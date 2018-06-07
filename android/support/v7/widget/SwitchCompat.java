package android.support.v7.widget;

import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import com.fossil.hh;
import com.fossil.ks;
import com.fossil.li;
import com.fossil.pk.a;
import com.fossil.pk.j;
import com.fossil.pn;
import com.fossil.pr;
import com.fossil.rv;
import com.fossil.sw;
import com.fossil.tb;

@TargetApi(14)
public class SwitchCompat extends CompoundButton {
    private static final Property<SwitchCompat, Float> auh = new Property<SwitchCompat, Float>(Float.class, "thumbPos") {
        public /* synthetic */ Object get(Object obj) {
            return m2575b((SwitchCompat) obj);
        }

        public /* synthetic */ void set(Object obj, Object obj2) {
            m2574a((SwitchCompat) obj, (Float) obj2);
        }

        public Float m2575b(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.auC);
        }

        public void m2574a(SwitchCompat switchCompat, Float f) {
            switchCompat.setThumbPosition(f.floatValue());
        }
    };
    private static final int[] tH = new int[]{16842912};
    private int aqc;
    private float auA;
    private float auB;
    private float auC;
    private int auD;
    private int auE;
    private int auF;
    private int auG;
    private int auH;
    private int auI;
    private int auJ;
    private ColorStateList auK;
    private Layout auL;
    private Layout auM;
    private TransformationMethod auN;
    ObjectAnimator auO;
    private Drawable aui;
    private ColorStateList auj;
    private Mode auk;
    private boolean aul;
    private boolean aum;
    private Drawable aun;
    private ColorStateList auo;
    private Mode aup;
    private boolean auq;
    private boolean aur;
    private int aus;
    private int aut;
    private int auu;
    private boolean auv;
    private CharSequence auw;
    private CharSequence aux;
    private boolean auy;
    private int auz;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private final Rect uU;
    private TextPaint xr;

    public SwitchCompat(Context context) {
        this(context, null);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.switchStyle);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.auj = null;
        this.auk = null;
        this.aul = false;
        this.aum = false;
        this.auo = null;
        this.aup = null;
        this.auq = false;
        this.aur = false;
        this.mVelocityTracker = VelocityTracker.obtain();
        this.uU = new Rect();
        this.xr = new TextPaint(1);
        Resources resources = getResources();
        this.xr.density = resources.getDisplayMetrics().density;
        sw a = sw.a(context, attributeSet, j.SwitchCompat, i, 0);
        this.aui = a.getDrawable(j.SwitchCompat_android_thumb);
        if (this.aui != null) {
            this.aui.setCallback(this);
        }
        this.aun = a.getDrawable(j.SwitchCompat_track);
        if (this.aun != null) {
            this.aun.setCallback(this);
        }
        this.auw = a.getText(j.SwitchCompat_android_textOn);
        this.aux = a.getText(j.SwitchCompat_android_textOff);
        this.auy = a.getBoolean(j.SwitchCompat_showText, true);
        this.aus = a.getDimensionPixelSize(j.SwitchCompat_thumbTextPadding, 0);
        this.aut = a.getDimensionPixelSize(j.SwitchCompat_switchMinWidth, 0);
        this.auu = a.getDimensionPixelSize(j.SwitchCompat_switchPadding, 0);
        this.auv = a.getBoolean(j.SwitchCompat_splitTrack, false);
        ColorStateList colorStateList = a.getColorStateList(j.SwitchCompat_thumbTint);
        if (colorStateList != null) {
            this.auj = colorStateList;
            this.aul = true;
        }
        Mode a2 = rv.a(a.getInt(j.SwitchCompat_thumbTintMode, -1), null);
        if (this.auk != a2) {
            this.auk = a2;
            this.aum = true;
        }
        if (this.aul || this.aum) {
            sq();
        }
        colorStateList = a.getColorStateList(j.SwitchCompat_trackTint);
        if (colorStateList != null) {
            this.auo = colorStateList;
            this.auq = true;
        }
        a2 = rv.a(a.getInt(j.SwitchCompat_trackTintMode, -1), null);
        if (this.aup != a2) {
            this.aup = a2;
            this.aur = true;
        }
        if (this.auq || this.aur) {
            sp();
        }
        int resourceId = a.getResourceId(j.SwitchCompat_switchTextAppearance, 0);
        if (resourceId != 0) {
            setSwitchTextAppearance(context, resourceId);
        }
        a.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.aqc = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    public void setSwitchTextAppearance(Context context, int i) {
        sw a = sw.a(context, i, j.TextAppearance);
        ColorStateList colorStateList = a.getColorStateList(j.TextAppearance_android_textColor);
        if (colorStateList != null) {
            this.auK = colorStateList;
        } else {
            this.auK = getTextColors();
        }
        int dimensionPixelSize = a.getDimensionPixelSize(j.TextAppearance_android_textSize, 0);
        if (!(dimensionPixelSize == 0 || ((float) dimensionPixelSize) == this.xr.getTextSize())) {
            this.xr.setTextSize((float) dimensionPixelSize);
            requestLayout();
        }
        aT(a.getInt(j.TextAppearance_android_typeface, -1), a.getInt(j.TextAppearance_android_textStyle, -1));
        if (a.getBoolean(j.TextAppearance_textAllCaps, false)) {
            this.auN = new pr(getContext());
        } else {
            this.auN = null;
        }
        a.recycle();
    }

    private void aT(int i, int i2) {
        Typeface typeface = null;
        switch (i) {
            case 1:
                typeface = Typeface.SANS_SERIF;
                break;
            case 2:
                typeface = Typeface.SERIF;
                break;
            case 3:
                typeface = Typeface.MONOSPACE;
                break;
        }
        setSwitchTypeface(typeface, i2);
    }

    public void setSwitchTypeface(Typeface typeface, int i) {
        boolean z = false;
        if (i > 0) {
            Typeface defaultFromStyle;
            int style;
            float f;
            if (typeface == null) {
                defaultFromStyle = Typeface.defaultFromStyle(i);
            } else {
                defaultFromStyle = Typeface.create(typeface, i);
            }
            setSwitchTypeface(defaultFromStyle);
            if (defaultFromStyle != null) {
                style = defaultFromStyle.getStyle();
            } else {
                style = 0;
            }
            style = (style ^ -1) & i;
            TextPaint textPaint = this.xr;
            if ((style & 1) != 0) {
                z = true;
            }
            textPaint.setFakeBoldText(z);
            TextPaint textPaint2 = this.xr;
            if ((style & 2) != 0) {
                f = -0.25f;
            } else {
                f = 0.0f;
            }
            textPaint2.setTextSkewX(f);
            return;
        }
        this.xr.setFakeBoldText(false);
        this.xr.setTextSkewX(0.0f);
        setSwitchTypeface(typeface);
    }

    public void setSwitchTypeface(Typeface typeface) {
        if (this.xr.getTypeface() != typeface) {
            this.xr.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public void setSwitchPadding(int i) {
        this.auu = i;
        requestLayout();
    }

    public int getSwitchPadding() {
        return this.auu;
    }

    public void setSwitchMinWidth(int i) {
        this.aut = i;
        requestLayout();
    }

    public int getSwitchMinWidth() {
        return this.aut;
    }

    public void setThumbTextPadding(int i) {
        this.aus = i;
        requestLayout();
    }

    public int getThumbTextPadding() {
        return this.aus;
    }

    public void setTrackDrawable(Drawable drawable) {
        if (this.aun != null) {
            this.aun.setCallback(null);
        }
        this.aun = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i) {
        setTrackDrawable(pn.c(getContext(), i));
    }

    public Drawable getTrackDrawable() {
        return this.aun;
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.auo = colorStateList;
        this.auq = true;
        sp();
    }

    public ColorStateList getTrackTintList() {
        return this.auo;
    }

    public void setTrackTintMode(Mode mode) {
        this.aup = mode;
        this.aur = true;
        sp();
    }

    public Mode getTrackTintMode() {
        return this.aup;
    }

    private void sp() {
        if (this.aun == null) {
            return;
        }
        if (this.auq || this.aur) {
            this.aun = this.aun.mutate();
            if (this.auq) {
                hh.m11623a(this.aun, this.auo);
            }
            if (this.aur) {
                hh.m11626a(this.aun, this.aup);
            }
            if (this.aun.isStateful()) {
                this.aun.setState(getDrawableState());
            }
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        if (this.aui != null) {
            this.aui.setCallback(null);
        }
        this.aui = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbResource(int i) {
        setThumbDrawable(pn.c(getContext(), i));
    }

    public Drawable getThumbDrawable() {
        return this.aui;
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.auj = colorStateList;
        this.aul = true;
        sq();
    }

    public ColorStateList getThumbTintList() {
        return this.auj;
    }

    public void setThumbTintMode(Mode mode) {
        this.auk = mode;
        this.aum = true;
        sq();
    }

    public Mode getThumbTintMode() {
        return this.auk;
    }

    private void sq() {
        if (this.aui == null) {
            return;
        }
        if (this.aul || this.aum) {
            this.aui = this.aui.mutate();
            if (this.aul) {
                hh.m11623a(this.aui, this.auj);
            }
            if (this.aum) {
                hh.m11626a(this.aui, this.auk);
            }
            if (this.aui.isStateful()) {
                this.aui.setState(getDrawableState());
            }
        }
    }

    public void setSplitTrack(boolean z) {
        this.auv = z;
        invalidate();
    }

    public boolean getSplitTrack() {
        return this.auv;
    }

    public CharSequence getTextOn() {
        return this.auw;
    }

    public void setTextOn(CharSequence charSequence) {
        this.auw = charSequence;
        requestLayout();
    }

    public CharSequence getTextOff() {
        return this.aux;
    }

    public void setTextOff(CharSequence charSequence) {
        this.aux = charSequence;
        requestLayout();
    }

    public void setShowText(boolean z) {
        if (this.auy != z) {
            this.auy = z;
            requestLayout();
        }
    }

    public boolean getShowText() {
        return this.auy;
    }

    public void onMeasure(int i, int i2) {
        int intrinsicWidth;
        int intrinsicHeight;
        int max;
        int i3 = 0;
        if (this.auy) {
            if (this.auL == null) {
                this.auL = m2580r(this.auw);
            }
            if (this.auM == null) {
                this.auM = m2580r(this.aux);
            }
        }
        Rect rect = this.uU;
        if (this.aui != null) {
            this.aui.getPadding(rect);
            intrinsicWidth = (this.aui.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.aui.getIntrinsicHeight();
        } else {
            intrinsicHeight = 0;
            intrinsicWidth = 0;
        }
        if (this.auy) {
            max = Math.max(this.auL.getWidth(), this.auM.getWidth()) + (this.aus * 2);
        } else {
            max = 0;
        }
        this.auF = Math.max(max, intrinsicWidth);
        if (this.aun != null) {
            this.aun.getPadding(rect);
            i3 = this.aun.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        max = rect.left;
        intrinsicWidth = rect.right;
        if (this.aui != null) {
            rect = rv.t(this.aui);
            max = Math.max(max, rect.left);
            intrinsicWidth = Math.max(intrinsicWidth, rect.right);
        }
        intrinsicWidth = Math.max(this.aut, intrinsicWidth + (max + (this.auF * 2)));
        intrinsicHeight = Math.max(i3, intrinsicHeight);
        this.auD = intrinsicWidth;
        this.auE = intrinsicHeight;
        super.onMeasure(i, i2);
        if (getMeasuredHeight() < intrinsicHeight) {
            setMeasuredDimension(li.m12237U(this), intrinsicHeight);
        }
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        Object obj = isChecked() ? this.auw : this.aux;
        if (obj != null) {
            accessibilityEvent.getText().add(obj);
        }
    }

    private Layout m2580r(CharSequence charSequence) {
        int ceil;
        CharSequence transformation = this.auN != null ? this.auN.getTransformation(charSequence, this) : charSequence;
        TextPaint textPaint = this.xr;
        if (transformation != null) {
            ceil = (int) Math.ceil((double) Layout.getDesiredWidth(transformation, this.xr));
        } else {
            ceil = 0;
        }
        return new StaticLayout(transformation, textPaint, ceil, Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    private boolean m2581t(float f, float f2) {
        if (this.aui == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.aui.getPadding(this.uU);
        int i = this.auH - this.mTouchSlop;
        thumbOffset = (thumbOffset + this.auG) - this.mTouchSlop;
        int i2 = (((this.auF + thumbOffset) + this.uU.left) + this.uU.right) + this.mTouchSlop;
        int i3 = this.auJ + this.mTouchSlop;
        if (f <= ((float) thumbOffset) || f >= ((float) i2) || f2 <= ((float) i) || f2 >= ((float) i3)) {
            return false;
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.mVelocityTracker.addMovement(motionEvent);
        float x;
        float y;
        switch (ks.m12043a(motionEvent)) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                if (isEnabled() && m2581t(x, y)) {
                    this.auz = 1;
                    this.auA = x;
                    this.auB = y;
                    break;
                }
            case 1:
            case 3:
                if (this.auz != 2) {
                    this.auz = 0;
                    this.mVelocityTracker.clear();
                    break;
                }
                m2579n(motionEvent);
                super.onTouchEvent(motionEvent);
                return true;
            case 2:
                switch (this.auz) {
                    case 0:
                        break;
                    case 1:
                        x = motionEvent.getX();
                        y = motionEvent.getY();
                        if (Math.abs(x - this.auA) > ((float) this.mTouchSlop) || Math.abs(y - this.auB) > ((float) this.mTouchSlop)) {
                            this.auz = 2;
                            getParent().requestDisallowInterceptTouchEvent(true);
                            this.auA = x;
                            this.auB = y;
                            return true;
                        }
                    case 2:
                        float x2 = motionEvent.getX();
                        int thumbScrollRange = getThumbScrollRange();
                        float f = x2 - this.auA;
                        x = thumbScrollRange != 0 ? f / ((float) thumbScrollRange) : f > 0.0f ? 1.0f : -1.0f;
                        if (tb.cH(this)) {
                            x = -x;
                        }
                        x = m2577b(x + this.auC, 0.0f, 1.0f);
                        if (x != this.auC) {
                            this.auA = x2;
                            setThumbPosition(x);
                        }
                        return true;
                    default:
                        break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void m2578m(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        super.onTouchEvent(obtain);
        obtain.recycle();
    }

    private void m2579n(MotionEvent motionEvent) {
        boolean z = true;
        this.auz = 0;
        boolean z2 = motionEvent.getAction() == 1 && isEnabled();
        boolean isChecked = isChecked();
        if (z2) {
            this.mVelocityTracker.computeCurrentVelocity(1000);
            float xVelocity = this.mVelocityTracker.getXVelocity();
            if (Math.abs(xVelocity) <= ((float) this.aqc)) {
                z = getTargetCheckedState();
            } else if (tb.cH(this)) {
                if (xVelocity >= 0.0f) {
                    z = false;
                }
            } else if (xVelocity <= 0.0f) {
                z = false;
            }
        } else {
            z = isChecked;
        }
        if (z != isChecked) {
            playSoundEffect(0);
        }
        setChecked(z);
        m2578m(motionEvent);
    }

    private void ax(boolean z) {
        float f = z ? 1.0f : 0.0f;
        this.auO = ObjectAnimator.ofFloat(this, auh, new float[]{f});
        this.auO.setDuration(250);
        if (VERSION.SDK_INT >= 18) {
            this.auO.setAutoCancel(true);
        }
        this.auO.start();
    }

    private void sr() {
        if (this.auO != null) {
            this.auO.cancel();
        }
    }

    private boolean getTargetCheckedState() {
        return this.auC > 0.5f;
    }

    void setThumbPosition(float f) {
        this.auC = f;
        invalidate();
    }

    public void toggle() {
        setChecked(!isChecked());
    }

    public void setChecked(boolean z) {
        super.setChecked(z);
        boolean isChecked = isChecked();
        if (getWindowToken() == null || !li.as(this)) {
            sr();
            setThumbPosition(isChecked ? 1.0f : 0.0f);
            return;
        }
        ax(isChecked);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int max;
        int paddingLeft;
        int paddingTop;
        int i5 = 0;
        super.onLayout(z, i, i2, i3, i4);
        if (this.aui != null) {
            Rect rect = this.uU;
            if (this.aun != null) {
                this.aun.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect t = rv.t(this.aui);
            max = Math.max(0, t.left - rect.left);
            i5 = Math.max(0, t.right - rect.right);
        } else {
            max = 0;
        }
        if (tb.cH(this)) {
            paddingLeft = getPaddingLeft() + max;
            max = ((this.auD + paddingLeft) - max) - i5;
            i5 = paddingLeft;
        } else {
            paddingLeft = (getWidth() - getPaddingRight()) - i5;
            i5 += max + (paddingLeft - this.auD);
            max = paddingLeft;
        }
        switch (getGravity() & 112) {
            case 16:
                paddingTop = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (this.auE / 2);
                paddingLeft = this.auE + paddingTop;
                break;
            case 80:
                paddingLeft = getHeight() - getPaddingBottom();
                paddingTop = paddingLeft - this.auE;
                break;
            default:
                paddingTop = getPaddingTop();
                paddingLeft = this.auE + paddingTop;
                break;
        }
        this.auG = i5;
        this.auH = paddingTop;
        this.auJ = paddingLeft;
        this.auI = max;
    }

    public void draw(Canvas canvas) {
        Rect t;
        int i;
        Rect rect = this.uU;
        int i2 = this.auG;
        int i3 = this.auH;
        int i4 = this.auI;
        int i5 = this.auJ;
        int thumbOffset = i2 + getThumbOffset();
        if (this.aui != null) {
            t = rv.t(this.aui);
        } else {
            t = rv.amG;
        }
        if (this.aun != null) {
            this.aun.getPadding(rect);
            int i6 = rect.left + thumbOffset;
            if (t != null) {
                if (t.left > rect.left) {
                    i2 += t.left - rect.left;
                }
                if (t.top > rect.top) {
                    thumbOffset = (t.top - rect.top) + i3;
                } else {
                    thumbOffset = i3;
                }
                if (t.right > rect.right) {
                    i4 -= t.right - rect.right;
                }
                i = t.bottom > rect.bottom ? i5 - (t.bottom - rect.bottom) : i5;
            } else {
                i = i5;
                thumbOffset = i3;
            }
            this.aun.setBounds(i2, thumbOffset, i4, i);
            i = i6;
        } else {
            i = thumbOffset;
        }
        if (this.aui != null) {
            this.aui.getPadding(rect);
            i2 = i - rect.left;
            i = (i + this.auF) + rect.right;
            this.aui.setBounds(i2, i3, i, i5);
            Drawable background = getBackground();
            if (background != null) {
                hh.m11622a(background, i2, i3, i, i5);
            }
        }
        super.draw(canvas);
    }

    protected void onDraw(Canvas canvas) {
        int save;
        super.onDraw(canvas);
        Rect rect = this.uU;
        Drawable drawable = this.aun;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i = this.auH + rect.top;
        int i2 = this.auJ - rect.bottom;
        Drawable drawable2 = this.aui;
        if (drawable != null) {
            if (!this.auv || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect t = rv.t(drawable2);
                drawable2.copyBounds(rect);
                rect.left += t.left;
                rect.right -= t.right;
                save = canvas.save();
                canvas.clipRect(rect, Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        save = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.auL : this.auM;
        if (layout != null) {
            int i3;
            int[] drawableState = getDrawableState();
            if (this.auK != null) {
                this.xr.setColor(this.auK.getColorForState(drawableState, 0));
            }
            this.xr.drawableState = drawableState;
            if (drawable2 != null) {
                rect = drawable2.getBounds();
                i3 = rect.right + rect.left;
            } else {
                i3 = getWidth();
            }
            canvas.translate((float) ((i3 / 2) - (layout.getWidth() / 2)), (float) (((i + i2) / 2) - (layout.getHeight() / 2)));
            layout.draw(canvas);
        }
        canvas.restoreToCount(save);
    }

    public int getCompoundPaddingLeft() {
        if (!tb.cH(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.auD;
        if (TextUtils.isEmpty(getText())) {
            return compoundPaddingLeft;
        }
        return compoundPaddingLeft + this.auu;
    }

    public int getCompoundPaddingRight() {
        if (tb.cH(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.auD;
        if (TextUtils.isEmpty(getText())) {
            return compoundPaddingRight;
        }
        return compoundPaddingRight + this.auu;
    }

    private int getThumbOffset() {
        float f;
        if (tb.cH(this)) {
            f = 1.0f - this.auC;
        } else {
            f = this.auC;
        }
        return (int) ((f * ((float) getThumbScrollRange())) + 0.5f);
    }

    private int getThumbScrollRange() {
        if (this.aun == null) {
            return 0;
        }
        Rect t;
        Rect rect = this.uU;
        this.aun.getPadding(rect);
        if (this.aui != null) {
            t = rv.t(this.aui);
        } else {
            t = rv.amG;
        }
        return ((((this.auD - this.auF) - rect.left) - rect.right) - t.left) - t.right;
    }

    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            mergeDrawableStates(onCreateDrawableState, tH);
        }
        return onCreateDrawableState;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        int i = 0;
        Drawable drawable = this.aui;
        if (drawable != null && drawable.isStateful()) {
            i = 0 | drawable.setState(drawableState);
        }
        drawable = this.aun;
        if (drawable != null && drawable.isStateful()) {
            i |= drawable.setState(drawableState);
        }
        if (i != 0) {
            invalidate();
        }
    }

    public void drawableHotspotChanged(float f, float f2) {
        if (VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(f, f2);
        }
        if (this.aui != null) {
            hh.m11620a(this.aui, f, f2);
        }
        if (this.aun != null) {
            hh.m11620a(this.aun, f, f2);
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.aui || drawable == this.aun;
    }

    public void jumpDrawablesToCurrentState() {
        if (VERSION.SDK_INT >= 14) {
            super.jumpDrawablesToCurrentState();
            if (this.aui != null) {
                this.aui.jumpToCurrentState();
            }
            if (this.aun != null) {
                this.aun.jumpToCurrentState();
            }
            if (this.auO != null && this.auO.isStarted()) {
                this.auO.end();
                this.auO = null;
            }
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("android.widget.Switch");
            CharSequence charSequence = isChecked() ? this.auw : this.aux;
            if (!TextUtils.isEmpty(charSequence)) {
                CharSequence text = accessibilityNodeInfo.getText();
                if (TextUtils.isEmpty(text)) {
                    accessibilityNodeInfo.setText(charSequence);
                    return;
                }
                CharSequence stringBuilder = new StringBuilder();
                stringBuilder.append(text).append(' ').append(charSequence);
                accessibilityNodeInfo.setText(stringBuilder);
            }
        }
    }

    private static float m2577b(float f, float f2, float f3) {
        if (f < f2) {
            return f2;
        }
        return f > f3 ? f3 : f;
    }
}
