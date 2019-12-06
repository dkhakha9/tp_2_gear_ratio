import java.util.ArrayList;

public class Bicycle {


	private Crankset crankset;
	private Cassette cassette;
	private ArrayList<ArrayList<Double>> gearRatios;
	
	public Bicycle(Crankset crankset, Cassette cassette) {
		this.crankset = crankset;
		this.cassette = cassette;
		gearRatios = new ArrayList<>();
	}
	
	public void calculateGearRatios() {
		for (int i = 0; i < crankset.getChaingring().size(); i++) {
			ArrayList<Double> chainringRatio = new ArrayList<Double>();
			for (int j = 0; j < cassette.getCassetteGears().size(); j++) {
				double ratio = crankset.getGearSize(i) / cassette.getGearSize(j);
				chainringRatio.add(ratio);
			}
			gearRatios.add(chainringRatio);
		}
	}
	
	public ArrayList<Integer> CasseteSizes(){
		return this.cassette.getAllCogSizes();
	}
	
	public ArrayList<Integer> CranksetSizes(){
		return this.crankset.getAllSizes();
	}
	
	
	public ArrayList<ArrayList<Double>> getGearRatios() {
		return gearRatios;
	}
	
}
