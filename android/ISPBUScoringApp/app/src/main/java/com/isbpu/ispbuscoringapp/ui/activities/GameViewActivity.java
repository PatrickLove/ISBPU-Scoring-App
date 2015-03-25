package com.isbpu.ispbuscoringapp.ui.activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import com.isbpu.ispbuscoringapp.R;
import com.isbpu.ispbuscoringapp.ui.views.GameView;
import com.isbpu.ispbuscoringapp.ui.views.StatsView;
import com.ispbu.scoring.Game;

public class GameViewActivity extends ActionBarActivity {

    private static final String SAVED_GAME_STATE = "game_state";
    public static final String EXTRA_GAME = "extra_game_data";

    private GameView gameView;
    private StatsView statsView;

    private Game g = new Game();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_view);

        statsView = (StatsView) findViewById(R.id.statsView);
        gameView = (GameView) findViewById(R.id.gameView);

        Bundle extras = getIntent().getExtras();
        if(savedInstanceState != null && savedInstanceState.containsKey(SAVED_GAME_STATE)){
            g.makeThrows(savedInstanceState.getIntArray(SAVED_GAME_STATE));
        }
        else if(extras != null && extras.containsKey(EXTRA_GAME)){
            g.makeThrows(extras.getIntArray(EXTRA_GAME));
        }
        gameView.setGame(g);
        statsView.updateStats(g.getStats());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntArray(SAVED_GAME_STATE, g.getThrowArray());
    }
}
