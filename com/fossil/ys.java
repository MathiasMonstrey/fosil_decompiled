package com.fossil;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.fossil.ud.C4136a;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Queue;

public class ys implements un<InputStream, yl> {
    private static final C4233b aEX = new C4233b();
    private static final C4232a aEY = new C4232a();
    private final C4233b aEZ;
    private final C4232a aFa;
    private final yk aFb;
    private final vl axR;
    private final Context context;

    static class C4232a {
        private final Queue<ud> aCN = abl.eR(0);

        C4232a() {
        }

        public synchronized ud m14097a(C4136a c4136a) {
            ud udVar;
            udVar = (ud) this.aCN.poll();
            if (udVar == null) {
                udVar = new ud(c4136a);
            }
            return udVar;
        }

        public synchronized void m14098a(ud udVar) {
            udVar.clear();
            this.aCN.offer(udVar);
        }
    }

    static class C4233b {
        private final Queue<ug> aCN = abl.eR(0);

        C4233b() {
        }

        public synchronized ug m14099J(byte[] bArr) {
            ug ugVar;
            ugVar = (ug) this.aCN.poll();
            if (ugVar == null) {
                ugVar = new ug();
            }
            return ugVar.m13817I(bArr);
        }

        public synchronized void m14100a(ug ugVar) {
            ugVar.clear();
            this.aCN.offer(ugVar);
        }
    }

    public ys(Context context, vl vlVar) {
        this(context, vlVar, aEX, aEY);
    }

    ys(Context context, vl vlVar, C4233b c4233b, C4232a c4232a) {
        this.context = context.getApplicationContext();
        this.axR = vlVar;
        this.aFa = c4232a;
        this.aFb = new yk(vlVar);
        this.aEZ = c4233b;
    }

    public yn m14105b(InputStream inputStream, int i, int i2) {
        byte[] e = m14103e(inputStream);
        ug J = this.aEZ.m14099J(e);
        ud a = this.aFa.m14097a(this.aFb);
        try {
            yn a2 = m14102a(e, i, i2, J, a);
            return a2;
        } finally {
            this.aEZ.m14100a(J);
            this.aFa.m14098a(a);
        }
    }

    private yn m14102a(byte[] bArr, int i, int i2, ug ugVar, ud udVar) {
        uf um = ugVar.um();
        if (um.ul() <= 0 || um.getStatus() != 0) {
            return null;
        }
        Bitmap a = m14101a(udVar, um, bArr);
        if (a == null) {
            return null;
        }
        return new yn(new yl(this.context, this.aFb, this.axR, xm.vC(), i, i2, um, bArr, a));
    }

    private Bitmap m14101a(ud udVar, uf ufVar, byte[] bArr) {
        udVar.m13816a(ufVar, bArr);
        udVar.advance();
        return udVar.ui();
    }

    public String getId() {
        return "";
    }

    private static byte[] m14103e(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byteArrayOutputStream.flush();
        } catch (Throwable e) {
            Log.w("GifResourceDecoder", "Error reading data from stream", e);
        }
        return byteArrayOutputStream.toByteArray();
    }
}
