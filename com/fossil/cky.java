package com.fossil;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.fossil.C2161i.C3687b;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.view.FlexibleButton;
import com.portfolio.platform.view.FlexibleTextView;
import com.portfolio.platform.view.FossilCircleImageView;

public class cky extends C2161i {
    private static final C3687b cpG = null;
    private static final SparseIntArray cpH = new SparseIntArray();
    private long cpL = -1;
    public final LinearLayout crg;
    public final RelativeLayout crh;
    public final FlexibleButton cri;
    public final FossilCircleImageView crj;
    public final FlexibleTextView crk;
    public final FlexibleTextView crl;
    public final FlexibleTextView crm;
    public final FlexibleTextView crn;
    public final FlexibleTextView cro;
    public final FlexibleTextView crp;
    public final FlexibleTextView crq;
    public final FlexibleTextView crr;
    public final ImageView crs;
    private final RelativeLayout crt;
    public final LinearLayout cru;

    static {
        cpH.put(R.id.customToolbar, 1);
        cpH.put(R.id.left_button, 2);
        cpH.put(R.id.fcivOpponentAvatar, 3);
        cpH.put(R.id.ftv_challenge_title, 4);
        cpH.put(R.id.bottomView, 5);
        cpH.put(R.id.ftv_challenge_desc, 6);
        cpH.put(R.id.ftv_challenge_content, 7);
        cpH.put(R.id.ftv_bc_detail_0, 8);
        cpH.put(R.id.ftv_bc_detail_1, 9);
        cpH.put(R.id.ftv_bc_detail_2, 10);
        cpH.put(R.id.ftv_bc_detail_3, 11);
        cpH.put(R.id.rl_bc_detail_4, 12);
        cpH.put(R.id.ftv_bc_detail_4, 13);
        cpH.put(R.id.fbtn_find, 14);
    }

    public cky(C2160d c2160d, View view) {
        super(c2160d, view, 0);
        Object[] a = C2161i.m6993a(c2160d, view, 15, cpG, cpH);
        this.crg = (LinearLayout) a[5];
        this.crh = (RelativeLayout) a[1];
        this.cri = (FlexibleButton) a[14];
        this.crj = (FossilCircleImageView) a[3];
        this.crk = (FlexibleTextView) a[8];
        this.crl = (FlexibleTextView) a[9];
        this.crm = (FlexibleTextView) a[10];
        this.crn = (FlexibleTextView) a[11];
        this.cro = (FlexibleTextView) a[13];
        this.crp = (FlexibleTextView) a[7];
        this.crq = (FlexibleTextView) a[6];
        this.crr = (FlexibleTextView) a[4];
        this.crs = (ImageView) a[2];
        this.crt = (RelativeLayout) a[0];
        this.crt.setTag(null);
        this.cru = (LinearLayout) a[12];
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

    public static cky m7014k(View view, C2160d c2160d) {
        if ("layout/fragment_bc_find_opponent_0".equals(view.getTag())) {
            return new cky(c2160d, view);
        }
        throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
    }
}
