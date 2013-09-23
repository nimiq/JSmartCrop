package com.mydomain.smartcrop;

import ij.ImagePlus;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.List;

import com.mydomain.smartcrop.operation.AbstractComputerVisionOperation;
import com.mydomain.smartcrop.operation.geometry.Crop;
import com.mydomain.smartcrop.procedure.AbstractProcedure;
import com.mydomain.smartcrop.utils.IOImage;

public class Scan {
    
    private BufferedImage image;
    private AbstractProcedure procedure;
    private Rectangle innerBorder;
    private boolean postProcessed = false;
    
    public Scan(BufferedImage image, AbstractProcedure procedure) {
        this.image = image;
        this.procedure = procedure;
        
        // Run preprocessing straight away
        runPreProcessing();
    }
    
    public BufferedImage getImage() {
        return image;
    }
    
    public void setInnerBorder(Rectangle rectangle) {
        innerBorder = rectangle;
    }
    
    public BufferedImage getPaperImage() {
        runPostProcessing();
        AbstractComputerVisionOperation op = new Crop(innerBorder);
        ImagePlus imgP = op.execute(new ImagePlus("", image));
        return imgP.getBufferedImage();
    }

    public BufferedImage getBoundedPaperImage() {
        runPostProcessing();
        AbstractComputerVisionOperation op = new Crop(innerBorder, true);
        ImagePlus imgP = op.execute(new ImagePlus("", image));
        return imgP.getBufferedImage();
    }

    public void savePaperTofile(String path) {
        runPostProcessing();
        BufferedImage img = getPaperImage();
        IOImage.saveImage(img, path);
    }
    
    public void runPostProcessing() {
        List<AbstractComputerVisionOperation> operations = procedure.getPostProcessingOperations();
        if (!postProcessed && !operations.isEmpty()) {
            
            ImagePlus imgP = new ImagePlus("", image);
            for (AbstractComputerVisionOperation op : operations) {
                imgP = op.execute(imgP);
            }
            image = imgP.getBufferedImage();
        }
        postProcessed = true;
    }

    private void runPreProcessing() {
        List<AbstractComputerVisionOperation> operations = procedure.getPreProcessingOperations();
        if (!operations.isEmpty()) {
            
            ImagePlus imgP = new ImagePlus("", image);
            for (AbstractComputerVisionOperation op : operations) {
                imgP = op.execute(imgP);
            }
            image = imgP.getBufferedImage();
        }
    }

}
