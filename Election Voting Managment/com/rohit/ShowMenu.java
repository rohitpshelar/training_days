package com.rohit;

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class ShowMenu extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Container cont;
	JMenuBar jmb;
	JMenu VI, CI, NewE, SR, help;
	JMenuItem vCreate, vModify, vDelete, vShow;
	JMenuItem cCreate, cModify, cDelete, cShow;
	JMenuItem Start;
	JMenuItem ShowRecord, abtUs, chgPass, ext, logOut;
	JLabel l;

	NewElection ne;
	CreateVoterInfo cvi;
	CreateCandidateInfo cci;
	ModifyVoterInfo mvi;
	ModifyCandidateInfo mci;
	DeleteVoterInfo dvi;
	DeleteCandidateInfo dci;
	ShowCandidateInfo sci;
	ShowVoterInfo svi;
	ElectionDetails ed;
	// ElectionInfo ei;
	Connection con;
	Statement stmt;
	ResultSet rs;

	ShowMenu() {
		super("Main Menu");
		l = new JLabel("satus");
		cont = getContentPane();

		cont.setLayout(new FlowLayout());
		ImageIcon icon=new ImageIcon(
				Frame.class.getResource("/com/rohit/resources/v.jpg"));
		
		JLabel background = new JLabel(icon);
		background.setLayout(new FlowLayout());
		background.setLocation(0, 0);
		Toolkit kits = Toolkit.getDefaultToolkit();
		Dimension screenSizes = kits.getScreenSize();
		background.setSize(screenSizes.width, screenSizes.height);
		

		jmb = new JMenuBar();
		VI = new JMenu("VoterDetail");
		vCreate = new JMenuItem("CreateRecord");
		vModify = new JMenuItem("ModifyRecord");
		vDelete = new JMenuItem("DeleteRecord");
		vShow = new JMenuItem("ShowRecord");
		VI.add(vCreate);
		VI.add(vModify);
		VI.add(vDelete);
		VI.addSeparator();
		VI.add(vShow);
		vCreate.addActionListener(this);
		vModify.addActionListener(this);
		vDelete.addActionListener(this);
		vShow.addActionListener(this);
		CI = new JMenu("CandidateDetail");
		cCreate = new JMenuItem("CreateRecord");
		cModify = new JMenuItem("ModifyRecord");
		cDelete = new JMenuItem("DeleteRecord");
		cShow = new JMenuItem("ShowRecord");
		CI.add(cCreate);
		CI.add(cModify);
		CI.add(cDelete);
		CI.addSeparator();
		CI.add(cShow);
		cCreate.addActionListener(this);
		cModify.addActionListener(this);
		cDelete.addActionListener(this);
		cShow.addActionListener(this);
		NewE = new JMenu("NewElection");
		Start = new JMenuItem("Start");
		Start.addActionListener(this);
		NewE.add(Start);
		SR = new JMenu("ElectionDetails");
		ShowRecord = new JMenuItem("ShowRecords");
		ShowRecord.addActionListener(this);
		SR.add(ShowRecord);
		help = new JMenu("Help");
		abtUs = new JMenuItem("About Us");
		chgPass = new JMenuItem("Change Password");
		logOut = new JMenuItem("Log out");
		ext = new JMenuItem("Exit");
		help.add(abtUs);
		help.addSeparator();
		help.add(chgPass);
		help.addSeparator();
		help.add(logOut);
		help.addSeparator();
		help.add(ext);
		abtUs.addActionListener(this);
		ext.addActionListener(this);
		chgPass.addActionListener(this);
		logOut.addActionListener(this);

		jmb.add(VI);
		jmb.add(CI);
		jmb.add(NewE);
		jmb.add(SR);
		jmb.add(help);
		setJMenuBar(jmb);
		
		cont.add(background);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		});
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		setLocation(0, 0);
		setSize(screenSize.width, screenSize.height);
		// setLocation(10,10);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent ae) {
		try {
			if (ae.getSource() == vCreate) {
				l.setText("You have selected create record option....");
				new CreateVoterInfo();
				dispose();
			} else if (ae.getSource() == vModify) {
				l.setText("You have selected Modify record option....");
				new ModifyVoterInfo();
				dispose();
			} else if (ae.getSource() == vDelete) {
				l.setText("You have selected delete record option....");
				new DeleteVoterInfo();
				dispose();
			} else if (ae.getSource() == vShow) {
				l.setText("You have selected show record option....");
				new ShowVoterInfo();
				dispose();
			} else if (ae.getSource() == cCreate) {
				l.setText("You have selected create record option....");
				new CreateCandidateInfo();
				dispose();
			} else if (ae.getSource() == cModify) {
				l.setText("You have selected modify record option....");
				new ModifyCandidateInfo();
				dispose();
			} else if (ae.getSource() == cDelete) {
				l.setText("You have selected delete record option....");
				new DeleteCandidateInfo();
				dispose();
			} else if (ae.getSource() == cShow) {
				l.setText("You have selected show record option....");
				sci = new ShowCandidateInfo();
				dispose();
			}

			else if (ae.getSource() == Start) {
				new NewElection();
				dispose();
				l.setText("You have selected start option....");
			} else if (ae.getSource() == ShowRecord) {
				new ElectionDetails();
				dispose();
				l.setText("You have selected Show Election record option....");
			} else if (ae.getSource() == abtUs) {

				JOptionPane
						.showMessageDialog(
								ShowMenu.this,
								"Developed By--           :\n \n\t                 R O H I T\n                S H E L A R            \n ",
								"About Us", JOptionPane.OK_OPTION);

			} else if (ae.getSource() == chgPass) {
				try { // Load the driver
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				String Lid = JOptionPane.showInputDialog(ShowMenu.this,
						"Current Login Id", "Change Password",
						JOptionPane.OK_OPTION);
				String pas = JOptionPane.showInputDialog(ShowMenu.this,
						"Current password", "Change Password",
						JOptionPane.OK_OPTION);
				try {
					// Establish the connection.
					con = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/VotingDB", "root",
							"root");
					System.out.println("Connection Established!!");
					// Create Statement
					stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
					// Obtain the resultset
					rs = stmt
							.executeQuery("select * from Admin where LoginId = '"
									+ Lid + "' and Password = '" + pas + "'");
					if (rs.next()) {
						String Lid1 = JOptionPane.showInputDialog(
								ShowMenu.this, "New Login Id",
								"Change Password", JOptionPane.OK_OPTION);
						String pas1 = JOptionPane.showInputDialog(
								ShowMenu.this, "New password",
								"Change Password", JOptionPane.OK_OPTION);
						int s = stmt
								.executeUpdate("update Admin set LoginID = '"
										+ Lid1 + "' , Password = '" + pas1
										+ "' where Password = '" + pas + "'");
					} else {
						JOptionPane.showMessageDialog(ShowMenu.this,
								"Sorry \n please try again......",
								"Login fails...", JOptionPane.OK_OPTION);
					}
				} catch (Exception e) {

				}
			}// change pass over
			else if (ae.getSource() == logOut) {
				new Login();
				dispose();
			} else if (ae.getSource() == ext) {
				JOptionPane.showMessageDialog(ShowMenu.this,
						"Thank You....\n\tHave a nice day....", "Exit message",
						JOptionPane.OK_OPTION);
				System.exit(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ShowMenu();
	}
}