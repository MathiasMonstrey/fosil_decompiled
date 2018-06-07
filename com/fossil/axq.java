package com.fossil;

import java.io.Closeable;
import java.io.IOException;

public final class axq {
    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }
}
