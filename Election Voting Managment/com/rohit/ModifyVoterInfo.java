package com.rohit;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

class ModifyVoterInfo extends JFrame implements ActionListener
{
	JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13;
    JRadioButton maleRadio,femaleRadio;
    JButton modifyButton,resetButton,searchButton,extButton;
    Container cont;

    Connection con;
	Statement stmt;
	ResultSet rs;

    String gender="male";
     int id,age;
    //constructor of Voter INfo
    ModifyVoterInfo()
	{
	    super("Modify Voters Record........");
		try
		{
			//Load the driver
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	  l=new  JLabel("---****---Candidate Information----****--");
	  l.setFont(new Font("Arial",0,16));
	  l.setForeground(new Color(100,255,200));
	  l1 =new JLabel("Id -:");
	  l1.setFont(new Font("Arial",0,14));
	  l1.setForeground(new Color(100,255,200));
	  l2 =new JLabel("First  Name--:");
	  l2.setFont(new Font("Arial",0,14));
	  l2.setForeground(new Color(100,255,200));
	  l3 =new JLabel("MiddleName--:");
	  l3.setFont(new Font("Arial",0,14));
	  l3.setForeground(new Color(100,255,200));
	  l4 =new JLabel("Last   Name--:");
	  l4.setFont(new Font("Arial",0,14));
	  l4.setForeground(new Color(100,255,200));
	  l5 =new JLabel("Address      --:");
	  l5.setFont(new Font("Arial",0,14));
	  l5.setForeground(new Color(100,255,200));
	  l6 =new JLabel("City              --:");
	  l6.setFont(new Font("Arial",0,14));
	  l6.setForeground(new Color(100,255,200));
	  l7 =new JLabel("Contact no.--:");
	  l7.setFont(new Font("Arial",0,14));
	  l7.setForeground(new Color(100,255,200));
	  l8 =new JLabel("DOB-: day");
	  l8.setFont(new Font("Arial",0,14));
	  l8.setForeground(new Color(100,255,200));
	  l9=new JLabel("mm");
	  l9.setFont(new Font("Arial",0,14));
	  l9.setForeground(new Color(100,255,200));
	  l10=new JLabel("yy");
	  l10.setFont(new Font("Arial",0,14));
	  l10.setForeground(new Color(100,255,200));
	  l11 =new JLabel("Gender     --:");
	  l11.setFont(new Font("Arial",0,14));
	  l11.setForeground(new Color(100,255,200));
	  l12=new JLabel("Age        --:");
	  l12.setFont(new Font("Arial",0,14));
	  l12.setForeground(new Color(100,255,200));
      l13=new JLabel("------------***-------------**-----------");
      l13.setFont(new Font("Arial",0,14));
	  l13.setForeground(new Color(100,255,200));
      l14=new JLabel("-------**-----******---*******--**-------");
      l14.setFont(new Font("Arial",0,14));
	  l14.setForeground(new Color(100,255,200));


	  t1=new JTextField(4);
	  t2=new JTextField(10);
	  t3=new JTextField(10);
	  t4=new JTextField(10);
	  t5=new JTextField(10);
	  t6=new JTextField(10);
	  t7=new JTextField(10);
      t8=new JTextField(2);
      t9=new JTextField(2);
      t10=new JTextField(4);
      t11=new JTextField(10);

      maleRadio=new JRadioButton("male",true);
      femaleRadio=new JRadioButton("female");
      maleRadio.setBackground(new Color(110,130,130));
      maleRadio.setFont(new Font("Arial",0,14));
      maleRadio.setForeground(new Color(100,255,200));
      femaleRadio.setBackground(new Color(110,130,130));
      femaleRadio.setFont(new Font("Arial",0,14));
      femaleRadio.setForeground(new Color(100,255,200));

	  modifyButton=new  JButton("Modify");
	  modifyButton.setEnabled(false);
	  resetButton=new  JButton("Reset");
      searchButton=new JButton("Search");
      extButton=new JButton("Exit");
	  cont = getContentPane();
	  cont.setLayout(new FlowLayout());

      cont.add(l);
      JPanel jp11=new JPanel(new GridLayout(1,3,1,5));
      jp11.add(l1);
      jp11.add(t1);
      jp11.add(searchButton);
      jp11.setBackground(new Color(110,130,130));
      cont.add(jp11);
      cont.add(l14);
      JPanel jp=new JPanel(new GridLayout(6,2,5,5));
      jp.add(l2);
      jp.add(t2);
      jp.add(l3);
      jp.add(t3);
      jp.add(l4);
      jp.add(t4);
      jp.add(l5);
      jp.add(t5);
      jp.add(l6);
      jp.add(t6);
      jp.add(l7);
      jp.add(t7);
      jp.setBackground(new Color(110,130,130));
      cont.add(jp);

      JPanel dobControl = new JPanel();
      dobControl.add(l8);
      dobControl.add(t8);
      dobControl.add(l9);
      dobControl.add(t9);
      dobControl.add(l10);
      dobControl.add(t10);
      dobControl.setBorder(BorderFactory.createTitledBorder("Date of Birth"));
      dobControl.setBackground(new Color(110,130,130));
      cont.add(dobControl);

      JPanel controls = new JPanel(new BorderLayout());
      controls.add(maleRadio,BorderLayout.WEST);
      controls.add(femaleRadio,BorderLayout.EAST);
      controls.setBorder(BorderFactory.createTitledBorder("Gender"));
      controls.setBackground(new Color(110,130,130));
      cont.add(controls);

      JPanel jp1=new JPanel(new GridLayout(0,2));
      jp1.add(l12);
      jp1.add(t11);
      jp1.setBackground(new Color(110,130,130));
      cont.add(jp1);
      JPanel jp2=new JPanel(new GridLayout(0,3));
      jp2.add(modifyButton);
	  jp2.add(resetButton);
	  jp2.add(extButton);
	  jp2.setBackground(new Color(110,130,130));
	  cont.add(jp2);
      cont.add(l13);
      cont.setBackground(new Color(110,130,130));

      maleRadio.addActionListener(this);
	  femaleRadio.addActionListener(this);
      modifyButton.addActionListener(this);
	  resetButton.addActionListener(this);
      searchButton.addActionListener(this);
      extButton.addActionListener(this);
	  addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{ dispose();	}    });

