package com.fossil;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public abstract class kc {
    private static final String TAG = "ActionProvider(support)";
    private final Context mContext;
    private C3780a mSubUiVisibilityListener;
    private C3781b mVisibilityListener;

    public interface C3780a {
        void m11956F(boolean z);
    }

    public interface C3781b {
        void onActionProviderVisibilityChanged(boolean z);
    }

    public abstract View onCreateActionView();

    public kc(Context context) {
        this.mContext = context;
    }

    public Context getContext() {
        return this.mContext;
    }

    public View onCreateActionView(MenuItem menuItem) {
        return onCreateActionView();
    }

    public boolean overridesItemVisibility() {
        return false;
    }

    public boolean isVisible() {
        return true;
    }

    public void refreshVisibility() {
        if (this.mVisibilityListener != null && overridesItemVisibility()) {
            this.mVisibilityListener.onActionProviderVisibilityChanged(isVisible());
        }
    }

    public boolean onPerformDefaultAction() {
        return false;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public void onPrepareSubMenu(SubMenu subMenu) {
    }

    public void subUiVisibilityChanged(boolean z) {
        if (this.mSubUiVisibilityListener != null) {
            this.mSubUiVisibilityListener.m11956F(z);
        }
    }

    public void setSubUiVisibilityListener(C3780a c3780a) {
        this.mSubUiVisibilityListener = c3780a;
    }

    public void setVisibilityListener(C3781b c3781b) {
        if (!(this.mVisibilityListener == null || c3781b == null)) {
            Log.w(TAG, "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.mVisibilityListener = c3781b;
    }

    public void reset() {
        this.mVisibilityListener = null;
        this.mSubUiVisibilityListener = null;
    }
}
