package com.misfit.frameworks.buttonservice.communite.ble;

import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.communite.SessionType;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.BleSessionCallback;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.SessionState;
import com.misfit.frameworks.buttonservice.communite.ble.share.ClearMappingBaseState;
import com.misfit.frameworks.buttonservice.communite.ble.share.DisableGoalTrackingBaseState;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.buttonservice.model.LinkMode;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.BLEMapping;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.LinkMapping;
import com.misfit.frameworks.buttonservice.utils.DevicePreferenceUtils;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.log.MFLogger;
import java.util.List;

public class ClearLinkMappingsSession extends ConnectableSession {
    protected List<LinkMapping> mappings;
    private LinkMode oldMode = LinkMode.RING_PHONE;

    public class ChooseDisableLinkMappingsState extends BleState {
        public ChooseDisableLinkMappingsState() {
            super(ClearLinkMappingsSession.this.TAG);
        }

        public boolean onEnter() {
            super.onEnter();
            if (ClearLinkMappingsSession.this.mappings == null || ClearLinkMappingsSession.this.mappings.size() == 0) {
                ClearLinkMappingsSession.this.stop(FailureCode.FAILED_TO_SET_LINK_MAPPING_EMPTY);
                return false;
            }
            ClearLinkMappingsSession.this.oldMode = LinkMode.fromLinkMappings(ClearLinkMappingsSession.this.mappings);
            switch (ClearLinkMappingsSession.this.oldMode) {
                case RING_PHONE:
                    ClearLinkMappingsSession.this.enterStateWithDelayTime(ClearLinkMappingsSession.this.createConcreteState(SessionState.CLEAR_MAPPING_STOP_STREAMING), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                    return true;
                case CONTROL_MUSIC:
                case TAKE_PHOTO:
                    ClearLinkMappingsSession.this.enterStateWithDelayTime(ClearLinkMappingsSession.this.createConcreteState(SessionState.CLEAR_ALL_MAPPINGS_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                    return true;
                case GOAL_TRACKING:
                    ClearLinkMappingsSession.this.enterStateWithDelayTime(ClearLinkMappingsSession.this.createConcreteState(SessionState.DISABLE_GOAL_TRACKING_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                    return true;
                default:
                    ClearLinkMappingsSession.this.stop(FailureCode.FAILED_TO_SET_LINK_MAPPING_EMPTY);
                    return false;
            }
        }
    }

    public class ClearAllMappingState extends ClearMappingBaseState {
        public ClearAllMappingState() {
            super(ClearLinkMappingsSession.this.bleAdapter, ClearLinkMappingsSession.this);
            ClearLinkMappingsSession.this.log("Clear mappings of device with serial " + ClearLinkMappingsSession.this.serial);
        }

        protected BleState getStateOnCompleted(boolean z) {
            if (z) {
                return ClearLinkMappingsSession.this.createConcreteState(SessionState.CLEAR_MAPPING_DISCONNECT_HID);
            }
            ClearLinkMappingsSession.this.stop(FailureCode.FAILED_TO_CLEAR_LINK_MAPPING);
            return null;
        }

        protected BleState getStateOnTimeOut() {
            ClearLinkMappingsSession.this.stop(FailureCode.FAILED_TO_CLEAR_LINK_MAPPING);
            return null;
        }
    }

    public class ClearMappingDisconnectHIDState extends BleState {
        public ClearMappingDisconnectHIDState() {
            super(ClearLinkMappingsSession.this.TAG);
            ClearLinkMappingsSession.this.log("Disconnect HID to" + ClearLinkMappingsSession.this.serial);
        }

        protected boolean isNeedDisConnectHID() {
            return ClearLinkMappingsSession.this.oldMode == LinkMode.CONTROL_MUSIC || ClearLinkMappingsSession.this.oldMode == LinkMode.TAKE_PHOTO;
        }

        public boolean onEnter() {
            if (isNeedDisConnectHID()) {
                startTimeout();
                if (!ClearLinkMappingsSession.this.bleAdapter.hidDisconnect()) {
                    stopTimeout();
                    ClearLinkMappingsSession.this.enterStateWithDelayTime(ClearLinkMappingsSession.this.createConcreteState(SessionState.DONE_CLEAN_LINK_MAPPING_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                    return false;
                }
            }
            ClearLinkMappingsSession.this.log("No need to Disconnect HID.");
            ClearLinkMappingsSession.this.enterStateWithDelayTime(ClearLinkMappingsSession.this.createConcreteState(SessionState.DONE_CLEAN_LINK_MAPPING_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        public boolean handleOnHidDisconnected() {
            stopTimeout();
            ClearLinkMappingsSession.this.enterState(ClearLinkMappingsSession.this.createConcreteState(SessionState.DONE_CLEAN_LINK_MAPPING_STATE));
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            ClearLinkMappingsSession.this.log("Disconnect HID timeout.");
            ClearLinkMappingsSession.this.enterState(ClearLinkMappingsSession.this.createConcreteState(SessionState.DONE_CLEAN_LINK_MAPPING_STATE));
        }

        public int getTimeout() {
            return 5000;
        }
    }

    public class DisableGoalTrackingState extends DisableGoalTrackingBaseState {
        public DisableGoalTrackingState() {
            super(ClearLinkMappingsSession.this.bleAdapter, ClearLinkMappingsSession.this);
            ClearLinkMappingsSession.this.log("Disable Goal Tracking of device with serial " + ClearLinkMappingsSession.this.serial);
        }

        protected BleState getStateOnCompleted(boolean z) {
            if (z) {
                return ClearLinkMappingsSession.this.createConcreteState(SessionState.DONE_CLEAN_LINK_MAPPING_STATE);
            }
            ClearLinkMappingsSession.this.stop(FailureCode.FAILED_TO_DISABLE_GOAL_TRACKING);
            return null;
        }

        protected BleState getStateOnTimeOut() {
            ClearLinkMappingsSession.this.stop(FailureCode.FAILED_TO_DISABLE_GOAL_TRACKING);
            return null;
        }
    }

    public class DoneCleanLinkMappingState extends BleState {
        public DoneCleanLinkMappingState() {
            super(ClearLinkMappingsSession.this.TAG);
        }

        public boolean onEnter() {
            super.onEnter();
            MFLogger.d(ClearLinkMappingsSession.this.TAG, "All done of " + ClearLinkMappingsSession.this.TAG);
            DevicePreferenceUtils.clearAutoSetMapping(ClearLinkMappingsSession.this.bleAdapter.getContext(), ClearLinkMappingsSession.this.bleAdapter.getSerial());
            ClearLinkMappingsSession.this.stop(0);
            return true;
        }
    }

    public ClearLinkMappingsSession(List<BLEMapping> list, BleAdapter bleAdapter, BleSessionCallback bleSessionCallback, SdkCallback sdkCallback) {
        super(SessionType.UI, CommunicateMode.CLEAN_LINK_MAPPINGS, bleAdapter, bleSessionCallback, sdkCallback);
        this.mappings = LinkMapping.convertToLinkMapping(list);
    }

    public BleSession copyObject() {
        BleSession clearLinkMappingsSession = new ClearLinkMappingsSession(LinkMapping.convertToBLEMapping(this.mappings), this.bleAdapter, this.bleSessionCallback, this.sdkCallback);
        clearLinkMappingsSession.setDevice(this.device);
        return clearLinkMappingsSession;
    }

    protected void initStateMap() {
        super.initStateMap();
        this.sessionStateMap.put(SessionState.CHOOSE_DISABLE_LINK_MAPPINGS_STATE, ChooseDisableLinkMappingsState.class.getName());
        this.sessionStateMap.put(SessionState.DISABLE_GOAL_TRACKING_STATE, DisableGoalTrackingState.class.getName());
        this.sessionStateMap.put(SessionState.CLEAR_ALL_MAPPINGS_STATE, ClearAllMappingState.class.getName());
        this.sessionStateMap.put(SessionState.CLEAR_MAPPING_DISCONNECT_HID, ClearMappingDisconnectHIDState.class.getName());
        this.sessionStateMap.put(SessionState.DONE_CLEAN_LINK_MAPPING_STATE, DoneCleanLinkMappingState.class.getName());
    }

    protected BleState getStateAfterConnected() {
        return createConcreteState(SessionState.CHOOSE_DISABLE_LINK_MAPPINGS_STATE);
    }

    protected void buildExtraInfoReturned() {
    }
}
