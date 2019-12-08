import java.util.ArrayList;

import javafx.scene.control.ChoiceBox;

public class Setup
{
	private ArrayList<ChoiceBox> chainrings;
	private ArrayList<ChoiceBox> sprockets;
	
	public Setup()
	{
		chainrings = new ArrayList<ChoiceBox>();
		sprockets = new ArrayList<ChoiceBox>();
	}
	
	public void addChainring(ChoiceBox newItem)
	{
		chainrings.add(newItem);
	}
	
	public void addSprocket(ChoiceBox newItem)
	{
		sprockets.add(newItem);
	}
	
	public ArrayList<ChoiceBox> getChainrings()
	{
		return chainrings;
	}
	
	public ArrayList<ChoiceBox> getSprockets()
	{
		return sprockets;
	}
	
	public ArrayList<Combo> getSetupCombos()
	{
		ArrayList<Combo> setupCombos = new ArrayList<Combo>();
		
		ArrayList<Integer> chainringsSizes = getSizes(chainrings);
		ArrayList<Integer> sprocketsSizes = getSizes(sprockets);
		
		for (Integer chainringSize: chainringsSizes)
		{
			setupCombos.add(new Combo(chainringSize, sprocketsSizes));
		}
		
		return setupCombos;
	} /* getSetupCombos */
	
	private ArrayList<Integer> getSizes(ArrayList<ChoiceBox> cogwheels)
	{
		ArrayList<Integer> sizes = new ArrayList<Integer>();
		
		int ringSize;
		
		for (ChoiceBox ring: cogwheels)
		{
			ringSize = genValue((Integer)ring.getValue(), 0);
			
			if (ringSize > 0)
			{
				sizes.add(ringSize);
			}
		}
		
		return sizes;
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
}
