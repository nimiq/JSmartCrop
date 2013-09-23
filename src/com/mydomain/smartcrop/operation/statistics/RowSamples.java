package com.mydomain.smartcrop.operation.statistics;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class RowSamples extends AbstractSamples {

    
    public RowSamples(BufferedImage image) {
        super.samples = new ArrayList<Long>();
        for (int row = 0; row < image.getHeight(); row++) {
            long sum = 0;
            for (int col = 0; col < image.getWidth(); col++)
                sum += image.getRaster().getSample(col, row, 0);
            samples.add(sum);
        }
        computeStatistics();
    }
}
