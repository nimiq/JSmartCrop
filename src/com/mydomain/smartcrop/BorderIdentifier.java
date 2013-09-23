package com.mydomain.smartcrop;

import java.awt.Rectangle;

import com.mydomain.smartcrop.operation.AbstractComputerVisionOperation;
import com.mydomain.smartcrop.operation.Operation;
import com.mydomain.smartcrop.operation.statistics.Singularities;
import com.mydomain.smartcrop.operation.statistics.StdScoreAnalysis;
import com.mydomain.smartcrop.procedure.AbstractProcedure;

import ij.ImagePlus;

public class BorderIdentifier implements Operation {
    
    final private AbstractProcedure procedure;
    private StdScoreAnalysis stdScoreAnalysis;

    public BorderIdentifier(final AbstractProcedure procedure) { //TODO: ci sono dei param??
        this.procedure = procedure;
    }
    
    @Override
    public Rectangle execute(final ImagePlus image) {
    	ImagePlus result = image;
        for (final AbstractComputerVisionOperation op : procedure.getOperations())
        	result = op.execute(result);
        
        stdScoreAnalysis = procedure.getStdScoreAnalysis();
        stdScoreAnalysis.execute(result);
        
        final Singularities rowSingularity = stdScoreAnalysis.getRowSingularities();
        final Singularities colSingularity = stdScoreAnalysis.getColSingularities();
        
        Rectangle innerBorder = new Rectangle(
                colSingularity.getX0(),
                rowSingularity.getX0(),
                colSingularity.getX1()-colSingularity.getX0(),
                rowSingularity.getX1()-rowSingularity.getX0());
        
        return innerBorder;
    }

    /**
     * @return the stdScoreAnalysis
     */
    public StdScoreAnalysis getStdScoreAnalysis() {
        return stdScoreAnalysis;
    }

}
