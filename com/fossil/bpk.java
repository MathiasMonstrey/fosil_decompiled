package com.fossil;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v8.renderscript.Allocation;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.misfit.ble.shine.ShineProfile;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.portfolio.platform.data.model.microapp.MicroApp;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import org.joda.time.DateTimeConstants;

public class bpk {
    private static volatile bpk bBc;
    private boolean bBA;
    private Boolean bBB;
    private long bBC;
    private FileLock bBD;
    private FileChannel bBE;
    private List<Long> bBF;
    private List<Runnable> bBG;
    private int bBH;
    private int bBI;
    private long bBJ = -1;
    private long bBK;
    private boolean bBL;
    private boolean bBM;
    private boolean bBN;
    private final long bBO = this.bBq.currentTimeMillis();
    private final bnm bBd = new bnm(this);
    private final bow bBe;
    private final bol bBf;
    private final bpg bBg;
    private final brz bBh;
    private final bpf bBi;
    private final AppMeasurement bBj;
    private final FirebaseAnalytics bBk;
    private final bsk bBl;
    private final boj bBm;
    private final bnn bBn;
    private final boh bBo;
    private final bop bBp;
    private final axm bBq = axn.LE();
    private final bqy bBr;
    private final brc bBs;
    private final bnt bBt;
    private final bqk bBu;
    private final bog bBv;
    private final bou bBw;
    private final bsf bBx;
    private final bnj bBy;
    private final bnc bBz;
    private final boolean bru;
    private final Context mContext;

    class C1939a implements bnp {
        bsy bBP;
        List<Long> bBQ;
        List<bsv> bBR;
        private long bBS;
        private /* synthetic */ bpk bBT;

        private C1939a(bpk com_fossil_bpk) {
            this.bBT = com_fossil_bpk;
        }

        private static long m5472a(bsv com_fossil_bsv) {
            return ((com_fossil_bsv.bEt.longValue() / 1000) / 60) / 60;
        }

        public final boolean mo1444a(long j, bsv com_fossil_bsv) {
            awa.bO(com_fossil_bsv);
            if (this.bBR == null) {
                this.bBR = new ArrayList();
            }
            if (this.bBQ == null) {
                this.bBQ = new ArrayList();
            }
            if (this.bBR.size() > 0 && C1939a.m5472a((bsv) this.bBR.get(0)) != C1939a.m5472a(com_fossil_bsv)) {
                return false;
            }
            long MW = this.bBS + ((long) com_fossil_bsv.MW());
            if (MW >= ((long) bnm.Qp())) {
                return false;
            }
            this.bBS = MW;
            this.bBR.add(com_fossil_bsv);
            this.bBQ.add(Long.valueOf(j));
            return this.bBR.size() < bnm.Qq();
        }

        public final void mo1445b(bsy com_fossil_bsy) {
            awa.bO(com_fossil_bsy);
            this.bBP = com_fossil_bsy;
        }
    }

