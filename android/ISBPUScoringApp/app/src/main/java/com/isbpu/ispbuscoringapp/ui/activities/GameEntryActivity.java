package com.isbpu.ispbuscoringapp.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.isbpu.ispbuscoringapp.R;
import com.isbpu.ispbuscoringapp.ui.views.GameView;
import com.ispbu.scoring.Frame;
import com.ispbu.scoring.Game;

public class GameEntryActivity extends Activity {

    private static final String SAVED_GAME_STATE = "game_data";
    public static final String EXTRA_GAME = "extra_game_data";
    private static final int REQUEST_CODE = 999;

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

        Bundle extras = getIntent().getExtras();
        if(savedInstanceState != null && savedInstanceState.containsKey(SAVED_GAME_STATE)){
            g.makeThrows(savedInstanceState.getIntArray(SAVED_GAME_STATE));
        }
        else if(extras != null && extras.containsKey(EXTRA_GAME)){
            g.makeThrows(extras.getIntArray(EXTRA_GAME));
        }
        gameView.setGame(g);
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
        if(g.isFinished()){
            Intent intent = new Intent(this, GameViewActivity.class);
            intent.putExtra(GameViewFragment.EXTRA_GAME, g.getThrowArray());
            intent.putExtra(GameViewFragment.EXTRA_SHOW_SAVE_OPTIONS, true);
            startActivityForResult(intent, REQUEST_CODE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                finish();
            }
        }
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
