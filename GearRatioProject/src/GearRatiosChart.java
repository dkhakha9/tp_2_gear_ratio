import java.util.List;

import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class GearRatiosChart
{
	private NumberAxis xAxis;
	private NumberAxis yAxis;
	private LineChart<Number, Number> lineChart;
	private int setupCount;
	
	private static final double SERIES_OFFSET = 0.1;
	
	public GearRatiosChart()
	{
		xAxis = new NumberAxis();
		yAxis = new NumberAxis();
		
		xAxis.setLabel("Ratio");
		yAxis.setLabel("Setup");
		
		yAxis.setTickUnit(1);
		
		lineChart = new LineChart<Number, Number>(xAxis,yAxis);
		
		lineChart.setTitle("Gear Ratios");
		
		setupCount = 0;
	}
	
	public void addSetup(List<Combo> setup)
	{
		setupCount++;
		double comboPos = calcStartingPos(setup.size());
		
		for (Combo combo: setup)
		{
			addSeries(combo, comboPos);
			comboPos += SERIES_OFFSET;
		}
	}
	
	private double calcStartingPos(int setupSize)
	{
		return setupCount + (this.SERIES_OFFSET/2)*(1 - setupSize);
	}
	
	private void addSeries(Combo combo, double posY)
	{
		XYChart.Series series = new XYChart.Series();
        series.setName(combo.getRingSize() + "t x " + combo.getMinTeethCount() + "-" + combo.getMaxTeethCount());
        
        for (Double gearRatio: combo.getGearRatios())
        {
        	series.getData().add(new XYChart.Data(gearRatio, posY));
        }
        
        lineChart.getData().add(series);
	}
	
	public Node getChart()
	{
        return lineChart;
    }
}
