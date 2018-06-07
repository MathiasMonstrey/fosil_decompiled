package com.fossil;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.ContentFrameLayout.a;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ViewStubCompat;
import android.support.v8.renderscript.Allocation;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.fossil.pk.C3982a;
import com.fossil.pk.C3984c;
import com.fossil.pk.C3987f;
import com.fossil.pk.C3988g;
import com.fossil.pk.C3990i;
import com.fossil.pk.C3991j;
import com.fossil.pu.C3965a;
import com.fossil.qj.C3950a;
import com.fossil.qq.C3962a;
import com.fossil.rx.C3956a;
import org.xmlpull.v1.XmlPullParser;

@TargetApi(9)
class pb extends ow implements km, C3950a {
    private static final boolean abM = (VERSION.SDK_INT < 21);
    private TextView aak;
    private rs abN;
    private C3963a abO;
    private C3969e abP;
    pu abQ;
    ActionBarContextView abR;
    PopupWindow abS;
    Runnable abT;
    lz abU = null;
    private boolean abV;
    private ViewGroup abW;
    private View abX;
    private boolean abY;
    private boolean abZ;
    private boolean aca;
    private C3968d[] acb;
    private C3968d acc;
    private boolean acd;
    boolean ace;
    int acf;
    private final Runnable acg = new C39541(this);
    private boolean ach;
    private pe aci;
    private Rect mTempRect1;
    private Rect mTempRect2;

    class C39541 implements Runnable {
        final /* synthetic */ pb acj;

        C39541(pb pbVar) {
            this.acj = pbVar;
        }

        public void run() {
            if ((this.acj.acf & 1) != 0) {
                this.acj.cm(0);
            }
            if ((this.acj.acf & 4096) != 0) {
                this.acj.cm(108);
            }
            this.acj.ace = false;
            this.acj.acf = 0;
        }
    }

    class C39552 implements kz {
        final /* synthetic */ pb acj;

        C39552(pb pbVar) {
            this.acj = pbVar;
        }

        public mg m13009a(View view, mg mgVar) {
            int systemWindowInsetTop = mgVar.getSystemWindowInsetTop();
            int cn = this.acj.cn(systemWindowInsetTop);
            if (systemWindowInsetTop != cn) {
                mgVar = mgVar.h(mgVar.getSystemWindowInsetLeft(), cn, mgVar.getSystemWindowInsetRight(), mgVar.getSystemWindowInsetBottom());
            }
            return li.a(view, mgVar);
        }
    }

    class C39573 implements C3956a {
        final /* synthetic */ pb acj;

        C39573(pb pbVar) {
            this.acj = pbVar;
        }

        public void mo3993g(Rect rect) {
            rect.top = this.acj.cn(rect.top);
        }
    }

    class C39584 implements a {
        final /* synthetic */ pb acj;

        C39584(pb pbVar) {
            this.acj = pbVar;
        }

        public void lP() {
        }

        public void onDetachedFromWindow() {
            this.acj.lO();
        }
    }

    class C39605 implements Runnable {
        final /* synthetic */ pb acj;

        class C39591 extends me {
            final /* synthetic */ C39605 ack;

            C39591(C39605 c39605) {
                this.ack = c39605;
            }

            public void m13012e(View view) {
                this.ack.acj.abR.setVisibility(0);
            }

            public void m13013f(View view) {
                li.g(this.ack.acj.abR, 1.0f);
                this.ack.acj.abU.a(null);
                this.ack.acj.abU = null;
            }
        }

        C39605(pb pbVar) {
            this.acj = pbVar;
        }

        public void run() {
            this.acj.abS.showAtLocation(this.acj.abR, 55, 0, 0);
            this.acj.lL();
            if (this.acj.lK()) {
                li.g(this.acj.abR, 0.0f);
                this.acj.abU = li.ae(this.acj.abR).y(1.0f);
                this.acj.abU.a(new C39591(this));
                return;
            }
            li.g(this.acj.abR, 1.0f);
            this.acj.abR.setVisibility(0);
        }
    }

    class C39616 extends me {
        final /* synthetic */ pb acj;

        C39616(pb pbVar) {
            this.acj = pbVar;
        }

        public void m13014e(View view) {
            this.acj.abR.setVisibility(0);
            this.acj.abR.sendAccessibilityEvent(32);
            if (this.acj.abR.getParent() instanceof View) {
                li.aj((View) this.acj.abR.getParent());
            }
        }

        public void m13015f(View view) {
            li.g(this.acj.abR, 1.0f);
            this.acj.abU.a(null);
            this.acj.abU = null;
        }
    }

    final class C3963a implements C3962a {
        final /* synthetic */ pb acj;

        C3963a(pb pbVar) {
            this.acj = pbVar;
        }

        public boolean mo3995d(qj qjVar) {
            Callback lB = this.acj.lB();
            if (lB != null) {
                lB.onMenuOpened(108, qjVar);
            }
            return true;
        }

        public void mo3994a(qj qjVar, boolean z) {
            this.acj.m12979c(qjVar);
        }
    }

    class C3966b implements C3965a {
        final /* synthetic */ pb acj;
        private C3965a acl;

        class C39641 extends me {
            final /* synthetic */ C3966b acm;

            C39641(C3966b c3966b) {
                this.acm = c3966b;
            }

            public void m13020f(View view) {
                this.acm.acj.abR.setVisibility(8);
                if (this.acm.acj.abS != null) {
                    this.acm.acj.abS.dismiss();
                } else if (this.acm.acj.abR.getParent() instanceof View) {
                    li.aj((View) this.acm.acj.abR.getParent());
                }
                this.acm.acj.abR.removeAllViews();
                this.acm.acj.abU.a(null);
                this.acm.acj.abU = null;
            }
        }

