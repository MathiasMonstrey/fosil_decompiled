package com.misfit.ble.obfuscated;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.util.Base64;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class C4589k {
    private static String CHARSET = "UTF-8";
    private static String f1572N = "AES";
    private static String f1573O = "AES/CBC/PKCS5PADDING";
    private static String f1574P = "com.misfitwearables.ble.encryption.TextEncryption";
    private static String f1575Q = "text_encryption_secret_key";
    private static String f1576R = "text_encryption_key";

    @SuppressLint({"TrulyRandom"})
    private static SecretKey generateKey() throws NoSuchAlgorithmException {
        SecureRandom secureRandom = new SecureRandom();
        KeyGenerator instance = KeyGenerator.getInstance(f1572N);
        instance.init(256, secureRandom);
        return instance.generateKey();
    }

    private static byte[] m15218s() throws NoSuchAlgorithmException {
        SharedPreferences I = ha.m15158I(f1574P);
        String string = I.getString(f1575Q, null);
        if (string == null) {
            string = I.getString(f1576R, null);
            I.edit().putString(f1575Q, string).apply();
        }
        if (string == null) {
            string = Base64.encodeToString(C4589k.generateKey().getEncoded(), 0);
            I.edit().putString(f1575Q, string).apply();
        }
        return Base64.decode(string, 0);
    }

    private static byte[] m15219t() throws NoSuchAlgorithmException, NoSuchProviderException {
        return new byte[16];
    }

    private static byte[] m15214a(byte[] bArr, byte[] bArr2) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, NoSuchProviderException {
        Key secretKeySpec = new SecretKeySpec(bArr, f1572N);
        Cipher instance = Cipher.getInstance(f1573O);
        instance.init(1, secretKeySpec, new IvParameterSpec(C4589k.m15219t()));
        return instance.doFinal(bArr2);
    }

    private static byte[] m15215b(byte[] bArr, byte[] bArr2) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, NoSuchProviderException {
        Key secretKeySpec = new SecretKeySpec(bArr, f1572N);
        Cipher instance = Cipher.getInstance(f1573O);
        instance.init(2, secretKeySpec, new IvParameterSpec(C4589k.m15219t()));
        return instance.doFinal(bArr2);
    }

    public static String m15216d(String str) {
        String str2 = null;
        try {
            str2 = Base64.encodeToString(C4589k.m15214a(C4589k.m15218s(), str.getBytes(CHARSET)), 0);
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return str2;
    }

    public static String m15217e(String str) {
        try {
            return new String(C4589k.m15215b(C4589k.m15218s(), Base64.decode(str, 0)), CHARSET);
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
            return null;
        }
    }
}
