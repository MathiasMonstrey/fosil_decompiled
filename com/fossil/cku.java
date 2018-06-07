package com.fossil;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatImageView;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import com.fossil.C2161i.C3687b;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.view.FlexibleButton;
import com.portfolio.platform.view.FlexibleTextView;

public class cku extends C2161i {
    private static final C3687b cpG = null;
    private static final SparseIntArray cpH = new SparseIntArray();
    public final FlexibleTextView cpC;
    private long cpL = -1;
    public final AppCompatImageView cqc;
    public final ConstraintLayout cqd;
    private final ConstraintLayout cqf;
    public final AppCompatImageView cqm;
    public final AppCompatImageButton cqn;
    public final AppCompatImageButton cqo;
    public final FrameLayout cqp;
    public final FlexibleTextView cqq;
    public final FlexibleTextView cqr;
    public final FlexibleButton cqs;
    public final FlexibleTextView cqt;

    static {
        cpH.put(R.id.cl_toolbar, 1);
        cpH.put(R.id.aciv_back, 2);
        cpH.put(R.id.ftv_title, 3);
        cpH.put(R.id.fl_description, 4);
        cpH.put(R.id.ftv_hour_description, 5);
        cpH.put(R.id.ftv_minute_description, 6);
        cpH.put(R.id.ftv_subeye_description, 7);
        cpH.put(R.id.ftv_next, 8);
        cpH.put(R.id.aciv_left, 9);
        cpH.put(R.id.aciv_right, 10);
        cpH.put(R.id.aciv_device, 11);
    }

    public cku(C2160d c2160d, View view) {
        super(c2160d, view, 0);
        Object[] a = C2161i.m6993a(c2160d, view, 12, cpG, cpH);
        m7002c(ckm.class);
        this.cqc = (AppCompatImageView) a[2];
        this.cqm = (AppCompatImageView) a[11];
        this.cqn = (AppCompatImageButton) a[9];
        this.cqo = (AppCompatImageButton) a[10];
        this.cqd = (ConstraintLayout) a[1];
        this.cqp = (FrameLayout) a[4];
        this.cqq = (FlexibleTextView) a[5];
        this.cqr = (FlexibleTextView) a[6];
        this.cqs = (FlexibleButton) a[8];
        this.cqt = (FlexibleTextView) a[7];
        this.cpC = (FlexibleTextView) a[3];
        this.cqf = (ConstraintLayout) a[0];
        this.cqf.setTag(null);
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

    public static cku m7010g(View view, C2160d c2160d) {
        if ("layout/device_calibration_fragment_0".equals(view.getTag())) {
            return new cku(c2160d, view);
        }
        throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
    }
}
