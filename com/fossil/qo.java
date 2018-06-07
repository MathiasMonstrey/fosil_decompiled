package com.fossil;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;

abstract class qo implements OnItemClickListener, qq, qu {
    private Rect ahg;

    public abstract void mo4029Y(boolean z);

    public abstract void mo4031f(qj qjVar);

    public abstract void setAnchorView(View view);

    public abstract void setForceShowIcon(boolean z);

    public abstract void setGravity(int i);

    public abstract void setHorizontalOffset(int i);

    public abstract void setOnDismissListener(OnDismissListener onDismissListener);

    public abstract void setVerticalOffset(int i);

    qo() {
    }

    public void m13149h(Rect rect) {
        this.ahg = rect;
    }

    public Rect nr() {
        return this.ahg;
    }

    public void mo4018a(Context context, qj qjVar) {
    }

    public boolean mo4021a(qj qjVar, ql qlVar) {
        return false;
    }

    public boolean mo4023b(qj qjVar, ql qlVar) {
        return false;
    }

    public int getId() {
        return 0;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        m13142a(listAdapter).agn.m13181a((MenuItem) listAdapter.getItem(i), (qq) this, mI() ? 0 : 4);
    }

    protected static int m13141a(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i2 = 0;
        int i3 = 0;
        View view = null;
        int i4 = 0;
        ViewGroup viewGroup2 = viewGroup;
        while (i2 < count) {
            ViewGroup frameLayout;
            int itemViewType = listAdapter.getItemViewType(i2);
            if (itemViewType != i3) {
                i3 = itemViewType;
                view = null;
            }
            if (viewGroup2 == null) {
                frameLayout = new FrameLayout(context);
            } else {
                frameLayout = viewGroup2;
            }
            view = listAdapter.getView(i2, view, frameLayout);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i) {
                return i;
            }
            if (measuredWidth <= i4) {
                measuredWidth = i4;
            }
            i2++;
            i4 = measuredWidth;
            viewGroup2 = frameLayout;
        }
        return i4;
    }

    protected static qi m13142a(ListAdapter listAdapter) {
        if (listAdapter instanceof HeaderViewListAdapter) {
            return (qi) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter();
        }
        return (qi) listAdapter;
    }

    protected static boolean m13143i(qj qjVar) {
        int size = qjVar.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = qjVar.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    protected boolean mI() {
        return true;
    }
}
