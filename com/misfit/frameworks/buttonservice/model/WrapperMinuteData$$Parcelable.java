package com.misfit.frameworks.buttonservice.model;

import android.os.Parcel;
import android.os.Parcelable;
import org.parceler.IdentityCollection;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

public class WrapperMinuteData$$Parcelable implements Parcelable, ParcelWrapper<WrapperMinuteData> {
    public static final WrapperMinuteData$$Parcelable$Creator$$2 CREATOR = new WrapperMinuteData$$Parcelable$Creator$$2();
    private WrapperMinuteData wrapperMinuteData$$0;

    public WrapperMinuteData$$Parcelable(WrapperMinuteData wrapperMinuteData) {
        this.wrapperMinuteData$$0 = wrapperMinuteData;
    }

    public void writeToParcel(Parcel parcel, int i) {
        write(this.wrapperMinuteData$$0, parcel, i, new IdentityCollection());
    }

    public static void write(WrapperMinuteData wrapperMinuteData, Parcel parcel, int i, IdentityCollection identityCollection) {
        int key = identityCollection.getKey(wrapperMinuteData);
        if (key != -1) {
            parcel.writeInt(key);
            return;
        }
        parcel.writeInt(identityCollection.put(wrapperMinuteData));
        parcel.writeLong(wrapperMinuteData.id);
        parcel.writeLong(wrapperMinuteData.startTime);
        parcel.writeLong(wrapperMinuteData.steps);
        parcel.writeLong(wrapperMinuteData.points);
    }

    public int describeContents() {
        return 0;
    }

    public WrapperMinuteData getParcel() {
        return this.wrapperMinuteData$$0;
    }

    public static WrapperMinuteData read(Parcel parcel, IdentityCollection identityCollection) {
        int readInt = parcel.readInt();
        if (!identityCollection.containsKey(readInt)) {
            readInt = identityCollection.reserve();
            WrapperMinuteData wrapperMinuteData = new WrapperMinuteData(parcel.readLong(), parcel.readLong(), parcel.readLong(), parcel.readLong());
            identityCollection.put(readInt, wrapperMinuteData);
            return wrapperMinuteData;
        } else if (!identityCollection.isReserved(readInt)) {
            return (WrapperMinuteData) identityCollection.get(readInt);
        } else {
            throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
