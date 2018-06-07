package com.fossil;

import com.flurry.sdk.jo;
import com.fossil.aqb.C1818a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class aqa {
    public final String aWR;
    public String aWS = "defaultDataKey_";
    public Set<String> aZU = new HashSet();
    private apk<aot> baW = new C18071(this);
    public aqc bbP;

    class C18071 implements apk<aot> {
        final /* synthetic */ aqa bbQ;

        C18071(aqa com_fossil_aqa) {
            this.bbQ = com_fossil_aqa;
        }

        public final /* synthetic */ void mo759a(apj com_fossil_apj) {
            aot com_fossil_aot = (aot) com_fossil_apj;
            app.m4180g(4, this.bbQ.aWR, "onNetworkStateChanged : isNetworkEnable = " + com_fossil_aot.aXk);
            if (com_fossil_aot.aXk) {
                this.bbQ.HO();
            }
        }
    }

    class C18104 extends aqx {
        final /* synthetic */ aqa bbR;
        final /* synthetic */ C1815a bbT = null;

        C18104(aqa com_fossil_aqa) {
            this.bbR = com_fossil_aqa;
        }

        public final void HJ() {
            aqa com_fossil_aqa = this.bbR;
            if (jo.ID().aXI) {
                List<String> arrayList = new ArrayList(com_fossil_aqa.bbP.bbX.keySet());
                if (arrayList.isEmpty()) {
                    app.m4180g(4, com_fossil_aqa.aWR, "No more reports to send.");
                    return;
                }
                for (String str : arrayList) {
                    if (com_fossil_aqa.m4087c()) {
                        List<String> cm = com_fossil_aqa.bbP.cm(str);
                        app.m4180g(4, com_fossil_aqa.aWR, "Number of not sent blocks = " + cm.size());
                        for (String str2 : cm) {
                            if (!com_fossil_aqa.aZU.contains(str2)) {
                                if (!com_fossil_aqa.m4087c()) {
                                    break;
                                }
                                aqb com_fossil_aqb = (aqb) new api(apc.IO().baD.getFileStreamPath(aqb.m4205a(str2)), ".yflurrydatasenderblock.", 1, new C18126(com_fossil_aqa)).IV();
                                if (com_fossil_aqb == null) {
                                    app.m4180g(6, com_fossil_aqa.aWR, "Internal ERROR! Cannot read!");
                                    com_fossil_aqa.bbP.m4209z(str2, str);
                                } else {
                                    byte[] bArr = com_fossil_aqb.baq;
                                    if (bArr == null || bArr.length == 0) {
                                        app.m4180g(6, com_fossil_aqa.aWR, "Internal ERROR! Report is empty!");
                                        com_fossil_aqa.bbP.m4209z(str2, str);
                                    } else {
                                        app.m4180g(5, com_fossil_aqa.aWR, "Reading block info " + str2);
                                        com_fossil_aqa.aZU.add(str2);
                                        com_fossil_aqa.mo1115b(bArr, str2, str);
                                    }
                                }
                            }
                        }
                    } else {
                        return;
                    }
                }
                return;
            }
            app.m4180g(5, com_fossil_aqa.aWR, "Reports were not sent! No Internet connection!");
        }
    }

    class C18115 implements aqk<aqb> {
        final /* synthetic */ aqa bbQ;

        C18115(aqa com_fossil_aqa) {
            this.bbQ = com_fossil_aqa;
        }

        public final aqi<aqb> hi(int i) {
            return new C1818a();
        }
    }

    class C18126 implements aqk<aqb> {
        final /* synthetic */ aqa bbQ;

        C18126(aqa com_fossil_aqa) {
            this.bbQ = com_fossil_aqa;
        }

        public final aqi<aqb> hi(int i) {
            return new C1818a();
        }
    }

    public interface C1815a {
    }

    public abstract void mo1115b(byte[] bArr, String str, String str2);

    public aqa(final String str, String str2) {
        this.aWR = str2;
        apl.IW().m4169a("com.flurry.android.sdk.NetworkStateEvent", this.baW);
        apc.IO().m4160b(new aqx(this) {
            final /* synthetic */ aqa bbR;

            public final void HJ() {
                this.bbR.bbP = new aqc(str);
            }
        });
    }

    public final void HO() {
        apc.IO().m4160b(new C18104(this));
    }

    public void mo1114a(final String str, final String str2, int i) {
        apc.IO().m4160b(new aqx(this) {
            final /* synthetic */ aqa bbU;

            public final void HJ() {
                if (!this.bbU.bbP.m4209z(str, str2)) {
                    app.m4180g(6, this.bbU.aWR, "Internal error. Block wasn't deleted with id = " + str);
                }
                if (!this.bbU.aZU.remove(str)) {
                    app.m4180g(6, this.bbU.aWR, "Internal error. Block with id = " + str + " was not in progress state");
                }
            }
        });
    }

    public final void cg(final String str) {
        apc.IO().m4160b(new aqx(this) {
            final /* synthetic */ aqa bbR;

            public final void HJ() {
                if (!this.bbR.aZU.remove(str)) {
                    app.m4180g(6, this.bbR.aWR, "Internal error. Block with id = " + str + " was not in progress state");
                }
            }
        });
    }

    public final void m4086c(final byte[] bArr, final String str, final String str2) {
        if (bArr == null || bArr.length == 0) {
            app.m4180g(6, this.aWR, "Report that has to be sent is EMPTY or NULL");
            return;
        }
        apc.IO().m4160b(new aqx(this) {
            final /* synthetic */ aqa bbS;

            public final void HJ() {
                aqa com_fossil_aqa = this.bbS;
                byte[] bArr = bArr;
                String str = str;
                str = com_fossil_aqa.aWS + str + "_" + str2;
                aqb com_fossil_aqb = new aqb(bArr);
                String str2 = com_fossil_aqb.aWB;
                new api(apc.IO().baD.getFileStreamPath(aqb.m4205a(str2)), ".yflurrydatasenderblock.", 1, new C18115(com_fossil_aqa)).bJ(com_fossil_aqb);
                app.m4180g(5, com_fossil_aqa.aWR, "Saving Block File " + str2 + " at " + apc.IO().baD.getFileStreamPath(aqb.m4205a(str2)));
                com_fossil_aqa.bbP.m4208a(com_fossil_aqb, str);
            }
        });
        HO();
    }

    final boolean m4087c() {
        return this.aZU.size() <= 5;
    }
}
