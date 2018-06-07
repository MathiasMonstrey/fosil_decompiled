package com.fossil;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import com.fossil.nl.C3919a;
import com.j256.ormlite.field.FieldType;

public abstract class nk extends BaseAdapter implements Filterable, C3919a {
    protected Cursor MC;
    protected boolean VR;
    protected boolean VS;
    protected int VT;
    protected C3917a VU;
    protected DataSetObserver VV;
    protected nl VW;
    protected FilterQueryProvider VX;
    protected Context mContext;

    class C3917a extends ContentObserver {
        final /* synthetic */ nk VY;

        C3917a(nk nkVar) {
            this.VY = nkVar;
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z) {
            this.VY.onContentChanged();
        }
    }

    class C3918b extends DataSetObserver {
        final /* synthetic */ nk VY;

        C3918b(nk nkVar) {
            this.VY = nkVar;
        }

        public void onChanged() {
            this.VY.VR = true;
            this.VY.notifyDataSetChanged();
        }

        public void onInvalidated() {
            this.VY.VR = false;
            this.VY.notifyDataSetInvalidated();
        }
    }

    public abstract void bindView(View view, Context context, Cursor cursor);

    public abstract View newView(Context context, Cursor cursor, ViewGroup viewGroup);

    public nk(Context context, Cursor cursor, boolean z) {
        m12769a(context, cursor, z ? 1 : 2);
    }

    void m12769a(Context context, Cursor cursor, int i) {
        boolean z = true;
        if ((i & 1) == 1) {
            i |= 2;
            this.VS = true;
        } else {
            this.VS = false;
        }
        if (cursor == null) {
            z = false;
        }
        this.MC = cursor;
        this.VR = z;
        this.mContext = context;
        this.VT = z ? cursor.getColumnIndexOrThrow(FieldType.FOREIGN_ID_FIELD_SUFFIX) : -1;
        if ((i & 2) == 2) {
            this.VU = new C3917a(this);
            this.VV = new C3918b(this);
        } else {
            this.VU = null;
            this.VV = null;
        }
        if (z) {
            if (this.VU != null) {
                cursor.registerContentObserver(this.VU);
            }
            if (this.VV != null) {
                cursor.registerDataSetObserver(this.VV);
            }
        }
    }

    public Cursor getCursor() {
        return this.MC;
    }

    public int getCount() {
        if (!this.VR || this.MC == null) {
            return 0;
        }
        return this.MC.getCount();
    }

    public Object getItem(int i) {
        if (!this.VR || this.MC == null) {
            return null;
        }
        this.MC.moveToPosition(i);
        return this.MC;
    }

    public long getItemId(int i) {
        if (this.VR && this.MC != null && this.MC.moveToPosition(i)) {
            return this.MC.getLong(this.VT);
        }
        return 0;
    }

    public boolean hasStableIds() {
        return true;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.VR) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.MC.moveToPosition(i)) {
            if (view == null) {
                view = newView(this.mContext, this.MC, viewGroup);
            }
            bindView(view, this.mContext, this.MC);
            return view;
        } else {
            throw new IllegalStateException("couldn't move cursor to position " + i);
        }
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.VR) {
            return null;
        }
        this.MC.moveToPosition(i);
        if (view == null) {
            view = newDropDownView(this.mContext, this.MC, viewGroup);
        }
        bindView(view, this.mContext, this.MC);
        return view;
    }

    public View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return newView(context, cursor, viewGroup);
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
            if (this.VU != null) {
                cursor2.unregisterContentObserver(this.VU);
            }
            if (this.VV != null) {
                cursor2.unregisterDataSetObserver(this.VV);
            }
        }
        this.MC = cursor;
        if (cursor != null) {
            if (this.VU != null) {
                cursor.registerContentObserver(this.VU);
            }
            if (this.VV != null) {
                cursor.registerDataSetObserver(this.VV);
            }
            this.VT = cursor.getColumnIndexOrThrow(FieldType.FOREIGN_ID_FIELD_SUFFIX);
            this.VR = true;
            notifyDataSetChanged();
            return cursor2;
        }
        this.VT = -1;
        this.VR = false;
        notifyDataSetInvalidated();
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
        if (this.VW == null) {
            this.VW = new nl(this);
        }
        return this.VW;
    }

    protected void onContentChanged() {
        if (this.VS && this.MC != null && !this.MC.isClosed()) {
            this.VR = this.MC.requery();
        }
    }
}
