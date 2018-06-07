package com.fossil;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.Guideline;
import android.support.v7.widget.AppCompatImageView;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import com.fossil.C2161i.C3687b;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.view.FlexibleTextView;

public class ckv extends C2161i {
    private static final C3687b cpG = null;
    private static final SparseIntArray cpH = new SparseIntArray();
    private long cpL = -1;
    public final FlexibleTextView cpq;
    public final ConstraintLayout cqA;
    public final ConstraintLayout cqB;
    public final FlexibleTextView cqC;
    public final FrameLayout cqD;
    public final FlexibleTextView cqE;
    public final FlexibleTextView cqF;
    public final FlexibleTextView cqG;
    public final FlexibleTextView cqH;
    public final FlexibleTextView cqI;
    public final FlexibleTextView cqJ;
    public final FlexibleTextView cqK;
    public final FlexibleTextView cqL;
    public final FlexibleTextView cqM;
    public final FlexibleTextView cqN;
    public final FlexibleTextView cqO;
    public final FlexibleTextView cqP;
    public final FlexibleTextView cqQ;
    public final FlexibleTextView cqR;
    public final Guideline cqS;
    public final AppCompatImageView cqT;
    private final ConstraintLayout cqU;
    public final RelativeLayout cqV;
    public final ScrollView cqW;
    public final AppCompatImageView cqc;
    public final ConstraintLayout cqd;
    private final ConstraintLayout cqf;
    public final AppCompatImageView cqu;
    public final AppCompatImageView cqv;
    public final AppCompatImageView cqw;
    public final AppCompatImageView cqx;
    public final AppCompatImageView cqy;
    public final AppCompatImageView cqz;

    static {
        cpH.put(R.id.cl_toolbar, 2);
        cpH.put(R.id.aciv_back, 3);
        cpH.put(R.id.scrollView, 4);
        cpH.put(R.id.guideline, 5);
        cpH.put(R.id.iv_device_avatar, 6);
        cpH.put(R.id.ftv_device_name, 7);
        cpH.put(R.id.aciv_sync, 8);
        cpH.put(R.id.ftv_sync_time, 9);
        cpH.put(R.id.ftv_battery, 10);
        cpH.put(R.id.aciv_battery, 11);
        cpH.put(R.id.ftv_connected, 12);
        cpH.put(R.id.rlReplaceBattery, 13);
        cpH.put(R.id.ftvReplaceBattery, 14);
        cpH.put(R.id.bottomView, 15);
        cpH.put(R.id.cl_device_feature, 16);
        cpH.put(R.id.aciv_alarm, 17);
        cpH.put(R.id.ftv_alarm, 18);
        cpH.put(R.id.aciv_find_device, 19);
        cpH.put(R.id.ftv_find_device, 20);
        cpH.put(R.id.aciv_calibration, 21);
        cpH.put(R.id.ftv_calibration, 22);
        cpH.put(R.id.aciv_vibration, 23);
        cpH.put(R.id.ftv_vibration, 24);
        cpH.put(R.id.ftv_serial_number_label, 25);
        cpH.put(R.id.ftv_serial_number, 26);
        cpH.put(R.id.ftv_firmware_label, 27);
        cpH.put(R.id.ftv_firmware, 28);
        cpH.put(R.id.ftv_battery_type_label, 29);
        cpH.put(R.id.ftv_battery_type, 30);
        cpH.put(R.id.fb_remove_device, 31);
        cpH.put(R.id.flListDevice, 32);
    }

    public ckv(C2160d c2160d, View view) {
        super(c2160d, view, 0);
        Object[] a = C2161i.m6993a(c2160d, view, 33, cpG, cpH);
        m7002c(ckm.class);
        this.cqu = (AppCompatImageView) a[17];
        this.cqc = (AppCompatImageView) a[3];
        this.cqv = (AppCompatImageView) a[11];
        this.cqw = (AppCompatImageView) a[21];
        this.cqx = (AppCompatImageView) a[19];
        this.cqy = (AppCompatImageView) a[8];
        this.cqz = (AppCompatImageView) a[23];
        this.cqA = (ConstraintLayout) a[15];
        this.cqB = (ConstraintLayout) a[16];
        this.cqd = (ConstraintLayout) a[2];
        this.cqC = (FlexibleTextView) a[31];
        this.cqD = (FrameLayout) a[32];
        this.cqE = (FlexibleTextView) a[18];
        this.cqF = (FlexibleTextView) a[10];
        this.cqG = (FlexibleTextView) a[30];
        this.cqH = (FlexibleTextView) a[29];
        this.cqI = (FlexibleTextView) a[22];
        this.cqJ = (FlexibleTextView) a[12];
        this.cpq = (FlexibleTextView) a[7];
        this.cqK = (FlexibleTextView) a[20];
        this.cqL = (FlexibleTextView) a[28];
        this.cqM = (FlexibleTextView) a[27];
        this.cqN = (FlexibleTextView) a[14];
        this.cqO = (FlexibleTextView) a[26];
        this.cqP = (FlexibleTextView) a[25];
        this.cqQ = (FlexibleTextView) a[9];
        this.cqR = (FlexibleTextView) a[24];
        this.cqS = (Guideline) a[5];
        this.cqT = (AppCompatImageView) a[6];
        this.cqf = (ConstraintLayout) a[0];
        this.cqf.setTag(null);
        this.cqU = (ConstraintLayout) a[1];
        this.cqU.setTag(null);
        this.cqV = (RelativeLayout) a[13];
        this.cqW = (ScrollView) a[4];
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
            this.oA.du().m6988F(this.cqU, R.drawable.fs_background);
        }
    }

    public static ckv m7011h(View view, C2160d c2160d) {
        if ("layout/device_fragment_0".equals(view.getTag())) {
            return new ckv(c2160d, view);
        }
        throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
    }
}
