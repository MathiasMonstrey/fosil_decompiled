package com.fossil;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.flurry.sdk.kf;
import com.flurry.sdk.kf.C1537a;
import com.fossil.aox.C1782a;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Locale;
import java.util.UUID;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class aoy {
    private static final String aWB = aoy.class.getSimpleName();
    private aoz bas;
    private byte[] bat;
    private final kf<byte[]> bau;
    private api<aox> bav;
    private int f1436c;

    class C17831 implements aqk<aox> {
        final /* synthetic */ aoy baw;

        C17831(aoy com_fossil_aoy) {
            this.baw = com_fossil_aoy;
        }

        public final aqi<aox> hi(int i) {
            return new C1782a();
        }
    }

    public aoy() {
        this.bas = null;
        this.f1436c = 0;
        this.bat = null;
        this.bav = null;
        this.bav = new api(IG(), "installationNum", 1, new C17831(this));
        this.bau = new kf(new aqe());
        this.bas = new aoz();
        byte[] a = m4133a(IH());
        if (a != null && VERSION.SDK_INT >= 23) {
            aqu.m4248u(IG());
            m4132a(a, C1537a.CRYPTO_ALGO_PADDING_7);
        }
        Ii();
    }

    public final byte[] Ii() {
        byte[] bArr = null;
        byte[] bArr2 = this.bat;
        if (bArr2 != null) {
            return bArr2;
        }
        C1537a c1537a;
        if (VERSION.SDK_INT < 23) {
            c1537a = C1537a.CRYPTO_ALGO_PADDING_5;
        } else {
            c1537a = C1537a.CRYPTO_ALGO_PADDING_7;
        }
        byte[] a = m4133a(II());
        if (a == null) {
            Object toLowerCase = UUID.randomUUID().toString().toLowerCase(Locale.ENGLISH);
            if (!TextUtils.isEmpty(toLowerCase)) {
                String replaceAll = toLowerCase.replaceAll("[^a-f0-9]+", "");
                if (replaceAll.length() % 2 != 0) {
                    app.m4180g(4, aWB, "Input string must contain an even number of characters " + replaceAll);
                } else {
                    bArr = aqv.cA(replaceAll);
                }
            }
            m4132a(bArr, c1537a);
        } else {
            bArr = a;
        }
        this.bat = bArr;
        return bArr;
    }

    private boolean m4132a(byte[] bArr, C1537a c1537a) {
        try {
            Object com_fossil_aox;
            aqu.m4248u(IG());
            byte[] If = If();
            byte[] a = this.bau.m2780a((Object) bArr, II(), new IvParameterSpec(If), c1537a);
            if (a != null) {
                com_fossil_aox = new aox(a, If, true, c1537a.ordinal());
            } else {
                com_fossil_aox = new aox(bArr, new byte[0], false, c1537a.ordinal());
            }
            this.bav.bJ(com_fossil_aox);
            return true;
        } catch (Throwable e) {
            app.m4174b(5, aWB, "Error while generating UUID" + e.getMessage(), e);
            return false;
        }
    }

    private byte[] m4133a(Key key) {
        try {
            aox com_fossil_aox = (aox) this.bav.IV();
            if (com_fossil_aox == null) {
                return null;
            }
            if (!com_fossil_aox.aXk) {
                return com_fossil_aox.aXJ;
            }
            byte[] bArr;
            byte[] bArr2 = com_fossil_aox.baq;
            byte[] bArr3 = com_fossil_aox.aXJ;
            C1537a a = C1537a.m2778a(com_fossil_aox.f1435d);
            if (bArr2 == null || bArr3 == null) {
                bArr = null;
            } else {
                bArr = (byte[]) this.bau.m2779a(bArr3, key, new IvParameterSpec(bArr2), a);
            }
            return bArr;
        } catch (IOException e) {
            app.m4180g(5, aWB, "Error while reading Android Install Id. Deleting file.");
            return null;
        }
    }

    private static File IG() {
        return new File(aqu.IG().getPath() + File.separator + "installationNum");
    }

    private static SecretKey IH() {
        Throwable e;
        String str = apc.IO().f1440d;
        long j = Long.MIN_VALUE;
        Object Y = aqs.m4244Y(apc.IO().baD);
        if (!TextUtils.isEmpty(Y)) {
            j = aqv.cC(Y);
        }
        try {
            return new SecretKeySpec(SecretKeyFactory.getInstance("PBEWithSHA256And256BitAES-CBC-BC").generateSecret(new PBEKeySpec(str.toCharArray(), ByteBuffer.allocate(8).putLong(j).array(), 1000, 256)).getEncoded(), "AES");
        } catch (InvalidKeySpecException e2) {
            e = e2;
        } catch (NoSuchAlgorithmException e3) {
            e = e3;
        }
        app.m4174b(4, aWB, "Error in generate secret key", e);
        return null;
    }

    private Key II() {
        if (VERSION.SDK_INT < 23) {
            return IH();
        }
        return this.bas.IJ();
    }

    private static byte[] If() {
        try {
            byte[] bArr = new byte[16];
            SecureRandom.getInstance("SHA1PRNG").nextBytes(bArr);
            return bArr;
        } catch (Throwable e) {
            app.m4174b(4, aWB, "Error in generating iv", e);
            return null;
        }
    }
}
