package com.isbpu.ispbuscoringapp.activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.isbpu.ispbuscoringapp.R;
import com.isbpu.ispbuscoringapp.views.GameView;
import com.ispbu.scoring.Frame;
import com.ispbu.scoring.Game;

public class GameEntryActivity extends ActionBarActivity {

    private static final String LOG_TAG ="GameEntryActivity";
    private static final String SAVED_GAME_STATE = "game_data";
    private View spareButton;
    private View strikeButton;
    private GameView gameView;

    private Game g = new Game();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_entry);
        spareButton = findViewById(R.id.buttonSpare);
        strikeButton = findViewById(R.id.buttonStrike);
        gameView = (GameView) findViewById(R.id.gameView);
        if(savedInstanceState != null && savedInstanceState.containsKey(SAVED_GAME_STATE)){
            g.makeThrows(savedInstanceState.getIntArray(SAVED_GAME_STATE));
        }
        gameView.setGame(g);
        gameView.notifyGameChanged();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntArray(SAVED_GAME_STATE, g.getThrowArray());
    }

    private void updateButtons(){
        spareButton.setEnabled(g.canSpare());
        strikeButton.setEnabled(g.canStrike());
    }

    public void onNumericButtonPress(View v){
        String numStr = (String) ((Button) v).getText();
        int pins = readNumFromButton(numStr);
        g.makeThrow(pins);
        gameView.notifyGameChanged();
        updateButtons();
    }

    public void onUndoPress(View v){
        g.undoThrow();
        gameView.notifyGameChanged();
        updateButtons();
    }

    private int readNumFromButton(String s){
        int num = Frame.NO_SCORE;
        if(s.equals(getString(R.string.zero))){
            num = 0;
        }
        else if(s.equals(getString(R.string.spare_symbol))){
            num = Frame.MAKE_SPARE;
        }
        else if(s.equals(getString(R.string.strike_symbol))){
            num = 10;
        }
        else if(s.equals(getString(R.string.one))){
            num = 1;
        }
        else if(s.equals(getString(R.string.two))){
            num = 2;
        }
        else if(s.equals(getString(R.string.three))){
            num = 3;
        }
        else if(s.equals(getString(R.string.four))){
            num = 4;
        }
        else if(s.equals(getString(R.string.five))){
            num = 5;
        }
        else if(s.equals(getString(R.string.six))){
            num = 6;
        }
        else if(s.equals(getString(R.string.seven))){
            num = 7;
        }
        else if(s.equals(getString(R.string.eight))){
            num = 8;
        }
        else if(s.equals(getString(R.string.nine))){
            num = 9;
        }
        return num;
    }
}
