package com.isbpu.ispbuscoringapp.ui.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;

import com.isbpu.ispbuscoringapp.R;
import com.isbpu.ispbuscoringapp.database.GameDBEntry;
import com.isbpu.ispbuscoringapp.ui.views.GameView;
import com.isbpu.ispbuscoringapp.ui.views.SingleGameStatsView;
import com.ispbu.scoring.Game;

import java.text.DateFormat;
import java.util.Date;

public class GameViewActivity extends ActionBarActivity {

    private static final String SAVED_GAME_STATE = "game_state";
    public static final String EXTRA_GAME = "extra_game_data";
    public static final String EXTRA_GAME_DATE = "extra_game_date";
    public static final String EXTRA_SHOW_SAVE_OPTIONS = "extra_show_save_options";

    private Game g = new Game();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_view);

        setResult(RESULT_CANCELED);

        SingleGameStatsView singleGameStatsView = (SingleGameStatsView) findViewById(R.id.statsView);
        GameView gameView = (GameView) findViewById(R.id.gameView);

        Bundle extras = getIntent().getExtras();
        if(savedInstanceState != null && savedInstanceState.containsKey(SAVED_GAME_STATE)){
            g.makeThrows(savedInstanceState.getIntArray(SAVED_GAME_STATE));
        }
        else if(extras != null){
            if(extras.containsKey(EXTRA_GAME)){
                g.makeThrows(extras.getIntArray(EXTRA_GAME));
                if(extras.containsKey(EXTRA_GAME_DATE)){
                    long dateMillis = extras.getLong(EXTRA_GAME_DATE);
                    String dateText = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(new Date(dateMillis));
                    findViewById(R.id.dateLabel).setVisibility(View.VISIBLE);
                    findViewById(R.id.dateView).setVisibility(View.VISIBLE);
                    ((TextView)findViewById(R.id.dateView)).setText(dateText);
                }
            }
            if(extras.containsKey(EXTRA_SHOW_SAVE_OPTIONS) && extras.getBoolean(EXTRA_SHOW_SAVE_OPTIONS)){
                findViewById(R.id.backBtn).setVisibility(View.GONE);
            }
            else{
                findViewById(R.id.saveCancelContainer).setVisibility(View.GONE);
            }
        }
        gameView.setGame(g);
        singleGameStatsView.updateStats(g.getStats());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntArray(SAVED_GAME_STATE, g.getThrowArray());
    }

    public void saveGame(View v){
        GameDBEntry entry = new GameDBEntry(g);
        entry.save(this);
        cancelGame(null);//Finishes this and parent activity
    }

    public void cancelGame(View v){
        setResult(RESULT_OK);
        finish();
    }

    public void backOut(View v){
        finish();
    }
}
