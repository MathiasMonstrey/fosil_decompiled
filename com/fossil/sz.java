package com.fossil;

import android.view.View;

public class sz {
    final C4087b avW;
    C4086a avX = new C4086a();

    static class C4086a {
        int avY = 0;
        int avZ;
        int awa;
        int awb;
        int awc;

        C4086a() {
        }

        void setBounds(int i, int i2, int i3, int i4) {
            this.avZ = i;
            this.awa = i2;
            this.awb = i3;
            this.awc = i4;
        }

        void addFlags(int i) {
            this.avY |= i;
        }

        void sI() {
            this.avY = 0;
        }

        int compare(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            if (i == i2) {
                return 2;
            }
            return 4;
        }

        boolean sJ() {
            if ((this.avY & 7) != 0 && (this.avY & (compare(this.awb, this.avZ) << 0)) == 0) {
                return false;
            }
            if ((this.avY & 112) != 0 && (this.avY & (compare(this.awb, this.awa) << 4)) == 0) {
                return false;
            }
            if ((this.avY & 1792) != 0 && (this.avY & (compare(this.awc, this.avZ) << 8)) == 0) {
                return false;
            }
            if ((this.avY & 28672) == 0 || (this.avY & (compare(this.awc, this.awa) << 12)) != 0) {
                return true;
            }
            return false;
        }
    }

    public interface C4087b {
        int cp(View view);

        int cq(View view);

        View getChildAt(int i);

        int qM();

        int qN();
    }

    public sz(C4087b c4087b) {
        this.avW = c4087b;
    }

    public View m13592o(int i, int i2, int i3, int i4) {
        int qM = this.avW.qM();
        int qN = this.avW.qN();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View childAt = this.avW.getChildAt(i);
            this.avX.setBounds(qM, qN, this.avW.cp(childAt), this.avW.cq(childAt));
            if (i3 != 0) {
                this.avX.sI();
                this.avX.addFlags(i3);
                if (this.avX.sJ()) {
                    return childAt;
                }
            }
            if (i4 != 0) {
                this.avX.sI();
                this.avX.addFlags(i4);
                if (this.avX.sJ()) {
                    i += i5;
                    view = childAt;
                }
            }
            childAt = view;
            i += i5;
            view = childAt;
        }
        return view;
    }

    public boolean m13591E(View view, int i) {
        this.avX.setBounds(this.avW.qM(), this.avW.qN(), this.avW.cp(view), this.avW.cq(view));
        if (i == 0) {
            return false;
        }
        this.avX.sI();
        this.avX.addFlags(i);
        return this.avX.sJ();
    }
}
