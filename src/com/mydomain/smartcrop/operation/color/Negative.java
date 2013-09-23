package com.mydomain.smartcrop.operation.color;

import ij.ImagePlus;
import ij.process.ImageProcessor;
import ij.process.LUT;

import com.mydomain.smartcrop.operation.AbstractComputerVisionOperation;
import com.mydomain.smartcrop.operation.Operation;

public class Negative extends AbstractComputerVisionOperation implements Operation {

    @Override
    public ImagePlus execute(ImagePlus image) {
        ImageProcessor imgProc = image.getProcessor();
        LUT lut = imgProc.getLut().createInvertedLut();
        imgProc.setLut(lut);
        return new ImagePlus("Negative", imgProc); 
    }

}
