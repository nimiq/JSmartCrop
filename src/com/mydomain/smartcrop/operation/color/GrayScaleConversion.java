package com.mydomain.smartcrop.operation.color;


import ij.ImagePlus;
import ij.process.ImageConverter;

import com.mydomain.smartcrop.operation.AbstractComputerVisionOperation;
import com.mydomain.smartcrop.operation.Operation;
import com.mydomain.smartcrop.operation.colorlib.StretchHistogram;

public class GrayScaleConversion extends AbstractComputerVisionOperation implements Operation {

    private float saturation = 2;
    
    public GrayScaleConversion() {}
    
    public GrayScaleConversion(float saturation) {
        this.saturation = saturation;
    }
    
    @Override
    public ImagePlus execute(ImagePlus image) {
        // Check if it is already grayscale
        if (image.getBufferedImage().getType() == 10) //10 means grayscale 8 bit
            return image;
        
        ImagePlus imgp = new ImagePlus("Grayscale", image.getBufferedImage());
        ImageConverter imgc = new ImageConverter(imgp);
        imgc.convertToGray8();

        //Contrast optimization
        AbstractComputerVisionOperation operation = new StretchHistogram(saturation);
        imgp = operation.execute(imgp);

        return imgp;
    }

}
