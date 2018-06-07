package com.fossil;

import com.squareup.okhttp.internal.framed.ErrorCode;
import java.io.IOException;

public interface dwg {
    public static final dwg dyL = new C32621();

    static class C32621 implements dwg {
        C32621() {
        }

        public void mo2753i(dwb com_fossil_dwb) throws IOException {
            com_fossil_dwb.m10080b(ErrorCode.REFUSED_STREAM);
        }
    }

    void mo2753i(dwb com_fossil_dwb) throws IOException;
}
