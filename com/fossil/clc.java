package com.fossil;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.FossilSwipeRefreshLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.AppCompatImageView;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import com.fossil.C2161i.C3687b;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.view.FlexibleTextView;

public class clc extends C2161i {
    private static final C3687b cpG = null;
    private static final SparseIntArray cpH = new SparseIntArray();
    private long cpL = -1;
    public final AppBarLayout csK;
    public final AppCompatImageView csL;
    public final AppCompatImageView csM;
    public final AppCompatImageView csN;
    public final AppCompatImageView csO;
    public final AppCompatImageView csP;
    public final AppCompatImageView csQ;
    public final AppCompatImageView csR;
    public final AppCompatImageView csS;
    public final AppCompatImageView csT;
    public final AppCompatImageView csU;
    public final AppCompatImageView csV;
    public final AppCompatImageView csW;
    public final CollapsingToolbarLayout csX;
    public final FlexibleTextView csY;
    public final FlexibleTextView csZ;
    public final FlexibleTextView cta;
    public final FlexibleTextView ctb;
    public final FlexibleTextView ctc;
    public final FlexibleTextView ctd;
    public final FlexibleTextView cte;
    public final FlexibleTextView ctf;
    public final FlexibleTextView ctg;
    public final FlexibleTextView cth;
    public final FlexibleTextView cti;
    public final FlexibleTextView ctj;
    public final FlexibleTextView ctk;
    public final FrameLayout ctl;
    public final AppCompatImageView ctm;
    public final CoordinatorLayout ctn;
    public final NestedScrollView cto;
    public final FossilSwipeRefreshLayout ctp;

    static {
        cpH.put(R.id.main_container, 2);
        cpH.put(R.id.contact_apps_button, 3);
        cpH.put(R.id.ncvNotifications, 4);
        cpH.put(R.id.aciv_1, 5);
        cpH.put(R.id.ftv_1, 6);
        cpH.put(R.id.aciv_2, 7);
        cpH.put(R.id.ftv_2, 8);
        cpH.put(R.id.aciv_3, 9);
        cpH.put(R.id.ftv_3, 10);
        cpH.put(R.id.aciv_4, 11);
        cpH.put(R.id.ftv_4, 12);
        cpH.put(R.id.aciv_5, 13);
        cpH.put(R.id.ftv_5, 14);
        cpH.put(R.id.aciv_6, 15);
        cpH.put(R.id.ftv_6, 16);
        cpH.put(R.id.aciv_7, 17);
        cpH.put(R.id.ftv_7, 18);
        cpH.put(R.id.aciv_8, 19);
        cpH.put(R.id.ftv_8, 20);
        cpH.put(R.id.aciv_9, 21);
        cpH.put(R.id.ftv_9, 22);
        cpH.put(R.id.aciv_10, 23);
        cpH.put(R.id.ftv_10, 24);
        cpH.put(R.id.aciv_11, 25);
        cpH.put(R.id.ftv_11, 26);
        cpH.put(R.id.aciv_12, 27);
        cpH.put(R.id.ftv_12, 28);
        cpH.put(R.id.abl, 29);
        cpH.put(R.id.collapsing_toolbar, 30);
        cpH.put(R.id.hand_picker, 31);
    }

    public clc(C2160d c2160d, View view) {
        super(c2160d, view, 0);
        Object[] a = C2161i.m6993a(c2160d, view, 32, cpG, cpH);
        m7002c(ckm.class);
        this.csK = (AppBarLayout) a[29];
        this.csL = (AppCompatImageView) a[5];
        this.csM = (AppCompatImageView) a[23];
        this.csN = (AppCompatImageView) a[25];
        this.csO = (AppCompatImageView) a[27];
        this.csP = (AppCompatImageView) a[7];
        this.csQ = (AppCompatImageView) a[9];
        this.csR = (AppCompatImageView) a[11];
        this.csS = (AppCompatImageView) a[13];
        this.csT = (AppCompatImageView) a[15];
        this.csU = (AppCompatImageView) a[17];
        this.csV = (AppCompatImageView) a[19];
        this.csW = (AppCompatImageView) a[21];
        this.csX = (CollapsingToolbarLayout) a[30];
        this.csY = (FlexibleTextView) a[3];
        this.csZ = (FlexibleTextView) a[6];
        this.cta = (FlexibleTextView) a[24];
        this.ctb = (FlexibleTextView) a[26];
        this.ctc = (FlexibleTextView) a[28];
        this.ctd = (FlexibleTextView) a[8];
        this.cte = (FlexibleTextView) a[10];
        this.ctf = (FlexibleTextView) a[12];
        this.ctg = (FlexibleTextView) a[14];
        this.cth = (FlexibleTextView) a[16];
        this.cti = (FlexibleTextView) a[18];
        this.ctj = (FlexibleTextView) a[20];
        this.ctk = (FlexibleTextView) a[22];
        this.ctl = (FrameLayout) a[31];
        this.ctm = (AppCompatImageView) a[1];
        this.ctm.setTag(null);
        this.ctn = (CoordinatorLayout) a[2];
        this.cto = (NestedScrollView) a[4];
        this.ctp = (FossilSwipeRefreshLayout) a[0];
        this.ctp.setTag(null);
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
            this.oA.du().m6988F(this.ctm, R.drawable.img_notifications_landing);
        }
    }

    public static clc m7021o(View view, C2160d c2160d) {
        if ("layout/fragment_notifications_0".equals(view.getTag())) {
            return new clc(c2160d, view);
        }
        throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
    }
}
