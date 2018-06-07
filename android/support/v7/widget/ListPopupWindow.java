package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import com.fossil.li;
import com.fossil.nz;
import com.fossil.pk.a;
import com.fossil.pk.j;
import com.fossil.qu;
import com.fossil.rw;
import java.lang.reflect.Method;

public class ListPopupWindow implements qu {
    private static Method aon;
    private static Method aoo;
    private static Method aop;
    private ListAdapter aam;
    private int afC;
    private Rect ahg;
    private int alh;
    private View aoA;
    private int aoB;
    private DataSetObserver aoC;
    private View aoD;
    private Drawable aoE;
    private OnItemClickListener aoF;
    private OnItemSelectedListener aoG;
    final C1232e aoH;
    private final C1231d aoI;
    private final C1230c aoJ;
    private final C1228a aoK;
    private Runnable aoL;
    private boolean aoM;
    protected PopupWindow aoN;
    rw aoq;
    private int aor;
    private int aos;
    private int aot;
    private int aou;
    private boolean aov;
    private boolean aow;
    private boolean aox;
    private boolean aoy;
    int aoz;
    private Context mContext;
    final Handler mHandler;
    private final Rect uU;

    class C02041 implements Runnable {
        final /* synthetic */ ListPopupWindow aoO;

        C02041(ListPopupWindow listPopupWindow) {
            this.aoO = listPopupWindow;
        }

        public void run() {
            View anchorView = this.aoO.getAnchorView();
            if (anchorView != null && anchorView.getWindowToken() != null) {
                this.aoO.show();
            }
        }
    }

    class C02052 implements OnItemSelectedListener {
        final /* synthetic */ ListPopupWindow aoO;

        C02052(ListPopupWindow listPopupWindow) {
            this.aoO = listPopupWindow;
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            if (i != -1) {
                rw rwVar = this.aoO.aoq;
                if (rwVar != null) {
                    rwVar.setListSelectionHidden(false);
                }
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    class C1228a implements Runnable {
        final /* synthetic */ ListPopupWindow aoO;

        C1228a(ListPopupWindow listPopupWindow) {
            this.aoO = listPopupWindow;
        }

        public void run() {
            this.aoO.clearListSelection();
        }
    }

    class C1229b extends DataSetObserver {
        final /* synthetic */ ListPopupWindow aoO;

        C1229b(ListPopupWindow listPopupWindow) {
            this.aoO = listPopupWindow;
        }

        public void onChanged() {
            if (this.aoO.isShowing()) {
                this.aoO.show();
            }
        }

        public void onInvalidated() {
            this.aoO.dismiss();
        }
    }

    class C1230c implements OnScrollListener {
        final /* synthetic */ ListPopupWindow aoO;

        C1230c(ListPopupWindow listPopupWindow) {
            this.aoO = listPopupWindow;
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && !this.aoO.isInputMethodNotNeeded() && this.aoO.aoN.getContentView() != null) {
                this.aoO.mHandler.removeCallbacks(this.aoO.aoH);
                this.aoO.aoH.run();
            }
        }
    }

    class C1231d implements OnTouchListener {
        final /* synthetic */ ListPopupWindow aoO;

        C1231d(ListPopupWindow listPopupWindow) {
            this.aoO = listPopupWindow;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && this.aoO.aoN != null && this.aoO.aoN.isShowing() && x >= 0 && x < this.aoO.aoN.getWidth() && y >= 0 && y < this.aoO.aoN.getHeight()) {
                this.aoO.mHandler.postDelayed(this.aoO.aoH, 250);
            } else if (action == 1) {
                this.aoO.mHandler.removeCallbacks(this.aoO.aoH);
            }
            return false;
        }
    }

    class C1232e implements Runnable {
        final /* synthetic */ ListPopupWindow aoO;

        C1232e(ListPopupWindow listPopupWindow) {
            this.aoO = listPopupWindow;
        }

