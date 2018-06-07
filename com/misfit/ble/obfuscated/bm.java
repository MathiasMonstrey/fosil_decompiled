package com.misfit.ble.obfuscated;

import android.os.Bundle;
import com.misfit.ble.obfuscated.av.C4455a;
import com.misfit.ble.obfuscated.ba.C4463a;
import com.misfit.ble.obfuscated.ds.C4538a;
import com.misfit.ble.obfuscated.dz.C4545a;
import com.misfit.ble.obfuscated.ef.C4553a;
import com.misfit.ble.obfuscated.gh.C4573a;
import com.misfit.ble.setting.rmm.GoalTrackingSettings;
import com.misfit.ble.setting.uapp.UAppSystemVersion;
import com.misfit.ble.shine.ShineActionID;
import com.misfit.ble.shine.ShineConfiguration;
import com.misfit.ble.shine.ShineConnectionParameters;
import com.misfit.ble.shine.ShineProfile;
import com.misfit.ble.shine.ShineProfile.ActionResult;
import com.misfit.ble.shine.ShineProfile.ConfigurationCallback;
import com.misfit.ble.shine.ShineProfile.ResultCode;
import com.misfit.ble.shine.ShineProperty;
import com.misfit.ble.shine.controller.ConfigurationSession;
import com.misfit.ble.shine.firmware.Firmware;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class bm {
    private C4463a fG;

    public class C4494a extends ConfigurationSession {
        final /* synthetic */ bm ib;

        public C4494a(bm bmVar) {
            this.ib = bmVar;
            this.mShineConfiguration = new ShineConfiguration();
        }
    }

    public bm(C4463a c4463a) {
        this.fG = c4463a;
    }

    public ba m14945m(final ConfigurationCallback configurationCallback) {
        new de().ca();
        return new av(ShineActionID.SEND_DUMMY_FILE_LIST, "phaseSendDummyFileList", Arrays.asList(new ew[]{r0}), this.fG, new C4455a(this) {
            final /* synthetic */ bm ib;

            public void mo4826a(ba baVar, List<ew> list, ActionResult actionResult) {
                configurationCallback.onConfigCompleted(baVar.aR(), actionResult, new Hashtable());
            }
        }, new JSONObject[0]);
    }

    public ba m14946n(final ConfigurationCallback configurationCallback) {
        new cm().ca();
        return new av(ShineActionID.ACTIVATE, "phaseActivate", Arrays.asList(new ew[]{r0}), this.fG, new C4455a(this) {
            final /* synthetic */ bm ib;

            public void mo4826a(ba baVar, List<ew> list, ActionResult actionResult) {
                configurationCallback.onConfigCompleted(baVar.aR(), actionResult, new Hashtable());
            }
        }, new JSONObject[0]);
    }

    public ba m14947o(final ConfigurationCallback configurationCallback) {
        new cr().ca();
        return new av(ShineActionID.ANIMATE, "phasePlayAnimation", Arrays.asList(new ew[]{r0}), this.fG, new C4455a(this) {
            final /* synthetic */ bm ib;

            public void mo4826a(ba baVar, List<ew> list, ActionResult actionResult) {
                configurationCallback.onConfigCompleted(baVar.aR(), actionResult, new Hashtable());
            }
        }, new JSONObject[0]);
    }

    public ba m14948p(final ConfigurationCallback configurationCallback) {
        new gb().ca();
        return new av(ShineActionID.STOP_ANIMATING, "phaseStopPlayingAnimation", Arrays.asList(new ew[]{r0}), this.fG, new C4455a(this) {
            final /* synthetic */ bm ib;

            public void mo4826a(ba baVar, List<ew> list, ActionResult actionResult) {
                configurationCallback.onConfigCompleted(baVar.aR(), actionResult, new Hashtable());
            }
        }, new JSONObject[0]);
    }

    public ba m14949q(final ConfigurationCallback configurationCallback) {
        new cs().ca();
        return new av(ShineActionID.SYNC_ANIMATE, "phasePlaySyncAnimation", Arrays.asList(new ew[]{r0}), this.fG, new C4455a(this) {
            final /* synthetic */ bm ib;

            public void mo4826a(ba baVar, List<ew> list, ActionResult actionResult) {
                configurationCallback.onConfigCompleted(baVar.aR(), actionResult, new Hashtable());
            }
        }, new JSONObject[0]);
    }

    public ba m14950r(final ConfigurationCallback configurationCallback) {
        new dj().ca();
        return new av(ShineActionID.GET_ACTIVATION_STATE, "phaseGetActivationState", Arrays.asList(new ew[]{r0}), this.fG, new C4455a(this) {
            final /* synthetic */ bm ib;

            public void mo4826a(ba baVar, List<ew> list, ActionResult actionResult) {
                Hashtable hashtable = new Hashtable();
                if (actionResult.getResultCode() == ResultCode.SUCCEEDED) {
                    for (ew ewVar : list) {
                        if (ewVar instanceof dj) {
                            hashtable.put(ShineProperty.ACTIVATION_STATE, Boolean.valueOf(((dj) ewVar).cs().lr));
                        }
                    }
                }
                configurationCallback.onConfigCompleted(baVar.aR(), actionResult, hashtable);
            }
        }, new JSONObject[0]);
    }

    public ba m14951s(final ConfigurationCallback configurationCallback) {
        new ds().ca();
        return new av(ShineActionID.GET_CONNECTION_PARAMETERS, "phaseGetConnectionParameters", Arrays.asList(new ew[]{r0}), this.fG, new C4455a(this) {
            final /* synthetic */ bm ib;

            public void mo4826a(ba baVar, List<ew> list, ActionResult actionResult) {
                Hashtable hashtable = new Hashtable();
                if (actionResult.getResultCode() == ResultCode.SUCCEEDED) {
                    for (ew ewVar : list) {
                        if (ewVar instanceof ds) {
                            C4538a cC = ((ds) ewVar).cC();
                            hashtable.put(ShineProperty.CONNECTION_PARAMETERS, new ShineConnectionParameters(cC.lM, cC.lN, cC.lO));
                        }
                    }
                }
                configurationCallback.onConfigCompleted(baVar.aR(), actionResult, hashtable);
            }
        }, new JSONObject[0]);
    }

    public ba m14943a(Firmware firmware, final ConfigurationSession configurationSession, final ConfigurationCallback configurationCallback) {
        List arrayList = new ArrayList();
        if (!(configurationSession.mTimestamp == -1 && configurationSession.mPartialSecond == -1 && configurationSession.mTimeZoneOffset == (short) 1024)) {
            fy fyVar = new fy();
            fyVar.m15108a(configurationSession.mTimestamp, configurationSession.mPartialSecond, configurationSession.mTimeZoneOffset);
            arrayList.add(fyVar);
        }
        if (configurationSession.mShineConfiguration.mGoalValue != -1) {
            fs fsVar = new fs();
            fsVar.m15102f(configurationSession.mShineConfiguration.mGoalValue);
            arrayList.add(fsVar);
        }
        if (configurationSession.mShineConfiguration.mActivityPoint != -1) {
            fe feVar = new fe();
            feVar.m15088f(configurationSession.mShineConfiguration.mActivityPoint);
            arrayList.add(feVar);
        }
        if (configurationSession.mShineConfiguration.mClockState != (byte) -1) {
            fj fjVar = new fj();
            fjVar.m15093b(configurationSession.mShineConfiguration.mClockState);
            arrayList.add(fjVar);
        }
        if (configurationSession.mShineConfiguration.mTripleTapState != (byte) -1) {
            fz fzVar = new fz();
            fzVar.m15109e(configurationSession.mShineConfiguration.mTripleTapState > (byte) 0);
            arrayList.add(fzVar);
        }
        if (configurationSession.mShineConfiguration.mActivityTaggingState != (byte) -1) {
            boolean z;
            ff ffVar = new ff();
            if (configurationSession.mShineConfiguration.mActivityTaggingState > (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            ffVar.m15089e(z);
            arrayList.add(ffVar);
        }
        if (configurationSession.mShineConfiguration.mWristFlickStateEnable != ShineConfiguration.DEFAULT_WRIST_FLICK_STATE_ENABLE) {
            ga gaVar = new ga();
            gaVar.m15128e(configurationSession.mShineConfiguration.mWristFlickStateEnable.booleanValue());
            arrayList.add(gaVar);
        }
        if (configurationSession.mShineConfiguration.mGroupId != (short) -1) {
            cn cnVar = new cn();
            cnVar.m15019c(configurationSession.mShineConfiguration.mGroupId);
            arrayList.add(cnVar);
        }
        if (configurationSession.mShineConfiguration.mPasscode != ShineConfiguration.DEFAULT_PASSCODE) {
            fw fwVar = new fw();
            fwVar.m15106y(configurationSession.mShineConfiguration.mPasscode);
            arrayList.add(fwVar);
        }
        if (configurationSession.mShineConfiguration.mFlashButtonMode != ShineConfiguration.DEFAULT_FLASH_BUTTON_MODE) {
            fp fpVar = new fp();
            fpVar.m15099a(true, configurationSession.mShineConfiguration.mFlashButtonMode);
            arrayList.add(fpVar);
        }
        if (configurationSession.mShineConfiguration.mExtraAdvertisingDataStateEnable != ShineConfiguration.DEFAULT_EXTRA_ADVERTISING_DATA_STATE_ENABLE) {
            fo foVar = new fo();
            foVar.m15098e(configurationSession.mShineConfiguration.mExtraAdvertisingDataStateEnable.booleanValue());
            arrayList.add(foVar);
        }
        if (configurationSession.mShineConfiguration.mGoalTrackingSettings != ShineConfiguration.DEFAULT_GOAL_TRACKING_SETTINGS) {
            ft ftVar = new ft();
            ftVar.m15103a(configurationSession.mShineConfiguration.mGoalTrackingSettings.mGoalIdNumber, configurationSession.mShineConfiguration.mGoalTrackingSettings.mGoalTrackingState);
            arrayList.add(ftVar);
        }
        if (configurationSession.mShineConfiguration.mTimezoneOffset != (short) -1) {
            gv gvVar = new gv();
            gvVar.m15143c(configurationSession.mShineConfiguration.mTimezoneOffset);
            arrayList.add(gvVar);
        }
        if (configurationSession.mShineConfiguration.mCountdownSettings != ShineConfiguration.DEFAULT_COUNTDOWN_SETTINGS) {
            gq gqVar = new gq();
            gqVar.m15137a(configurationSession.mShineConfiguration.mCountdownSettings);
            arrayList.add(gqVar);
        }
        if (configurationSession.mShineConfiguration.mVibeStrength != (short) -1) {
            gx gxVar = new gx();
            gxVar.m15145c(configurationSession.mShineConfiguration.mVibeStrength);
            arrayList.add(gxVar);
        }
        if (configurationSession.mShineConfiguration.mGoalInSteps != -1) {
            fr frVar = new fr();
            frVar.m15101f(configurationSession.mShineConfiguration.mGoalInSteps);
            arrayList.add(frVar);
        }
        if (configurationSession.mShineConfiguration.mCurrentSteps != -1) {
            fm fmVar = new fm();
            fmVar.m15096f(configurationSession.mShineConfiguration.mCurrentSteps);
            arrayList.add(fmVar);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!ar.m14767a(firmware, (ew) it.next())) {
                it.remove();
            }
        }
        return new av(ShineActionID.SET_CONFIGURATION, "phaseSetDeviceConfiguration", arrayList, this.fG, new C4455a(this) {
            final /* synthetic */ bm ib;

            public void mo4826a(ba baVar, List<ew> list, ActionResult actionResult) {
                Hashtable hashtable = new Hashtable();
                hashtable.put(ShineProperty.SHINE_CONFIGURATION_SESSION, configurationSession);
                configurationCallback.onConfigCompleted(baVar.aR(), actionResult, hashtable);
                this.ib.fG.mo4916a(baVar, (long) ShineProfile.LOG_UPLOADING_DELAY);
            }
        }, configurationSession.toJSON());
    }

    public ba m14942a(Firmware firmware, final ConfigurationCallback configurationCallback, List<String> list) {
        List arrayList = new ArrayList();
        int i = (list == null || list.isEmpty()) ? true : 0;
        if (i != 0 || list.contains(ShineProfile.DEVICE_CONFIGURATION_TIME_KEY)) {
            ef efVar = new ef();
            efVar.ca();
            arrayList.add(efVar);
        }
        if (i != 0 || list.contains(ShineProfile.DEVICE_CONFIGURATION_GOAL_KEY)) {
            dy dyVar = new dy();
            dyVar.ca();
            arrayList.add(dyVar);
        }
        if (i != 0 || list.contains(ShineProfile.DEVICE_CONFIGURATION_ACTIVITY_POINT_KEY)) {
            dk dkVar = new dk();
            dkVar.ca();
            arrayList.add(dkVar);
        }
        if (i != 0 || list.contains(ShineProfile.DEVICE_CONFIGURATION_CLOCK_STATE_KEY)) {
            dq dqVar = new dq();
            dqVar.ca();
            arrayList.add(dqVar);
        }
        if (i != 0 || list.contains(ShineProfile.DEVICE_CONFIGURATION_TRIPLE_TAP_KEY)) {
            eg egVar = new eg();
            egVar.ca();
            arrayList.add(egVar);
        }
        if (i != 0 || list.contains(ShineProfile.DEVICE_CONFIGURATION_ACTIVITY_TAGGING_KEY)) {
            dl dlVar = new dl();
            dlVar.ca();
            arrayList.add(dlVar);
        }
        if (i != 0 || list.contains(ShineProfile.DEVICE_CONFIGURATION_BATTERY_KEY)) {
            dn dnVar = new dn();
            dnVar.ca();
            arrayList.add(dnVar);
        }
        if (i != 0 || list.contains(ShineProfile.DEVICE_CONFIGURATION_WRIST_FLICK_STATE_KEY)) {
            eh ehVar = new eh();
            ehVar.ca();
            arrayList.add(ehVar);
        }
        if (i != 0 || list.contains(ShineProfile.DEVICE_CONFIGURATION_GROUP_ID_KEY)) {
            ea eaVar = new ea();
            eaVar.ca();
            arrayList.add(eaVar);
        }
        if (i != 0 || list.contains(ShineProfile.DEVICE_CONFIGURATION_PASSCODE_KEY)) {
            ed edVar = new ed();
            edVar.ca();
            arrayList.add(edVar);
        }
        if (i != 0 || list.contains(ShineProfile.DEVICE_CONFIGURATION_FLASH_BUTTON_MODE_KEY)) {
            dv dvVar = new dv();
            dvVar.ca();
            arrayList.add(dvVar);
        }
        if (i != 0 || list.contains(ShineProfile.DEVICE_CONFIGURATION_EXTRA_ADVERTISING_DATA_STATE_KEY)) {
            du duVar = new du();
            duVar.ca();
            arrayList.add(duVar);
        }
        if (i != 0 || list.contains(ShineProfile.DEVICE_CONFIGURATION_GOAL_TRACKING_SETTINGS_KEY)) {
            dz dzVar = new dz();
            dzVar.ca();
            arrayList.add(dzVar);
        }
        if (i != 0 || list.contains(ShineProfile.DEVICE_CONFIGURATION_TIMEZONE_OFFSET_KEY)) {
            gl glVar = new gl();
            glVar.ca();
            arrayList.add(glVar);
        }
        if (i != 0 || list.contains(ShineProfile.DEVICE_CONFIGURATION_COUNTDOWN_SETTINGS_KEY)) {
            gj gjVar = new gj();
            gjVar.ca();
            arrayList.add(gjVar);
        }
        if (i != 0 || list.contains(ShineProfile.DEVICE_CONFIGURATION_VIBE_STRENGTH_KEY)) {
            gn gnVar = new gn();
            gnVar.ca();
            arrayList.add(gnVar);
        }
        if (i != 0 || list.contains(ShineProfile.DEVICE_CONFIGURATION_GOAL_IN_STEPS_KEY)) {
            dx dxVar = new dx();
            dxVar.ca();
            arrayList.add(dxVar);
        }
        if (i != 0 || list.contains(ShineProfile.DEVICE_CONFIGURATION_CURRENT_STEPS_KEY)) {
            dt dtVar = new dt();
            dtVar.ca();
            arrayList.add(dtVar);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!ar.m14767a(firmware, (ew) it.next())) {
                it.remove();
            }
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.misfit.ble.shine.controller.runOptionSkipFailRequest", true);
        return new av(ShineActionID.GET_CONFIGURATION, "phaseGetDeviceConfiguration", arrayList, this.fG, new C4455a(this) {
            final /* synthetic */ bm ib;

            public void mo4826a(ba baVar, List<ew> list, ActionResult actionResult) {
                Hashtable hashtable = new Hashtable();
                ConfigurationSession c4494a = new C4494a(this.ib);
                for (ew ewVar : list) {
                    if (ewVar.getResponse() != null) {
                        if (ewVar instanceof ef) {
                            C4553a cP = ((ef) ewVar).cP();
                            c4494a.mTimestamp = cP.timestamp;
                            c4494a.mPartialSecond = cP.mo;
                            c4494a.mTimeZoneOffset = cP.mp;
                        } else if (ewVar instanceof dy) {
                            c4494a.mShineConfiguration.mGoalValue = ((dy) ewVar).cI().mb;
                        } else if (ewVar instanceof dk) {
                            c4494a.mShineConfiguration.mActivityPoint = ((dk) ewVar).ct().lt;
                        } else if (ewVar instanceof dq) {
                            c4494a.mShineConfiguration.mClockState = ((dq) ewVar).cA().lI;
                        } else if (ewVar instanceof eg) {
                            c4494a.mShineConfiguration.mTripleTapState = (byte) (((eg) ewVar).cQ().mr ? 1 : 0);
                        } else if (ewVar instanceof dl) {
                            c4494a.mShineConfiguration.mActivityTaggingState = (byte) (((dl) ewVar).cu().lv ? 1 : 0);
                        } else if (ewVar instanceof dn) {
                            c4494a.mShineConfiguration.mBatteryLevel = ((dn) ewVar).cx().ly;
                        } else if (ewVar instanceof eh) {
                            c4494a.mShineConfiguration.mWristFlickStateEnable = Boolean.valueOf(((eh) ewVar).cR().mt);
                        } else if (ewVar instanceof ea) {
                            c4494a.mShineConfiguration.mGroupId = ((ea) ewVar).cK().mGroupId;
                        } else if (ewVar instanceof ed) {
                            c4494a.mShineConfiguration.mPasscode = ((ed) ewVar).cN().mPasscode;
                        } else if (ewVar instanceof dv) {
                            c4494a.mShineConfiguration.mFlashButtonMode = ((dv) ewVar).cF().lV;
                        } else if (ewVar instanceof du) {
                            c4494a.mShineConfiguration.mExtraAdvertisingDataStateEnable = Boolean.valueOf(((du) ewVar).cE().lS);
                        } else if (ewVar instanceof dz) {
                            C4545a cJ = ((dz) ewVar).cJ();
                            c4494a.mShineConfiguration.mGoalTrackingSettings = new GoalTrackingSettings(cJ.me, cJ.mf);
                        } else if (ewVar instanceof gl) {
                            c4494a.mShineConfiguration.mTimezoneOffset = ((gl) ewVar).dj().nD;
                        } else if (ewVar instanceof gj) {
                            c4494a.mShineConfiguration.mCountdownSettings = ((gj) ewVar).dh().nz;
                        } else if (ewVar instanceof gn) {
                            c4494a.mShineConfiguration.mVibeStrength = ((gn) ewVar).dl().nH;
                        } else if (ewVar instanceof dx) {
                            c4494a.mShineConfiguration.mGoalInSteps = ((dx) ewVar).cH().mb;
                        } else if (ewVar instanceof dt) {
                            c4494a.mShineConfiguration.mCurrentSteps = ((dt) ewVar).cD().lQ;
                        }
                    }
                }
                hashtable.put(ShineProperty.SHINE_CONFIGURATION_SESSION, c4494a);
                configurationCallback.onConfigCompleted(baVar.aR(), actionResult, hashtable);
                this.ib.fG.mo4916a(baVar, (long) ShineProfile.LOG_UPLOADING_DELAY);
            }
        }, bundle, new JSONObject[0]);
    }

    public ba m14952t(final ConfigurationCallback configurationCallback) {
        new gh().ca();
        return new av(ShineActionID.READ_UAPP_SYSTEM_VERSION, "phaseReadUAppSystemVersion", Arrays.asList(new ew[]{r0}), this.fG, new C4455a(this) {
            final /* synthetic */ bm ib;

            public void mo4826a(ba baVar, List<ew> list, ActionResult actionResult) {
                Hashtable hashtable = new Hashtable();
                if (actionResult.getResultCode() == ResultCode.SUCCEEDED) {
                    for (ew ewVar : list) {
                        if (ewVar instanceof gh) {
                            C4573a dg = ((gh) ewVar).dg();
                            hashtable.put(ShineProperty.UAPP_SYSTEM_VERSION, new UAppSystemVersion(hb.m15163c(dg.nw), hb.m15163c(dg.nx)));
                        }
                    }
                }
                configurationCallback.onConfigCompleted(baVar.aR(), actionResult, hashtable);
            }
        }, new JSONObject[0]);
    }

    public ba m14944c(byte b, final ConfigurationCallback configurationCallback) {
        new cl().m15018b(b);
        return new av(ShineActionID.SEND_ACK_NEW_HEARTBEAT, "phaseSendAckNewHeartbeat", Arrays.asList(new ew[]{r0}), this.fG, new C4455a(this) {
            final /* synthetic */ bm ib;

            public void mo4826a(ba baVar, List<ew> list, ActionResult actionResult) {
                configurationCallback.onConfigCompleted(baVar.aR(), actionResult, new Hashtable());
            }
        }, new JSONObject[0]);
    }
}
