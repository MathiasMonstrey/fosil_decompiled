package com.fossil;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.SwitchCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import com.fossil.C2161i.C3687b;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.view.FlexibleTextView;

public class cld extends C2161i {
    private static final C3687b cpG = null;
    private static final SparseIntArray cpH = new SparseIntArray();
    public final FlexibleTextView cpC;
    private long cpL = -1;
    public final AppCompatImageView cqc;
    public final ConstraintLayout cqd;
    private final RelativeLayout crt;
    public final SwitchCompat ctq;
    public final SwitchCompat ctr;
    public final RelativeLayout cts;
    public final RelativeLayout ctt;
    public final RelativeLayout ctu;
    public final SwitchCompat ctv;

    static {
        cpH.put(R.id.cl_toolbar, 1);
        cpH.put(R.id.aciv_back, 2);
        cpH.put(R.id.ftv_title, 3);
        cpH.put(R.id.opt_1_container, 4);
        cpH.put(R.id.receive_switch, 5);
        cpH.put(R.id.opt_2_container, 6);
        cpH.put(R.id.email_switch, 7);
        cpH.put(R.id.opt_3_container, 8);
        cpH.put(R.id.anonymous_switch, 9);
    }

    public cld(C2160d c2160d, View view) {
        super(c2160d, view, 0);
        Object[] a = C2161i.m6993a(c2160d, view, 10, cpG, cpH);
        this.cqc = (AppCompatImageView) a[2];
        this.ctq = (SwitchCompat) a[9];
        this.cqd = (ConstraintLayout) a[1];
        this.ctr = (SwitchCompat) a[7];
        this.cpC = (FlexibleTextView) a[3];
        this.crt = (RelativeLayout) a[0];
        this.crt.setTag(null);
        this.cts = (RelativeLayout) a[4];
        this.ctt = (RelativeLayout) a[6];
        this.ctu = (RelativeLayout) a[8];
        this.ctv = (SwitchCompat) a[5];
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

    public static cld m7022p(View view, C2160d c2160d) {
        if ("layout/fragment_opt_in_0".equals(view.getTag())) {
            return new cld(c2160d, view);
        }
        throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
    }
}
