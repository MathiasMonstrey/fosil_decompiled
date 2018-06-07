package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ViewPager.C1109d;
import android.support.v4.view.ViewPager.C1119e;
import android.support.v4.view.ViewPager.C1155a;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.fossil.la;
import com.fossil.lb;
import com.fossil.li;
import com.fossil.oi;
import java.lang.ref.WeakReference;

@C1155a
public class PagerTitleStrip extends ViewGroup {
    private static final int[] Sk = new int[]{16842804, 16842901, 16842904, 16842927};
    private static final int[] Sl = new int[]{16843660};
    private static final C1152b So;
    ViewPager RZ;
    TextView Sa;
    TextView Sb;
    TextView Sc;
    private int Sd;
    float Se;
    private int Sf;
    private boolean Sg;
    private boolean Sh;
    private final C1151a Si;
    private WeakReference<la> Sj;
    private int Sm;
    int Sn;
    private int mGravity;

    class C1151a extends DataSetObserver implements C1109d, C1119e {
        private int BU;
        final /* synthetic */ PagerTitleStrip Sp;

        C1151a(PagerTitleStrip pagerTitleStrip) {
            this.Sp = pagerTitleStrip;
        }

        public void mo74a(int i, float f, int i2) {
            if (f > 0.5f) {
                i++;
            }
            this.Sp.mo89b(i, f, false);
        }

        public void ar(int i) {
            float f = 0.0f;
            if (this.BU == 0) {
                this.Sp.m2018a(this.Sp.RZ.getCurrentItem(), this.Sp.RZ.getAdapter());
                if (this.Sp.Se >= 0.0f) {
                    f = this.Sp.Se;
                }
                this.Sp.mo89b(this.Sp.RZ.getCurrentItem(), f, true);
            }
        }

        public void aq(int i) {
            this.BU = i;
        }

        public void mo70a(ViewPager viewPager, la laVar, la laVar2) {
            this.Sp.m2019a(laVar, laVar2);
        }

        public void onChanged() {
            float f = 0.0f;
            this.Sp.m2018a(this.Sp.RZ.getCurrentItem(), this.Sp.RZ.getAdapter());
            if (this.Sp.Se >= 0.0f) {
                f = this.Sp.Se;
            }
            this.Sp.mo89b(this.Sp.RZ.getCurrentItem(), f, true);
        }
    }

    interface C1152b {
        void setSingleLineAllCaps(TextView textView);
    }

    static class C1153c implements C1152b {
        C1153c() {
        }

        public void setSingleLineAllCaps(TextView textView) {
            textView.setSingleLine();
        }
    }

    static class C1154d implements C1152b {
        C1154d() {
        }

        public void setSingleLineAllCaps(TextView textView) {
            lb.setSingleLineAllCaps(textView);
        }
    }

    static {
        if (VERSION.SDK_INT >= 14) {
            So = new C1154d();
        } else {
            So = new C1153c();
        }
    }

    private static void setSingleLineAllCaps(TextView textView) {
        So.setSingleLineAllCaps(textView);
    }

    public PagerTitleStrip(Context context) {
        this(context, null);
    }

