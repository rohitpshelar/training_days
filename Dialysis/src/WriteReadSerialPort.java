package core.t2;

import java.io.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import javax.comm.*; // for SUN's serial/parallel port libraries
import gnu.io.*; // for rxtxSerial library
 
public class WriteReadSerialPort implements Runnable, SerialPortEventListener {
   static CommPortIdentifier portId;
   static CommPortIdentifier saveportId;
   static Enumeration        portList;
   InputStream           inputStream;
   SerialPort           serialPort;
   Thread           readThread;
  //  static String        messageString = "CX,015<CR>"; 
   
   //static String        messageString = "<SOH>F00156006<STX>BV,011<ETX>\n";
  // static String        messageString = "CX,PR,DI,BP,UF,KS,015<CR>\\n";
 //  static String        messageString = "PI430619<CR>\\n";
 static String        messageString = "<SOH>F00608024<STX>CX,XT,DI,KS,BP,PR,UF,030<ETX>"+System.lineSeparator();
   static OutputStream      outputStream;
   static boolean        outputBufferEmptyFlag = false;
   
   String fileName = "Communication_logs_";

   FileWriter myWriter = null;
 
   public static void main(String[] args) {
      boolean           portFound = false;
      String           defaultPort;
       
      // determine the name of the serial port on several operating systems
      String osname = System.getProperty("os.name","").toLowerCase();
      if ( osname.startsWith("windows") ) {
         // windows
         defaultPort = "COM1";
      } else if (osname.startsWith("linux")) {
         // linux
        defaultPort = "/dev/ttyS0";
      } else if ( osname.startsWith("mac") ) {
         // mac
         defaultPort = "????";
      } else {
         System.out.println("Sorry, your operating system is not supported");
         return;
      }
           
      if (args.length > 0) {
         defaultPort = args[0];
      } 
 
      System.out.println("Set default port to "+defaultPort);
       
        // parse ports and if the default port is found, initialized the reader
      portList = CommPortIdentifier.getPortIdentifiers();
      while (portList.hasMoreElements()) {
         portId = (CommPortIdentifier) portList.nextElement();
         if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
            if (portId.getName().equals(defaultPort)) {
               System.out.println("Found port: "+defaultPort);
               portFound = true;
               // init reader thread
               WriteReadSerialPort reader = new WriteReadSerialPort();
            } 
         } 
          
      } 
      if (!portFound) {
         System.out.println("port " + defaultPort + " not found.");
      } 
       
   } 
 
   public void initwritetoport() {
      // initwritetoport() assumes that the port has already been opened and
      //    initialized by "public WriteReadSerialPort()"
 
      try {
         // get the outputstream
         outputStream = serialPort.getOutputStream();
      } catch (IOException e) {}
 
      try {
         // activate the OUTPUT_BUFFER_EMPTY notifier
         serialPort.notifyOnOutputEmpty(true);
      } catch (Exception e) {
         System.out.println("Error setting event notification");
         System.out.println(e.toString());
         System.exit(-1);
      }
       
   }
 
   public void writetoport() {
      System.out.println("Writing \""+messageString+"\" to "+serialPort.getName());
      try {
         // write string to serial port
         outputStream.write(messageString.getBytes());
      } catch (IOException e) {}
   }
 
   public WriteReadSerialPort() {
      // initalize serial port
      try {
         serialPort = (SerialPort) portId.open("COM1", 9600);
      } catch (PortInUseException e) {}
    
      try {
         inputStream = serialPort.getInputStream();
      } catch (IOException e) {}
    
      try {
         serialPort.addEventListener(this);
      } catch (TooManyListenersException e) {}
       
      // activate the DATA_AVAILABLE notifier
      serialPort.notifyOnDataAvailable(true);
    
      try {
         // set port parameters
         serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, 
                     SerialPort.STOPBITS_1, 
                     SerialPort.PARITY_NONE);
      } catch (UnsupportedCommOperationException e) {}
       
      // start the read thread
      readThread = new Thread(this);
      readThread.start();
       
   }
 
   public void run() {
      // first thing in the thread, we initialize the write operation
      initwritetoport();
      
      try {
         while (true) {
            // write string to port, the serialEvent will read it
        	 
        	   File filem = new File(System.getProperty("user.dir")+"/generatedMsg");
   			if(!filem.exists()){
          			 filem.mkdir();
    			}
        	   File file = new File(System.getProperty("user.dir")+"/generatedMsg/"+fileName + LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyyyHHmmss"))+".txt");
			
        	   // creates the file
        	   file.createNewFile();
        	 myWriter = new FileWriter(file, true);
            writetoport();
            Thread.sleep(1000000);
         }
      } catch (InterruptedException e) {} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   } 
 
   public void serialEvent(SerialPortEvent event) {
       System.out.println("..........Return : "+event.getEventType());
//       System.out.println(".........Return :"+event.getNewValue());
//       System.out.println(".........Return :"+event.getOldValue());
//       System.out.println(".........Return :"+event.toString());
      switch (event.getEventType()) {
      case SerialPortEvent.BI:
          System.out.println("BI");
      case SerialPortEvent.OE:
          System.out.println("OE");
      case SerialPortEvent.FE:
          System.out.println("FE");
      case SerialPortEvent.PE:
          System.out.println("PE");
      case SerialPortEvent.CD:
          System.out.println("CD");
      case SerialPortEvent.CTS:
          System.out.println("CTS");
      case SerialPortEvent.DSR:
          System.out.println("DSR");
      case SerialPortEvent.RI:
          System.out.println("RI");
      case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
          System.out.println("OUTPUT_BUFFER_EMPTY");
          break;
      case SerialPortEvent.DATA_AVAILABLE:
         // we get here if data has been received
         byte[] readBuffer = new byte[200];
         try {
            // read data
        	
            while (inputStream.available() > 0) {
            	Thread.sleep(500);
               int numBytes = inputStream.read(readBuffer);
               
            } 
            // print data
            String result  = new String(readBuffer);
            
            String pattern = "[A-Za-z0-9{*-}{* }]+";

            // Create a Pattern object
            Pattern r = Pattern.compile("[A-Za-z0-9{*-}{* }]+");

            // Now create matcher object.
            Matcher m = r.matcher(result);
            if (m.find( )) {
           
            System.out.println("Read = "+m.group(0));
            File file = new File(System.getProperty("user.dir")+"/data_send/"+Instant.now().toString().replaceAll("[TZ]", " ").replaceAll("-", "_").replaceAll(":", "_").replaceAll(" ", "_").replace(".","_") +".txt");
     	   // creates the file
     	file.createNewFile();
     	 myWriter = new FileWriter(file, true);
            myWriter.write(m.group(0));
            myWriter.close();
            }
         } catch (IOException e) {} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
         break;
      }
   } 
   
   
 
}