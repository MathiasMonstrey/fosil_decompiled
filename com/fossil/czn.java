package com.fossil;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.fossil.ckb.C2126d;
import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ctb.C2286a;
import com.fossil.ctb.C2287b;
import com.fossil.cye.C2501a;
import com.fossil.cye.C2502b;
import com.fossil.cye.C2503c;
import com.fossil.cyg.C2505b;
import com.fossil.cyg.C2506c;
import com.fossil.cyg.C2507d;
import com.fossil.cyi.C2510a;
import com.fossil.cyi.C2511b;
import com.fossil.cyi.C2512c;
import com.fossil.cyo.C2523c;
import com.fossil.cyo.C2524a;
import com.fossil.cyo.C2525b;
import com.fossil.cyo.C2526d;
import com.fossil.cyo.C2527e;
import com.fossil.cyy.C2555a;
import com.fossil.cyy.C2556b;
import com.fossil.cyy.C2557c;
import com.fossil.czc.C2562b;
import com.fossil.czc.C2563c;
import com.fossil.czc.C2564d;
import com.fossil.czj.C2567b;
import com.fossil.czj.C2569a;
import com.fossil.dji.C2837a;
import com.fossil.dji.C2838b;
import com.fossil.dji.C2839c;
import com.misfit.frameworks.buttonservice.ble.ScanService;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.buttonservice.model.ShineDevice;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.OwnershipDeviceBox;
import com.portfolio.platform.data.OwnershipDeviceBox.OwnerShip;
import com.portfolio.platform.data.model.DeviceModel;
import com.portfolio.platform.data.model.SKUModel;
import com.portfolio.platform.data.source.DataVersioningRepository;
import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.helper.DeviceHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.parceler.Parcels;

public class czn implements C2569a {
    private static final String TAG = czn.class.getSimpleName();
    private ctb cCN;
    cnr cEF;
    private cye cFF;
    private cyy cFH;
    private int cLh = -1;
    private cyg cMA;
    private boolean cMB = false;
    private C2126d cMC = new C25722(this);
    private final BroadcastReceiver cMD = new C25787(this);
    private C2567b cMr;
    private ShineDevice cMs;
    private List<ShineDevice> cMt = new ArrayList();
    private List<ShineDevice> cMu = new ArrayList();
    private HashMap<String, List<Integer>> cMv = new HashMap();
    private cyo cMw;
    private czc cMx;
    private cyi cMy;
    private dji cMz;
    private DataVersioningRepository czr;
    private Handler mHandler;
    private ckc mUseCaseHandler;
    UserRepository mUserRepository;

    class C25722 implements C2126d<C2526d, C2523c> {
        final /* synthetic */ czn cMF;

        C25722(czn com_fossil_czn) {
            this.cMF = com_fossil_czn;
        }

        public /* synthetic */ void onError(Object obj) {
            m7988a((C2523c) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m7989a((C2526d) obj);
        }

        public void m7989a(C2526d c2526d) {
            MFLogger.m12670d(czn.TAG, "Inside .startPairClosestDevice pairDevice success, isSkipOTA=" + this.cMF.cEF.acD());
            Map il = il(c2526d.ajK().getDeviceId());
            this.cMF.m8024f("pair_success", il);
            if (il.containsKey("Serial_Number") && il.containsKey("Device_Name")) {
                this.cMF.m8025y(il);
            }
            this.cMF.m8020c(c2526d.ajK());
            cnm.abX().m7220a(this.cMF.cMs.getSerial(), 0, CommunicateMode.LINK);
        }

        public void m7988a(C2523c c2523c) {
            MFLogger.m12670d(czn.TAG, "Inside .startPairClosestDevice pairDevice fail with error=" + c2523c.getErrorCode());
            Map il = il(c2523c.getDeviceId());
            if (il.containsKey("Serial_Number") && il.containsKey("Device_Name")) {
                this.cMF.m8024f("pair_fail", il);
            }
            this.cMF.cMr.afM();
            if (c2523c instanceof C2524a) {
                this.cMF.cMr.kn(c2523c.getErrorCode());
            } else if (c2523c instanceof C2527e) {
                this.cMF.cMr.jV(c2523c.getErrorCode());
            }
            switch (c2523c.getErrorCode()) {
                case 601:
                    cnm.abX().m7220a(this.cMF.cMs.getSerial(), FailureCode.NETWORK_ERROR, CommunicateMode.LINK);
                    return;
                case FailureCode.FAILED_TO_CONNECT /*1201*/:
                    cnm.abX().m7220a(this.cMF.cMs.getSerial(), FailureCode.FAILED_TO_CONNECT, CommunicateMode.LINK);
                    return;
                default:
                    cnm.abX().m7220a(this.cMF.cMs.getSerial(), FailureCode.NETWORK_ERROR, CommunicateMode.LINK);
                    return;
            }
        }

        private HashMap<String, String> il(String str) {
            HashMap<String, String> hashMap = new HashMap();
            SKUModel hl = cnq.acd().acp().hl(DeviceHelper.gi(str));
            if (hl != null) {
                hashMap.put("Serial_Number", str);
                hashMap.put("Device_Name", hl.getDeviceName());
            }
            return hashMap;
        }
    }

