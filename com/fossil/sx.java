package com.fossil;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;
import com.fossil.pk.C3982a;
import com.fossil.pk.C3986e;
import com.fossil.pk.C3987f;
import com.fossil.pk.C3989h;
import com.fossil.pk.C3991j;
import com.fossil.qj.C3950a;
import com.fossil.qq.C3962a;

public class sx implements rt {
    private Drawable AN;
    private View BP;
    CharSequence Od;
    private CharSequence Oe;
    Callback acS;
    private rb ahw;
    private int avJ;
    private View avK;
    private Drawable avL;
    private Drawable avM;
    private boolean avN;
    private CharSequence avO;
    boolean avP;
    private int avQ;
    private int avR;
    private Drawable avS;
    Toolbar xE;

    class C40841 implements OnClickListener {
        final qc avT = new qc(this.avU.xE.getContext(), 0, 16908332, 0, 0, this.avU.Od);
        final /* synthetic */ sx avU;

        C40841(sx sxVar) {
            this.avU = sxVar;
        }

        public void onClick(View view) {
            if (this.avU.acS != null && this.avU.avP) {
                this.avU.acS.onMenuItemSelected(0, this.avT);
            }
        }
    }

    public sx(Toolbar toolbar, boolean z) {
        this(toolbar, z, C3989h.abc_action_bar_up_description, C3986e.abc_ic_ab_back_material);
    }

    public sx(Toolbar toolbar, boolean z, int i, int i2) {
        this.avQ = 0;
        this.avR = 0;
        this.xE = toolbar;
        this.Od = toolbar.getTitle();
        this.Oe = toolbar.getSubtitle();
        this.avN = this.Od != null;
        this.avM = toolbar.getNavigationIcon();
        sw a = sw.m13583a(toolbar.getContext(), null, C3991j.ActionBar, C3982a.actionBarStyle, 0);
        this.avS = a.getDrawable(C3991j.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence text = a.getText(C3991j.ActionBar_title);
            if (!TextUtils.isEmpty(text)) {
                setTitle(text);
            }
            text = a.getText(C3991j.ActionBar_subtitle);
            if (!TextUtils.isEmpty(text)) {
                setSubtitle(text);
            }
            Drawable drawable = a.getDrawable(C3991j.ActionBar_logo);
            if (drawable != null) {
                setLogo(drawable);
            }
            drawable = a.getDrawable(C3991j.ActionBar_icon);
            if (drawable != null) {
                setIcon(drawable);
            }
            if (this.avM == null && this.avS != null) {
                setNavigationIcon(this.avS);
            }
            setDisplayOptions(a.getInt(C3991j.ActionBar_displayOptions, 0));
            int resourceId = a.getResourceId(C3991j.ActionBar_customNavigationLayout, 0);
            if (resourceId != 0) {
                setCustomView(LayoutInflater.from(this.xE.getContext()).inflate(resourceId, this.xE, false));
                setDisplayOptions(this.avJ | 16);
            }
            resourceId = a.getLayoutDimension(C3991j.ActionBar_height, 0);
            if (resourceId > 0) {
                LayoutParams layoutParams = this.xE.getLayoutParams();
                layoutParams.height = resourceId;
                this.xE.setLayoutParams(layoutParams);
            }
            resourceId = a.getDimensionPixelOffset(C3991j.ActionBar_contentInsetStart, -1);
            int dimensionPixelOffset = a.getDimensionPixelOffset(C3991j.ActionBar_contentInsetEnd, -1);
            if (resourceId >= 0 || dimensionPixelOffset >= 0) {
                this.xE.setContentInsetsRelative(Math.max(resourceId, 0), Math.max(dimensionPixelOffset, 0));
            }
            resourceId = a.getResourceId(C3991j.ActionBar_titleTextStyle, 0);
            if (resourceId != 0) {
                this.xE.setTitleTextAppearance(this.xE.getContext(), resourceId);
            }
            resourceId = a.getResourceId(C3991j.ActionBar_subtitleTextStyle, 0);
            if (resourceId != 0) {
                this.xE.setSubtitleTextAppearance(this.xE.getContext(), resourceId);
            }
            int resourceId2 = a.getResourceId(C3991j.ActionBar_popupTheme, 0);
            if (resourceId2 != 0) {
                this.xE.setPopupTheme(resourceId2);
            }
        } else {
            this.avJ = sD();
        }
        a.recycle();
        ep(i);
        this.avO = this.xE.getNavigationContentDescription();
        this.xE.setNavigationOnClickListener(new C40841(this));
    }

    public void ep(int i) {
        if (i != this.avR) {
            this.avR = i;
            if (TextUtils.isEmpty(this.xE.getNavigationContentDescription())) {
                setNavigationContentDescription(this.avR);
            }
        }
    }

    private int sD() {
        if (this.xE.getNavigationIcon() == null) {
            return 11;
        }
        this.avS = this.xE.getNavigationIcon();
        return 15;
    }

    public ViewGroup oJ() {
        return this.xE;
    }

    public Context getContext() {
        return this.xE.getContext();
    }

    public boolean hasExpandedActionView() {
        return this.xE.hasExpandedActionView();
    }

    public void collapseActionView() {
        this.xE.collapseActionView();
    }

    public void setWindowCallback(Callback callback) {
        this.acS = callback;
    }

