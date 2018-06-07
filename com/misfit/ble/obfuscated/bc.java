package com.misfit.ble.obfuscated;

import com.misfit.ble.obfuscated.av.C4455a;
import com.misfit.ble.obfuscated.ba.C4463a;
import com.misfit.ble.setting.qmotion.QMotionEnum.LEDColor;
import com.misfit.ble.shine.ShineActionID;
import com.misfit.ble.shine.ShineProfile.ActionResult;
import com.misfit.ble.shine.ShineProfile.ConfigurationCallback;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import org.json.JSONObject;

public class bc {
    private C4463a fG;

    public bc(C4463a c4463a) {
        this.fG = c4463a;
    }

    public ba m14876a(LEDColor lEDColor, boolean z, short s, int i, final ConfigurationCallback configurationCallback) {
        new es().m15075a(lEDColor, z, s, i);
        return new av(ShineActionID.PLAY_NOTIFICATION_FILTER_LED_ANIMATION, "phasePlayNotificationFilterLEDAnimation", Arrays.asList(new ew[]{r0}), this.fG, new C4455a(this) {
            final /* synthetic */ bc hN;

            public void mo4826a(ba baVar, List<ew> list, ActionResult actionResult) {
                configurationCallback.onConfigCompleted(baVar.aR(), actionResult, new Hashtable());
            }
        }, new JSONObject[0]);
    }

    public ba m14877a(boolean z, short s, int i, final ConfigurationCallback configurationCallback) {
        new et().m15076a(z, s, i);
        return new av(ShineActionID.PLAY_NOTIFICATION_FILTER_VIBRATION, "phasePlayNotificationFilterVibration", Arrays.asList(new ew[]{r0}), this.fG, new C4455a(this) {
            final /* synthetic */ bc hN;

            public void mo4826a(ba baVar, List<ew> list, ActionResult actionResult) {
                configurationCallback.onConfigCompleted(baVar.aR(), actionResult, new Hashtable());
            }
        }, new JSONObject[0]);
    }
}
