package com.fossil;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;

public interface bxu extends IInterface {
    ayq Tq() throws RemoteException;

    void mo1534a(byb com_fossil_byb) throws RemoteException;

    void onCreate(Bundle bundle) throws RemoteException;

    void onDestroy() throws RemoteException;

    void onLowMemory() throws RemoteException;

    void onPause() throws RemoteException;

    void onResume() throws RemoteException;

    void onSaveInstanceState(Bundle bundle) throws RemoteException;

    void onStart() throws RemoteException;

    void onStop() throws RemoteException;
}
