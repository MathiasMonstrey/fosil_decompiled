package com.fossil;

import android.annotation.TargetApi;
import android.view.View;
import android.widget.ListView;

@TargetApi(9)
class nw {
    static void m12829a(ListView listView, int i) {
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        if (firstVisiblePosition != -1) {
            View childAt = listView.getChildAt(0);
            if (childAt != null) {
                listView.setSelectionFromTop(firstVisiblePosition, childAt.getTop() - i);
            }
        }
    }
}
