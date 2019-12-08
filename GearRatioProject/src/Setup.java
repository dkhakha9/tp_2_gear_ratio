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
}
