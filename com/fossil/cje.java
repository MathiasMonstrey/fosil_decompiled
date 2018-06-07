package com.fossil;

import android.content.ContentResolver;

public final class cje implements emi<ContentResolver> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cje.class.desiredAssertionStatus());
    private final ciz ceD;

    public /* synthetic */ Object get() {
        return Zo();
    }

    public cje(ciz com_fossil_ciz) {
        if ($assertionsDisabled || com_fossil_ciz != null) {
            this.ceD = com_fossil_ciz;
            return;
        }
        throw new AssertionError();
    }

    public ContentResolver Zo() {
        return (ContentResolver) emj.m10873f(this.ceD.Zj(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<ContentResolver> m6619a(ciz com_fossil_ciz) {
        return new cje(com_fossil_ciz);
    }
}
