package com.portfolio.platform.downloader;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.fossil.clx.l;
import com.fossil.cms;
import com.fossil.cnq;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class FileDownloader extends AsyncTask<String, Void, Boolean> {
    private static final String TAG = FileDownloader.class.getSimpleName();
    private String checksum;
    private String cww;
    protected DownloadEvent cwx;
    protected C4893a cwy;
    private String downloadUrl;

    public enum DownloadEvent {
        FIRMWARE
    }

    public interface C4893a {
        void bP(boolean z);
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m15618c((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m15617a((Boolean) obj);
    }

    public FileDownloader(String str, String str2, String str3, DownloadEvent downloadEvent) {
        this.downloadUrl = str;
        this.checksum = str2;
        this.cww = str3;
        this.cwx = downloadEvent;
    }

    public void m15616a(C4893a c4893a) {
        this.cwy = c4893a;
    }

    protected Boolean m15618c(String... strArr) {
        if (!TextUtils.isEmpty(this.downloadUrl)) {
            try {
                String str = PortfolioApp.ZQ().getFilesDir() + "/" + this.cww;
                File file = new File(str);
                if (file.exists()) {
                    if (cms.B(str, this.checksum)) {
                        return Boolean.valueOf(true);
                    }
                    file.delete();
                }
                URLConnection openConnection = new URL(this.downloadUrl).openConnection();
                openConnection.connect();
                long contentLength = (long) openConnection.getContentLength();
                MFLogger.d(TAG, "Inside " + TAG + ".FileDownloader.doInBackground - Downloading " + str + ", size=" + contentLength);
                InputStream bufferedInputStream = new BufferedInputStream(openConnection.getInputStream());
                OutputStream fileOutputStream = new FileOutputStream(str);
                byte[] bArr = new byte[1024];
                long j = 0;
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    j += (long) read;
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.flush();
                fileOutputStream.close();
                bufferedInputStream.close();
                if (TextUtils.isEmpty(this.checksum)) {
                    MFLogger.e(TAG, "Download complete with risk cause by empty checknull");
                    if (file.exists()) {
                        file.delete();
                    }
                    return Boolean.valueOf(false);
                }
                boolean B = cms.B(str, this.checksum);
                if (B) {
                    return Boolean.valueOf(true);
                }
                MFLogger.e(TAG, "Inconsistent checksum, retry download?");
                if (file.exists()) {
                    file.delete();
                }
                MFLogger.d(TAG, "len=" + contentLength + ", read=" + j + ", valid=" + B);
            } catch (Exception e) {
                MFLogger.e(TAG, "Error inside " + TAG + ".onHandleIntent - e=" + e);
                cnq.acd().acf().removeDataVersion("firmwares");
            }
        }
        return Boolean.valueOf(false);
    }

    protected void m15617a(Boolean bool) {
        super.onPostExecute(bool);
        if (this.cwy != null) {
            this.cwy.bP(bool.booleanValue());
        }
        MFLogger.d(TAG, "Download complete, success = " + bool + ", event = " + this.cwx);
        PortfolioApp.cL(new l(bool.booleanValue(), this.cwx));
    }
}
