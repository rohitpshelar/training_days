package core.t1;

import java.io.IOException;  
import java.io.InputStream;  
import java.io.OutputStream;  
import java.util.logging.Level;  
import java.util.logging.Logger;  
import javax.comm.*;  
import java.util.*; 

/** Check each port to see if it is open. **/  
public class openPort implements SerialPortEventListener {
	
	public static void main(String[] args) {
//		sendMessage("COM1", "test");
	}

    static Enumeration portList;
    static CommPortIdentifier portId;
    static String messageString;
    public static SerialPort serialPort;
    static OutputStream outputStream;
    InputStream inputStream;
    static boolean outputBufferEmptyFlag = false;

    public void open() {
        Enumeration port_list = CommPortIdentifier.getPortIdentifiers();

        while (port_list.hasMoreElements()) {
            // Get the list of ports
            CommPortIdentifier port_id = (CommPortIdentifier) port_list.nextElement();
            if (port_id.getName().equals("/dev/ttyS1")) {

                // Attempt to open it
                try {
                    SerialPort port = (SerialPort) port_id.open("PortListOpen", 20);
                    System.out.println("Opened successfully");
                    try {
                        int baudRate = 9600; //
                        port.setSerialPortParams(
                                baudRate,
                                SerialPort.DATABITS_7,
                                SerialPort.STOPBITS_1,
                                SerialPort.PARITY_EVEN);
                        port.setDTR(true);
                       /*

                        port.setFlowControlMode(
                                SerialPort.FLOWCONTROL_NONE);
                        *
                        */
                        System.out.println("properties are set");
                    } catch (UnsupportedCommOperationException e) {
                        System.out.println(e);
                    }
                    try {
                        //input = new SerialReader(in);
                        port.addEventListener(this);
                        System.out.println("listeners attached" + this);
                    } catch (TooManyListenersException e) {
                        System.out.println("too many listeners");
                    }
                    port.notifyOnDataAvailable(true);
                    //port.notifyOnOutputEmpty(true);
                    //sendMessage(port,"@PL");
                    //port.close ();
                    try {
                        inputStream = port.getInputStream();
                        System.out.println("inputstream" + inputStream.available());
                        outputStream = (OutputStream) port.getOutputStream();

                    } catch (IOException e) {
                        System.out.println(e);
                    }

                    //set the created variables to global variables
                } catch (PortInUseException pe) {
                    System.out.println("Open failed");
                    String owner_name = port_id.getCurrentOwner();
                    if (owner_name == null) {
                        System.out.println("Port Owned by unidentified app");
                    } else // The owner name not returned correctly unless it is
                    // a Java program.
                    {
                        System.out.println("  " + owner_name);
                    }
                }
            }
        }
    } 

    public static void sendMessage(SerialPort port, String msg) {
        if (port != null) {
            try {                
            	outputStream.write(msg.getBytes());
            	outputStream.flush();
                try {
                    Thread.sleep(2000);  // Be sure data is xferred before closing
                    System.out.println("read called");
                    //SimpleRead read = new SimpleRead();
                    //int read = global_variables.inputStream.read();
                    //System.out.println("read call ended"+read);
                } catch (Exception e) {
                }
            } catch (IOException ex) {
                Logger.getLogger(openPort.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void serialEvent(SerialPortEvent event) {
        System.out.println(event.getEventType());
        switch (event.getEventType()) {
            /*
            case SerialPortEvent.BI:

            case SerialPortEvent.OE:

            case SerialPortEvent.FE:

            case SerialPortEvent.PE:

            case SerialPortEvent.CD:

            case SerialPortEvent.CTS:

            case SerialPortEvent.DSR:

            case SerialPortEvent.RI:


            case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
            System.out.println("event.getEventType()");
            break;
             *
             */

            case SerialPortEvent.DATA_AVAILABLE:
                System.out.println("inside event handler data available");
                byte[] readBuffer = new byte[20];
                try {
                    while (inputStream.available() > 0) {
                        int numBytes = inputStream.read(readBuffer);
                    }
                    System.out.print(new String(readBuffer));
                    System.exit(1);
                } catch (IOException e) {
                    System.out.println(e);
                }

                break;
        }
    }
}
