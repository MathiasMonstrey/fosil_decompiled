package com.fossil;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParserException;

class si extends Resources {
    private final Resources Xe;

    public si(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.Xe = resources;
    }

    public CharSequence getText(int i) throws NotFoundException {
        return this.Xe.getText(i);
    }

    public CharSequence getQuantityText(int i, int i2) throws NotFoundException {
        return this.Xe.getQuantityText(i, i2);
    }

    public String getString(int i) throws NotFoundException {
        return this.Xe.getString(i);
    }

    public String getString(int i, Object... objArr) throws NotFoundException {
        return this.Xe.getString(i, objArr);
    }

    public String getQuantityString(int i, int i2, Object... objArr) throws NotFoundException {
        return this.Xe.getQuantityString(i, i2, objArr);
    }

    public String getQuantityString(int i, int i2) throws NotFoundException {
        return this.Xe.getQuantityString(i, i2);
    }

    public CharSequence getText(int i, CharSequence charSequence) {
        return this.Xe.getText(i, charSequence);
    }

    public CharSequence[] getTextArray(int i) throws NotFoundException {
        return this.Xe.getTextArray(i);
    }

    public String[] getStringArray(int i) throws NotFoundException {
        return this.Xe.getStringArray(i);
    }

    public int[] getIntArray(int i) throws NotFoundException {
        return this.Xe.getIntArray(i);
    }

    public TypedArray obtainTypedArray(int i) throws NotFoundException {
        return this.Xe.obtainTypedArray(i);
    }

    public float getDimension(int i) throws NotFoundException {
        return this.Xe.getDimension(i);
    }

    public int getDimensionPixelOffset(int i) throws NotFoundException {
        return this.Xe.getDimensionPixelOffset(i);
    }

    public int getDimensionPixelSize(int i) throws NotFoundException {
        return this.Xe.getDimensionPixelSize(i);
    }

    public float getFraction(int i, int i2, int i3) {
        return this.Xe.getFraction(i, i2, i3);
    }

    public Drawable getDrawable(int i) throws NotFoundException {
        return this.Xe.getDrawable(i);
    }

    public Drawable getDrawable(int i, Theme theme) throws NotFoundException {
        return this.Xe.getDrawable(i, theme);
    }

    public Drawable getDrawableForDensity(int i, int i2) throws NotFoundException {
        return this.Xe.getDrawableForDensity(i, i2);
    }

    public Drawable getDrawableForDensity(int i, int i2, Theme theme) {
        return this.Xe.getDrawableForDensity(i, i2, theme);
    }

    public Movie getMovie(int i) throws NotFoundException {
        return this.Xe.getMovie(i);
    }

    public int getColor(int i) throws NotFoundException {
        return this.Xe.getColor(i);
    }

    public ColorStateList getColorStateList(int i) throws NotFoundException {
        return this.Xe.getColorStateList(i);
    }

    public boolean getBoolean(int i) throws NotFoundException {
        return this.Xe.getBoolean(i);
    }

    public int getInteger(int i) throws NotFoundException {
        return this.Xe.getInteger(i);
    }

    public XmlResourceParser getLayout(int i) throws NotFoundException {
        return this.Xe.getLayout(i);
    }

    public XmlResourceParser getAnimation(int i) throws NotFoundException {
        return this.Xe.getAnimation(i);
    }

    public XmlResourceParser getXml(int i) throws NotFoundException {
        return this.Xe.getXml(i);
    }

    public InputStream openRawResource(int i) throws NotFoundException {
        return this.Xe.openRawResource(i);
    }

    public InputStream openRawResource(int i, TypedValue typedValue) throws NotFoundException {
        return this.Xe.openRawResource(i, typedValue);
    }

    public AssetFileDescriptor openRawResourceFd(int i) throws NotFoundException {
        return this.Xe.openRawResourceFd(i);
    }

    public void getValue(int i, TypedValue typedValue, boolean z) throws NotFoundException {
        this.Xe.getValue(i, typedValue, z);
    }

    public void getValueForDensity(int i, int i2, TypedValue typedValue, boolean z) throws NotFoundException {
        this.Xe.getValueForDensity(i, i2, typedValue, z);
    }

    public void getValue(String str, TypedValue typedValue, boolean z) throws NotFoundException {
        this.Xe.getValue(str, typedValue, z);
    }

    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.Xe.obtainAttributes(attributeSet, iArr);
    }

    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
        if (this.Xe != null) {
            this.Xe.updateConfiguration(configuration, displayMetrics);
        }
    }

    public DisplayMetrics getDisplayMetrics() {
        return this.Xe.getDisplayMetrics();
    }

    public Configuration getConfiguration() {
        return this.Xe.getConfiguration();
    }

    public int getIdentifier(String str, String str2, String str3) {
        return this.Xe.getIdentifier(str, str2, str3);
    }

    public String getResourceName(int i) throws NotFoundException {
        return this.Xe.getResourceName(i);
    }

    public String getResourcePackageName(int i) throws NotFoundException {
        return this.Xe.getResourcePackageName(i);
    }

    public String getResourceTypeName(int i) throws NotFoundException {
        return this.Xe.getResourceTypeName(i);
    }

    public String getResourceEntryName(int i) throws NotFoundException {
        return this.Xe.getResourceEntryName(i);
    }

    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) throws XmlPullParserException, IOException {
        this.Xe.parseBundleExtras(xmlResourceParser, bundle);
    }

    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) throws XmlPullParserException {
        this.Xe.parseBundleExtra(str, attributeSet, bundle);
    }
}
