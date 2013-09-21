package com.mydomain.smartcrop.operation.colorlib;


import ij.CompositeImage;
import ij.IJ;
import ij.ImagePlus;
import ij.process.FloatProcessor;
import ij.process.ImageProcessor;
import ij.process.ImageStatistics;
import ij.process.ShortProcessor;

import com.mydomain.smartcrop.operation.AbstractComputerVisionOperation;
import com.mydomain.smartcrop.operation.Operation;

/**
 * Stretches the historgram to increase contrast
 * Works with color or grayscale images
 *  
 */
public class StretchHistogram extends AbstractComputerVisionOperation implements Operation {
    
    private final int MIN_MAX = 16;
    private boolean normalize = true;
    private float saturated = 0.35F;
    private int max, range;
    private boolean classicEqualization;

    public StretchHistogram(float saturated) {
        this.saturated = saturated;
    }

    public StretchHistogram(float saturated, boolean normalize) {
        this.saturated = saturated;
        this.normalize = normalize;
    }
    
    @Override
    public ImagePlus execute(ImagePlus image) {
        ImageStatistics stats = null;
        ImagePlus imp = new ImagePlus("", image.getBufferedImage());
        ImageProcessor ip = imp.getProcessor();
        ip.setRoi(imp.getRoi());
        if (stats==null)
            stats = ImageStatistics.getStatistics(ip, MIN_MAX, null);
        if (imp.isComposite())
            stretchCompositeImageHistogram((CompositeImage)imp, saturated, stats);
        else
            stretchHistogram(ip, saturated, stats);
        return imp;
    }

    private void stretchHistogram(ImageProcessor ip, float saturated, ImageStatistics stats) {
        //System.out.println("stretchHistogram");//TODO
        int[] a = getMinAndMax(ip, saturated, stats);
        int hmin=a[0], hmax=a[1];
        //IJ.log(hmin+" "+hmax+" "+threshold);
        if (hmax>hmin) {
            double min = stats.histMin+hmin*stats.binSize;
            double max = stats.histMin+hmax*stats.binSize;
            if (stats.histogram16!=null && ip instanceof ShortProcessor) {
                min = hmin;
                max = hmax;
            }
            if (normalize) {
                //System.out.println("devo normalizza " + min + " " + max);//TODO
                normalize(ip, min, max);
            } else
                ip.setMinAndMax(min, max);
        }
    }

    private void stretchCompositeImageHistogram(CompositeImage imp, float saturated, ImageStatistics stats) {
        ImageProcessor ip = imp.getProcessor();
        int[] a = getMinAndMax(ip, saturated, stats);
        int hmin=a[0], hmax=a[1];
        if (hmax>hmin) {
            double min = stats.histMin+hmin*stats.binSize;
            double max = stats.histMin+hmax*stats.binSize;
            if (stats.histogram16!=null && imp.getBitDepth()==16) {
                min = hmin;
                max = hmax;
            }
            imp.setDisplayRange(min, max);
        }
    }

    private int[] getMinAndMax(ImageProcessor ip, float saturated, ImageStatistics stats) {
        int hmin, hmax;
        int threshold;
        int[] histogram = stats.histogram;
        if (stats.histogram16!=null && ip instanceof ShortProcessor)
            histogram = stats.histogram16;
        int hsize = histogram.length;
        if (saturated>0.0)
            threshold = (int)(stats.pixelCount*saturated/200.0);
        else
            threshold = 0;
        int i = -1;
        boolean found = false;
        int count = 0;
        int maxindex = hsize-1;
        do {
            i++;
            count += histogram[i];
            found = count>threshold;
        } while (!found && i<maxindex);
        hmin = i;

        i = hsize;
        count = 0;
        do {
            i--;
            count += histogram[i];
            found = count>threshold;
        } while (!found && i>0);
        hmax = i;
        int[] a = new int[2];
        a[0]=hmin; a[1]=hmax;
        return a;
    }

    private void normalize(ImageProcessor ip, double min, double max) {
        //System.out.println("Sto normalizzando");//TODO
        int max2 = 255;
        int range = 256;
        if (ip instanceof ShortProcessor)
        {max2 = 65535; range=65536;}
        else if (ip instanceof FloatProcessor)
            normalizeFloat(ip, min, max);

        //double scale = range/max-min);
        int[] lut = new int[range];
        for (int i=0; i<range; i++) {
            if (i<=min)
                lut[i] = 0;
            else if (i>=max)
                lut[i] = max2;
            else
                lut[i] = (int)(((double)(i-min)/(max-min))*max2);
        }
        ip.applyTable(lut);
    }

    private void normalizeFloat(ImageProcessor ip, double min, double max) {
        double scale = max>min?1.0/(max-min):1.0;
        int size = ip.getWidth()*ip.getHeight();
        float[] pixels = (float[])ip.getPixels();
        double v;
        for (int i=0; i<size; i++) {
            v = pixels[i] - min;
            if (v<0.0) v = 0.0;
            v *= scale;
            if (v>1.0) v = 1.0;
            pixels[i] = (float)v;
        }
    }

    @SuppressWarnings("unused")
    private void equalize(ImagePlus imp) {
        if (imp.getBitDepth()==32) {
            IJ.showMessage("Contrast Enhancer", "Equalization of 32-bit images not supported.");
            return;
        }
        classicEqualization = IJ.altKeyDown();
        int[] histogram = null;
        ImageProcessor ip = imp.getProcessor();
        if (histogram==null)
            histogram = ip.getHistogram();
        equalize(ip, histogram);
        imp.getProcessor().resetMinAndMax();
    }

    /** 
        Changes the tone curves of images. 
        It should bring up the detail in the flat regions of your image.
        Histogram Equalization can enhance meaningless detail and hide 
        important but small high-contrast features. This method uses a
        similar algorithm, but uses the square root of the histogram 
        values, so its effects are less extreme. Hold the alt key down 
        to use the standard histogram equalization algorithm.
        This code was contributed by Richard Kirk (rak@cre.canon.co.uk).
     */ 
    @SuppressWarnings("unused")
    private void equalize(ImageProcessor ip) {
        equalize(ip, ip.getHistogram());
    }

    private void equalize(ImageProcessor ip, int[] histogram) {
        ip.resetRoi();
        if (ip instanceof ShortProcessor) { // Short
            max = 65535;
            range = 65535;
        } else { //bytes
            max = 255;
            range = 255;
        }
        double sum;
        sum = getWeightedValue(histogram, 0);
        for (int i=1; i<max; i++)
            sum += 2 * getWeightedValue(histogram, i);
        sum += getWeightedValue(histogram, max);
        double scale = range/sum;
        int[] lut = new int[range+1];
        lut[0] = 0;
        sum = getWeightedValue(histogram, 0);
        for (int i=1; i<max; i++) {
            double delta = getWeightedValue(histogram, i);
            sum += delta;
            lut[i] = (int)Math.round(sum*scale);
            sum += delta;
        }
        lut[max] = max;
        ip.applyTable(lut);
    }

    private double getWeightedValue(int[] histogram, int i) {
        int h = histogram[i];
        if (h<2 || classicEqualization) return (double)h;
        return Math.sqrt((double)(h));
    }
}
