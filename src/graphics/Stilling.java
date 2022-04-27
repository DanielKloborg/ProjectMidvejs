package graphics;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

	public class Stilling extends Application{

	public void start(Stage stage)
	{
		GridPane grid = new GridPane();
			grid.setAlignment(Pos.TOP_LEFT);
			grid.setHgap(1);
			grid.setVgap(1);

	Label label2= new Label("Stilling");
		label2.setFont(new Font(20));
		grid.add(label2, 50, 0, 10, 10);
	
	stage.setTitle("Håndbold Liga");
	
	
	TableView stilling = new TableView();

    TableColumn column1 = new TableColumn<>("Hold");
    column1.setCellValueFactory(new PropertyValueFactory<>("Hold"));


    TableColumn column2 = new TableColumn<>("W");
    column2.setCellValueFactory(new PropertyValueFactory<>("W"));
    
    TableColumn column3 = new TableColumn<>("L");
    column3.setCellValueFactory(new PropertyValueFactory<>("L"));
    
    TableColumn column4 = new TableColumn<>("U");
    column4.setCellValueFactory(new PropertyValueFactory<>("U"));
    
    TableColumn column5 = new TableColumn<>("P");
    column5.setCellValueFactory(new PropertyValueFactory<>("P"));


    stilling.getColumns().add(column1);
    stilling.getColumns().add(column2);
    stilling.getColumns().add(column3);
    stilling.getColumns().add(column4);
    stilling.getColumns().add(column5);

	
    grid.add(stilling, 50, 20, 20, 20);
	
    
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