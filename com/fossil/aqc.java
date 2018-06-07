package com.fossil;

import com.fossil.aqb.C1818a;
import com.fossil.aqd.C1828a;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class aqc {
    public static final Integer bbW = Integer.valueOf(50);
    private static final String f1448d = aqc.class.getSimpleName();
    String aWR;
    LinkedHashMap<String, List<String>> bbX;

    class C18191 implements aqk<List<aqd>> {
        final /* synthetic */ aqc bbY;

        C18191(aqc com_fossil_aqc) {
            this.bbY = com_fossil_aqc;
        }

        public final aqi<List<aqd>> hi(int i) {
            return new aqh(new C1828a());
        }
    }

    class C18202 implements aqk<List<aqd>> {
        final /* synthetic */ aqc bbY;

        C18202(aqc com_fossil_aqc) {
            this.bbY = com_fossil_aqc;
        }

        public final aqi<List<aqd>> hi(int i) {
            return new aqh(new C1828a());
        }
    }

    class C18213 implements aqk<aqb> {
        final /* synthetic */ aqc bbY;

        C18213(aqc com_fossil_aqc) {
            this.bbY = com_fossil_aqc;
        }

        public final aqi<aqb> hi(int i) {
            return new C1818a();
        }
    }

    class C18224 implements aqk<List<aqd>> {
        final /* synthetic */ aqc bbY;

        C18224(aqc com_fossil_aqc) {
            this.bbY = com_fossil_aqc;
        }

        public final aqi<List<aqd>> hi(int i) {
            return new aqh(new C1828a());
        }
    }

    class C18235 implements aqk<aqb> {
        final /* synthetic */ aqc bbY;

        C18235(aqc com_fossil_aqc) {
            this.bbY = com_fossil_aqc;
        }

        public final aqi<aqb> hi(int i) {
            return new C1818a();
        }
    }

    class C18246 implements aqk<List<aqd>> {
        final /* synthetic */ aqc bbY;

        C18246(aqc com_fossil_aqc) {
            this.bbY = com_fossil_aqc;
        }

        public final aqi<List<aqd>> hi(int i) {
            return new aqh(new C1828a());
        }
    }

    class C18257 implements aqk<List<aqd>> {
        final /* synthetic */ aqc bbY;

        C18257(aqc com_fossil_aqc) {
            this.bbY = com_fossil_aqc;
        }

        public final aqi<List<aqd>> hi(int i) {
            return new aqh(new C1828a());
        }
    }

    public aqc(String str) {
        this.aWR = str + "Main";
        cf(this.aWR);
    }

    private void cf(String str) {
        this.bbX = new LinkedHashMap();
        List<String> arrayList = new ArrayList();
        if (cn(str)) {
            Collection co = co(str);
            if (co != null && co.size() > 0) {
                arrayList.addAll(co);
                for (String cp : arrayList) {
                    cp(cp);
                }
            }
            cq(str);
        } else {
            List<aqd> list = (List) new api(apc.IO().baD.getFileStreamPath(cr(this.aWR)), str, 1, new C18191(this)).IV();
            if (list == null) {
                app.m4183y(f1448d, "New main file also not found. returning..");
                return;
            }
            for (aqd com_fossil_aqd : list) {
                arrayList.add(com_fossil_aqd.aWB);
            }
        }
        for (String cp2 : arrayList) {
            this.bbX.put(cp2, cs(cp2));
        }
    }

    private synchronized boolean cn(String str) {
        File fileStreamPath;
        fileStreamPath = apc.IO().baD.getFileStreamPath(".FlurrySenderIndex.info." + str);
        app.m4180g(5, f1448d, "isOldIndexFilePresent: for " + str + fileStreamPath.exists());
        return fileStreamPath.exists();
    }

    private synchronized List<String> co(String str) {
        Throwable th;
        Throwable th2;
        Throwable th3;
        List<String> list = null;
        synchronized (this) {
            aqv.HO();
            app.m4180g(5, f1448d, "Reading Index File for " + str + " file name:" + apc.IO().baD.getFileStreamPath(".FlurrySenderIndex.info." + str));
            File fileStreamPath = apc.IO().baD.getFileStreamPath(".FlurrySenderIndex.info." + str);
            List<String> arrayList;
            if (fileStreamPath.exists()) {
                app.m4180g(5, f1448d, "Reading Index File for " + str + " Found file.");
                Closeable dataInputStream;
                try {
                    dataInputStream = new DataInputStream(new FileInputStream(fileStreamPath));
                    try {
                        int readUnsignedShort = dataInputStream.readUnsignedShort();
                        if (readUnsignedShort == 0) {
                            aqv.m4252a(dataInputStream);
                        } else {
                            arrayList = new ArrayList(readUnsignedShort);
                            int i = 0;
                            while (i < readUnsignedShort) {
                                try {
                                    int readUnsignedShort2 = dataInputStream.readUnsignedShort();
                                    app.m4180g(4, f1448d, "read iter " + i + " dataLength = " + readUnsignedShort2);
                                    byte[] bArr = new byte[readUnsignedShort2];
                                    dataInputStream.readFully(bArr);
                                    arrayList.add(new String(bArr));
                                    i++;
                                } catch (Throwable th4) {
                                    th = th4;
                                }
                            }
                            dataInputStream.readUnsignedShort();
                            aqv.m4252a(dataInputStream);
                            list = arrayList;
                        }
                    } catch (Throwable th32) {
                        th2 = th32;
                        arrayList = null;
                        th = th2;
                        try {
                            app.m4174b(6, f1448d, "Error when loading persistent file", th);
                            aqv.m4252a(dataInputStream);
                            list = arrayList;
                            return list;
                        } catch (Throwable th5) {
                            th32 = th5;
                            aqv.m4252a(dataInputStream);
                            throw th32;
                        }
                    }
                } catch (Throwable th6) {
                    th32 = th6;
                    dataInputStream = null;
                    aqv.m4252a(dataInputStream);
                    throw th32;
                }
            }
            app.m4180g(5, f1448d, "Agent cache file doesn't exist.");
            arrayList = null;
            list = arrayList;
        }
        return list;
    }

    private void cp(String str) {
        List<String> co = co(str);
        if (co == null) {
            app.m4183y(f1448d, "No old file to replace");
            return;
        }
        for (String str2 : co) {
            byte[] ct = ct(str2);
            if (ct == null) {
                app.m4180g(6, f1448d, "File does not exist");
            } else {
                m4207a(str2, ct);
                aqv.HO();
                app.m4180g(5, f1448d, "Deleting  block File for " + str2 + " file name:" + apc.IO().baD.getFileStreamPath(".flurrydatasenderblock." + str2));
                File fileStreamPath = apc.IO().baD.getFileStreamPath(".flurrydatasenderblock." + str2);
                if (fileStreamPath.exists()) {
                    app.m4180g(5, f1448d, "Found file for " + str2 + ". Deleted - " + fileStreamPath.delete());
                }
            }
        }
        m4206a(str, co, ".YFlurrySenderIndex.info.");
        cq(str);
    }

    private static void cq(String str) {
        aqv.HO();
        app.m4180g(5, f1448d, "Deleting Index File for " + str + " file name:" + apc.IO().baD.getFileStreamPath(".FlurrySenderIndex.info." + str));
        File fileStreamPath = apc.IO().baD.getFileStreamPath(".FlurrySenderIndex.info." + str);
        if (fileStreamPath.exists()) {
            app.m4180g(5, f1448d, "Found file for " + str + ". Deleted - " + fileStreamPath.delete());
        }
    }

    private static String cr(String str) {
        return ".YFlurrySenderIndex.info." + str;
    }

    private synchronized List<String> cs(String str) {
        List<String> arrayList;
        aqv.HO();
        app.m4180g(5, f1448d, "Reading Index File for " + str + " file name:" + apc.IO().baD.getFileStreamPath(cr(str)));
        List<aqd> list = (List) new api(apc.IO().baD.getFileStreamPath(cr(str)), ".YFlurrySenderIndex.info.", 1, new C18202(this)).IV();
        arrayList = new ArrayList();
        for (aqd com_fossil_aqd : list) {
            arrayList.add(com_fossil_aqd.aWB);
        }
        return arrayList;
    }

    private static byte[] ct(String str) {
        Closeable dataInputStream;
        Throwable th;
        Throwable th2;
        byte[] bArr = null;
        aqv.HO();
        app.m4180g(5, f1448d, "Reading block File for " + str + " file name:" + apc.IO().baD.getFileStreamPath(".flurrydatasenderblock." + str));
        File fileStreamPath = apc.IO().baD.getFileStreamPath(".flurrydatasenderblock." + str);
        if (fileStreamPath.exists()) {
            app.m4180g(5, f1448d, "Reading Index File for " + str + " Found file.");
            try {
                dataInputStream = new DataInputStream(new FileInputStream(fileStreamPath));
                try {
                    int readUnsignedShort = dataInputStream.readUnsignedShort();
                    if (readUnsignedShort == 0) {
                        aqv.m4252a(dataInputStream);
                    } else {
                        bArr = new byte[readUnsignedShort];
                        dataInputStream.readFully(bArr);
                        dataInputStream.readUnsignedShort();
                        aqv.m4252a(dataInputStream);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        app.m4174b(6, f1448d, "Error when loading persistent file", th);
                        aqv.m4252a(dataInputStream);
                        return bArr;
                    } catch (Throwable th4) {
                        th2 = th4;
                        aqv.m4252a(dataInputStream);
                        throw th2;
                    }
                }
            } catch (Throwable th5) {
                dataInputStream = null;
                th2 = th5;
                aqv.m4252a(dataInputStream);
                throw th2;
            }
        }
        app.m4180g(4, f1448d, "Agent cache file doesn't exist.");
        return bArr;
    }

    private synchronized void m4207a(String str, byte[] bArr) {
        aqv.HO();
        app.m4180g(5, f1448d, "Saving Block File for " + str + " file name:" + apc.IO().baD.getFileStreamPath(aqb.m4205a(str)));
        new api(apc.IO().baD.getFileStreamPath(aqb.m4205a(str)), ".yflurrydatasenderblock.", 1, new C18213(this)).bJ(new aqb(bArr));
    }

    private synchronized void m4206a(String str, List<String> list, String str2) {
        aqv.HO();
        app.m4180g(5, f1448d, "Saving Index File for " + str + " file name:" + apc.IO().baD.getFileStreamPath(cr(str)));
        api com_fossil_api = new api(apc.IO().baD.getFileStreamPath(cr(str)), str2, 1, new C18224(this));
        List arrayList = new ArrayList();
        for (String com_fossil_aqd : list) {
            arrayList.add(new aqd(com_fossil_aqd));
        }
        com_fossil_api.bJ(arrayList);
    }

    public final synchronized void m4208a(aqb com_fossil_aqb, String str) {
        Object obj = null;
        synchronized (this) {
            List linkedList;
            app.m4180g(4, f1448d, "addBlockInfo" + str);
            String str2 = com_fossil_aqb.aWB;
            List list = (List) this.bbX.get(str);
            if (list == null) {
                app.m4180g(4, f1448d, "New Data Key");
                linkedList = new LinkedList();
                obj = 1;
            } else {
                linkedList = list;
            }
            linkedList.add(str2);
            if (linkedList.size() > bbW.intValue()) {
                cu((String) linkedList.get(0));
                linkedList.remove(0);
            }
            this.bbX.put(str, linkedList);
            m4206a(str, linkedList, ".YFlurrySenderIndex.info.");
            if (obj != null) {
                HJ();
            }
        }
    }

    private boolean cu(String str) {
        return new api(apc.IO().baD.getFileStreamPath(aqb.m4205a(str)), ".yflurrydatasenderblock.", 1, new C18235(this)).Ie();
    }

    private synchronized void HJ() {
        List linkedList = new LinkedList(this.bbX.keySet());
        new api(apc.IO().baD.getFileStreamPath(cr(this.aWR)), ".YFlurrySenderIndex.info.", 1, new C18246(this)).Ie();
        if (!linkedList.isEmpty()) {
            m4206a(this.aWR, linkedList, this.aWR);
        }
    }

    public final boolean m4209z(String str, String str2) {
        List list = (List) this.bbX.get(str2);
        boolean z = false;
        if (list != null) {
            cu(str);
            z = list.remove(str);
        }
        if (list == null || list.isEmpty()) {
            cv(str2);
        } else {
            this.bbX.put(str2, list);
            m4206a(str2, list, ".YFlurrySenderIndex.info.");
        }
        return z;
    }

    private synchronized boolean cv(String str) {
        boolean Ie;
        aqv.HO();
        api com_fossil_api = new api(apc.IO().baD.getFileStreamPath(cr(str)), ".YFlurrySenderIndex.info.", 1, new C18257(this));
        List<String> cm = cm(str);
        if (cm != null) {
            app.m4180g(4, f1448d, "discardOutdatedBlocksForDataKey: notSentBlocks = " + cm.size());
            for (String str2 : cm) {
                cu(str2);
                app.m4180g(4, f1448d, "discardOutdatedBlocksForDataKey: removed block = " + str2);
            }
        }
        this.bbX.remove(str);
        Ie = com_fossil_api.Ie();
        HJ();
        return Ie;
    }

    public final List<String> cm(String str) {
        return (List) this.bbX.get(str);
    }
}
