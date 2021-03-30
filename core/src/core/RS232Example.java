package core;

import gnu.io.CommPortIdentifier;  
import gnu.io.SerialPort;  
   
public class RS232Example {  
     
    public void connect(String portName) throws Exception {  
        CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);  
   
        if (portIdentifier.isCurrentlyOwned()) {  
            System.out.println("Port in use!");  
        } else {  
            // points who owns the port and connection timeout  
            SerialPort serialPort = (SerialPort) portIdentifier.open("RS232Example", 2000);  
              
            // setup connection parameters  
            serialPort.setSerialPortParams(  
                38400, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);  
   
            // setup serial port writer  
            CommPortSender.setWriterStream(serialPort.getOutputStream());  
              
            // setup serial port reader  
            new CommPortReceiver(serialPort.getInputStream()).start();  
        }  
    }  
      
    public static void main(String[] args) throws Exception {  
          
        // connects to the port which name (e.g. COM1) is in the first argument  
        new RS232Example().connect("COM3");  
          
        // send HELO message through serial port using protocol implementation  
        CommPortSender.send(new ProtocolImpl().getMessage("HELO"));  
    }  
} 