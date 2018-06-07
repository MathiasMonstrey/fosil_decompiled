package com.fossil;

import android.os.Process;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.IdManager;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

class acq {
    private static final AtomicLong aIx = new AtomicLong(0);
    private static String aIy;

    public acq(IdManager idManager) {
        r0 = new byte[10];
        m2950N(r0);
        m2951O(r0);
        m2952P(r0);
        String mi = CommonUtils.mi(idManager.aFt());
        String au = CommonUtils.au(r0);
        aIy = String.format(Locale.US, "%s-%s-%s-%s", new Object[]{au.substring(0, 12), au.substring(12, 16), au.subSequence(16, 20), mi.substring(0, 12)}).toUpperCase(Locale.US);
    }

    private void m2950N(byte[] bArr) {
        long time = new Date().getTime();
        long j = time / 1000;
        time %= 1000;
        byte[] D = m2948D(j);
        bArr[0] = D[0];
        bArr[1] = D[1];
        bArr[2] = D[2];
        bArr[3] = D[3];
        byte[] E = m2949E(time);
        bArr[4] = E[0];
        bArr[5] = E[1];
    }

    private void m2951O(byte[] bArr) {
        byte[] E = m2949E(aIx.incrementAndGet());
        bArr[6] = E[0];
        bArr[7] = E[1];
    }

    private void m2952P(byte[] bArr) {
        byte[] E = m2949E((long) Integer.valueOf(Process.myPid()).shortValue());
        bArr[8] = E[0];
        bArr[9] = E[1];
    }

    private static byte[] m2948D(long j) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt((int) j);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    private static byte[] m2949E(long j) {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.putShort((short) ((int) j));
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    public String toString() {
        return aIy;
    }
}
