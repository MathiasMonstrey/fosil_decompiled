package com.misfit.frameworks.buttonservice.communite.ble.hybrid;

import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.communite.SessionType;
import com.misfit.frameworks.buttonservice.communite.ble.BleAdapter;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.BleSessionCallback;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.SessionState;
import com.misfit.frameworks.buttonservice.communite.ble.BleState;
import com.misfit.frameworks.buttonservice.communite.ble.ConnectableSession;
import com.misfit.frameworks.buttonservice.communite.ble.SdkCallback;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.BLEMapping;
import com.misfit.frameworks.buttonservice.utils.DevicePreferenceUtils;
import com.misfit.frameworks.common.log.MFLogger;
import java.util.List;

public class WatchClearLinkMappingSession extends ConnectableSession {
    private boolean hasHID;
    private boolean hasStreaming;
    private List<BLEMapping> mMappings;

    public class DoneCleanLinkMappingState extends BleState {
        public DoneCleanLinkMappingState() {
            super(WatchClearLinkMappingSession.this.TAG);
        }

        public boolean onEnter() {
            super.onEnter();
            MFLogger.d(WatchClearLinkMappingSession.this.TAG, "All done of " + WatchClearLinkMappingSession.this.TAG);
            DevicePreferenceUtils.clearAutoSetMapping(WatchClearLinkMappingSession.this.bleAdapter.getContext(), WatchClearLinkMappingSession.this.bleAdapter.getSerial());
            WatchClearLinkMappingSession.this.stop(0);
            return true;
        }
    }

    public WatchClearLinkMappingSession(List<BLEMapping> list, BleAdapter bleAdapter, BleSessionCallback bleSessionCallback, SdkCallback sdkCallback) {
        super(SessionType.UI, CommunicateMode.CLEAN_LINK_MAPPINGS, bleAdapter, bleSessionCallback, sdkCallback);
        this.mMappings = list;
    }

    public BleSession copyObject() {
        BleSession watchClearLinkMappingSession = new WatchClearLinkMappingSession(this.mMappings, this.bleAdapter, this.bleSessionCallback, this.sdkCallback);
        watchClearLinkMappingSession.setDevice(this.device);
        return watchClearLinkMappingSession;
    }

    protected void initStateMap() {
        super.initStateMap();
        this.sessionStateMap.put(SessionState.DONE_CLEAN_LINK_MAPPING_STATE, DoneCleanLinkMappingState.class.getName());
    }

    protected void buildExtraInfoReturned() {
    }

    protected BleState getStateAfterConnected() {
        return createConcreteState(SessionState.DONE_CLEAN_LINK_MAPPING_STATE);
    }
}
