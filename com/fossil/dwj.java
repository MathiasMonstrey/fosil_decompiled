package com.fossil;

import com.squareup.okhttp.internal.framed.ErrorCode;
import java.io.IOException;
import java.util.List;

public interface dwj {
    public static final dwj dyR = new C32651();

    static class C32651 implements dwj {
        C32651() {
        }

        public boolean mo2756d(int i, List<dwc> list) {
            return true;
        }

        public boolean mo2755b(int i, List<dwc> list, boolean z) {
            return true;
        }

        public boolean mo2754b(int i, etj com_fossil_etj, int i2, boolean z) throws IOException {
            com_fossil_etj.bh((long) i2);
            return true;
        }

        public void mo2757e(int i, ErrorCode errorCode) {
        }
    }

    boolean mo2754b(int i, etj com_fossil_etj, int i2, boolean z) throws IOException;

    boolean mo2755b(int i, List<dwc> list, boolean z);

    boolean mo2756d(int i, List<dwc> list);

    void mo2757e(int i, ErrorCode errorCode);
}
