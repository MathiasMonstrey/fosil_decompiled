package com.fossil;

import com.facebook.internal.Utility;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

class ebc {
    static int HF() {
        int i = 0;
        try {
            String str = "";
            InputStream inputStream = new ProcessBuilder(new String[]{"/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq"}).start().getInputStream();
            byte[] bArr = new byte[24];
            while (inputStream.read(bArr) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
            str = str.trim();
            if (str.length() > 0) {
                i = Integer.valueOf(str).intValue();
            }
        } catch (Throwable th) {
            ebb.dCY.m10419g(th);
        }
        return i * 1000;
    }

    static String HT() {
        int i = 2;
        String[] strArr = new String[]{"", ""};
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"), Utility.DEFAULT_STREAM_BUFFER_SIZE);
            String[] split = bufferedReader.readLine().split("\\s+");
            while (i < split.length) {
                strArr[0] = strArr[0] + split[i] + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
                i++;
            }
            bufferedReader.close();
        } catch (IOException e) {
        }
        return strArr[0];
    }

    static int Iz() {
        int i = 0;
        try {
            String str = "";
            InputStream inputStream = new ProcessBuilder(new String[]{"/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"}).start().getInputStream();
            byte[] bArr = new byte[24];
            while (inputStream.read(bArr) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
            str = str.trim();
            if (str.length() > 0) {
                i = Integer.valueOf(str).intValue();
            }
        } catch (Throwable e) {
            ebb.dCY.m10419g(e);
        }
        return i * 1000;
    }

    static int m10442a() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new ebd()).length;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }
}
