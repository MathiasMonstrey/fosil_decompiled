package com.fossil;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.fossil.gi.C2081a;
import com.fossil.pu.a;

public class ot extends ew implements C2081a, ou {
    private Resources Xe;
    private ov abe;
    private int abf = 0;
    private boolean abg;

    public void onCreate(Bundle bundle) {
        ov ls = ls();
        ls.lt();
        ls.onCreate(bundle);
        if (ls.lu() && this.abf != 0) {
            if (VERSION.SDK_INT >= 23) {
                onApplyThemeResource(getTheme(), this.abf, false);
            } else {
                setTheme(this.abf);
            }
        }
        super.onCreate(bundle);
    }

    public void setTheme(int i) {
        super.setTheme(i);
        this.abf = i;
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        ls().onPostCreate(bundle);
    }

    public ActionBar lp() {
        return ls().lp();
    }

    public void m6459a(Toolbar toolbar) {
        ls().a(toolbar);
    }

    public MenuInflater getMenuInflater() {
        return ls().getMenuInflater();
    }

    public void setContentView(int i) {
        ls().setContentView(i);
    }

    public void setContentView(View view) {
        ls().setContentView(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        ls().setContentView(view, layoutParams);
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        ls().addContentView(view, layoutParams);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ls().onConfigurationChanged(configuration);
        if (this.Xe != null) {
            this.Xe.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
    }

    protected void onPostResume() {
        super.onPostResume();
        ls().onPostResume();
    }

    protected void onStart() {
        super.onStart();
        ls().onStart();
    }

    public void onStop() {
        super.onStop();
        ls().onStop();
    }

    public View findViewById(int i) {
        return ls().findViewById(i);
    }

    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        ActionBar lp = lp();
        if (menuItem.getItemId() != 16908332 || lp == null || (lp.getDisplayOptions() & 4) == 0) {
            return false;
        }
        return lq();
    }

    public void onDestroy() {
        super.onDestroy();
        ls().onDestroy();
    }

    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        ls().setTitle(charSequence);
    }

    public void supportInvalidateOptionsMenu() {
        ls().invalidateOptionsMenu();
    }

    public void invalidateOptionsMenu() {
        ls().invalidateOptionsMenu();
    }

    public void mo1718a(pu puVar) {
    }

    public void mo1720b(pu puVar) {
    }

    public pu mo1719b(a aVar) {
        return null;
    }

    public void m6460a(gi giVar) {
        giVar.m11518k(this);
    }

    public void m6463b(gi giVar) {
    }

    public boolean lq() {
        Intent iK = iK();
        if (iK == null) {
            return false;
        }
        if (m6465d(iK)) {
            gi m = gi.m11515m(this);
            m6460a(m);
            m6463b(m);
            m.startActivities();
            try {
                eg.m10638a((Activity) this);
            } catch (IllegalStateException e) {
                finish();
            }
        } else {
            m6466e(iK);
        }
        return true;
    }

    public Intent iK() {
        return fl.m11439g(this);
    }

    public boolean m6465d(Intent intent) {
        return fl.m11435a((Activity) this, intent);
    }

    public void m6466e(Intent intent) {
        fl.m11437b((Activity) this, intent);
    }

    public void onContentChanged() {
        lr();
    }

    @Deprecated
    public void lr() {
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        ls().onSaveInstanceState(bundle);
    }

    public ov ls() {
        if (this.abe == null) {
            this.abe = ov.a(this, this);
        }
        return this.abe;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (kg.m11964c(keyEvent) && keyEvent.getUnicodeChar(keyEvent.getMetaState() & -28673) == 60) {
            int action = keyEvent.getAction();
            if (action == 0) {
                ActionBar lp = lp();
                if (lp != null && lp.isShowing() && lp.requestFocus()) {
                    this.abg = true;
                    return true;
                }
            } else if (action == 1 && this.abg) {
                this.abg = false;
                return true;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public Resources getResources() {
        if (this.Xe == null && sy.sH()) {
            this.Xe = new sy(this, super.getResources());
        }
        return this.Xe == null ? super.getResources() : this.Xe;
    }
}
