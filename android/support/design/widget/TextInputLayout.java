package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.widget.Space;
import android.support.v7.widget.AppCompatTextView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AccelerateInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.fossil.ag.C1622c;
import com.fossil.ag.C1625f;
import com.fossil.ag.C1627h;
import com.fossil.ag.C1628i;
import com.fossil.ag.C1629j;
import com.fossil.ag.C1630k;
import com.fossil.aq;
import com.fossil.aw;
import com.fossil.ay;
import com.fossil.bi;
import com.fossil.bj;
import com.fossil.bj.C1073c;
import com.fossil.bm;
import com.fossil.bp;
import com.fossil.gn;
import com.fossil.hh;
import com.fossil.ix;
import com.fossil.iy;
import com.fossil.jy;
import com.fossil.jz;
import com.fossil.li;
import com.fossil.me;
import com.fossil.ml;
import com.fossil.oi;
import com.fossil.pk.i;
import com.fossil.pn;
import com.fossil.rg;
import com.fossil.rv;
import com.fossil.sw;

public class TextInputLayout extends LinearLayout {
    private bj Ay;
    private Drawable CA;
    private ColorStateList CB;
    private boolean CC;
    private Mode CD;
    private boolean CF;
    private ColorStateList CG;
    private ColorStateList CH;
    private boolean CI;
    private boolean CJ;
    private boolean CK;
    private boolean CL;
    private boolean CM;
    private final FrameLayout Cb;
    EditText Cc;
    private boolean Cd;
    private CharSequence Ce;
    private Paint Cf;
    private LinearLayout Cg;
    private int Ch;
    private Typeface Ci;
    private boolean Cj;
    TextView Ck;
    private int Cl;
    private boolean Cm;
    private CharSequence Cn;
    boolean Co;
    private TextView Cp;
    private int Cq;
    private int Cr;
    private int Cs;
    private boolean Ct;
    private boolean Cu;
    private Drawable Cv;
    private CharSequence Cw;
    private CheckableImageButton Cx;
    private boolean Cy;
    private Drawable Cz;
    private final Rect xL;
    final aw xM;

    class C11231 implements TextWatcher {
        final /* synthetic */ TextInputLayout CN;

        C11231(TextInputLayout textInputLayout) {
            this.CN = textInputLayout;
        }

        public void afterTextChanged(Editable editable) {
            this.CN.m1973r(!this.CN.CM);
            if (this.CN.Co) {
                this.CN.as(editable.length());
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    class C11242 extends me {
        final /* synthetic */ TextInputLayout CN;

        C11242(TextInputLayout textInputLayout) {
            this.CN = textInputLayout;
        }

        public void mo81e(View view) {
            view.setVisibility(0);
        }
    }

    class C11264 implements OnClickListener {
        final /* synthetic */ TextInputLayout CN;

        C11264(TextInputLayout textInputLayout) {
            this.CN = textInputLayout;
        }

        public void onClick(View view) {
            this.CN.gS();
        }
    }

    class C11275 implements C1073c {
        final /* synthetic */ TextInputLayout CN;

        C11275(TextInputLayout textInputLayout) {
            this.CN = textInputLayout;
        }

        public void mo14a(bj bjVar) {
            this.CN.xM.m4633j(bjVar.gX());
        }
    }

    static class C1129a extends jy {
        public static final Creator<C1129a> CREATOR = ix.m11854a(new C11281());
        CharSequence CP;

        static class C11281 implements iy<C1129a> {
            C11281() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return m1962h(parcel, classLoader);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return at(i);
            }

            public C1129a m1962h(Parcel parcel, ClassLoader classLoader) {
                return new C1129a(parcel, classLoader);
            }

            public C1129a[] at(int i) {
                return new C1129a[i];
            }
        }

        C1129a(Parcelable parcelable) {
            super(parcelable);
        }

        C1129a(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.CP = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.CP, parcel, i);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + this.CP + "}";
        }
    }

    class C1130b extends jz {
        final /* synthetic */ TextInputLayout CN;

        C1130b(TextInputLayout textInputLayout) {
            this.CN = textInputLayout;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(TextInputLayout.class.getSimpleName());
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            CharSequence text = this.CN.xM.getText();
            if (!TextUtils.isEmpty(text)) {
                accessibilityEvent.getText().add(text);
            }
        }

