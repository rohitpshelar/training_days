package com.rohit;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


class Server extends JFrame implements ActionListener
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
JButton finish,start;
  JLabel l;
  Container cont;
  String eleName;
  //ValidVoterServer ob;
  Connection con;
  Statement stmt;
  ResultSet rs,rs1;
  FrontPage fp;
  int id=0;
  String name,symbol;

  Server(String electionName)
   {
    super("Voting Machine Server is running......");
    System.out.println("Server started");
    eleName=electionName;
        try
		{   //Load the driver
		   Class.forName("com.mysql.jdbc.Driver");
		}
	    catch(Exception e)
	     {
	       System.out.println(e);
         }

    finish=new JButton("Finish Voting?");
    start=new JButton("Start Voting");

    l=new JLabel("Voting Server is running");
    l.setFont(new Font("Arial",0,16));
    l.setForeground(new Color(170,245,150));
    addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
			 JOptionPane.showMessageDialog(Server.this,"Sorry don't finish illegally\nUse finish button"
                                            ,"Error message",JOptionPane.OK_OPTION);

			}
        });

    cont = getContentPane();
    cont.setLayout(new FlowLayout());
    cont.add(l);
    cont.add(start);
    cont.add(finish);

    finish.addActionListener(this);
    start.addActionListener(this);

    finish.setEnabled(false);
    cont.setBackground(new Color(100,190,190));
    setSize(500,250);
	setLocation(100,100);
	setVisible(true);

   }
   void winnerShow()
   {
         try
        {
         //Establish the connection.
		  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/VotingDB","root","root");
		  System.out.println("Connection Established!!");
		  //Create Statement
          stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
          //get result set
          rs=stmt.executeQuery("select * from "+eleName+" where winner = '1'");

          while(rs.next())
           {
             id=rs.getInt(1);
           }
          System.out.println("candidate id is--: "+id);
          rs=stmt.executeQuery("select * from candidate where c_id = "+id);
          while(rs.next())
           {
             name=rs.getString(2);//+" "+rs.getString(3)+" "+rs.getString(4);
             symbol=rs.getString(13);
           }
           System.out.println("candidate name is--: "+name);
           rs.close();
           stmt.close();
           con.close();
          }
          catch(SQLException e)
           {
            e.printStackTrace();
           }
    }
   public void actionPerformed(ActionEvent ae)
	{
		try
		{
		  if(ae.getSource()==start)
		   {
             start.setEnabled(false);
             finish.setEnabled(true);
             new FrontPage(eleName);
           }
		  else if(ae.getSource()==finish)
		    {
              new FinishWork(eleName);
              System.out.println("finish vote called");
              winnerShow();
              JOptionPane.showMessageDialog(Server.this,"The winner is "+name,"Winner message"
                                            ,JOptionPane.OK_OPTION,new ImageIcon(symbol));

              new CurrentElectionInfo(eleName);
              dispose();
              System.out.println("done");
            }
        }
        catch(Exception e)
           {
           }
    }
}