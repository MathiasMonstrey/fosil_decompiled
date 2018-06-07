package com.fossil;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.support.v8.renderscript.Allocation;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.Utility;
import com.misfit.frameworks.common.constants.Constants;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpHost;
import org.json.JSONObject;

public class ebb {
    private static String aWB = null;
    private static String aWR = null;
    private static String aWS = null;
    private static String aYl = "__MTA_FIRST_ACTIVATE__";
    private static String aYp = null;
    private static String aYt = null;
    private static String aYv = null;
    private static String aZb = "";
    private static String bbL = "";
    private static int bcN = -1;
    private static String bcy = "";
    private static String f1506d = null;
    private static String dCO = null;
    private static Random dCW = null;
    private static DisplayMetrics dCX = null;
    private static eaq dCY = null;
    private static String dCZ = null;
    private static volatile int dCc = -1;
    private static long dDa = -1;
    private static ebe dDb = null;
    private static long dDc = -1;
    private static String dDd = "";
    private static int f1507j = -1;
    private static int f1508w = 0;

    public static String HT() {
        if (cn(dCO)) {
            return dCO;
        }
        long Io = Io() / 1000000;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        String str = String.valueOf((((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / 1000000) + "/" + String.valueOf(Io);
        dCO = str;
        return str;
    }

    public static long IL() {
        try {
            Calendar instance = Calendar.getInstance();
            instance.set(11, 0);
            instance.set(12, 0);
            instance.set(13, 0);
            instance.set(14, 0);
            return instance.getTimeInMillis() + 86400000;
        } catch (Throwable th) {
            dCY.m10419g(th);
            return System.currentTimeMillis() + 86400000;
        }
    }

    public static long Io() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
    }

    private static long Ir() {
        if (dDa > 0) {
            return dDa;
        }
        long j = 1;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), Utility.DEFAULT_STREAM_BUFFER_SIZE);
            j = (long) (Integer.valueOf(bufferedReader.readLine().split("\\s+")[1]).intValue() * 1024);
            bufferedReader.close();
        } catch (Exception e) {
        }
        dDa = j;
        return j;
    }

    public static void m10434K(Context context, int i) {
        f1508w = i;
        ebg.m10446e(context, "mta.qq.com.difftime", i);
    }

    public static String m10435Y(Context context, String str) {
        if (!dze.aBT()) {
            return str;
        }
        if (aYt == null) {
            aYt = dP(context);
        }
        return aYt != null ? str + "_" + aYt : str;
    }

    public static int m10436a() {
        return aCq().nextInt(Integer.MAX_VALUE);
    }

    public static Long m10437a(String str, String str2, int i, int i2, Long l) {
        if (str == null || str2 == null) {
            return l;
        }
        if (str2.equalsIgnoreCase(".") || str2.equalsIgnoreCase("|")) {
            str2 = "\\" + str2;
        }
        String[] split = str.split(str2);
        if (split.length != i2) {
            return l;
        }
        try {
            Long valueOf = Long.valueOf(0);
            int i3 = 0;
            while (i3 < split.length) {
                Long valueOf2 = Long.valueOf(((long) i) * (valueOf.longValue() + Long.valueOf(split[i3]).longValue()));
                i3++;
                valueOf = valueOf2;
            }
            return valueOf;
        } catch (NumberFormatException e) {
            return l;
        }
    }

    public static String m10438a(String str) {
        if (str == null) {
            return AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                int i = b & 255;
                if (i < 16) {
                    stringBuffer.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                stringBuffer.append(Integer.toHexString(i));
            }
            return stringBuffer.toString();
        } catch (Throwable th) {
            return AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
    }

    public static boolean m10439a(dzh com_fossil_dzh) {
        return com_fossil_dzh == null ? false : cn(com_fossil_dzh.awy());
    }

    private static synchronized Random aCq() {
        Random random;
        synchronized (ebb.class) {
            if (dCW == null) {
                dCW = new Random();
            }
            random = dCW;
        }
        return random;
    }

    public static synchronized eaq aCr() {
        eaq com_fossil_eaq;
        synchronized (ebb.class) {
            if (dCY == null) {
                com_fossil_eaq = new eaq("MtaSDK");
                dCY = com_fossil_eaq;
                com_fossil_eaq.dG(false);
            }
            com_fossil_eaq = dCY;
        }
        return com_fossil_eaq;
    }

    public static String aR(long j) {
        return new SimpleDateFormat("yyyyMMdd").format(new Date(j));
    }

    public static synchronized String aa(Context context) {
        String Y;
        synchronized (ebb.class) {
            if (aWB == null || aWB.trim().length() == 0) {
                Y = ebh.m10450Y(context);
                aWB = Y;
                if (Y == null || aWB.trim().length() == 0) {
                    aWB = Integer.toString(aCq().nextInt(Integer.MAX_VALUE));
                }
                Y = aWB;
            } else {
                Y = aWB;
            }
        }
        return Y;
    }

    public static byte[] at(byte[] bArr) {
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        byte[] bArr2 = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length * 2);
        while (true) {
            int read = gZIPInputStream.read(bArr2);
            if (read != -1) {
                byteArrayOutputStream.write(bArr2, 0, read);
            } else {
                bArr2 = byteArrayOutputStream.toByteArray();
                byteArrayInputStream.close();
                gZIPInputStream.close();
                byteArrayOutputStream.close();
                return bArr2;
            }
        }
    }

    public static boolean cn(String str) {
        return (str == null || str.trim().length() == 0) ? false : true;
    }

    public static HttpHost dB(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) != 0) {
                return null;
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            if (activeNetworkInfo.getTypeName() != null && activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                return null;
            }
            String extraInfo = activeNetworkInfo.getExtraInfo();
            if (extraInfo == null) {
                return null;
            }
            if (extraInfo.equals("cmwap") || extraInfo.equals("3gwap") || extraInfo.equals("uniwap")) {
                return new HttpHost("10.0.0.172", 80);
            }
            if (extraInfo.equals("ctwap")) {
                return new HttpHost("10.0.0.200", 80);
            }
            String defaultHost = Proxy.getDefaultHost();
            if (defaultHost != null && defaultHost.trim().length() > 0) {
                return new HttpHost(defaultHost, Proxy.getDefaultPort());
            }
            return null;
        } catch (Throwable th) {
            dCY.m10419g(th);
        }
    }

    public static synchronized String dC(Context context) {
        String str;
        synchronized (ebb.class) {
            if (aWS == null || aWS.trim().length() == 0) {
                aWS = ebh.aa(context);
            }
            str = aWS;
        }
        return str;
    }

    public static DisplayMetrics dD(Context context) {
        if (dCX == null) {
            dCX = new DisplayMetrics();
            ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(dCX);
        }
        return dCX;
    }

    public static String dE(Context context) {
        if (aWR != null) {
            return aWR;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), Allocation.USAGE_SHARED);
            if (applicationInfo != null) {
                String string = applicationInfo.metaData.getString("TA_APPKEY");
                if (string != null) {
                    aWR = string;
                    return string;
                }
                dCY.cY("Could not read APPKEY meta-data from AndroidManifest.xml");
            }
        } catch (Throwable th) {
            dCY.cY("Could not read APPKEY meta-data from AndroidManifest.xml");
        }
        return null;
    }

    public static String dF(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), Allocation.USAGE_SHARED);
            if (applicationInfo != null) {
                Object obj = applicationInfo.metaData.get("InstallChannel");
                if (obj != null) {
                    return obj.toString();
                }
                dCY.cZ("Could not read InstallChannel meta-data from AndroidManifest.xml");
            }
        } catch (Throwable th) {
            dCY.da("Could not read InstallChannel meta-data from AndroidManifest.xml");
        }
        return null;
    }

    public static String dG(Context context) {
        return context == null ? null : context.getClass().getName();
    }

    public static String dH(Context context) {
        if (aYv != null) {
            return aYv;
        }
        try {
            if (!ebh.m10453l(context, "android.permission.READ_PHONE_STATE")) {
                dCY.da("Could not get permission of android.permission.READ_PHONE_STATE");
            } else if (dJ(context)) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    aYv = telephonyManager.getSimOperator();
                }
            }
        } catch (Throwable th) {
            dCY.m10419g(th);
        }
        return aYv;
    }

    public static String dI(Context context) {
        if (cn(bcy)) {
            return bcy;
        }
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            bcy = str;
            if (str == null) {
                return "";
            }
        } catch (Throwable th) {
            dCY.m10419g(th);
        }
        return bcy;
    }

    public static boolean dJ(Context context) {
        return context.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", context.getPackageName()) == 0;
    }

    public static String dK(Context context) {
        String str = "";
        try {
            if (ebh.m10453l(context, "android.permission.INTERNET") && ebh.m10453l(context, "android.permission.ACCESS_NETWORK_STATE")) {
                String typeName;
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    typeName = activeNetworkInfo.getTypeName();
                    String extraInfo = activeNetworkInfo.getExtraInfo();
                    if (typeName != null) {
                        if (typeName.equalsIgnoreCase("WIFI")) {
                            return "WIFI";
                        }
                        if (typeName.equalsIgnoreCase("MOBILE")) {
                            return extraInfo != null ? extraInfo : "MOBILE";
                        } else {
                            if (extraInfo != null) {
                                return extraInfo;
                            }
                            return typeName;
                        }
                    }
                }
                typeName = str;
                return typeName;
            }
            dCY.da("can not get the permission of android.permission.ACCESS_WIFI_STATE");
            return str;
        } catch (Throwable th) {
            dCY.m10419g(th);
            return str;
        }
    }

    public static Integer dL(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                return Integer.valueOf(telephonyManager.getNetworkType());
            }
        } catch (Throwable th) {
        }
        return null;
    }

    public static String dM(Context context) {
        if (cn(aZb)) {
            return aZb;
        }
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            aZb = str;
            if (str == null || aZb.length() == 0) {
                return "unknown";
            }
        } catch (Throwable th) {
            dCY.m10419g(th);
        }
        return aZb;
    }

    public static int dN(Context context) {
        if (f1507j != -1) {
            return f1507j;
        }
        try {
            if (ebf.Ja()) {
                f1507j = 1;
            }
        } catch (Throwable th) {
            dCY.m10419g(th);
        }
        f1507j = 0;
        return 0;
    }

    public static String dO(Context context) {
        if (cn(aYp)) {
            return aYp;
        }
        try {
            if (ebh.m10453l(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                String externalStorageState = Environment.getExternalStorageState();
                if (externalStorageState != null && externalStorageState.equals("mounted")) {
                    externalStorageState = Environment.getExternalStorageDirectory().getPath();
                    if (externalStorageState != null) {
                        StatFs statFs = new StatFs(externalStorageState);
                        long blockCount = (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 1000000;
                        externalStorageState = String.valueOf((((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks())) / 1000000) + "/" + String.valueOf(blockCount);
                        aYp = externalStorageState;
                        return externalStorageState;
                    }
                }
                return null;
            }
            dCY.warn("can not get the permission of android.permission.WRITE_EXTERNAL_STORAGE");
            return null;
        } catch (Throwable th) {
            dCY.m10419g(th);
        }
    }

    static String dP(Context context) {
        try {
            if (aYt != null) {
                return aYt;
            }
            int myPid = Process.myPid();
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(Constants.ACTIVITY)).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    aYt = runningAppProcessInfo.processName;
                    break;
                }
            }
            return aYt;
        } catch (Throwable th) {
        }
    }

    public static String dQ(Context context) {
        return m10435Y(context, eap.dCI);
    }

    public static synchronized Integer dR(Context context) {
        Integer valueOf;
        int i = 0;
        synchronized (ebb.class) {
            if (dCc <= 0) {
                dCc = ebg.m10445d(context, "MTA_EVENT_INDEX", 0);
                ebg.m10446e(context, "MTA_EVENT_INDEX", dCc + 1000);
            } else if (dCc % 1000 == 0) {
                try {
                    int i2 = dCc + 1000;
                    if (dCc < 2147383647) {
                        i = i2;
                    }
                    ebg.m10446e(context, "MTA_EVENT_INDEX", i);
                } catch (Throwable th) {
                    dCY.cZ(th);
                }
            }
            i = dCc + 1;
            dCc = i;
            valueOf = Integer.valueOf(i);
        }
        return valueOf;
    }

    public static String dS(Context context) {
        try {
            return String.valueOf(dT(context) / 1000000) + "/" + String.valueOf(Ir() / 1000000);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static long dT(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Constants.ACTIVITY);
        MemoryInfo memoryInfo = new MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static JSONObject dU(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("n", ebc.m10442a());
            String HT = ebc.HT();
            if (HT != null && HT.length() > 0) {
                jSONObject.put("na", HT);
            }
            int Iz = ebc.Iz();
            if (Iz > 0) {
                jSONObject.put("fx", Iz / 1000000);
            }
            Iz = ebc.HF();
            if (Iz > 0) {
                jSONObject.put("fn", Iz / 1000000);
            }
        } catch (Throwable th) {
            Log.w("MtaSDK", "get cpu error", th);
        }
        return jSONObject;
    }

    public static String dV(Context context) {
        if (cn(bbL)) {
            return bbL;
        }
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            if (sensorManager != null) {
                List sensorList = sensorManager.getSensorList(-1);
                if (sensorList != null) {
                    StringBuilder stringBuilder = new StringBuilder(sensorList.size() * 10);
                    for (int i = 0; i < sensorList.size(); i++) {
                        stringBuilder.append(((Sensor) sensorList.get(i)).getType());
                        if (i != sensorList.size() - 1) {
                            stringBuilder.append(",");
                        }
                    }
                    bbL = stringBuilder.toString();
                }
            }
        } catch (Throwable th) {
            dCY.m10419g(th);
        }
        return bbL;
    }

    public static synchronized int dW(Context context) {
        int i;
        synchronized (ebb.class) {
            if (bcN != -1) {
                i = bcN;
            } else {
                dX(context);
                i = bcN;
            }
        }
        return i;
    }

    public static void dX(Context context) {
        int d = ebg.m10445d(context, aYl, 1);
        bcN = d;
        if (d == 1) {
            ebg.m10446e(context, aYl, 0);
        }
    }

    public static boolean dY(Context context) {
        if (dDc < 0) {
            dDc = ebg.m10443a(context, "mta.qq.com.checktime", 0);
        }
        return Math.abs(System.currentTimeMillis() - dDc) > 86400000;
    }

    public static void dZ(Context context) {
        dDc = System.currentTimeMillis();
        ebg.m10444b(context, "mta.qq.com.checktime", dDc);
    }

    public static boolean m10440e(Context context) {
        try {
            if (ebh.m10453l(context, "android.permission.ACCESS_WIFI_STATE")) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
                if (connectivityManager != null) {
                    NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
                    if (allNetworkInfo != null) {
                        int i = 0;
                        while (i < allNetworkInfo.length) {
                            if (allNetworkInfo[i].getTypeName().equalsIgnoreCase("WIFI") && allNetworkInfo[i].isConnected()) {
                                return true;
                            }
                            i++;
                        }
                    }
                }
                return false;
            }
            dCY.warn("can not get the permission of android.permission.ACCESS_WIFI_STATE");
            return false;
        } catch (Throwable th) {
            dCY.m10419g(th);
        }
    }

    public static int ea(Context context) {
        return ebg.m10445d(context, "mta.qq.com.difftime", 0);
    }

    public static String eb(Context context) {
        if (context == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 0);
        return (resolveActivity.activityInfo == null || resolveActivity.activityInfo.packageName.equals("android")) ? null : resolveActivity.activityInfo.packageName;
    }

    public static int m10441j(Context context, boolean z) {
        if (z) {
            f1508w = ea(context);
        }
        return f1508w;
    }

    public static long ll(String str) {
        return m10437a(str, ".", 100, 3, Long.valueOf(0)).longValue();
    }

    public static String mW(int i) {
        Calendar instance = Calendar.getInstance();
        instance.roll(6, i);
        return new SimpleDateFormat("yyyyMMdd").format(instance.getTime());
    }
}
