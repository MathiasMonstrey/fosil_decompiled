package com.fossil;

import android.support.v7.view.menu.ListMenuItemView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.fossil.pk.C3988g;
import com.fossil.qr.C4019a;
import java.util.ArrayList;

public class qi extends BaseAdapter {
    static final int agm = C3988g.abc_popup_menu_item_layout;
    private final LayoutInflater Yg;
    private boolean afJ;
    private final boolean afv;
    private int agk = -1;
    qj agn;

    public /* synthetic */ Object getItem(int i) {
        return cw(i);
    }

    public qi(qj qjVar, LayoutInflater layoutInflater, boolean z) {
        this.afv = z;
        this.Yg = layoutInflater;
        this.agn = qjVar;
        mM();
    }

    public void setForceShowIcon(boolean z) {
        this.afJ = z;
    }

    public int getCount() {
        ArrayList mX = this.afv ? this.agn.mX() : this.agn.mU();
        if (this.agk < 0) {
            return mX.size();
        }
        return mX.size() - 1;
    }

    public qj mN() {
        return this.agn;
    }

    public ql cw(int i) {
        ArrayList mX = this.afv ? this.agn.mX() : this.agn.mU();
        if (this.agk >= 0 && i >= this.agk) {
            i++;
        }
        return (ql) mX.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate;
        if (view == null) {
            inflate = this.Yg.inflate(agm, viewGroup, false);
        } else {
            inflate = view;
        }
        C4019a c4019a = (C4019a) inflate;
        if (this.afJ) {
            ((ListMenuItemView) inflate).setForceShowIcon(true);
        }
        c4019a.m13206a(cw(i), 0);
        return inflate;
    }

    void mM() {
        ql nd = this.agn.nd();
        if (nd != null) {
            ArrayList mX = this.agn.mX();
            int size = mX.size();
            for (int i = 0; i < size; i++) {
                if (((ql) mX.get(i)) == nd) {
                    this.agk = i;
                    return;
                }
            }
        }
        this.agk = -1;
    }

    public void notifyDataSetChanged() {
        mM();
        super.notifyDataSetChanged();
    }
}
