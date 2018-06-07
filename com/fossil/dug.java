package com.fossil;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class dug {
    public static String ke(String str) {
        try {
            byte[] kg = kg(str);
            Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
            instance.init(2, kf("Stark"));
            try {
                return new String(instance.doFinal(kg), "utf-8");
            } catch (Exception e) {
                duj.m9770e("Decrypt", e.getMessage());
                return null;
            }
        } catch (Exception e2) {
            duj.m9770e("Decrypt", e2.getMessage());
            return null;
        }
    }

    protected static Key kf(String str) {
        try {
            String substring = duk.kn(str).substring(2, 18);
            if (substring == null) {
                duj.m9772v("Decrypt", "Key为空null");
                return null;
            } else if (substring.length() == 16) {
                return new SecretKeySpec(substring.getBytes("utf-8"), "AES");
            } else {
                duj.m9772v("Decrypt", "Key长度不是16位");
                return null;
            }
        } catch (Exception e) {
            duj.m9770e("generateKey", e.getMessage());
            return null;
        }
    }

    private static byte[] kg(String str) {
        return dui.decode(str.getBytes());
    }
}
