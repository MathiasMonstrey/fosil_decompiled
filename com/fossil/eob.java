package com.fossil;

public class eob implements eod {
    private final int maxRetries;

    public eob() {
        this(1);
    }

    public eob(int i) {
        this.maxRetries = i;
    }
}
