package core;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class SerialTest {
	  public static void main( String args[]) {
	    Runtime rt = Runtime.getRuntime();
	    Process p = null;
	    String portname = "COM1";
	    // for Win95 : c:\\windows\\command.com
	    //             c:\\windows\\command\\mode.com
	    String cmd[] = {
	     "c:\\windows\\system32\\cmd.exe", "/c",
	     "start", "/min",
	     "c:\\windows\\system32\\mode.com", portname,
	     "baud=9600", "parity=n", "data=8",
	     "stop=1",
	    };
	    try {
	      p = rt.exec( cmd );
	      if( p.waitFor() != 0 ) {
	        System.out.println("Error executing command: " + cmd );
	        System.exit( -1 );
	      }
	      byte data[] =
	       "Writing a byte stream out of a serial port.".getBytes();
	      FileOutputStream fos = new FileOutputStream( portname );
	      BufferedOutputStream bos = new BufferedOutputStream( fos );
	      fos.write( data, 0, data.length );
	      fos.close();
	    }
	    catch( Exception e ) {
	      e.printStackTrace();
	    }
	  }
	}