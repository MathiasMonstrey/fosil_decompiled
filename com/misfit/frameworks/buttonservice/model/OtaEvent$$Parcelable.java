package com.misfit.frameworks.buttonservice.model;

import android.os.Parcel;
import android.os.Parcelable;
import org.parceler.IdentityCollection;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

public class OtaEvent$$Parcelable implements Parcelable, ParcelWrapper<OtaEvent> {
    public static final OtaEvent$$Parcelable$Creator$$0 CREATOR = new OtaEvent$$Parcelable$Creator$$0();
    private OtaEvent otaEvent$$0;

    public OtaEvent$$Parcelable(OtaEvent otaEvent) {
        this.otaEvent$$0 = otaEvent;
    }

    public void writeToParcel(Parcel parcel, int i) {
        write(this.otaEvent$$0, parcel, i, new IdentityCollection());
    }

    public static void write(OtaEvent otaEvent, Parcel parcel, int i, IdentityCollection identityCollection) {
        int key = identityCollection.getKey(otaEvent);
        if (key != -1) {
            parcel.writeInt(key);
            return;
        }
        parcel.writeInt(identityCollection.put(otaEvent));
        parcel.writeString(otaEvent.serial);
        parcel.writeFloat(otaEvent.process);
    }

    public int describeContents() {
        return 0;
    }

    public OtaEvent getParcel() {
        return this.otaEvent$$0;
    }

    public static OtaEvent read(Parcel parcel, IdentityCollection identityCollection) {
        int readInt = parcel.readInt();
        if (!identityCollection.containsKey(readInt)) {
            int reserve = identityCollection.reserve();
            OtaEvent otaEvent = new OtaEvent(parcel.readString(), parcel.readFloat());
            identityCollection.put(reserve, otaEvent);
            return otaEvent;
        } else if (!identityCollection.isReserved(readInt)) {
            return (OtaEvent) identityCollection.get(readInt);
        } else {
            throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
