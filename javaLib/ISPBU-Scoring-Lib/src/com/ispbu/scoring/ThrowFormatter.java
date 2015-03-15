package com.ispbu.scoring;

public class ThrowFormatter {
	
	private static final String STRIKE = "X";
	private static final String SPARE = "/";
	private static final String OPEN = "-";
	public static final int NO_PREV_THROW = -1;
	
	public int throwToFormat;
	public int throwBefore = NO_PREV_THROW;
	
	public ThrowFormatter(int t){
		this.throwToFormat = t;
	}
	
	public ThrowFormatter(int t0, int t){
		this(t);
		this.throwBefore = t0;
	}
	
	public String format(){
		if(throwBefore == NO_PREV_THROW && throwToFormat == 10){
			return STRIKE;
		}
		if(throwBefore != -1 && throwBefore+throwToFormat == 10){
			return SPARE;
		}
		else if(throwToFormat == 0){
			return OPEN;
		}
		else{
			return throwToFormat + "";
		}
	}

}
