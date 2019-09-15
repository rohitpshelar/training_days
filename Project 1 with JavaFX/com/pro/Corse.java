package com.pro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javafx.beans.binding.ListBinding;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import com.mysql.jdbc.Statement;



public class Corse {


	
	private String id;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	static Corse c;
	static	Faculty cou = new Faculty();
	static Integer noOfLine;
	String is;
static	int count;

static	ArrayList<Corse> array = new ArrayList<Corse>();

public Scanner s;



	public ArrayList<Corse> getArray() {
		return array;
	}
static	Connection con;
static String sa;
static String howmany;
	public void insert() {
	
		try{
			Stage window = new Stage();
			window.initModality(Modality.APPLICATION_MODAL);
			window.setTitle("title");
			window.setMinWidth(600);
			window.setMinHeight(400);

			Button close = new Button("Submit");
			// close.setOnAction(e -> window.close());
		

			VBox layout = new VBox(10);

			layout.setAlignment(Pos.CENTER);
			Label label = new Label("How many No. of course you want to enter:");
			layout.getChildren().add(label);
	

		try {
			TextField tf = new TextField();
			tf.setPromptText("eg:1");
			tf.setMaxWidth(80);
			layout.getChildren().add(tf);
			close.setOnAction(e -> {
				noOfLine =Integer.parseInt( tf.getText());
				window.close();

			});
			layout.getChildren().add(close);
			layout.setAlignment(Pos.CENTER);
			Scene scene = new Scene(layout);
			window.setScene(scene);
			window.showAndWait();
			System.out.println(noOfLine);
			
		} catch (Exception e) {
			System.out.println("**NOTE:Enter PROPER FIELD (in first try)*");
		} finally {

			if (noOfLine instanceof Integer) {
				for (int i = 1; i <= noOfLine; i++) {
					Stage window2 = new Stage();
					window2.initModality(Modality.APPLICATION_MODAL);
					window2.setTitle("title");
					window2.setMinWidth(600);
					window2.setMinHeight(400);

					

					VBox layout2 = new VBox(10);

					layout2.setAlignment(Pos.CENTER);
					Label label2i = new Label("Your Course ID is:");
					layout2.getChildren().add(label2i);
					try {
						
						
						ConnectionProject connectionProject=new ConnectionProject();
						 con=ConnectionProject.connectionProjectMethod();
						String sql="SELECT * FROM `project`.`course` LIMIT 0, 30; ";
						PreparedStatement ps=con.prepareStatement(sql);
						ResultSet rs=ps.executeQuery();
						
						count=0;
						
						is = "c0"+count++;
					
						while(rs.next()){
						
						if(is.equals(rs.getString(1))){
						
							is = "c0"+count;
						}
						is = "c0"+count++;
						}
						
						count=0;
						
						Label label3i = new Label(is);
						layout2.getChildren().add(label3i);
					} catch (Exception e) {
						System.out.println("**NOTE:Enter PROPER FIELD (in Second try)*");
					} finally {
						Label label4i = new Label("Enter Course name for "+is+":");
						layout2.getChildren().add(label4i);
						
						TextField tf = new TextField();
						tf.setPromptText("eg:1");
						tf.setMaxWidth(80);
						layout2.getChildren().add(tf);
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
						
						sa = tf.getText();
						Corse c = new Corse();
						c.setId(is);
						c.setName(sa);
						
						ConnectionProject connectionProject=new ConnectionProject();
						 con=ConnectionProject.connectionProjectMethod();
						String sql="INSERT INTO `project`.`course` (`cid`, `cname`) VALUES (?, ?);";
						PreparedStatement ps=con.prepareStatement(sql);
						ps.setString(1, is);
						ps.setString(2, sa);
						ps.executeUpdate();
						con.close();
						array.add(c);
						
						
						System.out.println("*SAVED*");
					}
					close.setOnAction(e -> {
						
						window.close();

					});
				
				}
			} else {

				c.insert();
			}
		}}catch(Exception e){
			e.printStackTrace();
			System.out.println("in catch");
		}
	}

	public void display() {
	
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("********COURSE   AVAILABLE   ARE*******");
		window.setMinWidth(600);
		window.setMinHeight(400);

		Button close = new Button("Back");
		// close.setOnAction(e -> window.close());
		close.setOnAction(e -> {

			window.close();

		});

		VBox layout = new VBox(10);

		layout.setAlignment(Pos.CENTER);
		Label label = new Label("----------********COURSE   AVAILABLE   ARE*******--------------");
		layout.getChildren().add(label);
		Label label1 = new Label("");
		layout.getChildren().add(label1);
		Label label2 = new Label("ID    NAME");
		layout.getChildren().add(label2);
		try{
		ConnectionProject connectionProject=new ConnectionProject();
		 con=ConnectionProject.connectionProjectMethod();
		String sql="SELECT * FROM `project`.`course` LIMIT 0, 30; ";
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()){
			Label label3 = new Label(rs.getString(1)+"          "+rs.getString(2));
			layout.getChildren().add(label3);
		}
		}catch(Exception e)
		{
			
		}Label label4 = new Label("--------------------------------------------------------------------------");
		layout.getChildren().add(label4);
		layout.getChildren().add(close);
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();

		System.out.println("--------------------------------------------------------------------------");
	}
}
