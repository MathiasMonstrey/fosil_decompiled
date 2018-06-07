package com.misfit.ble.obfuscated;

import com.misfit.ble.obfuscated.ba.C4463a;
import com.misfit.ble.setting.uapp.UAppNotification;
import com.misfit.ble.setting.uapp.UAppSystemVersion;
import com.misfit.ble.setting.uapp.instruction.UAppInstruction;
import com.misfit.ble.shine.ShineActionID;
import com.misfit.ble.shine.ShineProfile.DataTransferCallback;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class bf extends bs {
    private List<UAppInstruction> bP;
    private UAppNotification bQ;

    public bf(C4463a c4463a, DataTransferCallback dataTransferCallback, UAppSystemVersion uAppSystemVersion, UAppNotification uAppNotification, List<UAppInstruction> list) throws IllegalArgumentException {
        super(ShineActionID.SEND_UAPP_REMOTE_ACTIVITY, "phaseSendUAppRemoteActivity", c4463a, dataTransferCallback, uAppSystemVersion);
        if (list == null) {
            throw new IllegalArgumentException("instructions must not be null.");
        }
        this.bQ = uAppNotification;
        this.bP = list;
        aZ();
        this.iQ = false;
    }

    private void aZ() throws IllegalArgumentException {
        m14907a((short) 2560, Arrays.asList(new byte[][]{new C4599z(this.bM, this.bQ, this.bP).m14674F()}));
    }

    protected long ba() {
        return 10000;
    }

    public JSONObject aH() {
        JSONObject aH = super.aH();
        try {
            aH.put("UAppNotification", this.bQ == null ? null : this.bQ.toJSONObject());
            JSONArray jSONArray = new JSONArray();
            for (UAppInstruction toJSONObject : this.bP) {
                jSONArray.put(toJSONObject.toJSONObject());
            }
            aH.put("instructions", jSONArray);
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return aH;
    }
}
