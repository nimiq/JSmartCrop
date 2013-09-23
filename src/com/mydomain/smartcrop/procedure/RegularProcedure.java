package com.mydomain.smartcrop.procedure;

import ijt.filter.morphology.Strel;
import ijt.filter.morphology.strel.LinearHorizontalStrel;
import ijt.filter.morphology.strel.LinearVerticalStrel;

import com.mydomain.smartcrop.operation.AbstractComputerVisionOperation;
import com.mydomain.smartcrop.operation.color.GrayScaleConversion;
import com.mydomain.smartcrop.operation.colorlib.OtsuThreshold;
import com.mydomain.smartcrop.operation.morphology.Closing;

public class RegularProcedure extends AbstractProcedure {

	public void setConfiguration(Configuration conf) {
		super.setConfiguration(conf);
		
        AbstractComputerVisionOperation operation;
        
        // 1. Convert to grayscale
        operation = new GrayScaleConversion(2); //using a fixed saturation value
        addOperation(operation);
        
        // 2. Closing (remove dark blobs) horizontally
        Strel strel = new LinearHorizontalStrel(51);
        operation = new Closing(strel);
        addOperation(operation);

        // 3. Closing (remove dark blobs) vertically
        strel = new LinearVerticalStrel(7);
        operation = new Closing(strel);
        addOperation(operation);

        // 4. OTSU Thresholding
        operation = new OtsuThreshold();
        addOperation(operation);
        
        
    }
}
