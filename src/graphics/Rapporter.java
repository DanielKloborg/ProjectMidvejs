package graphics;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

	public class Rapporter extends Application{

	public void start(Stage stage)
	{
		GridPane grid = new GridPane();
			grid.setAlignment(Pos.TOP_LEFT);
			grid.setHgap(1);
			grid.setVgap(1);

	Label label2= new Label("Kamprapporter");
		label2.setFont(new Font(20));
		grid.add(label2, 50, 0, 10, 10);
	
	stage.setTitle("Håndbold Liga");
	
	VBox vboxForButtons = new VBox(5);
	for(int i=0; i<10; i++){
	    Button btnNumber = new Button();
	    btnNumber.setText("Det her er kamp " + String.valueOf(i));
	    btnNumber.setOnAction((ActionEvent)->{
	        System.out.println(btnNumber.getText());
	    });
	    vboxForButtons.getChildren().add(btnNumber);
	}
	
	grid.add(vboxForButtons, 50, 20, 10, 10);
	
	Button tilbage= new Button("Tilbage");
	tilbage.setOnAction(e-> {
		HovedMenu firstWindow = new HovedMenu();
		try {
			firstWindow.start(stage);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		});
	HBox hbTilbage = new HBox(5);
		tilbage.setMinSize(90, 30);
		hbTilbage.setAlignment(Pos.BOTTOM_LEFT);
		hbTilbage.getChildren().add(tilbage);
	grid.add(hbTilbage, 50, 10, 50, 70);
	
	
	Scene scene = new Scene(grid, 500, 550);
	stage.setScene(scene);
	stage.show();
	
	}
}
