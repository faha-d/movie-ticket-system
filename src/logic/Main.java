package logic;
import view.Welcome;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	private MovieManager movieManager = new MovieManager();	
	
	@Override
	public void start(Stage primaryStage) {
	    Welcome.show(primaryStage, movieManager);
	}

	public static void main(String[] args) {
	    launch(args);
	}

}
