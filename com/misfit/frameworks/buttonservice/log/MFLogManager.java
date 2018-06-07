package com.misfit.frameworks.buttonservice.log;

import android.content.Context;
import android.text.TextUtils;
import com.fossil.cfj;
import com.misfit.frameworks.buttonservice.ButtonService;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.db.DataLogService;
import com.misfit.frameworks.buttonservice.db.DataLogServiceProvider;
import com.misfit.frameworks.buttonservice.utils.FossilDeviceSerialPatternUtil.BRAND;
import com.misfit.frameworks.common.log.MFLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class MFLogManager {
    public static final String TAG = MFLogManager.class.getSimpleName();
    private static MFLogManager sInstance;
    private HashMap<String, List<CommunicateMode>> activeLogs = new HashMap();
    private Context context;
    private HashMap<String, MFLog> pendingLogs = new LinkedHashMap();
    private HashMap<String, MFLog> pendingLogsToSaveDB = new LinkedHashMap();

    private MFLogManager() {
    }

    private synchronized void setActiveLog(String str, CommunicateMode communicateMode) {
        List list = (List) this.activeLogs.get(str);
        if (list == null) {
            list = new ArrayList();
        }
        list.add(communicateMode);
        this.activeLogs.put(str, list);
    }

    public static synchronized MFLogManager getInstance(Context context) {
        MFLogManager mFLogManager;
        synchronized (MFLogManager.class) {
            if (sInstance == null) {
                sInstance = new MFLogManager();
                sInstance.context = context.getApplicationContext();
            }
            mFLogManager = sInstance;
        }
        return mFLogManager;
    }

    public synchronized MFSyncLog startSyncLog(String str) {
        MFSyncLog mFSyncLog;
        end(CommunicateMode.SYNC, str);
        MFLogger.d(TAG, "startSyncLog - serial=" + str);
        mFSyncLog = new MFSyncLog(this.context);
        String generatePendingLogKey = generatePendingLogKey(CommunicateMode.SYNC, str);
        mFSyncLog.log("Start new sync session.");
        this.pendingLogs.put(generatePendingLogKey, mFSyncLog);
        setActiveLog(str, CommunicateMode.SYNC);
        return mFSyncLog;
    }

    public synchronized MFSetupLog startSetupLog(String str, BRAND brand) {
        MFSetupLog mFSetupLog;
        end(CommunicateMode.LINK, str);
        MFLogger.d(TAG, "startSetupLog - serial=" + str + ", brand=" + brand.toString());
        mFSetupLog = new MFSetupLog(this.context);
        String generatePendingLogKey = generatePendingLogKey(CommunicateMode.LINK, str);
        mFSetupLog.log("Start new setup session. Supported devices: " + Arrays.toString(ButtonService.getSupportedDevices(brand).toArray()));
        this.pendingLogs.put(generatePendingLogKey, mFSetupLog);
        setActiveLog(str, CommunicateMode.LINK);
        return mFSetupLog;
    }

    public synchronized MFOtaLog startOtaLog(String str) {
        MFOtaLog mFOtaLog;
        end(CommunicateMode.OTA, str);
        MFLogger.d(TAG, "startOtaLog - serial=" + str);
        mFOtaLog = new MFOtaLog(this.context);
        String generatePendingLogKey = generatePendingLogKey(CommunicateMode.OTA, str);
        mFOtaLog.log("Start new ota session.");
        this.pendingLogs.put(generatePendingLogKey, mFOtaLog);
        setActiveLog(str, CommunicateMode.OTA);
        return mFOtaLog;
    }

    public synchronized MFLog end(CommunicateMode communicateMode, String str) {
        MFLog log;
        log = getLog(communicateMode, str);
        MFLogger.d(TAG, ".end - log=" + log);
        if (log != null) {
            MFLogger.d(TAG, "end - serial=" + str + ", communicateMode=" + communicateMode + ", resultCode=" + log.getResultCode());
            log.setEndTime(System.currentTimeMillis());
            this.pendingLogsToSaveDB.put(generatePendingLogKey(communicateMode, str), log);
            saveLogToDB(communicateMode, str);
        }
        this.pendingLogs.remove(generatePendingLogKey(communicateMode, str));
        List list = (List) this.activeLogs.remove(str);
        if (!(list == null || list.isEmpty())) {
            list.remove(communicateMode);
        }
        this.activeLogs.put(str, list);
        return log;
    }

    private synchronized MFLog getLog(CommunicateMode communicateMode, String str) {
        return (MFLog) this.pendingLogs.get(generatePendingLogKey(communicateMode, str));
    }

    public MFLog getActiveLog(String str) {
        CommunicateMode communicateMode;
        List list = (List) this.activeLogs.get(str);
        if (list == null || list.isEmpty()) {
            communicateMode = null;
        } else {
            communicateMode = (CommunicateMode) list.get(list.size() - 1);
        }
        if (communicateMode != null) {
            MFLog log = getLog(communicateMode, str);
            if (!(log == null || log.isHidden())) {
                return log;
            }
        }
        return null;
    }

    public MFLog getActiveLogIncludeHidden(String str) {
        CommunicateMode communicateMode;
        List list = (List) this.activeLogs.get(str);
        if (list == null || list.isEmpty()) {
            communicateMode = null;
        } else {
            communicateMode = (CommunicateMode) list.get(list.size() - 1);
        }
        if (communicateMode != null) {
            return getLog(communicateMode, str);
        }
        return null;
    }

    public CommunicateMode getActiveCommunicateMode(String str) {
        List list = (List) this.activeLogs.get(str);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (CommunicateMode) list.get(list.size() - 1);
    }

    public MFLog addLogForActiveLog(String str, String str2) {
        MFLog activeLog = getActiveLog(str);
        if (!(activeLog == null || TextUtils.isEmpty(str2))) {
            activeLog.log(str2);
        }
        return activeLog;
    }

    public synchronized void changePendingLogKey(CommunicateMode communicateMode, String str, CommunicateMode communicateMode2, String str2) {
        this.pendingLogs.put(generatePendingLogKey(communicateMode2, str2), this.pendingLogs.remove(generatePendingLogKey(communicateMode, str)));
        List list = (List) this.activeLogs.remove(str);
        if (!(list == null || list.isEmpty())) {
            list.remove(communicateMode);
            list.add(communicateMode2);
        }
        this.activeLogs.put(str2, list);
    }

    public synchronized void stopLogService(int i) {
        if (this.pendingLogs != null) {
            for (MFLog mFLog : this.pendingLogs.values()) {
                if (mFLog != null && mFLog.getEndTime() <= 0) {
                    switch (i) {
                        case FailureCode.APP_CRASH_FROM_BUTTON_SERVICE /*1905*/:
                            mFLog.log("App was crashed from button service");
                            break;
                        case FailureCode.APP_CRASH_FROM_APP_LAYER /*1906*/:
                            mFLog.log("App was crashed from app layer");
                            break;
                        default:
                            mFLog.log("App was removed from task manager");
                            break;
                    }
                    mFLog.setResultCode(i);
                }
            }
            this.pendingLogs.clear();
        }
        if (this.pendingLogsToSaveDB != null) {
            this.pendingLogsToSaveDB.clear();
        }
        if (this.activeLogs != null) {
            this.activeLogs.clear();
        }
    }

    synchronized MFLog getPendingLog(CommunicateMode communicateMode, String str) {
        return (MFLog) this.pendingLogsToSaveDB.get(generatePendingLogKey(communicateMode, str));
    }

    synchronized void removePendingLog(CommunicateMode communicateMode, String str) {
        this.pendingLogsToSaveDB.remove(generatePendingLogKey(communicateMode, str));
    }

    private String generatePendingLogKey(CommunicateMode communicateMode, String str) {
        if (TextUtils.isEmpty(str)) {
            return communicateMode.toString();
        }
        return str + communicateMode;
    }

    private MFLog getMFLogFromDBDataLogService(int i) {
        if (i != -1) {
            DataLogService dataLogServiceById = DataLogServiceProvider.getInstance(this.context).getDataLogServiceById(i);
            if (dataLogServiceById != null) {
                try {
                    return (MFLog) new cfj().c(dataLogServiceById.getContent(), MFLog.class);
                } catch (Exception e) {
                    MFLogger.e("MFLogService", "Inside .handleAddLog - ex=" + e.toString());
                }
            }
        }
        return null;
    }

    private synchronized void saveLogToDB(CommunicateMode communicateMode, String str) {
        MFLog pendingLog = getPendingLog(communicateMode, str);
        removePendingLog(communicateMode, str);
        if (pendingLog == null) {
            MFLogger.e(TAG, "Cannot save Log to DB - getPendingLong is null");
        } else {
            String b;
            if (pendingLog instanceof MFSyncLog) {
                b = new cfj().b(pendingLog, MFSyncLog.class);
            } else if (pendingLog instanceof MFOtaLog) {
                b = new cfj().b(pendingLog, MFOtaLog.class);
            } else if (pendingLog instanceof MFSetupLog) {
                b = new cfj().b(pendingLog, MFSetupLog.class);
            } else {
                MFLogger.e(TAG, "Cannot save Log to DB - cannot parse dataLogGson");
            }
            DataLogServiceProvider.getInstance(this.context).createOrUpdate(new DataLogService(pendingLog.getStartTimeEpoch(), 0, b, pendingLog.getLogType(), pendingLog.getStartTime(), Calendar.getInstance().getTimeInMillis()));
        }
    }
}