    public void setWindowTitle(CharSequence charSequence) {
        if (!this.avN) {
            m13586s(charSequence);
        }
    }

    public CharSequence getTitle() {
        return this.xE.getTitle();
    }

    public void setTitle(CharSequence charSequence) {
        this.avN = true;
        m13586s(charSequence);
    }

    private void m13586s(CharSequence charSequence) {
        this.Od = charSequence;
        if ((this.avJ & 8) != 0) {
            this.xE.setTitle(charSequence);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        this.Oe = charSequence;
        if ((this.avJ & 8) != 0) {
            this.xE.setSubtitle(charSequence);
        }
    }

    public void oK() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void oL() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void setIcon(int i) {
        setIcon(i != 0 ? pn.m13079c(getContext(), i) : null);
    }

    public void setIcon(Drawable drawable) {
        this.AN = drawable;
        sE();
    }

    public void setLogo(int i) {
        setLogo(i != 0 ? pn.m13079c(getContext(), i) : null);
    }

    public void setLogo(Drawable drawable) {
        this.avL = drawable;
        sE();
    }

    private void sE() {
        Drawable drawable = null;
        if ((this.avJ & 2) != 0) {
            drawable = (this.avJ & 1) != 0 ? this.avL != null ? this.avL : this.AN : this.AN;
        }
        this.xE.setLogo(drawable);
    }

    public boolean nI() {
        return this.xE.nI();
    }

    public boolean isOverflowMenuShowing() {
        return this.xE.isOverflowMenuShowing();
    }

    public boolean nJ() {
        return this.xE.nJ();
    }

    public boolean showOverflowMenu() {
        return this.xE.showOverflowMenu();
    }

    public boolean hideOverflowMenu() {
        return this.xE.hideOverflowMenu();
    }

    public void nK() {
        this.avP = true;
    }

    public void mo4124a(Menu menu, C3962a c3962a) {
        if (this.ahw == null) {
            this.ahw = new rb(this.xE.getContext());
            this.ahw.setId(C3987f.action_menu_presenter);
        }
        this.ahw.mo4020a(c3962a);
        this.xE.a((qj) menu, this.ahw);
    }

    public void dismissPopupMenus() {
        this.xE.dismissPopupMenus();
    }

    public int getDisplayOptions() {
        return this.avJ;
    }

    public void setDisplayOptions(int i) {
        int i2 = this.avJ ^ i;
        this.avJ = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    sG();
                }
                sF();
            }
            if ((i2 & 3) != 0) {
                sE();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.xE.setTitle(this.Od);
                    this.xE.setSubtitle(this.Oe);
                } else {
                    this.xE.setTitle(null);
                    this.xE.setSubtitle(null);
                }
            }
            if ((i2 & 16) != 0 && this.BP != null) {
                if ((i & 16) != 0) {
                    this.xE.addView(this.BP);
                } else {
                    this.xE.removeView(this.BP);
                }
            }
        }
    }

    public void mo4126a(sn snVar) {
        if (this.avK != null && this.avK.getParent() == this.xE) {
            this.xE.removeView(this.avK);
        }
        this.avK = snVar;
        if (snVar != null && this.avQ == 2) {
            this.xE.addView(this.avK, 0);
            Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.avK.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.gravity = 8388691;
            snVar.setAllowCollapse(true);
        }
    }

    public void setCollapsible(boolean z) {
        this.xE.setCollapsible(z);
    }

    public void setHomeButtonEnabled(boolean z) {
    }

    public int getNavigationMode() {
        return this.avQ;
    }

    public void setCustomView(View view) {
        if (!(this.BP == null || (this.avJ & 16) == 0)) {
            this.xE.removeView(this.BP);
        }
        this.BP = view;
        if (view != null && (this.avJ & 16) != 0) {
            this.xE.addView(this.BP);
        }
    }

    public lz mo4127c(final int i, long j) {
        return li.ae(this.xE).y(i == 0 ? 1.0f : 0.0f).n(j).a(new me(this) {
            private boolean FN = false;
            final /* synthetic */ sx avU;

            public void m13584e(View view) {
                this.avU.xE.setVisibility(0);
            }

            public void m13585f(View view) {
                if (!this.FN) {
                    this.avU.xE.setVisibility(i);
                }
            }

            public void aD(View view) {
                this.FN = true;
            }
        });
    }

    public void setNavigationIcon(Drawable drawable) {
        this.avM = drawable;
        sF();
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(i != 0 ? pn.m13079c(getContext(), i) : null);
    }

    private void sF() {
        if ((this.avJ & 4) != 0) {
            this.xE.setNavigationIcon(this.avM != null ? this.avM : this.avS);
        } else {
            this.xE.setNavigationIcon(null);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        this.avO = charSequence;
        sG();
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i == 0 ? null : getContext().getString(i));
    }

    private void sG() {
        if ((this.avJ & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.avO)) {
            this.xE.setNavigationContentDescription(this.avR);
        } else {
            this.xE.setNavigationContentDescription(this.avO);
        }
    }

    public void setVisibility(int i) {
        this.xE.setVisibility(i);
    }

    public int getVisibility() {
        return this.xE.getVisibility();
    }

    public void mo4125a(C3962a c3962a, C3950a c3950a) {
        this.xE.a(c3962a, c3950a);
    }

    public Menu getMenu() {
        return this.xE.getMenu();
    }
}
