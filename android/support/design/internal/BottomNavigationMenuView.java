package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.fossil.ag.C1623d;
import com.fossil.ah;
import com.fossil.ai;
import com.fossil.ak;
import com.fossil.ju.C3763a;
import com.fossil.ju.C3765c;
import com.fossil.li;
import com.fossil.qj;
import com.fossil.ql;
import com.fossil.qr;

public class BottomNavigationMenuView extends ViewGroup implements qr {
    private final OnClickListener mOnClickListener;
    private boolean tM;
    private final int tT;
    private final int tU;
    private final int tV;
    private final int tW;
    private final ah tX;
    private final C3763a<BottomNavigationItemView> tY;
    private BottomNavigationItemView[] tZ;
    private int ua;
    private int ub;
    private ColorStateList uc;
    private ColorStateList ud;
    private int ue;
    private int[] uf;
    private ak ug;
    private qj uh;

    class C10691 implements OnClickListener {
        final /* synthetic */ BottomNavigationMenuView ui;

        C10691(BottomNavigationMenuView bottomNavigationMenuView) {
            this.ui = bottomNavigationMenuView;
        }

        public void onClick(View view) {
            MenuItem itemData = ((BottomNavigationItemView) view).getItemData();
            if (!this.ui.uh.a(itemData, this.ui.ug, 0)) {
                itemData.setChecked(true);
            }
        }
    }

    public BottomNavigationMenuView(Context context) {
        this(context, null);
    }

