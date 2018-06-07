package com.fossil;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.Log;
import java.io.File;

public final class axx {
    @TargetApi(21)
    public static File aw(Context context) {
        return axt.LJ() ? context.getNoBackupFilesDir() : m4688x(new File(context.getApplicationInfo().dataDir, "no_backup"));
    }

    private static synchronized File m4688x(File file) {
        synchronized (axx.class) {
            if (!(file.exists() || file.mkdirs() || file.exists())) {
                String str = "SupportV4Utils";
                String str2 = "Unable to create no-backup dir ";
                String valueOf = String.valueOf(file.getPath());
                Log.w(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                file = null;
            }
        }
        return file;
    }
}