        public C3966b(pb pbVar, C3965a c3965a) {
            this.acj = pbVar;
            this.acl = c3965a;
        }

        public boolean mo3996a(pu puVar, Menu menu) {
            return this.acl.mo3996a(puVar, menu);
        }

        public boolean mo3998b(pu puVar, Menu menu) {
            return this.acl.mo3998b(puVar, menu);
        }

        public boolean mo3997a(pu puVar, MenuItem menuItem) {
            return this.acl.mo3997a(puVar, menuItem);
        }

        public void mo3999c(pu puVar) {
            this.acl.mo3999c(puVar);
            if (this.acj.abS != null) {
                this.acj.ZQ.getDecorView().removeCallbacks(this.acj.abT);
            }
            if (this.acj.abR != null) {
                this.acj.lL();
                this.acj.abU = li.ae(this.acj.abR).y(0.0f);
                this.acj.abU.a(new C39641(this));
            }
            if (this.acj.abo != null) {
                this.acj.abo.b(this.acj.abQ);
            }
            this.acj.abQ = null;
        }
    }

    class C3967c extends ContentFrameLayout {
        final /* synthetic */ pb acj;

        public C3967c(pb pbVar, Context context) {
            this.acj = pbVar;
            super(context);
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return this.acj.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !m13029O((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            this.acj.closePanel(0);
            return true;
        }

        public void setBackgroundResource(int i) {
            setBackgroundDrawable(pn.m13079c(getContext(), i));
        }

        private boolean m13029O(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }
    }

    public static final class C3968d {
        int acn;
        ViewGroup aco;
        View acp;
        View acq;
        qj acr;
        qh acs;
        Context act;
        boolean acu;
        boolean acv;
        public boolean acw;
        boolean acx = false;
        boolean acy;
        Bundle acz;
        int background;
        int gravity;
        boolean isOpen;
        int windowAnimations;
        int f1514x;
        int f1515y;

        C3968d(int i) {
            this.acn = i;
        }

        public boolean lQ() {
            if (this.acp == null) {
                return false;
            }
            if (this.acq != null || this.acs.getAdapter().getCount() > 0) {
                return true;
            }
            return false;
        }

        void m13032u(Context context) {
            TypedValue typedValue = new TypedValue();
            Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(C3982a.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            }
            newTheme.resolveAttribute(C3982a.panelMenuListTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            } else {
                newTheme.applyStyle(C3990i.Theme_AppCompat_CompactMenu, true);
            }
            Context pwVar = new pw(context, 0);
            pwVar.getTheme().setTo(newTheme);
            this.act = pwVar;
            TypedArray obtainStyledAttributes = pwVar.obtainStyledAttributes(C3991j.AppCompatTheme);
            this.background = obtainStyledAttributes.getResourceId(C3991j.AppCompatTheme_panelBackground, 0);
            this.windowAnimations = obtainStyledAttributes.getResourceId(C3991j.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }

        void m13031e(qj qjVar) {
            if (qjVar != this.acr) {
                if (this.acr != null) {
                    this.acr.m13182b(this.acs);
                }
                this.acr = qjVar;
                if (qjVar != null && this.acs != null) {
                    qjVar.m13178a(this.acs);
                }
            }
        }

        qr m13030b(C3962a c3962a) {
            if (this.acr == null) {
                return null;
            }
            if (this.acs == null) {
                this.acs = new qh(this.act, C3988g.abc_list_menu_item_layout);
                this.acs.mo4020a(c3962a);
                this.acr.m13178a(this.acs);
            }
            return this.acs.m13160a(this.aco);
        }
    }

    final class C3969e implements C3962a {
        final /* synthetic */ pb acj;

        C3969e(pb pbVar) {
            this.acj = pbVar;
        }

        public void mo3994a(qj qjVar, boolean z) {
            Menu menu;
            qj nb = qjVar.nb();
            boolean z2 = nb != qjVar;
            pb pbVar = this.acj;
            if (z2) {
                menu = nb;
            }
            C3968d a = pbVar.m12971a(menu);
            if (a == null) {
                return;
            }
            if (z2) {
                this.acj.m12972a(a.acn, a, nb);
                this.acj.m12974a(a, true);
                return;
            }
            this.acj.m12974a(a, z);
        }

        public boolean mo3995d(qj qjVar) {
            if (qjVar == null && this.acj.abq) {
                Callback lB = this.acj.lB();
                if (!(lB == null || this.acj.isDestroyed())) {
                    lB.onMenuOpened(108, qjVar);
                }
            }
            return true;
        }
    }

    pb(Context context, Window window, ou ouVar) {
        super(context, window, ouVar);
    }

    public void onCreate(Bundle bundle) {
        if ((this.abm instanceof Activity) && fl.h((Activity) this.abm) != null) {
            ActionBar ly = ly();
            if (ly == null) {
                this.ach = true;
            } else {
                ly.O(true);
            }
        }
    }

    public void onPostCreate(Bundle bundle) {
        lH();
    }

    public void lx() {
        lH();
        if (this.abq && this.abp == null) {
            if (this.abm instanceof Activity) {
                this.abp = new pj((Activity) this.abm, this.abr);
            } else if (this.abm instanceof Dialog) {
                this.abp = new pj((Dialog) this.abm);
            }
            if (this.abp != null) {
                this.abp.O(this.ach);
            }
        }
    }

    public void mo3967a(Toolbar toolbar) {
        if (this.abm instanceof Activity) {
            ActionBar lp = lp();
            if (lp instanceof pj) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.vL = null;
            if (lp != null) {
                lp.onDestroy();
            }
            if (toolbar != null) {
                ActionBar pgVar = new pg(toolbar, ((Activity) this.abm).getTitle(), this.abn);
                this.abp = pgVar;
                this.ZQ.setCallback(pgVar.lR());
            } else {
                this.abp = null;
                this.ZQ.setCallback(this.abn);
            }
            invalidateOptionsMenu();
        }
    }

    public View findViewById(int i) {
        lH();
        return this.ZQ.findViewById(i);
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.abq && this.abV) {
            ActionBar lp = lp();
            if (lp != null) {
                lp.onConfigurationChanged(configuration);
            }
        }
        rg.ou().m13344x(this.mContext);
        lu();
    }

    public void onStop() {
        ActionBar lp = lp();
        if (lp != null) {
            lp.P(false);
        }
    }

    public void onPostResume() {
        ActionBar lp = lp();
        if (lp != null) {
            lp.P(true);
        }
    }

    public void setContentView(View view) {
        lH();
        ViewGroup viewGroup = (ViewGroup) this.abW.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.abm.onContentChanged();
    }

    public void setContentView(int i) {
        lH();
        ViewGroup viewGroup = (ViewGroup) this.abW.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.mContext).inflate(i, viewGroup);
        this.abm.onContentChanged();
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        lH();
        ViewGroup viewGroup = (ViewGroup) this.abW.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.abm.onContentChanged();
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        lH();
        ((ViewGroup) this.abW.findViewById(16908290)).addView(view, layoutParams);
        this.abm.onContentChanged();
    }

