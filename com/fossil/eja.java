package com.fossil;

import android.content.Context;
import android.content.SharedPreferences;
import com.ua.sdk.authentication.AuthenticationManager;
import com.ua.sdk.cache.CachePolicy;
import com.ua.sdk.cache.DiskCache;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class eja implements eiz {
    private static final int axg = Runtime.getRuntime().availableProcessors();
    private static final int axh = (axg + 1);
    private static final int cob = ((axg * 2) + 1);
    private ExecutorService aIj = null;
    private final Context context;
    private boolean dDD;
    private ekv dDK = null;
    private ejy dDL;
    private final String dDv;
    private final String dDw;
    private efw dGm = null;
    private SharedPreferences dGn = null;
    private ejb dGs;
    private eis<egb> dGt = null;
    private cfj dIK = null;
    protected egu dIL = new egu();
    private ein dIM;
    private ecs dIN = null;
    private ega dIO = null;
    private eis<ekn> dIP = null;
    private eit<ekn> dIQ = null;
    private eis<ecc<ekn>> dIR = null;
    private ekq dIS = null;
    private elh dIT = null;
    private eis<eld> dIU = null;
    private ele dIV = null;
    private egi dIW = null;
    private egi dIX = null;
    private ehd dIY = null;
    private ejw dIZ;
    protected AuthenticationManager dIg = null;
    private eka dJa;
    private ecw dJb;
    private ecv dJc;
    private ecz dJd;
    private efj dJe;
    private cfj gson;

    public eja(String str, String str2, Context context, boolean z) {
        this.context = (Context) eiy.m10771e(context, "context");
        this.dDv = (String) eiy.m10771e(str, "clientId");
        this.dDw = (String) eiy.m10771e(str2, "clientSecret");
        this.dDD = z;
    }

    public ejb aDA() {
        if (this.dGs == null) {
            this.dGs = new ejc();
        }
        return this.dGs;
    }

    public DiskCache<ekn> aDB() {
        if (this.dIS == null) {
            this.dIS = ekq.el(this.context);
        }
        return this.dIS;
    }

    protected cfj aDC() {
        if (this.gson == null) {
            this.gson = ejh.aDX();
        }
        return this.gson;
    }

    protected eis<ekn> aDD() {
        if (this.dIP == null) {
            this.dIP = m10773a(new eks(aDC()));
        }
        return this.dIP;
    }

    protected eit<ekn> aDE() {
        if (this.dIQ == null) {
            this.dIQ = m10774a(new ekt(aDC()));
        }
        return this.dIQ;
    }

    protected eis<ecc<ekn>> aDF() {
        if (this.dIR == null) {
            this.dIR = m10773a(new ekx(aDC()));
        }
        return this.dIR;
    }

    private eis<eld> aDG() {
        if (this.dIU == null) {
            this.dIU = m10773a(new elg(aDC()));
        }
        return this.dIU;
    }

    protected <T> eis<T> m10773a(eis<T> com_fossil_eis_T) {
        if (this.dDD) {
            return new eio(com_fossil_eis_T);
        }
        return com_fossil_eis_T;
    }

    protected <T> eit<T> m10774a(eit<T> com_fossil_eit_T) {
        if (this.dDD) {
            return new eip(com_fossil_eit_T);
        }
        return com_fossil_eit_T;
    }

    public ekv aDx() {
        if (this.dDK == null) {
            this.dDK = new ekw(aDH(), this.dIL, aDB(), new ekz(aDK(), aDz(), aDA(), aDD(), aDE(), aDF()), aDy(), aDz(), aDL(), getSharedPreferences());
        }
        return this.dDK;
    }

    public egi aDH() {
        if (this.dIW == null) {
            this.dIW = new egi(CachePolicy.CACHE_ELSE_NETWORK, TimeUnit.DAYS.toMillis(1));
        }
        return this.dIW;
    }

    public efw aDI() {
        if (this.dGm == null) {
            this.dGm = new efx(this.dDv, this.dDw, aDK(), aDA(), aDP(), this.context);
        }
        return this.dGm;
    }

    public ExecutorService aDy() {
        if (this.aIj == null) {
            this.aIj = new ScheduledThreadPoolExecutor(axh);
        }
        return this.aIj;
    }

    public SharedPreferences getSharedPreferences() {
        if (this.dGn == null) {
            this.dGn = this.context.getSharedPreferences("mmdk_shared_prefs", 0);
        }
        return this.dGn;
    }

    public AuthenticationManager aDz() {
        if (this.dIg == null) {
            Object aDJ = aDJ();
            this.dIg = aDJ;
            aDJ.m10619a(aDI(), aDy(), getSharedPreferences());
        }
        return this.dIg;
    }

    protected efv aDJ() {
        return new efv();
    }

    protected ein aDK() {
        if (this.dIM == null) {
            this.dIM = new ein(this.context, this.dDv);
        }
        return this.dIM;
    }

    public elh aDL() {
        eix com_fossil_eix = new eix(this.context, aDK(), aDA(), m10773a(new elg(this.gson)), aDz());
        if (this.dIT == null) {
            eix com_fossil_eix2 = com_fossil_eix;
            this.dIT = new eli(com_fossil_eix2, new egi(CachePolicy.NETWORK_ONLY, 0), this.dIL, null, new elk(aDK(), aDz(), aDA(), aDG()), aDy(), getSharedPreferences());
        }
        return this.dIT;
    }

    private ejw aDM() {
        if (this.dIZ == null) {
            this.dIZ = new ejw(aDC());
        }
        return this.dIZ;
    }

    public DiskCache<eju> aDN() {
        return new egj();
    }

    public ejy aCz() {
        if (this.dJa == null) {
            this.dJa = new eka(aDC());
        }
        if (this.dDL == null) {
            this.dDL = new ejz(aDO(), aDH(), this.dIL, aDN(), new ekd(aDK(), aDA(), aDz(), aDM(), this.dJa), aDy());
        }
        return this.dDL;
    }

    private ecw aDO() {
        if (this.dJc == null) {
            this.dJc = new ecv(aDC());
        }
        if (this.dJd == null) {
            this.dJd = new ecz();
        }
        if (this.dJb == null) {
            this.dJb = new ecx(aDx(), aDH(), null, null, new eda(aDK(), aDz(), aDA(), this.dJc, this.dJd), aDy());
            this.dJb.mo2805a(aCz());
        }
        return this.dJb;
    }

    protected eis<egb> aDP() {
        if (this.dGt == null) {
            this.dGt = m10773a(new egd(aDC()));
        }
        return this.dGt;
    }

    public efj aCA() {
        if (this.dJe == null) {
            efl com_fossil_efl = new efl(aDK(), aDz(), aDA(), m10774a(new efi()), m10773a(new efh()));
            this.dJe = new efk(new egi(CachePolicy.NETWORK_ONLY, -1), null, null, com_fossil_efl, aDy());
        }
        return this.dJe;
    }
}
