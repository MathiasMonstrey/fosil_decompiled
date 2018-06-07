package com.fossil;

import android.content.SharedPreferences;
import com.ua.sdk.UaException;
import com.ua.sdk.authentication.AuthenticationManager;
import com.ua.sdk.cache.CachePolicy;
import com.ua.sdk.cache.DiskCache;
import java.util.concurrent.ExecutorService;

public class ekw extends eij<ekn> implements ekv {
    protected final SharedPreferences bdC;
    protected ece<ekn> dLq;
    protected AuthenticationManager dLr;
    protected ekz dLs;
    protected elh dLt;
    protected ekn dLu;

    protected /* synthetic */ ecm mo2939h(ecm com_fossil_ecm) throws UaException {
        return m10840e((ekn) com_fossil_ecm);
    }

    public ekw(egi com_fossil_egi, egh com_fossil_egh, DiskCache<ekn> diskCache, eiq<ekn> com_fossil_eiq_com_fossil_ekn, ExecutorService executorService, AuthenticationManager authenticationManager, elh com_fossil_elh, SharedPreferences sharedPreferences) {
        super(com_fossil_egi, com_fossil_egh, diskCache, com_fossil_eiq_com_fossil_ekn, executorService);
        this.bdC = (SharedPreferences) eiy.dd(sharedPreferences);
        this.dLr = (AuthenticationManager) eiy.dd(authenticationManager);
        this.dLt = (elh) eiy.dd(com_fossil_elh);
        this.dLs = (ekz) com_fossil_eiq_com_fossil_ekn;
        if (aED() != null) {
            try {
                this.dLu = (ekn) m10501a(aED(), CachePolicy.CACHE_ONLY_IGNORE_MAX_AGE);
            } catch (Throwable e) {
                ecq.m10489d("Failed to get current user from cache.", e);
            }
        }
    }

    public ece<ekn> aED() {
        if (this.dLq != null) {
            return this.dLq;
        }
        String string = this.bdC.getString("mmdk_user_id", null);
        String string2 = this.bdC.getString("mmdk_user_href", null);
        if (string != null) {
            this.dLq = new eiv(string, string2);
        }
        return this.dLq;
    }

    private void m10835d(ekn com_fossil_ekn) {
        if (com_fossil_ekn != null) {
            this.dLu = com_fossil_ekn;
            this.dLq = com_fossil_ekn.aCt();
            String id = this.dLq.getId();
            String href = this.dLq.getHref();
            if (id == null || href == null) {
                aCB();
                return;
            } else {
                this.bdC.edit().putString("mmdk_user_id", id).putString("mmdk_user_href", href).commit();
                return;
            }
        }
        aCB();
    }

    public ekn mo2938d(ece<ekn> com_fossil_ece_com_fossil_ekn) throws UaException {
        return (ekn) m10503e(com_fossil_ece_com_fossil_ekn);
    }

    private boolean m10836l(ecj com_fossil_ecj) {
        if (com_fossil_ecj == null || com_fossil_ecj.getId() == null) {
            return false;
        }
        if ((com_fossil_ecj instanceof ekm) || com_fossil_ecj.getId().equalsIgnoreCase("self")) {
            return true;
        }
        ecj aED = aED();
        if (aED == null || !com_fossil_ecj.getId().equals(aED.getId())) {
            return false;
        }
        return true;
    }

    protected ekn m10838a(ecj com_fossil_ecj, ekn com_fossil_ekn) throws UaException {
        if (m10836l(com_fossil_ecj)) {
            m10835d(com_fossil_ekn);
        }
        m10834a((ekr) com_fossil_ekn);
        return com_fossil_ekn;
    }

    private void m10834a(ekr com_fossil_ekr) throws UaException {
        if (com_fossil_ekr.lz("image") != null) {
            com_fossil_ekr.m10820a(((elf) this.dLt.mo2945f(elj.aEN().mf(com_fossil_ekr.getId()).aEO())).aEM());
        }
    }

    protected ekn m10840e(ekn com_fossil_ekn) throws UaException {
        com_fossil_ekn = (ekr) com_fossil_ekn;
        this.dLr.a(com_fossil_ekn.aEA());
        m10835d(com_fossil_ekn);
        m10834a(com_fossil_ekn);
        return com_fossil_ekn;
    }

    public void aCB() {
        this.dLu = null;
        this.dLq = null;
        this.bdC.edit().remove("mmdk_user_id").remove("mmdk_user_href").commit();
    }
}
