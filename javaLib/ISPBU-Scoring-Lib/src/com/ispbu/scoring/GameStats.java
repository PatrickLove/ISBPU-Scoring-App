package com.ispbu.scoring;

public class GameStats {
	
	private int score;
	private int strikes;
	private int spares;
	private int markBonuses;
	private double nineConvert;
	
	public GameStats(int score, int strikes, int spares, int markBonus, int nineOps, int nineSpares){
		this.score = score;
		this.strikes = strikes;
		this.spares = spares;
		this.markBonuses = markBonus;
		this.nineConvert = (double)nineSpares/nineOps;
	}
	
	public int getScore() {
		return score;
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
	public double getAvgFrameScore(){
		return score/10.0;
	}
	public double getAvgBonus(){
		return (double)markBonuses/getMarks();
	}
	public int getMarks() {
		return strikes + spares;
	}
	public double getNineConvert() {
		return nineConvert;
	}
	
	
	public String toString(){
		return String.format(	"Game Stats:\n" +
								"\tScore: %d pins\n" +
								"\tMarks: %d\n" +
								"\t\tStrikes: %d\n" +
								"\t\tSpares:  %d\n" +
								"\tAverage Mark Bonus: %.3f pins/mark\n" +
								"\tNine Spare Conversion %%: %.2f%%",
								score, getMarks(), strikes, spares, getAvgBonus(), getNineConvert()*100);
	}
}
