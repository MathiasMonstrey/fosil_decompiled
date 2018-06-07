package com.fossil;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.ActionMenuItemView.b;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.AppCompatImageView;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.fossil.kc.a;
import com.fossil.pk.C3982a;
import com.fossil.pk.C3988g;
import com.fossil.qq.C3962a;
import com.fossil.qr.C4019a;
import java.util.ArrayList;

public class rb extends qd implements a {
    private int aiA;
    private int aiB;
    private boolean aiC;
    private boolean aiD;
    private boolean aiE;
    private boolean aiF;
    private int aiG;
    private final SparseBooleanArray aiH = new SparseBooleanArray();
    private View aiI;
    C4029e aiJ;
    C4024a aiK;
    C4026c aiL;
    private C4025b aiM;
    final C4030f aiN = new C4030f(this);
    int aiO;
    C4028d aiu;
    private Drawable aiv;
    private boolean aiw;
    private boolean aix;
    private boolean aiy;
    private int aiz;

    class C4024a extends qp {
        final /* synthetic */ rb aiP;

        public C4024a(rb rbVar, Context context, qw qwVar, View view) {
            this.aiP = rbVar;
            super(context, qwVar, view, false, C3982a.actionOverflowMenuStyle);
            if (!((ql) qwVar.getItem()).nl()) {
                setAnchorView(rbVar.aiu == null ? (View) rbVar.afo : rbVar.aiu);
            }
            m13205c(rbVar.aiN);
        }

        protected void onDismiss() {
            this.aiP.aiK = null;
            this.aiP.aiO = 0;
            super.onDismiss();
        }
    }

    class C4025b extends b {
        final /* synthetic */ rb aiP;

        C4025b(rb rbVar) {
            this.aiP = rbVar;
        }

        public qu mC() {
            return this.aiP.aiK != null ? this.aiP.aiK.ns() : null;
        }
    }

    class C4026c implements Runnable {
        final /* synthetic */ rb aiP;
        private C4029e aiQ;

        public C4026c(rb rbVar, C4029e c4029e) {
            this.aiP = rbVar;
            this.aiQ = c4029e;
        }

        public void run() {
            if (this.aiP.uh != null) {
                this.aiP.uh.mR();
            }
            View view = (View) this.aiP.afo;
            if (!(view == null || view.getWindowToken() == null || !this.aiQ.nt())) {
                this.aiP.aiJ = this.aiQ;
            }
            this.aiP.aiL = null;
        }
    }

    class C4028d extends AppCompatImageView implements ActionMenuView.a {
        final /* synthetic */ rb aiP;
        private final float[] aiR = new float[2];

