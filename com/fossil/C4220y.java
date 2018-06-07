package com.fossil;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import java.util.ArrayList;

public final class C4220y {
    public final Intent intent;
    public final Bundle tk;

    public static final class C4219a {
        private final Intent mIntent;
        private ArrayList<Bundle> tl;
        private Bundle tm;
        private ArrayList<Bundle> tn;
        private boolean tq;

        public C4219a() {
            this(null);
        }

        public C4219a(aa aaVar) {
            IBinder iBinder = null;
            this.mIntent = new Intent("android.intent.action.VIEW");
            this.tl = null;
            this.tm = null;
            this.tn = null;
            this.tq = true;
            if (aaVar != null) {
                this.mIntent.setPackage(aaVar.getComponentName().getPackageName());
            }
            Bundle bundle = new Bundle();
            String str = "android.support.customtabs.extra.SESSION";
            if (aaVar != null) {
                iBinder = aaVar.getBinder();
            }
            es.a(bundle, str, iBinder);
            this.mIntent.putExtras(bundle);
        }

        public C4220y eR() {
            if (this.tl != null) {
                this.mIntent.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", this.tl);
            }
            if (this.tn != null) {
                this.mIntent.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", this.tn);
            }
            this.mIntent.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.tq);
            return new C4220y(this.mIntent, this.tm);
        }
    }

    private C4220y(Intent intent, Bundle bundle) {
        this.intent = intent;
        this.tk = bundle;
    }
}
