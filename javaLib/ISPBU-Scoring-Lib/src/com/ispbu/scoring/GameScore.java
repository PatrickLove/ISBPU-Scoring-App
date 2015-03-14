package com.ispbu.scoring;

public class GameScore {
	
	private int value;
	private int frames;
	private int extraThrows;
	
	public GameScore(int value, int frames, int extraThrows){
		this.value = value;
		this.frames = frames;
		this.extraThrows = extraThrows;
	}
	
	public int getValue(){
		return value;
	}
	
	public int getExtraThrows(){
		return extraThrows;
	}
	
	public int getFrames(){
		return frames;
	}

}
