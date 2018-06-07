package com.fossil;

import android.view.View;
import android.view.ViewParent;

public class kw {
    private ViewParent RD;
    private boolean RE;
    private int[] RF;
    private final View mView;

    public kw(View view) {
        this.mView = view;
    }

    public void setNestedScrollingEnabled(boolean z) {
        if (this.RE) {
            li.ar(this.mView);
        }
        this.RE = z;
    }

    public boolean isNestedScrollingEnabled() {
        return this.RE;
    }

    public boolean hasNestedScrollingParent() {
        return this.RD != null;
    }

    public boolean startNestedScroll(int i) {
        if (hasNestedScrollingParent()) {
            return true;
        }
        if (isNestedScrollingEnabled()) {
            View view = this.mView;
            for (ViewParent parent = this.mView.getParent(); parent != null; parent = parent.getParent()) {
                if (lx.m12367a(parent, view, this.mView, i)) {
                    this.RD = parent;
                    lx.m12368b(parent, view, this.mView, i);
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
        }
        return false;
    }

    public void stopNestedScroll() {
        if (this.RD != null) {
            lx.m12362a(this.RD, this.mView);
            this.RD = null;
        }
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        if (!isNestedScrollingEnabled() || this.RD == null) {
            return false;
        }
        if (i != 0 || i2 != 0 || i3 != 0 || i4 != 0) {
            int i5;
            int i6;
            if (iArr != null) {
                this.mView.getLocationInWindow(iArr);
                int i7 = iArr[0];
                i5 = iArr[1];
                i6 = i7;
            } else {
                i5 = 0;
                i6 = 0;
            }
            lx.m12363a(this.RD, this.mView, i, i2, i3, i4);
            if (iArr != null) {
                this.mView.getLocationInWindow(iArr);
                iArr[0] = iArr[0] - i6;
                iArr[1] = iArr[1] - i5;
            }
            return true;
        } else if (iArr == null) {
            return false;
        } else {
            iArr[0] = 0;
            iArr[1] = 0;
            return false;
        }
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        if (!isNestedScrollingEnabled() || this.RD == null) {
            return false;
        }
        if (i != 0 || i2 != 0) {
            int i3;
            int i4;
            if (iArr2 != null) {
                this.mView.getLocationInWindow(iArr2);
                i3 = iArr2[0];
                i4 = iArr2[1];
            } else {
                i4 = 0;
                i3 = 0;
            }
            if (iArr == null) {
                if (this.RF == null) {
                    this.RF = new int[2];
                }
                iArr = this.RF;
            }
            iArr[0] = 0;
            iArr[1] = 0;
            lx.m12364a(this.RD, this.mView, i, i2, iArr);
            if (iArr2 != null) {
                this.mView.getLocationInWindow(iArr2);
                iArr2[0] = iArr2[0] - i3;
                iArr2[1] = iArr2[1] - i4;
            }
            if (iArr[0] == 0 && iArr[1] == 0) {
                return false;
            }
            return true;
        } else if (iArr2 == null) {
            return false;
        } else {
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        if (!isNestedScrollingEnabled() || this.RD == null) {
            return false;
        }
        return lx.m12366a(this.RD, this.mView, f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        if (!isNestedScrollingEnabled() || this.RD == null) {
            return false;
        }
        return lx.m12365a(this.RD, this.mView, f, f2);
    }
}
