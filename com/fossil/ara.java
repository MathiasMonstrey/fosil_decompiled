package com.fossil;

import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import com.flurry.sdk.mb.C1545a;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ara {
    public static final String aWB = ara.class.getSimpleName();

    class C18541 implements Runnable {
        final /* synthetic */ Map aZV;

        C18541(Map map) {
            this.aZV = map;
        }

        public final void run() {
            ara.m4273q(this.aZV);
            ara.m4271o(this.aZV);
            ara.m4272p(this.aZV);
        }
    }

    public static Map<String, String> aT(boolean z) {
        Map<String, String> hashMap = new HashMap();
        try {
            hashMap.put("mem.java.max", Long.toString(Runtime.getRuntime().maxMemory()));
        } catch (Throwable e) {
            app.m4175b(aWB, "Error retrieving max memory", e);
        }
        try {
            MemoryInfo memoryInfo = new MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
            hashMap.put("mem.pss", Long.toString((long) (memoryInfo.getTotalPss() * 1024)));
        } catch (Throwable e2) {
            app.m4175b(aWB, "Error retrieving pss memory", e2);
        }
        if (apc.Ie()) {
            hashMap.put("application.state", Integer.toString(C1545a.ACTIVE.f1364e));
        } else {
            hashMap.put("application.state", Integer.toString(C1545a.BACKGROUND.f1364e));
        }
        int i = -1;
        try {
            aon.Il();
            i = aon.Is() - 1;
        } catch (Exception e3) {
        }
        hashMap.put("net.status", Integer.toString(i));
        i = 0;
        try {
            i = aqt.HF();
        } catch (RuntimeException e4) {
        }
        hashMap.put("orientation", Integer.toString(i));
        if (z) {
            m4273q(hashMap);
            m4271o(hashMap);
            m4272p(hashMap);
        } else {
            apc.IO().m4160b(new C18541(hashMap));
        }
        return hashMap;
    }

    private static void m4273q(Map<String, String> map) {
        Closeable fileInputStream;
        Closeable bufferedReader;
        FileNotFoundException e;
        IOException e2;
        Throwable th;
        Closeable closeable = null;
        if (map != null) {
            Pattern compile = Pattern.compile("^Vm(RSS|Size|Peak):\\s+(\\d+)\\s+kB$");
            try {
                fileInputStream = new FileInputStream(new File(new File("/proc/" + Integer.toString(Process.myPid())), "status"));
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                    try {
                        for (CharSequence readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                            Matcher matcher = compile.matcher(readLine);
                            if (matcher.find()) {
                                String group = matcher.group(1);
                                CharSequence group2 = matcher.group(2);
                                if (!(TextUtils.isEmpty(group) || TextUtils.isEmpty(group2))) {
                                    Object obj = -1;
                                    int i;
                                    switch (group.hashCode()) {
                                        case 81458:
                                            if (group.equals("RSS")) {
                                                obj = null;
                                                break;
                                            }
                                            break;
                                        case 2483455:
                                            if (group.equals("Peak")) {
                                                i = 2;
                                                break;
                                            }
                                            break;
                                        case 2577441:
                                            if (group.equals("Size")) {
                                                i = 1;
                                                break;
                                            }
                                            break;
                                    }
                                    switch (obj) {
                                        case null:
                                            map.put("mem.rss", group2);
                                            break;
                                        case 1:
                                            map.put("mem.virt", group2);
                                            break;
                                        case 2:
                                            map.put("mem.virt.max", group2);
                                            break;
                                        default:
                                            break;
                                    }
                                }
                            }
                        }
                        aqv.m4252a(fileInputStream);
                        aqv.m4252a(bufferedReader);
                    } catch (FileNotFoundException e3) {
                        e = e3;
                        closeable = fileInputStream;
                    } catch (IOException e4) {
                        e2 = e4;
                    }
                } catch (FileNotFoundException e5) {
                    e = e5;
                    bufferedReader = null;
                    closeable = fileInputStream;
                    try {
                        e.printStackTrace();
                        aqv.m4252a(closeable);
                        aqv.m4252a(bufferedReader);
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = closeable;
                        aqv.m4252a(fileInputStream);
                        aqv.m4252a(bufferedReader);
                        throw th;
                    }
                } catch (IOException e6) {
                    e2 = e6;
                    bufferedReader = null;
                    try {
                        e2.printStackTrace();
                        aqv.m4252a(fileInputStream);
                        aqv.m4252a(bufferedReader);
                    } catch (Throwable th3) {
                        th = th3;
                        aqv.m4252a(fileInputStream);
                        aqv.m4252a(bufferedReader);
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    bufferedReader = null;
                    aqv.m4252a(fileInputStream);
                    aqv.m4252a(bufferedReader);
                    throw th;
                }
            } catch (FileNotFoundException e7) {
                e = e7;
                bufferedReader = null;
                e.printStackTrace();
                aqv.m4252a(closeable);
                aqv.m4252a(bufferedReader);
            } catch (IOException e8) {
                e2 = e8;
                bufferedReader = null;
                fileInputStream = null;
                e2.printStackTrace();
                aqv.m4252a(fileInputStream);
                aqv.m4252a(bufferedReader);
            } catch (Throwable th5) {
                th = th5;
                bufferedReader = null;
                fileInputStream = null;
                aqv.m4252a(fileInputStream);
                aqv.m4252a(bufferedReader);
                throw th;
            }
        }
    }

    static void m4271o(Map<String, String> map) {
        long blockSizeLong;
        long availableBlocksLong;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        if (VERSION.SDK_INT >= 18) {
            blockSizeLong = statFs.getBlockSizeLong();
        } else {
            blockSizeLong = (long) statFs.getBlockSize();
        }
        if (VERSION.SDK_INT >= 18) {
            availableBlocksLong = statFs.getAvailableBlocksLong();
        } else {
            availableBlocksLong = (long) statFs.getAvailableBlocks();
        }
        map.put("disk.size.free", Long.toString(blockSizeLong * availableBlocksLong));
    }

    static void m4272p(Map<String, String> map) {
        long blockSizeLong;
        long blockCountLong;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        if (VERSION.SDK_INT >= 18) {
            blockSizeLong = statFs.getBlockSizeLong();
        } else {
            blockSizeLong = (long) statFs.getBlockSize();
        }
        if (VERSION.SDK_INT >= 18) {
            blockCountLong = statFs.getBlockCountLong();
        } else {
            blockCountLong = (long) statFs.getBlockCount();
        }
        map.put("disk.size.total", Long.toString(blockSizeLong * blockCountLong));
    }
}
