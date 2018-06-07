package com.fossil;

import android.util.Log;
import android.util.SparseArray;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.fossil.atv.C1899c;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class bdo extends bdu {
    private final SparseArray<C1919a> brj = new SparseArray();

    class C1919a implements C1899c {
        public final int brk;
        public final atv brl;
        public final C1899c brm;
        private /* synthetic */ bdo brn;

        public C1919a(bdo com_fossil_bdo, int i, atv com_fossil_atv, C1899c c1899c) {
            this.brn = com_fossil_bdo;
            this.brk = i;
            this.brl = com_fossil_atv;
            this.brm = c1899c;
            com_fossil_atv.mo1307a((C1899c) this);
        }

        public final void mo1273a(atn com_fossil_atn) {
            String valueOf = String.valueOf(com_fossil_atn);
            Log.d("AutoManageHelper", new StringBuilder(String.valueOf(valueOf).length() + 27).append("beginFailureResolution for ").append(valueOf).toString());
            this.brn.m4904b(com_fossil_atn, this.brk);
        }
    }

    private bdo(bgi com_fossil_bgi) {
        super(com_fossil_bgi);
        this.buq.mo1346a("AutoManageHelper", this);
    }

    public static bdo m4905a(bgg com_fossil_bgg) {
        bgi b = bgh.m4901b(com_fossil_bgg);
        bdo com_fossil_bdo = (bdo) b.mo1347b("AutoManageHelper", bdo.class);
        return com_fossil_bdo != null ? com_fossil_bdo : new bdo(b);
    }

    private final C1919a ia(int i) {
        return this.brj.size() <= i ? null : (C1919a) this.brj.get(this.brj.keyAt(i));
    }

    protected final void MZ() {
        for (int i = 0; i < this.brj.size(); i++) {
            C1919a ia = ia(i);
            if (ia != null) {
                ia.brl.connect();
            }
        }
    }

    public final void m4906a(int i, atv com_fossil_atv, C1899c c1899c) {
        awa.m4640p(com_fossil_atv, "GoogleApiClient instance cannot be null");
        awa.m4634a(this.brj.indexOfKey(i) < 0, "Already managing a GoogleApiClient with id " + i);
        bdv com_fossil_bdv = (bdv) this.brw.get();
        boolean z = this.mStarted;
        String valueOf = String.valueOf(com_fossil_bdv);
        Log.d("AutoManageHelper", new StringBuilder(String.valueOf(valueOf).length() + 49).append("starting AutoManage for client ").append(i).append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).append(z).append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).append(valueOf).toString());
        this.brj.put(i, new C1919a(this, i, com_fossil_atv, c1899c));
        if (this.mStarted && com_fossil_bdv == null) {
            String valueOf2 = String.valueOf(com_fossil_atv);
            Log.d("AutoManageHelper", new StringBuilder(String.valueOf(valueOf2).length() + 11).append("connecting ").append(valueOf2).toString());
            com_fossil_atv.connect();
        }
    }

    protected final void mo1280a(atn com_fossil_atn, int i) {
        Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
        if (i < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        C1919a c1919a = (C1919a) this.brj.get(i);
        if (c1919a != null) {
            hZ(i);
            C1899c c1899c = c1919a.brm;
            if (c1899c != null) {
                c1899c.mo1273a(com_fossil_atn);
            }
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (int i = 0; i < this.brj.size(); i++) {
            C1919a ia = ia(i);
            if (ia != null) {
                printWriter.append(str).append("GoogleApiClient #").print(ia.brk);
                printWriter.println(":");
                ia.brl.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
            }
        }
    }

    public final void hZ(int i) {
        C1899c c1899c = (C1919a) this.brj.get(i);
        this.brj.remove(i);
        if (c1899c != null) {
            c1899c.brl.mo1308b(c1899c);
            c1899c.brl.disconnect();
        }
    }

    public final void onStart() {
        super.onStart();
        boolean z = this.mStarted;
        String valueOf = String.valueOf(this.brj);
        Log.d("AutoManageHelper", new StringBuilder(String.valueOf(valueOf).length() + 14).append("onStart ").append(z).append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).append(valueOf).toString());
        if (this.brw.get() == null) {
            for (int i = 0; i < this.brj.size(); i++) {
                C1919a ia = ia(i);
                if (ia != null) {
                    ia.brl.connect();
                }
            }
        }
    }

    public final void onStop() {
        super.onStop();
        for (int i = 0; i < this.brj.size(); i++) {
            C1919a ia = ia(i);
            if (ia != null) {
                ia.brl.disconnect();
            }
        }
    }
}
