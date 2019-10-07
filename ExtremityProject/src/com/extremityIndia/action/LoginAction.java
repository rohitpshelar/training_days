package com.extremityIndia.action;

import java.util.ArrayList;
import java.util.List;

import com.extremityIndia.hibernate.Systemlogin;
import com.extremityIndia.model.Product;
import com.extremityIndia.service.LoginService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class LoginAction extends ActionSupport implements ModelDriven<Systemlogin>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	LoginService loginService;
	Systemlogin systemlogin;//=new Systemlogin();
	List<Product> list;
	Product product;
	String navigationFlg;


	
	   public Systemlogin getModel() {
		// TODO Auto-generated method stub
		return systemlogin;
	}
	
	
	public String getNavigationFlg() {
		return navigationFlg;
	}

	public void setNavigationFlg(String navigationFlg) {
		this.navigationFlg = navigationFlg;
	}

	public String loginCheck()
	{
		System.out.println("hi");
		try{
		System.out.println(systemlogin.getUname());
		System.out.println(getSystemlogin().getPassword());
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		//LoginService loginService=new LoginServiceImpl();
	String display=	   loginService.getloginCheck(systemlogin);
		
		return display;
	}

	public String	fetchProduct()
	{
		
		
		list=getListOfProduct();
		return "success";
		
	}
	
	public  List<Product> getListOfProduct()
	{
		Product product=new Product();
		product.setPid(1);
		product.setPname("A");
		product.setPrice("100");
		
		Product product1=new Product();
		product1.setPid(2);
		product1.setPname("B");
		product1.setPrice("200");
		
		Product product2=new Product();
		product2.setPid(3);
		product2.setPname("C");
		product2.setPrice("300");
		
		Product product3=new Product();
		product3.setPid(4);
		product3.setPname("D");
		product3.setPrice("150");
		
		Product product4=new Product();
		product4.setPid(5);
		product4.setPname("E");
		product4.setPrice("250");
		
		Product product5=new Product();
		product5.setPid(6);
		product5.setPname("F");
		product5.setPrice("540");
		
		
		Product product6=new Product();
		product6.setPid(7);
		product6.setPname("G");
		product6.setPrice("275");
		
		Product product7=new Product();
		product7.setPid(8);
		product7.setPname("H");
		product7.setPrice("150");
		
		
		
		Product product8=new Product();
		product8.setPid(9);
		product8.setPname("I");
		product8.setPrice("150");
		
		
		
		
		
		list=new ArrayList<Product>();
		list.add(product);
		list.add(product1);
		list.add(product2);
		list.add(product3);
		list.add(product4);
		list.add(product5);
		list.add(product6);
		list.add(product7);
		list.add(product8);
		return list;
		
	}
	
public String saveProduct()
{
	
	System.out.println(product.getPid());
	System.out.println(product.getPname());
	System.out.println(product.getPrice());
	
	setNavigationFlg("success");
	//save to data base
return "success";
}

public String selectProduct()
{
	list=getListOfProduct();
	int id=product.getPid();
	System.out.println(product.getPid());
   product=list.get(--id);
    
    
return "success";
}


public String updateProduct()
{
	
	
	System.out.println(product.getPid());
	System.out.println(product.getPname());
	System.out.println(product.getPrice());
   setNavigationFlg("success");
    
return "success";
}

public String deleteProduct12()
{
	
	
	System.out.println(product.getPid());
	
return "success";
}

public String deleteProduct()
{
	
	
	System.out.println(product.getPid());
	System.out.println("product deleted success fully");
   setNavigationFlg("success");
    
return "success";
}

public Product getProduct() {
	return product;
}

public void setProduct(Product product) {
	this.product = product;
}



	public Systemlogin getSystemlogin() {
		return systemlogin;
	}


	public void setSystemlogin(Systemlogin systemlogin) {
		this.systemlogin = systemlogin;
	}
	
	public List<Product> getList() {
		return list;
	}

	public void setList(List<Product> list) {
		this.list = list;
	}


	public LoginService getLoginService() {
		return loginService;
	}


	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	
}
