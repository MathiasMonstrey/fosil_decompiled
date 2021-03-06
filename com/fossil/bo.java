package com.fossil;

import android.view.View;

public class bo {
    private int Dl;
    private int Dm;
    private int Dn;
    private int Do;
    private final View mView;

    public bo(View view) {
        this.mView = view;
    }

    public void hg() {
        this.Dl = this.mView.getTop();
        this.Dm = this.mView.getLeft();
        hh();
    }

    private void hh() {
        li.m12274p(this.mView, this.Dn - (this.mView.getTop() - this.Dl));
        li.m12275q(this.mView, this.Do - (this.mView.getLeft() - this.Dm));
    }

    public boolean setTopAndBottomOffset(int i) {
        if (this.Dn == i) {
            return false;
        }
        this.Dn = i;
        hh();
        return true;
    }

    public boolean setLeftAndRightOffset(int i) {
        if (this.Do == i) {
            return false;
        }
        this.Do = i;
        hh();
        return true;
    }

    public int getTopAndBottomOffset() {
        return this.Dn;
    }

    public int getLeftAndRightOffset() {
        return this.Do;
    }

    public int hi() {
        return this.Dl;
    }
}
