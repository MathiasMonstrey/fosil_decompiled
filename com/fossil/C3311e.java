package com.fossil;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class C3311e {
    private static C1978c oc = new C1978c();
    private static C2160d oe = null;

    public static <T extends C2161i> T m10385a(LayoutInflater layoutInflater, int i, ViewGroup viewGroup, boolean z) {
        return C3311e.m10386a(layoutInflater, i, viewGroup, z, oe);
    }

    public static <T extends C2161i> T m10386a(LayoutInflater layoutInflater, int i, ViewGroup viewGroup, boolean z, C2160d c2160d) {
        int i2 = 0;
        int i3 = (viewGroup == null || !z) ? 0 : 1;
        if (i3 != 0) {
            i2 = viewGroup.getChildCount();
        }
        View inflate = layoutInflater.inflate(i, viewGroup, z);
        if (i3 != 0) {
            return C3311e.m10387a(c2160d, viewGroup, i2, i);
        }
        return C3311e.m10388b(c2160d, inflate, i);
    }

    static <T extends C2161i> T m10389b(C2160d c2160d, View[] viewArr, int i) {
        return oc.m5859a(c2160d, viewArr, i);
    }

    static <T extends C2161i> T m10388b(C2160d c2160d, View view, int i) {
        return oc.m5858a(c2160d, view, i);
    }

    public static <T extends C2161i> T m10383a(Activity activity, int i) {
        return C3311e.m10384a(activity, i, oe);
    }

    public static <T extends C2161i> T m10384a(Activity activity, int i, C2160d c2160d) {
        activity.setContentView(i);
        return C3311e.m10387a(c2160d, (ViewGroup) activity.getWindow().getDecorView().findViewById(16908290), 0, i);
    }

    private static <T extends C2161i> T m10387a(C2160d c2160d, ViewGroup viewGroup, int i, int i2) {
        int childCount = viewGroup.getChildCount();
        int i3 = childCount - i;
        if (i3 == 1) {
            return C3311e.m10388b(c2160d, viewGroup.getChildAt(childCount - 1), i2);
        }
        View[] viewArr = new View[i3];
        for (childCount = 0; childCount < i3; childCount++) {
            viewArr[childCount] = viewGroup.getChildAt(childCount + i);
        }
        return C3311e.m10389b(c2160d, viewArr, i2);
    }
}
