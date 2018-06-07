package com.fossil;

import android.content.Context;
import android.support.v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import com.fossil.pu.C3965a;
import com.fossil.qj.C3950a;
import java.lang.ref.WeakReference;

public class px extends pu implements C3950a {
    private C3965a adQ;
    private WeakReference<View> adR;
    private ActionBarContextView adt;
    private boolean aeb;
    private boolean aec;
    private Context mContext;
    private qj uh;

    public px(Context context, ActionBarContextView actionBarContextView, C3965a c3965a, boolean z) {
        this.mContext = context;
        this.adt = actionBarContextView;
        this.adQ = c3965a;
        this.uh = new qj(actionBarContextView.getContext()).cx(1);
        this.uh.mo4047a((C3950a) this);
        this.aec = z;
    }

    public void setTitle(CharSequence charSequence) {
        this.adt.setTitle(charSequence);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.adt.setSubtitle(charSequence);
    }

    public void setTitle(int i) {
        setTitle(this.mContext.getString(i));
    }

    public void setSubtitle(int i) {
        setSubtitle(this.mContext.getString(i));
    }

    public void setTitleOptionalHint(boolean z) {
        super.setTitleOptionalHint(z);
        this.adt.setTitleOptional(z);
    }

    public boolean isTitleOptional() {
        return this.adt.isTitleOptional();
    }

    public void setCustomView(View view) {
        this.adt.setCustomView(view);
        this.adR = view != null ? new WeakReference(view) : null;
    }

    public void invalidate() {
        this.adQ.mo3998b(this, this.uh);
    }

    public void finish() {
        if (!this.aeb) {
            this.aeb = true;
            this.adt.sendAccessibilityEvent(32);
            this.adQ.mo3999c(this);
        }
    }

    public Menu getMenu() {
        return this.uh;
    }

    public CharSequence getTitle() {
        return this.adt.getTitle();
    }

    public CharSequence getSubtitle() {
        return this.adt.getSubtitle();
    }

    public View getCustomView() {
        return this.adR != null ? (View) this.adR.get() : null;
    }

    public MenuInflater getMenuInflater() {
        return new pz(this.adt.getContext());
    }

    public boolean mo3968a(qj qjVar, MenuItem menuItem) {
        return this.adQ.mo3997a((pu) this, menuItem);
    }

    public void mo3970b(qj qjVar) {
        invalidate();
        this.adt.showOverflowMenu();
    }
}
