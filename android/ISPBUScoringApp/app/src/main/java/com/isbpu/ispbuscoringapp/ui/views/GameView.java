package com.isbpu.ispbuscoringapp.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.isbpu.ispbuscoringapp.R;
import com.ispbu.scoring.Game;
import com.ispbu.scoring.GameScore;

/**
 * Created by Patrick Love on 3/19/2015.
 */
public class GameView extends LinearLayout {

    private FrameView[] frameViews = new FrameView[10];
    private TextView scoreText;

    private Game game;
    public void setGame(Game game) {
        this.game = game;
        notifyGameChanged();
    }

    public void notifyGameChanged(){
        GameScore score = game.score();
        int[] frameScores = score.getFrameScores();
        for(int i = 0; i < 10; i++){
            frameViews[i].setFrame(game.getFrame(i));
            frameViews[i].setScore(frameScores[i]);
        }
        this.scoreText.setText(""+score.getTotalValue());
    }


    public GameView(Context context){
        super(context);
        init();
    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public GameView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        inflate(getContext(), R.layout.view_game, this);
        frameViews[0] = (FrameView) findViewById(R.id.frame1);
        frameViews[1] = (FrameView) findViewById(R.id.frame2);
        frameViews[2] = (FrameView) findViewById(R.id.frame3);
        frameViews[3] = (FrameView) findViewById(R.id.frame4);
        frameViews[4] = (FrameView) findViewById(R.id.frame5);
        frameViews[5] = (FrameView) findViewById(R.id.frame6);
        frameViews[6] = (FrameView) findViewById(R.id.frame7);
        frameViews[7] = (FrameView) findViewById(R.id.frame8);
        frameViews[8] = (FrameView) findViewById(R.id.frame9);

        frameViews[9] = (FrameView) findViewById(R.id.frame10);
        scoreText = (TextView) findViewById(R.id.scoreView);

        if(isInEditMode()){
            scoreText.setText("300");
        }
    }
}
