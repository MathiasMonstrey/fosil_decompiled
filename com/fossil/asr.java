package com.fossil;

public final class asr {
    private static int bfx = 31;
    private int bfy = 1;

    public final int Km() {
        return this.bfy;
    }

    public final asr aW(boolean z) {
        this.bfy = (z ? 1 : 0) + (this.bfy * bfx);
        return this;
    }

    public final asr bL(Object obj) {
        this.bfy = (obj == null ? 0 : obj.hashCode()) + (this.bfy * bfx);
        return this;
    }
}
