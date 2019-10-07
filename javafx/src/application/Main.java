package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;


public class Main extends Application implements EventHandler<ActionEvent> {
	
	Button b,b2,b3;
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("ROHIT WINDOW");
		//	BorderPane root = new BorderPane();
			
			b=new Button("Submit");
			b.setOnAction(this);
			
			b2=new Button("CLICK");
			b2.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
				System.out.println("Annomus inter class handler");		
				}
			});
			
			b3=new Button("C");
			b3.setOnAction(e ->System.out.println("button 3 with lamda"));
			
			StackPane layout=new StackPane();
			layout.getChildren().add(b);
			layout.getChildren().add(b2);
			layout.getChildren().add(b3);
			
			Scene scene = new Scene(layout,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void handle(ActionEvent event) {
		
		if(event.getSource()==b){
			System.out.println("hi");		
		}

	}
}
