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
		for(int f = 0; f < currentFrame; f++){
			Frame currentFrame = frames[f];
			for(Score toS : toScore){
				currentFrame.addExtraThrowsTo(toS);
				if(toS.isEvaluated()){
					totalValue += toS.getValue();
					toScore.remove(toS);
				}
			}
			Score s = currentFrame.score();
			if(s.isEvaluated()){
				totalValue += s.getValue();
			}
			else{
				toScore.add(s);
			}
		}
		int remainingThrows = 0;
		for(Score toS : toScore){
			remainingThrows += toS.getRemainingThrows();
		}
		return new GameScore(totalValue, currentFrame, remainingThrows);
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

}