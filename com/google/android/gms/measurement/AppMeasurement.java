package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Keep;
import com.fossil.awa;
import com.fossil.bgd;
import com.fossil.bnm;
import com.fossil.bpk;
import com.fossil.bqk;
import com.fossil.bsh;
import com.fossil.bsk;
import com.fossil.jl;
import java.util.List;
import java.util.Map;

@Keep
@Deprecated
public class AppMeasurement {
    public static final String CRASH_ORIGIN = "crash";
    public static final String FCM_ORIGIN = "fcm";
    private final bpk zzboe;

    public AppMeasurement(bpk com_fossil_bpk) {
        awa.bO(com_fossil_bpk);
        this.zzboe = com_fossil_bpk;
    }

    @Keep
    @Deprecated
    public static AppMeasurement getInstance(Context context) {
        return bpk.aR(context).RE();
    }

    @Keep
    public void beginAdUnitExposure(String str) {
        this.zzboe.OQ().beginAdUnitExposure(str);
    }

    @Keep
    protected void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        this.zzboe.OS().clearConditionalUserProperty(str, str2, bundle);
    }

    @Keep
    protected void clearConditionalUserPropertyAs(String str, String str2, String str3, Bundle bundle) {
        this.zzboe.OS().clearConditionalUserPropertyAs(str, str2, str3, bundle);
    }

    @Keep
    public void endAdUnitExposure(String str) {
        this.zzboe.OQ().endAdUnitExposure(str);
    }

    @Keep
    public long generateEventId() {
        return this.zzboe.Pb().Si();
    }

    @Keep
    public String getAppInstanceId() {
        return this.zzboe.OS().Ro();
    }

    @Keep
    public List<ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        return this.zzboe.OS().getConditionalUserProperties(str, str2);
    }

    @Keep
    protected List<ConditionalUserProperty> getConditionalUserPropertiesAs(String str, String str2, String str3) {
        return this.zzboe.OS().getConditionalUserPropertiesAs(str, str2, str3);
    }

    @Keep
    public String getCurrentScreenClass() {
        g RU = this.zzboe.OW().RU();
        return RU != null ? RU.bJM : null;
    }

    @Keep
    public String getCurrentScreenName() {
        g RU = this.zzboe.OW().RU();
        return RU != null ? RU.bJL : null;
    }

    @Keep
    public String getGmpAppId() {
        try {
            return bgd.Oh();
        } catch (IllegalStateException e) {
            this.zzboe.Pf().Rc().m5439d("getGoogleAppId failed with exception", e);
            return null;
        }
    }

    @Keep
    public int getMaxUserProperties(String str) {
        this.zzboe.OS();
        return bqk.getMaxUserProperties(str);
    }

    @Keep
    protected Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        return this.zzboe.OS().getUserProperties(str, str2, z);
    }

    public Map<String, Object> getUserProperties(boolean z) {
        List<bsh> bh = this.zzboe.OS().bh(z);
        Map<String, Object> jlVar = new jl(bh.size());
        for (bsh com_fossil_bsh : bh) {
            jlVar.put(com_fossil_bsh.name, com_fossil_bsh.getValue());
        }
        return jlVar;
    }

    @Keep
    protected Map<String, Object> getUserPropertiesAs(String str, String str2, String str3, boolean z) {
        return this.zzboe.OS().getUserPropertiesAs(str, str2, str3, z);
    }

    public final void logEvent(String str, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bnm.Qh();
        if (!"_iap".equals(str)) {
            int ey = this.zzboe.Pb().ey(str);
            if (ey != 0) {
                this.zzboe.Pb();
                this.zzboe.Pb().m5598a(ey, "_ev", bsk.m5581a(str, bnm.PK(), true), str != null ? str.length() : 0);
                return;
            }
        }
        this.zzboe.OS().m5541a("app", str, bundle, true);
    }

    @Keep
    public void logEventInternal(String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.zzboe.OS().m5539a(str, str2, bundle);
    }

    public void logEventInternalNoInterceptor(String str, String str2, Bundle bundle, long j) {
        this.zzboe.OS().m5540a(str, str2, bundle == null ? new Bundle() : bundle, j);
    }

    public void registerOnMeasurementEventListener(c cVar) {
        this.zzboe.OS().registerOnMeasurementEventListener(cVar);
    }

    @Keep
    public void registerOnScreenChangeCallback(f fVar) {
        this.zzboe.OW().registerOnScreenChangeCallback(fVar);
    }

    @Keep
    protected void setConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
        this.zzboe.OS().setConditionalUserProperty(conditionalUserProperty);
    }

    @Keep
    protected void setConditionalUserPropertyAs(ConditionalUserProperty conditionalUserProperty) {
        this.zzboe.OS().setConditionalUserPropertyAs(conditionalUserProperty);
    }

    public void setEventInterceptor(b bVar) {
        this.zzboe.OS().setEventInterceptor(bVar);
    }

    @Deprecated
    public void setMeasurementEnabled(boolean z) {
        this.zzboe.OS().setMeasurementEnabled(z);
    }

    public final void setMinimumSessionDuration(long j) {
        this.zzboe.OS().setMinimumSessionDuration(j);
    }

    public final void setSessionTimeoutDuration(long j) {
        this.zzboe.OS().setSessionTimeoutDuration(j);
    }

    public final void setUserProperty(String str, String str2) {
        int eA = this.zzboe.Pb().eA(str);
        if (eA != 0) {
            this.zzboe.Pb();
            this.zzboe.Pb().m5598a(eA, "_ev", bsk.m5581a(str, bnm.PL(), true), str != null ? str.length() : 0);
            return;
        }
        setUserPropertyInternal("app", str, str2);
    }

    public void setUserPropertyInternal(String str, String str2, Object obj) {
        this.zzboe.OS().m5542a(str, str2, obj);
    }

    public void unregisterOnMeasurementEventListener(c cVar) {
        this.zzboe.OS().unregisterOnMeasurementEventListener(cVar);
    }

    @Keep
    public void unregisterOnScreenChangeCallback(f fVar) {
        this.zzboe.OW().unregisterOnScreenChangeCallback(fVar);
    }
}
