package com.portfolio.platform.data.model.microapp;

import com.fossil.cga;

public class Range {
    @cga("hasNext")
    private boolean hasNext;
    @cga("limit")
    private int limit;
    @cga("offset")
    private int offset;

    public int getLimit() {
        return this.limit;
    }

    public int getOffset() {
        return this.offset;
    }

    public void setOffset(int i) {
        this.offset = i;
    }

    public boolean isHasNext() {
        return this.hasNext;
    }
}
