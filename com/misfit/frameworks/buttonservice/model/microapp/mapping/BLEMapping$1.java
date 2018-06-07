package com.misfit.frameworks.buttonservice.model.microapp.mapping;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class BLEMapping$1 implements Creator<BLEMapping> {
    BLEMapping$1() {
    }

    public BLEMapping createFromParcel(Parcel parcel) {
        try {
            Constructor declaredConstructor = Class.forName(parcel.readString()).getDeclaredConstructor(new Class[]{Parcel.class});
            declaredConstructor.setAccessible(true);
            return (BLEMapping) declaredConstructor.newInstance(new Object[]{parcel});
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

    public BLEMapping[] newArray(int i) {
        return new BLEMapping[i];
    }
}
