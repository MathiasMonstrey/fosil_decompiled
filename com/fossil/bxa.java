package com.fossil;

import android.location.Location;
import android.os.IInterface;
import android.os.RemoteException;

public interface bxa extends IInterface {
    void onLocationChanged(Location location) throws RemoteException;
}
