package com.fossil;

import android.os.IInterface;
import android.os.Message;
import android.os.RemoteException;

public interface bca extends IInterface {
    void send(Message message) throws RemoteException;
}
