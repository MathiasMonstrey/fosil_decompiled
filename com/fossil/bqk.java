package com.fossil;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.measurement.AppMeasurement.ConditionalUserProperty;
import com.google.android.gms.measurement.AppMeasurement.b;
import com.google.android.gms.measurement.AppMeasurement.c;
import com.google.android.gms.measurement.AppMeasurement.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;

public final class bqk extends bqi {
    protected bqx bCh;
    private b bCi;
    private final Set<c> bCj = new CopyOnWriteArraySet();
    private boolean bCk;
    private final AtomicReference<String> bCl = new AtomicReference();

    protected bqk(bpk com_fossil_bpk) {
        super(com_fossil_bpk);
    }

    private final void m5527a(ConditionalUserProperty conditionalUserProperty) {
        long currentTimeMillis = super.OX().currentTimeMillis();
        awa.bO(conditionalUserProperty);
        awa.df(conditionalUserProperty.mName);
        awa.df(conditionalUserProperty.mOrigin);
        awa.bO(conditionalUserProperty.mValue);
        conditionalUserProperty.mCreationTimestamp = currentTimeMillis;
        String str = conditionalUserProperty.mName;
        Object obj = conditionalUserProperty.mValue;
        if (super.Pb().eB(str) != 0) {
            super.Pf().Rc().m5439d("Invalid conditional user property name", super.Pa().eh(str));
        } else if (super.Pb().m5607f(str, obj) != 0) {
            super.Pf().Rc().m5437a("Invalid conditional user property value", super.Pa().eh(str), obj);
        } else {
            Object g = super.Pb().m5608g(str, obj);
            if (g == null) {
                super.Pf().Rc().m5437a("Unable to normalize conditional user property value", super.Pa().eh(str), obj);
                return;
            }
            conditionalUserProperty.mValue = g;
            long j = conditionalUserProperty.mTriggerTimeout;
            if (TextUtils.isEmpty(conditionalUserProperty.mTriggerEventName) || (j <= bnm.PZ() && j >= 1)) {
                j = conditionalUserProperty.mTimeToLive;
                if (j > bnm.Qa() || j < 1) {
                    super.Pf().Rc().m5437a("Invalid conditional user property time to live", super.Pa().eh(str), Long.valueOf(j));
                    return;
                } else {
                    super.Pe().m5469h(new bqm(this, conditionalUserProperty));
                    return;
                }
            }
            super.Pf().Rc().m5437a("Invalid conditional user property timeout", super.Pa().eh(str), Long.valueOf(j));
        }
    }

