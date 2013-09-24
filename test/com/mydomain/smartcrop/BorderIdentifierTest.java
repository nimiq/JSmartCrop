package com.mydomain.smartcrop;

import static org.junit.Assert.assertEquals;
import ij.ImagePlus;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import org.junit.Before;
import org.junit.Test;

import com.mydomain.smartcrop.procedure.RegularProcedure;
import com.mydomain.smartcrop.utils.IOImage;


public class BorderIdentifierTest {

    private BorderIdentifier borderId;
    private ImagePlus image;
    
    @Before
    public void setUp() throws Exception {
        String path = "test/resources/1.png";
        BufferedImage imageB = IOImage.getImage(path);
        image = new ImagePlus("", imageB);        
        borderId = new BorderIdentifier(new RegularProcedure());
    }

    @Test
    public void testExecute() {
        Rectangle rec = borderId.execute(image);
        assertEquals(rec.x, 33);
        assertEquals(rec.y, 34);
        assertEquals(rec.height, 274);
        assertEquals(rec.width, 195);
    }

}
