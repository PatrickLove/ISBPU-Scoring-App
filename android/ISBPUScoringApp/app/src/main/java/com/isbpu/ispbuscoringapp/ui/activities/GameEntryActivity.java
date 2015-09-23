package com.isbpu.ispbuscoringapp.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.isbpu.ispbuscoringapp.R;
import com.isbpu.ispbuscoringapp.ui.views.GameView;
import com.ispbu.scoring.Frame;
import com.ispbu.scoring.Game;

public class GameEntryActivity extends Activity {

    public static final String ENTRY_PREFS = "game_entry_preferences";
    public static final String PREF_ENTRY_MODE = "entry_mode";
    public static final String ENTRY_MODE_STANDING = "1";

    private static final String SAVED_GAME_STATE = "game_data";
    public static final String EXTRA_GAME = "extra_game_data";
    private static final int REQUEST_CODE = 999;

    private boolean standingPinCount = false;
    private View spareButton;
    private View strikeButton;
    private View[] numButtons = new View[10];
    private GameView gameView;
    private int lastThrow = 0;

    private Game g = new Game();

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_entry);
        spareButton = findViewById(R.id.buttonSpare);
        strikeButton = findViewById(R.id.buttonStrike);

        numButtons[0] = findViewById(R.id.button);
        numButtons[1] = findViewById(R.id.button1);
        numButtons[2] = findViewById(R.id.button2);
        numButtons[3] = findViewById(R.id.button3);
        numButtons[4] = findViewById(R.id.button4);
        numButtons[5] = findViewById(R.id.button5);
        numButtons[6] = findViewById(R.id.button6);
        numButtons[7] = findViewById(R.id.button7);
        numButtons[8] = findViewById(R.id.button8);
        numButtons[9] = findViewById(R.id.button9);

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
    protected void onResume() {
        super.onResume();
        updatedMode();
    }

    private void updatedMode(){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        standingPinCount = false;
        if(prefs != null && prefs.contains(PREF_ENTRY_MODE)){
            standingPinCount = prefs.getString(PREF_ENTRY_MODE,"0").equals(ENTRY_MODE_STANDING);
        }
        ((Button) numButtons[0]).setText(standingPinCount ? R.string.ten : R.string.zero);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntArray(SAVED_GAME_STATE, g.getThrowArray());
    }

    private void updateButtons(){
        spareButton.setEnabled(g.canSpare());
        strikeButton.setEnabled(g.canStrike());
        disableNums(g.getRemainingPins());
    }

    public void onNumericButtonPress(View v){
        String numStr = (String) ((Button) v).getText();
        int pins = readNumFromButton(v);
        Log.d("THROWING", "Threw a " + pins);
        g.makeThrow(pins);
        gameView.notifyGameChanged();
        updateButtons();
        lastThrow = pins;
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
    }

    private void disableNums(int remaining){
        for(int i = 0; i < 10; i++){
            int adjNum = (standingPinCount && i == 0) ? 10:i;
            numButtons[i].setEnabled(adjNum <= remaining);
        }
    }

    private int readNumFromButton(View v){
        int num = Frame.NO_SCORE;
        if(v.equals(spareButton)){
            num = Frame.MAKE_SPARE;
        }
        else if(v.equals(strikeButton)){
            num = standingPinCount ? 0 : 10;
        }
        else{
            for(int i = 0; i < 10; i++){
                if(v.equals(numButtons[i])){
                    num = (i == 0 && standingPinCount) ? 10:i;
                    break;
                }
            }
        }
        return interpretNum(num);
    }

    private int interpretNum(int num){
        if(standingPinCount && num >=0 && num <= 10){
            return 10 - num - (g.canSpare() ? lastThrow : 0);
        }
        return num;
    }
}
