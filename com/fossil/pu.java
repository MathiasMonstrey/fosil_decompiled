package com.fossil;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public abstract class pu {
    private Object BM;
    private boolean adX;

    public interface C3965a {
        boolean mo3996a(pu puVar, Menu menu);

        boolean mo3997a(pu puVar, MenuItem menuItem);

        boolean mo3998b(pu puVar, Menu menu);

        void mo3999c(pu puVar);
    }

    public abstract void finish();

    public abstract View getCustomView();

    public abstract Menu getMenu();

    public abstract MenuInflater getMenuInflater();

    public abstract CharSequence getSubtitle();

    public abstract CharSequence getTitle();

    public abstract void invalidate();

    public abstract void setCustomView(View view);

    public abstract void setSubtitle(int i);

    public abstract void setSubtitle(CharSequence charSequence);

    public abstract void setTitle(int i);

    public abstract void setTitle(CharSequence charSequence);

    public void setTag(Object obj) {
        this.BM = obj;
    }

    public Object getTag() {
        return this.BM;
    }

    public void setTitleOptionalHint(boolean z) {
        this.adX = z;
    }

    public boolean getTitleOptionalHint() {
        return this.adX;
    }

    public boolean isTitleOptional() {
        return false;
    }
}
