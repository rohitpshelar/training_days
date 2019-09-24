package com.rohit;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;


public class Login implements ActionListener,KeyListener {
	public static void main(String[] args) {
		new Login();
		
	}

	JLabel l1, l2, l3;
	JComboBox t1;
	JButton si;
	JPasswordField t2;
	JFrame f1 = new JFrame("Login window");
	
	JDesktopPane jdp = new JDesktopPane();
	
	ImageIcon img;

	public Login() {

		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		f1.setSize(380, 200);
		f1.setLocation(screenSize.width / 3, screenSize.height / 3);
		f1.setLayout(null);
		f1.setResizable(false);
		
		
		

		l1 = new JLabel("User Name :");
		l2 = new JLabel("Password :");
		t1 = new JComboBox();
		t1.addItem("Administrator");
		t1.addItem("User");
		t2 = new JPasswordField();
		si = new JButton("Login");
		si.addActionListener(this);
		f1.add(l1);
		f1.add(t1);
		f1.add(l2);
		
		f1.add(t2);
		f1.add(si);
		// new
		// ImageIcon(Frame.class.getResource("src/com/rohit/resources/lock1.gif"));
		img = new ImageIcon(
				Frame.class.getResource("/com/rohit/resources/lock1.gif"));
		// img=new ImageIcon("src/com/rohit/resources/lock1.gif");
		l3 = new JLabel("", img, JLabel.RIGHT);
		l1.setBounds(20, 25, 82, 25);
		t1.setBounds(120, 25, 145, 25);
		l2.setBounds(20, 80, 82, 25);
		t2.setBounds(120, 80, 145, 25);
		si.setBounds(140, 125, 80, 35);
		l3.setBounds(278, 20, 99, 99);
		f1.add(l3);
		f1.setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		String s = arg0.getActionCommand();
	
		if (t1.getSelectedItem().equals("User")) // cheaks User Name
		{
			char pa[] = { 'u', 's', 'e','r'};

			char p[] = t2.getPassword();
			int count = 0;
			for (int i = 0; i < p.length; i++) // it Cheaks Password
			{
				count++;
				if (p[i] != pa[i]) {
					JDesktopPane Jdp = new JDesktopPane();
					JOptionPane.showMessageDialog(Jdp,
							"InCorrect Password !!!", "Error !!!",
							JOptionPane.ERROR_MESSAGE);
					// System.exit(0);
					break;
				}
				if (count == 4) {
					if (s.equals("Login")) // it cheak Action
					{
						
						ShowMenu mw = new ShowMenu();
						f1.setVisible(false);

					}
				}
			}
		}
		if (t1.getSelectedItem().equals("Administrator")) // cheaks User Name
		{
			char pa[] = { 'r', 'o', 'h', 'i', 't' };

			char p[] = t2.getPassword();
			int count = 0;
			for (int i = 0; i < p.length; i++) // it Cheaks Password
			{
				count++;
				if (p[i] != pa[i]) {
					JDesktopPane Jdp = new JDesktopPane();
					JOptionPane.showMessageDialog(Jdp,
							"InCorrect Password !!!", "Error !!!",
							JOptionPane.ERROR_MESSAGE);
					// System.exit(0);
					break;
				}
				if (count == 5) {
					if (s.equals("Login")) // it cheak Action
					{
						
						ShowMenu mw = new ShowMenu();
						f1.setVisible(false);

					}
				}
			}
		}
	}

	public void keyPressed(KeyEvent e) {
		System.out.println("press");
		
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



}
