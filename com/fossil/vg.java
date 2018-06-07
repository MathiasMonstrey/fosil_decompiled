package com.fossil;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

class vg implements ul {
    private final ul ayg;
    private final String id;

    public vg(String str, ul ulVar) {
        this.id = str;
        this.ayg = ulVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        vg vgVar = (vg) obj;
        if (!this.id.equals(vgVar.id)) {
            return false;
        }
        if (this.ayg.equals(vgVar.ayg)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + this.ayg.hashCode();
    }

    public void mo4200a(MessageDigest messageDigest) throws UnsupportedEncodingException {
        messageDigest.update(this.id.getBytes("UTF-8"));
        this.ayg.mo4200a(messageDigest);
    }
}
