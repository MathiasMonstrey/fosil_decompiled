package com.fossil;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;
import android.view.View;
import com.fossil.C2161i.C3687b;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.view.FlexibleTextView;

public class ckr extends C2161i {
    private static final C3687b cpG = null;
    private static final SparseIntArray cpH = new SparseIntArray();
    public final FlexibleTextView cpC;
    private long cpL = -1;
    public final AppCompatImageView cqc;
    public final ConstraintLayout cqd;
    public final FlexibleTextView cqe;
    private final ConstraintLayout cqf;
    public final RecyclerView cqg;

    static {
        cpH.put(R.id.cl_toolbar, 1);
        cpH.put(R.id.aciv_back, 2);
        cpH.put(R.id.ftv_title, 3);
        cpH.put(R.id.ftv_add_alarm, 4);
        cpH.put(R.id.rv_alarms, 5);
    }

    public ckr(C2160d c2160d, View view) {
        super(c2160d, view, 0);
        Object[] a = C2161i.m6993a(c2160d, view, 6, cpG, cpH);
        m7002c(ckm.class);
        this.cqc = (AppCompatImageView) a[2];
        this.cqd = (ConstraintLayout) a[1];
        this.cqe = (FlexibleTextView) a[4];
        this.cpC = (FlexibleTextView) a[3];
        this.cqf = (ConstraintLayout) a[0];
        this.cqf.setTag(null);
        this.cqg = (RecyclerView) a[5];
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
        if ((j & 1) != 0) {
            this.oA.du().m6988F(this.cqf, R.drawable.fs_background);
        }
    }

    public static ckr m7007d(View view, C2160d c2160d) {
        if ("layout/alarm_main_fragment_0".equals(view.getTag())) {
            return new ckr(c2160d, view);
        }
        throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
    }
}
