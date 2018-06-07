package com.misfit.ble.obfuscated;

import com.misfit.ble.obfuscated.C4534do.C4533a;
import com.misfit.ble.obfuscated.av.C4455a;
import com.misfit.ble.obfuscated.ba.C4463a;
import com.misfit.ble.obfuscated.dm.C4531a;
import com.misfit.ble.obfuscated.dp.C4535a;
import com.misfit.ble.obfuscated.dw.C4542a;
import com.misfit.ble.obfuscated.eb.C4549a;
import com.misfit.ble.obfuscated.ee.C4552a;
import com.misfit.ble.setting.pluto.AlarmSettings;
import com.misfit.ble.setting.pluto.GoalHitNotificationSettings;
import com.misfit.ble.setting.pluto.InactivityNudgeSettings;
import com.misfit.ble.setting.pluto.NotificationsSettings;
import com.misfit.ble.setting.pluto.PlutoSequence.LED;
import com.misfit.ble.setting.pluto.PlutoSequence.Sound;
import com.misfit.ble.setting.pluto.PlutoSequence.Vibe;
import com.misfit.ble.shine.ShineActionID;
import com.misfit.ble.shine.ShineProfile.ActionResult;
import com.misfit.ble.shine.ShineProfile.ConfigurationCallback;
import com.misfit.ble.shine.ShineProfile.ResultCode;
import com.misfit.ble.shine.ShineProperty;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import org.json.JSONObject;

public class bb {
    private C4463a fG;

    public bb(C4463a c4463a) {
        this.fG = c4463a;
    }

    public ba m14861a(InactivityNudgeSettings inactivityNudgeSettings, final ConfigurationCallback configurationCallback) {
        new fu().m15104a(inactivityNudgeSettings);
        return new av(ShineActionID.SET_INACTIVITY_NUDGE, "phaseSetInactivityNudge", Arrays.asList(new ew[]{r0}), this.fG, new C4455a(this) {
            final /* synthetic */ bb hM;

            public void mo4826a(ba baVar, List<ew> list, ActionResult actionResult) {
                configurationCallback.onConfigCompleted(baVar.aR(), actionResult, new Hashtable());
            }
        }, new JSONObject[0]);
    }

    public ba m14867b(final ConfigurationCallback configurationCallback) {
        new eb().ca();
        return new av(ShineActionID.GET_INACTIVITY_NUDGE, "phaseGetInactivityNudge", Arrays.asList(new ew[]{r0}), this.fG, new C4455a(this) {
            final /* synthetic */ bb hM;

            public void mo4826a(ba baVar, List<ew> list, ActionResult actionResult) {
                Hashtable hashtable = new Hashtable();
                if (actionResult.getResultCode() == ResultCode.SUCCEEDED) {
                    for (ew ewVar : list) {
                        if (ewVar instanceof eb) {
                            C4549a cL = ((eb) ewVar).cL();
                            hashtable.put(ShineProperty.INACTIVITY_NUDGE_SETTINGS, new InactivityNudgeSettings(cL.aQ, cL.lX, cL.lY, cL.lZ, cL.aR, cL.aS, cL.aT, cL.aU, cL.mi));
                        }
                    }
                }
                configurationCallback.onConfigCompleted(baVar.aR(), actionResult, hashtable);
            }
        }, new JSONObject[0]);
    }

    public ba m14859a(AlarmSettings alarmSettings, final ConfigurationCallback configurationCallback) {
        new fx().m15107a(alarmSettings);
        new fg().m15090a(alarmSettings);
        return new av(ShineActionID.SET_SINGLE_ALARM_TIME, "phaseSetSingleAlarmTime", Arrays.asList(new ew[]{r0, r1}), this.fG, new C4455a(this) {
            final /* synthetic */ bb hM;

            public void mo4826a(ba baVar, List<ew> list, ActionResult actionResult) {
                configurationCallback.onConfigCompleted(baVar.aR(), actionResult, new Hashtable());
            }
        }, new JSONObject[0]);
    }

