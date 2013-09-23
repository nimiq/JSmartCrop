package com.mydomain.smartcrop.utils;

import java.util.ArrayList;
import java.util.List;

public class Statistics {

    public static <N extends Number> float getMean(List<N> data) {
        float sum = 0;
        for(N n : data)
            sum += n.floatValue();
        float mean = sum/data.size();
        return mean;
    }

    public static <N extends Number> float getVariance(List<N> data) {
        float mean = getMean(data);
        float temp = 0;
        for(N n : data)
            temp += (n.floatValue()-mean)*(n.floatValue()-mean);
        float variance = temp/data.size();
        return variance;
    }

    public static <N extends Number> float getStandardDeviation(List<N> data) {
        long size = data.size();
        float stdDev = (float)Math.sqrt(getVariance(data) * size / (size-1));
        return stdDev;
    }

    public static <N extends Number> List<Float> getStandardScores(List<N> data) {
        //http://en.wikipedia.org/wiki/Normalization_%28statistics%29
        List<Float> stdScores = new ArrayList<Float>(data.size());
        for (N n : data)
            stdScores.add((n.floatValue() - getMean(data)) / getStandardDeviation(data));
        return stdScores;
    }

    public static <N extends Number> List<Float> getStandardScores(List<N> data, float mean, float stdDev) {
        //http://en.wikipedia.org/wiki/Normalization_%28statistics%29
        List<Float> stdScores = new ArrayList<Float>(data.size());
        for (N n : data)
            stdScores.add((n.floatValue() - mean) / stdDev);
        return stdScores;
    }

}
