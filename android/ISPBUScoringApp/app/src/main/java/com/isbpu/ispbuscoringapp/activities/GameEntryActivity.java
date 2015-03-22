package com.isbpu.ispbuscoringapp.activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.isbpu.ispbuscoringapp.R;

public class GameEntryActivity extends ActionBarActivity {

    private static final String LOG_TAG ="GameEntryActivity";
    private View spareButton;
    private View strikeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_entry);
        spareButton = findViewById(R.id.buttonSpare);
        strikeButton = findViewById(R.id.buttonStrike);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game_entry, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void updateButtons(){
        spareButton.setEnabled(true);
        strikeButton.setEnabled(true);
    }

    public void onNumericButtonPress(View v){
        String numStr = (String) ((Button) v).getText();
        int pins;
        if(numStr.equals(getString(R.string.zero))){
            pins = 0;
        }
        else if(numStr.equals(getString(R.string.spare_symbol))){
            //TODO game + /
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
        //TODO game + pins and refreshGame
        updateButtons();
    }

    public void onUndoPress(View v){
        //TODO Undo and refresh game
    }
}
