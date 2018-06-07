package com.fossil;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.fossil.C2161i.C3687b;
import com.fossil.wearables.fossil.R;

public class cko extends C2161i {
    private static final C3687b cpG = null;
    private static final SparseIntArray cpH = new SparseIntArray();
    public final FrameLayout cpI;
    public final ImageView cpJ;
    private final FrameLayout cpK;
    private long cpL = -1;

    static {
        cpH.put(R.id.iv_background, 1);
        cpH.put(R.id.fl_container, 2);
    }

    public cko(C2160d c2160d, View view) {
        super(c2160d, view, 0);
        Object[] a = C2161i.m6993a(c2160d, view, 3, cpG, cpH);
        this.cpI = (FrameLayout) a[2];
        this.cpJ = (ImageView) a[1];
        this.cpK = (FrameLayout) a[0];
        this.cpK.setTag(null);
        m7001a(view);
        abv();
    }

    public void abv() {
        synchronized (this) {
            this.cpL = 1;
        }
        dA();
    }

    public boolean dy() {
        synchronized (this) {
            if (this.cpL != 0) {
                return true;
            }
            return false;
        }
    }

    protected void dx() {
        synchronized (this) {
            long j = this.cpL;
            this.cpL = 0;
        }
    }

    public static cko m7004a(View view, C2160d c2160d) {
        if ("layout/activity_main_0".equals(view.getTag())) {
            return new cko(c2160d, view);
        }
        throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
    }
}
