package com.fossil;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.view.menu.ExpandedMenuView;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.fossil.pk.C3988g;
import com.fossil.qq.C3962a;
import com.fossil.qr.C4019a;
import java.util.ArrayList;

public class qh implements OnItemClickListener, qq {
    LayoutInflater Yg;
    int afn;
    ExpandedMenuView agg;
    int agh;
    int agi;
    C4011a agj;
    Context mContext;
    private int mId;
    private C3962a uF;
    qj uh;

    class C4011a extends BaseAdapter {
        private int agk = -1;
        final /* synthetic */ qh agl;

        public /* synthetic */ Object getItem(int i) {
            return cw(i);
        }

        public C4011a(qh qhVar) {
            this.agl = qhVar;
            mM();
        }

        public int getCount() {
            int size = this.agl.uh.mX().size() - this.agl.agh;
            return this.agk < 0 ? size : size - 1;
        }

        public ql cw(int i) {
            ArrayList mX = this.agl.uh.mX();
            int i2 = this.agl.agh + i;
            if (this.agk >= 0 && i2 >= this.agk) {
                i2++;
            }
            return (ql) mX.get(i2);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View inflate;
            if (view == null) {
                inflate = this.agl.Yg.inflate(this.agl.afn, viewGroup, false);
            } else {
                inflate = view;
            }
            ((C4019a) inflate).m13206a(cw(i), 0);
            return inflate;
        }

        void mM() {
            ql nd = this.agl.uh.nd();
            if (nd != null) {
                ArrayList mX = this.agl.uh.mX();
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

    public qh(Context context, int i) {
        this(i, 0);
        this.mContext = context;
        this.Yg = LayoutInflater.from(this.mContext);
    }

    public qh(int i, int i2) {
        this.afn = i;
        this.agi = i2;
    }

    public void mo4018a(Context context, qj qjVar) {
        if (this.agi != 0) {
            this.mContext = new ContextThemeWrapper(context, this.agi);
            this.Yg = LayoutInflater.from(this.mContext);
        } else if (this.mContext != null) {
            this.mContext = context;
            if (this.Yg == null) {
                this.Yg = LayoutInflater.from(this.mContext);
            }
        }
        this.uh = qjVar;
        if (this.agj != null) {
            this.agj.notifyDataSetChanged();
        }
    }

    public qr m13160a(ViewGroup viewGroup) {
        if (this.agg == null) {
            this.agg = (ExpandedMenuView) this.Yg.inflate(C3988g.abc_expanded_menu_layout, viewGroup, false);
            if (this.agj == null) {
                this.agj = new C4011a(this);
            }
            this.agg.setAdapter(this.agj);
            this.agg.setOnItemClickListener(this);
        }
        return this.agg;
    }

    public ListAdapter getAdapter() {
        if (this.agj == null) {
            this.agj = new C4011a(this);
        }
        return this.agj;
    }

    public void mo4025g(boolean z) {
        if (this.agj != null) {
            this.agj.notifyDataSetChanged();
        }
    }

    public void mo4020a(C3962a c3962a) {
        this.uF = c3962a;
    }

    public boolean mo4022a(qw qwVar) {
        if (!qwVar.hasVisibleItems()) {
            return false;
        }
        new qk(qwVar).m13200e(null);
        if (this.uF != null) {
            this.uF.mo3995d(qwVar);
        }
        return true;
    }

    public void mo4019a(qj qjVar, boolean z) {
        if (this.uF != null) {
            this.uF.mo3994a(qjVar, z);
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.uh.m13181a(this.agj.cw(i), (qq) this, 0);
    }

    public boolean eW() {
        return false;
    }

    public boolean mo4021a(qj qjVar, ql qlVar) {
        return false;
    }

    public boolean mo4023b(qj qjVar, ql qlVar) {
        return false;
    }

    public void saveHierarchyState(Bundle bundle) {
        SparseArray sparseArray = new SparseArray();
        if (this.agg != null) {
            this.agg.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
    }

    public void restoreHierarchyState(Bundle bundle) {
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.agg.restoreHierarchyState(sparseParcelableArray);
        }
    }

    public int getId() {
        return this.mId;
    }

    public Parcelable onSaveInstanceState() {
        if (this.agg == null) {
            return null;
        }
        Parcelable bundle = new Bundle();
        saveHierarchyState(bundle);
        return bundle;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        restoreHierarchyState((Bundle) parcelable);
    }
}
