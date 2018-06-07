package com.fossil;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;

class bz {
    public static boolean m5838a(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    public static float m5833a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, float f) {
        return !m5838a(xmlPullParser, str) ? f : typedArray.getFloat(i, f);
    }

    public static boolean m5837a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, boolean z) {
        return !m5838a(xmlPullParser, str) ? z : typedArray.getBoolean(i, z);
    }

    public static int m5834a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !m5838a(xmlPullParser, str) ? i2 : typedArray.getInt(i, i2);
    }

    public static int m5839b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !m5838a(xmlPullParser, str) ? i2 : typedArray.getColor(i, i2);
    }

    public static String m5836a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i) {
        if (m5838a(xmlPullParser, str)) {
            return typedArray.getString(i);
        }
        return null;
    }

    public static int m5841c(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !m5838a(xmlPullParser, str) ? i2 : typedArray.getResourceId(i, i2);
    }

    public static TypedValue m5840b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i) {
        if (m5838a(xmlPullParser, str)) {
            return typedArray.peekValue(i);
        }
        return null;
    }

    public static TypedArray m5835a(Resources resources, Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
