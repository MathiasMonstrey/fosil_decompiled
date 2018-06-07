package com.fossil;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public final class aqu {
    private static String aWB = aqu.class.getSimpleName();

    @TargetApi(21)
    public static File IG() {
        File noBackupFilesDir;
        Context context = apc.IO().baD;
        if (aqv.m4254c()) {
            noBackupFilesDir = context.getNoBackupFilesDir();
        } else {
            noBackupFilesDir = new File(context.getFilesDir().getPath() + File.separator + "no_backup");
        }
        return new File(noBackupFilesDir.getPath() + File.separator + ".flurryNoBackup");
    }

    public static boolean m4247t(File file) {
        if (file == null || file.getAbsoluteFile() == null) {
            return false;
        }
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            return true;
        }
        if (parentFile.mkdirs() || parentFile.isDirectory()) {
            return true;
        }
        app.m4180g(6, aWB, "Unable to create persistent dir: " + parentFile);
        return false;
    }

    public static boolean m4248u(File file) {
        if (file != null && file.isDirectory()) {
            for (String file2 : file.list()) {
                if (!m4248u(new File(file, file2))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    @Deprecated
    public static String m4249v(File file) {
        StringBuilder stringBuilder;
        Throwable th;
        Throwable th2;
        if (file == null || !file.exists()) {
            app.m4180g(4, aWB, "Persistent file doesn't exist.");
            return null;
        }
        app.m4180g(4, aWB, "Loading persistent data: " + file.getAbsolutePath());
        Closeable fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                stringBuilder = new StringBuilder();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    stringBuilder.append(new String(bArr, 0, read));
                }
                aqv.m4252a(fileInputStream);
            } catch (Throwable th3) {
                th = th3;
                try {
                    app.m4174b(6, aWB, "Error when loading persistent file", th);
                    aqv.m4252a(fileInputStream);
                    stringBuilder = null;
                    if (stringBuilder != null) {
                        return null;
                    }
                    return stringBuilder.toString();
                } catch (Throwable th4) {
                    th2 = th4;
                    aqv.m4252a(fileInputStream);
                    throw th2;
                }
            }
        } catch (Throwable th5) {
            fileInputStream = null;
            th2 = th5;
            aqv.m4252a(fileInputStream);
            throw th2;
        }
        if (stringBuilder != null) {
            return stringBuilder.toString();
        }
        return null;
    }

    @Deprecated
    public static void m4246b(File file, String str) {
        Throwable th;
        if (file == null) {
            app.m4180g(4, aWB, "No persistent file specified.");
        } else if (str == null) {
            app.m4180g(4, aWB, "No data specified; deleting persistent file: " + file.getAbsolutePath());
            file.delete();
        } else {
            app.m4180g(4, aWB, "Writing persistent data: " + file.getAbsolutePath());
            Closeable fileOutputStream;
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    fileOutputStream.write(str.getBytes());
                    aqv.m4252a(fileOutputStream);
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        app.m4174b(6, aWB, "Error writing persistent file", th);
                        aqv.m4252a(fileOutputStream);
                    } catch (Throwable th3) {
                        th = th3;
                        aqv.m4252a(fileOutputStream);
                        throw th;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                aqv.m4252a(fileOutputStream);
                throw th;
            }
        }
    }
}
