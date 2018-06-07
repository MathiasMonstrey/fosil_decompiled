package com.fossil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

class acr extends FileOutputStream {
    public static final FilenameFilter aIC = new C15671();
    private File aIA;
    private File aIB;
    private final String aIz;
    private boolean closed = false;

    static class C15671 implements FilenameFilter {
        C15671() {
        }

        public boolean accept(File file, String str) {
            return str.endsWith(".cls_temp");
        }
    }

    public acr(File file, String str) throws FileNotFoundException {
        super(new File(file, str + ".cls_temp"));
        this.aIz = file + File.separator + str;
        this.aIA = new File(this.aIz + ".cls_temp");
    }

    public synchronized void close() throws IOException {
        if (!this.closed) {
            this.closed = true;
            super.flush();
            super.close();
            File file = new File(this.aIz + ".cls");
            if (this.aIA.renameTo(file)) {
                this.aIA = null;
                this.aIB = file;
            } else {
                String str = "";
                if (file.exists()) {
                    str = " (target already exists)";
                } else if (!this.aIA.exists()) {
                    str = " (source does not exist)";
                }
                throw new IOException("Could not rename temp file: " + this.aIA + " -> " + file + str);
            }
        }
    }

    public void xB() throws IOException {
        if (!this.closed) {
            this.closed = true;
            super.flush();
            super.close();
        }
    }
}
