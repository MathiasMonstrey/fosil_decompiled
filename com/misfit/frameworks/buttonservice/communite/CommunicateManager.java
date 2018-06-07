package com.misfit.frameworks.buttonservice.communite;

import android.content.Context;
import com.fossil.cco;
import com.misfit.frameworks.buttonservice.communite.ble.BleCommunicator;
import com.misfit.frameworks.buttonservice.communite.ble.BleCommunicator.CommunicationResultCallback;
import com.misfit.frameworks.buttonservice.communite.ble.device.TrackerCommunicator;
import com.misfit.frameworks.buttonservice.communite.ble.device.TrackerVibeCommunicator;
import com.misfit.frameworks.buttonservice.communite.ble.device.WatchCommunicator;
import com.misfit.frameworks.buttonservice.communite.ble.device.WatchMiniCommunicator;
import com.misfit.frameworks.buttonservice.communite.ble.device.WatchSlimCommunicator;
import com.misfit.frameworks.buttonservice.utils.DeviceUtils;
import com.misfit.frameworks.buttonservice.utils.FossilDeviceSerialPatternUtil;
import java.util.concurrent.ConcurrentHashMap;

public class CommunicateManager {
    private static final String TAG = CommunicateManager.class.getSimpleName();
    private static CommunicateManager sInstance;
    private ConcurrentHashMap<String, BleCommunicator> bleCommunicators = new ConcurrentHashMap();
    private Context context;
    private BleCommunicator currentCommunicator = null;

    private CommunicateManager(Context context) {
        this.context = context;
    }

    public static synchronized CommunicateManager getInstance(Context context) {
        CommunicateManager communicateManager;
        synchronized (CommunicateManager.class) {
            if (sInstance == null) {
                sInstance = new CommunicateManager(context);
            }
            communicateManager = sInstance;
        }
        return communicateManager;
    }

    public synchronized BleCommunicator getCommunicator(String str, String str2, CommunicationResultCallback communicationResultCallback) {
        BleCommunicator bleCommunicator;
        CommunicationResultCallback communicationResultCallback2 = (CommunicationResultCallback) cco.ce(communicationResultCallback);
        bleCommunicator = (BleCommunicator) this.bleCommunicators.get(str);
        if (bleCommunicator == null) {
            switch (FossilDeviceSerialPatternUtil.getDeviceBySerial(str)) {
                case SAM_SLIM:
                    bleCommunicator = createWatchSlimCommunicator(this.context, str, str2, communicationResultCallback2);
                    break;
                case SAM_MINI:
                    bleCommunicator = createWatchMiniCommunicator(this.context, str, str2, communicationResultCallback2);
                    break;
                case SAM:
                case SE0:
                    bleCommunicator = createWatchCommunicator(this.context, str, str2, communicationResultCallback2);
                    break;
                case RMM:
                    bleCommunicator = createTrackerCommunicator(this.context, str, str2, communicationResultCallback2);
                    break;
                case Q_MOTION:
                    bleCommunicator = createTrackerVibeCommunicator(this.context, str, str2, communicationResultCallback2);
                    break;
                default:
                    bleCommunicator = createTrackerCommunicator(this.context, str, str2, communicationResultCallback2);
                    break;
            }
            this.bleCommunicators.put(str, bleCommunicator);
        }
        this.currentCommunicator = bleCommunicator;
        return bleCommunicator;
    }

    public BleCommunicator getCommunicator(String str, CommunicationResultCallback communicationResultCallback) {
        return getCommunicator(str, DeviceUtils.getInstance(this.context).getMacAddress(this.context, str), communicationResultCallback);
    }

    private BleCommunicator createTrackerCommunicator(Context context, String str, String str2, CommunicationResultCallback communicationResultCallback) {
        return new TrackerCommunicator(context, str, str2, communicationResultCallback);
    }

    private BleCommunicator createTrackerVibeCommunicator(Context context, String str, String str2, CommunicationResultCallback communicationResultCallback) {
        return new TrackerVibeCommunicator(context, str, str2, communicationResultCallback);
    }

    private BleCommunicator createWatchCommunicator(Context context, String str, String str2, CommunicationResultCallback communicationResultCallback) {
        return new WatchCommunicator(context, str, str2, communicationResultCallback);
    }

    private BleCommunicator createWatchSlimCommunicator(Context context, String str, String str2, CommunicationResultCallback communicationResultCallback) {
        return new WatchSlimCommunicator(context, str, str2, communicationResultCallback);
    }

    private BleCommunicator createWatchMiniCommunicator(Context context, String str, String str2, CommunicationResultCallback communicationResultCallback) {
        return new WatchMiniCommunicator(context, str, str2, communicationResultCallback);
    }

    public void clearCurrentCommunicatorSessionQueueIfNot(String str) {
        if (((BleCommunicator) this.bleCommunicators.get(str)) != this.currentCommunicator && this.currentCommunicator != null) {
            this.currentCommunicator.clearSessionQueue();
        }
    }

    public void clearCommunicatorSessionQueue(String str) {
        BleCommunicator bleCommunicator = (BleCommunicator) this.bleCommunicators.get(str);
        if (bleCommunicator != null) {
            bleCommunicator.clearSessionQueue();
        }
    }

    public String getDeviceModel(String str) {
        BleCommunicator bleCommunicator = (BleCommunicator) this.bleCommunicators.get(str);
        if (bleCommunicator == null) {
            return "";
        }
        return bleCommunicator.getBleAdapter().getDeviceModel();
    }

    public String getFirmwareVersion(String str) {
        BleCommunicator bleCommunicator = (BleCommunicator) this.bleCommunicators.get(str);
        if (bleCommunicator == null) {
            return "";
        }
        return bleCommunicator.getBleAdapter().getFirmwareVersion();
    }

    public short getMicroAppMajorVersion(String str) {
        BleCommunicator bleCommunicator = (BleCommunicator) this.bleCommunicators.get(str);
        if (bleCommunicator == null) {
            return (short) -1;
        }
        return bleCommunicator.getBleAdapter().getMicroAppMajorVersion();
    }

    public short getMicroAppMinorVersion(String str) {
        BleCommunicator bleCommunicator = (BleCommunicator) this.bleCommunicators.get(str);
        if (bleCommunicator == null) {
            return (short) -1;
        }
        return bleCommunicator.getBleAdapter().getMicroAppMinorVersion();
    }

    public int getBatteryLevel(String str) {
        BleCommunicator bleCommunicator = (BleCommunicator) this.bleCommunicators.get(str);
        if (bleCommunicator == null) {
            return -1;
        }
        return bleCommunicator.getBleAdapter().getBatteryLevel();
    }

    public ConcurrentHashMap<String, BleCommunicator> getBleCommunicators() {
        return this.bleCommunicators;
    }

    public void removeCommunicator(String str) {
        this.bleCommunicators.remove(str);
    }
}
