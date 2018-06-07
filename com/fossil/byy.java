package com.fossil;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;

public interface byy extends IInterface {
    boolean TA() throws RemoteException;

    float TD() throws RemoteException;

    void TG() throws RemoteException;

    void TH() throws RemoteException;

    boolean TI() throws RemoteException;

    int TJ() throws RemoteException;

    ayq TK() throws RemoteException;

    LatLng Tl() throws RemoteException;

    String Tw() throws RemoteException;

    boolean Tz() throws RemoteException;

    boolean mo1560a(byy com_fossil_byy) throws RemoteException;

    void ai(float f) throws RemoteException;

    void bx(boolean z) throws RemoteException;

    void by(boolean z) throws RemoteException;

    void mo1564d(LatLng latLng) throws RemoteException;

    void mo1565e(ayq com_fossil_ayq) throws RemoteException;

    void eX(String str) throws RemoteException;

    void mo1567f(ayq com_fossil_ayq) throws RemoteException;

    float getAlpha() throws RemoteException;

    String getId() throws RemoteException;

    float getRotation() throws RemoteException;

    String getTitle() throws RemoteException;

    boolean isVisible() throws RemoteException;

    void remove() throws RemoteException;

    void setAlpha(float f) throws RemoteException;

    void setRotation(float f) throws RemoteException;

    void setTitle(String str) throws RemoteException;

    void setVisible(boolean z) throws RemoteException;

    void mo1578u(float f, float f2) throws RemoteException;

    void mo1579v(float f, float f2) throws RemoteException;
}
