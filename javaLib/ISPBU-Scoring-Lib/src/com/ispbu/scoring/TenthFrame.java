package com.ispbu.scoring;

public class TenthFrame extends Frame {

	private int throw3 = NO_SCORE;

	public Score score(){
		return new Score(Math.max(throw1, 0)+Math.max(throw2, 0)+Math.max(throw3, 0));
	}
	
	public boolean canStrike(){
		if(throw1 == NO_SCORE) return true;
		else if(throw2 == NO_SCORE) return throw1 == 10;
		else if(throw3 == NO_SCORE) return throw1 + throw2 == 10 || throw2 == 10;
		return false;
	}
	
	public boolean canSpare(){
		if(throw1 == NO_SCORE) return false;
		else if(throw2 == NO_SCORE) return throw1 != 10;
		else if(throw3 == NO_SCORE) return throw1 == 10 && throw2 != 10;
		return false;
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
			if(score == MAKE_SPARE){
				if(!canSpare()) return false;
				if(throw2 == NO_SCORE) throw2 = 10-throw1;
				else if(throw3 == NO_SCORE) throw3 = 10-throw2;
				else return false;
			}
			else if(throw1 == NO_SCORE){
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
	
	@Override
	public String toString() {
		String ret = "";
		ret += new ThrowFormatter(throw1).format();
		ret += new ThrowFormatter(	throw1==10 ? ThrowFormatter.NO_PREV_THROW : throw1,
									throw2).format();
		ret += new ThrowFormatter(	(throw2 == 10 || throw1+throw2==10) ? 
										ThrowFormatter.NO_PREV_THROW :
										throw2,
									throw3).format();
		return ret;
	}
	
	public void addExtraThrowsTo(Score toS) {
		if(!toS.isEvaluated()){
			toS.addExtraThrow(Math.max(throw1, 0));
			if(!toS.isEvaluated()){
				toS.addExtraThrow(Math.max(throw2, 0));
				if(!toS.isEvaluated()){
					toS.addExtraThrow(Math.max(throw3, 0));
				}
			}
		}
	}
	
	public boolean isTenth(){
		return true;
	}
}
