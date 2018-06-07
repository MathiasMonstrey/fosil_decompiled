package com.fossil;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.fossil.C2161i.C3687b;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.view.FlexibleTextView;

public class clg extends C2161i {
    private static final C3687b cpG = null;
    private static final SparseIntArray cpH = new SparseIntArray();
    private long cpL = -1;
    private final ConstraintLayout cqf;
    public final RecyclerView ctY;
    public final FlexibleTextView ctZ;
    public final FlexibleTextView cua;
    public final FlexibleTextView cub;
    public final FlexibleTextView cuc;
    public final FlexibleTextView cud;
    public final FlexibleTextView cue;
    public final FlexibleTextView cuf;
    public final FlexibleTextView cug;
    public final FlexibleTextView cuh;
    public final FlexibleTextView cui;
    public final LinearLayout cuj;
    public final RelativeLayout cuk;
    public final LinearLayout cul;
    public final LinearLayout cum;
    public final LinearLayout cun;
    public final LinearLayout cuo;
    public final LinearLayout cup;
    public final LinearLayout cuq;

    static {
        cpH.put(R.id.ftv_my_challenge, 1);
        cpH.put(R.id.rv_my_challenge_list, 2);
        cpH.put(R.id.my_challenge_empty, 3);
        cpH.put(R.id.my_buddy_challenge_empty_title, 4);
        cpH.put(R.id.my_buddy_challenge_empty_content, 5);
        cpH.put(R.id.challengeViewList, 6);
        cpH.put(R.id.ftv_new_challenge, 7);
        cpH.put(R.id.start_challenge_one, 8);
        cpH.put(R.id.ftv_challenge_plugin_one, 9);
        cpH.put(R.id.start_challenge_three, 10);
        cpH.put(R.id.ftv_challenge_plugin_three, 11);
        cpH.put(R.id.start_challenge_five, 12);
        cpH.put(R.id.ftv_challenge_plugin_five, 13);
        cpH.put(R.id.start_challenge_one_debug, 14);
        cpH.put(R.id.ftv_challenge_plugin_one_debug, 15);
        cpH.put(R.id.start_challenge_three_debug, 16);
        cpH.put(R.id.ftv_challenge_plugin_three_debug, 17);
        cpH.put(R.id.start_challenge_five_debug, 18);
        cpH.put(R.id.ftv_challenge_plugin_five_debug, 19);
    }

    public clg(C2160d c2160d, View view) {
        super(c2160d, view, 0);
        Object[] a = C2161i.m6993a(c2160d, view, 20, cpG, cpH);
        this.ctY = (RecyclerView) a[6];
        this.ctZ = (FlexibleTextView) a[13];
        this.cua = (FlexibleTextView) a[19];
        this.cub = (FlexibleTextView) a[9];
        this.cuc = (FlexibleTextView) a[15];
        this.cud = (FlexibleTextView) a[11];
        this.cue = (FlexibleTextView) a[17];
        this.cuf = (FlexibleTextView) a[1];
        this.cug = (FlexibleTextView) a[7];
        this.cqf = (ConstraintLayout) a[0];
        this.cqf.setTag(null);
        this.cuh = (FlexibleTextView) a[5];
        this.cui = (FlexibleTextView) a[4];
        this.cuj = (LinearLayout) a[3];
        this.cuk = (RelativeLayout) a[2];
        this.cul = (LinearLayout) a[12];
        this.cum = (LinearLayout) a[18];
        this.cun = (LinearLayout) a[8];
        this.cuo = (LinearLayout) a[14];
        this.cup = (LinearLayout) a[10];
        this.cuq = (LinearLayout) a[16];
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

    public static clg m7025s(View view, C2160d c2160d) {
        if ("layout/fragment_stats_buddy_challenge_0".equals(view.getTag())) {
            return new clg(c2160d, view);
        }
        throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
    }
}
