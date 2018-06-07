package com.fossil;

import android.util.Log;

public class eml implements emu {
    private int dMR;

    public eml(int i) {
        this.dMR = i;
    }

    public eml() {
        this.dMR = 4;
    }

    public boolean isLoggable(String str, int i) {
        return this.dMR <= i;
    }

    public void mo2949c(String str, String str2, Throwable th) {
        if (isLoggable(str, 3)) {
            Log.d(str, str2, th);
        }
    }

    public void m10890d(String str, String str2, Throwable th) {
        if (isLoggable(str, 2)) {
            Log.v(str, str2, th);
        }
    }

    public void m10892e(String str, String str2, Throwable th) {
        if (isLoggable(str, 4)) {
            Log.i(str, str2, th);
        }
    }

    public void mo2952f(String str, String str2, Throwable th) {
        if (isLoggable(str, 5)) {
            Log.w(str, str2, th);
        }
    }

    public void mo2953g(String str, String str2, Throwable th) {
        if (isLoggable(str, 6)) {
            Log.e(str, str2, th);
        }
    }

    public void mo2950d(String str, String str2) {
        mo2949c(str, str2, null);
    }

    public void mo2956v(String str, String str2) {
        m10890d(str, str2, null);
    }

    public void mo2954i(String str, String str2) {
        m10892e(str, str2, null);
    }

    public void aS(String str, String str2) {
        mo2952f(str, str2, null);
    }

    public void mo2951e(String str, String str2) {
        mo2953g(str, str2, null);
    }

    public void mo2946a(int i, String str, String str2) {
        mo2947a(i, str, str2, false);
    }

    public void mo2947a(int i, String str, String str2, boolean z) {
        if (z || isLoggable(str, i)) {
            Log.println(i, str, str2);
        }
    }
}
