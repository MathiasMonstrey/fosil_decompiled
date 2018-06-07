package com.fossil;

public class cip extends cig {
    private int ccF;
    private int cej;
    private int cek;
    private int cel;
    private int cem;
    private int color;
    private long duration;
    private long startTime;
    private int state;

    public int getEndIndex() {
        return this.cek;
    }

    public void setEndIndex(int i) {
        this.cek = i;
        this.duration = (long) (this.cek - this.cej);
    }

    public int YJ() {
        return this.cej;
    }

    public int getState() {
        return this.state;
    }

    public int getSessionNumber() {
        return this.ccF;
    }

    public void setColor(int i) {
        this.color = i;
        this.cem = i;
    }

    public int getColor() {
        return this.color;
    }

    public void ju(int i) {
        this.cem = i;
    }

    public int YK() {
        return this.cem;
    }

    public int getHighlightColor() {
        return this.cel;
    }

    public long getDuration() {
        return this.duration;
    }

    public int compareTo(Object obj) {
        long j = 0;
        if (obj instanceof cip) {
            j = (long) ((cip) obj).YJ();
        }
        return (int) (((long) this.cej) - j);
    }

    public long getStartTime() {
        return this.startTime;
    }
}
