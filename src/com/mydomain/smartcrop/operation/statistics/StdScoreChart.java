package com.mydomain.smartcrop.operation.statistics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Marker;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public class StdScoreChart {
    
    private JFreeChart chart = null;
    List<Long> rows;
    List<Long> cols;
    
    public StdScoreChart(List<Long> rows, List<Long> cols) {
        this.rows = rows;
        this.cols = cols;
        getJFreeChart();
    }
    
    public final JFreeChart getJFreeChart() {
        if (chart != null)
            return chart;
        
        // Create 2 simple XY series and load data
        XYSeries series1 = new XYSeries("Rows");
        int i = 0;
        for (Long value : rows) {
            series1.add(i, value);
            i++;
        }

        XYSeries series2 = new XYSeries("Columns");
        i = 0;
        for (Long value : cols) {
            series2.add(i, value);
            i++;
        }

        // Add the series to your data set
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);

        // Generate the graph
        chart = ChartFactory.createXYLineChart(
                "Gray statistics", // Title
                "Distance from the top left corner in pixel", // x-axis Label
                "Sum of gray values", // y-axis Label
                dataset, // Dataset
                PlotOrientation.VERTICAL, // Plot Orientation
                true, // Show Legend
                true, // Use tooltips
                false // Configure chart to generate URLs?
                );        

        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, true);
        renderer.setSeriesShapesVisible(0, true);
        plot.setRenderer(renderer);        
        //ValueAxis xAxis = plot.getDomainAxis();
        //ValueAxis yAxis = plot.getRangeAxis();  
        //xAxis.setRange(0, 2172);
        //yAxis.setRange(0, 255);
        
        return chart;        
    }
    
    public void setSingularities(Singularities rowSing, Singularities colSing) {
        //Rectangle rectangle = stdScoreCrop.getBoundingRectangle();
        //HashMap<String, Integer> cropPoints = rectangleToMap(rectangle);
        List<Singularities> singList = new ArrayList<Singularities>();
        singList.add(rowSing);
        singList.add(colSing);
        int i = 0;
        for (Singularities sing : singList) {
            Marker marker1 = new ValueMarker(sing.getX0());
            Marker marker2 = new ValueMarker(sing.getX1());
            if (i==1) {
                marker1.setPaint(Color.BLUE);
                marker2.setPaint(Color.BLUE);
            } else {
                marker1.setPaint(Color.RED);
                marker2.setPaint(Color.RED);
            }
            BasicStroke stroke = new BasicStroke(
                    1.0f,                      // Width
                    BasicStroke.CAP_SQUARE,    // End cap
                    BasicStroke.JOIN_MITER,    // Join style
                    10.0f,                     // Miter limit
                    new float[] {8.0f,6.0f},   // Dash pattern
                    0.0f);                     // Dash phase
            marker1.setStroke(stroke);
            marker2.setStroke(stroke);
            //originalEnd.setLabel("Original Close (02:00)");
            //originalEnd.setLabelAnchor(RectangleAnchor.TOP_LEFT);
            //originalEnd.setLabelTextAnchor(TextAnchor.TOP_RIGHT);
            chart.getXYPlot().addDomainMarker(marker1);
            chart.getXYPlot().addDomainMarker(marker2);
            
            i++;
        }
    }
    
    public BufferedImage getChartImage(int width, int height) {
        if (chart == null)
            getJFreeChart();
        return chart.createBufferedImage(width, height);
    }
}
