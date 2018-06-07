package com.fossil;

import android.os.Bundle;
import android.os.Parcel;
import com.misfit.frameworks.buttonservice.db.DataFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class eil {
    @cga("_links")
    Map<String, ArrayList<eiu>> dIk;
    protected transient long dIl = -1;

    protected eil(Parcel parcel) {
        Bundle readBundle = parcel.readBundle(eiu.class.getClassLoader());
        this.dIk = new HashMap(0);
        for (String str : readBundle.keySet()) {
            this.dIk.put(str, readBundle.getParcelableArrayList(str));
        }
        if (this.dIk.isEmpty()) {
            this.dIk = null;
        }
        this.dIl = parcel.readLong();
    }

    public void writeToParcel(Parcel parcel, int i) {
        Bundle bundle;
        if (this.dIk == null) {
            bundle = new Bundle(0);
        } else {
            Bundle bundle2 = new Bundle(this.dIk.size());
            for (Entry entry : this.dIk.entrySet()) {
                bundle2.putParcelableArrayList((String) entry.getKey(), (ArrayList) entry.getValue());
            }
            bundle = bundle2;
        }
        parcel.writeBundle(bundle);
        parcel.writeLong(this.dIl);
    }

    public void aV(long j) {
        this.dIl = j;
    }

    public long aDp() {
        return this.dIl;
    }

    protected String getHref() {
        eiu lA = lA("self");
        return lA == null ? null : lA.getHref();
    }

    public void m10510A(Map<String, ArrayList<eiu>> map) {
        if (map == null || map.isEmpty()) {
            this.dIk = null;
        } else {
            this.dIk = map;
        }
    }

    public Map<String, ArrayList<eiu>> aDq() {
        return this.dIk;
    }

    public void m10512b(String str, ArrayList<eiu> arrayList) {
        if (this.dIk == null) {
            this.dIk = new HashMap(1);
        }
        this.dIk.put(str, arrayList);
    }

    public ArrayList<eiu> lz(String str) {
        if (this.dIk == null || str == null) {
            return null;
        }
        return (ArrayList) this.dIk.get(str);
    }

    public eiu lA(String str) {
        ely.notNull(str, DataFile.COLUMN_KEY);
        return m10511N(str, 0);
    }

    public eiu m10511N(String str, int i) {
        List lz = lz(str);
        if (lz == null || lz.size() <= i) {
            return null;
        }
        return (eiu) lz.get(i);
    }

    public Set<String> aDr() {
        if (this.dIk == null) {
            return Collections.emptySet();
        }
        return this.dIk.keySet();
    }
}
