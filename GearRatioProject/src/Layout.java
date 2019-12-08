import java.util.ArrayList;
import java.util.Arrays;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class Layout
{
	private GridPane grid;
	private ArrayList<Setup> setups;
	
	public Layout()
	{
		grid = new GridPane();
		setups = new ArrayList<Setup>();
	}
	
	public GridPane getGrid()
	{
		GearRatiosChart gearChart = new GearRatiosChart();
        
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        grid.add(new Label("Setup"), 0, 0);
        
        grid.add(new Label("Cogwheel"), 1, 0);
        
        grid.add(new Label("Sizes"), 2, 0);
        
        Button plotButton = new Button("Plot");
        
        grid.add(plotButton, 1, 1);
        
        Button buttonAddSetup = new Button("Add Setup");
        
        grid.add(buttonAddSetup, 0, 1);
        
        addSetup(buttonAddSetup, plotButton);
        
        plotButton.setOnAction(value ->  {
        	
        	Integer[] cassete1 = {11, 12, 13, 14, 15};
            Integer[] cassete2 = {11, 13, 15, 17, 19};
            
            Combo combo1 = new Combo(genValue((Integer)setups.get(0).getChainrings().get(0).getValue(), 46), new ArrayList<Integer>(Arrays.asList(cassete1)));
            
            int size = 38;
            
            if (setups.get(0).getChainrings().size() > 1)
            	size = genValue((Integer)setups.get(0).getChainrings().get(1).getValue(), size);
            
            Combo combo2 = new Combo(size, new ArrayList<Integer>(Arrays.asList(cassete2)));
            Combo combo3 = new Combo(36, new ArrayList<Integer>(Arrays.asList(cassete1)));
            Combo combo4 = new Combo(40, new ArrayList<Integer>(Arrays.asList(cassete1)));
            
            ArrayList<Combo> setup1 = new ArrayList<Combo>();
            ArrayList<Combo> setup2 = new ArrayList<Combo>();
            ArrayList<Combo> setup3 = new ArrayList<Combo>();
            
            setup1.add(combo2);
            
            setup2.add(combo1); // all combos in a setup should have the same cassette
            setup2.add(combo3);
            
            setup3.add(combo1);
            setup3.add(combo3);
            setup3.add(combo4);
            
            gearChart.addSetup(setup1);
            gearChart.addSetup(setup2);
            gearChart.addSetup(setup3);
            
            grid.add(gearChart.getChart(), 2, setups.size()*2 + 2, 12, 4);
            
            plotButton.setDisable(true);
            buttonAddSetup.setDisable(true);
        });
        
        buttonAddSetup.setOnAction(value ->  {
        	addSetup(buttonAddSetup, plotButton);
        });
        
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
	
	private int genValue(Integer userInput, Integer defaultVal)
	{
		if (userInput == null)
		{
			return defaultVal;
		}
		else
		{
			return userInput;
		}
	}
	
	private void addSetup(Button buttonAddSetup, Button plotButton)
	{
		int newSetupRowNum = setups.size()*2 + 1;
    	
    	Setup newSetup = new Setup();
    	
    	for (int i = 0; i < 3; i++)
    	{
    		newSetup.addChainring(new ChoiceBox(FXCollections.observableArrayList(genTeethSizeList(18, 62))));
    	}
    	
    	for (int i = 0; i < 12; i++)
    	{
    		newSetup.addSprocket(new ChoiceBox(FXCollections.observableArrayList(genTeethSizeList(9, 36))));
    	}
    	
    	setups.add(newSetup);
    	
    	int newButtonsRowNum = setups.size()*2 + 1;
    	
    	grid.setRowIndex(buttonAddSetup, newButtonsRowNum);
    	grid.setRowIndex(plotButton, newButtonsRowNum);
    	
    	grid.addRow(newSetupRowNum, new Label(Integer.toString(setups.size())), new Label("Chainrings"));
    	
    	for (ChoiceBox chainring: newSetup.getChainrings())
    	{
    		grid.addRow(newSetupRowNum, chainring);
    	}
    	
    	grid.addRow(newSetupRowNum + 1, new Label(), new Label("Sprockets"));
    	
    	for (ChoiceBox sprocket: newSetup.getSprockets())
    	{
    		grid.addRow(newSetupRowNum + 1, sprocket);
    	}
    	
    	if (setups.size() >= 3)
    	{
    		buttonAddSetup.setDisable(true);
    	}
	}
}
