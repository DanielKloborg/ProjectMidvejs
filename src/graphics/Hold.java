package graphics;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

	public class Hold extends Application{

	public void start(Stage stage)
	{
		GridPane grid = new GridPane();
			grid.setAlignment(Pos.TOP_LEFT);
			grid.setHgap(1);
			grid.setVgap(1);

	Label label2= new Label("Hold");
		label2.setFont(new Font(20));
		grid.add(label2, 50, 0, 10, 10);
	
	stage.setTitle("Håndbold Liga");
	
	TextField tfHold = new TextField(); 
	Button Opret = new Button("Opret");
	Opret.setOnAction(e-> {
		
		});
	HBox hbOpret = new HBox(5);
		hbOpret.setMinSize(90, 30);
		hbOpret.setAlignment(Pos.TOP_LEFT);
		hbOpret.getChildren().addAll(tfHold, Opret);
		grid.add(hbOpret, 50, 10, 10, 10);
	
	
	TableView hold = new TableView();

    TableColumn column1 = new TableColumn<>("Holdnavn");
    column1.setCellValueFactory(new PropertyValueFactory<>("Holdnavn"));

    hold.getColumns().add(column1);

	
    grid.add(hold, 50, 20, 20, 20);
	
    
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
