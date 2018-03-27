import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Timothy McWatters
 * @version 1.0
 * 
 * COP 4027 Advanced Computer Programming
 * Project 4
 * File Name: HorseRace.java
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

public class HorseRace implements Runnable {
	public static final int NUMBER_OF_HORSES = 5;
	public static final int FINISH_LINE = 400;
	private static final int DELAY = 1; 
	ArrayList<Horse> horses;
	private ReentrantLock lock;

	public HorseRace() {
		horses = new ArrayList<Horse>();
	}
	
	public void populateRaceWithHorses() {
		for (int i = 0; i < NUMBER_OF_HORSES; i++) {
			horses.add(new Horse(i));
		}
	}
	
	public void run() {
		try {
			horses.get(1);
			Thread.sleep(DELAY);
		}
	    catch (InterruptedException exception) {
	    	
	    }
	}
	

}
