package com.fossil;

import android.support.constraint.ConstraintLayout;
import android.util.SparseIntArray;
import android.view.View;
import com.fossil.C2161i.C3687b;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.view.BarChart;
import com.portfolio.platform.view.FlexibleTextView;

public class clq extends C2161i {
    private static final C3687b cpG = null;
    private static final SparseIntArray cpH = new SparseIntArray();
    public final FlexibleTextView cpC;
    private long cpL = -1;
    private final ConstraintLayout cqf;
    public final BarChart cvh;

    static {
        cpH.put(R.id.ftvTitle, 1);
        cpH.put(R.id.weekChart, 2);
    }

    public clq(C2160d c2160d, View view) {
        super(c2160d, view, 0);
        Object[] a = C2161i.m6993a(c2160d, view, 3, cpG, cpH);
        this.cpC = (FlexibleTextView) a[1];
        this.cqf = (ConstraintLayout) a[0];
        this.cqf.setTag(null);
        this.cvh = (BarChart) a[2];
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

    public static clq m7035C(View view, C2160d c2160d) {
        if ("layout/stats_sleep_week_fragment_0".equals(view.getTag())) {
            return new clq(c2160d, view);
        }
        throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
    }
}
