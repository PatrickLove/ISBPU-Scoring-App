package com.ispbu.scoring;

public class Frame {
	
	public static final int NO_SCORE = -1;
	
	protected int throw1 = NO_SCORE;
	protected int throw2 = NO_SCORE;
	
	public static final int MAKE_SPARE = -10;
	
	
	public Score score(){
		if(hasStrike()){
			return Score.getStrike();
		}
		else if(hasSpare()){
			return Score.getSpare();
		}
		else{
			return new Score(Math.max(throw1, 0)+Math.max(throw2, 0));
		}
	}
	
	public boolean hasNineOp(){
		return throw1 == 9;
	}
	
	public boolean canStrike(){
		return throw1 == NO_SCORE;
	}

	public boolean canSpare() {
		return throw1 != 10 && throw1 != NO_SCORE && throw2 == NO_SCORE;
	}
	
	public int countStrike(){
		return throw1 == 10 ? 1:0;
	}
	
	public int countSpare(){
		return (!hasStrike() && throw1+throw2 == 10) ? 1:0;
	}
	
	public boolean hasStrike(){
		return countStrike() > 0;
	}
	
	public boolean hasSpare(){
		return countSpare() > 0;
	}
	
	public boolean isFinished(){
		return throw1 != NO_SCORE && (hasStrike() || throw2 != NO_SCORE);
	}
	
	public boolean undoThrow(){
		if(throw2 != NO_SCORE){
			throw2 = NO_SCORE;
			return true;
		}
		else if(throw1 != NO_SCORE){
			throw1 = NO_SCORE;
			return true;
		}
		return false;
	}
	
	public boolean doThrow(int score){
		if(!isFinished() && score <= 10 && score != NO_SCORE){
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
			if(!toS.isEvaluated() && !hasStrike()){
				toS.addExtraThrow(Math.max(throw2, 0));
			}
		}
	}

	@Override
	public String toString() {
		if(hasStrike()){
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
	
	public int[] getThrows(){
		return new int[]{throw1, throw2};
	}
}
