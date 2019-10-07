package com.rohit;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class ShowCandidateInfo extends JFrame implements ActionListener
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
JLabel Lhead;
  JButton okButton;
  Container cont;
  Connection con;
  Statement stmt;
  ResultSet rs;

  String[] colNames = {"Id","First","Middle","Last","Address",
    "City","Contact","DOB","Gender","Age","Party Name","Info","Symbol","Photo"};
  JTable table;
  Object data[][]=new Object[1000][14];

  ShowCandidateInfo()
  {
    super("Information table..........");
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
          rs=stmt.executeQuery("select * from candidate");
          //Navigate the resultset
		  rs.beforeFirst();
		  int i=-1;
			while(rs.next())
			{   i++;
                data[i][0]=rs.getInt(1);
				data[i][1]=rs.getString(2);
				data[i][2]=rs.getString(3);
				data[i][3]=rs.getString(4);
				data[i][4]=rs.getString(5);
				data[i][5]=rs.getString(6);
				data[i][6]=rs.getString(7);
				data[i][7]=rs.getInt(8)+"-"+rs.getInt(15)+"-"+rs.getInt(16);
				data[i][8]=rs.getString(9);
				data[i][9]=rs.getInt(10);
				data[i][10]=rs.getString(11);
				data[i][11]=rs.getString(12);
				data[i][12]=rs.getString(13);
				data[i][13]=rs.getString(14);
			}
			//close all utilized connection
			stmt.close();
			con.close();
         }
        catch(Exception e)
         {
           System.out.println(e);
         }

      table = new JTable(data,colNames);
      table.setPreferredScrollableViewportSize(new Dimension(10,10));
      table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

      //Create the scroll pane and add the table to it.
      table.setEnabled(false);
      JScrollPane scrollPane = new JScrollPane(table);

      Lhead=new JLabel("Candidate's Information Table");
	  okButton=new  JButton("OK");

      cont = getContentPane();
	  cont.setLayout(new BorderLayout());
      JPanel jp=new JPanel(new FlowLayout());
      jp.add(okButton);
      cont.add(Lhead,BorderLayout.NORTH);
      cont.add(scrollPane,BorderLayout.CENTER);
	  cont.add(jp,BorderLayout.SOUTH);
      cont.setBackground(new Color(100,190,220));
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
            System.out.println("show candidate record get off");
           }
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		JFrame b = new ShowCandidateInfo();
	}
}