import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class RunHandler implements EventHandler<ActionEvent>  {

	/*
	 * Handles the Exit action
	 * @parameter action = The action to handle
	 */
	public void handle(ActionEvent action) {
		Platform.exit();
	}
}
