package com.fossil;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import com.fossil.kp.e;
import java.lang.reflect.Method;

@TargetApi(14)
public class qm extends qe<hv> implements MenuItem {
    private Method aha;

    class C4013a extends kc {
        final ActionProvider ahb;
        final /* synthetic */ qm ahc;

        public C4013a(qm qmVar, Context context, ActionProvider actionProvider) {
            this.ahc = qmVar;
            super(context);
            this.ahb = actionProvider;
        }

        public View onCreateActionView() {
            return this.ahb.onCreateActionView();
        }

        public boolean onPerformDefaultAction() {
            return this.ahb.onPerformDefaultAction();
        }

        public boolean hasSubMenu() {
            return this.ahb.hasSubMenu();
        }

        public void onPrepareSubMenu(SubMenu subMenu) {
            this.ahb.onPrepareSubMenu(this.ahc.m13135a(subMenu));
        }
    }

    static class C4014b extends FrameLayout implements pv {
        final CollapsibleActionView ahd;

        C4014b(View view) {
            super(view.getContext());
            this.ahd = (CollapsibleActionView) view;
            addView(view);
        }

        public void onActionViewExpanded() {
            this.ahd.onActionViewExpanded();
        }

        public void onActionViewCollapsed() {
            this.ahd.onActionViewCollapsed();
        }

        View nq() {
            return (View) this.ahd;
        }
    }

    class C4015c extends qf<OnActionExpandListener> implements e {
        final /* synthetic */ qm ahc;

        C4015c(qm qmVar, OnActionExpandListener onActionExpandListener) {
            this.ahc = qmVar;
            super(onActionExpandListener);
        }

        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return ((OnActionExpandListener) this.afr).onMenuItemActionExpand(this.ahc.m13136g(menuItem));
        }

        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return ((OnActionExpandListener) this.afr).onMenuItemActionCollapse(this.ahc.m13136g(menuItem));
        }
    }

    class C4016d extends qf<OnMenuItemClickListener> implements OnMenuItemClickListener {
        final /* synthetic */ qm ahc;

        C4016d(qm qmVar, OnMenuItemClickListener onMenuItemClickListener) {
            this.ahc = qmVar;
            super(onMenuItemClickListener);
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return ((OnMenuItemClickListener) this.afr).onMenuItemClick(this.ahc.m13136g(menuItem));
        }
    }

    qm(Context context, hv hvVar) {
        super(context, hvVar);
    }

    public int getItemId() {
        return ((hv) this.afr).getItemId();
    }

    public int getGroupId() {
        return ((hv) this.afr).getGroupId();
    }

    public int getOrder() {
        return ((hv) this.afr).getOrder();
    }

    public MenuItem setTitle(CharSequence charSequence) {
        ((hv) this.afr).setTitle(charSequence);
        return this;
    }

    public MenuItem setTitle(int i) {
        ((hv) this.afr).setTitle(i);
        return this;
    }

    public CharSequence getTitle() {
        return ((hv) this.afr).getTitle();
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((hv) this.afr).setTitleCondensed(charSequence);
        return this;
    }

    public CharSequence getTitleCondensed() {
        return ((hv) this.afr).getTitleCondensed();
    }

    public MenuItem setIcon(Drawable drawable) {
        ((hv) this.afr).setIcon(drawable);
        return this;
    }

    public MenuItem setIcon(int i) {
        ((hv) this.afr).setIcon(i);
        return this;
    }

    public Drawable getIcon() {
        return ((hv) this.afr).getIcon();
    }

    public MenuItem setIntent(Intent intent) {
        ((hv) this.afr).setIntent(intent);
        return this;
    }

    public Intent getIntent() {
        return ((hv) this.afr).getIntent();
    }

    public MenuItem setShortcut(char c, char c2) {
        ((hv) this.afr).setShortcut(c, c2);
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        ((hv) this.afr).setNumericShortcut(c);
        return this;
    }

    public char getNumericShortcut() {
        return ((hv) this.afr).getNumericShortcut();
    }

    public MenuItem setAlphabeticShortcut(char c) {
        ((hv) this.afr).setAlphabeticShortcut(c);
        return this;
    }

    public char getAlphabeticShortcut() {
        return ((hv) this.afr).getAlphabeticShortcut();
    }

    public MenuItem setCheckable(boolean z) {
        ((hv) this.afr).setCheckable(z);
        return this;
    }

    public boolean isCheckable() {
        return ((hv) this.afr).isCheckable();
    }

    public MenuItem setChecked(boolean z) {
        ((hv) this.afr).setChecked(z);
        return this;
    }

    public boolean isChecked() {
        return ((hv) this.afr).isChecked();
    }

    public MenuItem setVisible(boolean z) {
        return ((hv) this.afr).setVisible(z);
    }

    public boolean isVisible() {
        return ((hv) this.afr).isVisible();
    }

    public MenuItem setEnabled(boolean z) {
        ((hv) this.afr).setEnabled(z);
        return this;
    }

    public boolean isEnabled() {
        return ((hv) this.afr).isEnabled();
    }

    public boolean hasSubMenu() {
        return ((hv) this.afr).hasSubMenu();
    }

    public SubMenu getSubMenu() {
        return m13135a(((hv) this.afr).getSubMenu());
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        ((hv) this.afr).setOnMenuItemClickListener(onMenuItemClickListener != null ? new C4016d(this, onMenuItemClickListener) : null);
        return this;
    }

    public ContextMenuInfo getMenuInfo() {
        return ((hv) this.afr).getMenuInfo();
    }

    public void setShowAsAction(int i) {
        ((hv) this.afr).setShowAsAction(i);
    }

    public MenuItem setShowAsActionFlags(int i) {
        ((hv) this.afr).setShowAsActionFlags(i);
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new C4014b(view);
        }
        ((hv) this.afr).setActionView(view);
        return this;
    }

    public MenuItem setActionView(int i) {
        ((hv) this.afr).setActionView(i);
        View actionView = ((hv) this.afr).getActionView();
        if (actionView instanceof CollapsibleActionView) {
            ((hv) this.afr).setActionView(new C4014b(actionView));
        }
        return this;
    }

    public View getActionView() {
        View actionView = ((hv) this.afr).getActionView();
        if (actionView instanceof C4014b) {
            return ((C4014b) actionView).nq();
        }
        return actionView;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        ((hv) this.afr).a(actionProvider != null ? mo4046a(actionProvider) : null);
        return this;
    }

    public ActionProvider getActionProvider() {
        kc iP = ((hv) this.afr).iP();
        if (iP instanceof C4013a) {
            return ((C4013a) iP).ahb;
        }
        return null;
    }

    public boolean expandActionView() {
        return ((hv) this.afr).expandActionView();
    }

    public boolean collapseActionView() {
        return ((hv) this.afr).collapseActionView();
    }

    public boolean isActionViewExpanded() {
        return ((hv) this.afr).isActionViewExpanded();
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        ((hv) this.afr).a(onActionExpandListener != null ? new C4015c(this, onActionExpandListener) : null);
        return this;
    }

    public void ad(boolean z) {
        try {
            if (this.aha == null) {
                this.aha = ((hv) this.afr).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
            }
            this.aha.invoke(this.afr, new Object[]{Boolean.valueOf(z)});
        } catch (Throwable e) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
        }
    }

    C4013a mo4046a(ActionProvider actionProvider) {
        return new C4013a(this, this.mContext, actionProvider);
    }
}
