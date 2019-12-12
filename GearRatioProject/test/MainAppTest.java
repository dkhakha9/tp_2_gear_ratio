import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import javafx.collections.FXCollections;
import javafx.embed.swing.JFXPanel;
import javafx.scene.control.ChoiceBox;

public class MainAppTest
{
	@Test
	public void testBicycle1()
	{
		Bicycle setup = new Bicycle();
		
		new JFXPanel();
		
		Integer[] dropDownChoices = {2, 5, 9, 12, 17};
		
		ChoiceBox chainring1 = new ChoiceBox(FXCollections.observableArrayList(Arrays.asList(dropDownChoices)));
		chainring1.setValue(5);
		setup.addChainring(chainring1);
		
		ChoiceBox chainring2 = new ChoiceBox(FXCollections.observableArrayList(Arrays.asList(dropDownChoices)));
		chainring2.setValue(9);
		setup.addChainring(chainring2);
		
		ChoiceBox chainring3 = new ChoiceBox(FXCollections.observableArrayList(Arrays.asList(dropDownChoices)));
		// no value selected
		setup.addChainring(chainring3);
		
		ChoiceBox sprocket1 = new ChoiceBox(FXCollections.observableArrayList(Arrays.asList(dropDownChoices)));
		sprocket1.setValue(2);
		setup.addSprocket(sprocket1);
		
		ChoiceBox sprocket2 = new ChoiceBox(FXCollections.observableArrayList(Arrays.asList(dropDownChoices)));
		sprocket2.setValue(12);
		setup.addSprocket(sprocket2);
		
		ChoiceBox sprocket3 = new ChoiceBox(FXCollections.observableArrayList(Arrays.asList(dropDownChoices)));
		// no value selected
		setup.addSprocket(sprocket3);
		
		ArrayList<Combo> combos = setup.getSetupCombos();
		
		assertEquals(2, combos.size());
		
		assertEquals(12, combos.get(0).getMaxTeethCount());
		assertEquals(2, combos.get(1).getMinTeethCount());
		
		assertEquals(5, combos.get(0).getRingSize());
		assertEquals(9, combos.get(1).getRingSize());
		
		ArrayList<Double> expected1 = new ArrayList<>();
		expected1.add(5.0/2);
		expected1.add(5.0/12);
		
		ArrayList<Double> expected2 = new ArrayList<>();
		expected2.add(9.0/2);
		expected2.add(9.0/12);
		
		ArrayList<Double> actuals = combos.get(0).getGearRatios();
		
		assertEquals(2, actuals.size());
		
		for (Double gearRatioVal: actuals)
		{
			assertEquals(expected1.get(actuals.indexOf(gearRatioVal)), gearRatioVal, 0.01);
		}
		
		actuals = combos.get(1).getGearRatios();
		
		assertEquals(2, actuals.size());
		
		for (Double gearRatioVal: actuals)
		{
			assertEquals(expected2.get(actuals.indexOf(gearRatioVal)), gearRatioVal, 0.01);
		}
	} /* testBicycle1 */
	
	@Test
	public void testBicycle2()
	{
		Bicycle setup = new Bicycle();
		
		new JFXPanel();
		
		Integer[] dropDownChoices = {2, 5, 9, 12, 17};
		
		ChoiceBox chainring1 = new ChoiceBox(FXCollections.observableArrayList(Arrays.asList(dropDownChoices)));
		chainring1.setValue(5);
		setup.addChainring(chainring1);
		
		ChoiceBox chainring2 = new ChoiceBox(FXCollections.observableArrayList(Arrays.asList(dropDownChoices)));
		chainring2.setValue(9);
		setup.addChainring(chainring2);
		
		ChoiceBox chainring3 = new ChoiceBox(FXCollections.observableArrayList(Arrays.asList(dropDownChoices)));
		// no value selected
		setup.addChainring(chainring3);
		
		assertEquals(3, setup.getChainrings().size());
		
		ChoiceBox sprocket1 = new ChoiceBox(FXCollections.observableArrayList(Arrays.asList(dropDownChoices)));
		// no value selected
		setup.addSprocket(sprocket1);
		
		ChoiceBox sprocket2 = new ChoiceBox(FXCollections.observableArrayList(Arrays.asList(dropDownChoices)));
		// no value selected
		setup.addSprocket(sprocket2);
		
		ChoiceBox sprocket3 = new ChoiceBox(FXCollections.observableArrayList(Arrays.asList(dropDownChoices)));
		// no value selected
		setup.addSprocket(sprocket3);
		
		ChoiceBox sprocket4 = new ChoiceBox(FXCollections.observableArrayList(Arrays.asList(dropDownChoices)));
		// no value selected
		setup.addSprocket(sprocket4);
		
		assertEquals(4, setup.getSprockets().size());
		
		ArrayList<Combo> combos = setup.getSetupCombos();
		
		assertEquals(0, combos.size());
	} /* testBicycle2 */
} /* MainAppTest */