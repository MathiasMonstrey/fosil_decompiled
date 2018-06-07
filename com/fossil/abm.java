package com.fossil;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class abm extends emr<Void> implements ems {
    public final abn aHh;
    public final acg aHi;
    public final acs aHj;
    public final Collection<? extends emr> aHk;

    protected /* synthetic */ Object xf() {
        return xc();
    }

    public abm() {
        this(new abn(), new acg(), new acs());
    }

    abm(abn com_fossil_abn, acg com_fossil_acg, acs com_fossil_acs) {
        this.aHh = com_fossil_abn;
        this.aHi = com_fossil_acg;
        this.aHj = com_fossil_acs;
        this.aHk = Collections.unmodifiableCollection(Arrays.asList(new emr[]{com_fossil_abn, com_fossil_acg, com_fossil_acs}));
    }

    public String getVersion() {
        return "2.4.0.61";
    }

    public String getIdentifier() {
        return "com.crashlytics.sdk.android:crashlytics";
    }

    public Collection<? extends emr> xb() {
        return this.aHk;
    }

    protected Void xc() {
        return null;
    }

    public static abm xd() {
        return (abm) emm.an(abm.class);
    }

    public static void m2872a(int i, String str, String str2) {
        xe();
        xd().aHj.m2973a(i, str, str2);
    }

    private static void xe() {
        if (xd() == null) {
            throw new IllegalStateException("Crashlytics must be initialized by calling Fabric.with(Context) prior to calling Crashlytics.getInstance()");
        }
    }
}