    class C25765 implements C2126d<C2564d, C2563c> {
        final /* synthetic */ czn cMF;

        C25765(czn com_fossil_czn) {
            this.cMF = com_fossil_czn;
        }

        public /* synthetic */ void onError(Object obj) {
            m7996a((C2563c) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m7997a((C2564d) obj);
        }

        public void m7997a(C2564d c2564d) {
        }

        public void m7996a(C2563c c2563c) {
        }
    }

    class C25787 extends BroadcastReceiver {
        final /* synthetic */ czn cMF;

        C25787(czn com_fossil_czn) {
            this.cMF = com_fossil_czn;
        }

        public void onReceive(Context context, Intent intent) {
            ShineDevice shineDevice = (ShineDevice) Parcels.unwrap(intent.getParcelableExtra(Constants.DEVICE));
            if (shineDevice == null) {
                MFLogger.m12672i(czn.TAG, "scanReceiver - ShineDevice is NULL!!!");
                return;
            }
            String serial = shineDevice.getSerial();
            if (TextUtils.isEmpty(serial)) {
                MFLogger.m12672i(czn.TAG, "scanReceiver - ShineDeviceSerial is NULL!!!");
                return;
            }
            MFLogger.m12670d(czn.TAG, "scanReceiver - receive device serial=" + serial);
            if (DeviceHelper.abH().ga(serial)) {
                int rssi = shineDevice.getRssi();
                for (ShineDevice shineDevice2 : this.cMF.cMt) {
                    Object serial2 = shineDevice2.getSerial();
                    if (!TextUtils.isEmpty(serial2) && serial2.equalsIgnoreCase(serial)) {
                        this.cMF.m8002F(serial, rssi);
                        int c = this.cMF.ik(serial);
                        if (c == Integer.MIN_VALUE) {
                            c = rssi;
                        }
                        shineDevice2.updateRssi(c);
                        this.cMF.cMr.mo2200Z(this.cMF.cMt);
                        return;
                    }
                }
                if (this.cMF.ij(serial) == null) {
                    this.cMF.m8019c(shineDevice);
                }
            }
        }
    }

    class C25798 implements C2126d<C2507d, C2505b> {
        final /* synthetic */ czn cMF;

        C25798(czn com_fossil_czn) {
            this.cMF = com_fossil_czn;
        }

        public /* synthetic */ void onError(Object obj) {
            m8000a((C2505b) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m8001a((C2507d) obj);
        }

        public void m8001a(C2507d c2507d) {
            String deviceId = c2507d.getDeviceId();
            MFLogger.m12670d(czn.TAG, "checkOwnership " + deviceId);
            PortfolioApp.ZQ().m12691a(CommunicateMode.LINK, "", "Check ownership: " + deviceId + " ACCEPTED!!!");
            ShineDevice d = this.cMF.ij(deviceId);
            if (d != null) {
                OwnershipDeviceBox.getInstance().pushDeviceSerial(c2507d.ajN(), deviceId);
                this.cMF.cMt.add(d);
                this.cMF.cMr.mo2200Z(this.cMF.cMt);
            }
        }

        public void m8000a(C2505b c2505b) {
            if (c2505b.ajN() != null) {
                OwnershipDeviceBox.getInstance().pushDeviceSerial(c2505b.ajN(), c2505b.getDeviceId());
            }
            PortfolioApp.ZQ().m12691a(CommunicateMode.LINK, "", "Check ownership: " + c2505b.getDeviceId() + " IGNORED!!!");
        }
    }

    static class C2580a implements Runnable {
        private final WeakReference<czn> cMJ;

