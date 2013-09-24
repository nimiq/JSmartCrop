package com.mydomain.smartcrop;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.mydomain.smartcrop.operation.statistics.AbstractSamples;
import com.mydomain.smartcrop.operation.statistics.RowSamples;
import com.mydomain.smartcrop.utils.IOImage;

public class RowSamplesTest {

    private AbstractSamples samples;
    
    @Before
    public void setUp() throws Exception {
        String path = "test/resources/2.png";
        BufferedImage image = IOImage.getImage(path);
        samples = new RowSamples(image);
    }
    
    @Test
    public void testGetMean() {
        assertEquals(382.5, samples.getMean(), 0.1);
    }

    @Test
    public void testGetStdDev() {
        assertEquals(272.60648, samples.getStdDev(), 0.00001);
    }

    @Test
    public void testGetSamples() {
        List<Long> actualSamplesList = new ArrayList<Long>();
        actualSamplesList.add(255L);
        actualSamplesList.add(255L);
        actualSamplesList.add(255L);
        actualSamplesList.add(765L);
        actualSamplesList.add(510L);
        actualSamplesList.add(255L);
        actualSamplesList.add(765L);
        actualSamplesList.add(0L);
        Long[] a1 = new Long[8];
        a1 = actualSamplesList.toArray(a1);
        
        List<Long> samplesList = samples.getSamples();
        Long[] a2 = new Long[8];
        a2 = samplesList.toArray(a2);
        
        assertArrayEquals(a1, a2);
    }

    @Test
    public void testGetStdScores() {
        List<Float> actualScoresList = new ArrayList<Float>();
        actualScoresList.add(-0.46770716F);
        actualScoresList.add(-0.46770716F);
        actualScoresList.add(-0.46770716F);
        actualScoresList.add(1.4031215F);
        actualScoresList.add(0.46770716F);
        actualScoresList.add(-0.46770716F);
        actualScoresList.add(1.4031215F);
        actualScoresList.add(-1.4031215F);
        
        Float[] a1 = new Float[8];
        a1 = actualScoresList.toArray(a1);
        
        List<Float> scoresList = samples.getStdScores().getScores();
        Float[] a2 = new Float[8];
        a2 = scoresList.toArray(a2);
        
        assertArrayEquals(a1, a2);
    }

    @Test
    public void testComputeStatistics() {
        //DOesn't make sense to test this
    }

}
