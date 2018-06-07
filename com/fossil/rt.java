package com.fossil;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window.Callback;
import com.fossil.qj.C3950a;
import com.fossil.qq.C3962a;

public interface rt {
    void mo4124a(Menu menu, C3962a c3962a);

    void mo4125a(C3962a c3962a, C3950a c3950a);

    void mo4126a(sn snVar);

    lz mo4127c(int i, long j);

    void collapseActionView();

    void dismissPopupMenus();

    Context getContext();

    int getDisplayOptions();

    Menu getMenu();

    int getNavigationMode();

    CharSequence getTitle();

    int getVisibility();

    boolean hasExpandedActionView();

    boolean hideOverflowMenu();

    boolean isOverflowMenuShowing();

    boolean nI();

    boolean nJ();

    void nK();

    ViewGroup oJ();

    void oK();

    void oL();

    void setCollapsible(boolean z);

    void setDisplayOptions(int i);

    void setHomeButtonEnabled(boolean z);

    void setIcon(int i);

    void setIcon(Drawable drawable);

    void setLogo(int i);

    void setNavigationIcon(int i);

    void setVisibility(int i);

    void setWindowCallback(Callback callback);

    void setWindowTitle(CharSequence charSequence);

    boolean showOverflowMenu();
}
