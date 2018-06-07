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

public class clf extends C2161i {
    private static final C3687b cpG = null;
    private static final SparseIntArray cpH = new SparseIntArray();
    private long cpL = -1;
    private final RelativeLayout crt;
    public final ImageView ctE;
    public final AppCompatImageView ctF;
    public final AppCompatImageView ctG;
    public final AppCompatImageView ctH;
    public final AppCompatImageView ctI;
    public final AppCompatImageView ctJ;
    public final AppCompatImageView ctK;
    public final RelativeLayout ctL;
    public final ConstraintLayout ctM;
    public final FlexibleTextView ctN;
    public final FlexibleTextView ctO;
    public final FlexibleTextView ctP;
    public final FlexibleTextView ctQ;
    public final FlexibleTextView ctR;
    public final FlexibleTextView ctS;
    public final FlexibleTextView ctT;
    public final FlexibleTextView ctU;
    public final FlexibleTextView ctV;
    public final ConstraintLayout ctW;
    public final ConstraintLayout ctX;

    static {
        cpH.put(R.id.cl_toolbar, 1);
        cpH.put(R.id.aciv_back, 2);
        cpH.put(R.id.height_container, 3);
        cpH.put(R.id.ftvHeight, 4);
        cpH.put(R.id.ftvHeightFt, 5);
        cpH.put(R.id.aciv_height_ft, 6);
        cpH.put(R.id.ftvHeightCm, 7);
        cpH.put(R.id.aciv_height_cm, 8);
        cpH.put(R.id.weight_container, 9);
        cpH.put(R.id.ftvWeight, 10);
        cpH.put(R.id.ftvWeightLbs, 11);
        cpH.put(R.id.aciv_weight_lbs, 12);
        cpH.put(R.id.ftvWeightKg, 13);
        cpH.put(R.id.aciv_weight_kg, 14);
        cpH.put(R.id.distance_container, 15);
        cpH.put(R.id.ftvDistance, 16);
        cpH.put(R.id.ftvDistanceMi, 17);
        cpH.put(R.id.aciv_distance_mi, 18);
        cpH.put(R.id.ftvDistanceKm, 19);
        cpH.put(R.id.aciv_distance_km, 20);
    }

    public clf(C2160d c2160d, View view) {
        super(c2160d, view, 0);
        Object[] a = C2161i.m6993a(c2160d, view, 21, cpG, cpH);
        this.ctE = (ImageView) a[2];
        this.ctF = (AppCompatImageView) a[20];
        this.ctG = (AppCompatImageView) a[18];
        this.ctH = (AppCompatImageView) a[8];
        this.ctI = (AppCompatImageView) a[6];
        this.ctJ = (AppCompatImageView) a[14];
        this.ctK = (AppCompatImageView) a[12];
        this.ctL = (RelativeLayout) a[1];
        this.ctM = (ConstraintLayout) a[15];
        this.ctN = (FlexibleTextView) a[16];
        this.ctO = (FlexibleTextView) a[19];
        this.ctP = (FlexibleTextView) a[17];
        this.ctQ = (FlexibleTextView) a[4];
        this.ctR = (FlexibleTextView) a[7];
        this.ctS = (FlexibleTextView) a[5];
        this.ctT = (FlexibleTextView) a[10];
        this.ctU = (FlexibleTextView) a[13];
        this.ctV = (FlexibleTextView) a[11];
        this.ctW = (ConstraintLayout) a[3];
        this.crt = (RelativeLayout) a[0];
        this.crt.setTag(null);
        this.ctX = (ConstraintLayout) a[9];
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

    public static clf m7024r(View view, C2160d c2160d) {
        if ("layout/fragment_profile_unit_0".equals(view.getTag())) {
            return new clf(c2160d, view);
        }
        throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
    }
}
