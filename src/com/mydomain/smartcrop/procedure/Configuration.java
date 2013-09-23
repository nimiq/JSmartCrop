package com.mydomain.smartcrop.procedure;

public class Configuration {
	
    private boolean deskewDuringPreProcessing = true; //se devi fare deskew, meglio farlo in preproc
    private float deskewThresholdPre = 0.5F; //in deg. no deskew under this threshold of skewness
    private boolean deskewDuringPostProcessing = false; //se devi fare deskew, meglio farlo in preproc
    private float deskewThresholdPost = 0.5F; //in deg. no deskew under this threshold of skewness
    private boolean grayscaleDuringPostProcessing = false;    
    private boolean stretchHistogramDuringPostProcessing = true;
    private float stretchHistogramThresholdDuringPostProcessing = 5;
    private float thresholdStdDev = -1.5F;//-0.5 in caso di grandi immagini nel foglio
    //La presenza di extra bordi bianchi viene identificata quando l'errore medio dei primi pixeltot/whiteExtraBorderIdentificationPolicy da uno spigolo sono sopra (piu bianchi de) l'errore medio generale
    private int whiteExtraBorderIdentificationPolicy = 60;
    // Un extra bordo bianco identificato, viene considerato vero bordo bianco se di dimensione inferiore a pixeltot/whiteExtraBorderVerificationPolicy
    private int whiteExtraBorderVerificationPolicy = 7;
    private boolean createCharts = true;
    
	/**
	 * @return the deskewDuringPreProcessing
	 */
	public boolean isDeskewDuringPreProcessing() {
		return deskewDuringPreProcessing;
	}
	/**
	 * @param deskewDuringPreProcessing the deskewDuringPreProcessing to set
	 */
	public void setDeskewDuringPreProcessing(boolean deskewDuringPreProcessing) {
		this.deskewDuringPreProcessing = deskewDuringPreProcessing;
	}
	/**
	 * @return the deskewThresholdPre
	 */
	public float getDeskewThresholdPre() {
		return deskewThresholdPre;
	}
	/**
	 * @param deskewThresholdPre the deskewThresholdPre to set
	 */
	public void setDeskewThresholdPre(float deskewThresholdPre) {
		this.deskewThresholdPre = deskewThresholdPre;
	}
	/**
	 * @return the deskewDuringPostProcessing
	 */
	public boolean isDeskewDuringPostProcessing() {
		return deskewDuringPostProcessing;
	}
	/**
	 * @param deskewDuringPostProcessing the deskewDuringPostProcessing to set
	 */
	public void setDeskewDuringPostProcessing(boolean deskewDuringPostProcessing) {
		this.deskewDuringPostProcessing = deskewDuringPostProcessing;
	}
	/**
	 * @return the deskewThresholdPost
	 */
	public float getDeskewThresholdPost() {
		return deskewThresholdPost;
	}
	/**
	 * @param deskewThresholdPost the deskewThresholdPost to set
	 */
	public void setDeskewThresholdPost(float deskewThresholdPost) {
		this.deskewThresholdPost = deskewThresholdPost;
	}
	/**
	 * @return the grayscaleDuringPostProcessing
	 */
	public boolean isGrayscaleDuringPostProcessing() {
		return grayscaleDuringPostProcessing;
	}
	/**
	 * @param grayscaleDuringPostProcessing the grayscaleDuringPostProcessing to set
	 */
	public void setGrayscaleDuringPostProcessing(
			boolean grayscaleDuringPostProcessing) {
		this.grayscaleDuringPostProcessing = grayscaleDuringPostProcessing;
	}
	/**
	 * @return the stretchHistogramDuringPostProcessing
	 */
	public boolean isStretchHistogramDuringPostProcessing() {
		return stretchHistogramDuringPostProcessing;
	}
	/**
	 * @param stretchHistogramDuringPostProcessing the stretchHistogramDuringPostProcessing to set
	 */
	public void setStretchHistogramDuringPostProcessing(
			boolean stretchHistogramDuringPostProcessing) {
		this.stretchHistogramDuringPostProcessing = stretchHistogramDuringPostProcessing;
	}
	/**
	 * @return the stretchHistogramThresholdDuringPostProcessing
	 */
	public float getStretchHistogramThresholdDuringPostProcessing() {
		return stretchHistogramThresholdDuringPostProcessing;
	}
	/**
	 * @param stretchHistogramThresholdDuringPostProcessing the stretchHistogramThresholdDuringPostProcessing to set
	 */
	public void setStretchHistogramThresholdDuringPostProcessing(
			float stretchHistogramThresholdDuringPostProcessing) {
		this.stretchHistogramThresholdDuringPostProcessing = stretchHistogramThresholdDuringPostProcessing;
	}
	/**
	 * @return the thresholdStdDev
	 */
	public float getThresholdStdDev() {
		return thresholdStdDev;
	}
	/**
	 * @param thresholdStdDev the thresholdStdDev to set
	 */
	public void setThresholdStdDev(float thresholdStdDev) {
		this.thresholdStdDev = thresholdStdDev;
	}
	/**
	 * @return the whiteExtraBorderIdentificationPolicy
	 */
	public int getWhiteExtraBorderIdentificationPolicy() {
		return whiteExtraBorderIdentificationPolicy;
	}
	/**
	 * @param whiteExtraBorderIdentificationPolicy the whiteExtraBorderIdentificationPolicy to set
	 */
	public void setWhiteExtraBorderIdentificationPolicy(
			int whiteExtraBorderIdentificationPolicy) {
		this.whiteExtraBorderIdentificationPolicy = whiteExtraBorderIdentificationPolicy;
	}
	/**
	 * @return the whiteExtraBorderVerificationPolicy
	 */
	public int getWhiteExtraBorderVerificationPolicy() {
		return whiteExtraBorderVerificationPolicy;
	}
	/**
	 * @param whiteExtraBorderVerificationPolicy the whiteExtraBorderVerificationPolicy to set
	 */
	public void setWhiteExtraBorderVerificationPolicy(
			int whiteExtraBorderVerificationPolicy) {
		this.whiteExtraBorderVerificationPolicy = whiteExtraBorderVerificationPolicy;
	}
	/**
	 * @return the createCharts
	 */
	public boolean isCreateCharts() {
		return createCharts;
	}
	/**
	 * @param createCharts the createCharts to set
	 */
	public void setCreateCharts(boolean createCharts) {
		this.createCharts = createCharts;
	}


}
