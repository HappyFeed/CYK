package ui;

/*This class is in charged to start the application.
 * @author: Alejandro Martinez
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
    /*The method is in charged to start the application.
     * @param: A String[] args that represent the information. args!=null;
     */
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	public void start(Stage stage) throws Exception {
		Parent root= FXMLLoader.load(getClass().getResource("menuCYK.fxml"));
       	
       	Scene scene= new Scene(root);
       	stage.setTitle("CYK");
       	stage.setScene(scene);
       	stage.show();
		
	}
	
	    
	    
}
