package com.fossil;

import android.util.Log;
import com.fossil.ua.C4132a;
import com.fossil.ua.C4134c;
import com.fossil.vs.C4142b;
import java.io.File;
import java.io.IOException;

public class vw implements vs {
    private static vw aCQ = null;
    private final int Qq;
    private final vu aCR = new vu();
    private final wb aCS;
    private ua aCT;
    private final File directory;

    public static synchronized vs m13964a(File file, int i) {
        vs vsVar;
        synchronized (vw.class) {
            if (aCQ == null) {
                aCQ = new vw(file, i);
            }
            vsVar = aCQ;
        }
        return vsVar;
    }

    protected vw(File file, int i) {
        this.directory = file;
        this.Qq = i;
        this.aCS = new wb();
    }

    private synchronized ua vm() throws IOException {
        if (this.aCT == null) {
            this.aCT = ua.m13798a(this.directory, 1, 1, (long) this.Qq);
        }
        return this.aCT;
    }

    public File mo4222f(ul ulVar) {
        File file = null;
        try {
            C4134c aj = vm().aj(this.aCS.m13979k(ulVar));
            if (aj != null) {
                file = aj.ey(0);
            }
        } catch (Throwable e) {
            if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e);
            }
        }
        return file;
    }

    public void mo4221a(ul ulVar, C4142b c4142b) {
        C4132a ak;
        String k = this.aCS.m13979k(ulVar);
        this.aCR.m13962h(ulVar);
        try {
            ak = vm().ak(k);
            if (ak != null) {
                if (c4142b.mo4194p(ak.ey(0))) {
                    ak.commit();
                }
                ak.ub();
            }
            this.aCR.m13963i(ulVar);
        } catch (Throwable e) {
            try {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e);
                }
                this.aCR.m13963i(ulVar);
            } catch (Throwable th) {
                this.aCR.m13963i(ulVar);
            }
        } catch (Throwable th2) {
            ak.ub();
        }
    }

    public void mo4223g(ul ulVar) {
        try {
            vm().al(this.aCS.m13979k(ulVar));
        } catch (Throwable e) {
            if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Log.w("DiskLruCacheWrapper", "Unable to delete from disk cache", e);
            }
        }
    }
}
