package com.misfit.ble.obfuscated;

import com.misfit.ble.obfuscated.cg.C4515a;
import java.io.File;

public class cf {

    public interface C4513a {
        void mo4933b(File file, C4515a c4515a, C4514b c4514b);
    }

    public enum C4514b {
        SUCCEEDED,
        NETWORK_UNAVAILABLE,
        UNEXPECTED
    }

    public static void m15012b(File file, C4513a c4513a) {
        C4514b c4514b;
        C4515a c4515a = null;
        if (file == null || !file.exists()) {
            c4514b = C4514b.UNEXPECTED;
        } else if (hd.m15183e(C4592s.getApplicationContext())) {
            c4515a = new cg(C4592s.m15228x().getEndPoint(), C4592s.m15228x().getAccessKey(), file).bN();
            c4514b = C4514b.SUCCEEDED;
        } else {
            c4514b = C4514b.NETWORK_UNAVAILABLE;
        }
        c4513a.mo4933b(file, c4515a, c4514b);
    }
}
