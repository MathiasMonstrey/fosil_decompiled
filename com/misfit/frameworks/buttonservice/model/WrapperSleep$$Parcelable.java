package com.misfit.frameworks.buttonservice.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import org.parceler.IdentityCollection;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

public class WrapperSleep$$Parcelable implements Parcelable, ParcelWrapper<WrapperSleep> {
    public static final WrapperSleep$$Parcelable$Creator$$3 CREATOR = new WrapperSleep$$Parcelable$Creator$$3();
    private WrapperSleep wrapperSleep$$0;

    public WrapperSleep$$Parcelable(WrapperSleep wrapperSleep) {
        this.wrapperSleep$$0 = wrapperSleep;
    }

    public void writeToParcel(Parcel parcel, int i) {
        write(this.wrapperSleep$$0, parcel, i, new IdentityCollection());
    }

    public static void write(WrapperSleep wrapperSleep, Parcel parcel, int i, IdentityCollection identityCollection) {
        int key = identityCollection.getKey(wrapperSleep);
        if (key != -1) {
            parcel.writeInt(key);
            return;
        }
        parcel.writeInt(identityCollection.put(wrapperSleep));
        parcel.writeLong(wrapperSleep.startTime);
        parcel.writeLong(wrapperSleep.duration);
        parcel.writeLong(wrapperSleep.sleepMinute);
        parcel.writeLong(wrapperSleep.deepSleepMinute);
        parcel.writeFloat(wrapperSleep.sleepQuality);
        if (wrapperSleep.sleepStateChanges == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(wrapperSleep.sleepStateChanges.size());
        for (WrapperSleepStateChange write : wrapperSleep.sleepStateChanges) {
            WrapperSleepStateChange$$Parcelable.write(write, parcel, i, identityCollection);
        }
    }

    public int describeContents() {
        return 0;
    }

    public WrapperSleep getParcel() {
        return this.wrapperSleep$$0;
    }

    public static WrapperSleep read(Parcel parcel, IdentityCollection identityCollection) {
        int readInt = parcel.readInt();
        if (!identityCollection.containsKey(readInt)) {
            List list;
            int reserve = identityCollection.reserve();
            long readLong = parcel.readLong();
            long readLong2 = parcel.readLong();
            long readLong3 = parcel.readLong();
            long readLong4 = parcel.readLong();
            float readFloat = parcel.readFloat();
            int readInt2 = parcel.readInt();
            if (readInt2 < 0) {
                list = null;
            } else {
                list = new ArrayList(readInt2);
                for (readInt = 0; readInt < readInt2; readInt++) {
                    list.add(WrapperSleepStateChange$$Parcelable.read(parcel, identityCollection));
                }
            }
            WrapperSleep wrapperSleep = new WrapperSleep(readLong, readLong2, readLong3, readLong4, readFloat, list);
            identityCollection.put(reserve, wrapperSleep);
            return wrapperSleep;
        } else if (!identityCollection.isReserved(readInt)) {
            return (WrapperSleep) identityCollection.get(readInt);
        } else {
            throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
