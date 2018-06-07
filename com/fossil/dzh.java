package com.fossil;

public class dzh {
    private String aWB = null;
    private boolean aWE = false;
    private String aWR = null;
    private String aWS = null;
    private boolean f1480e = false;

    public boolean aCe() {
        return this.aWE;
    }

    public String aCf() {
        return this.aWR;
    }

    public boolean aCg() {
        return this.f1480e;
    }

    public String awy() {
        return this.aWB;
    }

    public String getVersion() {
        return this.aWS;
    }

    public void jU(String str) {
        this.aWB = str;
    }

    public String toString() {
        return "StatSpecifyReportedInfo [appKey=" + this.aWB + ", installChannel=" + this.aWR + ", version=" + this.aWS + ", sendImmediately=" + this.aWE + ", isImportant=" + this.f1480e + "]";
    }
}
