package com.portfolio.platform.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.provider.Telephony.Sms;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.fossil.cfj;
import com.fossil.cmq;
import com.fossil.cne;
import com.fossil.cnq;
import com.fossil.cok;
import com.fossil.cru;
import com.fossil.crv;
import com.fossil.crw;
import com.fossil.dre;
import com.fossil.wearables.fsl.fitness.FitnessProvider;
import com.fossil.wearables.fsl.fitness.SampleRaw;
import com.google.common.primitives.Ints;
import com.misfit.ble.setting.MSLSetting;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.db.DataLogService;
import com.misfit.frameworks.buttonservice.db.DataLogServiceProvider;
import com.misfit.frameworks.buttonservice.log.MFOtaLog;
import com.misfit.frameworks.buttonservice.log.MFSetupLog;
import com.misfit.frameworks.buttonservice.log.MFSyncLog;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.manager.MFNetwork;
import com.misfit.frameworks.network.manager.MFNetwork.MFServerResultCallback;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.DeviceModel;
import com.portfolio.platform.response.logService.FQBaseLogService;
import com.portfolio.platform.response.logService.FQLogServiceOTASession;
import com.portfolio.platform.response.logService.FQLogServiceSetupDeviceSession;
import com.portfolio.platform.response.logService.FQLogServiceSyncSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class UploadLogServiceIntentService extends IntentService {
    public static volatile long cDJ = 0;

    static /* synthetic */ class C49254 {
        static final /* synthetic */ int[] f1641xe21851be = new int[CommunicateMode.values().length];

        static {
            try {
                f1641xe21851be[CommunicateMode.SYNC.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1641xe21851be[CommunicateMode.LINK.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1641xe21851be[CommunicateMode.OTA.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public UploadLogServiceIntentService() {
        super("UploadLogServiceIntentService");
    }

    public static void bE(Context context) {
        Intent intent = new Intent(context, UploadLogServiceIntentService.class);
        intent.setAction("com.fossil.wearables.fossil.service.action.upload.log.service.fail.request");
        context.startService(intent);
    }

    public static void m15685a(Context context, int i, String str, int i2, CommunicateMode communicateMode) {
        Intent intent = new Intent(context, UploadLogServiceIntentService.class);
        intent.setAction("com.fossil.wearables.fossil.service.action.upload.log.service");
        intent.putExtra("log_id", i);
        intent.putExtra("log_serial", str);
        intent.putExtra("log_result_code", i2);
        intent.putExtra("log_communicate", communicateMode.getValue());
        context.startService(intent);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onHandleIntent(android.content.Intent r6) {
        /*
        r5 = this;
        r1 = 0;
        r2 = -1;
        if (r6 == 0) goto L_0x000e;
    L_0x0004:
        r0 = r6.getAction();
        r3 = android.text.TextUtils.isEmpty(r0);
        if (r3 == 0) goto L_0x000f;
    L_0x000e:
        return;
    L_0x000f:
        r3 = r0.hashCode();
        switch(r3) {
            case -1859611575: goto L_0x004f;
            case -1389916730: goto L_0x0045;
            case 36629796: goto L_0x003b;
            default: goto L_0x0016;
        };
    L_0x0016:
        r0 = r2;
    L_0x0017:
        switch(r0) {
            case 0: goto L_0x001b;
            case 1: goto L_0x0059;
            case 2: goto L_0x0075;
            default: goto L_0x001a;
        };
    L_0x001a:
        goto L_0x000e;
    L_0x001b:
        r0 = "log_id";
        r0 = r6.getIntExtra(r0, r1);
        r3 = "log_serial";
        r3 = r6.getStringExtra(r3);
        r4 = "log_result_code";
        r1 = r6.getIntExtra(r4, r1);
        r4 = "log_communicate";
        r2 = r6.getIntExtra(r4, r2);
        r2 = com.misfit.frameworks.buttonservice.communite.CommunicateMode.fromValue(r2);
        r5.m15684a(r0, r3, r1, r2);
        goto L_0x000e;
    L_0x003b:
        r3 = "com.fossil.wearables.fossil.service.action.upload.log.service";
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x0016;
    L_0x0043:
        r0 = r1;
        goto L_0x0017;
    L_0x0045:
        r3 = "com.fossil.wearables.fossil.service.action.upload.log.service.ended.log";
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x0016;
    L_0x004d:
        r0 = 1;
        goto L_0x0017;
    L_0x004f:
        r3 = "com.fossil.wearables.fossil.service.action.upload.log.service.fail.request";
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x0016;
    L_0x0057:
        r0 = 2;
        goto L_0x0017;
    L_0x0059:
        r0 = "log_serial";
        r0 = r6.getStringExtra(r0);
        r3 = "log_result_code";
        r1 = r6.getIntExtra(r3, r1);
        r3 = "log_communicate";
        r2 = r6.getIntExtra(r3, r2);
        r2 = com.misfit.frameworks.buttonservice.communite.CommunicateMode.fromValue(r2);
        r3 = "UPLOAD_ENDED_LOG";
        r5.m15688a(r0, r1, r2, r3);
        goto L_0x000e;
    L_0x0075:
        r0 = "";
        r1 = com.misfit.frameworks.buttonservice.communite.CommunicateMode.IDLE;
        r3 = "UPLOAD_PENDING_LOG";
        r5.m15688a(r0, r2, r1, r3);
        goto L_0x000e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.portfolio.platform.service.UploadLogServiceIntentService.onHandleIntent(android.content.Intent):void");
    }

    private void m15688a(String str, final int i, CommunicateMode communicateMode, final String str2) {
        MFLogger.d("UploadLogServiceIntentService", "pushEndedLogToServer - serial=" + str + ", resultCode=" + i + ", communicateMode=" + communicateMode + ", action=" + str2);
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (cDJ == 0 || cDJ + 3000 <= timeInMillis) {
            cDJ = timeInMillis;
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this) {
                final /* synthetic */ UploadLogServiceIntentService cDK;

                class C49191 implements Runnable {
                    final /* synthetic */ C49201 cDL;

                    C49191(C49201 c49201) {
                        this.cDL = c49201;
                    }

                    /* JADX WARNING: inconsistent code. */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void run() {
                        /*
                        r13 = this;
                        r12 = 2;
                        r2 = 0;
                        r3 = 1;
                        r0 = java.util.Calendar.getInstance();
                        r4 = r0.getTimeInMillis();
                        r0 = "UploadLogServiceIntentService";
                        r1 = new java.lang.StringBuilder;
                        r1.<init>();
                        r6 = "pushEndedLogToServer - currentTime=";
                        r1 = r1.append(r6);
                        r1 = r1.append(r4);
                        r1 = r1.toString();
                        com.misfit.frameworks.common.log.MFLogger.d(r0, r1);
                        r0 = com.portfolio.platform.PortfolioApp.ZQ();
                        r6 = com.misfit.frameworks.buttonservice.db.DataLogServiceProvider.getInstance(r0);
                        r0 = r6.getAllDataLogServiceByStatus(r2);
                        if (r0 == 0) goto L_0x00c5;
                    L_0x0031:
                        r1 = r0.size();
                        if (r1 <= 0) goto L_0x00c5;
                    L_0x0037:
                        r1 = "UploadLogServiceIntentService";
                        r7 = new java.lang.StringBuilder;
                        r7.<init>();
                        r8 = "pushEndedLogToServer - currentTime=";
                        r7 = r7.append(r8);
                        r7 = r7.append(r4);
                        r8 = ", dataLogServices=";
                        r7 = r7.append(r8);
                        r8 = r0.size();
                        r7 = r7.append(r8);
                        r7 = r7.toString();
                        com.misfit.frameworks.common.log.MFLogger.d(r1, r7);
                        r7 = r0.iterator();
                        r1 = r2;
                    L_0x0062:
                        r0 = r7.hasNext();
                        if (r0 == 0) goto L_0x00c6;
                    L_0x0068:
                        r0 = r7.next();
                        r0 = (com.misfit.frameworks.buttonservice.db.DataLogService) r0;
                        r8 = r0.getId();
                        if (r8 <= 0) goto L_0x0082;
                    L_0x0074:
                        r9 = r0.getContent();
                        r9 = r9.getBytes();
                        r9 = r9.length;
                        r10 = 819200; // 0xc8000 float:1.147944E-39 double:4.047386E-318;
                        if (r9 <= r10) goto L_0x0086;
                    L_0x0082:
                        r6.removeById(r8);
                        goto L_0x0062;
                    L_0x0086:
                        r9 = r0.getLogStyle();
                        switch(r9) {
                            case 0: goto L_0x0090;
                            case 1: goto L_0x00b5;
                            case 2: goto L_0x00a5;
                            case 3: goto L_0x0095;
                            default: goto L_0x008d;
                        };
                    L_0x008d:
                        r0 = r1;
                    L_0x008e:
                        r1 = r0;
                        goto L_0x0062;
                    L_0x0090:
                        r6.removeById(r8);
                        r0 = r1;
                        goto L_0x008e;
                    L_0x0095:
                        r8 = r13.cDL;
                        r8 = r8.cDK;
                        r9 = r13.cDL;
                        r9 = r8;
                        r0 = r8.m15691b(r6, r0, r9);
                        if (r0 == 0) goto L_0x008d;
                    L_0x00a3:
                        r0 = r3;
                        goto L_0x008e;
                    L_0x00a5:
                        r8 = r13.cDL;
                        r8 = r8.cDK;
                        r9 = r13.cDL;
                        r9 = r8;
                        r0 = r8.m15689a(r6, r0, r9);
                        if (r0 == 0) goto L_0x008d;
                    L_0x00b3:
                        r0 = r3;
                        goto L_0x008e;
                    L_0x00b5:
                        r8 = r13.cDL;
                        r8 = r8.cDK;
                        r9 = r13.cDL;
                        r9 = r8;
                        r0 = r8.m15693c(r6, r0, r9);
                        if (r0 == 0) goto L_0x008d;
                    L_0x00c3:
                        r0 = r3;
                        goto L_0x008e;
                    L_0x00c5:
                        r1 = r2;
                    L_0x00c6:
                        r0 = r6.getAllDataLogServiceByStatus(r3);
                        if (r0 == 0) goto L_0x00f9;
                    L_0x00cc:
                        r7 = r0.size();
                        if (r7 <= 0) goto L_0x00f9;
                    L_0x00d2:
                        r7 = r0.iterator();
                    L_0x00d6:
                        r0 = r7.hasNext();
                        if (r0 == 0) goto L_0x00f9;
                    L_0x00dc:
                        r0 = r7.next();
                        r0 = (com.misfit.frameworks.buttonservice.db.DataLogService) r0;
                        r8 = r0.getUpdateAt();
                        r10 = 3600000; // 0x36ee80 float:5.044674E-39 double:1.7786363E-317;
                        r8 = r8 + r10;
                        r8 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1));
                        if (r8 >= 0) goto L_0x00d6;
                    L_0x00ee:
                        r0.setUpdateAt(r4);
                        r0.setStatus(r12);
                        r6.createOrUpdate(r0);
                        r1 = r3;
                        goto L_0x00d6;
                    L_0x00f9:
                        r0 = "UploadLogServiceIntentService";
                        r6 = new java.lang.StringBuilder;
                        r6.<init>();
                        r7 = "pushEndedLogToServer - currentTime=";
                        r6 = r6.append(r7);
                        r4 = r6.append(r4);
                        r5 = ", isNeedUploadPin=";
                        r4 = r4.append(r5);
                        r1 = r4.append(r1);
                        r1 = r1.toString();
                        com.misfit.frameworks.common.log.MFLogger.d(r0, r1);
                        r0 = r13.cDL;
                        r0 = r0.cDK;
                        r1 = r13.cDL;
                        r1 = r10;
                        r0.m15697s(r12, r1);
                        r0 = r13.cDL;
                        r0 = r0.cDK;
                        r1 = r13.cDL;
                        r1 = r10;
                        r0.m15697s(r3, r1);
                        r0 = r13.cDL;
                        r0 = r0.cDK;
                        r1 = r13.cDL;
                        r1 = r10;
                        r0.m15697s(r2, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.portfolio.platform.service.UploadLogServiceIntentService.1.1.run():void");
                    }
                }

                public void run() {
                    PortfolioApp.ZQ().aam().YW().YR().execute(new C49191(this));
                }
            }, 1500);
        }
    }

    private void m15684a(final int i, String str, final int i2, final CommunicateMode communicateMode) {
        MFLogger.d("UploadLogServiceIntentService", "endLogFinishedAndPushLogToServer - logId=" + i + ", serial=" + str + ", resultCode=" + i2 + ", communicateMode=" + communicateMode);
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (cDJ == 0 || cDJ + 3000 <= timeInMillis) {
            cDJ = timeInMillis;
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this) {
                final /* synthetic */ UploadLogServiceIntentService cDK;

                class C49211 implements Runnable {
                    final /* synthetic */ C49222 cDO;

                    C49211(C49222 c49222) {
                        this.cDO = c49222;
                    }

                    public void run() {
                        MFLogger.d("UploadLogServiceIntentService", "endLogFinishedAndPushLogToServer - logId=" + i + ", currentTimeMillis=" + System.currentTimeMillis());
                        DataLogServiceProvider instance = DataLogServiceProvider.getInstance(PortfolioApp.ZQ());
                        DataLogService dataLogServiceById = instance.getDataLogServiceById(i);
                        if (dataLogServiceById != null) {
                            switch (C49254.f1641xe21851be[communicateMode.ordinal()]) {
                                case 1:
                                    if (this.cDO.cDK.m15693c(instance, dataLogServiceById, i2)) {
                                        this.cDO.cDK.m15697s(1, "UPLOAD_LOG");
                                        return;
                                    }
                                    return;
                                case 2:
                                    if (this.cDO.cDK.m15689a(instance, dataLogServiceById, i2)) {
                                        this.cDO.cDK.m15697s(0, "UPLOAD_LOG");
                                        return;
                                    }
                                    return;
                                case 3:
                                    if (this.cDO.cDK.m15691b(instance, dataLogServiceById, i2)) {
                                        this.cDO.cDK.m15697s(2, "UPLOAD_LOG");
                                        return;
                                    }
                                    return;
                                default:
                                    return;
                            }
                        }
                    }
                }

                public void run() {
                    PortfolioApp.ZQ().aam().YW().YR().execute(new C49211(this));
                }
            }, 1500);
        }
    }

    private synchronized void m15697s(int i, String str) {
        MFLogger.d("UploadLogServiceIntentService", "uploadData - logStyle=" + i + ", action=" + str);
        DataLogServiceProvider instance = DataLogServiceProvider.getInstance(PortfolioApp.ZQ());
        String str2 = "\n[And] -- Action=" + str + ", uploadTime=" + Calendar.getInstance().getTimeInMillis();
        List<DataLogService> allDataLogServiceByStatusAndLogStyle;
        FQBaseLogService fQBaseLogService;
        switch (i) {
            case 0:
                allDataLogServiceByStatusAndLogStyle = instance.getAllDataLogServiceByStatusAndLogStyle(2, 2);
                if (allDataLogServiceByStatusAndLogStyle != null && !allDataLogServiceByStatusAndLogStyle.isEmpty()) {
                    for (DataLogService dataLogService : allDataLogServiceByStatusAndLogStyle) {
                        if (dataLogService != null) {
                            try {
                                fQBaseLogService = (FQLogServiceSetupDeviceSession) new cfj().c(dataLogService.getContent(), FQLogServiceSetupDeviceSession.class);
                                if (!(fQBaseLogService == null || TextUtils.isEmpty(fQBaseLogService.getDebugLog()))) {
                                    dataLogService.setStatus(1);
                                    dataLogService.setUpdateAt(Calendar.getInstance().getTimeInMillis());
                                    instance.createOrUpdate(dataLogService);
                                    m15686a(fQBaseLogService, dataLogService, str2);
                                }
                            } catch (Exception e) {
                                MFLogger.e("UploadLogServiceIntentService", "uploadData - LOG_SERVICE_SETUP_DEVICE - e=" + e);
                            }
                        }
                    }
                    break;
                }
                MFLogger.d("UploadLogServiceIntentService", "uploadData - merged data log is empty");
                break;
                break;
            case 1:
                allDataLogServiceByStatusAndLogStyle = instance.getAllDataLogServiceByStatusAndLogStyle(2, 1);
                if (allDataLogServiceByStatusAndLogStyle != null && !allDataLogServiceByStatusAndLogStyle.isEmpty()) {
                    for (DataLogService dataLogService2 : allDataLogServiceByStatusAndLogStyle) {
                        if (dataLogService2 != null) {
                            try {
                                fQBaseLogService = (FQLogServiceSyncSession) new cfj().c(dataLogService2.getContent(), FQLogServiceSyncSession.class);
                                if (!(fQBaseLogService == null || TextUtils.isEmpty(fQBaseLogService.getDebugLog()))) {
                                    dataLogService2.setStatus(1);
                                    dataLogService2.setUpdateAt(Calendar.getInstance().getTimeInMillis());
                                    instance.createOrUpdate(dataLogService2);
                                    m15686a(fQBaseLogService, dataLogService2, str2);
                                }
                            } catch (Exception e2) {
                                MFLogger.e("UploadLogServiceIntentService", "uploadData - LOG_SERVICE_SYNC - e=" + e2);
                            }
                        }
                    }
                    break;
                }
                MFLogger.d("UploadLogServiceIntentService", "uploadData - merged data log is empty");
                break;
                break;
            case 2:
                allDataLogServiceByStatusAndLogStyle = instance.getAllDataLogServiceByStatusAndLogStyle(2, 3);
                if (allDataLogServiceByStatusAndLogStyle != null && !allDataLogServiceByStatusAndLogStyle.isEmpty()) {
                    for (DataLogService dataLogService22 : allDataLogServiceByStatusAndLogStyle) {
                        if (dataLogService22 != null) {
                            try {
                                fQBaseLogService = (FQLogServiceOTASession) new cfj().c(dataLogService22.getContent(), FQLogServiceOTASession.class);
                                if (!(fQBaseLogService == null || TextUtils.isEmpty(fQBaseLogService.getDebugLog()))) {
                                    dataLogService22.setStatus(1);
                                    dataLogService22.setUpdateAt(Calendar.getInstance().getTimeInMillis());
                                    instance.createOrUpdate(dataLogService22);
                                    m15686a(fQBaseLogService, dataLogService22, str2);
                                }
                            } catch (Exception e22) {
                                MFLogger.e("UploadLogServiceIntentService", "uploadData - LOG_SERVICE_OTA - e=" + e22);
                            }
                        }
                    }
                    break;
                }
                MFLogger.d("UploadLogServiceIntentService", "uploadData - merged data log is empty");
                break;
                break;
        }
    }

    private void m15686a(final FQBaseLogService fQBaseLogService, final DataLogService dataLogService, final String str) {
        new Handler(getMainLooper()).post(new Runnable(this) {
            final /* synthetic */ UploadLogServiceIntentService cDK;

            class C49231 implements MFServerResultCallback {
                final /* synthetic */ C49243 cDS;

                C49231(C49243 c49243) {
                    this.cDS = c49243;
                }

                public void onSuccess(MFResponse mFResponse) {
                    MFLogger.d("UploadLogServiceIntentService", "startUploadLogSessionRequest - SUCCESS - code=" + mFResponse.getHttpReturnCode());
                    DataLogServiceProvider.getInstance(PortfolioApp.ZQ()).removeById(dataLogService.getId());
                }

                public void onFail(int i, MFResponse mFResponse) {
                    MFLogger.e("UploadLogServiceIntentService", "startUploadLogSessionRequest - FAILED - code=" + i + ", response=" + mFResponse);
                    if (mFResponse.getHttpReturnCode() == 413) {
                        DataLogServiceProvider.getInstance(PortfolioApp.ZQ()).removeById(dataLogService.getId());
                        return;
                    }
                    dataLogService.setStatus(2);
                    DataLogServiceProvider.getInstance(PortfolioApp.ZQ()).createOrUpdate(dataLogService);
                }
            }

            public void run() {
                MFBaseRequest mFBaseRequest = null;
                fQBaseLogService.setDebugLog(fQBaseLogService.getDebugLog() + str + ", currentTime=" + Calendar.getInstance().getTimeInMillis());
                if (fQBaseLogService instanceof FQLogServiceSetupDeviceSession) {
                    MFLogger.d("UploadLogServiceIntentService", "startUploadLogSessionRequest - setupDeviceLogSession=" + fQBaseLogService);
                    mFBaseRequest = new crv(PortfolioApp.ZQ(), (FQLogServiceSetupDeviceSession) fQBaseLogService);
                } else if (fQBaseLogService instanceof FQLogServiceSyncSession) {
                    MFLogger.d("UploadLogServiceIntentService", "startUploadLogSessionRequest - syncLogSession=" + fQBaseLogService);
                    mFBaseRequest = new crw(PortfolioApp.ZQ(), (FQLogServiceSyncSession) fQBaseLogService);
                } else if (fQBaseLogService instanceof FQLogServiceOTASession) {
                    MFLogger.d("UploadLogServiceIntentService", "startUploadLogSessionRequest - otaLogSession=" + fQBaseLogService);
                    mFBaseRequest = new cru(PortfolioApp.ZQ(), (FQLogServiceOTASession) fQBaseLogService);
                }
                if (mFBaseRequest == null) {
                    MFLogger.d("UploadLogServiceIntentService", "startUploadLogSessionRequest - request == null");
                    DataLogServiceProvider.getInstance(PortfolioApp.ZQ()).removeById(dataLogService.getId());
                    return;
                }
                try {
                    MFNetwork.getInstance(PortfolioApp.ZQ()).execute(mFBaseRequest, new C49231(this));
                } catch (Exception e) {
                    MFLogger.e("UploadLogServiceIntentService", "startUploadLogSessionRequest - e=" + e);
                }
            }
        });
    }

    private List<Integer> m15695e(List<Integer> list, int i) {
        MFLogger.d("UploadLogServiceIntentService", ".upgradeErrorCodes - errorCodes=" + list + ", resultCode=" + i);
        int size = list == null ? 0 : list.size();
        if (size == 0) {
            list = new ArrayList();
            list.add(Integer.valueOf(i));
        } else if (size > 0 && ((Integer) list.get(size - 1)).intValue() != i) {
            list.add(Integer.valueOf(i));
        }
        list.removeAll(Collections.singleton(null));
        return list;
    }

    private FQLogServiceSetupDeviceSession m15682a(MFSetupLog mFSetupLog) {
        return new FQLogServiceSetupDeviceSession(mFSetupLog.getStartTimeEpoch(), mFSetupLog.getEndTimeEpoch(), mFSetupLog.getResultCode() == 0 ? 1 : 0, mFSetupLog.getButtonCount(), mFSetupLog.getResultCode(), mFSetupLog.getSerial(), mFSetupLog.getFirmwareVersion(), mFSetupLog.getDetailLog(), Ints.m14489i(mFSetupLog.getErrorCodes()), mFSetupLog.getOsVersion(), mFSetupLog.getSdkVersion(), mFSetupLog.getAppVersion());
    }

    private FQLogServiceOTASession m15681a(MFOtaLog mFOtaLog) {
        return new FQLogServiceOTASession(mFOtaLog.getSerial(), mFOtaLog.getStartTimeEpoch(), mFOtaLog.getEndTimeEpoch(), mFOtaLog.getResultCode() == 0 ? 1 : 0, mFOtaLog.getDetailLog(), mFOtaLog.getOldFirmware(), mFOtaLog.getNewFirmware(), (float) ((int) mFOtaLog.getProgress()), mFOtaLog.getBatteryLevel(), mFOtaLog.getRetries(), Ints.m14489i(mFOtaLog.getErrorCodes()), mFOtaLog.getOsVersion(), mFOtaLog.getSdkVersion(), mFOtaLog.getAppVersion());
    }

    private FQLogServiceSyncSession m15683a(MFSyncLog mFSyncLog) {
        String firmwareVersion = mFSyncLog.getFirmwareVersion();
        cok acp = cnq.acd().acp();
        if (TextUtils.isEmpty(firmwareVersion) && acp != null) {
            DeviceModel hd = acp.hd(mFSyncLog.getSerial());
            if (hd != null) {
                firmwareVersion = hd.getFirmwareRevision();
            }
        }
        return new FQLogServiceSyncSession(mFSyncLog.getSerial(), mFSyncLog.getStartTimeEpoch(), mFSyncLog.getEndTimeEpoch(), firmwareVersion, mFSyncLog.getDetailLog(), mFSyncLog.getActivityPoint(), mFSyncLog.getPostSyncActivityPoint(), mFSyncLog.getTimezone(), mFSyncLog.getPostSyncTimezone(), mFSyncLog.getGoal(), mFSyncLog.getPostSyncGoal(), mFSyncLog.getBattery(), mFSyncLog.getResultCode(), mFSyncLog.getRetries(), mFSyncLog.getSyncMode(), mFSyncLog.getActivityTaggingState(), mFSyncLog.getWatchTimestamp(), mFSyncLog.getPhoneTimestamp(), mFSyncLog.getRealTimeStep(), mFSyncLog.getTodaySumMinuteDataStep(), Ints.m14489i(mFSyncLog.getErrorCodes()), mFSyncLog.getOsVersion(), mFSyncLog.getSdkVersion(), mFSyncLog.getAppVersion(), MSLSetting.getMSLVersion(), (long) m15696r(Calendar.getInstance().getTime()));
    }

    private boolean m15689a(DataLogServiceProvider dataLogServiceProvider, DataLogService dataLogService, int i) {
        MFSetupLog mFSetupLog = (MFSetupLog) new cfj().c(dataLogService.getContent(), MFSetupLog.class);
        if (mFSetupLog == null || TextUtils.isEmpty(mFSetupLog.getDetailLog())) {
            dataLogServiceProvider.removeById(dataLogService.getId());
            return false;
        } else if (mFSetupLog.getEndTime() <= 0) {
            return false;
        } else {
            if (i != -1) {
                mFSetupLog.setResultCode(i);
            }
            int resultCode = mFSetupLog.getResultCode();
            mFSetupLog.setDetailLog(mFSetupLog.getDetailLog() + "End setup log session. Result code: " + resultCode);
            mFSetupLog.setErrorCodes(m15695e(mFSetupLog.getErrorCodes(), resultCode));
            dataLogService.setUpdateAt(Calendar.getInstance().getTimeInMillis());
            dataLogService.setContent(new cfj().toJson(m15682a(mFSetupLog)));
            dataLogService.setStatus(2);
            dataLogServiceProvider.createOrUpdate(dataLogService);
            return true;
        }
    }

    private boolean m15691b(DataLogServiceProvider dataLogServiceProvider, DataLogService dataLogService, int i) {
        MFOtaLog mFOtaLog = (MFOtaLog) new cfj().c(dataLogService.getContent(), MFOtaLog.class);
        if (mFOtaLog == null || TextUtils.isEmpty(mFOtaLog.getDetailLog())) {
            dataLogServiceProvider.removeById(dataLogService.getId());
            return false;
        } else if (mFOtaLog.getEndTime() <= 0) {
            return false;
        } else {
            if (i != -1) {
                mFOtaLog.setResultCode(i);
            }
            int resultCode = mFOtaLog.getResultCode();
            mFOtaLog.setDetailLog(mFOtaLog.getDetailLog() + "End ota log session. Result code: " + resultCode);
            mFOtaLog.setErrorCodes(m15695e(mFOtaLog.getErrorCodes(), resultCode));
            dataLogService.setUpdateAt(Calendar.getInstance().getTimeInMillis());
            dataLogService.setContent(new cfj().toJson(m15681a(mFOtaLog)));
            dataLogService.setStatus(2);
            dataLogServiceProvider.createOrUpdate(dataLogService);
            return true;
        }
    }

    private boolean m15693c(DataLogServiceProvider dataLogServiceProvider, DataLogService dataLogService, int i) {
        MFSyncLog mFSyncLog = (MFSyncLog) new cfj().c(dataLogService.getContent(), MFSyncLog.class);
        if (mFSyncLog == null || TextUtils.isEmpty(mFSyncLog.getDetailLog())) {
            dataLogServiceProvider.removeById(dataLogService.getId());
            return false;
        } else if (mFSyncLog.getEndTime() <= 0) {
            return false;
        } else {
            if (i != -1) {
                mFSyncLog.setResultCode(i);
            }
            int resultCode = mFSyncLog.getResultCode();
            mFSyncLog.setDetailLog(mFSyncLog.getDetailLog() + "End sync log session. Result code: " + resultCode);
            mFSyncLog.setErrorCodes(m15695e(mFSyncLog.getErrorCodes(), resultCode));
            mFSyncLog.setDetailLog(mFSyncLog.getDetailLog() + "\n-----Basic Info------");
            mFSyncLog.setDetailLog(mFSyncLog.getDetailLog() + "\n[0] -- PermissionGranted: " + Arrays.toString(dre.dff.auP()));
            TelephonyManager telephonyManager = (TelephonyManager) PortfolioApp.ZQ().getSystemService("phone");
            mFSyncLog.setDetailLog(mFSyncLog.getDetailLog() + "\n[0] -- Carrier: " + (telephonyManager != null ? telephonyManager.getNetworkOperatorName() : "NULL!!!"));
            mFSyncLog.setDetailLog(mFSyncLog.getDetailLog() + "\n[0] -- Default SMS app: " + Sms.getDefaultSmsPackage(PortfolioApp.ZQ()));
            if (VERSION.SDK_INT >= 23) {
                PowerManager powerManager = (PowerManager) PortfolioApp.ZQ().getSystemService("power");
                mFSyncLog.setDetailLog(mFSyncLog.getDetailLog() + "\n[0] -- IsAppInWhiteListDoze: " + (powerManager != null ? Boolean.valueOf(powerManager.isIgnoringBatteryOptimizations(PortfolioApp.ZQ().getPackageName())) : "NULL!!!"));
            }
            DataLogService dataLogServiceById = dataLogServiceProvider.getDataLogServiceById(999);
            if (dataLogServiceById != null) {
                mFSyncLog.setDetailLog(mFSyncLog.getDetailLog() + "\n" + dataLogServiceById.getContent());
                dataLogServiceProvider.removeById(999);
            }
            dataLogService.setUpdateAt(Calendar.getInstance().getTimeInMillis());
            dataLogService.setContent(new cfj().toJson(m15683a(mFSyncLog)));
            dataLogService.setStatus(2);
            dataLogServiceProvider.createOrUpdate(dataLogService);
            return true;
        }
    }

    public static int m15696r(Date date) {
        int i = 0;
        MFLogger.d("UploadLogServiceIntentService", "getStepsBySampeRaw - date=" + date);
        if (cne.getStartOfDay(date).before(PortfolioApp.ZQ().aac())) {
            MFLogger.d("UploadLogServiceIntentService", "getStepsBySampeRaw - date=" + date + " is before user signing up date, return null.");
        } else {
            FitnessProvider acr = cnq.acd().acr();
            Calendar instance = Calendar.getInstance();
            instance.setTime(date);
            Calendar b = cmq.b(instance);
            List<SampleRaw> rawSamples = acr.getRawSamples(b.getTime(), cmq.c((Calendar) b.clone()).getTime());
            if (rawSamples != null) {
                for (SampleRaw sampleRaw : rawSamples) {
                    int steps;
                    if (sampleRaw != null) {
                        steps = (int) (sampleRaw.getSteps() + ((double) i));
                    } else {
                        steps = i;
                    }
                    i = steps;
                }
            }
        }
        return i;
    }
}
