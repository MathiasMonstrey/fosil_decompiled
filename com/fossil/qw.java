package com.fossil;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import com.fossil.qj.C3950a;

public class qw extends qj implements SubMenu {
    private qj ahr;
    private ql ahs;

    public qw(Context context, qj qjVar, ql qlVar) {
        super(context);
        this.ahr = qjVar;
        this.ahs = qlVar;
    }

    public void setQwertyMode(boolean z) {
        this.ahr.setQwertyMode(z);
    }

    public boolean mP() {
        return this.ahr.mP();
    }

    public boolean mQ() {
        return this.ahr.mQ();
    }

    public Menu nv() {
        return this.ahr;
    }

    public MenuItem getItem() {
        return this.ahs;
    }

    public void mo4047a(C3950a c3950a) {
        this.ahr.mo4047a(c3950a);
    }

    public qj nb() {
        return this.ahr.nb();
    }

    boolean mo4048d(qj qjVar, MenuItem menuItem) {
        return super.mo4048d(qjVar, menuItem) || this.ahr.mo4048d(qjVar, menuItem);
    }

    public SubMenu setIcon(Drawable drawable) {
        this.ahs.setIcon(drawable);
        return this;
    }

    public SubMenu setIcon(int i) {
        this.ahs.setIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.m13196n(drawable);
    }

    public SubMenu setHeaderIcon(int i) {
        return (SubMenu) super.cC(i);
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.m13197o(charSequence);
    }

    public SubMenu setHeaderTitle(int i) {
        return (SubMenu) super.cB(i);
    }

    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.bq(view);
    }

    public boolean mo4049e(ql qlVar) {
        return this.ahr.mo4049e(qlVar);
    }

    public boolean mo4050f(ql qlVar) {
        return this.ahr.mo4050f(qlVar);
    }

    public String mO() {
        int itemId = this.ahs != null ? this.ahs.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.mO() + ":" + itemId;
    }
}
