package com.fossil;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

public class abd implements ul {
    private final String aGS;

    public abd(String str) {
        if (str == null) {
            throw new NullPointerException("Signature cannot be null!");
        }
        this.aGS = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.aGS.equals(((abd) obj).aGS);
    }

    public int hashCode() {
        return this.aGS.hashCode();
    }

    public void m2854a(MessageDigest messageDigest) throws UnsupportedEncodingException {
        messageDigest.update(this.aGS.getBytes("UTF-8"));
    }

    public String toString() {
        return "StringSignature{signature='" + this.aGS + '\'' + '}';
    }
}
