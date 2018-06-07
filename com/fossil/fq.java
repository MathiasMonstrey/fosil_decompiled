package com.fossil;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v8.renderscript.Allocation;
import android.widget.RemoteViews;
import com.fossil.fr.C3604a;
import com.fossil.fs.C3605a;
import com.fossil.ft.C3606a;
import com.fossil.fu.C3585a;
import com.fossil.fu.C3585a.C3583a;
import com.fossil.fw.C3607a;
import com.fossil.fx.C3608a;
import com.fossil.fy.C3609a;
import com.fossil.gd.C3617a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class fq {
    static final C3595h KU;

    public static class C3586a extends C3585a {
        public static final C3583a KY = new C35841();
        final Bundle KV;
        private final gb[] KW;
        private boolean KX;
        public PendingIntent actionIntent;
        public int icon;
        public CharSequence title;

        static class C35841 implements C3583a {
            C35841() {
            }
        }

        public /* synthetic */ C3617a[] iD() {
            return iC();
        }

        public int getIcon() {
            return this.icon;
        }

        public CharSequence getTitle() {
            return this.title;
        }

        public PendingIntent iB() {
            return this.actionIntent;
        }

        public Bundle getExtras() {
            return this.KV;
        }

        public boolean getAllowGeneratedReplies() {
            return this.KX;
        }

        public gb[] iC() {
            return this.KW;
        }
    }

    public static abstract class C3587q {
        C3590d LO;
        CharSequence LP;
        CharSequence LQ;
        boolean LR = false;

        public void m11447a(C3590d c3590d) {
            if (this.LO != c3590d) {
                this.LO = c3590d;
                if (this.LO != null) {
                    this.LO.m11457a(this);
                }
            }
        }

        public void mo3114c(Bundle bundle) {
        }
    }

    public static class C3588b extends C3587q {
        Bitmap KZ;
        Bitmap La;
        boolean Lb;
    }

    public static class C3589c extends C3587q {
        CharSequence Lc;

        public C3589c m11449d(CharSequence charSequence) {
            this.Lc = C3590d.m11451h(charSequence);
            return this;
        }
    }

    public static class C3590d {
        Bundle KV;
        int LA = 0;
        Notification LB;
        RemoteViews LC;
        RemoteViews LD;
        RemoteViews LE;
        public Notification LF = new Notification();
        public ArrayList<String> LG;
        public CharSequence Ld;
        public CharSequence Le;
        PendingIntent Lf;
        PendingIntent Lg;
        RemoteViews Lh;
        public Bitmap Li;
        public CharSequence Lj;
        public int Lk;
        int Ll;
        boolean Lm = true;
        public boolean Ln;
        public C3587q Lo;
        public CharSequence Lp;
        public CharSequence[] Lq;
        int Lr;
        int Ls;
        boolean Lt;
        String Lu;
        boolean Lv;
        String Lw;
        public ArrayList<C3586a> Lx = new ArrayList();
        boolean Ly = false;
        String Lz;
        public Context mContext;
        int sl = 0;

        public C3590d(Context context) {
            this.mContext = context;
            this.LF.when = System.currentTimeMillis();
            this.LF.audioStreamType = -1;
            this.Ll = 0;
            this.LG = new ArrayList();
        }

        public C3590d m11463m(long j) {
            this.LF.when = j;
            return this;
        }

        public C3590d aO(int i) {
            this.LF.icon = i;
            return this;
        }

        public C3590d m11460e(CharSequence charSequence) {
            this.Ld = C3590d.m11451h(charSequence);
            return this;
        }

        public C3590d m11461f(CharSequence charSequence) {
            this.Le = C3590d.m11451h(charSequence);
            return this;
        }

        public C3590d m11453a(PendingIntent pendingIntent) {
            this.Lf = pendingIntent;
            return this;
        }

        public C3590d m11459b(PendingIntent pendingIntent) {
            this.LF.deleteIntent = pendingIntent;
            return this;
        }

        public C3590d m11462g(CharSequence charSequence) {
            this.LF.tickerText = C3590d.m11451h(charSequence);
            return this;
        }

        public C3590d m11454a(Bitmap bitmap) {
            this.Li = bitmap;
            return this;
        }

        public C3590d m11455a(Uri uri) {
            this.LF.sound = uri;
            this.LF.audioStreamType = -1;
            return this;
        }

        public C3590d m11458a(long[] jArr) {
            this.LF.vibrate = jArr;
            return this;
        }

        public C3590d m11464z(boolean z) {
            m11450d(16, z);
            return this;
        }

        public C3590d m11452A(boolean z) {
            this.Ly = z;
            return this;
        }

        public C3590d aP(int i) {
            this.LF.defaults = i;
            if ((i & 4) != 0) {
                Notification notification = this.LF;
                notification.flags |= 1;
            }
            return this;
        }

        private void m11450d(int i, boolean z) {
            if (z) {
                Notification notification = this.LF;
                notification.flags |= i;
                return;
            }
            notification = this.LF;
            notification.flags &= i ^ -1;
        }

        public C3590d aQ(int i) {
            this.Ll = i;
            return this;
        }

        public C3590d m11456a(C3586a c3586a) {
            this.Lx.add(c3586a);
            return this;
        }

        public C3590d m11457a(C3587q c3587q) {
            if (this.Lo != c3587q) {
                this.Lo = c3587q;
                if (this.Lo != null) {
                    this.Lo.m11447a(this);
                }
            }
            return this;
        }

        public C3590d aR(int i) {
            this.LA = i;
            return this;
        }

        public Notification build() {
            return fq.KU.mo3115a(this, iE());
        }

        protected C3591e iE() {
            return new C3591e();
        }

        protected static CharSequence m11451h(CharSequence charSequence) {
            if (charSequence != null && charSequence.length() > 5120) {
                return charSequence.subSequence(0, 5120);
            }
            return charSequence;
        }

        protected CharSequence iF() {
            return this.Le;
        }

        protected CharSequence iG() {
            return this.Ld;
        }
    }

    public static class C3591e {
        protected C3591e() {
        }

        public Notification m11465a(C3590d c3590d, fp fpVar) {
            Notification build = fpVar.build();
            if (c3590d.LC != null) {
                build.contentView = c3590d.LC;
            }
            return build;
        }
    }

    public static class C3592f extends C3587q {
        ArrayList<CharSequence> LH = new ArrayList();
    }

    public static class C3594g extends C3587q {
        CharSequence LI;
        CharSequence LJ;
        List<C3593a> LK = new ArrayList();

        public static final class C3593a {
            private final CharSequence LL;
            private String LM;
            private Uri LN;
            private final long mTimestamp;
            private final CharSequence xf;

            public CharSequence getText() {
                return this.xf;
            }

            public long getTimestamp() {
                return this.mTimestamp;
            }

            public CharSequence getSender() {
                return this.LL;
            }

            public String getDataMimeType() {
                return this.LM;
            }

            public Uri getDataUri() {
                return this.LN;
            }

            private Bundle toBundle() {
                Bundle bundle = new Bundle();
                if (this.xf != null) {
                    bundle.putCharSequence("text", this.xf);
                }
                bundle.putLong("time", this.mTimestamp);
                if (this.LL != null) {
                    bundle.putCharSequence("sender", this.LL);
                }
                if (this.LM != null) {
                    bundle.putString("type", this.LM);
                }
                if (this.LN != null) {
                    bundle.putParcelable("uri", this.LN);
                }
                return bundle;
            }

            static Bundle[] m11466m(List<C3593a> list) {
                Bundle[] bundleArr = new Bundle[list.size()];
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    bundleArr[i] = ((C3593a) list.get(i)).toBundle();
                }
                return bundleArr;
            }
        }

        C3594g() {
        }

        public void mo3114c(Bundle bundle) {
            super.mo3114c(bundle);
            if (this.LI != null) {
                bundle.putCharSequence("android.selfDisplayName", this.LI);
            }
            if (this.LJ != null) {
                bundle.putCharSequence("android.conversationTitle", this.LJ);
            }
            if (!this.LK.isEmpty()) {
                bundle.putParcelableArray("android.messages", C3593a.m11466m(this.LK));
            }
        }
    }

    interface C3595h {
        Notification mo3115a(C3590d c3590d, C3591e c3591e);
    }

    static class C3596l implements C3595h {
        C3596l() {
        }

        public Notification mo3115a(C3590d c3590d, C3591e c3591e) {
            Notification a = fu.m11488a(c3590d.LF, c3590d.mContext, c3590d.iG(), c3590d.iF(), c3590d.Lf, c3590d.Lg);
            if (c3590d.Ll > 0) {
                a.flags |= Allocation.USAGE_SHARED;
            }
            if (c3590d.LC != null) {
                a.contentView = c3590d.LC;
            }
            return a;
        }

        public Bundle mo3116a(Notification notification) {
            return null;
        }
    }

    static class C3597o extends C3596l {
        C3597o() {
        }

        public Notification mo3115a(C3590d c3590d, C3591e c3591e) {
            fp c3608a = new C3608a(c3590d.mContext, c3590d.LF, c3590d.iG(), c3590d.iF(), c3590d.Lj, c3590d.Lh, c3590d.Lk, c3590d.Lf, c3590d.Lg, c3590d.Li, c3590d.Lr, c3590d.Ls, c3590d.Lt, c3590d.Ln, c3590d.Ll, c3590d.Lp, c3590d.Ly, c3590d.KV, c3590d.Lu, c3590d.Lv, c3590d.Lw, c3590d.LC, c3590d.LD);
            fq.m11480a((fo) c3608a, c3590d.Lx);
            fq.m11481a(c3608a, c3590d.Lo);
            Notification a = c3591e.m11465a(c3590d, c3608a);
            if (c3590d.Lo != null) {
                Bundle a2 = mo3116a(a);
                if (a2 != null) {
                    c3590d.Lo.mo3114c(a2);
                }
            }
            return a;
        }

        public Bundle mo3116a(Notification notification) {
            return fx.m11491a(notification);
        }
    }

    static class C3598p extends C3597o {
        C3598p() {
        }

        public Notification mo3115a(C3590d c3590d, C3591e c3591e) {
            fp c3609a = new C3609a(c3590d.mContext, c3590d.LF, c3590d.iG(), c3590d.iF(), c3590d.Lj, c3590d.Lh, c3590d.Lk, c3590d.Lf, c3590d.Lg, c3590d.Li, c3590d.Lr, c3590d.Ls, c3590d.Lt, c3590d.Lm, c3590d.Ln, c3590d.Ll, c3590d.Lp, c3590d.Ly, c3590d.LG, c3590d.KV, c3590d.Lu, c3590d.Lv, c3590d.Lw, c3590d.LC, c3590d.LD);
            fq.m11480a((fo) c3609a, c3590d.Lx);
            fq.m11481a(c3609a, c3590d.Lo);
            return c3591e.m11465a(c3590d, c3609a);
        }

        public Bundle mo3116a(Notification notification) {
            return fy.m11498a(notification);
        }
    }

    static class C3599i extends C3598p {
        C3599i() {
        }

        public Notification mo3115a(C3590d c3590d, C3591e c3591e) {
            fp c3604a = new C3604a(c3590d.mContext, c3590d.LF, c3590d.iG(), c3590d.iF(), c3590d.Lj, c3590d.Lh, c3590d.Lk, c3590d.Lf, c3590d.Lg, c3590d.Li, c3590d.Lr, c3590d.Ls, c3590d.Lt, c3590d.Lm, c3590d.Ln, c3590d.Ll, c3590d.Lp, c3590d.Ly, c3590d.LG, c3590d.KV, c3590d.Lu, c3590d.Lv, c3590d.Lw, c3590d.LC, c3590d.LD);
            fq.m11480a((fo) c3604a, c3590d.Lx);
            fq.m11481a(c3604a, c3590d.Lo);
            Notification a = c3591e.m11465a(c3590d, c3604a);
            if (c3590d.Lo != null) {
                c3590d.Lo.mo3114c(mo3116a(a));
            }
            return a;
        }
    }

    static class C3600j extends C3599i {
        C3600j() {
        }

        public Notification mo3115a(C3590d c3590d, C3591e c3591e) {
            fp c3605a = new C3605a(c3590d.mContext, c3590d.LF, c3590d.iG(), c3590d.iF(), c3590d.Lj, c3590d.Lh, c3590d.Lk, c3590d.Lf, c3590d.Lg, c3590d.Li, c3590d.Lr, c3590d.Ls, c3590d.Lt, c3590d.Lm, c3590d.Ln, c3590d.Ll, c3590d.Lp, c3590d.Ly, c3590d.Lz, c3590d.LG, c3590d.KV, c3590d.LA, c3590d.sl, c3590d.LB, c3590d.Lu, c3590d.Lv, c3590d.Lw, c3590d.LC, c3590d.LD, c3590d.LE);
            fq.m11480a((fo) c3605a, c3590d.Lx);
            fq.m11481a(c3605a, c3590d.Lo);
            Notification a = c3591e.m11465a(c3590d, c3605a);
            if (c3590d.Lo != null) {
                c3590d.Lo.mo3114c(mo3116a(a));
            }
            return a;
        }
    }

    static class C3601k extends C3600j {
        C3601k() {
        }

        public Notification mo3115a(C3590d c3590d, C3591e c3591e) {
            fo c3606a = new C3606a(c3590d.mContext, c3590d.LF, c3590d.Ld, c3590d.Le, c3590d.Lj, c3590d.Lh, c3590d.Lk, c3590d.Lf, c3590d.Lg, c3590d.Li, c3590d.Lr, c3590d.Ls, c3590d.Lt, c3590d.Lm, c3590d.Ln, c3590d.Ll, c3590d.Lp, c3590d.Ly, c3590d.Lz, c3590d.LG, c3590d.KV, c3590d.LA, c3590d.sl, c3590d.LB, c3590d.Lu, c3590d.Lv, c3590d.Lw, c3590d.Lq, c3590d.LC, c3590d.LD, c3590d.LE);
            fq.m11480a(c3606a, c3590d.Lx);
            fq.m11482b(c3606a, c3590d.Lo);
            Notification a = c3591e.m11465a(c3590d, c3606a);
            if (c3590d.Lo != null) {
                c3590d.Lo.mo3114c(mo3116a(a));
            }
            return a;
        }
    }

    static class C3602m extends C3596l {
        C3602m() {
        }

        public Notification mo3115a(C3590d c3590d, C3591e c3591e) {
            Notification a = fv.m11489a(c3590d.mContext, c3590d.LF, c3590d.iG(), c3590d.iF(), c3590d.Lj, c3590d.Lh, c3590d.Lk, c3590d.Lf, c3590d.Lg, c3590d.Li);
            if (c3590d.LC != null) {
                a.contentView = c3590d.LC;
            }
            return a;
        }
    }

    static class C3603n extends C3596l {
        C3603n() {
        }

        public Notification mo3115a(C3590d c3590d, C3591e c3591e) {
            return c3591e.m11465a(c3590d, new C3607a(c3590d.mContext, c3590d.LF, c3590d.iG(), c3590d.iF(), c3590d.Lj, c3590d.Lh, c3590d.Lk, c3590d.Lf, c3590d.Lg, c3590d.Li, c3590d.Lr, c3590d.Ls, c3590d.Lt));
        }
    }

    static void m11480a(fo foVar, ArrayList<C3586a> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            foVar.mo3117a((C3586a) it.next());
        }
    }

    static void m11481a(fp fpVar, C3587q c3587q) {
        if (c3587q == null) {
            return;
        }
        if (c3587q instanceof C3589c) {
            C3589c c3589c = (C3589c) c3587q;
            fx.m11493a(fpVar, c3589c.LP, c3589c.LR, c3589c.LQ, c3589c.Lc);
        } else if (c3587q instanceof C3592f) {
            C3592f c3592f = (C3592f) c3587q;
            fx.m11494a(fpVar, c3592f.LP, c3592f.LR, c3592f.LQ, c3592f.LH);
        } else if (c3587q instanceof C3588b) {
            C3588b c3588b = (C3588b) c3587q;
            fx.m11492a(fpVar, c3588b.LP, c3588b.LR, c3588b.LQ, c3588b.KZ, c3588b.La, c3588b.Lb);
        }
    }

    static void m11482b(fp fpVar, C3587q c3587q) {
        if (c3587q == null) {
            return;
        }
        if (c3587q instanceof C3594g) {
            C3594g c3594g = (C3594g) c3587q;
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            List arrayList3 = new ArrayList();
            List arrayList4 = new ArrayList();
            List arrayList5 = new ArrayList();
            for (C3593a c3593a : c3594g.LK) {
                arrayList.add(c3593a.getText());
                arrayList2.add(Long.valueOf(c3593a.getTimestamp()));
                arrayList3.add(c3593a.getSender());
                arrayList4.add(c3593a.getDataMimeType());
                arrayList5.add(c3593a.getDataUri());
            }
            ft.m11487a(fpVar, c3594g.LI, c3594g.LJ, arrayList, arrayList2, arrayList3, arrayList4, arrayList5);
            return;
        }
        m11481a(fpVar, c3587q);
    }

    static {
        if (it.ji()) {
            KU = new C3601k();
        } else if (VERSION.SDK_INT >= 21) {
            KU = new C3600j();
        } else if (VERSION.SDK_INT >= 20) {
            KU = new C3599i();
        } else if (VERSION.SDK_INT >= 19) {
            KU = new C3598p();
        } else if (VERSION.SDK_INT >= 16) {
            KU = new C3597o();
        } else if (VERSION.SDK_INT >= 14) {
            KU = new C3603n();
        } else if (VERSION.SDK_INT >= 11) {
            KU = new C3602m();
        } else {
            KU = new C3596l();
        }
    }
}
