import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestCalculator {

	@Test
	public void testGearRatioCalculator() {
		
		Gear gear1 = new Gear(6);
		Gear gear2 = new Gear(10);
		Gear gear3 = new Gear(15);
		Gear gear4 = new Gear(20);
		Gear gear5 = new Gear(30);
		Gear gear6 = new Gear(60);
		Gear gear7 = new Gear(120);
		
		Chainring chainring = new Chainring("Chainring");
		chainring.addChainringGear(gear6);
		chainring.addChainringGear(gear7);
		
		Cassette cassette = new Cassette("Cassette");
		cassette.addCassetteGear(gear1);
		cassette.addCassetteGear(gear2);
		cassette.addCassetteGear(gear3);
		cassette.addCassetteGear(gear4);
		cassette.addCassetteGear(gear5);
		
		ArrayList<Double> expected1 = new ArrayList<>();
		expected1.add(10.0);
		expected1.add(6.0);
		expected1.add(4.0);
		expected1.add(3.0);
		expected1.add(2.0);
		
		ArrayList<Double> expected2 = new ArrayList<>();
		expected2.add(20.0);
		expected2.add(12.0);
		expected2.add(8.0);
		expected2.add(6.0);
		expected2.add(4.0);
		
		Calculator calc = new Calculator(chainring, cassette);
		calc.calculateGearRatios();
		assertEquals(calc.getGearRatios().get(0), expected1);
		assertEquals(calc.getGearRatios().get(1), expected2);
	}
	
}
