package com.fossil;

import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;

public class sm {
    public static int m13551a(s sVar, sf sfVar, View view, View view2, h hVar, boolean z, boolean z2) {
        if (hVar.getChildCount() == 0 || sVar.getItemCount() == 0 || view == null || view2 == null) {
            return 0;
        }
        int max;
        int min = Math.min(hVar.ce(view), hVar.ce(view2));
        int max2 = Math.max(hVar.ce(view), hVar.ce(view2));
        if (z2) {
            max = Math.max(0, (sVar.getItemCount() - max2) - 1);
        } else {
            max = Math.max(0, min);
        }
        if (!z) {
            return max;
        }
        return Math.round((((float) max) * (((float) Math.abs(sfVar.bL(view2) - sfVar.bK(view))) / ((float) (Math.abs(hVar.ce(view) - hVar.ce(view2)) + 1)))) + ((float) (sfVar.pF() - sfVar.bK(view))));
    }

    public static int m13550a(s sVar, sf sfVar, View view, View view2, h hVar, boolean z) {
        if (hVar.getChildCount() == 0 || sVar.getItemCount() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(hVar.ce(view) - hVar.ce(view2)) + 1;
        }
        return Math.min(sfVar.pH(), sfVar.bL(view2) - sfVar.bK(view));
    }

    public static int m13552b(s sVar, sf sfVar, View view, View view2, h hVar, boolean z) {
        if (hVar.getChildCount() == 0 || sVar.getItemCount() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return sVar.getItemCount();
        }
        return (int) ((((float) (sfVar.bL(view2) - sfVar.bK(view))) / ((float) (Math.abs(hVar.ce(view) - hVar.ce(view2)) + 1))) * ((float) sVar.getItemCount()));
    }
}
