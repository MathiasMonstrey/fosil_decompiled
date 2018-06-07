package com.misfit.ble.shine.log;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import com.misfit.ble.obfuscated.C4462b;
import com.misfit.ble.obfuscated.C4589k;
import com.misfit.ble.obfuscated.C4592s;
import com.misfit.ble.obfuscated.cb;
import com.misfit.ble.obfuscated.cd;
import com.misfit.ble.obfuscated.ce;
import com.misfit.ble.obfuscated.cf;
import com.misfit.ble.obfuscated.cf.C4513a;
import com.misfit.ble.obfuscated.cf.C4514b;
import com.misfit.ble.obfuscated.cg.C4515a;
import com.misfit.ble.obfuscated.gz;
import com.misfit.ble.obfuscated.ha;
import com.misfit.ble.obfuscated.hd;
import com.misfit.ble.shine.log.LogSessionUploader.ResultCode;
import com.misfit.ble.util.LogUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class LogManager {
    private static final String TAG = LogUtils.m15475b(LogManager.class);
    private static Handler jZ;
    private static LogManager ka = null;
    private final Object gi = new Object();
    private C4643a kb;
    private C4513a kc = new C46401(this);
    private HashMap<String, String> kd = new HashMap();
    private HashMap<String, Integer> ke = new HashMap();

    class C46401 implements C4513a {
        final /* synthetic */ LogManager kf;

        C46401(LogManager logManager) {
            this.kf = logManager;
        }

        public void mo4933b(File file, C4515a c4515a, C4514b c4514b) {
            this.kf.m15449a(file, c4515a, c4514b);
        }
    }

    class C46412 implements Comparator<File> {
        final /* synthetic */ LogManager kf;

        C46412(LogManager logManager) {
            this.kf = logManager;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m15430a((File) obj, (File) obj2);
        }

        public int m15430a(File file, File file2) {
            if (file == null) {
                return -1;
            }
            if (file2 == null) {
                return 1;
            }
            String y = this.kf.m15454y(file.getName());
            String y2 = this.kf.m15454y(file2.getName());
            if (y == null) {
                return -1;
            }
            if (y2 == null) {
                return 1;
            }
            if (y.equalsIgnoreCase(y2)) {
                int a = this.kf.m15432A(file.getName());
                int a2 = this.kf.m15432A(file2.getName());
                if (a < a2) {
                    return -1;
                }
                if (a == a2) {
                    return 0;
                }
                if (a > a2) {
                    return 1;
                }
            }
            return this.kf.m15446x(y).compareToIgnoreCase(this.kf.m15446x(y2));
        }
    }

    static class C4643a extends HandlerThread {
        private Handler mHandler = new Handler(getLooper());

        public C4643a() {
            super("com.misfitwearables.ble.shine.log", 10);
            start();
        }

        public void m15431a(final File file, final C4513a c4513a) {
            this.mHandler.post(new Runnable(this) {
                final /* synthetic */ C4643a ki;

                public void run() {
                    cf.m15012b(file, c4513a);
                }
            });
        }
    }

    public static Handler bz() {
        if (jZ == null) {
            jZ = hd.m15181do();
        }
        return jZ;
    }

    public static LogManager bA() {
        if (ka == null) {
            ka = new LogManager();
            ka.bB();
            ka.bG();
        }
        return ka;
    }

    protected void finalize() throws Throwable {
        jZ.removeCallbacksAndMessages(null);
        super.finalize();
    }

    private void bB() {
        this.kb = new C4643a();
    }

    public void m15450b(cb cbVar) {
        if (C4592s.m15228x().shouldSaveSessions()) {
            ArrayList bI = cbVar.bI();
            if (bI != null && !bI.isEmpty()) {
                Iterator it = bI.iterator();
                while (it.hasNext()) {
                    String jSONObject = ((JSONObject) it.next()).toString();
                    String d = C4589k.m15216d(jSONObject);
                    String z = m15455z(cbVar.getName());
                    LogUtils.m15476d(TAG, "SaveSessionLogFile: " + z);
                    if (gz.m15150a(d, "com.misfitwearables.ble.shine.log", z)) {
                        m15445f(jSONObject, z);
                        m15433B(z);
                    }
                }
            }
        }
    }

    public void m15448a(ce ceVar) {
        if (C4592s.m15228x().shouldSaveSessions()) {
            String jSONObject = ceVar.toJSON().toString();
            String d = C4589k.m15216d(jSONObject);
            String z = m15455z(ceVar.getName());
            LogUtils.m15476d(TAG, "SaveSessionLogFile: " + z);
            if (gz.m15150a(d, "com.misfitwearables.ble.shine.log", z)) {
                m15445f(jSONObject, z);
                m15433B(z);
            }
        }
    }

    public void m15447a(cd cdVar) {
        if (C4592s.m15228x().shouldSaveSessions()) {
            String jSONObject = cdVar.toJSON().toString();
            String d = C4589k.m15216d(jSONObject);
            String z = m15455z(cdVar.getName());
            LogUtils.m15476d(TAG, "SaveSessionLogFile: " + z);
            if (gz.m15150a(d, "com.misfitwearables.ble.shine.log", z)) {
                m15445f(jSONObject, z);
                m15433B(z);
            }
        }
    }

    private void m15445f(String str, String str2) {
        String str3 = str2 + ".txt";
        LogUtils.m15476d(TAG, "SaveSessionUnencryptedLogFile: " + str2);
        gz.m15150a(str, "com.misfitwearables.ble.shine.log.raw", str3);
    }

    public static String getRawLogFolderName() {
        return "com.misfitwearables.ble.shine.log.raw";
    }

    File[] bC() {
        File[] G = gz.m15148G("com.misfitwearables.ble.shine.log");
        if (G == null) {
            return null;
        }
        m15440a(G);
        return G;
    }

    void m15451b(File file) {
        this.kb.m15431a(file, this.kc);
    }

    void m15453w(String str) {
        File i = gz.m15153i("com.misfitwearables.ble.shine.log", str);
        LogUtils.m15476d(TAG, "Upload logfile: " + i.getName());
        if (i != null && i.exists()) {
            this.kb.m15431a(i, this.kc);
        }
    }

    public void m15449a(File file, C4515a c4515a, C4514b c4514b) {
        synchronized (this.gi) {
            if (c4514b == C4514b.SUCCEEDED && c4515a != null) {
                LogUtils.m15476d(TAG, c4515a.toString());
                if (c4515a.bP()) {
                    m15444d(file);
                    m15443c(file);
                    m15438a(c4515a);
                } else if (c4515a.bQ()) {
                    m15439a(file, c4515a);
                }
            }
            C4592s.m15228x().mo4935a(file, m15437a(c4515a, c4514b));
        }
    }

    private void m15439a(File file, C4515a c4515a) {
        int errorCode = c4515a.getErrorCode();
        if (errorCode == 4000 || errorCode == 4001 || errorCode == 4002 || errorCode == 4003 || errorCode == 4004) {
            m15444d(file);
            m15443c(file);
        }
    }

    private void m15443c(File file) {
        m15444d(gz.m15153i("com.misfitwearables.ble.shine.log.raw", file.getName() + ".txt"));
    }

    private void m15444d(File file) {
        if (file != null && file.exists()) {
            file.delete();
        }
    }

    private void bD() {
        Throwable e;
        HashMap hashMap = new HashMap();
        String bF = bF();
        if (bF != null) {
            try {
                JSONObject jSONObject = new JSONObject(bF);
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    bF = (String) keys.next();
                    hashMap.put(bF, jSONObject.getString(bF));
                }
            } catch (JSONException e2) {
                e = e2;
                C4462b.m14831a(e, "");
                this.kd = hashMap;
            } catch (ConcurrentModificationException e3) {
                e = e3;
                C4462b.m14831a(e, "");
                this.kd = hashMap;
            }
        }
        this.kd = hashMap;
    }

    private void bE() {
        m15441a(this.kd);
    }

    private static SharedPreferences aJ() {
        return ha.m15158I("com.misfitwearables.ble.shine.log.LogManager");
    }

    private static String bF() {
        return aJ().getString("com.misfitwearables.ble.shine.log.LogManager.trackingSessionIdsKey", null);
    }

    private static boolean m15441a(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            return aJ().edit().putString("com.misfitwearables.ble.shine.log.LogManager.trackingSessionIdsKey", "").commit();
        }
        return aJ().edit().putString("com.misfitwearables.ble.shine.log.LogManager.trackingSessionIdsKey", new JSONObject(hashMap).toString()).commit();
    }

    private void bG() {
        synchronized (this.gi) {
            bD();
            File[] G = gz.m15148G("com.misfitwearables.ble.shine.log");
            for (String str : new ArrayList(this.kd.keySet())) {
                Object obj;
                if (G != null) {
                    for (File name : G) {
                        if (name.getName().startsWith(str)) {
                            obj = 1;
                            break;
                        }
                    }
                }
                obj = null;
                if (obj == null) {
                    this.kd.remove(str);
                }
            }
            bE();
        }
    }

    private String m15446x(String str) {
        int indexOf = str.indexOf("_");
        return indexOf == -1 ? str : str.substring(indexOf);
    }

    private void m15440a(File[] fileArr) {
        if (fileArr == null) {
            LogUtils.m15477e(TAG, "sortSessionFiles - Illegal arguments - sessionFiles: " + fileArr);
        } else {
            Arrays.sort(fileArr, new C46412(this));
        }
    }

    String m15454y(String str) {
        if (str == null) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf("-");
        return lastIndexOf != -1 ? str.substring(0, lastIndexOf) : str;
    }

    String m15455z(String str) {
        Integer num = (Integer) this.ke.get(str);
        return (num == null || num.intValue() == 0) ? str : str + "-" + num;
    }

    private int m15432A(String str) {
        int i = 0;
        if (str != null) {
            int lastIndexOf = str.lastIndexOf("-");
            if (lastIndexOf != -1) {
                try {
                    i = Integer.parseInt(str.substring(lastIndexOf + 1));
                } catch (Throwable e) {
                    LogUtils.m15479l(TAG, e.getMessage());
                    C4462b.m14831a(e, "");
                }
            }
        }
        return i;
    }

    private void m15433B(String str) {
        String y = m15454y(str);
        Integer num = (Integer) this.ke.get(y);
        if (num == null) {
            num = Integer.valueOf(0);
        }
        this.ke.put(y, Integer.valueOf(num.intValue() + 1));
        C4592s.m15228x().mo4934E(str);
    }

    public String m15452g(String str, String str2) {
        if (str == null || str2 == null) {
            LogUtils.m15477e(TAG, "addSessionIdToPostRequest - illegal arguments: {filename: " + str + ", " + "content: " + (str2 != null ? "okay" : "null"));
            return null;
        }
        String y = m15454y(str);
        synchronized (this.gi) {
            String str3 = (String) this.kd.get(y);
        }
        if (y == null || str3 == null) {
            return str2;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            jSONObject.put("sessionid", str3);
            return jSONObject.toString();
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
            return str2;
        }
    }

    private void m15438a(C4515a c4515a) {
        String str;
        if (this.kd == null || c4515a == null) {
            String str2 = TAG;
            StringBuilder append = new StringBuilder().append("saveSessionIdForSession - Illegal arguments: {mTrackingSessionIds: ");
            if (this.kd != null) {
                str = "okay";
            } else {
                str = "null";
            }
            append = append.append(str).append(", ").append("response: ");
            if (c4515a != null) {
                str = "okay";
            } else {
                str = "null";
            }
            LogUtils.m15477e(str2, append.append(str).toString());
            return;
        }
        str = m15454y(c4515a.kF);
        str2 = m15434C(c4515a.kH);
        synchronized (this.gi) {
            this.kd.put(str, str2);
            bE();
        }
    }

    private String m15434C(String str) {
        String str2 = null;
        try {
            str2 = new JSONObject(str).getString("sessionid");
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return str2;
    }

    private int m15435D(String str) {
        int i = -1;
        try {
            i = new JSONObject(str).getInt("error");
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return i;
    }

    private ResultCode m15437a(C4515a c4515a, C4514b c4514b) {
        if (C4514b.NETWORK_UNAVAILABLE == c4514b) {
            return ResultCode.NETWORK_ERROR;
        }
        if (C4514b.UNEXPECTED == c4514b) {
            return ResultCode.UNEXPECTED_ERROR;
        }
        if (C4514b.SUCCEEDED != c4514b) {
            return null;
        }
        if (c4515a == null) {
            return ResultCode.UNEXPECTED_ERROR;
        }
        String str = c4515a.kH;
        if (c4515a.bQ()) {
            if (str == null) {
                return ResultCode.INVALID_SESSION_ERROR;
            }
            if (-1 == m15435D(str)) {
                return ResultCode.INVALID_SESSION_ERROR;
            }
            return ResultCode.UNEXPECTED_ERROR;
        } else if (c4515a.bP()) {
            return ResultCode.SUCCEEDED;
        } else {
            return ResultCode.UNEXPECTED_ERROR;
        }
    }
}
