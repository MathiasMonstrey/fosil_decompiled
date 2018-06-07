package com.fossil;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import com.fossil.kp.e;

public class qc implements hv {
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
    private Context mContext;
    private final int mId;
    private Intent mIntent;
    private final int rq;

    public /* synthetic */ MenuItem setActionView(int i) {
        return cr(i);
    }

    public /* synthetic */ MenuItem setActionView(View view) {
        return bp(view);
    }

    public /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        return cs(i);
    }

    public qc(Context context, int i, int i2, int i3, int i4, CharSequence charSequence) {
        this.mContext = context;
        this.mId = i2;
        this.rq = i;
        this.aeU = i3;
        this.aeV = i4;
        this.Od = charSequence;
    }

    public char getAlphabeticShortcut() {
        return this.aeY;
    }

    public int getGroupId() {
        return this.rq;
    }

    public Drawable getIcon() {
        return this.aeZ;
    }

    public Intent getIntent() {
        return this.mIntent;
    }

    public int getItemId() {
        return this.mId;
    }

    public ContextMenuInfo getMenuInfo() {
        return null;
    }

    public char getNumericShortcut() {
        return this.aeX;
    }

    public int getOrder() {
        return this.aeV;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public CharSequence getTitle() {
        return this.Od;
    }

    public CharSequence getTitleCondensed() {
        return this.aeW != null ? this.aeW : this.Od;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isCheckable() {
        return (this.JM & 1) != 0;
    }

    public boolean isChecked() {
        return (this.JM & 2) != 0;
    }

    public boolean isEnabled() {
        return (this.JM & 16) != 0;
    }

    public boolean isVisible() {
        return (this.JM & 8) == 0;
    }

    public MenuItem setAlphabeticShortcut(char c) {
        this.aeY = c;
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        this.JM = (z ? 1 : 0) | (this.JM & -2);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        this.JM = (z ? 2 : 0) | (this.JM & -3);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.JM = (z ? 16 : 0) | (this.JM & -17);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.aeZ = drawable;
        this.afa = 0;
        return this;
    }

    public MenuItem setIcon(int i) {
        this.afa = i;
        this.aeZ = gn.c(this.mContext, i);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.mIntent = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        this.aeX = c;
        return this;
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.afb = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.aeX = c;
        this.aeY = c2;
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.Od = charSequence;
        return this;
    }

    public MenuItem setTitle(int i) {
        this.Od = this.mContext.getResources().getString(i);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.aeW = charSequence;
        return this;
    }

    public MenuItem setVisible(boolean z) {
        this.JM = (z ? 0 : 8) | (this.JM & 8);
        return this;
    }

    public void setShowAsAction(int i) {
    }

    public hv bp(View view) {
        throw new UnsupportedOperationException();
    }

    public View getActionView() {
        return null;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    public hv cr(int i) {
        throw new UnsupportedOperationException();
    }

    public kc iP() {
        return null;
    }

    public hv m13112a(kc kcVar) {
        throw new UnsupportedOperationException();
    }

    public hv cs(int i) {
        setShowAsAction(i);
        return this;
    }

    public boolean expandActionView() {
        return false;
    }

    public boolean collapseActionView() {
        return false;
    }

    public boolean isActionViewExpanded() {
        return false;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public hv m13113a(e eVar) {
        return this;
    }
}
