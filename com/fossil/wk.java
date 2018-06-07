package com.fossil;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;

public class wk {
    private final InputStream aDv;
    private final ParcelFileDescriptor aDw;

    public wk(InputStream inputStream, ParcelFileDescriptor parcelFileDescriptor) {
        this.aDv = inputStream;
        this.aDw = parcelFileDescriptor;
    }

    public InputStream vu() {
        return this.aDv;
    }

    public ParcelFileDescriptor vv() {
        return this.aDw;
    }
}
