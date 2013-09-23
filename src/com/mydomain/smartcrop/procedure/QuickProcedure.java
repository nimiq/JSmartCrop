package com.mydomain.smartcrop.procedure;

import com.mydomain.smartcrop.operation.AbstractComputerVisionOperation;
import com.mydomain.smartcrop.operation.color.GrayScaleConversion;

public class QuickProcedure extends AbstractProcedure {

	public void setConfiguration(Configuration conf) {
		super.setConfiguration(conf);
		
        AbstractComputerVisionOperation operation;
        
        // 1. Convert to grayscale
        operation = new GrayScaleConversion(2); //using a fixed saturation value
        addOperation(operation);
        
    }
}
