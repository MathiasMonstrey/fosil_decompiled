package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.C1109d;
import android.support.v4.view.ViewPager.C1119e;
import android.support.v4.view.ViewPager.C1155a;
import android.support.v7.app.ActionBar.C1193b;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.fossil.ag.C1623d;
import com.fossil.ag.C1627h;
import com.fossil.ag.C1629j;
import com.fossil.ag.C1630k;
import com.fossil.aq;
import com.fossil.bi;
import com.fossil.bj;
import com.fossil.bj.C1073c;
import com.fossil.bj.C1114a;
import com.fossil.bj.C1115b;
import com.fossil.bp;
import com.fossil.ju.C3763a;
import com.fossil.ju.C3764b;
import com.fossil.ju.C3765c;
import com.fossil.la;
import com.fossil.lc;
import com.fossil.li;
import com.fossil.oi;
import com.fossil.pk.j;
import com.fossil.pn;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

@C1155a
public class TabLayout extends HorizontalScrollView {
    private static final C3763a<C1118e> AP = new C3765c(16);
    private final ArrayList<C1118e> AQ;
    private C1118e AR;
    private final C1117d AS;
    int AT;
    int AU;
    int AV;
    int AW;
    int AY;
    ColorStateList AZ;
    float Ba;
    float Bb;
    final int Bc;
    int Bd;
    private final int Be;
    private final int Bf;
    private final int Bg;
    private int Bh;
    int Bi;
    int Bj;
    private C1111b Bk;
    private final ArrayList<C1111b> Bl;
    private C1111b Bm;
    private bj Bn;
    ViewPager Bo;
    private la Bp;
    private DataSetObserver Bq;
    private C1120f Br;
    private C1110a Bs;
    private boolean Bt;
    private final C3763a<C1121g> Bu;

    class C11081 implements C1073c {
        final /* synthetic */ TabLayout Bv;

        C11081(TabLayout tabLayout) {
            this.Bv = tabLayout;
        }

        public void mo14a(bj bjVar) {
            this.Bv.scrollTo(bjVar.gW(), 0);
        }
    }

    class C1110a implements C1109d {
        final /* synthetic */ TabLayout Bv;
        private boolean Bw;

        C1110a(TabLayout tabLayout) {
            this.Bv = tabLayout;
        }

        public void mo70a(ViewPager viewPager, la laVar, la laVar2) {
            if (this.Bv.Bo == viewPager) {
                this.Bv.m1949a(laVar2, this.Bw);
            }
        }

        void m1903q(boolean z) {
            this.Bw = z;
        }
    }

    public interface C1111b {
        void mo77h(C1118e c1118e);

        void mo78i(C1118e c1118e);

        void mo79j(C1118e c1118e);
    }

    class C1112c extends DataSetObserver {
        final /* synthetic */ TabLayout Bv;

        C1112c(TabLayout tabLayout) {
            this.Bv = tabLayout;
        }

        public void onChanged() {
            this.Bv.gE();
        }

        public void onInvalidated() {
            this.Bv.gE();
        }
    }

    class C1117d extends LinearLayout {
        float BA;
        private int BB = -1;
        private int BD = -1;
        private bj BF;
        final /* synthetic */ TabLayout Bv;
        private int Bx;
        private final Paint By;
        int Bz = -1;

        C1117d(TabLayout tabLayout, Context context) {
            this.Bv = tabLayout;
            super(context);
            setWillNotDraw(false);
            this.By = new Paint();
        }

        void am(int i) {
            if (this.By.getColor() != i) {
                this.By.setColor(i);
                li.m12231O(this);
            }
        }

        void an(int i) {
            if (this.Bx != i) {
                this.Bx = i;
                li.m12231O(this);
            }
        }

        boolean gJ() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        void m1915b(int i, float f) {
            if (this.BF != null && this.BF.isRunning()) {
                this.BF.cancel();
            }
            this.Bz = i;
            this.BA = f;
            gL();
        }

        float gK() {
            return ((float) this.Bz) + this.BA;
        }

