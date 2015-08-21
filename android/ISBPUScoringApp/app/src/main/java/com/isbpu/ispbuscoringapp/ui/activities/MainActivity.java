package com.isbpu.ispbuscoringapp.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.isbpu.ispbuscoringapp.R;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
