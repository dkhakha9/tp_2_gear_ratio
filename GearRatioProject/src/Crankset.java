import java.util.ArrayList;


public class Crankset {
	private ArrayList<Chainring> chainring;
	private ArrayList<Integer> availableSizes;
	private final static int MAX_CR_COUNT =12;
	
	public Crankset(Chainring cr) {

		this.chainring.add(cr);
		this.availableSizes.add(cr.getTeeth());
	}
	
	public void addChaingring (Chainring cr) {
		if (availableSizes.size() < MAX_CR_COUNT && !availableSizes.contains(cr.getTeeth())) {
			this.chainring.add(cr);
			this.availableSizes.add(cr.getTeeth());
		}
	}

	public ArrayList<Chainring> getChaingring() {
		return chainring;
	}
		
	public ArrayList<Integer> getAllSizes() {
		return availableSizes;
	}
	
	public double getGearSize(int index) {
		return chainring.get(index).getTeeth();
	}
}
