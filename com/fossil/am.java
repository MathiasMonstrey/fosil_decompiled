package com.fossil;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.internal.NavigationMenuItemView;
import android.support.design.internal.NavigationMenuView;
import android.support.v7.widget.RecyclerView.C1234a;
import android.support.v7.widget.RecyclerView.C1264v;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.fossil.ag.C1623d;
import com.fossil.ag.C1627h;
import com.fossil.qq.a;
import java.util.ArrayList;

public class am implements qq {
    private int mId;
    LayoutInflater mLayoutInflater;
    final OnClickListener mOnClickListener = new C16831(this);
    private NavigationMenuView uD;
    LinearLayout uE;
    private a uF;
    C1686b uG;
    int uH;
    boolean uI;
    ColorStateList uJ;
    Drawable uK;
    private int uL;
    int uM;
    qj uh;
    ColorStateList uy;

    class C16831 implements OnClickListener {
        final /* synthetic */ am uN;

        C16831(am amVar) {
            this.uN = amVar;
        }

        public void onClick(View view) {
            NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) view;
            this.uN.m3828h(true);
            ql itemData = navigationMenuItemView.getItemData();
            boolean a = this.uN.uh.a(itemData, this.uN, 0);
            if (itemData != null && itemData.isCheckable() && a) {
                this.uN.uG.m3812a(itemData);
            }
            this.uN.m3828h(false);
            this.uN.m3827g(false);
        }
    }

    static abstract class C1684j extends C1264v {
        public C1684j(View view) {
            super(view);
        }
    }

    static class C1685a extends C1684j {
        public C1685a(View view) {
            super(view);
        }
    }

    class C1686b extends C1234a<C1684j> {
        final /* synthetic */ am uN;
        private final ArrayList<C1687d> uO = new ArrayList();
        private ql uP;
        private boolean uk;

        public /* synthetic */ C1264v mo1090c(ViewGroup viewGroup, int i) {
            return m3813b(viewGroup, i);
        }

        C1686b(am amVar) {
            this.uN = amVar;
            fb();
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public int getItemCount() {
            return this.uO.size();
        }

        public int getItemViewType(int i) {
            C1687d c1687d = (C1687d) this.uO.get(i);
            if (c1687d instanceof C1689e) {
                return 2;
            }
            if (c1687d instanceof C1688c) {
                return 3;
            }
            if (!(c1687d instanceof C1690f)) {
                throw new RuntimeException("Unknown item type.");
            } else if (((C1690f) c1687d).fd().hasSubMenu()) {
                return 1;
            } else {
                return 0;
            }
        }

        public C1684j m3813b(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    return new C1691g(this.uN.mLayoutInflater, viewGroup, this.uN.mOnClickListener);
                case 1:
                    return new C1693i(this.uN.mLayoutInflater, viewGroup);
                case 2:
                    return new C1692h(this.uN.mLayoutInflater, viewGroup);
                case 3:
                    return new C1685a(this.uN.uE);
                default:
                    return null;
            }
        }

        public void m3811a(C1684j c1684j, int i) {
            switch (getItemViewType(i)) {
                case 0:
                    View view = (NavigationMenuItemView) c1684j.arT;
                    view.setIconTintList(this.uN.uy);
                    if (this.uN.uI) {
                        view.setTextAppearance(this.uN.uH);
                    }
                    if (this.uN.uJ != null) {
                        view.setTextColor(this.uN.uJ);
                    }
                    li.m12248a(view, this.uN.uK != null ? this.uN.uK.getConstantState().newDrawable() : null);
                    C1690f c1690f = (C1690f) this.uO.get(i);
                    view.setNeedsEmptyIcon(c1690f.uR);
                    view.m1687a(c1690f.fd(), 0);
                    return;
                case 1:
                    ((TextView) c1684j.arT).setText(((C1690f) this.uO.get(i)).fd().getTitle());
                    return;
                case 2:
                    C1689e c1689e = (C1689e) this.uO.get(i);
                    c1684j.arT.setPadding(0, c1689e.getPaddingTop(), 0, c1689e.getPaddingBottom());
                    return;
                default:
                    return;
            }
        }

        public void m3810a(C1684j c1684j) {
            if (c1684j instanceof C1691g) {
                ((NavigationMenuItemView) c1684j.arT).recycle();
            }
        }

        public void update() {
            fb();
            notifyDataSetChanged();
        }

        private void fb() {
            if (!this.uk) {
                this.uk = true;
                this.uO.clear();
                this.uO.add(new C1688c());
                int i = -1;
                int i2 = 0;
                boolean z = false;
                int size = this.uN.uh.mU().size();
                int i3 = 0;
                while (i3 < size) {
                    int i4;
                    ql qlVar = (ql) this.uN.uh.mU().get(i3);
                    if (qlVar.isChecked()) {
                        m3812a(qlVar);
                    }
                    if (qlVar.isCheckable()) {
                        qlVar.ad(false);
                    }
                    int i5;
                    if (qlVar.hasSubMenu()) {
                        SubMenu subMenu = qlVar.getSubMenu();
                        if (subMenu.hasVisibleItems()) {
                            if (i3 != 0) {
                                this.uO.add(new C1689e(this.uN.uM, 0));
                            }
                            this.uO.add(new C1690f(qlVar));
                            Object obj = null;
                            int size2 = this.uO.size();
                            int size3 = subMenu.size();
                            for (i5 = 0; i5 < size3; i5++) {
                                ql qlVar2 = (ql) subMenu.getItem(i5);
                                if (qlVar2.isVisible()) {
                                    if (obj == null && qlVar2.getIcon() != null) {
                                        obj = 1;
                                    }
                                    if (qlVar2.isCheckable()) {
                                        qlVar2.ad(false);
                                    }
                                    if (qlVar.isChecked()) {
                                        m3812a(qlVar);
                                    }
                                    this.uO.add(new C1690f(qlVar2));
                                }
                            }
                            if (obj != null) {
                                m3807j(size2, this.uO.size());
                            }
                        }
                        i4 = i;
                    } else {
                        int size4;
                        boolean z2;
                        i5 = qlVar.getGroupId();
                        if (i5 != i) {
                            size4 = this.uO.size();
                            z2 = qlVar.getIcon() != null;
                            if (i3 != 0) {
                                size4++;
                                this.uO.add(new C1689e(this.uN.uM, this.uN.uM));
                            }
                        } else if (z || qlVar.getIcon() == null) {
                            z2 = z;
                            size4 = i2;
                        } else {
                            z2 = true;
                            m3807j(i2, this.uO.size());
                            size4 = i2;
                        }
                        C1690f c1690f = new C1690f(qlVar);
                        c1690f.uR = z2;
                        this.uO.add(c1690f);
                        z = z2;
                        i2 = size4;
                        i4 = i5;
                    }
                    i3++;
                    i = i4;
                }
                this.uk = false;
            }
        }

        private void m3807j(int i, int i2) {
            while (i < i2) {
                ((C1690f) this.uO.get(i)).uR = true;
                i++;
            }
        }

        public void m3812a(ql qlVar) {
            if (this.uP != qlVar && qlVar.isCheckable()) {
                if (this.uP != null) {
                    this.uP.setChecked(false);
                }
                this.uP = qlVar;
                qlVar.setChecked(true);
            }
        }

        public Bundle fc() {
            Bundle bundle = new Bundle();
            if (this.uP != null) {
                bundle.putInt("android:menu:checked", this.uP.getItemId());
            }
            SparseArray sparseArray = new SparseArray();
            int size = this.uO.size();
            for (int i = 0; i < size; i++) {
                C1687d c1687d = (C1687d) this.uO.get(i);
                if (c1687d instanceof C1690f) {
                    ql fd = ((C1690f) c1687d).fd();
                    View actionView = fd != null ? fd.getActionView() : null;
                    if (actionView != null) {
                        SparseArray aoVar = new ao();
                        actionView.saveHierarchyState(aoVar);
                        sparseArray.put(fd.getItemId(), aoVar);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:action_views", sparseArray);
            return bundle;
        }

        public void m3814b(Bundle bundle) {
            C1687d c1687d;
            ql fd;
            int i = 0;
            int i2 = bundle.getInt("android:menu:checked", 0);
            if (i2 != 0) {
                this.uk = true;
                int size = this.uO.size();
                for (int i3 = 0; i3 < size; i3++) {
                    c1687d = (C1687d) this.uO.get(i3);
                    if (c1687d instanceof C1690f) {
                        fd = ((C1690f) c1687d).fd();
                        if (fd != null && fd.getItemId() == i2) {
                            m3812a(fd);
                            break;
                        }
                    }
                }
                this.uk = false;
                fb();
            }
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:action_views");
            if (sparseParcelableArray != null) {
                i2 = this.uO.size();
                while (i < i2) {
                    c1687d = (C1687d) this.uO.get(i);
                    if (c1687d instanceof C1690f) {
                        fd = ((C1690f) c1687d).fd();
                        if (fd != null) {
                            View actionView = fd.getActionView();
                            if (actionView != null) {
                                ao aoVar = (ao) sparseParcelableArray.get(fd.getItemId());
                                if (aoVar != null) {
                                    actionView.restoreHierarchyState(aoVar);
                                }
                            }
                        }
                    }
                    i++;
                }
            }
        }

        public void m3816h(boolean z) {
            this.uk = z;
        }
    }

    interface C1687d {
    }

    static class C1688c implements C1687d {
        C1688c() {
        }
    }

    static class C1689e implements C1687d {
        private final int sM;
        private final int sO;

        public C1689e(int i, int i2) {
            this.sM = i;
            this.sO = i2;
        }

        public int getPaddingTop() {
            return this.sM;
        }

        public int getPaddingBottom() {
            return this.sO;
        }
    }

    static class C1690f implements C1687d {
        private final ql uQ;
        boolean uR;

        C1690f(ql qlVar) {
            this.uQ = qlVar;
        }

        public ql fd() {
            return this.uQ;
        }
    }

    static class C1691g extends C1684j {
        public C1691g(LayoutInflater layoutInflater, ViewGroup viewGroup, OnClickListener onClickListener) {
            super(layoutInflater.inflate(C1627h.design_navigation_item, viewGroup, false));
            this.arT.setOnClickListener(onClickListener);
        }
    }

    static class C1692h extends C1684j {
        public C1692h(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(C1627h.design_navigation_item_separator, viewGroup, false));
        }
    }

    static class C1693i extends C1684j {
        public C1693i(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(C1627h.design_navigation_item_subheader, viewGroup, false));
        }
    }

    public void m3819a(Context context, qj qjVar) {
        this.mLayoutInflater = LayoutInflater.from(context);
        this.uh = qjVar;
        this.uM = context.getResources().getDimensionPixelOffset(C1623d.design_navigation_separator_vertical_padding);
    }

    public qr m3818a(ViewGroup viewGroup) {
        if (this.uD == null) {
            this.uD = (NavigationMenuView) this.mLayoutInflater.inflate(C1627h.design_navigation_menu, viewGroup, false);
            if (this.uG == null) {
                this.uG = new C1686b(this);
            }
            this.uE = (LinearLayout) this.mLayoutInflater.inflate(C1627h.design_navigation_item_header, this.uD, false);
            this.uD.setAdapter(this.uG);
        }
        return this.uD;
    }

    public void m3827g(boolean z) {
        if (this.uG != null) {
            this.uG.update();
        }
    }

    public void m3823a(a aVar) {
        this.uF = aVar;
    }

    public boolean m3825a(qw qwVar) {
        return false;
    }

    public void m3821a(qj qjVar, boolean z) {
        if (this.uF != null) {
            this.uF.a(qjVar, z);
        }
    }

    public boolean eW() {
        return false;
    }

    public boolean m3824a(qj qjVar, ql qlVar) {
        return false;
    }

    public boolean m3826b(qj qjVar, ql qlVar) {
        return false;
    }

    public int getId() {
        return this.mId;
    }

    public void setId(int i) {
        this.mId = i;
    }

    public Parcelable onSaveInstanceState() {
        if (VERSION.SDK_INT < 11) {
            return null;
        }
        Parcelable bundle = new Bundle();
        if (this.uD != null) {
            SparseArray sparseArray = new SparseArray();
            this.uD.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        if (this.uG != null) {
            bundle.putBundle("android:menu:adapter", this.uG.fc());
        }
        if (this.uE == null) {
            return bundle;
        }
        sparseArray = new SparseArray();
        this.uE.saveHierarchyState(sparseArray);
        bundle.putSparseParcelableArray("android:menu:header", sparseArray);
        return bundle;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.uD.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                this.uG.m3814b(bundle2);
            }
            sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:header");
            if (sparseParcelableArray != null) {
                this.uE.restoreHierarchyState(sparseParcelableArray);
            }
        }
    }

    public void m3822a(ql qlVar) {
        this.uG.m3812a(qlVar);
    }

    public View m3817D(int i) {
        View inflate = this.mLayoutInflater.inflate(i, this.uE, false);
        addHeaderView(inflate);
        return inflate;
    }

    public void addHeaderView(View view) {
        this.uE.addView(view);
        this.uD.setPadding(0, 0, 0, this.uD.getPaddingBottom());
    }

    public int getHeaderCount() {
        return this.uE.getChildCount();
    }

    public ColorStateList fa() {
        return this.uy;
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.uy = colorStateList;
        m3827g(false);
    }

    public ColorStateList getItemTextColor() {
        return this.uJ;
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.uJ = colorStateList;
        m3827g(false);
    }

    public void setItemTextAppearance(int i) {
        this.uH = i;
        this.uI = true;
        m3827g(false);
    }

    public Drawable getItemBackground() {
        return this.uK;
    }

    public void setItemBackground(Drawable drawable) {
        this.uK = drawable;
        m3827g(false);
    }

    public void m3828h(boolean z) {
        if (this.uG != null) {
            this.uG.m3816h(z);
        }
    }

    public void m3820a(mg mgVar) {
        int systemWindowInsetTop = mgVar.getSystemWindowInsetTop();
        if (this.uL != systemWindowInsetTop) {
            this.uL = systemWindowInsetTop;
            if (this.uE.getChildCount() == 0) {
                this.uD.setPadding(0, this.uL, 0, this.uD.getPaddingBottom());
            }
        }
        li.m12253b(this.uE, mgVar);
    }
}
