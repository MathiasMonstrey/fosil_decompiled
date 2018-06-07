package com.fossil;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.h;
import android.view.View;

public abstract class sf {
    protected final h ape;
    private int apf;
    final Rect xL;

    public abstract int bK(View view);

    public abstract int bL(View view);

    public abstract int bM(View view);

    public abstract int bN(View view);

    public abstract int bO(View view);

    public abstract int bP(View view);

    public abstract void dl(int i);

    public abstract int getEnd();

    public abstract int getEndPadding();

    public abstract int getMode();

    public abstract int pF();

    public abstract int pG();

    public abstract int pH();

    public abstract int pI();

    private sf(h hVar) {
        this.apf = Integer.MIN_VALUE;
        this.xL = new Rect();
        this.ape = hVar;
    }

    public void pD() {
        this.apf = pH();
    }

    public int pE() {
        return Integer.MIN_VALUE == this.apf ? 0 : pH() - this.apf;
    }

    public static sf m13514a(h hVar, int i) {
        switch (i) {
            case 0:
                return m13513a(hVar);
            case 1:
                return m13515b(hVar);
            default:
                throw new IllegalArgumentException("invalid orientation");
        }
    }

    public static sf m13513a(h hVar) {
        return new sf(hVar) {
            public int pG() {
                return this.ape.getWidth() - this.ape.getPaddingRight();
            }

            public int getEnd() {
                return this.ape.getWidth();
            }

            public void dl(int i) {
                this.ape.dp(i);
            }

            public int pF() {
                return this.ape.getPaddingLeft();
            }

            public int bO(View view) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                return layoutParams.rightMargin + (this.ape.cf(view) + layoutParams.leftMargin);
            }

            public int bP(View view) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                return layoutParams.bottomMargin + (this.ape.cg(view) + layoutParams.topMargin);
            }

            public int bL(View view) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                return layoutParams.rightMargin + this.ape.cj(view);
            }

            public int bK(View view) {
                return this.ape.ch(view) - ((LayoutParams) view.getLayoutParams()).leftMargin;
            }

            public int bM(View view) {
                this.ape.b(view, true, this.xL);
                return this.xL.right;
            }

            public int bN(View view) {
                this.ape.b(view, true, this.xL);
                return this.xL.left;
            }

            public int pH() {
                return (this.ape.getWidth() - this.ape.getPaddingLeft()) - this.ape.getPaddingRight();
            }

            public int getEndPadding() {
                return this.ape.getPaddingRight();
            }

            public int getMode() {
                return this.ape.qH();
            }

            public int pI() {
                return this.ape.qI();
            }
        };
    }

    public static sf m13515b(h hVar) {
        return new sf(hVar) {
            public int pG() {
                return this.ape.getHeight() - this.ape.getPaddingBottom();
            }

            public int getEnd() {
                return this.ape.getHeight();
            }

            public void dl(int i) {
                this.ape.do(i);
            }

            public int pF() {
                return this.ape.getPaddingTop();
            }

            public int bO(View view) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                return layoutParams.bottomMargin + (this.ape.cg(view) + layoutParams.topMargin);
            }

            public int bP(View view) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                return layoutParams.rightMargin + (this.ape.cf(view) + layoutParams.leftMargin);
            }

            public int bL(View view) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                return layoutParams.bottomMargin + this.ape.ck(view);
            }

            public int bK(View view) {
                return this.ape.ci(view) - ((LayoutParams) view.getLayoutParams()).topMargin;
            }

            public int bM(View view) {
                this.ape.b(view, true, this.xL);
                return this.xL.bottom;
            }

            public int bN(View view) {
                this.ape.b(view, true, this.xL);
                return this.xL.top;
            }

            public int pH() {
                return (this.ape.getHeight() - this.ape.getPaddingTop()) - this.ape.getPaddingBottom();
            }

            public int getEndPadding() {
                return this.ape.getPaddingBottom();
            }

            public int getMode() {
                return this.ape.qI();
            }

            public int pI() {
                return this.ape.qH();
            }
        };
    }
}
