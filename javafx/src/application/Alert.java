package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.InputEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Alert {

	static void display(String title,String msg) {
	Stage window=new Stage();
	window.initModality(Modality.APPLICATION_MODAL);
	window.setTitle(title);
	window.setMaxWidth(220);
	
	Label label = new Label();
	label.setText(msg);
	
	Button close = new Button("close");
	close.setOnAction(e -> window.close());
	
	VBox layout = new VBox(10);
	layout.getChildren().setAll(label,close);
	layout.setAlignment(Pos.CENTER);
	
	Scene scene = new Scene(layout);
	window.setScene(scene);
	window.showAndWait();
	

	}
}
