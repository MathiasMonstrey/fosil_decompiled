package com.fossil;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;

public interface bxw extends IInterface {
    ayq Tq() throws RemoteException;

    void mo1502a(bye com_fossil_bye) throws RemoteException;

    void onCreate(Bundle bundle) throws RemoteException;

    void onDestroy() throws RemoteException;

    void onLowMemory() throws RemoteException;

    void onPause() throws RemoteException;

    void onResume() throws RemoteException;

    void onSaveInstanceState(Bundle bundle) throws RemoteException;
}
