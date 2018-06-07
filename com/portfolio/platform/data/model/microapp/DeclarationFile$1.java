package com.portfolio.platform.data.model.microapp;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class DeclarationFile$1 implements Creator<DeclarationFile> {
    DeclarationFile$1() {
    }

    public DeclarationFile createFromParcel(Parcel parcel) {
        return new DeclarationFile(parcel);
    }

    public DeclarationFile[] newArray(int i) {
        return new DeclarationFile[i];
    }
}
