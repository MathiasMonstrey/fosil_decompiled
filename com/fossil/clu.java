package com.fossil;

import android.support.constraint.ConstraintLayout;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.fossil.C2161i.C3687b;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.view.FlexibleTextView;
import com.portfolio.platform.view.FossilCircleImageView;

public class clu extends C2161i {
    private static final C3687b cpG = null;
    private static final SparseIntArray cpH = new SparseIntArray();
    private long cpL = -1;
    private final LinearLayout cpN;
    public final FossilCircleImageView csJ;
    public final ImageView cwl;
    public final ImageView cwm;
    public final FossilCircleImageView cwn;
    public final ConstraintLayout cwo;
    public final FlexibleTextView cwp;
    public final ProgressBar cwq;
    public final FlexibleTextView cwr;
    public final ConstraintLayout cws;
    public final FlexibleTextView cwt;
    public final ProgressBar cwu;
    public final FlexibleTextView cwv;

    static {
        cpH.put(R.id.user_icon, 1);
        cpH.put(R.id.user_avatar, 2);
        cpH.put(R.id.ivUserCheckMark, 3);
        cpH.put(R.id.user_name, 4);
        cpH.put(R.id.user_progress, 5);
        cpH.put(R.id.user_step, 6);
        cpH.put(R.id.opponent_icon, 7);
        cpH.put(R.id.opponent_avatar, 8);
        cpH.put(R.id.ivOpponentCheckMark, 9);
        cpH.put(R.id.opponent_name, 10);
        cpH.put(R.id.opponent_progress, 11);
        cpH.put(R.id.opponent_step, 12);
    }

    public clu(C2160d c2160d, View view) {
        super(c2160d, view, 0);
        Object[] a = C2161i.m6993a(c2160d, view, 13, cpG, cpH);
        this.cwl = (ImageView) a[9];
        this.cwm = (ImageView) a[3];
        this.cpN = (LinearLayout) a[0];
        this.cpN.setTag(null);
        this.cwn = (FossilCircleImageView) a[8];
        this.cwo = (ConstraintLayout) a[7];
        this.cwp = (FlexibleTextView) a[10];
        this.cwq = (ProgressBar) a[11];
        this.cwr = (FlexibleTextView) a[12];
        this.csJ = (FossilCircleImageView) a[2];
        this.cws = (ConstraintLayout) a[1];
        this.cwt = (FlexibleTextView) a[4];
        this.cwu = (ProgressBar) a[5];
        this.cwv = (FlexibleTextView) a[6];
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

    public static clu m7039G(View view, C2160d c2160d) {
        if ("layout/view_bc_main_one_day_progress_0".equals(view.getTag())) {
            return new clu(c2160d, view);
        }
        throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
    }
}
