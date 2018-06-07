package android.support.v7.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.PopupWindow;
import com.fossil.nz;
import com.fossil.pk.j;
import com.fossil.sw;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

class AppCompatPopupWindow extends PopupWindow {
    private static final boolean akO = (VERSION.SDK_INT < 21);
    private boolean akP;

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2203a(context, attributeSet, i, 0);
    }

    @TargetApi(11)
    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m2203a(context, attributeSet, i, i2);
    }

    private void m2203a(Context context, AttributeSet attributeSet, int i, int i2) {
        sw a = sw.a(context, attributeSet, j.PopupWindow, i, i2);
        if (a.hasValue(j.PopupWindow_overlapAnchor)) {
            ak(a.getBoolean(j.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(a.getDrawable(j.PopupWindow_android_popupBackground));
        int i3 = VERSION.SDK_INT;
        if (i2 != 0 && i3 < 11 && a.hasValue(j.PopupWindow_android_popupAnimationStyle)) {
            setAnimationStyle(a.getResourceId(j.PopupWindow_android_popupAnimationStyle, -1));
        }
        a.recycle();
        if (VERSION.SDK_INT < 14) {
            m2204a(this);
        }
    }

    public void showAsDropDown(View view, int i, int i2) {
        if (akO && this.akP) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    @TargetApi(19)
    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (akO && this.akP) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    public void update(View view, int i, int i2, int i3, int i4) {
        int height;
        if (akO && this.akP) {
            height = i2 - view.getHeight();
        } else {
            height = i2;
        }
        super.update(view, i, height, i3, i4);
    }

    private static void m2204a(final PopupWindow popupWindow) {
        try {
            final Field declaredField = PopupWindow.class.getDeclaredField("mAnchor");
            declaredField.setAccessible(true);
            Field declaredField2 = PopupWindow.class.getDeclaredField("mOnScrollChangedListener");
            declaredField2.setAccessible(true);
            final OnScrollChangedListener onScrollChangedListener = (OnScrollChangedListener) declaredField2.get(popupWindow);
            declaredField2.set(popupWindow, new OnScrollChangedListener() {
                public void onScrollChanged() {
                    try {
                        WeakReference weakReference = (WeakReference) declaredField.get(popupWindow);
                        if (weakReference != null && weakReference.get() != null) {
                            onScrollChangedListener.onScrollChanged();
                        }
                    } catch (IllegalAccessException e) {
                    }
                }
            });
        } catch (Throwable e) {
            Log.d("AppCompatPopupWindow", "Exception while installing workaround OnScrollChangedListener", e);
        }
    }

    public void ak(boolean z) {
        if (akO) {
            this.akP = z;
        } else {
            nz.a(this, z);
        }
    }
}
