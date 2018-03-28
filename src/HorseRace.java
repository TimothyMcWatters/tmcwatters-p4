import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.StageStyle;

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

public class HorseRace {
	public static final int NUMBER_OF_HORSES = 5;
	public static final int FINISH_LINE = 400;
	public static final int DELAY = 1000; 
	private ArrayList<Horse> horses;
	private boolean raceOver = false;
	private ReentrantLock lock;

	public HorseRace() {
		this.horses = new ArrayList<Horse>();
		this.lock = new ReentrantLock();
	}
	
	public void populateRaceWithHorses() {
		for (int i = 0; i < NUMBER_OF_HORSES; i++) {
			horses.add(new Horse(i));
		}
	}
	
	public void startRace(int horseNumber) {
		class Race implements Runnable {
			@Override
			public void run() {
				while (!isRaceOver()) {
					try {
						System.out.println(!isRaceOver());
						lock.lock();
						horses.get(horseNumber).moveHorse();
						GUI.getGCList().get(horseNumber).clearRect(horses.get(horseNumber).getLocationOnTrack() - 68, 0, 68, 47);
						GUI.getGCList().get(horseNumber).drawImage(GUI.getImage(), horses.get(horseNumber).getLocationOnTrack(), 0);
						if (horses.get(horseNumber).getLocationOnTrack() >= FINISH_LINE) {
							Platform.runLater(() -> winnerDialog(horseNumber + 1));
							setRaceOver(true);
							Thread.currentThread().interrupt();
						}
						lock.unlock();
						Thread.sleep(DELAY);
						if (isRaceOver()) {
							Thread.currentThread().interrupt();
						}
					}
				    catch (InterruptedException exception) {
				    	System.out.println("Thread terminated");
				    }
				}
			}
		}
		Runnable r = new Race();
		Thread t = new Thread(r);
		t.start();
	}


	private void winnerDialog(int horseNumber) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.initStyle(StageStyle.DECORATED);
		alert.setTitle("Announcing the winner");
		alert.setHeaderText(null);
		alert.setContentText("Horse number " + horseNumber + " is the winner!");
		alert.showAndWait();
	}

	/**
	 * @return the raceOver
	 */
	public boolean isRaceOver() {
		return raceOver;
	}

	/**
	 * @param raceOver the raceOver to set
	 */
	public void setRaceOver(boolean raceOver) {
		this.raceOver = raceOver;
	}

	/**
	 * @return the horses
	 */
	public ArrayList<Horse> getHorses() {
		return horses;
	}
}
