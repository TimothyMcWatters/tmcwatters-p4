import java.io.File;

import javafx.application.Application;
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
	public void start(Stage stage) {
		
		//Creates an instance of the horse race to be called and ran, reset or quit later
		HorseRace horseRace = new HorseRace();
		
		// creates a GridPane for the operational buttons (run, reset, quit)
		GridPane gridPane1 = new GridPane();
		gridPane1.setAlignment(Pos.CENTER);
		
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
		RunHandler runAction = new RunHandler();
		ResetHandler resetAction = new ResetHandler();
		QuitHandler quitAction = new QuitHandler();
	
		//set button actions
		runButton.setOnAction(runAction);
		resetButton.setOnAction(resetAction);
		quitButton.setOnAction(quitAction);
		
		// Load the Image
		Image image = new Image("Horse.jpg");
		//Image image = new Image(new File("Horse.jpg").toURI().toString());
		
		// Create the Canvas
		Canvas canvas0 = new Canvas(400, 100);
		// Get the graphics context of the canvas
		GraphicsContext gc0 = canvas0.getGraphicsContext2D();
		// Draw the Image
		gc0.drawImage(image, 0,0);
		
		// Create the Canvas
		Canvas canvas1 = new Canvas(400, 100);
		// Get the graphics context of the canvas
		GraphicsContext gc1 = canvas1.getGraphicsContext2D();
		// Draw the Image
		gc1.drawImage(image, 0,0);
		
		// Create the Canvas
		Canvas canvas2 = new Canvas(400, 100);
		// Get the graphics context of the canvas
		GraphicsContext gc2 = canvas2.getGraphicsContext2D();
		// Draw the Image
		gc2.drawImage(image, 0,0);
		
		// Create the Canvas
		Canvas canvas3 = new Canvas(400, 100);
		// Get the graphics context of the canvas
		GraphicsContext gc3 = canvas3.getGraphicsContext2D();
		// Draw the Image
		gc3.drawImage(image, 0,0);
		
		// Create the Canvas
		Canvas canvas4 = new Canvas(400, 50);
		// Get the graphics context of the canvas
		GraphicsContext gc4 = canvas4.getGraphicsContext2D();
		// Draw the Image
		gc4.drawImage(image, 0,0);
				
		//Creates rows containing canvas'
		gridPane2.addRow(0, canvas0);
		gridPane2.addRow(1, canvas1);
		gridPane2.addRow(2, canvas2);
		gridPane2.addRow(3, canvas3);
		gridPane2.addRow(4, canvas4);
		
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
