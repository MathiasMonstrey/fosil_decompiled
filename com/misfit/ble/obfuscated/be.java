package com.misfit.ble.obfuscated;

import com.misfit.ble.obfuscated.av.C4455a;
import com.misfit.ble.obfuscated.ba.C4463a;
import com.misfit.ble.setting.flashlink.EventMappingEnum.StopWatchSecondHand;
import com.misfit.ble.setting.qmotion.QMotionEnum.LEDColor;
import com.misfit.ble.setting.sam.HandControl;
import com.misfit.ble.setting.sam.HandSettings;
import com.misfit.ble.setting.sam.SAMEnum$HandMovingType;
import com.misfit.ble.setting.sam.SAMEnum.VibeEnum;
import com.misfit.ble.shine.ShineActionID;
import com.misfit.ble.shine.ShineProfile.ActionResult;
import com.misfit.ble.shine.ShineProfile.ConfigurationCallback;
import com.misfit.ble.shine.ShineProfile.ResultCode;
import com.misfit.ble.shine.ShineProperty;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import org.json.JSONObject;

public class be {
    private C4463a fG;

    public be(C4463a c4463a) {
        this.fG = c4463a;
    }

    public ba m14900i(final ConfigurationCallback configurationCallback) {
        new gp().ca();
        return new av(ShineActionID.SET_CALIBRATED_HAND_POSITION, "phaseSetCalibratedHandPosition", Arrays.asList(new ew[]{r0}), this.fG, new C4455a(this) {
            final /* synthetic */ be hS;

            public void mo4826a(ba baVar, List<ew> list, ActionResult actionResult) {
                configurationCallback.onConfigCompleted(baVar.aR(), actionResult, new Hashtable());
            }
        }, new JSONObject[0]);
    }

    public ba m14898a(SAMEnum$HandMovingType sAMEnum$HandMovingType, List<HandSettings> list, final ConfigurationCallback configurationCallback) {
        new gs().m15140a(sAMEnum$HandMovingType, list);
        return new av(ShineActionID.SET_MOVING_HANDS, "phaseSetMovingHands", Arrays.asList(new ew[]{r0}), this.fG, new C4455a(this) {
            final /* synthetic */ be hS;

            public void mo4826a(ba baVar, List<ew> list, ActionResult actionResult) {
                configurationCallback.onConfigCompleted(baVar.aR(), actionResult, new Hashtable());
            }
        }, new JSONObject[0]);
    }

    public ba m14893a(byte b, boolean z, boolean z2, final ConfigurationCallback configurationCallback) {
        new gu().m15142a(b, z, z2);
        return new av(ShineActionID.SET_REQUEST_HANDS_CONTROL, "phaseSetRequestHandsControl", Arrays.asList(new ew[]{r0}), this.fG, new C4455a(this) {
            final /* synthetic */ be hS;

            public void mo4826a(ba baVar, List<ew> list, ActionResult actionResult) {
                configurationCallback.onConfigCompleted(baVar.aR(), actionResult, new Hashtable());
            }
        }, new JSONObject[0]);
    }

    public ba m14894a(int i, final ConfigurationCallback configurationCallback) {
        new gt().m15141i(i);
        return new av(ShineActionID.SET_RELEASE_HANDS_CONTROL, "phaseSetReleaseHandsControl", Arrays.asList(new ew[]{r0}), this.fG, new C4455a(this) {
            final /* synthetic */ be hS;

            public void mo4826a(ba baVar, List<ew> list, ActionResult actionResult) {
                configurationCallback.onConfigCompleted(baVar.aR(), actionResult, new Hashtable());
            }
        }, new JSONObject[0]);
    }

    public ba m14901j(final ConfigurationCallback configurationCallback) {
        new gk().ca();
        return new av(ShineActionID.GET_CURRENT_HAND_POSITIONS, "phaseGetCurrentHandPositions", Arrays.asList(new ew[]{r0}), this.fG, new C4455a(this) {
            final /* synthetic */ be hS;

            public void mo4826a(ba baVar, List<ew> list, ActionResult actionResult) {
                Hashtable hashtable = new Hashtable();
                if (actionResult.getResultCode() == ResultCode.SUCCEEDED) {
                    for (ew ewVar : list) {
                        if (ewVar instanceof gk) {
                            hashtable.put(ShineProperty.HAND_POSITIONS, ((gk) ewVar).di().nB);
                        }
                    }
                }
                configurationCallback.onConfigCompleted(baVar.aR(), actionResult, hashtable);
            }
        }, new JSONObject[0]);
    }

