package com.fossil;

import android.content.Context;
import com.facebook.internal.NativeProtocol;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.File;

class add {
    private static final C1596a aJA = new C1596a();
    private final File aJB;
    private adc aJC = aJA;
    private final Context context;

    static final class C1596a implements adc {
        private C1596a() {
        }

        public void mo826a(long j, String str) {
        }

        public acp ys() {
            return null;
        }

        public void yt() {
        }

        public void yu() {
        }
    }

    public add(Context context, File file) {
        this.context = context;
        this.aJB = new File(file, "log-files");
    }

    public void aG(String str) {
        yw();
        if (yy()) {
            m3029b(aH(str), NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
            return;
        }
        emm.aEU().mo2950d("Fabric", "Preferences requested no custom logs. Aborting log file creation.");
        this.aJC = aJA;
    }

    public void m3028a(long j, String str) {
        this.aJC.mo826a(j, str);
    }

    public acp yv() {
        return this.aJC.ys();
    }

    public void yw() {
        this.aJC.yu();
    }

    void m3029b(File file, int i) {
        this.aJC.yt();
        this.aJC = new adh(file, i);
    }

    private File aH(String str) {
        yx();
        return new File(this.aJB, "crashlytics-userlog-" + str + ".temp");
    }

    private void yx() {
        if (!this.aJB.exists()) {
            this.aJB.mkdirs();
        }
    }

    private boolean yy() {
        return CommonUtils.j(this.context, "com.crashlytics.CollectCustomLogs", true);
    }
}
