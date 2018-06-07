package com.fossil;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.NativeProtocol;
import com.sina.weibo.sdk.exception.WeiboException;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.concurrent.locks.ReentrantLock;
import javax.crypto.Cipher;
import org.json.JSONException;
import org.json.JSONObject;

public class duh {
    private static duh dtN;
    private String dqh;
    private C3207a dtO;
    private volatile ReentrantLock dtP = new ReentrantLock(true);
    private C3209c dtQ;
    private Context mContext;

    class C32051 implements Runnable {
        final /* synthetic */ duh dtR;

        C32051(duh com_fossil_duh) {
            this.dtR = com_fossil_duh;
        }

        public void run() {
            for (int i = 0; i < 1; i++) {
                try {
                    this.dtR.mx(i).delete();
                } catch (Exception e) {
                }
            }
        }
    }

    class C32062 implements Runnable {
        final /* synthetic */ duh dtR;

        C32062(duh com_fossil_duh) {
            this.dtR = com_fossil_duh;
        }

        public void run() {
            if (this.dtR.dtP.tryLock()) {
                C3207a b = this.dtR.axQ();
                if (b == null) {
                    int i = 1;
                    do {
                        i++;
                        try {
                            String c = this.dtR.axR();
                            C3207a km = C3207a.km(c);
                            this.dtR.kk(c);
                            this.dtR.dtO = km;
                            break;
                        } catch (WeiboException e) {
                            duj.m9770e("AidTask", "AidTaskInit WeiboException Msg : " + e.getMessage());
                            if (i >= 3) {
                            }
                        }
                    } while (i >= 3);
                } else {
                    this.dtR.dtO = b;
                }
                this.dtR.dtP.unlock();
                return;
            }
            duj.m9770e("AidTask", "tryLock : false, return");
        }
    }

    public static final class C3207a {
        private String dtS;
        private String dtT;

        public String axW() {
            return this.dtS;
        }

