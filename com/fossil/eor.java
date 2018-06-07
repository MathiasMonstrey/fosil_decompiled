package com.fossil;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class eor implements eol {
    private final File aKc;
    private final Context context;
    private final File dPh;
    private final String dPi;
    private enn dPj = new enn(this.aKc);
    private File dPk;

    public eor(Context context, File file, String str, String str2) throws IOException {
        this.context = context;
        this.dPh = file;
        this.dPi = str2;
        this.aKc = new File(this.dPh, str);
        aGc();
    }

    private void aGc() {
        this.dPk = new File(this.dPh, this.dPi);
        if (!this.dPk.exists()) {
            this.dPk.mkdirs();
        }
    }

    public void av(byte[] bArr) throws IOException {
        this.dPj.av(bArr);
    }

    public int aFY() {
        return this.dPj.aFC();
    }

    public void mt(String str) throws IOException {
        this.dPj.close();
        m10985d(this.aKc, new File(this.dPk, str));
        this.dPj = new enn(this.aKc);
    }

    private void m10985d(File file, File file2) throws IOException {
        Throwable th;
        Closeable closeable = null;
        Closeable fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                closeable = mo2988C(file2);
                CommonUtils.a(fileInputStream, closeable, new byte[1024]);
                CommonUtils.a(fileInputStream, "Failed to close file input stream");
                CommonUtils.a(closeable, "Failed to close output stream");
                file.delete();
            } catch (Throwable th2) {
                th = th2;
                CommonUtils.a(fileInputStream, "Failed to close file input stream");
                CommonUtils.a(closeable, "Failed to close output stream");
                file.delete();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            CommonUtils.a(fileInputStream, "Failed to close file input stream");
            CommonUtils.a(closeable, "Failed to close output stream");
            file.delete();
            throw th;
        }
    }

    public OutputStream mo2988C(File file) throws IOException {
        return new FileOutputStream(file);
    }

    public List<File> pj(int i) {
        List<File> arrayList = new ArrayList();
        for (Object add : this.dPk.listFiles()) {
            arrayList.add(add);
            if (arrayList.size() >= i) {
                break;
            }
        }
        return arrayList;
    }

    public void aH(List<File> list) {
        for (File file : list) {
            CommonUtils.Z(this.context, String.format("deleting sent analytics file %s", new Object[]{file.getName()}));
            file.delete();
        }
    }

    public List<File> aGa() {
        return Arrays.asList(this.dPk.listFiles());
    }

    public void aGb() {
        try {
            this.dPj.close();
        } catch (IOException e) {
        }
        this.aKc.delete();
    }

    public boolean aFZ() {
        return this.dPj.isEmpty();
    }

    public boolean cs(int i, int i2) {
        return this.dPj.cq(i, i2);
    }
}
