package com.mydomain.smartcrop.operation.statistics;

import com.mydomain.smartcrop.operation.Operation;

import ij.ImagePlus;


public class StdScoreAnalysis implements Operation {

    private Float threshold = null;
    private Integer whiteExtraBorderIdentificationPolicy = null;
    private Integer whiteExtraBorderVerificationPolicy = null;
    private AbstractSamples rows = null;
    private AbstractSamples cols = null;
    private Singularities rowSingularities = null;
    private Singularities colSingularities = null;
    StdScoreChart chart = null;

    public StdScoreAnalysis() {
    }
    
    public StdScoreAnalysis(float threshold) {
        this.threshold = threshold;
    }

    public StdScoreAnalysis(float threshold, int whiteExtraBorderIdentificationPolicy, int whiteExtraBorderVerificationPolicy) {
        this.threshold = threshold;
        this.whiteExtraBorderIdentificationPolicy = whiteExtraBorderIdentificationPolicy;
        this.whiteExtraBorderVerificationPolicy = whiteExtraBorderVerificationPolicy;
    }

    @Override
    public Integer execute(ImagePlus image) {
        rows = new RowSamples(image.getBufferedImage());
        cols = new ColumnSamples(image.getBufferedImage());
        
        // Creates the chart
        chart = new StdScoreChart(rows.getSamples(), cols.getSamples());
        chart.setSingularities(getRowSingularities(), getColSingularities());
            
        return 0;
    }
    
    public Singularities getRowSingularities() {
        if (rowSingularities == null) {
            if (rows != null) {
                SingularitiesFinder finder = new SingularitiesFinder(rows.getStdScores().getScores());
                rowSingularities = finder.getSingularities(threshold, whiteExtraBorderIdentificationPolicy, whiteExtraBorderVerificationPolicy);
            }
        }
        return rowSingularities;
    }

    public Singularities getColSingularities() {
        if (colSingularities == null) {
            if (cols != null) {
                SingularitiesFinder finder = new SingularitiesFinder(cols.getStdScores().getScores());
                colSingularities = finder.getSingularities(threshold, whiteExtraBorderIdentificationPolicy, whiteExtraBorderVerificationPolicy);
            }
        }
        return colSingularities;
    }

    public float getThreshold() {
        return threshold;
    }

    public int getWhiteExtraBorderIdentificationPolicy() {
        return whiteExtraBorderIdentificationPolicy;
    }

    public int getWhiteExtraBorderVerificationPolicy() {
        return whiteExtraBorderVerificationPolicy;
    }

    public AbstractSamples getRows() {
        return rows;
    }

    public AbstractSamples getCols() {
        return cols;
    }

    /**
     * @return the chart
     */
    public StdScoreChart getChart() {
        return chart;
    }

}