        public void run() {
            if (this.aoO.aoq != null && li.au(this.aoO.aoq) && this.aoO.aoq.getCount() > this.aoO.aoq.getChildCount() && this.aoO.aoq.getChildCount() <= this.aoO.aoz) {
                this.aoO.aoN.setInputMethodMode(2);
                this.aoO.show();
            }
        }
    }

    static {
        try {
            aon = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException e) {
            Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
        try {
            aoo = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
        } catch (NoSuchMethodException e2) {
            Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }
        try {
            aop = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[]{Rect.class});
        } catch (NoSuchMethodException e3) {
            Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
        }
    }

    public ListPopupWindow(Context context) {
        this(context, null, a.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        this.aor = -2;
        this.alh = -2;
        this.aou = 1002;
        this.aow = true;
        this.afC = 0;
        this.aox = false;
        this.aoy = false;
        this.aoz = Integer.MAX_VALUE;
        this.aoB = 0;
        this.aoH = new C1232e(this);
        this.aoI = new C1231d(this);
        this.aoJ = new C1230c(this);
        this.aoK = new C1228a(this);
        this.uU = new Rect();
        this.mContext = context;
        this.mHandler = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.ListPopupWindow, i, i2);
        this.aos = obtainStyledAttributes.getDimensionPixelOffset(j.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.aot = obtainStyledAttributes.getDimensionPixelOffset(j.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.aot != 0) {
            this.aov = true;
        }
        obtainStyledAttributes.recycle();
        if (VERSION.SDK_INT >= 11) {
            this.aoN = new AppCompatPopupWindow(context, attributeSet, i, i2);
        } else {
            this.aoN = new AppCompatPopupWindow(context, attributeSet, i);
        }
        this.aoN.setInputMethodMode(1);
    }

    public void setAdapter(ListAdapter listAdapter) {
        if (this.aoC == null) {
            this.aoC = new C1229b(this);
        } else if (this.aam != null) {
            this.aam.unregisterDataSetObserver(this.aoC);
        }
        this.aam = listAdapter;
        if (this.aam != null) {
            listAdapter.registerDataSetObserver(this.aoC);
        }
        if (this.aoq != null) {
            this.aoq.setAdapter(this.aam);
        }
    }

    public void setPromptPosition(int i) {
        this.aoB = i;
    }

    public void setModal(boolean z) {
        this.aoM = z;
        this.aoN.setFocusable(z);
    }

    public boolean isModal() {
        return this.aoM;
    }

    public Drawable getBackground() {
        return this.aoN.getBackground();
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.aoN.setBackgroundDrawable(drawable);
    }

    public void setAnimationStyle(int i) {
        this.aoN.setAnimationStyle(i);
    }

    public View getAnchorView() {
        return this.aoD;
    }

    public void setAnchorView(View view) {
        this.aoD = view;
    }

    public int getHorizontalOffset() {
        return this.aos;
    }

    public void setHorizontalOffset(int i) {
        this.aos = i;
    }

    public int getVerticalOffset() {
        if (this.aov) {
            return this.aot;
        }
        return 0;
    }

    public void setVerticalOffset(int i) {
        this.aot = i;
        this.aov = true;
    }

    public void m2206h(Rect rect) {
        this.ahg = rect;
    }

    public void setDropDownGravity(int i) {
        this.afC = i;
    }

    public int getWidth() {
        return this.alh;
    }

    public void setWidth(int i) {
        this.alh = i;
    }

    public void setContentWidth(int i) {
        Drawable background = this.aoN.getBackground();
        if (background != null) {
            background.getPadding(this.uU);
            this.alh = (this.uU.left + this.uU.right) + i;
            return;
        }
        setWidth(i);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.aoF = onItemClickListener;
    }

    public void show() {
        boolean z = true;
        boolean z2 = false;
        int i = -1;
        int pA = pA();
        boolean isInputMethodNotNeeded = isInputMethodNotNeeded();
        nz.a(this.aoN, this.aou);
        int i2;
        if (this.aoN.isShowing()) {
            int i3;
            int i4;
            if (this.alh == -1) {
                i3 = -1;
            } else if (this.alh == -2) {
                i3 = getAnchorView().getWidth();
            } else {
                i3 = this.alh;
            }
            if (this.aor == -1) {
                if (!isInputMethodNotNeeded) {
                    pA = -1;
                }
                PopupWindow popupWindow;
                if (isInputMethodNotNeeded) {
                    popupWindow = this.aoN;
                    if (this.alh == -1) {
                        i2 = -1;
                    } else {
                        i2 = 0;
                    }
                    popupWindow.setWidth(i2);
                    this.aoN.setHeight(0);
                    i4 = pA;
                } else {
                    popupWindow = this.aoN;
                    if (this.alh == -1) {
                        i2 = -1;
                    } else {
                        i2 = 0;
                    }
                    popupWindow.setWidth(i2);
                    this.aoN.setHeight(-1);
                    i4 = pA;
                }
            } else if (this.aor == -2) {
                i4 = pA;
            } else {
                i4 = this.aor;
            }
            PopupWindow popupWindow2 = this.aoN;
            if (!(this.aoy || this.aox)) {
                z2 = true;
            }
            popupWindow2.setOutsideTouchable(z2);
            popupWindow2 = this.aoN;
            View anchorView = getAnchorView();
            pA = this.aos;
            int i5 = this.aot;
            if (i3 < 0) {
                i3 = -1;
            }
            if (i4 >= 0) {
                i = i4;
            }
            popupWindow2.update(anchorView, pA, i5, i3, i);
            return;
        }
        if (this.alh == -1) {
            i2 = -1;
        } else if (this.alh == -2) {
            i2 = getAnchorView().getWidth();
        } else {
            i2 = this.alh;
        }
        if (this.aor == -1) {
            pA = -1;
        } else if (this.aor != -2) {
            pA = this.aor;
        }
        this.aoN.setWidth(i2);
        this.aoN.setHeight(pA);
        an(true);
        popupWindow2 = this.aoN;
        if (this.aoy || this.aox) {
            z = false;
        }
        popupWindow2.setOutsideTouchable(z);
        this.aoN.setTouchInterceptor(this.aoI);
        if (aop != null) {
            try {
                aop.invoke(this.aoN, new Object[]{this.ahg});
            } catch (Throwable e) {
                Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e);
            }
        }
        nz.a(this.aoN, getAnchorView(), this.aos, this.aot, this.afC);
        this.aoq.setSelection(-1);
        if (!this.aoM || this.aoq.isInTouchMode()) {
            clearListSelection();
        }
        if (!this.aoM) {
            this.mHandler.post(this.aoK);
        }
    }

