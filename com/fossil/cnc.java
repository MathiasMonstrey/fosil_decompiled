package com.fossil;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.view.FlexibleEditText;

public class cnc {
    private static final String TAG = cnc.class.toString();

    public static void m7185a(ViewGroup viewGroup, Context context) {
        try {
            if (bz(context)) {
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    if (viewGroup.getChildAt(i) instanceof ImageView) {
                        ((ImageView) viewGroup.getChildAt(i)).getDrawable().setAutoMirrored(true);
                    }
                }
            }
        } catch (Exception e) {
            MFLogger.m12670d(TAG, e.toString());
        }
    }

    public static boolean bz(Context context) {
        if (VERSION.SDK_INT < 17) {
            return false;
        }
        if (context.getResources().getConfiguration().getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    @SuppressLint({"RtlHardcoded"})
    public static void m7186b(View view, Context context) {
        try {
            if (bz(context) && (view instanceof FlexibleEditText)) {
                ((FlexibleEditText) view).setGravity(8388629);
                view.setTextDirection(4);
            }
        } catch (Exception e) {
            MFLogger.m12670d(TAG, e.toString());
        }
    }
}
