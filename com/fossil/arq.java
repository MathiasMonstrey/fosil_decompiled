package com.fossil;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import com.fossil.localization.LocalizationResponse;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.manager.MFNetwork;
import com.misfit.frameworks.network.manager.MFNetwork.MFServerResultCallback;
import com.misfit.frameworks.network.responses.MFResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class arq extends BroadcastReceiver {
    private static final String TAG = arq.class.getSimpleName();
    private String bdA;
    String bdB = "";
    SharedPreferences bdC;
    private ActivityLifecycleCallbacks bdD = new C18672(this);
    private Activity bdz;
    private Context mContext;

    class C18661 implements MFServerResultCallback {
        final /* synthetic */ arq bdE;

        C18661(arq com_fossil_arq) {
            this.bdE = com_fossil_arq;
        }

        public void onSuccess(MFResponse mFResponse) {
            Object obj = 1;
            LocalizationResponse localizationResponse = (LocalizationResponse) mFResponse;
            long j = this.bdE.bdC.getLong("localization_date", 0);
            long j2 = this.bdE.bdC.getLong("localization_update_date", 0);
            long time = ars.cN(localizationResponse.getUpdatedAt()).getTime();
            if (j2 > 0 ? j2 < time : j < time) {
                obj = null;
            }
            if (obj != null) {
                this.bdE.m4331a(localizationResponse);
            } else {
                MFLogger.m12670d(arq.TAG, "onSuccess: Language pack is the latest, no need to download!");
            }
        }

        public void onFail(int i, MFResponse mFResponse) {
            MFLogger.m12671e(arq.TAG, "onFail: i=" + i + ", response=" + mFResponse.toString());
        }
    }

    class C18672 implements ActivityLifecycleCallbacks {
        final /* synthetic */ arq bdE;

        C18672(arq com_fossil_arq) {
            this.bdE = com_fossil_arq;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            this.bdE.bdz = activity;
            if (activity.getClass().getSimpleName().equals(this.bdE.bdB)) {
                this.bdE.JA();
            }
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
            if (this.bdE.bdz == activity) {
                this.bdE.bdz = null;
            }
        }
    }

    public class C1868a extends AsyncTask<String, Void, Boolean> {
        final /* synthetic */ arq bdE;
        private LocalizationResponse bdF;
        private Context context;

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m4320c((String[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m4319a((Boolean) obj);
        }

        public C1868a(arq com_fossil_arq, Context context, LocalizationResponse localizationResponse) {
            this.bdE = com_fossil_arq;
            this.bdF = localizationResponse;
            this.context = context;
        }

        protected Boolean m4320c(String... strArr) {
            if (!TextUtils.isEmpty(this.bdF.getDownloadUrl())) {
                try {
                    String str = this.context.getFilesDir().getAbsolutePath() + "/" + "language.zip";
                    if (new File(str).exists() && arq.m4324B(str, this.bdF.getCheckSum())) {
                        return Boolean.valueOf(true);
                    }
                    URLConnection openConnection = new URL(this.bdF.getDownloadUrl()).openConnection();
                    openConnection.connect();
                    InputStream bufferedInputStream = new BufferedInputStream(openConnection.getInputStream());
                    OutputStream fileOutputStream = new FileOutputStream(str);
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
                    if (TextUtils.isEmpty(this.bdF.getCheckSum())) {
                        MFLogger.m12671e(arq.TAG, "Download complete with risk cause by empty checksum");
                        return Boolean.valueOf(true);
                    } else if (arq.m4324B(str, this.bdF.getCheckSum())) {
                        return Boolean.valueOf(true);
                    } else {
                        MFLogger.m12671e(arq.TAG, "Inconsistent checksum, retry download?");
                        return Boolean.valueOf(true);
                    }
                } catch (Exception e) {
                    MFLogger.m12671e(arq.TAG, "Error inside " + arq.TAG + ".onHandleIntent - e=" + e);
                }
            }
            return Boolean.valueOf(false);
        }

        protected void m4319a(Boolean bool) {
            super.onPostExecute(bool);
            if (bool.booleanValue()) {
                new C1870c().execute(new String[]{this.bdF.getUpdatedAt()});
            }
        }
    }

    public class C1869b extends AsyncTask<String, Void, Boolean> {
        final /* synthetic */ arq bdE;
        String bdG;
        boolean bdH;

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m4321c((String[]) objArr);
        }

        public C1869b(arq com_fossil_arq, String str, boolean z) {
            this.bdE = com_fossil_arq;
            this.bdG = str;
            this.bdH = z;
        }

        protected Boolean m4321c(String... strArr) {
            boolean z = true;
            try {
                if (arp.Jx().equals("en_US")) {
                    String str = this.bdE.JC() + "/strings.json";
                    aru.m4341i(this.bdG, this.bdH);
                    aru.m4341i(str, true);
                } else {
                    aru.m4341i(this.bdG, this.bdH);
                }
                aru.Jy();
            } catch (Exception e) {
                MFLogger.m12671e(arq.TAG, "load cache failed e=" + e);
                z = false;
            }
            return Boolean.valueOf(z);
        }
    }

    class C1870c extends AsyncTask<String, Void, Boolean> {
        final /* synthetic */ arq bdE;
        private String updateAt;

        private C1870c(arq com_fossil_arq) {
            this.bdE = com_fossil_arq;
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m4323c((String[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m4322a((Boolean) obj);
        }

        protected Boolean m4323c(String... strArr) {
            this.updateAt = strArr[0];
            return Boolean.valueOf(this.bdE.ae(this.bdE.mContext));
        }

        protected void m4322a(Boolean bool) {
            super.onPostExecute(bool);
            if (bool.booleanValue()) {
                this.bdE.m4338w(new File(this.bdE.mContext.getFilesDir() + ""));
                this.bdE.bdC.edit().putLong("localization_update_date", ars.cN(this.updateAt).getTime()).apply();
                this.bdE.m4337h(this.bdE.mContext.getFilesDir().getAbsolutePath() + "/" + this.bdE.JD(), true);
            }
        }
    }

    public arq(Application application, String str) {
        this.bdC = application.getSharedPreferences(application.getPackageName() + ".language", 0);
        this.bdA = str;
        if (!this.bdC.contains("localization_date")) {
            this.bdC.edit().putLong("localization_date", ars.cN("2016-10-16T10:07:09.000").getTime()).apply();
        }
        this.mContext = application;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.LOCALE_CHANGED")) {
            MFLogger.m12670d(TAG, "onReceive locale=" + arp.Jx());
            if (!(this.bdz == null || this.bdz.isFinishing())) {
                MFLogger.m12670d(TAG, "onReceive finish activity=" + this.bdz.getLocalClassName());
                this.bdz.setResult(0);
                this.bdz.finishAffinity();
            }
            Jy();
        }
    }

    public void Jy() {
        aru.setContext(this.mContext);
        aru.clearCache();
        if (this.bdC.contains("localization_update_date")) {
            String JB = JB();
            if (new File(JB).exists()) {
                m4337h(JB, true);
                return;
            } else {
                m4337h(JD(), false);
                return;
            }
        }
        m4337h(JD(), false);
    }

    private void m4337h(String str, boolean z) {
        new C1869b(this, str, z).execute(new String[0]);
    }

    public ActivityLifecycleCallbacks Jz() {
        return this.bdD;
    }

    private void JA() {
        MFLogger.m12670d(TAG, "checkLangVersionAndUpdateIfNeeded() called");
        MFNetwork.getInstance(this.mContext).execute(new arr(this.mContext, this.bdA, 0, 0, true), new C18661(this));
    }

    private void m4331a(LocalizationResponse localizationResponse) {
        new C1868a(this, this.mContext, localizationResponse).execute(new String[0]);
    }

    private void m4338w(File file) {
        if (file.exists() && file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                if (file2.isDirectory()) {
                    m4338w(file2);
                }
            }
        }
    }

    private static boolean m4324B(String str, String str2) {
        boolean z = false;
        if (str2 == null) {
            return true;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            InputStream fileInputStream = new FileInputStream(str);
            byte[] bArr = new byte[2014];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    String bytesToString = bytesToString(instance.digest());
                    fileInputStream.close();
                    return str2.toLowerCase().equals(bytesToString);
                } else if (read > 0) {
                    instance.update(bArr, 0, read);
                }
            }
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "Error inside " + TAG + ".verifyDownloadFile - e=" + e);
            return z;
        }
    }

    private static String bytesToString(byte[] bArr) {
        String str = "";
        for (byte b : bArr) {
            str = str + Integer.toString((b & 255) + 256, 16).substring(1);
        }
        return str.toLowerCase();
    }

    private boolean ae(Context context) {
        byte[] bArr = new byte[2048];
        try {
            String str = context.getFilesDir().getAbsolutePath() + "/";
            String str2 = context.getFilesDir().getAbsolutePath() + "/" + "language.zip";
            if (!new File(str2).exists()) {
                return false;
            }
            InputStream fileInputStream = new FileInputStream(str2);
            ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    zipInputStream.close();
                    fileInputStream.close();
                    return true;
                } else if (nextEntry.isDirectory()) {
                    m4339I(str, nextEntry.getName());
                } else {
                    FileOutputStream fileOutputStream = new FileOutputStream(str + nextEntry.getName());
                    while (true) {
                        int read = zipInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    zipInputStream.closeEntry();
                    fileOutputStream.close();
                }
            }
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "Unzipping failed ex=" + e);
            return false;
        }
    }

    public void m4339I(String str, String str2) {
        File file = new File(str + str2);
        if (!file.isDirectory()) {
            file.mkdirs();
        }
    }

    private String JB() {
        return this.mContext.getFilesDir().getAbsolutePath() + "/" + JD();
    }

    private String JC() {
        return this.mContext.getFilesDir().getAbsolutePath() + "/" + "language" + "/values";
    }

    private String JD() {
        String str;
        new String[1][0] = "";
        String str2 = "language/values";
        File file = new File(this.mContext.getFilesDir().getAbsolutePath() + "/" + "language");
        if (file.exists()) {
            String[] list = file.list();
            Locale locale = arp.getLocale();
            str = str2;
            for (int i = 0; i < list.length; i++) {
                if (list[i].contains(locale.getLanguage())) {
                    if (!str.contains(locale.getLanguage())) {
                        str = str + "-" + locale.getLanguage();
                    }
                    if (list[i].contains(locale.getCountry())) {
                        str = str + "-r" + locale.getCountry();
                        break;
                    }
                }
            }
        } else {
            str = str2;
        }
        return str + "/strings.json";
    }
}
