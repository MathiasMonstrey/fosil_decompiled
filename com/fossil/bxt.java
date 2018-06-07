package com.fossil;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.maps.GoogleMapOptions;

public interface bxt extends IInterface {
    ayq mo1521a(ayq com_fossil_ayq, ayq com_fossil_ayq2, Bundle bundle) throws RemoteException;

    void mo1522a(ayq com_fossil_ayq, GoogleMapOptions googleMapOptions, Bundle bundle) throws RemoteException;

    void mo1523a(byb com_fossil_byb) throws RemoteException;

    void onCreate(Bundle bundle) throws RemoteException;

    void onDestroy() throws RemoteException;

    void onDestroyView() throws RemoteException;

    void onLowMemory() throws RemoteException;

    void onPause() throws RemoteException;

    void onResume() throws RemoteException;

    void onSaveInstanceState(Bundle bundle) throws RemoteException;

    void onStart() throws RemoteException;

    void onStop() throws RemoteException;
}
