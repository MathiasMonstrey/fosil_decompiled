package com.fossil;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.fossil.wearables.fossil.R;
import com.misfit.ble.shine.log.LogManager;
import com.misfit.frameworks.buttonservice.utils.MicroAppEventLogger;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class csw {
    private static final String TAG = csw.class.getSimpleName();
    private static csw cDy;
    private String bKT;
    private int cDA = -1;
    private int cDB = -1;
    private WeakReference<Context> cDz;

    class C2283a extends AsyncTask<Bitmap, Void, Void> {
        final /* synthetic */ csw cDC;

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m7483a((Bitmap[]) objArr);
        }

        C2283a(csw com_fossil_csw) {
            this.cDC = com_fossil_csw;
        }

        protected Void m7483a(Bitmap... bitmapArr) {
            try {
                new File(this.cDC.bKT).mkdir();
                File file = new File(this.cDC.bKT, "screenshot.jpg");
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                OutputStream fileOutputStream = new FileOutputStream(file);
                bitmapArr[0].compress(CompressFormat.JPEG, 90, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
                MFLogger.m12671e(csw.TAG, ".ScreenShootTask - doInBackground ex=" + e.toString());
            }
            File file2 = new File(this.cDC.bKT, String.format("logCat_%s.txt", new Object[]{Long.valueOf(System.currentTimeMillis() / 1000)}));
            try {
                Runtime.getRuntime().exec("logcat -v time -d -f " + file2.getAbsolutePath());
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            List bu = cmp.bu((Context) this.cDC.cDz.get());
            String str = this.cDC.bKT + "screenshot.jpg";
            List arrayList = new ArrayList();
            arrayList.add(file2);
            Collection c = this.cDC.afn();
            Log.d(csw.TAG, "Number of app logs=" + c.size());
            arrayList.addAll(c);
            this.cDC.m7486a(str, bu, arrayList);
            return null;
        }
    }

    public static synchronized csw afk() {
        csw com_fossil_csw;
        synchronized (csw.class) {
            if (cDy == null) {
                cDy = new csw();
            }
            com_fossil_csw = cDy;
        }
        return com_fossil_csw;
    }

    private csw() {
        if (afm()) {
            this.bKT = Environment.getExternalStorageDirectory().toString();
        } else {
            this.bKT = PortfolioApp.ZQ().getApplicationContext().getFilesDir().toString();
        }
        this.bKT += "/com.fossil.wearables.fossil/";
    }

    public String afl() {
        return this.bKT;
    }

    public void bD(Context context) {
        View rootView = ((Activity) context).getWindow().getDecorView().getRootView();
        rootView.setDrawingCacheEnabled(true);
        Bitmap createBitmap = Bitmap.createBitmap(rootView.getDrawingCache());
        new C2283a(this).executeOnExecutor(Executors.newSingleThreadExecutor(), new Bitmap[]{createBitmap});
    }

    private boolean afm() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    private void m7486a(String str, List<String> list, List<File> list2) {
        File dir;
        Intent intent = new Intent("android.intent.action.SEND_MULTIPLE");
        intent.setType("vnd.android.cursor.dir/email");
        intent.putExtra("android.intent.extra.EMAIL", new String[]{"help@misfit.com"});
        ArrayList arrayList = new ArrayList();
        long j = 0;
        if (list.size() > 0) {
            dir = PortfolioApp.ZQ().getApplicationContext().getDir(LogManager.getRawLogFolderName(), 0);
        } else {
            dir = PortfolioApp.ZQ().getApplicationContext().getDir(LogManager.getRawLogFolderName(), 0);
        }
        if (dir != null) {
            File[] listFiles = dir.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                MFLogger.m12671e(TAG, ".sendFeedbackEmail - files.length=" + listFiles.length);
                try {
                    File file = new File(Environment.getExternalStorageDirectory(), "SDKLog.zip");
                    ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(file));
                    for (File file2 : listFiles) {
                        byte[] bArr = new byte[1024];
                        FileInputStream fileInputStream = new FileInputStream(file2);
                        zipOutputStream.putNextEntry(new ZipEntry(file2.getName()));
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            zipOutputStream.write(bArr, 0, read);
                        }
                        fileInputStream.close();
                    }
                    zipOutputStream.close();
                    arrayList.add(Uri.parse("file://" + file.getAbsolutePath()));
                    j = 0 + file.length();
                } catch (IOException e) {
                    MFLogger.m12671e(TAG, ".sendFeedbackEmail - read sdk log ex=" + e.toString());
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            Uri parse = Uri.parse("file://" + str);
            arrayList.add(parse);
            j += new File(parse.getPath()).length();
        }
        long j2 = j;
        for (File file3 : list2) {
            File file32;
            MFLogger.m12670d(TAG, "sendFeedbackEmail - logFile=" + file32.getName() + ", length=" + file32.length());
            j2 += file32.length();
            arrayList.add(Uri.parse("file://" + file32.getAbsolutePath()));
        }
        MFLogger.m12670d(TAG, ".sendFeedbackEmail - dataFeedbackSize=" + j2);
        if (j2 > 9437184) {
            file32 = m7489i(arrayList);
            arrayList.clear();
            arrayList.add(Uri.parse("file://" + file32.getAbsolutePath()));
        }
        intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
        if (afp() != -1) {
            switch (afp()) {
                case 0:
                    intent.putExtra("android.intent.extra.SUBJECT", "GATT CONNECTION");
                    break;
                case 1:
                    intent.putExtra("android.intent.extra.SUBJECT", "HID CONNECTION");
                    break;
            }
        } else if (afo() == 0) {
            intent.putExtra("android.intent.extra.SUBJECT", "[BETA - " + PortfolioApp.ZQ().aag().getName() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + "] - " + "[Android - Feedback]");
        } else {
            intent.putExtra("android.intent.extra.SUBJECT", "[" + PortfolioApp.ZQ().aag().getName() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + "] - " + "[Android Feedback] -" + String.format(" on %s (%s)", new Object[]{Long.valueOf(System.currentTimeMillis() / 1000), cmq.m7138p(new Date())}));
        }
        try {
            intent.putExtra("android.intent.extra.TEXT", "[" + PortfolioApp.ZQ().aag().getName() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + "" + "]\n" + cmk.abE().m7092d((Context) this.cDz.get(), afo(), afp()));
        } catch (Exception e2) {
            MFLogger.m12670d(TAG, ".sendFeedbackEmail - ex=" + e2.toString());
        }
        if (this.cDz != null && this.cDz.get() != null) {
            ((Context) this.cDz.get()).startActivity(Intent.createChooser(intent, ((Context) this.cDz.get()).getString(R.string.rate_app_send_email)));
        }
    }

    private List<File> afn() {
        List<File> arrayList = new ArrayList();
        List<File> arrayList2 = new ArrayList();
        arrayList2.addAll(MFLogger.exportLogFiles());
        arrayList2.addAll(MicroAppEventLogger.exportLogFiles());
        for (File file : arrayList2) {
            Log.d(TAG, "Exporting " + file.getName() + ", size=" + file.length());
            try {
                File file2 = new File(this.bKT, file.getName());
                if (file2.exists()) {
                    file2.delete();
                } else {
                    file2.createNewFile();
                }
                Object channel = new FileInputStream(file).getChannel();
                FileChannel channel2 = new FileOutputStream(file2).getChannel();
                channel2.transferFrom(channel, 0, channel.size());
                channel.close();
                channel2.close();
                Log.d(TAG, "Done exporting " + file2.getName() + ", size=" + file2.length());
                arrayList.add(file2);
            } catch (Exception e) {
                Log.e(TAG, "Error while exporting log files - e=" + e);
            }
        }
        return arrayList;
    }

    private File m7489i(ArrayList<Uri> arrayList) {
        File file = new File(Environment.getExternalStorageDirectory(), "DebugDataLog.zip");
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(file));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                byte[] bArr = new byte[1024];
                File file2 = new File(((Uri) it.next()).getPath());
                FileInputStream fileInputStream = new FileInputStream(file2);
                zipOutputStream.putNextEntry(new ZipEntry(file2.getName()));
                MFLogger.m12670d(TAG, "zipDataFile - Processing file=" + file2.getName() + ", length=" + file2.length());
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    zipOutputStream.write(bArr, 0, read);
                }
                fileInputStream.close();
            }
            zipOutputStream.close();
            arrayList.add(Uri.parse("file://" + file.getAbsolutePath()));
        } catch (IOException e) {
            MFLogger.m12671e(TAG, ".zipDataFile - ex=" + e.toString());
        }
        return file;
    }

    public int afo() {
        return this.cDA;
    }

    public int afp() {
        return this.cDB;
    }
}
