package com.rohit;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class NewElection extends JFrame implements ActionListener
{
  JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;
  JTextField t1,t2,t3;
  JButton b1,b2,b3;
  Container cont;
  Connection con;
  Statement stmt;
  ResultSet rs,rs1;
  int id1[]=new int[15];
  String name[]=new String[15];
  String votes[]=new String[15];
  String electionName;
  int totalVoter,totalCandidate;
  int success;
  Server server;

  NewElection()
  {
   super("Voting Server is running..........");

    try
	  {   //Load the driver
		Class.forName("com.mysql.jdbc.Driver");
	  }
	catch(Exception e)
	  {
	    System.out.println(e);
      }

   l1=new  JLabel("Election Voting Server...........................");
   l1.setFont(new Font("Arial",0,16));
   l1.setForeground(new Color(170,245,150));
   l2=new JLabel("Election name --:");
   l2.setFont(new Font("Arial",1,14));
   l2.setForeground(new Color(100,255,200));
   t1=new JTextField(10);

   b1=new  JButton("OK");
   b2=new  JButton("Exit");

   cont = getContentPane();
   cont.setLayout(new FlowLayout());
   cont.setBackground(new Color(100,190,190));

    cont.add(l1);
    cont.add(l2);
    cont.add(t1);
	cont.add(b1);
    cont.add(b2);
    b1.addActionListener(this);
    b2.addActionListener(this);

   addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				dispose();
			}
        });

   setSize(280,130);
   setLocation(100,100);
   setVisible(true);
  }

////////////////////////////////////////////////////////////////////////////////
/////////////////////////CREATE//////////////////////////////////////////////////
void create()
{
             try
              {
			   //Establish the connection.
			   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/VotingDB","root","root");
		       System.out.println("Connection Established!!");

               //Create Statement
               stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			   Date eleDate = new Date(System.currentTimeMillis());//Obtain the resultset
			   electionName=t1.getText();
               String createTable = "create table "+ electionName +
                   "(id int primary key, candidate varchar(50), totalVotes varchar(50),winner varchar(50))";
               stmt.executeUpdate(createTable);
		success=1;
			   System.out.println("New election record is Successfully Created!!!");
                   /*voter voted 0*/
               int aa=stmt.executeUpdate("update voter set voted = 0");
               rs=stmt.executeQuery("select * from voter");
               rs.beforeFirst();
               totalVoter=0;
               while(rs.next())
                { totalVoter++; //got total voter information
                }

               //add candidates information in the election table
               rs=stmt.executeQuery("select * from candidate ");//where permitted = 1");
               //Navigate the resultset
			   rs.beforeFirst();
			   String fn,mn,ln;
			   int i=0,j=0;
			   int ids[]=new int[30];
			   String names[]=new String[30];
			   while(rs.next())
			   {   //get the information from candidate table
			    i++;
                ids[i]=rs.getInt(1);
                fn=rs.getString(2);
				mn=rs.getString(3);
				ln=rs.getString(4);
				names[i]=fn+" "+mn+" "+ln;
			   }
			   totalCandidate=i;    //got total candidate information
               rs1=stmt.executeQuery("select * from "+ electionName);
              while(i>0)
			     {   //add candidate detail in election table name
			        j++;
                    i--;
            	    rs1.moveToInsertRow();
                    rs1.updateInt(1,ids[j]);
                    rs1.updateString(2,names[j]);
                    rs1.updateString(3,"0");
                    rs1.updateString(4,"0");
                    rs1.insertRow();
			     }
               int start=stmt.executeUpdate("insert into Status values('start','"+electionName+"')");
			   // add election information in Election details table
               rs=stmt.executeQuery("select * from electionDetails");
	           rs.moveToInsertRow();
	           rs.updateString(2,electionName);
	           rs.updateString(3,""+totalCandidate);
	           rs.updateString(4,""+totalVoter);
	           rs.updateDate(7,eleDate);
               rs.insertRow();
               rs.close();
               System.out.println("election name is successfully added..");

			    stmt.close();
			    con.close();
                }
              catch (SQLException e)
              {
			   e.printStackTrace();
              }
}
///////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////
public void actionPerformed(ActionEvent ae)
	{
		try
		{
		    if(ae.getSource()==b2)
		     {
                new ShowMenu();
                dispose();
             }
			else if(ae.getSource()==b1)
			{
              if(t1.getText().equals(""))
               {
                 JOptionPane.showMessageDialog(NewElection.this,"don't leave election name empty"
                                    ,"Error Message",JOptionPane.OK_OPTION);
               }
               else
               {
                create();
                  if(success==0)
                   {
                   JOptionPane.showMessageDialog(NewElection.this,"This election name already present"
                                    ,"Error Message",JOptionPane.OK_OPTION);
                    t1.requestFocus(true);
                   }
                  else
                   {
                     System.out.println("start to the server");
                     new Server(electionName);
                     dispose();
                   }
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
		JFrame b = new NewElection();
	} */
}