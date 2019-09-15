package com.rohit;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

class DeleteCandidateInfo extends JFrame implements ActionListener
{
	JLabel l1,l2,l3;
    JTextField t1,t2;
    JButton b1,b2,b3;
    Container cont;

    Connection con;
	Statement stmt;
	ResultSet rs;
	ResultSetMetaData rm;

    //constructor of Voter INfo
    DeleteCandidateInfo()
	{
	    super("Delete Candidate's record......");
		try
		{
			//Load the driver
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}

		l1=new  JLabel("---****---Candidate Information----****--");
	  l2 =new JLabel("Id                  --:");
      l3=new JLabel("##############################");

      t1=new JTextField(10);

	  b1=new  JButton("Delete");
	  b2=new  JButton("Reset");
	  b3=new JButton("Exit");

	  cont = getContentPane();
	  cont.setLayout(new FlowLayout());

      cont.add(l1);
      cont.add(l2);
      cont.add(t1);
      cont.add(b1);
	  cont.add(b2);
	  cont.add(b3);
      cont.add(l3);
      cont.setBackground(new Color(100,190,220));

      b1.addActionListener(this);
	  b2.addActionListener(this);
      b3.addActionListener(this);
	  addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				dispose();
			}
        });

       setSize(280,160);
	   setLocation(180,150);
	   setVisible(true);
	}
	//--------**-----Action performed----------**-------
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
			if(ae.getSource()==b1)
			{
              delete();
            }
			else if(ae.getSource()==b2)
			{
				t1.setText("");
				t1.requestFocus();
			}
			else if(ae.getSource()==b3)
			{
             new ShowMenu();
			  dispose();
            }
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
     //delete record
     void delete()
      {
        try
        {
			//Establish the connection.
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/VotingDB","root","root");
		    System.out.println("Connection Established!!");
			//Create Statement
            stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			//Obtain the resultset
			int id=Integer.parseInt(t1.getText());
			String queryStr="delete from candidate where c_id = "+id;
			int success=stmt.executeUpdate(queryStr);
            if(success==1)
			  {
               l3.setText("Candidate's record is Successfully deleted!!!");
               JOptionPane.showMessageDialog(DeleteCandidateInfo.this,"Candidate's record is Successfully deleted!!!",
                                        "Error message",JOptionPane.OK_OPTION);
              }
			else
			  {
              l3.setText("Sorry this name record is not present..");
              JOptionPane.showMessageDialog(DeleteCandidateInfo.this,"Sorry, this name record is not present..",
                                        "Error message",JOptionPane.OK_OPTION);
              t1.requestFocus(true);
              }
			//close all utilized
			stmt.close();
			con.close();
        }
        catch (SQLException e)
        {
			e.printStackTrace();
        }
      }
//------------***---------main method
	public static void main(String[] args)
	{
        JFrame ob=new DeleteCandidateInfo();
	}
}