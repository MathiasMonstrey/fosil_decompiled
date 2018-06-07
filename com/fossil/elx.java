package com.fossil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class elx {
    public static void m10869a(CharSequence charSequence, OutputStream outputStream) throws IOException {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            bufferedWriter.write(charSequence.toString());
            bufferedWriter.flush();
            bufferedWriter.close();
        } finally {
            outputStream.close();
        }
    }

    public static String m10870v(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            char[] cArr = new char[1024];
            for (int read = bufferedReader.read(cArr); read > 0; read = bufferedReader.read(cArr)) {
                stringBuffer.append(cArr, 0, read);
            }
            return stringBuffer.toString();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                stringBuffer = e;
            }
        }
    }
}
