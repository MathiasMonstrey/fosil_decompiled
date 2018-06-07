package com.fossil;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import com.fossil.C2161i.C3687b;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.view.FlexibleTextView;
import com.portfolio.platform.view.FossilCircleImageView;

public class cls extends C2161i {
    private static final C3687b cpG = null;
    private static final SparseIntArray cpH = new SparseIntArray();
    private long cpL = -1;
    private final LinearLayout cpN;
    public final FlexibleTextView cvV;
    public final FlexibleTextView cvW;
    public final FossilCircleImageView cvX;
    public final FossilCircleImageView cvY;
    public final FlexibleTextView cvZ;

    static {
        cpH.put(R.id.user_avatar_invitation, 1);
        cpH.put(R.id.user_name_invitation, 2);
        cpH.put(R.id.flexibleTextView2, 3);
        cpH.put(R.id.opponent_avatar_invitation, 4);
        cpH.put(R.id.name_opponent, 5);
    }

    public cls(C2160d c2160d, View view) {
        super(c2160d, view, 0);
        Object[] a = C2161i.m6993a(c2160d, view, 6, cpG, cpH);
        this.cvV = (FlexibleTextView) a[3];
        this.cpN = (LinearLayout) a[0];
        this.cpN.setTag(null);
        this.cvW = (FlexibleTextView) a[5];
        this.cvX = (FossilCircleImageView) a[4];
        this.cvY = (FossilCircleImageView) a[1];
        this.cvZ = (FlexibleTextView) a[2];
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

    public static cls m7037E(View view, C2160d c2160d) {
        if ("layout/view_bc_main_invitation_0".equals(view.getTag())) {
            return new cls(c2160d, view);
        }
        throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
    }
}
