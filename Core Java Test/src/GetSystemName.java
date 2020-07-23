import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

public class GetSystemName {
	public static void main(String[] args) throws UnknownHostException {
		System.out.println(getComputerName());
		System.out.println(InetAddress.getLocalHost().getHostName());
	}
	
	private static String getComputerName()
	{
	    Map<String, String> env = System.getenv();
	    if (env.containsKey("COMPUTERNAME"))
	        return env.get("COMPUTERNAME");
	    else if (env.containsKey("HOSTNAME"))
	        return env.get("HOSTNAME");
	    else
	        return "Unknown Computer";
	}
}