    private final void m5528a(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        Bundle bundle2;
        if (bundle == null) {
            bundle2 = new Bundle();
        } else {
            bundle2 = new Bundle(bundle);
            for (String str4 : bundle2.keySet()) {
                Object obj = bundle2.get(str4);
                if (obj instanceof Bundle) {
                    bundle2.putBundle(str4, new Bundle((Bundle) obj));
                } else if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    for (r4 = 0; r4 < parcelableArr.length; r4++) {
                        if (parcelableArr[r4] instanceof Bundle) {
                            parcelableArr[r4] = new Bundle((Bundle) parcelableArr[r4]);
                        }
                    }
                } else if (obj instanceof ArrayList) {
                    ArrayList arrayList = (ArrayList) obj;
                    for (r4 = 0; r4 < arrayList.size(); r4++) {
                        Object obj2 = arrayList.get(r4);
                        if (obj2 instanceof Bundle) {
                            arrayList.set(r4, new Bundle((Bundle) obj2));
                        }
                    }
                }
            }
        }
        super.Pe().m5469h(new bqs(this, str, str2, j, bundle2, z, z2, z3, str3));
    }

    private final void m5529a(String str, String str2, long j, Object obj) {
        super.Pe().m5469h(new bqt(this, str, str2, obj, j));
    }

    private final void m5530a(String str, String str2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        m5528a(str, str2, super.OX().currentTimeMillis(), bundle, true, z2, z3, null);
    }

    private final void m5531a(String str, String str2, Object obj, long j) {
        awa.df(str);
        awa.df(str2);
        super.OP();
        super.ON();
        RA();
        if (!this.zzboe.isEnabled()) {
            super.Pf().Rh().log("User property not set since app measurement is disabled");
        } else if (this.zzboe.RB()) {
            super.Pf().Rh().m5437a("Setting user property (FE)", super.Pa().ef(str2), obj);
            super.OV().m5564b(new bsh(str2, j, obj, str));
        }
    }

    private final void m5532a(String str, String str2, String str3, Bundle bundle) {
        long currentTimeMillis = super.OX().currentTimeMillis();
        awa.df(str2);
        ConditionalUserProperty conditionalUserProperty = new ConditionalUserProperty();
        conditionalUserProperty.mAppId = str;
        conditionalUserProperty.mName = str2;
        conditionalUserProperty.mCreationTimestamp = currentTimeMillis;
        if (str3 != null) {
            conditionalUserProperty.mExpiredEventName = str3;
            conditionalUserProperty.mExpiredEventParams = bundle;
        }
        super.Pe().m5469h(new bqn(this, conditionalUserProperty));
    }

    private final String an(long j) {
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            super.Pe().m5469h(new bqw(this, atomicReference));
            try {
                atomicReference.wait(j);
            } catch (InterruptedException e) {
                super.Pf().Re().log("Interrupted waiting for app instance id");
                return null;
            }
        }
        return (String) atomicReference.get();
    }

    private final Map<String, Object> m5533b(String str, String str2, String str3, boolean z) {
        if (super.Pe().Rw()) {
            super.Pf().Rc().log("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        }
        super.Pe();
        if (bpg.LM()) {
            super.Pf().Rc().log("Cannot get user properties from main thread");
            return Collections.emptyMap();
        }
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            this.zzboe.Pe().m5469h(new bqp(this, atomicReference, str, str2, str3, z));
            try {
                atomicReference.wait(5000);
            } catch (InterruptedException e) {
                super.Pf().Re().m5439d("Interrupted waiting for get user properties", e);
            }
        }
        List<bsh> list = (List) atomicReference.get();
        if (list == null) {
            super.Pf().Re().log("Timed out waiting for get user properties");
            return Collections.emptyMap();
        }
        Map<String, Object> jlVar = new jl(list.size());
        for (bsh com_fossil_bsh : list) {
            jlVar.put(com_fossil_bsh.name, com_fossil_bsh.getValue());
        }
        return jlVar;
    }

    private final void m5535b(ConditionalUserProperty conditionalUserProperty) {
        super.OP();
        RA();
        awa.bO(conditionalUserProperty);
        awa.df(conditionalUserProperty.mName);
        awa.df(conditionalUserProperty.mOrigin);
        awa.bO(conditionalUserProperty.mValue);
        if (this.zzboe.isEnabled()) {
            bsh com_fossil_bsh = new bsh(conditionalUserProperty.mName, conditionalUserProperty.mTriggeredTimestamp, conditionalUserProperty.mValue, conditionalUserProperty.mOrigin);
            try {
                bnz a = super.Pb().m5597a(conditionalUserProperty.mTriggeredEventName, conditionalUserProperty.mTriggeredEventParams, conditionalUserProperty.mOrigin, 0, true, false);
                super.OV().m5566f(new bnk(conditionalUserProperty.mAppId, conditionalUserProperty.mOrigin, com_fossil_bsh, conditionalUserProperty.mCreationTimestamp, false, conditionalUserProperty.mTriggerEventName, super.Pb().m5597a(conditionalUserProperty.mTimedOutEventName, conditionalUserProperty.mTimedOutEventParams, conditionalUserProperty.mOrigin, 0, true, false), conditionalUserProperty.mTriggerTimeout, a, conditionalUserProperty.mTimeToLive, super.Pb().m5597a(conditionalUserProperty.mExpiredEventName, conditionalUserProperty.mExpiredEventParams, conditionalUserProperty.mOrigin, 0, true, false)));
                return;
            } catch (IllegalArgumentException e) {
                return;
            }
        }
        super.Pf().Rh().log("Conditional property not sent since Firebase Analytics is disabled");
    }

    private final void m5536b(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        awa.df(str);
        awa.df(str2);
        awa.bO(bundle);
        super.OP();
        RA();
        if (this.zzboe.isEnabled()) {
            if (!this.bCk) {
                this.bCk = true;
                try {
                    try {
                        Class.forName("com.google.android.gms.tagmanager.TagManagerService").getDeclaredMethod("initialize", new Class[]{Context.class}).invoke(null, new Object[]{super.getContext()});
                    } catch (Exception e) {
                        super.Pf().Re().m5439d("Failed to invoke Tag Manager's initialize() method", e);
                    }
                } catch (ClassNotFoundException e2) {
                    super.Pf().Rg().log("Tag Manager is not found and thus will not be used");
                }
            }
            boolean equals = "am".equals(str);
            boolean eI = bsk.eI(str2);
            if (z && this.bCi != null && !eI && !equals) {
                super.Pf().Rh().m5437a("Passing event to registered event handler (FE)", super.Pa().ef(str2), super.Pa().m5431y(bundle));
                this.bCi.b(str, str2, bundle, j);
                return;
            } else if (this.zzboe.RB()) {
                int ez = super.Pb().ez(str2);
                if (ez != 0) {
                    super.Pb();
                    this.zzboe.Pb().m5602a(str3, ez, "_ev", bsk.m5581a(str2, bnm.PK(), true), str2 != null ? str2.length() : 0);
                    return;
                }
                int i;
                Bundle a;
                List singletonList = Collections.singletonList("_o");
                Bundle a2 = super.Pb().m5596a(str2, bundle, singletonList, z3, true);
                List arrayList = new ArrayList();
                arrayList.add(a2);
                long nextLong = super.Pb().Sj().nextLong();
                int i2 = 0;
                String[] strArr = (String[]) a2.keySet().toArray(new String[bundle.size()]);
                Arrays.sort(strArr);
                int length = strArr.length;
                int i3 = 0;
                while (i3 < length) {
                    int length2;
                    String str4 = strArr[i3];
                    Object obj = a2.get(str4);
                    super.Pb();
                    Bundle[] bX = bsk.bX(obj);
                    if (bX != null) {
                        a2.putInt(str4, bX.length);
                        for (i = 0; i < bX.length; i++) {
                            a = super.Pb().m5596a("_ep", bX[i], singletonList, z3, false);
                            a.putString("_en", str2);
                            a.putLong("_eid", nextLong);
                            a.putString("_gn", str4);
                            a.putInt("_ll", bX.length);
                            a.putInt("_i", i);
                            arrayList.add(a);
                        }
                        length2 = bX.length + i2;
                    } else {
                        length2 = i2;
                    }
                    i3++;
                    i2 = length2;
                }
                if (i2 != 0) {
                    a2.putLong("_eid", nextLong);
                    a2.putInt("_epc", i2);
                }
                bnm.Qh();
                g RT = super.OW().RT();
                if (!(RT == null || a2.containsKey("_sc"))) {
                    RT.bCM = true;
                }
                i = 0;
                while (i < arrayList.size()) {
                    a = (Bundle) arrayList.get(i);
                    String str5 = (i != 0 ? 1 : null) != null ? "_ep" : str2;
                    a.putString("_o", str);
                    if (!a.containsKey("_sc")) {
                        bqy.m5546a(RT, a);
                    }
                    Bundle z4 = z2 ? super.Pb().m5611z(a) : a;
                    super.Pf().Rh().m5437a("Logging event (FE)", super.Pa().ef(str2), super.Pa().m5431y(z4));
                    super.OV().m5565c(new bnz(str5, new bnw(z4), str, j), str3);
                    if (!equals) {
                        for (c c : this.bCj) {
                            c.c(str, str2, new Bundle(z4), j);
                        }
                    }
                    i++;
                }
                bnm.Qh();
                if (super.OW().RT() != null && "_ae".equals(str2)) {
                    super.Pd().bi(true);
                    return;
                }
                return;
            } else {
                return;
            }
        }
        super.Pf().Rh().log("Event not sent since app measurement is disabled");
    }

    private final void bg(boolean z) {
        super.OP();
        super.ON();
        RA();
        super.Pf().Rh().m5439d("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        super.Pg().setMeasurementEnabled(z);
        super.OV().RV();
    }

    private final void m5537c(ConditionalUserProperty conditionalUserProperty) {
        super.OP();
        RA();
        awa.bO(conditionalUserProperty);
        awa.df(conditionalUserProperty.mName);
        if (this.zzboe.isEnabled()) {
            bsh com_fossil_bsh = new bsh(conditionalUserProperty.mName, 0, null, null);
            try {
                super.OV().m5566f(new bnk(conditionalUserProperty.mAppId, conditionalUserProperty.mOrigin, com_fossil_bsh, conditionalUserProperty.mCreationTimestamp, conditionalUserProperty.mActive, conditionalUserProperty.mTriggerEventName, null, conditionalUserProperty.mTriggerTimeout, null, conditionalUserProperty.mTimeToLive, super.Pb().m5597a(conditionalUserProperty.mExpiredEventName, conditionalUserProperty.mExpiredEventParams, conditionalUserProperty.mOrigin, conditionalUserProperty.mCreationTimestamp, true, false)));
                return;
            } catch (IllegalArgumentException e) {
                return;
            }
        }
        super.Pf().Rh().log("Conditional property not cleared since Firebase Analytics is disabled");
    }

    public static int getMaxUserProperties(String str) {
        awa.df(str);
        return bnm.PX();
    }

    private final List<ConditionalUserProperty> m5538h(String str, String str2, String str3) {
        if (super.Pe().Rw()) {
            super.Pf().Rc().log("Cannot get conditional user properties from analytics worker thread");
            return Collections.emptyList();
        }
        super.Pe();
        if (bpg.LM()) {
            super.Pf().Rc().log("Cannot get conditional user properties from main thread");
            return Collections.emptyList();
        }
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            this.zzboe.Pe().m5469h(new bqo(this, atomicReference, str, str2, str3));
            try {
                atomicReference.wait(5000);
            } catch (InterruptedException e) {
                super.Pf().Re().m5437a("Interrupted waiting for get conditional user properties", str, e);
            }
        }
        List<bnk> list = (List) atomicReference.get();
        if (list == null) {
            super.Pf().Re().m5439d("Timed out waiting for get conditional user properties", str);
            return Collections.emptyList();
        }
        List<ConditionalUserProperty> arrayList = new ArrayList(list.size());
        for (bnk com_fossil_bnk : list) {
            ConditionalUserProperty conditionalUserProperty = new ConditionalUserProperty();
            conditionalUserProperty.mAppId = str;
            conditionalUserProperty.mOrigin = str2;
            conditionalUserProperty.mCreationTimestamp = com_fossil_bnk.bxE;
            conditionalUserProperty.mName = com_fossil_bnk.bxD.name;
            conditionalUserProperty.mValue = com_fossil_bnk.bxD.getValue();
            conditionalUserProperty.mActive = com_fossil_bnk.bxF;
            conditionalUserProperty.mTriggerEventName = com_fossil_bnk.bxG;
            if (com_fossil_bnk.bxH != null) {
                conditionalUserProperty.mTimedOutEventName = com_fossil_bnk.bxH.name;
                if (com_fossil_bnk.bxH.byq != null) {
                    conditionalUserProperty.mTimedOutEventParams = com_fossil_bnk.bxH.byq.QY();
                }
            }
            conditionalUserProperty.mTriggerTimeout = com_fossil_bnk.bxI;
            if (com_fossil_bnk.bxJ != null) {
                conditionalUserProperty.mTriggeredEventName = com_fossil_bnk.bxJ.name;
                if (com_fossil_bnk.bxJ.byq != null) {
                    conditionalUserProperty.mTriggeredEventParams = com_fossil_bnk.bxJ.byq.QY();
                }
            }
            conditionalUserProperty.mTriggeredTimestamp = com_fossil_bnk.bxD.bDu;
            conditionalUserProperty.mTimeToLive = com_fossil_bnk.bxK;
            if (com_fossil_bnk.bxL != null) {
                conditionalUserProperty.mExpiredEventName = com_fossil_bnk.bxL.name;
                if (com_fossil_bnk.bxL.byq != null) {
                    conditionalUserProperty.mExpiredEventParams = com_fossil_bnk.bxL.byq.QY();
                }
            }
            arrayList.add(conditionalUserProperty);
        }
        return arrayList;
    }

    public final /* bridge */ /* synthetic */ void OM() {
        super.OM();
    }

    public final /* bridge */ /* synthetic */ void ON() {
        super.ON();
    }

    public final /* bridge */ /* synthetic */ void OO() {
        super.OO();
    }

    public final /* bridge */ /* synthetic */ void OP() {
        super.OP();
    }

    public final /* bridge */ /* synthetic */ bnc OQ() {
        return super.OQ();
    }

    public final /* bridge */ /* synthetic */ bnj OR() {
        return super.OR();
    }

    public final /* bridge */ /* synthetic */ bqk OS() {
        return super.OS();
    }

    public final /* bridge */ /* synthetic */ bog OT() {
        return super.OT();
    }

    public final /* bridge */ /* synthetic */ bnt OU() {
        return super.OU();
    }

    public final /* bridge */ /* synthetic */ brc OV() {
        return super.OV();
    }

    public final /* bridge */ /* synthetic */ bqy OW() {
        return super.OW();
    }

    public final /* bridge */ /* synthetic */ axm OX() {
        return super.OX();
    }

    public final /* bridge */ /* synthetic */ boh OY() {
        return super.OY();
    }

    public final /* bridge */ /* synthetic */ bnn OZ() {
        return super.OZ();
    }

    protected final void PH() {
    }

    public final /* bridge */ /* synthetic */ boj Pa() {
        return super.Pa();
    }

    public final /* bridge */ /* synthetic */ bsk Pb() {
        return super.Pb();
    }

    public final /* bridge */ /* synthetic */ bpf Pc() {
        return super.Pc();
    }

    public final /* bridge */ /* synthetic */ brz Pd() {
        return super.Pd();
    }

    public final /* bridge */ /* synthetic */ bpg Pe() {
        return super.Pe();
    }

    public final /* bridge */ /* synthetic */ bol Pf() {
        return super.Pf();
    }

    public final /* bridge */ /* synthetic */ bow Pg() {
        return super.Pg();
    }

    public final /* bridge */ /* synthetic */ bnm Ph() {
        return super.Ph();
    }

    public final String Ro() {
        super.ON();
        return (String) this.bCl.get();
    }

    public final void m5539a(String str, String str2, Bundle bundle) {
        super.ON();
        boolean z = this.bCi == null || bsk.eI(str2);
        m5530a(str, str2, bundle, true, z, false, null);
    }

    public final void m5540a(String str, String str2, Bundle bundle, long j) {
        super.ON();
        m5528a(str, str2, j, bundle, false, true, true, null);
    }

    public final void m5541a(String str, String str2, Bundle bundle, boolean z) {
        super.ON();
        boolean z2 = this.bCi == null || bsk.eI(str2);
        m5530a(str, str2, bundle, true, z2, true, null);
    }

    public final void m5542a(String str, String str2, Object obj) {
        int i = 0;
        awa.df(str);
        long currentTimeMillis = super.OX().currentTimeMillis();
        int eB = super.Pb().eB(str2);
        String a;
        if (eB != 0) {
            super.Pb();
            a = bsk.m5581a(str2, bnm.PL(), true);
            if (str2 != null) {
                i = str2.length();
            }
            this.zzboe.Pb().m5598a(eB, "_ev", a, i);
        } else if (obj != null) {
            eB = super.Pb().m5607f(str2, obj);
            if (eB != 0) {
                super.Pb();
                a = bsk.m5581a(str2, bnm.PL(), true);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    i = String.valueOf(obj).length();
                }
                this.zzboe.Pb().m5598a(eB, "_ev", a, i);
                return;
            }
            Object g = super.Pb().m5608g(str2, obj);
            if (g != null) {
                m5529a(str, str2, currentTimeMillis, g);
            }
        } else {
            m5529a(str, str2, currentTimeMillis, null);
        }
    }

    final String am(long j) {
        if (super.Pe().Rw()) {
            super.Pf().Rc().log("Cannot retrieve app instance id from analytics worker thread");
            return null;
        }
        super.Pe();
        if (bpg.LM()) {
            super.Pf().Rc().log("Cannot retrieve app instance id from main thread");
            return null;
        }
        long elapsedRealtime = super.OX().elapsedRealtime();
        String an = an(120000);
        elapsedRealtime = super.OX().elapsedRealtime() - elapsedRealtime;
        return (an != null || elapsedRealtime >= 120000) ? an : an(120000 - elapsedRealtime);
    }

    public final List<bsh> bh(boolean z) {
        super.ON();
        RA();
        super.Pf().Rh().log("Fetching user attributes (FE)");
        if (super.Pe().Rw()) {
            super.Pf().Rc().log("Cannot get all user properties from analytics worker thread");
            return Collections.emptyList();
        }
        super.Pe();
        if (bpg.LM()) {
            super.Pf().Rc().log("Cannot get all user properties from main thread");
            return Collections.emptyList();
        }
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            this.zzboe.Pe().m5469h(new bqu(this, atomicReference, z));
            try {
                atomicReference.wait(5000);
            } catch (InterruptedException e) {
                super.Pf().Re().m5439d("Interrupted waiting for get user properties", e);
            }
        }
        List<bsh> list = (List) atomicReference.get();
        if (list != null) {
            return list;
        }
        super.Pf().Re().log("Timed out waiting for get user properties");
        return Collections.emptyList();
    }

    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        super.ON();
        m5532a(null, str, str2, bundle);
    }

    public final void clearConditionalUserPropertyAs(String str, String str2, String str3, Bundle bundle) {
        awa.df(str);
        super.OM();
        m5532a(str, str2, str3, bundle);
    }

    final void en(String str) {
        this.bCl.set(str);
    }

    public final cag<String> getAppInstanceId() {
        try {
            String Ro = super.Pg().Ro();
            return Ro != null ? cai.bZ(Ro) : cai.m5864a(super.Pe().Rx(), new bqv(this));
        } catch (Exception e) {
            super.Pf().Re().log("Failed to schedule task for getAppInstanceId");
            return cai.m5865j(e);
        }
    }

    public final List<ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        super.ON();
        return m5538h(null, str, str2);
    }

    public final List<ConditionalUserProperty> getConditionalUserPropertiesAs(String str, String str2, String str3) {
        awa.df(str);
        super.OM();
        return m5538h(str, str2, str3);
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        super.ON();
        return m5533b(null, str, str2, z);
    }

    public final Map<String, Object> getUserPropertiesAs(String str, String str2, String str3, boolean z) {
        awa.df(str);
        super.OM();
        return m5533b(str, str2, str3, z);
    }

    public final void registerOnMeasurementEventListener(c cVar) {
        super.ON();
        RA();
        awa.bO(cVar);
        if (!this.bCj.add(cVar)) {
            super.Pf().Re().log("OnEventListener already registered");
        }
    }

    public final void setConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
        awa.bO(conditionalUserProperty);
        super.ON();
        ConditionalUserProperty conditionalUserProperty2 = new ConditionalUserProperty(conditionalUserProperty);
        if (!TextUtils.isEmpty(conditionalUserProperty2.mAppId)) {
            super.Pf().Re().log("Package name should be null when calling setConditionalUserProperty");
        }
        conditionalUserProperty2.mAppId = null;
        m5527a(conditionalUserProperty2);
    }

    public final void setConditionalUserPropertyAs(ConditionalUserProperty conditionalUserProperty) {
        awa.bO(conditionalUserProperty);
        awa.df(conditionalUserProperty.mAppId);
        super.OM();
        m5527a(new ConditionalUserProperty(conditionalUserProperty));
    }

    public final void setEventInterceptor(b bVar) {
        super.OP();
        super.ON();
        RA();
        if (!(bVar == null || bVar == this.bCi)) {
            awa.m4634a(this.bCi == null, "EventInterceptor already set.");
        }
        this.bCi = bVar;
    }

    public final void setMeasurementEnabled(boolean z) {
        RA();
        super.ON();
        super.Pe().m5469h(new bql(this, z));
    }

    public final void setMinimumSessionDuration(long j) {
        super.ON();
        super.Pe().m5469h(new bqq(this, j));
    }

    public final void setSessionTimeoutDuration(long j) {
        super.ON();
        super.Pe().m5469h(new bqr(this, j));
    }

    public final void unregisterOnMeasurementEventListener(c cVar) {
        super.ON();
        RA();
        awa.bO(cVar);
        if (!this.bCj.remove(cVar)) {
            super.Pf().Re().log("OnEventListener had not been registered");
        }
    }
}
