package com.fossil;

import com.portfolio.platform.receiver.BootReceiver;

public final class cpp implements emg<BootReceiver> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cpp.class.desiredAssertionStatus());
    private final eru<cmi> cng;

    public /* synthetic */ void injectMembers(Object obj) {
        m7447b((BootReceiver) obj);
    }

    public cpp(eru<cmi> com_fossil_eru_com_fossil_cmi) {
        if ($assertionsDisabled || com_fossil_eru_com_fossil_cmi != null) {
            this.cng = com_fossil_eru_com_fossil_cmi;
            return;
        }
        throw new AssertionError();
    }

    public static emg<BootReceiver> create(eru<cmi> com_fossil_eru_com_fossil_cmi) {
        return new cpp(com_fossil_eru_com_fossil_cmi);
    }

    public void m7447b(BootReceiver bootReceiver) {
        if (bootReceiver == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        bootReceiver.cmS = (cmi) this.cng.get();
    }
}
