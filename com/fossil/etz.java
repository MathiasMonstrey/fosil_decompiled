package com.fossil;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import org.apache.commons.io.output.StringBuilderWriter;

public class etz {
    public static final char dTK = File.separatorChar;
    public static final String dTL;

    static {
        Writer stringBuilderWriter = new StringBuilderWriter(4);
        PrintWriter printWriter = new PrintWriter(stringBuilderWriter);
        printWriter.println();
        dTL = stringBuilderWriter.toString();
        printWriter.close();
    }

    public static byte[] m11205z(InputStream inputStream) throws IOException {
        OutputStream com_fossil_eua = new eua();
        m11203d(inputStream, com_fossil_eua);
        return com_fossil_eua.toByteArray();
    }

    public static int m11203d(InputStream inputStream, OutputStream outputStream) throws IOException {
        long e = m11204e(inputStream, outputStream);
        if (e > 2147483647L) {
            return -1;
        }
        return (int) e;
    }

    public static long m11204e(InputStream inputStream, OutputStream outputStream) throws IOException {
        return m11202b(inputStream, outputStream, new byte[4096]);
    }

    public static long m11202b(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
    }
}
