package com.fossil;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.fossil.ats.C1879a;
import com.fossil.ats.C1879a.C1880a;
import com.fossil.ats.C1879a.C1881b;
import com.fossil.ats.C1887c;
import com.fossil.ats.C1888f;
import com.fossil.ats.C1889e;
import com.fossil.ats.C1890b;
import com.fossil.ats.C1892d;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;

public abstract class atv {
    private static final Set<atv> bgd = Collections.newSetFromMap(new WeakHashMap());

    public static final class C1897a {
        private Account beU;
        private Looper bfY;
        private final Set<Scope> bge = new HashSet();
        private final Set<Scope> bgf = new HashSet();
        private int bgg;
        private View bgh;
        private String bgi;
        private String bgj;
        private final Map<ats<?>, awz> bgk = new jl();
        private final Map<ats<?>, C1879a> bgl = new jl();
        private bgg bgm;
        private int bgn = -1;
        private C1899c bgo;
        private atp bgp = atp.Ku();
        private C1890b<? extends btu, btv> bgq = btq.bvj;
        private final ArrayList<C1898b> bgr = new ArrayList();
        private final ArrayList<C1899c> bgs = new ArrayList();
        private boolean bgt = false;
        private final Context mContext;

        public C1897a(Context context) {
            this.mContext = context;
            this.bfY = context.getMainLooper();
            this.bgi = context.getPackageName();
            this.bgj = context.getClass().getName();
        }

        private final <O extends C1879a> void m4463a(ats<O> com_fossil_ats_O, O o, Scope... scopeArr) {
            Set hashSet = new HashSet(com_fossil_ats_O.Kv().bM(o));
            for (Object add : scopeArr) {
                hashSet.add(add);
            }
            this.bgk.put(com_fossil_ats_O, new awz(hashSet));
        }

        public final awy KH() {
            btv com_fossil_btv = btv.bGd;
            if (this.bgl.containsKey(btq.bfF)) {
                com_fossil_btv = (btv) this.bgl.get(btq.bfF);
            }
            return new awy(this.beU, this.bge, this.bgk, this.bgg, this.bgh, this.bgi, this.bgj, com_fossil_btv);
        }

