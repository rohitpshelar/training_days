package com.pro;

import java.awt.print.Printable;
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

public class Faculty extends Corse {
	Corse cc = new Corse();

	ArrayList<Corse> array = (ArrayList<Corse>) cc.getArray();

	static ArrayList<Faculty> array1 = new ArrayList<Faculty>();

	public ArrayList<Faculty> getArray1() {
		return array1;
	}

	public ArrayList<Corse> getArray() {
		return array;
	}

	Scanner s = new Scanner(System.in);

	static Faculty cou = new Faculty();

	static String fis;

	private String fid;

	private String fname;

	private Corse corse;

	public Corse getCorse() {
		return corse;
	}

	public void setCorse(Corse corse) {
		this.corse = corse;
	}

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	Corse c = new Corse();

	private Scanner s2;
	static int count;
	static int noOfLine;
	static Connection con2;
	static String is;

	public void insertf() {

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
			Label label = new Label("How many No. of Faculty you want to enter:");
			layout.getChildren().add(label);

			TextField tf = new TextField();
			tf.setPromptText("eg:1");
			tf.setMaxWidth(80);
			layout.getChildren().add(tf);
			close.setOnAction(e -> {
				noOfLine = Integer.parseInt(tf.getText());
				window.close();

			});
			layout.getChildren().add(close);
			layout.setAlignment(Pos.CENTER);
			Scene scene = new Scene(layout);
			window.setScene(scene);
			window.showAndWait();
			System.out.println(noOfLine);

			for (int i = 1; i <= noOfLine; i++) {
				Stage window2 = new Stage();
				window2.initModality(Modality.APPLICATION_MODAL);
				window2.setTitle("title");
				window2.setMinWidth(600);
				window2.setMinHeight(400);

				VBox layout2 = new VBox(10);

				layout2.setAlignment(Pos.CENTER);
				Label label2i = new Label("Your Faculty ID is:");
				layout2.getChildren().add(label2i);

				ConnectionProject connectionProject = new ConnectionProject();
				con = ConnectionProject.connectionProjectMethod();
				String sql = "SELECT * FROM `project`.`faculty` LIMIT 0, 30; ";
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();

				count = 0;
				is = "f0" + count;
				while (rs.next()) {
					if (is.equals(rs.getString(1))) {
						is = "f0" + count;
					}
					is = "f0" + count++;
				}

				is = "f0" + count;

				Label label3i = new Label(is);
				layout2.getChildren().add(label3i);

				count = 0;
				Label label4i = new Label("Enter Faculty name for " + is + ":");
				layout2.getChildren().add(label4i);

				TextField tf2 = new TextField();
				tf2.setPromptText("eg:1");
				tf2.setMaxWidth(80);
				layout2.getChildren().add(tf2);
				Button closeshow = new Button("SHOW COURSE");
				// close.setOnAction(e -> window.close());
				closeshow.setOnAction(e -> c.display());
				layout2.getChildren().add(closeshow);

				Label label5i = new Label("Allocate  Courde ID  to " + sa + "  from above  :");
				layout2.getChildren().add(label5i);
				TextField tf2s = new TextField();
				tf2s.setPromptText("eg:  c01 or c02");
				tf2s.setMaxWidth(80);
				layout2.getChildren().add(tf2s);

				Button close2 = new Button("Submit");
				// close.setOnAction(e -> window.close());
				close2.setOnAction(e -> {

					window2.close();

				});
				layout2.getChildren().add(close2);
				layout2.setAlignment(Pos.CENTER);
				Scene scene2 = new Scene(layout2);
				window2.setScene(scene2);
				window2.showAndWait();
				
				
				fis = tf2s.getText();
				String sa = tf2.getText();

				Faculty fi = new Faculty();
				fi.setFid(is);// 1
				fi.setFname(sa);// 2

				ConnectionProject connectionProject3 = new ConnectionProject();
				con = ConnectionProject.connectionProjectMethod();
				String sql3 = "SELECT * FROM `project`.`course` LIMIT 0, 30; ";
				PreparedStatement ps3 = con.prepareStatement(sql3);
				ResultSet rs3 = ps3.executeQuery();

				while (rs3.next()) {
					Corse c = new Corse();
					c.setId(rs3.getString(1));
					c.setName(rs3.getString(2));
					array.add(c);
				}

				Iterator<Corse> itr = array.iterator();// =====
				while (itr.hasNext()) {
					Corse cc = itr.next();
					if (cc.getId().equals(fis)) {
						fi.setCorse(cc);// 3

						ConnectionProject connectionProject2 = new ConnectionProject();
						con2 = ConnectionProject.connectionProjectMethod();
						String sql2 = "INSERT INTO `project`.`faculty` (`fid`, `fname`, `cid`) VALUES (?, ?,?);";
						PreparedStatement ps2 = con2.prepareStatement(sql2);
						ps2.setString(1, is);
						ps2.setString(2, sa);
						ps2.setString(3, cc.getId());
						ps2.executeUpdate();
						con2.close();

						array1.add(fi);
					}

				}

				System.out.println(array1);
				System.out.println("*@" + sa + " entry SAVED@*");

			}
		} catch (Exception e) {
			System.out.println("in ff catch");
			s2 = new Scanner(System.in);
			// flag = false;
		}

		/*
		 * } catch (Exception e) { System.out.println("in F catch");
		 */

	}

	Connection con3;

	public void displayf() {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("********DETAILED  Faculty  DISPLAY ********");
		window.setMinWidth(600);
		window.setMinHeight(400);

		Button close = new Button("Back");
		// close.setOnAction(e -> window.close());
		close.setOnAction(e -> {

			window.close();

		});

		VBox layout = new VBox(10);

		layout.setAlignment(Pos.CENTER);
		Label label = new Label("-----------********DETAILED  Faculty  DISPLAY ********---------------");
		layout.getChildren().add(label);
		Label label1 = new Label("");
		layout.getChildren().add(label1);
		Label label2 = new Label("courseID    courseNAME  FacultyID    FacultyNAME ");
		layout.getChildren().add(label2);
		try {
	//		ConnectionProject connectionProjects = new ConnectionProject();
			con3 = ConnectionProject.connectionProjectMethod();
			String sqls = "SELECT * FROM `faculty` INNER JOIN `course` ON `faculty`.`cid`=`course`.`cid` LIMIT 0, 1000;";
			PreparedStatement pss = con3.prepareStatement(sqls);
			ResultSet rss = pss.executeQuery();

			while (rss.next()) {

				Label label3 = new Label(rss.getString(3) + "                      " + rss.getString(5)
						+ "                       " + rss.getString(1) + "                        " + rss.getString(2));
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
