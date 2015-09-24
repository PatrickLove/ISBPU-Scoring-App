package com.isbpu.ispbuscoringapp.ui.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.isbpu.ispbuscoringapp.R;
import com.isbpu.ispbuscoringapp.database.GameDBEntry;


public class GameListActivity extends Activity
        implements GameListFragment.Callbacks {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home && getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_list);

        if (findViewById(R.id.game_detail_container) != null) {
            mTwoPane = true;

            GameListFragment frag = ((GameListFragment) getFragmentManager()
                    .findFragmentById(R.id.game_list));
            frag.setActivateOnItemClick(true);
        }
        else{
            GameListFragment defaultFrag = new GameListFragment();
            getFragmentManager().beginTransaction().add(R.id.fragment_container, defaultFrag).commit();
        }
    }


    /**
     * Callback method from {@link GameListFragment.Callbacks}
     * indicating that the item with the given ID was selected.
     */
    @Override
    public void onItemSelected(GameDBEntry entry) {
        Bundle arguments = entry.getViewArgs();
        arguments.putBoolean(GameViewFragment.EXTRA_SHOW_SAVE_OPTIONS, false);
        GameViewFragment fragment = new GameViewFragment();
        fragment.setArguments(arguments);
        if (mTwoPane) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.game_detail_container, fragment)
                    .commit();

        } else {
            getFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit();
        }
    }
}
