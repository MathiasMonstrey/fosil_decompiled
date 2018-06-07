package com.fossil;

import android.graphics.Bitmap;
import android.util.Log;
import com.fossil.ud.C4136a;
import java.io.OutputStream;

public class yt implements uo<yl> {
    private static final C4234a aFc = new C4234a();
    private final C4136a aFd;
    private final C4234a aFe;
    private final vl axR;

    static class C4234a {
        C4234a() {
        }

        public ud m14106b(C4136a c4136a) {
            return new ud(c4136a);
        }

        public ug wc() {
            return new ug();
        }

        public uh wd() {
            return new uh();
        }

        public vh<Bitmap> m14107b(Bitmap bitmap, vl vlVar) {
            return new xp(bitmap, vlVar);
        }
    }

    public boolean m14111a(com.fossil.vh<com.fossil.yl> r11, java.io.OutputStream r12) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r10 = this;
        r3 = 0;
        r4 = com.fossil.abh.wV();
        r0 = r11.get();
        r0 = (com.fossil.yl) r0;
        r6 = r0.vV();
        r1 = r6 instanceof com.fossil.xm;
        if (r1 == 0) goto L_0x001c;
    L_0x0013:
        r0 = r0.getData();
        r3 = r10.m14110a(r0, r12);
    L_0x001b:
        return r3;
    L_0x001c:
        r1 = r0.getData();
        r7 = r10.m14108K(r1);
        r1 = r10.aFe;
        r8 = r1.wd();
        r1 = r8.m13818a(r12);
        if (r1 == 0) goto L_0x001b;
    L_0x0030:
        r2 = r3;
    L_0x0031:
        r1 = r7.getFrameCount();
        if (r2 >= r1) goto L_0x0069;
    L_0x0037:
        r1 = r7.ui();
        r9 = r10.m14109a(r1, r6, r0);
        r1 = r9.get();	 Catch:{ all -> 0x0064 }
        r1 = (android.graphics.Bitmap) r1;	 Catch:{ all -> 0x0064 }
        r1 = r8.m13819e(r1);	 Catch:{ all -> 0x0064 }
        if (r1 != 0) goto L_0x004f;
    L_0x004b:
        r9.recycle();
        goto L_0x001b;
    L_0x004f:
        r1 = r7.ug();	 Catch:{ all -> 0x0064 }
        r1 = r7.eB(r1);	 Catch:{ all -> 0x0064 }
        r8.eD(r1);	 Catch:{ all -> 0x0064 }
        r7.advance();	 Catch:{ all -> 0x0064 }
        r9.recycle();
        r1 = r2 + 1;
        r2 = r1;
        goto L_0x0031;
    L_0x0064:
        r0 = move-exception;
        r9.recycle();
        throw r0;
    L_0x0069:
        r3 = r8.ux();
        r1 = "GifEncoder";
        r2 = 2;
        r1 = android.util.Log.isLoggable(r1, r2);
        if (r1 == 0) goto L_0x001b;
    L_0x0076:
        r1 = "GifEncoder";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r6 = "Encoded gif with ";
        r2 = r2.append(r6);
        r6 = r7.getFrameCount();
        r2 = r2.append(r6);
        r6 = " frames and ";
        r2 = r2.append(r6);
        r0 = r0.getData();
        r0 = r0.length;
        r0 = r2.append(r0);
        r2 = " bytes in ";
        r0 = r0.append(r2);
        r4 = com.fossil.abh.v(r4);
        r0 = r0.append(r4);
        r2 = " ms";
        r0 = r0.append(r2);
        r0 = r0.toString();
        android.util.Log.v(r1, r0);
        goto L_0x001b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.yt.a(com.fossil.vh, java.io.OutputStream):boolean");
    }

    public yt(vl vlVar) {
        this(vlVar, aFc);
    }

    yt(vl vlVar, C4234a c4234a) {
        this.axR = vlVar;
        this.aFd = new yk(vlVar);
        this.aFe = c4234a;
    }

    private boolean m14110a(byte[] bArr, OutputStream outputStream) {
        try {
            outputStream.write(bArr);
            return true;
        } catch (Throwable e) {
            if (Log.isLoggable("GifEncoder", 3)) {
                Log.d("GifEncoder", "Failed to write data to output stream in GifResourceEncoder", e);
            }
            return false;
        }
    }

    private ud m14108K(byte[] bArr) {
        ug wc = this.aFe.wc();
        wc.m13817I(bArr);
        uf um = wc.um();
        ud b = this.aFe.m14106b(this.aFd);
        b.m13816a(um, bArr);
        b.advance();
        return b;
    }

    private vh<Bitmap> m14109a(Bitmap bitmap, up<Bitmap> upVar, yl ylVar) {
        vh b = this.aFe.m14107b(bitmap, this.axR);
        vh<Bitmap> a = upVar.mo4427a(b, ylVar.getIntrinsicWidth(), ylVar.getIntrinsicHeight());
        if (!b.equals(a)) {
            b.recycle();
        }
        return a;
    }

    public String getId() {
        return "";
    }
}
