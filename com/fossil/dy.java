package com.fossil;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;

@TargetApi(13)
public class dy {
    private final C2143a Hs;
    private int Ht;
    private int Hu;
    private boolean Hv;
    private final OnLongClickListener Hw = new C32901(this);
    private final OnTouchListener Hx = new C32912(this);
    private final View mView;

    public interface C2143a {
        boolean mo1878a(View view, dy dyVar);
    }

    class C32901 implements OnLongClickListener {
        final /* synthetic */ dy Hy;

        C32901(dy dyVar) {
            this.Hy = dyVar;
        }

        public boolean onLongClick(View view) {
            return this.Hy.onLongClick(view);
        }
    }

    class C32912 implements OnTouchListener {
        final /* synthetic */ dy Hy;

        C32912(dy dyVar) {
            this.Hy = dyVar;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return this.Hy.onTouch(view, motionEvent);
        }
    }

    public dy(View view, C2143a c2143a) {
        this.mView = view;
        this.Hs = c2143a;
    }

    public void hG() {
        this.mView.setOnLongClickListener(this.Hw);
        this.mView.setOnTouchListener(this.Hx);
    }

    public void detach() {
        this.mView.setOnLongClickListener(null);
        this.mView.setOnTouchListener(null);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.Ht = x;
                this.Hu = y;
                return false;
            case 1:
            case 3:
                this.Hv = false;
                return false;
            case 2:
                if (!ks.m12049e(motionEvent, 8194) || (ks.m12046c(motionEvent) & 1) == 0 || this.Hv) {
                    return false;
                }
                if (this.Ht == x && this.Hu == y) {
                    return false;
                }
                this.Ht = x;
                this.Hu = y;
                this.Hv = this.Hs.mo1878a(view, this);
                return this.Hv;
            default:
                return false;
        }
    }

    public boolean onLongClick(View view) {
        return this.Hs.mo1878a(view, this);
    }

    public void m10274a(Point point) {
        point.set(this.Ht, this.Hu);
    }
}
