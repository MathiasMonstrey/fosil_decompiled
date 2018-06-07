package com.misfit.ble.shine.log;

import android.text.TextUtils;
import com.misfit.ble.shine.log.LogSessionUploader.ResultCode;
import com.misfit.ble.util.LogUtils;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class LogSessionAutomaticUploader extends LogSessionUploader {
    private static final String TAG = LogUtils.m15475b(LogSessionAutomaticUploader.class);
    private final Object ko = new Object();
    private volatile boolean kp;
    private volatile boolean kq;
    private File[] kr;
    private int ks = 0;
    private Set<String> kt = new HashSet();

    protected boolean shouldSaveSessions() {
        return true;
    }

    protected void mo4934E(String str) {
        bJ();
    }

    protected void mo4935a(File file, ResultCode resultCode) {
        synchronized (this.ko) {
            if (resultCode == ResultCode.SUCCEEDED) {
                m15458d(false);
            } else if (resultCode == ResultCode.NETWORK_ERROR) {
                this.kq = true;
                m15458d(true);
            } else if (resultCode == ResultCode.INVALID_SESSION_ERROR || resultCode == ResultCode.UNEXPECTED_ERROR) {
                this.kt.add(bM().m15454y(file.getName()));
                this.kq = true;
                m15458d(false);
            }
        }
    }

    private void bJ() {
        synchronized (this.ko) {
            if (this.kp) {
                return;
            }
            this.kr = bM().bC();
            if (this.kr == null || this.kr.length <= 0) {
                LogUtils.m15478k(TAG, "Invalid log session files");
                return;
            }
            this.kp = true;
            this.kq = false;
            this.ks = this.kr.length;
            bL();
        }
    }

    private void bK() {
        synchronized (this.ko) {
            if (this.kp) {
                this.ks = 0;
                this.kt.clear();
                this.kp = false;
                return;
            }
        }
    }

    private void bL() {
        synchronized (this.ko) {
            File file = this.kr[this.kr.length - this.ks];
            CharSequence y = bM().m15454y(file.getName());
            if (TextUtils.isEmpty(y) || this.kt.contains(y)) {
                this.kq = true;
                m15458d(false);
                return;
            }
            bM().m15451b(file);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m15458d(boolean r3) {
        /*
        r2 = this;
        r1 = r2.ko;
        monitor-enter(r1);
        r0 = r2.ks;	 Catch:{ all -> 0x0020 }
        r0 = r0 + -1;
        r2.ks = r0;	 Catch:{ all -> 0x0020 }
        if (r3 == 0) goto L_0x0010;
    L_0x000b:
        r2.bK();	 Catch:{ all -> 0x0020 }
        monitor-exit(r1);	 Catch:{ all -> 0x0020 }
    L_0x000f:
        return;
    L_0x0010:
        r0 = r2.ks;	 Catch:{ all -> 0x0020 }
        if (r0 > 0) goto L_0x0023;
    L_0x0014:
        r2.bK();	 Catch:{ all -> 0x0020 }
        r0 = r2.kq;	 Catch:{ all -> 0x0020 }
        if (r0 != 0) goto L_0x001e;
    L_0x001b:
        r2.bJ();	 Catch:{ all -> 0x0020 }
    L_0x001e:
        monitor-exit(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x000f;
    L_0x0020:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0020 }
        throw r0;
    L_0x0023:
        r2.bL();	 Catch:{ all -> 0x0020 }
        monitor-exit(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x000f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.misfit.ble.shine.log.LogSessionAutomaticUploader.d(boolean):void");
    }
}