    public ba m14866b(byte b, final ConfigurationCallback configurationCallback) {
        new ee().m15062b(b);
        new dm().ca();
        return new av(ShineActionID.GET_SINGLE_ALARM_TIME, "phaseGetSingleAlarmTime", Arrays.asList(new ew[]{r0, r1}), this.fG, new C4455a(this) {
            final /* synthetic */ bb hM;

            public void mo4826a(ba baVar, List<ew> list, ActionResult actionResult) {
                Hashtable hashtable = new Hashtable();
                if (actionResult.getResultCode() == ResultCode.SUCCEEDED) {
                    AlarmSettings alarmSettings = new AlarmSettings();
                    for (ew ewVar : list) {
                        if (ewVar instanceof ee) {
                            C4552a cO = ((ee) ewVar).cO();
                            alarmSettings.setAlarmDay(cO.aF);
                            alarmSettings.setAlarmType(cO.aH);
                            alarmSettings.setAlarmHour(cO.aI);
                            alarmSettings.setAlarmMinute(cO.aJ);
                        } else if (ewVar instanceof dm) {
                            C4531a cv = ((dm) ewVar).cv();
                            alarmSettings.setWindowInMinute(cv.aN);
                            alarmSettings.setLEDSequence(cv.aK);
                            alarmSettings.setVibeSequence(cv.aL);
                            alarmSettings.setSoundSequence(cv.aM);
                            alarmSettings.setSnoozeTimeInMinute(cv.aO);
                            alarmSettings.setAlarmDuration(cv.aP);
                        }
                    }
                    if (!alarmSettings.isDefaultValue()) {
                        hashtable.put(ShineProperty.ALARM_SETTINGS, alarmSettings);
                    }
                }
                configurationCallback.onConfigCompleted(baVar.aR(), actionResult, hashtable);
            }
        }, new JSONObject[0]);
    }

    public ba m14868c(final ConfigurationCallback configurationCallback) {
        new co().ca();
        return new av(ShineActionID.CLEAR_ALL_ALARMS, "phaseClearAllAlarms", Arrays.asList(new ew[]{r0}), this.fG, new C4455a(this) {
            final /* synthetic */ bb hM;

            public void mo4826a(ba baVar, List<ew> list, ActionResult actionResult) {
                configurationCallback.onConfigCompleted(baVar.aR(), actionResult, new Hashtable());
            }
        }, new JSONObject[0]);
    }

    public ba m14860a(GoalHitNotificationSettings goalHitNotificationSettings, final ConfigurationCallback configurationCallback) {
        new fq().m15100a(goalHitNotificationSettings);
        return new av(ShineActionID.SET_GOAL_HIT_NOTIFICATION, "phaseSetGoalHitNotification", Arrays.asList(new ew[]{r0}), this.fG, new C4455a(this) {
            final /* synthetic */ bb hM;

            public void mo4826a(ba baVar, List<ew> list, ActionResult actionResult) {
                configurationCallback.onConfigCompleted(baVar.aR(), actionResult, new Hashtable());
            }
        }, new JSONObject[0]);
    }

    public ba m14869d(final ConfigurationCallback configurationCallback) {
        new dw().ca();
        return new av(ShineActionID.GET_GOAL_HIT_NOTIFICATION, "phaseGetGoalHitNotification", Arrays.asList(new ew[]{r0}), this.fG, new C4455a(this) {
            final /* synthetic */ bb hM;

            public void mo4826a(ba baVar, List<ew> list, ActionResult actionResult) {
                Hashtable hashtable = new Hashtable();
                if (actionResult.getResultCode() == ResultCode.SUCCEEDED) {
                    for (ew ewVar : list) {
                        if (ewVar instanceof dw) {
                            C4542a cG = ((dw) ewVar).cG();
                            hashtable.put(ShineProperty.GOAL_HIT_NOTIFICATION_SETTINGS, new GoalHitNotificationSettings(cG.aQ, cG.lX, cG.lY, cG.lZ, cG.aR, cG.aS, cG.aT, cG.aU));
                        }
                    }
                }
                configurationCallback.onConfigCompleted(baVar.aR(), actionResult, hashtable);
            }
        }, new JSONObject[0]);
    }

    public ba m14862a(NotificationsSettings notificationsSettings, final ConfigurationCallback configurationCallback) {
        new fi().m15092a(notificationsSettings);
        new fh().m15091a(notificationsSettings);
        return new av(ShineActionID.SET_CALL_TEXT_NOTIFICATIONS, "phaseSetCallTextNotifications", Arrays.asList(new ew[]{r0, r1}), this.fG, new C4455a(this) {
            final /* synthetic */ bb hM;

            public void mo4826a(ba baVar, List<ew> list, ActionResult actionResult) {
                configurationCallback.onConfigCompleted(baVar.aR(), actionResult, new Hashtable());
            }
        }, new JSONObject[0]);
    }

