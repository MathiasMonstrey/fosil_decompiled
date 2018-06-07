package com.fossil;

import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.AppCompatImageView;
import android.util.SparseIntArray;
import android.view.View;
import com.fossil.C2161i.C3687b;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.view.FlexibleTextView;
import com.portfolio.platform.view.recyclerview.RecyclerViewCalendar;

public class clo extends C2161i {
    private static final C3687b cpG = null;
    private static final SparseIntArray cpH = new SparseIntArray();
    private long cpL = -1;
    public final AppCompatImageView cuM;
    public final FlexibleTextView cuS;
    public final RecyclerViewCalendar cuX;
    private final CoordinatorLayout cuY;
    public final View cuZ;

    static {
        cpH.put(R.id.v_action_bar, 1);
        cpH.put(R.id.ftvDate, 2);
        cpH.put(R.id.aciv_arrow, 3);
        cpH.put(R.id.calendar_view, 4);
    }

    public clo(C2160d c2160d, View view) {
        super(c2160d, view, 0);
        Object[] a = C2161i.m6993a(c2160d, view, 5, cpG, cpH);
        this.cuM = (AppCompatImageView) a[3];
        this.cuX = (RecyclerViewCalendar) a[4];
        this.cuS = (FlexibleTextView) a[2];
        this.cuY = (CoordinatorLayout) a[0];
        this.cuY.setTag(null);
        this.cuZ = (View) a[1];
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

    public static clo m7033A(View view, C2160d c2160d) {
        if ("layout/stats_sleep_month_fragment_0".equals(view.getTag())) {
            return new clo(c2160d, view);
        }
        throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
    }
}
