package core.t2;

import java.io.*;
import java.time.Instant;
import java.util.*;
//import javax.comm.*; // for SUN's serial/parallel port libraries
import gnu.io.*; // for rxtxSerial library
 
public class WriteReadSerialPort implements Runnable, SerialPortEventListener {
   static CommPortIdentifier portId;
   static CommPortIdentifier saveportId;
   static Enumeration        portList;
   InputStream           inputStream;
   SerialPort           serialPort;
   Thread           readThread;
	static String fileName = "Communication_logs_";
	 static  FileWriter myWriter = null;
   static String        messageString = "Hello, world!";
   static OutputStream      outputStream;
   static boolean        outputBufferEmptyFlag = false;
 
   public static void main(String[] args) throws Exception {
      boolean           portFound = false;
      String           defaultPort;
 	 File file = new File(System.getProperty("user.dir")+"/"+fileName +".txt");
     
     // creates the file
     file.createNewFile();
	 myWriter = new FileWriter(file);
	 myWriter.write("Read: ");
	      myWriter.close();

         defaultPort = "COM1";
 
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
      try {
    	  outputStream = serialPort.getOutputStream();
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
         outputStream.write(messageString.getBytes());
      } catch (IOException e) {}
   }
 
   public WriteReadSerialPort() {
      try {
         serialPort = (SerialPort) portId.open("SimpleReadApp", 200);
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
        
            writetoport();
            Thread.sleep(1000);
         }
      } catch (InterruptedException e) {}
   } 
 
   public void serialEvent(SerialPortEvent event) {
       System.out.println(".........Return :"+event.getEventType());
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
         byte[] readBuffer = new byte[20];
         try {
            // read data
        
 	 
            while (inputStream.available() > 0) {
               int numBytes = inputStream.read(readBuffer);
            } 
            // print data
            String result  = new String(readBuffer);
            System.out.println("Read: "+result);
            myWriter.write("Read: "+result);
   	      myWriter.close();
         } catch (IOException e) {}
    
         break;
      }
   } 
 
}