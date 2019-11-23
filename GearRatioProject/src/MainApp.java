import edu.princeton.cs.introcs.StdOut;

public class MainApp
{

	public static void main(String[] args)
	{
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
		
		Calculator calc = new Calculator(chainring, cassette);
		calc.calculateGearRatios();
		StdOut.println(calc.getGearRatios());
		StdOut.println("Thank you for using Gear Ratio App\n");
	}

}
