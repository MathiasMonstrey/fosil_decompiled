package com.fossil;

import com.google.gson.DefaultDateTypeAdapter;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.LongSerializationPolicy;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.TreeTypeAdapter;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class cfk {
    private final List<cfx> bQL = new ArrayList();
    private Excluder bQN = Excluder.bRv;
    private boolean bQP = false;
    private boolean bQR = false;
    private boolean bQS = false;
    private boolean bQT = false;
    private LongSerializationPolicy bQY = LongSerializationPolicy.DEFAULT;
    private cfi bQZ = FieldNamingPolicy.IDENTITY;
    private final Map<Type, cfl<?>> bRa = new HashMap();
    private final List<cfx> bRb = new ArrayList();
    private String bRc;
    private int bRd = 2;
    private int bRe = 2;
    private boolean bRf = false;
    private boolean bRg = false;
    private boolean bRh = true;

    public cfk m6208f(int... iArr) {
        this.bQN = this.bQN.g(iArr);
        return this;
    }

    public cfk Wt() {
        this.bQN = this.bQN.WN();
        return this;
    }

    public cfk m6207a(Type type, Object obj) {
        boolean z = (obj instanceof cfv) || (obj instanceof cfo) || (obj instanceof cfl) || (obj instanceof cfw);
        cgd.bz(z);
        if (obj instanceof cfl) {
            this.bRa.put(type, (cfl) obj);
        }
        if ((obj instanceof cfv) || (obj instanceof cfo)) {
            this.bQL.add(TreeTypeAdapter.b(cgu.get(type), obj));
        }
        if (obj instanceof cfw) {
            this.bQL.add(cgs.m6393a(cgu.get(type), (cfw) obj));
        }
        return this;
    }

    public cfj Wu() {
        List arrayList = new ArrayList();
        arrayList.addAll(this.bQL);
        Collections.reverse(arrayList);
        arrayList.addAll(this.bRb);
        m6206a(this.bRc, this.bRd, this.bRe, arrayList);
        return new cfj(this.bQN, this.bQZ, this.bRa, this.bQP, this.bRf, this.bQR, this.bRh, this.bQS, this.bQT, this.bRg, this.bQY, arrayList);
    }

    private void m6206a(String str, int i, int i2, List<cfx> list) {
        Object defaultDateTypeAdapter;
        if (str != null && !"".equals(str.trim())) {
            defaultDateTypeAdapter = new DefaultDateTypeAdapter(str);
        } else if (i != 2 && i2 != 2) {
            defaultDateTypeAdapter = new DefaultDateTypeAdapter(i, i2);
        } else {
            return;
        }
        list.add(TreeTypeAdapter.a(cgu.get(Date.class), defaultDateTypeAdapter));
        list.add(TreeTypeAdapter.a(cgu.get(Timestamp.class), defaultDateTypeAdapter));
        list.add(TreeTypeAdapter.a(cgu.get(java.sql.Date.class), defaultDateTypeAdapter));
    }
}
