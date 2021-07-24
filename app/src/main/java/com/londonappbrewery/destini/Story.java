package com.londonappbrewery.destini;

public class Story {
    private int storyIndex;
    private int topAnswer;
    private int bottomAnswer;

    public Story(int storyIndex, int topAnswer, int bottomAnswer) {
        this.storyIndex = storyIndex;
        this.topAnswer = topAnswer;
        this.bottomAnswer = bottomAnswer;
    }

    public int getStoryIndex() {
        return storyIndex;
    }

    public int getTopAnswer() {
        return topAnswer;
    }

    public int getBottomAnswer() {
        return bottomAnswer;
    }
}