    public void dismiss() {
        this.aoN.dismiss();
        pz();
        this.aoN.setContentView(null);
        this.aoq = null;
        this.mHandler.removeCallbacks(this.aoH);
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.aoN.setOnDismissListener(onDismissListener);
    }

    private void pz() {
        if (this.aoA != null) {
            ViewParent parent = this.aoA.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.aoA);
            }
        }
    }

    public void setInputMethodMode(int i) {
        this.aoN.setInputMethodMode(i);
    }

    public void setSelection(int i) {
        rw rwVar = this.aoq;
        if (isShowing() && rwVar != null) {
            rwVar.setListSelectionHidden(false);
            rwVar.setSelection(i);
            if (VERSION.SDK_INT >= 11 && rwVar.getChoiceMode() != 0) {
                rwVar.setItemChecked(i, true);
            }
        }
    }

    public void clearListSelection() {
        rw rwVar = this.aoq;
        if (rwVar != null) {
            rwVar.setListSelectionHidden(true);
            rwVar.requestLayout();
        }
    }

    public boolean isShowing() {
        return this.aoN.isShowing();
    }

    public boolean isInputMethodNotNeeded() {
        return this.aoN.getInputMethodMode() == 2;
    }

    public ListView getListView() {
        return this.aoq;
    }

    public rw m2205a(Context context, boolean z) {
        return new rw(context, z);
    }

    private int pA() {
        int i;
        int i2;
        int i3;
        int i4;
        boolean z = true;
        LayoutParams layoutParams;
        View view;
        if (this.aoq == null) {
            Context context = this.mContext;
            this.aoL = new C02041(this);
            this.aoq = m2205a(context, !this.aoM);
            if (this.aoE != null) {
                this.aoq.setSelector(this.aoE);
            }
            this.aoq.setAdapter(this.aam);
            this.aoq.setOnItemClickListener(this.aoF);
            this.aoq.setFocusable(true);
            this.aoq.setFocusableInTouchMode(true);
            this.aoq.setOnItemSelectedListener(new C02052(this));
            this.aoq.setOnScrollListener(this.aoJ);
            if (this.aoG != null) {
                this.aoq.setOnItemSelectedListener(this.aoG);
            }
            View view2 = this.aoq;
            View view3 = this.aoA;
            if (view3 != null) {
                View linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-1, 0, 1.0f);
                switch (this.aoB) {
                    case 0:
                        linearLayout.addView(view3);
                        linearLayout.addView(view2, layoutParams2);
                        break;
                    case 1:
                        linearLayout.addView(view2, layoutParams2);
                        linearLayout.addView(view3);
                        break;
                    default:
                        Log.e("ListPopupWindow", "Invalid hint position " + this.aoB);
                        break;
                }
                if (this.alh >= 0) {
                    i = this.alh;
                    i2 = Integer.MIN_VALUE;
                } else {
                    i2 = 0;
                    i = 0;
                }
                view3.measure(MeasureSpec.makeMeasureSpec(i, i2), 0);
                layoutParams = (LayoutParams) view3.getLayoutParams();
                i2 = layoutParams.bottomMargin + (view3.getMeasuredHeight() + layoutParams.topMargin);
                view = linearLayout;
            } else {
                view = view2;
                i2 = 0;
            }
            this.aoN.setContentView(view);
            i3 = i2;
        } else {
            ViewGroup viewGroup = (ViewGroup) this.aoN.getContentView();
            view = this.aoA;
            if (view != null) {
                layoutParams = (LayoutParams) view.getLayoutParams();
                i3 = layoutParams.bottomMargin + (view.getMeasuredHeight() + layoutParams.topMargin);
            } else {
                i3 = 0;
            }
        }
        Drawable background = this.aoN.getBackground();
        if (background != null) {
            background.getPadding(this.uU);
            i2 = this.uU.top + this.uU.bottom;
            if (this.aov) {
                i4 = i2;
            } else {
                this.aot = -this.uU.top;
                i4 = i2;
            }
        } else {
            this.uU.setEmpty();
            i4 = 0;
        }
        if (this.aoN.getInputMethodMode() != 2) {
            z = false;
        }
        i = getMaxAvailableHeight(getAnchorView(), this.aot, z);
        if (this.aox || this.aor == -1) {
            return i + i4;
        }
        int makeMeasureSpec;
        switch (this.alh) {
            case -2:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.uU.left + this.uU.right), Integer.MIN_VALUE);
                break;
            case -1:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.uU.left + this.uU.right), 1073741824);
                break;
            default:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.alh, 1073741824);
                break;
        }
        i2 = this.aoq.e(makeMeasureSpec, 0, -1, i - i3, -1);
        if (i2 > 0) {
            i3 += (this.aoq.getPaddingTop() + this.aoq.getPaddingBottom()) + i4;
        }
        return i2 + i3;
    }

    private void an(boolean z) {
        if (aon != null) {
            try {
                aon.invoke(this.aoN, new Object[]{Boolean.valueOf(z)});
            } catch (Exception e) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    private int getMaxAvailableHeight(View view, int i, boolean z) {
        if (aoo != null) {
            try {
                return ((Integer) aoo.invoke(this.aoN, new Object[]{view, Integer.valueOf(i), Boolean.valueOf(z)})).intValue();
            } catch (Exception e) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.aoN.getMaxAvailableHeight(view, i);
    }
}
