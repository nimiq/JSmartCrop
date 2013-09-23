package com.mydomain.smartcrop.gui;

import ij.ImagePlus;

import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

import org.jfree.chart.ChartPanel;

import com.mydomain.smartcrop.BorderIdentifier;
import com.mydomain.smartcrop.Scan;
import com.mydomain.smartcrop.procedure.AbstractProcedure;
import com.mydomain.smartcrop.procedure.Configuration;
import com.mydomain.smartcrop.utils.IOImage;

public class ScanManager implements Runnable {
    
    private String inFolderPath;
    private String outFolderPath;
    private Configuration conf;
    private AbstractProcedure procedure;
    private ProgressFrame frame = null;
    private File file = null;
    private boolean investigate;
    private ChartFrame chartFrame;
    
    public ScanManager(String inFolderPath, String outFolderPath, Configuration conf, AbstractProcedure procedure) {
        this.inFolderPath = inFolderPath;
        this.outFolderPath = outFolderPath;
        this.conf = conf;
        this.procedure = procedure;
    }
    
    public ScanManager(String inFolderPath, String outFolderPath, Configuration conf, AbstractProcedure procedure, ProgressFrame frame) {
        this.inFolderPath = inFolderPath;
        this.outFolderPath = outFolderPath;
        this.conf = conf;
        this.procedure = procedure;
        this.frame = frame;
    }
    
    public ScanManager(File file, Configuration conf, AbstractProcedure procedure, boolean investigate, ChartFrame chartFrame) {
        this.file = file;
        this.conf = conf;
        this.procedure = procedure;
        this.investigate = investigate;
        this.chartFrame = chartFrame;
    }
    
    public void run() {
        // Get the list of files to process
    	File[] listOfFiles;
        if (file != null) {
        	listOfFiles = new File[1];
        	listOfFiles[0] = file;
        } else {
	    	File folder = new File(inFolderPath);
	        listOfFiles = folder.listFiles();
        }
        
        int nFile = listOfFiles.length;
        
        int counter = 0;
        for (File file : listOfFiles) {

            // If the current file is not a file, it should be skipped
            if (!file.isFile()) {
                counter ++;
                updateProgressBar(frame, counter*100/nFile);
                continue;
            }
            
            // Create file names
            final String[] tokens = file.getName().split("\\.(?=[^\\.]+$)");
            final String fileName = tokens[0];
            //final String fileExt = tokens[1];
            //file.getPath() -> "C:\Users\...\1.png or /home/.../1.png"
            //file.getName() -> "1.png"
            //fileName -> "1"
            //fileExt -> "png"
            final String outFilePath = outFolderPath + file.getName();

            // Get image
            BufferedImage image = IOImage.getImage(file.getPath());
            // Checking if the file is an image
            try {
            	image.getWidth();
            } catch (Exception e) {
                counter ++;
                updateProgressBar(frame, counter*100/nFile);
                continue;
            }
            
            Scan scan = new Scan(image, procedure);
            
            BorderIdentifier borderId = new BorderIdentifier(procedure);
            Rectangle innerBorder = borderId.execute(new ImagePlus("", image));
            
            scan.setInnerBorder(innerBorder);
            if (investigate)
            	new ImagePlus("", scan.getBoundedPaperImage()).show();
            else
            	IOImage.saveImage(scan.getPaperImage(), outFilePath);
            
            if (conf.isCreateCharts()) {
                final String chartFilePath = outFolderPath + fileName + "C" + ".png";
                final BufferedImage chart = borderId.getStdScoreAnalysis().getChart().getChartImage(600, 300);
                IOImage.saveImage(chart, chartFilePath, "png");
                if (investigate) {
                	ChartPanel chartPanel = new ChartPanel(borderId.getStdScoreAnalysis().getChart().getJFreeChart());
                	chartFrame.getContentPane().add(chartPanel, BorderLayout.CENTER);
                	chartFrame.setLocationRelativeTo(null);
                	chartFrame.setVisible(true);
                }
                	
            }
            
            counter ++;
            updateProgressBar(frame, counter*100/nFile);
        }
        if (frame != null)
        	frame.getExitButton().setEnabled(true);
    }
    
    public void updateProgressBar(ProgressFrame frame, int n) {
    	if (frame != null)
    		frame.getProgressBar().setValue(n);
    }

}
