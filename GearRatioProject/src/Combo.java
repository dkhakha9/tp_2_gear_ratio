import java.util.ArrayList;
import java.util.Collections;

public class Combo
{
	private int ringSize;
	private ArrayList<Integer> sprockets;
	
	public Combo(int chainringSize, ArrayList<Integer> sprockets)
	{
		ringSize = chainringSize;
		this.sprockets = sprockets;
	}
	
	public int getRingSize()
	{
		return ringSize;
	}
	
	public int getMinTeethCount()
	{
		return Collections.min(sprockets);
	}
	
	public int getMaxTeethCount()
	{
		return Collections.max(sprockets);
	}
	
	public ArrayList<Double> getGearRatios()
	{
		ArrayList<Double> gearRatios = new ArrayList<Double>();
		
		for (Integer gear: sprockets)
		{
			gearRatios.add((double)ringSize / gear);
		}
		
		return gearRatios;
	}
}
