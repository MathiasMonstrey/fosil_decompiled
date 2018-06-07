package com.portfolio.platform.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.support.v8.renderscript.Allocation;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.fossil.cjz.a;
import com.fossil.wearables.fossil.R;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;

public class NumberPicker extends LinearLayout {
    private static final C5004j dkh = new C5004j();
    private static final char[] dlc = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '٠', '١', '٢', '٣', '٤', '٥', '٦', '٧', '٨', '٩', '۰', '۱', '۲', '۳', '۴', '۵', '۶', '۷', '۸', '۹'};
    private int BU;
    private int QY;
    private int QZ;
    private int dkA;
    private int dkB;
    private int dkC;
    private final Scroller dkD;
    private final Scroller dkE;
    private int dkF;
    private C5002h dkG;
    private C4998c dkH;
    private C4997b dkI;
    private float dkJ;
    private long dkK;
    private float dkL;
    private boolean dkM;
    private final int dkN;
    private final int dkO;
    private final boolean dkP;
    private final Drawable dkQ;
    private final int dkR;
    private boolean dkS;
    private boolean dkT;
    private int dkU;
    private int dkV;
    private int dkW;
    private boolean dkX;
    private boolean dkY;
    private C5003i dkZ;
    private final ImageButton dki;
    private final ImageButton dkj;
    private final AppCompatEditText dkk;
    private final int dkl;
    private final boolean dkm;
    private final int dkn;
    private int dko;
    private String[] dkp;
    private int dkq;
    private int dkr;
    private C4977f dks;
    private C5000e dkt;
    private C4999d dku;
    private long dkv;
    private final SparseArray<String> dkw;
    private final int[] dkx;
    private final Paint dky;
    private final Drawable dkz;
    private final C5001g dla;
    private int dlb;
    private int mMaxWidth;
    private int mTouchSlop;
    private int mValue;
    private VelocityTracker mVelocityTracker;
    private final int oL;
    private final int oM;
    private final int oN;

    public interface C4977f {
        void mo5424a(NumberPicker numberPicker, int i, int i2);
    }

    class C49941 implements OnClickListener {
        final /* synthetic */ NumberPicker dld;

        C49941(NumberPicker numberPicker) {
            this.dld = numberPicker;
        }

        public void onClick(View view) {
            this.dld.avw();
            this.dld.dkk.clearFocus();
            if (view.getId() == R.id.np__increment) {
                this.dld.ds(true);
            } else {
                this.dld.ds(false);
            }
        }
    }

    class C49952 implements OnLongClickListener {
        final /* synthetic */ NumberPicker dld;

        C49952(NumberPicker numberPicker) {
            this.dld = numberPicker;
        }

        public boolean onLongClick(View view) {
            this.dld.avw();
            this.dld.dkk.clearFocus();
            if (view.getId() == R.id.np__increment) {
                this.dld.m15922b(true, 0);
            } else {
                this.dld.m15922b(false, 0);
            }
            return true;
        }
    }

    public static class CustomEditText extends AppCompatEditText {
        public CustomEditText(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public void onEditorAction(int i) {
            super.onEditorAction(i);
            if (i == 6) {
                clearFocus();
            }
        }
    }

    class C4996a extends AccessibilityNodeProvider {
        final /* synthetic */ NumberPicker dld;
        private final int[] dle = new int[2];
        private int dlf = Integer.MIN_VALUE;
        private final Rect uU = new Rect();

        C4996a(NumberPicker numberPicker) {
            this.dld = numberPicker;
        }

        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            switch (i) {
                case -1:
                    return m15906z(this.dld.getScrollX(), this.dld.getScrollY(), this.dld.getScrollX() + (this.dld.getRight() - this.dld.getLeft()), this.dld.getScrollY() + (this.dld.getBottom() - this.dld.getTop()));
                case 1:
                    return m15903a(1, avL(), this.dld.getScrollX(), this.dld.dkV - this.dld.dkR, (this.dld.getRight() - this.dld.getLeft()) + this.dld.getScrollX(), (this.dld.getBottom() - this.dld.getTop()) + this.dld.getScrollY());
                case 2:
                    return avH();
                case 3:
                    return m15903a(3, avK(), this.dld.getScrollX(), this.dld.getScrollY(), (this.dld.getRight() - this.dld.getLeft()) + this.dld.getScrollX(), this.dld.dkR + this.dld.dkU);
                default:
                    return super.createAccessibilityNodeInfo(i);
            }
        }

        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            if (TextUtils.isEmpty(str)) {
                return Collections.emptyList();
            }
            String toLowerCase = str.toLowerCase();
            List<AccessibilityNodeInfo> arrayList = new ArrayList();
            switch (i) {
                case -1:
                    m15904a(toLowerCase, 3, arrayList);
                    m15904a(toLowerCase, 2, arrayList);
                    m15904a(toLowerCase, 1, arrayList);
                    return arrayList;
                case 1:
                case 2:
                case 3:
                    m15904a(toLowerCase, i, arrayList);
                    return arrayList;
                default:
                    return super.findAccessibilityNodeInfosByText(str, i);
            }
        }

        public boolean performAction(int i, int i2, Bundle bundle) {
            boolean z = false;
            switch (i) {
                case -1:
                    switch (i2) {
                        case 64:
                            if (this.dlf == i) {
                                return false;
                            }
                            this.dlf = i;
                            this.dld.performAccessibilityAction(64, null);
                            return true;
                        case Allocation.USAGE_SHARED /*128*/:
                            if (this.dlf != i) {
                                return false;
                            }
                            this.dlf = Integer.MIN_VALUE;
                            this.dld.performAccessibilityAction(Allocation.USAGE_SHARED, null);
                            return true;
                        case 4096:
                            if (!this.dld.isEnabled()) {
                                return false;
                            }
                            if (!this.dld.getWrapSelectorWheel() && this.dld.getValue() >= this.dld.getMaxValue()) {
                                return false;
                            }
                            this.dld.ds(true);
                            return true;
                        case Utility.DEFAULT_STREAM_BUFFER_SIZE /*8192*/:
                            if (!this.dld.isEnabled()) {
                                return false;
                            }
                            if (!this.dld.getWrapSelectorWheel() && this.dld.getValue() <= this.dld.getMinValue()) {
                                return false;
                            }
                            this.dld.ds(false);
                            return true;
                        default:
                            break;
                    }
                case 1:
                    switch (i2) {
                        case 16:
                            if (!this.dld.isEnabled()) {
                                return false;
                            }
                            this.dld.ds(true);
                            ck(i, 1);
                            return true;
                        case 64:
                            if (this.dlf == i) {
                                return false;
                            }
                            this.dlf = i;
                            ck(i, 32768);
                            this.dld.invalidate(0, this.dld.dkV, this.dld.getRight(), this.dld.getBottom());
                            return true;
                        case Allocation.USAGE_SHARED /*128*/:
                            if (this.dlf != i) {
                                return false;
                            }
                            this.dlf = Integer.MIN_VALUE;
                            ck(i, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
                            this.dld.invalidate(0, this.dld.dkV, this.dld.getRight(), this.dld.getBottom());
                            return true;
                        default:
                            return false;
                    }
                case 2:
                    switch (i2) {
                        case 1:
                            if (!this.dld.isEnabled() || this.dld.dkk.isFocused()) {
                                return false;
                            }
                            return this.dld.dkk.requestFocus();
                        case 2:
                            if (!this.dld.isEnabled() || !this.dld.dkk.isFocused()) {
                                return false;
                            }
                            this.dld.dkk.clearFocus();
                            return true;
                        case 16:
                            if (!this.dld.isEnabled()) {
                                return false;
                            }
                            this.dld.avv();
                            return true;
                        case 64:
                            if (this.dlf == i) {
                                return false;
                            }
                            this.dlf = i;
                            ck(i, 32768);
                            this.dld.dkk.invalidate();
                            return true;
                        case Allocation.USAGE_SHARED /*128*/:
                            if (this.dlf != i) {
                                return false;
                            }
                            this.dlf = Integer.MIN_VALUE;
                            ck(i, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
                            this.dld.dkk.invalidate();
                            return true;
                        default:
                            return this.dld.dkk.performAccessibilityAction(i2, bundle);
                    }
                case 3:
                    switch (i2) {
                        case 16:
                            if (!this.dld.isEnabled()) {
                                return false;
                            }
                            if (i == 1) {
                                z = true;
                            }
                            this.dld.ds(z);
                            ck(i, 1);
                            return true;
                        case 64:
                            if (this.dlf == i) {
                                return false;
                            }
                            this.dlf = i;
                            ck(i, 32768);
                            this.dld.invalidate(0, 0, this.dld.getRight(), this.dld.dkU);
                            return true;
                        case Allocation.USAGE_SHARED /*128*/:
                            if (this.dlf != i) {
                                return false;
                            }
                            this.dlf = Integer.MIN_VALUE;
                            ck(i, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
                            this.dld.invalidate(0, 0, this.dld.getRight(), this.dld.dkU);
                            return true;
                        default:
                            return false;
                    }
            }
            return super.performAction(i, i2, bundle);
        }

        public void ck(int i, int i2) {
            switch (i) {
                case 1:
                    if (avJ()) {
                        m15905j(i, i2, avL());
                        return;
                    }
                    return;
                case 2:
                    lL(i2);
                    return;
                case 3:
                    if (avI()) {
                        m15905j(i, i2, avK());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        private void lL(int i) {
            if (((AccessibilityManager) this.dld.getContext().getSystemService("accessibility")).isEnabled()) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain(i);
                this.dld.dkk.onInitializeAccessibilityEvent(obtain);
                this.dld.dkk.onPopulateAccessibilityEvent(obtain);
                obtain.setSource(this.dld, 2);
                this.dld.requestSendAccessibilityEvent(this.dld, obtain);
            }
        }

        private void m15905j(int i, int i2, String str) {
            if (((AccessibilityManager) this.dld.getContext().getSystemService("accessibility")).isEnabled()) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
                obtain.setClassName(Button.class.getName());
                obtain.setPackageName(this.dld.getContext().getPackageName());
                obtain.getText().add(str);
                obtain.setEnabled(this.dld.isEnabled());
                obtain.setSource(this.dld, i);
                this.dld.requestSendAccessibilityEvent(this.dld, obtain);
            }
        }

        private void m15904a(String str, int i, List<AccessibilityNodeInfo> list) {
            Object avL;
            switch (i) {
                case 1:
                    avL = avL();
                    if (!TextUtils.isEmpty(avL) && avL.toLowerCase().contains(str)) {
                        list.add(createAccessibilityNodeInfo(1));
                        return;
                    }
                    return;
                case 2:
                    CharSequence text = this.dld.dkk.getText();
                    if (TextUtils.isEmpty(text) || !text.toString().toLowerCase().contains(str)) {
                        text = this.dld.dkk.getText();
                        if (!TextUtils.isEmpty(text) && text.toString().toLowerCase().contains(str)) {
                            list.add(createAccessibilityNodeInfo(2));
                            return;
                        }
                        return;
                    }
                    list.add(createAccessibilityNodeInfo(2));
                    return;
                case 3:
                    avL = avK();
                    if (!TextUtils.isEmpty(avL) && avL.toLowerCase().contains(str)) {
                        list.add(createAccessibilityNodeInfo(3));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        private AccessibilityNodeInfo avH() {
            AccessibilityNodeInfo createAccessibilityNodeInfo = this.dld.dkk.createAccessibilityNodeInfo();
            createAccessibilityNodeInfo.setSource(this.dld, 2);
            if (this.dlf != 2) {
                createAccessibilityNodeInfo.addAction(64);
            }
            if (this.dlf == 2) {
                createAccessibilityNodeInfo.addAction(Allocation.USAGE_SHARED);
            }
            return createAccessibilityNodeInfo;
        }

        private AccessibilityNodeInfo m15903a(int i, String str, int i2, int i3, int i4, int i5) {
            AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain();
            obtain.setClassName(Button.class.getName());
            obtain.setPackageName(this.dld.getContext().getPackageName());
            obtain.setSource(this.dld, i);
            obtain.setParent(this.dld);
            obtain.setText(str);
            obtain.setClickable(true);
            obtain.setLongClickable(true);
            obtain.setEnabled(this.dld.isEnabled());
            Rect rect = this.uU;
            rect.set(i2, i3, i4, i5);
            obtain.setBoundsInParent(rect);
            int[] iArr = this.dle;
            this.dld.getLocationOnScreen(iArr);
            rect.offset(iArr[0], iArr[1]);
            obtain.setBoundsInScreen(rect);
            if (this.dlf != i) {
                obtain.addAction(64);
            }
            if (this.dlf == i) {
                obtain.addAction(Allocation.USAGE_SHARED);
            }
            if (this.dld.isEnabled()) {
                obtain.addAction(16);
            }
            return obtain;
        }

        private AccessibilityNodeInfo m15906z(int i, int i2, int i3, int i4) {
            AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain();
            obtain.setClassName(NumberPicker.class.getName());
            obtain.setPackageName(this.dld.getContext().getPackageName());
            obtain.setSource(this.dld);
            if (avI()) {
                obtain.addChild(this.dld, 3);
            }
            obtain.addChild(this.dld, 2);
            if (avJ()) {
                obtain.addChild(this.dld, 1);
            }
            obtain.setParent((View) this.dld.getParentForAccessibility());
            obtain.setEnabled(this.dld.isEnabled());
            obtain.setScrollable(true);
            if (this.dlf != -1) {
                obtain.addAction(64);
            }
            if (this.dlf == -1) {
                obtain.addAction(Allocation.USAGE_SHARED);
            }
            if (this.dld.isEnabled()) {
                if (this.dld.getWrapSelectorWheel() || this.dld.getValue() < this.dld.getMaxValue()) {
                    obtain.addAction(4096);
                }
                if (this.dld.getWrapSelectorWheel() || this.dld.getValue() > this.dld.getMinValue()) {
                    obtain.addAction(Utility.DEFAULT_STREAM_BUFFER_SIZE);
                }
            }
            return obtain;
        }

        private boolean avI() {
            return this.dld.getWrapSelectorWheel() || this.dld.getValue() > this.dld.getMinValue();
        }

        private boolean avJ() {
            return this.dld.getWrapSelectorWheel() || this.dld.getValue() < this.dld.getMaxValue();
        }

        private String avK() {
            int l = this.dld.mValue - 1;
            if (this.dld.dkM) {
                l = this.dld.lH(l);
            }
            if (l < this.dld.dkq) {
                return null;
            }
            if (this.dld.dkp == null) {
                return this.dld.lJ(l);
            }
            return this.dld.dkp[l - this.dld.dkq];
        }

        private String avL() {
            int l = this.dld.mValue + 1;
            if (this.dld.dkM) {
                l = this.dld.lH(l);
            }
            if (l > this.dld.dkr) {
                return null;
            }
            if (this.dld.dkp == null) {
                return this.dld.lJ(l);
            }
            return this.dld.dkp[l - this.dld.dkq];
        }
    }

    class C4997b implements Runnable {
        final /* synthetic */ NumberPicker dld;

        C4997b(NumberPicker numberPicker) {
            this.dld = numberPicker;
        }

        public void run() {
            this.dld.avv();
            this.dld.dkS = true;
        }
    }

    class C4998c implements Runnable {
        final /* synthetic */ NumberPicker dld;
        private boolean dlg;

        C4998c(NumberPicker numberPicker) {
            this.dld = numberPicker;
        }

        private void dt(boolean z) {
            this.dlg = z;
        }

        public void run() {
            this.dld.ds(this.dlg);
            this.dld.postDelayed(this, this.dld.dkv);
        }
    }

    public interface C4999d {
        String format(int i);
    }

    public interface C5000e {
        void m15908c(NumberPicker numberPicker, int i);
    }

    class C5001g implements Runnable {
        private int Bj;
        final /* synthetic */ NumberPicker dld;
        private final int dlh = 1;
        private final int dli = 2;
        private int dlj;

        C5001g(NumberPicker numberPicker) {
            this.dld = numberPicker;
        }

        public void cancel() {
            this.Bj = 0;
            this.dlj = 0;
            this.dld.removeCallbacks(this);
            if (this.dld.dkX) {
                this.dld.dkX = false;
                this.dld.invalidate(0, this.dld.dkV, this.dld.getRight(), this.dld.getBottom());
            }
            this.dld.dkY = false;
            if (this.dld.dkY) {
                this.dld.invalidate(0, 0, this.dld.getRight(), this.dld.dkU);
            }
        }

        public void lM(int i) {
            cancel();
            this.Bj = 1;
            this.dlj = i;
            this.dld.postDelayed(this, (long) ViewConfiguration.getTapTimeout());
        }

        public void lN(int i) {
            cancel();
            this.Bj = 2;
            this.dlj = i;
            this.dld.post(this);
        }

        public void run() {
            switch (this.Bj) {
                case 1:
                    switch (this.dlj) {
                        case 1:
                            this.dld.dkX = true;
                            this.dld.invalidate(0, this.dld.dkV, this.dld.getRight(), this.dld.getBottom());
                            return;
                        case 2:
                            this.dld.dkY = true;
                            this.dld.invalidate(0, 0, this.dld.getRight(), this.dld.dkU);
                            return;
                        default:
                            return;
                    }
                case 2:
                    switch (this.dlj) {
                        case 1:
                            if (!this.dld.dkX) {
                                this.dld.postDelayed(this, (long) ViewConfiguration.getPressedStateDuration());
                            }
                            this.dld.dkX = this.dld.dkX ^ 1;
                            this.dld.invalidate(0, this.dld.dkV, this.dld.getRight(), this.dld.getBottom());
                            return;
                        case 2:
                            if (!this.dld.dkY) {
                                this.dld.postDelayed(this, (long) ViewConfiguration.getPressedStateDuration());
                            }
                            this.dld.dkY = this.dld.dkY ^ 1;
                            this.dld.invalidate(0, 0, this.dld.getRight(), this.dld.dkU);
                            return;
                        default:
                            return;
                    }
                default:
                    return;
            }
        }
    }

    class C5002h implements Runnable {
        final /* synthetic */ NumberPicker dld;
        private int dlk;
        private int dll;

        public void run() {
            this.dld.dkk.setSelection(this.dlk, this.dll);
        }
    }

    class C5003i {
        final /* synthetic */ NumberPicker dld;
        C4996a dlm;

        private C5003i(NumberPicker numberPicker) {
            this.dld = numberPicker;
            if (VERSION.SDK_INT >= 16) {
                this.dlm = new C4996a(numberPicker);
            }
        }

        public boolean performAction(int i, int i2, Bundle bundle) {
            return this.dlm != null && this.dlm.performAction(i, i2, bundle);
        }

        public void ck(int i, int i2) {
            if (this.dlm != null) {
                this.dlm.ck(i, i2);
            }
        }
    }

    static class C5004j implements C4999d {
        final Object[] mArgs = new Object[1];
        final StringBuilder mBuilder = new StringBuilder();
        transient Formatter mFmt;
        char mZeroDigit;

        C5004j() {
            m15909d(Locale.getDefault());
        }

        private void m15909d(Locale locale) {
            this.mFmt = m15911f(locale);
            this.mZeroDigit = C5004j.m15910e(locale);
        }

        public String format(int i) {
            Locale locale = Locale.getDefault();
            if (this.mZeroDigit != C5004j.m15910e(locale)) {
                m15909d(locale);
            }
            this.mArgs[0] = Integer.valueOf(i);
            this.mBuilder.delete(0, this.mBuilder.length());
            this.mFmt.format("%02d", this.mArgs);
            return this.mFmt.toString();
        }

        private static char m15910e(Locale locale) {
            return new DecimalFormatSymbols(locale).getZeroDigit();
        }

        private Formatter m15911f(Locale locale) {
            return new Formatter(this.mBuilder, locale);
        }
    }

    public static C4999d getTwoDigitFormatter() {
        return dkh;
    }

    public NumberPicker(Context context) {
        this(context, null);
    }

    public NumberPicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.numberPickerStyle);
    }

    public NumberPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.dkv = 300;
        this.dkw = new SparseArray();
        this.dkx = new int[3];
        this.dkB = Integer.MIN_VALUE;
        this.BU = 0;
        this.dlb = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.NumberPicker, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(12, 0);
        this.dkP = resourceId != 0;
        this.dkO = obtainStyledAttributes.getColor(3, 0);
        this.dkN = obtainStyledAttributes.getColor(1, 0);
        this.dkQ = obtainStyledAttributes.getDrawable(5);
        this.dkR = obtainStyledAttributes.getDimensionPixelSize(6, (int) TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics()));
        this.dkl = obtainStyledAttributes.getDimensionPixelSize(7, (int) TypedValue.applyDimension(1, 48.0f, getResources().getDisplayMetrics()));
        this.oM = obtainStyledAttributes.getDimensionPixelSize(8, -1);
        this.oN = obtainStyledAttributes.getDimensionPixelSize(9, -1);
        if (this.oM == -1 || this.oN == -1 || this.oM <= this.oN) {
            this.oL = obtainStyledAttributes.getDimensionPixelSize(10, -1);
            this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(11, -1);
            if (this.oL == -1 || this.mMaxWidth == -1 || this.oL <= this.mMaxWidth) {
                this.dkm = this.mMaxWidth == -1;
                this.dkz = obtainStyledAttributes.getDrawable(13);
                obtainStyledAttributes.recycle();
                this.dla = new C5001g(this);
                setWillNotDraw(!this.dkP);
                ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(resourceId, this, true);
                OnClickListener c49941 = new C49941(this);
                OnLongClickListener c49952 = new C49952(this);
                if (this.dkP) {
                    this.dki = null;
                } else {
                    this.dki = (ImageButton) findViewById(R.id.np__increment);
                    this.dki.setOnClickListener(c49941);
                    this.dki.setOnLongClickListener(c49952);
                }
                if (this.dkP) {
                    this.dkj = null;
                } else {
                    this.dkj = (ImageButton) findViewById(R.id.np__decrement);
                    this.dkj.setOnClickListener(c49941);
                    this.dkj.setOnLongClickListener(c49952);
                }
                this.dkk = (AppCompatEditText) findViewById(R.id.np__numberpicker_input);
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
                this.QY = viewConfiguration.getScaledMinimumFlingVelocity();
                this.QZ = viewConfiguration.getScaledMaximumFlingVelocity() / 8;
                this.dkn = (int) this.dkk.getTextSize();
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setTextAlign(Align.CENTER);
                paint.setTextSize((float) this.dkn);
                paint.setTypeface(this.dkk.getTypeface());
                int[][] iArr = new int[4][];
                iArr[0] = new int[]{16842910};
                iArr[1] = new int[]{-16842910};
                iArr[2] = new int[]{-16842912};
                iArr[3] = new int[]{16842919};
                this.dkk.setTextColor(new ColorStateList(iArr, new int[]{getResources().getColor(R.color.gray_dark), getResources().getColor(R.color.gray_dark), getResources().getColor(R.color.gray_dark), getResources().getColor(R.color.gray_dark)}));
                if (this.dkO != 0) {
                    this.dkk.setTextColor(this.dkO);
                }
                paint.setColor(this.dkk.getTextColors().getColorForState(ENABLED_STATE_SET, -1));
                this.dky = paint;
                this.dkD = new Scroller(getContext(), null, true);
                this.dkE = new Scroller(getContext(), new DecelerateInterpolator(2.5f));
                avB();
                if (VERSION.SDK_INT >= 16 && getImportantForAccessibility() == 0) {
                    setImportantForAccessibility(1);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("minWidth > maxWidth");
        }
        throw new IllegalArgumentException("minHeight > maxHeight");
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.dkP) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            int measuredWidth2 = this.dkk.getMeasuredWidth();
            int measuredHeight2 = this.dkk.getMeasuredHeight();
            measuredWidth = (measuredWidth - measuredWidth2) / 2;
            measuredHeight = (measuredHeight - measuredHeight2) / 2;
            this.dkk.layout(measuredWidth, measuredHeight, measuredWidth2 + measuredWidth, measuredHeight2 + measuredHeight);
            if (z) {
                avz();
                avA();
                this.dkU = ((getHeight() - this.dkl) / 2) - this.dkR;
                this.dkV = (this.dkU + (this.dkR * 2)) + this.dkl;
                return;
            }
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    protected void onMeasure(int i, int i2) {
        if (this.dkP) {
            super.onMeasure(makeMeasureSpec(i, this.mMaxWidth), makeMeasureSpec(i2, this.oN));
            setMeasuredDimension(m15913H(this.oL, getMeasuredWidth(), i), m15913H(this.oM, getMeasuredHeight(), i2));
            return;
        }
        super.onMeasure(i, i2);
    }

    private boolean m15918a(Scroller scroller) {
        scroller.forceFinished(true);
        int finalY = scroller.getFinalY() - scroller.getCurrY();
        int i = this.dkB - ((this.dkC + finalY) % this.dkA);
        if (i == 0) {
            return false;
        }
        if (Math.abs(i) > this.dkA / 2) {
            if (i > 0) {
                i -= this.dkA;
            } else {
                i += this.dkA;
            }
        }
        scrollBy(0, i + finalY);
        return true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.dkP || !isEnabled()) {
            return false;
        }
        switch (motionEvent.getAction() & 255) {
            case 0:
                avF();
                this.dkk.setVisibility(4);
                float y = motionEvent.getY();
                this.dkJ = y;
                this.dkL = y;
                this.dkK = motionEvent.getEventTime();
                this.dkS = false;
                this.dkT = false;
                if (this.dkJ < ((float) this.dkU)) {
                    if (this.BU == 0) {
                        this.dla.lM(2);
                    }
                } else if (this.dkJ > ((float) this.dkV) && this.BU == 0) {
                    this.dla.lM(1);
                }
                getParent().requestDisallowInterceptTouchEvent(true);
                if (!this.dkD.isFinished()) {
                    this.dkD.forceFinished(true);
                    this.dkE.forceFinished(true);
                    lG(0);
                    return true;
                } else if (!this.dkE.isFinished()) {
                    this.dkD.forceFinished(true);
                    this.dkE.forceFinished(true);
                    return true;
                } else if (this.dkJ < ((float) this.dkU)) {
                    avw();
                    m15922b(false, (long) ViewConfiguration.getLongPressTimeout());
                    return true;
                } else if (this.dkJ > ((float) this.dkV)) {
                    avw();
                    m15922b(true, (long) ViewConfiguration.getLongPressTimeout());
                    return true;
                } else {
                    this.dkT = true;
                    avD();
                    return true;
                }
            default:
                return false;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || !this.dkP) {
            return false;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 1:
                avE();
                avC();
                this.dla.cancel();
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, (float) this.QZ);
                int yVelocity = (int) velocityTracker.getYVelocity();
                if (Math.abs(yVelocity) > this.QY) {
                    fling(yVelocity);
                    lG(2);
                } else {
                    yVelocity = (int) motionEvent.getY();
                    long eventTime = motionEvent.getEventTime() - this.dkK;
                    eventTime = (long) ViewConfiguration.getTapTimeout();
                    if (((int) Math.abs(((float) yVelocity) - this.dkJ)) > this.mTouchSlop) {
                        avG();
                    } else if (this.dkT) {
                        this.dkT = false;
                        avv();
                    } else {
                        yVelocity = (yVelocity / this.dkA) - 1;
                        if (yVelocity > 0) {
                            ds(true);
                            this.dla.lN(1);
                        } else if (yVelocity < 0) {
                            ds(false);
                            this.dla.lN(2);
                        }
                    }
                    lG(0);
                }
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
                return true;
            case 2:
                if (this.dkS) {
                    return true;
                }
                float y = motionEvent.getY();
                if (this.BU == 1) {
                    scrollBy(0, (int) (y - this.dkL));
                    invalidate();
                } else if (((int) Math.abs(y - this.dkJ)) > this.mTouchSlop) {
                    avF();
                    lG(1);
                }
                this.dkL = y;
                return true;
            default:
                return true;
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 1:
            case 3:
                avF();
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchKeyEvent(android.view.KeyEvent r6) {
        /*
        r5 = this;
        r4 = 20;
        r1 = 1;
        r0 = r6.getKeyCode();
        switch(r0) {
            case 19: goto L_0x0013;
            case 20: goto L_0x0013;
            case 23: goto L_0x000f;
            case 66: goto L_0x000f;
            default: goto L_0x000a;
        };
    L_0x000a:
        r1 = super.dispatchKeyEvent(r6);
    L_0x000e:
        return r1;
    L_0x000f:
        r5.avF();
        goto L_0x000a;
    L_0x0013:
        r2 = r5.dkP;
        if (r2 == 0) goto L_0x000a;
    L_0x0017:
        r2 = r6.getAction();
        switch(r2) {
            case 0: goto L_0x001f;
            case 1: goto L_0x0053;
            default: goto L_0x001e;
        };
    L_0x001e:
        goto L_0x000a;
    L_0x001f:
        r2 = r5.dkM;
        if (r2 != 0) goto L_0x0025;
    L_0x0023:
        if (r0 != r4) goto L_0x0046;
    L_0x0025:
        r2 = r5.getValue();
        r3 = r5.getMaxValue();
        if (r2 >= r3) goto L_0x000a;
    L_0x002f:
        r5.requestFocus();
        r5.dlb = r0;
        r5.avF();
        r2 = r5.dkD;
        r2 = r2.isFinished();
        if (r2 == 0) goto L_0x000e;
    L_0x003f:
        if (r0 != r4) goto L_0x0051;
    L_0x0041:
        r0 = r1;
    L_0x0042:
        r5.ds(r0);
        goto L_0x000e;
    L_0x0046:
        r2 = r5.getValue();
        r3 = r5.getMinValue();
        if (r2 <= r3) goto L_0x000a;
    L_0x0050:
        goto L_0x002f;
    L_0x0051:
        r0 = 0;
        goto L_0x0042;
    L_0x0053:
        r2 = r5.dlb;
        if (r2 != r0) goto L_0x000a;
    L_0x0057:
        r0 = -1;
        r5.dlb = r0;
        goto L_0x000e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.portfolio.platform.view.NumberPicker.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 1:
            case 3:
                avF();
                break;
        }
        return super.dispatchTrackballEvent(motionEvent);
    }

    protected boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (!this.dkP) {
            return super.dispatchHoverEvent(motionEvent);
        }
        if (((AccessibilityManager) getContext().getSystemService("accessibility")).isEnabled()) {
            int y = (int) motionEvent.getY();
            if (y < this.dkU) {
                y = 3;
            } else if (y > this.dkV) {
                y = 1;
            } else {
                y = 2;
            }
            int action = motionEvent.getAction() & 255;
            C5003i supportAccessibilityNodeProvider = getSupportAccessibilityNodeProvider();
            switch (action) {
                case 7:
                    if (!(this.dkW == y || this.dkW == -1)) {
                        supportAccessibilityNodeProvider.ck(this.dkW, 256);
                        supportAccessibilityNodeProvider.ck(y, Allocation.USAGE_SHARED);
                        this.dkW = y;
                        supportAccessibilityNodeProvider.performAction(y, 64, null);
                        break;
                    }
                case 9:
                    supportAccessibilityNodeProvider.ck(y, Allocation.USAGE_SHARED);
                    this.dkW = y;
                    supportAccessibilityNodeProvider.performAction(y, 64, null);
                    break;
                case 10:
                    supportAccessibilityNodeProvider.ck(y, 256);
                    this.dkW = -1;
                    break;
            }
        }
        return false;
    }

    public void computeScroll() {
        Scroller scroller = this.dkD;
        if (scroller.isFinished()) {
            scroller = this.dkE;
            if (scroller.isFinished()) {
                return;
            }
        }
        scroller.computeScrollOffset();
        int currY = scroller.getCurrY();
        if (this.dkF == 0) {
            this.dkF = scroller.getStartY();
        }
        scrollBy(0, currY - this.dkF);
        this.dkF = currY;
        if (scroller.isFinished()) {
            m15921b(scroller);
        } else {
            invalidate();
        }
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (!this.dkP) {
            this.dki.setEnabled(z);
        }
        if (!this.dkP) {
            this.dkj.setEnabled(z);
        }
        this.dkk.setEnabled(z);
    }

    public void scrollBy(int i, int i2) {
        int[] iArr = this.dkx;
        if (!this.dkM && i2 > 0 && iArr[1] <= this.dkq) {
            this.dkC = this.dkB;
        } else if (this.dkM || i2 >= 0 || iArr[1] < this.dkr) {
            this.dkC += i2;
            while (this.dkC - this.dkB > this.dko) {
                this.dkC -= this.dkA;
                m15935j(iArr);
                m15912E(iArr[1], true);
                if (!this.dkM && iArr[1] <= this.dkq) {
                    this.dkC = this.dkB;
                }
            }
            while (this.dkC - this.dkB < (-this.dko)) {
                this.dkC += this.dkA;
                m15933i(iArr);
                m15912E(iArr[1], true);
                if (!this.dkM && iArr[1] >= this.dkr) {
                    this.dkC = this.dkB;
                }
            }
        } else {
            this.dkC = this.dkB;
        }
    }

    public int getSolidColor() {
        return this.dkN;
    }

    public void setOnValueChangedListener(C4977f c4977f) {
        this.dks = c4977f;
    }

    public void setOnScrollListener(C5000e c5000e) {
        this.dkt = c5000e;
    }

    public void setFormatter(C4999d c4999d) {
        if (c4999d != this.dku) {
            this.dku = c4999d;
            avy();
            avB();
        }
    }

    public void setValue(int i) {
        m15912E(i, false);
    }

    private void avv() {
    }

    private void avw() {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null && inputMethodManager.isActive(this.dkk)) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            if (this.dkP) {
                this.dkk.setVisibility(4);
            }
        }
    }

    private void avx() {
        int i = 0;
        if (this.dkm) {
            int i2;
            if (this.dkp == null) {
                float f = 0.0f;
                int i3 = 0;
                while (i3 <= 9) {
                    float measureText = this.dky.measureText(lK(i3));
                    if (measureText <= f) {
                        measureText = f;
                    }
                    i3++;
                    f = measureText;
                }
                for (i2 = this.dkr; i2 > 0; i2 /= 10) {
                    i++;
                }
                i2 = (int) (((float) i) * f);
            } else {
                i2 = this.dkp.length;
                i2 = 0;
                for (String measureText2 : this.dkp) {
                    float measureText3 = this.dky.measureText(measureText2);
                    if (measureText3 > ((float) i2)) {
                        i2 = (int) measureText3;
                    }
                }
            }
            i2 += this.dkk.getPaddingLeft() + this.dkk.getPaddingRight();
            if (this.mMaxWidth != i2) {
                if (i2 > this.oL) {
                    this.mMaxWidth = i2;
                } else {
                    this.mMaxWidth = this.oL;
                }
                invalidate();
            }
        }
    }

    public boolean getWrapSelectorWheel() {
        return this.dkM;
    }

    public void setWrapSelectorWheel(boolean z) {
        Object obj = this.dkr - this.dkq >= this.dkx.length ? 1 : null;
        if ((!z || obj != null) && z != this.dkM) {
            this.dkM = z;
        }
    }

    public void setOnLongPressUpdateInterval(long j) {
        this.dkv = j;
    }

    public int getValue() {
        return this.mValue;
    }

    public int getMinValue() {
        return this.dkq;
    }

    public void setMinValue(int i) {
        if (this.dkq != i) {
            if (i < 0) {
                throw new IllegalArgumentException("minValue must be >= 0");
            }
            this.dkq = i;
            if (this.dkq > this.mValue) {
                this.mValue = this.dkq;
            }
            setWrapSelectorWheel(this.dkr - this.dkq > this.dkx.length);
            avy();
            avB();
            avx();
            invalidate();
        }
    }

    public int getMaxValue() {
        return this.dkr;
    }

    public void setMaxValue(int i) {
        if (this.dkr != i) {
            if (i < 0) {
                throw new IllegalArgumentException("maxValue must be >= 0");
            }
            this.dkr = i;
            if (this.dkr < this.mValue) {
                this.mValue = this.dkr;
            }
            setWrapSelectorWheel(this.dkr - this.dkq > this.dkx.length);
            avy();
            avB();
            avx();
            invalidate();
        }
    }

    public String[] getDisplayedValues() {
        return this.dkp;
    }

    public void setDisplayedValues(String[] strArr) {
        if (this.dkp != strArr) {
            this.dkp = strArr;
            if (this.dkp != null) {
                this.dkk.setRawInputType(524289);
            } else {
                this.dkk.setRawInputType(2);
            }
            avB();
            avy();
            avx();
        }
    }

    protected float getTopFadingEdgeStrength() {
        return 0.9f;
    }

    protected float getBottomFadingEdgeStrength() {
        return 0.9f;
    }

    protected void onDetachedFromWindow() {
        avF();
        super.onDetachedFromWindow();
    }

    protected void onDraw(Canvas canvas) {
        if (this.dkP) {
            float right = (float) ((getRight() - getLeft()) / 2);
            float f = (float) this.dkC;
            if (this.dkz != null && this.BU == 0) {
                if (this.dkY) {
                    this.dkz.setState(PRESSED_ENABLED_STATE_SET);
                    this.dkz.setBounds(0, 0, getRight(), this.dkU);
                    this.dkz.draw(canvas);
                }
                if (this.dkX) {
                    this.dkz.setState(PRESSED_ENABLED_STATE_SET);
                    this.dkz.setBounds(0, this.dkV, getRight(), getBottom());
                    this.dkz.draw(canvas);
                }
            }
            int[] iArr = this.dkx;
            float f2 = f;
            for (int i = 0; i < iArr.length; i++) {
                String str = (String) this.dkw.get(iArr[i]);
                if (i != 1 || this.dkk.getVisibility() != 0) {
                    canvas.drawText(str, right, f2, this.dky);
                }
                f2 += (float) this.dkA;
            }
            if (this.dkQ != null) {
                int i2 = this.dkU;
                this.dkQ.setBounds(0, i2, getRight(), this.dkR + i2);
                this.dkQ.draw(canvas);
                i2 = this.dkV;
                this.dkQ.setBounds(0, i2 - this.dkR, getRight(), i2);
                this.dkQ.draw(canvas);
                return;
            }
            return;
        }
        super.onDraw(canvas);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(NumberPicker.class.getName());
        accessibilityEvent.setScrollable(true);
        accessibilityEvent.setScrollY((this.dkq + this.mValue) * this.dkA);
        accessibilityEvent.setMaxScrollY((this.dkr - this.dkq) * this.dkA);
    }

    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        if (!this.dkP) {
            return super.getAccessibilityNodeProvider();
        }
        if (this.dkZ == null) {
            this.dkZ = new C5003i();
        }
        return this.dkZ.dlm;
    }

    private int makeMeasureSpec(int i, int i2) {
        if (i2 == -1) {
            return i;
        }
        int size = MeasureSpec.getSize(i);
        int mode = MeasureSpec.getMode(i);
        switch (mode) {
            case Integer.MIN_VALUE:
                return MeasureSpec.makeMeasureSpec(Math.min(size, i2), 1073741824);
            case 0:
                return MeasureSpec.makeMeasureSpec(i2, 1073741824);
            case 1073741824:
                return i;
            default:
                throw new IllegalArgumentException("Unknown measure mode: " + mode);
        }
    }

    private int m15913H(int i, int i2, int i3) {
        if (i != -1) {
            return resolveSizeAndState(Math.max(i, i2), i3, 0);
        }
        return i2;
    }

    public static int resolveSizeAndState(int i, int i2, int i3) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        switch (mode) {
            case Integer.MIN_VALUE:
                if (size < i) {
                    i = size | 16777216;
                    break;
                }
                break;
            case 1073741824:
                i = size;
                break;
        }
        return (-16777216 & i3) | i;
    }

    private void avy() {
        this.dkw.clear();
        int[] iArr = this.dkx;
        int value = getValue();
        for (int i = 0; i < this.dkx.length; i++) {
            int i2 = (i - 1) + value;
            if (this.dkM) {
                i2 = lH(i2);
            }
            iArr[i] = i2;
            lI(iArr[i]);
        }
    }

    private void m15912E(int i, boolean z) {
        if (this.mValue != i) {
            int lH;
            if (this.dkM) {
                lH = lH(i);
            } else {
                lH = Math.min(Math.max(i, this.dkq), this.dkr);
            }
            int i2 = this.mValue;
            this.mValue = lH;
            avB();
            if (z) {
                cj(i2, lH);
            }
            avy();
            invalidate();
        }
    }

    private void ds(boolean z) {
        if (this.dkP) {
            this.dkk.setVisibility(4);
            if (!m15918a(this.dkD)) {
                m15918a(this.dkE);
            }
            this.dkF = 0;
            if (z) {
                this.dkD.startScroll(0, 0, 0, -this.dkA, 300);
            } else {
                this.dkD.startScroll(0, 0, 0, this.dkA, 300);
            }
            invalidate();
        } else if (z) {
            m15912E(this.mValue + 1, true);
        } else {
            m15912E(this.mValue - 1, true);
        }
    }

    private void avz() {
        avy();
        int[] iArr = this.dkx;
        this.dko = (int) ((((float) ((getBottom() - getTop()) - (iArr.length * this.dkn))) / ((float) iArr.length)) + 0.5f);
        this.dkA = this.dkn + this.dko;
        this.dkB = (this.dkk.getBaseline() + this.dkk.getTop()) - (this.dkA * 1);
        this.dkC = this.dkB;
        avB();
    }

    private void avA() {
        setVerticalFadingEdgeEnabled(true);
        setFadingEdgeLength(((getBottom() - getTop()) - this.dkn) / 2);
    }

    private void m15921b(Scroller scroller) {
        if (scroller == this.dkD) {
            if (!avG()) {
                avB();
            }
            lG(0);
        } else if (this.BU != 1) {
            avB();
        }
    }

    private void lG(int i) {
        if (this.BU != i) {
            this.BU = i;
            if (this.dkt != null) {
                this.dkt.m15908c(this, i);
            }
        }
    }

    private void fling(int i) {
        this.dkF = 0;
        if (i > 0) {
            this.dkD.fling(0, 0, 0, i, 0, 0, 0, Integer.MAX_VALUE);
        } else {
            this.dkD.fling(0, Integer.MAX_VALUE, 0, i, 0, 0, 0, Integer.MAX_VALUE);
        }
        invalidate();
    }

    private int lH(int i) {
        if (i > this.dkr) {
            return (this.dkq + ((i - this.dkr) % (this.dkr - this.dkq))) - 1;
        }
        if (i < this.dkq) {
            return (this.dkr - ((this.dkq - i) % (this.dkr - this.dkq))) + 1;
        }
        return i;
    }

    private void m15933i(int[] iArr) {
        System.arraycopy(iArr, 1, iArr, 0, iArr.length - 1);
        int i = iArr[iArr.length - 2] + 1;
        if (this.dkM && i > this.dkr) {
            i = this.dkq;
        }
        iArr[iArr.length - 1] = i;
        lI(i);
    }

    private void m15935j(int[] iArr) {
        System.arraycopy(iArr, 0, iArr, 1, iArr.length - 1);
        int i = iArr[1] - 1;
        if (this.dkM && i < this.dkq) {
            i = this.dkr;
        }
        iArr[0] = i;
        lI(i);
    }

    private void lI(int i) {
        SparseArray sparseArray = this.dkw;
        if (((String) sparseArray.get(i)) == null) {
            Object obj;
            if (i < this.dkq || i > this.dkr) {
                obj = "";
            } else if (this.dkp != null) {
                obj = this.dkp[i - this.dkq];
            } else {
                obj = lJ(i);
            }
            sparseArray.put(i, obj);
        }
    }

    private String lJ(int i) {
        return this.dku != null ? this.dku.format(i) : lK(i);
    }

    private boolean avB() {
        CharSequence lJ = this.dkp == null ? lJ(this.mValue) : this.dkp[this.mValue - this.dkq];
        if (TextUtils.isEmpty(lJ) || lJ.equals(this.dkk.getText().toString())) {
            return false;
        }
        this.dkk.setText(lJ);
        return true;
    }

    private void cj(int i, int i2) {
        if (this.dks != null) {
            this.dks.mo5424a(this, i, this.mValue);
        }
    }

    private void m15922b(boolean z, long j) {
        if (this.dkH == null) {
            this.dkH = new C4998c(this);
        } else {
            removeCallbacks(this.dkH);
        }
        this.dkH.dt(z);
        postDelayed(this.dkH, j);
    }

    private void avC() {
        if (this.dkH != null) {
            removeCallbacks(this.dkH);
        }
    }

    private void avD() {
        if (this.dkI == null) {
            this.dkI = new C4997b(this);
        } else {
            removeCallbacks(this.dkI);
        }
        postDelayed(this.dkI, (long) ViewConfiguration.getLongPressTimeout());
    }

    private void avE() {
        if (this.dkI != null) {
            removeCallbacks(this.dkI);
        }
    }

    private void avF() {
        if (this.dkH != null) {
            removeCallbacks(this.dkH);
        }
        if (this.dkG != null) {
            removeCallbacks(this.dkG);
        }
        if (this.dkI != null) {
            removeCallbacks(this.dkI);
        }
        this.dla.cancel();
    }

    private boolean avG() {
        int i = this.dkB - this.dkC;
        if (i == 0) {
            return false;
        }
        this.dkF = 0;
        if (Math.abs(i) > this.dkA / 2) {
            i += i > 0 ? -this.dkA : this.dkA;
        }
        this.dkE.startScroll(0, 0, 0, i, 800);
        invalidate();
        return true;
    }

    public AppCompatEditText getEditView() {
        return this.dkk;
    }

    private C5003i getSupportAccessibilityNodeProvider() {
        return new C5003i();
    }

    private static String lK(int i) {
        return String.format(Locale.getDefault(), "%d", new Object[]{Integer.valueOf(i)});
    }
}
