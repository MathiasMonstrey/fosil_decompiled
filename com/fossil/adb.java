package com.fossil;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.Closeable;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

final class adb {
    public static void m3022a(Throwable th, OutputStream outputStream) {
        if (outputStream != null) {
            m3025b(th, outputStream);
        }
    }

    private static void m3025b(Throwable th, OutputStream outputStream) {
        Throwable e;
        Closeable printWriter;
        try {
            printWriter = new PrintWriter(outputStream);
            try {
                m3023a(th, (Writer) printWriter);
                CommonUtils.a(printWriter, "Failed to close stack trace writer.");
            } catch (Exception e2) {
                e = e2;
                try {
                    emm.aEU().mo2953g("Fabric", "Failed to create PrintWriter", e);
                    CommonUtils.a(printWriter, "Failed to close stack trace writer.");
                } catch (Throwable th2) {
                    e = th2;
                    CommonUtils.a(printWriter, "Failed to close stack trace writer.");
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            printWriter = null;
            emm.aEU().mo2953g("Fabric", "Failed to create PrintWriter", e);
            CommonUtils.a(printWriter, "Failed to close stack trace writer.");
        } catch (Throwable th3) {
            e = th3;
            printWriter = null;
            CommonUtils.a(printWriter, "Failed to close stack trace writer.");
            throw e;
        }
    }

    private static void m3023a(Throwable th, Writer writer) {
        Object obj = 1;
        while (th != null) {
            try {
                String b = m3024b(th);
                writer.write((obj != null ? "" : "Caused by: ") + th.getClass().getName() + ": " + (b != null ? b : "") + "\n");
                for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                    writer.write("\tat " + stackTraceElement.toString() + "\n");
                }
                th = th.getCause();
                obj = null;
            } catch (Throwable e) {
                emm.aEU().mo2953g("Fabric", "Could not write stack trace", e);
                return;
            }
        }
    }

    private static String m3024b(Throwable th) {
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            return null;
        }
        return localizedMessage.replaceAll("(\r\n|\n|\f)", MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
    }
}