        public static C3207a km(String str) throws WeiboException {
            C3207a c3207a = new C3207a();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("error") || jSONObject.has(NativeProtocol.BRIDGE_ARG_ERROR_CODE)) {
                    duj.m9769d("AidTask", "loadAidFromNet has error !!!");
                    throw new WeiboException("loadAidFromNet has error !!!");
                }
                c3207a.dtS = jSONObject.optString("aid", "");
                c3207a.dtT = jSONObject.optString("sub", "");
                return c3207a;
            } catch (JSONException e) {
                duj.m9769d("AidTask", "loadAidFromNet JSONException Msg : " + e.getMessage());
                throw new WeiboException("loadAidFromNet has error !!!");
            }
        }

        C3207a axX() {
            C3207a c3207a = new C3207a();
            c3207a.dtS = this.dtS;
            c3207a.dtT = this.dtT;
            return c3207a;
        }
    }

    public interface C3208b {
        void m9760a(C3207a c3207a);

        void m9761k(Exception exception);
    }

    static class C3209c extends Handler {
        private WeakReference<C3208b> dtU;

        public C3209c(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            C3208b c3208b = (C3208b) this.dtU.get();
            switch (message.what) {
                case 1001:
                    if (c3208b != null) {
                        c3208b.m9760a(((C3207a) message.obj).axX());
                        return;
                    }
                    return;
                case 1002:
                    if (c3208b != null) {
                        c3208b.m9761k((WeiboException) message.obj);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private duh(Context context) {
        this.mContext = context.getApplicationContext();
        this.dtQ = new C3209c(this.mContext.getMainLooper());
        new Thread(new C32051(this)).start();
    }

    public static synchronized duh cP(Context context) {
        duh com_fossil_duh;
        synchronized (duh.class) {
            if (dtN == null) {
                dtN = new duh(context);
            }
            com_fossil_duh = dtN;
        }
        return com_fossil_duh;
    }

    public void kh(String str) {
        if (!TextUtils.isEmpty(str)) {
            duj.m9770e("AidTask", "aidTaskInit ");
            ki(str);
        }
    }

    private void ki(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.dqh = str;
            new Thread(new C32062(this)).start();
        }
    }

    public C3207a kj(String str) throws WeiboException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        duj.m9770e("AidTask", "getAidSync ");
        if (this.dtO == null) {
            kh(str);
        }
        return this.dtO;
    }

    private synchronized C3207a axQ() {
        FileInputStream fileInputStream;
        Throwable th;
        C3207a c3207a = null;
        synchronized (this) {
            try {
                fileInputStream = new FileInputStream(mx(1));
                try {
                    byte[] bArr = new byte[fileInputStream.available()];
                    fileInputStream.read(bArr);
                    c3207a = C3207a.km(new String(bArr));
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (Exception e2) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    return c3207a;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                fileInputStream = c3207a;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return c3207a;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                fileInputStream = c3207a;
                th = th4;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        }
        return c3207a;
    }

    private File mx(int i) {
        return new File(this.mContext.getFilesDir(), "weibo_sdk_aid" + i);
    }

    private String axR() throws WeiboException {
        String str = "https://api.weibo.com/oauth2/getaid.json";
        str = this.mContext.getPackageName();
        String T = duq.m9791T(this.mContext, str);
        String cQ = cQ(this.mContext);
        dtq com_fossil_dtq = new dtq(this.dqh);
        com_fossil_dtq.put("appkey", this.dqh);
        com_fossil_dtq.put("mfp", cQ);
        com_fossil_dtq.put("packagename", str);
        com_fossil_dtq.put("key_hash", T);
        try {
            str = dtn.m9733e(this.mContext, "https://api.weibo.com/oauth2/getaid.json", "GET", com_fossil_dtq);
            duj.m9769d("AidTask", "loadAidFromNet response : " + str);
            return str;
        } catch (WeiboException e) {
            duj.m9769d("AidTask", "loadAidFromNet WeiboException Msg : " + e.getMessage());
            throw e;
        }
    }

    private synchronized void kk(String str) {
        FileOutputStream fileOutputStream;
        Throwable th;
        if (!TextUtils.isEmpty(str)) {
            FileOutputStream fileOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(mx(1));
                try {
                    fileOutputStream.write(str.getBytes());
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (Exception e2) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    return;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    fileOutputStream2 = fileOutputStream;
                    th = th3;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                fileOutputStream = null;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return;
            } catch (Throwable th4) {
                th = th4;
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                throw th;
            }
        }
        return;
    }

    private static String cQ(Context context) {
        String str = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDHHM0Fi2Z6+QYKXqFUX2Cy6AaWq3cPi+GSn9oeAwQbPZR75JB7Netm0HtBVVbtPhzT7UO2p1JhFUKWqrqoYuAjkgMVPmA0sFrQohns5EE44Y86XQopD4ZO+dE5KjUZFE6vrPO3rWW3np2BqlgKpjnYZri6TJApmIpGcQg9/G/3zQIDAQAB";
        String str2 = "";
        try {
            str = new String(cR(context).getBytes(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            str = str2;
        }
        duj.m9769d("AidTask", "genMfpString() utf-8 string : " + str);
        try {
            str = aR(str, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDHHM0Fi2Z6+QYKXqFUX2Cy6AaWq3cPi+GSn9oeAwQbPZR75JB7Netm0HtBVVbtPhzT7UO2p1JhFUKWqrqoYuAjkgMVPmA0sFrQohns5EE44Y86XQopD4ZO+dE5KjUZFE6vrPO3rWW3np2BqlgKpjnYZri6TJApmIpGcQg9/G/3zQIDAQAB");
            duj.m9769d("AidTask", "encryptRsa() string : " + str);
            return str;
        } catch (Exception e2) {
            duj.m9770e("AidTask", e2.getMessage());
            return "";
        }
    }

    private static String cR(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            CharSequence axS = axS();
            if (!TextUtils.isEmpty(axS)) {
                jSONObject.put(AppEventsConstants.EVENT_PARAM_VALUE_YES, axS);
            }
            axS = cS(context);
            if (!TextUtils.isEmpty(axS)) {
                jSONObject.put("2", axS);
            }
            axS = cT(context);
            if (!TextUtils.isEmpty(axS)) {
                jSONObject.put("3", axS);
            }
            axS = cU(context);
            if (!TextUtils.isEmpty(axS)) {
                jSONObject.put("4", axS);
            }
            axS = cV(context);
            if (!TextUtils.isEmpty(axS)) {
                jSONObject.put("5", axS);
            }
            axS = cW(context);
            if (!TextUtils.isEmpty(axS)) {
                jSONObject.put("6", axS);
            }
            axS = axT();
            if (!TextUtils.isEmpty(axS)) {
                jSONObject.put("7", axS);
            }
            axS = cX(context);
            if (!TextUtils.isEmpty(axS)) {
                jSONObject.put("10", axS);
            }
            axS = axU();
            if (!TextUtils.isEmpty(axS)) {
                jSONObject.put("13", axS);
            }
            axS = getModel();
            if (!TextUtils.isEmpty(axS)) {
                jSONObject.put("14", axS);
            }
            axS = axV();
            if (!TextUtils.isEmpty(axS)) {
                jSONObject.put("15", axS);
            }
            axS = cY(context);
            if (!TextUtils.isEmpty(axS)) {
                jSONObject.put("16", axS);
            }
            axS = cZ(context);
            if (!TextUtils.isEmpty(axS)) {
                jSONObject.put("17", axS);
            }
            axS = getDeviceName();
            if (!TextUtils.isEmpty(axS)) {
                jSONObject.put("18", axS);
            }
            axS = da(context);
            if (!TextUtils.isEmpty(axS)) {
                jSONObject.put("19", axS);
            }
            String str = "";
            try {
                axS = duq.dj(context);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!TextUtils.isEmpty(axS)) {
                jSONObject.put("20", axS);
            }
            return jSONObject.toString();
        } catch (JSONException e2) {
            return "";
        }
    }

    private static String aR(String str, String str2) throws Exception {
        Throwable th;
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(1, kl(str2));
        byte[] bytes = str.getBytes("UTF-8");
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            int i = 0;
            while (true) {
                int j = m9768j(bytes, i, 117);
                if (j == -1) {
                    break;
                }
                try {
                    byte[] doFinal = instance.doFinal(bytes, i, j);
                    byteArrayOutputStream.write(doFinal);
                    duj.m9769d("AidTask", "encryptRsa offset = " + i + "     len = " + j + "     enBytes len = " + doFinal.length);
                    i += j;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            byteArrayOutputStream.flush();
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            duj.m9769d("AidTask", "encryptRsa total enBytes len = " + toByteArray.length);
            toByteArray = dui.ap(toByteArray);
            duj.m9769d("AidTask", "encryptRsa total base64byte len = " + toByteArray.length);
            String str3 = "01";
            String str4 = "01" + new String(toByteArray, "UTF-8");
            duj.m9769d("AidTask", "encryptRsa total base64string : " + str4);
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                }
            }
            return str4;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                }
            }
            throw th;
        }
    }

    private static int m9768j(byte[] bArr, int i, int i2) {
        if (i >= bArr.length) {
            return -1;
        }
        return Math.min(bArr.length - i, i2);
    }

    private static PublicKey kl(String str) throws Exception {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(dui.decode(str.getBytes())));
    }

    private static String axS() {
        try {
            return "Android " + VERSION.RELEASE;
        } catch (Exception e) {
            return "";
        }
    }

    private static String cS(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception e) {
            return "";
        }
    }

    private static String cT(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception e) {
            return "";
        }
    }

    private static String cU(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
        } catch (Exception e) {
            return "";
        }
    }

    private static String cV(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager == null) {
                return "";
            }
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            return connectionInfo != null ? connectionInfo.getMacAddress() : "";
        } catch (Exception e) {
            return "";
        }
    }

    private static String cW(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSimSerialNumber();
        } catch (Exception e) {
            return "";
        }
    }

    private static String axT() {
        String str = "";
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", new Class[]{String.class, String.class}).invoke(cls, new Object[]{"ro.serialno", "unknown"});
        } catch (Exception e) {
            return str;
        }
    }

    private static String cX(Context context) {
        try {
            return Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception e) {
            return "";
        }
    }

    private static String axU() {
        try {
            return Build.CPU_ABI;
        } catch (Exception e) {
            return "";
        }
    }

    private static String getModel() {
        try {
            return Build.MODEL;
        } catch (Exception e) {
            return "";
        }
    }

    private static String axV() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return Long.toString(((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize()));
        } catch (Exception e) {
            return "";
        }
    }

    private static String cY(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return new StringBuilder(String.valueOf(String.valueOf(displayMetrics.widthPixels))).append("*").append(String.valueOf(displayMetrics.heightPixels)).toString();
        } catch (Exception e) {
            return "";
        }
    }

    private static String cZ(Context context) {
        try {
            WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                return connectionInfo.getSSID();
            }
        } catch (Exception e) {
        }
        return "";
    }

    private static String getDeviceName() {
        try {
            return Build.BRAND;
        } catch (Exception e) {
            return "";
        }
    }

    private static String da(Context context) {
        String str = "none";
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.getType() == 0) {
                    switch (activeNetworkInfo.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            return "2G";
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return "3G";
                        case 13:
                            return "4G";
                        default:
                            return "none";
                    }
                } else if (activeNetworkInfo.getType() == 1) {
                    return "wifi";
                }
            }
            return str;
        } catch (Exception e) {
            return str;
        }
    }
}
