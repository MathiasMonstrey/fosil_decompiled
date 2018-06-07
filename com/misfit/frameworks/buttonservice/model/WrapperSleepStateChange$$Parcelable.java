package com.misfit.frameworks.buttonservice.model;

import android.os.Parcel;
import android.os.Parcelable;
import org.parceler.IdentityCollection;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

public class WrapperSleepStateChange$$Parcelable implements Parcelable, ParcelWrapper<WrapperSleepStateChange> {
    public static final WrapperSleepStateChange$$Parcelable$Creator$$4 CREATOR = new WrapperSleepStateChange$$Parcelable$Creator$$4();
    private WrapperSleepStateChange wrapperSleepStateChange$$0;

    public WrapperSleepStateChange$$Parcelable(WrapperSleepStateChange wrapperSleepStateChange) {
        this.wrapperSleepStateChange$$0 = wrapperSleepStateChange;
    }

    public void writeToParcel(Parcel parcel, int i) {
        write(this.wrapperSleepStateChange$$0, parcel, i, new IdentityCollection());
    }

    public static void write(WrapperSleepStateChange wrapperSleepStateChange, Parcel parcel, int i, IdentityCollection identityCollection) {
        int key = identityCollection.getKey(wrapperSleepStateChange);
        if (key != -1) {
            parcel.writeInt(key);
            return;
        }
        parcel.writeInt(identityCollection.put(wrapperSleepStateChange));
        parcel.writeInt(wrapperSleepStateChange.state);
        parcel.writeLong(wrapperSleepStateChange.index);
    }

    public int describeContents() {
        return 0;
    }

    public WrapperSleepStateChange getParcel() {
        return this.wrapperSleepStateChange$$0;
    }

    public static WrapperSleepStateChange read(Parcel parcel, IdentityCollection identityCollection) {
        int readInt = parcel.readInt();
        if (!identityCollection.containsKey(readInt)) {
            int reserve = identityCollection.reserve();
            WrapperSleepStateChange wrapperSleepStateChange = new WrapperSleepStateChange(parcel.readInt(), parcel.readLong());
            identityCollection.put(reserve, wrapperSleepStateChange);
            return wrapperSleepStateChange;
        } else if (!identityCollection.isReserved(readInt)) {
            return (WrapperSleepStateChange) identityCollection.get(readInt);
        } else {
            throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
