package com.isbpu.ispbuscoringapp.ui.activities;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.isbpu.ispbuscoringapp.database.GameDBEntry;
import com.isbpu.ispbuscoringapp.ui.views.GameListAdapter;

import java.util.List;


public class GameListFragment extends ListFragment {

    private static final String ARG_QUERY_STRING = "querystring";
    private static final String STATE_ACTIVATED_POSITION = "activated_position";


    private Callbacks mCallbacks = dummyCallbacks;
    private static Callbacks dummyCallbacks = new Callbacks() {
        @Override
        public void onItemSelected(GameDBEntry entry) {

        }
    };
    private int mActivatedPosition = ListView.INVALID_POSITION;
    private List<GameDBEntry> getValues(){
        return ((GameListAdapter)getListAdapter()).getList();
    };

    public interface Callbacks {
        void onItemSelected(GameDBEntry entry);
    }

    public GameListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String query = null;
        Bundle args = getArguments();
        if(args != null && args.containsKey(ARG_QUERY_STRING)){
            query = getArguments().getString(ARG_QUERY_STRING);
        }
        setListAdapter(new GameListAdapter(getActivity(), query));
    }

    public void updateForQuery(String query){
        ((GameListAdapter)getListAdapter()).setQuery(query);
        setActivatedPosition(0);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Restore the previously serialized activated item position.
        if (savedInstanceState != null
                && savedInstanceState.containsKey(STATE_ACTIVATED_POSITION)) {
            setActivatedPosition(savedInstanceState.getInt(STATE_ACTIVATED_POSITION));
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // Activities containing this fragment must implement its callbacks.
        if (!(activity instanceof Callbacks)) {
            throw new IllegalStateException("Activity must implement fragment's callbacks.");
        }

        mCallbacks = (Callbacks) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();

        // Reset the active callbacks interface to the dummy implementation.
        mCallbacks = dummyCallbacks;
    }

    @Override
    public void onListItemClick(ListView listView, View view, int position, long id) {
        super.onListItemClick(listView, view, position, id);

        // Notify the active callbacks interface (the activity, if the
        // fragment is attached to one) that an item has been selected.
        mCallbacks.onItemSelected(getValues().get(position));
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mActivatedPosition != ListView.INVALID_POSITION) {
            // Serialize and persist the activated item position.
            outState.putInt(STATE_ACTIVATED_POSITION, mActivatedPosition);
        }
    }

    /**
     * Turns on activate-on-click mode. When this mode is on, list items will be
     * given the 'activated' state when touched.
     */
    public void setActivateOnItemClick(boolean activateOnItemClick) {
        // When setting CHOICE_MODE_SINGLE, ListView will automatically
        // give items the 'activated' state when touched.
        getListView().setChoiceMode(activateOnItemClick
                ? ListView.CHOICE_MODE_SINGLE
                : ListView.CHOICE_MODE_NONE);
        getListView().setSelector(android.R.color.holo_blue_dark);
    }

    public void setActivatedPosition(int position) {
        Log.d("POS", "ACTIVATING INDEX " + position);
        getListView().setItemChecked(mActivatedPosition, false);
        if (position != ListView.INVALID_POSITION) {
            Log.d("POS", "NOT INVALID");
            getListView().setItemChecked(position, true);
            getListView().setSelection(position);
            if(getListView().getSelectedView() != null){
                getListView().getSelectedView().performClick();
            }
            else Log.e("NO SELECTION", "NO SELECTION");
            mCallbacks.onItemSelected(getValues().get(position));
        }
        mActivatedPosition = position;
    }
}
