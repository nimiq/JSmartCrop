package com.mydomain.smartcrop.operation.geometry;

import ij.ImagePlus;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;

import com.mydomain.smartcrop.operation.AbstractComputerVisionOperation;
import com.mydomain.smartcrop.operation.Operation;


public class Crop extends AbstractComputerVisionOperation implements Operation {

    private boolean doNotCropButBound = false;
    private Rectangle rectangle;
    
    
    public Crop(Rectangle rectangle){
        this.rectangle = rectangle;
    }
    
    public Crop(Rectangle rectangle, boolean doNotCropButBound){
        this.doNotCropButBound = doNotCropButBound;
        this.rectangle = rectangle;
    }    
    
    @Override
    public ImagePlus execute(ImagePlus image) {
        BufferedImage result;
        if (!doNotCropButBound) {
            BufferedImage imgB = image.getBufferedImage();
            BufferedImage toDraw = imgB.getSubimage(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
            result = new BufferedImage(toDraw.getWidth(), toDraw.getHeight(), imgB.getType()); //BufferedImage.TYPE_BYTE_GRAY is (int) 10
            Graphics2D g = result.createGraphics();
            g.drawRenderedImage(toDraw, null);
            g.dispose();            
            return new ImagePlus("Cropped", result);
            /* The following line would be enough (instead of all the previous lines in this method, but if the resulting ImageBuffer is converted
             *  to ImagePlus there will be a problem (noisy horizontal lines). This is probably a bug. I run some performance test and seems that
             *  there is no difference.
             */
            //return image.getBufferedImage().getSubimage(cropPoints.get("x0"), cropPoints.get("y0"), cropPoints.get("x1")-cropPoints.get("x0"), cropPoints.get("y1")-cropPoints.get("y0"));
        } else {
            result = new BufferedImage(image.getWidth(), image.getHeight(), ColorSpace.TYPE_RGB);
            Graphics2D g = result.createGraphics();
            g.drawRenderedImage(image.getBufferedImage(), null);
            g.setColor(Color.RED);
            g.setStroke(new BasicStroke(10));
            //g.drawRect(cropPoints.get("x0"), cropPoints.get("y0"), cropPoints.get("x1")-cropPoints.get("x0"), cropPoints.get("y1")-cropPoints.get("y0"));
            g.draw(rectangle);
            g.dispose();
        }
        return new ImagePlus("Cropped", result);
    }
}
