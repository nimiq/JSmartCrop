package com.mydomain.smartcrop.operation.statistics;

import java.util.List;

import com.mydomain.smartcrop.utils.Statistics;

public abstract class AbstractSamples {

    protected List<Long> samples;
    private Float mean = null;
    private Float stdDev = null;
    private StdScores scores = null;
    
    public float getMean() {
        if (mean == null)
            mean = Statistics.getMean(samples);
        return mean;
    }
    
    public float getStdDev() {
        if (stdDev == null)
            stdDev = Statistics.getStandardDeviation(samples);
        return stdDev;
    }
    
    public List<Long> getSamples() {
        return samples;
    }

    public StdScores getStdScores() {
        if (scores == null) {
            scores = new StdScores(samples, getMean(), getStdDev()); 
        }
        return scores;
    }
    
    protected void computeStatistics() {
        getMean();
        getStdDev();
        getStdScores();
    }
}
