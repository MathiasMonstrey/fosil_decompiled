package com.fossil;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.security.keystore.KeyGenParameterSpec.Builder;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.crypto.KeyGenerator;

public class aoz {
    private static final String aWB = aoz.class.getSimpleName();
    private KeyStore bax;

    @TargetApi(23)
    public aoz() {
        Throwable e;
        if (VERSION.SDK_INT >= 23) {
            try {
                this.bax = KeyStore.getInstance("AndroidKeyStore");
                this.bax.load(null);
                if (!this.bax.containsAlias("fl.install.id.sec.key")) {
                    KeyGenerator instance = KeyGenerator.getInstance("AES", "AndroidKeyStore");
                    instance.init(new Builder("fl.install.id.sec.key", 3).setBlockModes(new String[]{"CBC"}).setEncryptionPaddings(new String[]{"PKCS7Padding"}).setRandomizedEncryptionRequired(false).setDigests(new String[]{"SHA-256", "SHA-512"}).build());
                    instance.generateKey();
                }
            } catch (NoSuchAlgorithmException e2) {
                e = e2;
                app.m4174b(5, aWB, "Error while generating Key" + e.getMessage(), e);
            } catch (NoSuchProviderException e3) {
                e = e3;
                app.m4174b(5, aWB, "Error while generating Key" + e.getMessage(), e);
            } catch (InvalidAlgorithmParameterException e4) {
                e = e4;
                app.m4174b(5, aWB, "Error while generating Key" + e.getMessage(), e);
            } catch (CertificateException e5) {
                e = e5;
                app.m4174b(5, aWB, "Error while generating Key" + e.getMessage(), e);
            } catch (KeyStoreException e6) {
                e = e6;
                app.m4174b(5, aWB, "Error while generating Key" + e.getMessage(), e);
            } catch (IOException e7) {
                e = e7;
                app.m4174b(5, aWB, "Error while generating Key" + e.getMessage(), e);
            }
        }
    }

    public final Key IJ() {
        Key key = null;
        if (VERSION.SDK_INT >= 23 && this.bax != null) {
            try {
                key = this.bax.getKey("fl.install.id.sec.key", null);
            } catch (KeyStoreException e) {
                app.m4180g(6, aWB, "Error in getting key.");
                return key;
            } catch (UnrecoverableKeyException e2) {
                app.m4180g(6, aWB, "Error in getting key.");
                return key;
            } catch (NoSuchAlgorithmException e3) {
                app.m4180g(6, aWB, "Error in getting key.");
                return key;
            }
        }
        return key;
    }
}
