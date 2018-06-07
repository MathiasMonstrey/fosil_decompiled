package com.fossil;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

@TargetApi(14)
class qx extends qt implements SubMenu {
    qx(Context context, hw hwVar) {
        super(context, hwVar);
    }

    public hw nw() {
        return (hw) this.afr;
    }

    public SubMenu setHeaderTitle(int i) {
        nw().setHeaderTitle(i);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        nw().setHeaderTitle(charSequence);
        return this;
    }

    public SubMenu setHeaderIcon(int i) {
        nw().setHeaderIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        nw().setHeaderIcon(drawable);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        nw().setHeaderView(view);
        return this;
    }

    public void clearHeader() {
        nw().clearHeader();
    }

    public SubMenu setIcon(int i) {
        nw().setIcon(i);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        nw().setIcon(drawable);
        return this;
    }

    public MenuItem getItem() {
        return m13136g(nw().getItem());
    }
}
