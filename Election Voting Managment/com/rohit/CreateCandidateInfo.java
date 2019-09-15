package com.rohit;

import java.sql.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.filechooser.*;

class CreateCandidateInfo extends JFrame implements ActionListener
{
	JLabel l,Lid,l2,l3,l4,l5,l6,l7,l8,l9,l10,Lgender,Lage,Lpartyname,Linfo,Lsym,Lphoto,Lstatus;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16;
    JButton createButton,resetButton,extButton,symButton,phtButton;
    ButtonGroup bg;
    JLabel symButtonbol,photo;
    JRadioButton maleRadio,femaleRadio;

    Container cont;
    Connection con;
	Statement stmt;
	ResultSet rs;

    String gender="male";
    JFileChooser fc;
    File file;
    String symButtonPath="",phtButtonPath="";

    //constructor of Voter INfo
    CreateCandidateInfo()
	{
	    super("Create new Candidates information...");
		try
		{   //Load the driver
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}

      fc = new JFileChooser();
	  l=new  JLabel("---**----Candidate Information---**-------");
	  l.setForeground(new Color(50,235,200));
	  Lid=new JLabel("Id                  --:");
	  Lid.setForeground(new Color(50,235,200));
	  l2 =new JLabel("First  Name--:");
	  l2.setForeground(new Color(50,235,200));
	  l3 =new JLabel("MiddleName--:");
	  l3.setForeground(new Color(50,235,200));
	  l4 =new JLabel("Last   Name--:");
	  l4.setForeground(new Color(50,235,200));
	  l5 =new JLabel("Address      --:");
	  l5.setForeground(new Color(50,235,200));
	  l6 =new JLabel("City              --:");
	  l6.setForeground(new Color(50,235,200));
	  l7 =new JLabel("Contact no.--:");
	  l7.setForeground(new Color(50,235,200));
	  l8 =new JLabel("DOB-: day");
	  l8.setForeground(new Color(50,235,200));
	  l9=new JLabel("mm");
	  l9.setForeground(new Color(50,235,200));
	  l10=new JLabel("yy");
	  l10.setForeground(new Color(50,235,200));
	  Lgender =new JLabel("Gender     --:");
	  Lgender.setForeground(new Color(50,235,200));
	  Lage=new JLabel("Age        --:");
	  Lage.setForeground(new Color(50,235,200));
	  Lpartyname=new JLabel("Party name --:");
	  Lpartyname.setForeground(new Color(50,235,200));
	  Linfo=new JLabel("Information--:");
	  Linfo.setForeground(new Color(50,235,200));
	  Lsym=new JLabel("Symbol     --:");
	  Lsym.setForeground(new Color(50,235,200));
	  Lphoto=new JLabel("Photo--: ");
	  Lphoto.setForeground(new Color(50,235,200));
      Lstatus=new JLabel("#################################");
      Lstatus.setForeground(new Color(50,235,200));

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
      t12=new JTextField(10);
	  t13=new JTextField(10);
	  //t14=new JTextField(10);
	  symButtonbol=new JLabel(new ImageIcon(""));
	  photo=new JLabel(new ImageIcon(""));

      maleRadio=new JRadioButton("male",true);
      femaleRadio=new JRadioButton("female");
      maleRadio.setFont(new Font("Arial",1,14));
      maleRadio.setBackground(new Color(110,130,130));
      maleRadio.setForeground(new Color(128,255,255));
      femaleRadio.setBackground(new Color(110,130,130));
      femaleRadio.setForeground(new Color(128,255,255));
      femaleRadio.setFont(new Font("Arial",1,14));

      bg=new ButtonGroup();
      bg.add(maleRadio);
      bg.add(femaleRadio);

	  createButton=new  JButton("Create");
	  resetButton=new  JButton("Reset");
      extButton=new JButton("Exit");
      symButton=new JButton("Symbol");
      phtButton=new JButton("Photo");

      cont = getContentPane();
	  cont.setLayout(new FlowLayout());

      cont.add(l);
      JPanel jp=new JPanel(new GridLayout(4,4,5,5));
      jp.add(Lid);
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
      dobControl.setBackground(new Color(110,130,130));
      dobControl.setBorder(BorderFactory.createTitledBorder("Date of Birth"));
      cont.add(dobControl);

      JPanel controls = new JPanel(new BorderLayout());
      controls.add(maleRadio,BorderLayout.WEST);
      controls.add(femaleRadio,BorderLayout.EAST);
      controls.setBorder(BorderFactory.createTitledBorder("Gender"));
      controls.setBackground(new Color(110,130,130));
      cont.add(controls);

      JPanel jp2 = new JPanel(new GridLayout(2,2,5,5));
      jp2.add(Lage);
      jp2.add(t11);
      jp2.add(Lpartyname);
      jp2.add(t12);
      jp2.setBackground(new Color(110,130,130));
      cont.add(jp2);

      JPanel jp3 = new JPanel();
      jp3.add(Linfo);
      JScrollPane jsp=new JScrollPane(t13,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
      jp3.add(jsp);
      jp3.setBackground(new Color(110,130,130));
      cont.add(jp3);

      JPanel jp5 = new JPanel();
      jp5.add(Lsym);
      jp5.add(symButtonbol);
      jp5.add(symButton);
      jp5.add(Lphoto);
      jp5.add(photo);
      jp5.add(phtButton);
      jp5.setBackground(new Color(110,130,130));
      cont.add(jp5);

	  JPanel jp4 = new JPanel();
      jp4.add(createButton);
	  jp4.add(resetButton);
      jp4.add(extButton);
      jp4.setBackground(new Color(110,130,130));
      cont.add(jp4);
      cont.setBackground(new Color(110,130,130));

      maleRadio.addActionListener(this);
	  femaleRadio.addActionListener(this);
      createButton.addActionListener(this);
	  resetButton.addActionListener(this);
      extButton.addActionListener(this);
      symButton.addActionListener(this);
      phtButton.addActionListener(this);

	  addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				new ShowMenu();
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
			 iid=rs.getInt(2);
            }
            t1.setText(""+(iid+1));
		}
		catch(Exception e)
		{
		 e.printStackTrace();
        }
       t1.setEditable(true);
       setSize(610,560);
	   setLocation(70,10);
	   setVisible(true);
	}
    //--------**-----Action performed----------**-------
    public void actionPerformed(ActionEvent ae)
	{
		try
		{
			if(ae.getSource()==createButton)
			{
             if(t2.getText().equals("") || t3.getText().equals("") || t4.getText().equals("")|| t4.getText().equals("")
                 || t6.getText().equals("") || t7.getText().equals("") || t8.getText().equals("")
                 || t9.getText().equals("") || t10.getText().equals("") || t11.getText().equals("")
                 || t12.getText().equals("") || t13.getText().equals("") )
                {
                 JOptionPane.showMessageDialog(CreateCandidateInfo.this,"Don't leave any field empty"
                              ,"Error message",JOptionPane.OK_OPTION);
                 //Lpartyname.setText("Please fill the all fields");
                }
             else
               {
                if(Integer.parseInt(t8.getText())<32 && Integer.parseInt(t9.getText())<13 && Integer.parseInt(t10.getText())<2008)
                    insert();
                 else
                  JOptionPane.showMessageDialog(CreateCandidateInfo.this,"Please fill Date of birth field correctly",
                                        "Error message",JOptionPane.OK_OPTION);
               }
            }
			else if(ae.getSource()==resetButton)
			{   createButton.setEnabled(true);
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
				t12.setText("");
				t13.setText("");
				createButton.setEnabled(true);
				t1.requestFocus();
			}
			else if(ae.getSource()==symButton)
			  {
			    int returnVal = fc.showOpenDialog(CreateCandidateInfo.this);
			    file = fc.getSelectedFile();
			    symButtonPath =file.getPath();
			    symButtonbol.setIcon(new ImageIcon(symButtonPath));
              }
            else if(ae.getSource()==phtButton)
              {
                int returnVal = fc.showOpenDialog(CreateCandidateInfo.this);
			    file = fc.getSelectedFile();
			    phtButtonPath =file.getPath();
			    photo.setIcon(new ImageIcon(phtButtonPath));
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
            else if(ae.getSource()==extButton)
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
	//-------**-------------insert record-----------***-------------
	void insert()
	 {
	  try
        {  	//Establish the connection.
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/VotingDB","root","root");
		    System.out.println("Connection Established!!");
			//Create Statement
            stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			//Obtain the resultset
			rs=stmt.executeQuery("select * from candidate");

	        rs.moveToInsertRow();
			rs.updateInt(1,Integer.parseInt(t1.getText()));
			rs.updateString(2,t2.getText());
            rs.updateString(3,t3.getText());
            rs.updateString(4,t4.getText());
            rs.updateString(5,t5.getText());
            rs.updateString(6,t6.getText());
            rs.updateString(7,t7.getText());
            int yy=Integer.parseInt(t10.getText());
            int mm=Integer.parseInt(t9.getText());
            int dd=Integer.parseInt(t8.getText());
            rs.updateInt(8,dd);
            rs.updateString(9,gender);
            rs.updateInt(10,Integer.parseInt(t11.getText()));
            rs.updateString(11,t12.getText());
            rs.updateString(12,t13.getText());
            rs.updateString(13,symButtonPath);
            rs.updateString(14,phtButtonPath);
            rs.updateInt(15,mm);
            rs.updateInt(16,yy);
			rs.insertRow();
			rs.close();
			//Create Statement
            stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			//Obtain the resultset
			//int sdfs=stmt.executeUpdate("update candidate set c_symButtonbol='"+symButtonPath+"', photo = '"+phtButtonPath+"' where c_id = "+Integer.parseInt(t1.getText()));

            JOptionPane.showMessageDialog(CreateCandidateInfo.this,"Record is successfully created"
                                ,"Success message",JOptionPane.OK_OPTION);
			createButton.setEnabled(false);
            System.out.println("Candidate's record is Successfully Created!!!");

            int ss=stmt.executeUpdate("update IDs set CandidateID = "+(Integer.parseInt(t1.getText())));

			//close all utilized connection
			stmt.close();
			con.close();
        }
        catch (SQLException e)
        {
			e.printStackTrace();
        }
     }
 }