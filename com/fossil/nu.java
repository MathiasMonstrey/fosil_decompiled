package com.fossil;

import android.widget.ListView;

public class nu extends ne {
    private final ListView Xa;

    public nu(ListView listView) {
        super(listView);
        this.Xa = listView;
    }

    public void mo3937A(int i, int i2) {
        nv.m12828a(this.Xa, i2);
    }

    public boolean bF(int i) {
        return false;
    }

    public boolean bG(int i) {
        ListView listView = this.Xa;
        int count = listView.getCount();
        if (count == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i2 = firstVisiblePosition + childCount;
        if (i > 0) {
            if (i2 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                return false;
            }
        } else if (i >= 0) {
            return false;
        } else {
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }
}
