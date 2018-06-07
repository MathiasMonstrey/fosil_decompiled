package com.fossil;

import android.os.Process;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;
import java.io.IOException;

public final class axu {
    private static String bjf = null;
    private static final int bjg = Process.myPid();

    public static String LL() {
        if (bjf == null) {
            bjf = hA(bjg);
        }
        return bjf;
    }

    private static String hA(int i) {
        ThreadPolicy allowThreadDiskReads;
        Closeable bufferedReader;
        Throwable th;
        String str = null;
        if (i > 0) {
            try {
                allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                bufferedReader = new BufferedReader(new FileReader("/proc/" + i + "/cmdline"));
                try {
                    StrictMode.setThreadPolicy(allowThreadDiskReads);
                    str = bufferedReader.readLine().trim();
                    axq.closeQuietly(bufferedReader);
                } catch (IOException e) {
                    axq.closeQuietly(bufferedReader);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    axq.closeQuietly(bufferedReader);
                    throw th;
                }
            } catch (IOException e2) {
                bufferedReader = str;
                axq.closeQuietly(bufferedReader);
                return str;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                bufferedReader = str;
                th = th4;
                axq.closeQuietly(bufferedReader);
                throw th;
            }
        }
        return str;
    }
}
