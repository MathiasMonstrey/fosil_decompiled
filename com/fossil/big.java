package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class big extends auq {
    public static final Creator<big> CREATOR = new bih();
    private int ber;
    private final bii bvo;

    big(int i, bii com_fossil_bii) {
        this.ber = i;
        this.bvo = com_fossil_bii;
    }

    private big(bii com_fossil_bii) {
        this.ber = 1;
        this.bvo = com_fossil_bii;
    }

    public static big m5196a(bio<?, ?> com_fossil_bio___) {
        if (com_fossil_bio___ instanceof bii) {
            return new big((bii) com_fossil_bio___);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    public final bio<?, ?> Ow() {
        if (this.bvo != null) {
            return this.bvo;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4565c(parcel, 1, this.ber);
        aus.m4548a(parcel, 2, this.bvo, i, false);
        aus.m4540G(parcel, A);
    }
}
