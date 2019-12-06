import java.util.ArrayList;


public class Cassette {

	private ArrayList<Cogs> cogs= new ArrayList<>();
	private ArrayList<Integer> availableSizes = new ArrayList<Integer>();
	//based on interview
	private final static int MAX_COGS_COUNT =12;
	
	public Cassette(Cogs cogs) {

		this.cogs.add(cogs);

		this.availableSizes.add(cogs.getTeeth());
	}
	
	public void addCogs (Cogs cogs) {
		
		//avoid adding same size cogs
		if (availableSizes.size() < MAX_COGS_COUNT && !availableSizes.contains(cogs.getTeeth())) {
			this.cogs.add(cogs);
			this.availableSizes.add(cogs.getTeeth());
		}
		
	}
	
	public ArrayList<Cogs> getCassetteGears() {
		return cogs;
	}
	
	public ArrayList<Integer> getAllCogSizes() {
		return availableSizes;
	}
	
	public int getGearSize(int index) {
		return cogs.get(index).getTeeth();
	}
	
}
