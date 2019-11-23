import java.util.ArrayList;

public class Calculator {

	private Chainring chainring;
	private Cassette cassette;
	private ArrayList<ArrayList<Double>> gearRatios;
	
	public Calculator(Chainring chainring, Cassette cassette) {
		this.chainring = chainring;
		this.cassette = cassette;
		gearRatios = new ArrayList<>();
	}
	
	public void calculateGearRatios() {
		for (int i = 0; i < chainring.getChainringGears().size(); i++) {
			ArrayList<Double> chainringRatio = new ArrayList<Double>();
			for (int j = 0; j < cassette.getCassetteGears().size(); j++) {
				double ratio = chainring.getGearSize(i) / cassette.getGearSize(j);
				chainringRatio.add(ratio);
			}
			gearRatios.add(chainringRatio);
		}
	}
	
	public ArrayList<ArrayList<Double>> getGearRatios() {
		return gearRatios;
	}
	
}
