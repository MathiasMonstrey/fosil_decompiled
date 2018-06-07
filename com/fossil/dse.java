package com.fossil;

import android.view.View;
import android.view.View.OnClickListener;

public class dse {

    public static class C3168a {
        private int dpr;
        private String dps;
        private int dpt;
        private OnClickListener dpu;
        private int dpv = 1;
        private int dpw = 80;
        private int dpx = 3;
        private int dpy = 0;
        private dsf dpz;
        private final View yL;

        public C3168a(View view) {
            this.yL = view;
        }

        public C3168a mi(int i) {
            this.dpr = i;
            this.dps = null;
            return this;
        }

        public C3168a jy(String str) {
            this.dps = str;
            this.dpr = -1;
            return this;
        }

        public C3168a m9610a(int i, OnClickListener onClickListener) {
            this.dpt = i;
            this.dpu = onClickListener;
            return this;
        }

        public C3168a mj(int i) {
            this.dpv = i;
            return this;
        }

        public C3168a mk(int i) {
            this.dpw = i;
            return this;
        }

        public C3168a ml(int i) {
            this.dpx = i;
            return this;
        }

        public C3168a mm(int i) {
            this.dpy = i;
            return this;
        }

        public void show() {
            if (this.dpr != -1) {
                this.dpz = new dsf(this.yL, this.dpr, this.dpt, this.dpu, this.dpv, this.dpw, this.dpx, this.dpy);
            } else {
                this.dpz = new dsf(this.yL, this.dps, this.dpt, this.dpu, this.dpv, this.dpw, this.dpx, this.dpy);
            }
            this.dpz.show();
        }

        public boolean isShowing() {
            return this.dpz != null && this.dpz.isShowing();
        }
    }

    public static void hide() {
        dsf awr = dsf.awr();
        if (awr != null) {
            awr.hide();
        }
    }
}
