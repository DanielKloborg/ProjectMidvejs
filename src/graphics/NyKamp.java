package graphics;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NyKamp extends Application {

	public void start(Stage stage)
	{
	Label lbl = new Label("NyKamp");
	BorderPane bp = new BorderPane();
	bp.setCenter(lbl);

	Label label2= new Label("Opret ny kamp");
	Button button2= new Button("Go to scene 1");
	
	button2.setOnAction(e-> {
		HovedMenu firstWindow = new HovedMenu();
		try {
			firstWindow.start(stage);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	});
	
	VBox layout2= new VBox(20);
	layout2.getChildren().addAll(label2, button2);
	Scene Scene2 = new Scene(layout2,300,250);
	
	//Scene scene = new Scene(bp, 500, 500);
	stage.setScene(Scene2);
	stage.show();

	}
}
