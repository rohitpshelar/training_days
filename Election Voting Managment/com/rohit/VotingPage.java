package com.rohit;

import java.io.*;
import java.util.*;
import java.rmi.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class VotingPage extends JFrame implements ActionListener
{
   JLabel Lhead,l2,l3,l4,l5,l6,l7,l8,l9,Lhead0,Lhead1,Lhead2;
   JLabel pic[]=new JLabel[20];
   JRadioButton jr[]=new JRadioButton[20];
   JButton electedButton,cancelButton;
   ButtonGroup group;
   Container cont;
   Icon icon;
   Remote stub;
   ResultSet rs;
   Connection con;
   Statement stmt;

   int i=0;
   int total=0;
   String candidateName[]=new String[50];
   String candidateSymbol[]=new String[50];
   String candidatePhoto[]=new String[50];
   String candidateInfo[]=new String[50];

   int ids[]=new int[50];
   int v_id,c_id,state=0;
   int success=0;
   String eleName;
//---------------------access voter id from front page
   VotingPage(String eleName,int v_id)
   {
     super("Voting Fprm....");
     this.v_id=v_id;
     this.eleName=eleName;
     ///////////////////////////////////////////////////////////////
            try
		      {   //Load the driver
		          Class.forName("com.mysql.jdbc.Driver");
		      }
	          catch(Exception e)
	          {
	              System.out.println(e);
              }

              try
              {
              //Establish the connection.
		      con=DriverManager.getConnection("jdbc:mysql://localhost:3306/VotingDB","root","root");
		      System.out.println("Connection Established!!");
		      //Create Statement
              stmt=con.createStatement();
              //get result set
              rs=stmt.executeQuery("select * from candidate");
              total=-1;
              while(rs.next())
              {
               total++;
               state=1;
               ids[total]=rs.getInt(1);
               candidateName[total]=rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4);
               candidateInfo[total]=rs.getString(12);
               candidateSymbol[total]=rs.getString(13);
               candidatePhoto[total]=rs.getString(14);
              }
              c_id=ids[0];
              //close connection
              rs.close();
              stmt.close();
              con.close();
              }
              catch(SQLException e)
               {
                e.printStackTrace();
               }
            System.out.println("got information..");
     /////////////////////////////////////////////////////// //////
      Lhead=new JLabel("-------**********---------Vote to your favourite candidate...--------*********-----------");
      Lhead.setFont(new Font("Arial",1,14));
      Lhead.setForeground(new Color(255,0,128));
      jr[0]=new JRadioButton(candidateName[0],true);
      jr[0].setBackground(new Color(183,202,193));
      jr[0].setForeground(new Color(128,0,128));
      jr[0].setFont(new Font("Arial",4,14));
      jr[0].setToolTipText(""+candidateInfo[0]);
      pic[0]=new JLabel(new ImageIcon(candidateSymbol[0]));
      pic[0].setBackground(new Color(183,202,193));
      System.out.println("start addedd");

      for(i=1;i<=total;i++)
       {
       System.out.println("enter for");
         if(candidateSymbol[i].equals(""))
         {
           jr[i]=new JRadioButton(candidateName[i]);
           jr[i].setBackground(new Color(100,190,190));
           jr[i].setForeground(new Color(128,0,128));
           jr[i].setFont(new Font("Arial",4,14));
           jr[i].setToolTipText(""+candidateInfo[i]);
           System.out.println("enter if"+i);
         }
         else
         { try{
           System.out.println("enter else"+i);
           jr[i]=new JRadioButton(candidateName[i]);
           jr[i].setBackground(new Color(183,202,193));
           jr[i].setForeground(new Color(128,0,128));
           jr[i].setFont(new Font("Arial",4,14));
           jr[i].setToolTipText(""+candidateInfo[i]);
           pic[i]=new JLabel(new ImageIcon(candidateSymbol[i]));
           pic[i].setBounds(new Rectangle(5,5));
           }catch(Exception e){}
           }
         }


       System.out.println("radio button added");
      electedButton=new JButton("Elected");
      cancelButton=new JButton("Cancel Voting");

      group=new ButtonGroup();

      for(i=0;i<=total;i++)
       {
        group.add(jr[i]);
       }
       System.out.println("successfully grouped");

      cont = getContentPane();
	  cont.setLayout(new FlowLayout());
      cont.setBackground(new Color(183,202,193));
      cont.add(Lhead,BorderLayout.NORTH);

      JPanel jpp=new JPanel(new GridLayout(5,5));
      System.out.println("jp created");
      for(i=0;i<=total;i++)
       {
        System.out.println("enter for"+i);
        jpp.add(jr[i]);
        jpp.add(pic[i]);
       }
       System.out.println("added");
       jpp.setBackground(new Color(183,202,193));
       //JScrollPane jspp=new JScrollPane(jpp,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
       cont.add(jpp,BorderLayout.CENTER);
       System.out.println("successfully added");
       JPanel jp=new JPanel(new GridLayout(1,2));
       jp.add(electedButton);
       jp.add(cancelButton);
       cont.add(jp,BorderLayout.SOUTH);

      for(i=0;i<=total;i++)
       {
        jr[i].addActionListener(this);
       }
      System.out.println("added action listener");
      electedButton.addActionListener(this);
	  cancelButton.addActionListener(this);

      addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we)
			{dispose();}});

      setSize(760,570);
	  setLocation(00,0);
	  setVisible(true);
   }//constructor ends

