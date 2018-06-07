package com.fossil;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.AppCompatImageView;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import com.fossil.C2161i.C3687b;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.view.FlexibleTextView;

public class ckq extends C2161i {
    private static final C3687b cpG = null;
    private static final SparseIntArray cpH = new SparseIntArray();
    private long cpL = -1;
    public final AppCompatImageView cpO;
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
    public final View cqb;

    static {
        cpH.put(R.id.aciv_remove, 1);
        cpH.put(R.id.v_enable, 2);
        cpH.put(R.id.ll_days_repeat, 3);
        cpH.put(R.id.day_sunday, 4);
        cpH.put(R.id.day_monday, 5);
        cpH.put(R.id.day_tuesday, 6);
        cpH.put(R.id.day_wednesday, 7);
        cpH.put(R.id.day_thursday, 8);
        cpH.put(R.id.day_friday, 9);
        cpH.put(R.id.day_saturday, 10);
        cpH.put(R.id.v_group_line, 11);
        cpH.put(R.id.ftv_name, 12);
        cpH.put(R.id.ftv_time, 13);
    }

    public ckq(C2160d c2160d, View view) {
        super(c2160d, view, 0);
        Object[] a = C2161i.m6993a(c2160d, view, 14, cpG, cpH);
        this.cpO = (AppCompatImageView) a[1];
        this.cpP = (FlexibleTextView) a[9];
        this.cpQ = (FlexibleTextView) a[5];
        this.cpR = (FlexibleTextView) a[10];
        this.cpS = (FlexibleTextView) a[4];
        this.cpT = (FlexibleTextView) a[8];
        this.cpU = (FlexibleTextView) a[6];
        this.cpV = (FlexibleTextView) a[7];
        this.cpW = (FlexibleTextView) a[12];
        this.cpX = (FlexibleTextView) a[13];
        this.cpY = (ConstraintLayout) a[0];
        this.cpY.setTag(null);
        this.cpZ = (LinearLayout) a[3];
        this.cqa = (View) a[2];
        this.cqb = (View) a[11];
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

    public static ckq m7006c(View view, C2160d c2160d) {
        if ("layout/alarm_main_adapter_0".equals(view.getTag())) {
            return new ckq(c2160d, view);
        }
        throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
    }
}
