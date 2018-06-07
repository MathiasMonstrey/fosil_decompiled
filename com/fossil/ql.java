package com.fossil;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug.CapturedViewProperty;
import android.widget.LinearLayout;
import com.fossil.kp.C3805e;
import com.fossil.qr.a;

public final class ql implements hv {
    private static String agV;
    private static String agW;
    private static String agX;
    private static String agY;
    private int JM = 16;
    private CharSequence Od;
    private final int aeU;
    private final int aeV;
    private CharSequence aeW;
    private char aeX;
    private char aeY;
    private Drawable aeZ;
    private int afa = 0;
    private OnMenuItemClickListener afb;
    private qw agN;
    private Runnable agO;
    private int agP = 0;
    private View agQ;
    private kc agR;
    private C3805e agS;
    private boolean agT = false;
    private ContextMenuInfo agU;
    private final int mId;
    private Intent mIntent;
    private final int rq;
    qj uh;

    public /* synthetic */ MenuItem setActionView(int i) {
        return cr(i);
    }

    public /* synthetic */ MenuItem setActionView(View view) {
        return bp(view);
    }

    public /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        return cs(i);
    }

    ql(qj qjVar, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.uh = qjVar;
        this.mId = i2;
        this.rq = i;
        this.aeU = i3;
        this.aeV = i4;
        this.Od = charSequence;
        this.agP = i5;
    }

    public boolean ne() {
        if ((this.afb != null && this.afb.onMenuItemClick(this)) || this.uh.d(this.uh.nb(), this)) {
            return true;
        }
        if (this.agO != null) {
            this.agO.run();
            return true;
        }
        if (this.mIntent != null) {
            try {
                this.uh.getContext().startActivity(this.mIntent);
                return true;
            } catch (Throwable e) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
            }
        }
        if (this.agR == null || !this.agR.onPerformDefaultAction()) {
            return false;
        }
        return true;
    }

    public boolean isEnabled() {
        return (this.JM & 16) != 0;
    }

    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.JM |= 16;
        } else {
            this.JM &= -17;
        }
        this.uh.i(false);
        return this;
    }

    public int getGroupId() {
        return this.rq;
    }

    @CapturedViewProperty
    public int getItemId() {
        return this.mId;
    }

    public int getOrder() {
        return this.aeU;
    }

    public int getOrdering() {
        return this.aeV;
    }

    public Intent getIntent() {
        return this.mIntent;
    }

    public MenuItem setIntent(Intent intent) {
        this.mIntent = intent;
        return this;
    }

    public char getAlphabeticShortcut() {
        return this.aeY;
    }

    public MenuItem setAlphabeticShortcut(char c) {
        if (this.aeY != c) {
            this.aeY = Character.toLowerCase(c);
            this.uh.i(false);
        }
        return this;
    }

    public char getNumericShortcut() {
        return this.aeX;
    }

    public MenuItem setNumericShortcut(char c) {
        if (this.aeX != c) {
            this.aeX = c;
            this.uh.i(false);
        }
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.aeX = c;
        this.aeY = Character.toLowerCase(c2);
        this.uh.i(false);
        return this;
    }

    public char nf() {
        return this.uh.mP() ? this.aeY : this.aeX;
    }

    public String ng() {
        char nf = nf();
        if (nf == '\u0000') {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(agV);
        switch (nf) {
            case '\b':
                stringBuilder.append(agX);
                break;
            case '\n':
                stringBuilder.append(agW);
                break;
            case ' ':
                stringBuilder.append(agY);
                break;
            default:
                stringBuilder.append(nf);
                break;
        }
        return stringBuilder.toString();
    }

    public boolean nh() {
        return this.uh.mQ() && nf() != '\u0000';
    }

    public SubMenu getSubMenu() {
        return this.agN;
    }

    public boolean hasSubMenu() {
        return this.agN != null;
    }

    public void m12650b(qw qwVar) {
        this.agN = qwVar;
        qwVar.setHeaderTitle(getTitle());
    }

    @CapturedViewProperty
    public CharSequence getTitle() {
        return this.Od;
    }

    public CharSequence m12648a(a aVar) {
        if (aVar == null || !aVar.eT()) {
            return getTitle();
        }
        return getTitleCondensed();
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.Od = charSequence;
        this.uh.i(false);
        if (this.agN != null) {
            this.agN.setHeaderTitle(charSequence);
        }
        return this;
    }

    public MenuItem setTitle(int i) {
        return setTitle(this.uh.getContext().getString(i));
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.aeW != null ? this.aeW : this.Od;
        if (VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) {
            return charSequence;
        }
        return charSequence.toString();
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.aeW = charSequence;
        if (charSequence == null) {
            CharSequence charSequence2 = this.Od;
        }
        this.uh.i(false);
        return this;
    }

    public Drawable getIcon() {
        if (this.aeZ != null) {
            return this.aeZ;
        }
        if (this.afa == 0) {
            return null;
        }
        Drawable c = pn.c(this.uh.getContext(), this.afa);
        this.afa = 0;
        this.aeZ = c;
        return c;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.afa = 0;
        this.aeZ = drawable;
        this.uh.i(false);
        return this;
    }

    public MenuItem setIcon(int i) {
        this.aeZ = null;
        this.afa = i;
        this.uh.i(false);
        return this;
    }

    public boolean isCheckable() {
        return (this.JM & 1) == 1;
    }

    public MenuItem setCheckable(boolean z) {
        int i = this.JM;
        this.JM = (z ? 1 : 0) | (this.JM & -2);
        if (i != this.JM) {
            this.uh.i(false);
        }
        return this;
    }

    public void ad(boolean z) {
        this.JM = (z ? 4 : 0) | (this.JM & -5);
    }

    public boolean ni() {
        return (this.JM & 4) != 0;
    }

    public boolean isChecked() {
        return (this.JM & 2) == 2;
    }

    public MenuItem setChecked(boolean z) {
        if ((this.JM & 4) != 0) {
            this.uh.h(this);
        } else {
            ae(z);
        }
        return this;
    }

    void ae(boolean z) {
        int i;
        int i2 = this.JM;
        int i3 = this.JM & -3;
        if (z) {
            i = 2;
        } else {
            i = 0;
        }
        this.JM = i | i3;
        if (i2 != this.JM) {
            this.uh.i(false);
        }
    }

    public boolean isVisible() {
        if (this.agR == null || !this.agR.overridesItemVisibility()) {
            if ((this.JM & 8) != 0) {
                return false;
            }
            return true;
        } else if ((this.JM & 8) == 0 && this.agR.isVisible()) {
            return true;
        } else {
            return false;
        }
    }

    boolean af(boolean z) {
        int i = this.JM;
        this.JM = (z ? 0 : 8) | (this.JM & -9);
        if (i != this.JM) {
            return true;
        }
        return false;
    }

    public MenuItem setVisible(boolean z) {
        if (af(z)) {
            this.uh.c(this);
        }
        return this;
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.afb = onMenuItemClickListener;
        return this;
    }

    public String toString() {
        return this.Od != null ? this.Od.toString() : null;
    }

    void m12649a(ContextMenuInfo contextMenuInfo) {
        this.agU = contextMenuInfo;
    }

    public ContextMenuInfo getMenuInfo() {
        return this.agU;
    }

    public void nj() {
        this.uh.d(this);
    }

    public boolean nk() {
        return this.uh.nc();
    }

    public boolean nl() {
        return (this.JM & 32) == 32;
    }

    public boolean nm() {
        return (this.agP & 1) == 1;
    }

    public boolean nn() {
        return (this.agP & 2) == 2;
    }

    public void ag(boolean z) {
        if (z) {
            this.JM |= 32;
        } else {
            this.JM &= -33;
        }
    }

    public boolean no() {
        return (this.agP & 4) == 4;
    }

    public void setShowAsAction(int i) {
        switch (i & 3) {
            case 0:
            case 1:
            case 2:
                this.agP = i;
                this.uh.d(this);
                return;
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    public hv bp(View view) {
        this.agQ = view;
        this.agR = null;
        if (view != null && view.getId() == -1 && this.mId > 0) {
            view.setId(this.mId);
        }
        this.uh.d(this);
        return this;
    }

    public hv cr(int i) {
        Context context = this.uh.getContext();
        bp(LayoutInflater.from(context).inflate(i, new LinearLayout(context), false));
        return this;
    }

    public View getActionView() {
        if (this.agQ != null) {
            return this.agQ;
        }
        if (this.agR == null) {
            return null;
        }
        this.agQ = this.agR.onCreateActionView(this);
        return this.agQ;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public kc iP() {
        return this.agR;
    }

    public hv mo3486a(kc kcVar) {
        if (this.agR != null) {
            this.agR.reset();
        }
        this.agQ = null;
        this.agR = kcVar;
        this.uh.i(true);
        if (this.agR != null) {
            this.agR.setVisibilityListener(new 1(this));
        }
        return this;
    }

    public hv cs(int i) {
        setShowAsAction(i);
        return this;
    }

    public boolean expandActionView() {
        if (!np()) {
            return false;
        }
        if (this.agS == null || this.agS.onMenuItemActionExpand(this)) {
            return this.uh.e(this);
        }
        return false;
    }

    public boolean collapseActionView() {
        if ((this.agP & 8) == 0) {
            return false;
        }
        if (this.agQ == null) {
            return true;
        }
        if (this.agS == null || this.agS.onMenuItemActionCollapse(this)) {
            return this.uh.f(this);
        }
        return false;
    }

    public hv mo3487a(C3805e c3805e) {
        this.agS = c3805e;
        return this;
    }

    public boolean np() {
        if ((this.agP & 8) == 0) {
            return false;
        }
        if (this.agQ == null && this.agR != null) {
            this.agQ = this.agR.onCreateActionView(this);
        }
        if (this.agQ != null) {
            return true;
        }
        return false;
    }

    public void ah(boolean z) {
        this.agT = z;
        this.uh.i(false);
    }

    public boolean isActionViewExpanded() {
        return this.agT;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setOnActionExpandListener()");
    }
}
