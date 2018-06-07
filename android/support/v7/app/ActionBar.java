package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import com.fossil.pk.j;
import com.fossil.pu;
import com.fossil.pu.a;

public abstract class ActionBar {

    public static class LayoutParams extends MarginLayoutParams {
        public int gravity;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.gravity = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.ActionBarLayout);
            this.gravity = obtainStyledAttributes.getInt(j.ActionBarLayout_android_layout_gravity, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.gravity = 0;
            this.gravity = 8388627;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = 0;
            this.gravity = layoutParams.gravity;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = 0;
        }
    }

    public interface C1192a {
        void onMenuVisibilityChanged(boolean z);
    }

    @Deprecated
    public static abstract class C1193b {
        public abstract CharSequence getContentDescription();

        public abstract View getCustomView();

        public abstract Drawable getIcon();

        public abstract CharSequence getText();

        public abstract void select();
    }

    public abstract int getDisplayOptions();

    public abstract CharSequence getTitle();

    public abstract boolean isShowing();

    public abstract void setDisplayHomeAsUpEnabled(boolean z);

    public void setHomeButtonEnabled(boolean z) {
    }

    public Context getThemedContext() {
        return null;
    }

    public void setHomeAsUpIndicator(int i) {
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
        }
    }

    public int getHideOffset() {
        return 0;
    }

    public void setElevation(float f) {
        if (f != 0.0f) {
            throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
        }
    }

    public void m2157O(boolean z) {
    }

    public void m2158P(boolean z) {
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void m2159Q(boolean z) {
    }

    public pu m2160a(a aVar) {
        return null;
    }

    public boolean lj() {
        return false;
    }

    public boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean collapseActionView() {
        return false;
    }

    public void setWindowTitle(CharSequence charSequence) {
    }

    public boolean requestFocus() {
        return false;
    }

    public void onDestroy() {
    }
}
