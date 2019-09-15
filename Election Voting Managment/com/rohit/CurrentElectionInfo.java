package com.rohit;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class CurrentElectionInfo extends JFrame implements ActionListener
{
  JLabel l1;
  JButton okButton;
  Container cont;
  Connection con;
  Statement stmt;
  ResultSet rs;
  String[] colNames = {"Id","Name","Total Votes","Winner"};

  JTable table;
  Object data[][]=new Object[1000][4];

  CurrentElectionInfo(String eleName)
  {
    super(eleName+" Information table..........");
      try
	  {   //Load the driver
		Class.forName("com.mysql.jdbc.Driver");
	  }
	  catch(Exception e)
	  {
	    System.out.println(e);
      }

      try
        { //Establish the connection.
		  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/VotingDB","root","root");
		  System.out.println("Connection Established!!");
		  //Create Statement
          stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
          //get result set
          rs=stmt.executeQuery("select * from "+eleName);
          //Navigate the resultset
		  rs.beforeFirst();
		  int i=-1;
			while(rs.next())
			{   i++;
                data[i][0]=rs.getInt(1);
				data[i][1]=rs.getString(2);
				data[i][2]=rs.getString(3);
				data[i][3]=rs.getString(4);
			}
			//close all utilized connection
			stmt.close();
			con.close();
         }
        catch(Exception e)
         {
           System.out.println(e);
         }

      table = new JTable(data, colNames);
      table.setPreferredScrollableViewportSize(new Dimension(10,10));
      table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

      //Create the scroll pane and add the table to it.

      JScrollPane scrollPane = new JScrollPane(table);

      l1=new JLabel("Current's Information Table");
	  okButton=new  JButton("OK");

      cont = getContentPane();
	  cont.setLayout(new BorderLayout());

      cont.add(l1,BorderLayout.NORTH);
      cont.add(scrollPane,BorderLayout.CENTER);
	  cont.add(okButton,BorderLayout.SOUTH);
      cont.setBackground(new Color(190,100,150));
      okButton.addActionListener(this);

	  addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				dispose();
			}
        });

       setSize(790,500);
	   setLocation(2,2);
	   setVisible(true);
	}

public void actionPerformed(ActionEvent ae)
	{
		try
		{
          if(ae.getSource()==okButton)
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

/*	public static void main(String[] args)
	{
		JFrame b = new CurrentElectionInfo("");
	} */
}