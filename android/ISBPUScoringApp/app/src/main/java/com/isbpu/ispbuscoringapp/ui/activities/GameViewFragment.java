package com.isbpu.ispbuscoringapp.ui.activities;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.isbpu.ispbuscoringapp.R;
import com.isbpu.ispbuscoringapp.ui.views.GameView;
import com.isbpu.ispbuscoringapp.ui.views.SingleGameStatsView;
import com.ispbu.scoring.Game;

import java.text.DateFormat;
import java.util.Date;

public class GameViewFragment extends Fragment {

    private static final String SAVED_GAME_STATE = "game_state";
    public static final String EXTRA_GAME = "extra_game_data";
    public static final String EXTRA_GAME_DATE = "extra_game_date";
    public static final String EXTRA_SHOW_SAVE_OPTIONS = "extra_show_save_options";

    private Game g = new Game();

    public interface SaveOptionsHandler{
        void onCancelGame(Game g);
        void onSaveGame(Game g);
        void onEditGame(Game g);
    }
    private static SaveOptionsHandler dummyHandler = new SaveOptionsHandler() {
        @Override
        public void onCancelGame(Game g) {}

        @Override
        public void onSaveGame(Game g) {}

        @Override
        public void onEditGame(Game g) {}
    };

    private SaveOptionsHandler handler = dummyHandler;


    @Override
    public void onDetach() {
        super.onDetach();
        handler = dummyHandler;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_game_view, container, false);
        
        SingleGameStatsView singleGameStatsView = (SingleGameStatsView) v.findViewById(R.id.statsView);
        GameView gameView = (GameView) v.findViewById(R.id.gameView);

        Bundle extras = getArguments();//getIntent().getExtras();
        if(savedInstanceState != null && savedInstanceState.containsKey(SAVED_GAME_STATE)){
            //noinspection ConstantConditions
            g.makeThrows(savedInstanceState.getIntArray(SAVED_GAME_STATE));
        }
        else if(extras != null){
            if(extras.containsKey(EXTRA_GAME)){
                //noinspection ConstantConditions
                g.makeThrows(extras.getIntArray(EXTRA_GAME));
                if(extras.containsKey(EXTRA_GAME_DATE)){
                    long dateMillis = extras.getLong(EXTRA_GAME_DATE);
                    String dateText = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(new Date(dateMillis));
                    v.findViewById(R.id.dateLabel).setVisibility(View.VISIBLE);
                    v.findViewById(R.id.dateView).setVisibility(View.VISIBLE);
                    ((TextView)v.findViewById(R.id.dateView)).setText(dateText);
                }
            }
            if(extras.getBoolean(EXTRA_SHOW_SAVE_OPTIONS, false)){
                if (!(getActivity() instanceof SaveOptionsHandler)) {
                    throw new IllegalStateException("Activity must implement fragment's callbacks.");
                }
                handler = (SaveOptionsHandler) getActivity();
                v.findViewById(R.id.saveBtn).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        handler.onSaveGame(g);
                    }
                });
                v.findViewById(R.id.cancelBtn).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        handler.onCancelGame(g);
                    }
                });
                v.findViewById(R.id.editButton).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        handler.onEditGame(g);
                    }
                });
            }
            else{
                v.findViewById(R.id.saveCancelContainer).setVisibility(View.GONE);
            }
        }
        gameView.setGame(g);
        singleGameStatsView.updateStats(g.getStats());

        return v;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntArray(SAVED_GAME_STATE, g.getThrowArray());
    }
}
