package com.fossil;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.app.ActionBar.b;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.fossil.pk.C3982a;

public class sn extends HorizontalScrollView implements OnItemSelectedListener {
    private static final Interpolator asL = new DecelerateInterpolator();
    private int ahx;
    protected lz ahy;
    Runnable asC;
    private C4078b asD;
    LinearLayoutCompat asE;
    private Spinner asF;
    private boolean asG;
    int asH;
    int asI;
    private int asJ;
    protected final C4080d asK = new C4080d(this);

    class C4077a extends BaseAdapter {
        final /* synthetic */ sn asN;

        C4077a(sn snVar) {
            this.asN = snVar;
        }

        public int getCount() {
            return this.asN.asE.getChildCount();
        }

        public Object getItem(int i) {
            return ((C4079c) this.asN.asE.getChildAt(i)).rO();
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return this.asN.m13556a((b) getItem(i), true);
            }
            ((C4079c) view).m13553a((b) getItem(i));
            return view;
        }
    }

    class C4078b implements OnClickListener {
        final /* synthetic */ sn asN;

        C4078b(sn snVar) {
            this.asN = snVar;
        }

        public void onClick(View view) {
            ((C4079c) view).rO().select();
            int childCount = this.asN.asE.getChildCount();
            for (int i = 0; i < childCount; i++) {
                boolean z;
                View childAt = this.asN.asE.getChildAt(i);
                if (childAt == view) {
                    z = true;
                } else {
                    z = false;
                }
                childAt.setSelected(z);
            }
        }
    }

    class C4079c extends LinearLayoutCompat implements OnLongClickListener {
        private View BP;
        private TextView BW;
        private ImageView BX;
        final /* synthetic */ sn asN;
        private final int[] asO = new int[]{16842964};
        private b asP;

        public C4079c(sn snVar, Context context, b bVar, boolean z) {
            this.asN = snVar;
            super(context, null, C3982a.actionBarTabStyle);
            this.asP = bVar;
            sw a = sw.m13583a(context, null, this.asO, C3982a.actionBarTabStyle, 0);
            if (a.hasValue(0)) {
                setBackgroundDrawable(a.getDrawable(0));
            }
            a.recycle();
            if (z) {
                setGravity(8388627);
            }
            update();
        }

        public void m13553a(b bVar) {
            this.asP = bVar;
            update();
        }

        public void setSelected(boolean z) {
            Object obj = isSelected() != z ? 1 : null;
            super.setSelected(z);
            if (obj != null && z) {
                sendAccessibilityEvent(4);
            }
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(b.class.getName());
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            if (VERSION.SDK_INT >= 14) {
                accessibilityNodeInfo.setClassName(b.class.getName());
            }
        }

        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (this.asN.asH > 0 && getMeasuredWidth() > this.asN.asH) {
                super.onMeasure(MeasureSpec.makeMeasureSpec(this.asN.asH, 1073741824), i2);
            }
        }

        public void update() {
            b bVar = this.asP;
            View customView = bVar.getCustomView();
            if (customView != null) {
                C4079c parent = customView.getParent();
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
                    return;
                }
                return;
            }
            boolean z;
            if (this.BP != null) {
                removeView(this.BP);
                this.BP = null;
            }
            Drawable icon = bVar.getIcon();
            CharSequence text = bVar.getText();
            if (icon != null) {
                if (this.BX == null) {
                    View appCompatImageView = new AppCompatImageView(getContext());
                    LayoutParams layoutParams = new LinearLayoutCompat.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.BX = appCompatImageView;
                }
                this.BX.setImageDrawable(icon);
                this.BX.setVisibility(0);
            } else if (this.BX != null) {
                this.BX.setVisibility(8);
                this.BX.setImageDrawable(null);
            }
            if (TextUtils.isEmpty(text)) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                if (this.BW == null) {
                    appCompatImageView = new AppCompatTextView(getContext(), null, C3982a.actionBarTabTextStyle);
                    appCompatImageView.setEllipsize(TruncateAt.END);
                    layoutParams = new LinearLayoutCompat.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView);
                    this.BW = appCompatImageView;
                }
                this.BW.setText(text);
                this.BW.setVisibility(0);
            } else if (this.BW != null) {
                this.BW.setVisibility(8);
                this.BW.setText(null);
            }
            if (this.BX != null) {
                this.BX.setContentDescription(bVar.getContentDescription());
            }
            if (z || TextUtils.isEmpty(bVar.getContentDescription())) {
                setOnLongClickListener(null);
                setLongClickable(false);
                return;
            }
            setOnLongClickListener(this);
        }

        public boolean onLongClick(View view) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            Context context = getContext();
            int width = getWidth();
            int height = getHeight();
            int i = context.getResources().getDisplayMetrics().widthPixels;
            Toast makeText = Toast.makeText(context, this.asP.getContentDescription(), 0);
            makeText.setGravity(49, (iArr[0] + (width / 2)) - (i / 2), height);
            makeText.show();
            return true;
        }

        public b rO() {
            return this.asP;
        }
    }

    public class C4080d implements md {
        private boolean FN = false;
        private int ahB;
        final /* synthetic */ sn asN;

        protected C4080d(sn snVar) {
            this.asN = snVar;
        }

        public void m13554e(View view) {
            this.asN.setVisibility(0);
            this.FN = false;
        }

        public void m13555f(View view) {
            if (!this.FN) {
                this.asN.ahy = null;
                this.asN.setVisibility(this.ahB);
            }
        }

        public void aD(View view) {
            this.FN = true;
        }
    }

    public sn(Context context) {
        super(context);
        setHorizontalScrollBarEnabled(false);
        pt w = pt.m13087w(context);
        setContentHeight(w.ml());
        this.asI = w.mn();
        this.asE = rM();
        addView(this.asE, new LayoutParams(-2, -1));
    }

    public void onMeasure(int i, int i2) {
        int i3 = 1;
        int mode = MeasureSpec.getMode(i);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.asE.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.asH = -1;
        } else {
            if (childCount > 2) {
                this.asH = (int) (((float) MeasureSpec.getSize(i)) * 0.4f);
            } else {
                this.asH = MeasureSpec.getSize(i) / 2;
            }
            this.asH = Math.min(this.asH, this.asI);
        }
        mode = MeasureSpec.makeMeasureSpec(this.ahx, 1073741824);
        if (z || !this.asG) {
            i3 = 0;
        }
        if (i3 != 0) {
            this.asE.measure(0, mode);
            if (this.asE.getMeasuredWidth() > MeasureSpec.getSize(i)) {
                rK();
            } else {
                rL();
            }
        } else {
            rL();
        }
        i3 = getMeasuredWidth();
        super.onMeasure(i, mode);
        int measuredWidth = getMeasuredWidth();
        if (z && i3 != measuredWidth) {
            setTabSelected(this.asJ);
        }
    }

    private boolean rJ() {
        return this.asF != null && this.asF.getParent() == this;
    }

    public void setAllowCollapse(boolean z) {
        this.asG = z;
    }

    private void rK() {
        if (!rJ()) {
            if (this.asF == null) {
                this.asF = rN();
            }
            removeView(this.asE);
            addView(this.asF, new LayoutParams(-2, -1));
            if (this.asF.getAdapter() == null) {
                this.asF.setAdapter(new C4077a(this));
            }
            if (this.asC != null) {
                removeCallbacks(this.asC);
                this.asC = null;
            }
            this.asF.setSelection(this.asJ);
        }
    }

    private boolean rL() {
        if (rJ()) {
            removeView(this.asF);
            addView(this.asE, new LayoutParams(-2, -1));
            setTabSelected(this.asF.getSelectedItemPosition());
        }
        return false;
    }

    public void setTabSelected(int i) {
        this.asJ = i;
        int childCount = this.asE.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            boolean z;
            View childAt = this.asE.getChildAt(i2);
            if (i2 == i) {
                z = true;
            } else {
                z = false;
            }
            childAt.setSelected(z);
            if (z) {
                al(i);
            }
        }
        if (this.asF != null && i >= 0) {
            this.asF.setSelection(i);
        }
    }

    public void setContentHeight(int i) {
        this.ahx = i;
        requestLayout();
    }

    private LinearLayoutCompat rM() {
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(getContext(), null, C3982a.actionBarTabBarStyle);
        linearLayoutCompat.setMeasureWithLargestChildEnabled(true);
        linearLayoutCompat.setGravity(17);
        linearLayoutCompat.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        return linearLayoutCompat;
    }

    private Spinner rN() {
        Spinner appCompatSpinner = new AppCompatSpinner(getContext(), null, C3982a.actionDropDownStyle);
        appCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        pt w = pt.m13087w(getContext());
        setContentHeight(w.ml());
        this.asI = w.mn();
    }

    public void al(int i) {
        final View childAt = this.asE.getChildAt(i);
        if (this.asC != null) {
            removeCallbacks(this.asC);
        }
        this.asC = new Runnable(this) {
            final /* synthetic */ sn asN;

            public void run() {
                this.asN.smoothScrollTo(childAt.getLeft() - ((this.asN.getWidth() - childAt.getWidth()) / 2), 0);
                this.asN.asC = null;
            }
        };
        post(this.asC);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.asC != null) {
            post(this.asC);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.asC != null) {
            removeCallbacks(this.asC);
        }
    }

    C4079c m13556a(b bVar, boolean z) {
        C4079c c4079c = new C4079c(this, getContext(), bVar, z);
        if (z) {
            c4079c.setBackgroundDrawable(null);
            c4079c.setLayoutParams(new AbsListView.LayoutParams(-1, this.ahx));
        } else {
            c4079c.setFocusable(true);
            if (this.asD == null) {
                this.asD = new C4078b(this);
            }
            c4079c.setOnClickListener(this.asD);
        }
        return c4079c;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        ((C4079c) view).rO().select();
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
