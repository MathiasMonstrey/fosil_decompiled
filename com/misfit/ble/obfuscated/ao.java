package com.misfit.ble.obfuscated;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Handler;
import com.misfit.ble.obfuscated.bz.C4506a;
import com.misfit.ble.obfuscated.bz.C4507b;
import com.misfit.ble.obfuscated.bz.C4508c;
import com.misfit.ble.obfuscated.ch.C4445a;
import com.misfit.ble.shine.ActionID;
import com.misfit.ble.shine.ShineDevice;
import com.misfit.ble.shine.ShineProfile.State;
import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.ble.util.LogUtils;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.enums.Action.Presenter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public class ao {
    private static final String TAG = LogUtils.m15475b(ao.class);
    private cb fd;
    private bz fe;
    private ArrayList<C4518o> gc;
    private Hashtable<C4451b, ew> gd;
    private ch ge;
    private ScheduledExecutorService gf;
    private Hashtable<ActionID, ScheduledFuture<?>> gg;
    private C4453d gh;
    public final Object gi = new Object();
    private C4568q gj = null;
    private ShineDevice gk = null;
    private C4445a gl = new C44461(this);
    private C4447n gm = new C44482(this);
    private Hashtable<C4451b, C4450a> gn;
    private Handler mHandler;

    class C44461 implements C4445a {
        final /* synthetic */ ao go;

        C44461(ao aoVar) {
            this.go = aoVar;
        }

        public void mo4809a(String str, byte[] bArr) {
            C4563r c = this.go.m14760c("3dda0001-957f-7d4a-34a6-74696673696d");
            if (c != null) {
                C4518o b = c.mo4872b(str);
                if (b != null && b.setValue(bArr) && this.go.m14758b(b)) {
                    return;
                }
            }
            this.go.ge.m15015a(str, 257);
        }

        public void mo4810b(ba baVar, int i, int i2, int i3, int i4) {
            this.go.gh.mo4904a(baVar, i, i2, i3, i4);
        }
    }

    class C44482 implements C4447n {
        final /* synthetic */ ao go;
        private int gp = -1;

        C44482(ao aoVar) {
            this.go = aoVar;
        }

        public void onConnectionStateChange(BluetoothDevice bluetoothDevice, int i, int i2) {
            synchronized (this.go.gi) {
                this.go.gd.clear();
                this.go.gh.mo4908b(i, i2);
            }
        }

        public void mo4811a(int i) {
            List list;
            int i2;
            JSONObject jSONObject = null;
            int i3 = 0;
            if (i == 0) {
                C4563r c = this.go.m14760c("0000180a-0000-1000-8000-00805f9b34fb");
                C4563r c2 = this.go.m14760c("3dda0001-957f-7d4a-34a6-74696673696d");
                if (c == null || c2 == null) {
                    i = Presenter.NEXT;
                    list = null;
                    i2 = 1;
                } else {
                    List list2;
                    int i4;
                    C4518o b = c.mo4872b("00002a26-0000-1000-8000-00805f9b34fb");
                    C4518o b2 = c.mo4872b("00002a24-0000-1000-8000-00805f9b34fb");
                    C4518o b3 = c2.mo4872b("3dda0002-957f-7d4a-34a6-74696673696d");
                    C4518o b4 = c2.mo4872b("3dda0003-957f-7d4a-34a6-74696673696d");
                    C4518o b5 = c2.mo4872b("3dda0004-957f-7d4a-34a6-74696673696d");
                    if (b == null || b2 == null || b3 == null || b4 == null || b5 == null) {
                        i = 300;
                        list2 = null;
                        i4 = 1;
                    } else {
                        list2 = new ArrayList(Arrays.asList(new C4518o[]{b3, b4, b5}));
                        b = c2.mo4872b("3dda0006-957f-7d4a-34a6-74696673696d");
                        if (b != null) {
                            list2.add(b);
                        }
                        C4518o b6 = c2.mo4872b("3dda0007-957f-7d4a-34a6-74696673696d");
                        if (b6 != null) {
                            list2.add(b6);
                        }
                        i4 = 0;
                    }
                    i2 = i4;
                    list = list2;
                }
            } else {
                list = null;
                i3 = 1;
                i2 = 1;
            }
            if (i3 == 0) {
                jSONObject = new JSONObject();
                try {
                    jSONObject.put(Constants.RESULT, i2);
                    jSONObject.put("services", this.go.m14749g(this.go.getServices()));
                    jSONObject.put("status", i);
                } catch (Throwable e) {
                    C4462b.m14831a(e, "");
                }
            }
            this.go.fe.jX = new C4508c(Integer.valueOf(i3), jSONObject);
            if (i2 == 1) {
                this.go.gh.mo4912c(i, 1);
            } else {
                this.go.m14748f(list);
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo4818c(com.misfit.ble.obfuscated.C4518o r7) {
            /*
            r6 = this;
            r0 = r6.go;
            r2 = r0.gi;
            monitor-enter(r2);
            r3 = r7.mo4860h();	 Catch:{ all -> 0x0048 }
            r0 = r6.go;	 Catch:{ all -> 0x0048 }
            r0 = r0.gd;	 Catch:{ all -> 0x0048 }
            r1 = r6.go;	 Catch:{ all -> 0x0048 }
            r1 = r1.m14751n(r3);	 Catch:{ all -> 0x0048 }
            r0 = r0.get(r1);	 Catch:{ all -> 0x0048 }
            r0 = (com.misfit.ble.obfuscated.ew) r0;	 Catch:{ all -> 0x0048 }
            r4 = r7.getValue();	 Catch:{ all -> 0x0048 }
            r1 = com.misfit.ble.obfuscated.gr.m15138c(r3, r4);	 Catch:{ all -> 0x0048 }
            if (r1 == 0) goto L_0x0030;
        L_0x0025:
            r0 = r6.go;	 Catch:{ all -> 0x0048 }
            r0 = r0.gh;	 Catch:{ all -> 0x0048 }
            r0.ay();	 Catch:{ all -> 0x0048 }
            monitor-exit(r2);	 Catch:{ all -> 0x0048 }
        L_0x002f:
            return;
        L_0x0030:
            r1 = 0;
            if (r0 != 0) goto L_0x004b;
        L_0x0033:
            r1 = "onCharacteristicChanged: currentRequest is null";
        L_0x0035:
            if (r1 == 0) goto L_0x006e;
        L_0x0037:
            r0 = com.misfit.ble.obfuscated.aq.m14765b(r3, r4);	 Catch:{ all -> 0x0048 }
            if (r0 == 0) goto L_0x005d;
        L_0x003d:
            r0 = r6.go;	 Catch:{ all -> 0x0048 }
            r0 = r0.gh;	 Catch:{ all -> 0x0048 }
            r0.mo4915g(r4);	 Catch:{ all -> 0x0048 }
        L_0x0046:
            monitor-exit(r2);	 Catch:{ all -> 0x0048 }
            goto L_0x002f;
        L_0x0048:
            r0 = move-exception;
            monitor-exit(r2);	 Catch:{ all -> 0x0048 }
            throw r0;
        L_0x004b:
            r5 = r0.isWaitingForResponse();	 Catch:{ all -> 0x0048 }
            if (r5 != 0) goto L_0x0054;
        L_0x0051:
            r1 = "onCharacteristicChanged: currentRequest does not expecting any response.";
            goto L_0x0035;
        L_0x0054:
            r5 = r0.validateResponse(r3, r4);	 Catch:{ all -> 0x0048 }
            if (r5 == 0) goto L_0x0035;
        L_0x005a:
            r1 = "onCharacteristicChanged: RESPONSE_MISMATCHED";
            goto L_0x0035;
        L_0x005d:
            r0 = r6.go;	 Catch:{ all -> 0x0048 }
            r0 = r0.gh;	 Catch:{ all -> 0x0048 }
            r0.mo4914d(r7);	 Catch:{ all -> 0x0048 }
            r0 = com.misfit.ble.obfuscated.ao.TAG;	 Catch:{ all -> 0x0048 }
            com.misfit.ble.util.LogUtils.m15479l(r0, r1);	 Catch:{ all -> 0x0048 }
            goto L_0x0046;
        L_0x006e:
            r1 = r6.go;	 Catch:{ all -> 0x0048 }
            r1 = r1.gh;	 Catch:{ all -> 0x0048 }
            r5 = 0;
            r1.mo4905a(r0, r5, r4);	 Catch:{ all -> 0x0048 }
            r0.handleResponse(r3, r4);	 Catch:{ all -> 0x0048 }
            r1 = r0.getIsCompleted();	 Catch:{ all -> 0x0048 }
            if (r1 == 0) goto L_0x008b;
        L_0x0081:
            r1 = r6.go;	 Catch:{ all -> 0x0048 }
            r1 = r1.gh;	 Catch:{ all -> 0x0048 }
            r3 = 0;
            r1.mo4911b(r0, r3, r4);	 Catch:{ all -> 0x0048 }
        L_0x008b:
            monitor-exit(r2);	 Catch:{ all -> 0x0048 }
            goto L_0x002f;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.misfit.ble.obfuscated.ao.2.c(com.misfit.ble.obfuscated.o):void");
        }

        public void mo4813a(C4518o c4518o, int i) {
            String h = c4518o.mo4860h();
            if (i != 0) {
                LogUtils.m15479l(ao.TAG, "onCharacteristicRead - characteristic: " + h + ", status: " + i);
            }
            if ("00002a25-0000-1000-8000-00805f9b34fb".equals(h)) {
                if (i == 0) {
                    h = c4518o.getStringValue(0);
                    if (hc.m15172J(h)) {
                        this.go.gh.mo4903a(0, h);
                        return;
                    }
                    LogUtils.m15479l(ao.TAG, "onCharacteristicRead, invalid serial number: \"" + h + "\"");
                    this.go.gh.mo4903a(1, h);
                } else if (i == 5) {
                    this.go.gh.mo4903a(4, null);
                } else if (i != 137 && i != 133) {
                    this.go.gh.mo4903a(1, null);
                } else if (this.gp != 5) {
                    this.go.gh.mo4903a(1, null);
                }
            } else if ("00002a26-0000-1000-8000-00805f9b34fb".equals(h)) {
                if (i == 0) {
                    h = c4518o.getStringValue(0);
                    if (hc.m15173K(h)) {
                        this.go.gh.mo4913c(0, h);
                        return;
                    }
                    LogUtils.m15479l(ao.TAG, "onCharacteristicRead, invalid firmware version: \"" + h + "\"");
                    this.go.gh.mo4903a(1, h);
                    return;
                }
                this.go.gh.mo4913c(1, null);
            } else if (!"00002a24-0000-1000-8000-00805f9b34fb".equals(h)) {
            } else {
                if (i == 0) {
                    h = c4518o.getStringValue(0);
                    if (hc.m15174L(h)) {
                        this.go.gh.mo4909b(0, h);
                        return;
                    }
                    LogUtils.m15479l(ao.TAG, "onCharacteristicRead, invalid model number: \"" + h + "\"");
                    this.go.gh.mo4909b(1, h);
                    return;
                }
                this.go.gh.mo4909b(1, null);
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo4815b(com.misfit.ble.obfuscated.C4518o r7, int r8) {
            /*
            r6 = this;
            r1 = 0;
            r0 = r6.go;
            r2 = r0.gi;
            monitor-enter(r2);
            r0 = r6.go;	 Catch:{ all -> 0x0074 }
            r3 = r7.mo4860h();	 Catch:{ all -> 0x0074 }
            r3 = r0.m14751n(r3);	 Catch:{ all -> 0x0074 }
            r0 = r6.go;	 Catch:{ all -> 0x0074 }
            r0 = r0.gd;	 Catch:{ all -> 0x0074 }
            r0 = r0.get(r3);	 Catch:{ all -> 0x0074 }
            r0 = (com.misfit.ble.obfuscated.ew) r0;	 Catch:{ all -> 0x0074 }
            if (r0 == 0) goto L_0x0033;
        L_0x001e:
            r4 = r0.getCharacteristicUUID();	 Catch:{ all -> 0x0074 }
            if (r4 == 0) goto L_0x0033;
        L_0x0024:
            r4 = r0.getCharacteristicUUID();	 Catch:{ all -> 0x0074 }
            r5 = r7.mo4860h();	 Catch:{ all -> 0x0074 }
            r4 = r4.equalsIgnoreCase(r5);	 Catch:{ all -> 0x0074 }
            if (r4 == 0) goto L_0x0033;
        L_0x0032:
            r1 = r0;
        L_0x0033:
            r4 = r6.go;	 Catch:{ all -> 0x0074 }
            r4 = r4.ge;	 Catch:{ all -> 0x0074 }
            r5 = r7.mo4860h();	 Catch:{ all -> 0x0074 }
            r4.m15015a(r5, r8);	 Catch:{ all -> 0x0074 }
            if (r1 != 0) goto L_0x0077;
        L_0x0042:
            r0 = r0 instanceof com.misfit.ble.obfuscated.em;	 Catch:{ all -> 0x0074 }
            if (r0 == 0) goto L_0x0054;
        L_0x0046:
            r0 = r7.mo4860h();	 Catch:{ all -> 0x0074 }
            r1 = "3dda0004-957f-7d4a-34a6-74696673696d";
            r0 = r0.equalsIgnoreCase(r1);	 Catch:{ all -> 0x0074 }
            if (r0 == 0) goto L_0x0054;
        L_0x0052:
            monitor-exit(r2);	 Catch:{ all -> 0x0074 }
        L_0x0053:
            return;
        L_0x0054:
            r0 = com.misfit.ble.obfuscated.ao.TAG;	 Catch:{ all -> 0x0074 }
            r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0074 }
            r1.<init>();	 Catch:{ all -> 0x0074 }
            r3 = "onCharacteristicWrite: unexpected onWrite event on characteristic: ";
            r1 = r1.append(r3);	 Catch:{ all -> 0x0074 }
            r3 = r7.mo4860h();	 Catch:{ all -> 0x0074 }
            r1 = r1.append(r3);	 Catch:{ all -> 0x0074 }
            r1 = r1.toString();	 Catch:{ all -> 0x0074 }
            com.misfit.ble.util.LogUtils.m15479l(r0, r1);	 Catch:{ all -> 0x0074 }
            monitor-exit(r2);	 Catch:{ all -> 0x0074 }
            goto L_0x0053;
        L_0x0074:
            r0 = move-exception;
            monitor-exit(r2);	 Catch:{ all -> 0x0074 }
            throw r0;
        L_0x0077:
            r1.onRequestSent(r8);	 Catch:{ all -> 0x0074 }
            if (r8 != 0) goto L_0x0089;
        L_0x007c:
            r0 = r6.go;	 Catch:{ all -> 0x0074 }
            r0 = r0.gh;	 Catch:{ all -> 0x0074 }
            r3 = 0;
            r4 = 0;
            r0.mo4910b(r1, r3, r4);	 Catch:{ all -> 0x0074 }
        L_0x0087:
            monitor-exit(r2);	 Catch:{ all -> 0x0074 }
            goto L_0x0053;
        L_0x0089:
            r0 = r6.go;	 Catch:{ all -> 0x0074 }
            r0 = r0.gh;	 Catch:{ all -> 0x0074 }
            r4 = 1;
            r5 = com.misfit.ble.obfuscated.am.m14694c(r8);	 Catch:{ all -> 0x0074 }
            r0.mo4910b(r1, r4, r5);	 Catch:{ all -> 0x0074 }
            r0 = r6.go;	 Catch:{ all -> 0x0074 }
            r0 = r0.gd;	 Catch:{ all -> 0x0074 }
            r0.remove(r3);	 Catch:{ all -> 0x0074 }
            goto L_0x0087;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.misfit.ble.obfuscated.ao.2.b(com.misfit.ble.obfuscated.o, int):void");
        }

        public void mo4814a(C4546p c4546p, int i) {
        }

        public void mo4817b(C4546p c4546p, int i) {
        }

        public void mo4816b(C4518o c4518o, boolean z) {
            this.go.fe.jX = new C4508c(Integer.valueOf(z ? 0 : 1), null);
            if (z) {
                this.go.gc.remove(c4518o);
                this.go.az();
            }
        }

        public void mo4812a(int i, int i2) {
            if (i2 == 0) {
                this.go.gh.mo4902a(0, i);
            } else {
                this.go.gh.mo4902a(1, i);
            }
        }
    }

    class C4450a implements Runnable {
        public boolean fW = false;
        final /* synthetic */ ao go;
        public ew gv;

        public C4450a(ao aoVar, ew ewVar) {
            this.go = aoVar;
            this.gv = ewVar;
        }

        public void run() {
            synchronized (this.go.gi) {
                if (!(this.fW || this.gv.getIsCompleted())) {
                    this.go.m14739a(this.gv, this);
                }
            }
        }
    }

    enum C4451b {
        DC,
        FTC_FTD,
        ASYNCHRONOUS_DATA,
        FILE_SETTING
    }

    public enum C4452c implements ap {
        SUCCEEDED(0),
        FAILED(12),
        CHARACTERISTIC_WRITING_FAILED(26);
        
        int eo;

        private C4452c(int i) {
            this.eo = i;
        }

        public int getId() {
            return this.eo;
        }
    }

    public interface C4453d {
        void mo4902a(int i, int i2);

        void mo4903a(int i, String str);

        void mo4904a(ba baVar, int i, int i2, int i3, int i4);

        void mo4905a(ew ewVar, int i, byte[] bArr);

        void mo4906a(Event event);

        void ay();

        void mo4908b(int i, int i2);

        void mo4909b(int i, String str);

        void mo4910b(ew ewVar, int i, ap apVar);

        void mo4911b(ew ewVar, int i, byte[] bArr);

        void mo4912c(int i, int i2);

        void mo4913c(int i, String str);

        void mo4914d(C4518o c4518o);

        void mo4915g(byte[] bArr);
    }

    private C4451b m14751n(String str) {
        if (str.equalsIgnoreCase("3dda0002-957f-7d4a-34a6-74696673696d")) {
            return C4451b.DC;
        }
        if (str.equalsIgnoreCase("3dda0003-957f-7d4a-34a6-74696673696d") || str.equalsIgnoreCase("3dda0004-957f-7d4a-34a6-74696673696d")) {
            return C4451b.FTC_FTD;
        }
        if (str.equalsIgnoreCase("3dda0006-957f-7d4a-34a6-74696673696d")) {
            return C4451b.ASYNCHRONOUS_DATA;
        }
        if (str.equalsIgnoreCase("3dda0007-957f-7d4a-34a6-74696673696d")) {
            return C4451b.FILE_SETTING;
        }
        return null;
    }

    public ao(Context context, ShineDevice shineDevice) {
        this.gj = C4590l.m15220a(context, shineDevice.f1601y);
        this.gk = shineDevice;
        this.gd = new Hashtable();
        this.gn = new Hashtable();
        this.ge = new ch(this.gl);
        this.gg = new Hashtable();
        if (this.mHandler == null) {
            this.mHandler = hd.m15181do();
        } else {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public void m14753a(cb cbVar) {
        this.fd = cbVar;
    }

    private void az() {
        if (this.gc.size() > 0) {
            int i;
            this.gh.mo4906a(Event.DISCOVER_CHARACTERISTICS);
            C4518o c4518o = (C4518o) this.gc.get(0);
            this.fe = m14750m("subscribeCharacteristic");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("characteristic", m14746e(c4518o));
            } catch (Throwable e) {
                C4462b.m14831a(e, "");
            }
            this.fe.jU = new C4507b(State.CONNECTING, jSONObject);
            boolean a = m14755a(c4518o, true);
            bz bzVar = this.fe;
            if (a) {
                i = 0;
            } else {
                i = 1;
            }
            bzVar.jV = new C4506a(Integer.valueOf(i));
            return;
        }
        this.gh.mo4912c(0, 0);
    }

    private void m14748f(List<C4518o> list) {
        this.gc = new ArrayList(list);
        az();
    }

    public boolean m14756a(boolean z, C4453d c4453d) {
        if (!this.gj.mo4877a(z, this.gm)) {
            return false;
        }
        this.gh = c4453d;
        return true;
    }

    public boolean connect() {
        return this.gj.connect();
    }

    public void disconnect() {
        synchronized (this.gi) {
            if (this.gj != null) {
                this.gj.disconnect();
                this.gd.clear();
                if (this.mHandler != null) {
                    this.mHandler.removeCallbacksAndMessages(null);
                }
            }
        }
    }

    public boolean readRemoteRssi() {
        return this.gj.readRemoteRssi();
    }

    public boolean m14759b(State state) {
        this.fe = m14750m("refreshDeviceCache");
        this.fe.jU = new C4507b(state, null);
        boolean refreshDeviceCache = this.gj.refreshDeviceCache();
        this.fe.jV = new C4506a(Integer.valueOf(refreshDeviceCache ? 0 : 1));
        return refreshDeviceCache;
    }

    public ShineDevice getDevice() {
        if (this.gk == null || !this.gk.f1601y.equals(this.gj.getDevice())) {
            return null;
        }
        return this.gk;
    }

    public void close() {
        synchronized (this.gi) {
            this.gj.close();
            this.gd.clear();
            this.ge.bR();
            for (ScheduledFuture scheduledFuture : this.gg.values()) {
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(true);
                }
            }
            this.gg.clear();
            if (this.mHandler != null) {
                this.mHandler.removeCallbacksAndMessages(null);
            }
        }
    }

    public boolean aA() {
        this.gh.mo4906a(Event.READ_SERIAL_NUMBER);
        C4563r c = m14760c("0000180a-0000-1000-8000-00805f9b34fb");
        if (c == null) {
            return false;
        }
        C4518o b = c.mo4872b("00002a25-0000-1000-8000-00805f9b34fb");
        if (b != null) {
            return m14754a(b);
        }
        return false;
    }

    public boolean aB() {
        this.gh.mo4906a(Event.READ_FIRMWARE_VERSION);
        C4563r c = m14760c("0000180a-0000-1000-8000-00805f9b34fb");
        if (c == null) {
            return false;
        }
        C4518o b = c.mo4872b("00002a26-0000-1000-8000-00805f9b34fb");
        if (b != null) {
            return m14754a(b);
        }
        return false;
    }

    public boolean aC() {
        this.gh.mo4906a(Event.READ_MODEL_NUMBER);
        C4563r c = m14760c("0000180a-0000-1000-8000-00805f9b34fb");
        if (c == null) {
            return false;
        }
        C4518o b = c.mo4872b("00002a24-0000-1000-8000-00805f9b34fb");
        if (b != null) {
            return m14754a(b);
        }
        return false;
    }

    public boolean aD() {
        this.gh.mo4906a(Event.DISCOVER_SERVICES);
        this.fe = m14750m("discoverServices");
        this.fe.jU = new C4507b(State.CONNECTING, null);
        boolean discoverServices = this.gj.discoverServices();
        this.fe.jV = new C4506a(Integer.valueOf(discoverServices ? 0 : 1));
        return discoverServices;
    }

    public C4452c m14752a(ew ewVar) {
        C4452c c4452c;
        synchronized (this.gi) {
            String characteristicUUID = ewVar.getCharacteristicUUID();
            C4451b n = m14751n(characteristicUUID);
            if (ewVar instanceof ex) {
                if (!((ex) ewVar).m15079a(this.gj)) {
                    c4452c = C4452c.CHARACTERISTIC_WRITING_FAILED;
                }
                this.gd.put(n, ewVar);
                m14742b(ewVar);
                c4452c = C4452c.SUCCEEDED;
            } else {
                C4563r c = m14760c("3dda0001-957f-7d4a-34a6-74696673696d");
                if (c == null) {
                    c4452c = C4452c.CHARACTERISTIC_WRITING_FAILED;
                } else {
                    C4518o b = c.mo4872b(characteristicUUID);
                    if (b == null) {
                        c4452c = C4452c.CHARACTERISTIC_WRITING_FAILED;
                    } else if (b.setValue(ewVar.getRequestData())) {
                        if (!m14758b(b)) {
                            c4452c = C4452c.CHARACTERISTIC_WRITING_FAILED;
                        }
                        this.gd.put(n, ewVar);
                        m14742b(ewVar);
                        c4452c = C4452c.SUCCEEDED;
                    } else {
                        c4452c = C4452c.CHARACTERISTIC_WRITING_FAILED;
                    }
                }
            }
        }
        return c4452c;
    }

    public void m14761c(ba baVar, ci ciVar) {
        this.ge.m15017e(baVar, ciVar);
    }

    public void m14757b(ActionID actionID) {
        this.ge.m15016d(actionID);
    }

    public void m14763d(ba baVar, ci ciVar) {
        C4563r c = m14760c("3dda0001-957f-7d4a-34a6-74696673696d");
        if (c != null) {
            final C4518o b = c.mo4872b("3dda0004-957f-7d4a-34a6-74696673696d");
            if (b != null) {
                Object scheduleWithFixedDelay;
                final float a = aw.m14798a(48.75f);
                final ci ciVar2 = ciVar;
                final ba baVar2 = baVar;
                Runnable c44493 = new Runnable(this) {
                    final /* synthetic */ ao go;
                    private boolean gq;

                    public void run() {
                        this.gq = a > 0.0f;
                        do {
                            if (ciVar2.bW()) {
                                Object obj;
                                int i;
                                if (b.setValue(ciVar2.bX()) && this.go.m14758b(b)) {
                                    obj = 1;
                                } else {
                                    obj = null;
                                }
                                C4453d b = this.go.gh;
                                ba baVar = baVar2;
                                if (obj != null) {
                                    i = 0;
                                } else {
                                    i = 1;
                                }
                                b.mo4904a(baVar, i, obj != null ? 0 : 1, ciVar2.bS(), ciVar2.bT());
                            }
                        } while (!this.gq);
                    }
                };
                if (this.gf == null) {
                    this.gf = Executors.newSingleThreadScheduledExecutor();
                }
                if (a > 0.0f) {
                    scheduleWithFixedDelay = this.gf.scheduleWithFixedDelay(c44493, 0, (long) Math.ceil((double) (a * 1000.0f)), TimeUnit.MICROSECONDS);
                } else {
                    scheduleWithFixedDelay = this.gf.schedule(c44493, 0, TimeUnit.MILLISECONDS);
                }
                this.gg.put(baVar.aR(), scheduleWithFixedDelay);
            }
        }
    }

    public void m14762c(ActionID actionID) {
        ScheduledFuture scheduledFuture = (ScheduledFuture) this.gg.remove(actionID);
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }

    private void m14739a(ew ewVar, C4450a c4450a) {
        C4451b n = m14751n(ewVar.getCharacteristicUUID());
        if (c4450a == this.gn.get(n)) {
            this.gn.remove(n);
        }
        this.gh.mo4911b(ewVar, 2, null);
        if (ewVar == this.gd.get(n)) {
            this.gd.remove(n);
        }
    }

    private void m14742b(ew ewVar) {
        C4451b n = m14751n(ewVar.getCharacteristicUUID());
        C4450a c4450a = (C4450a) this.gn.get(n);
        if (c4450a != null) {
            c4450a.fW = true;
            this.mHandler.removeCallbacks(c4450a);
        }
        if (ewVar.getTimeOut() > 0) {
            Runnable c4450a2 = new C4450a(this, ewVar);
            this.gn.put(n, c4450a2);
            this.mHandler.postDelayed(c4450a2, (long) ewVar.getTimeOut());
        }
    }

    private bz m14750m(String str) {
        ca bzVar = new bz(str);
        if (this.fd != null) {
            this.fd.m14997a(bzVar);
        }
        return bzVar;
    }

    private JSONArray m14749g(List<C4563r> list) {
        if (list == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (C4563r a : list) {
            jSONArray.put(m14737a(a));
        }
        return jSONArray;
    }

    private JSONObject m14737a(C4563r c4563r) {
        if (c4563r == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("uuid", c4563r.mo4874h());
        JSONArray jSONArray = new JSONArray();
        List<C4518o> characteristics = c4563r.getCharacteristics();
        if (characteristics != null) {
            for (C4518o c4518o : characteristics) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("uuid", c4518o.mo4860h());
                } catch (Throwable e) {
                    try {
                        C4462b.m14831a(e, "");
                    } catch (Throwable e2) {
                        C4462b.m14831a(e2, "");
                    }
                }
                jSONArray.put(jSONObject2);
            }
        }
        jSONObject.put("characteristics", jSONArray);
        return jSONObject;
    }

    private JSONObject m14746e(C4518o c4518o) {
        if (c4518o == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uuid", c4518o.mo4860h());
            return jSONObject;
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
            return jSONObject;
        }
    }

    public C4563r m14760c(String str) {
        return this.gj.mo4879c(str);
    }

    protected List<C4563r> getServices() {
        return this.gj.getServices();
    }

    protected boolean m14755a(C4518o c4518o, boolean z) {
        if (c4518o != null) {
            return this.gj.mo4876a(c4518o, z);
        }
        LogUtils.m15477e(TAG, "characteristic not found");
        return false;
    }

    protected boolean m14754a(C4518o c4518o) {
        return this.gj.mo4875a(c4518o);
    }

    protected boolean m14758b(C4518o c4518o) {
        return this.gj.mo4878b(c4518o);
    }
}
