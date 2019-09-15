package com.rohit;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

class CreateVoterInfo extends JFrame implements ActionListener
{
	JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13;
    JRadioButton maleRadio,femaleRadio;
    ButtonGroup bg=new ButtonGroup();
    JButton createButton,resetButton,extButton;
    Container cont;

    Connection con;
	Statement stmt;
	ResultSet rs;

    String gender="male";
    //constructor of Voter INfo
    CreateVoterInfo()
	{
	    super("Create new Voter information...");
		try
		{
			//Load the driver
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}


	  l=new  JLabel("---**---Voter's Information----**--");
	  l.setFont(new Font("Arial",1,16));
	  l.setForeground(new Color(50,235,200));
	  l1 =new JLabel("Id                --:");
	  l1.setFont(new Font("Arial",0,14));
	  l1.setForeground(new Color(100,255,200));
	  l2 =new JLabel("First  Name --:");
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
	  l6 =new JLabel("City             --:");
	  l6.setFont(new Font("Arial",0,14));
	  l6.setForeground(new Color(100,255,200));
	  l7 =new JLabel("Contact no. --:");
	  l7.setFont(new Font("Arial",0,14));
	  l7.setForeground(new Color(100,255,200));
	  l8 =new JLabel("day");
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
	  l12=new JLabel("Age           --:");
	  l12.setFont(new Font("Arial",0,14));
	  l12.setForeground(new Color(100,255,200));
      l13=new JLabel("");
      l13.setFont(new Font("Arial",0,14));
	  l13.setForeground(new Color(100,255,200));

      t1=new JTextField(10);
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

      bg.add(maleRadio);
      bg.add(femaleRadio);

	  createButton=new  JButton("Create");
	  resetButton=new  JButton("Reset");
      extButton=new JButton("Exit");


	  cont = getContentPane();
	  cont.setLayout(new FlowLayout());

      cont.add(l);
      JPanel jp=new JPanel(new GridLayout(7,2,5,5));
      jp.add(l1);
      jp.add(t1);
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
      jp2.add(createButton);
	  jp2.add(resetButton);
	  jp2.add(extButton);
	  jp2.setBackground(new Color(110,130,130));
	  cont.add(jp2);
      cont.add(l13);

      cont.setBackground(new Color(110,130,130));

      maleRadio.addActionListener(this);
	  femaleRadio.addActionListener(this);
      createButton.addActionListener(this);
	  resetButton.addActionListener(this);
      extButton.addActionListener(this);
      
      t7.addKeyListener (new KeyAdapter() {
			public void keyTyped (KeyEvent ke) {
					char c = ke.getKeyChar ();
					if (!((Character.isDigit (c) || (c == KeyEvent.VK_BACK_SPACE)))) {
						getToolkit().beep ();
						ke.consume ();
	      				}
	    			}
	  			}
			);
      t8.addKeyListener (new KeyAdapter() {
			public void keyTyped (KeyEvent ke) {
					char c = ke.getKeyChar ();
					if (!((Character.isDigit (c) || (c == KeyEvent.VK_BACK_SPACE)))) {
						getToolkit().beep ();
						ke.consume ();
	      				}
	    			}
	  			}
			);
      t9.addKeyListener (new KeyAdapter() {
			public void keyTyped (KeyEvent ke) {
					char c = ke.getKeyChar ();
					if (!((Character.isDigit (c) || (c == KeyEvent.VK_BACK_SPACE)))) {
						getToolkit().beep ();
						ke.consume ();
	      				}
	    			}
	  			}
			);
      t10.addKeyListener (new KeyAdapter() {
			public void keyTyped (KeyEvent ke) {
					char c = ke.getKeyChar ();
					if (!((Character.isDigit (c) || (c == KeyEvent.VK_BACK_SPACE)))) {
						getToolkit().beep ();
						ke.consume ();
	      				}
	    			}
	  			}
			);
      t11.addKeyListener (new KeyAdapter() {
			public void keyTyped (KeyEvent ke) {
					char c = ke.getKeyChar ();
					if (!((Character.isDigit (c) || (c == KeyEvent.VK_BACK_SPACE)))) {
						getToolkit().beep ();
						ke.consume ();
	      				}
	    			}
	  			}
			);
   
	  addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				dispose();
			}
        });
       try
        {
			//Establish the connection.
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/VotingDB","root","root");
		    System.out.println("Connection Established!!");
			//Create Statement
            stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			//Obtain the resultset
			rs=stmt.executeQuery("select * from IDs");
			int iid=0;
			while(rs.next())
			{
			 iid=rs.getInt(1);
            }
            t1.setText(""+(iid+1));
		}
		catch(Exception e)
		{
		 e.printStackTrace();
        }

       t1.setEditable(true);
       setSize(340,440);
	   setLocation(150,50);
	   setVisible(true);
	}
	//--------**-----Action performed----------**-------
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
			if(ae.getSource()==createButton)
			{
              if(t2.getText().equals("") || t3.getText().equals("") ||
                 t4.getText().equals("") || t5.getText().equals("") ||
                 t6.getText().equals("") || t7.getText().equals("") ||
                 t8.getText().equals("") || t9.getText().equals("") ||
                 t10.getText().equals("") || t11.getText().equals(""))
                 {
                 l13.setText("Please fill the all fields");
                 JOptionPane.showMessageDialog(CreateVoterInfo.this,"Please fill all the fields",
                                        "Error message",JOptionPane.OK_OPTION);
                 }
              else
               {
                 if(Integer.parseInt(t8.getText())<32 && Integer.parseInt(t9.getText())<13 && Integer.parseInt(t10.getText())<2008)
                    insert();
                 else
                  JOptionPane.showMessageDialog(CreateVoterInfo.this,"Please fill Date of birth field correctly",
                                        "Error message",JOptionPane.OK_OPTION);
               }
            }
			else if(ae.getSource()==resetButton)
			{
				t1.setText("");
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
				createButton.setEnabled(true);
				t1.requestFocus();
			}
			else if(ae.getSource()==extButton)
			{
			  new ShowMenu();
			  dispose();
             }
		    else if(ae.getSource()==maleRadio)
		      {
               gender="male";
              }
		    else
		      {
               gender="female";
              }
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	//----**-------------insert record
	void insert()
	 {
	  try
        {
			//Establish the connection.
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/VotingDB","root","root");
		    System.out.println("Connection Established!!");
			//Create Statement
            stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			//Obtain the resultset
			rs=stmt.executeQuery("select * from voter");
            int id=Integer.parseInt(t1.getText());
            int age=Integer.parseInt(t11.getText());
	        rs.moveToInsertRow();
			rs.updateInt(1,id);
			rs.updateString(2,t2.getText());
            rs.updateString(3,t3.getText());
            rs.updateString(4,t4.getText());
            rs.updateString(5,t5.getText());
            rs.updateString(6,t6.getText());
            rs.updateString(7,t7.getText());
            int yy=Integer.parseInt(t10.getText());
            int mm=Integer.parseInt(t9.getText());
            int dd=Integer.parseInt(t8.getText());
            //java.sql.Date d=new java.sql.Date(yy,mm,dd);
            rs.updateInt(8,dd);
            rs.updateString(9,gender);
            rs.updateInt(10,age);
            rs.updateInt(13,mm);
            rs.updateInt(14,yy);
			rs.insertRow();
			rs.close();

			l13.setText("Voter's record is Successfully Created!!!");
			int ss=stmt.executeUpdate("update IDs set VoterID = "+(Integer.parseInt(t1.getText())));
            createButton.setEnabled(false);
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
        JFrame ob=new CreateVoterInfo();
	}
}