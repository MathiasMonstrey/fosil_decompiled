package com.misfit.ble.setting.uapp;

import com.misfit.ble.obfuscated.C4462b;
import com.misfit.ble.setting.uapp.files.declaration.UAppDeclarationFrame;
import com.misfit.frameworks.common.constants.Constants;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class UAppEventSetting {
    private UAppEnum$UAppButtonEvent bt;
    private List<UAppDeclarationFrame> bu;

    public UAppEventSetting(UAppEnum$UAppButtonEvent uAppEnum$UAppButtonEvent, List<UAppDeclarationFrame> list) throws IllegalArgumentException {
        if (uAppEnum$UAppButtonEvent == null) {
            throw new IllegalArgumentException("buttonEvent must not be null.");
        } else if (list == null) {
            throw new IllegalArgumentException("declarationFrameList must not be null.");
        } else {
            this.bt = uAppEnum$UAppButtonEvent;
            this.bu = list;
        }
    }

    public UAppEnum$UAppButtonEvent getUAppButtonEvent() {
        return this.bt;
    }

    public List<UAppDeclarationFrame> getUAppDeclarationFrameList() {
        return this.bu;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof UAppEventSetting) && ((UAppEventSetting) obj).getUAppButtonEvent() == getUAppButtonEvent()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return getUAppButtonEvent().getId();
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject;
        Throwable th;
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put(Constants.EVENT, this.bt);
                JSONArray jSONArray = new JSONArray();
                for (UAppDeclarationFrame C : this.bu) {
                    jSONArray.put(C.m15251C());
                }
                jSONObject3.put("declarations", jSONArray);
                return jSONObject3;
            } catch (Throwable e) {
                Throwable th2 = e;
                jSONObject = jSONObject3;
                th = th2;
                C4462b.m14831a(th, "");
                return jSONObject;
            }
        } catch (Throwable e2) {
            th = e2;
            jSONObject = jSONObject2;
            C4462b.m14831a(th, "");
            return jSONObject;
        }
    }

    public String toString() {
        return toJSONObject().toString();
    }
}