    private bpk(bqj com_fossil_bqj) {
        bon Rg;
        awa.bO(com_fossil_bqj);
        this.mContext = com_fossil_bqj.mContext;
        bow com_fossil_bow = new bow(this);
        com_fossil_bow.initialize();
        this.bBe = com_fossil_bow;
        bol com_fossil_bol = new bol(this);
        com_fossil_bol.initialize();
        this.bBf = com_fossil_bol;
        Pf().Rg().m5439d("App measurement is starting up, version", Long.valueOf(bnm.Pr()));
        bnm.Qh();
        Pf().Rg().log("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        bsk com_fossil_bsk = new bsk(this);
        com_fossil_bsk.initialize();
        this.bBl = com_fossil_bsk;
        boj com_fossil_boj = new boj(this);
        com_fossil_boj.initialize();
        this.bBm = com_fossil_boj;
        bnt com_fossil_bnt = new bnt(this);
        com_fossil_bnt.initialize();
        this.bBt = com_fossil_bnt;
        bog com_fossil_bog = new bog(this);
        com_fossil_bog.initialize();
        this.bBv = com_fossil_bog;
        bnm.Qh();
        String Pj = com_fossil_bog.Pj();
        if (Pb().eJ(Pj)) {
            Rg = Pf().Rg();
            Pj = "Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.";
        } else {
            Rg = Pf().Rg();
            String str = "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ";
            Pj = String.valueOf(Pj);
            Pj = Pj.length() != 0 ? str.concat(Pj) : new String(str);
        }
        Rg.log(Pj);
        Pf().Rh().log("Debug-level message logging enabled");
        bnn com_fossil_bnn = new bnn(this);
        com_fossil_bnn.initialize();
        this.bBn = com_fossil_bnn;
        boh com_fossil_boh = new boh(this);
        com_fossil_boh.initialize();
        this.bBo = com_fossil_boh;
        bnj com_fossil_bnj = new bnj(this);
        com_fossil_bnj.initialize();
        this.bBy = com_fossil_bnj;
        this.bBz = new bnc(this);
        bop com_fossil_bop = new bop(this);
        com_fossil_bop.initialize();
        this.bBp = com_fossil_bop;
        bqy com_fossil_bqy = new bqy(this);
        com_fossil_bqy.initialize();
        this.bBr = com_fossil_bqy;
        brc com_fossil_brc = new brc(this);
        com_fossil_brc.initialize();
        this.bBs = com_fossil_brc;
        bqk com_fossil_bqk = new bqk(this);
        com_fossil_bqk.initialize();
        this.bBu = com_fossil_bqk;
        bsf com_fossil_bsf = new bsf(this);
        com_fossil_bsf.initialize();
        this.bBx = com_fossil_bsf;
        this.bBw = new bou(this);
        this.bBj = new AppMeasurement(this);
        this.bBk = new FirebaseAnalytics(this);
        brz com_fossil_brz = new brz(this);
        com_fossil_brz.initialize();
        this.bBh = com_fossil_brz;
        bpf com_fossil_bpf = new bpf(this);
        com_fossil_bpf.initialize();
        this.bBi = com_fossil_bpf;
        bpg com_fossil_bpg = new bpg(this);
        com_fossil_bpg.initialize();
        this.bBg = com_fossil_bpg;
        if (this.bBH != this.bBI) {
            Pf().Rc().m5437a("Not all components initialized", Integer.valueOf(this.bBH), Integer.valueOf(this.bBI));
        }
        this.bru = true;
        bnm.Qh();
        if (this.mContext.getApplicationContext() instanceof Application) {
            bqk OS = OS();
            if (OS.getContext().getApplicationContext() instanceof Application) {
                Application application = (Application) OS.getContext().getApplicationContext();
                if (OS.bCh == null) {
                    OS.bCh = new bqx(OS);
                }
                application.unregisterActivityLifecycleCallbacks(OS.bCh);
                application.registerActivityLifecycleCallbacks(OS.bCh);
                OS.Pf().Ri().log("Registered activity lifecycle callback");
            }
        } else {
            Pf().Re().log("Application context is not an Application");
        }
        this.bBg.m5469h(new bpl(this));
    }

    static void OM() {
        bnm.Qh();
        throw new IllegalStateException("Unexpected call on client side");
    }

    private final bou RH() {
        if (this.bBw != null) {
            return this.bBw;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    private final bsf RI() {
        m5478a(this.bBx);
        return this.bBx;
    }

    private final boolean RJ() {
        Pe().OP();
        try {
            this.bBE = new RandomAccessFile(new File(this.mContext.getFilesDir(), bnm.Qf()), "rw").getChannel();
            this.bBD = this.bBE.tryLock();
            if (this.bBD != null) {
                Pf().Ri().log("Storage concurrent access okay");
                return true;
            }
            Pf().Rc().log("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e) {
            Pf().Rc().m5439d("Failed to acquire storage lock", e);
        } catch (IOException e2) {
            Pf().Rc().m5439d("Failed to access storage lock file", e2);
        }
    }

    private final long RL() {
        long currentTimeMillis = this.bBq.currentTimeMillis();
        bow Pg = Pg();
        Pg.RA();
        Pg.OP();
        long j = Pg.bAb.get();
        if (j == 0) {
            j = (long) (Pg.Pb().Sj().nextInt(DateTimeConstants.MILLIS_PER_DAY) + 1);
            Pg.bAb.set(j);
        }
        return ((((j + currentTimeMillis) / 1000) / 60) / 60) / 24;
    }

    private final boolean RN() {
        Pe().OP();
        RA();
        return OZ().QL() || !TextUtils.isEmpty(OZ().QG());
    }

    private final void RO() {
        Pe().OP();
        RA();
        if (RR()) {
            long abs;
            if (this.bBK > 0) {
                abs = 3600000 - Math.abs(this.bBq.elapsedRealtime() - this.bBK);
                if (abs > 0) {
                    Pf().Ri().m5439d("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(abs));
                    RH().unregister();
                    RI().cancel();
                    return;
                }
                this.bBK = 0;
            }
            if (RB() && RN()) {
                long currentTimeMillis = this.bBq.currentTimeMillis();
                long QB = bnm.QB();
                Object obj = (OZ().QM() || OZ().QH()) ? 1 : null;
                if (obj != null) {
                    CharSequence QE = this.bBd.QE();
                    abs = (TextUtils.isEmpty(QE) || ".none.".equals(QE)) ? bnm.Qw() : bnm.Qx();
                } else {
                    abs = bnm.Qv();
                }
                long j = Pg().bzX.get();
                long j2 = Pg().bzY.get();
                long max = Math.max(OZ().QJ(), OZ().QK());
                if (max == 0) {
                    abs = 0;
                } else {
                    max = currentTimeMillis - Math.abs(max - currentTimeMillis);
                    j2 = currentTimeMillis - Math.abs(j2 - currentTimeMillis);
                    j = Math.max(currentTimeMillis - Math.abs(j - currentTimeMillis), j2);
                    currentTimeMillis = max + QB;
                    if (obj != null && j > 0) {
                        currentTimeMillis = Math.min(max, j) + abs;
                    }
                    if (!Pb().m5605d(j, abs)) {
                        currentTimeMillis = j + abs;
                    }
                    if (j2 == 0 || j2 < max) {
                        abs = currentTimeMillis;
                    } else {
                        for (int i = 0; i < bnm.QD(); i++) {
                            currentTimeMillis += ((long) (1 << i)) * bnm.QC();
                            if (currentTimeMillis > j2) {
                                abs = currentTimeMillis;
                                break;
                            }
                        }
                        abs = 0;
                    }
                }
                if (abs == 0) {
                    Pf().Ri().log("Next upload time is 0");
                    RH().unregister();
                    RI().cancel();
                    return;
                } else if (RG().Rk()) {
                    currentTimeMillis = Pg().bzZ.get();
                    long Qu = bnm.Qu();
                    if (!Pb().m5605d(currentTimeMillis, Qu)) {
                        abs = Math.max(abs, currentTimeMillis + Qu);
                    }
                    RH().unregister();
                    abs -= this.bBq.currentTimeMillis();
                    if (abs <= 0) {
                        abs = bnm.Qy();
                        Pg().bzX.set(this.bBq.currentTimeMillis());
                    }
                    Pf().Ri().m5439d("Upload scheduled in approximately ms", Long.valueOf(abs));
                    RI().ak(abs);
                    return;
                } else {
                    Pf().Ri().log("No network");
                    RH().Rl();
                    RI().cancel();
                    return;
                }
            }
            Pf().Ri().log("Nothing to upload or uploading impossible");
            RH().unregister();
            RI().cancel();
        }
    }

    private final boolean RR() {
        Pe().OP();
        RA();
        return this.bBA;
    }

    private final void RS() {
        Pe().OP();
        if (this.bBL || this.bBM || this.bBN) {
            Pf().Ri().m5438a("Not stopping services. fetch, network, upload", Boolean.valueOf(this.bBL), Boolean.valueOf(this.bBM), Boolean.valueOf(this.bBN));
            return;
        }
        Pf().Ri().log("Stopping uploading service(s)");
        if (this.bBG != null) {
            for (Runnable run : this.bBG) {
                run.run();
            }
            this.bBG.clear();
        }
    }

    private final int m5475a(FileChannel fileChannel) {
        int i = 0;
        Pe().OP();
        if (fileChannel == null || !fileChannel.isOpen()) {
            Pf().Rc().log("Bad chanel to read from");
        } else {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            try {
                fileChannel.position(0);
                int read = fileChannel.read(allocate);
                if (read == 4) {
                    allocate.flip();
                    i = allocate.getInt();
                } else if (read != -1) {
                    Pf().Re().m5439d("Unexpected data length. Bytes read", Integer.valueOf(read));
                }
            } catch (IOException e) {
                Pf().Rc().m5439d("Failed to read from channel", e);
            }
        }
        return i;
    }

    private final void m5476a(bnu com_fossil_bnu, bnh com_fossil_bnh) {
        Pe().OP();
        RA();
        awa.bO(com_fossil_bnu);
        awa.bO(com_fossil_bnh);
        awa.df(com_fossil_bnu.mAppId);
        awa.aY(com_fossil_bnu.mAppId.equals(com_fossil_bnh.packageName));
        bsy com_fossil_bsy = new bsy();
        com_fossil_bsy.bEz = Integer.valueOf(1);
        com_fossil_bsy.bEH = "android";
        com_fossil_bsy.bEM = com_fossil_bnh.packageName;
        com_fossil_bsy.bxr = com_fossil_bnh.bxr;
        com_fossil_bsy.bpS = com_fossil_bnh.bpS;
        com_fossil_bsy.bEW = com_fossil_bnh.bxx == -2147483648L ? null : Integer.valueOf((int) com_fossil_bnh.bxx);
        com_fossil_bsy.bEN = Long.valueOf(com_fossil_bnh.bxs);
        com_fossil_bsy.bxq = com_fossil_bnh.bxq;
        com_fossil_bsy.bES = com_fossil_bnh.bxt == 0 ? null : Long.valueOf(com_fossil_bnh.bxt);
        Pair ek = Pg().ek(com_fossil_bnh.packageName);
        if (!(ek == null || TextUtils.isEmpty((CharSequence) ek.first))) {
            com_fossil_bsy.bEP = (String) ek.first;
            com_fossil_bsy.bEQ = (Boolean) ek.second;
        }
        OU().RA();
        com_fossil_bsy.bEJ = Build.MODEL;
        OU().RA();
        com_fossil_bsy.bEI = VERSION.RELEASE;
        com_fossil_bsy.bEL = Integer.valueOf((int) OU().QV());
        com_fossil_bsy.bEK = OU().QW();
        com_fossil_bsy.bEO = null;
        com_fossil_bsy.bEC = null;
        com_fossil_bsy.bED = null;
        com_fossil_bsy.bEE = null;
        com_fossil_bsy.bFa = Long.valueOf(com_fossil_bnh.bxz);
        if (isEnabled() && bnm.QF()) {
            OT();
            com_fossil_bsy.bFb = null;
        }
        bng dZ = OZ().dZ(com_fossil_bnh.packageName);
        if (dZ == null) {
            dZ = new bng(this, com_fossil_bnh.packageName);
            dZ.dP(OT().QZ());
            dZ.dS(com_fossil_bnh.bxy);
            dZ.dQ(com_fossil_bnh.bxq);
            dZ.dR(Pg().el(com_fossil_bnh.packageName));
            dZ.m5323Z(0);
            dZ.m5318U(0);
            dZ.m5319V(0);
            dZ.setAppVersion(com_fossil_bnh.bpS);
            dZ.m5320W(com_fossil_bnh.bxx);
            dZ.dT(com_fossil_bnh.bxr);
            dZ.m5321X(com_fossil_bnh.bxs);
            dZ.m5322Y(com_fossil_bnh.bxt);
            dZ.setMeasurementEnabled(com_fossil_bnh.bxv);
            dZ.ai(com_fossil_bnh.bxz);
            OZ().m5359a(dZ);
        }
        com_fossil_bsy.bER = dZ.getAppInstanceId();
        com_fossil_bsy.bxy = dZ.Pl();
        List dY = OZ().dY(com_fossil_bnh.packageName);
        com_fossil_bsy.bEB = new bta[dY.size()];
        for (int i = 0; i < dY.size(); i++) {
            bta com_fossil_bta = new bta();
            com_fossil_bsy.bEB[i] = com_fossil_bta;
            com_fossil_bta.name = ((bsj) dY.get(i)).mName;
            com_fossil_bta.bFf = Long.valueOf(((bsj) dY.get(i)).bDy);
            Pb().m5601a(com_fossil_bta, ((bsj) dY.get(i)).mValue);
        }
        try {
            boolean z;
            long a = OZ().m5357a(com_fossil_bsy);
            bnn OZ = OZ();
            if (com_fossil_bnu.byj != null) {
                Iterator it = com_fossil_bnu.byj.iterator();
                while (it.hasNext()) {
                    if ("_r".equals((String) it.next())) {
                        z = true;
                        break;
                    }
                }
                z = Pc().ab(com_fossil_bnu.mAppId, com_fossil_bnu.mName);
                bno a2 = OZ().m5358a(RL(), com_fossil_bnu.mAppId, false, false, false, false, false);
                if (z && a2.bxZ < ((long) this.bBd.dV(com_fossil_bnu.mAppId))) {
                    z = true;
                    if (OZ.m5363a(com_fossil_bnu, a, z)) {
                        this.bBK = 0;
                    }
                }
            }
            z = false;
            if (OZ.m5363a(com_fossil_bnu, a, z)) {
                this.bBK = 0;
            }
        } catch (IOException e) {
            Pf().Rc().m5437a("Data loss. Failed to insert raw event metadata. appId", bol.ei(com_fossil_bsy.bEM), e);
        }
    }

    private static void m5477a(bqh com_fossil_bqh) {
        if (com_fossil_bqh == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private static void m5478a(bqi com_fossil_bqi) {
        if (com_fossil_bqi == null) {
            throw new IllegalStateException("Component not created");
        } else if (!com_fossil_bqi.isInitialized()) {
            throw new IllegalStateException("Component not initialized");
        }
    }

    private final boolean m5479a(int i, FileChannel fileChannel) {
        Pe().OP();
        if (fileChannel == null || !fileChannel.isOpen()) {
            Pf().Rc().log("Bad chanel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.flip();
        try {
            fileChannel.truncate(0);
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() == 4) {
                return true;
            }
            Pf().Rc().m5439d("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            return true;
        } catch (IOException e) {
            Pf().Rc().m5439d("Failed to write to channel", e);
            return false;
        }
    }

    private final bsu[] m5480a(String str, bta[] com_fossil_btaArr, bsv[] com_fossil_bsvArr) {
        awa.df(str);
        return OR().m5332a(str, com_fossil_bsvArr, com_fossil_btaArr);
    }

    public static bpk aR(Context context) {
        awa.bO(context);
        awa.bO(context.getApplicationContext());
        if (bBc == null) {
            synchronized (bpk.class) {
                if (bBc == null) {
                    bBc = new bpk(new bqj(context));
                }
            }
        }
        return bBc;
    }

    private final void m5481b(bng com_fossil_bng) {
        Map map = null;
        Pe().OP();
        if (TextUtils.isEmpty(com_fossil_bng.getGmpAppId())) {
            m5492b(com_fossil_bng.Pj(), 204, null, null, null);
            return;
        }
        String gmpAppId = com_fossil_bng.getGmpAppId();
        String appInstanceId = com_fossil_bng.getAppInstanceId();
        Builder builder = new Builder();
        Builder encodedAuthority = builder.scheme((String) bob.byD.get()).encodedAuthority((String) bob.byE.get());
        String str = "config/app/";
        String valueOf = String.valueOf(gmpAppId);
        encodedAuthority.path(valueOf.length() != 0 ? str.concat(valueOf) : new String(str)).appendQueryParameter("app_instance_id", appInstanceId).appendQueryParameter(MicroApp.COLUMN_PLATFORM, "android").appendQueryParameter("gmp_version", "11020");
        valueOf = builder.build().toString();
        try {
            URL url = new URL(valueOf);
            Pf().Ri().m5439d("Fetching remote configuration", com_fossil_bng.Pj());
            bss eq = Pc().eq(com_fossil_bng.Pj());
            CharSequence er = Pc().er(com_fossil_bng.Pj());
            if (!(eq == null || TextUtils.isEmpty(er))) {
                map = new jl();
                map.put("If-Modified-Since", er);
            }
            this.bBL = true;
            RG().m5443a(com_fossil_bng.Pj(), url, map, new bpo(this));
        } catch (MalformedURLException e) {
            Pf().Rc().m5437a("Failed to parse config URL. Not fetching. appId", bol.ei(com_fossil_bng.Pj()), valueOf);
        }
    }

    private final void m5482c(bnz com_fossil_bnz, bnh com_fossil_bnh) {
        awa.bO(com_fossil_bnh);
        awa.df(com_fossil_bnh.packageName);
        long nanoTime = System.nanoTime();
        Pe().OP();
        RA();
        String str = com_fossil_bnh.packageName;
        Pb();
        if (!bsk.m5591d(com_fossil_bnz, com_fossil_bnh)) {
            return;
        }
        if (!com_fossil_bnh.bxv) {
            m5483f(com_fossil_bnh);
        } else if (Pc().aa(str, com_fossil_bnz.name)) {
            Pf().Re().m5437a("Dropping blacklisted event. appId", bol.ei(str), Pa().ef(com_fossil_bnz.name));
            Object obj = (Pb().eL(str) || Pb().eM(str)) ? 1 : null;
            if (obj == null && !"_err".equals(com_fossil_bnz.name)) {
                Pb().m5602a(str, 11, "_ev", com_fossil_bnz.name, 0);
            }
            if (obj != null) {
                bng dZ = OZ().dZ(str);
                if (dZ != null) {
                    if (Math.abs(this.bBq.currentTimeMillis() - Math.max(dZ.Pw(), dZ.Pv())) > bnm.Qm()) {
                        Pf().Rh().log("Fetching config for blacklisted app");
                        m5481b(dZ);
                    }
                }
            }
        } else {
            Bundle QY;
            if (Pf().ig(2)) {
                Pf().Ri().m5439d("Logging event", Pa().m5430b(com_fossil_bnz));
            }
            OZ().beginTransaction();
            bnn OZ;
            try {
                QY = com_fossil_bnz.byq.QY();
                m5483f(com_fossil_bnh);
                if ("_iap".equals(com_fossil_bnz.name) || "ecommerce_purchase".equals(com_fossil_bnz.name)) {
                    long round;
                    Object string = QY.getString("currency");
                    if ("ecommerce_purchase".equals(com_fossil_bnz.name)) {
                        double d = QY.getDouble("value") * 1000000.0d;
                        if (d == 0.0d) {
                            d = ((double) QY.getLong("value")) * 1000000.0d;
                        }
                        if (d > 9.223372036854776E18d || d < -9.223372036854776E18d) {
                            Pf().Re().m5437a("Data lost. Currency value is too big. appId", bol.ei(str), Double.valueOf(d));
                            OZ().setTransactionSuccessful();
                            OZ().endTransaction();
                            return;
                        }
                        round = Math.round(d);
                    } else {
                        round = QY.getLong("value");
                    }
                    if (!TextUtils.isEmpty(string)) {
                        String toUpperCase = string.toUpperCase(Locale.US);
                        if (toUpperCase.matches("[A-Z]{3}")) {
                            String valueOf = String.valueOf("_ltv_");
                            toUpperCase = String.valueOf(toUpperCase);
                            String concat = toUpperCase.length() != 0 ? valueOf.concat(toUpperCase) : new String(valueOf);
                            bsj T = OZ().m5351T(str, concat);
                            if (T == null || !(T.mValue instanceof Long)) {
                                OZ = OZ();
                                int b = this.bBd.m5334b(str, bob.bzd) - 1;
                                awa.df(str);
                                OZ.OP();
                                OZ.RA();
                                OZ.getWritableDatabase().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", new String[]{str, str, String.valueOf(b)});
                                T = new bsj(str, com_fossil_bnz.bxC, concat, this.bBq.currentTimeMillis(), Long.valueOf(round));
                            } else {
                                T = new bsj(str, com_fossil_bnz.bxC, concat, this.bBq.currentTimeMillis(), Long.valueOf(round + ((Long) T.mValue).longValue()));
                            }
                            if (!OZ().m5364a(T)) {
                                Pf().Rc().m5438a("Too many unique user properties are set. Ignoring user property. appId", bol.ei(str), Pa().eh(T.mName), T.mValue);
                                Pb().m5602a(str, 9, null, null, 0);
                            }
                        }
                    }
                }
            } catch (SQLiteException e) {
                OZ.Pf().Rc().m5437a("Error pruning currencies. appId", bol.ei(str), e);
            } catch (Throwable th) {
                OZ().endTransaction();
            }
            boolean ex = bsk.ex(com_fossil_bnz.name);
            boolean equals = "_err".equals(com_fossil_bnz.name);
            bno a = OZ().m5358a(RL(), str, true, ex, false, equals, false);
            long PT = a.bxW - bnm.PT();
            if (PT > 0) {
                if (PT % 1000 == 1) {
                    Pf().Rc().m5437a("Data loss. Too many events logged. appId, count", bol.ei(str), Long.valueOf(a.bxW));
                }
                OZ().setTransactionSuccessful();
                OZ().endTransaction();
                return;
            }
            bnv com_fossil_bnv;
            if (ex) {
                PT = a.bxV - bnm.PU();
                if (PT > 0) {
                    if (PT % 1000 == 1) {
                        Pf().Rc().m5437a("Data loss. Too many public events logged. appId, count", bol.ei(str), Long.valueOf(a.bxV));
                    }
                    Pb().m5602a(str, 16, "_ev", com_fossil_bnz.name, 0);
                    OZ().setTransactionSuccessful();
                    OZ().endTransaction();
                    return;
                }
            }
            if (equals) {
                PT = a.bxY - ((long) Math.max(0, Math.min(1000000, this.bBd.m5334b(com_fossil_bnh.packageName, bob.byK))));
                if (PT > 0) {
                    if (PT == 1) {
                        Pf().Rc().m5437a("Too many error events logged. appId, count", bol.ei(str), Long.valueOf(a.bxY));
                    }
                    OZ().setTransactionSuccessful();
                    OZ().endTransaction();
                    return;
                }
            }
            Pb().m5599a(QY, "_o", com_fossil_bnz.bxC);
            if (Pb().eJ(str)) {
                Pb().m5599a(QY, "_dbg", Long.valueOf(1));
                Pb().m5599a(QY, "_r", Long.valueOf(1));
            }
            PT = OZ().ea(str);
            if (PT > 0) {
                Pf().Re().m5437a("Data lost. Too many events stored on disk, deleted. appId", bol.ei(str), Long.valueOf(PT));
            }
            bnu com_fossil_bnu = new bnu(this, com_fossil_bnz.bxC, str, com_fossil_bnz.name, com_fossil_bnz.byr, 0, QY);
            bnv R = OZ().m5349R(str, com_fossil_bnu.mName);
            if (R == null) {
                long ed = OZ().ed(str);
                bnm.PS();
                if (ed >= 500) {
                    Pf().Rc().m5438a("Too many event names used, ignoring event. appId, name, supported count", bol.ei(str), Pa().ef(com_fossil_bnu.mName), Integer.valueOf(bnm.PS()));
                    Pb().m5602a(str, 8, null, null, 0);
                    OZ().endTransaction();
                    return;
                }
                com_fossil_bnv = new bnv(str, com_fossil_bnu.mName, 0, 0, com_fossil_bnu.byh);
            } else {
                com_fossil_bnu = com_fossil_bnu.m5376a(this, R.bym);
                com_fossil_bnv = R.al(com_fossil_bnu.byh);
            }
            OZ().m5360a(com_fossil_bnv);
            m5476a(com_fossil_bnu, com_fossil_bnh);
            OZ().setTransactionSuccessful();
            if (Pf().ig(2)) {
                Pf().Ri().m5439d("Event recorded", Pa().m5426a(com_fossil_bnu));
            }
            OZ().endTransaction();
            RO();
            Pf().Ri().m5439d("Background event processing time, ms", Long.valueOf(((System.nanoTime() - nanoTime) + 500000) / 1000000));
        }
    }

    private final bnh eu(String str) {
        bng dZ = OZ().dZ(str);
        if (dZ == null || TextUtils.isEmpty(dZ.Po())) {
            Pf().Rh().m5439d("No app data available; dropping", str);
            return null;
        }
        try {
            String str2 = bje.aQ(this.mContext).getPackageInfo(str, 0).versionName;
            if (!(dZ.Po() == null || dZ.Po().equals(str2))) {
                Pf().Re().m5439d("App version does not match; dropping. appId", bol.ei(str));
                return null;
            }
        } catch (NameNotFoundException e) {
        }
        return new bnh(str, dZ.getGmpAppId(), dZ.Po(), dZ.Pp(), dZ.Pq(), dZ.Pr(), dZ.Ps(), null, dZ.Pt(), false, dZ.Pl(), dZ.PG(), 0, 0);
    }

    private final void m5483f(bnh com_fossil_bnh) {
        Object obj = 1;
        Pe().OP();
        RA();
        awa.bO(com_fossil_bnh);
        awa.df(com_fossil_bnh.packageName);
        bng dZ = OZ().dZ(com_fossil_bnh.packageName);
        String el = Pg().el(com_fossil_bnh.packageName);
        Object obj2 = null;
        if (dZ == null) {
            bng com_fossil_bng = new bng(this, com_fossil_bnh.packageName);
            com_fossil_bng.dP(OT().QZ());
            com_fossil_bng.dR(el);
            dZ = com_fossil_bng;
            obj2 = 1;
        } else if (!el.equals(dZ.Pk())) {
            dZ.dR(el);
            dZ.dP(OT().QZ());
            int i = 1;
        }
        if (!(TextUtils.isEmpty(com_fossil_bnh.bxq) || com_fossil_bnh.bxq.equals(dZ.getGmpAppId()))) {
            dZ.dQ(com_fossil_bnh.bxq);
            obj2 = 1;
        }
        if (!(TextUtils.isEmpty(com_fossil_bnh.bxy) || com_fossil_bnh.bxy.equals(dZ.Pl()))) {
            dZ.dS(com_fossil_bnh.bxy);
            obj2 = 1;
        }
        if (!(com_fossil_bnh.bxs == 0 || com_fossil_bnh.bxs == dZ.Pr())) {
            dZ.m5321X(com_fossil_bnh.bxs);
            obj2 = 1;
        }
        if (!(TextUtils.isEmpty(com_fossil_bnh.bpS) || com_fossil_bnh.bpS.equals(dZ.Po()))) {
            dZ.setAppVersion(com_fossil_bnh.bpS);
            obj2 = 1;
        }
        if (com_fossil_bnh.bxx != dZ.Pp()) {
            dZ.m5320W(com_fossil_bnh.bxx);
            obj2 = 1;
        }
        if (!(com_fossil_bnh.bxr == null || com_fossil_bnh.bxr.equals(dZ.Pq()))) {
            dZ.dT(com_fossil_bnh.bxr);
            obj2 = 1;
        }
        if (com_fossil_bnh.bxt != dZ.Ps()) {
            dZ.m5322Y(com_fossil_bnh.bxt);
            obj2 = 1;
        }
        if (com_fossil_bnh.bxv != dZ.Pt()) {
            dZ.setMeasurementEnabled(com_fossil_bnh.bxv);
            obj2 = 1;
        }
        if (!(TextUtils.isEmpty(com_fossil_bnh.bxu) || com_fossil_bnh.bxu.equals(dZ.PE()))) {
            dZ.dU(com_fossil_bnh.bxu);
            obj2 = 1;
        }
        if (com_fossil_bnh.bxz != dZ.PG()) {
            dZ.ai(com_fossil_bnh.bxz);
        } else {
            obj = obj2;
        }
        if (obj != null) {
            OZ().m5359a(dZ);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean m5484g(java.lang.String r21, long r22) {
        /*
        r20 = this;
        r2 = r20.OZ();
        r2.beginTransaction();
        r15 = new com.fossil.bpk$a;	 Catch:{ all -> 0x019d }
        r2 = 0;
        r0 = r20;
        r15.<init>();	 Catch:{ all -> 0x019d }
        r14 = r20.OZ();	 Catch:{ all -> 0x019d }
        r4 = 0;
        r0 = r20;
        r0 = r0.bBJ;	 Catch:{ all -> 0x019d }
        r16 = r0;
        com.fossil.awa.bO(r15);	 Catch:{ all -> 0x019d }
        r14.OP();	 Catch:{ all -> 0x019d }
        r14.RA();	 Catch:{ all -> 0x019d }
        r3 = 0;
        r2 = r14.getWritableDatabase();	 Catch:{ SQLiteException -> 0x0796 }
        r5 = 0;
        r5 = android.text.TextUtils.isEmpty(r5);	 Catch:{ SQLiteException -> 0x0796 }
        if (r5 == 0) goto L_0x01a6;
    L_0x002f:
        r6 = -1;
        r5 = (r16 > r6 ? 1 : (r16 == r6 ? 0 : -1));
        if (r5 == 0) goto L_0x013f;
    L_0x0035:
        r5 = 2;
        r5 = new java.lang.String[r5];	 Catch:{ SQLiteException -> 0x0796 }
        r6 = 0;
        r7 = java.lang.String.valueOf(r16);	 Catch:{ SQLiteException -> 0x0796 }
        r5[r6] = r7;	 Catch:{ SQLiteException -> 0x0796 }
        r6 = 1;
        r7 = java.lang.String.valueOf(r22);	 Catch:{ SQLiteException -> 0x0796 }
        r5[r6] = r7;	 Catch:{ SQLiteException -> 0x0796 }
        r6 = r5;
    L_0x0047:
        r8 = -1;
        r5 = (r16 > r8 ? 1 : (r16 == r8 ? 0 : -1));
        if (r5 == 0) goto L_0x014c;
    L_0x004d:
        r5 = "rowid <= ? and ";
    L_0x004f:
        r7 = java.lang.String.valueOf(r5);	 Catch:{ SQLiteException -> 0x0796 }
        r7 = r7.length();	 Catch:{ SQLiteException -> 0x0796 }
        r7 = r7 + 148;
        r8 = new java.lang.StringBuilder;	 Catch:{ SQLiteException -> 0x0796 }
        r8.<init>(r7);	 Catch:{ SQLiteException -> 0x0796 }
        r7 = "select app_id, metadata_fingerprint from raw_events where ";
        r7 = r8.append(r7);	 Catch:{ SQLiteException -> 0x0796 }
        r5 = r7.append(r5);	 Catch:{ SQLiteException -> 0x0796 }
        r7 = "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;";
        r5 = r5.append(r7);	 Catch:{ SQLiteException -> 0x0796 }
        r5 = r5.toString();	 Catch:{ SQLiteException -> 0x0796 }
        r3 = r2.rawQuery(r5, r6);	 Catch:{ SQLiteException -> 0x0796 }
        r5 = r3.moveToFirst();	 Catch:{ SQLiteException -> 0x0796 }
        if (r5 != 0) goto L_0x0150;
    L_0x007c:
        if (r3 == 0) goto L_0x0081;
    L_0x007e:
        r3.close();	 Catch:{ all -> 0x019d }
    L_0x0081:
        r2 = r15.bBR;	 Catch:{ all -> 0x019d }
        if (r2 == 0) goto L_0x008d;
    L_0x0085:
        r2 = r15.bBR;	 Catch:{ all -> 0x019d }
        r2 = r2.isEmpty();	 Catch:{ all -> 0x019d }
        if (r2 == 0) goto L_0x0335;
    L_0x008d:
        r2 = 1;
    L_0x008e:
        if (r2 != 0) goto L_0x0781;
    L_0x0090:
        r13 = 0;
        r0 = r15.bBP;	 Catch:{ all -> 0x019d }
        r16 = r0;
        r2 = r15.bBR;	 Catch:{ all -> 0x019d }
        r2 = r2.size();	 Catch:{ all -> 0x019d }
        r2 = new com.fossil.bsv[r2];	 Catch:{ all -> 0x019d }
        r0 = r16;
        r0.bEA = r2;	 Catch:{ all -> 0x019d }
        r12 = 0;
        r2 = 0;
        r14 = r2;
    L_0x00a4:
        r2 = r15.bBR;	 Catch:{ all -> 0x019d }
        r2 = r2.size();	 Catch:{ all -> 0x019d }
        if (r14 >= r2) goto L_0x05c9;
    L_0x00ac:
        r3 = r20.Pc();	 Catch:{ all -> 0x019d }
        r2 = r15.bBP;	 Catch:{ all -> 0x019d }
        r4 = r2.bEM;	 Catch:{ all -> 0x019d }
        r2 = r15.bBR;	 Catch:{ all -> 0x019d }
        r2 = r2.get(r14);	 Catch:{ all -> 0x019d }
        r2 = (com.fossil.bsv) r2;	 Catch:{ all -> 0x019d }
        r2 = r2.name;	 Catch:{ all -> 0x019d }
        r2 = r3.aa(r4, r2);	 Catch:{ all -> 0x019d }
        if (r2 == 0) goto L_0x033b;
    L_0x00c4:
        r2 = r20.Pf();	 Catch:{ all -> 0x019d }
        r3 = r2.Re();	 Catch:{ all -> 0x019d }
        r4 = "Dropping blacklisted raw event. appId";
        r2 = r15.bBP;	 Catch:{ all -> 0x019d }
        r2 = r2.bEM;	 Catch:{ all -> 0x019d }
        r5 = com.fossil.bol.ei(r2);	 Catch:{ all -> 0x019d }
        r6 = r20.Pa();	 Catch:{ all -> 0x019d }
        r2 = r15.bBR;	 Catch:{ all -> 0x019d }
        r2 = r2.get(r14);	 Catch:{ all -> 0x019d }
        r2 = (com.fossil.bsv) r2;	 Catch:{ all -> 0x019d }
        r2 = r2.name;	 Catch:{ all -> 0x019d }
        r2 = r6.ef(r2);	 Catch:{ all -> 0x019d }
        r3.m5437a(r4, r5, r2);	 Catch:{ all -> 0x019d }
        r2 = r20.Pb();	 Catch:{ all -> 0x019d }
        r3 = r15.bBP;	 Catch:{ all -> 0x019d }
        r3 = r3.bEM;	 Catch:{ all -> 0x019d }
        r2 = r2.eL(r3);	 Catch:{ all -> 0x019d }
        if (r2 != 0) goto L_0x0107;
    L_0x00f9:
        r2 = r20.Pb();	 Catch:{ all -> 0x019d }
        r3 = r15.bBP;	 Catch:{ all -> 0x019d }
        r3 = r3.bEM;	 Catch:{ all -> 0x019d }
        r2 = r2.eM(r3);	 Catch:{ all -> 0x019d }
        if (r2 == 0) goto L_0x0338;
    L_0x0107:
        r2 = 1;
    L_0x0108:
        if (r2 != 0) goto L_0x07ad;
    L_0x010a:
        r3 = "_err";
        r2 = r15.bBR;	 Catch:{ all -> 0x019d }
        r2 = r2.get(r14);	 Catch:{ all -> 0x019d }
        r2 = (com.fossil.bsv) r2;	 Catch:{ all -> 0x019d }
        r2 = r2.name;	 Catch:{ all -> 0x019d }
        r2 = r3.equals(r2);	 Catch:{ all -> 0x019d }
        if (r2 != 0) goto L_0x07ad;
    L_0x011c:
        r2 = r20.Pb();	 Catch:{ all -> 0x019d }
        r3 = r15.bBP;	 Catch:{ all -> 0x019d }
        r3 = r3.bEM;	 Catch:{ all -> 0x019d }
        r4 = 11;
        r5 = "_ev";
        r6 = r15.bBR;	 Catch:{ all -> 0x019d }
        r6 = r6.get(r14);	 Catch:{ all -> 0x019d }
        r6 = (com.fossil.bsv) r6;	 Catch:{ all -> 0x019d }
        r6 = r6.name;	 Catch:{ all -> 0x019d }
        r7 = 0;
        r2.m5602a(r3, r4, r5, r6, r7);	 Catch:{ all -> 0x019d }
        r2 = r12;
        r3 = r13;
    L_0x0138:
        r4 = r14 + 1;
        r14 = r4;
        r12 = r2;
        r13 = r3;
        goto L_0x00a4;
    L_0x013f:
        r5 = 1;
        r5 = new java.lang.String[r5];	 Catch:{ SQLiteException -> 0x0796 }
        r6 = 0;
        r7 = java.lang.String.valueOf(r22);	 Catch:{ SQLiteException -> 0x0796 }
        r5[r6] = r7;	 Catch:{ SQLiteException -> 0x0796 }
        r6 = r5;
        goto L_0x0047;
    L_0x014c:
        r5 = "";
        goto L_0x004f;
    L_0x0150:
        r5 = 0;
        r4 = r3.getString(r5);	 Catch:{ SQLiteException -> 0x0796 }
        r5 = 1;
        r5 = r3.getString(r5);	 Catch:{ SQLiteException -> 0x0796 }
        r3.close();	 Catch:{ SQLiteException -> 0x0796 }
        r13 = r5;
        r11 = r3;
        r12 = r4;
    L_0x0160:
        r3 = "raw_events_metadata";
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ SQLiteException -> 0x02bd, all -> 0x0792 }
        r5 = 0;
        r6 = "metadata";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x02bd, all -> 0x0792 }
        r5 = "app_id = ? and metadata_fingerprint = ?";
        r6 = 2;
        r6 = new java.lang.String[r6];	 Catch:{ SQLiteException -> 0x02bd, all -> 0x0792 }
        r7 = 0;
        r6[r7] = r12;	 Catch:{ SQLiteException -> 0x02bd, all -> 0x0792 }
        r7 = 1;
        r6[r7] = r13;	 Catch:{ SQLiteException -> 0x02bd, all -> 0x0792 }
        r7 = 0;
        r8 = 0;
        r9 = "rowid";
        r10 = "2";
        r11 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ SQLiteException -> 0x02bd, all -> 0x0792 }
        r3 = r11.moveToFirst();	 Catch:{ SQLiteException -> 0x02bd, all -> 0x0792 }
        if (r3 != 0) goto L_0x0210;
    L_0x0185:
        r2 = r14.Pf();	 Catch:{ SQLiteException -> 0x02bd, all -> 0x0792 }
        r2 = r2.Rc();	 Catch:{ SQLiteException -> 0x02bd, all -> 0x0792 }
        r3 = "Raw event metadata record is missing. appId";
        r4 = com.fossil.bol.ei(r12);	 Catch:{ SQLiteException -> 0x02bd, all -> 0x0792 }
        r2.m5439d(r3, r4);	 Catch:{ SQLiteException -> 0x02bd, all -> 0x0792 }
        if (r11 == 0) goto L_0x0081;
    L_0x0198:
        r11.close();	 Catch:{ all -> 0x019d }
        goto L_0x0081;
    L_0x019d:
        r2 = move-exception;
        r3 = r20.OZ();
        r3.endTransaction();
        throw r2;
    L_0x01a6:
        r6 = -1;
        r5 = (r16 > r6 ? 1 : (r16 == r6 ? 0 : -1));
        if (r5 == 0) goto L_0x01f7;
    L_0x01ac:
        r5 = 2;
        r5 = new java.lang.String[r5];	 Catch:{ SQLiteException -> 0x0796 }
        r6 = 0;
        r7 = 0;
        r5[r6] = r7;	 Catch:{ SQLiteException -> 0x0796 }
        r6 = 1;
        r7 = java.lang.String.valueOf(r16);	 Catch:{ SQLiteException -> 0x0796 }
        r5[r6] = r7;	 Catch:{ SQLiteException -> 0x0796 }
        r6 = r5;
    L_0x01bb:
        r8 = -1;
        r5 = (r16 > r8 ? 1 : (r16 == r8 ? 0 : -1));
        if (r5 == 0) goto L_0x0200;
    L_0x01c1:
        r5 = " and rowid <= ?";
    L_0x01c3:
        r7 = java.lang.String.valueOf(r5);	 Catch:{ SQLiteException -> 0x0796 }
        r7 = r7.length();	 Catch:{ SQLiteException -> 0x0796 }
        r7 = r7 + 84;
        r8 = new java.lang.StringBuilder;	 Catch:{ SQLiteException -> 0x0796 }
        r8.<init>(r7);	 Catch:{ SQLiteException -> 0x0796 }
        r7 = "select metadata_fingerprint from raw_events where app_id = ?";
        r7 = r8.append(r7);	 Catch:{ SQLiteException -> 0x0796 }
        r5 = r7.append(r5);	 Catch:{ SQLiteException -> 0x0796 }
        r7 = " order by rowid limit 1;";
        r5 = r5.append(r7);	 Catch:{ SQLiteException -> 0x0796 }
        r5 = r5.toString();	 Catch:{ SQLiteException -> 0x0796 }
        r3 = r2.rawQuery(r5, r6);	 Catch:{ SQLiteException -> 0x0796 }
        r5 = r3.moveToFirst();	 Catch:{ SQLiteException -> 0x0796 }
        if (r5 != 0) goto L_0x0203;
    L_0x01f0:
        if (r3 == 0) goto L_0x0081;
    L_0x01f2:
        r3.close();	 Catch:{ all -> 0x019d }
        goto L_0x0081;
    L_0x01f7:
        r5 = 1;
        r5 = new java.lang.String[r5];	 Catch:{ SQLiteException -> 0x0796 }
        r6 = 0;
        r7 = 0;
        r5[r6] = r7;	 Catch:{ SQLiteException -> 0x0796 }
        r6 = r5;
        goto L_0x01bb;
    L_0x0200:
        r5 = "";
        goto L_0x01c3;
    L_0x0203:
        r5 = 0;
        r5 = r3.getString(r5);	 Catch:{ SQLiteException -> 0x0796 }
        r3.close();	 Catch:{ SQLiteException -> 0x0796 }
        r13 = r5;
        r11 = r3;
        r12 = r4;
        goto L_0x0160;
    L_0x0210:
        r3 = 0;
        r3 = r11.getBlob(r3);	 Catch:{ SQLiteException -> 0x02bd, all -> 0x0792 }
        r4 = 0;
        r5 = r3.length;	 Catch:{ SQLiteException -> 0x02bd, all -> 0x0792 }
        r3 = com.fossil.bch.m4834g(r3, r4, r5);	 Catch:{ SQLiteException -> 0x02bd, all -> 0x0792 }
        r4 = new com.fossil.bsy;	 Catch:{ SQLiteException -> 0x02bd, all -> 0x0792 }
        r4.<init>();	 Catch:{ SQLiteException -> 0x02bd, all -> 0x0792 }
        r4.mo1266a(r3);	 Catch:{ IOException -> 0x0298 }
        r3 = r11.moveToNext();	 Catch:{ SQLiteException -> 0x02bd, all -> 0x0792 }
        if (r3 == 0) goto L_0x023a;
    L_0x0229:
        r3 = r14.Pf();	 Catch:{ SQLiteException -> 0x02bd, all -> 0x0792 }
        r3 = r3.Re();	 Catch:{ SQLiteException -> 0x02bd, all -> 0x0792 }
        r5 = "Get multiple raw event metadata records, expected one. appId";
        r6 = com.fossil.bol.ei(r12);	 Catch:{ SQLiteException -> 0x02bd, all -> 0x0792 }
        r3.m5439d(r5, r6);	 Catch:{ SQLiteException -> 0x02bd, all -> 0x0792 }
    L_0x023a:
        r11.close();	 Catch:{ SQLiteException -> 0x02bd, all -> 0x0792 }
        r15.mo1445b(r4);	 Catch:{ SQLiteException -> 0x02bd, all -> 0x0792 }
        r4 = -1;
        r3 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1));
        if (r3 == 0) goto L_0x02b1;
    L_0x0246:
        r5 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?";
        r3 = 3;
        r6 = new java.lang.String[r3];	 Catch:{ SQLiteException -> 0x02bd, all -> 0x0792 }
        r3 = 0;
        r6[r3] = r12;	 Catch:{ SQLiteException -> 0x02bd, all -> 0x0792 }
        r3 = 1;
        r6[r3] = r13;	 Catch:{ SQLiteException -> 0x02bd, all -> 0x0792 }
        r3 = 2;
        r4 = java.lang.String.valueOf(r16);	 Catch:{ SQLiteException -> 0x02bd, all -> 0x0792 }
        r6[r3] = r4;	 Catch:{ SQLiteException -> 0x02bd, all -> 0x0792 }
    L_0x0258:
        r3 = "raw_events";
        r4 = 4;
        r4 = new java.lang.String[r4];	 Catch:{ SQLiteException -> 0x02bd, all -> 0x0792 }
        r7 = 0;
        r8 = "rowid";
        r4[r7] = r8;	 Catch:{ SQLiteException -> 0x02bd, all -> 0x0792 }
        r7 = 1;
        r8 = "name";
        r4[r7] = r8;	 Catch:{ SQLiteException -> 0x02bd, all -> 0x0792 }
        r7 = 2;
        r8 = "timestamp";
        r4[r7] = r8;	 Catch:{ SQLiteException -> 0x02bd, all -> 0x0792 }
        r7 = 3;
        r8 = "data";
        r4[r7] = r8;	 Catch:{ SQLiteException -> 0x02bd, all -> 0x0792 }
        r7 = 0;
        r8 = 0;
        r9 = "rowid";
        r10 = 0;
        r3 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ SQLiteException -> 0x02bd, all -> 0x0792 }
        r2 = r3.moveToFirst();	 Catch:{ SQLiteException -> 0x0799 }
        if (r2 != 0) goto L_0x02d8;
    L_0x0280:
        r2 = r14.Pf();	 Catch:{ SQLiteException -> 0x0799 }
        r2 = r2.Re();	 Catch:{ SQLiteException -> 0x0799 }
        r4 = "Raw event data disappeared while in transaction. appId";
        r5 = com.fossil.bol.ei(r12);	 Catch:{ SQLiteException -> 0x0799 }
        r2.m5439d(r4, r5);	 Catch:{ SQLiteException -> 0x0799 }
        if (r3 == 0) goto L_0x0081;
    L_0x0293:
        r3.close();	 Catch:{ all -> 0x019d }
        goto L_0x0081;
    L_0x0298:
        r2 = move-exception;
        r3 = r14.Pf();	 Catch:{ SQLiteException -> 0x02bd, all -> 0x0792 }
        r3 = r3.Rc();	 Catch:{ SQLiteException -> 0x02bd, all -> 0x0792 }
        r4 = "Data loss. Failed to merge raw event metadata. appId";
        r5 = com.fossil.bol.ei(r12);	 Catch:{ SQLiteException -> 0x02bd, all -> 0x0792 }
        r3.m5437a(r4, r5, r2);	 Catch:{ SQLiteException -> 0x02bd, all -> 0x0792 }
        if (r11 == 0) goto L_0x0081;
    L_0x02ac:
        r11.close();	 Catch:{ all -> 0x019d }
        goto L_0x0081;
    L_0x02b1:
        r5 = "app_id = ? and metadata_fingerprint = ?";
        r3 = 2;
        r6 = new java.lang.String[r3];	 Catch:{ SQLiteException -> 0x02bd, all -> 0x0792 }
        r3 = 0;
        r6[r3] = r12;	 Catch:{ SQLiteException -> 0x02bd, all -> 0x0792 }
        r3 = 1;
        r6[r3] = r13;	 Catch:{ SQLiteException -> 0x02bd, all -> 0x0792 }
        goto L_0x0258;
    L_0x02bd:
        r2 = move-exception;
        r3 = r11;
        r4 = r12;
    L_0x02c0:
        r5 = r14.Pf();	 Catch:{ all -> 0x032e }
        r5 = r5.Rc();	 Catch:{ all -> 0x032e }
        r6 = "Data loss. Error selecting raw event. appId";
        r4 = com.fossil.bol.ei(r4);	 Catch:{ all -> 0x032e }
        r5.m5437a(r6, r4, r2);	 Catch:{ all -> 0x032e }
        if (r3 == 0) goto L_0x0081;
    L_0x02d3:
        r3.close();	 Catch:{ all -> 0x019d }
        goto L_0x0081;
    L_0x02d8:
        r2 = 0;
        r4 = r3.getLong(r2);	 Catch:{ SQLiteException -> 0x0799 }
        r2 = 3;
        r2 = r3.getBlob(r2);	 Catch:{ SQLiteException -> 0x0799 }
        r6 = 0;
        r7 = r2.length;	 Catch:{ SQLiteException -> 0x0799 }
        r2 = com.fossil.bch.m4834g(r2, r6, r7);	 Catch:{ SQLiteException -> 0x0799 }
        r6 = new com.fossil.bsv;	 Catch:{ SQLiteException -> 0x0799 }
        r6.<init>();	 Catch:{ SQLiteException -> 0x0799 }
        r6.mo1266a(r2);	 Catch:{ IOException -> 0x030f }
        r2 = 1;
        r2 = r3.getString(r2);	 Catch:{ SQLiteException -> 0x0799 }
        r6.name = r2;	 Catch:{ SQLiteException -> 0x0799 }
        r2 = 2;
        r8 = r3.getLong(r2);	 Catch:{ SQLiteException -> 0x0799 }
        r2 = java.lang.Long.valueOf(r8);	 Catch:{ SQLiteException -> 0x0799 }
        r6.bEt = r2;	 Catch:{ SQLiteException -> 0x0799 }
        r2 = r15.mo1444a(r4, r6);	 Catch:{ SQLiteException -> 0x0799 }
        if (r2 != 0) goto L_0x0321;
    L_0x0308:
        if (r3 == 0) goto L_0x0081;
    L_0x030a:
        r3.close();	 Catch:{ all -> 0x019d }
        goto L_0x0081;
    L_0x030f:
        r2 = move-exception;
        r4 = r14.Pf();	 Catch:{ SQLiteException -> 0x0799 }
        r4 = r4.Rc();	 Catch:{ SQLiteException -> 0x0799 }
        r5 = "Data loss. Failed to merge raw event. appId";
        r6 = com.fossil.bol.ei(r12);	 Catch:{ SQLiteException -> 0x0799 }
        r4.m5437a(r5, r6, r2);	 Catch:{ SQLiteException -> 0x0799 }
    L_0x0321:
        r2 = r3.moveToNext();	 Catch:{ SQLiteException -> 0x0799 }
        if (r2 != 0) goto L_0x02d8;
    L_0x0327:
        if (r3 == 0) goto L_0x0081;
    L_0x0329:
        r3.close();	 Catch:{ all -> 0x019d }
        goto L_0x0081;
    L_0x032e:
        r2 = move-exception;
    L_0x032f:
        if (r3 == 0) goto L_0x0334;
    L_0x0331:
        r3.close();	 Catch:{ all -> 0x019d }
    L_0x0334:
        throw r2;	 Catch:{ all -> 0x019d }
    L_0x0335:
        r2 = 0;
        goto L_0x008e;
    L_0x0338:
        r2 = 0;
        goto L_0x0108;
    L_0x033b:
        r3 = r20.Pc();	 Catch:{ all -> 0x019d }
        r2 = r15.bBP;	 Catch:{ all -> 0x019d }
        r4 = r2.bEM;	 Catch:{ all -> 0x019d }
        r2 = r15.bBR;	 Catch:{ all -> 0x019d }
        r2 = r2.get(r14);	 Catch:{ all -> 0x019d }
        r2 = (com.fossil.bsv) r2;	 Catch:{ all -> 0x019d }
        r2 = r2.name;	 Catch:{ all -> 0x019d }
        r17 = r3.ab(r4, r2);	 Catch:{ all -> 0x019d }
        if (r17 != 0) goto L_0x0366;
    L_0x0353:
        r20.Pb();	 Catch:{ all -> 0x019d }
        r2 = r15.bBR;	 Catch:{ all -> 0x019d }
        r2 = r2.get(r14);	 Catch:{ all -> 0x019d }
        r2 = (com.fossil.bsv) r2;	 Catch:{ all -> 0x019d }
        r2 = r2.name;	 Catch:{ all -> 0x019d }
        r2 = com.fossil.bsk.eN(r2);	 Catch:{ all -> 0x019d }
        if (r2 == 0) goto L_0x05c7;
    L_0x0366:
        r3 = 0;
        r4 = 0;
        r2 = r15.bBR;	 Catch:{ all -> 0x019d }
        r2 = r2.get(r14);	 Catch:{ all -> 0x019d }
        r2 = (com.fossil.bsv) r2;	 Catch:{ all -> 0x019d }
        r2 = r2.bEs;	 Catch:{ all -> 0x019d }
        if (r2 != 0) goto L_0x0381;
    L_0x0374:
        r2 = r15.bBR;	 Catch:{ all -> 0x019d }
        r2 = r2.get(r14);	 Catch:{ all -> 0x019d }
        r2 = (com.fossil.bsv) r2;	 Catch:{ all -> 0x019d }
        r5 = 0;
        r5 = new com.fossil.bsw[r5];	 Catch:{ all -> 0x019d }
        r2.bEs = r5;	 Catch:{ all -> 0x019d }
    L_0x0381:
        r2 = r15.bBR;	 Catch:{ all -> 0x019d }
        r2 = r2.get(r14);	 Catch:{ all -> 0x019d }
        r2 = (com.fossil.bsv) r2;	 Catch:{ all -> 0x019d }
        r6 = r2.bEs;	 Catch:{ all -> 0x019d }
        r7 = r6.length;	 Catch:{ all -> 0x019d }
        r2 = 0;
        r5 = r2;
    L_0x038e:
        if (r5 >= r7) goto L_0x03c0;
    L_0x0390:
        r2 = r6[r5];	 Catch:{ all -> 0x019d }
        r8 = "_c";
        r9 = r2.name;	 Catch:{ all -> 0x019d }
        r8 = r8.equals(r9);	 Catch:{ all -> 0x019d }
        if (r8 == 0) goto L_0x03ac;
    L_0x039c:
        r8 = 1;
        r3 = java.lang.Long.valueOf(r8);	 Catch:{ all -> 0x019d }
        r2.bEw = r3;	 Catch:{ all -> 0x019d }
        r2 = 1;
        r3 = r2;
        r2 = r4;
    L_0x03a7:
        r4 = r5 + 1;
        r5 = r4;
        r4 = r2;
        goto L_0x038e;
    L_0x03ac:
        r8 = "_r";
        r9 = r2.name;	 Catch:{ all -> 0x019d }
        r8 = r8.equals(r9);	 Catch:{ all -> 0x019d }
        if (r8 == 0) goto L_0x07aa;
    L_0x03b6:
        r8 = 1;
        r4 = java.lang.Long.valueOf(r8);	 Catch:{ all -> 0x019d }
        r2.bEw = r4;	 Catch:{ all -> 0x019d }
        r2 = 1;
        goto L_0x03a7;
    L_0x03c0:
        if (r3 != 0) goto L_0x0420;
    L_0x03c2:
        if (r17 == 0) goto L_0x0420;
    L_0x03c4:
        r2 = r20.Pf();	 Catch:{ all -> 0x019d }
        r3 = r2.Ri();	 Catch:{ all -> 0x019d }
        r5 = "Marking event as conversion";
        r6 = r20.Pa();	 Catch:{ all -> 0x019d }
        r2 = r15.bBR;	 Catch:{ all -> 0x019d }
        r2 = r2.get(r14);	 Catch:{ all -> 0x019d }
        r2 = (com.fossil.bsv) r2;	 Catch:{ all -> 0x019d }
        r2 = r2.name;	 Catch:{ all -> 0x019d }
        r2 = r6.ef(r2);	 Catch:{ all -> 0x019d }
        r3.m5439d(r5, r2);	 Catch:{ all -> 0x019d }
        r2 = r15.bBR;	 Catch:{ all -> 0x019d }
        r2 = r2.get(r14);	 Catch:{ all -> 0x019d }
        r2 = (com.fossil.bsv) r2;	 Catch:{ all -> 0x019d }
        r3 = r2.bEs;	 Catch:{ all -> 0x019d }
        r2 = r15.bBR;	 Catch:{ all -> 0x019d }
        r2 = r2.get(r14);	 Catch:{ all -> 0x019d }
        r2 = (com.fossil.bsv) r2;	 Catch:{ all -> 0x019d }
        r2 = r2.bEs;	 Catch:{ all -> 0x019d }
        r2 = r2.length;	 Catch:{ all -> 0x019d }
        r2 = r2 + 1;
        r2 = java.util.Arrays.copyOf(r3, r2);	 Catch:{ all -> 0x019d }
        r2 = (com.fossil.bsw[]) r2;	 Catch:{ all -> 0x019d }
        r3 = new com.fossil.bsw;	 Catch:{ all -> 0x019d }
        r3.<init>();	 Catch:{ all -> 0x019d }
        r5 = "_c";
        r3.name = r5;	 Catch:{ all -> 0x019d }
        r6 = 1;
        r5 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x019d }
        r3.bEw = r5;	 Catch:{ all -> 0x019d }
        r5 = r2.length;	 Catch:{ all -> 0x019d }
        r5 = r5 + -1;
        r2[r5] = r3;	 Catch:{ all -> 0x019d }
        r3 = r15.bBR;	 Catch:{ all -> 0x019d }
        r3 = r3.get(r14);	 Catch:{ all -> 0x019d }
        r3 = (com.fossil.bsv) r3;	 Catch:{ all -> 0x019d }
        r3.bEs = r2;	 Catch:{ all -> 0x019d }
    L_0x0420:
        if (r4 != 0) goto L_0x047e;
    L_0x0422:
        r2 = r20.Pf();	 Catch:{ all -> 0x019d }
        r3 = r2.Ri();	 Catch:{ all -> 0x019d }
        r4 = "Marking event as real-time";
        r5 = r20.Pa();	 Catch:{ all -> 0x019d }
        r2 = r15.bBR;	 Catch:{ all -> 0x019d }
        r2 = r2.get(r14);	 Catch:{ all -> 0x019d }
        r2 = (com.fossil.bsv) r2;	 Catch:{ all -> 0x019d }
        r2 = r2.name;	 Catch:{ all -> 0x019d }
        r2 = r5.ef(r2);	 Catch:{ all -> 0x019d }
        r3.m5439d(r4, r2);	 Catch:{ all -> 0x019d }
        r2 = r15.bBR;	 Catch:{ all -> 0x019d }
        r2 = r2.get(r14);	 Catch:{ all -> 0x019d }
        r2 = (com.fossil.bsv) r2;	 Catch:{ all -> 0x019d }
        r3 = r2.bEs;	 Catch:{ all -> 0x019d }
        r2 = r15.bBR;	 Catch:{ all -> 0x019d }
        r2 = r2.get(r14);	 Catch:{ all -> 0x019d }
        r2 = (com.fossil.bsv) r2;	 Catch:{ all -> 0x019d }
        r2 = r2.bEs;	 Catch:{ all -> 0x019d }
        r2 = r2.length;	 Catch:{ all -> 0x019d }
        r2 = r2 + 1;
        r2 = java.util.Arrays.copyOf(r3, r2);	 Catch:{ all -> 0x019d }
        r2 = (com.fossil.bsw[]) r2;	 Catch:{ all -> 0x019d }
        r3 = new com.fossil.bsw;	 Catch:{ all -> 0x019d }
        r3.<init>();	 Catch:{ all -> 0x019d }
        r4 = "_r";
        r3.name = r4;	 Catch:{ all -> 0x019d }
        r4 = 1;
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x019d }
        r3.bEw = r4;	 Catch:{ all -> 0x019d }
        r4 = r2.length;	 Catch:{ all -> 0x019d }
        r4 = r4 + -1;
        r2[r4] = r3;	 Catch:{ all -> 0x019d }
        r3 = r15.bBR;	 Catch:{ all -> 0x019d }
        r3 = r3.get(r14);	 Catch:{ all -> 0x019d }
        r3 = (com.fossil.bsv) r3;	 Catch:{ all -> 0x019d }
        r3.bEs = r2;	 Catch:{ all -> 0x019d }
    L_0x047e:
        r2 = 1;
        r3 = r20.OZ();	 Catch:{ all -> 0x019d }
        r4 = r20.RL();	 Catch:{ all -> 0x019d }
        r6 = r15.bBP;	 Catch:{ all -> 0x019d }
        r6 = r6.bEM;	 Catch:{ all -> 0x019d }
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r10 = 0;
        r11 = 1;
        r3 = r3.m5358a(r4, r6, r7, r8, r9, r10, r11);	 Catch:{ all -> 0x019d }
        r4 = r3.bxZ;	 Catch:{ all -> 0x019d }
        r0 = r20;
        r3 = r0.bBd;	 Catch:{ all -> 0x019d }
        r6 = r15.bBP;	 Catch:{ all -> 0x019d }
        r6 = r6.bEM;	 Catch:{ all -> 0x019d }
        r3 = r3.dV(r6);	 Catch:{ all -> 0x019d }
        r6 = (long) r3;	 Catch:{ all -> 0x019d }
        r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r3 <= 0) goto L_0x07a7;
    L_0x04a7:
        r2 = r15.bBR;	 Catch:{ all -> 0x019d }
        r2 = r2.get(r14);	 Catch:{ all -> 0x019d }
        r2 = (com.fossil.bsv) r2;	 Catch:{ all -> 0x019d }
        r3 = 0;
    L_0x04b0:
        r4 = r2.bEs;	 Catch:{ all -> 0x019d }
        r4 = r4.length;	 Catch:{ all -> 0x019d }
        if (r3 >= r4) goto L_0x04e1;
    L_0x04b5:
        r4 = "_r";
        r5 = r2.bEs;	 Catch:{ all -> 0x019d }
        r5 = r5[r3];	 Catch:{ all -> 0x019d }
        r5 = r5.name;	 Catch:{ all -> 0x019d }
        r4 = r4.equals(r5);	 Catch:{ all -> 0x019d }
        if (r4 == 0) goto L_0x0556;
    L_0x04c3:
        r4 = r2.bEs;	 Catch:{ all -> 0x019d }
        r4 = r4.length;	 Catch:{ all -> 0x019d }
        r4 = r4 + -1;
        r4 = new com.fossil.bsw[r4];	 Catch:{ all -> 0x019d }
        if (r3 <= 0) goto L_0x04d3;
    L_0x04cc:
        r5 = r2.bEs;	 Catch:{ all -> 0x019d }
        r6 = 0;
        r7 = 0;
        java.lang.System.arraycopy(r5, r6, r4, r7, r3);	 Catch:{ all -> 0x019d }
    L_0x04d3:
        r5 = r4.length;	 Catch:{ all -> 0x019d }
        if (r3 >= r5) goto L_0x04df;
    L_0x04d6:
        r5 = r2.bEs;	 Catch:{ all -> 0x019d }
        r6 = r3 + 1;
        r7 = r4.length;	 Catch:{ all -> 0x019d }
        r7 = r7 - r3;
        java.lang.System.arraycopy(r5, r6, r4, r3, r7);	 Catch:{ all -> 0x019d }
    L_0x04df:
        r2.bEs = r4;	 Catch:{ all -> 0x019d }
    L_0x04e1:
        r2 = r15.bBR;	 Catch:{ all -> 0x019d }
        r2 = r2.get(r14);	 Catch:{ all -> 0x019d }
        r2 = (com.fossil.bsv) r2;	 Catch:{ all -> 0x019d }
        r2 = r2.name;	 Catch:{ all -> 0x019d }
        r2 = com.fossil.bsk.ex(r2);	 Catch:{ all -> 0x019d }
        if (r2 == 0) goto L_0x05c7;
    L_0x04f1:
        if (r17 == 0) goto L_0x05c7;
    L_0x04f3:
        r3 = r20.OZ();	 Catch:{ all -> 0x019d }
        r4 = r20.RL();	 Catch:{ all -> 0x019d }
        r2 = r15.bBP;	 Catch:{ all -> 0x019d }
        r6 = r2.bEM;	 Catch:{ all -> 0x019d }
        r7 = 0;
        r8 = 0;
        r9 = 1;
        r10 = 0;
        r11 = 0;
        r2 = r3.m5358a(r4, r6, r7, r8, r9, r10, r11);	 Catch:{ all -> 0x019d }
        r2 = r2.bxX;	 Catch:{ all -> 0x019d }
        r0 = r20;
        r4 = r0.bBd;	 Catch:{ all -> 0x019d }
        r5 = r15.bBP;	 Catch:{ all -> 0x019d }
        r5 = r5.bEM;	 Catch:{ all -> 0x019d }
        r6 = com.fossil.bob.byM;	 Catch:{ all -> 0x019d }
        r4 = r4.m5334b(r5, r6);	 Catch:{ all -> 0x019d }
        r4 = (long) r4;	 Catch:{ all -> 0x019d }
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 <= 0) goto L_0x05c7;
    L_0x051d:
        r2 = r20.Pf();	 Catch:{ all -> 0x019d }
        r2 = r2.Re();	 Catch:{ all -> 0x019d }
        r3 = "Too many conversions. Not logging as conversion. appId";
        r4 = r15.bBP;	 Catch:{ all -> 0x019d }
        r4 = r4.bEM;	 Catch:{ all -> 0x019d }
        r4 = com.fossil.bol.ei(r4);	 Catch:{ all -> 0x019d }
        r2.m5439d(r3, r4);	 Catch:{ all -> 0x019d }
        r2 = r15.bBR;	 Catch:{ all -> 0x019d }
        r2 = r2.get(r14);	 Catch:{ all -> 0x019d }
        r2 = (com.fossil.bsv) r2;	 Catch:{ all -> 0x019d }
        r5 = 0;
        r4 = 0;
        r7 = r2.bEs;	 Catch:{ all -> 0x019d }
        r8 = r7.length;	 Catch:{ all -> 0x019d }
        r3 = 0;
        r6 = r3;
    L_0x0541:
        if (r6 >= r8) goto L_0x056b;
    L_0x0543:
        r3 = r7[r6];	 Catch:{ all -> 0x019d }
        r9 = "_c";
        r10 = r3.name;	 Catch:{ all -> 0x019d }
        r9 = r9.equals(r10);	 Catch:{ all -> 0x019d }
        if (r9 == 0) goto L_0x055a;
    L_0x054f:
        r4 = r5;
    L_0x0550:
        r5 = r6 + 1;
        r6 = r5;
        r5 = r4;
        r4 = r3;
        goto L_0x0541;
    L_0x0556:
        r3 = r3 + 1;
        goto L_0x04b0;
    L_0x055a:
        r9 = "_err";
        r3 = r3.name;	 Catch:{ all -> 0x019d }
        r3 = r9.equals(r3);	 Catch:{ all -> 0x019d }
        if (r3 == 0) goto L_0x07a3;
    L_0x0564:
        r3 = 1;
        r18 = r4;
        r4 = r3;
        r3 = r18;
        goto L_0x0550;
    L_0x056b:
        if (r5 == 0) goto L_0x05a2;
    L_0x056d:
        if (r4 == 0) goto L_0x05a2;
    L_0x056f:
        r3 = r2.bEs;	 Catch:{ all -> 0x019d }
        r3 = r3.length;	 Catch:{ all -> 0x019d }
        r3 = r3 + -1;
        r7 = new com.fossil.bsw[r3];	 Catch:{ all -> 0x019d }
        r5 = 0;
        r8 = r2.bEs;	 Catch:{ all -> 0x019d }
        r9 = r8.length;	 Catch:{ all -> 0x019d }
        r3 = 0;
        r6 = r3;
    L_0x057c:
        if (r6 >= r9) goto L_0x058b;
    L_0x057e:
        r10 = r8[r6];	 Catch:{ all -> 0x019d }
        if (r10 == r4) goto L_0x07a0;
    L_0x0582:
        r3 = r5 + 1;
        r7[r5] = r10;	 Catch:{ all -> 0x019d }
    L_0x0586:
        r5 = r6 + 1;
        r6 = r5;
        r5 = r3;
        goto L_0x057c;
    L_0x058b:
        r2.bEs = r7;	 Catch:{ all -> 0x019d }
        r4 = r13;
    L_0x058e:
        r0 = r16;
        r5 = r0.bEA;	 Catch:{ all -> 0x019d }
        r3 = r12 + 1;
        r2 = r15.bBR;	 Catch:{ all -> 0x019d }
        r2 = r2.get(r14);	 Catch:{ all -> 0x019d }
        r2 = (com.fossil.bsv) r2;	 Catch:{ all -> 0x019d }
        r5[r12] = r2;	 Catch:{ all -> 0x019d }
        r2 = r3;
        r3 = r4;
        goto L_0x0138;
    L_0x05a2:
        if (r4 == 0) goto L_0x05b2;
    L_0x05a4:
        r2 = "_err";
        r4.name = r2;	 Catch:{ all -> 0x019d }
        r2 = 10;
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x019d }
        r4.bEw = r2;	 Catch:{ all -> 0x019d }
        r4 = r13;
        goto L_0x058e;
    L_0x05b2:
        r2 = r20.Pf();	 Catch:{ all -> 0x019d }
        r2 = r2.Rc();	 Catch:{ all -> 0x019d }
        r3 = "Did not find conversion parameter. appId";
        r4 = r15.bBP;	 Catch:{ all -> 0x019d }
        r4 = r4.bEM;	 Catch:{ all -> 0x019d }
        r4 = com.fossil.bol.ei(r4);	 Catch:{ all -> 0x019d }
        r2.m5439d(r3, r4);	 Catch:{ all -> 0x019d }
    L_0x05c7:
        r4 = r13;
        goto L_0x058e;
    L_0x05c9:
        r2 = r15.bBR;	 Catch:{ all -> 0x019d }
        r2 = r2.size();	 Catch:{ all -> 0x019d }
        if (r12 >= r2) goto L_0x05df;
    L_0x05d1:
        r0 = r16;
        r2 = r0.bEA;	 Catch:{ all -> 0x019d }
        r2 = java.util.Arrays.copyOf(r2, r12);	 Catch:{ all -> 0x019d }
        r2 = (com.fossil.bsv[]) r2;	 Catch:{ all -> 0x019d }
        r0 = r16;
        r0.bEA = r2;	 Catch:{ all -> 0x019d }
    L_0x05df:
        r2 = r15.bBP;	 Catch:{ all -> 0x019d }
        r2 = r2.bEM;	 Catch:{ all -> 0x019d }
        r3 = r15.bBP;	 Catch:{ all -> 0x019d }
        r3 = r3.bEB;	 Catch:{ all -> 0x019d }
        r0 = r16;
        r4 = r0.bEA;	 Catch:{ all -> 0x019d }
        r0 = r20;
        r2 = r0.m5480a(r2, r3, r4);	 Catch:{ all -> 0x019d }
        r0 = r16;
        r0.bEV = r2;	 Catch:{ all -> 0x019d }
        r2 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x019d }
        r0 = r16;
        r0.bED = r2;	 Catch:{ all -> 0x019d }
        r2 = -9223372036854775808;
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x019d }
        r0 = r16;
        r0.bEE = r2;	 Catch:{ all -> 0x019d }
        r2 = 0;
    L_0x060d:
        r0 = r16;
        r3 = r0.bEA;	 Catch:{ all -> 0x019d }
        r3 = r3.length;	 Catch:{ all -> 0x019d }
        if (r2 >= r3) goto L_0x064d;
    L_0x0614:
        r0 = r16;
        r3 = r0.bEA;	 Catch:{ all -> 0x019d }
        r3 = r3[r2];	 Catch:{ all -> 0x019d }
        r4 = r3.bEt;	 Catch:{ all -> 0x019d }
        r4 = r4.longValue();	 Catch:{ all -> 0x019d }
        r0 = r16;
        r6 = r0.bED;	 Catch:{ all -> 0x019d }
        r6 = r6.longValue();	 Catch:{ all -> 0x019d }
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 >= 0) goto L_0x0632;
    L_0x062c:
        r4 = r3.bEt;	 Catch:{ all -> 0x019d }
        r0 = r16;
        r0.bED = r4;	 Catch:{ all -> 0x019d }
    L_0x0632:
        r4 = r3.bEt;	 Catch:{ all -> 0x019d }
        r4 = r4.longValue();	 Catch:{ all -> 0x019d }
        r0 = r16;
        r6 = r0.bEE;	 Catch:{ all -> 0x019d }
        r6 = r6.longValue();	 Catch:{ all -> 0x019d }
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 <= 0) goto L_0x064a;
    L_0x0644:
        r3 = r3.bEt;	 Catch:{ all -> 0x019d }
        r0 = r16;
        r0.bEE = r3;	 Catch:{ all -> 0x019d }
    L_0x064a:
        r2 = r2 + 1;
        goto L_0x060d;
    L_0x064d:
        r2 = r15.bBP;	 Catch:{ all -> 0x019d }
        r6 = r2.bEM;	 Catch:{ all -> 0x019d }
        r2 = r20.OZ();	 Catch:{ all -> 0x019d }
        r7 = r2.dZ(r6);	 Catch:{ all -> 0x019d }
        if (r7 != 0) goto L_0x06df;
    L_0x065b:
        r2 = r20.Pf();	 Catch:{ all -> 0x019d }
        r2 = r2.Rc();	 Catch:{ all -> 0x019d }
        r3 = "Bundling raw events w/o app info. appId";
        r4 = r15.bBP;	 Catch:{ all -> 0x019d }
        r4 = r4.bEM;	 Catch:{ all -> 0x019d }
        r4 = com.fossil.bol.ei(r4);	 Catch:{ all -> 0x019d }
        r2.m5439d(r3, r4);	 Catch:{ all -> 0x019d }
    L_0x0670:
        r0 = r16;
        r2 = r0.bEA;	 Catch:{ all -> 0x019d }
        r2 = r2.length;	 Catch:{ all -> 0x019d }
        if (r2 <= 0) goto L_0x06a9;
    L_0x0677:
        com.fossil.bnm.Qh();	 Catch:{ all -> 0x019d }
        r2 = r20.Pc();	 Catch:{ all -> 0x019d }
        r3 = r15.bBP;	 Catch:{ all -> 0x019d }
        r3 = r3.bEM;	 Catch:{ all -> 0x019d }
        r2 = r2.eq(r3);	 Catch:{ all -> 0x019d }
        if (r2 == 0) goto L_0x068c;
    L_0x0688:
        r3 = r2.bEh;	 Catch:{ all -> 0x019d }
        if (r3 != 0) goto L_0x0762;
    L_0x068c:
        r2 = r15.bBP;	 Catch:{ all -> 0x019d }
        r2 = r2.bxq;	 Catch:{ all -> 0x019d }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ all -> 0x019d }
        if (r2 == 0) goto L_0x074b;
    L_0x0696:
        r2 = -1;
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x019d }
        r0 = r16;
        r0.bEZ = r2;	 Catch:{ all -> 0x019d }
    L_0x06a0:
        r2 = r20.OZ();	 Catch:{ all -> 0x019d }
        r0 = r16;
        r2.m5365a(r0, r13);	 Catch:{ all -> 0x019d }
    L_0x06a9:
        r2 = r20.OZ();	 Catch:{ all -> 0x019d }
        r3 = r15.bBQ;	 Catch:{ all -> 0x019d }
        r2.m5348B(r3);	 Catch:{ all -> 0x019d }
        r3 = r20.OZ();	 Catch:{ all -> 0x019d }
        r2 = r3.getWritableDatabase();	 Catch:{ all -> 0x019d }
        r4 = "delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)";
        r5 = 2;
        r5 = new java.lang.String[r5];	 Catch:{ SQLiteException -> 0x076a }
        r7 = 0;
        r5[r7] = r6;	 Catch:{ SQLiteException -> 0x076a }
        r7 = 1;
        r5[r7] = r6;	 Catch:{ SQLiteException -> 0x076a }
        r2.execSQL(r4, r5);	 Catch:{ SQLiteException -> 0x076a }
    L_0x06c8:
        r2 = r20.OZ();	 Catch:{ all -> 0x019d }
        r2.setTransactionSuccessful();	 Catch:{ all -> 0x019d }
        r0 = r16;
        r2 = r0.bEA;	 Catch:{ all -> 0x019d }
        r2 = r2.length;	 Catch:{ all -> 0x019d }
        if (r2 <= 0) goto L_0x077e;
    L_0x06d6:
        r2 = 1;
    L_0x06d7:
        r3 = r20.OZ();
        r3.endTransaction();
    L_0x06de:
        return r2;
    L_0x06df:
        r0 = r16;
        r2 = r0.bEA;	 Catch:{ all -> 0x019d }
        r2 = r2.length;	 Catch:{ all -> 0x019d }
        if (r2 <= 0) goto L_0x0670;
    L_0x06e6:
        r2 = r7.Pn();	 Catch:{ all -> 0x019d }
        r4 = 0;
        r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r4 == 0) goto L_0x0747;
    L_0x06f0:
        r4 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x019d }
    L_0x06f4:
        r0 = r16;
        r0.bEG = r4;	 Catch:{ all -> 0x019d }
        r4 = r7.Pm();	 Catch:{ all -> 0x019d }
        r8 = 0;
        r8 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));
        if (r8 != 0) goto L_0x079d;
    L_0x0702:
        r4 = 0;
        r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r4 == 0) goto L_0x0749;
    L_0x0708:
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x019d }
    L_0x070c:
        r0 = r16;
        r0.bEF = r2;	 Catch:{ all -> 0x019d }
        r7.Px();	 Catch:{ all -> 0x019d }
        r2 = r7.Pu();	 Catch:{ all -> 0x019d }
        r2 = (int) r2;	 Catch:{ all -> 0x019d }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x019d }
        r0 = r16;
        r0.bET = r2;	 Catch:{ all -> 0x019d }
        r0 = r16;
        r2 = r0.bED;	 Catch:{ all -> 0x019d }
        r2 = r2.longValue();	 Catch:{ all -> 0x019d }
        r7.m5318U(r2);	 Catch:{ all -> 0x019d }
        r0 = r16;
        r2 = r0.bEE;	 Catch:{ all -> 0x019d }
        r2 = r2.longValue();	 Catch:{ all -> 0x019d }
        r7.m5319V(r2);	 Catch:{ all -> 0x019d }
        r2 = r7.PF();	 Catch:{ all -> 0x019d }
        r0 = r16;
        r0.bxu = r2;	 Catch:{ all -> 0x019d }
        r2 = r20.OZ();	 Catch:{ all -> 0x019d }
        r2.m5359a(r7);	 Catch:{ all -> 0x019d }
        goto L_0x0670;
    L_0x0747:
        r4 = 0;
        goto L_0x06f4;
    L_0x0749:
        r2 = 0;
        goto L_0x070c;
    L_0x074b:
        r2 = r20.Pf();	 Catch:{ all -> 0x019d }
        r2 = r2.Re();	 Catch:{ all -> 0x019d }
        r3 = "Did not find measurement config or missing version info. appId";
        r4 = r15.bBP;	 Catch:{ all -> 0x019d }
        r4 = r4.bEM;	 Catch:{ all -> 0x019d }
        r4 = com.fossil.bol.ei(r4);	 Catch:{ all -> 0x019d }
        r2.m5439d(r3, r4);	 Catch:{ all -> 0x019d }
        goto L_0x06a0;
    L_0x0762:
        r2 = r2.bEh;	 Catch:{ all -> 0x019d }
        r0 = r16;
        r0.bEZ = r2;	 Catch:{ all -> 0x019d }
        goto L_0x06a0;
    L_0x076a:
        r2 = move-exception;
        r3 = r3.Pf();	 Catch:{ all -> 0x019d }
        r3 = r3.Rc();	 Catch:{ all -> 0x019d }
        r4 = "Failed to remove unused event metadata. appId";
        r5 = com.fossil.bol.ei(r6);	 Catch:{ all -> 0x019d }
        r3.m5437a(r4, r5, r2);	 Catch:{ all -> 0x019d }
        goto L_0x06c8;
    L_0x077e:
        r2 = 0;
        goto L_0x06d7;
    L_0x0781:
        r2 = r20.OZ();	 Catch:{ all -> 0x019d }
        r2.setTransactionSuccessful();	 Catch:{ all -> 0x019d }
        r2 = r20.OZ();
        r2.endTransaction();
        r2 = 0;
        goto L_0x06de;
    L_0x0792:
        r2 = move-exception;
        r3 = r11;
        goto L_0x032f;
    L_0x0796:
        r2 = move-exception;
        goto L_0x02c0;
    L_0x0799:
        r2 = move-exception;
        r4 = r12;
        goto L_0x02c0;
    L_0x079d:
        r2 = r4;
        goto L_0x0702;
    L_0x07a0:
        r3 = r5;
        goto L_0x0586;
    L_0x07a3:
        r3 = r4;
        r4 = r5;
        goto L_0x0550;
    L_0x07a7:
        r13 = r2;
        goto L_0x04e1;
    L_0x07aa:
        r2 = r4;
        goto L_0x03a7;
    L_0x07ad:
        r2 = r12;
        r3 = r13;
        goto L_0x0138;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.bpk.g(java.lang.String, long):boolean");
    }

    public final bnc OQ() {
        m5477a(this.bBz);
        return this.bBz;
    }

    public final bnj OR() {
        m5478a(this.bBy);
        return this.bBy;
    }

    public final bqk OS() {
        m5478a(this.bBu);
        return this.bBu;
    }

    public final bog OT() {
        m5478a(this.bBv);
        return this.bBv;
    }

    public final bnt OU() {
        m5478a(this.bBt);
        return this.bBt;
    }

    public final brc OV() {
        m5478a(this.bBs);
        return this.bBs;
    }

    public final bqy OW() {
        m5478a(this.bBr);
        return this.bBr;
    }

    public final axm OX() {
        return this.bBq;
    }

    public final boh OY() {
        m5478a(this.bBo);
        return this.bBo;
    }

    public final bnn OZ() {
        m5478a(this.bBn);
        return this.bBn;
    }

    public final boj Pa() {
        m5477a(this.bBm);
        return this.bBm;
    }

    public final bsk Pb() {
        m5477a(this.bBl);
        return this.bBl;
    }

    public final bpf Pc() {
        m5478a(this.bBi);
        return this.bBi;
    }

    public final brz Pd() {
        m5478a(this.bBh);
        return this.bBh;
    }

    public final bpg Pe() {
        m5478a(this.bBg);
        return this.bBg;
    }

    public final bol Pf() {
        m5478a(this.bBf);
        return this.bBf;
    }

    public final bow Pg() {
        m5477a(this.bBe);
        return this.bBe;
    }

    public final bnm Ph() {
        return this.bBd;
    }

    final void RA() {
        if (!this.bru) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
    }

    protected final boolean RB() {
        boolean z = false;
        RA();
        Pe().OP();
        if (this.bBB == null || this.bBC == 0 || !(this.bBB == null || this.bBB.booleanValue() || Math.abs(this.bBq.elapsedRealtime() - this.bBC) <= 1000)) {
            this.bBC = this.bBq.elapsedRealtime();
            bnm.Qh();
            if (Pb().eH("android.permission.INTERNET") && Pb().eH("android.permission.ACCESS_NETWORK_STATE") && (bje.aQ(this.mContext).OG() || (bpc.m5452f(this.mContext, false) && brv.m5573g(this.mContext, false)))) {
                z = true;
            }
            this.bBB = Boolean.valueOf(z);
            if (this.bBB.booleanValue()) {
                this.bBB = Boolean.valueOf(Pb().eE(OT().getGmpAppId()));
            }
        }
        return this.bBB.booleanValue();
    }

    public final bol RC() {
        return (this.bBf == null || !this.bBf.isInitialized()) ? null : this.bBf;
    }

    final bpg RD() {
        return this.bBg;
    }

    public final AppMeasurement RE() {
        return this.bBj;
    }

    public final FirebaseAnalytics RF() {
        return this.bBk;
    }

    public final bop RG() {
        m5478a(this.bBp);
        return this.bBp;
    }

    final long RK() {
        Long valueOf = Long.valueOf(Pg().bAc.get());
        return valueOf.longValue() == 0 ? this.bBO : Math.min(this.bBO, valueOf.longValue());
    }

    public final void RM() {
        boolean z = true;
        Pe().OP();
        RA();
        this.bBN = true;
        String QG;
        String Qs;
        try {
            bnm.Qh();
            Boolean Rp = Pg().Rp();
            if (Rp == null) {
                Pf().Re().log("Upload data called on the client side before use of service was decided");
                this.bBN = false;
                RS();
            } else if (Rp.booleanValue()) {
                Pf().Rc().log("Upload called in the client side when service should be used");
                this.bBN = false;
                RS();
            } else if (this.bBK > 0) {
                RO();
                this.bBN = false;
                RS();
            } else {
                Pe().OP();
                if (this.bBF != null) {
                    Pf().Ri().log("Uploading requested multiple times");
                    this.bBN = false;
                    RS();
                } else if (RG().Rk()) {
                    long currentTimeMillis = this.bBq.currentTimeMillis();
                    m5484g(null, currentTimeMillis - bnm.Qt());
                    long j = Pg().bzX.get();
                    if (j != 0) {
                        Pf().Rh().m5439d("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(currentTimeMillis - j)));
                    }
                    QG = OZ().QG();
                    Object aj;
                    if (TextUtils.isEmpty(QG)) {
                        this.bBJ = -1;
                        aj = OZ().aj(currentTimeMillis - bnm.Qt());
                        if (!TextUtils.isEmpty(aj)) {
                            bng dZ = OZ().dZ(aj);
                            if (dZ != null) {
                                m5481b(dZ);
                            }
                        }
                    } else {
                        if (this.bBJ == -1) {
                            this.bBJ = OZ().QN();
                        }
                        List<Pair> p = OZ().m5369p(QG, this.bBd.m5334b(QG, bob.byF), Math.max(0, this.bBd.m5334b(QG, bob.byG)));
                        if (!p.isEmpty()) {
                            bsy com_fossil_bsy;
                            Object obj;
                            int i;
                            List subList;
                            for (Pair pair : p) {
                                com_fossil_bsy = (bsy) pair.first;
                                if (!TextUtils.isEmpty(com_fossil_bsy.bEP)) {
                                    obj = com_fossil_bsy.bEP;
                                    break;
                                }
                            }
                            obj = null;
                            if (obj != null) {
                                for (i = 0; i < p.size(); i++) {
                                    com_fossil_bsy = (bsy) ((Pair) p.get(i)).first;
                                    if (!TextUtils.isEmpty(com_fossil_bsy.bEP) && !com_fossil_bsy.bEP.equals(obj)) {
                                        subList = p.subList(0, i);
                                        break;
                                    }
                                }
                            }
                            subList = p;
                            bsx com_fossil_bsx = new bsx();
                            com_fossil_bsx.bEx = new bsy[subList.size()];
                            Collection arrayList = new ArrayList(subList.size());
                            boolean z2 = bnm.QF() && this.bBd.dX(QG);
                            for (i = 0; i < com_fossil_bsx.bEx.length; i++) {
                                com_fossil_bsx.bEx[i] = (bsy) ((Pair) subList.get(i)).first;
                                arrayList.add((Long) ((Pair) subList.get(i)).second);
                                com_fossil_bsx.bEx[i].bEO = Long.valueOf(bnm.Pr());
                                com_fossil_bsx.bEx[i].bEC = Long.valueOf(currentTimeMillis);
                                com_fossil_bsx.bEx[i].bEU = Boolean.valueOf(bnm.Qh());
                                if (!z2) {
                                    com_fossil_bsx.bEx[i].bFb = null;
                                }
                            }
                            Object a = Pf().ig(2) ? Pa().m5429a(com_fossil_bsx) : null;
                            byte[] b = Pb().m5604b(com_fossil_bsx);
                            Qs = bnm.Qs();
                            URL url = new URL(Qs);
                            if (arrayList.isEmpty()) {
                                z = false;
                            }
                            awa.aY(z);
                            if (this.bBF != null) {
                                Pf().Rc().log("Set uploading progress before finishing the previous upload");
                            } else {
                                this.bBF = new ArrayList(arrayList);
                            }
                            Pg().bzY.set(currentTimeMillis);
                            aj = "?";
                            if (com_fossil_bsx.bEx.length > 0) {
                                aj = com_fossil_bsx.bEx[0].bEM;
                            }
                            Pf().Ri().m5438a("Uploading data. app, uncompressed size, data", aj, Integer.valueOf(b.length), a);
                            this.bBM = true;
                            RG().m5444a(QG, url, b, null, new bpn(this));
                        }
                    }
                    this.bBN = false;
                    RS();
                } else {
                    Pf().Ri().log("Network not connected, ignoring upload request");
                    RO();
                    this.bBN = false;
                    RS();
                }
            }
        } catch (MalformedURLException e) {
            Pf().Rc().m5437a("Failed to parse upload URL. Not uploading. appId", bol.ei(QG), Qs);
        } catch (Throwable th) {
            this.bBN = false;
            RS();
        }
    }

    final void RP() {
        this.bBI++;
    }

    final void RQ() {
        Pe().OP();
        RA();
        if (!this.bBA) {
            Pf().Rg().log("This instance being marked as an uploader");
            Pe().OP();
            RA();
            if (RR() && RJ()) {
                int a = m5475a(this.bBE);
                int Ra = OT().Ra();
                Pe().OP();
                if (a > Ra) {
                    Pf().Rc().m5437a("Panic: can't downgrade version. Previous, current version", Integer.valueOf(a), Integer.valueOf(Ra));
                } else if (a < Ra) {
                    if (m5479a(Ra, this.bBE)) {
                        Pf().Ri().m5437a("Storage version upgraded. Previous, current version", Integer.valueOf(a), Integer.valueOf(Ra));
                    } else {
                        Pf().Rc().m5437a("Storage version upgrade failed. Previous, current version", Integer.valueOf(a), Integer.valueOf(Ra));
                    }
                }
            }
            this.bBA = true;
            RO();
        }
    }

    protected final void m5485a(int i, Throwable th, byte[] bArr) {
        Pe().OP();
        RA();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.bBM = false;
                RS();
            }
        }
        List<Long> list = this.bBF;
        this.bBF = null;
        if ((i == MFNetworkReturnCode.RESPONSE_OK || i == 204) && th == null) {
            try {
                Pg().bzX.set(this.bBq.currentTimeMillis());
                Pg().bzY.set(0);
                RO();
                Pf().Ri().m5437a("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                OZ().beginTransaction();
                bnn OZ;
                try {
                    for (Long l : list) {
                        OZ = OZ();
                        long longValue = l.longValue();
                        OZ.OP();
                        OZ.RA();
                        if (OZ.getWritableDatabase().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                            throw new SQLiteException("Deleted fewer rows from queue than expected");
                        }
                    }
                    OZ().setTransactionSuccessful();
                    OZ().endTransaction();
                    if (RG().Rk() && RN()) {
                        RM();
                    } else {
                        this.bBJ = -1;
                        RO();
                    }
                    this.bBK = 0;
                } catch (SQLiteException e) {
                    OZ.Pf().Rc().m5439d("Failed to delete a bundle in a queue table", e);
                    throw e;
                } catch (Throwable th3) {
                    OZ().endTransaction();
                }
            } catch (SQLiteException e2) {
                Pf().Rc().m5439d("Database error while trying to delete uploaded bundles", e2);
                this.bBK = this.bBq.elapsedRealtime();
                Pf().Ri().m5439d("Disable upload, time", Long.valueOf(this.bBK));
            }
        } else {
            Pf().Ri().m5437a("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            Pg().bzY.set(this.bBq.currentTimeMillis());
            boolean z = i == 503 || i == MFNetworkReturnCode.RATE_LIMIT_EXEEDED;
            if (z) {
                Pg().bzZ.set(this.bBq.currentTimeMillis());
            }
            RO();
        }
        this.bBM = false;
        RS();
    }

    public final byte[] m5486a(bnz com_fossil_bnz, String str) {
        RA();
        Pe().OP();
        OM();
        awa.bO(com_fossil_bnz);
        awa.df(str);
        bsx com_fossil_bsx = new bsx();
        OZ().beginTransaction();
        try {
            bng dZ = OZ().dZ(str);
            byte[] bArr;
            if (dZ == null) {
                Pf().Rh().m5439d("Log and bundle not available. package_name", str);
                bArr = new byte[0];
                return bArr;
            } else if (dZ.Pt()) {
                long j;
                bsy com_fossil_bsy = new bsy();
                com_fossil_bsx.bEx = new bsy[]{com_fossil_bsy};
                com_fossil_bsy.bEz = Integer.valueOf(1);
                com_fossil_bsy.bEH = "android";
                com_fossil_bsy.bEM = dZ.Pj();
                com_fossil_bsy.bxr = dZ.Pq();
                com_fossil_bsy.bpS = dZ.Po();
                long Pp = dZ.Pp();
                com_fossil_bsy.bEW = Pp == -2147483648L ? null : Integer.valueOf((int) Pp);
                com_fossil_bsy.bEN = Long.valueOf(dZ.Pr());
                com_fossil_bsy.bxq = dZ.getGmpAppId();
                com_fossil_bsy.bES = Long.valueOf(dZ.Ps());
                if (isEnabled() && bnm.QF() && this.bBd.dX(com_fossil_bsy.bEM)) {
                    OT();
                    com_fossil_bsy.bFb = null;
                }
                Pair ek = Pg().ek(dZ.Pj());
                if (!(ek == null || TextUtils.isEmpty((CharSequence) ek.first))) {
                    com_fossil_bsy.bEP = (String) ek.first;
                    com_fossil_bsy.bEQ = (Boolean) ek.second;
                }
                OU().RA();
                com_fossil_bsy.bEJ = Build.MODEL;
                OU().RA();
                com_fossil_bsy.bEI = VERSION.RELEASE;
                com_fossil_bsy.bEL = Integer.valueOf((int) OU().QV());
                com_fossil_bsy.bEK = OU().QW();
                com_fossil_bsy.bER = dZ.getAppInstanceId();
                com_fossil_bsy.bxy = dZ.Pl();
                List dY = OZ().dY(dZ.Pj());
                com_fossil_bsy.bEB = new bta[dY.size()];
                for (int i = 0; i < dY.size(); i++) {
                    bta com_fossil_bta = new bta();
                    com_fossil_bsy.bEB[i] = com_fossil_bta;
                    com_fossil_bta.name = ((bsj) dY.get(i)).mName;
                    com_fossil_bta.bFf = Long.valueOf(((bsj) dY.get(i)).bDy);
                    Pb().m5601a(com_fossil_bta, ((bsj) dY.get(i)).mValue);
                }
                Bundle QY = com_fossil_bnz.byq.QY();
                if ("_iap".equals(com_fossil_bnz.name)) {
                    QY.putLong("_c", 1);
                    Pf().Rh().log("Marking in-app purchase as real-time");
                    QY.putLong("_r", 1);
                }
                QY.putString("_o", com_fossil_bnz.bxC);
                if (Pb().eJ(com_fossil_bsy.bEM)) {
                    Pb().m5599a(QY, "_dbg", Long.valueOf(1));
                    Pb().m5599a(QY, "_r", Long.valueOf(1));
                }
                bnv R = OZ().m5349R(str, com_fossil_bnz.name);
                if (R == null) {
                    OZ().m5360a(new bnv(str, com_fossil_bnz.name, 1, 0, com_fossil_bnz.byr));
                    j = 0;
                } else {
                    j = R.bym;
                    OZ().m5360a(R.al(com_fossil_bnz.byr).QX());
                }
                bnu com_fossil_bnu = new bnu(this, com_fossil_bnz.bxC, str, com_fossil_bnz.name, com_fossil_bnz.byr, j, QY);
                bsv com_fossil_bsv = new bsv();
                com_fossil_bsy.bEA = new bsv[]{com_fossil_bsv};
                com_fossil_bsv.bEt = Long.valueOf(com_fossil_bnu.byh);
                com_fossil_bsv.name = com_fossil_bnu.mName;
                com_fossil_bsv.bEu = Long.valueOf(com_fossil_bnu.byi);
                com_fossil_bsv.bEs = new bsw[com_fossil_bnu.byj.size()];
                Iterator it = com_fossil_bnu.byj.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    bsw com_fossil_bsw = new bsw();
                    int i3 = i2 + 1;
                    com_fossil_bsv.bEs[i2] = com_fossil_bsw;
                    com_fossil_bsw.name = str2;
                    Pb().m5600a(com_fossil_bsw, com_fossil_bnu.byj.get(str2));
                    i2 = i3;
                }
                com_fossil_bsy.bEV = m5480a(dZ.Pj(), com_fossil_bsy.bEB, com_fossil_bsy.bEA);
                com_fossil_bsy.bED = com_fossil_bsv.bEt;
                com_fossil_bsy.bEE = com_fossil_bsv.bEt;
                Pp = dZ.Pn();
                com_fossil_bsy.bEG = Pp != 0 ? Long.valueOf(Pp) : null;
                long Pm = dZ.Pm();
                if (Pm != 0) {
                    Pp = Pm;
                }
                com_fossil_bsy.bEF = Pp != 0 ? Long.valueOf(Pp) : null;
                dZ.Px();
                com_fossil_bsy.bET = Integer.valueOf((int) dZ.Pu());
                com_fossil_bsy.bEO = Long.valueOf(bnm.Pr());
                com_fossil_bsy.bEC = Long.valueOf(this.bBq.currentTimeMillis());
                com_fossil_bsy.bEU = Boolean.TRUE;
                dZ.m5318U(com_fossil_bsy.bED.longValue());
                dZ.m5319V(com_fossil_bsy.bEE.longValue());
                OZ().m5359a(dZ);
                OZ().setTransactionSuccessful();
                OZ().endTransaction();
                try {
                    bArr = new byte[com_fossil_bsx.MW()];
                    bci h = bci.m4843h(bArr, 0, bArr.length);
                    com_fossil_bsx.mo1264a(h);
                    h.MQ();
                    return Pb().ai(bArr);
                } catch (IOException e) {
                    Pf().Rc().m5437a("Data loss. Failed to bundle and serialize. appId", bol.ei(str), e);
                    return null;
                }
            } else {
                Pf().Rh().m5439d("Log and bundle disabled. package_name", str);
                bArr = new byte[0];
                OZ().endTransaction();
                return bArr;
            }
        } finally {
            OZ().endTransaction();
        }
    }

    final void m5487b(bnk com_fossil_bnk, bnh com_fossil_bnh) {
        boolean z = true;
        awa.bO(com_fossil_bnk);
        awa.df(com_fossil_bnk.packageName);
        awa.bO(com_fossil_bnk.bxC);
        awa.bO(com_fossil_bnk.bxD);
        awa.df(com_fossil_bnk.bxD.name);
        Pe().OP();
        RA();
        if (!TextUtils.isEmpty(com_fossil_bnh.bxq)) {
            if (com_fossil_bnh.bxv) {
                bnk com_fossil_bnk2 = new bnk(com_fossil_bnk);
                com_fossil_bnk2.bxF = false;
                OZ().beginTransaction();
                try {
                    bnk U = OZ().m5352U(com_fossil_bnk2.packageName, com_fossil_bnk2.bxD.name);
                    if (!(U == null || U.bxC.equals(com_fossil_bnk2.bxC))) {
                        Pf().Re().m5438a("Updating a conditional user property with different origin. name, origin, origin (from DB)", Pa().eh(com_fossil_bnk2.bxD.name), com_fossil_bnk2.bxC, U.bxC);
                    }
                    if (U != null && U.bxF) {
                        com_fossil_bnk2.bxC = U.bxC;
                        com_fossil_bnk2.bxE = U.bxE;
                        com_fossil_bnk2.bxI = U.bxI;
                        com_fossil_bnk2.bxG = U.bxG;
                        com_fossil_bnk2.bxJ = U.bxJ;
                        com_fossil_bnk2.bxF = U.bxF;
                        com_fossil_bnk2.bxD = new bsh(com_fossil_bnk2.bxD.name, U.bxD.bDu, com_fossil_bnk2.bxD.getValue(), U.bxD.bxC);
                        z = false;
                    } else if (TextUtils.isEmpty(com_fossil_bnk2.bxG)) {
                        com_fossil_bnk2.bxD = new bsh(com_fossil_bnk2.bxD.name, com_fossil_bnk2.bxE, com_fossil_bnk2.bxD.getValue(), com_fossil_bnk2.bxD.bxC);
                        com_fossil_bnk2.bxF = true;
                    } else {
                        z = false;
                    }
                    if (com_fossil_bnk2.bxF) {
                        bsh com_fossil_bsh = com_fossil_bnk2.bxD;
                        bsj com_fossil_bsj = new bsj(com_fossil_bnk2.packageName, com_fossil_bnk2.bxC, com_fossil_bsh.name, com_fossil_bsh.bDu, com_fossil_bsh.getValue());
                        if (OZ().m5364a(com_fossil_bsj)) {
                            Pf().Rh().m5438a("User property updated immediately", com_fossil_bnk2.packageName, Pa().eh(com_fossil_bsj.mName), com_fossil_bsj.mValue);
                        } else {
                            Pf().Rc().m5438a("(2)Too many active user properties, ignoring", bol.ei(com_fossil_bnk2.packageName), Pa().eh(com_fossil_bsj.mName), com_fossil_bsj.mValue);
                        }
                        if (z && com_fossil_bnk2.bxJ != null) {
                            m5482c(new bnz(com_fossil_bnk2.bxJ, com_fossil_bnk2.bxE), com_fossil_bnh);
                        }
                    }
                    if (OZ().m5362a(com_fossil_bnk2)) {
                        Pf().Rh().m5438a("Conditional property added", com_fossil_bnk2.packageName, Pa().eh(com_fossil_bnk2.bxD.name), com_fossil_bnk2.bxD.getValue());
                    } else {
                        Pf().Rc().m5438a("Too many conditional properties, ignoring", bol.ei(com_fossil_bnk2.packageName), Pa().eh(com_fossil_bnk2.bxD.name), com_fossil_bnk2.bxD.getValue());
                    }
                    OZ().setTransactionSuccessful();
                } finally {
                    OZ().endTransaction();
                }
            } else {
                m5483f(com_fossil_bnh);
            }
        }
    }

    final void m5488b(bnz com_fossil_bnz, bnh com_fossil_bnh) {
        awa.bO(com_fossil_bnh);
        awa.df(com_fossil_bnh.packageName);
        Pe().OP();
        RA();
        String str = com_fossil_bnh.packageName;
        long j = com_fossil_bnz.byr;
        Pb();
        if (!bsk.m5591d(com_fossil_bnz, com_fossil_bnh)) {
            return;
        }
        if (com_fossil_bnh.bxv) {
            OZ().beginTransaction();
            try {
                List emptyList;
                Object obj;
                bnn OZ = OZ();
                awa.df(str);
                OZ.OP();
                OZ.RA();
                if (j < 0) {
                    OZ.Pf().Re().m5437a("Invalid time querying timed out conditional properties", bol.ei(str), Long.valueOf(j));
                    emptyList = Collections.emptyList();
                } else {
                    emptyList = OZ.m5366c("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j)});
                }
                for (bnk com_fossil_bnk : r2) {
                    if (com_fossil_bnk != null) {
                        Pf().Rh().m5438a("User property timed out", com_fossil_bnk.packageName, Pa().eh(com_fossil_bnk.bxD.name), com_fossil_bnk.bxD.getValue());
                        if (com_fossil_bnk.bxH != null) {
                            m5482c(new bnz(com_fossil_bnk.bxH, j), com_fossil_bnh);
                        }
                        OZ().m5353V(str, com_fossil_bnk.bxD.name);
                    }
                }
                OZ = OZ();
                awa.df(str);
                OZ.OP();
                OZ.RA();
                if (j < 0) {
                    OZ.Pf().Re().m5437a("Invalid time querying expired conditional properties", bol.ei(str), Long.valueOf(j));
                    emptyList = Collections.emptyList();
                } else {
                    emptyList = OZ.m5366c("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j)});
                }
                List arrayList = new ArrayList(r2.size());
                for (bnk com_fossil_bnk2 : r2) {
                    if (com_fossil_bnk2 != null) {
                        Pf().Rh().m5438a("User property expired", com_fossil_bnk2.packageName, Pa().eh(com_fossil_bnk2.bxD.name), com_fossil_bnk2.bxD.getValue());
                        OZ().m5350S(str, com_fossil_bnk2.bxD.name);
                        if (com_fossil_bnk2.bxL != null) {
                            arrayList.add(com_fossil_bnk2.bxL);
                        }
                        OZ().m5353V(str, com_fossil_bnk2.bxD.name);
                    }
                }
                ArrayList arrayList2 = (ArrayList) arrayList;
                int size = arrayList2.size();
                int i = 0;
                while (i < size) {
                    obj = arrayList2.get(i);
                    i++;
                    m5482c(new bnz((bnz) obj, j), com_fossil_bnh);
                }
                OZ = OZ();
                String str2 = com_fossil_bnz.name;
                awa.df(str);
                awa.df(str2);
                OZ.OP();
                OZ.RA();
                if (j < 0) {
                    OZ.Pf().Re().m5438a("Invalid time querying triggered conditional properties", bol.ei(str), OZ.Pa().ef(str2), Long.valueOf(j));
                    emptyList = Collections.emptyList();
                } else {
                    emptyList = OZ.m5366c("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j)});
                }
                List arrayList3 = new ArrayList(r2.size());
                for (bnk com_fossil_bnk3 : r2) {
                    if (com_fossil_bnk3 != null) {
                        bsh com_fossil_bsh = com_fossil_bnk3.bxD;
                        bsj com_fossil_bsj = new bsj(com_fossil_bnk3.packageName, com_fossil_bnk3.bxC, com_fossil_bsh.name, j, com_fossil_bsh.getValue());
                        if (OZ().m5364a(com_fossil_bsj)) {
                            Pf().Rh().m5438a("User property triggered", com_fossil_bnk3.packageName, Pa().eh(com_fossil_bsj.mName), com_fossil_bsj.mValue);
                        } else {
                            Pf().Rc().m5438a("Too many active user properties, ignoring", bol.ei(com_fossil_bnk3.packageName), Pa().eh(com_fossil_bsj.mName), com_fossil_bsj.mValue);
                        }
                        if (com_fossil_bnk3.bxJ != null) {
                            arrayList3.add(com_fossil_bnk3.bxJ);
                        }
                        com_fossil_bnk3.bxD = new bsh(com_fossil_bsj);
                        com_fossil_bnk3.bxF = true;
                        OZ().m5362a(com_fossil_bnk3);
                    }
                }
                m5482c(com_fossil_bnz, com_fossil_bnh);
                arrayList2 = (ArrayList) arrayList3;
                int size2 = arrayList2.size();
                i = 0;
                while (i < size2) {
                    obj = arrayList2.get(i);
                    i++;
                    m5482c(new bnz((bnz) obj, j), com_fossil_bnh);
                }
                OZ().setTransactionSuccessful();
            } finally {
                OZ().endTransaction();
            }
        } else {
            m5483f(com_fossil_bnh);
        }
    }

    final void m5489b(bnz com_fossil_bnz, String str) {
        bng dZ = OZ().dZ(str);
        if (dZ == null || TextUtils.isEmpty(dZ.Po())) {
            Pf().Rh().m5439d("No app data available; dropping event", str);
            return;
        }
        try {
            String str2 = bje.aQ(this.mContext).getPackageInfo(str, 0).versionName;
            if (!(dZ.Po() == null || dZ.Po().equals(str2))) {
                Pf().Re().m5439d("App version does not match; dropping event. appId", bol.ei(str));
                return;
            }
        } catch (NameNotFoundException e) {
            if (!"_ui".equals(com_fossil_bnz.name)) {
                Pf().Re().m5439d("Could not find package. appId", bol.ei(str));
            }
        }
        bnz com_fossil_bnz2 = com_fossil_bnz;
        m5488b(com_fossil_bnz2, new bnh(str, dZ.getGmpAppId(), dZ.Po(), dZ.Pp(), dZ.Pq(), dZ.Pr(), dZ.Ps(), null, dZ.Pt(), false, dZ.Pl(), dZ.PG(), 0, 0));
    }

    final void m5490b(bqi com_fossil_bqi) {
        this.bBH++;
    }

    final void m5491b(bsh com_fossil_bsh, bnh com_fossil_bnh) {
        int i = 0;
        Pe().OP();
        RA();
        if (!TextUtils.isEmpty(com_fossil_bnh.bxq)) {
            if (com_fossil_bnh.bxv) {
                int eB = Pb().eB(com_fossil_bsh.name);
                String a;
                if (eB != 0) {
                    Pb();
                    a = bsk.m5581a(com_fossil_bsh.name, bnm.PL(), true);
                    if (com_fossil_bsh.name != null) {
                        i = com_fossil_bsh.name.length();
                    }
                    Pb().m5602a(com_fossil_bnh.packageName, eB, "_ev", a, i);
                    return;
                }
                eB = Pb().m5607f(com_fossil_bsh.name, com_fossil_bsh.getValue());
                if (eB != 0) {
                    Pb();
                    a = bsk.m5581a(com_fossil_bsh.name, bnm.PL(), true);
                    Object value = com_fossil_bsh.getValue();
                    if (value != null && ((value instanceof String) || (value instanceof CharSequence))) {
                        i = String.valueOf(value).length();
                    }
                    Pb().m5602a(com_fossil_bnh.packageName, eB, "_ev", a, i);
                    return;
                }
                Object g = Pb().m5608g(com_fossil_bsh.name, com_fossil_bsh.getValue());
                if (g != null) {
                    bsj com_fossil_bsj = new bsj(com_fossil_bnh.packageName, com_fossil_bsh.bxC, com_fossil_bsh.name, com_fossil_bsh.bDu, g);
                    Pf().Rh().m5437a("Setting user property", Pa().eh(com_fossil_bsj.mName), g);
                    OZ().beginTransaction();
                    try {
                        m5483f(com_fossil_bnh);
                        boolean a2 = OZ().m5364a(com_fossil_bsj);
                        OZ().setTransactionSuccessful();
                        if (a2) {
                            Pf().Rh().m5437a("User property set", Pa().eh(com_fossil_bsj.mName), com_fossil_bsj.mValue);
                        } else {
                            Pf().Rc().m5437a("Too many unique user properties are set. Ignoring user property", Pa().eh(com_fossil_bsj.mName), com_fossil_bsj.mValue);
                            Pb().m5602a(com_fossil_bnh.packageName, 9, null, null, 0);
                        }
                        OZ().endTransaction();
                        return;
                    } catch (Throwable th) {
                        OZ().endTransaction();
                    }
                } else {
                    return;
                }
            }
            m5483f(com_fossil_bnh);
        }
    }

    final void m5492b(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        boolean z = true;
        Pe().OP();
        RA();
        awa.df(str);
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.bBL = false;
                RS();
            }
        }
        Pf().Ri().m5439d("onConfigFetched. Response size", Integer.valueOf(bArr.length));
        OZ().beginTransaction();
        bng dZ = OZ().dZ(str);
        boolean z2 = (i == MFNetworkReturnCode.RESPONSE_OK || i == 204 || i == 304) && th == null;
        if (dZ == null) {
            Pf().Re().m5439d("App does not exist in onConfigFetched. appId", bol.ei(str));
        } else if (z2 || i == 404) {
            List list = map != null ? (List) map.get("Last-Modified") : null;
            String str2 = (list == null || list.size() <= 0) ? null : (String) list.get(0);
            if (i == 404 || i == 304) {
                if (Pc().eq(str) == null && !Pc().m5458a(str, null, null)) {
                    OZ().endTransaction();
                    this.bBL = false;
                    RS();
                    return;
                }
            } else if (!Pc().m5458a(str, bArr, str2)) {
                OZ().endTransaction();
                this.bBL = false;
                RS();
                return;
            }
            dZ.aa(this.bBq.currentTimeMillis());
            OZ().m5359a(dZ);
            if (i == 404) {
                Pf().Rf().m5439d("Config not found. Using empty config. appId", str);
            } else {
                Pf().Ri().m5437a("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
            }
            if (RG().Rk() && RN()) {
                RM();
            } else {
                RO();
            }
        } else {
            dZ.ab(this.bBq.currentTimeMillis());
            OZ().m5359a(dZ);
            Pf().Ri().m5437a("Fetching config failed. code, error", Integer.valueOf(i), th);
            Pc().es(str);
            Pg().bzY.set(this.bBq.currentTimeMillis());
            if (!(i == 503 || i == MFNetworkReturnCode.RATE_LIMIT_EXEEDED)) {
                z = false;
            }
            if (z) {
                Pg().bzZ.set(this.bBq.currentTimeMillis());
            }
            RO();
        }
        OZ().setTransactionSuccessful();
        OZ().endTransaction();
        this.bBL = false;
        RS();
    }

    public final void bf(boolean z) {
        RO();
    }

    final void m5493c(bnk com_fossil_bnk, bnh com_fossil_bnh) {
        awa.bO(com_fossil_bnk);
        awa.df(com_fossil_bnk.packageName);
        awa.bO(com_fossil_bnk.bxD);
        awa.df(com_fossil_bnk.bxD.name);
        Pe().OP();
        RA();
        if (!TextUtils.isEmpty(com_fossil_bnh.bxq)) {
            if (com_fossil_bnh.bxv) {
                OZ().beginTransaction();
                try {
                    m5483f(com_fossil_bnh);
                    bnk U = OZ().m5352U(com_fossil_bnk.packageName, com_fossil_bnk.bxD.name);
                    if (U != null) {
                        Pf().Rh().m5437a("Removing conditional user property", com_fossil_bnk.packageName, Pa().eh(com_fossil_bnk.bxD.name));
                        OZ().m5353V(com_fossil_bnk.packageName, com_fossil_bnk.bxD.name);
                        if (U.bxF) {
                            OZ().m5350S(com_fossil_bnk.packageName, com_fossil_bnk.bxD.name);
                        }
                        if (com_fossil_bnk.bxL != null) {
                            Bundle bundle = null;
                            if (com_fossil_bnk.bxL.byq != null) {
                                bundle = com_fossil_bnk.bxL.byq.QY();
                            }
                            m5482c(Pb().m5597a(com_fossil_bnk.bxL.name, bundle, U.bxC, com_fossil_bnk.bxL.byr, true, false), com_fossil_bnh);
                        }
                    } else {
                        Pf().Re().m5437a("Conditional user property doesn't exist", bol.ei(com_fossil_bnk.packageName), Pa().eh(com_fossil_bnk.bxD.name));
                    }
                    OZ().setTransactionSuccessful();
                } finally {
                    OZ().endTransaction();
                }
            } else {
                m5483f(com_fossil_bnh);
            }
        }
    }

    final void m5494c(bsh com_fossil_bsh, bnh com_fossil_bnh) {
        Pe().OP();
        RA();
        if (!TextUtils.isEmpty(com_fossil_bnh.bxq)) {
            if (com_fossil_bnh.bxv) {
                Pf().Rh().m5439d("Removing user property", Pa().eh(com_fossil_bsh.name));
                OZ().beginTransaction();
                try {
                    m5483f(com_fossil_bnh);
                    OZ().m5350S(com_fossil_bnh.packageName, com_fossil_bsh.name);
                    OZ().setTransactionSuccessful();
                    Pf().Rh().m5439d("User property removed", Pa().eh(com_fossil_bsh.name));
                } finally {
                    OZ().endTransaction();
                }
            } else {
                m5483f(com_fossil_bnh);
            }
        }
    }

    final void m5495d(bnh com_fossil_bnh) {
        Pe().OP();
        RA();
        awa.df(com_fossil_bnh.packageName);
        m5483f(com_fossil_bnh);
    }

    final void m5496d(bnk com_fossil_bnk) {
        bnh eu = eu(com_fossil_bnk.packageName);
        if (eu != null) {
            m5487b(com_fossil_bnk, eu);
        }
    }

    public final void m5497e(bnh com_fossil_bnh) {
        Pe().OP();
        RA();
        awa.bO(com_fossil_bnh);
        awa.df(com_fossil_bnh.packageName);
        if (!TextUtils.isEmpty(com_fossil_bnh.bxq)) {
            bng dZ = OZ().dZ(com_fossil_bnh.packageName);
            if (!(dZ == null || !TextUtils.isEmpty(dZ.getGmpAppId()) || TextUtils.isEmpty(com_fossil_bnh.bxq))) {
                dZ.aa(0);
                OZ().m5359a(dZ);
                Pc().et(com_fossil_bnh.packageName);
            }
            if (com_fossil_bnh.bxv) {
                int i;
                Bundle bundle;
                long j = com_fossil_bnh.bxA;
                if (j == 0) {
                    j = this.bBq.currentTimeMillis();
                }
                int i2 = com_fossil_bnh.bxB;
                if (i2 == 0 || i2 == 1) {
                    i = i2;
                } else {
                    Pf().Re().m5437a("Incorrect app type, assuming installed app. appId, appType", bol.ei(com_fossil_bnh.packageName), Integer.valueOf(i2));
                    i = 0;
                }
                OZ().beginTransaction();
                bnn OZ;
                String Pj;
                try {
                    dZ = OZ().dZ(com_fossil_bnh.packageName);
                    if (!(dZ == null || dZ.getGmpAppId() == null || dZ.getGmpAppId().equals(com_fossil_bnh.bxq))) {
                        Pf().Re().m5439d("New GMP App Id passed in. Removing cached database data. appId", bol.ei(dZ.Pj()));
                        OZ = OZ();
                        Pj = dZ.Pj();
                        OZ.RA();
                        OZ.OP();
                        awa.df(Pj);
                        SQLiteDatabase writableDatabase = OZ.getWritableDatabase();
                        String[] strArr = new String[]{Pj};
                        i2 = writableDatabase.delete("audience_filter_values", "app_id=?", strArr) + ((((((((writableDatabase.delete("events", "app_id=?", strArr) + 0) + writableDatabase.delete("user_attributes", "app_id=?", strArr)) + writableDatabase.delete("conditional_properties", "app_id=?", strArr)) + writableDatabase.delete("apps", "app_id=?", strArr)) + writableDatabase.delete("raw_events", "app_id=?", strArr)) + writableDatabase.delete("raw_events_metadata", "app_id=?", strArr)) + writableDatabase.delete("event_filters", "app_id=?", strArr)) + writableDatabase.delete("property_filters", "app_id=?", strArr));
                        if (i2 > 0) {
                            OZ.Pf().Ri().m5437a("Deleted application data. app, records", Pj, Integer.valueOf(i2));
                        }
                        dZ = null;
                    }
                } catch (SQLiteException e) {
                    OZ.Pf().Rc().m5437a("Error deleting application data. appId, error", bol.ei(Pj), e);
                } catch (Throwable th) {
                    OZ().endTransaction();
                }
                if (dZ != null) {
                    if (!(dZ.Po() == null || dZ.Po().equals(com_fossil_bnh.bpS))) {
                        bundle = new Bundle();
                        bundle.putString("_pv", dZ.Po());
                        m5488b(new bnz("_au", new bnw(bundle), "auto", j), com_fossil_bnh);
                    }
                }
                m5483f(com_fossil_bnh);
                bnv com_fossil_bnv = null;
                if (i == 0) {
                    com_fossil_bnv = OZ().m5349R(com_fossil_bnh.packageName, "_f");
                } else if (i == 1) {
                    com_fossil_bnv = OZ().m5349R(com_fossil_bnh.packageName, "_v");
                }
                if (com_fossil_bnv == null) {
                    long j2 = (1 + (j / 3600000)) * 3600000;
                    if (i == 0) {
                        m5491b(new bsh("_fot", j, Long.valueOf(j2), "auto"), com_fossil_bnh);
                        Pe().OP();
                        RA();
                        Bundle bundle2 = new Bundle();
                        bundle2.putLong("_c", 1);
                        bundle2.putLong("_r", 1);
                        bundle2.putLong("_uwa", 0);
                        bundle2.putLong("_pfo", 0);
                        bundle2.putLong("_sys", 0);
                        bundle2.putLong("_sysu", 0);
                        if (this.mContext.getPackageManager() == null) {
                            Pf().Rc().m5439d("PackageManager is null, first open report might be inaccurate. appId", bol.ei(com_fossil_bnh.packageName));
                        } else {
                            ApplicationInfo applicationInfo;
                            PackageInfo packageInfo = null;
                            try {
                                packageInfo = bje.aQ(this.mContext).getPackageInfo(com_fossil_bnh.packageName, 0);
                            } catch (NameNotFoundException e2) {
                                Pf().Rc().m5437a("Package info is null, first open report might be inaccurate. appId", bol.ei(com_fossil_bnh.packageName), e2);
                            }
                            if (packageInfo != null) {
                                if (packageInfo.firstInstallTime != 0) {
                                    Object obj = null;
                                    if (packageInfo.firstInstallTime != packageInfo.lastUpdateTime) {
                                        bundle2.putLong("_uwa", 1);
                                    } else {
                                        obj = 1;
                                    }
                                    m5491b(new bsh("_fi", j, Long.valueOf(obj != null ? 1 : 0), "auto"), com_fossil_bnh);
                                }
                            }
                            try {
                                applicationInfo = bje.aQ(this.mContext).getApplicationInfo(com_fossil_bnh.packageName, 0);
                            } catch (NameNotFoundException e22) {
                                Pf().Rc().m5437a("Application info is null, first open report might be inaccurate. appId", bol.ei(com_fossil_bnh.packageName), e22);
                                applicationInfo = null;
                            }
                            if (applicationInfo != null) {
                                if ((applicationInfo.flags & 1) != 0) {
                                    bundle2.putLong("_sys", 1);
                                }
                                if ((applicationInfo.flags & Allocation.USAGE_SHARED) != 0) {
                                    bundle2.putLong("_sysu", 1);
                                }
                            }
                        }
                        bnn OZ2 = OZ();
                        String str = com_fossil_bnh.packageName;
                        awa.df(str);
                        OZ2.OP();
                        OZ2.RA();
                        j2 = OZ2.m5356Y(str, "first_open_count");
                        if (j2 >= 0) {
                            bundle2.putLong("_pfo", j2);
                        }
                        m5488b(new bnz("_f", new bnw(bundle2), "auto", j), com_fossil_bnh);
                    } else if (i == 1) {
                        m5491b(new bsh("_fvt", j, Long.valueOf(j2), "auto"), com_fossil_bnh);
                        Pe().OP();
                        RA();
                        bundle = new Bundle();
                        bundle.putLong("_c", 1);
                        bundle.putLong("_r", 1);
                        m5488b(new bnz("_v", new bnw(bundle), "auto", j), com_fossil_bnh);
                    }
                    bundle = new Bundle();
                    bundle.putLong("_et", 1);
                    m5488b(new bnz("_e", new bnw(bundle), "auto", j), com_fossil_bnh);
                } else if (com_fossil_bnh.bxw) {
                    m5488b(new bnz("_cd", new bnw(new Bundle()), "auto", j), com_fossil_bnh);
                }
                OZ().setTransactionSuccessful();
                OZ().endTransaction();
                return;
            }
            m5483f(com_fossil_bnh);
        }
    }

    final void m5498e(bnk com_fossil_bnk) {
        bnh eu = eu(com_fossil_bnk.packageName);
        if (eu != null) {
            m5493c(com_fossil_bnk, eu);
        }
    }

    public final String ev(String str) {
        Object e;
        try {
            return (String) Pe().m5467d(new bpm(this, str)).get(ShineProfile.LOG_UPLOADING_DELAY, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e2) {
            e = e2;
        } catch (InterruptedException e3) {
            e = e3;
        } catch (ExecutionException e4) {
            e = e4;
        }
        Pf().Rc().m5437a("Failed to get app instance id. appId", bol.ei(str), e);
        return null;
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final boolean isEnabled() {
        boolean z = false;
        Pe().OP();
        RA();
        if (this.bBd.Qj()) {
            return false;
        }
        Boolean dW = this.bBd.dW("firebase_analytics_collection_enabled");
        if (dW != null) {
            z = dW.booleanValue();
        } else if (!bnm.Oi()) {
            z = true;
        }
        return Pg().be(z);
    }

    final void m5499j(Runnable runnable) {
        Pe().OP();
        if (this.bBG == null) {
            this.bBG = new ArrayList();
        }
        this.bBG.add(runnable);
    }

    protected final void start() {
        Pe().OP();
        OZ().QI();
        if (Pg().bzX.get() == 0) {
            Pg().bzX.set(this.bBq.currentTimeMillis());
        }
        if (Long.valueOf(Pg().bAc.get()).longValue() == 0) {
            Pf().Ri().m5439d("Persisting first open", Long.valueOf(this.bBO));
            Pg().bAc.set(this.bBO);
        }
        if (RB()) {
            bnm.Qh();
            if (!TextUtils.isEmpty(OT().getGmpAppId())) {
                String Rn = Pg().Rn();
                if (Rn == null) {
                    Pg().em(OT().getGmpAppId());
                } else if (!Rn.equals(OT().getGmpAppId())) {
                    Pf().Rg().log("Rechecking which service to use due to a GMP App Id change");
                    Pg().Rq();
                    this.bBs.disconnect();
                    this.bBs.RY();
                    Pg().em(OT().getGmpAppId());
                    Pg().bAc.set(this.bBO);
                    Pg().bAd.eo(null);
                }
            }
            OS().en(Pg().bAd.Rv());
            bnm.Qh();
            if (!TextUtils.isEmpty(OT().getGmpAppId())) {
                bqk OS = OS();
                OS.OP();
                OS.ON();
                OS.RA();
                if (OS.zzboe.RB()) {
                    OS.OV().RW();
                    String Rr = OS.Pg().Rr();
                    if (!TextUtils.isEmpty(Rr)) {
                        OS.OU().RA();
                        if (!Rr.equals(VERSION.RELEASE)) {
                            Bundle bundle = new Bundle();
                            bundle.putString("_po", Rr);
                            OS.m5539a("auto", "_ou", bundle);
                        }
                    }
                }
                OV().m5560a(new AtomicReference());
            }
        } else if (isEnabled()) {
            if (!Pb().eH("android.permission.INTERNET")) {
                Pf().Rc().log("App is missing INTERNET permission");
            }
            if (!Pb().eH("android.permission.ACCESS_NETWORK_STATE")) {
                Pf().Rc().log("App is missing ACCESS_NETWORK_STATE permission");
            }
            bnm.Qh();
            if (!bje.aQ(this.mContext).OG()) {
                if (!bpc.m5452f(this.mContext, false)) {
                    Pf().Rc().log("AppMeasurementReceiver not registered/enabled");
                }
                if (!brv.m5573g(this.mContext, false)) {
                    Pf().Rc().log("AppMeasurementService not registered/enabled");
                }
            }
            Pf().Rc().log("Uploading is not possible. App measurement disabled");
        }
        RO();
    }
}
