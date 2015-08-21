package com.isbpu.ispbuscoringapp.ui.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.isbpu.ispbuscoringapp.R;

public class CarrerStatsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_view);

        MultiGameStatsFragment fragment = new MultiGameStatsFragment();
        getFragmentManager().beginTransaction()
                .add(R.id.fragment_container, fragment).commit();
    }

}
