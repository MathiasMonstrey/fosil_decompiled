package com.misfit.frameworks.buttonservice.model.microapp;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class MicroAppInstruction$1 implements Creator<MicroAppInstruction> {
    MicroAppInstruction$1() {
    }

    public MicroAppInstruction createFromParcel(Parcel parcel) {
        try {
            Constructor declaredConstructor = Class.forName(parcel.readString()).getDeclaredConstructor(new Class[]{Parcel.class});
            declaredConstructor.setAccessible(true);
            return (MicroAppInstruction) declaredConstructor.newInstance(new Object[]{parcel});
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        } catch (InstantiationException e4) {
            e4.printStackTrace();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
        }
        return null;
    }

    public MicroAppInstruction[] newArray(int i) {
        return new MicroAppInstruction[i];
    }
}
