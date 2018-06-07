package com.fossil;

import io.fabric.sdk.android.InitializationException;
import io.fabric.sdk.android.services.concurrency.Priority;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;

class emq<Result> extends ent<Void, Void, Result> {
    final emr<Result> dNl;

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m10914a((Void[]) objArr);
    }

    public emq(emr<Result> com_fossil_emr_Result) {
        this.dNl = com_fossil_emr_Result;
    }

    protected void onPreExecute() {
        super.onPreExecute();
        enq mg = mg("onPreExecute");
        try {
            boolean xh = this.dNl.xh();
            mg.aFF();
            if (!xh) {
                cancel(true);
            }
        } catch (UnmetDependencyException e) {
            throw e;
        } catch (Throwable e2) {
            emm.aEU().mo2953g("Fabric", "Failure onPreExecute()", e2);
            mg.aFF();
            cancel(true);
        } catch (Throwable th) {
            mg.aFF();
            cancel(true);
        }
    }

    protected Result m10914a(Void... voidArr) {
        enq mg = mg("doInBackground");
        Result result = null;
        if (!isCancelled()) {
            result = this.dNl.xf();
        }
        mg.aFF();
        return result;
    }

    protected void onPostExecute(Result result) {
        this.dNl.onPostExecute(result);
        this.dNl.dMV.de(result);
    }

    protected void onCancelled(Result result) {
        this.dNl.onCancelled(result);
        this.dNl.dMV.mo2960l(new InitializationException(this.dNl.getIdentifier() + " Initialization was cancelled"));
    }

    public Priority xS() {
        return Priority.HIGH;
    }

    private enq mg(String str) {
        enq com_fossil_enq = new enq(this.dNl.getIdentifier() + "." + str, "KitInitialization");
        com_fossil_enq.aFE();
        return com_fossil_enq;
    }
}
