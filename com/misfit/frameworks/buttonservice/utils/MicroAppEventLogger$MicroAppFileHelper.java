package com.misfit.frameworks.buttonservice.utils;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

class MicroAppEventLogger$MicroAppFileHelper {
    private static final String FILE_NAME_PATTERN = "log_%s_%s.txt";
    private static final long FILE_SIZE = 102400;
    private static final String LOG_PATTERN = "%s|%s|%s|%s|%s\n";
    private static final int MAX_FILE_NUMBER = 3;
    private final String TAG = MicroAppEventLogger$MicroAppFileHelper.class.getSimpleName();
    private String directoryPath;
    private String logName;

    MicroAppEventLogger$MicroAppFileHelper(Context context, String str) {
        this.directoryPath = context.getFilesDir().toString();
        this.logName = str;
    }

    public void log(String str, String str2, String str3, String str4) {
        writeLog(String.format(Locale.US, LOG_PATTERN, new Object[]{Long.valueOf(Calendar.getInstance().getTimeInMillis()), str, str2, str3, str4}));
    }

    private synchronized void writeLog(String str) {
        File file = new File(getFilePath(String.format(FILE_NAME_PATTERN, new Object[]{this.logName, Integer.valueOf(0)})));
        try {
            if (!file.exists()) {
                Log.d(this.TAG, "Inside writeLog - Creating file...");
                file.createNewFile();
            } else if (file.length() >= FILE_SIZE) {
                Log.d(this.TAG, "Inside writeLog - Rotating files...");
                rotateFiles();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            fileOutputStream.write(str.getBytes());
            fileOutputStream.close();
        } catch (Exception e) {
            Log.e(this.TAG, "Error inside writeLog - e=" + e + ", fileName=" + file.getAbsolutePath());
        }
    }

    private synchronized void rotateFiles() throws Exception {
        Log.d(this.TAG, "Inside rotateFiles - Start rotating files...");
        for (int i = 2; i >= 0; i--) {
            File file = new File(getFilePath(String.format(FILE_NAME_PATTERN, new Object[]{this.logName, Integer.valueOf(i)})));
            if (file.exists()) {
                FileChannel channel = new RandomAccessFile(file, "rw").getChannel();
                FileLock lock = channel.lock();
                Log.d(this.TAG, "Inside rotateFiles - Locking " + file.getName());
                if (i >= 2) {
                    Log.d(this.TAG, "Inside rotateFiles - Deleting " + String.format(FILE_NAME_PATTERN, new Object[]{this.logName, Integer.valueOf(i)}));
                    file.delete();
                } else {
                    Log.d(this.TAG, "Inside rotateFiles - Renaming " + String.format(FILE_NAME_PATTERN, new Object[]{this.logName, Integer.valueOf(i)}) + " to " + String.format(FILE_NAME_PATTERN, new Object[]{this.logName, Integer.valueOf(i + 1)}));
                    file.renameTo(new File(getFilePath(String.format(FILE_NAME_PATTERN, new Object[]{this.logName, Integer.valueOf(i + 1)}))));
                }
                Log.d(this.TAG, "Inside rotateFiles - Unlocking " + file.getName());
                lock.release();
                channel.close();
            }
        }
        Log.d(this.TAG, "Inside rotateFiles - Creating new " + getFilePath(String.format(FILE_NAME_PATTERN, new Object[]{this.logName, Integer.valueOf(0)})));
        new File(getFilePath(String.format(FILE_NAME_PATTERN, new Object[]{this.logName, Integer.valueOf(0)}))).createNewFile();
        Log.d(this.TAG, "Inside rotateFiles - End Rotating files");
    }

    private String getFilePath(String str) {
        return this.directoryPath + str;
    }

    private List<File> exportLogs() {
        List<File> arrayList = new ArrayList();
        for (int i = 0; i < 3; i++) {
            File file = new File(getFilePath(String.format(FILE_NAME_PATTERN, new Object[]{this.logName, Integer.valueOf(i)})));
            if (file.exists()) {
                arrayList.add(file);
            }
        }
        return arrayList;
    }

    private void resetLogFiles() {
        for (int i = 2; i >= 0; i--) {
            File file = new File(getFilePath(String.format(FILE_NAME_PATTERN, new Object[]{this.logName, Integer.valueOf(i)})));
            if (file.exists()) {
                file.delete();
            }
        }
    }
}
