package com.mydomain.smartcrop.operation.statistics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.mydomain.smartcrop.utils.Statistics;


public class SingularitiesFinder {

    List<Float> data; //f.i. rows' std scores 
    private float threshold = -1.5F;//-0.5 in caso di grandi immagini nel foglio
    //La presenza di extra bordi bianchi viene identificata quando l'errore medio dei primi pixeltot/whiteExtraBorderIdentificationPolicy da uno spigolo sono sopra (piu bianchi de) l'errore medio generale
    private int whiteExtraBorderIdentificationPolicy = 60;
    // Un extra bordo bianco identificato, viene considerato vero bordo bianco se di dimensione inferiore a pixeltot/whiteExtraBorderVerificationPolicy
    private int whiteExtraBorderVerificationPolicy = 7;
    
    public SingularitiesFinder(List<Float> data) {
        this.data = data;
    }

    public Singularities getSingularities() {
        return getSingularities(threshold, whiteExtraBorderIdentificationPolicy, whiteExtraBorderVerificationPolicy);
    }

    public Singularities getSingularities(Float threshold, Integer whiteExtraBorderIdentificationPolicy, Integer whiteExtraBorderVerificationPolicy) {
        this.threshold = threshold;
        this.whiteExtraBorderIdentificationPolicy = whiteExtraBorderIdentificationPolicy;
        this.whiteExtraBorderVerificationPolicy = whiteExtraBorderVerificationPolicy;
        
        int first = getFirstSingularity(data);
        
        List<Float> reverse = new ArrayList<Float>();
        reverse.addAll(data);
        Collections.reverse(reverse);
        int second = getFirstSingularity(reverse);
        second = reverse.size() - second;
        
        return new Singularities(first, second);
    }
    
    public int getFirstSingularity(List<Float> data) {
        //TODO num cyclomatico alto, riesco a sistemarlo?
        if (isExtraInitialNoise(data)) {
            int x;
            for (x = 0; x < data.size(); x++) {
                if (x < data.size()-1) { //do NOT do this check for the last entry in data otherwise index out of bound error
                    if (data.get(x) <= threshold && data.get(x+1) > threshold)
                        break;
                }
            }
            if (x < Math.floor(data.size()/whiteExtraBorderVerificationPolicy))
                return x;
        }
        
        int x = 0;
        for (Float d : data) {
            if (d > threshold)
                break;
            x++;
        }        
        return x;        
    }
    
    /**
     * Decide se la dimensione (riga o colonna) a cui {@linkplain errs} fa riferimento
     * inizia o meno con un possibile bordo bianco
     * Vengono analizzati qui solo i primi (dimensione di riga o colonna)/{@link WHITE_EXTRA_BORDER_IDENTIFICATION_POLITICY} pixel
     * L'effettiva presenza di un possibile bordo bianco verra' poi verificata in {@link getSingularity(ArrayList<Double> errs)}
     * @param data
     * @return
     */    
    public boolean isExtraInitialNoise(List<Float> data) {
        final List<Float> oneSixty = new ArrayList<Float>();
        for (int i = 0; i < Math.floor(data.size()/whiteExtraBorderIdentificationPolicy); i++)
            oneSixty.add(data.get(i));
        
        return Statistics.getMean(oneSixty) > 0;
    }
}
