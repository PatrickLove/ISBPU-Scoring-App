package com.ispbu.scoring;

public class Frame {
	
	protected static final int NO_SCORE = -1;
	
	protected int throw1 = NO_SCORE;
	protected int throw2 = NO_SCORE;
	
	
	public Score score(){
		if(isStrike()){
			return Score.getStrike();
		}
		else if(isSpare()){
			return Score.getSpare();
		}
		else{
			return new Score(throw1+throw2);
		}
	}
	
	public boolean isStrike(){
		return throw1 == 10;
	}
	
	public boolean isSpare(){
		return !isStrike() && throw1+throw2 == 10;
	}
	
	public boolean isFinished(){
		return throw1 != NO_SCORE && (isStrike() || throw2 != NO_SCORE);
	}
	
	public boolean doThrow(int score){
		if(!isFinished() && score <= 10){
			if(throw1 == NO_SCORE){
				throw1 = score;
			}
			else if(throw2 == NO_SCORE){
				if(score > 10-throw1) return false;
				throw2 = score;
			}
			return true;
		}
		return false;
	}

	public void addExtraThrowsTo(Score toS) {
		if(isFinished() && !toS.isEvaluated()){
			toS.addExtraThrow(throw1);
			if(!toS.isEvaluated() && !isStrike()){
				toS.addExtraThrow(throw2);
			}
		}
	}

	@Override
	public String toString() {
		if(isStrike()){
			return " X"; //Does not use ThrowFormatter due to extra space
		}
		if(throw1 != NO_SCORE){
			String ret = "";
			ret += new ThrowFormatter(throw1).format();
			if(throw2 != NO_SCORE){
				ret += new ThrowFormatter(	throw1==10 ? ThrowFormatter.NO_PREV_THROW : throw1,
											throw2).format();
			}
			else{
				ret += " ";
			}
			return ret;
		}
		else{
			return "  ";
		}
	}

	public boolean isTenth(){
		return false;
	}
}
