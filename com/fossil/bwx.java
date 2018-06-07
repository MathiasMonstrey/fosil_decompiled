package com.fossil;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;

public interface bwx extends IInterface {
    void mo1398a(LocationAvailability locationAvailability) throws RemoteException;

    void mo1399a(LocationResult locationResult) throws RemoteException;
}
