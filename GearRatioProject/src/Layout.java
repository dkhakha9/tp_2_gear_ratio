import java.util.ArrayList;

import javax.xml.soap.Node;

import edu.princeton.cs.introcs.StdOut;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Layout
{
	private GridPane grid;
	private ArrayList<Bicycle> bikes;
	
	private Button plotButton;
	private Button buttonAddSetup;
	private Button reset;
	
	public Layout()
	{
		grid = new GridPane();
		plotButton = new Button("Plot");
		buttonAddSetup = new Button("Add sike setup");
		reset = new Button ("Reset");
		
		bikes = new ArrayList<Bicycle>();
		
		initializeGrid();
	}
	
	public GridPane getGrid()
	{        
        return grid;
	} /* getGrid */
	
	private ArrayList<Integer> genTeethSizeList(int minSize, int maxSize)
	{
		assert(minSize <= maxSize);
		ArrayList<Integer> resultList = new ArrayList<Integer>();
		for (int i = minSize; i <= maxSize; i++)
		{
			resultList.add(i);
		}
		return resultList;
	}
	
	private void initializeGrid()
	{        
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        grid.add(new Label("Setup"), 0, 0);
        
        grid.add(new Label("Cogwheel"), 1, 0);
        
        grid.add(new Label("Sizes"), 2, 0);
                
        grid.add(plotButton, 1, 1);
        
        grid.add(buttonAddSetup, 0, 1);
        
        addSetup();
        
        plotButton.setOnAction(value ->  {
        	
        	plotChart();
            
            plotButton.setDisable(true);
            buttonAddSetup.setDisable(true);
            grid.add(reset, 2, 3);
        });
        
        buttonAddSetup.setOnAction(value ->  {
        	addSetup();
        });
        
        
	} /* initializeGrid */
	
	private void addSetup()
	{
		int newSetupRowNum = bikes.size()*2 + 1;
    	
    	Bicycle newSetup = new Bicycle();
    	
    	for (int i = 0; i < 3; i++)
    	{
    		newSetup.addChainring(new ChoiceBox(FXCollections.observableArrayList(genTeethSizeList(18, 62))));
    	}
    	
    	for (int i = 0; i < 12; i++)
    	{
    		newSetup.addSprocket(new ChoiceBox(FXCollections.observableArrayList(genTeethSizeList(9, 36))));
    	}
    	
    	bikes.add(newSetup);
    	
    	int newButtonsRowNum = bikes.size()*2 + 1;
    	
    	grid.setRowIndex(buttonAddSetup, newButtonsRowNum);
    	grid.setRowIndex(plotButton, newButtonsRowNum);
    	
    	grid.addRow(newSetupRowNum, new Label(Integer.toString(bikes.size())), new Label("Chainrings"));
    	
    	for (ChoiceBox chainring: newSetup.getChainrings())
    	{
    		grid.addRow(newSetupRowNum, chainring);
    	}
    	
    	grid.addRow(newSetupRowNum + 1, new Label(), new Label("Sprockets"));
    	
    	for (ChoiceBox sprocket: newSetup.getSprockets())
    	{
    		grid.addRow(newSetupRowNum + 1, sprocket);
    	}
    	
    	if (bikes.size() >= 3)
    	{
    		buttonAddSetup.setDisable(true);
    	}
	} /* addSetup */
	

	
	private void plotChart()
	{
		GearRatiosChart gearChart = new GearRatiosChart(bikes.size());
		
        for (Bicycle setup: bikes)
        {
        	gearChart.addSetup(setup.getSetupCombos());
        }
        
        grid.add(gearChart.getChart(), 2, bikes.size()*2 + 2, 12, 4);
	} /* plotChart */
}
