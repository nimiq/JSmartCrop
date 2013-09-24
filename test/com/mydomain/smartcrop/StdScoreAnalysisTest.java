package com.mydomain.smartcrop;

import static org.junit.Assert.assertEquals;
import ij.ImagePlus;

import java.awt.image.BufferedImage;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.mydomain.smartcrop.operation.statistics.AbstractSamples;
import com.mydomain.smartcrop.operation.statistics.Singularities;
import com.mydomain.smartcrop.operation.statistics.StdScoreAnalysis;
import com.mydomain.smartcrop.utils.IOImage;

public class StdScoreAnalysisTest {

    private ImagePlus image;
    
    @Before
    public void setUp() throws Exception {
        String path = "test/resources/1.png";
        BufferedImage imageB = IOImage.getImage(path);
        image = new ImagePlus("", imageB);
    }

    @Test
    public void testExecute() {
        StdScoreAnalysis an = new StdScoreAnalysis();
        an.execute(image);
        AbstractSamples rows = an.getRows();
        assertEquals(42485.42, rows.getMean(), 0.01);
    }

    @Test
    public void testGetRowSingularities() {
        StdScoreAnalysis an = new StdScoreAnalysis();
        an.execute(image);
        Singularities sing = an.getRowSingularities();
        assertEquals(sing.getX0(), 34);
        assertEquals(sing.getX1(), 308);        
    }

    @Test
    public void testGetColSingularities() {
        StdScoreAnalysis an = new StdScoreAnalysis();
        an.execute(image);
        Singularities sing = an.getColSingularities();
        assertEquals(sing.getX0(), 33);
        assertEquals(sing.getX1(), 228);        
    }

    @Ignore
    @Test
    public void testGetThreshold() {
      //no sense to test this getter
    }

    @Ignore
    @Test
    public void testGetWhiteExtraBorderIdentificationPolicy() {
        //no sense to test this getter
    }

    @Ignore
    @Test
    public void testGetWhiteExtraBorderVerificationPolicy() {
      //no sense to test this getter
    }

    @Ignore
    @Test
    public void testGetRows() {
      //no sense to test this getter
    }

    @Ignore
    @Test
    public void testGetCols() {
      //no sense to test this getter
    }

}
