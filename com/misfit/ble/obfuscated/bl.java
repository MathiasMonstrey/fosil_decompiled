package com.misfit.ble.obfuscated;

import com.misfit.ble.obfuscated.ba.C4463a;
import com.misfit.ble.setting.uapp.UAppEventSetting;
import com.misfit.ble.setting.uapp.UAppSystemVersion;
import com.misfit.ble.shine.ShineActionID;
import com.misfit.ble.shine.ShineProfile.DataTransferCallback;
import java.util.Arrays;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class bl extends bs {
    private Set<UAppEventSetting> ia;

    public bl(C4463a c4463a, DataTransferCallback dataTransferCallback, UAppSystemVersion uAppSystemVersion, Set<UAppEventSetting> set) throws IllegalArgumentException {
        super(ShineActionID.SET_UAPP_CONFIGURATION, "phaseSetUAppConfiguration", c4463a, dataTransferCallback, uAppSystemVersion);
        this.ia = set;
        bg();
    }

    private void bg() throws IllegalArgumentException {
        m14907a((short) 2048, Arrays.asList(new byte[][]{new aa(this.bM, this.ia).m14674F()}));
    }

    public JSONObject aH() {
        JSONObject aH = super.aH();
        try {
            JSONArray jSONArray = new JSONArray();
            for (UAppEventSetting toJSONObject : this.ia) {
                jSONArray.put(toJSONObject.toJSONObject());
            }
            aH.put("UAppEventSetting", jSONArray);
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return aH;
    }
}
