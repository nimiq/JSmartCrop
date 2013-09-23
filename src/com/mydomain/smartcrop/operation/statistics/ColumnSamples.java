package com.mydomain.smartcrop.operation.statistics;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class ColumnSamples extends AbstractSamples {

    
    public ColumnSamples(BufferedImage image) {
        super.samples = new ArrayList<Long>();
        for (int col = 0; col < image.getWidth(); col++) {
            long sum = 0;
            for (int row = 0; row < image.getHeight(); row++)
                sum += image.getRaster().getSample(col, row, 0);
            samples.add(sum);
        }
        computeStatistics();
    }
}
