package com.fossil;

import java.lang.ref.WeakReference;

abstract class ayi extends ayg {
    private static final WeakReference<byte[]> bjr = new WeakReference(null);
    private WeakReference<byte[]> bjq = bjr;

    ayi(byte[] bArr) {
        super(bArr);
    }

    protected abstract byte[] LP();

    final byte[] getBytes() {
        byte[] bArr;
        synchronized (this) {
            bArr = (byte[]) this.bjq.get();
            if (bArr == null) {
                bArr = LP();
                this.bjq = new WeakReference(bArr);
            }
        }
        return bArr;
    }
}
