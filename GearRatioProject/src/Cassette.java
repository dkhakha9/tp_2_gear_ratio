import java.util.ArrayList;

public class Cassette {

	private String name;
	private ArrayList<Gear> gears;
	
	public Cassette(String name) {
		this.name = name;
		gears = new ArrayList<>();
	}
	
	public void addCassetteGear(Gear newGear) {
		gears.add(newGear);
	}
	
	public ArrayList<Gear> getCassetteGears() {
		return gears;
	}
	
	public String getCassetteName() {
		return name;
	}
	
	public void setCassetteName(String name) {
		this.name = name;
	}
	
	public double getGearSize(int index) {
		return gears.get(index).getTeeth();
	}
	
}
