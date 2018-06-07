package com.fossil;

import com.flurry.sdk.kw;
import com.flurry.sdk.kw.C1541b;
import java.io.InputStream;
import java.io.OutputStream;

public final class apv<RequestObjectType, ResponseObjectType> extends kw {
    public aqi<RequestObjectType> baS;
    public aqi<ResponseObjectType> bbl;
    public C1725a<RequestObjectType, ResponseObjectType> bbn;
    public RequestObjectType bbo;
    private ResponseObjectType bbp;

    public interface C1725a<RequestObjectType, ResponseObjectType> {
        void mo1108a(apv<RequestObjectType, ResponseObjectType> com_fossil_apv_RequestObjectType__ResponseObjectType, ResponseObjectType responseObjectType);
    }

    class C17961 implements C1541b {
        final /* synthetic */ apv bbq;

        C17961(apv com_fossil_apv) {
            this.bbq = com_fossil_apv;
        }

        public final void mo1121e(OutputStream outputStream) throws Exception {
            if (this.bbq.bbo != null && this.bbq.baS != null) {
                this.bbq.baS.mo1105a(outputStream, this.bbq.bbo);
            }
        }

        public final void mo1120a(kw kwVar, InputStream inputStream) throws Exception {
            if (kwVar.IY() && this.bbq.bbl != null) {
                this.bbq.bbp = this.bbq.bbl.mo1106j(inputStream);
            }
        }

        public final void mo1119a(kw kwVar) {
            apv.m4196d(this.bbq);
        }
    }

    public final void HJ() {
        this.bby = new C17961(this);
        super.HJ();
    }

    static /* synthetic */ void m4196d(apv com_fossil_apv) {
        if (com_fossil_apv.bbn != null && !com_fossil_apv.IZ()) {
            com_fossil_apv.bbn.mo1108a(com_fossil_apv, com_fossil_apv.bbp);
        }
    }
}
