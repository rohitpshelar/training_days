package com.rohit;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class ShowVoterInfo extends JFrame implements ActionListener
{
  JLabel Lhead;
  JButton okButton;

  Container cont;
  Connection con;
  Statement stmt;
  ResultSet rs;
  String[] v_colNames = {"Id","First","Middle","Last","Address","City","Contact","DOB","Gender","Age","Voted","TotalVotes"};

  JTable c_table,v_table;
  Object v_data[][]=new Object[1000][12];
  ShowVoterInfo()
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
          rs=stmt.executeQuery("select * from voter");
          //Navigate the resultset
		  rs.beforeFirst();
		  int i=-1;
			while(rs.next())
			{   i++;
                v_data[i][0]=rs.getInt(1);
				v_data[i][1]=rs.getString(2);
				v_data[i][2]=rs.getString(3);
				v_data[i][3]=rs.getString(4);
				v_data[i][4]=rs.getString(5);
				v_data[i][5]=rs.getString(6);
				v_data[i][6]=rs.getString(7);
				v_data[i][7]=rs.getInt(8)+"-"+rs.getInt(13)+"-"+rs.getInt(14);
				v_data[i][8]=rs.getString(9);
				v_data[i][9]=rs.getInt(10);
				v_data[i][10]=rs.getInt(11);
				v_data[i][11]=rs.getInt(12);
			}
			//close all utilized connection
			stmt.close();
			con.close();
         }
        catch(Exception e)
         {
           System.out.println(e);
         }

      v_table = new JTable(v_data, v_colNames);
      v_table.setPreferredScrollableViewportSize(new Dimension(10,10));
      v_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

      //Create the scroll pane and add the table to it.
      v_table.setEnabled(false);
      JScrollPane scrollPane = new JScrollPane(v_table);

      Lhead=new JLabel("Voter's Information Table");
      Lhead.setFont(new Font("Arial",1,16));
	  Lhead.setForeground(new Color(100,255,200));
	  okButton=new  JButton("OK");

      cont = getContentPane();
	  cont.setLayout(new BorderLayout());

      cont.add(Lhead,BorderLayout.NORTH);
      cont.add(scrollPane,BorderLayout.CENTER);
	  cont.add(okButton,BorderLayout.SOUTH);

      okButton.addActionListener(this);
      cont.setBackground(new Color(110,130,130));

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
            dispose();
            new ShowMenu();
           }
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		JFrame b = new ShowVoterInfo();
	}
}