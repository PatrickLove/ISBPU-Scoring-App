package com.isbpu.ispbuscoringapp.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.isbpu.ispbuscoringapp.R;
import com.ispbu.scoring.MultiGameStats;

import java.text.DecimalFormat;

public class MultiGameStatsView extends LinearLayout {

    private final DecimalFormat PERCENT_FORMAT = new DecimalFormat("0.##%");
    private final DecimalFormat DOUBLE_FORMAT = new DecimalFormat("0.##");

    public void updateStats(MultiGameStats stats) {
        gameCountView.setText("" + stats.getGameCount());
        minMarkView.setText("" + stats.getMinMarks());
        maxMarkView.setText("" + stats.getMaxMarks());
        maxScoreView.setText("" + stats.getMaxScore());
        minScoreView.setText("" + stats.getMinScore());
        totalScoreView.setText("" + stats.getTotalScore());
        avgScoreView.setText(DOUBLE_FORMAT.format(stats.getAverageScore()));
        markView.setText("" + stats.getMarks());
        strikeView.setText("" + stats.getStrikes());
        spareView.setText("" + stats.getSpares());
        AMBView.setText(DOUBLE_FORMAT.format(stats.getAverageBonus()));
        SPFView.setText(DOUBLE_FORMAT.format(stats.getAverageFrameScore()));
        nineSpareView.setText(PERCENT_FORMAT.format(stats.getNineConvert()));
        stdDevView.setText(DOUBLE_FORMAT.format(stats.getStandardDeviation()));
    }

    private TextView totalScoreView;
    private TextView avgScoreView;
    private TextView markView;
    private TextView strikeView;
    private TextView spareView;
    private TextView AMBView;
    private TextView SPFView;
    private TextView nineSpareView;
    private TextView stdDevView;
    private TextView maxScoreView;
    private TextView minScoreView;
    private TextView maxMarkView;
    private TextView minMarkView;
    private TextView gameCountView;



    public MultiGameStatsView(Context context) {
        super(context);
        init();
    }

    public MultiGameStatsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MultiGameStatsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init(){
        inflate(getContext(), R.layout.view_stats_multi_game, this);
        totalScoreView = (TextView) findViewById(R.id.scoreView);
        avgScoreView = (TextView) findViewById(R.id.avgScoreView);
        markView = (TextView) findViewById(R.id.marksView);
        strikeView = (TextView) findViewById(R.id.strikesView);
        spareView = (TextView) findViewById(R.id.sparesView);
        AMBView = (TextView) findViewById(R.id.bonusView);
        SPFView = (TextView) findViewById(R.id.spfView);
        nineSpareView = (TextView) findViewById(R.id.nineSpareView);
        stdDevView = (TextView) findViewById(R.id.stdDevView);
        maxScoreView = (TextView) findViewById(R.id.maxScoreView);
        minScoreView = (TextView) findViewById(R.id.minScoreView);
        maxMarkView = (TextView) findViewById(R.id.maxMarkView);
        minMarkView = (TextView) findViewById(R.id.minMarkView);
        gameCountView = (TextView) findViewById(R.id.gamesView);

        if(isInEditMode()){
            totalScoreView.setText("300");
            avgScoreView.setText("150");
            markView.setText("12");
            strikeView.setText("12");
            spareView.setText("0");
            AMBView.setText("17.5");
            SPFView.setText("15");
            stdDevView.setText("150");
            maxScoreView.setText("300");
            minScoreView.setText("0");
            maxMarkView.setText("12");
            minMarkView.setText("0");
            gameCountView.setText("2");
            nineSpareView.setText("NaN");
        }
    }

}
