package com.fossil;

import com.facebook.appevents.AppEventsConstants;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class adj {
    private static final FilenameFilter aKi = new C16131();
    static final Map<String, String> aKj = Collections.singletonMap("X-CRASHLYTICS-INVALID-SESSION", AppEventsConstants.EVENT_PARAM_VALUE_YES);
    private static final short[] aKk = new short[]{(short) 10, (short) 20, (short) 30, (short) 60, (short) 120, (short) 300};
    private final Object aKl = new Object();
    private final acy aKm;
    private Thread aKn;

    static class C16131 implements FilenameFilter {
        C16131() {
        }

        public boolean accept(File file, String str) {
            return str.endsWith(".cls") && !str.contains("Session");
        }
    }

    class C1614a extends enh {
        private final float aII;
        final /* synthetic */ adj aKo;

        C1614a(adj com_fossil_adj, float f) {
            this.aKo = com_fossil_adj;
            this.aII = f;
        }

        public void yH() {
            try {
                yI();
            } catch (Throwable e) {
                emm.aEU().mo2953g("Fabric", "An unexpected error occurred while attempting to upload crash reports.", e);
            }
            this.aKo.aKn = null;
        }

        private void yI() {
            emm.aEU().mo2950d("Fabric", "Starting report processing in " + this.aII + " second(s)...");
            if (this.aII > 0.0f) {
                try {
                    Thread.sleep((long) (this.aII * 1000.0f));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            acs xD = acs.xD();
            acw xH = xD.xH();
            List<adi> yF = this.aKo.yF();
            if (!xH.ya()) {
                if (yF.isEmpty() || xD.xQ()) {
                    List list = yF;
                    int i = 0;
                    while (!r0.isEmpty() && !acs.xD().xH().ya()) {
                        emm.aEU().mo2950d("Fabric", "Attempting to send " + r0.size() + " report(s)");
                        for (adi a : r0) {
                            this.aKo.m3061a(a);
                        }
                        List yF2 = this.aKo.yF();
                        if (yF2.isEmpty()) {
                            list = yF2;
                        } else {
                            int i2 = i + 1;
                            long j = (long) adj.aKk[Math.min(i, adj.aKk.length - 1)];
                            emm.aEU().mo2950d("Fabric", "Report submisson: scheduling delayed retry in " + j + " seconds");
                            try {
                                Thread.sleep(j * 1000);
                                i = i2;
                                list = yF2;
                            } catch (InterruptedException e2) {
                                Thread.currentThread().interrupt();
                                return;
                            }
                        }
                    }
                    return;
                }
                emm.aEU().mo2950d("Fabric", "User declined to send. Removing " + yF.size() + " Report(s).");
                for (adi a2 : yF) {
                    a2.yD();
                }
            }
        }
    }

    public adj(acy com_fossil_acy) {
        if (com_fossil_acy == null) {
            throw new IllegalArgumentException("createReportCall must not be null.");
        }
        this.aKm = com_fossil_acy;
    }

    public synchronized void m3060S(float f) {
        if (this.aKn == null) {
            this.aKn = new Thread(new C1614a(this, f), "Crashlytics Report Uploader");
            this.aKn.start();
        }
    }

    boolean m3061a(adi com_fossil_adi) {
        boolean z = false;
        synchronized (this.aKl) {
            try {
                boolean a = this.aKm.mo825a(new acx(new eng().er(acs.xD().getContext()), com_fossil_adi));
                emm.aEU().mo2954i("Fabric", "Crashlytics report upload " + (a ? "complete: " : "FAILED: ") + com_fossil_adi.getFileName());
                if (a) {
                    com_fossil_adi.yD();
                    z = true;
                }
            } catch (Throwable e) {
                emm.aEU().mo2953g("Fabric", "Error occurred sending report " + com_fossil_adi, e);
            }
        }
        return z;
    }

    List<adi> yF() {
        emm.aEU().mo2950d("Fabric", "Checking for crash reports...");
        synchronized (this.aKl) {
            File[] listFiles = acs.xD().xl().listFiles(aKi);
        }
        List<adi> linkedList = new LinkedList();
        for (File file : listFiles) {
            emm.aEU().mo2950d("Fabric", "Found crash report " + file.getPath());
            linkedList.add(new adl(file));
        }
        if (linkedList.isEmpty()) {
            emm.aEU().mo2950d("Fabric", "No reports found.");
        }
        return linkedList;
    }
}
