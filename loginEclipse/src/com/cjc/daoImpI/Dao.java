package com.cjc.daoImpI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cjc.dao.IDao;
import com.cjc.model.RegForm;
import com.cjc.util.DatabaseServlet;


public class Dao implements IDao{

	public int AddRegDetails(RegForm s) 
	{
	int n=0;
	try {
		
		String query="INSERT INTO `login`.`reg` (`fname`, `lname`,`gender`,`qual`, `adds`,`lang`, `uname`, `pw`,`photo`) VALUES ('"+s.getFname()+"', '"+s.getLname()+"','"+s.getGender()+"','"+s.getQual()+"', '"+s.getAdder()+"','"+s.getLang()+"', '"+s.getUname()+"', '"+s.getPass()+"',LOAD_FILE(?));";
		System.out.println(query);	
		
		
	
			
			Connection con=DatabaseServlet.GetConnection();
			
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1,s.getPhoto());
			//pst.setBinaryStream(1, fileInputStream, fileInputStream.available());
			n=pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return n;
	}
	public int UpdateRegDetails(RegForm s) 
	{
		String query="UPDATE `login`.`reg` SET `fname` = '"+ s.getFname() + "' ,`lname` = '" + s.getLname()+ "' ,`gender` = '" + s.getGender() + "' ,`qual` = '"+ s.getQual() + "' ,`adds` = '" + s.getAdder()+ "' ,`lang` = '" + s.getLang() + "' ,`uname` = '"+ s.getUname() + "' ,`pw` = '" + s.getPass() + "' WHERE `id` = '"+ s.getRegid() + "'";
		System.out.println(query);
		int n=DatabaseServlet.ExecuteUpdate(query);
		return n;
	}
	
	public int DeleteReg(int id) 
	{
		String query="DELETE FROM `login`.`reg` WHERE `id` = '"+id+"'";
		System.out.println(query);		
		int n=DatabaseServlet.ExecuteUpdate(query);		
		return n;
	}
	
	public ResultSet GetLoginDetails(String un,String pw) 
	{
		String query="SELECT `uname`,`pw` FROM `login`.`reg` WHERE uname='"+un+"' and pw='"+pw+"'" ;			
		ResultSet rs=DatabaseServlet.ExecuteQuery(query);		
		return rs;
	}
	
	public ResultSet GetLoginUsername() 
	{
		String query="SELECT `uname` FROM `login`.`reg` " ;			
		ResultSet rs=DatabaseServlet.ExecuteQuery(query);		
		return rs;
	}
	
