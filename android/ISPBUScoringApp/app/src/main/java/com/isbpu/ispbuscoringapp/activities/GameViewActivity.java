package com.isbpu.ispbuscoringapp.activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.isbpu.ispbuscoringapp.R;

import org.w3c.dom.Text;

public class GameViewActivity extends ActionBarActivity {

    private TextView totalScoreView;
    private TextView markView;
    private TextView strikeView;
    private TextView spareView;
    private TextView AMBView;
    private TextView SPFView;
    private TextView nineSpareView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_view);
    }
}
