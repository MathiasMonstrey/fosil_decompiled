package com.misfit.frameworks.buttonservice.model;

import android.os.Parcel;
import android.os.Parcelable;
import org.parceler.IdentityCollection;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

public class WrapperActivitySync$$Parcelable implements Parcelable, ParcelWrapper<WrapperActivitySync> {
    public static final WrapperActivitySync$$Parcelable$Creator$$1 CREATOR = new WrapperActivitySync$$Parcelable$Creator$$1();
    private WrapperActivitySync wrapperActivitySync$$0;

    public WrapperActivitySync$$Parcelable(WrapperActivitySync wrapperActivitySync) {
        this.wrapperActivitySync$$0 = wrapperActivitySync;
    }

    public void writeToParcel(Parcel parcel, int i) {
        write(this.wrapperActivitySync$$0, parcel, i, new IdentityCollection());
    }

    public static void write(WrapperActivitySync wrapperActivitySync, Parcel parcel, int i, IdentityCollection identityCollection) {
        int key = identityCollection.getKey(wrapperActivitySync);
        if (key != -1) {
            parcel.writeInt(key);
            return;
        }
        parcel.writeInt(identityCollection.put(wrapperActivitySync));
        parcel.writeLong(wrapperActivitySync.mStartTimestamp);
        parcel.writeLong(wrapperActivitySync.mEndTimestamp);
        parcel.writeLong(wrapperActivitySync.mBipedalCount);
        parcel.writeLong(wrapperActivitySync.mPoints);
        parcel.writeInt(wrapperActivitySync.mVariance);
        parcel.writeFloat(wrapperActivitySync.mCalories);
        parcel.writeFloat(wrapperActivitySync.mDistance);
    }

    public int describeContents() {
        return 0;
    }

    public WrapperActivitySync getParcel() {
        return this.wrapperActivitySync$$0;
    }

    public static WrapperActivitySync read(Parcel parcel, IdentityCollection identityCollection) {
        int readInt = parcel.readInt();
        if (!identityCollection.containsKey(readInt)) {
            readInt = identityCollection.reserve();
            WrapperActivitySync wrapperActivitySync = new WrapperActivitySync(parcel.readLong(), parcel.readLong(), parcel.readLong(), parcel.readLong(), parcel.readInt(), parcel.readFloat(), parcel.readFloat());
            identityCollection.put(readInt, wrapperActivitySync);
            return wrapperActivitySync;
        } else if (!identityCollection.isReserved(readInt)) {
            return (WrapperActivitySync) identityCollection.get(readInt);
        } else {
            throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
