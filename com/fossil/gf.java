package com.fossil;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Parcelable;
import java.util.ArrayList;

public final class gf {
    static C3619b Mg;

    public static class C3618a {
        private Activity IX;
        private CharSequence Mh;
        private ArrayList<String> Mi;
        private ArrayList<String> Mj;
        private ArrayList<String> Mk;
        private ArrayList<Uri> Ml;
        private Intent mIntent = new Intent().setAction("android.intent.action.SEND");

        public static C3618a m11507j(Activity activity) {
            return new C3618a(activity);
        }

        private C3618a(Activity activity) {
            this.IX = activity;
            this.mIntent.putExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE", activity.getPackageName());
            this.mIntent.putExtra("android.support.v4.app.EXTRA_CALLING_ACTIVITY", activity.getComponentName());
            this.mIntent.addFlags(524288);
        }

        public Intent getIntent() {
            if (this.Mi != null) {
                m11506a("android.intent.extra.EMAIL", this.Mi);
                this.Mi = null;
            }
            if (this.Mj != null) {
                m11506a("android.intent.extra.CC", this.Mj);
                this.Mj = null;
            }
            if (this.Mk != null) {
                m11506a("android.intent.extra.BCC", this.Mk);
                this.Mk = null;
            }
            int i = (this.Ml == null || this.Ml.size() <= 1) ? 0 : 1;
            boolean equals = this.mIntent.getAction().equals("android.intent.action.SEND_MULTIPLE");
            if (i == 0 && equals) {
                this.mIntent.setAction("android.intent.action.SEND");
                if (this.Ml == null || this.Ml.isEmpty()) {
                    this.mIntent.removeExtra("android.intent.extra.STREAM");
                } else {
                    this.mIntent.putExtra("android.intent.extra.STREAM", (Parcelable) this.Ml.get(0));
                }
                this.Ml = null;
            }
            if (!(i == 0 || equals)) {
                this.mIntent.setAction("android.intent.action.SEND_MULTIPLE");
                if (this.Ml == null || this.Ml.isEmpty()) {
                    this.mIntent.removeExtra("android.intent.extra.STREAM");
                } else {
                    this.mIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", this.Ml);
                }
            }
            return this.mIntent;
        }

        private void m11506a(String str, ArrayList<String> arrayList) {
            Object stringArrayExtra = this.mIntent.getStringArrayExtra(str);
            int length = stringArrayExtra != null ? stringArrayExtra.length : 0;
            Object obj = new String[(arrayList.size() + length)];
            arrayList.toArray(obj);
            if (stringArrayExtra != null) {
                System.arraycopy(stringArrayExtra, 0, obj, arrayList.size(), length);
            }
            this.mIntent.putExtra(str, obj);
        }

        public Intent iI() {
            return Intent.createChooser(getIntent(), this.Mh);
        }

        public void iJ() {
            this.IX.startActivity(iI());
        }

        public C3618a m11508Y(String str) {
            this.mIntent.setType(str);
            return this;
        }

        public C3618a m11509Z(String str) {
            if (this.Mi == null) {
                this.Mi = new ArrayList();
            }
            this.Mi.add(str);
            return this;
        }
    }

    interface C3619b {
    }

    static class C3620c implements C3619b {
        C3620c() {
        }
    }

    static class C3621d extends C3620c {
        C3621d() {
        }
    }

    static class C3622e extends C3621d {
        C3622e() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            Mg = new C3622e();
        } else if (VERSION.SDK_INT >= 14) {
            Mg = new C3621d();
        } else {
            Mg = new C3620c();
        }
    }
}
