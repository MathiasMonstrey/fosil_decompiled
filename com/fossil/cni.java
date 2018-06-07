package com.fossil;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class cni {
    private C2217a cyT;
    private View view;

    public interface C2217a {
        void cN(View view);

        void cO(View view);

        void cP(View view);

        void cQ(View view);

        void onClick(View view);
    }

    public void m7195a(final View view, final C2217a c2217a) {
        this.view = view;
        this.cyT = c2217a;
        view.setOnTouchListener(new OnTouchListener(this) {
            private long cyU;
            final /* synthetic */ cni cyW;

            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.cyU = System.currentTimeMillis();
                        c2217a.cP(view);
                        return true;
                    case 1:
                    case 3:
                        if (System.currentTimeMillis() - this.cyU > 300) {
                            c2217a.cO(view);
                        } else {
                            c2217a.onClick(view);
                        }
                        c2217a.cQ(view);
                        this.cyU = 0;
                        return true;
                    case 2:
                        if (System.currentTimeMillis() - this.cyU <= 300) {
                            return true;
                        }
                        c2217a.cN(view);
                        return true;
                    default:
                        return false;
                }
            }
        });
    }
}
