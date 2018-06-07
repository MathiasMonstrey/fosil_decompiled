package com.flurry.sdk;

import com.fossil.app;
import com.fossil.aqi;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;

public class kf<ObjectType> {
    private static final String aWB = kf.class.getSimpleName();
    private aqi<ObjectType> baP;

    public enum C1537a {
        NONE(""),
        CRYPTO_ALGO_PADDING_7("AES/CBC/PKCS7Padding"),
        CRYPTO_ALGO_PADDING_5("AES/CBC/PKCS5Padding");
        
        String f1335d;

        private C1537a(String str) {
            this.f1335d = str;
        }

        public static C1537a m2778a(int i) {
            for (C1537a c1537a : C1537a.values()) {
                if (c1537a.ordinal() == i) {
                    return c1537a;
                }
            }
            return NONE;
        }
    }

    public kf(aqi<ObjectType> com_fossil_aqi_ObjectType) {
        this.baP = com_fossil_aqi_ObjectType;
    }

    public final byte[] m2780a(ObjectType objectType, Key key, IvParameterSpec ivParameterSpec, C1537a c1537a) throws IOException {
        GeneralSecurityException e;
        if (objectType == null || key == null || c1537a == null) {
            app.m4180g(5, aWB, "Cannot encrypt, invalid params.");
            return null;
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.baP.mo1105a(byteArrayOutputStream, objectType);
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        try {
            Cipher instance = Cipher.getInstance(c1537a.f1335d);
            instance.init(1, key, ivParameterSpec);
            return instance.doFinal(toByteArray);
        } catch (InvalidKeyException e2) {
            e = e2;
            app.m4180g(5, aWB, "Error in encrypt " + e.getMessage());
            return null;
        } catch (InvalidAlgorithmParameterException e3) {
            e = e3;
            app.m4180g(5, aWB, "Error in encrypt " + e.getMessage());
            return null;
        } catch (BadPaddingException e4) {
            e = e4;
            app.m4180g(5, aWB, "Error in encrypt " + e.getMessage());
            return null;
        } catch (IllegalBlockSizeException e5) {
            e = e5;
            app.m4180g(5, aWB, "Error in encrypt " + e.getMessage());
            return null;
        } catch (NoSuchAlgorithmException e6) {
            e = e6;
            app.m4180g(5, aWB, "Error in encrypt " + e.getMessage());
            return null;
        } catch (NoSuchPaddingException e7) {
            e = e7;
            app.m4180g(5, aWB, "Error in encrypt " + e.getMessage());
            return null;
        }
    }

    public final ObjectType m2779a(byte[] bArr, Key key, IvParameterSpec ivParameterSpec, C1537a c1537a) throws IOException {
        GeneralSecurityException e;
        if (bArr == null || key == null || c1537a == null) {
            app.m4180g(5, aWB, "Cannot decrypt, invalid params.");
            return null;
        }
        try {
            Cipher instance = Cipher.getInstance(c1537a.f1335d);
            instance.init(2, key, ivParameterSpec);
            return this.baP.mo1106j(new ByteArrayInputStream(instance.doFinal(bArr)));
        } catch (InvalidKeyException e2) {
            e = e2;
            app.m4180g(5, aWB, "Error in decrypt " + e.getMessage());
            return null;
        } catch (InvalidAlgorithmParameterException e3) {
            e = e3;
            app.m4180g(5, aWB, "Error in decrypt " + e.getMessage());
            return null;
        } catch (BadPaddingException e4) {
            e = e4;
            app.m4180g(5, aWB, "Error in decrypt " + e.getMessage());
            return null;
        } catch (IllegalBlockSizeException e5) {
            e = e5;
            app.m4180g(5, aWB, "Error in decrypt " + e.getMessage());
            return null;
        } catch (NoSuchAlgorithmException e6) {
            e = e6;
            app.m4180g(5, aWB, "Error in decrypt " + e.getMessage());
            return null;
        } catch (NoSuchPaddingException e7) {
            e = e7;
            app.m4180g(5, aWB, "Error in decrypt " + e.getMessage());
            return null;
        }
    }
}
