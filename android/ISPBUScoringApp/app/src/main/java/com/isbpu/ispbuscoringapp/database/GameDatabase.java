package com.isbpu.ispbuscoringapp.database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ispbu.scoring.Game;

/**
 * Created by Patrick Love on 3/25/2015.
 */
public class GameDatabase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "game_database";
    private static final int DB_VERSION = 1;
    private static GameDatabase instance;

    public static GameDatabase getInstance(Context c){
        if(instance == null){
            instance = new GameDatabase(c.getApplicationContext());
        }
        return instance;
    }

    protected static final String TABLE_GAMES = "game_table";
    protected static final String COLUMN_ID = "_id";
    protected static final String COLUMN_THROWS = "game_table";
    protected static final String COLUMN_DATE = "game_table";

    private static final String CREATE_SQL =
                "CREATE TABLE " + TABLE_GAMES + " ( " +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_DATE + " INTEGER, " +
                COLUMN_THROWS + " STRING NOT NULL " +
            ");";

    public GameDatabase(Context c){
        super(c,DATABASE_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_GAMES);
        db.execSQL(CREATE_SQL);
    }

    private static final int CHAR_OFFSET = 0x40;
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
}
