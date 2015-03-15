package com.ispbu.scoring;

public class Frame {
	
	protected static final int NO_SCORE = -1;
	
	protected int throw1 = NO_SCORE;
	protected int throw2 = NO_SCORE;
	
	public static final int MAKE_SPARE = -10;
	
	
	public Score score(){
		if(isStrike()){
			return Score.getStrike();
		}
		else if(isSpare()){
			return Score.getSpare();
		}
		else{
			return new Score(Math.max(throw1, 0)+Math.max(throw2, 0));
		}
	}
	
	public boolean canStrike(){
		return throw1 == NO_SCORE;
	}

	public boolean canSpare() {
		return throw1 != 10 && throw1 != NO_SCORE && throw2 == NO_SCORE;
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
			if(score == MAKE_SPARE){
				if(!canSpare()) return false;
				throw2 = 10-throw1;
			}
			else if(throw1 == NO_SCORE){
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
		if(!toS.isEvaluated()){
			toS.addExtraThrow(Math.max(throw1, 0));
			if(!toS.isEvaluated() && !isStrike()){
				toS.addExtraThrow(Math.max(throw2, 0));
			}
		}
	}

	@Override
	public String toString() {
		if(isStrike()){
			return " X"; //Does not use ThrowFormatter due to extra space
		}
		String ret = "";
		ret += new ThrowFormatter(throw1).format();
		ret += new ThrowFormatter(	throw1==10 ? ThrowFormatter.NO_PREV_THROW : throw1,
									throw2).format();
		return ret;
	}

	public boolean isTenth(){
		return false;
	}
}
