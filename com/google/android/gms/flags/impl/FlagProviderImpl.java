package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.fossil.ayq;
import com.fossil.azc;
import com.fossil.bbb;
import com.fossil.bbd;
import com.fossil.bbf;
import com.fossil.bbh;
import com.fossil.bbj;
import com.fossil.blp;
import com.google.android.gms.common.util.DynamiteApi;

@DynamiteApi
public class FlagProviderImpl extends blp {
    private boolean boM = false;
    private SharedPreferences boN;

    public boolean getBooleanFlagValue(String str, boolean z, int i) {
        return !this.boM ? z : bbb.a(this.boN, str, Boolean.valueOf(z)).booleanValue();
    }

    public int getIntFlagValue(String str, int i, int i2) {
        return !this.boM ? i : bbd.a(this.boN, str, Integer.valueOf(i)).intValue();
    }

    public long getLongFlagValue(String str, long j, int i) {
        return !this.boM ? j : bbf.a(this.boN, str, Long.valueOf(j)).longValue();
    }

    public String getStringFlagValue(String str, String str2, int i) {
        return !this.boM ? str2 : bbh.a(this.boN, str, str2);
    }

    public void init(ayq com_fossil_ayq) {
        Context context = (Context) azc.a(com_fossil_ayq);
        if (!this.boM) {
            try {
                this.boN = bbj.aE(context.createPackageContext("com.google.android.gms", 0));
                this.boM = true;
            } catch (NameNotFoundException e) {
            } catch (Exception e2) {
                String str = "FlagProviderImpl";
                String str2 = "Could not retrieve sdk flags, continuing with defaults: ";
                String valueOf = String.valueOf(e2.getMessage());
                Log.w(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            }
        }
    }
}
