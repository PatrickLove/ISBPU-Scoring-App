package com.isbpu.ispbuscoringapp.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.isbpu.ispbuscoringapp.R;
import com.ispbu.scoring.GameStats;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by Patrick Love on 3/25/2015.
 */
public class StatsView extends LinearLayout {

    private final DecimalFormat PERCENT_FORMAT = new DecimalFormat("0.###%");
    private final DecimalFormat DOUBLE_FORMAT = new DecimalFormat("0.###");

    public void updateStats(GameStats stats) {
        totalScoreView.setText(""+stats.getScore());
        markView.setText(""+stats.getMarks());
        strikeView.setText(""+stats.getStrikes());
        spareView.setText(""+stats.getSpares());
        AMBView.setText(DOUBLE_FORMAT.format(stats.getMarkBonuses()));
        SPFView.setText(DOUBLE_FORMAT.format(stats.getAvgFrameScore()));
        nineSpareView.setText(PERCENT_FORMAT.format(stats.getNineConvert()));
    }

    private TextView totalScoreView;
    private TextView markView;
    private TextView strikeView;
    private TextView spareView;
    private TextView AMBView;
    private TextView SPFView;
    private TextView nineSpareView;


    public StatsView(Context context) {
        super(context);
        init();
    }

    public StatsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public StatsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init(){
        inflate(getContext(), R.layout.view_stats, this);
        totalScoreView = (TextView) findViewById(R.id.scoreView);
        markView = (TextView) findViewById(R.id.marksView);
        strikeView = (TextView) findViewById(R.id.strikesView);
        spareView = (TextView) findViewById(R.id.sparesView);
        AMBView = (TextView) findViewById(R.id.bonusView);
        SPFView = (TextView) findViewById(R.id.spfView);
        nineSpareView = (TextView) findViewById(R.id.nineSpareView);

        if(isInEditMode()){
            totalScoreView.setText("300");
            markView.setText("12");
            strikeView.setText("12");
            spareView.setText("0");
            AMBView.setText("17.5");
            SPFView.setText("30");
            nineSpareView.setText("NaN");
        }
    }

}