        public C2580a(WeakReference<czn> weakReference) {
            this.cMJ = weakReference;
        }

        public void run() {
            if (this.cMJ != null && this.cMJ.get() != null) {
                if (((czn) this.cMJ.get()).cMt.isEmpty()) {
                    ((czn) this.cMJ.get()).cMr.afM();
                    ((czn) this.cMJ.get()).cMr.kn(FailureCode.NO_DEVICE_FOUND);
                    ((czn) this.cMJ.get()).akA();
                    return;
                }
                Collections.sort(((czn) this.cMJ.get()).cMt);
                if (((czn) this.cMJ.get()).cMs == null) {
                    ((czn) this.cMJ.get()).cMs = (ShineDevice) ((czn) this.cMJ.get()).cMt.get(0);
                    ((czn) this.cMJ.get()).akx();
                }
            }
        }
    }

    public czn(C2567b c2567b, ckc com_fossil_ckc, cyo com_fossil_cyo, cyy com_fossil_cyy, czc com_fossil_czc, DataVersioningRepository dataVersioningRepository, cyi com_fossil_cyi, dji com_fossil_dji, cye com_fossil_cye, ctb com_fossil_ctb, cyg com_fossil_cyg) {
        this.cMr = (C2567b) emj.m10873f(c2567b, "scanClosestDeviceView cannot be null!");
        this.cMw = com_fossil_cyo;
        this.mUseCaseHandler = com_fossil_ckc;
        this.cFH = com_fossil_cyy;
        this.cCN = com_fossil_ctb;
        this.cFF = com_fossil_cye;
        this.cMx = com_fossil_czc;
        this.cMy = com_fossil_cyi;
        this.cMz = com_fossil_dji;
        this.cMA = (cyg) emj.m10873f(com_fossil_cyg, "checkOwnershipDeviceUseCase cannot be null!");
        this.czr = dataVersioningRepository;
        this.cMr.cK(this);
    }

    public void ahu() {
        this.cMr.cK(this);
    }

    public void start() {
        OwnershipDeviceBox.getInstance().reset();
        gy.m11536p(PortfolioApp.ZQ()).m11537a(this.cMD, new IntentFilter("SCAN_DEVICE_FOUND"));
        this.cMw.ajd();
        this.mHandler = new Handler(Looper.getMainLooper());
        if (this.cMs != null) {
            this.cMw.m7920a(this.cMs, this.cLh, this.cMC);
            PortfolioApp.ZQ().m12685I(Collections.singletonList(CommunicateMode.LINK));
        }
        this.cMr.akl();
    }

    public void stop() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        stopScan();
        this.cMw.aje();
        gy.m11536p(PortfolioApp.ZQ()).unregisterReceiver(this.cMD);
    }

    public ShineDevice aky() {
        return this.cMs;
    }

    public int akz() {
        return this.cLh;
    }

    public void mo2210a(ShineDevice shineDevice, int i) {
        this.cMs = shineDevice;
        this.cLh = i;
    }

