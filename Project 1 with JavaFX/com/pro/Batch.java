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

public class Batch extends Faculty {

	static Batch b = new Batch();
	Corse cc = new Corse();

	ArrayList<Corse> array = (ArrayList<Corse>) cc.getArray();

	Faculty ff = new Faculty();
	ArrayList<Faculty> array1 = (ArrayList<Faculty>) ff.getArray1();

	static ArrayList<Batch> array2 = new ArrayList<Batch>();

	public ArrayList<Batch> getArray2() {
		return array2;
	}

	private String bid;
	private String bname;
	private Faculty faculty;

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	String bis;
	static int count;
	static String is;
	Faculty f = new Faculty();
	private Scanner s;
	static Connection con2;
static	int noOfLineb ;
	public void insertB() {

		

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
			Label label = new Label("How many No. of Batch you want to enter:");
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
		System.out.println(noOfLine);
		
			for (int i = 1; i <= noOfLineb; i++) {

				Stage window2 = new Stage();
				window2.initModality(Modality.APPLICATION_MODAL);
				window2.setTitle("title");
				window2.setMinWidth(600);
				window2.setMinHeight(400);

				

				VBox layout2 = new VBox(10);

				layout2.setAlignment(Pos.CENTER);
				Label label2i = new Label("Your Batch ID is:");
				layout2.getChildren().add(label2i);
				
				ConnectionProject connectionProject = new ConnectionProject();
				con = ConnectionProject.connectionProjectMethod();
				String sql = "SELECT * FROM `project`.`batch` LIMIT 0, 30; ";
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();

				count = 0;
				is = "b0" + count;
				while (rs.next()) {
					if (is.equals(rs.getString(1))) {
						is = "b0" + count;
					}
					is = "b0" + count++;
				
				}
				is = "b0" + count++;
				is = "b0" + count++;
				System.out.println(is);
				Label label3i = new Label(is);
				layout2.getChildren().add(label3i);
				
				
				Label label4i = new Label("Enter "+is+" Batch name for " + is + ":");
				layout2.getChildren().add(label4i);
				
				
			
				TextField tf2 = new TextField();
				tf2.setPromptText("eg:1");
				tf2.setMaxWidth(80);
				layout2.getChildren().add(tf2);
				Button closeshow = new Button("SHOW Faculty");
				// close.setOnAction(e -> window.close());
				closeshow.setOnAction(e -> b.displayf());
				layout2.getChildren().add(closeshow);

				Label label5i = new Label("Allocate  Faculty ID   from above  list:");
				
				layout2.getChildren().add(label5i);
				TextField tf2s = new TextField();
				tf2s.setPromptText("eg:  f01 or f02");
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
				
				
				
				bis = tf2s.getText();
				String bbis = bis;

				try {
					ConnectionProject connectionProjects = new ConnectionProject();
					con3 = ConnectionProject.connectionProjectMethod();
					String sqls = "SELECT * FROM `faculty` INNER JOIN `course` ON `faculty`.`cid`=`course`.`cid` LIMIT 0, 1000;";
					PreparedStatement pss = con3.prepareStatement(sqls);
					ResultSet rss = pss.executeQuery();

					String sa = tf2.getText();
					Batch b = new Batch();
					b.setBid(is);// 11
					b.setBname(sa);// 22

					while (rss.next()) {
						Faculty f = new Faculty();
						f.setFid(rss.getString(1));
						f.setFname(rss.getString(2));
						Corse c = new Corse();
						c.setId(rss.getString(3));
						c.setName(rss.getString(5));
						f.setCorse(c);
						array1.add(f);

					}

					Iterator<Faculty> iter = array1.iterator();
					while (iter.hasNext()) {
						Faculty ff = iter.next();

						if (ff.getFid().equals(bis)) {

							b.setFaculty(ff);// 33

							ConnectionProject connectionProject2 = new ConnectionProject();
							con2 = ConnectionProject.connectionProjectMethod();
							String sql2 = "INSERT INTO `project`.`batch` (`bid`, `bname`, `fid`) VALUES (?,?,?);";
							PreparedStatement ps2 = con2.prepareStatement(sql2);
							ps2.setString(1, is);
							ps2.setString(2, sa);
							ps2.setString(3, ff.getFid());
							ps2.executeUpdate();
							con2.close();

							array2.add(b);

						}

					}

					System.out.println("*@" + sa + " entry SAVED@*");
				} catch (Exception e) {
					System.out.println("in catch");
					e.printStackTrace();
				}

			}
		} catch (Exception e) {
			s = new Scanner(System.in);

		}

	}

	public void displayB() {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("********DETAILED Batch   DISPLAY ********");
		window.setMinWidth(600);
		window.setMinHeight(400);

		Button close = new Button("Back");
		// close.setOnAction(e -> window.close());
		close.setOnAction(e -> {

			window.close();

		});

		VBox layout = new VBox(10);

		layout.setAlignment(Pos.CENTER);
		Label label = new Label("-----------********DETAILED Batch   DISPLAY ********---------------");
		layout.getChildren().add(label);
		Label label1 = new Label("");
		layout.getChildren().add(label1);
		Label label2 = new Label("Batch ID     Batch Name    Faculty Name    Course Name ");
		layout.getChildren().add(label2);

		try {
			ConnectionProject connectionProjects = new ConnectionProject();
			con3 = ConnectionProject.connectionProjectMethod();
			System.out.println("");

			String sqls = "SELECT * FROM `batch` JOIN `faculty` ON `batch`.`fid`=`faculty`.`fid` JOIN `course` ON `faculty`.`cid`=`course`.`cid` ;";
			PreparedStatement pss = con3.prepareStatement(sqls);
			ResultSet rss = pss.executeQuery();
			while (rss.next()) {

				Label label3 = new Label(rss.getString(1) + "                      " + rss.getString(2)
						+ "                       " + rss.getString(5) + "                        " + rss.getString(8));
			
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
}
