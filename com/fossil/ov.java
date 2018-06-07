package com.fossil;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;

public abstract class ov {
    private static int abh = -1;
    private static boolean abi = false;

    public abstract void mo3967a(Toolbar toolbar);

    public abstract void addContentView(View view, LayoutParams layoutParams);

    public abstract View findViewById(int i);

    public abstract MenuInflater getMenuInflater();

    public abstract void invalidateOptionsMenu();

    public abstract ActionBar lp();

    public abstract void lt();

    public abstract boolean lu();

    public abstract void onConfigurationChanged(Configuration configuration);

    public abstract void onCreate(Bundle bundle);

    public abstract void onDestroy();

    public abstract void onPostCreate(Bundle bundle);

    public abstract void onPostResume();

    public abstract void onSaveInstanceState(Bundle bundle);

    public abstract void onStart();

    public abstract void onStop();

    public abstract boolean requestWindowFeature(int i);

    public abstract void setContentView(int i);

    public abstract void setContentView(View view);

    public abstract void setContentView(View view, LayoutParams layoutParams);

    public abstract void setTitle(CharSequence charSequence);

    public static ov m12949a(Activity activity, ou ouVar) {
        return m12951a(activity, activity.getWindow(), ouVar);
    }

    public static ov m12950a(Dialog dialog, ou ouVar) {
        return m12951a(dialog.getContext(), dialog.getWindow(), ouVar);
    }

    private static ov m12951a(Context context, Window window, ou ouVar) {
        int i = VERSION.SDK_INT;
        if (it.ji()) {
            return new ox(context, window, ouVar);
        }
        if (i >= 23) {
            return new pa(context, window, ouVar);
        }
        if (i >= 14) {
            return new oz(context, window, ouVar);
        }
        if (i >= 11) {
            return new oy(context, window, ouVar);
        }
        return new pb(context, window, ouVar);
    }

    ov() {
    }

    public static int lv() {
        return abh;
    }

    public static boolean lw() {
        return abi;
    }
}
