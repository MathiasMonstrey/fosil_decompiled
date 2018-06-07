package com.misfit.ble.obfuscated;

import com.misfit.ble.setting.flashlink.FlashButtonMode;
import com.misfit.ble.shine.error.ShineError.Event;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class fp extends ew {
    private FlashButtonMode mFlashButtonMode;
    private boolean nh;

    public String getRequestName() {
        return "setFlashButtonMode";
    }

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    public byte bZ() {
        return (byte) 7;
    }

    public byte cc() {
        return (byte) 10;
    }

    public void m15099a(boolean z, FlashButtonMode flashButtonMode) {
        int i = 1;
        this.nh = z;
        this.mFlashButtonMode = flashButtonMode;
        byte bZ = bZ();
        byte cc = cc();
        ByteBuffer allocate = ByteBuffer.allocate(5);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, (byte) 2);
        allocate.put(1, bZ);
        allocate.put(2, cc);
        if (!z) {
            i = 0;
        }
        allocate.put(3, (byte) i);
        allocate.put(4, hb.m15166e(flashButtonMode.getId()));
        this.mRequestData = allocate.array();
    }

    public JSONObject getRequestDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("activityTrackingEnabled", this.nh);
            jSONObject.put("flashButtonMode", this.mFlashButtonMode.getId());
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public void onRequestSent(int i) {
        this.mIsCompleted = true;
    }

    public Event getEventID() {
        return Event.SET_FLASH_BUTTON_MODE;
    }
}
