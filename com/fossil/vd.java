package com.fossil;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

class vd implements ul {
    private final un aBW;
    private final un aBX;
    private final uo aBY;
    private final uk aBZ;
    private final zd aBq;
    private String aCa;
    private ul aCb;
    private final ul ayg;
    private final up ayv;
    private int hashCode;
    private final int height;
    private final String id;
    private final int width;

    public vd(String str, ul ulVar, int i, int i2, un unVar, un unVar2, up upVar, uo uoVar, zd zdVar, uk ukVar) {
        this.id = str;
        this.ayg = ulVar;
        this.width = i;
        this.height = i2;
        this.aBW = unVar;
        this.aBX = unVar2;
        this.ayv = upVar;
        this.aBY = uoVar;
        this.aBq = zdVar;
        this.aBZ = ukVar;
    }

    public ul uU() {
        if (this.aCb == null) {
            this.aCb = new vg(this.id, this.ayg);
        }
        return this.aCb;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        vd vdVar = (vd) obj;
        if (!this.id.equals(vdVar.id) || !this.ayg.equals(vdVar.ayg) || this.height != vdVar.height || this.width != vdVar.width) {
            return false;
        }
        if (((this.ayv == null ? 1 : 0) ^ (vdVar.ayv == null ? 1 : 0)) != 0) {
            return false;
        }
        if (this.ayv != null && !this.ayv.getId().equals(vdVar.ayv.getId())) {
            return false;
        }
        int i;
        if (this.aBX == null) {
            i = 1;
        } else {
            i = 0;
        }
        if ((i ^ (vdVar.aBX == null ? 1 : 0)) != 0) {
            return false;
        }
        if (this.aBX != null && !this.aBX.getId().equals(vdVar.aBX.getId())) {
            return false;
        }
        if (this.aBW == null) {
            i = 1;
        } else {
            i = 0;
        }
        if ((i ^ (vdVar.aBW == null ? 1 : 0)) != 0) {
            return false;
        }
        if (this.aBW != null && !this.aBW.getId().equals(vdVar.aBW.getId())) {
            return false;
        }
        if (this.aBY == null) {
            i = 1;
        } else {
            i = 0;
        }
        if ((i ^ (vdVar.aBY == null ? 1 : 0)) != 0) {
            return false;
        }
        if (this.aBY != null && !this.aBY.getId().equals(vdVar.aBY.getId())) {
            return false;
        }
        if (this.aBq == null) {
            i = 1;
        } else {
            i = 0;
        }
        if ((i ^ (vdVar.aBq == null ? 1 : 0)) != 0) {
            return false;
        }
        if (this.aBq != null && !this.aBq.getId().equals(vdVar.aBq.getId())) {
            return false;
        }
        if (this.aBZ == null) {
            i = 1;
        } else {
            i = 0;
        }
        if ((i ^ (vdVar.aBZ == null ? 1 : 0)) != 0) {
            return false;
        }
        if (this.aBZ == null || this.aBZ.getId().equals(vdVar.aBZ.getId())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        if (this.hashCode == 0) {
            int hashCode;
            this.hashCode = this.id.hashCode();
            this.hashCode = (this.hashCode * 31) + this.ayg.hashCode();
            this.hashCode = (this.hashCode * 31) + this.width;
            this.hashCode = (this.hashCode * 31) + this.height;
            this.hashCode = (this.aBW != null ? this.aBW.getId().hashCode() : 0) + (this.hashCode * 31);
            int i2 = this.hashCode * 31;
            if (this.aBX != null) {
                hashCode = this.aBX.getId().hashCode();
            } else {
                hashCode = 0;
            }
            this.hashCode = hashCode + i2;
            i2 = this.hashCode * 31;
            if (this.ayv != null) {
                hashCode = this.ayv.getId().hashCode();
            } else {
                hashCode = 0;
            }
            this.hashCode = hashCode + i2;
            i2 = this.hashCode * 31;
            if (this.aBY != null) {
                hashCode = this.aBY.getId().hashCode();
            } else {
                hashCode = 0;
            }
            this.hashCode = hashCode + i2;
            i2 = this.hashCode * 31;
            if (this.aBq != null) {
                hashCode = this.aBq.getId().hashCode();
            } else {
                hashCode = 0;
            }
            this.hashCode = hashCode + i2;
            hashCode = this.hashCode * 31;
            if (this.aBZ != null) {
                i = this.aBZ.getId().hashCode();
            }
            this.hashCode = hashCode + i;
        }
        return this.hashCode;
    }

    public String toString() {
        if (this.aCa == null) {
            String id;
            StringBuilder append = new StringBuilder().append("EngineKey{").append(this.id).append('+').append(this.ayg).append("+[").append(this.width).append('x').append(this.height).append("]+").append('\'');
            if (this.aBW != null) {
                id = this.aBW.getId();
            } else {
                id = "";
            }
            append = append.append(id).append('\'').append('+').append('\'');
            if (this.aBX != null) {
                id = this.aBX.getId();
            } else {
                id = "";
            }
            append = append.append(id).append('\'').append('+').append('\'');
            if (this.ayv != null) {
                id = this.ayv.getId();
            } else {
                id = "";
            }
            append = append.append(id).append('\'').append('+').append('\'');
            if (this.aBY != null) {
                id = this.aBY.getId();
            } else {
                id = "";
            }
            append = append.append(id).append('\'').append('+').append('\'');
            if (this.aBq != null) {
                id = this.aBq.getId();
            } else {
                id = "";
            }
            append = append.append(id).append('\'').append('+').append('\'');
            if (this.aBZ != null) {
                id = this.aBZ.getId();
            } else {
                id = "";
            }
            this.aCa = append.append(id).append('\'').append('}').toString();
        }
        return this.aCa;
    }

    public void mo4200a(MessageDigest messageDigest) throws UnsupportedEncodingException {
        byte[] array = ByteBuffer.allocate(8).putInt(this.width).putInt(this.height).array();
        this.ayg.mo4200a(messageDigest);
        messageDigest.update(this.id.getBytes("UTF-8"));
        messageDigest.update(array);
        messageDigest.update((this.aBW != null ? this.aBW.getId() : "").getBytes("UTF-8"));
        messageDigest.update((this.aBX != null ? this.aBX.getId() : "").getBytes("UTF-8"));
        messageDigest.update((this.ayv != null ? this.ayv.getId() : "").getBytes("UTF-8"));
        messageDigest.update((this.aBY != null ? this.aBY.getId() : "").getBytes("UTF-8"));
        messageDigest.update((this.aBZ != null ? this.aBZ.getId() : "").getBytes("UTF-8"));
    }
}
