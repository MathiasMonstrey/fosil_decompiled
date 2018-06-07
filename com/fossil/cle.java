package com.fossil;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.AppCompatImageView;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.fossil.C2161i.C3687b;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.view.FlexibleTextView;

public class cle extends C2161i {
    private static final C3687b cpG = null;
    private static final SparseIntArray cpH = new SparseIntArray();
    public final FlexibleTextView cpC;
    private long cpL = -1;
    public final AppCompatImageView cqc;
    private final RelativeLayout crt;
    public final FlexibleTextView ctA;
    public final ImageView ctB;
    public final ImageView ctC;
    public final ImageView ctD;
    public final ConstraintLayout ctw;
    public final FlexibleTextView ctx;
    public final FlexibleTextView cty;
    public final FlexibleTextView ctz;

    static {
        cpH.put(R.id.fl_toolbar, 1);
        cpH.put(R.id.aciv_back, 2);
        cpH.put(R.id.ftv_title, 3);
        cpH.put(R.id.ftv_des, 4);
        cpH.put(R.id.ftvUnderAmourRecord, 5);
        cpH.put(R.id.ivUnderAmourRecordCheck, 6);
        cpH.put(R.id.ftvUpByJawbone, 7);
        cpH.put(R.id.ivUpByJawboneCheck, 8);
        cpH.put(R.id.ftvHealthKit, 9);
        cpH.put(R.id.ivHealthKitCheck, 10);
    }

    public cle(C2160d c2160d, View view) {
        super(c2160d, view, 0);
        Object[] a = C2161i.m6993a(c2160d, view, 11, cpG, cpH);
        this.cqc = (AppCompatImageView) a[2];
        this.ctw = (ConstraintLayout) a[1];
        this.ctx = (FlexibleTextView) a[4];
        this.cty = (FlexibleTextView) a[9];
        this.cpC = (FlexibleTextView) a[3];
        this.ctz = (FlexibleTextView) a[5];
        this.ctA = (FlexibleTextView) a[7];
        this.ctB = (ImageView) a[10];
        this.ctC = (ImageView) a[6];
        this.ctD = (ImageView) a[8];
        this.crt = (RelativeLayout) a[0];
        this.crt.setTag(null);
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

    public static cle m7023q(View view, C2160d c2160d) {
        if ("layout/fragment_profile_connected_app_0".equals(view.getTag())) {
            return new cle(c2160d, view);
        }
        throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
    }
}
