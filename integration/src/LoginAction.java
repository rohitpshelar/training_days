
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class LoginAction extends ActionSupport implements ModelDriven<Systemlogin>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Systemlogin systemlogin;//=new Systemlogin();

	public String loginCheck()
	{
		System.out.println("hi");
		try{
		System.out.println(systemlogin.getUname());
		System.out.println(systemlogin.getPassword());
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		//LoginService loginService=new LoginServiceImpl();
	
		
		return "success";
	}

	public Systemlogin getSystemlogin() {
		return systemlogin;
	}

	public void setSystemlogin(Systemlogin systemlogin) {
		this.systemlogin = systemlogin;
	}

	@Override
	public Systemlogin getModel() {
		// TODO Auto-generated method stub
		return systemlogin;
	}



	
	
}
