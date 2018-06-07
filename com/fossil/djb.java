package com.fossil;

import com.fossil.ckb.C2126d;
import com.fossil.ckb.C2131a;
import com.fossil.diz.C2799a;
import com.fossil.diz.C2816b;
import com.fossil.djs.C2852a;
import com.fossil.dkk.C2895a;
import com.fossil.dkk.C2896b;
import com.google.gson.JsonSyntaxException;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.microapp.SecondTimezone;
import java.util.Collections;
import java.util.List;

public class djb implements C2799a {
    private static final String TAG = djb.class.getSimpleName();
    private C2816b cWS;
    private SecondTimezone cWW;
    private List<SecondTimezone> cWX;
    private djs cWY;
    private dkk cWZ;
    private ckc mUseCaseHandler;

    class C28171 implements C2126d<C2852a, C2131a> {
        final /* synthetic */ djb cXa;

        C28171(djb com_fossil_djb) {
            this.cXa = com_fossil_djb;
        }

        public /* synthetic */ void onError(Object obj) {
            m8800a((C2131a) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m8801a((C2852a) obj);
        }

        public void m8801a(C2852a c2852a) {
            MFLogger.m12670d(djb.TAG, "getRawSecondTimezones onSuccess");
            this.cXa.cWX = c2852a.aqc();
        }

        public void m8800a(C2131a c2131a) {
        }
    }

    class C28182 implements C2126d<C2852a, C2131a> {
        final /* synthetic */ djb cXa;

        C28182(djb com_fossil_djb) {
            this.cXa = com_fossil_djb;
        }

        public /* synthetic */ void onError(Object obj) {
            m8802a((C2131a) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m8803a((C2852a) obj);
        }

        public void m8803a(C2852a c2852a) {
            MFLogger.m12670d(djb.TAG, "mGetRawDataSecondTimezones onSuccess");
            this.cXa.cWX = c2852a.aqc();
            this.cXa.cWS.mo2510a(this.cXa.cWX, this.cXa.cWW);
        }

        public void m8802a(C2131a c2131a) {
            MFLogger.m12670d(djb.TAG, "mGetRawDataSecondTimezones onError");
        }
    }

    class C28193 implements C2126d<C2896b, C2131a> {
        final /* synthetic */ djb cXa;

        C28193(djb com_fossil_djb) {
            this.cXa = com_fossil_djb;
        }

        public /* synthetic */ void onError(Object obj) {
            m8804a((C2131a) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m8805a((C2896b) obj);
        }

        public void m8805a(C2896b c2896b) {
            MFLogger.m12670d(djb.TAG, "setSecondTimezone onSuccess");
            this.cXa.cWW = c2896b.aqP();
            this.cXa.cWS.afU();
            this.cXa.cWS.apc();
        }

        public void m8804a(C2131a c2131a) {
            MFLogger.m12670d(djb.TAG, "setSecondTimezone onError");
            this.cXa.cWS.afU();
            this.cXa.cWS.aou();
        }
    }

    public djb(C2816b c2816b, djs com_fossil_djs, dkk com_fossil_dkk, ckc com_fossil_ckc) {
        this.cWS = (C2816b) emj.ce(c2816b);
        this.cWY = (djs) emj.m10873f(com_fossil_djs, "getRawDataSecondTimezones can not be null");
        this.cWZ = (dkk) emj.m10873f(com_fossil_dkk, "setSecondTimezone can not be null");
        this.mUseCaseHandler = (ckc) emj.m10873f(com_fossil_ckc, "useCaseHandler can not be null");
    }

    public void apm() {
        this.cWZ.ajd();
        MFLogger.m12670d(TAG, "startSecondTimezone");
        if (this.cWW != null) {
            this.cWS.mo2513c(this.cWW);
        }
        aqg();
        PortfolioApp.ZQ().m12685I(Collections.singletonList(CommunicateMode.SET_SECOND_TIMEZONE));
    }

    private void aqg() {
        MFLogger.m12670d(TAG, "getRawSecondTimezones");
        this.mUseCaseHandler.m6886a(this.cWY, null, new C28171(this));
    }

    public void iH(String str) {
        MFLogger.m12670d(TAG, "loadSecondTimezones");
        if (str == null || str.isEmpty()) {
            this.cWW = new SecondTimezone();
            return;
        }
        try {
            this.cWW = (SecondTimezone) new cfk().Wt().Wu().m6205c(str, SecondTimezone.class);
        } catch (JsonSyntaxException e) {
            this.cWW = new SecondTimezone();
        }
        if (this.cWW == null) {
            this.cWW = new SecondTimezone();
        }
    }

    public void app() {
        if (this.cWX == null || this.cWX.isEmpty()) {
            MFLogger.m12670d(TAG, "mGetRawDataSecondTimezones");
            this.mUseCaseHandler.m6886a(this.cWY, null, new C28182(this));
            return;
        }
        this.cWS.mo2510a(this.cWX, this.cWW);
    }

    public void mo2479b(SecondTimezone secondTimezone) {
        this.cWW = secondTimezone;
        this.cWS.afT();
        this.mUseCaseHandler.m6886a(this.cWZ, new C2895a(PortfolioApp.ZQ().aaa(), this.cWW), new C28193(this));
    }

    public void apn() {
        this.cWZ.aje();
    }

    public void ahu() {
        this.cWS.cK(this);
    }

    public boolean apo() {
        return (this.cWW == null || this.cWW.getTimezoneCityName() == null || this.cWW.getTimezoneCityName().isEmpty()) ? false : true;
    }

    public String apW() {
        MFLogger.m12670d(TAG, "getSettingJson cityName=" + this.cWW.getTimezoneCityName() + " uri=" + this.cWW.getUri());
        String toJson = new cfj().toJson(this.cWW);
        MFLogger.m12670d(TAG, "getSettingJson - jsonString=" + toJson);
        return toJson;
    }

    public void aoW() {
        MFLogger.m12670d(TAG, "reloadSettings");
        if (this.cWW != null) {
            this.cWS.mo2513c(this.cWW);
        }
    }
}
