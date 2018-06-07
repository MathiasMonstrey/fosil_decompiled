package com.fossil;

import android.content.Context;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import java.io.InputStream;

public class xb implements xe<wh> {
    private final wo<wh, wh> aDM;

    public static class C4208a implements wq<wh, InputStream> {
        private final wo<wh, wh> aDM = new wo(MFNetworkReturnCode.INTERNAL_SERVER_ERROR);

        public wp<wh, InputStream> mo4423a(Context context, wg wgVar) {
            return new xb(this.aDM);
        }

        public void vz() {
        }
    }

    public /* synthetic */ us mo4419c(Object obj, int i, int i2) {
        return m14025a((wh) obj, i, i2);
    }

    public xb() {
        this(null);
    }

    public xb(wo<wh, wh> woVar) {
        this.aDM = woVar;
    }

    public us<InputStream> m14025a(wh whVar, int i, int i2) {
        if (this.aDM != null) {
            wh whVar2 = (wh) this.aDM.m14004d(whVar, 0, 0);
            if (whVar2 == null) {
                this.aDM.m14003a(whVar, 0, 0, whVar);
            } else {
                whVar = whVar2;
            }
        }
        return new uv(whVar);
    }
}
