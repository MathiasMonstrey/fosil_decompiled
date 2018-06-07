package com.fossil;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatCheckedTextView;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatMultiAutoCompleteTextView;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.AppCompatSeekBar;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.View;
import android.view.View.OnClickListener;
import com.fossil.pk.C3991j;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;

class pe {
    private static final Class<?>[] acA = new Class[]{Context.class, AttributeSet.class};
    private static final int[] acB = new int[]{16843375};
    private static final Map<String, Constructor<? extends View>> acC = new jl();
    private static final String[] sClassPrefixList = new String[]{"android.widget.", "android.view.", "android.webkit."};
    private final Object[] acD = new Object[2];

    static class C3970a implements OnClickListener {
        private final View acE;
        private final String acF;
        private Method acG;
        private Context acH;

        public C3970a(View view, String str) {
            this.acE = view;
            this.acF = str;
        }

        public void onClick(View view) {
            if (this.acG == null) {
                m13035c(this.acE.getContext(), this.acF);
            }
            try {
                this.acG.invoke(this.acH, new Object[]{view});
            } catch (Throwable e) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
            } catch (Throwable e2) {
                throw new IllegalStateException("Could not execute method for android:onClick", e2);
            }
        }

        private void m13035c(Context context, String str) {
            String str2;
            Context context2 = context;
            while (context2 != null) {
                try {
                    if (!context2.isRestricted()) {
                        Method method = context2.getClass().getMethod(this.acF, new Class[]{View.class});
                        if (method != null) {
                            this.acG = method;
                            this.acH = context2;
                            return;
                        }
                    }
                } catch (NoSuchMethodException e) {
                }
                if (context2 instanceof ContextWrapper) {
                    context2 = ((ContextWrapper) context2).getBaseContext();
                } else {
                    context2 = null;
                }
            }
            int id = this.acE.getId();
            if (id == -1) {
                str2 = "";
            } else {
                str2 = " with id '" + this.acE.getContext().getResources().getResourceEntryName(id) + "'";
            }
            throw new IllegalStateException("Could not find method " + this.acF + "(View) in a parent or ancestor Context for android:onClick " + "attribute defined on view " + this.acE.getClass() + str2);
        }
    }

    pe() {
    }

    public final View m13040a(View view, String str, Context context, AttributeSet attributeSet, boolean z, boolean z2, boolean z3, boolean z4) {
        Context context2;
        View view2;
        if (!z || view == null) {
            context2 = context;
        } else {
            context2 = view.getContext();
        }
        if (z2 || z3) {
            context2 = m13036a(context2, attributeSet, z2, z3);
        }
        if (z4) {
            context2 = st.m13579C(context2);
        }
        View view3 = null;
        Object obj = -1;
        switch (str.hashCode()) {
            case -1946472170:
                if (str.equals("RatingBar")) {
                    obj = 11;
                    break;
                }
                break;
            case -1455429095:
                if (str.equals("CheckedTextView")) {
                    obj = 8;
                    break;
                }
                break;
            case -1346021293:
                if (str.equals("MultiAutoCompleteTextView")) {
                    obj = 10;
                    break;
                }
                break;
            case -938935918:
                if (str.equals("TextView")) {
                    obj = null;
                    break;
                }
                break;
            case -937446323:
                if (str.equals("ImageButton")) {
                    obj = 5;
                    break;
                }
                break;
            case -658531749:
                if (str.equals("SeekBar")) {
                    obj = 12;
                    break;
                }
                break;
            case -339785223:
                if (str.equals("Spinner")) {
                    obj = 4;
                    break;
                }
                break;
            case 776382189:
                if (str.equals("RadioButton")) {
                    obj = 7;
                    break;
                }
                break;
            case 1125864064:
                if (str.equals("ImageView")) {
                    obj = 1;
                    break;
                }
                break;
            case 1413872058:
                if (str.equals("AutoCompleteTextView")) {
                    obj = 9;
                    break;
                }
                break;
            case 1601505219:
                if (str.equals("CheckBox")) {
                    obj = 6;
                    break;
                }
                break;
            case 1666676343:
                if (str.equals("EditText")) {
                    obj = 3;
                    break;
                }
                break;
            case 2001146706:
                if (str.equals("Button")) {
                    obj = 2;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                view3 = new AppCompatTextView(context2, attributeSet);
                break;
            case 1:
                view3 = new AppCompatImageView(context2, attributeSet);
                break;
            case 2:
                view3 = new AppCompatButton(context2, attributeSet);
                break;
            case 3:
                view3 = new AppCompatEditText(context2, attributeSet);
                break;
            case 4:
                view3 = new AppCompatSpinner(context2, attributeSet);
                break;
            case 5:
                view3 = new AppCompatImageButton(context2, attributeSet);
                break;
            case 6:
                view3 = new AppCompatCheckBox(context2, attributeSet);
                break;
            case 7:
                view3 = new AppCompatRadioButton(context2, attributeSet);
                break;
            case 8:
                view3 = new AppCompatCheckedTextView(context2, attributeSet);
                break;
            case 9:
                view3 = new AppCompatAutoCompleteTextView(context2, attributeSet);
                break;
            case 10:
                view3 = new AppCompatMultiAutoCompleteTextView(context2, attributeSet);
                break;
            case 11:
                view3 = new AppCompatRatingBar(context2, attributeSet);
                break;
            case 12:
                view3 = new AppCompatSeekBar(context2, attributeSet);
                break;
        }
        if (view3 != null || context == context2) {
            view2 = view3;
        } else {
            view2 = m13037a(context2, str, attributeSet);
        }
        if (view2 != null) {
            m13038a(view2, attributeSet);
        }
        return view2;
    }

    private View m13037a(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            this.acD[0] = context;
            this.acD[1] = attributeSet;
            View b;
            if (-1 == str.indexOf(46)) {
                for (String b2 : sClassPrefixList) {
                    b = m13039b(context, str, b2);
                    if (b != null) {
                        return b;
                    }
                }
                this.acD[0] = null;
                this.acD[1] = null;
                return null;
            }
            b = m13039b(context, str, null);
            this.acD[0] = null;
            this.acD[1] = null;
            return b;
        } catch (Exception e) {
            return null;
        } finally {
            this.acD[0] = null;
            this.acD[1] = null;
        }
    }

    private void m13038a(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if (!(context instanceof ContextWrapper)) {
            return;
        }
        if (VERSION.SDK_INT < 15 || li.av(view)) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, acB);
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                view.setOnClickListener(new C3970a(view, string));
            }
            obtainStyledAttributes.recycle();
        }
    }

    private View m13039b(Context context, String str, String str2) throws ClassNotFoundException, InflateException {
        Constructor constructor = (Constructor) acC.get(str);
        if (constructor == null) {
            try {
                constructor = context.getClassLoader().loadClass(str2 != null ? str2 + str : str).asSubclass(View.class).getConstructor(acA);
                acC.put(str, constructor);
            } catch (Exception e) {
                return null;
            }
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.acD);
    }

    private static Context m13036a(Context context, AttributeSet attributeSet, boolean z, boolean z2) {
        int resourceId;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C3991j.View, 0, 0);
        if (z) {
            resourceId = obtainStyledAttributes.getResourceId(C3991j.View_android_theme, 0);
        } else {
            resourceId = 0;
        }
        if (z2 && r0 == 0) {
            resourceId = obtainStyledAttributes.getResourceId(C3991j.View_theme, 0);
            if (resourceId != 0) {
                Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
            }
        }
        int i = resourceId;
        obtainStyledAttributes.recycle();
        if (i == 0) {
            return context;
        }
        if ((context instanceof pw) && ((pw) context).mp() == i) {
            return context;
        }
        return new pw(context, i);
    }
}
