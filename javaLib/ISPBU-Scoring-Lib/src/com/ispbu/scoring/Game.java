package com.ispbu.scoring;

import java.util.ArrayList;

public class Game {
	
	private static final int FRAME_DONE = 10;
	
	private int currentFrame = 0;
	private Frame[] frames = new Frame[] {
			new Frame(),
			new Frame(),
			new Frame(),
			new Frame(),
			new Frame(),
			new Frame(),
			new Frame(),
			new Frame(),
			new Frame(),
			new TenthFrame()
	};
	
	public boolean isFinished(){
		return currentFrame == FRAME_DONE;
	}
	
	public Frame getFrame(int num){
		if(num < 0 || num > 9){
			return null;
		}
		else{
			return frames[num];
		}
	}
	
	public GameScore score(){
		int totalValue = 0;
		ArrayList<Score> toScore = new ArrayList<>();
		int[] frameScores = new int[10];
		for(int f = 0; f < 10; f++){
			Frame currentLoopFrame = frames[f];
			ArrayList<Score> toRemove = new ArrayList<Score>();
			for(Score toS : toScore){
				int initialVal = toS.getValue();
				if(!toS.isEvaluated()){
					currentLoopFrame.addExtraThrowsTo(toS);
					totalValue += toS.getValue()-initialVal;
					frameScores[toS.getFrameNum()] = toS.getTotalScore();
				}
				if(toS.isEvaluated()){
					toRemove.add(toS);
				}
			}
			for(Score toR : toRemove){
				toScore.remove(toR);
			}
			Score s = currentLoopFrame.score();
			if(s.isEvaluated()){
				totalValue += s.getValue();
				frameScores[f] = totalValue;
			}
			else{
				s.setFrameNum(f);
				s.setBaseScore(totalValue);
				totalValue += s.getValue();
				frameScores[f] = s.getTotalScore();
				toScore.add(s);
			}
		}
		return new GameScore(totalValue, currentFrame, frameScores);
	}
	
	public boolean makeThrow(int pins){
		boolean ret = false;
		if(!isFinished()){
			ret = frames[currentFrame].doThrow(pins);
			updateCurrentFrameIfNecessary();
		}
		return ret;
	}
	
	public boolean makeThrows(int...pins){
		boolean ret = true;
		for(int i : pins){
			if(!makeThrow(i)) { ret = false; }
		}
		return ret;
	}

	private void updateCurrentFrameIfNecessary() {
		if(frames[currentFrame].isFinished()){
			currentFrame++;
		}
	}
	
	public boolean canStrike(){
		if(isFinished()) return false;
		return frames[currentFrame].canStrike();
	}
	
	public boolean canSpare(){
		if(isFinished()) return false;
		return frames[currentFrame].canSpare();
	}

	@Override
	public String toString() {
		String shots = "";
		String scores = "";
		GameScore score = this.score();
		int[] frameScore = score.getFrameScores();
		for(int f = 0; f < currentFrame; f++){
			shots += frames[f].toString() + " ";
			scores += pad(frameScore[f]);
			if(frames[f].isTenth()){
				scores += " ";
			}
			else if(frameScore[f] > 100){
				scores += " ";
				shots += " ";
			}
		}
		return shots + "\n" + scores + ": " + score.getTotalValue();
	}

	private String pad(int i) {
		String ret = i+"";
		while(ret.length() < 3){
			ret += " ";
		}
		return ret;
	}
	
	public GameStats getStats(){
		if(isFinished()){
			int score = this.score().getTotalValue();
			int spares = 0;
			int strikes = 0;
			int bonus = 0;
			int nineOps = 0;
			int nineConvs = 0;
			ArrayList<Score> toScore = new ArrayList<Score>();
			for(Frame f : frames){
				spares += f.countSpare();
				strikes += f.countStrike();
				
				ArrayList<Score> toRemove = new ArrayList<Score>();
				for(Score toS : toScore){
					if(!toS.isEvaluated()){
						f.addExtraThrowsTo(toS);
					}
					if(toS.isEvaluated()){
						bonus += toS.getValue()-10;
						toRemove.add(toS);
					}
				}
				for(Score toR : toRemove){
					toScore.remove(toR);
				}
				Score fScore = f.score();
				if(fScore.getRemainingThrows() > 0){
					toScore.add(fScore);
				}
				if(f.isTenth()){
					bonus += ((TenthFrame) f).countBonus();
				}
				
				if(f.hasNineOp()){
					nineOps++;
					if(f.hasSpare()){
						nineConvs++;
					}
				}
			}
			return new GameStats(score, strikes, spares, bonus, nineOps, nineConvs);
		}
		return null;
	}
}
