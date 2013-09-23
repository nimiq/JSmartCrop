package com.mydomain.smartcrop.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class IOImage {
    
    public static BufferedImage getImage(String imagePath) {
        // Reading the image
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Impossibile leggere il file " + imagePath, "Error", JOptionPane.ERROR_MESSAGE);
        }

        return image;        
    }
    

    public static void saveImage(BufferedImage image, String path) {
        saveImage(image, path, "jpg");
    }
    
    public static void saveImage(BufferedImage image, String path, String format) {
        try {
            ImageIO.write(image, format, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Impossibile scrivere il file " + path, "Error", JOptionPane.ERROR_MESSAGE);
        }        
    }
    
//    public static int[] toIntArray(BufferedImage image) {
//        int[] i = new int[image.getWidth()*image.getHeight()];
//        image.getData().getSamples(0, 0, image.getWidth(), image.getHeight(), 0, i);
//        return i;
//    }
}
