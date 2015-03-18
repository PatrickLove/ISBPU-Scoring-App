package com.ispbu.scoring;

public class GameScore {
	
	private int totalValue;
	private int frames;
	private int[] frameScores;
	
	
	public GameScore(int value, int frames, int[] frameScores){
		this.totalValue = value;
		this.frames = frames;
		this.frameScores = frameScores;
	}
	
	public int getTotalValue(){
		return totalValue;
	}
	
	public int[] getFrameScores(){
		return frameScores;
	}
	
	public int getFramesScored(){
		return frames;
	}
	
	public String toString(){
		return String.format("%d in %d complete frames", totalValue, frames);
	}

}
