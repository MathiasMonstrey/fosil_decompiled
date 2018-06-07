package com.misfit.ble.obfuscated;

import com.fossil.wearables.fsl.shared.BaseFeatureModel;
import com.misfit.ble.setting.pluto.InactivityNudgeSettings;
import com.misfit.ble.shine.error.ShineError.Event;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class fu extends ew {
    private InactivityNudgeSettings nj;

    public String getRequestName() {
        return "setInactivityNudge";
    }

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    private byte cb() {
        return (byte) 2;
    }

    public byte bZ() {
        return (byte) 3;
    }

    public byte cc() {
        return (byte) 3;
    }

    public byte ce() {
        return (byte) 1;
    }

    public void m15104a(InactivityNudgeSettings inactivityNudgeSettings) {
        this.nj = inactivityNudgeSettings;
        ByteBuffer allocate = ByteBuffer.allocate(13);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, cb());
        allocate.put(1, bZ());
        allocate.put(2, cc());
        allocate.put(3, ce());
        allocate.put(4, hb.m15167f(this.nj.getEnabled()));
        allocate.put(5, hb.m15166e(this.nj.getLEDSequence().getValue()));
        allocate.put(6, hb.m15166e(this.nj.getVibeSequence().getValue()));
        allocate.put(7, hb.m15166e(this.nj.getSoundSequence().getValue()));
        allocate.put(8, hb.m15166e(this.nj.getStartHour()));
        allocate.put(9, hb.m15166e(this.nj.getStartMinute()));
        allocate.put(10, hb.m15166e(this.nj.getEndHour()));
        allocate.put(11, hb.m15166e(this.nj.getEndMinute()));
        allocate.put(12, hb.m15166e(this.nj.getRepeatIntervalInMinute()));
        this.mRequestData = allocate.array();
    }

    public JSONObject getRequestDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(BaseFeatureModel.COLUMN_ENABLED, this.nj.getEnabled());
            jSONObject.put("ledSequenceID", this.nj.getLEDSequence());
            jSONObject.put("vibeSequenceID", this.nj.getVibeSequence());
            jSONObject.put("soundSequenceID", this.nj.getSoundSequence());
            jSONObject.put("startHour", this.nj.getStartHour());
            jSONObject.put("startMinute", this.nj.getStartMinute());
            jSONObject.put("endHour", this.nj.getEndHour());
            jSONObject.put("endMinute", this.nj.getEndMinute());
            jSONObject.put("repeatIntervalMinutes", this.nj.getRepeatIntervalInMinute());
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public void onRequestSent(int i) {
        this.mIsCompleted = true;
    }

    public Event getEventID() {
        return Event.SETUP_INACTIVITY_NUDGE;
    }
}
