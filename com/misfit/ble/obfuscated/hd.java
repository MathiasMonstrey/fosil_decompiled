package com.misfit.ble.obfuscated;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.misfit.ble.obfuscated.C4435a.C4434a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

public class hd {
    public static String m15182e(File file) {
        Throwable e;
        IOException e2;
        if (file == null || !file.exists()) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        InputStreamReader inputStreamReader;
        try {
            inputStreamReader = new InputStreamReader(new FileInputStream(file));
            try {
                char[] cArr = new char[1024];
                while (true) {
                    int read = inputStreamReader.read(cArr);
                    if (read == -1) {
                        break;
                    }
                    stringBuilder.append(cArr, 0, read);
                }
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (Throwable e3) {
                        C4462b.m14831a(e3, file.getAbsolutePath());
                    }
                }
            } catch (IOException e4) {
                e2 = e4;
                try {
                    m15177a(C4434a.READ_TEXT_FILE_FAIL, file, file.length(), e2);
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (Throwable e32) {
                            C4462b.m14831a(e32, file.getAbsolutePath());
                        }
                    }
                    return stringBuilder.toString();
                } catch (Throwable th) {
                    e32 = th;
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (Throwable e5) {
                            C4462b.m14831a(e5, file.getAbsolutePath());
                        }
                    }
                    throw e32;
                }
            }
        } catch (IOException e6) {
            IOException iOException = e6;
            inputStreamReader = null;
            e2 = iOException;
            m15177a(C4434a.READ_TEXT_FILE_FAIL, file, file.length(), e2);
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            return stringBuilder.toString();
        } catch (Throwable e52) {
            Throwable th2 = e52;
            inputStreamReader = null;
            e32 = th2;
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            throw e32;
        }
        return stringBuilder.toString();
    }

    public static boolean m15178a(String str, File file) {
        Throwable e;
        IOException e2;
        OutputStreamWriter outputStreamWriter = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(new FileOutputStream(file));
            try {
                outputStreamWriter2.write(str);
                if (outputStreamWriter2 == null) {
                    return true;
                }
                try {
                    outputStreamWriter2.close();
                    return true;
                } catch (Throwable e3) {
                    C4462b.m14831a(e3, file.getAbsolutePath());
                    return false;
                }
            } catch (IOException e4) {
                e2 = e4;
                outputStreamWriter = outputStreamWriter2;
                try {
                    m15177a(C4434a.WRITE_TEXT_FILE_FAIL, file, (long) str.length(), e2);
                    if (outputStreamWriter != null) {
                        return false;
                    }
                    try {
                        outputStreamWriter.close();
                        return false;
                    } catch (Throwable e32) {
                        C4462b.m14831a(e32, file.getAbsolutePath());
                        return false;
                    }
                } catch (Throwable th) {
                    e32 = th;
                    if (outputStreamWriter != null) {
                        try {
                            outputStreamWriter.close();
                        } catch (Throwable e5) {
                            C4462b.m14831a(e5, file.getAbsolutePath());
                        }
                    }
                    throw e32;
                }
            } catch (Throwable th2) {
                e32 = th2;
                outputStreamWriter = outputStreamWriter2;
                if (outputStreamWriter != null) {
                    outputStreamWriter.close();
                }
                throw e32;
            }
        } catch (IOException e6) {
            e2 = e6;
            m15177a(C4434a.WRITE_TEXT_FILE_FAIL, file, (long) str.length(), e2);
            if (outputStreamWriter != null) {
                return false;
            }
            outputStreamWriter.close();
            return false;
        }
    }

    public static boolean m15179a(byte[] bArr, File file) {
        Throwable e;
        IOException e2;
        FileOutputStream fileOutputStream = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(bArr);
                if (fileOutputStream2 == null) {
                    return true;
                }
                try {
                    fileOutputStream2.close();
                    return true;
                } catch (Throwable e3) {
                    C4462b.m14831a(e3, file.getAbsolutePath());
                    return false;
                }
            } catch (IOException e4) {
                e2 = e4;
                fileOutputStream = fileOutputStream2;
                try {
                    m15177a(C4434a.WRITE_BINARY_FILE_FAIL, file, (long) bArr.length, e2);
                    if (fileOutputStream != null) {
                        return false;
                    }
                    try {
                        fileOutputStream.close();
                        return false;
                    } catch (Throwable e32) {
                        C4462b.m14831a(e32, file.getAbsolutePath());
                        return false;
                    }
                } catch (Throwable th) {
                    e32 = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e5) {
                            C4462b.m14831a(e5, file.getAbsolutePath());
                        }
                    }
                    throw e32;
                }
            } catch (Throwable th2) {
                e32 = th2;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw e32;
            }
        } catch (IOException e6) {
            e2 = e6;
            m15177a(C4434a.WRITE_BINARY_FILE_FAIL, file, (long) bArr.length, e2);
            if (fileOutputStream != null) {
                return false;
            }
            fileOutputStream.close();
            return false;
        }
    }

    public static String getDeviceName() {
        String dn = dn();
        return dn + "_" + getDeviceModel();
    }

    public static String dn() {
        String str = Build.MANUFACTURER;
        if (str != null) {
            return str;
        }
        return "unknown";
    }

    public static String getDeviceModel() {
        String str = Build.MODEL;
        if (str != null) {
            return str;
        }
        return "unknown";
    }

    public static boolean m15183e(Context context) {
        if (context == null) {
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        networkInfo = connectivityManager.getNetworkInfo(0);
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] m15184f(java.io.File r6) {
        /*
        r1 = 0;
        r2 = new java.io.DataInputStream;	 Catch:{ FileNotFoundException -> 0x0019 }
        r0 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x0019 }
        r0.<init>(r6);	 Catch:{ FileNotFoundException -> 0x0019 }
        r2.<init>(r0);	 Catch:{ FileNotFoundException -> 0x0019 }
        r4 = r6.length();
        r0 = (int) r4;
        r0 = new byte[r0];
        r2.readFully(r0);	 Catch:{ IOException -> 0x002c }
        r2.close();	 Catch:{ IOException -> 0x0023 }
    L_0x0018:
        return r0;
    L_0x0019:
        r0 = move-exception;
        r2 = r6.getAbsolutePath();
        com.misfit.ble.obfuscated.C4462b.m14831a(r0, r2);
        r0 = r1;
        goto L_0x0018;
    L_0x0023:
        r1 = move-exception;
        r2 = r6.getAbsolutePath();
        com.misfit.ble.obfuscated.C4462b.m14831a(r1, r2);
        goto L_0x0018;
    L_0x002c:
        r0 = move-exception;
        r3 = com.misfit.ble.obfuscated.C4435a.C4434a.READ_BINARY_FILE_FAIL;	 Catch:{ all -> 0x0044 }
        r4 = r6.length();	 Catch:{ all -> 0x0044 }
        m15177a(r3, r6, r4, r0);	 Catch:{ all -> 0x0044 }
        r2.close();	 Catch:{ IOException -> 0x003b }
    L_0x0039:
        r0 = r1;
        goto L_0x0018;
    L_0x003b:
        r0 = move-exception;
        r2 = r6.getAbsolutePath();
        com.misfit.ble.obfuscated.C4462b.m14831a(r0, r2);
        goto L_0x0039;
    L_0x0044:
        r0 = move-exception;
        r2.close();	 Catch:{ IOException -> 0x0049 }
    L_0x0048:
        throw r0;
    L_0x0049:
        r1 = move-exception;
        r2 = r6.getAbsolutePath();
        com.misfit.ble.obfuscated.C4462b.m14831a(r1, r2);
        goto L_0x0048;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.misfit.ble.obfuscated.hd.f(java.io.File):byte[]");
    }

    public static boolean m15180d(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str) || bArr == null) {
            return false;
        }
        String G = m15175G(bArr);
        if (G != null) {
            return G.equalsIgnoreCase(str);
        }
        return false;
    }

    public static String m15175G(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr, 0, bArr.length);
            String bigInteger = new BigInteger(1, instance.digest()).toString(16);
            return String.format("%32s", new Object[]{bigInteger}).replace(' ', '0');
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
            return null;
        }
    }

    public static long m15176a(int i, byte[] bArr) {
        if (bArr == null || i > bArr.length || i < 0) {
            return 0;
        }
        Checksum crc32 = new CRC32();
        crc32.update(bArr, 0, i);
        return crc32.getValue();
    }

    public static Handler m15181do() {
        Looper myLooper = Looper.myLooper();
        if (myLooper == null) {
            myLooper = Looper.getMainLooper();
        }
        return new Handler(myLooper);
    }

    public static String m15185m(int i) {
        switch (i) {
            case 10:
                return "BOND_NONE";
            case 11:
                return "BOND_BONDING";
            case 12:
                return "BOND_BONDED";
            default:
                return "INVALID STATE";
        }
    }

    private static void m15177a(C4434a c4434a, File file, long j, IOException iOException) {
        C4462b.m14831a(iOException, "");
        C4435a a = new C4435a(c4434a).m14672a("exception", iOException.getClass().getSimpleName());
        if (file != null) {
            a.m14672a("fileName", file.getAbsolutePath()).m14672a("isExisted", String.valueOf(file.exists())).m14672a("dataSize", String.valueOf(j));
        } else {
            a.m14672a("file", "null");
        }
        C4462b.m14830a(a);
    }
}
