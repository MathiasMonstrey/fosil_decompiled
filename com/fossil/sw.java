package com.fossil;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

public class sw {
    private final TypedArray auX;
    private final Context mContext;

    public static sw m13582a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new sw(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static sw m13583a(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new sw(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    public static sw m13581a(Context context, int i, int[] iArr) {
        return new sw(context, context.obtainStyledAttributes(i, iArr));
    }

    private sw(Context context, TypedArray typedArray) {
        this.mContext = context;
        this.auX = typedArray;
    }

    public Drawable getDrawable(int i) {
        if (this.auX.hasValue(i)) {
            int resourceId = this.auX.getResourceId(i, 0);
            if (resourceId != 0) {
                return pn.m13079c(this.mContext, resourceId);
            }
        }
        return this.auX.getDrawable(i);
    }

    public Drawable el(int i) {
        if (this.auX.hasValue(i)) {
            int resourceId = this.auX.getResourceId(i, 0);
            if (resourceId != 0) {
                return rg.ou().m13340a(this.mContext, resourceId, true);
            }
        }
        return null;
    }

    public CharSequence getText(int i) {
        return this.auX.getText(i);
    }

    public String getString(int i) {
        return this.auX.getString(i);
    }

    public boolean getBoolean(int i, boolean z) {
        return this.auX.getBoolean(i, z);
    }

    public int getInt(int i, int i2) {
        return this.auX.getInt(i, i2);
    }

    public float getFloat(int i, float f) {
        return this.auX.getFloat(i, f);
    }

    public int getColor(int i, int i2) {
        return this.auX.getColor(i, i2);
    }

    public ColorStateList getColorStateList(int i) {
        if (this.auX.hasValue(i)) {
            int resourceId = this.auX.getResourceId(i, 0);
            if (resourceId != 0) {
                ColorStateList d = pn.m13080d(this.mContext, resourceId);
                if (d != null) {
                    return d;
                }
            }
        }
        return this.auX.getColorStateList(i);
    }

    public int getInteger(int i, int i2) {
        return this.auX.getInteger(i, i2);
    }

    public int getDimensionPixelOffset(int i, int i2) {
        return this.auX.getDimensionPixelOffset(i, i2);
    }

    public int getDimensionPixelSize(int i, int i2) {
        return this.auX.getDimensionPixelSize(i, i2);
    }

    public int getLayoutDimension(int i, int i2) {
        return this.auX.getLayoutDimension(i, i2);
    }

    public int getResourceId(int i, int i2) {
        return this.auX.getResourceId(i, i2);
    }

    public CharSequence[] getTextArray(int i) {
        return this.auX.getTextArray(i);
    }

    public boolean hasValue(int i) {
        return this.auX.hasValue(i);
    }

    public void recycle() {
        this.auX.recycle();
    }
}