	public ResultSet GetLoginDetails(String id) 
	{
		
		String query="SELECT * FROM `login`.`reg` WHERE `id` = '"+id+"' LIMIT 0, 30";		
		ResultSet rs=DatabaseServlet.ExecuteQuery(query);		
		return rs;
	}
	FileOutputStream fs;
	OutputStream fo;
	public ArrayList<RegForm> GetLoginDetails(int id) 
	{
		String file="C:/a.jpg"; 
		int i=0;
		try {
			fs = new FileOutputStream(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String query="SELECT * FROM `login`.`reg` WHERE `id` = '"+id+"' LIMIT 0, 30";		
		ResultSet rs=DatabaseServlet.ExecuteQuery(query);		
		ArrayList<RegForm> al = new ArrayList<RegForm>();
		try {
			while (rs.next())
			{
				RegForm r = new RegForm();
				r.setRegid(rs.getInt(1));
				r.setFname(rs.getString(2));
				r.setLname(rs.getString(3));
				r.setGender(rs.getString(4));
				r.setQual(rs.getString(5));
				r.setAdder(rs.getString(6));
				r.setLang(rs.getString(7));
				r.setUname(rs.getString(8));
				r.setPass(rs.getString(9));
			
				String fileOutput="C:/Users/ROHIT SHELAR/Myeclipse/Login With folder N templet=photo/WebRoot/DBimages/"+rs.getString(2)+rs.getString(3)+".jpg";
				String ShowFrom="DBimages/"+rs.getString(2)+rs.getString(3)+".jpg";
			    InputStream in = rs.getBinaryStream("photo");
                 fs = new FileOutputStream(new File(fileOutput));   
			     i++;
                 int c = 0;
                 while ((c = in.read()) > -1) {
                      fs.write(c);
                 }
				System.out.println("r.setPhoto(file2)="+ShowFrom);
				r.setPhoto(ShowFrom);
				fs.close();
				al.add(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	}
	public static void main(String[] args) {
		Dao d = new Dao();
		d.GetLoginDetails();
	}
	public ArrayList<RegForm> GetLoginDetails() 
	{
		int i=0;
		System.out.println("inside GetLoginDetails");
		String query="SELECT * FROM `login`.`reg`" ;			
		ResultSet rs=DatabaseServlet.ExecuteQuery(query);		
		ArrayList<RegForm> al = new ArrayList<RegForm>();
		
		
	
		
		try {
			
			while (rs.next())
			{
				RegForm r = new RegForm();
				r.setRegid(rs.getInt(1));
				r.setFname(rs.getString(2));
				r.setLname(rs.getString(3));
				r.setGender(rs.getString(4));
				r.setQual(rs.getString(5));
				r.setAdder(rs.getString(6));
				r.setLang(rs.getString(7));
				r.setUname(rs.getString(8));
				r.setPass(rs.getString(9));
				
			//  String fileOutput="D:/Database pics/"+rs.getString(2)+rs.getString(3)+".jpg"; 
			//	String fileOutput="WebRoot/DBimages/"+rs.getString(2)+rs.getString(3)+".jpg"; 
			//	String fileOutput=rs.getString(2)+rs.getString(3)+".jpg"; 
			//	String fileOutput="C:/Users/ROHIT SHELAR/Myeclipse/imagetest/WebRoot/DBimages/"+rs.getString(2)+rs.getString(3)+".jpg";
		    //  File fileOutput = new File("../DBimages/"+rs.getString(2)+rs.getString(3)+".jpg");
				
			/*	try {
					fs = new FileOutputStream(new File(fileOutput));
				
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Blob b=rs.getBlob(10);
				byte bb[]=b.getBytes(1, (int)b.length());
				fs.write(bb);*/
				String fileOutput="C:/Users/ROHIT SHELAR/Myeclipse/Login With folder N templet=photo/WebRoot/DBimages/"+rs.getString(2)+rs.getString(3)+".jpg";
				String ShowFrom="DBimages/"+rs.getString(2)+rs.getString(3)+".jpg";
			    InputStream in = rs.getBinaryStream("photo");
                 fs = new FileOutputStream(new File(fileOutput));   
			     i++;
                 int c = 0;
                 while ((c = in.read()) > -1) {
                      fs.write(c);
                 }
				System.out.println("r.setPhoto(file2)="+ShowFrom);
				r.setPhoto(ShowFrom);
				fs.close();
				al.add(r);
				
				
				
				//System.out.println("coming photo path(GetLoginDetails)==="+fileOutput+bb);
				
             /*in.close();*/

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	
	}
	
	public ArrayList<RegForm> GetLoginDetailsSpecific(String un,String pw) 
	{
		int i=0;
		String query="SELECT * FROM `login`.`reg`  WHERE uname='"+un+"' and pw='"+pw+"'" ;			
		ResultSet rs=DatabaseServlet.ExecuteQuery(query);		
		ArrayList<RegForm> al = new ArrayList<RegForm>();
	
		try {
			
			while (rs.next())
			{
				RegForm r = new RegForm();
				r.setRegid(rs.getInt(1));
				r.setFname(rs.getString(2));
				r.setLname(rs.getString(3));
				r.setGender(rs.getString(4));
				r.setQual(rs.getString(5));
				r.setAdder(rs.getString(6));
				r.setLang(rs.getString(7));
				r.setUname(rs.getString(8));
				r.setPass(rs.getString(9));
				
				String fileOutput="C:/Users/ROHIT SHELAR/Myeclipse/Login With folder N templet=photo/WebRoot/DBimages/"+rs.getString(2)+rs.getString(3)+".jpg";
				String ShowFrom="DBimages/"+rs.getString(2)+rs.getString(3)+".jpg";
			    InputStream in = rs.getBinaryStream("photo");
                 fs = new FileOutputStream(new File(fileOutput));   
			     i++;
                 int c = 0;
                 while ((c = in.read()) > -1) {
                      fs.write(c);
                 }
				System.out.println("r.setPhoto(file2)="+ShowFrom);
				r.setPhoto(ShowFrom);
				fs.close();al.add(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	
	}
}