        public final atv KI() {
            awa.m4637b(!this.bgl.isEmpty(), "must call addApi() to add at least one API");
            awy KH = KH();
            ats com_fossil_ats = null;
            Map Lw = KH.Lw();
            Map jlVar = new jl();
            Map jlVar2 = new jl();
            ArrayList arrayList = new ArrayList();
            Object obj = null;
            for (ats com_fossil_ats2 : this.bgl.keySet()) {
                ats com_fossil_ats22;
                Object obj2 = this.bgl.get(com_fossil_ats22);
                boolean z = Lw.get(com_fossil_ats22) != null;
                jlVar.put(com_fossil_ats22, Boolean.valueOf(z));
                C1898b com_fossil_bec = new bec(com_fossil_ats22, z);
                arrayList.add(com_fossil_bec);
                C1889e Kw = com_fossil_ats22.Kw();
                C1888f a = Kw.mo1176a(this.mContext, this.bfY, KH, obj2, com_fossil_bec, com_fossil_bec);
                jlVar2.put(com_fossil_ats22.Kx(), a);
                Object obj3 = Kw.getPriority() == 1 ? obj2 != null ? 1 : null : obj;
                if (!a.Kj()) {
                    com_fossil_ats22 = com_fossil_ats;
                } else if (com_fossil_ats != null) {
                    String valueOf = String.valueOf(com_fossil_ats22.getName());
                    String valueOf2 = String.valueOf(com_fossil_ats.getName());
                    throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 21) + String.valueOf(valueOf2).length()).append(valueOf).append(" cannot be used with ").append(valueOf2).toString());
                }
                obj = obj3;
                com_fossil_ats = com_fossil_ats22;
            }
            if (com_fossil_ats != null) {
                if (obj != null) {
                    valueOf = String.valueOf(com_fossil_ats.getName());
                    throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 82).append("With using ").append(valueOf).append(", GamesOptions can only be specified within GoogleSignInOptions.Builder").toString());
                }
                awa.m4635a(this.beU == null, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", com_fossil_ats.getName());
                awa.m4635a(this.bge.equals(this.bgf), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", com_fossil_ats.getName());
            }
            atv com_fossil_bfg = new bfg(this.mContext, new ReentrantLock(), this.bfY, KH, this.bgp, this.bgq, jlVar, this.bgr, this.bgs, jlVar2, this.bgn, bfg.m5041a(jlVar2.values(), true), arrayList, false);
            synchronized (atv.bgd) {
                atv.bgd.add(com_fossil_bfg);
            }
            if (this.bgn >= 0) {
                bdo.m4905a(this.bgm).m4906a(this.bgn, com_fossil_bfg, this.bgo);
            }
            return com_fossil_bfg;
        }

        public final C1897a m4464a(Account account) {
            this.beU = account;
            return this;
        }

        public final C1897a m4465a(Handler handler) {
            awa.m4640p(handler, "Handler must not be null");
            this.bfY = handler.getLooper();
            return this;
        }

        public final <O extends C1880a> C1897a m4466a(ats<O> com_fossil_ats_O, O o) {
            awa.m4640p(com_fossil_ats_O, "Api must not be null");
            awa.m4640p(o, "Null options are not permitted for this Api");
            this.bgl.put(com_fossil_ats_O, o);
            Collection bM = com_fossil_ats_O.Kv().bM(o);
            this.bgf.addAll(bM);
            this.bge.addAll(bM);
            return this;
        }

        public final C1897a m4467a(ats<? extends C1881b> com_fossil_ats__extends_com_fossil_ats_a_b, Scope... scopeArr) {
            awa.m4640p(com_fossil_ats__extends_com_fossil_ats_a_b, "Api must not be null");
            this.bgl.put(com_fossil_ats__extends_com_fossil_ats_a_b, null);
            m4463a((ats) com_fossil_ats__extends_com_fossil_ats_a_b, null, scopeArr);
            return this;
        }

        public final C1897a m4468a(ew ewVar, int i, C1899c c1899c) {
            bgg com_fossil_bgg = new bgg(ewVar);
            awa.m4637b(i >= 0, "clientId must be non-negative");
            this.bgn = i;
            this.bgo = c1899c;
            this.bgm = com_fossil_bgg;
            return this;
        }

        public final C1897a m4469a(Scope scope) {
            awa.m4640p(scope, "Scope must not be null");
            this.bge.add(scope);
            return this;
        }

        public final C1897a m4470b(C1898b c1898b) {
            awa.m4640p(c1898b, "Listener must not be null");
            this.bgr.add(c1898b);
            return this;
        }

        public final C1897a m4471c(ats<? extends C1881b> com_fossil_ats__extends_com_fossil_ats_a_b) {
            awa.m4640p(com_fossil_ats__extends_com_fossil_ats_a_b, "Api must not be null");
            this.bgl.put(com_fossil_ats__extends_com_fossil_ats_a_b, null);
            Collection bM = com_fossil_ats__extends_com_fossil_ats_a_b.Kv().bM(null);
            this.bgf.addAll(bM);
            this.bge.addAll(bM);
            return this;
        }

        public final C1897a m4472c(C1899c c1899c) {
            awa.m4640p(c1899c, "Listener must not be null");
            this.bgs.add(c1899c);
            return this;
        }
    }

    public interface C1898b {
        void hr(int i);

        void mo1284l(Bundle bundle);
    }

    public interface C1899c {
        void mo1273a(atn com_fossil_atn);
    }

    public static Set<atv> KC() {
        Set<atv> set;
        synchronized (bgd) {
            set = bgd;
        }
        return set;
    }

    public void KD() {
        throw new UnsupportedOperationException();
    }

    public abstract atn KE();

    public abstract atw<Status> KF();

    public <C extends C1888f> C mo1329a(C1892d<C> c1892d) {
        throw new UnsupportedOperationException();
    }

    public abstract void mo1306a(C1898b c1898b);

    public abstract void mo1307a(C1899c c1899c);

    public void mo1330a(bhd com_fossil_bhd) {
        throw new UnsupportedOperationException();
    }

    public boolean mo1331a(ats<?> com_fossil_ats_) {
        throw new UnsupportedOperationException();
    }

    public boolean mo1332a(bgv com_fossil_bgv) {
        throw new UnsupportedOperationException();
    }

    public abstract void mo1308b(C1899c c1899c);

    public void mo1333b(bhd com_fossil_bhd) {
        throw new UnsupportedOperationException();
    }

    public abstract boolean mo1309b(ats<?> com_fossil_ats_);

    public <A extends C1887c, R extends atz, T extends bds<R, A>> T mo1334c(T t) {
        throw new UnsupportedOperationException();
    }

    public abstract void mo1310c(ew ewVar);

    public abstract void connect();

    public <A extends C1887c, T extends bds<? extends atz, A>> T mo1335d(T t) {
        throw new UnsupportedOperationException();
    }

    public abstract void disconnect();

    public abstract void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public Context getContext() {
        throw new UnsupportedOperationException();
    }

    public Looper getLooper() {
        throw new UnsupportedOperationException();
    }

    public void hq(int i) {
        throw new UnsupportedOperationException();
    }

    public abstract boolean isConnected();

    public abstract boolean isConnecting();

    public abstract void reconnect();
}
