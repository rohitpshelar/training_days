package core;

import java.io.OutputStream;
import java.util.Enumeration;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

public class New_port_writer {
	    static Enumeration ports;
	    static CommPortIdentifier pID;
	    static OutputStream outStream;
	    SerialPort serPort;
	    static String messageToSend = "message!\n";
	    
	    public New_port_writer() throws Exception{
	        serPort = (SerialPort)pID.open("PortWriter",2000);
	        outStream = serPort.getOutputStream();
	        serPort.setSerialPortParams(9600, SerialPort.DATABITS_8,
	        SerialPort.STOPBITS_1,
	        SerialPort.PARITY_NONE);
	    }    
	    
	    public static void main(String[] args) throws Exception{
	        ports = CommPortIdentifier.getPortIdentifiers();
	        
	        while(ports.hasMoreElements())
	        {
	            pID = (CommPortIdentifier)ports.nextElement();
	            System.out.println("Port " + pID.getName());
	            
	            if (pID.getPortType() == CommPortIdentifier.PORT_SERIAL)
	            {
	                if (pID.getName().equals("COM1"))
	                {
	                	New_port_writer pWriter = new New_port_writer();
	                    System.out.println("COM1 found");
	                }
	            }
	        }
	        outStream.write(messageToSend.getBytes());
	    }
}
