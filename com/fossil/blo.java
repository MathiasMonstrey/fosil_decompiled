package com.fossil;

import android.os.IInterface;
import android.os.RemoteException;

public interface blo extends IInterface {
    boolean getBooleanFlagValue(String str, boolean z, int i) throws RemoteException;

    int getIntFlagValue(String str, int i, int i2) throws RemoteException;

    long getLongFlagValue(String str, long j, int i) throws RemoteException;

    String getStringFlagValue(String str, String str2, int i) throws RemoteException;

    void init(ayq com_fossil_ayq) throws RemoteException;
}