    public void onDestroy() {
        if (this.ace) {
            this.ZQ.getDecorView().removeCallbacks(this.acg);
        }
        super.onDestroy();
        if (this.abp != null) {
            this.abp.onDestroy();
        }
    }

    private void lH() {
        if (!this.abV) {
            this.abW = lI();
            CharSequence title = getTitle();
            if (!TextUtils.isEmpty(title)) {
                mo3977n(title);
            }
            lJ();
            m12982k(this.abW);
            this.abV = true;
            C3968d g = m12981g(0, false);
            if (!isDestroyed()) {
                if (g == null || g.acr == null) {
                    invalidatePanelMenu(108);
                }
            }
        }
    }

    private ViewGroup lI() {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(C3991j.AppCompatTheme);
        if (obtainStyledAttributes.hasValue(C3991j.AppCompatTheme_windowActionBar)) {
            View view;
            if (obtainStyledAttributes.getBoolean(C3991j.AppCompatTheme_windowNoTitle, false)) {
                requestWindowFeature(1);
            } else if (obtainStyledAttributes.getBoolean(C3991j.AppCompatTheme_windowActionBar, false)) {
                requestWindowFeature(108);
            }
            if (obtainStyledAttributes.getBoolean(C3991j.AppCompatTheme_windowActionBarOverlay, false)) {
                requestWindowFeature(109);
            }
            if (obtainStyledAttributes.getBoolean(C3991j.AppCompatTheme_windowActionModeOverlay, false)) {
                requestWindowFeature(10);
            }
            this.abt = obtainStyledAttributes.getBoolean(C3991j.AppCompatTheme_android_windowIsFloating, false);
            obtainStyledAttributes.recycle();
            this.ZQ.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.mContext);
            if (this.abu) {
                View view2;
                if (this.abs) {
                    view2 = (ViewGroup) from.inflate(C3988g.abc_screen_simple_overlay_action_mode, null);
                } else {
                    view2 = (ViewGroup) from.inflate(C3988g.abc_screen_simple, null);
                }
                if (VERSION.SDK_INT >= 21) {
                    li.a(view2, new C39552(this));
                    view = view2;
                } else {
                    ((rx) view2).setOnFitSystemWindowsListener(new C39573(this));
                    view = view2;
                }
            } else if (this.abt) {
                r0 = (ViewGroup) from.inflate(C3988g.abc_dialog_title_material, null);
                this.abr = false;
                this.abq = false;
                view = r0;
            } else if (this.abq) {
                Context pwVar;
                TypedValue typedValue = new TypedValue();
                this.mContext.getTheme().resolveAttribute(C3982a.actionBarTheme, typedValue, true);
                if (typedValue.resourceId != 0) {
                    pwVar = new pw(this.mContext, typedValue.resourceId);
                } else {
                    pwVar = this.mContext;
                }
                r0 = (ViewGroup) LayoutInflater.from(pwVar).inflate(C3988g.abc_screen_toolbar, null);
                this.abN = (rs) r0.findViewById(C3987f.decor_content_parent);
                this.abN.setWindowCallback(lB());
                if (this.abr) {
                    this.abN.cD(109);
                }
                if (this.abY) {
                    this.abN.cD(2);
                }
                if (this.abZ) {
                    this.abN.cD(5);
                }
                view = r0;
            } else {
                view = null;
            }
            if (view == null) {
                throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.abq + ", windowActionBarOverlay: " + this.abr + ", android:windowIsFloating: " + this.abt + ", windowActionModeOverlay: " + this.abs + ", windowNoTitle: " + this.abu + " }");
            }
            if (this.abN == null) {
                this.aak = (TextView) view.findViewById(C3987f.title);
            }
            tb.cI(view);
            ContentFrameLayout contentFrameLayout = (ContentFrameLayout) view.findViewById(C3987f.action_bar_activity_content);
            ViewGroup viewGroup = (ViewGroup) this.ZQ.findViewById(16908290);
            if (viewGroup != null) {
                while (viewGroup.getChildCount() > 0) {
                    View childAt = viewGroup.getChildAt(0);
                    viewGroup.removeViewAt(0);
                    contentFrameLayout.addView(childAt);
                }
                viewGroup.setId(-1);
                contentFrameLayout.setId(16908290);
                if (viewGroup instanceof FrameLayout) {
                    ((FrameLayout) viewGroup).setForeground(null);
                }
            }
            this.ZQ.setContentView(view);
            contentFrameLayout.setAttachListener(new C39584(this));
            return view;
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    void m12982k(ViewGroup viewGroup) {
    }

