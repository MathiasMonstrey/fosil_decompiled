package com.fossil;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ActionMode;
import android.view.Window;
import android.view.Window.Callback;
import com.fossil.ow.C3946a;
import com.fossil.py.C4000a;

@TargetApi(14)
class oz extends oy {
    private int abA = -100;
    private boolean abB;
    private boolean abC = true;
    private C3952b abD;

    class C3947a extends C3946a {
        final /* synthetic */ oz abE;

        C3947a(oz ozVar, Callback callback) {
            this.abE = ozVar;
            super(ozVar, callback);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (this.abE.lA()) {
                return m12957a(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        final ActionMode m12957a(ActionMode.Callback callback) {
            Object c4000a = new C4000a(this.abE.mContext, callback);
            pu d = this.abE.m12980d(c4000a);
            if (d != null) {
                return c4000a.m13095d(d);
            }
            return null;
        }
    }

    final class C3952b {
        final /* synthetic */ oz abE;
        private pi abF;
        private boolean abG;
        private BroadcastReceiver abH;
        private IntentFilter abI;

        class C39511 extends BroadcastReceiver {
            final /* synthetic */ C3952b abJ;

            C39511(C3952b c3952b) {
                this.abJ = c3952b;
            }

            public void onReceive(Context context, Intent intent) {
                this.abJ.lF();
            }
        }

        C3952b(oz ozVar, pi piVar) {
            this.abE = ozVar;
            this.abF = piVar;
            this.abG = piVar.lU();
        }

        final int lE() {
            this.abG = this.abF.lU();
            return this.abG ? 2 : 1;
        }

        final void lF() {
            boolean lU = this.abF.lU();
            if (lU != this.abG) {
                this.abG = lU;
                this.abE.lu();
            }
        }

        final void setup() {
            lG();
            if (this.abH == null) {
                this.abH = new C39511(this);
            }
            if (this.abI == null) {
                this.abI = new IntentFilter();
                this.abI.addAction("android.intent.action.TIME_SET");
                this.abI.addAction("android.intent.action.TIMEZONE_CHANGED");
                this.abI.addAction("android.intent.action.TIME_TICK");
            }
            this.abE.mContext.registerReceiver(this.abH, this.abI);
        }

        final void lG() {
            if (this.abH != null) {
                this.abE.mContext.unregisterReceiver(this.abH);
                this.abH = null;
            }
        }
    }

    oz(Context context, Window window, ou ouVar) {
        super(context, window, ouVar);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null && this.abA == -100) {
            this.abA = bundle.getInt("appcompat:local_night_mode", -100);
        }
    }

    Callback mo3990a(Callback callback) {
        return new C3947a(this, callback);
    }

    public boolean lA() {
        return this.abC;
    }

    public boolean lu() {
        boolean z = false;
        int nightMode = getNightMode();
        int ck = ck(nightMode);
        if (ck != -1) {
            z = cl(ck);
        }
        if (nightMode == 0) {
            lC();
            this.abD.setup();
        }
        this.abB = true;
        return z;
    }

    public void onStart() {
        super.onStart();
        lu();
    }

    public void onStop() {
        super.onStop();
        if (this.abD != null) {
            this.abD.lG();
        }
    }

    int ck(int i) {
        switch (i) {
            case -100:
                return -1;
            case 0:
                lC();
                return this.abD.lE();
            default:
                return i;
        }
    }

    private int getNightMode() {
        return this.abA != -100 ? this.abA : ov.lv();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.abA != -100) {
            bundle.putInt("appcompat:local_night_mode", this.abA);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.abD != null) {
            this.abD.lG();
        }
    }

    private boolean cl(int i) {
        Resources resources = this.mContext.getResources();
        Configuration configuration = resources.getConfiguration();
        int i2 = configuration.uiMode & 48;
        int i3 = i == 2 ? 32 : 16;
        if (i2 == i3) {
            return false;
        }
        if (lD()) {
            ((Activity) this.mContext).recreate();
        } else {
            Configuration configuration2 = new Configuration(configuration);
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            configuration2.uiMode = i3 | (configuration2.uiMode & -49);
            resources.updateConfiguration(configuration2, displayMetrics);
            pf.m13041e(resources);
        }
        return true;
    }

    private void lC() {
        if (this.abD == null) {
            this.abD = new C3952b(this, pi.m13058v(this.mContext));
        }
    }

    private boolean lD() {
        if (!this.abB || !(this.mContext instanceof Activity)) {
            return false;
        }
        try {
            if ((this.mContext.getPackageManager().getActivityInfo(new ComponentName(this.mContext, this.mContext.getClass()), 0).configChanges & 512) == 0) {
                return true;
            }
            return false;
        } catch (Throwable e) {
            Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e);
            return true;
        }
    }
}
