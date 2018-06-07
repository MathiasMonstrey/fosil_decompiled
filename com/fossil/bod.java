package com.fossil;

import android.os.IInterface;
import android.os.RemoteException;
import java.util.List;

public interface bod extends IInterface {
    List<bsh> mo1428a(bnh com_fossil_bnh, boolean z) throws RemoteException;

    List<bnk> mo1429a(String str, String str2, bnh com_fossil_bnh) throws RemoteException;

    List<bsh> mo1430a(String str, String str2, String str3, boolean z) throws RemoteException;

    List<bsh> mo1431a(String str, String str2, boolean z, bnh com_fossil_bnh) throws RemoteException;

    void mo1432a(long j, String str, String str2, String str3) throws RemoteException;

    void mo1433a(bnh com_fossil_bnh) throws RemoteException;

    void mo1434a(bnk com_fossil_bnk, bnh com_fossil_bnh) throws RemoteException;

    void mo1435a(bnz com_fossil_bnz, bnh com_fossil_bnh) throws RemoteException;

    void mo1436a(bnz com_fossil_bnz, String str, String str2) throws RemoteException;

    void mo1437a(bsh com_fossil_bsh, bnh com_fossil_bnh) throws RemoteException;

    byte[] mo1438a(bnz com_fossil_bnz, String str) throws RemoteException;

    void mo1439b(bnh com_fossil_bnh) throws RemoteException;

    void mo1440b(bnk com_fossil_bnk) throws RemoteException;

    String mo1441c(bnh com_fossil_bnh) throws RemoteException;

    List<bnk> mo1442g(String str, String str2, String str3) throws RemoteException;
}
