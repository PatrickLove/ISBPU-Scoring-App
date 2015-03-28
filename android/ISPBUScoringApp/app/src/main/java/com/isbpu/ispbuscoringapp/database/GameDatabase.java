package com.isbpu.ispbuscoringapp.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

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
    protected static final String COLUMN_THROWS = "game_throws";
    protected static final String COLUMN_DATE = "game_date";

    protected static final String[] ALL_COLUMNS = new String[] {
            COLUMN_ID,
            COLUMN_DATE,
            COLUMN_THROWS
    };

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

    public long saveGame(final GameDBEntry gameDBEntry) {
        return runWithDb(new DbRunnable<Long>() {
            @Override
            public Long run(SQLiteDatabase db) {
                return db.insert(TABLE_GAMES,null,gameDBEntry.encodeToValues());
            }
        });
    }

    public List<GameDBEntry> query(final String where){
        return runWithDb(new DbRunnable<List<GameDBEntry>>() {
            @Override
            public List<GameDBEntry> run(SQLiteDatabase db) {
                Cursor cursor = db.query(TABLE_GAMES, ALL_COLUMNS, where, null, null,null, null);
                List<GameDBEntry> ret = new ArrayList<>();
                for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()){
                    ret.add(GameDBEntry.readFromCursor(cursor));
                }
                cursor.close();
                return ret;
            }
        });
    }

    public GameDBEntry idQuery(long id) {
        List<GameDBEntry> result = query(idEquals(id));
        return result.size()>0 ? result.get(0) : null;
    }

    private interface DbRunnable<T> {
        public T run(SQLiteDatabase db);
    }

    private <T> T runWithDb(DbRunnable<T> runnable){
        SQLiteDatabase db = this.getWritableDatabase();
        T ret = runnable.run(db);
        db.close();
        return ret;
    }

    public void updateGame(final GameDBEntry gameDBEntry) {
        runWithDb(new DbRunnable() {
            @Override
            public Object run(SQLiteDatabase db) {
                db.update(TABLE_GAMES, gameDBEntry.encodeToValues(), idEquals(gameDBEntry.getId()), null);
                return null;
            }
        });
    }

    private static String idEquals(long id) {
        return "(" + COLUMN_ID + " = " + id + ")";
    }
}