    private void stopScan() {
        try {
            PortfolioApp.ZR().deviceStopScan();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startScan() {
        try {
            PortfolioApp.ZR().deviceStartScan();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void akv() {
        if (this.cMs != null) {
            stopScan();
            final C2525b c2525b = new C2525b(this.cMs.getSerial(), this.cMs.getMacAddress(), 0);
            this.cLh = 0;
            if (OwnershipDeviceBox.getInstance().isOwnBy(OwnerShip.OtherOwn, this.cMs.getSerial())) {
                c2525b.setMode(1);
                this.cLh = 1;
            }
            this.cMr.afL();
            this.czr.clearDeviceDataVersioning();
            this.mUseCaseHandler.m6886a(this.cMz, new C2837a(this.cMs.getSerial()), new C2126d<C2839c, C2838b>(this) {
                final /* synthetic */ czn cMF;

                public /* synthetic */ void onError(Object obj) {
                    m7986a((C2838b) obj);
                }

                public /* synthetic */ void onSuccess(Object obj) {
                    m7987a((C2839c) obj);
                }

                public void m7987a(C2839c c2839c) {
                    MFLogger.m12670d(czn.TAG, "Get device shortcut setting done SUCCESS, start pair device");
                    this.cMF.m8015b(c2525b);
                }

                public void m7986a(C2838b c2838b) {
                    MFLogger.m12670d(czn.TAG, "Get device shortcut setting done FAILED!!, start pair device");
                    this.cMF.m8015b(c2525b);
                }
            });
            PortfolioApp.ZQ().m12685I(Collections.singletonList(CommunicateMode.LINK));
        }
    }

    private void m8015b(C2525b c2525b) {
        PortfolioApp.ZQ().changePendingLogKey(CommunicateMode.LINK, "", CommunicateMode.LINK, c2525b.ajU());
        this.mUseCaseHandler.m6886a(this.cMw, (C2132b) c2525b, this.cMC);
    }

    private void ih(final String str) {
        MFLogger.m12670d(TAG, "Inside .downloadMicroAppVariant serial=" + str);
        this.cEF.m7241a(str, 0, false);
        this.cEF.m7251r(str, true);
        this.mUseCaseHandler.m6886a(this.cCN, new C2286a(str), new C2126d<C2287b, C2131a>(this) {
            final /* synthetic */ czn cMF;

            public /* synthetic */ void onError(Object obj) {
                m7990a((C2131a) obj);
            }

            public /* synthetic */ void onSuccess(Object obj) {
                m7991a((C2287b) obj);
            }

            public void m7991a(C2287b c2287b) {
                MFLogger.m12670d(czn.TAG, "Inside .downloadMicroAppVariant onSuccess" + str);
                this.cMF.cMr.afM();
                this.cMF.cMr.akk();
            }

            public void m7990a(C2131a c2131a) {
                MFLogger.m12670d(czn.TAG, "Inside .downloadMicroAppVariant onError");
                this.cMF.cMr.afM();
                this.cMF.cMr.akk();
            }
        });
    }

    private void m8020c(final DeviceModel deviceModel) {
        MFLogger.m12670d(TAG, "Inside .startCheckFirmware of serial=" + deviceModel + ", model=" + deviceModel.getSku() + ", currentFwVersion=" + deviceModel.getFirmwareRevision());
        this.mUseCaseHandler.m6886a(this.cMy, new C2510a(deviceModel.getSku()), new C2126d<C2512c, C2511b>(this) {
            final /* synthetic */ czn cMF;

            public /* synthetic */ void onError(Object obj) {
                m7994a((C2511b) obj);
            }

            public /* synthetic */ void onSuccess(Object obj) {
                m7995a((C2512c) obj);
            }

            public void m7995a(C2512c c2512c) {
                final String ajP = c2512c.ajP();
                MFLogger.m12670d(czn.TAG, "Inside .startCheckFirmware downloadLatestFw of this device success, latestFwVersion=" + ajP);
                this.cMF.mUseCaseHandler.m6886a(this.cMF.cFF, new C2501a(deviceModel), new C2126d<C2503c, C2502b>(this) {
                    final /* synthetic */ C25754 cMI;

                    public /* synthetic */ void onError(Object obj) {
                        m7992a((C2502b) obj);
                    }

                    public /* synthetic */ void onSuccess(Object obj) {
                        m7993a((C2503c) obj);
                    }

                    public void m7993a(C2503c c2503c) {
                        MFLogger.m12670d(czn.TAG, "Inside .startCheckFirmware error" + c2503c.toString());
                        if (c2503c.ajL()) {
                            this.cMI.cMF.ih(deviceModel.getDeviceId());
                            return;
                        }
                        this.cMI.cMF.m8012a(deviceModel, ajP);
                        this.cMI.cMF.cEF.m7251r(deviceModel.getDeviceId(), false);
                        this.cMI.cMF.cMr.afM();
                        this.cMI.cMF.cMr.akk();
                    }

                    public void m7992a(C2502b c2502b) {
                        MFLogger.m12670d(czn.TAG, "Inside .startCheckFirmware error " + c2502b.toString());
                        this.cMI.cMF.m8012a(deviceModel, ajP);
                        this.cMI.cMF.cEF.m7251r(deviceModel.getDeviceId(), false);
                        this.cMI.cMF.cMr.afM();
                        this.cMI.cMF.cMr.akk();
                    }
                });
            }

            public void m7994a(C2511b c2511b) {
                PortfolioApp.ZQ().fO("");
                this.cMF.ii(deviceModel.getDeviceId());
                this.cMF.cMr.afM();
                this.cMF.cMr.kn(MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            }
        });
    }

    private void m8012a(DeviceModel deviceModel, String str) {
        MFLogger.m12670d(TAG, "Inside .updateFirmware update firmware with latestFW=" + str);
        String deviceId = deviceModel.getDeviceId();
        SKUModel hl = cnq.acd().acp().hl(DeviceHelper.gi(deviceId));
        if (hl != null) {
            Map hashMap = new HashMap();
            hashMap.put("Serial_Number", deviceId);
            hashMap.put("Device_Name", hl.getDeviceName());
            m8024f("ota_start", hashMap);
        }
        this.mUseCaseHandler.m6886a(this.cMx, new C2562b(deviceModel.getDeviceId()), new C25765(this));
    }

    private void ii(final String str) {
        this.mUseCaseHandler.m6886a(this.cFH, new C2555a(str), new C2126d<C2557c, C2556b>(this) {
            final /* synthetic */ czn cMF;

            public /* synthetic */ void onError(Object obj) {
                m7998a((C2556b) obj);
            }

            public /* synthetic */ void onSuccess(Object obj) {
                m7999a((C2557c) obj);
            }

            public void m7999a(C2557c c2557c) {
            }

            public void m7998a(C2556b c2556b) {
                cnq.acd().acp().he(str);
            }
        });
    }

    public void mo2218b(ShineDevice shineDevice) {
        this.cMs = shineDevice;
        this.cMr.mo2201a(this.cMs);
    }

    public void akw() {
        this.cMr.aa(this.cMt);
    }

    public void akx() {
        this.cMr.afM();
        this.cMr.mo2201a(this.cMs);
    }

    private ShineDevice ij(String str) {
        for (ShineDevice shineDevice : this.cMu) {
            if (shineDevice.getSerial().equalsIgnoreCase(str)) {
                return shineDevice;
            }
        }
        return null;
    }

    private void m8019c(ShineDevice shineDevice) {
        if (shineDevice != null) {
            String serial = shineDevice.getSerial();
            MFLogger.m12670d(TAG, "checkOwnership - deviceId=" + serial);
            if (!TextUtils.isEmpty(serial)) {
                PortfolioApp.ZQ().m12691a(CommunicateMode.LINK, "", "Check ownership: " + serial);
                this.cMA = new cyg(this.mUserRepository);
                this.mUseCaseHandler.m6886a(this.cMA, new C2506c(serial), new C25798(this));
                this.cMu.add(shineDevice);
            }
        }
    }

    public void akA() {
        MFLogger.m12670d(TAG, "onCancelLogService()");
        cnm.abX().m7220a("", this.cMt.isEmpty() ? FailureCode.USER_CANCELLED_NO_DEVICE_FOUND : FailureCode.USER_CANCELLED_BUT_USER_DID_NOT_SELECT_ANY_DEVICE, CommunicateMode.LINK);
    }

    public void aix() {
        if (!this.cMB) {
            if (this.cMs == null) {
                this.cMr.afL();
                this.mHandler.postDelayed(new C2580a(new WeakReference(this)), 15000);
            }
            startScan();
        }
    }

    private void m8002F(String str, int i) {
        if (this.cMv.containsKey(str)) {
            List list = (List) this.cMv.get(str);
            if (list.size() < 5) {
                list.add(Integer.valueOf(i));
                return;
            }
            list.remove(0);
            list.add(Integer.valueOf(i));
            return;
        }
        this.cMv.put(str, new LinkedList());
    }

    private int ik(String str) {
        if (!this.cMv.containsKey(str)) {
            return Integer.MIN_VALUE;
        }
        double d = 0.0d;
        List<Integer> list = (List) this.cMv.get(str);
        int i = 0;
        for (Integer num : list) {
            if (num.intValue() == 0) {
                return 0;
            }
            int i2;
            if (num.intValue() == ScanService.RETRIEVE_DEVICE_BOND_RSSI_MARK) {
                i2 = i + 1;
            } else {
                d += (double) num.intValue();
                i2 = i;
            }
            i = i2;
        }
        int size = list.size() - i;
        if (size <= 0) {
            size = 1;
        }
        return (int) (d / ((double) size));
    }

    public void cB(boolean z) {
        this.cMB = z;
    }

    public boolean akD() {
        return this.cMB;
    }

    private void m8024f(String str, Map<String, String> map) {
        cmj.bs(PortfolioApp.ZQ()).m7085e(str, map);
    }

    private void m8025y(Map<String, String> map) {
        cmj.bs(PortfolioApp.ZQ()).m7087w(map);
    }
}
