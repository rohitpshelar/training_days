package com.rohit;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class ElectionDetails extends JFrame implements ActionListener
{
  JLabel l1,Lsearch,Lsearch1;
  JTextField Tsearch;
  JButton b1,Bsearch;
  Container cont;
  Connection con;
  Statement stmt;
  ResultSet rs;
  String[] colNames = {"Id","Election name","Total Candidate","Total Voters","Total Voted","Winner","Date"};
  CurrentElectionInfo cei;
  JTable table;
  Object data[][]=new Object[1000][7];

  ElectionDetails()
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
          rs=stmt.executeQuery("select * from electionDetails");
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
				data[i][6]=rs.getDate(7);
			}
			//close all utilized connection
			stmt.close();
			con.close();
         }
        catch(Exception e)
         {
           System.out.println(e);
         }

      //Lsearch=new JLabel("Enter Election name");
      //Lsearch1=new JLabel("From the table u will get all information");
      Tsearch=new JTextField(10);
      Bsearch=new JButton("Search");
      JPanel jcont=new JPanel();
      //jcont.setLayout(new BoxLayout(jcont,BoxLayout.Y_AXIS));
      //jcont.add(Lsearch);
      //jcont.add(Lsearch1);
      jcont.add(Tsearch);
      jcont.add(Bsearch);
      jcont.setBackground(new Color(190,100,150));
      table = new JTable(data, colNames);
      table.setPreferredScrollableViewportSize(new Dimension(10,10));
      table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

      //Create the scroll pane and add the table to it.
      table.setToolTipText("Double click will give you brief detail about that election......");
      JScrollPane scrollPane = new JScrollPane(table);

      l1=new JLabel("Elections Information Table                            #################################                                Enter Election name for search");
	  b1=new  JButton("-------OK---------");

      cont = getContentPane();
	  cont.setLayout(new BorderLayout());
      JPanel jp2=new JPanel(new FlowLayout(1,1,1));
      jp2.add(b1);

      cont.add(l1,BorderLayout.NORTH);
      cont.add(scrollPane,BorderLayout.CENTER);
	  cont.add(jp2,BorderLayout.SOUTH);
      cont.add(jcont,BorderLayout.EAST);
      b1.addActionListener(this);
      Bsearch.addActionListener(this);
      cont.setBackground(new Color(190,100,150));
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
          if(ae.getSource()==b1)
           {
            new ShowMenu();
            dispose();
           }
           else if(ae.getSource()==Bsearch)
           {
             if(Tsearch.getText().equals(""))
               JOptionPane.showMessageDialog(ElectionDetails.this,"don't leave election name empty"
                                    ,"Error Message",JOptionPane.OK_OPTION);
             else
              {
               new CurrentElectionInfo(Tsearch.getText());
               dispose();
              }
           }
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

/*	public static void main(String[] args)
	{
		JFrame b = new ElectionDetails();
	}*/
}