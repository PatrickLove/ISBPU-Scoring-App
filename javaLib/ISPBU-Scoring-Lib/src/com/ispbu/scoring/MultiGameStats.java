package com.ispbu.scoring;

import java.util.ArrayList;
import java.util.List;

public class MultiGameStats {

	private int maxScore;
	private int minScore;
	private int minMarks;
	private int maxMarks;
	private List<Game> games;
	private int totalScore;
	private int strikes;
	private int spares;
	private int markBonuses;
	private int nineOps;
	private int nineSpares;
	
	public MultiGameStats(
							List<Game> games, 	int minScore, 	int maxScore, 		int minMarks, 	int maxMarks, 	int totalScore,
							int strikes, 		int spares, 	int markBonuses, 	int nineOps, 	int nineSpares
						){
		this.games = games;
		this.maxScore = maxScore;
		this.minScore = minScore;
		this.maxMarks = maxMarks;
		this.minMarks = minMarks;
		this.totalScore = totalScore;
		this.strikes = strikes;
		this.spares = spares;
		this.markBonuses = markBonuses;
		this.nineOps = nineOps;
		this.nineSpares = nineSpares;
	}
	
	
	//Calculated Stats
	
	public double getStandardDeviation(){
		double totalVariance = 0;
		for(Game g : games){
			totalVariance += Math.pow(g.score().getTotalValue()-getAverageScore(), 2);
		}
		return Math.sqrt(totalVariance/getGameCount());
	}
	
	public double getAverageScore(){
		return (double)totalScore/getGameCount();
	}
	
	public double getAverageBonus(){
		return (double)markBonuses/getMarks();
	}
	
	public double getAverageFrameScore(){
		return totalScore/(getGameCount()*10.0);
	}
	
	public int getMarks(){
		return strikes + spares;
	}
	
	public double getNineConvert(){
		return (double)nineSpares/nineOps;
	}
	
	public int getGameCount(){
		return games.size();
	}
	
	//Getters
	
	public int getMaxScore() {
		return maxScore;
	}

	public int getMinScore() {
		return minScore;
	}

	public int getMinMarks() {
		return minMarks;
	}

	public int getMaxMarks() {
		return maxMarks;
	}

	public List<Game> getGames() {
		return games;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public int getStrikes() {
		return strikes;
	}

	public int getSpares() {
		return spares;
	}

	public int getMarkBonuses() {
		return markBonuses;
	}

	protected int getNineOps() {
		return nineOps;
	}

	protected int getNineSpares() {
		return nineSpares;
	}

	
	
	
	public static MultiGameStats calculateStats(List<Game> games){
		if(games.size() == 0) return null;
		List<GameStats> stats = new ArrayList<>();
		for(Game g : games){
			stats.add(g.getStats());
		}
		
		int maxScore = stats.get(0).getScore(), //Gets are safe since the function returns null and exits if the game list is empty
			minScore = stats.get(0).getScore(),
			maxMarks = stats.get(0).getMarks(),
			minMarks = stats.get(0).getMarks(),
			totalScore = 0,
			strikes = 0,
			spares = 0,
			markBonuses = 0,
			nineOps = 0,
			nineSpares = 0;
		for(GameStats stat : stats){
			int thisScore = stat.getScore();
			if(thisScore > maxScore) maxScore = thisScore;
			if(thisScore < minScore) minScore = thisScore;
			totalScore += thisScore;
			
			int thisMarks = stat.getMarks();
			if(thisMarks > maxMarks) maxMarks = thisMarks;
			if(thisMarks < minMarks) minMarks = thisMarks;
			
			strikes += stat.getStrikes();
			spares += stat.getSpares();
			markBonuses += stat.getMarkBonuses();
			nineOps += stat.getNineOps();
			nineSpares += stat.getNineSpares();
		}
		
		return new MultiGameStats(games, minScore, maxScore, minMarks, maxMarks, totalScore, strikes, spares, markBonuses, nineOps, nineSpares);
	}
}