    public ba m14897a(LEDColor lEDColor, byte b, VibeEnum vibeEnum, int i, List<HandControl> list, final ConfigurationCallback configurationCallback) {
        new go().m15136a(lEDColor, b, vibeEnum, i, list);
        return new av(ShineActionID.SEND_NOTIFICATION_HAND_CONTROL, "phaseSendNotificationHandControl", Arrays.asList(new ew[]{r0}), this.fG, new C4455a(this) {
            final /* synthetic */ be hS;

            public void mo4826a(ba baVar, List<ew> list, ActionResult actionResult) {
                configurationCallback.onConfigCompleted(baVar.aR(), actionResult, new Hashtable());
            }
        }, new JSONObject[0]);
    }

    public ba m14895a(long j, int i, short s, final ConfigurationCallback configurationCallback) {
        new gr().m15139a(j, i, s);
        return new av(ShineActionID.SET_CURRENT_TIME_SERVICE, "phaseSetCurrentTimeService", Arrays.asList(new ew[]{r0}), this.fG, new C4455a(this) {
            final /* synthetic */ be hS;

            public void mo4826a(ba baVar, List<ew> list, ActionResult actionResult) {
                configurationCallback.onConfigCompleted(baVar.aR(), actionResult, new Hashtable());
            }
        }, new JSONObject[0]);
    }

    public ba m14899b(int i, final ConfigurationCallback configurationCallback) {
        int i2 = ((i * 3) + 2) + 4;
        new gy().m15147a(0, (long) i2, (long) i2);
        return new av(ShineActionID.VERIFY_MULTIPLE_ALARMS, "phaseVerifyMultipleAlarms", Arrays.asList(new ew[]{r1}), this.fG, new C4455a(this) {
            final /* synthetic */ be hS;

            public void mo4826a(ba baVar, List<ew> list, ActionResult actionResult) {
                Hashtable hashtable = new Hashtable();
                if (actionResult.getResultCode() == ResultCode.SUCCEEDED) {
                    for (ew ewVar : list) {
                        if (ewVar instanceof gy) {
                            hashtable.put(ShineProperty.MULTIPLE_ALARMS_CRC, Long.valueOf(((gy) ewVar).dm().mN));
                        }
                    }
                }
                configurationCallback.onConfigCompleted(baVar.aR(), actionResult, hashtable);
            }
        }, new JSONObject[0]);
    }

    public ba m14902k(final ConfigurationCallback configurationCallback) {
        new gi().ca();
        return new av(ShineActionID.CLEAR_ALL_HAND_NOTIFICATIONS, "phaseClearAllHandNotifications", Arrays.asList(new ew[]{r0}), this.fG, new C4455a(this) {
            final /* synthetic */ be hS;

            public void mo4826a(ba baVar, List<ew> list, ActionResult actionResult) {
                configurationCallback.onConfigCompleted(baVar.aR(), actionResult, new Hashtable());
            }
        }, new JSONObject[0]);
    }

    public ba m14896a(StopWatchSecondHand stopWatchSecondHand, final ConfigurationCallback configurationCallback) {
        new gw().m15144a(stopWatchSecondHand);
        return new av(ShineActionID.SET_STOP_WATCH_SETTING, "phaseSetStopWatchSetting", Arrays.asList(new ew[]{r0}), this.fG, new C4455a(this) {
            final /* synthetic */ be hS;

            public void mo4826a(ba baVar, List<ew> list, ActionResult actionResult) {
                configurationCallback.onConfigCompleted(baVar.aR(), actionResult, new Hashtable());
            }
        }, new JSONObject[0]);
    }

    public ba m14903l(final ConfigurationCallback configurationCallback) {
        new gm().ca();
        return new av(ShineActionID.GET_STOP_WATCH_SETTING, "phaseGetStopWatchSetting", Arrays.asList(new ew[]{r0}), this.fG, new C4455a(this) {
            final /* synthetic */ be hS;

            public void mo4826a(ba baVar, List<ew> list, ActionResult actionResult) {
                Hashtable hashtable = new Hashtable();
                if (actionResult.getResultCode() == ResultCode.SUCCEEDED) {
                    for (ew ewVar : list) {
                        if (ewVar instanceof gm) {
                            hashtable.put(ShineProperty.STOP_WATCH_SECOND_HAND, ((gm) ewVar).dk().nF);
                        }
                    }
                }
                configurationCallback.onConfigCompleted(baVar.aR(), actionResult, hashtable);
            }
        }, new JSONObject[0]);
    }
}
