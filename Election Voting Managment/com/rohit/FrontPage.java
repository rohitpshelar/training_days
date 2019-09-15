package com.rohit;

import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class FrontPage extends JFrame implements ActionListener
{
  JLabel l,l1,l2;
  JTextField t1,t2,t3;
  JButton okButton,resetButton,chk;
  Container cont;
  String eleName;
  Connection con;
  Statement stmt;
  ResultSet rs;

  FrontPage(String eleName)
	{
	  super("Front Page for "+eleName+" elction......");
      this.eleName=eleName;

      try
	   {   //Load the driver
	     Class.forName("com.mysql.jdbc.Driver");
	   }
	  catch(Exception e)
	   {
	     System.out.println(e);
       }

      l=new  JLabel("Voter id   --:");
	  l1=new JLabel("Voter name --:");
	  l2=new JLabel("");
	  t1=new JTextField(10);
	  t2=new JTextField(10);
	  okButton=new  JButton("OK");
	  resetButton=new  JButton("Reset");
	  okButton.setEnabled(false);
	  resetButton.setEnabled(false);

      chk=new JButton("Check Voting Status");
      cont = getContentPane();
	  cont.setLayout(new FlowLayout());
      cont.add(l);
      cont.add(t1);
      cont.add(l1);
      cont.add(t2);
	  cont.add(okButton);
	  cont.add(resetButton);
	  cont.add(chk);
      cont.add(l2);

      okButton.addActionListener(this);
	  resetButton.addActionListener(this);
      chk.addActionListener(this);

      cont.setBackground(new Color(100,190,190));

	  addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				dispose();
			}
        });

       setSize(220,150);
	   setLocation(150,150);
	   setVisible(true);
	}
//----------------------------action performed
public void actionPerformed(ActionEvent ae)
	{
	  int id;
		try
		{
		    if(ae.getSource()==chk)
		     {
               //Establish the connection.
		      con=DriverManager.getConnection("jdbc:mysql://localhost:3306/VotingDB","root","root");
		      System.out.println("Connection Established!!");
		     // Create Statement
              stmt=con.createStatement();
              //get result set
              rs=stmt.executeQuery("select * from Status where  eleName = '"+eleName+"' and statusls = 'start'");
              int status=0;
              if(rs.next())
               {
                 status=1;
               }
               if(status==1)
                {
                  JOptionPane.showMessageDialog(FrontPage.this,"The election is going on for '"+eleName+"'",
                                          "Election Status",JOptionPane.OK_OPTION);
                  okButton.setEnabled(true);
                  resetButton.setEnabled(true);
                }
               else if(status==0)
                {
                  JOptionPane.showMessageDialog(FrontPage.this,"Sorry!! no election is going on just wait....",
                                          "Election Status",JOptionPane.OK_OPTION);
                  dispose();
                }
             }

			else if(ae.getSource()==okButton)
			{
			  l2.setText("Processing Please wait.....");

              try
              {
              //Establish the connection.
		      con=DriverManager.getConnection("jdbc:mysql://localhost:3306/VotingDB","root","root");
		      System.out.println("Connection Established!!");
		      //Create Statement
              stmt=con.createStatement();
              if(t1.getText().equals(""))
               id=0;
              else
               id=Integer.parseInt(t1.getText());
              //get result set
              rs=stmt.executeQuery("select * from voter where v_id = "+id);
              int voted=0,state=1;
              String name="";
              while(rs.next())
              {
               voted=rs.getInt(11);
               name=rs.getString(2);
               state=1;
               System.out.println(name+" "+voted);
              }
             if(state==1)
              {
              if(name.equals(t2.getText()) && voted==1 )
                  {
                  JOptionPane.showMessageDialog(FrontPage.this,"Sorry You have already voted"
                                      ,"Message",JOptionPane.OK_OPTION);
                  }
            /*  else if(name.equals(t2.getText()) )
                  {*/
                   JOptionPane.showMessageDialog(FrontPage.this,"Welcome u r valid user"
                                      ,"Message",JOptionPane.OK_OPTION);
                    this.setVisible(false);
                    new VotingPage(eleName,id);
                 // }
              /*else
                  {
                   JOptionPane.showMessageDialog(FrontPage.this,"Please enter valid id"
                                      ,"Error Message",JOptionPane.OK_OPTION);
                  }*/
              }
              else if(state==0)
                 {
                 JOptionPane.showMessageDialog(FrontPage.this,"Please enter valid id"
                                      ,"Error Message",JOptionPane.OK_OPTION);
                 }

              rs.close();
              //close connection
              stmt.close();
              con.close();

              }
              catch(Exception e)
              {
              System.out.println(e);
              }
             }
			else
			{
				t1.setText("");
				t2.setText("");
				l2.setText("");
				t1.requestFocus();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
  ///-----------------------------------main
  public static void main(String[] args)
   {
    JFrame b = new FrontPage("");
   } //main method ends
}
