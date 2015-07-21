package com.isbpu.ispbuscoringapp.ui.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.isbpu.ispbuscoringapp.R;
import com.isbpu.ispbuscoringapp.database.GameDBEntry;
import com.isbpu.ispbuscoringapp.database.GameDatabase;
import com.isbpu.ispbuscoringapp.ui.views.MultiGameStatsView;
import com.ispbu.scoring.Game;
import com.ispbu.scoring.MultiGameStats;

import java.util.List;

public class CareerStatsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_career_stats);
        refreshGames();
    }

    private void refreshGames() {
        List<GameDBEntry> gameEntries = GameDatabase.getInstance(this).query(null);
        Log.d("ENTRIES", gameEntries.toString());
        List<Game> games = GameDBEntry.pullGamesFrom(gameEntries);
        MultiGameStats stats = MultiGameStats.calculateStats(games);
        if(stats == null) return;

        MultiGameStatsView statsView = (MultiGameStatsView) findViewById(R.id.statsView);
        statsView.updateStats(stats);
    }
}
