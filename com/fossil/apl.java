package com.fossil;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class apl {
    private static apl baT = null;
    private final apg<String, apx<apk<?>>> baU = new apg();
    private final apg<apx<apk<?>>, String> baV = new apg();

    private apl() {
    }

    public static synchronized apl IW() {
        apl com_fossil_apl;
        synchronized (apl.class) {
            if (baT == null) {
                baT = new apl();
            }
            com_fossil_apl = baT;
        }
        return com_fossil_apl;
    }

    public final synchronized void m4169a(String str, apk<?> com_fossil_apk_) {
        boolean z = false;
        synchronized (this) {
            if (!(TextUtils.isEmpty(str) || com_fossil_apk_ == null)) {
                apx com_fossil_apx = new apx(com_fossil_apk_);
                List p = this.baU.m4166p(str, false);
                if (p != null) {
                    z = p.contains(com_fossil_apx);
                }
                if (!z) {
                    this.baU.m4164n(str, com_fossil_apx);
                    this.baV.m4164n(com_fossil_apx, str);
                }
            }
        }
    }

    public final synchronized void m4170b(String str, apk<?> com_fossil_apk_) {
        if (!TextUtils.isEmpty(str)) {
            apx com_fossil_apx = new apx(com_fossil_apk_);
            this.baU.m4165o(str, com_fossil_apx);
            this.baV.m4165o(com_fossil_apx, str);
        }
    }

    public final synchronized void m4168a(apk<?> com_fossil_apk_) {
        if (com_fossil_apk_ != null) {
            apx com_fossil_apx = new apx(com_fossil_apk_);
            for (String o : this.baV.bH(com_fossil_apx)) {
                this.baU.m4165o(o, com_fossil_apx);
            }
            this.baV.bI(com_fossil_apx);
        }
    }

    public final void m4167a(final apj com_fossil_apj) {
        if (com_fossil_apj != null) {
            for (final apk com_fossil_apk : cl(com_fossil_apj.Ik())) {
                apc.IO().m4160b(new aqx(this) {
                    final /* synthetic */ apl baY;

                    public final void HJ() {
                        com_fossil_apk.mo759a(com_fossil_apj);
                    }
                });
            }
        }
    }

    private synchronized List<apk<?>> cl(String str) {
        List<apk<?>> emptyList;
        if (TextUtils.isEmpty(str)) {
            emptyList = Collections.emptyList();
        } else {
            List<apk<?>> arrayList = new ArrayList();
            Iterator it = this.baU.bH(str).iterator();
            while (it.hasNext()) {
                apk com_fossil_apk = (apk) ((apx) it.next()).get();
                if (com_fossil_apk == null) {
                    it.remove();
                } else {
                    arrayList.add(com_fossil_apk);
                }
            }
            emptyList = arrayList;
        }
        return emptyList;
    }
}
