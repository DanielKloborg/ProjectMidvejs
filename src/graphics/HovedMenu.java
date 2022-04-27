package graphics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.*;

public class HovedMenu extends Application {
	
	public static void main(String[] args) {
        launch(args);
    }
	
	private static int appWidth = 200 * 3;
    private static int appHeight = 310 * 3;
    private static int numRows = 7;
    private static int numCols = 8;

    public void start(Stage firstWindow) throws Exception {
	
    	// knapper
    	Button NyKamp = new Button("Ny Kamp");
	    NyKamp.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	    NyKamp.setOnAction(e-> {
	    	NyKamp secondWindow = new NyKamp();
	    	secondWindow.start(firstWindow);
	    });
	
	    Button Hold = new Button("Hold");
	    Hold.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	    Hold.setOnAction(e-> {
	    	Hold secondWindow = new Hold();
	        secondWindow.start(firstWindow);
	    });
	        
	    Button Rapport = new Button("Kamp Rapporter");
	    Rapport.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	    Rapport.setOnAction(e-> {
	    	Rapporter secondWindow = new Rapporter();
	        secondWindow.start(firstWindow);
	        });
	        
	    Button Stilling = new Button("Stilling");
	    Stilling.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	    Stilling.setOnAction(e-> {
	    	Stilling secondWindow = new Stilling();
	        secondWindow.start(firstWindow);
	    });
	        
	    //Screen label
	    Text screen = new Text("Håndbold");
	    screen.setFont(new Font(50));
	    VBox Text = new VBox();
	    Text.getChildren().addAll(screen);
	       
	
	    //Create GridPane
	    GridPane grid = new GridPane();
	    grid.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	        
	
	    //Add nodes to grid pane
	    grid.add(Text, 2, 1, 4, 1);
	    grid.add(NyKamp, 2, 2, 4, 1);
	    grid.add(Hold, 2, 3, 4, 1);
	    grid.add(Rapport, 2, 4, 4, 1);
	    grid.add(Stilling, 2, 5, 4, 1);
	        
	
	    //Set row and column constraints
	    for (int rowIndex = 0; rowIndex < HovedMenu.numRows; rowIndex++) {
	    	RowConstraints rc = new RowConstraints();
	        rc.setVgrow(Priority.ALWAYS);
	        rc.setFillHeight(true);
	        rc.setPercentHeight(HovedMenu.appHeight / HovedMenu.numRows);
	        grid.getRowConstraints().add(rc);
	        }
	    for (int colIndex = 0; colIndex < HovedMenu.numCols; colIndex++) {
	        ColumnConstraints cc = new ColumnConstraints();
	        cc.setHgrow(Priority.ALWAYS);
	        cc.setFillWidth(true);
	        cc.setPercentWidth(HovedMenu.appWidth / HovedMenu.numCols);
	        grid.getColumnConstraints().add(cc);
	    }
	
	    grid.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

	    Scene scene = new Scene(grid, appWidth, appHeight);
	    firstWindow.setScene(scene);
	    firstWindow.setTitle("HåndboldLiga");
	    firstWindow.setResizable(false);
	    firstWindow.show();
    } 
}