    public ba m14870e(final ConfigurationCallback configurationCallback) {
        new C4534do().ca();
        new dp().ca();
        return new av(ShineActionID.GET_CALL_TEXT_NOTIFICATIONS, "phaseGetCallTextNotifications", Arrays.asList(new ew[]{r0, r1}), this.fG, new C4455a(this) {
            final /* synthetic */ bb hM;

            public void mo4826a(ba baVar, List<ew> list, ActionResult actionResult) {
                Hashtable hashtable = new Hashtable();
                if (actionResult.getResultCode() == ResultCode.SUCCEEDED) {
                    NotificationsSettings notificationsSettings = new NotificationsSettings();
                    for (ew ewVar : list) {
                        if (ewVar instanceof C4534do) {
                            C4533a cy = ((C4534do) ewVar).cy();
                            notificationsSettings.setCallLEDSequence(cy.lA);
                            notificationsSettings.setCallVibeSequence(cy.lB);
                            notificationsSettings.setCallSoundSequence(cy.lC);
                            notificationsSettings.setTextLEDSequence(cy.lD);
                            notificationsSettings.setTextVibeSequence(cy.lE);
                            notificationsSettings.setTextSoundSequence(cy.lF);
                        } else if (ewVar instanceof dp) {
                            C4535a cz = ((dp) ewVar).cz();
                            notificationsSettings.setStartHour(cz.aR);
                            notificationsSettings.setStartMinute(cz.aS);
                            notificationsSettings.setEndHour(cz.aT);
                            notificationsSettings.setEndMinute(cz.aU);
                        }
                    }
                    hashtable.put(ShineProperty.CALL_TEXT_NOTIFICATION_SETTINGS, notificationsSettings);
                }
                configurationCallback.onConfigCompleted(baVar.aR(), actionResult, hashtable);
            }
        }, new JSONObject[0]);
    }

    public ba m14871f(final ConfigurationCallback configurationCallback) {
        new cq().ca();
        return new av(ShineActionID.DISABLE_ALL_CALL_TEXT_NOTIFICATIONS, "phaseDisableAllCallTextNotifications", Arrays.asList(new ew[]{r0}), this.fG, new C4455a(this) {
            final /* synthetic */ bb hM;

            public void mo4826a(ba baVar, List<ew> list, ActionResult actionResult) {
                configurationCallback.onConfigCompleted(baVar.aR(), actionResult, new Hashtable());
            }
        }, new JSONObject[0]);
    }

    public ba m14872g(final ConfigurationCallback configurationCallback) {
        new ez().ca();
        return new av(ShineActionID.SEND_CALL_NOTIFICATION, "phaseSendCallNotification", Arrays.asList(new ew[]{r0}), this.fG, new C4455a(this) {
            final /* synthetic */ bb hM;

            public void mo4826a(ba baVar, List<ew> list, ActionResult actionResult) {
                configurationCallback.onConfigCompleted(baVar.aR(), actionResult, new Hashtable());
            }
        }, new JSONObject[0]);
    }

    public ba m14873h(final ConfigurationCallback configurationCallback) {
        new fa().ca();
        return new av(ShineActionID.SEND_TEXT_NOTIFICATION, "phaseSendTextNotification", Arrays.asList(new ew[]{r0}), this.fG, new C4455a(this) {
            final /* synthetic */ bb hM;

            public void mo4826a(ba baVar, List<ew> list, ActionResult actionResult) {
                configurationCallback.onConfigCompleted(baVar.aR(), actionResult, new Hashtable());
            }
        }, new JSONObject[0]);
    }

    public ba m14863a(LED led, short s, int i, final ConfigurationCallback configurationCallback) {
        new er().m15074a(led, s, i);
        return new av(ShineActionID.PLAY_LED_ANIMATION, "phasePlayLEDAnimation", Arrays.asList(new ew[]{r0}), this.fG, new C4455a(this) {
            final /* synthetic */ bb hM;

            public void mo4826a(ba baVar, List<ew> list, ActionResult actionResult) {
                configurationCallback.onConfigCompleted(baVar.aR(), actionResult, new Hashtable());
            }
        }, new JSONObject[0]);
    }

    public ba m14865a(Vibe vibe, short s, int i, final ConfigurationCallback configurationCallback) {
        new ev().m15078a(vibe, s, i);
        return new av(ShineActionID.PLAY_VIBRATION, "phasePlayVibration", Arrays.asList(new ew[]{r0}), this.fG, new C4455a(this) {
            final /* synthetic */ bb hM;

            public void mo4826a(ba baVar, List<ew> list, ActionResult actionResult) {
                configurationCallback.onConfigCompleted(baVar.aR(), actionResult, new Hashtable());
            }
        }, new JSONObject[0]);
    }

    public ba m14864a(Sound sound, short s, int i, final ConfigurationCallback configurationCallback) {
        new eu().m15077a(sound, s, i);
        return new av(ShineActionID.PLAY_SOUND, "phasePlaySound", Arrays.asList(new ew[]{r0}), this.fG, new C4455a(this) {
            final /* synthetic */ bb hM;

            public void mo4826a(ba baVar, List<ew> list, ActionResult actionResult) {
                configurationCallback.onConfigCompleted(baVar.aR(), actionResult, new Hashtable());
            }
        }, new JSONObject[0]);
    }
}
