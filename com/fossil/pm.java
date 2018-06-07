package com.fossil;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import com.fossil.pk.C3982a;
import com.fossil.pk.C3991j;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

final class pm {
    public static ColorStateList createFromXml(Resources resources, XmlPullParser xmlPullParser, Theme theme) throws XmlPullParserException, IOException {
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return m13075c(resources, xmlPullParser, asAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    private static ColorStateList m13075c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return m13077d(resources, xmlPullParser, attributeSet, theme);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    private static ColorStateList m13077d(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        Object trimStateSet;
        int depth = xmlPullParser.getDepth() + 1;
        Object obj = new int[20][];
        Object obj2 = obj;
        int i = 0;
        Object obj3 = new int[obj.length];
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                break;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next == 3) {
                break;
            } else if (next == 2 && depth2 <= depth && xmlPullParser.getName().equals("item")) {
                TypedArray a = m13074a(resources, theme, attributeSet, C3991j.ColorStateListItem);
                int color = a.getColor(C3991j.ColorStateListItem_android_color, -65281);
                float f = 1.0f;
                if (a.hasValue(C3991j.ColorStateListItem_android_alpha)) {
                    f = a.getFloat(C3991j.ColorStateListItem_android_alpha, 1.0f);
                } else if (a.hasValue(C3991j.ColorStateListItem_alpha)) {
                    f = a.getFloat(C3991j.ColorStateListItem_alpha, 1.0f);
                }
                a.recycle();
                int i2 = 0;
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr = new int[attributeCount];
                int i3 = 0;
                while (i3 < attributeCount) {
                    depth2 = attributeSet.getAttributeNameResource(i3);
                    if (depth2 == 16843173 || depth2 == 16843551 || depth2 == C3982a.alpha) {
                        depth2 = i2;
                    } else {
                        int i4 = i2 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i3, false)) {
                            depth2 = -depth2;
                        }
                        iArr[i2] = depth2;
                        depth2 = i4;
                    }
                    i3++;
                    i2 = depth2;
                }
                trimStateSet = StateSet.trimStateSet(iArr, i2);
                next = m13076d(color, f);
                if (i == 0 || trimStateSet.length == 0) {
                    obj = po.m13085b(obj3, i, next);
                    i++;
                    obj2 = (int[][]) po.m13084a(obj2, i, trimStateSet);
                    obj3 = obj;
                } else {
                    obj = po.m13085b(obj3, i, next);
                    i++;
                    obj2 = (int[][]) po.m13084a(obj2, i, trimStateSet);
                    obj3 = obj;
                }
            }
        }
        obj = new int[i];
        trimStateSet = new int[i][];
        System.arraycopy(obj3, 0, obj, 0, i);
        System.arraycopy(obj2, 0, trimStateSet, 0, i);
        return new ColorStateList(trimStateSet, obj);
    }

    private static TypedArray m13074a(Resources resources, Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    private static int m13076d(int i, float f) {
        return hg.x(i, Math.round(((float) Color.alpha(i)) * f));
    }
}