        protected void onMeasure(int i, int i2) {
            boolean z = false;
            super.onMeasure(i, i2);
            if (MeasureSpec.getMode(i) == 1073741824 && this.Bv.Bj == 1 && this.Bv.Bi == 1) {
                int childCount = getChildCount();
                int i3 = 0;
                int i4 = 0;
                while (i3 < childCount) {
                    int max;
                    View childAt = getChildAt(i3);
                    if (childAt.getVisibility() == 0) {
                        max = Math.max(i4, childAt.getMeasuredWidth());
                    } else {
                        max = i4;
                    }
                    i3++;
                    i4 = max;
                }
                if (i4 > 0) {
                    if (i4 * childCount <= getMeasuredWidth() - (this.Bv.aj(16) * 2)) {
                        i3 = 0;
                        while (i3 < childCount) {
                            boolean z2;
                            LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
                            if (layoutParams.width == i4 && layoutParams.weight == 0.0f) {
                                z2 = z;
                            } else {
                                layoutParams.width = i4;
                                layoutParams.weight = 0.0f;
                                z2 = true;
                            }
                            i3++;
                            z = z2;
                        }
                    } else {
                        this.Bv.Bi = 0;
                        this.Bv.m1954p(false);
                        z = true;
                    }
                    if (z) {
                        super.onMeasure(i, i2);
                    }
                }
            }
        }

        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.BF == null || !this.BF.isRunning()) {
                gL();
                return;
            }
            this.BF.cancel();
            m1917p(this.Bz, Math.round(((float) this.BF.getDuration()) * (1.0f - this.BF.getAnimatedFraction())));
        }

        private void gL() {
            int i;
            int i2;
            View childAt = getChildAt(this.Bz);
            if (childAt == null || childAt.getWidth() <= 0) {
                i = -1;
                i2 = -1;
            } else {
                i2 = childAt.getLeft();
                i = childAt.getRight();
                if (this.BA > 0.0f && this.Bz < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.Bz + 1);
                    i2 = (int) ((((float) i2) * (1.0f - this.BA)) + (this.BA * ((float) childAt2.getLeft())));
                    i = (int) ((((float) i) * (1.0f - this.BA)) + (((float) childAt2.getRight()) * this.BA));
                }
            }
            m1916o(i2, i);
        }

        void m1916o(int i, int i2) {
            if (i != this.BB || i2 != this.BD) {
                this.BB = i;
                this.BD = i2;
                li.m12231O(this);
            }
        }

        void m1917p(final int i, int i2) {
            if (this.BF != null && this.BF.isRunning()) {
                this.BF.cancel();
            }
            Object obj = li.m12235S(this) == 1 ? 1 : null;
            View childAt = getChildAt(i);
            if (childAt == null) {
                gL();
                return;
            }
            int i3;
            int i4;
            final int left = childAt.getLeft();
            final int right = childAt.getRight();
            if (Math.abs(i - this.Bz) <= 1) {
                i3 = this.BB;
                i4 = this.BD;
            } else {
                int aj = this.Bv.aj(24);
                if (i < this.Bz) {
                    if (obj != null) {
                        i4 = left - aj;
                        i3 = i4;
                    } else {
                        i4 = right + aj;
                        i3 = i4;
                    }
                } else if (obj != null) {
                    i4 = right + aj;
                    i3 = i4;
                } else {
                    i4 = left - aj;
                    i3 = i4;
                }
            }
            if (i3 != left || i4 != right) {
                bj ha = bp.ha();
                this.BF = ha;
                ha.setInterpolator(aq.vc);
                ha.setDuration((long) i2);
                ha.m5223d(0.0f, 1.0f);
                ha.m5222a(new C1073c(this) {
                    final /* synthetic */ C1117d BK;

                    public void mo14a(bj bjVar) {
                        float animatedFraction = bjVar.getAnimatedFraction();
                        this.BK.m1916o(aq.m4201a(i3, left, animatedFraction), aq.m4201a(i4, right, animatedFraction));
                    }
                });
                ha.m5221a(new C1115b(this) {
                    final /* synthetic */ C1117d BK;

                    public void mo71b(bj bjVar) {
                        this.BK.Bz = i;
                        this.BK.BA = 0.0f;
                    }
                });
                ha.start();
            }
        }

        public void draw(Canvas canvas) {
            super.draw(canvas);
            if (this.BB >= 0 && this.BD > this.BB) {
                canvas.drawRect((float) this.BB, (float) (getHeight() - this.Bx), (float) this.BD, (float) getHeight(), this.By);
            }
        }
    }

    public static final class C1118e {
        private Drawable AN;
        private Object BM;
        private CharSequence BN;
        private int BO = -1;
        private View BP;
        TabLayout BQ;
        C1121g BR;
        private CharSequence xf;

        C1118e() {
        }

        public View getCustomView() {
            return this.BP;
        }

        public C1118e m1921x(View view) {
            this.BP = view;
            gM();
            return this;
        }

        public C1118e ao(int i) {
            return m1921x(LayoutInflater.from(this.BR.getContext()).inflate(i, this.BR, false));
        }

        public Drawable getIcon() {
            return this.AN;
        }

        public int getPosition() {
            return this.BO;
        }

        void ap(int i) {
            this.BO = i;
        }

        public CharSequence getText() {
            return this.xf;
        }

        public C1118e m1918a(Drawable drawable) {
            this.AN = drawable;
            gM();
            return this;
        }

        public C1118e m1919b(CharSequence charSequence) {
            this.xf = charSequence;
            gM();
            return this;
        }

        public void select() {
            if (this.BQ == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            this.BQ.m1952d(this);
        }

        public boolean isSelected() {
            if (this.BQ != null) {
                return this.BQ.getSelectedTabPosition() == this.BO;
            } else {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
        }

        public C1118e m1920c(CharSequence charSequence) {
            this.BN = charSequence;
            gM();
            return this;
        }

        public CharSequence getContentDescription() {
            return this.BN;
        }

        void gM() {
            if (this.BR != null) {
                this.BR.update();
            }
        }

        void reset() {
            this.BQ = null;
            this.BR = null;
            this.BM = null;
            this.AN = null;
            this.xf = null;
            this.BN = null;
            this.BO = -1;
            this.BP = null;
        }
    }

    public static class C1120f implements C1119e {
        private final WeakReference<TabLayout> BS;
        private int BT;
        private int BU;

        public C1120f(TabLayout tabLayout) {
            this.BS = new WeakReference(tabLayout);
        }

        public void aq(int i) {
            this.BT = this.BU;
            this.BU = i;
        }

        public void mo74a(int i, float f, int i2) {
            boolean z = false;
            TabLayout tabLayout = (TabLayout) this.BS.get();
            if (tabLayout != null) {
                boolean z2 = this.BU != 2 || this.BT == 1;
                if (!(this.BU == 2 && this.BT == 0)) {
                    z = true;
                }
                tabLayout.m1943a(i, f, z2, z);
            }
        }

        public void ar(int i) {
            TabLayout tabLayout = (TabLayout) this.BS.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != i && i < tabLayout.getTabCount()) {
                boolean z = this.BU == 0 || (this.BU == 2 && this.BT == 0);
                tabLayout.m1951b(tabLayout.ai(i), z);
            }
        }

        void reset() {
            this.BU = 0;
            this.BT = 0;
        }
    }

    class C1121g extends LinearLayout implements OnLongClickListener {
        private View BP;
        private C1118e BV;
        private TextView BW;
        private ImageView BX;
        private TextView BY;
        private ImageView BZ;
        final /* synthetic */ TabLayout Bv;
        private int Ca = 2;

        public C1121g(TabLayout tabLayout, Context context) {
            this.Bv = tabLayout;
            super(context);
            if (tabLayout.Bc != 0) {
                li.m12248a((View) this, pn.c(context, tabLayout.Bc));
            }
            li.m12261e(this, tabLayout.AT, tabLayout.AU, tabLayout.AV, tabLayout.AW);
            setGravity(17);
            setOrientation(1);
            setClickable(true);
            li.m12251a((View) this, lc.m12067f(getContext(), 1002));
        }

        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.BV == null) {
                return performClick;
            }
            if (!performClick) {
                playSoundEffect(0);
            }
            this.BV.select();
            return true;
        }

        public void setSelected(boolean z) {
            Object obj = isSelected() != z ? 1 : null;
            super.setSelected(z);
            if (obj != null && z && VERSION.SDK_INT < 16) {
                sendAccessibilityEvent(4);
            }
            if (this.BW != null) {
                this.BW.setSelected(z);
            }
            if (this.BX != null) {
                this.BX.setSelected(z);
            }
            if (this.BP != null) {
                this.BP.setSelected(z);
            }
        }

        @TargetApi(14)
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(C1193b.class.getName());
        }

        @TargetApi(14)
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(C1193b.class.getName());
        }

        public void onMeasure(int i, int i2) {
            int i3 = 1;
            int size = MeasureSpec.getSize(i);
            int mode = MeasureSpec.getMode(i);
            int tabMaxWidth = this.Bv.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i = MeasureSpec.makeMeasureSpec(this.Bv.Bd, Integer.MIN_VALUE);
            }
            super.onMeasure(i, i2);
            if (this.BW != null) {
                getResources();
                float f = this.Bv.Ba;
                size = this.Ca;
                if (this.BX != null && this.BX.getVisibility() == 0) {
                    size = 1;
                } else if (this.BW != null && this.BW.getLineCount() > 1) {
                    f = this.Bv.Bb;
                }
                float textSize = this.BW.getTextSize();
                int lineCount = this.BW.getLineCount();
                int b = oi.b(this.BW);
                if (f != textSize || (b >= 0 && size != b)) {
                    if (this.Bv.Bj == 1 && f > textSize && lineCount == 1) {
                        Layout layout = this.BW.getLayout();
                        if (layout == null || m1924a(layout, 0, f) > ((float) ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()))) {
                            i3 = 0;
                        }
                    }
                    if (i3 != 0) {
                        this.BW.setTextSize(0, f);
                        this.BW.setMaxLines(size);
                        super.onMeasure(i, i2);
                    }
                }
            }
        }

        void m1926k(C1118e c1118e) {
            if (c1118e != this.BV) {
                this.BV = c1118e;
                update();
            }
        }

        void reset() {
            m1926k(null);
            setSelected(false);
        }

        final void update() {
            boolean z;
            C1118e c1118e = this.BV;
            View customView = c1118e != null ? c1118e.getCustomView() : null;
            if (customView != null) {
                C1121g parent = customView.getParent();
                if (parent != this) {
                    if (parent != null) {
                        parent.removeView(customView);
                    }
                    addView(customView);
                }
                this.BP = customView;
                if (this.BW != null) {
                    this.BW.setVisibility(8);
                }
                if (this.BX != null) {
                    this.BX.setVisibility(8);
                    this.BX.setImageDrawable(null);
                }
                this.BY = (TextView) customView.findViewById(16908308);
                if (this.BY != null) {
                    this.Ca = oi.b(this.BY);
                }
                this.BZ = (ImageView) customView.findViewById(16908294);
            } else {
                if (this.BP != null) {
                    removeView(this.BP);
                    this.BP = null;
                }
                this.BY = null;
                this.BZ = null;
            }
            if (this.BP == null) {
                if (this.BX == null) {
                    ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(C1627h.design_layout_tab_icon, this, false);
                    addView(imageView, 0);
                    this.BX = imageView;
                }
                if (this.BW == null) {
                    TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(C1627h.design_layout_tab_text, this, false);
                    addView(textView);
                    this.BW = textView;
                    this.Ca = oi.b(this.BW);
                }
                oi.b(this.BW, this.Bv.AY);
                if (this.Bv.AZ != null) {
                    this.BW.setTextColor(this.Bv.AZ);
                }
                m1925a(this.BW, this.BX);
            } else if (!(this.BY == null && this.BZ == null)) {
                m1925a(this.BY, this.BZ);
            }
            if (c1118e == null || !c1118e.isSelected()) {
                z = false;
            } else {
                z = true;
            }
            setSelected(z);
        }

        private void m1925a(TextView textView, ImageView imageView) {
            CharSequence text;
            CharSequence contentDescription;
            boolean z;
            Drawable icon = this.BV != null ? this.BV.getIcon() : null;
            if (this.BV != null) {
                text = this.BV.getText();
            } else {
                text = null;
            }
            if (this.BV != null) {
                contentDescription = this.BV.getContentDescription();
            } else {
                contentDescription = null;
            }
            if (imageView != null) {
                if (icon != null) {
                    imageView.setImageDrawable(icon);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
                imageView.setContentDescription(contentDescription);
            }
            if (TextUtils.isEmpty(text)) {
                z = false;
            } else {
                z = true;
            }
            if (textView != null) {
                if (z) {
                    textView.setText(text);
                    textView.setVisibility(0);
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText(null);
                }
                textView.setContentDescription(contentDescription);
            }
            if (imageView != null) {
                int aj;
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) imageView.getLayoutParams();
                if (z && imageView.getVisibility() == 0) {
                    aj = this.Bv.aj(8);
                } else {
                    aj = 0;
                }
                if (aj != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = aj;
                    imageView.requestLayout();
                }
            }
            if (z || TextUtils.isEmpty(contentDescription)) {
                setOnLongClickListener(null);
                setLongClickable(false);
                return;
            }
            setOnLongClickListener(this);
        }

        public boolean onLongClick(View view) {
            int[] iArr = new int[2];
            Rect rect = new Rect();
            getLocationOnScreen(iArr);
            getWindowVisibleDisplayFrame(rect);
            Context context = getContext();
            int width = getWidth();
            int height = getHeight();
            int i = iArr[1] + (height / 2);
            width = (width / 2) + iArr[0];
            if (li.m12235S(view) == 0) {
                width = context.getResources().getDisplayMetrics().widthPixels - width;
            }
            Toast makeText = Toast.makeText(context, this.BV.getContentDescription(), 0);
            if (i < rect.height()) {
                makeText.setGravity(8388661, width, (iArr[1] + height) - rect.top);
            } else {
                makeText.setGravity(81, 0, height);
            }
            makeText.show();
            return true;
        }

        private float m1924a(Layout layout, int i, float f) {
            return layout.getLineWidth(i) * (f / layout.getPaint().getTextSize());
        }
    }

    public static class C1122h implements C1111b {
        private final ViewPager Bo;

        public C1122h(ViewPager viewPager) {
            this.Bo = viewPager;
        }

        public void mo77h(C1118e c1118e) {
            this.Bo.setCurrentItem(c1118e.getPosition());
        }

        public void mo78i(C1118e c1118e) {
        }

        public void mo79j(C1118e c1118e) {
        }
    }

    public TabLayout(Context context) {
        this(context, null);
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.AQ = new ArrayList();
        this.Bd = Integer.MAX_VALUE;
        this.Bl = new ArrayList();
        this.Bu = new C3764b(12);
        bi.m5190g(context);
        setHorizontalScrollBarEnabled(false);
        this.AS = new C1117d(this, context);
        super.addView(this.AS, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1630k.TabLayout, i, C1629j.Widget_Design_TabLayout);
        this.AS.an(obtainStyledAttributes.getDimensionPixelSize(C1630k.TabLayout_tabIndicatorHeight, 0));
        this.AS.am(obtainStyledAttributes.getColor(C1630k.TabLayout_tabIndicatorColor, 0));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C1630k.TabLayout_tabPadding, 0);
        this.AW = dimensionPixelSize;
        this.AV = dimensionPixelSize;
        this.AU = dimensionPixelSize;
        this.AT = dimensionPixelSize;
        this.AT = obtainStyledAttributes.getDimensionPixelSize(C1630k.TabLayout_tabPaddingStart, this.AT);
        this.AU = obtainStyledAttributes.getDimensionPixelSize(C1630k.TabLayout_tabPaddingTop, this.AU);
        this.AV = obtainStyledAttributes.getDimensionPixelSize(C1630k.TabLayout_tabPaddingEnd, this.AV);
        this.AW = obtainStyledAttributes.getDimensionPixelSize(C1630k.TabLayout_tabPaddingBottom, this.AW);
        this.AY = obtainStyledAttributes.getResourceId(C1630k.TabLayout_tabTextAppearance, C1629j.TextAppearance_Design_Tab);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(this.AY, j.TextAppearance);
        try {
            this.Ba = (float) obtainStyledAttributes2.getDimensionPixelSize(j.TextAppearance_android_textSize, 0);
            this.AZ = obtainStyledAttributes2.getColorStateList(j.TextAppearance_android_textColor);
            if (obtainStyledAttributes.hasValue(C1630k.TabLayout_tabTextColor)) {
                this.AZ = obtainStyledAttributes.getColorStateList(C1630k.TabLayout_tabTextColor);
            }
            if (obtainStyledAttributes.hasValue(C1630k.TabLayout_tabSelectedTextColor)) {
                this.AZ = m1940n(this.AZ.getDefaultColor(), obtainStyledAttributes.getColor(C1630k.TabLayout_tabSelectedTextColor, 0));
            }
            this.Be = obtainStyledAttributes.getDimensionPixelSize(C1630k.TabLayout_tabMinWidth, -1);
            this.Bf = obtainStyledAttributes.getDimensionPixelSize(C1630k.TabLayout_tabMaxWidth, -1);
            this.Bc = obtainStyledAttributes.getResourceId(C1630k.TabLayout_tabBackground, 0);
            this.Bh = obtainStyledAttributes.getDimensionPixelSize(C1630k.TabLayout_tabContentStart, 0);
            this.Bj = obtainStyledAttributes.getInt(C1630k.TabLayout_tabMode, 1);
            this.Bi = obtainStyledAttributes.getInt(C1630k.TabLayout_tabGravity, 0);
            obtainStyledAttributes.recycle();
            Resources resources = getResources();
            this.Bb = (float) resources.getDimensionPixelSize(C1623d.design_tab_text_size_2line);
            this.Bg = resources.getDimensionPixelSize(C1623d.design_tab_scrollable_min_width);
            gI();
        } finally {
            obtainStyledAttributes2.recycle();
        }
    }

    public void setSelectedTabIndicatorColor(int i) {
        this.AS.am(i);
    }

    public void setSelectedTabIndicatorHeight(int i) {
        this.AS.an(i);
    }

    public void m1942a(int i, float f, boolean z) {
        m1943a(i, f, z, true);
    }

    void m1943a(int i, float f, boolean z, boolean z2) {
        int round = Math.round(((float) i) + f);
        if (round >= 0 && round < this.AS.getChildCount()) {
            if (z2) {
                this.AS.m1915b(i, f);
            }
            if (this.Bn != null && this.Bn.isRunning()) {
                this.Bn.cancel();
            }
            scrollTo(m1930a(i, f), 0);
            if (z) {
                setSelectedTabView(round);
            }
        }
    }

    private float getScrollPosition() {
        return this.AS.gK();
    }

    public void m1945a(C1118e c1118e) {
        m1947a(c1118e, this.AQ.isEmpty());
    }

    public void m1947a(C1118e c1118e, boolean z) {
        m1946a(c1118e, this.AQ.size(), z);
    }

    public void m1946a(C1118e c1118e, int i, boolean z) {
        if (c1118e.BQ != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        m1932a(c1118e, i);
        m1936c(c1118e);
        if (z) {
            c1118e.select();
        }
    }

    private void m1931a(TabItem tabItem) {
        C1118e gD = gD();
        if (tabItem.xf != null) {
            gD.m1919b(tabItem.xf);
        }
        if (tabItem.AN != null) {
            gD.m1918a(tabItem.AN);
        }
        if (tabItem.AO != 0) {
            gD.ao(tabItem.AO);
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            gD.m1920c(tabItem.getContentDescription());
        }
        m1945a(gD);
    }

    @Deprecated
    public void setOnTabSelectedListener(C1111b c1111b) {
        if (this.Bk != null) {
            m1950b(this.Bk);
        }
        this.Bk = c1111b;
        if (c1111b != null) {
            m1944a(c1111b);
        }
    }

    public void m1944a(C1111b c1111b) {
        if (!this.Bl.contains(c1111b)) {
            this.Bl.add(c1111b);
        }
    }

    public void m1950b(C1111b c1111b) {
        this.Bl.remove(c1111b);
    }

    public C1118e gD() {
        C1118e c1118e = (C1118e) AP.ea();
        if (c1118e == null) {
            c1118e = new C1118e();
        }
        c1118e.BQ = this;
        c1118e.BR = m1935b(c1118e);
        return c1118e;
    }

    public int getTabCount() {
        return this.AQ.size();
    }

    public C1118e ai(int i) {
        return (i < 0 || i >= getTabCount()) ? null : (C1118e) this.AQ.get(i);
    }

    public int getSelectedTabPosition() {
        return this.AR != null ? this.AR.getPosition() : -1;
    }

    public void removeAllTabs() {
        for (int childCount = this.AS.getChildCount() - 1; childCount >= 0; childCount--) {
            ak(childCount);
        }
        Iterator it = this.AQ.iterator();
        while (it.hasNext()) {
            C1118e c1118e = (C1118e) it.next();
            it.remove();
            c1118e.reset();
            AP.mo3248e(c1118e);
        }
        this.AR = null;
    }

    public void setTabMode(int i) {
        if (i != this.Bj) {
            this.Bj = i;
            gI();
        }
    }

    public int getTabMode() {
        return this.Bj;
    }

    public void setTabGravity(int i) {
        if (this.Bi != i) {
            this.Bi = i;
            gI();
        }
    }

    public int getTabGravity() {
        return this.Bi;
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.AZ != colorStateList) {
            this.AZ = colorStateList;
            gF();
        }
    }

    public ColorStateList getTabTextColors() {
        return this.AZ;
    }

    public void m1953m(int i, int i2) {
        setTabTextColors(m1940n(i, i2));
    }

    public void setupWithViewPager(ViewPager viewPager) {
        m1948a(viewPager, true);
    }

    public void m1948a(ViewPager viewPager, boolean z) {
        m1933a(viewPager, z, false);
    }

    private void m1933a(ViewPager viewPager, boolean z, boolean z2) {
        if (this.Bo != null) {
            if (this.Br != null) {
                this.Bo.m2051b(this.Br);
            }
            if (this.Bs != null) {
                this.Bo.m2050b(this.Bs);
            }
        }
        if (this.Bm != null) {
            m1950b(this.Bm);
            this.Bm = null;
        }
        if (viewPager != null) {
            this.Bo = viewPager;
            if (this.Br == null) {
                this.Br = new C1120f(this);
            }
            this.Br.reset();
            viewPager.m2046a(this.Br);
            this.Bm = new C1122h(viewPager);
            m1944a(this.Bm);
            la adapter = viewPager.getAdapter();
            if (adapter != null) {
                m1949a(adapter, z);
            }
            if (this.Bs == null) {
                this.Bs = new C1110a(this);
            }
            this.Bs.m1903q(z);
            viewPager.m2045a(this.Bs);
            m1942a(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.Bo = null;
            m1949a(null, false);
        }
        this.Bt = z2;
    }

    @Deprecated
    public void setTabsFromPagerAdapter(la laVar) {
        m1949a(laVar, false);
    }

    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.Bo == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                m1933a((ViewPager) parent, true, true);
            }
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.Bt) {
            setupWithViewPager(null);
            this.Bt = false;
        }
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.AS.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    void m1949a(la laVar, boolean z) {
        if (!(this.Bp == null || this.Bq == null)) {
            this.Bp.unregisterDataSetObserver(this.Bq);
        }
        this.Bp = laVar;
        if (z && laVar != null) {
            if (this.Bq == null) {
                this.Bq = new C1112c(this);
            }
            laVar.registerDataSetObserver(this.Bq);
        }
        gE();
    }

    void gE() {
        removeAllTabs();
        if (this.Bp != null) {
            int i;
            int count = this.Bp.getCount();
            for (i = 0; i < count; i++) {
                m1947a(gD().m1919b(this.Bp.bo(i)), false);
            }
            if (this.Bo != null && count > 0) {
                i = this.Bo.getCurrentItem();
                if (i != getSelectedTabPosition() && i < getTabCount()) {
                    m1952d(ai(i));
                }
            }
        }
    }

    private void gF() {
        int size = this.AQ.size();
        for (int i = 0; i < size; i++) {
            ((C1118e) this.AQ.get(i)).gM();
        }
    }

    private C1121g m1935b(C1118e c1118e) {
        C1121g c1121g = this.Bu != null ? (C1121g) this.Bu.ea() : null;
        if (c1121g == null) {
            c1121g = new C1121g(this, getContext());
        }
        c1121g.m1926k(c1118e);
        c1121g.setFocusable(true);
        c1121g.setMinimumWidth(getTabMinWidth());
        return c1121g;
    }

    private void m1932a(C1118e c1118e, int i) {
        c1118e.ap(i);
        this.AQ.add(i, c1118e);
        int size = this.AQ.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            ((C1118e) this.AQ.get(i2)).ap(i2);
        }
    }

    private void m1936c(C1118e c1118e) {
        this.AS.addView(c1118e.BR, c1118e.getPosition(), gG());
    }

    public void addView(View view) {
        m1941w(view);
    }

    public void addView(View view, int i) {
        m1941w(view);
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        m1941w(view);
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        m1941w(view);
    }

    private void m1941w(View view) {
        if (view instanceof TabItem) {
            m1931a((TabItem) view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private LayoutParams gG() {
        LayoutParams layoutParams = new LayoutParams(-2, -1);
        m1934a(layoutParams);
        return layoutParams;
    }

    private void m1934a(LayoutParams layoutParams) {
        if (this.Bj == 1 && this.Bi == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            return;
        }
        layoutParams.width = -2;
        layoutParams.weight = 0.0f;
    }

    int aj(int i) {
        return Math.round(getResources().getDisplayMetrics().density * ((float) i));
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 1;
        int aj = (aj(getDefaultHeight()) + getPaddingTop()) + getPaddingBottom();
        switch (MeasureSpec.getMode(i2)) {
            case Integer.MIN_VALUE:
                i2 = MeasureSpec.makeMeasureSpec(Math.min(aj, MeasureSpec.getSize(i2)), 1073741824);
                break;
            case 0:
                i2 = MeasureSpec.makeMeasureSpec(aj, 1073741824);
                break;
        }
        aj = MeasureSpec.getSize(i);
        if (MeasureSpec.getMode(i) != 0) {
            if (this.Bf > 0) {
                aj = this.Bf;
            } else {
                aj -= aj(56);
            }
            this.Bd = aj;
        }
        super.onMeasure(i, i2);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            switch (this.Bj) {
                case 0:
                    if (childAt.getMeasuredWidth() >= getMeasuredWidth()) {
                        aj = 0;
                        break;
                    } else {
                        aj = 1;
                        break;
                    }
                case 1:
                    if (childAt.getMeasuredWidth() == getMeasuredWidth()) {
                        i3 = 0;
                    }
                    aj = i3;
                    break;
                default:
                    aj = 0;
                    break;
            }
            if (aj != 0) {
                childAt.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
            }
        }
    }

    private void ak(int i) {
        C1121g c1121g = (C1121g) this.AS.getChildAt(i);
        this.AS.removeViewAt(i);
        if (c1121g != null) {
            c1121g.reset();
            this.Bu.mo3248e(c1121g);
        }
        requestLayout();
    }

    private void al(int i) {
        if (i != -1) {
            if (getWindowToken() == null || !li.as(this) || this.AS.gJ()) {
                m1942a(i, 0.0f, true);
                return;
            }
            int scrollX = getScrollX();
            int a = m1930a(i, 0.0f);
            if (scrollX != a) {
                gH();
                this.Bn.m5224q(scrollX, a);
                this.Bn.start();
            }
            this.AS.m1917p(i, 300);
        }
    }

    private void gH() {
        if (this.Bn == null) {
            this.Bn = bp.ha();
            this.Bn.setInterpolator(aq.vc);
            this.Bn.setDuration(300);
            this.Bn.m5222a(new C11081(this));
        }
    }

    void setScrollAnimatorListener(C1114a c1114a) {
        gH();
        this.Bn.m5221a(c1114a);
    }

    private void setSelectedTabView(int i) {
        int childCount = this.AS.getChildCount();
        if (i < childCount) {
            for (int i2 = 0; i2 < childCount; i2++) {
                boolean z;
                View childAt = this.AS.getChildAt(i2);
                if (i2 == i) {
                    z = true;
                } else {
                    z = false;
                }
                childAt.setSelected(z);
            }
        }
    }

    void m1952d(C1118e c1118e) {
        m1951b(c1118e, true);
    }

    void m1951b(C1118e c1118e, boolean z) {
        C1118e c1118e2 = this.AR;
        if (c1118e2 != c1118e) {
            int position = c1118e != null ? c1118e.getPosition() : -1;
            if (z) {
                if ((c1118e2 == null || c1118e2.getPosition() == -1) && position != -1) {
                    m1942a(position, 0.0f, true);
                } else {
                    al(position);
                }
                if (position != -1) {
                    setSelectedTabView(position);
                }
            }
            if (c1118e2 != null) {
                m1938f(c1118e2);
            }
            this.AR = c1118e;
            if (c1118e != null) {
                m1937e(c1118e);
            }
        } else if (c1118e2 != null) {
            m1939g(c1118e);
            al(c1118e.getPosition());
        }
    }

    private void m1937e(C1118e c1118e) {
        for (int size = this.Bl.size() - 1; size >= 0; size--) {
            ((C1111b) this.Bl.get(size)).mo77h(c1118e);
        }
    }

    private void m1938f(C1118e c1118e) {
        for (int size = this.Bl.size() - 1; size >= 0; size--) {
            ((C1111b) this.Bl.get(size)).mo78i(c1118e);
        }
    }

    private void m1939g(C1118e c1118e) {
        for (int size = this.Bl.size() - 1; size >= 0; size--) {
            ((C1111b) this.Bl.get(size)).mo79j(c1118e);
        }
    }

    private int m1930a(int i, float f) {
        int i2 = 0;
        if (this.Bj != 0) {
            return 0;
        }
        int width;
        View childAt = this.AS.getChildAt(i);
        View childAt2 = i + 1 < this.AS.getChildCount() ? this.AS.getChildAt(i + 1) : null;
        if (childAt != null) {
            width = childAt.getWidth();
        } else {
            width = 0;
        }
        if (childAt2 != null) {
            i2 = childAt2.getWidth();
        }
        int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
        i2 = (int) ((((float) (i2 + width)) * 0.5f) * f);
        return li.m12235S(this) == 0 ? i2 + left : left - i2;
    }

    private void gI() {
        int max;
        if (this.Bj == 0) {
            max = Math.max(0, this.Bh - this.AT);
        } else {
            max = 0;
        }
        li.m12261e(this.AS, max, 0, 0, 0);
        switch (this.Bj) {
            case 0:
                this.AS.setGravity(8388611);
                break;
            case 1:
                this.AS.setGravity(1);
                break;
        }
        m1954p(true);
    }

    void m1954p(boolean z) {
        for (int i = 0; i < this.AS.getChildCount(); i++) {
            View childAt = this.AS.getChildAt(i);
            childAt.setMinimumWidth(getTabMinWidth());
            m1934a((LayoutParams) childAt.getLayoutParams());
            if (z) {
                childAt.requestLayout();
            }
        }
    }

    private static ColorStateList m1940n(int i, int i2) {
        r0 = new int[2][];
        int[] iArr = new int[]{SELECTED_STATE_SET, i2};
        r0[1] = EMPTY_STATE_SET;
        iArr[1] = i;
        return new ColorStateList(r0, iArr);
    }

    private int getDefaultHeight() {
        Object obj;
        int size = this.AQ.size();
        for (int i = 0; i < size; i++) {
            C1118e c1118e = (C1118e) this.AQ.get(i);
            if (c1118e != null && c1118e.getIcon() != null && !TextUtils.isEmpty(c1118e.getText())) {
                obj = 1;
                break;
            }
        }
        obj = null;
        if (obj != null) {
            return 72;
        }
        return 48;
    }

    private int getTabMinWidth() {
        if (this.Be != -1) {
            return this.Be;
        }
        return this.Bj == 0 ? this.Bg : 0;
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    int getTabMaxWidth() {
        return this.Bd;
    }
}
