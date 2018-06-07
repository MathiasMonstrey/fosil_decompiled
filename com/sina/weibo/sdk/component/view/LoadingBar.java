package com.sina.weibo.sdk.component.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.TextView;

public class LoadingBar extends TextView {
    private Runnable Dc = new C50591(this);
    private int Ls;
    private int dhc;
    private Handler dsg;
    private Paint wx;

    class C50591 implements Runnable {
        final /* synthetic */ LoadingBar dsh;

        C50591(LoadingBar loadingBar) {
            this.dsh = loadingBar;
        }

        public void run() {
            LoadingBar loadingBar = this.dsh;
            loadingBar.Ls = loadingBar.Ls + 1;
            this.dsh.mu(this.dsh.Ls);
        }
    }

    public LoadingBar(Context context) {
        super(context);
        init(context);
    }

    public LoadingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public LoadingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.dsg = new Handler();
        this.wx = new Paint();
        axo();
    }

    public void axo() {
        this.dhc = -11693826;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.wx.setColor(this.dhc);
        canvas.drawRect(getRect(), this.wx);
    }

    private Rect getRect() {
        return new Rect(0, 0, (getLeft() + (((getRight() - getLeft()) * this.Ls) / 100)) - getLeft(), getBottom() - getTop());
    }

    public void mu(int i) {
        if (i < 7) {
            this.dsg.postDelayed(this.Dc, 70);
        } else {
            this.dsg.removeCallbacks(this.Dc);
            this.Ls = i;
        }
        invalidate();
    }
}