        public void mo2a(View view, ml mlVar) {
            super.mo2a(view, mlVar);
            mlVar.setClassName(TextInputLayout.class.getSimpleName());
            CharSequence text = this.CN.xM.getText();
            if (!TextUtils.isEmpty(text)) {
                mlVar.setText(text);
            }
            if (this.CN.Cc != null) {
                mlVar.setLabelFor(this.CN.Cc);
            }
            text = this.CN.Ck != null ? this.CN.Ck.getText() : null;
            if (!TextUtils.isEmpty(text)) {
                mlVar.setContentInvalid(true);
                mlVar.setError(text);
            }
        }
    }

    public TextInputLayout(Context context) {
        this(context, null);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.xL = new Rect();
        this.xM = new aw(this);
        bi.m5190g(context);
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        this.Cb = new FrameLayout(context);
        this.Cb.setAddStatesFromChildren(true);
        addView(this.Cb);
        this.xM.m4624a(aq.vc);
        this.xM.m4627b(new AccelerateInterpolator());
        this.xM.m4620T(8388659);
        sw a = sw.a(context, attributeSet, C1630k.TextInputLayout, i, C1629j.Widget_Design_TextInputLayout);
        this.Cd = a.getBoolean(C1630k.TextInputLayout_hintEnabled, true);
        setHint(a.getText(C1630k.TextInputLayout_android_hint));
        this.CJ = a.getBoolean(C1630k.TextInputLayout_hintAnimationEnabled, true);
        if (a.hasValue(C1630k.TextInputLayout_android_textColorHint)) {
            ColorStateList colorStateList = a.getColorStateList(C1630k.TextInputLayout_android_textColorHint);
            this.CH = colorStateList;
            this.CG = colorStateList;
        }
        if (a.getResourceId(C1630k.TextInputLayout_hintTextAppearance, -1) != -1) {
            setHintTextAppearance(a.getResourceId(C1630k.TextInputLayout_hintTextAppearance, 0));
        }
        this.Cl = a.getResourceId(C1630k.TextInputLayout_errorTextAppearance, 0);
        boolean z = a.getBoolean(C1630k.TextInputLayout_errorEnabled, false);
        boolean z2 = a.getBoolean(C1630k.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(a.getInt(C1630k.TextInputLayout_counterMaxLength, -1));
        this.Cr = a.getResourceId(C1630k.TextInputLayout_counterTextAppearance, 0);
        this.Cs = a.getResourceId(C1630k.TextInputLayout_counterOverflowTextAppearance, 0);
        this.Cu = a.getBoolean(C1630k.TextInputLayout_passwordToggleEnabled, false);
        this.Cv = a.getDrawable(C1630k.TextInputLayout_passwordToggleDrawable);
        this.Cw = a.getText(C1630k.TextInputLayout_passwordToggleContentDescription);
        if (a.hasValue(C1630k.TextInputLayout_passwordToggleTint)) {
            this.CC = true;
            this.CB = a.getColorStateList(C1630k.TextInputLayout_passwordToggleTint);
        }
        if (a.hasValue(C1630k.TextInputLayout_passwordToggleTintMode)) {
            this.CF = true;
            this.CD = bp.m5449a(a.getInt(C1630k.TextInputLayout_passwordToggleTintMode, -1), null);
        }
        a.recycle();
        setErrorEnabled(z);
        setCounterEnabled(z2);
        gV();
        if (li.m12232P(this) == 0) {
            li.m12272n(this, 1);
        }
        li.m12249a((View) this, new C1130b(this));
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (view instanceof EditText) {
            LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & -113) | 16;
            this.Cb.addView(view, layoutParams2);
            this.Cb.setLayoutParams(layoutParams);
            gN();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i, layoutParams);
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.Ci) {
            this.Ci = typeface;
            this.xM.m4630c(typeface);
            if (this.Cp != null) {
                this.Cp.setTypeface(typeface);
            }
            if (this.Ck != null) {
                this.Ck.setTypeface(typeface);
            }
        }
    }

    public Typeface getTypeface() {
        return this.Ci;
    }

