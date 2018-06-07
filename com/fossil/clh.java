package com.fossil;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.AppCompatImageView;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.fossil.C2161i.C3687b;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.view.FlexibleButton;
import com.portfolio.platform.view.FlexibleTextView;
import com.portfolio.platform.view.FossilCircleImageView;
import com.portfolio.platform.view.recyclerview.RecyclerViewPager;

public class clh extends C2161i {
    private static final C3687b cpG = null;
    private static final SparseIntArray cpH = new SparseIntArray();
    private long cpL = -1;
    public final ConstraintLayout cqd;
    private final ConstraintLayout cqf;
    public final AppCompatImageView cqm;
    public final FlexibleTextView cra;
    public final FlexibleButton cuA;
    public final FlexibleTextView cuB;
    public final ImageView cuC;
    public final FossilCircleImageView cuD;
    public final ImageView cuE;
    public final LinearLayout cuF;
    public final LinearLayout cuG;
    public final LinearLayout cuH;
    public final LinearLayout cuI;
    public final LinearLayout cuJ;
    public final ProgressBar cuK;
    public final RecyclerViewPager cuL;
    public final AppCompatImageView cur;
    public final AppCompatImageView cus;
    public final AppCompatImageView cut;
    public final AppCompatImageView cuu;
    public final AppCompatImageView cuv;
    public final RelativeLayout cuw;
    public final ConstraintLayout cux;
    public final FlexibleTextView cuy;
    public final FlexibleTextView cuz;

    static {
        cpH.put(R.id.cl_toolbar, 1);
        cpH.put(R.id.cl_toolbar_full, 2);
        cpH.put(R.id.aciv_logo, 3);
        cpH.put(R.id.iv_profile, 4);
        cpH.put(R.id.ivDevice, 5);
        cpH.put(R.id.ftvPair, 6);
        cpH.put(R.id.acivLowBattery, 7);
        cpH.put(R.id.cl_toolbar_explore, 8);
        cpH.put(R.id.iv_toolbar_left, 9);
        cpH.put(R.id.ll_bottom_bar, 10);
        cpH.put(R.id.ll_home, 11);
        cpH.put(R.id.aciv_home, 12);
        cpH.put(R.id.ftv_home, 13);
        cpH.put(R.id.ll_device, 14);
        cpH.put(R.id.aciv_device, 15);
        cpH.put(R.id.ftv_device, 16);
        cpH.put(R.id.ll_notifications, 17);
        cpH.put(R.id.aciv_notifications, 18);
        cpH.put(R.id.ftv_notifications, 19);
        cpH.put(R.id.ll_stats, 20);
        cpH.put(R.id.aciv_stats, 21);
        cpH.put(R.id.ftv_stats, 22);
        cpH.put(R.id.rv_tabs, 23);
        cpH.put(R.id.pb_tooltip, 24);
    }

    public clh(C2160d c2160d, View view) {
        super(c2160d, view, 0);
        Object[] a = C2161i.m6993a(c2160d, view, 25, cpG, cpH);
        m7002c(ckm.class);
        this.cqm = (AppCompatImageView) a[15];
        this.cur = (AppCompatImageView) a[12];
        this.cus = (AppCompatImageView) a[3];
        this.cut = (AppCompatImageView) a[7];
        this.cuu = (AppCompatImageView) a[18];
        this.cuv = (AppCompatImageView) a[21];
        this.cqd = (ConstraintLayout) a[1];
        this.cuw = (RelativeLayout) a[8];
        this.cux = (ConstraintLayout) a[2];
        this.cra = (FlexibleTextView) a[16];
        this.cuy = (FlexibleTextView) a[13];
        this.cuz = (FlexibleTextView) a[19];
        this.cuA = (FlexibleButton) a[6];
        this.cuB = (FlexibleTextView) a[22];
        this.cuC = (ImageView) a[5];
        this.cuD = (FossilCircleImageView) a[4];
        this.cuE = (ImageView) a[9];
        this.cuF = (LinearLayout) a[10];
        this.cuG = (LinearLayout) a[14];
        this.cuH = (LinearLayout) a[11];
        this.cuI = (LinearLayout) a[17];
        this.cuJ = (LinearLayout) a[20];
        this.cqf = (ConstraintLayout) a[0];
        this.cqf.setTag(null);
        this.cuK = (ProgressBar) a[24];
        this.cuL = (RecyclerViewPager) a[23];
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

    public static clh m7026t(View view, C2160d c2160d) {
        if ("layout/main_fragment_0".equals(view.getTag())) {
            return new clh(c2160d, view);
        }
        throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
    }
}
