package com.fossil;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.fossil.C2161i.C3687b;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.view.FlexibleButton;
import com.portfolio.platform.view.FlexibleEditText;
import com.portfolio.platform.view.FlexibleTextView;
import com.portfolio.platform.view.FossilCircleImageView;

public class clb extends C2161i {
    private static final C3687b cpG = null;
    private static final SparseIntArray cpH = new SparseIntArray();
    private long cpL = -1;
    private final ConstraintLayout cqf;
    public final RelativeLayout crh;
    public final ImageView crs;
    public final LinearLayout csA;
    public final FlexibleTextView csB;
    public final FlexibleButton csC;
    public final FlexibleEditText csD;
    public final FlexibleTextView csE;
    public final FlexibleTextView csF;
    public final FlexibleTextView csG;
    public final RecyclerView csH;
    public final FlexibleTextView csI;
    public final FossilCircleImageView csJ;
    public final ConstraintLayout csz;

    static {
        cpH.put(R.id.customToolbar, 1);
        cpH.put(R.id.left_button, 2);
        cpH.put(R.id.title, 3);
        cpH.put(R.id.content, 4);
        cpH.put(R.id.user_avatar, 5);
        cpH.put(R.id.ftvCreateAccountDesc, 6);
        cpH.put(R.id.content2, 7);
        cpH.put(R.id.fet_enter_name, 8);
        cpH.put(R.id.ftvAccountStatus, 9);
        cpH.put(R.id.cl_suggestion_group, 10);
        cpH.put(R.id.ftv_suggestions, 11);
        cpH.put(R.id.rvSuggestionAccounts, 12);
        cpH.put(R.id.fbtn_next, 13);
    }

    public clb(C2160d c2160d, View view) {
        super(c2160d, view, 0);
        Object[] a = C2161i.m6993a(c2160d, view, 14, cpG, cpH);
        this.csz = (ConstraintLayout) a[10];
        this.csA = (LinearLayout) a[4];
        this.csB = (FlexibleTextView) a[7];
        this.crh = (RelativeLayout) a[1];
        this.csC = (FlexibleButton) a[13];
        this.csD = (FlexibleEditText) a[8];
        this.csE = (FlexibleTextView) a[9];
        this.csF = (FlexibleTextView) a[6];
        this.csG = (FlexibleTextView) a[11];
        this.crs = (ImageView) a[2];
        this.cqf = (ConstraintLayout) a[0];
        this.cqf.setTag(null);
        this.csH = (RecyclerView) a[12];
        this.csI = (FlexibleTextView) a[3];
        this.csJ = (FossilCircleImageView) a[5];
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

    public static clb m7020n(View view, C2160d c2160d) {
        if ("layout/fragment_create_bc_account_0".equals(view.getTag())) {
            return new clb(c2160d, view);
        }
        throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
    }
}
