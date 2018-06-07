package com.fossil;

import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.support.v7.widget.RecyclerView.C1234a;
import android.support.v7.widget.RecyclerView.C1264v;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import com.fossil.dcs.C2670a;
import com.misfit.frameworks.common.log.MFLogger;

public abstract class dct<VH extends C1264v> extends C1234a<VH> implements Filterable, C2670a {
    private static final String TAG = dct.class.getSimpleName();
    private Cursor MC;
    private DataSetObserver VV;
    private FilterQueryProvider VX;
    private boolean cQp;
    private C2672a cQq;
    private dcs cQr;

    class C2672a extends ContentObserver {
        final /* synthetic */ dct cQs;

        C2672a(dct com_fossil_dct) {
            this.cQs = com_fossil_dct;
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z) {
            this.cQs.onContentChanged();
        }
    }

    class C2673b extends DataSetObserver {
        final /* synthetic */ dct cQs;

        private C2673b(dct com_fossil_dct) {
            this.cQs = com_fossil_dct;
        }

        public void onChanged() {
            this.cQs.cQp = true;
            this.cQs.notifyDataSetChanged();
        }

        public void onInvalidated() {
            this.cQs.cQp = false;
            this.cQs.ay(0, this.cQs.getItemCount());
        }
    }

    public abstract void mo2324a(VH vh, Cursor cursor, int i);

    dct(Cursor cursor) {
        m8316f(cursor);
    }

    private void m8316f(Cursor cursor) {
        boolean z = cursor != null;
        this.MC = cursor;
        this.cQp = z;
        this.cQq = new C2672a(this);
        this.VV = new C2673b();
        if (z) {
            if (this.cQq != null) {
                cursor.registerContentObserver(this.cQq);
            }
            if (this.VV != null) {
                cursor.registerDataSetObserver(this.VV);
            }
        }
    }

    public void mo1089a(VH vh, int i) {
        if (!this.cQp) {
            MFLogger.m12670d(TAG, ".Inside onBindViewHolder the cursor is valid");
        }
        mo2324a(vh, this.MC, i);
    }

    public int getItemCount() {
        if (!this.cQp || this.MC == null) {
            return 0;
        }
        return this.MC.getCount();
    }

    public Cursor getCursor() {
        return this.MC;
    }

    public void changeCursor(Cursor cursor) {
        Cursor swapCursor = swapCursor(cursor);
        if (swapCursor != null) {
            swapCursor.close();
        }
    }

    public Cursor swapCursor(Cursor cursor) {
        if (cursor == this.MC) {
            return null;
        }
        Cursor cursor2 = this.MC;
        if (cursor2 != null) {
            if (this.cQq != null) {
                cursor2.unregisterContentObserver(this.cQq);
            }
            if (this.VV != null) {
                cursor2.unregisterDataSetObserver(this.VV);
            }
        }
        this.MC = cursor;
        if (cursor != null) {
            if (this.cQq != null) {
                cursor.registerContentObserver(this.cQq);
            }
            if (this.VV != null) {
                cursor.registerDataSetObserver(this.VV);
            }
            this.cQp = true;
            notifyDataSetChanged();
            return cursor2;
        }
        this.cQp = false;
        ay(0, getItemCount());
        return cursor2;
    }

    public CharSequence convertToString(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        if (this.VX != null) {
            return this.VX.runQuery(charSequence);
        }
        return this.MC;
    }

    public Filter getFilter() {
        if (this.cQr == null) {
            this.cQr = new dcs(this);
        }
        return this.cQr;
    }

    public void setFilterQueryProvider(FilterQueryProvider filterQueryProvider) {
        this.VX = filterQueryProvider;
    }

    private void onContentChanged() {
        MFLogger.m12670d(TAG, ".Inside onContentChanged");
    }
}