    private void setEditText(EditText editText) {
        if (this.Cc != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (!(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.Cc = editText;
        if (!gT()) {
            this.xM.m4630c(this.Cc.getTypeface());
        }
        this.xM.m4632i(this.Cc.getTextSize());
        int gravity = this.Cc.getGravity();
        this.xM.m4620T((gravity & -113) | 48);
        this.xM.m4619S(gravity);
        this.Cc.addTextChangedListener(new C11231(this));
        if (this.CG == null) {
            this.CG = this.Cc.getHintTextColors();
        }
        if (this.Cd && TextUtils.isEmpty(this.Ce)) {
            setHint(this.Cc.getHint());
            this.Cc.setHint(null);
        }
        if (this.Cp != null) {
            as(this.Cc.getText().length());
        }
        if (this.Cg != null) {
            gO();
        }
        gR();
        m1972c(false, true);
    }

    private void gN() {
        int i;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Cb.getLayoutParams();
        if (this.Cd) {
            if (this.Cf == null) {
                this.Cf = new Paint();
            }
            this.Cf.setTypeface(this.xM.fx());
            this.Cf.setTextSize(this.xM.fA());
            i = (int) (-this.Cf.ascent());
        } else {
            i = 0;
        }
        if (i != layoutParams.topMargin) {
            layoutParams.topMargin = i;
            this.Cb.requestLayout();
        }
    }

    void m1973r(boolean z) {
        m1972c(z, false);
    }

    void m1972c(boolean z, boolean z2) {
        Object obj = 1;
        boolean isEnabled = isEnabled();
        Object obj2 = (this.Cc == null || TextUtils.isEmpty(this.Cc.getText())) ? null : 1;
        boolean a = m1969a(getDrawableState(), 16842908);
        if (TextUtils.isEmpty(getError())) {
            obj = null;
        }
        if (this.CG != null) {
            this.xM.m4629c(this.CG);
        }
        if (isEnabled && this.Ct && this.Cp != null) {
            this.xM.m4625b(this.Cp.getTextColors());
        } else if (isEnabled && a && this.CH != null) {
            this.xM.m4625b(this.CH);
        } else if (this.CG != null) {
            this.xM.m4625b(this.CG);
        }
        if (obj2 != null || (isEnabled() && (a || r1 != null))) {
            if (z2 || this.CI) {
                m1970s(z);
            }
        } else if (z2 || !this.CI) {
            m1971t(z);
        }
    }

    public EditText getEditText() {
        return this.Cc;
    }

    public void setHint(CharSequence charSequence) {
        if (this.Cd) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    private void setHintInternal(CharSequence charSequence) {
        this.Ce = charSequence;
        this.xM.setText(charSequence);
    }

    public CharSequence getHint() {
        return this.Cd ? this.Ce : null;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.Cd) {
            this.Cd = z;
            CharSequence hint = this.Cc.getHint();
            if (!this.Cd) {
                if (!TextUtils.isEmpty(this.Ce) && TextUtils.isEmpty(hint)) {
                    this.Cc.setHint(this.Ce);
                }
                setHintInternal(null);
            } else if (!TextUtils.isEmpty(hint)) {
                if (TextUtils.isEmpty(this.Ce)) {
                    setHint(hint);
                }
                this.Cc.setHint(null);
            }
            if (this.Cc != null) {
                gN();
            }
        }
    }

    public void setHintTextAppearance(int i) {
        this.xM.m4621U(i);
        this.CH = this.xM.fI();
        if (this.Cc != null) {
            m1973r(false);
            gN();
        }
    }

    private void m1966a(TextView textView, int i) {
        if (this.Cg == null) {
            this.Cg = new LinearLayout(getContext());
            this.Cg.setOrientation(0);
            addView(this.Cg, -1, -2);
            this.Cg.addView(new Space(getContext()), new LinearLayout.LayoutParams(0, 0, 1.0f));
            if (this.Cc != null) {
                gO();
            }
        }
        this.Cg.setVisibility(0);
        this.Cg.addView(textView, i);
        this.Ch++;
    }

    private void gO() {
        li.m12261e(this.Cg, li.m12240X(this.Cc), 0, li.m12241Y(this.Cc), this.Cc.getPaddingBottom());
    }

    private void m1965a(TextView textView) {
        if (this.Cg != null) {
            this.Cg.removeView(textView);
            int i = this.Ch - 1;
            this.Ch = i;
            if (i == 0) {
                this.Cg.setVisibility(8);
            }
        }
    }

    public void setErrorEnabled(boolean z) {
        if (this.Cj != z) {
            if (this.Ck != null) {
                li.ae(this.Ck).cancel();
            }
            if (z) {
                int i;
                this.Ck = new AppCompatTextView(getContext());
                this.Ck.setId(C1625f.textinput_error);
                if (this.Ci != null) {
                    this.Ck.setTypeface(this.Ci);
                }
                try {
                    oi.b(this.Ck, this.Cl);
                    if (VERSION.SDK_INT < 23 || this.Ck.getTextColors().getDefaultColor() != -65281) {
                        boolean z2 = false;
                    } else {
                        i = 1;
                    }
                } catch (Exception e) {
                    i = 1;
                }
                if (i != 0) {
                    oi.b(this.Ck, i.TextAppearance_AppCompat_Caption);
                    this.Ck.setTextColor(gn.m10634e(getContext(), C1622c.design_textinput_error_color_light));
                }
                this.Ck.setVisibility(4);
                li.m12273o(this.Ck, 1);
                m1966a(this.Ck, 0);
            } else {
                this.Cm = false;
                gP();
                m1965a(this.Ck);
                this.Ck = null;
            }
            this.Cj = z;
        }
    }

    public void setErrorTextAppearance(int i) {
        this.Cl = i;
        if (this.Ck != null) {
            oi.b(this.Ck, i);
        }
    }

    public void setError(CharSequence charSequence) {
        boolean z = li.as(this) && isEnabled() && (this.Ck == null || !TextUtils.equals(this.Ck.getText(), charSequence));
        m1967a(charSequence, z);
    }

    private void m1967a(final CharSequence charSequence, boolean z) {
        boolean z2 = true;
        this.Cn = charSequence;
        if (!this.Cj) {
            if (!TextUtils.isEmpty(charSequence)) {
                setErrorEnabled(true);
            } else {
                return;
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            z2 = false;
        }
        this.Cm = z2;
        li.ae(this.Ck).cancel();
        if (this.Cm) {
            this.Ck.setText(charSequence);
            this.Ck.setVisibility(0);
            if (z) {
                if (li.m12233Q(this.Ck) == 1.0f) {
                    li.m12264g(this.Ck, 0.0f);
                }
                li.ae(this.Ck).m12420y(1.0f).m12418n(200).m12417c(aq.ve).m12415a(new C11242(this)).start();
            } else {
                li.m12264g(this.Ck, 1.0f);
            }
        } else if (this.Ck.getVisibility() == 0) {
            if (z) {
                li.ae(this.Ck).m12420y(0.0f).m12418n(200).m12417c(aq.vd).m12415a(new me(this) {
                    final /* synthetic */ TextInputLayout CN;

                    public void mo82f(View view) {
                        this.CN.Ck.setText(charSequence);
                        view.setVisibility(4);
                    }
                }).start();
            } else {
                this.Ck.setText(charSequence);
                this.Ck.setVisibility(4);
            }
        }
        gP();
        m1973r(z);
    }

    public void setCounterEnabled(boolean z) {
        if (this.Co != z) {
            if (z) {
                this.Cp = new AppCompatTextView(getContext());
                this.Cp.setId(C1625f.textinput_counter);
                if (this.Ci != null) {
                    this.Cp.setTypeface(this.Ci);
                }
                this.Cp.setMaxLines(1);
                try {
                    oi.b(this.Cp, this.Cr);
                } catch (Exception e) {
                    oi.b(this.Cp, i.TextAppearance_AppCompat_Caption);
                    this.Cp.setTextColor(gn.m10634e(getContext(), C1622c.design_textinput_error_color_light));
                }
                m1966a(this.Cp, -1);
                if (this.Cc == null) {
                    as(0);
                } else {
                    as(this.Cc.getText().length());
                }
            } else {
                m1965a(this.Cp);
                this.Cp = null;
            }
            this.Co = z;
        }
    }

    public void setCounterMaxLength(int i) {
        if (this.Cq != i) {
            if (i > 0) {
                this.Cq = i;
            } else {
                this.Cq = -1;
            }
            if (this.Co) {
                as(this.Cc == null ? 0 : this.Cc.getText().length());
            }
        }
    }

    public void setEnabled(boolean z) {
        m1964a((ViewGroup) this, z);
        super.setEnabled(z);
    }

    private static void m1964a(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                m1964a((ViewGroup) childAt, z);
            }
        }
    }

    public int getCounterMaxLength() {
        return this.Cq;
    }

    void as(int i) {
        boolean z = this.Ct;
        if (this.Cq == -1) {
            this.Cp.setText(String.valueOf(i));
            this.Ct = false;
        } else {
            this.Ct = i > this.Cq;
            if (z != this.Ct) {
                oi.b(this.Cp, this.Ct ? this.Cs : this.Cr);
            }
            this.Cp.setText(getContext().getString(C1628i.character_counter_pattern, new Object[]{Integer.valueOf(i), Integer.valueOf(this.Cq)}));
        }
        if (this.Cc != null && z != this.Ct) {
            m1973r(false);
            gP();
        }
    }

    private void gP() {
        if (this.Cc != null) {
            Drawable background = this.Cc.getBackground();
            if (background != null) {
                gQ();
                if (rv.v(background)) {
                    background = background.mutate();
                }
                if (this.Cm && this.Ck != null) {
                    background.setColorFilter(rg.c(this.Ck.getCurrentTextColor(), Mode.SRC_IN));
                } else if (!this.Ct || this.Cp == null) {
                    hh.m11634h(background);
                    this.Cc.refreshDrawableState();
                } else {
                    background.setColorFilter(rg.c(this.Cp.getCurrentTextColor(), Mode.SRC_IN));
                }
            }
        }
    }

    private void gQ() {
        int i = VERSION.SDK_INT;
        if (i == 21 || i == 22) {
            Drawable background = this.Cc.getBackground();
            if (background != null && !this.CK) {
                Drawable newDrawable = background.getConstantState().newDrawable();
                if (background instanceof DrawableContainer) {
                    this.CK = ay.m4691a((DrawableContainer) background, newDrawable.getConstantState());
                }
                if (!this.CK) {
                    li.m12248a(this.Cc, newDrawable);
                    this.CK = true;
                }
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        Parcelable c1129a = new C1129a(super.onSaveInstanceState());
        if (this.Cm) {
            c1129a.CP = getError();
        }
        return c1129a;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof C1129a) {
            C1129a c1129a = (C1129a) parcelable;
            super.onRestoreInstanceState(c1129a.getSuperState());
            setError(c1129a.CP);
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.CM = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.CM = false;
    }

    public CharSequence getError() {
        return this.Cj ? this.Cn : null;
    }

    public void setHintAnimationEnabled(boolean z) {
        this.CJ = z;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.Cd) {
            this.xM.draw(canvas);
        }
    }

    protected void onMeasure(int i, int i2) {
        gR();
        super.onMeasure(i, i2);
    }

    private void gR() {
        if (this.Cc != null) {
            Drawable[] c;
            if (gU()) {
                if (this.Cx == null) {
                    this.Cx = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(C1627h.design_text_input_password_icon, this.Cb, false);
                    this.Cx.setImageDrawable(this.Cv);
                    this.Cx.setContentDescription(this.Cw);
                    this.Cb.addView(this.Cx);
                    this.Cx.setOnClickListener(new C11264(this));
                }
                if (this.Cc != null && li.ad(this.Cc) <= 0) {
                    this.Cc.setMinimumHeight(li.ad(this.Cx));
                }
                this.Cx.setVisibility(0);
                this.Cx.setChecked(this.Cy);
                if (this.Cz == null) {
                    this.Cz = new ColorDrawable();
                }
                this.Cz.setBounds(0, 0, this.Cx.getMeasuredWidth(), 1);
                c = oi.c(this.Cc);
                if (c[2] != this.Cz) {
                    this.CA = c[2];
                }
                oi.a(this.Cc, c[0], c[1], this.Cz, c[3]);
                this.Cx.setPadding(this.Cc.getPaddingLeft(), this.Cc.getPaddingTop(), this.Cc.getPaddingRight(), this.Cc.getPaddingBottom());
                return;
            }
            if (this.Cx != null && this.Cx.getVisibility() == 0) {
                this.Cx.setVisibility(8);
            }
            if (this.Cz != null) {
                c = oi.c(this.Cc);
                if (c[2] == this.Cz) {
                    oi.a(this.Cc, c[0], c[1], this.CA, c[3]);
                    this.Cz = null;
                }
            }
        }
    }

    public void setPasswordVisibilityToggleDrawable(int i) {
        setPasswordVisibilityToggleDrawable(i != 0 ? pn.c(getContext(), i) : null);
    }

    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.Cv = drawable;
        if (this.Cx != null) {
            this.Cx.setImageDrawable(drawable);
        }
    }

    public void setPasswordVisibilityToggleContentDescription(int i) {
        setPasswordVisibilityToggleContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.Cw = charSequence;
        if (this.Cx != null) {
            this.Cx.setContentDescription(charSequence);
        }
    }

    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.Cv;
    }

    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.Cw;
    }

