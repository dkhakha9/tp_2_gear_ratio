import java.util.ArrayList;

public class Chainring {

	private String name;
	private ArrayList<Gear> gears;
	
	public Chainring(String name) {
		this.name = name;
		gears = new ArrayList<>();
	}
	
	public void addChainringGear(Gear newGear) {
		gears.add(newGear);
	}
	
	public ArrayList<Gear> getChainringGears() {
		return gears;
	}
	
	public String getChainringName() {
		return name;
	}
	
	public void setChainringName(String name) {
		this.name = name;
	}
	
	public double getGearSize(int index) {
		return gears.get(index).getTeeth();
	}
	
}