       setSize(340,470);
	   setLocation(150,50);
	   setVisible(true);
	}
	//--------**-----Action performed----------**-------
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
			if(ae.getSource()==modifyButton)
			{
              if(Integer.parseInt(t8.getText())<32 && Integer.parseInt(t9.getText())<13 && Integer.parseInt(t10.getText())<2008)
                 modify();
              else
                  JOptionPane.showMessageDialog(ModifyVoterInfo.this,"Please fill Date of birth field correctly",
                                        "Error message",JOptionPane.OK_OPTION);
            }
			else if(ae.getSource()==resetButton)
			{
				//t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t6.setText("");
				t7.setText("");
				t8.setText("");
				t9.setText("");
				t10.setText("");
				t11.setText("");
				t1.requestFocus();
			}
			else if(ae.getSource()==searchButton)
			  {
			   if(t1.getText().equals(""))
			     JOptionPane.showMessageDialog(ModifyVoterInfo.this,"Please Enter correct id",
                                        "Error message",JOptionPane.OK_OPTION);
               else
               search();
              }
            else if(ae.getSource()==extButton)
            {
             new ShowMenu();
			  dispose();
            }
		    else if(ae.getSource()==maleRadio)
		      {
		       femaleRadio.setSelected(false);
               gender="male";
              }
		    else if(ae.getSource()==femaleRadio)
		      {
		       maleRadio.setSelected(false);
               gender="female";
              }
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	//----**-------------insert record
	void search()
	 {
	  try
        {
			//Establish the connection.
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/VotingDB","root","root");
		    System.out.println("Connection Established!!");
			//Create Statement
            stmt=con.createStatement();
			//Obtain the resultset

            id=Integer.parseInt(t1.getText());
            System.out.println(id);
            rs=stmt.executeQuery("select * from voter where v_id = "+id);

            if(rs.next())
	        {
	          String name=rs.getString(2);
			  t2.setText(name);
              t3.setText(rs.getString(3));
              t4.setText(rs.getString(4));
              t5.setText(rs.getString(5));
              t6.setText(rs.getString(6));
              t7.setText(rs.getString(7));
              t8.setText(""+rs.getInt(8));
              t9.setText(""+rs.getInt(13));
              t10.setText(""+rs.getInt(14));
              if(rs.getString(9).equals("male"))
                maleRadio.setSelected(true);
              else
                femaleRadio.setSelected(true);

			  t11.setText(""+rs.getInt(10));

			  System.out.println("record found successfully");
			  modifyButton.setEnabled(true);
			  t1.setEnabled(false);

            }
            else
			 {
              l13.setText("Please enter the correct id.......");
              JOptionPane.showMessageDialog(ModifyVoterInfo.this,"Please Enter correct id",
                                        "Error message",JOptionPane.OK_OPTION);
              t1.requestFocus();
              modifyButton.setEnabled(false);
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
     //to modify record
    void modify()
	 {
       try
        {
			//Establish the connection.
			con=DriverManager.getConnection("jdbc:odbc:VotingDB");
		    System.out.println("Connection Established!!");
			//Create Statement
            stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

            //Obtain the resultset
            //java.sql.Date d1=new java.sql.Date(1985,5,5);
            age=Integer.parseInt(t11.getText());
	        String queryStr="UPDATE voter set v_first_name = '" + t2.getText() +
                 "', v_middle_name = '" + t3.getText() + "', v_last_name = '"+ t4.getText() +
                 "', v_address = '"+ t5.getText() + "', v_city = '"+ t6.getText() +
                 "', v_contact = '"+ t7.getText() + "', v_DOB = "+ Integer.parseInt(t8.getText()) +
                 ", v_gender = '"+ gender + "', v_age = "+ age + " , mm = "+Integer.parseInt(t9.getText())
                 + " , yy = "+Integer.parseInt(t10.getText())+ " WHERE v_id = "+id;
            int success=stmt.executeUpdate(queryStr);
            if(success==1)
			  {
			  JOptionPane.showMessageDialog(ModifyVoterInfo.this,"Voter's record is Successfully updated!!",
                                        "Error message",JOptionPane.OK_OPTION);
              System.out.println("Voter's record is Successfully updated!!!");
              }
			else
			  {
              JOptionPane.showMessageDialog(ModifyVoterInfo.this,"Sorry, record doesn't updated, try again..",
                                        "Error message",JOptionPane.OK_OPTION);
              System.out.println("Sorry , try again");
              }
			//close all utilized
			//stmt.close();
			con.close();
			t1.setEnabled(true);
			modifyButton.setEnabled(false);
        }
        catch (SQLException e)
        {
			e.printStackTrace();
        }
     }
    //------------***---------main method
	public static void main(String[] args)
	{
        JFrame ob=new ModifyVoterInfo();

	}
}