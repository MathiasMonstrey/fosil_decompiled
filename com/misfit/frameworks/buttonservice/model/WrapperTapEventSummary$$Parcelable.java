package com.misfit.frameworks.buttonservice.model;

import android.os.Parcel;
import android.os.Parcelable;
import org.parceler.IdentityCollection;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

public class WrapperTapEventSummary$$Parcelable implements Parcelable, ParcelWrapper<WrapperTapEventSummary> {
    public static final WrapperTapEventSummary$$Parcelable$Creator$$6 CREATOR = new WrapperTapEventSummary$$Parcelable$Creator$$6();
    private WrapperTapEventSummary wrapperTapEventSummary$$0;

    public WrapperTapEventSummary$$Parcelable(WrapperTapEventSummary wrapperTapEventSummary) {
        this.wrapperTapEventSummary$$0 = wrapperTapEventSummary;
    }

    public void writeToParcel(Parcel parcel, int i) {
        write(this.wrapperTapEventSummary$$0, parcel, i, new IdentityCollection());
    }

    public static void write(WrapperTapEventSummary wrapperTapEventSummary, Parcel parcel, int i, IdentityCollection identityCollection) {
        int key = identityCollection.getKey(wrapperTapEventSummary);
        if (key != -1) {
            parcel.writeInt(key);
            return;
        }
        parcel.writeInt(identityCollection.put(wrapperTapEventSummary));
        parcel.writeLong(wrapperTapEventSummary.startTime);
        parcel.writeLong(wrapperTapEventSummary.doubleTapCount);
        parcel.writeLong(wrapperTapEventSummary.tripleTapCount);
        if (wrapperTapEventSummary.goalTrackingIds == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(wrapperTapEventSummary.goalTrackingIds.length);
        for (long writeLong : wrapperTapEventSummary.goalTrackingIds) {
            parcel.writeLong(writeLong);
        }
    }

    public int describeContents() {
        return 0;
    }

    public WrapperTapEventSummary getParcel() {
        return this.wrapperTapEventSummary$$0;
    }

    public static WrapperTapEventSummary read(Parcel parcel, IdentityCollection identityCollection) {
        int readInt = parcel.readInt();
        if (!identityCollection.containsKey(readInt)) {
            long[] jArr;
            int reserve = identityCollection.reserve();
            long readLong = parcel.readLong();
            long readLong2 = parcel.readLong();
            long readLong3 = parcel.readLong();
            int readInt2 = parcel.readInt();
            if (readInt2 < 0) {
                jArr = null;
            } else {
                jArr = new long[readInt2];
                for (readInt = 0; readInt < readInt2; readInt++) {
                    jArr[readInt] = parcel.readLong();
                }
            }
            WrapperTapEventSummary wrapperTapEventSummary = new WrapperTapEventSummary(readLong, readLong2, readLong3, jArr);
            identityCollection.put(reserve, wrapperTapEventSummary);
            return wrapperTapEventSummary;
        } else if (!identityCollection.isReserved(readInt)) {
            return (WrapperTapEventSummary) identityCollection.get(readInt);
        } else {
            throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
