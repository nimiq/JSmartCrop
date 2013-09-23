package com.mydomain.smartcrop.procedure;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import com.mydomain.smartcrop.operation.AbstractComputerVisionOperation;
import com.mydomain.smartcrop.operation.color.GrayScaleConversion;
import com.mydomain.smartcrop.operation.colorlib.StretchHistogram;
import com.mydomain.smartcrop.operation.geometrylib.Deskew;
import com.mydomain.smartcrop.operation.statistics.StdScoreAnalysis;

public abstract class AbstractProcedure {

    private List<AbstractComputerVisionOperation> operations;
    private List<AbstractComputerVisionOperation> preProcessingOperations;
    private List<AbstractComputerVisionOperation> postProcessingOperations;
    private Configuration conf;

    public void setConfiguration(Configuration conf) {
    	this.conf = conf;
        operations = new ArrayList<AbstractComputerVisionOperation>();
        preProcessingOperations = new ArrayList<AbstractComputerVisionOperation>();
        postProcessingOperations = new ArrayList<AbstractComputerVisionOperation>();
        AbstractComputerVisionOperation operation;
        
        // ---------- PREPROCESSING ----------
        // Deskew pre-processing
        if (conf.isDeskewDuringPreProcessing()) {
            operation = new Deskew(conf.getDeskewThresholdPre(), Color.BLACK);
            addPreProcessingOperation(operation);
        }
        
        
        // ---------- POST-PROCESSING ----------
        // Deskew post-processing
        if (conf.isDeskewDuringPostProcessing()) {
            operation = new Deskew(conf.getDeskewThresholdPost(), Color.WHITE);
            addPostProcessingOperation(operation);
        }
        
        // Convert to grayscale
        if (conf.isGrayscaleDuringPostProcessing()) {
            operation = new GrayScaleConversion(0); //0 means no strecth histogram
            addPostProcessingOperation(operation);
        }
        
        // Stretch Histogram to increase contract
        if (conf.isStretchHistogramDuringPostProcessing()) {
            operation = new StretchHistogram(conf.getStretchHistogramThresholdDuringPostProcessing());
            addPostProcessingOperation(operation);
        }
    }
    
    public StdScoreAnalysis getStdScoreAnalysis() {
        StdScoreAnalysis s = new StdScoreAnalysis(conf.getThresholdStdDev(), conf.getWhiteExtraBorderIdentificationPolicy(), conf.getWhiteExtraBorderVerificationPolicy());
        return s;
    }
    
    public List<AbstractComputerVisionOperation> getOperations() {
        return operations;
    }
    
    public void addOperation(AbstractComputerVisionOperation operation) {
        operations.add(operation);
    }
    
    public List<AbstractComputerVisionOperation> getPreProcessingOperations() {
        return preProcessingOperations;
    }
    
    public final void addPreProcessingOperation(AbstractComputerVisionOperation operation) {
        preProcessingOperations.add(operation);
    }
    
    public List<AbstractComputerVisionOperation> getPostProcessingOperations() {
        return postProcessingOperations;
    }
    
    public final void addPostProcessingOperation(AbstractComputerVisionOperation operation) {
        postProcessingOperations.add(operation);
    }
}
