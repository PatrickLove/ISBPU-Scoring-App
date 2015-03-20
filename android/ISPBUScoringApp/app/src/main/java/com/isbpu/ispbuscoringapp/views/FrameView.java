package com.isbpu.ispbuscoringapp.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.isbpu.ispbuscoringapp.R;

/**
 * Created by Patrick Love on 3/19/2015.
 */
public class FrameView extends LinearLayout {

    private TextView throw1Text;
    private TextView throw2Text;
    private boolean isTenth = false;
    private TextView throw3Text;
    private TextView scoreText;

    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
        scoreText.setText(score+"");
    }
    private int score;

    public FrameView(Context context){
        super(context);
        init();
    }

    public FrameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        retrieveAttrs(attrs);
        init();
    }

    public FrameView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        retrieveAttrs(attrs);
        init();
    }

    private void retrieveAttrs(AttributeSet attrs){
        TypedArray a = getContext().getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.FrameView,
                0, 0);

        try {
            isTenth = a.getBoolean(R.styleable.FrameView_isTenth, false);
        } finally {
            a.recycle();
        }
    }

    private void init(){
        if(isTenth){
            inflate(getContext(), R.layout.view_frame_tenth, this);
        }
        else{
            inflate(getContext(), R.layout.view_frame, this);
        }
        throw1Text = (TextView) findViewById(R.id.textThrow1);
        throw2Text = (TextView) findViewById(R.id.textThrow2);
        if(isTenth){
            throw3Text = (TextView) findViewById(R.id.textThrow3);
        }
        scoreText = (TextView) findViewById(R.id.textScore);

        if(isInEditMode()){
            throw1Text.setText("9");
            throw2Text.setText("/");
            if(throw3Text != null) throw3Text.setText("X");
            scoreText.setText("100");
        }
    }
}
