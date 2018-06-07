package com.fossil;

import com.squareup.okhttp.internal.framed.ErrorCode;
import com.squareup.okhttp.internal.framed.HeadersMode;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

public interface dvy extends Closeable {

    public interface C3238a {
        void mo2718a(int i, ErrorCode errorCode);

        void mo2719a(int i, ErrorCode errorCode, ByteString byteString);

        void mo2720a(boolean z, int i, etj com_fossil_etj, int i2) throws IOException;

        void mo2721a(boolean z, dwk com_fossil_dwk);

        void mo2722a(boolean z, boolean z2, int i, int i2, List<dwc> list, HeadersMode headersMode);

        void azQ();

        void mo2724b(int i, int i2, int i3, boolean z);

        void mo2725b(int i, int i2, List<dwc> list) throws IOException;

        void mo2726c(boolean z, int i, int i2);

        void mo2727k(int i, long j);
    }

    boolean mo2737a(C3238a c3238a) throws IOException;

    void azP() throws IOException;
}
