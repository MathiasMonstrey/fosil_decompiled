package com.misfit.ble.obfuscated;

import android.text.TextUtils;
import com.misfit.ble.shine.firmware.Firmware;
import com.misfit.ble.util.LogUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class bw {
    private static final String TAG = LogUtils.m15475b(bw.class);

    public static Firmware m14975b(JSONObject jSONObject) {
        Firmware firmware = new Firmware(jSONObject);
        return m14973a(firmware) ? firmware : null;
    }

    public static Firmware m14977t(String str) {
        if (str == null) {
            return null;
        }
        return m14972a(gz.m15153i(Firmware.iY, str));
    }

    public static List<Firmware> bw() {
        List arrayList = new ArrayList();
        File[] G = gz.m15148G(Firmware.iY);
        if (G != null) {
            for (File file : G) {
                if (!file.getName().endsWith(Firmware.iZ)) {
                    Firmware a = m14972a(file);
                    if (!(a == null || a.getFirmwareData() == null)) {
                        arrayList.add(a);
                    }
                }
            }
        }
        return arrayList;
    }

    private static boolean m14973a(Firmware firmware) {
        if (firmware == null || TextUtils.isEmpty(firmware.fa) || TextUtils.isEmpty(firmware.jk) || TextUtils.isEmpty(firmware.jn) || TextUtils.isEmpty(firmware.jo) || firmware.jl == null || firmware.jm == null || firmware.supportedCommands == null) {
            return false;
        }
        return true;
    }

    public static boolean m14976b(Firmware firmware) {
        Throwable e;
        boolean z = true;
        LogUtils.m15476d(TAG, String.format("archiveFirmware(%s)", new Object[]{firmware}));
        if (firmware == null) {
            return false;
        }
        File i = gz.m15153i(Firmware.iY, firmware.fa);
        if (i == null) {
            LogUtils.m15479l(TAG, "Cannot create file");
            return false;
        }
        try {
            OutputStream fileOutputStream = new FileOutputStream(i);
            ObjectOutputStream objectOutputStream;
            try {
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                try {
                    objectOutputStream.writeObject(firmware);
                    try {
                        objectOutputStream.close();
                    } catch (Throwable e2) {
                        C4462b.m14831a(e2, "");
                    }
                    try {
                        fileOutputStream.close();
                    } catch (Throwable e22) {
                        C4462b.m14831a(e22, "");
                    }
                } catch (IOException e3) {
                    e = e3;
                    try {
                        C4462b.m14831a(e, "");
                        try {
                            objectOutputStream.close();
                        } catch (Throwable e4) {
                            C4462b.m14831a(e4, "");
                        }
                        try {
                            fileOutputStream.close();
                            z = false;
                        } catch (Throwable e42) {
                            C4462b.m14831a(e42, "");
                            z = false;
                        }
                        return z;
                    } catch (Throwable th) {
                        e42 = th;
                        try {
                            objectOutputStream.close();
                        } catch (Throwable e222) {
                            C4462b.m14831a(e222, "");
                        }
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e2222) {
                            C4462b.m14831a(e2222, "");
                        }
                        throw e42;
                    }
                }
            } catch (IOException e5) {
                e42 = e5;
                objectOutputStream = null;
                C4462b.m14831a(e42, "");
                objectOutputStream.close();
                fileOutputStream.close();
                z = false;
                return z;
            } catch (Throwable th2) {
                e42 = th2;
                objectOutputStream = null;
                objectOutputStream.close();
                fileOutputStream.close();
                throw e42;
            }
            return z;
        } catch (Throwable e422) {
            C4462b.m14831a(e422, "");
            return false;
        }
    }

    private static Firmware m14972a(File file) {
        Firmware firmware;
        Throwable th;
        Throwable e;
        Throwable th2;
        LogUtils.m15476d(TAG, String.format("unarchiveFirmware(%s)", new Object[]{file}));
        try {
            InputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream;
            try {
                objectInputStream = new ObjectInputStream(fileInputStream);
                try {
                    firmware = (Firmware) objectInputStream.readObject();
                } catch (Throwable e2) {
                    th = e2;
                    firmware = null;
                    th2 = th;
                    try {
                        C4462b.m14831a(th2, "");
                        try {
                            objectInputStream.close();
                        } catch (Throwable th22) {
                            C4462b.m14831a(th22, "");
                        }
                        try {
                            fileInputStream.close();
                            return firmware;
                        } catch (Throwable th222) {
                            C4462b.m14831a(th222, "");
                            return firmware;
                        }
                    } catch (Throwable th3) {
                        e2 = th3;
                        try {
                            objectInputStream.close();
                        } catch (Throwable th2222) {
                            C4462b.m14831a(th2222, "");
                        }
                        try {
                            fileInputStream.close();
                        } catch (Throwable th22222) {
                            C4462b.m14831a(th22222, "");
                        }
                        throw e2;
                    }
                } catch (Throwable e22) {
                    th = e22;
                    firmware = null;
                    th22222 = th;
                    C4462b.m14831a(th22222, "");
                    try {
                        objectInputStream.close();
                    } catch (Throwable th222222) {
                        C4462b.m14831a(th222222, "");
                    }
                    try {
                        fileInputStream.close();
                        return firmware;
                    } catch (Throwable th2222222) {
                        C4462b.m14831a(th2222222, "");
                        return firmware;
                    }
                }
                try {
                    if (!m14973a(firmware)) {
                        firmware = null;
                    }
                    try {
                        objectInputStream.close();
                    } catch (Throwable th22222222) {
                        C4462b.m14831a(th22222222, "");
                    }
                    try {
                        fileInputStream.close();
                        return firmware;
                    } catch (Throwable th222222222) {
                        C4462b.m14831a(th222222222, "");
                        return firmware;
                    }
                } catch (IOException e3) {
                    th222222222 = e3;
                    C4462b.m14831a(th222222222, "");
                    objectInputStream.close();
                    fileInputStream.close();
                    return firmware;
                } catch (ClassNotFoundException e4) {
                    th222222222 = e4;
                    C4462b.m14831a(th222222222, "");
                    objectInputStream.close();
                    fileInputStream.close();
                    return firmware;
                }
            } catch (Throwable e222) {
                objectInputStream = null;
                th = e222;
                firmware = null;
                th222222222 = th;
                C4462b.m14831a(th222222222, "");
                objectInputStream.close();
                fileInputStream.close();
                return firmware;
            } catch (Throwable e2222) {
                objectInputStream = null;
                th = e2222;
                firmware = null;
                th222222222 = th;
                C4462b.m14831a(th222222222, "");
                objectInputStream.close();
                fileInputStream.close();
                return firmware;
            } catch (Throwable th4) {
                e2222 = th4;
                objectInputStream = null;
                objectInputStream.close();
                fileInputStream.close();
                throw e2222;
            }
        } catch (FileNotFoundException e5) {
            return null;
        }
    }

    public static String m14978u(String str) {
        return String.format("%s.%s", new Object[]{str, Firmware.iZ});
    }

    public static boolean m14974a(Map<String, Set<String>> map, Map<String, Set<String>> map2) {
        if (map == map2) {
            return true;
        }
        if (map == null || map2 == null || map.size() != map2.size()) {
            return false;
        }
        Set<String> keySet = map.keySet();
        Set keySet2 = map2.keySet();
        for (String str : keySet) {
            if (keySet2.contains(str)) {
                return false;
            }
            Set<String> set = (Set) map.get(str);
            Set set2 = (Set) map2.get(str);
            if (set.size() != set2.size()) {
                return false;
            }
            for (String contains : set) {
                if (!set2.contains(contains)) {
                    return false;
                }
            }
        }
        return true;
    }
}