    public void setPasswordVisibilityToggleEnabled(boolean z) {
        if (this.Cu != z) {
            this.Cu = z;
            if (!(z || !this.Cy || this.Cc == null)) {
                this.Cc.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            this.Cy = false;
            gR();
        }
    }

    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.CB = colorStateList;
        this.CC = true;
        gV();
    }

    public void setPasswordVisibilityToggleTintMode(Mode mode) {
        this.CD = mode;
        this.CF = true;
        gV();
    }

    void gS() {
        if (this.Cu) {
            int selectionEnd = this.Cc.getSelectionEnd();
            if (gT()) {
                this.Cc.setTransformationMethod(null);
                this.Cy = true;
            } else {
                this.Cc.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.Cy = false;
            }
            this.Cx.setChecked(this.Cy);
            this.Cc.setSelection(selectionEnd);
        }
    }

    private boolean gT() {
        return this.Cc != null && (this.Cc.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    private boolean gU() {
        return this.Cu && (gT() || this.Cy);
    }

    private void gV() {
        if (this.Cv == null) {
            return;
        }
        if (this.CC || this.CF) {
            this.Cv = hh.m11635i(this.Cv).mutate();
            if (this.CC) {
                hh.m11623a(this.Cv, this.CB);
            }
            if (this.CF) {
                hh.m11626a(this.Cv, this.CD);
            }
            if (this.Cx != null && this.Cx.getDrawable() != this.Cv) {
                this.Cx.setImageDrawable(this.Cv);
            }
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.Cd && this.Cc != null) {
            Rect rect = this.xL;
            bm.m5287b(this, this.Cc, rect);
            int compoundPaddingLeft = rect.left + this.Cc.getCompoundPaddingLeft();
            int compoundPaddingRight = rect.right - this.Cc.getCompoundPaddingRight();
            this.xM.m4628c(compoundPaddingLeft, rect.top + this.Cc.getCompoundPaddingTop(), compoundPaddingRight, rect.bottom - this.Cc.getCompoundPaddingBottom());
            this.xM.m4631d(compoundPaddingLeft, getPaddingTop(), compoundPaddingRight, (i4 - i2) - getPaddingBottom());
            this.xM.fG();
        }
    }

    private void m1970s(boolean z) {
        if (this.Ay != null && this.Ay.isRunning()) {
            this.Ay.cancel();
        }
        if (z && this.CJ) {
            m1974u(1.0f);
        } else {
            this.xM.m4633j(1.0f);
        }
        this.CI = false;
    }

    protected void drawableStateChanged() {
        boolean z = true;
        if (!this.CL) {
            int state;
            this.CL = true;
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            if (!(li.as(this) && isEnabled())) {
                z = false;
            }
            m1973r(z);
            gP();
            if (this.xM != null) {
                state = this.xM.setState(drawableState) | 0;
            } else {
                state = 0;
            }
            if (state != 0) {
                invalidate();
            }
            this.CL = false;
        }
    }

    private void m1971t(boolean z) {
        if (this.Ay != null && this.Ay.isRunning()) {
            this.Ay.cancel();
        }
        if (z && this.CJ) {
            m1974u(0.0f);
        } else {
            this.xM.m4633j(0.0f);
        }
        this.CI = true;
    }

    void m1974u(float f) {
        if (this.xM.fz() != f) {
            if (this.Ay == null) {
                this.Ay = bp.ha();
                this.Ay.setInterpolator(aq.vb);
                this.Ay.setDuration(200);
                this.Ay.m5222a(new C11275(this));
            }
            this.Ay.m5223d(this.xM.fz(), f);
            this.Ay.start();
        }
    }

    private static boolean m1969a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }
}
