package com.fossil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import retrofit.mime.MultipartTypedOutput;

public class eut extends euq {
    private final String charset;
    private final File file;
    private final String filename;

    public eut(File file, String str, String str2, String str3) {
        super(str2);
        if (file == null) {
            throw new IllegalArgumentException("File may not be null");
        }
        this.file = file;
        if (str != null) {
            this.filename = str;
        } else {
            this.filename = file.getName();
        }
        this.charset = str3;
    }

    public eut(File file, String str, String str2) {
        this(file, null, str, str2);
    }

    public eut(File file, String str) {
        this(file, str, null);
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        InputStream fileInputStream = new FileInputStream(this.file);
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                outputStream.write(bArr, 0, read);
            }
            outputStream.flush();
        } finally {
            fileInputStream.close();
        }
    }

    public String getTransferEncoding() {
        return MultipartTypedOutput.DEFAULT_TRANSFER_ENCODING;
    }

    public String aHU() {
        return this.charset;
    }

    public long getContentLength() {
        return this.file.length();
    }

    public String aHT() {
        return this.filename;
    }
}
