package com.fossil;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import com.fossil.C2161i.C3687b;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.view.FlexibleButton;
import com.portfolio.platform.view.FlexibleTextView;
import com.portfolio.platform.view.UnderlinedTextView;

public class ckz extends C2161i {
    private static final C3687b cpG = new C3687b(27);
    private static final SparseIntArray cpH = new SparseIntArray();
    private long cpL = -1;
    public final RelativeLayout crA;
    public final FlexibleTextView crB;
    public final FlexibleTextView crC;
    public final LinearLayout crD;
    public final cls crE;
    public final clt crF;
    public final clu crG;
    private final ScrollView crH;
    public final LinearLayout crI;
    public final RelativeLayout crJ;
    public final ImageView crK;
    public final LinearLayout crL;
    public final UnderlinedTextView crM;
    public final RelativeLayout crh;
    public final FlexibleTextView crk;
    public final FlexibleTextView crl;
    public final FlexibleTextView crm;
    public final FlexibleTextView crn;
    public final FlexibleTextView cro;
    public final FlexibleTextView crp;
    public final FlexibleTextView crr;
    public final LinearLayout cru;
    public final RelativeLayout crv;
    public final FlexibleButton crw;
    public final FlexibleButton crx;
    public final FlexibleButton cry;
    public final LinearLayout crz;

    static {
        cpG.m11713a(1, new String[]{"view_bc_main_one_day_progress", "view_bc_main_multiple_day_progress", "view_bc_main_invitation"}, new int[]{2, 3, 4}, new int[]{R.layout.view_bc_main_one_day_progress, R.layout.view_bc_main_multiple_day_progress, R.layout.view_bc_main_invitation});
        cpH.put(R.id.customToolbar, 5);
        cpH.put(R.id.right_button, 6);
        cpH.put(R.id.bottomView, 7);
        cpH.put(R.id.info_section, 8);
        cpH.put(R.id.ftv_challenge_title, 9);
        cpH.put(R.id.ftv_challenge_status, 10);
        cpH.put(R.id.rule_section, 11);
        cpH.put(R.id.ftv_challenge_content, 12);
        cpH.put(R.id.flexibleTextView, 13);
        cpH.put(R.id.ftv_bc_detail_0, 14);
        cpH.put(R.id.ftv_bc_detail_1, 15);
        cpH.put(R.id.ftv_bc_detail_2, 16);
        cpH.put(R.id.ftv_bc_detail_3, 17);
        cpH.put(R.id.rl_bc_detail_4, 18);
        cpH.put(R.id.ftv_bc_detail_4, 19);
        cpH.put(R.id.btn_groups, 20);
        cpH.put(R.id.receive_challenge_group, 21);
        cpH.put(R.id.btn_group, 22);
        cpH.put(R.id.btn_decline, 23);
        cpH.put(R.id.btn_accept, 24);
        cpH.put(R.id.utvTryDifferent, 25);
        cpH.put(R.id.btn_action, 26);
    }

    public ckz(C2160d c2160d, View view) {
        super(c2160d, view, 3);
        Object[] a = C2161i.m6993a(c2160d, view, 27, cpG, cpH);
        this.crv = (RelativeLayout) a[7];
        this.crw = (FlexibleButton) a[24];
        this.crx = (FlexibleButton) a[26];
        this.cry = (FlexibleButton) a[23];
        this.crz = (LinearLayout) a[22];
        this.crA = (RelativeLayout) a[20];
        this.crh = (RelativeLayout) a[5];
        this.crB = (FlexibleTextView) a[13];
        this.crk = (FlexibleTextView) a[14];
        this.crl = (FlexibleTextView) a[15];
        this.crm = (FlexibleTextView) a[16];
        this.crn = (FlexibleTextView) a[17];
        this.cro = (FlexibleTextView) a[19];
        this.crp = (FlexibleTextView) a[12];
        this.crC = (FlexibleTextView) a[10];
        this.crr = (FlexibleTextView) a[9];
        this.crD = (LinearLayout) a[8];
        this.crE = (cls) a[4];
        m7003e(this.crE);
        this.crF = (clt) a[3];
        m7003e(this.crF);
        this.crG = (clu) a[2];
        m7003e(this.crG);
        this.crH = (ScrollView) a[0];
        this.crH.setTag(null);
        this.crI = (LinearLayout) a[1];
        this.crI.setTag(null);
        this.crJ = (RelativeLayout) a[21];
        this.crK = (ImageView) a[6];
        this.cru = (LinearLayout) a[18];
        this.crL = (LinearLayout) a[11];
        this.crM = (UnderlinedTextView) a[25];
        m7001a(view);
        abv();
    }

    public void abv() {
        synchronized (this) {
            this.cpL = 8;
        }
        this.crG.abv();
        this.crF.abv();
        this.crE.abv();
        dA();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dy() {
        /*
        r6 = this;
        r0 = 1;
        monitor-enter(r6);
        r2 = r6.cpL;	 Catch:{ all -> 0x0027 }
        r4 = 0;
        r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r1 == 0) goto L_0x000c;
    L_0x000a:
        monitor-exit(r6);	 Catch:{ all -> 0x0027 }
    L_0x000b:
        return r0;
    L_0x000c:
        monitor-exit(r6);	 Catch:{ all -> 0x0027 }
        r1 = r6.crG;
        r1 = r1.dy();
        if (r1 != 0) goto L_0x000b;
    L_0x0015:
        r1 = r6.crF;
        r1 = r1.dy();
        if (r1 != 0) goto L_0x000b;
    L_0x001d:
        r1 = r6.crE;
        r1 = r1.dy();
        if (r1 != 0) goto L_0x000b;
    L_0x0025:
        r0 = 0;
        goto L_0x000b;
    L_0x0027:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0027 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.ckz.dy():boolean");
    }

    protected void dx() {
        synchronized (this) {
            long j = this.cpL;
            this.cpL = 0;
        }
        C2161i.m6998d(this.crG);
        C2161i.m6998d(this.crF);
        C2161i.m6998d(this.crE);
    }

    public static ckz m7015l(View view, C2160d c2160d) {
        if ("layout/fragment_bc_main_0".equals(view.getTag())) {
            return new ckz(c2160d, view);
        }
        throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
    }
}
