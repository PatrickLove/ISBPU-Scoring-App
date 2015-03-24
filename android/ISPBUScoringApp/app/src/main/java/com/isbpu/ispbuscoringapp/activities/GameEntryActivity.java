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
        gameView.setGame(g);
    }

    private void updateButtons(){
        spareButton.setEnabled(g.canSpare());
        strikeButton.setEnabled(g.canStrike());
    }

    public void onNumericButtonPress(View v){
        String numStr = (String) ((Button) v).getText();
        int pins;
        if(numStr.equals(getString(R.string.zero))){
            pins = 0;
        }
        else if(numStr.equals(getString(R.string.spare_symbol))){
            pins = Frame.MAKE_SPARE;
        }
        else if(numStr.equals(getString(R.string.strike_symbol))){
            pins = 10;
        }
        else{
            try{
                pins = Integer.parseInt(numStr);
            }
            catch (NumberFormatException e){
                Log.w(LOG_TAG, "Number could not be read from button");
                return;
            }
        }
        g.makeThrow(pins);
        gameView.notifyGameChanged();
        updateButtons();
    }

    public void onUndoPress(View v){
        g.undoThrow();
        gameView.notifyGameChanged();
        updateButtons();
    }
}
