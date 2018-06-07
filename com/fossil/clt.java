package com.fossil;

import android.support.constraint.ConstraintLayout;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import com.fossil.C2161i.C3687b;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.view.FlexibleTextView;
import com.portfolio.platform.view.FossilCircleImageView;

public class clt extends C2161i {
    private static final C3687b cpG = null;
    private static final SparseIntArray cpH = new SparseIntArray();
    private long cpL = -1;
    private final ConstraintLayout cqf;
    public final FlexibleTextView cwa;
    public final FlexibleTextView cwb;
    public final FossilCircleImageView cwc;
    public final LinearLayout cwd;
    public final FlexibleTextView cwe;
    public final FlexibleTextView cwf;
    public final FossilCircleImageView cwg;
    public final LinearLayout cwh;
    public final FlexibleTextView cwi;
    public final FlexibleTextView cwj;
    public final FlexibleTextView cwk;

    static {
        cpH.put(R.id.user_info_container, 1);
        cpH.put(R.id.user_avatar_multiple_day, 2);
        cpH.put(R.id.user_name_multiple_day, 3);
        cpH.put(R.id.ftv_versus, 4);
        cpH.put(R.id.opponent_info_container, 5);
        cpH.put(R.id.opponent_avatar_multiple_day, 6);
        cpH.put(R.id.name_opponent_multiple_day, 7);
        cpH.put(R.id.user_score, 8);
        cpH.put(R.id.user_steps_multiple_day, 9);
        cpH.put(R.id.opponent_score, 10);
        cpH.put(R.id.opponent_steps_multiple_day, 11);
    }

    public clt(C2160d c2160d, View view) {
        super(c2160d, view, 0);
        Object[] a = C2161i.m6993a(c2160d, view, 12, cpG, cpH);
        this.cwa = (FlexibleTextView) a[4];
        this.cqf = (ConstraintLayout) a[0];
        this.cqf.setTag(null);
        this.cwb = (FlexibleTextView) a[7];
        this.cwc = (FossilCircleImageView) a[6];
        this.cwd = (LinearLayout) a[5];
        this.cwe = (FlexibleTextView) a[10];
        this.cwf = (FlexibleTextView) a[11];
        this.cwg = (FossilCircleImageView) a[2];
        this.cwh = (LinearLayout) a[1];
        this.cwi = (FlexibleTextView) a[3];
        this.cwj = (FlexibleTextView) a[8];
        this.cwk = (FlexibleTextView) a[9];
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

    public static clt m7038F(View view, C2160d c2160d) {
        if ("layout/view_bc_main_multiple_day_progress_0".equals(view.getTag())) {
            return new clt(c2160d, view);
        }
        throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
    }
}
