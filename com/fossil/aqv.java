package com.fossil;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public final class aqv {
    private static final String aWB = aqv.class.getSimpleName();

    public static void HO() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            throw new IllegalStateException("Must be called from a background thread!");
        }
    }

    public static String m4251a(String str) {
        if (!TextUtils.isEmpty(str) && Uri.parse(str).getScheme() == null) {
            return "http://" + str;
        }
        return str;
    }

    public static String cx(String str) {
        if (str == null) {
            return "";
        }
        if (str.length() > 255) {
            return str.substring(0, 255);
        }
        return str;
    }

    public static String cy(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            app.m4180g(5, aWB, "Cannot encode '" + str + "'");
            return "";
        }
    }

    public static void m4252a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
            }
        }
    }

    public static byte[] cz(String str) {
        byte[] bArr = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                bArr = str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException e) {
                app.m4180g(5, aWB, "Unsupported UTF-8: " + e.getMessage());
            }
        }
        return bArr;
    }

    public static byte[] cA(String str) {
        byte[] bArr = new byte[(str.length() / 2)];
        char[] toCharArray = str.toCharArray();
        for (int i = 0; i < toCharArray.length; i += 2) {
            StringBuilder stringBuilder = new StringBuilder(2);
            stringBuilder.append(toCharArray[i]).append(toCharArray[i + 1]);
            bArr[i / 2] = (byte) Integer.parseInt(stringBuilder.toString(), 16);
        }
        return bArr;
    }

    public static boolean m4254c() {
        return VERSION.SDK_INT >= 21;
    }

    public static String ab(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            app.m4180g(5, aWB, "Unsupported ISO-8859-1:" + e.getMessage());
            return null;
        }
    }

    public static String cB(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            app.m4180g(5, aWB, "Cannot decode '" + str + "'");
            return "";
        }
    }

    public static long cC(String str) {
        if (str == null) {
            return 0;
        }
        long j = 1125899906842597L;
        int i = 0;
        while (i < str.length()) {
            long charAt = ((long) str.charAt(i)) + (j * 31);
            i++;
            j = charAt;
        }
        return j;
    }

    public static byte[] m4256m(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        m4253b(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static long m4253b(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read < 0) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
    }

    public static double m4250a(double d, int i) {
        if (i == -1) {
            return d;
        }
        return ((double) Math.round(Math.pow(10.0d, (double) i) * d)) / Math.pow(10.0d, (double) i);
    }

    public static boolean m4255l(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            app.m4180g(6, aWB, "Error occured when checking if app has permission.  Error: " + e.getMessage());
            return false;
        }
    }
}
