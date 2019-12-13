import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestCombo
{
	@Test
	public void testGearRatioCalculator()
	{
		
		ArrayList<Double> expected1 = new ArrayList<>();
		expected1.add(4.18);
		expected1.add(3.07);
		expected1.add(1.64);
		
		ArrayList<Integer> sprockets = new ArrayList<>();
		sprockets.add(11);
		sprockets.add(15);
		sprockets.add(28);
		
		Combo calc = new Combo(46, sprockets);
		
		ArrayList<Double> actuals = calc.getGearRatios();
		
		for (Double gearRatioVal: actuals)
		{
			assertEquals(expected1.get(actuals.indexOf(gearRatioVal)), gearRatioVal, 0.01);
		}
	} /* testGearRatioCalculator */
}
