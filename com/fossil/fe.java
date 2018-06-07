package com.fossil;

import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;

public abstract class fe extends la {
    private final fa JV;
    private fg JW = null;
    private Fragment JX = null;

    public abstract Fragment aK(int i);

    public fe(fa faVar) {
        this.JV = faVar;
    }

    public void mo1710e(ViewGroup viewGroup) {
        if (viewGroup.getId() == -1) {
            throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
        }
    }

    public Object mo1709d(ViewGroup viewGroup, int i) {
        if (this.JW == null) {
            this.JW = this.JV.hW();
        }
        long itemId = getItemId(i);
        Fragment W = this.JV.mo3086W(m6439b(viewGroup.getId(), itemId));
        if (W != null) {
            this.JW.mo2972c(W);
        } else {
            W = aK(i);
            this.JW.mo2966a(viewGroup.getId(), W, m6439b(viewGroup.getId(), itemId));
        }
        if (W != this.JX) {
            W.setMenuVisibility(false);
            W.setUserVisibleHint(false);
        }
        return W;
    }

    public void mo1706a(ViewGroup viewGroup, int i, Object obj) {
        if (this.JW == null) {
            this.JW = this.JV.hW();
        }
        this.JW.mo2971b((Fragment) obj);
    }

    public void mo1708b(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.JX) {
            if (this.JX != null) {
                this.JX.setMenuVisibility(false);
                this.JX.setUserVisibleHint(false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            }
            this.JX = fragment;
        }
    }

    public void mo1711f(ViewGroup viewGroup) {
        if (this.JW != null) {
            this.JW.commitNowAllowingStateLoss();
            this.JW = null;
        }
    }

    public boolean mo1707a(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    public Parcelable ip() {
        return null;
    }

    public void mo1705a(Parcelable parcelable, ClassLoader classLoader) {
    }

    public long getItemId(int i) {
        return (long) i;
    }

    private static String m6439b(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }
}
