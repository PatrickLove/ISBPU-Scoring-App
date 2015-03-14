package com.ispbu.scoring;

public class Score {
	
	public static Score SPARE = new Score(10, 1);
	public static Score STRIKE = new Score(10, 2);
	
	private int value;
	private int extraThrows;
	
	public Score(int val, int eThrows){
		this.value = val;
		this.extraThrows = eThrows;
	}
	
	public Score(int val){
		this(val, 0);
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

}
