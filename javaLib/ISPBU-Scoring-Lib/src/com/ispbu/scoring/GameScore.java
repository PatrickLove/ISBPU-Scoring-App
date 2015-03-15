package com.ispbu.scoring;

public class GameScore {
	
	private int totalValue;
	private int frames;
	private int extraThrows;
	private int[] frameScores;
	
	
	public GameScore(int value, int frames, int extraThrows, int[] frameScores){
		this.totalValue = value;
		this.frames = frames;
		this.extraThrows = extraThrows;
		this.frameScores = frameScores;
	}
	
	public int getTotalValue(){
		return totalValue;
	}
	
	public int[] getFrameScores(){
		return frameScores;
	}
	
	public int getExtraThrows(){
		return extraThrows;
	}
	
	public int getFrames(){
		return frames;
	}

}
