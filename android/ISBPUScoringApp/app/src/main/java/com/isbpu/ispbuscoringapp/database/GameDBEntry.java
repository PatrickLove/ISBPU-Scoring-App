package com.isbpu.ispbuscoringapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;

import com.isbpu.ispbuscoringapp.ui.activities.GameViewFragment;
import com.ispbu.scoring.Game;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GameDBEntry {
    private static final long NO_ID = -1;

    public long getId() {
        return id;
    }

    public Game getGame() {
        return game;
    }

    public Date getDate() {
        return new Date(date);
    }

    private Game game;
    private long date;
    private long id=NO_ID;

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

    public void save(Context c){
        GameDatabase db = GameDatabase.getInstance(c);
        if(id==NO_ID){
            id = db.saveGame(this);
        }
        else{
            db.updateGame(this);
        }
    }

    protected ContentValues encodeToValues(){
        ContentValues vals = new ContentValues();
        if(id!=NO_ID){
            vals.put(GameDatabase.COLUMN_ID, id);
        }
        vals.put(GameDatabase.COLUMN_DATE, date);
        vals.put(GameDatabase.COLUMN_THROWS, encodeGameThrows(game));
        return vals;
    }

    protected static GameDBEntry readFromCursor(Cursor c){
        long id = c.getLong(c.getColumnIndex(GameDatabase.COLUMN_ID));
        long date = c.getLong(c.getColumnIndex(GameDatabase.COLUMN_DATE));
        String encoding = c.getString(c.getColumnIndex(GameDatabase.COLUMN_THROWS));
        return new GameDBEntry(id, decodeGameThrows(encoding), date);
    }

    private static final int CHAR_OFFSET = 0x30;
    private static String encodeGameThrows(Game g){
        String ret = "";
        for(int i : g.getThrowArray()){
            ret += (char)(i+CHAR_OFFSET);
        }
        return ret;
    }
    private static Game decodeGameThrows(String s){
        char[] chars = s.toCharArray();
        int[] gThrows = new int[chars.length];
        for(int i = 0; i < chars.length; i++){
            gThrows[i] = (int)chars[i] - CHAR_OFFSET;
        }
        Game ret = new Game();
        ret.makeThrows(gThrows);
        return ret;
    }

    public static GameDBEntry readFromId(Context c, long id){
        GameDatabase db = GameDatabase.getInstance(c);
        return db.idQuery(id);
    }

    public Bundle getViewArgs(){
        Bundle ret = new Bundle();
        ret.putLong(GameViewFragment.EXTRA_GAME_DATE, date);
        ret.putIntArray(GameViewFragment.EXTRA_GAME, game.getThrowArray());
        return ret;
    }

    public static List<Game> pullGamesFrom(List<GameDBEntry> entries){
        List<Game> ret = new ArrayList<>();
        for(GameDBEntry entry : entries){
            ret.add(entry.getGame());
        }
        return ret;
    }
}
