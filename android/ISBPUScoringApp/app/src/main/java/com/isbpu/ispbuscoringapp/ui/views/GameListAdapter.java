package com.isbpu.ispbuscoringapp.ui.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.isbpu.ispbuscoringapp.R;
import com.isbpu.ispbuscoringapp.database.GameDBEntry;
import com.isbpu.ispbuscoringapp.database.GameDatabase;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by PatrickLove on 7/21/15.
 */
public class GameListAdapter extends BaseAdapter {

    private final Context context;
    private List<GameDBEntry> values;
    private String currentQuery = null;

    public GameListAdapter(Context context, String query) {
        this.context = context;
        this.setQuery(query);
    }

    public void refreshList(){
        this.values = GameDatabase.getInstance(context).query(currentQuery);
        notifyDataSetChanged();
    }

    public void setQuery(String query){
        currentQuery = query;
        refreshList();
    }

    @Override
    public int getCount() {
        return values.size();
    }

    @Override
    public Object getItem(int i) {
        return values.get(i);
    }

    @Override
    public long getItemId(int i) {
        return values.get(i).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        GameDBEntry game = values.get(position);
        View v;
        if(convertView != null){
            v = convertView;
        }
        else{
            LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.game_list_element, parent, false);
        }
        ((TextView)v.findViewById(R.id.gameDate)).setText(DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(game.getDate()));
        ((TextView)v.findViewById(R.id.scoreView)).setText(""+game.getGame().score().getTotalValue());

        return v;
    }
}
