package com.rohit;

import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

class ModifyCandidateInfo extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16;
    JButton modifyButton,resetButton,extButton,searchButton,sym,pht;
    ButtonGroup bg;
    JLabel symbol,photo;
    JRadioButton maleRadio,femaleRadio;
    Container cont;
    Connection con;
	Statement stmt;
	ResultSet rs;
    String gender="male";
    JFileChooser fc;
    File file;
    String symPath,phtPath;
    int id;
    //constructor of Voter INfo
    ModifyCandidateInfo()
	{
	    super("modify");
		try
		{   //Load the driver
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}

	  fc = new JFileChooser();
	  l=new  JLabel("------****-------Modify Candidate Information--------*****-------");
	  l.setForeground(new Color(50,235,200));
	  l1 =new JLabel("Id                  --:");
	  l1.setForeground(new Color(50,235,200));
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
	  l11 =new JLabel("Gender     --:");
	  l11.setForeground(new Color(50,235,200));
	  l12=new JLabel("Age        --:");
	  l12.setForeground(new Color(50,235,200));
	  l13=new JLabel("Party name --:");
	  l13.setForeground(new Color(50,235,200));
	  l14=new JLabel("Information--:");
	  l14.setForeground(new Color(50,235,200));
	  l15=new JLabel("Symbol--:");
	  l15.setForeground(new Color(50,235,200));
	  l16=new JLabel("Photo--: ");
	  l16.setForeground(new Color(50,235,200));
      l17=new JLabel("#################################");
      l17.setForeground(new Color(50,235,200));

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
	  symbol=new JLabel(new ImageIcon(""));
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

      searchButton=new JButton("Search");
	  modifyButton=new  JButton("Modify");
	  resetButton=new  JButton("Reset");
      extButton=new JButton("Exit");
      sym=new JButton("Symbol");
      pht=new JButton("Photo");

      cont = getContentPane();
	  cont.setLayout(new FlowLayout());

      cont.add(l);
      JPanel jpp=new JPanel();
      jpp.add(l1);
      jpp.add(t1);
      jpp.add(searchButton);
      jpp.setBackground(new Color(110,130,130));
      cont.add(jpp);

      JPanel jp=new JPanel(new GridLayout(3,4,5,5));
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
      jp2.add(l12);
      jp2.add(t11);
      jp2.add(l13);
      jp2.add(t12);
      jp2.setBackground(new Color(110,130,130));
      cont.add(jp2);

      JPanel jp3 = new JPanel();
      jp3.add(l14);
      JScrollPane jsp=new JScrollPane(t13,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
      jp3.add(jsp);
      jp3.setBackground(new Color(110,130,130));
      cont.add(jp3);

      JPanel jp5 = new JPanel();
      jp5.add(l15);
      jp5.add(symbol);
      jp5.add(sym);
      jp5.add(l16);
      jp5.add(photo);
      jp5.add(pht);
      jp5.setBackground(new Color(110,130,130));
      cont.add(jp5);

      JPanel jp4 = new JPanel();
      jp4.add(modifyButton);
	  jp4.add(resetButton);
      jp4.add(extButton);
      jp4.setBackground(new Color(110,130,130));
      cont.add(jp4);
      cont.setBackground(new Color(110,130,130));

      maleRadio.addActionListener(this);
	  femaleRadio.addActionListener(this);
      modifyButton.addActionListener(this);
	  resetButton.addActionListener(this);
      extButton.addActionListener(this);
      searchButton.addActionListener(this);
      sym.addActionListener(this);
      pht.addActionListener(this);

	  addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				dispose();
			}
        });

       setSize(610,560);
	   setLocation(70,10);
	   setVisible(true);
	}

    public void actionPerformed(ActionEvent ae)
	{
		try
		{
			if(ae.getSource()==modifyButton)
			{
             if(Integer.parseInt(t8.getText())<32 && Integer.parseInt(t9.getText())<13 && Integer.parseInt(t10.getText())<2008)
                    modify();
                 else
                  JOptionPane.showMessageDialog(ModifyCandidateInfo.this,"Please fill Date of birth field correctly",
                                        "Error message",JOptionPane.OK_OPTION);
            }
            else if(ae.getSource()==extButton)
            {
             new ShowMenu();
			  dispose();
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
				t12.setText("");
				t13.setText("");
				t1.requestFocus();
			}
			else if(ae.getSource()==searchButton)
			  {
			   if(t1.getText().equals(""))
			     JOptionPane.showMessageDialog(ModifyCandidateInfo.this,"Please Enter id",
                                        "Error message",JOptionPane.OK_OPTION);
               else
               search();
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
            else if(ae.getSource()==sym)
			  {
			    int returnVal = fc.showOpenDialog(ModifyCandidateInfo.this);
			    file = fc.getSelectedFile();
			    symPath =file.getPath();
			    symbol.setIcon(new ImageIcon(symPath));
              }
            else if(ae.getSource()==pht)
              {
                int returnVal = fc.showOpenDialog(ModifyCandidateInfo.this);
			    file = fc.getSelectedFile();
			    phtPath =file.getPath();
			    photo.setIcon(new ImageIcon(phtPath));
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
            rs=stmt.executeQuery("select * from candidate where c_id = "+id);

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
              t9.setText(""+rs.getInt(15));
              t10.setText(""+rs.getInt(16));

              if(rs.getString(9).equals("male"))
                maleRadio.setSelected(true);
              else
                femaleRadio.setSelected(true);
			  t11.setText(""+rs.getInt(10));
			  t12.setText(rs.getString(11));
			  t13.setText(rs.getString(12));
			  try {
                 symPath=rs.getString(13);
                 symbol.setIcon(new ImageIcon(symPath));
              } catch (Exception e) {
                symbol.setText("Image not found add new");
              }
              try {
                phtPath=rs.getString(14);
                photo.setIcon(new ImageIcon(phtPath));
              } catch (Exception e) {
                photo.setText("Image not found add new");
              }


			  System.out.println("record found successfully");
			  modifyButton.setEnabled(true);
			  t1.setEnabled(false);

            }
            else
			 {
              l13.setText("Please enter the correct id.......");
              JOptionPane.showMessageDialog(ModifyCandidateInfo.this,"Please Enter correct id",
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
//---------**-----------to modify record---------**---------------
    void modify()
	 {
       try
        {   //Establish the connection.
			con=DriverManager.getConnection("jdbc:odbc:VotingDB");
		    System.out.println("Connection Established!!");
			//Create Statement
            stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			//Obtain the resultset
            String fName=t2.getText();
            String mName=t3.getText();
            String lName=t4.getText();
            String addr=t5.getText();
            String city=t6.getText();
            String contact=t7.getText();
            int age=Integer.parseInt(t11.getText());
            int yy=Integer.parseInt(t10.getText());
            int mm=Integer.parseInt(t9.getText());
            int dd=Integer.parseInt(t8.getText());

	        String queryStr="UPDATE candidate set c_first_name = '" + fName +
                 "', c_middle_name = '" + mName + "', c_last_name = '"+ lName +
                 "', c_address = '"+ addr + "', c_city = '"+ city +
                 "', c_contact = '"+ contact + "', c_DOB = "+ dd +
                 ", c_gender = '"+ gender + "', c_age = "+ age +
                 ", c_partyname = '"+t12.getText()+"',c_info ='"+ t13.getText() +
                 "', c_symbol = '" + symPath + "', photo = '"+ phtPath  +
                 "' , mm = "+mm+ " , yy = "+yy+" WHERE c_id = "+id;
            int success=stmt.executeUpdate(queryStr);
            if(success==1)
			  {
			  JOptionPane.showMessageDialog(ModifyCandidateInfo.this,"record is successfully updated"
			                        ,"Success message",JOptionPane.OK_OPTION);
              System.out.println("Candidate's record is Successfully updated!!!");
              t1.setEnabled(true);
              modifyButton.setEnabled(false);
              }
			else
			  {
              System.out.println("Sorry this named record is not present..");
              JOptionPane.showMessageDialog(ModifyCandidateInfo.this,"record is not successfully updated"
			                        ,"Error message",JOptionPane.OK_OPTION);
              }
			//close all utilized connection
			stmt.close();
			con.close();
        }
        catch (SQLException e)
        {
			e.printStackTrace();
        }
     }

     //------------***---------main method---------***----------------
	public static void main(String[] args)
	{
        JFrame ob=new ModifyCandidateInfo();
        //ob.modify();
	}
}