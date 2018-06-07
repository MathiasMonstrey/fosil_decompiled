package com.fossil;

import com.squareup.okhttp.internal.framed.ErrorCode;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;

public interface dvz extends Closeable {
    void mo2739a(int i, ErrorCode errorCode) throws IOException;

    void mo2740a(int i, ErrorCode errorCode, byte[] bArr) throws IOException;

    void mo2741a(dwk com_fossil_dwk) throws IOException;

    void mo2742a(boolean z, int i, eth com_fossil_eth, int i2) throws IOException;

    void mo2743a(boolean z, boolean z2, int i, int i2, List<dwc> list) throws IOException;

    void azR() throws IOException;

    int azS();

    void mo2746b(int i, int i2, List<dwc> list) throws IOException;

    void mo2747b(dwk com_fossil_dwk) throws IOException;

    void mo2748c(boolean z, int i, int i2) throws IOException;

    void flush() throws IOException;

    void mo2750k(int i, long j) throws IOException;
}
