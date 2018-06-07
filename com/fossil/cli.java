package com.fossil;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.Guideline;
import android.support.v7.widget.AppCompatImageView;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import com.fossil.C2161i.C3687b;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.view.AutoResizeTextView;
import com.portfolio.platform.view.FlexibleTextView;
import com.portfolio.platform.view.RingChart;

public class cli extends C2161i {
    private static final C3687b cpG = null;
    private static final SparseIntArray cpH = new SparseIntArray();
    private long cpL = -1;
    public final FlexibleTextView cqQ;
    public final Guideline cqS;
    private final ConstraintLayout cqf;
    public final FlexibleTextView ctN;
    public final AppCompatImageView cuM;
    public final AppCompatImageView cuN;
    public final RingChart cuO;
    public final LinearLayout cuP;
    public final FlexibleTextView cuQ;
    public final FlexibleTextView cuR;
    public final FlexibleTextView cuS;
    public final FlexibleTextView cuT;
    public final FlexibleTextView cuU;
    public final FlexibleTextView cuV;
    public final AutoResizeTextView cuW;

    static {
        cpH.put(R.id.ftv_date, 1);
        cpH.put(R.id.aciv_arrow, 2);
        cpH.put(R.id.ftv_sync_time, 3);
        cpH.put(R.id.chart, 4);
        cpH.put(R.id.ftvSteps, 5);
        cpH.put(R.id.ftvStepGoal, 6);
        cpH.put(R.id.acivEditInfo, 7);
        cpH.put(R.id.guideline, 8);
        cpH.put(R.id.ftvDistance, 9);
        cpH.put(R.id.ftvDistanceUnit, 10);
        cpH.put(R.id.ftvCalories, 11);
        cpH.put(R.id.ftvCaloriesUnit, 12);
        cpH.put(R.id.flMissingInfo, 13);
        cpH.put(R.id.ftvEditInfo, 14);
    }

    public cli(C2160d c2160d, View view) {
        super(c2160d, view, 0);
        Object[] a = C2161i.m6993a(c2160d, view, 15, cpG, cpH);
        this.cuM = (AppCompatImageView) a[2];
        this.cuN = (AppCompatImageView) a[7];
        this.cuO = (RingChart) a[4];
        this.cuP = (LinearLayout) a[13];
        this.cuQ = (FlexibleTextView) a[11];
        this.cuR = (FlexibleTextView) a[12];
        this.cuS = (FlexibleTextView) a[1];
        this.ctN = (FlexibleTextView) a[9];
        this.cuT = (FlexibleTextView) a[10];
        this.cuU = (FlexibleTextView) a[14];
        this.cuV = (FlexibleTextView) a[6];
        this.cuW = (AutoResizeTextView) a[5];
        this.cqQ = (FlexibleTextView) a[3];
        this.cqS = (Guideline) a[8];
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
    }

    public static cli m7027u(View view, C2160d c2160d) {
        if ("layout/stats_activity_day_fragment_0".equals(view.getTag())) {
            return new cli(c2160d, view);
        }
        throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
    }
}
