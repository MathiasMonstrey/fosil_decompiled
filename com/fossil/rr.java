package com.fossil;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

public class rr {
    final C4050b alP;
    final C4049a alQ = new C4049a();
    final List<View> alR = new ArrayList();

    static class C4049a {
        long alS = 0;
        C4049a alT;

        C4049a() {
        }

        void set(int i) {
            if (i >= 64) {
                oI();
                this.alT.set(i - 64);
                return;
            }
            this.alS |= 1 << i;
        }

        private void oI() {
            if (this.alT == null) {
                this.alT = new C4049a();
            }
        }

        void clear(int i) {
            if (i < 64) {
                this.alS &= (1 << i) ^ -1;
            } else if (this.alT != null) {
                this.alT.clear(i - 64);
            }
        }

        boolean get(int i) {
            if (i < 64) {
                return (this.alS & (1 << i)) != 0;
            } else {
                oI();
                return this.alT.get(i - 64);
            }
        }

        void reset() {
            this.alS = 0;
            if (this.alT != null) {
                this.alT.reset();
            }
        }

        void m13408i(int i, boolean z) {
            if (i >= 64) {
                oI();
                this.alT.m13408i(i - 64, z);
                return;
            }
            boolean z2 = (this.alS & Long.MIN_VALUE) != 0;
            long j = (1 << i) - 1;
            this.alS = (((j ^ -1) & this.alS) << 1) | (this.alS & j);
            if (z) {
                set(i);
            } else {
                clear(i);
            }
            if (z2 || this.alT != null) {
                oI();
                this.alT.m13408i(0, z2);
            }
        }

        boolean cX(int i) {
            if (i >= 64) {
                oI();
                return this.alT.cX(i - 64);
            }
            long j = 1 << i;
            boolean z = (this.alS & j) != 0;
            this.alS &= j ^ -1;
            j--;
            this.alS = Long.rotateRight((j ^ -1) & this.alS, 1) | (this.alS & j);
            if (this.alT == null) {
                return z;
            }
            if (this.alT.get(0)) {
                set(63);
            }
            this.alT.cX(0);
            return z;
        }

        int cY(int i) {
            if (this.alT == null) {
                if (i >= 64) {
                    return Long.bitCount(this.alS);
                }
                return Long.bitCount(this.alS & ((1 << i) - 1));
            } else if (i < 64) {
                return Long.bitCount(this.alS & ((1 << i) - 1));
            } else {
                return this.alT.cY(i - 64) + Long.bitCount(this.alS);
            }
        }

        public String toString() {
            if (this.alT == null) {
                return Long.toBinaryString(this.alS);
            }
            return this.alT.toString() + "xx" + Long.toBinaryString(this.alS);
        }
    }

    public interface C4050b {
        void addView(View view, int i);

        void attachViewToParent(View view, int i, LayoutParams layoutParams);

        v bB(View view);

        void bC(View view);

        void bD(View view);

        void detachViewFromParent(int i);

        View getChildAt(int i);

        int getChildCount();

        int indexOfChild(View view);

        void removeAllViews();

        void removeViewAt(int i);
    }

    public rr(C4050b c4050b) {
        this.alP = c4050b;
    }

    private void bv(View view) {
        this.alR.add(view);
        this.alP.bC(view);
    }

    private boolean bw(View view) {
        if (!this.alR.remove(view)) {
            return false;
        }
        this.alP.bD(view);
        return true;
    }

    public void m13411h(View view, boolean z) {
        m13410a(view, -1, z);
    }

    public void m13410a(View view, int i, boolean z) {
        int childCount;
        if (i < 0) {
            childCount = this.alP.getChildCount();
        } else {
            childCount = cU(i);
        }
        this.alQ.m13408i(childCount, z);
        if (z) {
            bv(view);
        }
        this.alP.addView(view, childCount);
    }

    private int cU(int i) {
        if (i < 0) {
            return -1;
        }
        int childCount = this.alP.getChildCount();
        int i2 = i;
        while (i2 < childCount) {
            int cY = i - (i2 - this.alQ.cY(i2));
            if (cY == 0) {
                while (this.alQ.get(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += cY;
        }
        return -1;
    }

    public void removeView(View view) {
        int indexOfChild = this.alP.indexOfChild(view);
        if (indexOfChild >= 0) {
            if (this.alQ.cX(indexOfChild)) {
                bw(view);
            }
            this.alP.removeViewAt(indexOfChild);
        }
    }

    public void removeViewAt(int i) {
        int cU = cU(i);
        View childAt = this.alP.getChildAt(cU);
        if (childAt != null) {
            if (this.alQ.cX(cU)) {
                bw(childAt);
            }
            this.alP.removeViewAt(cU);
        }
    }

    public View getChildAt(int i) {
        return this.alP.getChildAt(cU(i));
    }

    public void oG() {
        this.alQ.reset();
        for (int size = this.alR.size() - 1; size >= 0; size--) {
            this.alP.bD((View) this.alR.get(size));
            this.alR.remove(size);
        }
        this.alP.removeAllViews();
    }

    public View cV(int i) {
        int size = this.alR.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = (View) this.alR.get(i2);
            v bB = this.alP.bB(view);
            if (bB.rl() == i && !bB.isInvalid() && !bB.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    public void m13409a(View view, int i, LayoutParams layoutParams, boolean z) {
        int childCount;
        if (i < 0) {
            childCount = this.alP.getChildCount();
        } else {
            childCount = cU(i);
        }
        this.alQ.m13408i(childCount, z);
        if (z) {
            bv(view);
        }
        this.alP.attachViewToParent(view, childCount, layoutParams);
    }

    public int getChildCount() {
        return this.alP.getChildCount() - this.alR.size();
    }

    public int oH() {
        return this.alP.getChildCount();
    }

    public View cW(int i) {
        return this.alP.getChildAt(i);
    }

    public void detachViewFromParent(int i) {
        int cU = cU(i);
        this.alQ.cX(cU);
        this.alP.detachViewFromParent(cU);
    }

    public int indexOfChild(View view) {
        int indexOfChild = this.alP.indexOfChild(view);
        if (indexOfChild == -1 || this.alQ.get(indexOfChild)) {
            return -1;
        }
        return indexOfChild - this.alQ.cY(indexOfChild);
    }

    public boolean bx(View view) {
        return this.alR.contains(view);
    }

    public void by(View view) {
        int indexOfChild = this.alP.indexOfChild(view);
        if (indexOfChild < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        this.alQ.set(indexOfChild);
        bv(view);
    }

    public void bz(View view) {
        int indexOfChild = this.alP.indexOfChild(view);
        if (indexOfChild < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        } else if (this.alQ.get(indexOfChild)) {
            this.alQ.clear(indexOfChild);
            bw(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public String toString() {
        return this.alQ.toString() + ", hidden list:" + this.alR.size();
    }

    public boolean bA(View view) {
        int indexOfChild = this.alP.indexOfChild(view);
        if (indexOfChild == -1) {
            return bw(view) ? true : true;
        } else {
            if (!this.alQ.get(indexOfChild)) {
                return false;
            }
            this.alQ.cX(indexOfChild);
            if (bw(view)) {
                this.alP.removeViewAt(indexOfChild);
            } else {
                this.alP.removeViewAt(indexOfChild);
            }
            return true;
        }
    }
}
