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
	
	public GameScore score(){
		int totalValue = 0;
		ArrayList<Score> toScore = new ArrayList<>();
		int[] frameScores = new int[currentFrame];
		for(int f = 0; f < currentFrame; f++){
			Frame currentLoopFrame = frames[f];
			ArrayList<Score> toRemove = new ArrayList<Score>();
			for(Score toS : toScore){
				int initialVal = toS.getValue();
				if(!toS.isEvaluated()){
					currentLoopFrame.addExtraThrowsTo(toS);
					totalValue += toS.getValue()-initialVal;
					frameScores[toS.getFrameNum()] = totalValue;
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
				totalValue += 10;
				frameScores[f] = totalValue;
				toScore.add(s);
			}
			
		}
		int remainingThrows = 0;
		for(Score toS : toScore){
			remainingThrows += toS.getRemainingThrows();
		}
		return new GameScore(totalValue, currentFrame, remainingThrows, frameScores);
	}
	
	public boolean makeThrow(int pins){
		boolean ret = false;
		if(!isFinished()){
			ret = frames[currentFrame].doThrow(pins);
			updateCurrentFrameIfNecessary();
		}
		return ret;
	}

	private void updateCurrentFrameIfNecessary() {
		if(frames[currentFrame].isFinished()){
			currentFrame++;
		}
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
}
