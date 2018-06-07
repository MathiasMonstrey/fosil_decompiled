package com.fossil;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import com.fossil.by.C1971b;
import com.misfit.frameworks.common.constants.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class bv {
    private static final TypedValue DR = new TypedValue();

    static class C1962a implements TypeEvaluator<C1971b[]> {
        private C1971b[] DS;

        public /* synthetic */ Object evaluate(float f, Object obj, Object obj2) {
            return m5700a(f, (C1971b[]) obj, (C1971b[]) obj2);
        }

        private C1962a() {
        }

        public C1971b[] m5700a(float f, C1971b[] c1971bArr, C1971b[] c1971bArr2) {
            if (by.m5789a(c1971bArr, c1971bArr2)) {
                if (this.DS == null || !by.m5789a(this.DS, c1971bArr)) {
                    this.DS = by.m5790a(c1971bArr);
                }
                for (int i = 0; i < c1971bArr.length; i++) {
                    this.DS[i].m5783a(c1971bArr[i], c1971bArr2[i], f);
                }
                return this.DS;
            }
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
    }

    public static Animator loadAnimator(Context context, int i) throws NotFoundException {
        if (VERSION.SDK_INT >= 24) {
            return AnimatorInflater.loadAnimator(context, i);
        }
        return m5702a(context, context.getResources(), context.getTheme(), i);
    }

    public static Animator m5702a(Context context, Resources resources, Theme theme, int i) throws NotFoundException {
        return m5703a(context, resources, theme, i, 1.0f);
    }

    public static Animator m5703a(Context context, Resources resources, Theme theme, int i, float f) throws NotFoundException {
        NotFoundException notFoundException;
        XmlResourceParser xmlResourceParser = null;
        try {
            xmlResourceParser = resources.getAnimation(i);
            Animator a = m5704a(context, resources, theme, (XmlPullParser) xmlResourceParser, f);
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            return a;
        } catch (Throwable e) {
            notFoundException = new NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
            notFoundException.initCause(e);
            throw notFoundException;
        } catch (Throwable e2) {
            notFoundException = new NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
            notFoundException.initCause(e2);
            throw notFoundException;
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }

    private static PropertyValuesHolder m5710a(TypedArray typedArray, int i, int i2, int i3, String str) {
        Object obj;
        TypedValue peekValue = typedArray.peekValue(i2);
        Object obj2 = peekValue != null ? 1 : null;
        int i4 = obj2 != null ? peekValue.type : 0;
        TypedValue peekValue2 = typedArray.peekValue(i3);
        Object obj3 = peekValue2 != null ? 1 : null;
        int i5 = obj3 != null ? peekValue2.type : 0;
        if (i == 4) {
            if ((obj2 == null || !au(i4)) && (obj3 == null || !au(i5))) {
                i = 0;
            } else {
                i = 3;
            }
        }
        if (i == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (i == 2) {
            String string = typedArray.getString(i2);
            String string2 = typedArray.getString(i3);
            C1971b[] P = by.m5785P(string);
            C1971b[] P2 = by.m5785P(string2);
            if (!(P == null && P2 == null)) {
                if (P != null) {
                    TypeEvaluator c1962a = new C1962a();
                    if (P2 == null) {
                        return PropertyValuesHolder.ofObject(str, c1962a, new Object[]{P});
                    } else if (by.m5789a(P, P2)) {
                        return PropertyValuesHolder.ofObject(str, c1962a, new Object[]{P, P2});
                    } else {
                        throw new InflateException(" Can't morph from " + string + " to " + string2);
                    }
                } else if (P2 != null) {
                    return PropertyValuesHolder.ofObject(str, new C1962a(), new Object[]{P2});
                }
            }
            return null;
        }
        PropertyValuesHolder ofFloat;
        TypeEvaluator typeEvaluator = null;
        if (i == 3) {
            typeEvaluator = bw.hk();
        }
        if (obj != null) {
            float dimension;
            if (obj2 != null) {
                float dimension2;
                if (i4 == 5) {
                    dimension2 = typedArray.getDimension(i2, 0.0f);
                } else {
                    dimension2 = typedArray.getFloat(i2, 0.0f);
                }
                if (obj3 != null) {
                    if (i5 == 5) {
                        dimension = typedArray.getDimension(i3, 0.0f);
                    } else {
                        dimension = typedArray.getFloat(i3, 0.0f);
                    }
                    ofFloat = PropertyValuesHolder.ofFloat(str, new float[]{dimension2, dimension});
                } else {
                    ofFloat = PropertyValuesHolder.ofFloat(str, new float[]{dimension2});
                }
            } else {
                if (i5 == 5) {
                    dimension = typedArray.getDimension(i3, 0.0f);
                } else {
                    dimension = typedArray.getFloat(i3, 0.0f);
                }
                ofFloat = PropertyValuesHolder.ofFloat(str, new float[]{dimension});
            }
        } else if (obj2 != null) {
            int dimension3;
            if (i4 == 5) {
                dimension3 = (int) typedArray.getDimension(i2, 0.0f);
            } else if (au(i4)) {
                dimension3 = typedArray.getColor(i2, 0);
            } else {
                dimension3 = typedArray.getInt(i2, 0);
            }
            if (obj3 != null) {
                if (i5 == 5) {
                    i4 = (int) typedArray.getDimension(i3, 0.0f);
                } else if (au(i5)) {
                    i4 = typedArray.getColor(i3, 0);
                } else {
                    i4 = typedArray.getInt(i3, 0);
                }
                ofFloat = PropertyValuesHolder.ofInt(str, new int[]{dimension3, i4});
            } else {
                ofFloat = PropertyValuesHolder.ofInt(str, new int[]{dimension3});
            }
        } else if (obj3 != null) {
            if (i5 == 5) {
                i4 = (int) typedArray.getDimension(i3, 0.0f);
            } else if (au(i5)) {
                i4 = typedArray.getColor(i3, 0);
            } else {
                i4 = typedArray.getInt(i3, 0);
            }
            ofFloat = PropertyValuesHolder.ofInt(str, new int[]{i4});
        } else {
            ofFloat = null;
        }
        if (ofFloat == null || typeEvaluator == null) {
            return ofFloat;
        }
        ofFloat.setEvaluator(typeEvaluator);
        return ofFloat;
    }

    private static void m5713a(ValueAnimator valueAnimator, TypedArray typedArray, TypedArray typedArray2, float f, XmlPullParser xmlPullParser) {
        long a = (long) bz.m5834a(typedArray, xmlPullParser, Constants.DURATION, 1, 300);
        long a2 = (long) bz.m5834a(typedArray, xmlPullParser, "startOffset", 2, 0);
        int a3 = bz.m5834a(typedArray, xmlPullParser, "valueType", 7, 4);
        if (bz.m5838a(xmlPullParser, "valueFrom") && bz.m5838a(xmlPullParser, "valueTo")) {
            if (a3 == 4) {
                a3 = m5716b(typedArray, 5, 6);
            }
            if (m5710a(typedArray, a3, 5, 6, "") != null) {
                valueAnimator.setValues(new PropertyValuesHolder[]{m5710a(typedArray, a3, 5, 6, "")});
            }
            valueAnimator.setDuration(a);
            valueAnimator.setStartDelay(a2);
            valueAnimator.setRepeatCount(bz.m5834a(typedArray, xmlPullParser, "repeatCount", 3, 0));
            valueAnimator.setRepeatMode(bz.m5834a(typedArray, xmlPullParser, "repeatMode", 4, 1));
            if (typedArray2 != null) {
                m5712a(valueAnimator, typedArray2, a3, f, xmlPullParser);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("no valueFrom or no valueTo");
    }

    private static void m5712a(ValueAnimator valueAnimator, TypedArray typedArray, int i, float f, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator;
        if (bz.m5836a(typedArray, xmlPullParser, "pathData", 1) != null) {
            Log.e("AnimatorInflater", "We don't support moving along path yet");
        } else {
            objectAnimator.setPropertyName(bz.m5836a(typedArray, xmlPullParser, "propertyName", 0));
        }
    }

    private static Animator m5704a(Context context, Resources resources, Theme theme, XmlPullParser xmlPullParser, float f) throws XmlPullParserException, IOException {
        return m5705a(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser), null, 0, f);
    }

    private static Animator m5705a(Context context, Resources resources, Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet, AnimatorSet animatorSet, int i, float f) throws XmlPullParserException, IOException {
        Animator animator = null;
        ArrayList arrayList = null;
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next == 2) {
                    String name = xmlPullParser.getName();
                    Object obj;
                    if (name.equals("objectAnimator")) {
                        animator = m5708a(context, resources, theme, attributeSet, f, xmlPullParser);
                        obj = null;
                    } else if (name.equals("animator")) {
                        animator = m5711a(context, resources, theme, attributeSet, null, f, xmlPullParser);
                        obj = null;
                    } else if (name.equals("set")) {
                        Animator animatorSet2 = new AnimatorSet();
                        TypedArray a = bz.m5835a(resources, theme, attributeSet, br.Dz);
                        Context context2 = context;
                        Resources resources2 = resources;
                        Theme theme2 = theme;
                        XmlPullParser xmlPullParser2 = xmlPullParser;
                        AttributeSet attributeSet2 = attributeSet;
                        m5705a(context2, resources2, theme2, xmlPullParser2, attributeSet2, (AnimatorSet) animatorSet2, bz.m5834a(a, xmlPullParser, "ordering", 0, 0), f);
                        a.recycle();
                        obj = null;
                        animator = animatorSet2;
                    } else if (name.equals("propertyValuesHolder")) {
                        PropertyValuesHolder[] a2 = m5715a(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser));
                        if (!(a2 == null || animator == null || !(animator instanceof ValueAnimator))) {
                            ((ValueAnimator) animator).setValues(a2);
                        }
                        obj = 1;
                    } else {
                        throw new RuntimeException("Unknown animator name: " + xmlPullParser.getName());
                    }
                    if (animatorSet != null && r4 == null) {
                        ArrayList arrayList2;
                        if (arrayList == null) {
                            arrayList2 = new ArrayList();
                        } else {
                            arrayList2 = arrayList;
                        }
                        arrayList2.add(animator);
                        arrayList = arrayList2;
                    }
                }
            }
        }
        if (!(animatorSet == null || arrayList == null)) {
            Animator[] animatorArr = new Animator[arrayList.size()];
            Iterator it = arrayList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                int i3 = i2 + 1;
                animatorArr[i2] = (Animator) it.next();
                i2 = i3;
            }
            if (i == 0) {
                animatorSet.playTogether(animatorArr);
            } else {
                animatorSet.playSequentially(animatorArr);
            }
        }
        return animator;
    }

    private static PropertyValuesHolder[] m5715a(Context context, Resources resources, Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        ArrayList arrayList = null;
        while (true) {
            int eventType = xmlPullParser.getEventType();
            if (eventType != 3 && eventType != 1) {
                if (eventType != 2) {
                    xmlPullParser.next();
                } else {
                    ArrayList arrayList2;
                    if (xmlPullParser.getName().equals("propertyValuesHolder")) {
                        Object a;
                        TypedArray a2 = bz.m5835a(resources, theme, attributeSet, br.DA);
                        String a3 = bz.m5836a(a2, xmlPullParser, "propertyName", 3);
                        int a4 = bz.m5834a(a2, xmlPullParser, "valueType", 2, 4);
                        PropertyValuesHolder a5 = m5709a(context, resources, theme, xmlPullParser, a3, a4);
                        if (a5 == null) {
                            a = m5710a(a2, a4, 0, 1, a3);
                        } else {
                            PropertyValuesHolder propertyValuesHolder = a5;
                        }
                        if (a != null) {
                            if (arrayList == null) {
                                arrayList2 = new ArrayList();
                            } else {
                                arrayList2 = arrayList;
                            }
                            arrayList2.add(a);
                        } else {
                            arrayList2 = arrayList;
                        }
                        a2.recycle();
                    } else {
                        arrayList2 = arrayList;
                    }
                    xmlPullParser.next();
                    arrayList = arrayList2;
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[size];
        for (int i = 0; i < size; i++) {
            propertyValuesHolderArr[i] = (PropertyValuesHolder) arrayList.get(i);
        }
        return propertyValuesHolderArr;
    }

    private static int m5701a(Resources resources, Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        int i = 0;
        TypedArray a = bz.m5835a(resources, theme, attributeSet, br.DB);
        TypedValue b = bz.m5840b(a, xmlPullParser, "value", 0);
        if ((b != null ? 1 : 0) != 0 && au(b.type)) {
            i = 3;
        }
        a.recycle();
        return i;
    }

    private static int m5716b(TypedArray typedArray, int i, int i2) {
        int i3;
        TypedValue peekValue = typedArray.peekValue(i);
        int i4 = peekValue != null ? 1 : 0;
        int i5;
        if (i4 != 0) {
            i5 = peekValue.type;
        } else {
            i5 = 0;
        }
        TypedValue peekValue2 = typedArray.peekValue(i2);
        if (peekValue2 != null) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        int i6;
        if (i3 != 0) {
            i6 = peekValue2.type;
        } else {
            i6 = 0;
        }
        if ((i4 == 0 || !au(r0)) && (i3 == 0 || !au(r2))) {
            return 0;
        }
        return 3;
    }

    private static PropertyValuesHolder m5709a(Context context, Resources resources, Theme theme, XmlPullParser xmlPullParser, String str, int i) throws XmlPullParserException, IOException {
        Keyframe keyframe;
        float fraction;
        int i2;
        Keyframe[] keyframeArr;
        ArrayList arrayList = null;
        int i3 = i;
        while (true) {
            Keyframe a;
            int size;
            float fraction2;
            int i4;
            PropertyValuesHolder ofKeyframe;
            int next = xmlPullParser.next();
            if (next != 3 && next != 1) {
                ArrayList arrayList2;
                if (xmlPullParser.getName().equals("keyframe")) {
                    if (i3 == 4) {
                        i3 = m5701a(resources, theme, Xml.asAttributeSet(xmlPullParser), xmlPullParser);
                    }
                    a = m5707a(context, resources, theme, Xml.asAttributeSet(xmlPullParser), i3, xmlPullParser);
                    if (a != null) {
                        if (arrayList == null) {
                            arrayList2 = new ArrayList();
                        } else {
                            arrayList2 = arrayList;
                        }
                        arrayList2.add(a);
                    } else {
                        arrayList2 = arrayList;
                    }
                    xmlPullParser.next();
                } else {
                    arrayList2 = arrayList;
                }
                arrayList = arrayList2;
            } else if (arrayList != null) {
                size = arrayList.size();
                if (size > 0) {
                    keyframe = (Keyframe) arrayList.get(0);
                    a = (Keyframe) arrayList.get(size - 1);
                    fraction = a.getFraction();
                    if (fraction < 1.0f) {
                        i2 = size;
                    } else if (fraction >= 0.0f) {
                        a.setFraction(1.0f);
                        i2 = size;
                    } else {
                        arrayList.add(arrayList.size(), m5706a(a, 1.0f));
                        i2 = size + 1;
                    }
                    fraction2 = keyframe.getFraction();
                    if (fraction2 != 0.0f) {
                        if (fraction2 >= 0.0f) {
                            keyframe.setFraction(0.0f);
                        } else {
                            arrayList.add(0, m5706a(keyframe, 0.0f));
                            i2++;
                        }
                    }
                    keyframeArr = new Keyframe[i2];
                    arrayList.toArray(keyframeArr);
                    for (i4 = 0; i4 < i2; i4++) {
                        keyframe = keyframeArr[i4];
                        if (keyframe.getFraction() >= 0.0f) {
                            if (i4 == 0) {
                                keyframe.setFraction(0.0f);
                            } else if (i4 != i2 - 1) {
                                keyframe.setFraction(1.0f);
                            } else {
                                next = i4 + 1;
                                size = i4;
                                while (next < i2 - 1 && keyframeArr[next].getFraction() < 0.0f) {
                                    size = next;
                                    next++;
                                }
                                m5714a(keyframeArr, keyframeArr[size + 1].getFraction() - keyframeArr[i4 - 1].getFraction(), i4, size);
                            }
                        }
                    }
                    ofKeyframe = PropertyValuesHolder.ofKeyframe(str, keyframeArr);
                    if (i3 == 3) {
                        return ofKeyframe;
                    }
                    ofKeyframe.setEvaluator(bw.hk());
                    return ofKeyframe;
                }
            }
        }
        if (arrayList != null) {
            size = arrayList.size();
            if (size > 0) {
                keyframe = (Keyframe) arrayList.get(0);
                a = (Keyframe) arrayList.get(size - 1);
                fraction = a.getFraction();
                if (fraction < 1.0f) {
                    i2 = size;
                } else if (fraction >= 0.0f) {
                    arrayList.add(arrayList.size(), m5706a(a, 1.0f));
                    i2 = size + 1;
                } else {
                    a.setFraction(1.0f);
                    i2 = size;
                }
                fraction2 = keyframe.getFraction();
                if (fraction2 != 0.0f) {
                    if (fraction2 >= 0.0f) {
                        arrayList.add(0, m5706a(keyframe, 0.0f));
                        i2++;
                    } else {
                        keyframe.setFraction(0.0f);
                    }
                }
                keyframeArr = new Keyframe[i2];
                arrayList.toArray(keyframeArr);
                for (i4 = 0; i4 < i2; i4++) {
                    keyframe = keyframeArr[i4];
                    if (keyframe.getFraction() >= 0.0f) {
                        if (i4 == 0) {
                            keyframe.setFraction(0.0f);
                        } else if (i4 != i2 - 1) {
                            next = i4 + 1;
                            size = i4;
                            while (next < i2 - 1) {
                                size = next;
                                next++;
                            }
                            m5714a(keyframeArr, keyframeArr[size + 1].getFraction() - keyframeArr[i4 - 1].getFraction(), i4, size);
                        } else {
                            keyframe.setFraction(1.0f);
                        }
                    }
                }
                ofKeyframe = PropertyValuesHolder.ofKeyframe(str, keyframeArr);
                if (i3 == 3) {
                    return ofKeyframe;
                }
                ofKeyframe.setEvaluator(bw.hk());
                return ofKeyframe;
            }
        }
        return null;
    }

    private static Keyframe m5706a(Keyframe keyframe, float f) {
        if (keyframe.getType() == Float.TYPE) {
            return Keyframe.ofFloat(f);
        }
        if (keyframe.getType() == Integer.TYPE) {
            return Keyframe.ofInt(f);
        }
        return Keyframe.ofObject(f);
    }

    private static void m5714a(Keyframe[] keyframeArr, float f, int i, int i2) {
        float f2 = f / ((float) ((i2 - i) + 2));
        while (i <= i2) {
            keyframeArr[i].setFraction(keyframeArr[i - 1].getFraction() + f2);
            i++;
        }
    }

    private static Keyframe m5707a(Context context, Resources resources, Theme theme, AttributeSet attributeSet, int i, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        TypedArray a = bz.m5835a(resources, theme, attributeSet, br.DB);
        Keyframe keyframe = null;
        float a2 = bz.m5833a(a, xmlPullParser, "fraction", 3, -1.0f);
        TypedValue b = bz.m5840b(a, xmlPullParser, "value", 0);
        int i2 = b != null ? 1 : 0;
        if (i == 4) {
            if (i2 == 0 || !au(b.type)) {
                i = 0;
            } else {
                i = 3;
            }
        }
        if (i2 != 0) {
            switch (i) {
                case 0:
                    keyframe = Keyframe.ofFloat(a2, bz.m5833a(a, xmlPullParser, "value", 0, 0.0f));
                    break;
                case 1:
                case 3:
                    keyframe = Keyframe.ofInt(a2, bz.m5834a(a, xmlPullParser, "value", 0, 0));
                    break;
            }
        } else if (i == 0) {
            keyframe = Keyframe.ofFloat(a2);
        } else {
            keyframe = Keyframe.ofInt(a2);
        }
        int c = bz.m5841c(a, xmlPullParser, "interpolator", 1, 0);
        if (c > 0) {
            keyframe.setInterpolator(bu.loadInterpolator(context, c));
        }
        a.recycle();
        return keyframe;
    }

    private static ObjectAnimator m5708a(Context context, Resources resources, Theme theme, AttributeSet attributeSet, float f, XmlPullParser xmlPullParser) throws NotFoundException {
        ValueAnimator objectAnimator = new ObjectAnimator();
        m5711a(context, resources, theme, attributeSet, objectAnimator, f, xmlPullParser);
        return objectAnimator;
    }

    private static ValueAnimator m5711a(Context context, Resources resources, Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f, XmlPullParser xmlPullParser) throws NotFoundException {
        TypedArray a = bz.m5835a(resources, theme, attributeSet, br.Dy);
        TypedArray a2 = bz.m5835a(resources, theme, attributeSet, br.DC);
        if (valueAnimator == null) {
            valueAnimator = new ValueAnimator();
        }
        m5713a(valueAnimator, a, a2, f, xmlPullParser);
        int c = bz.m5841c(a, xmlPullParser, "interpolator", 0, 0);
        if (c > 0) {
            valueAnimator.setInterpolator(bu.loadInterpolator(context, c));
        }
        a.recycle();
        if (a2 != null) {
            a2.recycle();
        }
        return valueAnimator;
    }

    private static boolean au(int i) {
        return i >= 28 && i <= 31;
    }
}
