package com.fossil;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.fossil.cloudimagelib.AssetsDeviceResponse;
import com.misfit.frameworks.common.log.MFLogger;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class ark {
    private static final String TAG = ("CloudImage_" + ark.class.getSimpleName());
    private String bdm;
    private String bdn;
    private AssetsDeviceResponse bdo;
    private C1860b bdp;

    interface C1860b {
        void mo1135D(String str, String str2);

        void mo1139b(String str, String str2, AssetsDeviceResponse assetsDeviceResponse);
    }

    class C1863a extends AsyncTask<Void, Void, Boolean> {
        private String bdm;
        private String bdn;
        private AssetsDeviceResponse bdq;
        final /* synthetic */ ark bdr;

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m4297b((Void[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m4296a((Boolean) obj);
        }

        C1863a(ark com_fossil_ark, String str, String str2, AssetsDeviceResponse assetsDeviceResponse) {
            this.bdr = com_fossil_ark;
            this.bdm = str;
            this.bdn = str2;
            this.bdq = assetsDeviceResponse;
        }

        protected Boolean m4297b(Void... voidArr) {
            if (TextUtils.isEmpty(this.bdq.getDownloadUrl())) {
                MFLogger.m12671e(ark.TAG, "Download file failed for serialNumber = [" + this.bdq.getSerialNumber() + "], feature = [" + this.bdq.getFeature() + "], downloadUrl = [" + this.bdq.getDownloadUrl() + "]");
                return Boolean.valueOf(false);
            }
            try {
                URLConnection openConnection = new URL(this.bdq.getDownloadUrl()).openConnection();
                openConnection.connect();
                InputStream bufferedInputStream = new BufferedInputStream(openConnection.getInputStream());
                OutputStream fileOutputStream = new FileOutputStream(this.bdm);
                byte[] bArr = new byte[1024];
                long j = 0;
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    } else if (isCancelled()) {
                        bufferedInputStream.close();
                        return Boolean.valueOf(false);
                    } else {
                        j += (long) read;
                        fileOutputStream.write(bArr, 0, read);
                    }
                }
                fileOutputStream.flush();
                fileOutputStream.close();
                bufferedInputStream.close();
                if (TextUtils.isEmpty(this.bdq.getChecksum())) {
                    MFLogger.m12671e(ark.TAG, "Download assets completed for serialNumber = [" + this.bdq.getSerialNumber() + "], feature = [" + this.bdq.getFeature() + "] with risk cause by empty checksum.");
                    return Boolean.valueOf(true);
                } else if (arg.m4277B(this.bdm, this.bdq.getChecksum())) {
                    return Boolean.valueOf(true);
                } else {
                    MFLogger.m12671e(ark.TAG, "Inconsistent checksum, retry download?");
                    return Boolean.valueOf(true);
                }
            } catch (Exception e) {
                MFLogger.m12671e(ark.TAG, "Download file failed for serialNumber = [" + this.bdq.getSerialNumber() + "], feature = [" + this.bdq.getFeature() + "], ex = " + e);
                return Boolean.valueOf(false);
            }
        }

        protected void m4296a(Boolean bool) {
            super.onPostExecute(bool);
            if (this.bdr.bdp == null) {
                return;
            }
            if (bool.booleanValue()) {
                this.bdr.bdp.mo1135D(this.bdm, this.bdn);
            } else {
                this.bdr.bdp.mo1139b(this.bdm, this.bdn, this.bdq);
            }
        }
    }

    public static ark Jr() {
        return new ark();
    }

    public void m4299a(C1860b c1860b) {
        this.bdp = c1860b;
    }

    public void m4300c(String str, String str2, AssetsDeviceResponse assetsDeviceResponse) {
        this.bdm = str;
        this.bdn = str2;
        this.bdo = assetsDeviceResponse;
    }

    public void execute() {
        MFLogger.m12670d(TAG, "execute() called with serialNumber = [" + this.bdo.getSerialNumber() + "], feature = [" + this.bdo.getFeature() + "]");
        new C1863a(this, this.bdm, this.bdn, this.bdo).execute(new Void[0]);
    }
}
