package io.fabric.sdk.android.services.common;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;
import com.fossil.emm;
import com.misfit.frameworks.common.constants.Constants;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CommonUtils {
    private static Boolean dNF = null;
    private static final char[] dNG = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static long dNH = -1;
    private static Boolean dNI = null;
    public static final Comparator<File> dNJ = new C08841();

    static class C08841 implements Comparator<File> {
        C08841() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m16265c((File) obj, (File) obj2);
        }

        public int m16265c(File file, File file2) {
            return (int) (file.lastModified() - file2.lastModified());
        }
    }

    enum Architecture {
        X86_32,
        X86_64,
        ARM_UNKNOWN,
        PPC,
        PPC64,
        ARMV6,
        ARMV7,
        UNKNOWN,
        ARMV7S,
        ARM64;
        
        private static final Map<String, Architecture> dNK = null;

        static {
            dNK = new HashMap(4);
            dNK.put("armeabi-v7a", ARMV7);
            dNK.put("armeabi", ARMV6);
            dNK.put("x86", X86_32);
        }

        static Architecture getValue() {
            Object obj = Build.CPU_ABI;
            if (TextUtils.isEmpty(obj)) {
                emm.aEU().d("Fabric", "Architecture#getValue()::Build.CPU_ABI returned null or empty");
                return UNKNOWN;
            }
            Architecture architecture = (Architecture) dNK.get(obj.toLowerCase(Locale.US));
            if (architecture == null) {
                return UNKNOWN;
            }
            return architecture;
        }
    }

    public static SharedPreferences ev(Context context) {
        return context.getSharedPreferences("com.crashlytics.prefs", 0);
    }

    public static String m16276c(File file, String str) {
        Closeable bufferedReader;
        Throwable e;
        Throwable th;
        String str2 = null;
        if (file.exists()) {
            try {
                String[] split;
                bufferedReader = new BufferedReader(new FileReader(file), 1024);
                while (true) {
                    try {
                        CharSequence readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        split = Pattern.compile("\\s*:\\s*").split(readLine, 2);
                        if (split.length > 1 && split[0].equals(str)) {
                            break;
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                }
                str2 = split[1];
                m16271a(bufferedReader, "Failed to close system file reader.");
            } catch (Exception e3) {
                e = e3;
                bufferedReader = null;
                try {
                    emm.aEU().g("Fabric", "Error parsing " + file, e);
                    m16271a(bufferedReader, "Failed to close system file reader.");
                    return str2;
                } catch (Throwable th2) {
                    th = th2;
                    m16271a(bufferedReader, "Failed to close system file reader.");
                    throw th;
                }
            } catch (Throwable e4) {
                bufferedReader = null;
                th = e4;
                m16271a(bufferedReader, "Failed to close system file reader.");
                throw th;
            }
        }
        return str2;
    }

    public static int aFn() {
        return Architecture.getValue().ordinal();
    }

    public static synchronized long aFo() {
        long j;
        synchronized (CommonUtils.class) {
            if (dNH == -1) {
                j = 0;
                Object c = m16276c(new File("/proc/meminfo"), "MemTotal");
                if (!TextUtils.isEmpty(c)) {
                    String toUpperCase = c.toUpperCase(Locale.US);
                    try {
                        if (toUpperCase.endsWith("KB")) {
                            j = m16274b(toUpperCase, "KB", 1024);
                        } else if (toUpperCase.endsWith("MB")) {
                            j = m16274b(toUpperCase, "MB", 1048576);
                        } else if (toUpperCase.endsWith("GB")) {
                            j = m16274b(toUpperCase, "GB", 1073741824);
                        } else {
                            emm.aEU().d("Fabric", "Unexpected meminfo format while computing RAM: " + toUpperCase);
                        }
                    } catch (Throwable e) {
                        emm.aEU().g("Fabric", "Unexpected meminfo format while computing RAM: " + toUpperCase, e);
                    }
                }
                dNH = j;
            }
            j = dNH;
        }
        return j;
    }

    static long m16274b(String str, String str2, int i) {
        return Long.parseLong(str.split(str2)[0].trim()) * ((long) i);
    }

    public static RunningAppProcessInfo m16267a(String str, Context context) {
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(Constants.ACTIVITY)).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.equals(str)) {
                    return runningAppProcessInfo;
                }
            }
        }
        return null;
    }

    public static String m16281w(InputStream inputStream) throws IOException {
        Scanner useDelimiter = new Scanner(inputStream).useDelimiter("\\A");
        return useDelimiter.hasNext() ? useDelimiter.next() : "";
    }

    public static String mi(String str) {
        return bk(str, "SHA-1");
    }

    public static String m16282x(InputStream inputStream) {
        return m16268a(inputStream, "SHA-1");
    }

    private static String m16268a(InputStream inputStream, String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return au(instance.digest());
                }
                instance.update(bArr, 0, read);
            }
        } catch (Throwable e) {
            emm.aEU().g("Fabric", "Could not calculate hash for app icon.", e);
            return "";
        }
    }

    private static String m16275b(byte[] bArr, String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            instance.update(bArr);
            return au(instance.digest());
        } catch (Throwable e) {
            emm.aEU().g("Fabric", "Could not create hashing algorithm: " + str + ", returning empty string.", e);
            return "";
        }
    }

    private static String bk(String str, String str2) {
        return m16275b(str.getBytes(), str2);
    }

    public static String m16277g(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        List<String> arrayList = new ArrayList();
        for (String str : strArr) {
            if (str != null) {
                arrayList.add(str.replace("-", "").toLowerCase(Locale.US));
            }
        }
        Collections.sort(arrayList);
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : arrayList) {
            stringBuilder.append(append);
        }
        String append2 = stringBuilder.toString();
        return append2.length() > 0 ? mi(append2) : null;
    }

    public static long ew(Context context) {
        MemoryInfo memoryInfo = new MemoryInfo();
        ((ActivityManager) context.getSystemService(Constants.ACTIVITY)).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static long mj(String str) {
        StatFs statFs = new StatFs(str);
        long blockSize = (long) statFs.getBlockSize();
        return (((long) statFs.getBlockCount()) * blockSize) - (((long) statFs.getAvailableBlocks()) * blockSize);
    }

    public static float ex(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        return ((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1));
    }

    public static boolean ey(Context context) {
        if (eA(context)) {
            return false;
        }
        return ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(8) != null;
    }

    public static void m16266Z(Context context, String str) {
        if (ez(context)) {
            emm.aEU().d("Fabric", str);
        }
    }

    public static void m16270a(Context context, String str, Throwable th) {
        if (ez(context)) {
            emm.aEU().e("Fabric", str);
        }
    }

    public static void m16269a(Context context, int i, String str, String str2) {
        if (ez(context)) {
            emm.aEU().a(i, "Fabric", str2);
        }
    }

    public static boolean ez(Context context) {
        if (dNF == null) {
            dNF = Boolean.valueOf(m16278j(context, "com.crashlytics.Trace", false));
        }
        return dNF.booleanValue();
    }

    public static boolean m16278j(Context context, String str, boolean z) {
        if (context == null) {
            return z;
        }
        Resources resources = context.getResources();
        if (resources == null) {
            return z;
        }
        int n = m16280n(context, str, "bool");
        if (n > 0) {
            return resources.getBoolean(n);
        }
        int n2 = m16280n(context, str, "string");
        if (n2 > 0) {
            return Boolean.parseBoolean(context.getString(n2));
        }
        return z;
    }

    public static int m16280n(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, eE(context));
    }

    public static boolean eA(Context context) {
        return ServerProtocol.DIALOG_PARAM_SDK_VERSION.equals(Build.PRODUCT) || "google_sdk".equals(Build.PRODUCT) || Secure.getString(context.getContentResolver(), "android_id") == null;
    }

    public static boolean eB(Context context) {
        boolean eA = eA(context);
        String str = Build.TAGS;
        if ((!eA && str != null && str.contains("test-keys")) || new File("/system/app/Superuser.apk").exists()) {
            return true;
        }
        File file = new File("/system/xbin/su");
        if (eA || !file.exists()) {
            return false;
        }
        return true;
    }

    public static boolean aFp() {
        return Debug.isDebuggerConnected() || Debug.waitingForDebugger();
    }

    public static int eC(Context context) {
        int i = 0;
        if (eA(context)) {
            i = 1;
        }
        if (eB(context)) {
            i |= 2;
        }
        if (aFp()) {
            return i | 4;
        }
        return i;
    }

    public static int m16279k(Context context, boolean z) {
        float ex = ex(context);
        if (!z) {
            return 1;
        }
        if (z && ((double) ex) >= 99.0d) {
            return 3;
        }
        if (!z || ((double) ex) >= 99.0d) {
            return 0;
        }
        return 2;
    }

    @SuppressLint({"GetInstance"})
    public static Cipher m16283z(int i, String str) throws InvalidKeyException {
        if (str.length() < 32) {
            throw new InvalidKeyException("Key must be at least 32 bytes.");
        }
        Key secretKeySpec = new SecretKeySpec(str.getBytes(), 0, 32, "AES/ECB/PKCS7Padding");
        try {
            Cipher instance = Cipher.getInstance("AES/ECB/PKCS7Padding");
            instance.init(i, secretKeySpec);
            return instance;
        } catch (Throwable e) {
            emm.aEU().g("Fabric", "Could not create Cipher for AES/ECB/PKCS7Padding - should never happen.", e);
            throw new RuntimeException(e);
        }
    }

    public static String au(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            cArr[i * 2] = dNG[i2 >>> 4];
            cArr[(i * 2) + 1] = dNG[i2 & 15];
        }
        return new String(cArr);
    }

    public static boolean eD(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    public static String aa(Context context, String str) {
        int n = m16280n(context, str, "string");
        if (n > 0) {
            return context.getString(n);
        }
        return "";
    }

    public static void m16271a(Closeable closeable, String str) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable e) {
                emm.aEU().g("Fabric", str, e);
            }
        }
    }

    public static void m16272a(Flushable flushable, String str) {
        if (flushable != null) {
            try {
                flushable.flush();
            } catch (Throwable e) {
                emm.aEU().g("Fabric", str, e);
            }
        }
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static String eE(Context context) {
        int i = context.getApplicationContext().getApplicationInfo().icon;
        if (i > 0) {
            return context.getResources().getResourcePackageName(i);
        }
        return context.getPackageName();
    }

    public static void m16273a(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static String pc(int i) {
        switch (i) {
            case 2:
                return "V";
            case 3:
                return "D";
            case 4:
                return "I";
            case 5:
                return "W";
            case 6:
                return "E";
            case 7:
                return "A";
            default:
                return "?";
        }
    }

    public static String eF(Context context) {
        Closeable openRawResource;
        Throwable e;
        Throwable th;
        String str = null;
        try {
            openRawResource = context.getResources().openRawResource(eG(context));
            try {
                String x = m16282x(openRawResource);
                if (!isNullOrEmpty(x)) {
                    str = x;
                }
                m16271a(openRawResource, "Failed to close icon input stream.");
            } catch (Exception e2) {
                e = e2;
                try {
                    emm.aEU().g("Fabric", "Could not calculate hash for app icon.", e);
                    m16271a(openRawResource, "Failed to close icon input stream.");
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    m16271a(openRawResource, "Failed to close icon input stream.");
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            openRawResource = null;
            emm.aEU().g("Fabric", "Could not calculate hash for app icon.", e);
            m16271a(openRawResource, "Failed to close icon input stream.");
            return str;
        } catch (Throwable e4) {
            openRawResource = null;
            th = e4;
            m16271a(openRawResource, "Failed to close icon input stream.");
            throw th;
        }
        return str;
    }

    public static int eG(Context context) {
        return context.getApplicationContext().getApplicationInfo().icon;
    }

    public static String eH(Context context) {
        int n = m16280n(context, "io.fabric.android.build_id", "string");
        if (n == 0) {
            n = m16280n(context, "com.crashlytics.android.build_id", "string");
        }
        if (n == 0) {
            return null;
        }
        String string = context.getResources().getString(n);
        emm.aEU().d("Fabric", "Build ID is: " + string);
        return string;
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    public static boolean ab(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    public static boolean eI(Context context) {
        if (!ab(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return true;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }
}
