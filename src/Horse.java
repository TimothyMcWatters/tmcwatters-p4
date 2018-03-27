import java.util.Random;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

/**
 * @author Timothy McWatters
 * @version 1.0
 * 
 * COP 4027 Advanced Computer Programming
 * Project 4
 * File Name: Horse.java
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

public class Horse {
	private Random randomGenerator = new Random();
	private int horseNumber;
	private int locationOnTrack = 0; 
	
	public Horse(int horseNumber) {
		this.horseNumber = horseNumber;
	}
	
	public void moveHorse() {
		int distanceToMove = (randomGenerator.nextInt(5) + 1) * 5;
		int oldLocationOnTrack = getLocationOnTrack();
		int newLocationOnTrack = oldLocationOnTrack + distanceToMove;
		setLocationOnTrack(newLocationOnTrack);
	}
	
	/**
	 * @return the horseNumber
	 */
	public int getHorseNumber() {
		return horseNumber;
	}

	/**
	 * @param horseNumber the horseNumber to set
	 */
	public void setHorseNumber(int horseNumber) {
		this.horseNumber = horseNumber;
	}

	/**
	 * @return the locationOnTrack
	 */
	public int getLocationOnTrack() {
		return locationOnTrack;
	}

	/**
	 * @param locationOnTrack the locationOnTrack to set
	 */
	public void setLocationOnTrack(int locationOnTrack) {
		this.locationOnTrack = locationOnTrack;
	}
	
	// Create the Canvas
	//Canvas canvas0 = new Canvas(400, 100);
	// Get the graphics context of the canvas
	//GraphicsContext gc0 = canvas0.getGraphicsContext2D();
	// Draw the Image
	//gc0.drawImage(image, 0,0);
}
