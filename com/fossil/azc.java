package com.fossil;

import android.os.IBinder;
import com.fossil.ayq.C1901a;
import java.lang.reflect.Field;

public final class azc<T> extends C1901a {
    private final T afr;

    private azc(T t) {
        this.afr = t;
    }

    public static <T> T m4739a(ayq com_fossil_ayq) {
        int i = 0;
        if (com_fossil_ayq instanceof azc) {
            return ((azc) com_fossil_ayq).afr;
        }
        IBinder asBinder = com_fossil_ayq.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        Field field = null;
        int length = declaredFields.length;
        int i2 = 0;
        while (i2 < length) {
            Field field2 = declaredFields[i2];
            if (field2.isSynthetic()) {
                field2 = field;
            } else {
                i++;
            }
            i2++;
            field = field2;
        }
        if (i != 1) {
            throw new IllegalArgumentException("Unexpected number of IObjectWrapper declared fields: " + declaredFields.length);
        } else if (field.isAccessible()) {
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        } else {
            field.setAccessible(true);
            try {
                return field.get(asBinder);
            } catch (Throwable e) {
                throw new IllegalArgumentException("Binder object is null.", e);
            } catch (Throwable e2) {
                throw new IllegalArgumentException("Could not access the field in remoteBinder.", e2);
            }
        }
    }

    public static <T> ayq bQ(T t) {
        return new azc(t);
    }
}
