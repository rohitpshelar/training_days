package com.pro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Student extends Batch {
	Corse cc = new Corse();
	ArrayList<Corse> array = (ArrayList<Corse>) cc.getArray();

	Faculty ff = new Faculty();
	ArrayList<Faculty> array1 = (ArrayList<Faculty>) ff.getArray1();

	Batch bb = new Batch();
	ArrayList<Batch> array2 = (ArrayList<Batch>) bb.getArray2();

	static ArrayList<Student> array3 = new ArrayList<Student>();

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	private String sid;
	private String sname;
	private Batch batch;

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public void case1() {
		s2 = new Scanner(System.in);
		System.out.println("Enter 1 to Enter Software OR 0 to EXIT");
		int a = s2.nextInt();
		Student cou1 = new Student();
		switch (a) {
		case 1:
			cou1.case2();
			break;

		case 0:
			System.out.println("THANK YOU");
			System.exit(0);
			break;
		}
	}

	Corse c = new Corse();
	Faculty f = new Faculty();
	Batch b = new Batch();

	static Student cou = new Student();

	private Scanner s;

	private Scanner s2;

	public void case2() {
		s = new Scanner(System.in);
		System.out.println("");
		System.out.println("******OPTIONS*****");
		System.out.println("Press 1.===== Insert Course");
		System.out.println("Press 2.===== Display Course");
		System.out.println("Press 3.===== Insert Faculty");
		System.out.println("Press 4.===== Display Faculty");
		System.out.println("Press 5.===== Insert Batch");
		System.out.println("Press 6.===== Display Batch");
		System.out.println("Press 7.===== Insert Student");
		System.out.println("Press 8.===== Display Student");
		System.out.println("Press 9.===== SEARCH");
		System.out.println("Press 10===== EXIT OPTION");

		int ib = s.nextInt();
		switch (ib) {
		case 1:
			try {
				c.insert();
				c.display();
				cou.case2();
				break;

			} catch (Exception e) {
				System.out.println("**NOTE:Enter PROPER  FIELD (1 CHANCE)*");
				try {
					c.insert();
				} catch (Exception e1) {
					System.out.println("**NOTE:Enter PROPER FIELD (2 CHANCE)*");
					c.insert();
				}
			}

		case 2:
			c.display();
			cou.case2();
			break;

		case 3:
			f.insertf();
			f.displayf();
			cou.case2();
			break;

		case 4:
			f.displayf();
			cou.case2();
			break;

		case 5:
			b.insertB();
			b.displayB();
			cou.case2();
			break;

		case 6:
			b.displayB();
			cou.case2();
			break;

		case 7:
			cou.insertS();
			cou.displayS();
			cou.case2();
			break;

		case 8:
			cou.displayS();
			cou.case2();
			break;

		case 9:
		//	cou.Search(s.nextLine());
			cou.case2();
			break;

		case 10:
			cou.case1();
			break;
		}
	}

/*	public static void main(String[] args) {
		Student s = new Student();

		s.case1();
	}*/

	static String sis;
	static int count;
	static Connection con2;
	static	int noOfLineb ;
	static String is;
	
	public void insertS() {

		
		
		s = new Scanner(System.in);

		try {

			Stage window = new Stage();
			window.initModality(Modality.APPLICATION_MODAL);
			window.setTitle("title");
			window.setMinWidth(600);
			window.setMinHeight(400);

			Button close = new Button("Submit");
			// close.setOnAction(e -> window.close());
		

			VBox layout = new VBox(10);

			layout.setAlignment(Pos.CENTER);
			Label label = new Label("How many No. of Student you want to enter:");
			layout.getChildren().add(label);	

			TextField tf = new TextField();
			tf.setPromptText("eg:1");
			tf.setMaxWidth(80);
			layout.getChildren().add(tf);
			close.setOnAction(e -> {
				noOfLineb =Integer.parseInt( tf.getText());
				window.close();

			});
			layout.getChildren().add(close);
			layout.setAlignment(Pos.CENTER);
			Scene scene = new Scene(layout);
			window.setScene(scene);
			window.showAndWait();
			System.out.println(noOfLineb);

			for (int i = 1; i <= noOfLineb; i++) {

				Stage window2 = new Stage();
				window2.initModality(Modality.APPLICATION_MODAL);
				window2.setTitle("title");
				window2.setMinWidth(600);
				window2.setMinHeight(400);

				

				VBox layout2 = new VBox(10);

				layout2.setAlignment(Pos.CENTER);
				Label label2i = new Label("Your Student ID is:");
				layout2.getChildren().add(label2i);
				
				ConnectionProject connectionProject = new ConnectionProject();
				con = ConnectionProject.connectionProjectMethod();
				String sql = "SELECT * FROM `project`.`student` LIMIT 0, 30; ";
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();

				count = 0;
				is = "s0" + count;

				while (rs.next()) {
					if (is.equals(rs.getString(1))) {
						is = "s0" + count;
					}
					is = "s0" + count++;
				}
				is = "s0" + count;

				System.out.println(is);
				Label label3i = new Label(is);
				layout2.getChildren().add(label3i);

				Label label4i = new Label("Enter "+is+" Student name:");
				layout2.getChildren().add(label4i);
				
				TextField tf2 = new TextField();
				tf2.setPromptText("eg:1");
				tf2.setMaxWidth(80);
				layout2.getChildren().add(tf2);
				Button closeshow = new Button("SHOW Batch");
				// close.setOnAction(e -> window.close());
				closeshow.setOnAction(e -> b.displayB());
				layout2.getChildren().add(closeshow);

				Label label5i = new Label("Allocate  Batch ID to  "+is+"   from above  :");
				layout2.getChildren().add(label5i);
				TextField tf2s = new TextField();
				tf2s.setPromptText("eg:  b01 or b02");
				tf2s.setMaxWidth(80);
				layout2.getChildren().add(tf2s);

				Button close2 = new Button("Submit");
				// close.setOnAction(e -> window.close());
				close2.setOnAction(e -> {

					window2.close();
					count = 0;

				});
				layout2.getChildren().add(close2);
				layout2.setAlignment(Pos.CENTER);
				Scene scene2 = new Scene(layout2);
				window2.setScene(scene2);
				window2.showAndWait();

				ConnectionProject connectionProjects = new ConnectionProject();
				con = ConnectionProject.connectionProjectMethod();
				String sqls = "SELECT * FROM `batch` JOIN `faculty` ON `batch`.`fid`=`faculty`.`fid` JOIN `course` ON `faculty`.`cid`=`course`.`cid` ; ";
				PreparedStatement pss = con.prepareStatement(sqls);
				ResultSet rss = pss.executeQuery();
		
				sis =  tf2s.getText();
				String sa = tf2.getText();
				Student s = new Student();
				s.setSid(is);// 1111
				s.setSname(sa);// 2222

				while (rss.next()) {

					Batch b = new Batch();
					b.setBid(rss.getString(1));
					b.setBname(rss.getString(2));
					Faculty f = new Faculty();
					f.setFid(rss.getString(3));
					f.setFname(rss.getString(5));
					Corse c = new Corse();
					c.setId(rss.getString(7));
					c.setName(rss.getString(8));
					b.setFaculty(f);
					f.setCorse(c);

					array2.add(b);

				}

				Iterator<Batch> iter2 = array2.iterator();
				while (iter2.hasNext()) {
					Batch bb = iter2.next();

					if (bb.getBid().equals(sis)) {

						s.setBatch(bb);// 3333

						ConnectionProject connectionProject2 = new ConnectionProject();
						con2 = ConnectionProject.connectionProjectMethod();
						String sql2 = "INSERT INTO `project`.`student` (`sid`, `sname`, `bid`) VALUES (?,?,?);";
						PreparedStatement ps2 = con2.prepareStatement(sql2);
						ps2.setString(1, is);
						ps2.setString(2, sa);
						ps2.setString(3, bb.getBid());
						ps2.executeUpdate();
						con2.close();

						array3.add(s);

					}
				}
				count = 0;
				System.out.println("*@" + sa + " entry SAVED@*");
			}
		} catch (Exception e) {
			s = new Scanner(System.in);

		}
	}

	public void displayS() {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("********DETAILED Student   DISPLAY ********");
		window.setMinWidth(600);
		window.setMinHeight(400);

		Button close = new Button("Back");
		// close.setOnAction(e -> window.close());
		close.setOnAction(e -> {

			window.close();
			
		});
		
		VBox layout = new VBox(10);
		
		layout.setAlignment(Pos.CENTER);
		Label label = new Label();
		label.setText("-----------********DETAILED Student   DISPLAY ********---------------");
		layout.getChildren().add(label);
		Label label1 = new Label("");
		layout.getChildren().add(label1);
		Label label2 = new Label("Student ID     Student Name   Batch Name    Faculty Name    Course Name ");
		layout.getChildren().add(label2);
		try {
			ConnectionProject connectionProjects = new ConnectionProject();
			con3 = ConnectionProject.connectionProjectMethod();
			System.out.println("");

			String sqls = "SELECT * FROM `student` JOIN `batch` ON `batch`.`bid`=`student`.`bid` JOIN `faculty` ON `batch`.`fid`=`faculty`.`fid` JOIN `course` ON `faculty`.`cid`=`course`.`cid` ;";
			PreparedStatement pss = con3.prepareStatement(sqls);
			ResultSet rss = pss.executeQuery();
			while (rss.next()) {

				Label label3 = new Label(rss.getString(1) + "                      " + rss.getString(2)
						+ "                       " + rss.getString(5) + "                        " + rss.getString(8)
						+ "                        " + rss.getString(11));
				
				layout.getChildren().add(label3);
			}
		} catch (Exception e) {
			System.out.println("in catch");
			e.printStackTrace();
		}
		Label label4 = new Label("--------------------------------------------------------------------------");
		layout.getChildren().add(label4);
		layout.getChildren().add(close);
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}

	static String search;

	public void Search( ) {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("title");
		window.setMinWidth(600);
		window.setMinHeight(400);

		

		

	
	//	System.out.println(inputedText);
	
		VBox layout = new VBox(10);
	
		layout.setAlignment(Pos.CENTER);
		Label label = new Label();
		label.setText("Enter of Student OR Faculty OR Course");
		layout.getChildren().add(label);
		TextField tf =new TextField();
		tf.setMaxWidth(80);
		layout.getChildren().add(tf);
		Button close = new Button("Search");
		// close.setOnAction(e -> window.close());
		close.setOnAction(e -> {
			search = tf.getText();
			window.close();
			
		});
		layout.getChildren().add(close);
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		
		
		Stage window2 = new Stage();
		window2.initModality(Modality.APPLICATION_MODAL);
		window2.setTitle("Result");
		window2.setMinWidth(600);
		window2.setMinHeight(400);

		VBox layout2 = new VBox(10);
	
		layout2.setAlignment(Pos.CENTER);
		Label label2 = new Label();
		label2.setText("Student ID     Student Name   Batch Name    Faculty Name    Course Name ");
		layout2.getChildren().add(label2);
		try {
			ConnectionProject connectionProjects2 = new ConnectionProject();
			con = ConnectionProject.connectionProjectMethod();
			String sqlse = "SELECT * FROM `student` JOIN `batch` ON `batch`.`bid`=`student`.`bid` JOIN `faculty` ON `batch`.`fid`=`faculty`.`fid` JOIN `course` ON `faculty`.`cid`=`course`.`cid` ;";
			PreparedStatement psse = con.prepareStatement(sqlse);
			ResultSet rss = psse.executeQuery();

			while (rss.next()) {
				
				
				if (search.equals(rss.getString(2)) || search.equals(rss.getString(5)) || search.equals(rss.getString(8))
						|| search.equals(rss.getString(11))) {
					Label label3 = new Label();
					label3.setText(rss.getString(1) + "                      " + rss.getString(2)
							+ "                       " + rss.getString(5) + "                        "
							+ rss.getString(8) + "                        " + rss.getString(11));
					System.out.println("----------------------------------------------------------------------");
					layout2.getChildren().add(label3);
				}

			}

		} catch (Exception e) {
			System.out.println("in catch");
			e.printStackTrace();
		}
		Label label4 = new Label("--------------------------------------------------------------------------");
		Button close2 = new Button("Back");
		// close.setOnAction(e -> window.close());
		close2.setOnAction(e -> {
			
			window2.close();
			
		});
		layout2.getChildren().add(label4);
		layout2.getChildren().add(close2);
		Scene scene2 = new Scene(layout2);
		window2.setScene(scene2);
		window2.showAndWait();

	//	cou.case2();
	}	
	
}
