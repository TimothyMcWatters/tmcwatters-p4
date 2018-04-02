import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;

/**
 * @author Timothy McWatters
 * @version 1.0
 * 
 * COP 4027 Advanced Computer Programming
 * Project 4
 * File Name: ResetHandler.java
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

public class ResetHandler implements EventHandler<ActionEvent>  {
	private ArrayList<GraphicsContext> GCList;
	private Image image;
	private Button runButton;
	
	/**
	 * Constructor
	 * @param GCList = Graphics Context Array List
	 * @param image = The horse image
	 * @param runButton = The button to start the race
	 */
	public ResetHandler(ArrayList<GraphicsContext> GCList, Image image, Button runButton) {
		this.GCList = GCList;
		this.image = image;
		this.runButton = runButton;
	}
	
	/*
	 * Handles the Reset race action by disabling the run button and placing the horses in starting position
	 * @parameter action = The action to handle
	 */
	public void handle(ActionEvent action) {
		for (GraphicsContext element : GCList) {
			element.clearRect(0, 0, 1250, 180);
			element.drawImage(image, 0,0);
		}
		runButton.setDisable(false);
	}
}
