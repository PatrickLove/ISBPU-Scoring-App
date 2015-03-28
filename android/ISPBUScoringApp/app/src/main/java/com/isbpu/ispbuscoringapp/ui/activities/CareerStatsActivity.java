package com.isbpu.ispbuscoringapp.ui.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.isbpu.ispbuscoringapp.R;
import com.isbpu.ispbuscoringapp.database.GameDBEntry;
import com.isbpu.ispbuscoringapp.database.GameDatabase;
import com.isbpu.ispbuscoringapp.ui.views.MultiGameStatsView;
import com.ispbu.scoring.Game;
import com.ispbu.scoring.MultiGameStats;

import java.util.List;

public class CareerStatsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_career_stats);
        refreshGames();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_career_stats, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_refresh) {
            refreshGames();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void refreshGames() {

        List<GameDBEntry> gameEntries = GameDatabase.getInstance(this).query(null);
        List<Game> games = GameDBEntry.pullGamesFrom(gameEntries);
        MultiGameStats stats = MultiGameStats.calculateStats(games);
        if(stats == null) return;

        MultiGameStatsView statsView = (MultiGameStatsView) findViewById(R.id.statsView);
        statsView.updateStats(stats);
    }
}
