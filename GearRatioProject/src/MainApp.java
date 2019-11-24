import edu.princeton.cs.introcs.StdOut;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application
{
	@Override public void start(Stage stage)
	{
        stage.setTitle("Gear Ratios Comparison Tool");
        
        GearRatiosChart gearChart = new GearRatiosChart();
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label cassetteSizeLabel = new Label("Cassette size");
        grid.add(cassetteSizeLabel, 0, 0);

        ChoiceBox cassetteSizeNumber = new ChoiceBox(FXCollections.observableArrayList("36t", "38t", "40t", "46t", "48t"));
        grid.add(cassetteSizeNumber, 1, 0);
        
        grid.add(gearChart.getChart(), 0, 2, 6, 2);
        
        Scene scene = new Scene(grid,800,600);
       
        stage.setScene(scene);
        stage.show();
    }
	
	public static void main(String[] args)
	{
		Gear gear1 = new Gear(6);
		Gear gear2 = new Gear(10);
		Gear gear3 = new Gear(15);
		Gear gear4 = new Gear(20);
		Gear gear5 = new Gear(30);
		Gear gear6 = new Gear(60);
		Gear gear7 = new Gear(120);
		
		Chainring chainring = new Chainring("Chainring");
		chainring.addChainringGear(gear6);
		chainring.addChainringGear(gear7);
		
		Cassette cassette = new Cassette("Cassette");
		cassette.addCassetteGear(gear1);
		cassette.addCassetteGear(gear2);
		cassette.addCassetteGear(gear3);
		cassette.addCassetteGear(gear4);
		cassette.addCassetteGear(gear5);
		
		Calculator calc = new Calculator(chainring, cassette);
		calc.calculateGearRatios();
		StdOut.println(calc.getGearRatios());
		StdOut.println("Thank you for using Gear Ratio App\n");
		
		launch(args);
	}

}
