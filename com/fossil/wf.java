package com.fossil;

import android.net.Uri;
import java.io.File;

public class wf<T> implements wp<File, T> {
    private final wp<Uri, T> aDh;

    public /* synthetic */ us mo4419c(Object obj, int i, int i2) {
        return m13985a((File) obj, i, i2);
    }

    public wf(wp<Uri, T> wpVar) {
        this.aDh = wpVar;
    }

    public us<T> m13985a(File file, int i, int i2) {
        return this.aDh.mo4419c(Uri.fromFile(file), i, i2);
    }
}
