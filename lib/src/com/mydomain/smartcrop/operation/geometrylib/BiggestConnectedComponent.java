package com.mydomain.smartcrop.operation.geometrylib;

import ij.ImagePlus;
import ij.blob.Blob;
import ij.blob.ManyBlobs;
import ij.process.ImageProcessor;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.image.BufferedImage;

import com.mydomain.smartcrop.operation.AbstractComputerVisionOperation;
import com.mydomain.smartcrop.operation.Operation;

/**
 * Specificare bene che interpreta il nero come background e il bianco come foreground (qs perche io faccio il negativo)
 * @author Paolo Coffetti
 *
 */
public class BiggestConnectedComponent extends AbstractComputerVisionOperation implements Operation {

    private ImagePlus image;
    private ManyBlobs components = null;
    
    @Override
    public ImagePlus execute(ImagePlus image) {
        // Negative (perche qs processo interpreta il bianco come sfondo e nero come primo piano)
        //ImageAnalysisOperation operation = new Negative();
        //this.image = operation.execute(image);
        this.image = image;
        ImageProcessor p = this.image.getProcessor();
        p.invertLut();
        
        
        Polygon biggest = getBiggestRectangle();
        return setPolygonAsuniqueForeground(image, biggest);
    }

    private ManyBlobs getComponents() {
        if (components == null) {
            components = new ManyBlobs(image); // Extended ArrayList
            components.findConnectedComponents(); // Start the Connected Component Algorithm
        }
        
        return components;
    }
    
    private Polygon getBiggestRectangle() {
        if (components == null)
            components = getComponents();
        
        Blob biggest = components.get(0); //TODO: potrebbe essere che il num 0 non ci sia??
        for (Blob blob : components) {
            if (blob.getEnclosedArea() > biggest.getEnclosedArea())
                biggest = blob;
        }
        return biggest.getOuterContour();
    }
    
    private ImagePlus setPolygonAsuniqueForeground(ImagePlus image, Polygon polygon) {
        BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(), image.getBufferedImage().getType());
        Graphics2D g = result.createGraphics();

        g.setBackground(Color.BLACK);
        g.fill(polygon);
        g.dispose();        
        return new ImagePlus("Labbeled", result);
    }
}
