import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
/**
 * @author Timothy McWatters
 * @version 1.0
 * 
 * COP 4027 Advanced Computer Programming
 * Project 4
 * File Name: RunHandler.java
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

public class RunHandler implements EventHandler<ActionEvent>  {

	/*
	 * Handles the Exit action
	 * @parameter action = The action to handle
	 */
	public void handle(ActionEvent action) {
		Platform.exit();
	}
}
