package com.isbpu.ispbuscoringapp.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.isbpu.ispbuscoringapp.R;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_settings){
            startActivity(new Intent(this, SettingsActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    public void onCareerStatsClick(View v){
        startActivity(new Intent(this, CarrerStatsActivity.class));
    }

    public void onPlayClick(View v){
        loadNewGame();
    }

    public void onShowGamesClick(View v){
        startActivity(new Intent(this, GameListActivity.class));
    }

    private void loadNewGame() {
        startActivity(new Intent(this, GameEntryActivity.class));
    }
}
