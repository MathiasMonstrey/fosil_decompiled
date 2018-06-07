package com.fossil;

import android.util.Log;
import com.facebook.internal.NativeProtocol;
import java.util.Queue;

public final class abe {
    private static final abe aGU = new abe();
    private final Queue<byte[]> aGT = abl.eR(0);

    public static abe wT() {
        return aGU;
    }

    private abe() {
    }

    public byte[] getBytes() {
        byte[] bArr;
        synchronized (this.aGT) {
            bArr = (byte[]) this.aGT.poll();
        }
        if (bArr == null) {
            bArr = new byte[NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST];
            if (Log.isLoggable("ByteArrayPool", 3)) {
                Log.d("ByteArrayPool", "Created temp bytes");
            }
        }
        return bArr;
    }

    public boolean m2855L(byte[] bArr) {
        boolean z = false;
        if (bArr.length == NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) {
            synchronized (this.aGT) {
                if (this.aGT.size() < 32) {
                    z = true;
                    this.aGT.offer(bArr);
                }
            }
        }
        return z;
    }
}
