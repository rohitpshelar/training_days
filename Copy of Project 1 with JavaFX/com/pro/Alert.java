package com.pro;

import java.awt.*;

public class Alert {
	 static String inputedText;

	public static String getInputedText() {
		return inputedText;
	}

	static void display(String title, String msg) {
		Stage window = new Stage();
		window.initModality(ModalityType.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(300);
		window.setMinHeight(150);

		Label label = new Label();
		label.setText(msg);

		// input
		TextField input = new TextField();
		input.setText("eg:1");

		Button close = new Button("Submit");
		// close.setOnAction(e -> window.close());
		close.setOnAction(e -> {
			inputedText = input.getText();
	//		System.out.println(input.getText());
	//		System.out.println(inputedText);
			window.close();
			
		});

		

		VBox layout = new VBox(10);
		layout.getChildren().setAll(label, input, close);
		layout.setAlignment(Pos.CENTER);

		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	//	System.out.println(inputedText);
	
		
	}
}
