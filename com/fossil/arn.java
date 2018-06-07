package com.fossil;

import android.os.AsyncTask;
import com.misfit.frameworks.common.log.MFLogger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class arn {
    private static final String TAG = ("CloudImage_" + arn.class.getSimpleName());
    private String bdm;
    private String bdn;
    private C1862a bdv;

    interface C1862a {
        void mo1136E(String str, String str2);

        void mo1137F(String str, String str2);
    }

    class C1865b extends AsyncTask<Void, Void, Boolean> {
        private String bdm;
        private String bdn;
        final /* synthetic */ arn bdw;

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m4311b((Void[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m4310a((Boolean) obj);
        }

        C1865b(arn com_fossil_arn, String str, String str2) {
            this.bdw = com_fossil_arn;
            this.bdm = str;
            this.bdn = str2;
        }

        protected Boolean m4311b(Void... voidArr) {
            byte[] bArr = new byte[2048];
            try {
                if (!new File(this.bdm).exists()) {
                    return Boolean.valueOf(false);
                }
                this.bdw.cJ(this.bdn);
                InputStream fileInputStream = new FileInputStream(this.bdm);
                ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);
                while (true) {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry != null) {
                        MFLogger.m12673v(arn.TAG, "Unzipping " + nextEntry.getName());
                        FileOutputStream fileOutputStream = new FileOutputStream(this.bdn + "/" + nextEntry.getName());
                        while (true) {
                            int read = zipInputStream.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        zipInputStream.closeEntry();
                        fileOutputStream.close();
                    } else {
                        zipInputStream.close();
                        fileInputStream.close();
                        MFLogger.m12670d(arn.TAG, "Unzipping completed, path = " + this.bdn);
                        return Boolean.valueOf(true);
                    }
                }
            } catch (Exception e) {
                MFLogger.m12671e(arn.TAG, "Unzipping failed, ex = " + e);
                return Boolean.valueOf(false);
            }
        }

        protected void m4310a(Boolean bool) {
            super.onPostExecute(bool);
            if (this.bdw.bdv == null) {
                return;
            }
            if (bool.booleanValue()) {
                this.bdw.bdv.mo1136E(this.bdm, this.bdn);
            } else {
                this.bdw.bdv.mo1137F(this.bdm, this.bdn);
            }
        }
    }

    public static arn Jv() {
        return new arn();
    }

    public void m4315a(C1862a c1862a) {
        this.bdv = c1862a;
    }

    public void m4314G(String str, String str2) {
        this.bdm = str;
        this.bdn = str2;
    }

    public void execute() {
        MFLogger.m12670d(TAG, "execute() called with destinationUnzipPath = [" + this.bdn + "]");
        new C1865b(this, this.bdm, this.bdn).execute(new Void[0]);
    }

    private void cJ(String str) {
        File file = new File(str);
        if (!file.isDirectory()) {
            file.mkdirs();
        }
    }
}
