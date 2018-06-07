package com.fossil;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.AppCompatImageView;
import android.util.SparseIntArray;
import android.view.View;
import com.fossil.C2161i.C3687b;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.view.FlexibleTextView;

public class clp extends C2161i {
    private static final C3687b cpG = null;
    private static final SparseIntArray cpH = new SparseIntArray();
    private long cpL = -1;
    private final ConstraintLayout cqf;
    public final AppCompatImageView cva;
    public final FlexibleTextView cvb;
    public final FlexibleTextView cvc;
    public final View cve;
    public final View cvf;
    public final FlexibleTextView cvr;
    public final View cvs;

    static {
        cpH.put(R.id.aciv_close, 1);
        cpH.put(R.id.v_intense, 2);
        cpH.put(R.id.v_still, 3);
        cpH.put(R.id.v_light, 4);
        cpH.put(R.id.ftv_intense, 5);
        cpH.put(R.id.ftv_still, 6);
        cpH.put(R.id.ftv_light, 7);
    }

    public clp(C2160d c2160d, View view) {
        super(c2160d, view, 0);
        Object[] a = C2161i.m6993a(c2160d, view, 8, cpG, cpH);
        this.cva = (AppCompatImageView) a[1];
        this.cvb = (FlexibleTextView) a[5];
        this.cvc = (FlexibleTextView) a[7];
        this.cvr = (FlexibleTextView) a[6];
        this.cqf = (ConstraintLayout) a[0];
        this.cqf.setTag(null);
        this.cve = (View) a[2];
        this.cvf = (View) a[4];
        this.cvs = (View) a[3];
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

    public static clp m7034B(View view, C2160d c2160d) {
        if ("layout/stats_sleep_overview_fragment_0".equals(view.getTag())) {
            return new clp(c2160d, view);
        }
        throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
    }
}
