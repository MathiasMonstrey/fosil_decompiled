package com.fossil;

import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class dua {
    public static String kd(String str) {
        String str2 = "";
        str2 = "";
        if (dub.getPackageName() != null) {
            str2 = new StringBuilder(String.valueOf(duk.kn(dub.getPackageName()))).append("/").toString();
        }
        return axM() + "/sina/weibo/.applogs/" + str2 + str + ".txt";
    }

    private static String axM() {
        File externalStorageDirectory;
        if (Environment.getExternalStorageState().equals("mounted")) {
            externalStorageDirectory = Environment.getExternalStorageDirectory();
        } else {
            externalStorageDirectory = null;
        }
        if (externalStorageDirectory != null) {
            return externalStorageDirectory.toString();
        }
        return null;
    }

    public static synchronized void m9757b(String str, String str2, boolean z) {
        FileWriter fileWriter;
        Throwable th;
        synchronized (dua.class) {
            if (!TextUtils.isEmpty(str)) {
                duj.m9771i("WBAgent", "filePath:" + str);
                if (!(str2 == null || str2.length() == 0)) {
                    StringBuilder stringBuilder = new StringBuilder(str2);
                    if (stringBuilder.charAt(0) == '[') {
                        stringBuilder.replace(0, 1, "");
                    }
                    if (stringBuilder.charAt(stringBuilder.length() - 1) != ',') {
                        stringBuilder.replace(stringBuilder.length() - 1, stringBuilder.length(), ",");
                    }
                    File file = new File(str);
                    FileWriter fileWriter2 = null;
                    try {
                        File parentFile = file.getParentFile();
                        if (!parentFile.exists()) {
                            parentFile.mkdirs();
                        }
                        if (!file.exists()) {
                            file.createNewFile();
                        } else if (file.lastModified() > 0 && System.currentTimeMillis() - file.lastModified() > 86400000) {
                            z = false;
                        }
                        fileWriter = new FileWriter(file, z);
                        try {
                            fileWriter.write(stringBuilder.toString());
                            fileWriter.flush();
                            if (fileWriter != null) {
                                try {
                                    fileWriter.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        } catch (IOException e2) {
                            fileWriter2 = fileWriter;
                            if (fileWriter2 != null) {
                                try {
                                    fileWriter2.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (fileWriter != null) {
                                try {
                                    fileWriter.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e5) {
                        if (fileWriter2 != null) {
                            fileWriter2.close();
                        }
                    } catch (Throwable th3) {
                        Throwable th4 = th3;
                        fileWriter = null;
                        th = th4;
                        if (fileWriter != null) {
                            fileWriter.close();
                        }
                        throw th;
                    }
                }
            }
        }
    }
}
