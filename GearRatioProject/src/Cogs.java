
public class Cogs extends Gear  {

	private static final int MAX_TEETH = 32;
	private static final int MIN_TEETH = 11;
	
	public Cogs(int teethCount) throws Exception {
		super(teethCount);
		
		if (teethCount < MIN_TEETH && teethCount > MAX_TEETH) {
			throw new Exception("Teeth count out of  possible range");
		}
	}

}
