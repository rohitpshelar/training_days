package com.pro;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Javafx extends Application {

	Stage window;
	Scene scene1,scene2;
	String search;
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
	window=primaryStage;
	
	Label label1 = new Label("WELCOME TO SOFTWARE");
	Button button1 = new Button("ENTER");
	Button button3 = new Button("EXIT");
	button1.setOnAction(e -> window.setScene(scene2));
	button3.setOnAction(e -> System.exit(0));
	
	//layout 1
	VBox layout1 = new VBox(20);
	layout1.getChildren().addAll(label1,button1,button3);
	layout1.setAlignment(Pos.CENTER);
	scene1=new Scene(layout1,600,400);
	
//button2
	Label label3 = new Label("*******OPTIONS********");
	Label labeli = new Label("**INSERT**");
	Label labeld = new Label("**DISPLAY**");
	Button button2 = new Button("Insert Course");
	Button button21 = new Button("Display Course");
	Button button22 = new Button("Insert Faculty");
	Button button23 = new Button("Display Faculty");
	Button button24 = new Button("Insert Batch");
	Button button25 = new Button("Display Batch");
	Button button26 = new Button("Insert Student");
	Button button27 = new Button("Display Student");
	Button button28 = new Button("Search ");
	Button button29 = new Button(" Exit");
	button29.setOnAction(e -> window.setScene(scene1));
	Student s=new Student();
	button2.setOnAction(e -> s.insert() );
	

	button21.setOnAction(e -> s.display() );
	button22.setOnAction(e -> s.insertf() );

	button23.setOnAction(e -> s.displayf());
	button24.setOnAction(e -> s.insertB() );
	
	button25.setOnAction(e -> s.displayB());
	button28.setOnAction(e -> s.Search());
	button26.setOnAction(e -> s.insertS());
	button27.setOnAction(e -> s.displayS());
	
	//layout 2
/*	VBox layout2 = new VBox(10);
	layout2.getChildren().addAll(label3,button2,button21,button22,button23,button24,button25,button26,button27,button28,button29);
	layout2.setAlignment(Pos.CENTER);
	scene2=new Scene(layout2,600,400);*/
	VBox layout = new VBox(10);
	HBox h = new HBox(18);

	
	VBox layoutl = new VBox(10);
	layoutl.getChildren().addAll(labeli,button2,button22,button24,button26);
	layoutl.setAlignment(Pos.CENTER);
	VBox layoutr = new VBox(10);
	layoutr.getChildren().addAll(labeld,button21,button23,button25,button27);
	layoutr.setAlignment(Pos.CENTER);
		
	/*h.setLeft(layoutl);
	h.setRight(layoutr);*/
	
	h.getChildren().addAll(layoutl,layoutr);
	h.setAlignment(Pos.CENTER);

	layout.getChildren().addAll(label3,h,button28,button29);
	layout.setAlignment(Pos.CENTER);
	scene2=new Scene(layout,600,400);
	window.setScene(scene1);
	window.setTitle("ROHIT PROJECT");
	window.show();
	
	
	}

}
