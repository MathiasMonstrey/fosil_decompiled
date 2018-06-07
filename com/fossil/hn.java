package com.fossil;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.InsetDrawable;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@TargetApi(21)
class hn {
    public static void m11650a(Drawable drawable, float f, float f2) {
        drawable.setHotspot(f, f2);
    }

    public static void m11652a(Drawable drawable, int i, int i2, int i3, int i4) {
        drawable.setHotspotBounds(i, i2, i3, i4);
    }

    public static void m11651a(Drawable drawable, int i) {
        drawable.setTint(i);
    }

    public static void m11653a(Drawable drawable, ColorStateList colorStateList) {
        drawable.setTintList(colorStateList);
    }

    public static void m11656a(Drawable drawable, Mode mode) {
        drawable.setTintMode(mode);
    }

    public static Drawable m11660k(Drawable drawable) {
        if (drawable instanceof ht) {
            return drawable;
        }
        return new hs(drawable);
    }

    public static void m11654a(Drawable drawable, Theme theme) {
        drawable.applyTheme(theme);
    }

    public static boolean m11657f(Drawable drawable) {
        return drawable.canApplyTheme();
    }

    public static ColorFilter m11658g(Drawable drawable) {
        return drawable.getColorFilter();
    }

    public static void m11659h(Drawable drawable) {
        drawable.clearColorFilter();
        if (drawable instanceof InsetDrawable) {
            m11659h(((InsetDrawable) drawable).getDrawable());
        } else if (drawable instanceof ho) {
            m11659h(((ho) drawable).iM());
        } else if (drawable instanceof DrawableContainer) {
            DrawableContainerState drawableContainerState = (DrawableContainerState) ((DrawableContainer) drawable).getConstantState();
            if (drawableContainerState != null) {
                int childCount = drawableContainerState.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    Drawable child = drawableContainerState.getChild(i);
                    if (child != null) {
                        m11659h(child);
                    }
                }
            }
        }
    }

    public static void m11655a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws IOException, XmlPullParserException {
        drawable.inflate(resources, xmlPullParser, attributeSet, theme);
    }
}
