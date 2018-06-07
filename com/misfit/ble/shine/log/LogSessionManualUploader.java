package com.misfit.ble.shine.log;

import com.misfit.ble.shine.log.LogSessionUploader.ResultCode;
import com.misfit.ble.util.LogUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LogSessionManualUploader extends LogSessionUploader {
    private static final String TAG = LogUtils.m15475b(LogSessionManualUploader.class);
    private LogSessionUploadingCallback ku;

    public interface LogSessionUploadingCallback {
        void onLogSessionSaved(String str);

        void onLogSessionUploaded(String str, ResultCode resultCode);
    }

    public LogSessionManualUploader(LogSessionUploadingCallback logSessionUploadingCallback) throws IllegalArgumentException {
        if (logSessionUploadingCallback == null) {
            throw new IllegalArgumentException("Callback must not be null");
        }
        this.ku = logSessionUploadingCallback;
    }

    protected boolean shouldSaveSessions() {
        return true;
    }

    protected void mo4934E(String str) {
        if (this.ku == null) {
            LogUtils.m15479l(TAG, "Log Session Uploading Callback is null!");
        } else {
            this.ku.onLogSessionSaved(str);
        }
    }

    protected void mo4935a(File file, ResultCode resultCode) {
        if (this.ku == null) {
            LogUtils.m15479l(TAG, "Log Session Uploading Callback is null!");
        } else {
            this.ku.onLogSessionUploaded(file.getName(), resultCode);
        }
    }

    public void pushLogSession(String str) {
        bM().m15453w(str);
    }

    public List<String> getSavedSessionFileNames() {
        List<String> arrayList = new ArrayList();
        for (File file : bM().bC()) {
            if (file.isFile()) {
                arrayList.add(file.getName());
            }
        }
        return arrayList;
    }
}
