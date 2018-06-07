package com.fossil;

public final class dhj implements emg<dhi> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dhj.class.desiredAssertionStatus());
    private final eru<dik> cVn;
    private final eru<dhu> cVo;
    private final eru<dir> cVp;
    private final eru<djb> cVq;

    public /* synthetic */ void injectMembers(Object obj) {
        m8676d((dhi) obj);
    }

    public dhj(eru<dik> com_fossil_eru_com_fossil_dik, eru<dhu> com_fossil_eru_com_fossil_dhu, eru<dir> com_fossil_eru_com_fossil_dir, eru<djb> com_fossil_eru_com_fossil_djb) {
        if ($assertionsDisabled || com_fossil_eru_com_fossil_dik != null) {
            this.cVn = com_fossil_eru_com_fossil_dik;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_dhu != null) {
                this.cVo = com_fossil_eru_com_fossil_dhu;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_dir != null) {
                    this.cVp = com_fossil_eru_com_fossil_dir;
                    if ($assertionsDisabled || com_fossil_eru_com_fossil_djb != null) {
                        this.cVq = com_fossil_eru_com_fossil_djb;
                        return;
                    }
                    throw new AssertionError();
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static emg<dhi> m8675a(eru<dik> com_fossil_eru_com_fossil_dik, eru<dhu> com_fossil_eru_com_fossil_dhu, eru<dir> com_fossil_eru_com_fossil_dir, eru<djb> com_fossil_eru_com_fossil_djb) {
        return new dhj(com_fossil_eru_com_fossil_dik, com_fossil_eru_com_fossil_dhu, com_fossil_eru_com_fossil_dir, com_fossil_eru_com_fossil_djb);
    }

    public void m8676d(dhi com_fossil_dhi) {
        if (com_fossil_dhi == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        com_fossil_dhi.cVe = (dik) this.cVn.get();
        com_fossil_dhi.cVf = (dhu) this.cVo.get();
        com_fossil_dhi.cVg = (dir) this.cVp.get();
        com_fossil_dhi.cVh = (djb) this.cVq.get();
    }
}
