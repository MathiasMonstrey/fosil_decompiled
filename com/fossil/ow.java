package com.fossil;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;
import com.fossil.pu.C3965a;
import java.lang.Thread.UncaughtExceptionHandler;

@TargetApi(9)
abstract class ow extends ov {
    private static boolean abj = true;
    private static final boolean abk = (VERSION.SDK_INT < 21);
    private static final int[] abl = new int[]{16842836};
    private CharSequence Od;
    final Window ZQ;
    final Callback abm = this.ZQ.getCallback();
    final Callback abn;
    final ou abo;
    ActionBar abp;
    boolean abq;
    boolean abr;
    boolean abs;
    boolean abt;
    boolean abu;
    private boolean abv;
    private boolean abw;
    final Context mContext;
    MenuInflater vL;

    class C3946a extends qb {
        final /* synthetic */ ow aby;

        C3946a(ow owVar, Callback callback) {
            this.aby = owVar;
            super(callback);
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return this.aby.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || this.aby.onKeyShortcut(keyEvent.getKeyCode(), keyEvent);
        }

        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof qj)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        public void onContentChanged() {
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            qj qjVar;
            if (menu instanceof qj) {
                qjVar = (qj) menu;
            } else {
                qjVar = null;
            }
            if (i == 0 && qjVar == null) {
                return false;
            }
            if (qjVar != null) {
                qjVar.ac(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (qjVar == null) {
                return onPreparePanel;
            }
            qjVar.ac(false);
            return onPreparePanel;
        }

        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            this.aby.onMenuOpened(i, menu);
            return true;
        }

        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            this.aby.onPanelClosed(i, menu);
        }
    }

    abstract pu mo3971c(C3965a c3965a);

    abstract boolean dispatchKeyEvent(KeyEvent keyEvent);

    abstract void lx();

    abstract void mo3977n(CharSequence charSequence);

    abstract boolean onKeyShortcut(int i, KeyEvent keyEvent);

    abstract boolean onMenuOpened(int i, Menu menu);

    abstract void onPanelClosed(int i, Menu menu);

    static {
        if (abk && !abj) {
            final UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {
                public void uncaughtException(Thread thread, Throwable th) {
                    if (m12953a(th)) {
                        Throwable notFoundException = new NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                        notFoundException.initCause(th.getCause());
                        notFoundException.setStackTrace(th.getStackTrace());
                        defaultUncaughtExceptionHandler.uncaughtException(thread, notFoundException);
                        return;
                    }
                    defaultUncaughtExceptionHandler.uncaughtException(thread, th);
                }

                private boolean m12953a(Throwable th) {
                    if (!(th instanceof NotFoundException)) {
                        return false;
                    }
                    String message = th.getMessage();
                    if (message == null) {
                        return false;
                    }
                    if (message.contains("drawable") || message.contains("Drawable")) {
                        return true;
                    }
                    return false;
                }
            });
        }
    }

    ow(Context context, Window window, ou ouVar) {
        this.mContext = context;
        this.ZQ = window;
        this.abo = ouVar;
        if (this.abm instanceof C3946a) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        this.abn = mo3990a(this.abm);
        this.ZQ.setCallback(this.abn);
        sw a = sw.m13582a(context, null, abl);
        Drawable el = a.el(0);
        if (el != null) {
            this.ZQ.setBackgroundDrawable(el);
        }
        a.recycle();
    }

    Callback mo3990a(Callback callback) {
        return new C3946a(this, callback);
    }

    public ActionBar lp() {
        lx();
        return this.abp;
    }

    final ActionBar ly() {
        return this.abp;
    }

    public MenuInflater getMenuInflater() {
        if (this.vL == null) {
            lx();
            this.vL = new pz(this.abp != null ? this.abp.getThemedContext() : this.mContext);
        }
        return this.vL;
    }

    final Context lz() {
        Context context = null;
        ActionBar lp = lp();
        if (lp != null) {
            context = lp.getThemedContext();
        }
        if (context == null) {
            return this.mContext;
        }
        return context;
    }

    public void onStart() {
        this.abv = true;
    }

    public void onStop() {
        this.abv = false;
    }

    public void onDestroy() {
        this.abw = true;
    }

    public boolean lA() {
        return false;
    }

    public boolean lu() {
        return false;
    }

    final boolean isDestroyed() {
        return this.abw;
    }

    final Callback lB() {
        return this.ZQ.getCallback();
    }

    public final void setTitle(CharSequence charSequence) {
        this.Od = charSequence;
        mo3977n(charSequence);
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    final CharSequence getTitle() {
        if (this.abm instanceof Activity) {
            return ((Activity) this.abm).getTitle();
        }
        return this.Od;
    }
}
