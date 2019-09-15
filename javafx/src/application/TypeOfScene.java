package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TypeOfScene extends Application {

	Stage window;
	Scene scene1,scene2;
	
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
	Button button2 = new Button("INSERT COURSE");
	Button button21 = new Button("DISPLAY COURSE");
	Button button22 = new Button("INSERT FACULTY");
	Button button23 = new Button("DISPLAY FACULTY");
	button2.setOnAction(e -> window.setScene(scene1));
	button21.setOnAction(e -> Alert.display("tile","woow"));
	
	//layout 2
	VBox layout2 = new VBox(10);
	layout2.getChildren().addAll(label3,button2,button21,button22,button23);
	layout2.setAlignment(Pos.CENTER);
	scene2=new Scene(layout2,600,400);
	
	window.setScene(scene1);
	window.setTitle("ROHIT PROJECT");
	window.show();
	
	
	}

}
