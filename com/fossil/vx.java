package com.fossil;

import android.content.Context;
import com.fossil.vv.C4171a;
import java.io.File;

public final class vx extends vv {

    class C41721 implements C4171a {
        final /* synthetic */ String aCU;
        final /* synthetic */ Context val$context;

        C41721(Context context, String str) {
            this.val$context = context;
            this.aCU = str;
        }

        public File vl() {
            File cacheDir = this.val$context.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            return this.aCU != null ? new File(cacheDir, this.aCU) : cacheDir;
        }
    }

    public vx(Context context) {
        this(context, "image_manager_disk_cache", 262144000);
    }

    public vx(Context context, String str, int i) {
        super(new C41721(context, str), i);
    }
}
