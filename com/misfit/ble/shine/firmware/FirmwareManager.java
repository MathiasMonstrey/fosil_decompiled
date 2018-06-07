package com.misfit.ble.shine.firmware;

import android.support.v8.renderscript.Allocation;
import android.text.TextUtils;
import com.misfit.ble.obfuscated.bv;
import com.misfit.ble.obfuscated.bv.C4503a;
import com.misfit.ble.obfuscated.bv.C4504b;
import com.misfit.ble.obfuscated.bw;
import com.misfit.ble.util.LogUtils;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class FirmwareManager {
    private static final String TAG = LogUtils.m15475b(FirmwareManager.class);
    private static final Executor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(jC, jD, 1, TimeUnit.SECONDS, jF, jE);
    private static final int jB = Runtime.getRuntime().availableProcessors();
    private static final int jC = (jB + 1);
    private static final int jD = ((jB * 2) + 1);
    private static final ThreadFactory jE = new C46321();
    private static final BlockingQueue<Runnable> jF = new LinkedBlockingQueue(Allocation.USAGE_SHARED);
    private static FirmwareManager jG;

    static class C46321 implements ThreadFactory {
        private final AtomicInteger jH = new AtomicInteger(1);

        C46321() {
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "FirmwareManager #" + this.jH.getAndIncrement());
        }
    }

    public interface DownloadFirmwareCallback {
        void onFailure(FirmwareAPIErrorCode firmwareAPIErrorCode);

        void onSuccess(Firmware firmware);
    }

    public interface LoadFirmwareCallback {
        void onResult(Firmware firmware);
    }

    public interface LoadFirmwaresCallback {
        void onResult(List<Firmware> list);
    }

    public interface VerifyFirmwareCallback {
        void onFailure(FirmwareAPIErrorCode firmwareAPIErrorCode);

        void onSuccess();
    }

    private static void m15425a(Firmware firmware, DownloadFirmwareCallback downloadFirmwareCallback) {
        LogUtils.m15476d(TAG, String.format("downloadBinaryForFirmware(%s)", new Object[]{firmware}));
        if (firmware.getFirmwareData() != null) {
            LogUtils.m15478k(TAG, String.format("Firmware data for %s existed", new Object[]{firmware.getFirmwareVersion()}));
            downloadFirmwareCallback.onSuccess(firmware);
            return;
        }
        C4503a s = bv.bv().m14971s(firmware.jn);
        if (s.ju == null) {
            LogUtils.m15477e(TAG, String.format("Error when download firmware: %s", new Object[]{s.jt}));
            downloadFirmwareCallback.onFailure(s.jt);
        } else if (firmware.m15424h(s.ju)) {
            LogUtils.m15478k(TAG, "Firmware downloaded");
            downloadFirmwareCallback.onSuccess(firmware);
        } else {
            LogUtils.m15479l(TAG, "wrong checksum");
            downloadFirmwareCallback.onFailure(FirmwareAPIErrorCode.WRONG_CHECKSUM);
        }
    }

    private static void m15426a(String str, DownloadFirmwareCallback downloadFirmwareCallback) {
        LogUtils.m15476d(TAG, String.format("downloadFirmwareWithVersionImp(%s)", new Object[]{str}));
        C4504b r = bv.bv().m14970r(str);
        if (r.jw != null) {
            Firmware b = bw.m14975b(r.jw);
            if (b == null) {
                LogUtils.m15479l(TAG, String.format("Cannot create firmware instance for %s", new Object[]{str}));
                downloadFirmwareCallback.onFailure(FirmwareAPIErrorCode.INVALID_FIRMWARE);
                return;
            } else if (bw.m14976b(b)) {
                LogUtils.m15478k(TAG, "Firmware archived");
                downloadFirmwareCallback.onSuccess(b);
                return;
            } else {
                LogUtils.m15479l(TAG, String.format("Cannot archive firmware with version %s", new Object[]{str}));
                downloadFirmwareCallback.onFailure(FirmwareAPIErrorCode.ARCHIVE_ERROR);
                return;
            }
        }
        LogUtils.m15479l(TAG, String.format("Metadata for %s is null", new Object[]{str}));
        downloadFirmwareCallback.onFailure(r.jt);
    }

    public static synchronized FirmwareManager getDefaultManager() {
        FirmwareManager firmwareManager;
        synchronized (FirmwareManager.class) {
            if (jG == null) {
                jG = new FirmwareManager();
            }
            firmwareManager = jG;
        }
        return firmwareManager;
    }

    private FirmwareManager() {
    }

    public void downloadLatestFirmware(final String str, final DownloadFirmwareCallback downloadFirmwareCallback) {
        if (TextUtils.isEmpty(str) || downloadFirmwareCallback == null) {
            throw new IllegalArgumentException();
        }
        THREAD_POOL_EXECUTOR.execute(new Runnable(this) {
            final /* synthetic */ FirmwareManager jK;

            public void run() {
                C4504b q = bv.bv().m14969q(str);
                if (q.jw != null) {
                    Firmware b = bw.m14975b(q.jw);
                    if (b == null) {
                        downloadFirmwareCallback.onFailure(FirmwareAPIErrorCode.INVALID_FIRMWARE);
                        return;
                    } else if (bw.m14976b(b)) {
                        FirmwareManager.m15425a(b, downloadFirmwareCallback);
                        return;
                    } else {
                        downloadFirmwareCallback.onFailure(FirmwareAPIErrorCode.ARCHIVE_ERROR);
                        return;
                    }
                }
                downloadFirmwareCallback.onFailure(q.jt);
            }
        });
    }

    public void downloadFirmware(final String str, final DownloadFirmwareCallback downloadFirmwareCallback) {
        THREAD_POOL_EXECUTOR.execute(new Runnable(this) {
            final /* synthetic */ FirmwareManager jK;

            class C46341 implements DownloadFirmwareCallback {
                final /* synthetic */ C46353 jM;

                C46341(C46353 c46353) {
                    this.jM = c46353;
                }

                public void onSuccess(Firmware firmware) {
                    FirmwareManager.m15425a(firmware, downloadFirmwareCallback);
                }

                public void onFailure(FirmwareAPIErrorCode firmwareAPIErrorCode) {
                    downloadFirmwareCallback.onFailure(firmwareAPIErrorCode);
                }
            }

            public void run() {
                FirmwareManager.m15426a(str, new C46341(this));
            }
        });
    }

    public void verify(final String str, final VerifyFirmwareCallback verifyFirmwareCallback) {
        THREAD_POOL_EXECUTOR.execute(new Runnable(this) {
            final /* synthetic */ FirmwareManager jK;

            class C46361 implements DownloadFirmwareCallback {
                final /* synthetic */ C46374 jO;

                C46361(C46374 c46374) {
                    this.jO = c46374;
                }

                public void onSuccess(Firmware firmware) {
                    verifyFirmwareCallback.onSuccess();
                }

                public void onFailure(FirmwareAPIErrorCode firmwareAPIErrorCode) {
                    verifyFirmwareCallback.onFailure(firmwareAPIErrorCode);
                }
            }

            public void run() {
                FirmwareManager.m15426a(str, new C46361(this));
            }
        });
    }

    public void loadLocalFirmware(final String str, final LoadFirmwareCallback loadFirmwareCallback) {
        THREAD_POOL_EXECUTOR.execute(new Runnable(this) {
            final /* synthetic */ FirmwareManager jK;

            public void run() {
                Firmware t = bw.m14977t(str);
                if (t == null || t.getFirmwareData() == null) {
                    t = null;
                }
                loadFirmwareCallback.onResult(t);
            }
        });
    }

    public void loadLocalFirmwares(final LoadFirmwaresCallback loadFirmwaresCallback) {
        THREAD_POOL_EXECUTOR.execute(new Runnable(this) {
            final /* synthetic */ FirmwareManager jK;

            public void run() {
                loadFirmwaresCallback.onResult(bw.bw());
            }
        });
    }
}
