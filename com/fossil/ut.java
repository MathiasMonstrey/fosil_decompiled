package com.fossil;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import java.io.IOException;

public class ut extends uq<ParcelFileDescriptor> {
    protected /* synthetic */ Object mo4189a(AssetManager assetManager, String str) throws IOException {
        return m13840b(assetManager, str);
    }

    protected /* synthetic */ void bd(Object obj) throws IOException {
        m13839a((ParcelFileDescriptor) obj);
    }

    public ut(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    protected ParcelFileDescriptor m13840b(AssetManager assetManager, String str) throws IOException {
        return assetManager.openFd(str).getParcelFileDescriptor();
    }

    protected void m13839a(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        parcelFileDescriptor.close();
    }
}
