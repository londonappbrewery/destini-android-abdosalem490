package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView storyTexView;
    Button buttonTop;
    Button buttonBottom;
    int mStoryIndex = 0;
    private final Story[] stories = {
            new Story(R.string.T1_Story, R.string.T1_Ans1, R.string.T1_Ans2),
            new Story(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2),
            new Story(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2),
            new Story(R.string.T4_End,-1,-1),
            new Story(R.string.T5_End,-1,-1),
            new Story(R.string.T6_End,-1,-1)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null)
            mStoryIndex = savedInstanceState.getInt("storyIndex");



        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        storyTexView = findViewById(R.id.storyTextView);
        buttonTop = findViewById(R.id.buttonTop);
        buttonBottom = findViewById(R.id.buttonBottom);

        setText();

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        buttonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update(true);
            }
        });


        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        buttonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update(false);
            }
        });

    }

    private void setText() {
        storyTexView.setText(stories[mStoryIndex].getStoryIndex());
        if (mStoryIndex < 3){
            buttonTop.setText(stories[mStoryIndex].getTopAnswer());
            buttonBottom.setText(stories[mStoryIndex].getBottomAnswer());
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("storyIndex",mStoryIndex);
    }

    private void update(boolean isTopButton) {
        if (isTopButton && mStoryIndex == 0)
            mStoryIndex = 2;
        else if (!isTopButton && mStoryIndex == 0)
            mStoryIndex = 1;
        else if (isTopButton && mStoryIndex == 2)
            mStoryIndex = 5;
        else if (!isTopButton && mStoryIndex == 2)
            mStoryIndex = 4;
        else if (isTopButton && mStoryIndex == 1)
            mStoryIndex = 2;
        else if (!isTopButton && mStoryIndex == 1)
            mStoryIndex = 3;

        Story story = stories[mStoryIndex];
        if (story.getBottomAnswer() == -1){
            buttonTop.setVisibility(View.GONE);
            buttonBottom.setVisibility(View.GONE);
        }

        setText();
    }
}