    private void lJ() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.abW.findViewById(16908290);
        View decorView = this.ZQ.getDecorView();
        contentFrameLayout.l(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(C3991j.AppCompatTheme);
        obtainStyledAttributes.getValue(C3991j.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(C3991j.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(C3991j.AppCompatTheme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(C3991j.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(C3991j.AppCompatTheme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(C3991j.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(C3991j.AppCompatTheme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(C3991j.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(C3991j.AppCompatTheme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(C3991j.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    public boolean requestWindowFeature(int i) {
        int co = co(i);
        if (this.abu && co == 108) {
            return false;
        }
        if (this.abq && co == 1) {
            this.abq = false;
        }
        switch (co) {
            case 1:
                lN();
                this.abu = true;
                return true;
            case 2:
                lN();
                this.abY = true;
                return true;
            case 5:
                lN();
                this.abZ = true;
                return true;
            case 10:
                lN();
                this.abs = true;
                return true;
            case 108:
                lN();
                this.abq = true;
                return true;
            case 109:
                lN();
                this.abr = true;
                return true;
            default:
                return this.ZQ.requestFeature(co);
        }
    }

    void mo3977n(CharSequence charSequence) {
        if (this.abN != null) {
            this.abN.setWindowTitle(charSequence);
        } else if (ly() != null) {
            ly().setWindowTitle(charSequence);
        } else if (this.aak != null) {
            this.aak.setText(charSequence);
        }
    }

    void onPanelClosed(int i, Menu menu) {
        if (i == 108) {
            ActionBar lp = lp();
            if (lp != null) {
                lp.Q(false);
            }
        } else if (i == 0) {
            C3968d g = m12981g(i, true);
            if (g.isOpen) {
                m12974a(g, false);
            }
        }
    }

    boolean onMenuOpened(int i, Menu menu) {
        if (i != 108) {
            return false;
        }
        ActionBar lp = lp();
        if (lp == null) {
            return true;
        }
        lp.Q(true);
        return true;
    }

    public boolean mo3968a(qj qjVar, MenuItem menuItem) {
        Callback lB = lB();
        if (!(lB == null || isDestroyed())) {
            C3968d a = m12971a(qjVar.nb());
            if (a != null) {
                return lB.onMenuItemSelected(a.acn, menuItem);
            }
        }
        return false;
    }

    public void mo3970b(qj qjVar) {
        m12965b(qjVar, true);
    }

    public pu m12980d(C3965a c3965a) {
        if (c3965a == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        if (this.abQ != null) {
            this.abQ.finish();
        }
        C3965a c3966b = new C3966b(this, c3965a);
        ActionBar lp = lp();
        if (lp != null) {
            this.abQ = lp.a(c3966b);
            if (!(this.abQ == null || this.abo == null)) {
                this.abo.a(this.abQ);
            }
        }
        if (this.abQ == null) {
            this.abQ = mo3971c(c3966b);
        }
        return this.abQ;
    }

    public void invalidateOptionsMenu() {
        ActionBar lp = lp();
        if (lp == null || !lp.lj()) {
            invalidatePanelMenu(0);
        }
    }

    pu mo3971c(C3965a c3965a) {
        pu puVar;
        lL();
        if (this.abQ != null) {
            this.abQ.finish();
        }
        if (!(c3965a instanceof C3966b)) {
            c3965a = new C3966b(this, c3965a);
        }
        if (this.abo == null || isDestroyed()) {
            puVar = null;
        } else {
            try {
                puVar = this.abo.b(c3965a);
            } catch (AbstractMethodError e) {
                puVar = null;
            }
        }
        if (puVar != null) {
            this.abQ = puVar;
        } else {
            if (this.abR == null) {
                if (this.abt) {
                    Context pwVar;
                    TypedValue typedValue = new TypedValue();
                    Theme theme = this.mContext.getTheme();
                    theme.resolveAttribute(C3982a.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Theme newTheme = this.mContext.getResources().newTheme();
                        newTheme.setTo(theme);
                        newTheme.applyStyle(typedValue.resourceId, true);
                        pwVar = new pw(this.mContext, 0);
                        pwVar.getTheme().setTo(newTheme);
                    } else {
                        pwVar = this.mContext;
                    }
                    this.abR = new ActionBarContextView(pwVar);
                    this.abS = new PopupWindow(pwVar, null, C3982a.actionModePopupWindowStyle);
                    nz.m12858a(this.abS, 2);
                    this.abS.setContentView(this.abR);
                    this.abS.setWidth(-1);
                    pwVar.getTheme().resolveAttribute(C3982a.actionBarSize, typedValue, true);
                    this.abR.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, pwVar.getResources().getDisplayMetrics()));
                    this.abS.setHeight(-2);
                    this.abT = new C39605(this);
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.abW.findViewById(C3987f.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(lz()));
                        this.abR = (ActionBarContextView) viewStubCompat.inflate();
                    }
                }
            }
            if (this.abR != null) {
                boolean z;
                lL();
                this.abR.nz();
                Context context = this.abR.getContext();
                ActionBarContextView actionBarContextView = this.abR;
                if (this.abS == null) {
                    z = true;
                } else {
                    z = false;
                }
                pu pxVar = new px(context, actionBarContextView, c3965a, z);
                if (c3965a.mo3996a(pxVar, pxVar.getMenu())) {
                    pxVar.invalidate();
                    this.abR.e(pxVar);
                    this.abQ = pxVar;
                    if (lK()) {
                        li.g(this.abR, 0.0f);
                        this.abU = li.ae(this.abR).y(1.0f);
                        this.abU.a(new C39616(this));
                    } else {
                        li.g(this.abR, 1.0f);
                        this.abR.setVisibility(0);
                        this.abR.sendAccessibilityEvent(32);
                        if (this.abR.getParent() instanceof View) {
                            li.aj((View) this.abR.getParent());
                        }
                    }
                    if (this.abS != null) {
                        this.ZQ.getDecorView().post(this.abT);
                    }
                } else {
                    this.abQ = null;
                }
            }
        }
        if (!(this.abQ == null || this.abo == null)) {
            this.abo.a(this.abQ);
        }
        return this.abQ;
    }

    final boolean lK() {
        return this.abV && this.abW != null && li.as(this.abW);
    }

    void lL() {
        if (this.abU != null) {
            this.abU.cancel();
        }
    }

    boolean lM() {
        if (this.abQ != null) {
            this.abQ.finish();
            return true;
        }
        ActionBar lp = lp();
        if (lp == null || !lp.collapseActionView()) {
            return false;
        }
        return true;
    }

    boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        ActionBar lp = lp();
        if (lp != null && lp.onKeyShortcut(i, keyEvent)) {
            return true;
        }
        if (this.acc == null || !m12964a(this.acc, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.acc == null) {
                C3968d g = m12981g(0, true);
                m12968b(g, keyEvent);
                boolean a = m12964a(g, keyEvent.getKeyCode(), keyEvent, 1);
                g.acu = false;
                if (a) {
                    return true;
                }
            }
            return false;
        } else if (this.acc == null) {
            return true;
        } else {
            this.acc.acv = true;
            return true;
        }
    }

    boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z = true;
        if (keyEvent.getKeyCode() == 82 && this.abm.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0) {
            z = false;
        }
        return z ? onKeyDown(keyCode, keyEvent) : onKeyUp(keyCode, keyEvent);
    }

    boolean onKeyUp(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                boolean z = this.acd;
                this.acd = false;
                C3968d g = m12981g(0, false);
                if (g == null || !g.isOpen) {
                    if (lM()) {
                        return true;
                    }
                } else if (z) {
                    return true;
                } else {
                    m12974a(g, true);
                    return true;
                }
                break;
            case 82:
                m12966b(0, keyEvent);
                return true;
        }
        return false;
    }

    boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z = true;
        switch (i) {
            case 4:
                if ((keyEvent.getFlags() & Allocation.USAGE_SHARED) == 0) {
                    z = false;
                }
                this.acd = z;
                break;
            case 82:
                m12961a(0, keyEvent);
                return true;
        }
        if (VERSION.SDK_INT < 11) {
            onKeyShortcut(i, keyEvent);
        }
        return false;
    }

    public View m12976b(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        if (this.aci == null) {
            this.aci = new pe();
        }
        if (abM) {
            boolean a = attributeSet instanceof XmlPullParser ? ((XmlPullParser) attributeSet).getDepth() > 1 : m12962a((ViewParent) view);
            z = a;
        } else {
            z = false;
        }
        return this.aci.m13040a(view, str, context, attributeSet, z, abM, true, sy.sH());
    }

    private boolean m12962a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        ViewParent decorView = this.ZQ.getDecorView();
        ViewParent viewParent2 = viewParent;
        while (viewParent2 != null) {
            if (viewParent2 == decorView || !(viewParent2 instanceof View) || li.au((View) viewParent2)) {
                return false;
            }
            viewParent2 = viewParent2.getParent();
        }
        return true;
    }

    public void lt() {
        LayoutInflater from = LayoutInflater.from(this.mContext);
        if (from.getFactory() == null) {
            ki.a(from, this);
        } else if (!(ki.a(from) instanceof pb)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View a = mo3989a(view, str, context, attributeSet);
        return a != null ? a : m12976b(view, str, context, attributeSet);
    }

    View mo3989a(View view, String str, Context context, AttributeSet attributeSet) {
        if (this.abm instanceof Factory) {
            View onCreateView = ((Factory) this.abm).onCreateView(str, context, attributeSet);
            if (onCreateView != null) {
                return onCreateView;
            }
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m12960a(com.fossil.pb.C3968d r11, android.view.KeyEvent r12) {
        /*
        r10 = this;
        r1 = -1;
        r3 = 0;
        r9 = 1;
        r2 = -2;
        r0 = r11.isOpen;
        if (r0 != 0) goto L_0x000e;
    L_0x0008:
        r0 = r10.isDestroyed();
        if (r0 == 0) goto L_0x000f;
    L_0x000e:
        return;
    L_0x000f:
        r0 = r11.acn;
        if (r0 != 0) goto L_0x0034;
    L_0x0013:
        r4 = r10.mContext;
        r0 = r4.getResources();
        r0 = r0.getConfiguration();
        r0 = r0.screenLayout;
        r0 = r0 & 15;
        r5 = 4;
        if (r0 != r5) goto L_0x0048;
    L_0x0024:
        r0 = r9;
    L_0x0025:
        r4 = r4.getApplicationInfo();
        r4 = r4.targetSdkVersion;
        r5 = 11;
        if (r4 < r5) goto L_0x004a;
    L_0x002f:
        r4 = r9;
    L_0x0030:
        if (r0 == 0) goto L_0x0034;
    L_0x0032:
        if (r4 != 0) goto L_0x000e;
    L_0x0034:
        r0 = r10.lB();
        if (r0 == 0) goto L_0x004c;
    L_0x003a:
        r4 = r11.acn;
        r5 = r11.acr;
        r0 = r0.onMenuOpened(r4, r5);
        if (r0 != 0) goto L_0x004c;
    L_0x0044:
        r10.m12974a(r11, r9);
        goto L_0x000e;
    L_0x0048:
        r0 = r3;
        goto L_0x0025;
    L_0x004a:
        r4 = r3;
        goto L_0x0030;
    L_0x004c:
        r0 = r10.mContext;
        r4 = "window";
        r0 = r0.getSystemService(r4);
        r8 = r0;
        r8 = (android.view.WindowManager) r8;
        if (r8 == 0) goto L_0x000e;
    L_0x0059:
        r0 = r10.m12968b(r11, r12);
        if (r0 == 0) goto L_0x000e;
    L_0x005f:
        r0 = r11.aco;
        if (r0 == 0) goto L_0x0067;
    L_0x0063:
        r0 = r11.acx;
        if (r0 == 0) goto L_0x00f1;
    L_0x0067:
        r0 = r11.aco;
        if (r0 != 0) goto L_0x00df;
    L_0x006b:
        r0 = r10.m12963a(r11);
        if (r0 == 0) goto L_0x000e;
    L_0x0071:
        r0 = r11.aco;
        if (r0 == 0) goto L_0x000e;
    L_0x0075:
        r0 = r10.m12969c(r11);
        if (r0 == 0) goto L_0x000e;
    L_0x007b:
        r0 = r11.lQ();
        if (r0 == 0) goto L_0x000e;
    L_0x0081:
        r0 = r11.acp;
        r0 = r0.getLayoutParams();
        if (r0 != 0) goto L_0x0103;
    L_0x0089:
        r0 = new android.view.ViewGroup$LayoutParams;
        r0.<init>(r2, r2);
        r1 = r0;
    L_0x008f:
        r0 = r11.background;
        r4 = r11.aco;
        r4.setBackgroundResource(r0);
        r0 = r11.acp;
        r0 = r0.getParent();
        if (r0 == 0) goto L_0x00a9;
    L_0x009e:
        r4 = r0 instanceof android.view.ViewGroup;
        if (r4 == 0) goto L_0x00a9;
    L_0x00a2:
        r0 = (android.view.ViewGroup) r0;
        r4 = r11.acp;
        r0.removeView(r4);
    L_0x00a9:
        r0 = r11.aco;
        r4 = r11.acp;
        r0.addView(r4, r1);
        r0 = r11.acp;
        r0 = r0.hasFocus();
        if (r0 != 0) goto L_0x00bd;
    L_0x00b8:
        r0 = r11.acp;
        r0.requestFocus();
    L_0x00bd:
        r1 = r2;
    L_0x00be:
        r11.acv = r3;
        r0 = new android.view.WindowManager$LayoutParams;
        r3 = r11.f1514x;
        r4 = r11.f1515y;
        r5 = 1002; // 0x3ea float:1.404E-42 double:4.95E-321;
        r6 = 8519680; // 0x820000 float:1.1938615E-38 double:4.209281E-317;
        r7 = -3;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        r1 = r11.gravity;
        r0.gravity = r1;
        r1 = r11.windowAnimations;
        r0.windowAnimations = r1;
        r1 = r11.aco;
        r8.addView(r1, r0);
        r11.isOpen = r9;
        goto L_0x000e;
    L_0x00df:
        r0 = r11.acx;
        if (r0 == 0) goto L_0x0075;
    L_0x00e3:
        r0 = r11.aco;
        r0 = r0.getChildCount();
        if (r0 <= 0) goto L_0x0075;
    L_0x00eb:
        r0 = r11.aco;
        r0.removeAllViews();
        goto L_0x0075;
    L_0x00f1:
        r0 = r11.acq;
        if (r0 == 0) goto L_0x0101;
    L_0x00f5:
        r0 = r11.acq;
        r0 = r0.getLayoutParams();
        if (r0 == 0) goto L_0x0101;
    L_0x00fd:
        r0 = r0.width;
        if (r0 == r1) goto L_0x00be;
    L_0x0101:
        r1 = r2;
        goto L_0x00be;
    L_0x0103:
        r1 = r0;
        goto L_0x008f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.pb.a(com.fossil.pb$d, android.view.KeyEvent):void");
    }

    private boolean m12963a(C3968d c3968d) {
        c3968d.m13032u(lz());
        c3968d.aco = new C3967c(this, c3968d.act);
        c3968d.gravity = 81;
        return true;
    }

    private void m12965b(qj qjVar, boolean z) {
        if (this.abN == null || !this.abN.nI() || (lt.b(ViewConfiguration.get(this.mContext)) && !this.abN.nJ())) {
            C3968d g = m12981g(0, true);
            g.acx = true;
            m12974a(g, false);
            m12960a(g, null);
            return;
        }
        Callback lB = lB();
        if (this.abN.isOverflowMenuShowing() && z) {
            this.abN.hideOverflowMenu();
            if (!isDestroyed()) {
                lB.onPanelClosed(108, m12981g(0, true).acr);
            }
        } else if (lB != null && !isDestroyed()) {
            if (this.ace && (this.acf & 1) != 0) {
                this.ZQ.getDecorView().removeCallbacks(this.acg);
                this.acg.run();
            }
            C3968d g2 = m12981g(0, true);
            if (g2.acr != null && !g2.acy && lB.onPreparePanel(0, g2.acq, g2.acr)) {
                lB.onMenuOpened(108, g2.acr);
                this.abN.showOverflowMenu();
            }
        }
    }

    private boolean m12967b(C3968d c3968d) {
        Context pwVar;
        qj qjVar;
        Context context = this.mContext;
        if ((c3968d.acn == 0 || c3968d.acn == 108) && this.abN != null) {
            TypedValue typedValue = new TypedValue();
            Theme theme = context.getTheme();
            theme.resolveAttribute(C3982a.actionBarTheme, typedValue, true);
            Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(C3982a.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(C3982a.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            Theme theme3 = theme2;
            if (theme3 != null) {
                pwVar = new pw(context, 0);
                pwVar.getTheme().setTo(theme3);
                qjVar = new qj(pwVar);
                qjVar.mo4047a((C3950a) this);
                c3968d.m13031e(qjVar);
                return true;
            }
        }
        pwVar = context;
        qjVar = new qj(pwVar);
        qjVar.mo4047a((C3950a) this);
        c3968d.m13031e(qjVar);
        return true;
    }

    private boolean m12969c(C3968d c3968d) {
        if (c3968d.acq != null) {
            c3968d.acp = c3968d.acq;
            return true;
        } else if (c3968d.acr == null) {
            return false;
        } else {
            if (this.abP == null) {
                this.abP = new C3969e(this);
            }
            c3968d.acp = (View) c3968d.m13030b(this.abP);
            return c3968d.acp != null;
        }
    }

    private boolean m12968b(C3968d c3968d, KeyEvent keyEvent) {
        if (isDestroyed()) {
            return false;
        }
        if (c3968d.acu) {
            return true;
        }
        if (!(this.acc == null || this.acc == c3968d)) {
            m12974a(this.acc, false);
        }
        Callback lB = lB();
        if (lB != null) {
            c3968d.acq = lB.onCreatePanelView(c3968d.acn);
        }
        boolean z = c3968d.acn == 0 || c3968d.acn == 108;
        if (z && this.abN != null) {
            this.abN.nK();
        }
        if (c3968d.acq == null && !(z && (ly() instanceof pg))) {
            if (c3968d.acr == null || c3968d.acy) {
                if (c3968d.acr == null && (!m12967b(c3968d) || c3968d.acr == null)) {
                    return false;
                }
                if (z && this.abN != null) {
                    if (this.abO == null) {
                        this.abO = new C3963a(this);
                    }
                    this.abN.m13412a(c3968d.acr, this.abO);
                }
                c3968d.acr.mS();
                if (lB.onCreatePanelMenu(c3968d.acn, c3968d.acr)) {
                    c3968d.acy = false;
                } else {
                    c3968d.m13031e(null);
                    if (!z || this.abN == null) {
                        return false;
                    }
                    this.abN.m13412a(null, this.abO);
                    return false;
                }
            }
            c3968d.acr.mS();
            if (c3968d.acz != null) {
                c3968d.acr.m13195k(c3968d.acz);
                c3968d.acz = null;
            }
            if (lB.onPreparePanel(0, c3968d.acq, c3968d.acr)) {
                if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1) {
                    z = true;
                } else {
                    z = false;
                }
                c3968d.acw = z;
                c3968d.acr.setQwertyMode(c3968d.acw);
                c3968d.acr.mT();
            } else {
                if (z && this.abN != null) {
                    this.abN.m13412a(null, this.abO);
                }
                c3968d.acr.mT();
                return false;
            }
        }
        c3968d.acu = true;
        c3968d.acv = false;
        this.acc = c3968d;
        return true;
    }

    void m12979c(qj qjVar) {
        if (!this.aca) {
            this.aca = true;
            this.abN.lO();
            Callback lB = lB();
            if (!(lB == null || isDestroyed())) {
                lB.onPanelClosed(108, qjVar);
            }
            this.aca = false;
        }
    }

    void closePanel(int i) {
        m12974a(m12981g(i, true), true);
    }

    void m12974a(C3968d c3968d, boolean z) {
        if (z && c3968d.acn == 0 && this.abN != null && this.abN.isOverflowMenuShowing()) {
            m12979c(c3968d.acr);
            return;
        }
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (!(windowManager == null || !c3968d.isOpen || c3968d.aco == null)) {
            windowManager.removeView(c3968d.aco);
            if (z) {
                m12972a(c3968d.acn, c3968d, null);
            }
        }
        c3968d.acu = false;
        c3968d.acv = false;
        c3968d.isOpen = false;
        c3968d.acp = null;
        c3968d.acx = true;
        if (this.acc == c3968d) {
            this.acc = null;
        }
    }

    private boolean m12961a(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() == 0) {
            C3968d g = m12981g(i, true);
            if (!g.isOpen) {
                return m12968b(g, keyEvent);
            }
        }
        return false;
    }

    private boolean m12966b(int i, KeyEvent keyEvent) {
        boolean z = true;
        if (this.abQ != null) {
            return false;
        }
        C3968d g = m12981g(i, true);
        if (i != 0 || this.abN == null || !this.abN.nI() || lt.b(ViewConfiguration.get(this.mContext))) {
            boolean z2;
            if (g.isOpen || g.acv) {
                z2 = g.isOpen;
                m12974a(g, true);
                z = z2;
            } else {
                if (g.acu) {
                    if (g.acy) {
                        g.acu = false;
                        z2 = m12968b(g, keyEvent);
                    } else {
                        z2 = true;
                    }
                    if (z2) {
                        m12960a(g, keyEvent);
                    }
                }
                z = false;
            }
        } else if (this.abN.isOverflowMenuShowing()) {
            z = this.abN.hideOverflowMenu();
        } else {
            if (!isDestroyed() && m12968b(g, keyEvent)) {
                z = this.abN.showOverflowMenu();
            }
            z = false;
        }
        if (z) {
            AudioManager audioManager = (AudioManager) this.mContext.getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return z;
    }

    void m12972a(int i, C3968d c3968d, Menu menu) {
        if (menu == null) {
            if (c3968d == null && i >= 0 && i < this.acb.length) {
                c3968d = this.acb[i];
            }
            if (c3968d != null) {
                menu = c3968d.acr;
            }
        }
        if ((c3968d == null || c3968d.isOpen) && !isDestroyed()) {
            this.abm.onPanelClosed(i, menu);
        }
    }

    C3968d m12971a(Menu menu) {
        C3968d[] c3968dArr = this.acb;
        int length = c3968dArr != null ? c3968dArr.length : 0;
        for (int i = 0; i < length; i++) {
            C3968d c3968d = c3968dArr[i];
            if (c3968d != null && c3968d.acr == menu) {
                return c3968d;
            }
        }
        return null;
    }

    protected C3968d m12981g(int i, boolean z) {
        Object obj = this.acb;
        if (obj == null || obj.length <= i) {
            Object obj2 = new C3968d[(i + 1)];
            if (obj != null) {
                System.arraycopy(obj, 0, obj2, 0, obj.length);
            }
            this.acb = obj2;
            obj = obj2;
        }
        C3968d c3968d = obj[i];
        if (c3968d != null) {
            return c3968d;
        }
        c3968d = new C3968d(i);
        obj[i] = c3968d;
        return c3968d;
    }

    private boolean m12964a(C3968d c3968d, int i, KeyEvent keyEvent, int i2) {
        boolean z = false;
        if (!keyEvent.isSystem()) {
            if ((c3968d.acu || m12968b(c3968d, keyEvent)) && c3968d.acr != null) {
                z = c3968d.acr.performShortcut(i, keyEvent, i2);
            }
            if (z && (i2 & 1) == 0 && this.abN == null) {
                m12974a(c3968d, true);
            }
        }
        return z;
    }

    private void invalidatePanelMenu(int i) {
        this.acf |= 1 << i;
        if (!this.ace) {
            li.b(this.ZQ.getDecorView(), this.acg);
            this.ace = true;
        }
    }

    void cm(int i) {
        C3968d g = m12981g(i, true);
        if (g.acr != null) {
            Bundle bundle = new Bundle();
            g.acr.m13194j(bundle);
            if (bundle.size() > 0) {
                g.acz = bundle;
            }
            g.acr.mS();
            g.acr.clear();
        }
        g.acy = true;
        g.acx = true;
        if ((i == 108 || i == 0) && this.abN != null) {
            g = m12981g(0, false);
            if (g != null) {
                g.acu = false;
                m12968b(g, null);
            }
        }
    }

    int cn(int i) {
        int i2;
        int i3 = 1;
        int i4 = 0;
        if (this.abR == null || !(this.abR.getLayoutParams() instanceof MarginLayoutParams)) {
            i2 = 0;
        } else {
            int i5;
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.abR.getLayoutParams();
            if (this.abR.isShown()) {
                if (this.mTempRect1 == null) {
                    this.mTempRect1 = new Rect();
                    this.mTempRect2 = new Rect();
                }
                Rect rect = this.mTempRect1;
                Rect rect2 = this.mTempRect2;
                rect.set(0, i, 0, 0);
                tb.m13618a(this.abW, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    if (this.abX == null) {
                        this.abX = new View(this.mContext);
                        this.abX.setBackgroundColor(this.mContext.getResources().getColor(C3984c.abc_input_method_navigation_guard));
                        this.abW.addView(this.abX, -1, new LayoutParams(-1, i));
                        i5 = 1;
                    } else {
                        LayoutParams layoutParams = this.abX.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            this.abX.setLayoutParams(layoutParams);
                        }
                        i5 = 1;
                    }
                } else {
                    i5 = 0;
                }
                if (this.abX == null) {
                    i3 = 0;
                }
                if (!(this.abs || i3 == 0)) {
                    i = 0;
                }
                int i6 = i5;
                i5 = i3;
                i3 = i6;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                i5 = 0;
            } else {
                i3 = 0;
                i5 = 0;
            }
            if (i3 != 0) {
                this.abR.setLayoutParams(marginLayoutParams);
            }
            i2 = i5;
        }
        if (this.abX != null) {
            View view = this.abX;
            if (i2 == 0) {
                i4 = 8;
            }
            view.setVisibility(i4);
        }
        return i;
    }

    private void lN() {
        if (this.abV) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private int co(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        } else if (i != 9) {
            return i;
        } else {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        }
    }

    void lO() {
        if (this.abN != null) {
            this.abN.lO();
        }
        if (this.abS != null) {
            this.ZQ.getDecorView().removeCallbacks(this.abT);
            if (this.abS.isShowing()) {
                try {
                    this.abS.dismiss();
                } catch (IllegalArgumentException e) {
                }
            }
            this.abS = null;
        }
        lL();
        C3968d g = m12981g(0, false);
        if (g != null && g.acr != null) {
            g.acr.close();
        }
    }
}
