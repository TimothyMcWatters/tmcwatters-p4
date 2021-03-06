import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
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
	public static final int FINISH_LINE = 1000-68;
	public static final int DELAY = 100; 
	private ArrayList<Horse> horses;
	private boolean raceOver = false;
	private ReentrantLock lock;
	private RaceTimer timer;
	private Button resetButton;
	private Button runButton;

	/**
	 * Constructor
	 * @param resetButton = The button used to reset the horses to their starting position
	 * @param runButton = The button to start the race
	 */
	public HorseRace(Button resetButton, Button runButton) {
		this.horses = new ArrayList<Horse>();
		this.lock = new ReentrantLock();
		this.timer = new RaceTimer();
		this.resetButton = resetButton;
		this.runButton = runButton;
	}
	
	/**
	 * Adds the set number of horses to the race
	 */
	public void populateRaceWithHorses() {
		for (int i = 0; i < NUMBER_OF_HORSES; i++) {
			horses.add(new Horse(i));
		}
	}
	
	/**
	 * Starts the race for a particular Horse
	 * @param horseNumber = The horse number of the Horse that is running
	 */
	public void startRace(int horseNumber) {
		class Race implements Runnable {
			@Override
			public void run() {
				resetButton.setDisable(true);
				runButton.setDisable(true);
				while (!isRaceOver()) {
					try {
						lock.lock();
						horses.get(horseNumber).moveHorse();
						GUI.getGCList().get(horseNumber).clearRect(horses.get(horseNumber).getLocationOnTrack() - 68, 0, 68, 47);
						GUI.getGCList().get(horseNumber).drawImage(GUI.getImage(), horses.get(horseNumber).getLocationOnTrack(), 0);
						if (horses.get(horseNumber).getLocationOnTrack() >= FINISH_LINE) {
							if (!isRaceOver()) {
								Platform.runLater(() -> announceWinner(horseNumber + 1));
								Thread.currentThread().interrupt();
								resetButton.setDisable(false);
							}
							timer.stop();
							setRaceOver(true);
							Thread.currentThread().interrupt();
							resetButton.setDisable(false);
						}
						lock.unlock();
						Thread.sleep(DELAY);
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

	/**
	 * Announces the winner of the race
	 * @param horseNumber = The number of the Horse who won
	 */
	private void announceWinner(int horseNumber) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.initStyle(StageStyle.DECORATED);
		alert.setTitle("Winner of Tim's Wild Horse Race Extravaganza!");
		alert.setHeaderText(null);
		alert.setContentText("Horse number " + horseNumber + " is the winner!\n" + timer.toString());
		alert.showAndWait();
	}
	
	/**
	 * @return the timer
	 */
	public RaceTimer getTimer() {
		return timer;
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
	
	/**
	 * @return the horse
	 */
	public Horse getHorse(int horseNumber) {
		return horses.get(horseNumber);
	}
}
