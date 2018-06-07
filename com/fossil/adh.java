package com.fossil;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.fossil.enn.C1611c;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

class adh implements adc {
    private final File aKc;
    private final int aKd;
    private enn aKe;

    public adh(File file, int i) {
        this.aKc = file;
        this.aKd = i;
    }

    public void mo826a(long j, String str) {
        yC();
        m3057b(j, str);
    }

    public acp ys() {
        if (!this.aKc.exists()) {
            return null;
        }
        yC();
        if (this.aKe == null) {
            return null;
        }
        final int[] iArr = new int[]{0};
        final byte[] bArr = new byte[this.aKe.aFC()];
        try {
            this.aKe.m10977a(new C1611c(this) {
                final /* synthetic */ adh aKh;

                public void mo834a(InputStream inputStream, int i) throws IOException {
                    try {
                        inputStream.read(bArr, iArr[0], i);
                        int[] iArr = iArr;
                        iArr[0] = iArr[0] + i;
                    } finally {
                        inputStream.close();
                    }
                }
            });
        } catch (Throwable e) {
            emm.aEU().mo2953g("Fabric", "A problem occurred while reading the Crashlytics log file.", e);
        }
        return acp.m2946b(bArr, 0, iArr[0]);
    }

    public void yt() {
        CommonUtils.a(this.aKe, "There was a problem closing the Crashlytics log file.");
        this.aKe = null;
    }

    public void yu() {
        yt();
        this.aKc.delete();
    }

    private void yC() {
        if (this.aKe == null) {
            try {
                this.aKe = new enn(this.aKc);
            } catch (Throwable e) {
                emm.aEU().mo2953g("Fabric", "Could not open log file: " + this.aKc, e);
            }
        }
    }

    private void m3057b(long j, String str) {
        if (this.aKe != null) {
            String str2;
            if (str == null) {
                str2 = "null";
            } else {
                str2 = str;
            }
            try {
                int i = this.aKd / 4;
                if (str2.length() > i) {
                    str2 = "..." + str2.substring(str2.length() - i);
                }
                str2 = str2.replaceAll("\r", MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).replaceAll("\n", MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                this.aKe.av(String.format(Locale.US, "%d %s%n", new Object[]{Long.valueOf(j), str2}).getBytes("UTF-8"));
                while (!this.aKe.isEmpty() && this.aKe.aFC() > this.aKd) {
                    this.aKe.remove();
                }
            } catch (Throwable e) {
                emm.aEU().mo2953g("Fabric", "There was a problem writing to the Crashlytics log.", e);
            }
        }
    }
}