    public PagerTitleStrip(Context context, AttributeSet attributeSet) {
        boolean z = false;
        super(context, attributeSet);
        this.Sd = -1;
        this.Se = -1.0f;
        this.Si = new C1151a(this);
        View textView = new TextView(context);
        this.Sa = textView;
        addView(textView);
        textView = new TextView(context);
        this.Sb = textView;
        addView(textView);
        textView = new TextView(context);
        this.Sc = textView;
        addView(textView);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Sk);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            oi.b(this.Sa, resourceId);
            oi.b(this.Sb, resourceId);
            oi.b(this.Sc, resourceId);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            setTextSize(0, (float) dimensionPixelSize);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            dimensionPixelSize = obtainStyledAttributes.getColor(2, 0);
            this.Sa.setTextColor(dimensionPixelSize);
            this.Sb.setTextColor(dimensionPixelSize);
            this.Sc.setTextColor(dimensionPixelSize);
        }
        this.mGravity = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        this.Sn = this.Sb.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(0.6f);
        this.Sa.setEllipsize(TruncateAt.END);
        this.Sb.setEllipsize(TruncateAt.END);
        this.Sc.setEllipsize(TruncateAt.END);
        if (resourceId != 0) {
            obtainStyledAttributes = context.obtainStyledAttributes(resourceId, Sl);
            z = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
        }
        if (z) {
            setSingleLineAllCaps(this.Sa);
            setSingleLineAllCaps(this.Sb);
            setSingleLineAllCaps(this.Sc);
        } else {
            this.Sa.setSingleLine();
            this.Sb.setSingleLine();
            this.Sc.setSingleLine();
        }
        this.Sf = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }

    public void setTextSpacing(int i) {
        this.Sf = i;
        requestLayout();
    }

    public int getTextSpacing() {
        return this.Sf;
    }

    public void setNonPrimaryAlpha(float f) {
        this.Sm = ((int) (255.0f * f)) & 255;
        int i = (this.Sm << 24) | (this.Sn & 16777215);
        this.Sa.setTextColor(i);
        this.Sc.setTextColor(i);
    }

    public void setTextColor(int i) {
        this.Sn = i;
        this.Sb.setTextColor(i);
        int i2 = (this.Sm << 24) | (this.Sn & 16777215);
        this.Sa.setTextColor(i2);
        this.Sc.setTextColor(i2);
    }

    public void setTextSize(int i, float f) {
        this.Sa.setTextSize(i, f);
        this.Sb.setTextSize(i, f);
        this.Sc.setTextSize(i, f);
    }

    public void setGravity(int i) {
        this.mGravity = i;
        requestLayout();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof ViewPager) {
            ViewPager viewPager = (ViewPager) parent;
            la adapter = viewPager.getAdapter();
            viewPager.m2052c(this.Si);
            viewPager.m2045a(this.Si);
            this.RZ = viewPager;
            m2019a(this.Sj != null ? (la) this.Sj.get() : null, adapter);
            return;
        }
        throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.RZ != null) {
            m2019a(this.RZ.getAdapter(), null);
            this.RZ.m2052c(null);
            this.RZ.m2050b(this.Si);
            this.RZ = null;
        }
    }

    void m2018a(int i, la laVar) {
        CharSequence charSequence;
        CharSequence charSequence2 = null;
        int count = laVar != null ? laVar.getCount() : 0;
        this.Sg = true;
        if (i < 1 || laVar == null) {
            charSequence = null;
        } else {
            charSequence = laVar.bo(i - 1);
        }
        this.Sa.setText(charSequence);
        TextView textView = this.Sb;
        if (laVar == null || i >= count) {
            charSequence = null;
        } else {
            charSequence = laVar.bo(i);
        }
        textView.setText(charSequence);
        if (i + 1 < count && laVar != null) {
            charSequence2 = laVar.bo(i + 1);
        }
        this.Sc.setText(charSequence2);
        count = MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((float) ((getWidth() - getPaddingLeft()) - getPaddingRight())) * 0.8f)), Integer.MIN_VALUE);
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        this.Sa.measure(count, makeMeasureSpec);
        this.Sb.measure(count, makeMeasureSpec);
        this.Sc.measure(count, makeMeasureSpec);
        this.Sd = i;
        if (!this.Sh) {
            mo89b(i, this.Se, false);
        }
        this.Sg = false;
    }

    public void requestLayout() {
        if (!this.Sg) {
            super.requestLayout();
        }
    }

    void m2019a(la laVar, la laVar2) {
        if (laVar != null) {
            laVar.unregisterDataSetObserver(this.Si);
            this.Sj = null;
        }
        if (laVar2 != null) {
            laVar2.registerDataSetObserver(this.Si);
            this.Sj = new WeakReference(laVar2);
        }
        if (this.RZ != null) {
            this.Sd = -1;
            this.Se = -1.0f;
            m2018a(this.RZ.getCurrentItem(), laVar2);
            requestLayout();
        }
    }

    void mo89b(int i, float f, boolean z) {
        if (i != this.Sd) {
            m2018a(i, this.RZ.getAdapter());
        } else if (!z && f == this.Se) {
            return;
        }
        this.Sh = true;
        int measuredWidth = this.Sa.getMeasuredWidth();
        int measuredWidth2 = this.Sb.getMeasuredWidth();
        int measuredWidth3 = this.Sc.getMeasuredWidth();
        int i2 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i3 = paddingRight + i2;
        int i4 = (width - (paddingLeft + i2)) - i3;
        float f2 = 0.5f + f;
        if (f2 > 1.0f) {
            f2 -= 1.0f;
        }
        i4 = ((width - i3) - ((int) (f2 * ((float) i4)))) - (measuredWidth2 / 2);
        i3 = i4 + measuredWidth2;
        i2 = this.Sa.getBaseline();
        measuredWidth2 = this.Sb.getBaseline();
        int baseline = this.Sc.getBaseline();
        int max = Math.max(Math.max(i2, measuredWidth2), baseline);
        i2 = max - i2;
        measuredWidth2 = max - measuredWidth2;
        baseline = max - baseline;
        int measuredHeight = this.Sc.getMeasuredHeight() + baseline;
        max = Math.max(Math.max(this.Sa.getMeasuredHeight() + i2, this.Sb.getMeasuredHeight() + measuredWidth2), measuredHeight);
        switch (this.mGravity & 112) {
            case 16:
                paddingTop = (((height - paddingTop) - paddingBottom) - max) / 2;
                height = paddingTop + i2;
                measuredWidth2 += paddingTop;
                i2 = paddingTop + baseline;
                break;
            case 80:
                paddingTop = (height - paddingBottom) - max;
                height = paddingTop + i2;
                measuredWidth2 += paddingTop;
                i2 = paddingTop + baseline;
                break;
            default:
                height = paddingTop + i2;
                measuredWidth2 += paddingTop;
                i2 = paddingTop + baseline;
                break;
        }
        this.Sb.layout(i4, measuredWidth2, i3, this.Sb.getMeasuredHeight() + measuredWidth2);
        measuredWidth2 = Math.min(paddingLeft, (i4 - this.Sf) - measuredWidth);
        this.Sa.layout(measuredWidth2, height, measuredWidth + measuredWidth2, this.Sa.getMeasuredHeight() + height);
        measuredWidth2 = Math.max((width - paddingRight) - measuredWidth3, this.Sf + i3);
        this.Sc.layout(measuredWidth2, i2, measuredWidth2 + measuredWidth3, this.Sc.getMeasuredHeight() + i2);
        this.Se = f;
        this.Sh = false;
    }

    protected void onMeasure(int i, int i2) {
        if (MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException("Must measure with an exact width");
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        int size = MeasureSpec.getSize(i);
        int childMeasureSpec2 = getChildMeasureSpec(i, (int) (((float) size) * 0.2f), -2);
        this.Sa.measure(childMeasureSpec2, childMeasureSpec);
        this.Sb.measure(childMeasureSpec2, childMeasureSpec);
        this.Sc.measure(childMeasureSpec2, childMeasureSpec);
        if (MeasureSpec.getMode(i2) == 1073741824) {
            paddingTop = MeasureSpec.getSize(i2);
        } else {
            paddingTop = Math.max(getMinHeight(), paddingTop + this.Sb.getMeasuredHeight());
        }
        setMeasuredDimension(size, li.resolveSizeAndState(paddingTop, i2, li.m12239W(this.Sb) << 16));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f = 0.0f;
        if (this.RZ != null) {
            if (this.Se >= 0.0f) {
                f = this.Se;
            }
            mo89b(this.Sd, f, true);
        }
    }

    int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }
}
