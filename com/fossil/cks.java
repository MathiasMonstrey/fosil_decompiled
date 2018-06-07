package com.fossil;

import android.support.constraint.ConstraintLayout;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import com.fossil.C2161i.C3687b;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.view.FlexibleEditText;
import com.portfolio.platform.view.FlexibleTextView;

public class cks extends C2161i {
    private static final C3687b cpG = null;
    private static final SparseIntArray cpH = new SparseIntArray();
    public final FlexibleTextView cpC;
    private long cpL = -1;
    public final FlexibleTextView cpP;
    public final FlexibleTextView cpQ;
    public final FlexibleTextView cpR;
    public final FlexibleTextView cpS;
    public final FlexibleTextView cpT;
    public final FlexibleTextView cpU;
    public final FlexibleTextView cpV;
    public final FlexibleTextView cpW;
    public final FlexibleTextView cpX;
    public final ConstraintLayout cpY;
    public final LinearLayout cpZ;
    public final View cqa;
    public final ConstraintLayout cqd;
    private final ConstraintLayout cqf;
    public final FlexibleEditText cqh;
    public final FlexibleTextView cqi;
    public final FlexibleTextView cqj;

    static {
        cpH.put(R.id.cl_toolbar, 1);
        cpH.put(R.id.ftv_cancel, 2);
        cpH.put(R.id.ftv_save, 3);
        cpH.put(R.id.ftv_title, 4);
        cpH.put(R.id.fet_name, 5);
        cpH.put(R.id.itemView, 6);
        cpH.put(R.id.v_enable, 7);
        cpH.put(R.id.ll_days_repeat, 8);
        cpH.put(R.id.day_sunday, 9);
        cpH.put(R.id.day_monday, 10);
        cpH.put(R.id.day_tuesday, 11);
        cpH.put(R.id.day_wednesday, 12);
        cpH.put(R.id.day_thursday, 13);
        cpH.put(R.id.day_friday, 14);
        cpH.put(R.id.day_saturday, 15);
        cpH.put(R.id.ftv_name, 16);
        cpH.put(R.id.ftv_time, 17);
    }

    public cks(C2160d c2160d, View view) {
        super(c2160d, view, 0);
        Object[] a = C2161i.m6993a(c2160d, view, 18, cpG, cpH);
        m7002c(ckm.class);
        this.cqd = (ConstraintLayout) a[1];
        this.cpP = (FlexibleTextView) a[14];
        this.cpQ = (FlexibleTextView) a[10];
        this.cpR = (FlexibleTextView) a[15];
        this.cpS = (FlexibleTextView) a[9];
        this.cpT = (FlexibleTextView) a[13];
        this.cpU = (FlexibleTextView) a[11];
        this.cpV = (FlexibleTextView) a[12];
        this.cqh = (FlexibleEditText) a[5];
        this.cqi = (FlexibleTextView) a[2];
        this.cpW = (FlexibleTextView) a[16];
        this.cqj = (FlexibleTextView) a[3];
        this.cpX = (FlexibleTextView) a[17];
        this.cpC = (FlexibleTextView) a[4];
        this.cpY = (ConstraintLayout) a[6];
        this.cpZ = (LinearLayout) a[8];
        this.cqf = (ConstraintLayout) a[0];
        this.cqf.setTag(null);
        this.cqa = (View) a[7];
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

    public static cks m7008e(View view, C2160d c2160d) {
        if ("layout/alarm_set_fragment_0".equals(view.getTag())) {
            return new cks(c2160d, view);
        }
        throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
    }
}
