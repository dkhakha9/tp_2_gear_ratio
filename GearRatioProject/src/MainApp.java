import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application
{
	@Override public void start(Stage stage)
	{
        stage.setTitle("Gear Ratios Comparison Tool");
        
        Layout appLayout = new Layout();
        
        Scene scene = new Scene(appLayout.getGrid(),1200,800);
       
        stage.setScene(scene);
        stage.show();
    }
	
	public static void main(String[] args)
	{
		
		launch(args);
	}

}
