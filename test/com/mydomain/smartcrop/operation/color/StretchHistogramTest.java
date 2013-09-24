package com.mydomain.smartcrop.operation.color;

import ij.ImagePlus;

import java.awt.image.BufferedImage;

import org.junit.Before;
import org.junit.Test;

import com.mydomain.smartcrop.operation.AbstractComputerVisionOperation;
import com.mydomain.smartcrop.operation.colorlib.StretchHistogram;
import com.mydomain.smartcrop.utils.IOImage;

public class StretchHistogramTest {

    ImagePlus image;
    
    @Before
    public void setUp() throws Exception {
        String path = "test/resources/1.png";
        BufferedImage imageB = IOImage.getImage(path);
        image = new ImagePlus("", imageB);          
    }

    @Test
    public void testExecute() {
        AbstractComputerVisionOperation op = new StretchHistogram(80);
        image = op.execute(image);
        image.show();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
