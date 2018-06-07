package com.fossil;

import android.os.IInterface;
import android.os.RemoteException;

public interface avj extends IInterface {
    void cancel() throws RemoteException;
}
