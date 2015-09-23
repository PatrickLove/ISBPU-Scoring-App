package com.isbpu.ispbuscoringapp.ui.activities;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.isbpu.ispbuscoringapp.R;
import com.isbpu.ispbuscoringapp.database.GameDBEntry;
import com.isbpu.ispbuscoringapp.database.GameDatabase;
import com.isbpu.ispbuscoringapp.ui.views.MultiGameStatsView;
import com.ispbu.scoring.Game;
import com.ispbu.scoring.MultiGameStats;

import java.util.List;

public class MultiGameStatsFragment extends Fragment {

    public static final String ARG_QUERY_STRING = "query";

    private MultiGameStatsView statsView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_multi_game_stats, container, false);
        statsView = (MultiGameStatsView) v.findViewById(R.id.statsView);
        String query = null;
        if(getArguments().containsKey(ARG_QUERY_STRING)){
            query = getArguments().getString(ARG_QUERY_STRING);
        }
        displayStatsForQuery(query);
        return v;
    }

    public void displayStatsForQuery(String query) {
        List<GameDBEntry> gameEntries = GameDatabase.getInstance(getActivity()).query(query);
        Log.d("ENTRIES", gameEntries.toString());
        List<Game> games = GameDBEntry.pullGamesFrom(gameEntries);
        MultiGameStats stats = MultiGameStats.calculateStats(games);
        if(stats == null) return;
        statsView.updateStats(stats);
    }
}