//-----------------Action performed events
   public void actionPerformed(ActionEvent ae)
	{
		try
		{
			if(ae.getSource()==electedButton)
			{
             success = electedCandidate();
             System.out.println(success);
             if(success!=0)
              {
              JOptionPane.showMessageDialog(VotingPage.this,"Thank u!! u have voted successfully","Success Message",

                                            JOptionPane.YES_OPTION);
              this.setVisible(false);
              new FrontPage(eleName).setVisible(true);
             }
            }
			else if(ae.getSource()==cancelButton)
			{
              int yy = JOptionPane.showConfirmDialog(VotingPage.this,"Do u really want to quit without voted......","Empty Message",
                                            JOptionPane.YES_NO_OPTION);
               if(yy == JOptionPane.YES_OPTION)
                 {
                  this.setVisible(false);
                  new FrontPage(eleName).setVisible(true);
                 }
			}
			else
			 {
             for(int i=0;i<=total;i++)
			  {
               if(ae.getSource()==jr[i])
                 c_id=ids[i];
                 System.out.println(c_id+" "+v_id);
              }
             }
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
//----------------------------------------------------------------------
  public static void main(String[] args)  throws IOException
   {
      JFrame j = new VotingPage("",1);
  } //main method ends

  int electedCandidate()
	 {
	    int totalVote=0;
	    int done=0;
        try
        {
         //Establish the connection.
		  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/VotingDB","root","root");
		  System.out.println("Connection Established!!");
          stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
          //------------------------for Voter
            rs=stmt.executeQuery("select * from voter where v_id ="+v_id);
            //Navigate the resultset
			rs.beforeFirst();
			while(rs.next())
               { totalVote=rs.getInt(12);}

          totalVote++;
          //Create Statement
          stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
          //Obtain the resultset
	      String queryStr="UPDATE voter set voted = 1, totalVotes = " +
                 totalVote + " WHERE v_id = "+v_id;
          int success=stmt.executeUpdate(queryStr);
          if(success==1)
            {done++;
		     System.out.println("Voter's record is Successfully updated!!!");
		    }
		  else
		     System.out.println("Sorry not updated..");


          //--------------------For Election table
          rs=stmt.executeQuery("select * from "+eleName+" where id ="+c_id);
            //Navigate the resultset
			rs.beforeFirst();
			while(rs.next())
               { totalVote=rs.getInt(3);}

          totalVote++;
          //Create Statement
          stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
          //Obtain the resultset
	      queryStr="UPDATE "+eleName+" set totalVotes = "+
                 totalVote+" WHERE id = "+c_id;
          success=stmt.executeUpdate(queryStr);
          if(success==1)
		     {done++;
             System.out.println(eleName+"'s record is Successfully updated!!!");
             }
		  else
		     System.out.println("Sorry updated..");
         }
        catch(Exception e)
         {
           System.out.println(e);
         }
		finally
        {
        if(rs==null)
          return 0;
        else
		  return done;
       }
     }
}