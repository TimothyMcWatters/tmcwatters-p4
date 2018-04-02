import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author Timothy McWatters
 * @version 1.0
 * 
 * COP 4027 Advanced Computer Programming
 * Project 4
 * File Name: GUI.java
 * 
 * This Program: The idea is to create a graphical program using JavaFX 
 * that will race 5 horses across a window in Java each running a separate thread. 
 * The program will be an application that will instantiate multiple instances 
 * of RaceHorse threads. 
 * The application will run in a window that will contain three buttons:
 *		Run Race. 
 *		Reset Race. 
 *		Quit Program. 
 */

public class GUI extends Application {
	private static Image image = new Image("Horse.jpg");
	private static ArrayList<GraphicsContext> GCList = new ArrayList<GraphicsContext>();
	
	/**
	 * Accessor for the ArrayList
	 * @return ArrayList of GraphicsContexts for each horse
	 */
	public static ArrayList<GraphicsContext> getGCList() {
		return GCList;
	}
	
	/**
	 * 
	 * @return image = image of the horse
	 */
	public static Image getImage() {
		return image;
	}
	
	public void start(Stage stage) {
		
		// creates a GridPane for the operational buttons (run, reset, quit)
		GridPane gridPane1 = new GridPane();
		gridPane1.setAlignment(Pos.CENTER);
		gridPane1.setPadding(new Insets(20, 0, 30, 0));
		
		//creates a GridPane for the horse race
		GridPane gridPane2 = new GridPane();
		
		//create an HBox for gridPane1
		HBox hBoxButtons = new HBox();
		hBoxButtons.setSpacing(10.0);
		
		//create the buttons for the HBox
		Button runButton = new Button("Run Race");
		Button resetButton = new Button("Reset Race");
		Button quitButton = new Button("Quit Program");
		
		//add buttons to HBox
		hBoxButtons.getChildren().addAll(runButton, resetButton, quitButton);
		
		//add HBox to gridPane1
		gridPane1.add(hBoxButtons, 1, 2, 2, 1);
		
		//create the EventHandler association
		RunHandler runAction = new RunHandler(resetButton, runButton);
		ResetHandler resetAction = new ResetHandler(GCList, image, runButton);
		QuitHandler quitAction = new QuitHandler();
	
		//set button actions
		runButton.setOnAction(runAction);
		resetButton.setOnAction(resetAction);
		quitButton.setOnAction(quitAction);
		
		// Create the Canvas
		Canvas canvas0 = new Canvas(1000, 80);
		Canvas canvas1 = new Canvas(1000, 80);
		Canvas canvas2 = new Canvas(1000, 80);
		Canvas canvas3 = new Canvas(1000, 80);
		Canvas canvas4 = new Canvas(1000, 80);
		
		// Get the graphics context of the canvas
		GraphicsContext gc0 = canvas0.getGraphicsContext2D();
		GraphicsContext gc1 = canvas1.getGraphicsContext2D();
		GraphicsContext gc2 = canvas2.getGraphicsContext2D();
		GraphicsContext gc3 = canvas3.getGraphicsContext2D();
		GraphicsContext gc4 = canvas4.getGraphicsContext2D();
		
		//populate an ArrayList of GraphicsContext
		GCList.add(gc0);
		GCList.add(gc1);
		GCList.add(gc2);		
		GCList.add(gc3);
		GCList.add(gc4);
		
		//Creates rows containing canvas'
		gridPane2.addRow(0, canvas0);
		gridPane2.addRow(1, canvas1);
		gridPane2.addRow(2, canvas2);
		gridPane2.addRow(3, canvas3);
		gridPane2.addRow(4, canvas4);
		
		// Draw the Image on the canvas
		gc0.drawImage(image, 0,0);
		gc1.drawImage(image, 0,0);
		gc2.drawImage(image, 0,0);
		gc3.drawImage(image, 0,0);
		gc4.drawImage(image, 0,0);
		
		//sets up the boarder pane to hold the GUI items
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(gridPane1);
		borderPane.setCenter(gridPane2);
		Scene scene = new Scene(borderPane, 1000, 500);
		
		//displays the GUI
		stage.setTitle("Tim's Wild Horse Race Extravaganza!");
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
