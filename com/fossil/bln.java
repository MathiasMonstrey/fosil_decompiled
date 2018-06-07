package com.fossil;

public final class bln {
    private static final ThreadLocal<String> bwe = new ThreadLocal();

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String dN(java.lang.String r10) {
        /*
        r9 = 461845907; // 0x1b873593 float:2.2368498E-22 double:2.281821963E-315;
        r8 = -862048943; // 0xffffffffcc9e2d51 float:-8.2930312E7 double:NaN;
        r1 = 0;
        r0 = bwe;
        r0 = r0.get();
        r0 = (java.lang.String) r0;
        if (r0 == 0) goto L_0x0019;
    L_0x0011:
        r2 = "com.google";
        r0 = r0.startsWith(r2);
        if (r0 == 0) goto L_0x001d;
    L_0x0019:
        r0 = 1;
    L_0x001a:
        if (r0 == 0) goto L_0x001f;
    L_0x001c:
        return r10;
    L_0x001d:
        r0 = r1;
        goto L_0x001a;
    L_0x001f:
        r0 = bwe;
        r0 = r0.get();
        r0 = (java.lang.String) r0;
        if (r10 == 0) goto L_0x001c;
    L_0x0029:
        if (r0 == 0) goto L_0x001c;
    L_0x002b:
        r2 = r10.length();
        r3 = r0.length();
        r2 = r2 + r3;
        r3 = new byte[r2];
        r2 = r10.getBytes();
        r4 = r10.length();
        java.lang.System.arraycopy(r2, r1, r3, r1, r4);
        r2 = r0.getBytes();
        r4 = r10.length();
        r0 = r0.length();
        java.lang.System.arraycopy(r2, r1, r3, r4, r0);
        r4 = r3.length;
        r0 = r4 & -4;
        r5 = r0 + 0;
        r0 = r1;
        r2 = r1;
    L_0x0057:
        if (r0 >= r5) goto L_0x008c;
    L_0x0059:
        r6 = r3[r0];
        r6 = r6 & 255;
        r7 = r0 + 1;
        r7 = r3[r7];
        r7 = r7 & 255;
        r7 = r7 << 8;
        r6 = r6 | r7;
        r7 = r0 + 2;
        r7 = r3[r7];
        r7 = r7 & 255;
        r7 = r7 << 16;
        r6 = r6 | r7;
        r7 = r0 + 3;
        r7 = r3[r7];
        r7 = r7 << 24;
        r6 = r6 | r7;
        r6 = r6 * r8;
        r7 = r6 << 15;
        r6 = r6 >>> 17;
        r6 = r6 | r7;
        r6 = r6 * r9;
        r2 = r2 ^ r6;
        r6 = r2 << 13;
        r2 = r2 >>> 19;
        r2 = r2 | r6;
        r2 = r2 * 5;
        r6 = -430675100; // 0xffffffffe6546b64 float:-2.5078068E23 double:NaN;
        r2 = r2 + r6;
        r0 = r0 + 4;
        goto L_0x0057;
    L_0x008c:
        r0 = r4 & 3;
        switch(r0) {
            case 1: goto L_0x00bb;
            case 2: goto L_0x00c9;
            case 3: goto L_0x00aa;
            default: goto L_0x0091;
        };
    L_0x0091:
        r0 = r2;
    L_0x0092:
        r0 = r0 ^ r4;
        r1 = r0 >>> 16;
        r0 = r0 ^ r1;
        r1 = -2048144789; // 0xffffffff85ebca6b float:-2.217365E-35 double:NaN;
        r0 = r0 * r1;
        r1 = r0 >>> 13;
        r0 = r0 ^ r1;
        r1 = -1028477387; // 0xffffffffc2b2ae35 float:-89.34025 double:NaN;
        r0 = r0 * r1;
        r1 = r0 >>> 16;
        r0 = r0 ^ r1;
        r10 = java.lang.Integer.toHexString(r0);
        goto L_0x001c;
    L_0x00aa:
        r0 = r5 + 2;
        r0 = r3[r0];
        r0 = r0 & 255;
        r0 = r0 << 16;
    L_0x00b2:
        r1 = r5 + 1;
        r1 = r3[r1];
        r1 = r1 & 255;
        r1 = r1 << 8;
        r1 = r1 | r0;
    L_0x00bb:
        r0 = r3[r5];
        r0 = r0 & 255;
        r0 = r0 | r1;
        r0 = r0 * r8;
        r1 = r0 << 15;
        r0 = r0 >>> 17;
        r0 = r0 | r1;
        r0 = r0 * r9;
        r0 = r0 ^ r2;
        goto L_0x0092;
    L_0x00c9:
        r0 = r1;
        goto L_0x00b2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.bln.dN(java.lang.String):java.lang.String");
    }
}
