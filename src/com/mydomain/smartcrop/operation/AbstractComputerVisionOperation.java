package com.mydomain.smartcrop.operation;

import ij.ImagePlus;

public abstract class AbstractComputerVisionOperation implements Operation {
   
    @Override
    public abstract ImagePlus execute(ImagePlus image);
}