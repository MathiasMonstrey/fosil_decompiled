package com.fossil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class yi<T> implements un<File, T> {
    private static final C4222a aEx = new C4222a();
    private un<InputStream, T> aEm;
    private final C4222a aEy;

    static class C4222a {
        C4222a() {
        }

        public InputStream m14076q(File file) throws FileNotFoundException {
            return new FileInputStream(file);
        }
    }

    public yi(un<InputStream, T> unVar) {
        this(unVar, aEx);
    }

    yi(un<InputStream, T> unVar, C4222a c4222a) {
        this.aEm = unVar;
        this.aEy = c4222a;
    }

    public vh<T> m14077b(File file, int i, int i2) throws IOException {
        InputStream inputStream = null;
        try {
            inputStream = this.aEy.m14076q(file);
            vh<T> b = this.aEm.mo4436b(inputStream, i, i2);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                }
            }
            return b;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                }
            }
        }
    }

    public String getId() {
        return "";
    }
}
