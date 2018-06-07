package com.misfit.frameworks.buttonservice.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import org.parceler.IdentityCollection;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

public class WrapperSyncResult$$Parcelable implements Parcelable, ParcelWrapper<WrapperSyncResult> {
    public static final WrapperSyncResult$$Parcelable$Creator$$5 CREATOR = new WrapperSyncResult$$Parcelable$Creator$$5();
    private WrapperSyncResult wrapperSyncResult$$0;

    public WrapperSyncResult$$Parcelable(WrapperSyncResult wrapperSyncResult) {
        this.wrapperSyncResult$$0 = wrapperSyncResult;
    }

    public void writeToParcel(Parcel parcel, int i) {
        write(this.wrapperSyncResult$$0, parcel, i, new IdentityCollection());
    }

    public static void write(WrapperSyncResult wrapperSyncResult, Parcel parcel, int i, IdentityCollection identityCollection) {
        int key = identityCollection.getKey(wrapperSyncResult);
        if (key != -1) {
            parcel.writeInt(key);
            return;
        }
        parcel.writeInt(identityCollection.put(wrapperSyncResult));
        if (wrapperSyncResult.sleepSessions == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(wrapperSyncResult.sleepSessions.size());
            for (WrapperSleep write : wrapperSyncResult.sleepSessions) {
                WrapperSleep$$Parcelable.write(write, parcel, i, identityCollection);
            }
        }
        if (wrapperSyncResult.minuteDataList == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(wrapperSyncResult.minuteDataList.size());
            for (WrapperMinuteData write2 : wrapperSyncResult.minuteDataList) {
                WrapperMinuteData$$Parcelable.write(write2, parcel, i, identityCollection);
            }
        }
        if (wrapperSyncResult.tapEventSummaryList == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(wrapperSyncResult.tapEventSummaryList.size());
            for (WrapperTapEventSummary write3 : wrapperSyncResult.tapEventSummaryList) {
                WrapperTapEventSummary$$Parcelable.write(write3, parcel, i, identityCollection);
            }
        }
        if (wrapperSyncResult.fileIds == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(wrapperSyncResult.fileIds.size());
            for (String writeString : wrapperSyncResult.fileIds) {
                parcel.writeString(writeString);
            }
        }
        parcel.writeFloat(wrapperSyncResult.calories);
        parcel.writeFloat(wrapperSyncResult.distance);
        parcel.writeLong(wrapperSyncResult.realTimeStep);
        parcel.writeInt(wrapperSyncResult.vibeStrengthLevel);
    }

    public int describeContents() {
        return 0;
    }

    public WrapperSyncResult getParcel() {
        return this.wrapperSyncResult$$0;
    }

    public static WrapperSyncResult read(Parcel parcel, IdentityCollection identityCollection) {
        int readInt = parcel.readInt();
        if (!identityCollection.containsKey(readInt)) {
            List list;
            List list2;
            List list3;
            List list4;
            int reserve = identityCollection.reserve();
            int readInt2 = parcel.readInt();
            if (readInt2 < 0) {
                list = null;
            } else {
                list = new ArrayList(readInt2);
                for (int i = 0; i < readInt2; i++) {
                    list.add(WrapperSleep$$Parcelable.read(parcel, identityCollection));
                }
            }
            int readInt3 = parcel.readInt();
            if (readInt3 < 0) {
                list2 = null;
            } else {
                list2 = new ArrayList(readInt3);
                for (readInt2 = 0; readInt2 < readInt3; readInt2++) {
                    list2.add(WrapperMinuteData$$Parcelable.read(parcel, identityCollection));
                }
            }
            int readInt4 = parcel.readInt();
            if (readInt4 < 0) {
                list3 = null;
            } else {
                list3 = new ArrayList(readInt4);
                for (readInt3 = 0; readInt3 < readInt4; readInt3++) {
                    list3.add(WrapperTapEventSummary$$Parcelable.read(parcel, identityCollection));
                }
            }
            readInt4 = parcel.readInt();
            if (readInt4 < 0) {
                list4 = null;
            } else {
                list4 = new ArrayList(readInt4);
                for (int i2 = 0; i2 < readInt4; i2++) {
                    list4.add(parcel.readString());
                }
            }
            WrapperSyncResult wrapperSyncResult = new WrapperSyncResult(list, list2, list3, list4, parcel.readFloat(), parcel.readFloat(), parcel.readLong(), parcel.readInt());
            identityCollection.put(reserve, wrapperSyncResult);
            return wrapperSyncResult;
        } else if (!identityCollection.isReserved(readInt)) {
            return (WrapperSyncResult) identityCollection.get(readInt);
        } else {
            throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
