package com.fossil;

import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.fossil.ats.C1888f;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public class bwv extends bwr {
    private static final String TAG = bwv.class.getSimpleName();
    private final C1967d bIa = null;
    private final C1965a bIb;
    private final C1968e bIc;
    private final C1969f bId;
    private final C1966c bIe;

    public static abstract class C1964b<R extends atz, A extends C1888f> extends bds<R, A> {
        public C1964b(ats com_fossil_ats, atv com_fossil_atv) {
            super(com_fossil_ats, com_fossil_atv);
        }

        public final /* synthetic */ void aV(Object obj) {
            super.m4406d((atz) obj);
        }
    }

    public static abstract class C1965a<A extends C1888f> extends C1964b<buw, A> {
        public C1965a(ats com_fossil_ats, atv com_fossil_atv) {
            super(com_fossil_ats, com_fossil_atv);
        }

        protected final /* synthetic */ atz mo1172c(Status status) {
            return new buw(DataHolder.ht(status.getStatusCode()));
        }
    }

    public static abstract class C1966c<A extends C1888f> extends C1964b<buz, A> {
        protected final /* synthetic */ atz mo1172c(Status status) {
            return new buz(DataHolder.ht(status.getStatusCode()));
        }
    }

    public static abstract class C1967d<A extends C1888f> extends C1964b<bvc, A> {
        protected final /* synthetic */ atz mo1172c(Status status) {
            return new bvc(DataHolder.ht(status.getStatusCode()), 100);
        }
    }

    @Deprecated
    public static abstract class C1968e<A extends C1888f> extends C1964b<bmz, A> {
    }

    public static abstract class C1969f<A extends C1888f> extends C1964b<Status, A> {
        protected final /* synthetic */ atz mo1172c(Status status) {
            return status;
        }
    }

    public bwv(C1965a c1965a) {
        this.bIb = c1965a;
        this.bIc = null;
        this.bId = null;
        this.bIe = null;
    }

    public final void mo1494a(DataHolder dataHolder) throws RemoteException {
        awa.m4634a(this.bIa != null, "placeEstimator cannot be null");
        if (dataHolder == null) {
            if (Log.isLoggable(TAG, 6)) {
                Log.e(TAG, "onPlaceEstimated received null DataHolder", new Throwable());
            }
            this.bIa.m4411i(Status.bgy);
            return;
        }
        Bundle KN = dataHolder.KN();
        this.bIa.m4406d(new bvc(dataHolder, KN == null ? 100 : bvc.m5717A(KN)));
    }

    public final void mo1495b(DataHolder dataHolder) throws RemoteException {
        if (dataHolder == null) {
            if (Log.isLoggable(TAG, 6)) {
                Log.e(TAG, "onAutocompletePrediction received null DataHolder", new Throwable());
            }
            this.bIb.m4411i(Status.bgy);
            return;
        }
        this.bIb.m4406d(new buw(dataHolder));
    }

    public final void mo1496c(DataHolder dataHolder) throws RemoteException {
        C1968e c1968e = null;
        if (dataHolder == null) {
            if (Log.isLoggable(TAG, 6)) {
                Log.e(TAG, "onPlaceUserDataFetched received null DataHolder", new Throwable());
            }
            c1968e.m4411i(Status.bgy);
            return;
        }
        c1968e.m4406d(new bmz(dataHolder));
    }

    public final void mo1497d(DataHolder dataHolder) throws RemoteException {
        this.bIe.m4406d(new buz(dataHolder));
    }

    public final void mo1498o(Status status) throws RemoteException {
        this.bId.m4406d(status);
    }
}
