package com.mydomain.smartcrop.operation;

import ij.ImagePlus;

public interface Operation {
	
    public Object execute(ImagePlus image);
    
}
