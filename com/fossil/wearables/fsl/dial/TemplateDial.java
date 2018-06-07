package com.fossil.wearables.fsl.dial;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Log;

public class TemplateDial implements DialListItem {
    private ConfigItemOptionTable configItemOptionTable;
    private String mDisplayName;
    private boolean mIsCustomizable;
    private int mResId;
    private String mUniqueId;
    private Class mWatchFaceClass;

    public TemplateDial(String str, boolean z, int i, Class cls) {
        this.mDisplayName = str;
        this.mIsCustomizable = z;
        this.mResId = i;
        this.mWatchFaceClass = cls;
    }

    public TemplateDial(String str, int i, Class cls, ConfigItemOptionTable configItemOptionTable, String str2) {
        this.mDisplayName = str;
        this.mIsCustomizable = true;
        this.mResId = i;
        this.mWatchFaceClass = cls;
        this.configItemOptionTable = configItemOptionTable;
        this.mUniqueId = str2;
    }

    public Class getWatchFaceClass() {
        return this.mWatchFaceClass;
    }

    public ConfigItemOptionTable getConfigItemOptionTable() {
        return this.configItemOptionTable;
    }

    public void setInitialConfigItemsTo(SavedDial savedDial) {
    }

    public boolean isCustomizable() {
        return this.mIsCustomizable;
    }

    public int getResId() {
        return this.mResId;
    }

    public int getConfigItemDisplayResId(String str) {
        return 0;
    }

    public String getUniqueId() {
        if (this.mUniqueId == null) {
            this.mUniqueId = this.mDisplayName.replace(' ', '_');
            Log.d(getClass().getSimpleName(), "No unique id -> use default rule: " + this.mUniqueId);
        }
        return this.mUniqueId;
    }

    public String toString() {
        return this.mDisplayName;
    }

    public int getDbRowId() {
        return -1;
    }

    public Drawable getThumbnailDrawable(Context context) {
        return context.getResources().getDrawable(this.mResId);
    }

    public Bitmap getThumbnailBitmap() {
        return null;
    }

    public String getDisplayName() {
        return this.mDisplayName;
    }

    public void livePreview(Object obj, ConfigItem configItem, Context context) {
    }
}
