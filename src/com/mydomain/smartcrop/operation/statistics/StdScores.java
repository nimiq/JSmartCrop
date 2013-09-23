package com.mydomain.smartcrop.operation.statistics;

import java.util.ArrayList;
import java.util.List;

import com.mydomain.smartcrop.utils.Statistics;

public class StdScores {

    private List<Float> scores;
    
    public <N extends Number> StdScores(List<N> samples, float mean, float stdDev) {
        scores = new ArrayList<Float>();
        scores.addAll(Statistics.getStandardScores(samples, mean, stdDev));
    }

    /**
     * @return the scores
     */
    public List<Float> getScores() {
        return scores;
    }
}
