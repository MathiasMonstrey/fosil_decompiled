package com.misfit.frameworks.buttonservice.communite.ble.tracker;

import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.communite.SessionType;
import com.misfit.frameworks.buttonservice.communite.ble.BleAdapter;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.BleSessionCallback;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.SessionState;
import com.misfit.frameworks.buttonservice.communite.ble.BleState;
import com.misfit.frameworks.buttonservice.communite.ble.ConnectableSession;
import com.misfit.frameworks.buttonservice.communite.ble.SdkCallback;
import com.misfit.frameworks.buttonservice.communite.ble.share.DisableGoalTrackingBaseState;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.buttonservice.model.LinkMode;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.LinkMapping;
import com.misfit.frameworks.buttonservice.utils.DevicePreferenceUtils;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import java.util.List;

public class TrackerDisableGoalTrackingSession extends ConnectableSession {
    protected List<LinkMapping> oldMappings;
    private LinkMode oldMode;

    public class ChooseDisableOldLinkMappingsState extends BleState {
        public ChooseDisableOldLinkMappingsState() {
            super(TrackerDisableGoalTrackingSession.this.TAG);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            if (TrackerDisableGoalTrackingSession.this.oldMode == LinkMode.GOAL_TRACKING) {
                TrackerDisableGoalTrackingSession.this.enterState(TrackerDisableGoalTrackingSession.this.createConcreteState(SessionState.DISABLE_OLD_GOAL_TRACKING_STATE));
                return;
            }
            TrackerDisableGoalTrackingSession.this.log("No need to disable goal tracking.");
            TrackerDisableGoalTrackingSession.this.stop(0);
        }

        public int getTimeout() {
            return MFNetworkReturnCode.INTERNAL_SERVER_ERROR;
        }
    }

    public class DisableOldGoalTrackingState extends DisableGoalTrackingBaseState {
        public DisableOldGoalTrackingState() {
            super(TrackerDisableGoalTrackingSession.this.bleAdapter, TrackerDisableGoalTrackingSession.this);
            TrackerDisableGoalTrackingSession.this.log("Disable goal tracking of device with serial " + TrackerDisableGoalTrackingSession.this.serial);
        }

        protected BleState getStateOnCompleted(boolean z) {
            if (z) {
                DevicePreferenceUtils.clearAutoSetMapping(TrackerDisableGoalTrackingSession.this.context, TrackerDisableGoalTrackingSession.this.serial);
                TrackerDisableGoalTrackingSession.this.stop(0);
            } else {
                TrackerDisableGoalTrackingSession.this.stop(FailureCode.FAILED_TO_DISABLE_GOAL_TRACKING);
            }
            return null;
        }

        protected BleState getStateOnTimeOut() {
            TrackerDisableGoalTrackingSession.this.stop(FailureCode.FAILED_TO_DISABLE_GOAL_TRACKING);
            return null;
        }
    }

    public TrackerDisableGoalTrackingSession(BleAdapter bleAdapter, BleSessionCallback bleSessionCallback, SdkCallback sdkCallback) {
        super(SessionType.URGENT, CommunicateMode.DISABLE_GOAL_TRACKING, bleAdapter, bleSessionCallback, sdkCallback);
    }

    protected boolean onStart(Object... objArr) {
        initSettings();
        return super.onStart(objArr);
    }

    private void initSettings() {
        this.oldMappings = LinkMapping.convertToLinkMapping(DevicePreferenceUtils.getAutoMapping(this.bleAdapter.getContext(), this.bleAdapter.getSerial()));
        if (this.oldMappings == null) {
            this.oldMode = null;
        } else {
            this.oldMode = LinkMode.fromLinkMappings(this.oldMappings);
        }
    }

    public BleSession copyObject() {
        BleSession trackerDisableGoalTrackingSession = new TrackerDisableGoalTrackingSession(this.bleAdapter, this.bleSessionCallback, this.sdkCallback);
        trackerDisableGoalTrackingSession.setDevice(this.device);
        return trackerDisableGoalTrackingSession;
    }

    protected void initStateMap() {
        super.initStateMap();
        this.sessionStateMap.put(SessionState.CHOOSE_DISABLE_OLD_LINK_MAPPINGS_STATE, ChooseDisableOldLinkMappingsState.class.getName());
        this.sessionStateMap.put(SessionState.DISABLE_OLD_GOAL_TRACKING_STATE, DisableOldGoalTrackingState.class.getName());
    }

    protected void buildExtraInfoReturned() {
    }

    protected BleState getStateAfterConnected() {
        return createConcreteState(SessionState.CHOOSE_DISABLE_OLD_LINK_MAPPINGS_STATE);
    }
}
