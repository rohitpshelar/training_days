package finalls;

public class a {
	
	public static void main(String[] args) {
		
		
//	1	//  static String        messageString = "CX,015<CR>"; 
		   
//	2   //  static String        messageString = "<SOH>F00156006<STX>BV,011<ETX>\n";
		 
//	3	// static String        messageString = "CX,PR,DI,BP,UF,KS,015<CR>\\n";
	
//		4 Final : <SOH>F00608024<STX>CX,XT,DI,KS,BP,PR,UF,030<ETX>
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	//	[RX]> VP+108,AP-101,[RX]> TM+062,UR0800,[RX]> UTT,SY000,DY00[RX]> 0,PL000,MA000,[RX]> TXT,QB0340,QD0[RX]> 500,TT0170,DK0[RX]> 0121,KT00329,H[RX]> A001,HR000
		
		System.out.println(proces("P,0,0"));
	//	System.out.println(proces("CX,015<CR>"));
	}
	
	if($('#show'+field).hasClass('displayBlock')){
        $('#show'+field).addClass('displayAsNone');
        $('#show'+field).removeClass('displayBlock');
        $('#hide'+field).addClass('displayBlock');
        $('#hide'+field).removeClass('displayAsNone');

	}else{
		$('#show'+field).addClass('displayBlock');
		$('#show'+field).removeClass('displayAsNone');
        $('#hide'+field).addClass('displayAsNone');
        $('#hide'+field).removeClass('displayBlock');
	}
	
	javac -cp .:/* serialRobot.java
	javac -cp ".;comm-2.0.jar;RXTXcomm.jar" serialRobot.java
	java -cp ".;comm-2.0.jar;RXTXcomm.jar" core.Finals.serialRobot
	javac -cp .:/* serialRobot.java
	
	javac -cp ".;comm-2.0.jar;RXTXcomm.jar" WriteReadSerialPort.java
	javac -cp ".;comm-2.0.jar;RXTXcomm.jar" core.t2.WriteReadSerialPort.java
	java -cp ".;comm-2.0.jar;RXTXcomm.jar" core.t2.WriteReadSerialPort
	
	java -cp ".;RXTXcomm.jar" core.t2.WriteReadSerialPort
	private static byte[] proces(String tekstas){
        tekstas = tekstas.trim();
        char[] charArray = tekstas.toCharArray();
        byte kodas1[];/core/comm-2.0.jar/core/RXTXcomm.jar



        int fComa = tekstas.indexOf(',', 1);
        int sComa = tekstas.indexOf(',', 2);
        int matavimas = charArray.length;
        int skir1 = sComa - fComa - 1;
        int skir2 = matavimas - sComa -1;

        char leftSpeed[] = new char[skir1];

        	
        	 for(int i = 0; i < skir1; i++){
                 leftSpeed[i] = charArray[fComa + i + 1];
           }

           char rightSpeed[] = new char[skir2];

           for(int i = 0; i < skir2; i++){
               rightSpeed[i] = charArray[sComa + i + 1];
           }
           String right = String.valueOf(rightSpeed);
           String left = String.valueOf(leftSpeed);


           int val1 = Integer.parseInt(left);
           int val2 = Integer.parseInt(right);
           kodas1 = new byte[5];
           kodas1[0] = (byte)-charArray[0];
           kodas1[1] = (byte)(val1 & 0xFF);
           kodas1[2] = (byte)(val1 >> 8);
           kodas1[3] = (byte)(val2 & 0xFF);
           kodas1[4] = (byte)(val2 >> 8);

           return kodas1;


       }
}
