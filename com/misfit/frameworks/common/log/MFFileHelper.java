package com.misfit.frameworks.common.log;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

class MFFileHelper {
    private static final String FILE_NAME_PATTERN = "log_%s.txt";
    private static final int FILE_SIZE = 3145728;
    private static final String LOG_PATTERN = "%s %s: %s\n";
    private static final int MAX_FILE_NUMBER = 3;
    private static final String TAG = MFFileHelper.class.getSimpleName();
    private static String directoryPath;
    private static boolean isInitialized;
    private static SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss.SSS", Locale.US);

    MFFileHelper() {
    }

    public static void init(Context context) {
        directoryPath = context.getFilesDir().toString();
        isInitialized = true;
    }

    public static void m15614e(Context context, String str, String str2) {
        writeLog(context, String.format(Locale.US, LOG_PATTERN, new Object[]{sdf.format(new Date()), str + " /E", str2}));
    }

    public static void m15613d(Context context, String str, String str2) {
        writeLog(context, String.format(Locale.US, LOG_PATTERN, new Object[]{sdf.format(new Date()), str + " /D", str2}));
    }

    public static void m15615i(Context context, String str, String str2) {
        writeLog(context, String.format(Locale.US, LOG_PATTERN, new Object[]{sdf.format(new Date()), str + " /I", str2}));
    }

    private static synchronized void writeLog(Context context, String str) {
        synchronized (MFFileHelper.class) {
            if (isInitialized) {
                File file = new File(getFilePath(String.format(FILE_NAME_PATTERN, new Object[]{Integer.valueOf(0)})));
                try {
                    if (!file.exists()) {
                        Log.d(TAG, "Inside writeLog - Creating file...");
                        file.createNewFile();
                    } else if (file.length() >= 3145728) {
                        Log.d(TAG, "Inside writeLog - Rotating files...");
                        rotateFiles();
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file, true);
                    fileOutputStream.write(str.getBytes());
                    fileOutputStream.close();
                } catch (Exception e) {
                    Log.e(TAG, "Error inside writeLog - e=" + e + ", fileName=" + file.getAbsolutePath());
                }
            } else {
                Log.e(TAG, TAG + " is not initialized");
            }
        }
    }

    private static synchronized void rotateFiles() throws Exception {
        synchronized (MFFileHelper.class) {
            Log.d(TAG, "Inside rotateFiles - Start rotating files...");
            for (int i = 2; i >= 0; i--) {
                File file = new File(getFilePath(String.format(FILE_NAME_PATTERN, new Object[]{Integer.valueOf(i)})));
                if (file.exists()) {
                    FileChannel channel = new RandomAccessFile(file, "rw").getChannel();
                    FileLock lock = channel.lock();
                    Log.d(TAG, "Inside rotateFiles - Locking " + file.getName());
                    if (i >= 2) {
                        Log.d(TAG, "Inside rotateFiles - Deleting " + String.format(FILE_NAME_PATTERN, new Object[]{Integer.valueOf(i)}));
                        file.delete();
                    } else {
                        Log.d(TAG, "Inside rotateFiles - Renaming " + String.format(FILE_NAME_PATTERN, new Object[]{Integer.valueOf(i)}) + " to " + String.format(FILE_NAME_PATTERN, new Object[]{Integer.valueOf(i + 1)}));
                        file.renameTo(new File(getFilePath(String.format(FILE_NAME_PATTERN, new Object[]{Integer.valueOf(i + 1)}))));
                    }
                    Log.d(TAG, "Inside rotateFiles - Unlocking " + file.getName());
                    lock.release();
                    channel.close();
                }
            }
            Log.d(TAG, "Inside rotateFiles - Creating new " + getFilePath(String.format(FILE_NAME_PATTERN, new Object[]{Integer.valueOf(0)})));
            new File(getFilePath(String.format(FILE_NAME_PATTERN, new Object[]{Integer.valueOf(0)}))).createNewFile();
            Log.d(TAG, "Inside rotateFiles - End Rotating files");
        }
    }

    private static String getFilePath(String str) {
        return directoryPath + str;
    }

    public static List<File> exportLogs() {
        List<File> arrayList = new ArrayList();
        for (int i = 0; i < 3; i++) {
            File file = new File(getFilePath(String.format(FILE_NAME_PATTERN, new Object[]{Integer.valueOf(i)})));
            if (file.exists()) {
                arrayList.add(file);
            }
        }
        return arrayList;
    }
}
