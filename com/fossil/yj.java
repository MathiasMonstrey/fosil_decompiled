package com.fossil;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class yj implements zx<InputStream, File> {
    private static final C4224a aEz = new C4224a();
    private final un<File, File> aBW = new yg();
    private final uk<InputStream> aBt = new ws();

    static class C4224a implements un<InputStream, File> {
        private C4224a() {
        }

        public /* synthetic */ vh mo4436b(Object obj, int i, int i2) throws IOException {
            return m14079a((InputStream) obj, i, i2);
        }

        public vh<File> m14079a(InputStream inputStream, int i, int i2) {
            throw new Error("You cannot decode a File from an InputStream by default, try either #diskCacheStratey(DiskCacheStrategy.SOURCE) to avoid this call or #decoder(ResourceDecoder) to replace this Decoder");
        }

        public String getId() {
            return "";
        }
    }

    public un<File, File> vF() {
        return this.aBW;
    }

    public un<InputStream, File> vG() {
        return aEz;
    }

    public uk<InputStream> vH() {
        return this.aBt;
    }

    public uo<File> vI() {
        return xk.vB();
    }
}
