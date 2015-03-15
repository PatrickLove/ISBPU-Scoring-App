package com.ispbu.scoring;

public class Score {
	
	public static Score getSpare(){ return new Score(10, 1); }
	public static Score getStrike(){ return new Score(10, 2); }
	
	private int value;
	private int extraThrows;
	private int frameNum = -1;
	
	public Score(int val, int eThrows){
		this.value = val;
		this.extraThrows = eThrows;
	}
	
	public Score(int val){
		this(val, 0);
	}
	
	public int getFrameNum() {
		return frameNum;
	}

	public void setFrameNum(int frameNum) {
		this.frameNum = frameNum;
	}

	public boolean isEvaluated(){
		return extraThrows <= 0;
	}
	
	public void addExtraThrow(int t){
		if(!isEvaluated()){
			extraThrows--;
			value += t;
		}
	}

	public int getValue() {
		return value;
	}

	public int getRemainingThrows() {
		return extraThrows;
	}
	
	public String toString(){
		return value + " with the next " + extraThrows + " throw(s)";
	}

}
