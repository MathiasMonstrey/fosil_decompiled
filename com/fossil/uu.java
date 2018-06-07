package com.fossil;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;

public class uu extends uw<ParcelFileDescriptor> {
    protected /* synthetic */ Object mo4191b(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        return m13843a(uri, contentResolver);
    }

    protected /* synthetic */ void bd(Object obj) throws IOException {
        m13844a((ParcelFileDescriptor) obj);
    }

    public uu(Context context, Uri uri) {
        super(context, uri);
    }

    protected ParcelFileDescriptor m13843a(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        return contentResolver.openAssetFileDescriptor(uri, "r").getParcelFileDescriptor();
    }

    protected void m13844a(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        parcelFileDescriptor.close();
    }
}
