package com.fossil;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@TargetApi(9)
class hj {
    public static void m11638a(Drawable drawable, int i) {
        if (drawable instanceof ht) {
            ((ht) drawable).setTint(i);
        }
    }

    public static void m11639a(Drawable drawable, ColorStateList colorStateList) {
        if (drawable instanceof ht) {
            ((ht) drawable).setTintList(colorStateList);
        }
    }

    public static void m11641a(Drawable drawable, Mode mode) {
        if (drawable instanceof ht) {
            ((ht) drawable).setTintMode(mode);
        }
    }

    public static Drawable m11642k(Drawable drawable) {
        if (drawable instanceof ht) {
            return drawable;
        }
        return new hp(drawable);
    }

    public static void m11640a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws IOException, XmlPullParserException {
        drawable.inflate(resources, xmlPullParser, attributeSet);
    }
}
