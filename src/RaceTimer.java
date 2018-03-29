/**
 * @author Timothy McWatters
 * @version 1.0
 * 
 * COP 4027 Advanced Computer Programming
 * Project 4
 * File Name: RaceTimer.java
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

public class RaceTimer {  
    private long elapsedTime;
    private long startTime;
    private boolean isRunning;
    
	/**
	 * Default constructor to start at zero
	 */
   public RaceTimer() {  
      reset();
   }

   /**
    * Timer starts now.
    */
   public void start() {  
      if (isRunning) return;
      isRunning = true;
      startTime = System.currentTimeMillis();
   }
      
   /**
    * Stops the timer. Time stops accumulating and is
    * is added to the elapsed time.
    */
   public void stop() {  
      if (!isRunning) return;
      isRunning = false;
      long endTime = System.currentTimeMillis();
      elapsedTime = elapsedTime + endTime - startTime;
   }
   
   /**
    * Returns the total elapsed time.
    * @return the total elapsed time
    */
   public long getElapsedTime() {  
      if (isRunning) {  
          long endTime = System.currentTimeMillis();
          return elapsedTime + endTime - startTime;
       } else {
    	   return elapsedTime;
       } 
    }
    
   /**
    *   Stops the watch and resets the elapsed time to 0.
    */
    public void reset() {  
       elapsedTime = 0;
       isRunning = false;
    }
    
    /**
     * Gets a string representation of the timer results
     * @return string = the string representation of the timer results
     */
    public String toString() {
    	return "The recorded time was " + getElapsedTime()/1000.0 + " seconds";
    }
 }
