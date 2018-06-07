package com.fossil;

public class aai implements aad, aae {
    private aad aGt;
    private aad aGu;
    private aae aGv;

    public aai() {
        this(null);
    }

    public aai(aae com_fossil_aae) {
        this.aGv = com_fossil_aae;
    }

    public void m2816a(aad com_fossil_aad, aad com_fossil_aad2) {
        this.aGt = com_fossil_aad;
        this.aGu = com_fossil_aad2;
    }

    public boolean mo771c(aad com_fossil_aad) {
        return wE() && (com_fossil_aad.equals(this.aGt) || !this.aGt.wu());
    }

    private boolean wE() {
        return this.aGv == null || this.aGv.mo771c(this);
    }

    public boolean mo772d(aad com_fossil_aad) {
        return wF() && com_fossil_aad.equals(this.aGt) && !wC();
    }

    private boolean wF() {
        return this.aGv == null || this.aGv.mo772d(this);
    }

    public boolean wC() {
        return wG() || wu();
    }

    public void mo773e(aad com_fossil_aad) {
        if (!com_fossil_aad.equals(this.aGu)) {
            if (this.aGv != null) {
                this.aGv.mo773e(this);
            }
            if (!this.aGu.isComplete()) {
                this.aGu.clear();
            }
        }
    }

    private boolean wG() {
        return this.aGv != null && this.aGv.wC();
    }

    public void begin() {
        if (!this.aGu.isRunning()) {
            this.aGu.begin();
        }
        if (!this.aGt.isRunning()) {
            this.aGt.begin();
        }
    }

    public void pause() {
        this.aGt.pause();
        this.aGu.pause();
    }

    public void clear() {
        this.aGu.clear();
        this.aGt.clear();
    }

    public boolean isRunning() {
        return this.aGt.isRunning();
    }

    public boolean isComplete() {
        return this.aGt.isComplete() || this.aGu.isComplete();
    }

    public boolean wu() {
        return this.aGt.wu() || this.aGu.wu();
    }

    public boolean isCancelled() {
        return this.aGt.isCancelled();
    }

    public void recycle() {
        this.aGt.recycle();
        this.aGu.recycle();
    }
}
