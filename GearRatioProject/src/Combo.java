import java.util.ArrayList;

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
