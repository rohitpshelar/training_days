package com.rohit;

import java.sql.*;

class FinishWork
{
    String eleName;
    Connection con;
	Statement stmt;
	ResultSet rs,rs1;
	int i=0;

 FinishWork(String eleName)
  {
    this.eleName=eleName;
        try
		{   //Load the driver
		   Class.forName("com.mysql.jdbc.Driver");
		}
	    catch(Exception e)
	     {
	       System.out.println(e);
         }
        System.out.println("finish work constr called");
         try
        {
         //Establish the connection.
		  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/VotingDB","root","root");
		  System.out.println("Connection Established!!");
		  //Create Statement
          stmt=con.createStatement();
          //get result set
          rs=stmt.executeQuery("select * from "+eleName);
          int ii=0,max=0,voted=0,votes=0;
          String name="";
          String wName="";
          while(rs.next())
           {
             votes=0;
             ii=rs.getInt(1);
             votes=Integer.parseInt(rs.getString(3));
             name=rs.getString(2);
             System.out.println("before"+votes+" "+max+" "+i);
             if(votes>max)
               {
                max=votes;
                i=ii;
                wName=name;
               }
             System.out.println("after"+votes+" "+max+" "+i);
             voted=voted+votes;

           }
           System.out.println("elelction details added");
          int ss=stmt.executeUpdate("Update "+eleName+" set winner = '1' where id = "+i);
              System.out.println("details added in "+eleName);
              ss=stmt.executeUpdate("Update electionDetails set e_total_voted = '"+voted+"', e_winner = '"+wName+"' where electionName = '"+eleName+"'");
              System.out.println("elelctiondetails added");
              ss = stmt.executeUpdate("Update Status set statusIs = 'finish' where eleName = '"+eleName+"'");
              System.out.println("finished work");


         }
        catch(Exception e)
         {
           System.out.println(e);
         }
  }

}