package com.fossil;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import com.fossil.pk.C3990i;

public class pw extends ContextWrapper {
    private Resources Xe;
    private LayoutInflater Yg;
    private int adY;
    private Theme adZ;
    private Configuration aea;

    public pw() {
        super(null);
    }

    public pw(Context context, int i) {
        super(context);
        this.adY = i;
    }

    public pw(Context context, Theme theme) {
        super(context);
        this.adZ = theme;
    }

    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public Resources getResources() {
        return mo();
    }

    private Resources mo() {
        if (this.Xe == null) {
            if (this.aea == null) {
                this.Xe = super.getResources();
            } else if (VERSION.SDK_INT >= 17) {
                this.Xe = createConfigurationContext(this.aea).getResources();
            }
        }
        return this.Xe;
    }

    public void setTheme(int i) {
        if (this.adY != i) {
            this.adY = i;
            mq();
        }
    }

    public int mp() {
        return this.adY;
    }

    public Theme getTheme() {
        if (this.adZ != null) {
            return this.adZ;
        }
        if (this.adY == 0) {
            this.adY = C3990i.Theme_AppCompat_Light;
        }
        mq();
        return this.adZ;
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.Yg == null) {
            this.Yg = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.Yg;
    }

    protected void onApplyThemeResource(Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    private void mq() {
        boolean z = this.adZ == null;
        if (z) {
            this.adZ = getResources().newTheme();
            Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.adZ.setTo(theme);
            }
        }
        onApplyThemeResource(this.adZ, this.adY, z);
    }

    public AssetManager getAssets() {
        return getResources().getAssets();
    }
}
