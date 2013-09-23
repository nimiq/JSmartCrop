package com.mydomain.smartcrop.operation.morphology;


import ij.ImagePlus;
import ij.process.ImageProcessor;
import ijt.filter.morphology.Morphology;
import ijt.filter.morphology.Strel;

import com.mydomain.smartcrop.operation.AbstractComputerVisionOperation;
import com.mydomain.smartcrop.operation.Operation;

public class Opening extends AbstractComputerVisionOperation implements Operation {

    private Strel structuringElement;
    
    public Opening(Strel structuringElement) {
        this.structuringElement = structuringElement;
    }
    
    @Override
    public ImagePlus execute(ImagePlus image) {
        ImageProcessor imgProc = Morphology.opening(image.getProcessor(), structuringElement);
        return new ImagePlus("Opening", imgProc);
    }

}
