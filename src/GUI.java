import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author Timothy McWatters
 * @version 1.0
 * 
 * COP 4027 Advanced Computer Programming
 * Project 3
 * File Name: GUI.java
 * 
 * This Program: Will create a graphical spell checker program
 * It will have a menu item to open an input file and place it into a TextArea in a window. 
 * When the checking proceeds, it will extract a word from the text to be checked, 
 * hash it into the table, and determine if it exists. 
 * You will continue this process until you have checked all the words in the file. 
 * Each time you find a word that you cannot match in the dictionary, you will let the user 
 * know and you will attempt to generate a list of suggested words. 
 * You will generate the list by assembling similar words via three methods:
 *		One letter missing. 
 *		One letter added. 
 *		Two letters reversed. 
 */
public class GUI extends Application {
	public void start(Stage stage) {
		
		//Creates an instance of the horse race to be called and ran, reset or quit later
		HorseRace horseRace = new HorseRace();
		
		// creates a GridPane for the operational buttons (run, reset, quit)
		GridPane gridPane1 = new GridPane();
		gridPane1.setAlignment(Pos.CENTER);
		
		// creates a GridPane for the horse race
		GridPane gridPane2 = new GridPane();
		
		//create an HBox for gridPane1
		HBox hBoxButtons = new HBox();
		hBoxButtons.setSpacing(10.0);
		
		//create the buttons to populate first Grid Pane with buttons
		Button runButton = new Button("Run");
		Button resetButton = new Button("Reset");
		Button quitButton = new Button("Quit");
		
		//add buttons to HBox
		hBoxButtons.getChildren().addAll(runButton, resetButton, quitButton);
		
		//add HBox to gridPane1
		gridPane1.add(hBoxButtons, 1, 2, 2, 1);
		
		//create the text area
		RunHandler runAction = new RunHandler();
		ResetHandler resetAction = new ResetHandler();
		QuitHandler quitAction = new QuitHandler();
	
		//set menu item actions
		runButton.setOnAction(runAction);
		resetButton.setOnAction(resetAction);
		quitButton.setOnAction(quitAction);
		
		//sets up the boarder pane to hold the GUI items
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(gridPane1);
		borderPane.setCenter(gridPane2);
		Scene scene = new Scene(borderPane, 350, 400);
		
		//displays the GUI
		stage.setTitle("Tim's Wild Horse Race Extravaganza!");
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
