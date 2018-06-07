package com.fossil;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.ActionBarOverlayLayout.a;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.fossil.pk.C3982a;
import com.fossil.pk.C3987f;
import com.fossil.pk.C3991j;
import com.fossil.pu.C3965a;
import com.fossil.qj.C3950a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class pj extends ActionBar implements a {
    static final /* synthetic */ boolean $assertionsDisabled = (!pj.class.desiredAssertionStatus());
    private static final Interpolator adn = new AccelerateInterpolator();
    private static final Interpolator ado = new DecelerateInterpolator();
    private static final boolean adp;
    private ArrayList<Object> AQ = new ArrayList();
    private Activity IX;
    rt acQ;
    private boolean acU;
    private ArrayList<ActionBar.a> acV = new ArrayList();
    C3965a adA;
    private boolean adB;
    private int adC = 0;
    boolean adD = true;
    boolean adE;
    boolean adF;
    private boolean adG;
    private boolean adH = true;
    qa adI;
    private boolean adJ;
    boolean adK;
    final md adL = new C39781(this);
    final md adM = new C39792(this);
    final mf adN = new C39803(this);
    private Context adq;
    ActionBarOverlayLayout adr;
    ActionBarContainer ads;
    ActionBarContextView adt;
    View adu;
    sn adv;
    private int adw = -1;
    private boolean adx;
    C3981a ady;
    pu adz;
    Context mContext;
    private Dialog mDialog;

    class C39781 extends me {
        final /* synthetic */ pj adO;

        C39781(pj pjVar) {
            this.adO = pjVar;
        }

        public void m13059f(View view) {
            if (this.adO.adD && this.adO.adu != null) {
                li.f(this.adO.adu, 0.0f);
                li.f(this.adO.ads, 0.0f);
            }
            this.adO.ads.setVisibility(8);
            this.adO.ads.setTransitioning(false);
            this.adO.adI = null;
            this.adO.lX();
            if (this.adO.adr != null) {
                li.aj(this.adO.adr);
            }
        }
    }

    class C39792 extends me {
        final /* synthetic */ pj adO;

        C39792(pj pjVar) {
            this.adO = pjVar;
        }

        public void m13060f(View view) {
            this.adO.adI = null;
            this.adO.ads.requestLayout();
        }
    }

    class C39803 implements mf {
        final /* synthetic */ pj adO;

        C39803(pj pjVar) {
            this.adO = pjVar;
        }

        public void aH(View view) {
            ((View) this.adO.ads.getParent()).invalidate();
        }
    }

    public class C3981a extends pu implements C3950a {
        final /* synthetic */ pj adO;
        private final Context adP;
        private C3965a adQ;
        private WeakReference<View> adR;
        private final qj uh;

        public C3981a(pj pjVar, Context context, C3965a c3965a) {
            this.adO = pjVar;
            this.adP = context;
            this.adQ = c3965a;
            this.uh = new qj(context).cx(1);
            this.uh.mo4047a((C3950a) this);
        }

        public MenuInflater getMenuInflater() {
            return new pz(this.adP);
        }

        public Menu getMenu() {
            return this.uh;
        }

        public void finish() {
            if (this.adO.ady == this) {
                if (pj.m13065b(this.adO.adE, this.adO.adF, false)) {
                    this.adQ.mo3999c(this);
                } else {
                    this.adO.adz = this;
                    this.adO.adA = this.adQ;
                }
                this.adQ = null;
                this.adO.m13072X(false);
                this.adO.adt.ny();
                this.adO.acQ.oJ().sendAccessibilityEvent(32);
                this.adO.adr.setHideOnContentScrollEnabled(this.adO.adK);
                this.adO.ady = null;
            }
        }

        public void invalidate() {
            if (this.adO.ady == this) {
                this.uh.mS();
                try {
                    this.adQ.mo3998b(this, this.uh);
                } finally {
                    this.uh.mT();
                }
            }
        }

        public boolean mf() {
            this.uh.mS();
            try {
                boolean a = this.adQ.mo3996a((pu) this, this.uh);
                return a;
            } finally {
                this.uh.mT();
            }
        }

        public void setCustomView(View view) {
            this.adO.adt.setCustomView(view);
            this.adR = new WeakReference(view);
        }

        public void setSubtitle(CharSequence charSequence) {
            this.adO.adt.setSubtitle(charSequence);
        }

        public void setTitle(CharSequence charSequence) {
            this.adO.adt.setTitle(charSequence);
        }

        public void setTitle(int i) {
            setTitle(this.adO.mContext.getResources().getString(i));
        }

        public void setSubtitle(int i) {
            setSubtitle(this.adO.mContext.getResources().getString(i));
        }

        public CharSequence getTitle() {
            return this.adO.adt.getTitle();
        }

        public CharSequence getSubtitle() {
            return this.adO.adt.getSubtitle();
        }

        public void setTitleOptionalHint(boolean z) {
            super.setTitleOptionalHint(z);
            this.adO.adt.setTitleOptional(z);
        }

        public boolean isTitleOptional() {
            return this.adO.adt.isTitleOptional();
        }

        public View getCustomView() {
            return this.adR != null ? (View) this.adR.get() : null;
        }

        public boolean mo3968a(qj qjVar, MenuItem menuItem) {
            if (this.adQ != null) {
                return this.adQ.mo3997a((pu) this, menuItem);
            }
            return false;
        }

        public void mo3970b(qj qjVar) {
            if (this.adQ != null) {
                invalidate();
                this.adO.adt.showOverflowMenu();
            }
        }
    }

    static {
        boolean z = true;
        if (VERSION.SDK_INT < 14) {
            z = false;
        }
        adp = z;
    }

    public pj(Activity activity, boolean z) {
        this.IX = activity;
        View decorView = activity.getWindow().getDecorView();
        bn(decorView);
        if (!z) {
            this.adu = decorView.findViewById(16908290);
        }
    }

    public pj(Dialog dialog) {
        this.mDialog = dialog;
        bn(dialog.getWindow().getDecorView());
    }

    private void bn(View view) {
        this.adr = (ActionBarOverlayLayout) view.findViewById(C3987f.decor_content_parent);
        if (this.adr != null) {
            this.adr.setActionBarVisibilityCallback(this);
        }
        this.acQ = bo(view.findViewById(C3987f.action_bar));
        this.adt = (ActionBarContextView) view.findViewById(C3987f.action_context_bar);
        this.ads = (ActionBarContainer) view.findViewById(C3987f.action_bar_container);
        if (this.acQ == null || this.adt == null || this.ads == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with a compatible window decor layout");
        }
        this.mContext = this.acQ.getContext();
        boolean z = (this.acQ.getDisplayOptions() & 4) != 0;
        if (z) {
            this.adx = true;
        }
        pt w = pt.m13087w(this.mContext);
        if (w.mm() || z) {
            z = true;
        } else {
            z = false;
        }
        setHomeButtonEnabled(z);
        m13063S(w.mk());
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(null, C3991j.ActionBar, C3982a.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(C3991j.ActionBar_hideOnContentScroll, false)) {
            setHideOnContentScrollEnabled(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C3991j.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            setElevation((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    private rt bo(View view) {
        if (view instanceof rt) {
            return (rt) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException(new StringBuilder().append("Can't make a decor toolbar out of ").append(view).toString() != null ? view.getClass().getSimpleName() : "null");
    }

    public void setElevation(float f) {
        li.l(this.ads, f);
    }

    public void onConfigurationChanged(Configuration configuration) {
        m13063S(pt.m13087w(this.mContext).mk());
    }

    private void m13063S(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = true;
        this.adB = z;
        if (this.adB) {
            this.ads.setTabContainer(null);
            this.acQ.mo4126a(this.adv);
        } else {
            this.acQ.mo4126a(null);
            this.ads.setTabContainer(this.adv);
        }
        if (getNavigationMode() == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.adv != null) {
            if (z2) {
                this.adv.setVisibility(0);
                if (this.adr != null) {
                    li.aj(this.adr);
                }
            } else {
                this.adv.setVisibility(8);
            }
        }
        rt rtVar = this.acQ;
        if (this.adB || !z2) {
            z3 = false;
        } else {
            z3 = true;
        }
        rtVar.setCollapsible(z3);
        ActionBarOverlayLayout actionBarOverlayLayout = this.adr;
        if (this.adB || !z2) {
            z4 = false;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z4);
    }

    void lX() {
        if (this.adA != null) {
            this.adA.mo3999c(this.adz);
            this.adz = null;
            this.adA = null;
        }
    }

    public void onWindowVisibilityChanged(int i) {
        this.adC = i;
    }

    public void m13067P(boolean z) {
        this.adJ = z;
        if (!z && this.adI != null) {
            this.adI.cancel();
        }
    }

    public void m13068Q(boolean z) {
        if (z != this.acU) {
            this.acU = z;
            int size = this.acV.size();
            for (int i = 0; i < size; i++) {
                ((ActionBar.a) this.acV.get(i)).onMenuVisibilityChanged(z);
            }
        }
    }

    public void setDisplayHomeAsUpEnabled(boolean z) {
        setDisplayOptions(z ? 4 : 0, 4);
    }

    public void setHomeButtonEnabled(boolean z) {
        this.acQ.setHomeButtonEnabled(z);
    }

    public void setWindowTitle(CharSequence charSequence) {
        this.acQ.setWindowTitle(charSequence);
    }

    public boolean requestFocus() {
        ViewGroup oJ = this.acQ.oJ();
        if (oJ == null || oJ.hasFocus()) {
            return false;
        }
        oJ.requestFocus();
        return true;
    }

    public void setDisplayOptions(int i, int i2) {
        int displayOptions = this.acQ.getDisplayOptions();
        if ((i2 & 4) != 0) {
            this.adx = true;
        }
        this.acQ.setDisplayOptions((displayOptions & (i2 ^ -1)) | (i & i2));
    }

    public CharSequence getTitle() {
        return this.acQ.getTitle();
    }

    public int getNavigationMode() {
        return this.acQ.getNavigationMode();
    }

    public int getDisplayOptions() {
        return this.acQ.getDisplayOptions();
    }

    public pu m13073a(C3965a c3965a) {
        if (this.ady != null) {
            this.ady.finish();
        }
        this.adr.setHideOnContentScrollEnabled(false);
        this.adt.nz();
        pu c3981a = new C3981a(this, this.adt.getContext(), c3965a);
        if (!c3981a.mf()) {
            return null;
        }
        this.ady = c3981a;
        c3981a.invalidate();
        this.adt.e(c3981a);
        m13072X(true);
        this.adt.sendAccessibilityEvent(32);
        return c3981a;
    }

    public int getHeight() {
        return this.ads.getHeight();
    }

    public void m13069T(boolean z) {
        this.adD = z;
    }

    private void lY() {
        if (!this.adG) {
            this.adG = true;
            if (this.adr != null) {
                this.adr.setShowingForActionMode(true);
            }
            m13064U(false);
        }
    }

    public void lZ() {
        if (this.adF) {
            this.adF = false;
            m13064U(true);
        }
    }

    private void ma() {
        if (this.adG) {
            this.adG = false;
            if (this.adr != null) {
                this.adr.setShowingForActionMode(false);
            }
            m13064U(false);
        }
    }

    public void mb() {
        if (!this.adF) {
            this.adF = true;
            m13064U(true);
        }
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (!z || this.adr.nA()) {
            this.adK = z;
            this.adr.setHideOnContentScrollEnabled(z);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    public int getHideOffset() {
        return this.adr.getActionBarHideOffset();
    }

    static boolean m13065b(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        if (z || z2) {
            return false;
        }
        return true;
    }

    private void m13064U(boolean z) {
        if (m13065b(this.adE, this.adF, this.adG)) {
            if (!this.adH) {
                this.adH = true;
                m13070V(z);
            }
        } else if (this.adH) {
            this.adH = false;
            m13071W(z);
        }
    }

    public void m13070V(boolean z) {
        if (this.adI != null) {
            this.adI.cancel();
        }
        this.ads.setVisibility(0);
        if (this.adC == 0 && adp && (this.adJ || z)) {
            li.f(this.ads, 0.0f);
            float f = (float) (-this.ads.getHeight());
            if (z) {
                int[] iArr = new int[]{0, 0};
                this.ads.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            li.f(this.ads, f);
            qa qaVar = new qa();
            lz A = li.ae(this.ads).A(0.0f);
            A.a(this.adN);
            qaVar.m13107a(A);
            if (this.adD && this.adu != null) {
                li.f(this.adu, f);
                qaVar.m13107a(li.ae(this.adu).A(0.0f));
            }
            qaVar.m13110d(ado);
            qaVar.m13111q(250);
            qaVar.m13109b(this.adM);
            this.adI = qaVar;
            qaVar.start();
        } else {
            li.g(this.ads, 1.0f);
            li.f(this.ads, 0.0f);
            if (this.adD && this.adu != null) {
                li.f(this.adu, 0.0f);
            }
            this.adM.f(null);
        }
        if (this.adr != null) {
            li.aj(this.adr);
        }
    }

    public void m13071W(boolean z) {
        if (this.adI != null) {
            this.adI.cancel();
        }
        if (this.adC == 0 && adp && (this.adJ || z)) {
            li.g(this.ads, 1.0f);
            this.ads.setTransitioning(true);
            qa qaVar = new qa();
            float f = (float) (-this.ads.getHeight());
            if (z) {
                int[] iArr = new int[]{0, 0};
                this.ads.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            lz A = li.ae(this.ads).A(f);
            A.a(this.adN);
            qaVar.m13107a(A);
            if (this.adD && this.adu != null) {
                qaVar.m13107a(li.ae(this.adu).A(f));
            }
            qaVar.m13110d(adn);
            qaVar.m13111q(250);
            qaVar.m13109b(this.adL);
            this.adI = qaVar;
            qaVar.start();
            return;
        }
        this.adL.f(null);
    }

    public boolean isShowing() {
        int height = getHeight();
        return this.adH && (height == 0 || getHideOffset() < height);
    }

    public void m13072X(boolean z) {
        if (z) {
            lY();
        } else {
            ma();
        }
        if (mc()) {
            lz c;
            lz c2;
            if (z) {
                c = this.acQ.mo4127c(4, 100);
                c2 = this.adt.c(0, 200);
            } else {
                c2 = this.acQ.mo4127c(0, 200);
                c = this.adt.c(8, 100);
            }
            qa qaVar = new qa();
            qaVar.m13108a(c, c2);
            qaVar.start();
        } else if (z) {
            this.acQ.setVisibility(4);
            this.adt.setVisibility(0);
        } else {
            this.acQ.setVisibility(0);
            this.adt.setVisibility(8);
        }
    }

    private boolean mc() {
        return li.as(this.ads);
    }

    public Context getThemedContext() {
        if (this.adq == null) {
            TypedValue typedValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(C3982a.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.adq = new ContextThemeWrapper(this.mContext, i);
            } else {
                this.adq = this.mContext;
            }
        }
        return this.adq;
    }

    public void setHomeAsUpIndicator(int i) {
        this.acQ.setNavigationIcon(i);
    }

    public void md() {
        if (this.adI != null) {
            this.adI.cancel();
            this.adI = null;
        }
    }

    public void me() {
    }

    public boolean collapseActionView() {
        if (this.acQ == null || !this.acQ.hasExpandedActionView()) {
            return false;
        }
        this.acQ.collapseActionView();
        return true;
    }

    public void m13066O(boolean z) {
        if (!this.adx) {
            setDisplayHomeAsUpEnabled(z);
        }
    }
}