    public BottomNavigationMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.tY = new C3765c(5);
        this.tM = true;
        this.ua = 0;
        this.ub = 0;
        Resources resources = getResources();
        this.tT = resources.getDimensionPixelSize(C1623d.design_bottom_navigation_item_max_width);
        this.tU = resources.getDimensionPixelSize(C1623d.design_bottom_navigation_item_min_width);
        this.tV = resources.getDimensionPixelSize(C1623d.design_bottom_navigation_active_item_max_width);
        this.tW = resources.getDimensionPixelSize(C1623d.design_bottom_navigation_height);
        if (VERSION.SDK_INT >= 14) {
            this.tX = new ai();
        } else {
            this.tX = new ah();
        }
        this.mOnClickListener = new C10691(this);
        this.uf = new int[5];
    }

    public void m1683a(qj qjVar) {
        this.uh = qjVar;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int min;
        int size = MeasureSpec.getSize(i);
        int childCount = getChildCount();
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.tW, 1073741824);
        int min2;
        if (this.tM) {
            i3 = childCount - 1;
            min = Math.min(size - (this.tU * i3), this.tV);
            min2 = Math.min((size - min) / i3, this.tT);
            size = (size - min) - (i3 * min2);
            int i4 = 0;
            while (i4 < childCount) {
                int[] iArr = this.uf;
                if (i4 == this.ub) {
                    i3 = min;
                } else {
                    i3 = min2;
                }
                iArr[i4] = i3;
                if (size > 0) {
                    int[] iArr2 = this.uf;
                    iArr2[i4] = iArr2[i4] + 1;
                    i3 = size - 1;
                } else {
                    i3 = size;
                }
                i4++;
                size = i3;
            }
        } else {
            if (childCount == 0) {
                i3 = 1;
            } else {
                i3 = childCount;
            }
            min2 = Math.min(size / i3, this.tV);
            i3 = size - (min2 * childCount);
            for (min = 0; min < childCount; min++) {
                this.uf[min] = min2;
                if (i3 > 0) {
                    int[] iArr3 = this.uf;
                    iArr3[min] = iArr3[min] + 1;
                    i3--;
                }
            }
        }
        i3 = 0;
        for (min = 0; min < childCount; min++) {
            View childAt = getChildAt(min);
            if (childAt.getVisibility() != 8) {
                childAt.measure(MeasureSpec.makeMeasureSpec(this.uf[min], 1073741824), makeMeasureSpec);
                childAt.getLayoutParams().width = childAt.getMeasuredWidth();
                i3 += childAt.getMeasuredWidth();
            }
        }
        setMeasuredDimension(li.resolveSizeAndState(i3, MeasureSpec.makeMeasureSpec(i3, 1073741824), 0), li.resolveSizeAndState(this.tW, makeMeasureSpec, 0));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                if (li.m12235S(this) == 1) {
                    childAt.layout((i5 - i7) - childAt.getMeasuredWidth(), 0, i5 - i7, i6);
                } else {
                    childAt.layout(i7, 0, childAt.getMeasuredWidth() + i7, i6);
                }
                i7 += childAt.getMeasuredWidth();
            }
        }
    }

    public int getWindowAnimations() {
        return 0;
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.uc = colorStateList;
        if (this.tZ != null) {
            for (BottomNavigationItemView iconTintList : this.tZ) {
                iconTintList.setIconTintList(colorStateList);
            }
        }
    }

    public ColorStateList getIconTintList() {
        return this.uc;
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.ud = colorStateList;
        if (this.tZ != null) {
            for (BottomNavigationItemView textColor : this.tZ) {
                textColor.setTextColor(colorStateList);
            }
        }
    }

    public ColorStateList getItemTextColor() {
        return this.ud;
    }

    public void setItemBackgroundRes(int i) {
        this.ue = i;
        if (this.tZ != null) {
            for (BottomNavigationItemView itemBackground : this.tZ) {
                itemBackground.setItemBackground(i);
            }
        }
    }

    public int getItemBackgroundRes() {
        return this.ue;
    }

    public void setPresenter(ak akVar) {
        this.ug = akVar;
    }

    public void eU() {
        removeAllViews();
        if (this.tZ != null) {
            for (Object e : this.tZ) {
                this.tY.mo3248e(e);
            }
        }
        if (this.uh.size() == 0) {
            this.ua = 0;
            this.ub = 0;
            this.tZ = null;
            return;
        }
        boolean z;
        this.tZ = new BottomNavigationItemView[this.uh.size()];
        if (this.uh.size() > 3) {
            z = true;
        } else {
            z = false;
        }
        this.tM = z;
        for (int i = 0; i < this.uh.size(); i++) {
            this.ug.m3633h(true);
            this.uh.getItem(i).setCheckable(true);
            this.ug.m3633h(false);
            View newItem = getNewItem();
            this.tZ[i] = newItem;
            newItem.setIconTintList(this.uc);
            newItem.setTextColor(this.ud);
            newItem.setItemBackground(this.ue);
            newItem.setShiftingMode(this.tM);
            newItem.m1678a((ql) this.uh.getItem(i), 0);
            newItem.setItemPosition(i);
            newItem.setOnClickListener(this.mOnClickListener);
            addView(newItem);
        }
        this.ub = Math.min(this.uh.size() - 1, this.ub);
        this.uh.getItem(this.ub).setChecked(true);
    }

    public void eV() {
        int size = this.uh.size();
        if (size != this.tZ.length) {
            eU();
            return;
        }
        int i = this.ua;
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = this.uh.getItem(i2);
            if (item.isChecked()) {
                this.ua = item.getItemId();
                this.ub = i2;
            }
        }
        if (i != this.ua) {
            this.tX.beginDelayedTransition(this);
        }
        for (i = 0; i < size; i++) {
            this.ug.m3633h(true);
            this.tZ[i].m1678a((ql) this.uh.getItem(i), 0);
            this.ug.m3633h(false);
        }
    }

    private BottomNavigationItemView getNewItem() {
        BottomNavigationItemView bottomNavigationItemView = (BottomNavigationItemView) this.tY.ea();
        if (bottomNavigationItemView == null) {
            return new BottomNavigationItemView(getContext());
        }
        return bottomNavigationItemView;
    }

    public int getSelectedItemId() {
        return this.ua;
    }

    public void m1682B(int i) {
        int size = this.uh.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = this.uh.getItem(i2);
            if (i == item.getItemId()) {
                this.ua = i;
                this.ub = i2;
                item.setChecked(true);
                return;
            }
        }
    }
}
