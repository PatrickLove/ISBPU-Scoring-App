package com.ispbu.scoring;

public class TenthFrame extends Frame {

	private int throw3 = NO_SCORE;

	public Score score(){
		return new Score(throw1+throw2+throw3);
	}
	
	public boolean isStrike(){
		return throw1 == 10 || throw2 == 10 || throw3 == 10;
	}
	
	public boolean isSpare(){
		return throw1+throw2 == 10 || throw2+throw3 == 10;
	}
	
	public boolean isFinished(){
		if(throw1 != NO_SCORE && throw2 != NO_SCORE){
			if(throw1 == 10 || throw1+throw2 == 10){
				return throw3 != NO_SCORE;
			}
		}
		return false;
	}
	
	public boolean doThrow(int score){
		if(!isFinished() && score <= 10){
			if(throw1 == NO_SCORE){
				throw1 = score;
			}
			else if(throw2 == NO_SCORE){
				if(throw1 != 10 && score > 10-throw1) return false;
				throw2 = score;
			}
			else if(throw3 == NO_SCORE){
				if( (throw2 != 10 && throw1+throw2 != 10) && score > 10-throw2) return false;
				throw3 = score;
			}
			return true;
		}
		return false;
	}
}
