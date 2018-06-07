package com.fossil;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.Guideline;
import android.support.v4.widget.FossilSwipeRefreshLayout;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import com.fossil.C2161i.C3687b;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.view.FlexibleTextView;

public class clm extends C2161i {
    private static final C3687b cpG = null;
    private static final SparseIntArray cpH = new SparseIntArray();
    private long cpL = -1;
    public final Guideline cqS;
    public final ScrollView cqW;
    public final FossilSwipeRefreshLayout ctp;
    public final ConstraintLayout cvi;
    public final FlexibleTextView cvj;
    public final FlexibleTextView cvk;
    public final FrameLayout cvl;
    public final FrameLayout cvm;
    public final FrameLayout cvn;
    public final View cvo;
    public final View cvp;
    public final View cvq;

    static {
        cpH.put(R.id.scroll_view, 1);
        cpH.put(R.id.clRoot, 2);
        cpH.put(R.id.stats_day, 3);
        cpH.put(R.id.guideline, 4);
        cpH.put(R.id.tabBackground, 5);
        cpH.put(R.id.ftvActivity, 6);
        cpH.put(R.id.ftvSleep, 7);
        cpH.put(R.id.v_activity_indicator, 8);
        cpH.put(R.id.v_sleep_indicator, 9);
        cpH.put(R.id.stats_week, 10);
        cpH.put(R.id.stats_buddy_challenge, 11);
    }

    public clm(C2160d c2160d, View view) {
        super(c2160d, view, 0);
        Object[] a = C2161i.m6993a(c2160d, view, 12, cpG, cpH);
        this.cvi = (ConstraintLayout) a[2];
        this.cvj = (FlexibleTextView) a[6];
        this.cvk = (FlexibleTextView) a[7];
        this.cqS = (Guideline) a[4];
        this.cqW = (ScrollView) a[1];
        this.ctp = (FossilSwipeRefreshLayout) a[0];
        this.ctp.setTag(null);
        this.cvl = (FrameLayout) a[11];
        this.cvm = (FrameLayout) a[3];
        this.cvn = (FrameLayout) a[10];
        this.cvo = (View) a[5];
        this.cvp = (View) a[8];
        this.cvq = (View) a[9];
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

    public static clm m7031y(View view, C2160d c2160d) {
        if ("layout/stats_fragment_0".equals(view.getTag())) {
            return new clm(c2160d, view);
        }
        throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
    }
}
