package com.fossil;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

public class eoq extends eor {
    public eoq(Context context, File file, String str, String str2) throws IOException {
        super(context, file, str, str2);
    }

    public OutputStream mo2988C(File file) throws IOException {
        return new GZIPOutputStream(new FileOutputStream(file));
    }
}
