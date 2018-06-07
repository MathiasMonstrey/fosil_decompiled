package com.misfit.frameworks.buttonservice.model.microapp.mapping.customization;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.misfit.ble.setting.uapp.files.customization.UAppCustomizationFrame;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public abstract class BLECustomization implements Parcelable {
    public static Creator<BLECustomization> CREATOR = new C47181();
    public static final String FIELD_TYPE = "mType";
    private final String className = getClass().getName();
    protected int mType;

    static class C47181 implements Creator<BLECustomization> {
        C47181() {
        }

        public BLECustomization createFromParcel(Parcel parcel) {
            try {
                Constructor declaredConstructor = Class.forName(parcel.readString()).getDeclaredConstructor(new Class[]{Parcel.class});
                declaredConstructor.setAccessible(true);
                return (BLECustomization) declaredConstructor.newInstance(new Object[]{parcel});
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

        public BLECustomization[] newArray(int i) {
            return new BLECustomization[i];
        }
    }

    public static class BLEMappingCustomizationType {
        public static final int GOAL_TRACKING_TYPE = 1;
        public static final int NON_TYPE = 0;
    }

    public abstract UAppCustomizationFrame getCustomizationFrame();

    public abstract String getHash();

    public int describeContents() {
        return 0;
    }

    public BLECustomization(int i) {
        this.mType = i;
    }

    protected BLECustomization(Parcel parcel) {
        this.mType = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.className);
        parcel.writeInt(this.mType);
    }

    public int getType() {
        return this.mType;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof BLECustomization)) {
            return false;
        }
        return getHash().equalsIgnoreCase(((BLECustomization) obj).getHash());
    }
}
