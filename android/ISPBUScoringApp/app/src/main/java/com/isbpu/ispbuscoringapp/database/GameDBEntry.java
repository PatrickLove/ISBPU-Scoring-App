package com.isbpu.ispbuscoringapp.database;

import com.ispbu.scoring.Game;

import java.util.Date;

/**
 * Created by Patrick Love on 3/25/2015.
 */
public class GameDBEntry {
    public long getId() {
        return id;
    }

    public Game getGame() {
        return game;
    }

    public long getDate() {
        return date;
    }

    private Game game;
    private long date;
    private long id;

    public GameDBEntry(Game g){
        this.date = System.currentTimeMillis();
        this.game = g;
    }

    public GameDBEntry(Game g, long d){
        this.date = d;
        this.game = g;
    }

    public GameDBEntry(long id, Game g, long d){
        this(g, d);
        this.id = id;
    }


}