        public C4028d(final rb rbVar, Context context) {
            this.aiP = rbVar;
            super(context, null, C3982a.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            setOnTouchListener(new ry(this, this) {
                final /* synthetic */ C4028d aiT;

                public qu mC() {
                    if (this.aiT.aiP.aiJ == null) {
                        return null;
                    }
                    return this.aiT.aiP.aiJ.ns();
                }

                public boolean mD() {
                    this.aiT.aiP.showOverflowMenu();
                    return true;
                }

                public boolean nN() {
                    if (this.aiT.aiP.aiL != null) {
                        return false;
                    }
                    this.aiT.aiP.hideOverflowMenu();
                    return true;
                }
            });
        }

        public boolean performClick() {
            if (!super.performClick()) {
                playSoundEffect(0);
                this.aiP.showOverflowMenu();
            }
            return true;
        }

        public boolean mA() {
            return false;
        }

        public boolean mB() {
            return false;
        }

        protected boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                width = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                height = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                hh.a(background, width - max, height - max, width + max, height + max);
            }
            return frame;
        }
    }

    class C4029e extends qp {
        final /* synthetic */ rb aiP;

        public C4029e(rb rbVar, Context context, qj qjVar, View view, boolean z) {
            this.aiP = rbVar;
            super(context, qjVar, view, z, C3982a.actionOverflowMenuStyle);
            setGravity(8388613);
            m13205c(rbVar.aiN);
        }

        protected void onDismiss() {
            if (this.aiP.uh != null) {
                this.aiP.uh.close();
            }
            this.aiP.aiJ = null;
            super.onDismiss();
        }
    }

    class C4030f implements C3962a {
        final /* synthetic */ rb aiP;

        C4030f(rb rbVar) {
            this.aiP = rbVar;
        }

        public boolean mo3995d(qj qjVar) {
            if (qjVar == null) {
                return false;
            }
            this.aiP.aiO = ((qw) qjVar).getItem().getItemId();
            C3962a mE = this.aiP.mE();
            return mE != null ? mE.mo3995d(qjVar) : false;
        }

        public void mo3994a(qj qjVar, boolean z) {
            if (qjVar instanceof qw) {
                qjVar.nb().ab(false);
            }
            C3962a mE = this.aiP.mE();
            if (mE != null) {
                mE.mo3994a(qjVar, z);
            }
        }
    }

    static class C4032g implements Parcelable {
        public static final Creator<C4032g> CREATOR = new C40311();
        public int aiU;

        static class C40311 implements Creator<C4032g> {
            C40311() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m13254v(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return cE(i);
            }

            public C4032g m13254v(Parcel parcel) {
                return new C4032g(parcel);
            }

            public C4032g[] cE(int i) {
                return new C4032g[i];
            }
        }

        C4032g() {
        }

        C4032g(Parcel parcel) {
            this.aiU = parcel.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.aiU);
        }
    }

    public rb(Context context) {
        super(context, C3988g.abc_action_menu_layout, C3988g.abc_action_menu_item_layout);
    }

    public void mo4018a(Context context, qj qjVar) {
        super.mo4018a(context, qjVar);
        Resources resources = context.getResources();
        pt w = pt.m13087w(context);
        if (!this.aiy) {
            this.aix = w.mi();
        }
        if (!this.aiE) {
            this.aiz = w.mj();
        }
        if (!this.aiC) {
            this.aiB = w.mh();
        }
        int i = this.aiz;
        if (this.aix) {
            if (this.aiu == null) {
                this.aiu = new C4028d(this, this.afk);
                if (this.aiw) {
                    this.aiu.setImageDrawable(this.aiv);
                    this.aiv = null;
                    this.aiw = false;
                }
                int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
                this.aiu.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.aiu.getMeasuredWidth();
        } else {
            this.aiu = null;
        }
        this.aiA = i;
        this.aiG = (int) (56.0f * resources.getDisplayMetrics().density);
        this.aiI = null;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!this.aiC) {
            this.aiB = pt.m13087w(this.mContext).mh();
        }
        if (this.uh != null) {
            this.uh.m13193i(true);
        }
    }

    public void ai(boolean z) {
        this.aix = z;
        this.aiy = true;
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.aiF = z;
    }

    public void setOverflowIcon(Drawable drawable) {
        if (this.aiu != null) {
            this.aiu.setImageDrawable(drawable);
            return;
        }
        this.aiw = true;
        this.aiv = drawable;
    }

    public Drawable getOverflowIcon() {
        if (this.aiu != null) {
            return this.aiu.getDrawable();
        }
        if (this.aiw) {
            return this.aiv;
        }
        return null;
    }

    public qr mo4063a(ViewGroup viewGroup) {
        qr qrVar = this.afo;
        qr a = super.mo4063a(viewGroup);
        if (qrVar != a) {
            ((ActionMenuView) a).setPresenter(this);
        }
        return a;
    }

    public View mo4062a(ql qlVar, View view, ViewGroup viewGroup) {
        View actionView = qlVar.getActionView();
        if (actionView == null || qlVar.np()) {
            actionView = super.mo4062a(qlVar, view, viewGroup);
        }
        actionView.setVisibility(qlVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.e(layoutParams));
        }
        return actionView;
    }

    public void mo4064a(ql qlVar, C4019a c4019a) {
        c4019a.m13206a(qlVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) c4019a;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.afo);
        if (this.aiM == null) {
            this.aiM = new C4025b(this);
        }
        actionMenuItemView.setPopupCallback(this.aiM);
    }

    public boolean mo4065a(int i, ql qlVar) {
        return qlVar.nl();
    }

    public void mo4025g(boolean z) {
        int i;
        int i2 = 1;
        int i3 = 0;
        ViewGroup viewGroup = (ViewGroup) ((View) this.afo).getParent();
        if (viewGroup != null) {
            ps.beginDelayedTransition(viewGroup);
        }
        super.mo4025g(z);
        ((View) this.afo).requestLayout();
        if (this.uh != null) {
            ArrayList mW = this.uh.mW();
            int size = mW.size();
            for (i = 0; i < size; i++) {
                kc iP = ((ql) mW.get(i)).iP();
                if (iP != null) {
                    iP.setSubUiVisibilityListener(this);
                }
            }
        }
        ArrayList mX = this.uh != null ? this.uh.mX() : null;
        if (this.aix && mX != null) {
            i = mX.size();
            if (i == 1) {
                int i4;
                if (((ql) mX.get(0)).isActionViewExpanded()) {
                    i4 = 0;
                } else {
                    i4 = 1;
                }
                i3 = i4;
            } else {
                if (i <= 0) {
                    i2 = 0;
                }
                i3 = i2;
            }
        }
        if (i3 != 0) {
            if (this.aiu == null) {
                this.aiu = new C4028d(this, this.afk);
            }
            viewGroup = (ViewGroup) this.aiu.getParent();
            if (viewGroup != this.afo) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.aiu);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.afo;
                actionMenuView.addView(this.aiu, actionMenuView.nQ());
            }
        } else if (this.aiu != null && this.aiu.getParent() == this.afo) {
            ((ViewGroup) this.afo).removeView(this.aiu);
        }
        ((ActionMenuView) this.afo).setOverflowReserved(this.aix);
    }

    public boolean mo4066e(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.aiu) {
            return false;
        }
        return super.mo4066e(viewGroup, i);
    }

    public boolean mo4022a(qw qwVar) {
        if (!qwVar.hasVisibleItems()) {
            return false;
        }
        qw qwVar2 = qwVar;
        while (qwVar2.nv() != this.uh) {
            qwVar2 = (qw) qwVar2.nv();
        }
        View i = m13261i(qwVar2.getItem());
        if (i == null) {
            return false;
        }
        boolean z;
        this.aiO = qwVar.getItem().getItemId();
        int size = qwVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = qwVar.getItem(i2);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
        }
        z = false;
        this.aiK = new C4024a(this, this.mContext, qwVar, i);
        this.aiK.setForceShowIcon(z);
        this.aiK.show();
        super.mo4022a(qwVar);
        return true;
    }

    private View m13261i(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.afo;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof C4019a) && ((C4019a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public boolean showOverflowMenu() {
        if (!this.aix || isOverflowMenuShowing() || this.uh == null || this.afo == null || this.aiL != null || this.uh.mX().isEmpty()) {
            return false;
        }
        this.aiL = new C4026c(this, new C4029e(this, this.mContext, this.uh, this.aiu, true));
        ((View) this.afo).post(this.aiL);
        super.mo4022a(null);
        return true;
    }

    public boolean hideOverflowMenu() {
        if (this.aiL == null || this.afo == null) {
            qp qpVar = this.aiJ;
            if (qpVar == null) {
                return false;
            }
            qpVar.dismiss();
            return true;
        }
        ((View) this.afo).removeCallbacks(this.aiL);
        this.aiL = null;
        return true;
    }

    public boolean nL() {
        return hideOverflowMenu() | nM();
    }

    public boolean nM() {
        if (this.aiK == null) {
            return false;
        }
        this.aiK.dismiss();
        return true;
    }

    public boolean isOverflowMenuShowing() {
        return this.aiJ != null && this.aiJ.isShowing();
    }

    public boolean nJ() {
        return this.aiL != null || isOverflowMenuShowing();
    }

    public boolean eW() {
        int size;
        ArrayList arrayList;
        int i;
        if (this.uh != null) {
            ArrayList mU = this.uh.mU();
            size = mU.size();
            arrayList = mU;
        } else {
            size = 0;
            arrayList = null;
        }
        int i2 = this.aiB;
        int i3 = this.aiA;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.afo;
        int i4 = 0;
        int i5 = 0;
        Object obj = null;
        int i6 = 0;
        while (i6 < size) {
            ql qlVar = (ql) arrayList.get(i6);
            if (qlVar.nn()) {
                i4++;
            } else if (qlVar.nm()) {
                i5++;
            } else {
                obj = 1;
            }
            if (this.aiF && qlVar.isActionViewExpanded()) {
                i = 0;
            } else {
                i = i2;
            }
            i6++;
            i2 = i;
        }
        if (this.aix && (r4 != null || i4 + i5 > i2)) {
            i2--;
        }
        i6 = i2 - i4;
        SparseBooleanArray sparseBooleanArray = this.aiH;
        sparseBooleanArray.clear();
        i = 0;
        if (this.aiD) {
            i = i3 / this.aiG;
            i5 = ((i3 % this.aiG) / i) + this.aiG;
        } else {
            i5 = 0;
        }
        int i7 = 0;
        i2 = 0;
        int i8 = i;
        while (i7 < size) {
            qlVar = (ql) arrayList.get(i7);
            int i9;
            if (qlVar.nn()) {
                View a = mo4062a(qlVar, this.aiI, viewGroup);
                if (this.aiI == null) {
                    this.aiI = a;
                }
                if (this.aiD) {
                    i8 -= ActionMenuView.g(a, i5, i8, makeMeasureSpec, 0);
                } else {
                    a.measure(makeMeasureSpec, makeMeasureSpec);
                }
                i4 = a.getMeasuredWidth();
                i9 = i3 - i4;
                if (i2 != 0) {
                    i4 = i2;
                }
                i2 = qlVar.getGroupId();
                if (i2 != 0) {
                    sparseBooleanArray.put(i2, true);
                }
                qlVar.ag(true);
                i = i9;
                i2 = i6;
            } else if (qlVar.nm()) {
                boolean z;
                int groupId = qlVar.getGroupId();
                boolean z2 = sparseBooleanArray.get(groupId);
                boolean z3 = (i6 > 0 || z2) && i3 > 0 && (!this.aiD || i8 > 0);
                if (z3) {
                    View a2 = mo4062a(qlVar, this.aiI, viewGroup);
                    if (this.aiI == null) {
                        this.aiI = a2;
                    }
                    boolean z4;
                    if (this.aiD) {
                        int g = ActionMenuView.g(a2, i5, i8, makeMeasureSpec, 0);
                        i9 = i8 - g;
                        if (g == 0) {
                            i8 = 0;
                        } else {
                            z4 = z3;
                        }
                        i4 = i9;
                    } else {
                        a2.measure(makeMeasureSpec, makeMeasureSpec);
                        boolean z5 = z3;
                        i4 = i8;
                        z4 = z5;
                    }
                    i9 = a2.getMeasuredWidth();
                    i3 -= i9;
                    if (i2 == 0) {
                        i2 = i9;
                    }
                    if (this.aiD) {
                        z = i8 & (i3 >= 0 ? 1 : 0);
                        i9 = i2;
                        i2 = i4;
                    } else {
                        z = i8 & (i3 + i2 > 0 ? 1 : 0);
                        i9 = i2;
                        i2 = i4;
                    }
                } else {
                    z = z3;
                    i9 = i2;
                    i2 = i8;
                }
                if (z && groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                    i8 = i6;
                } else if (z2) {
                    sparseBooleanArray.put(groupId, false);
                    i4 = i6;
                    for (i6 = 0; i6 < i7; i6++) {
                        ql qlVar2 = (ql) arrayList.get(i6);
                        if (qlVar2.getGroupId() == groupId) {
                            if (qlVar2.nl()) {
                                i4++;
                            }
                            qlVar2.ag(false);
                        }
                    }
                    i8 = i4;
                } else {
                    i8 = i6;
                }
                if (z) {
                    i8--;
                }
                qlVar.ag(z);
                i4 = i9;
                i = i3;
                int i10 = i2;
                i2 = i8;
                i8 = i10;
            } else {
                qlVar.ag(false);
                i4 = i2;
                i = i3;
                i2 = i6;
            }
            i7++;
            i3 = i;
            i6 = i2;
            i2 = i4;
        }
        return true;
    }

    public void mo4019a(qj qjVar, boolean z) {
        nL();
        super.mo4019a(qjVar, z);
    }

    public Parcelable onSaveInstanceState() {
        Parcelable c4032g = new C4032g();
        c4032g.aiU = this.aiO;
        return c4032g;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof C4032g) {
            C4032g c4032g = (C4032g) parcelable;
            if (c4032g.aiU > 0) {
                MenuItem findItem = this.uh.findItem(c4032g.aiU);
                if (findItem != null) {
                    mo4022a((qw) findItem.getSubMenu());
                }
            }
        }
    }

    public void m13262F(boolean z) {
        if (z) {
            super.mo4022a(null);
        } else if (this.uh != null) {
            this.uh.ab(false);
        }
    }

    public void m13266a(ActionMenuView actionMenuView) {
        this.afo = actionMenuView;
        actionMenuView.a(this.uh);
    }
}
