package com.isbpu.ispbuscoringapp.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.isbpu.ispbuscoringapp.R;

/**
 * Created by Patrick Love on 3/19/2015.
 */
public class GameView extends LinearLayout {

    private FrameView[] frameViews;
    private TextView scoreText;

    public GameView(Context context){
        super(context);
        init();
    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
//        retrieveAttrs(attrs);
        init();
    }

    public GameView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
//        retrieveAttrs(attrs);
        init();
    }

//    private void retrieveAttrs(AttributeSet attrs){
//        TypedArray a = getContext().getTheme().obtainStyledAttributes(
//                attrs,
//                R.styleable.FrameView,
//                0, 0);
//
//        try {
//            isTenth = a.getBoolean(R.styleable.FrameView_isTenth, false);
//        } finally {
//            a.recycle();
//        }
//    }

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
        scoreText = (TextView) findViewById(R.id.textScore);

        if(isInEditMode()){
            scoreText.setText("300");
        }
    }
}
