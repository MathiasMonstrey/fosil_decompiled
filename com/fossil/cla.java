package com.fossil;

import android.support.constraint.ConstraintLayout;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fossil.C2161i.C3687b;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.ui.widget.FossilTopHeaderLayout;
import com.portfolio.platform.view.ClockView;
import com.portfolio.platform.view.EditTextCustom;
import com.portfolio.platform.view.FlexibleTextView;

public class cla extends C2161i {
    private static final C3687b cpG = null;
    private static final SparseIntArray cpH = new SparseIntArray();
    private long cpL = -1;
    public final FlexibleTextView crN;
    public final AppBarLayout crO;
    public final ImageView crP;
    public final TextView crQ;
    public final RelativeLayout crR;
    public final FlexibleTextView crS;
    public final FlexibleTextView crT;
    public final ImageView crU;
    public final ImageView crV;
    public final RelativeLayout crW;
    public final ClockView crX;
    public final ImageView crY;
    public final FossilTopHeaderLayout crZ;
    public final ConstraintLayout csa;
    public final FlexibleTextView csb;
    public final ConstraintLayout csc;
    public final RelativeLayout csd;
    public final RecyclerView cse;
    public final RecyclerView csf;
    public final AppCompatImageView csg;
    public final ImageView csh;
    public final RelativeLayout csi;
    public final ConstraintLayout csj;
    public final TextView csk;
    public final ImageView csl;
    public final FlexibleTextView csm;
    public final FlexibleTextView csn;
    public final RecyclerView cso;
    public final FlexibleTextView csp;
    public final RelativeLayout csq;
    public final RelativeLayout csr;
    public final FlexibleTextView css;
    public final RelativeLayout cst;
    public final EditTextCustom csu;
    public final ConstraintLayout csv;
    public final FlexibleTextView csw;
    public final ImageView csx;
    public final ImageView csy;

    static {
        cpH.put(R.id.iv_background, 1);
        cpH.put(R.id.customToolbar, 2);
        cpH.put(R.id.cancel, 3);
        cpH.put(R.id.save_text, 4);
        cpH.put(R.id.appbar, 5);
        cpH.put(R.id.collapsing_toolbar, 6);
        cpH.put(R.id.main_container, 7);
        cpH.put(R.id.clock_container, 8);
        cpH.put(R.id.clock_view, 9);
        cpH.put(R.id.horizontal_animation, 10);
        cpH.put(R.id.contact_container, 11);
        cpH.put(R.id.plus_icon, 12);
        cpH.put(R.id.plus_name, 13);
        cpH.put(R.id.arrow_start, 14);
        cpH.put(R.id.horizontal_list, 15);
        cpH.put(R.id.assign_message_layout, 16);
        cpH.put(R.id.close_picker, 17);
        cpH.put(R.id.assign_message, 18);
        cpH.put(R.id.search_container, 19);
        cpH.put(R.id.tab_header, 20);
        cpH.put(R.id.contact_text, 21);
        cpH.put(R.id.app_text, 22);
        cpH.put(R.id.rl_container_search_view, 23);
        cpH.put(R.id.search_view, 24);
        cpH.put(R.id.iv_close, 25);
        cpH.put(R.id.recycler_view, 26);
        cpH.put(R.id.detail_layout, 27);
        cpH.put(R.id.noti_fuction, 28);
        cpH.put(R.id.user_call_in_detail, 29);
        cpH.put(R.id.check_mark_call, 30);
        cpH.put(R.id.call_detail_des, 31);
        cpH.put(R.id.use_text_in_detail, 32);
        cpH.put(R.id.check_mark_text, 33);
        cpH.put(R.id.text_detail_des, 34);
        cpH.put(R.id.remove_in_detail_layout, 35);
        cpH.put(R.id.reassign_in_detail_layout, 36);
        cpH.put(R.id.plus_des, 37);
    }

    public cla(C2160d c2160d, View view) {
        super(c2160d, view, 0);
        Object[] a = C2161i.m6993a(c2160d, view, 38, cpG, cpH);
        this.crN = (FlexibleTextView) a[22];
        this.crO = (AppBarLayout) a[5];
        this.crP = (ImageView) a[14];
        this.crQ = (TextView) a[18];
        this.crR = (RelativeLayout) a[16];
        this.crS = (FlexibleTextView) a[31];
        this.crT = (FlexibleTextView) a[3];
        this.crU = (ImageView) a[30];
        this.crV = (ImageView) a[33];
        this.crW = (RelativeLayout) a[8];
        this.crX = (ClockView) a[9];
        this.crY = (ImageView) a[17];
        this.crZ = (FossilTopHeaderLayout) a[6];
        this.csa = (ConstraintLayout) a[11];
        this.csb = (FlexibleTextView) a[21];
        this.csc = (ConstraintLayout) a[2];
        this.csd = (RelativeLayout) a[27];
        this.cse = (RecyclerView) a[10];
        this.csf = (RecyclerView) a[15];
        this.csg = (AppCompatImageView) a[1];
        this.csh = (ImageView) a[25];
        this.csi = (RelativeLayout) a[7];
        this.csj = (ConstraintLayout) a[28];
        this.csk = (TextView) a[37];
        this.csl = (ImageView) a[12];
        this.csm = (FlexibleTextView) a[13];
        this.csn = (FlexibleTextView) a[36];
        this.cso = (RecyclerView) a[26];
        this.csp = (FlexibleTextView) a[35];
        this.csq = (RelativeLayout) a[23];
        this.csr = (RelativeLayout) a[0];
        this.csr.setTag(null);
        this.css = (FlexibleTextView) a[4];
        this.cst = (RelativeLayout) a[19];
        this.csu = (EditTextCustom) a[24];
        this.csv = (ConstraintLayout) a[20];
        this.csw = (FlexibleTextView) a[34];
        this.csx = (ImageView) a[32];
        this.csy = (ImageView) a[29];
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

    public static cla m7019m(View view, C2160d c2160d) {
        if ("layout/fragment_contact_and_app_0".equals(view.getTag())) {
            return new cla(c2160d, view);
        }
        throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
    }
}
