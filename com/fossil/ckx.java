package com.fossil;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.AppCompatImageView;
import android.util.SparseIntArray;
import android.view.View;
import com.fossil.C2161i.C3687b;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.view.FlexibleTextView;

public class ckx extends C2161i {
    private static final C3687b cpG = null;
    private static final SparseIntArray cpH = new SparseIntArray();
    public final FlexibleTextView cpC;
    private long cpL = -1;
    public final AppCompatImageView cqY;
    public final FlexibleTextView cqZ;
    public final View cqa;
    public final AppCompatImageView cqc;
    public final ConstraintLayout cqd;
    private final ConstraintLayout cqf;
    public final AppCompatImageView cqm;
    public final FlexibleTextView cra;
    public final FlexibleTextView crb;
    public final FlexibleTextView crd;
    public final FlexibleTextView cre;
    public final View crf;

    static {
        cpH.put(R.id.cl_toolbar, 1);
        cpH.put(R.id.aciv_back, 2);
        cpH.put(R.id.v_enable, 3);
        cpH.put(R.id.ftv_title, 4);
        cpH.put(R.id.ftv_description, 5);
        cpH.put(R.id.ftv_locate_on_map, 6);
        cpH.put(R.id.ftv_device, 7);
        cpH.put(R.id.aciv_device, 8);
        cpH.put(R.id.v_line, 9);
        cpH.put(R.id.ftv_range, 10);
        cpH.put(R.id.aciv_avatar, 11);
        cpH.put(R.id.ftv_you, 12);
    }

    public ckx(C2160d c2160d, View view) {
        super(c2160d, view, 0);
        Object[] a = C2161i.m6993a(c2160d, view, 13, cpG, cpH);
        m7002c(ckm.class);
        this.cqY = (AppCompatImageView) a[11];
        this.cqc = (AppCompatImageView) a[2];
        this.cqm = (AppCompatImageView) a[8];
        this.cqd = (ConstraintLayout) a[1];
        this.cqZ = (FlexibleTextView) a[5];
        this.cra = (FlexibleTextView) a[7];
        this.crb = (FlexibleTextView) a[6];
        this.crd = (FlexibleTextView) a[10];
        this.cpC = (FlexibleTextView) a[4];
        this.cre = (FlexibleTextView) a[12];
        this.cqf = (ConstraintLayout) a[0];
        this.cqf.setTag(null);
        this.cqa = (View) a[3];
        this.crf = (View) a[9];
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

    public static ckx m7013j(View view, C2160d c2160d) {
        if ("layout/device_locate_proximity_fragment_0".equals(view.getTag())) {
            return new ckx(c2160d, view);
        }
        throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
    }
}
