package com.rohit;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class DeleteVoterInfo extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel l1,l2,l3;
    JTextField t1,t2;
    JButton b1,b2,b3;
    Container cont;

    Connection con;
	Statement stmt;
	ResultSet rs;
	ResultSetMetaData rm;

    //constructor of Voter INfo
    DeleteVoterInfo()
	{
	    super("Delete voter's record......");
		try
		{
			//Load the driver
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}

		l1=new  JLabel("---**--**-Voter Information--**--**--");
		l1.setFont(new Font("Arial",1,16));
	  l1.setForeground(new Color(100,255,200));
	  l2 =new JLabel("Id                  --:");
	  l2.setFont(new Font("Arial",0,14));
	  l2.setForeground(new Color(100,255,200));
      l3=new JLabel("##############################");
      l3.setFont(new Font("Arial",0,16));
	  l3.setForeground(new Color(100,255,200));

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
      cont.setBackground(new Color(110,130,130));

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

       setSize(300,170);
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
			String queryStr="delete from voter where v_id = "+id;
			int success=stmt.executeUpdate(queryStr);
            if(success==1)
			  {
               l3.setText("Voter's record is Successfully deleted!!!");
               JOptionPane.showMessageDialog(DeleteVoterInfo.this,"Voter's record is Successfully deleted!!!",
                                        "Error message",JOptionPane.OK_OPTION);
              }
			else
			  {
              l3.setText("Sorry this name record is not present..");
              JOptionPane.showMessageDialog(DeleteVoterInfo.this,"Sorry, this name record is not present..",
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
        JFrame ob=new DeleteVoterInfo();
	}
}