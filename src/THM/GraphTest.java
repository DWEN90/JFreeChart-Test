package THM;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.experimental.chart.plot.CombinedCategoryPlot;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;


public class GraphTest extends ApplicationFrame {


	private static final long serialVersionUID = 1L;

    public GraphTest(String title, Dimension size) {
        super(title);
        JPanel chartPanel = createDemoPanel();
        chartPanel.setPreferredSize(size);
        setContentPane(chartPanel);
    }

    public static CategoryDataset createDataset1() {
    	
    	////////////////////////////////
    	// Liniendiegramm
    	////////////////////////////////
    	
        DefaultCategoryDataset result = new DefaultCategoryDataset();
        
        String series1 = "Red-Line"; // Die rote linie
        String series2 = "Blue-Line"; // Die blaue Linie
        
        // Wofür is das nötig? Wird das irgendwo dargestellt?
        String type1 = "Type 1";
        String type2 = "Type 2";
        String type3 = "Type 3";
        String type4 = "Type 4";
        String type5 = "Type 5";
        String type6 = "Type 6";
        String type7 = "Type 7";
        String type8 = "Type 8";

        result.addValue(1.0, series1, type1);
        result.addValue(4.0, series1, type2);
        result.addValue(3.0, series1, type3);
        result.addValue(5.0, series1, type4);
        result.addValue(5.0, series1, type5);
        result.addValue(7.0, series1, type6);
        result.addValue(7.0, series1, type7);
        result.addValue(22.0, series1, type8);

        result.addValue(5.0, series2, type1);
        result.addValue(7.0, series2, type2);
        result.addValue(6.0, series2, type3);
        result.addValue(8.0, series2, type4);
        result.addValue(4.0, series2, type5);
        result.addValue(4.0, series2, type6);
        result.addValue(2.0, series2, type7);
        result.addValue(-10.0, series2, type8);

        return result;
    }

    public static CategoryDataset createDataset2() {

		////////////////////////////////
		// Balkendiegramm
		////////////////////////////////
    	
        DefaultCategoryDataset result = new DefaultCategoryDataset();

        String series1 = "Green-Beam";
        String series2 = "Yellow-Beam";

        String type1 = "Beam 1";
        String type2 = "Beam 2";
        String type3 = "Beam 3";
        String type4 = "Beam 4";
        String type5 = "Beam 5";
        String type6 = "Beam 6";
        String type7 = "Beam 7";
        String type8 = "Beam 8";

        result.addValue(-5.0, series1, type1);
        result.addValue(-5.0, series1, type2);
        result.addValue(-5.0, series1, type3);
        result.addValue(-5.0, series1, type4);
        result.addValue(-5.0, series1, type5);
        result.addValue(-5.0, series1, type6);
        result.addValue(-5.0, series1, type7);
        result.addValue(-5.0, series1, type8);

        result.addValue(20.0, series2, type1);
        result.addValue(15.0, series2, type2);
        result.addValue(15.0, series2, type3);
        result.addValue(15.0, series2, type4);
        result.addValue(15.0, series2, type5);
        result.addValue(15.0, series2, type6);
        result.addValue(15.0, series2, type7);
        result.addValue(20.0, series2, type8);

        return result;

    }

    private static JFreeChart createChart() {

    	// Lieniendiagramm
        CategoryDataset dataset1 = createDataset1();
        NumberAxis rangeAxis1 = new NumberAxis("Value");
        
        rangeAxis1.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        rangeAxis1.setAxisLineVisible(true);
        
        LineAndShapeRenderer renderer1 = new LineAndShapeRenderer();
        renderer1.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
        
        CategoryPlot subplot1 = new CategoryPlot(dataset1, null, rangeAxis1, renderer1);
        subplot1.setDomainGridlinesVisible(true);

        //Balkendiagramm
        CategoryDataset dataset2 = createDataset2();
        NumberAxis rangeAxis2 = new NumberAxis("Value");
        
        rangeAxis2.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        
        BarRenderer renderer2 = new BarRenderer();
        renderer2.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
        
        CategoryPlot subplot2 = new CategoryPlot(dataset2, null, rangeAxis2, renderer2);
        subplot2.setDomainGridlinesVisible(true);
      
        //Achsen erstellen
        CategoryAxis domainAxis = new CategoryAxis("Category");
        CombinedCategoryPlot plot = new CombinedCategoryPlot(domainAxis, new NumberAxis("Range")); 
        
        //Beide Dieagramme hinzufügen
        plot.add(subplot1, 2);
        plot.add(subplot2, 1);

        JFreeChart result = new JFreeChart("INSIDE TITLE TEST", new Font("SansSerif", Font.BOLD, 12), plot, true);
        return result;

    }

    public static JPanel createDemoPanel() {
        JFreeChart chart = createChart();
        return new ChartPanel(chart);
    }

    public static void main(String[] args) {
        String title = "THM Test 1";
        Dimension size = new Dimension(800, 800);
        GraphTest demo = new GraphTest(title, size);
        
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }

}
