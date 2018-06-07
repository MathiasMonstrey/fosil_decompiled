package com.fossil;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

public class zq implements Callback {
    private static final zq aFL = new zq();
    private volatile tz aFM;
    final Map<FragmentManager, zp> aFN = new HashMap();
    final Map<fa, zt> aFO = new HashMap();
    private final Handler handler = new Handler(Looper.getMainLooper(), this);

    public static zq wm() {
        return aFL;
    }

    zq() {
    }

    private tz m14160I(Context context) {
        if (this.aFM == null) {
            synchronized (this) {
                if (this.aFM == null) {
                    this.aFM = new tz(context.getApplicationContext(), new zh(), new zl());
                }
            }
        }
        return this.aFM;
    }

    public tz m14162J(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        if (abl.wZ() && !(context instanceof Application)) {
            if (context instanceof ew) {
                return m14167b((ew) context);
            }
            if (context instanceof Activity) {
                return m14168n((Activity) context);
            }
            if (context instanceof ContextWrapper) {
                return m14162J(((ContextWrapper) context).getBaseContext());
            }
        }
        return m14160I(context);
    }

    public tz m14167b(ew ewVar) {
        if (abl.xa()) {
            return m14162J(ewVar.getApplicationContext());
        }
        m14161o(ewVar);
        return m14166b((Context) ewVar, ewVar.getSupportFragmentManager());
    }

    public tz m14169u(Fragment fragment) {
        if (fragment.getActivity() == null) {
            throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
        } else if (abl.xa()) {
            return m14162J(fragment.getActivity().getApplicationContext());
        } else {
            return m14166b(fragment.getActivity(), fragment.getChildFragmentManager());
        }
    }

    @TargetApi(11)
    public tz m14168n(Activity activity) {
        if (abl.xa() || VERSION.SDK_INT < 11) {
            return m14162J(activity.getApplicationContext());
        }
        m14161o(activity);
        return m14165b((Context) activity, activity.getFragmentManager());
    }

    @TargetApi(17)
    private static void m14161o(Activity activity) {
        if (VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    @TargetApi(17)
    zp m14163a(FragmentManager fragmentManager) {
        zp zpVar = (zp) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (zpVar != null) {
            return zpVar;
        }
        zpVar = (zp) this.aFN.get(fragmentManager);
        if (zpVar != null) {
            return zpVar;
        }
        android.app.Fragment zpVar2 = new zp();
        this.aFN.put(fragmentManager, zpVar2);
        fragmentManager.beginTransaction().add(zpVar2, "com.bumptech.glide.manager").commitAllowingStateLoss();
        this.handler.obtainMessage(1, fragmentManager).sendToTarget();
        return zpVar2;
    }

    @TargetApi(11)
    tz m14165b(Context context, FragmentManager fragmentManager) {
        zp a = m14163a(fragmentManager);
        tz wk = a.wk();
        if (wk != null) {
            return wk;
        }
        wk = new tz(context, a.wj(), a.wl());
        a.m14159g(wk);
        return wk;
    }

    zt m14164a(fa faVar) {
        zt ztVar = (zt) faVar.W("com.bumptech.glide.manager");
        if (ztVar != null) {
            return ztVar;
        }
        ztVar = (zt) this.aFO.get(faVar);
        if (ztVar != null) {
            return ztVar;
        }
        Fragment ztVar2 = new zt();
        this.aFO.put(faVar, ztVar2);
        faVar.hW().a(ztVar2, "com.bumptech.glide.manager").commitAllowingStateLoss();
        this.handler.obtainMessage(2, faVar).sendToTarget();
        return ztVar2;
    }

    tz m14166b(Context context, fa faVar) {
        zt a = m14164a(faVar);
        tz wk = a.wk();
        if (wk != null) {
            return wk;
        }
        wk = new tz(context, a.wj(), a.wl());
        a.m14174g(wk);
        return wk;
    }

    public boolean handleMessage(Message message) {
        Object obj = null;
        boolean z = true;
        Object remove;
        switch (message.what) {
            case 1:
                FragmentManager fragmentManager = (FragmentManager) message.obj;
                remove = this.aFN.remove(fragmentManager);
                break;
            case 2:
                fa faVar = (fa) message.obj;
                remove = this.aFO.remove(faVar);
                break;
            default:
                z = false;
                remove = null;
                break;
        }
        if (z && r1 == null && Log.isLoggable("RMRetriever", 5)) {
            Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj);
        }
        return z;
    }
}
