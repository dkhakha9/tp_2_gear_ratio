import javafx.scene.Node;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class GearRatiosChart
{
	final NumberAxis xAxis;
	final CategoryAxis yAxis;
	final LineChart<Number, String> lineChart;
	
	public GearRatiosChart()
	{
		xAxis = new NumberAxis();
		yAxis = new CategoryAxis();
		
		xAxis.setLabel("Ratio");
		
		lineChart = new LineChart<Number, String>(xAxis,yAxis);
		
		lineChart.setTitle("Gear Ratios");
	}
	
	public Node getChart()
	{
        XYChart.Series series = new XYChart.Series();
        series.setName("Bike 1");
        
        series.getData().add(new XYChart.Data(1, "46t x 11-28"));
        series.getData().add(new XYChart.Data(2, "46t x 11-28"));
        series.getData().add(new XYChart.Data(4, "46t x 11-28"));        
        
        lineChart.getData().add(series);
        
        return lineChart;

    }
}
