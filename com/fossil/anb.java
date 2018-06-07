package com.fossil;

import android.content.Context;
import java.io.File;
import java.util.List;
import java.util.Map;

public class anb {
    private static final String aWR = anb.class.getSimpleName();
    private String aWX;
    private final anc aXi;
    private final File aXj;
    boolean aXk;

    public anb() {
        this(apc.IO().baD);
    }

    public anb(Context context) {
        this.aXi = new anc();
        this.aXj = context.getFileStreamPath(".flurryinstallreceiver.");
        app.m4180g(3, aWR, "Referrer file name if it exists:  " + this.aXj);
    }

    public final synchronized Map<String, List<String>> HG() {
        HH();
        return anc.ch(this.aWX);
    }

    private void HH() {
        if (!this.aXk) {
            this.aXk = true;
            app.m4180g(4, aWR, "Loading referrer info from file: " + this.aXj.getAbsolutePath());
            String v = aqu.m4249v(this.aXj);
            app.m4181w(aWR, "Referrer file contents: " + v);
            cf(v);
        }
    }

    private void cf(String str) {
        if (str != null) {
            this.aWX = str;
        }
    }

    public final synchronized String HI() {
        HH();
        return this.aWX;
    }

    public final synchronized void cg(String str) {
        this.aXk = true;
        cf(str);
        aqu.m4246b(this.aXj, this.aWX);
    }
}
