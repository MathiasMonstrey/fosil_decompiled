package com.fossil;

import android.content.Context;
import io.fabric.sdk.android.services.common.IdManager;
import java.io.File;
import java.util.Collection;

public abstract class emr<Result> implements Comparable<emr> {
    IdManager aId;
    Context context;
    emp<Result> dMV;
    emm dNm;
    emq<Result> dNn = new emq(this);

    public abstract String getIdentifier();

    public abstract String getVersion();

    protected abstract Result xf();

    public /* synthetic */ int compareTo(Object obj) {
        return m2869a((emr) obj);
    }

    void m2870a(Context context, emm com_fossil_emm, emp<Result> com_fossil_emp_Result, IdManager idManager) {
        this.dNm = com_fossil_emm;
        this.context = new emn(context, getIdentifier(), getPath());
        this.dMV = com_fossil_emp_Result;
        this.aId = idManager;
    }

    final void initialize() {
        this.dNn.m10912a(this.dNm.aET(), (Void) null);
    }

    protected boolean xh() {
        return true;
    }

    protected void onPostExecute(Result result) {
    }

    protected void onCancelled(Result result) {
    }

    protected IdManager aEZ() {
        return this.aId;
    }

    public Context getContext() {
        return this.context;
    }

    public emm aFa() {
        return this.dNm;
    }

    public String getPath() {
        return ".Fabric" + File.separator + getIdentifier();
    }

    public int m2869a(emr com_fossil_emr) {
        if (m2871b(com_fossil_emr)) {
            return 1;
        }
        if (com_fossil_emr.m2871b(this)) {
            return -1;
        }
        if (aFb() && !com_fossil_emr.aFb()) {
            return 1;
        }
        if (aFb() || !com_fossil_emr.aFb()) {
            return 0;
        }
        return -1;
    }

    boolean m2871b(emr com_fossil_emr) {
        ens com_fossil_ens = (ens) getClass().getAnnotation(ens.class);
        if (com_fossil_ens != null) {
            for (Object equals : com_fossil_ens.zy()) {
                if (equals.equals(com_fossil_emr.getClass())) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean aFb() {
        return ((ens) getClass().getAnnotation(ens.class)) != null;
    }

    protected Collection<enz> aFc() {
        return this.dNn.aFc();
    }
}
