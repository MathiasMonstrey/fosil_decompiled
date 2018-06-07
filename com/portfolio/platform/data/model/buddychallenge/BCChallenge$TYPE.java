package com.portfolio.platform.data.model.buddychallenge;

public enum BCChallenge$TYPE {
    TYPE_CHALLENGE_ONE(0),
    TYPE_CHALLENGE_THREE(1),
    TYPE_CHALLENGE_FIVE(2),
    TYPE_CHALLENGE_ONE_DEBUG(1000),
    TYPE_CHALLENGE_THREE_DEBUG(1001),
    TYPE_CHALLENGE_FIVE_DEBUG(1002);
    
    private int mValue;

    private BCChallenge$TYPE(int i) {
        this.mValue = i;
    }

    public int getValue() {
        return this.mValue;
    }
}
