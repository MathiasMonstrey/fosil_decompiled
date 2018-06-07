package com.misfit.ble.obfuscated;

import com.fossil.wearables.fsl.shared.BaseFeatureModel;
import com.misfit.ble.setting.qmotion.QMotionEnum.LEDColor;
import com.misfit.ble.setting.sam.HandControl;
import com.misfit.ble.setting.sam.SAMEnum.VibeEnum;
import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.frameworks.common.constants.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class go extends ew {
    private LEDColor mS;
    private byte nI;
    private VibeEnum nJ;
    private int nK;
    private List<HandControl> nL;

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    private byte cb() {
        return (byte) 2;
    }

    public byte bZ() {
        return (byte) 7;
    }

    public byte cc() {
        return (byte) 15;
    }

    public byte ce() {
        return (byte) 10;
    }

    public String getRequestName() {
        return "sendNotificationHandControl";
    }

    public void m15136a(LEDColor lEDColor, byte b, VibeEnum vibeEnum, int i, List<HandControl> list) {
        this.mS = lEDColor;
        this.nI = b;
        this.nJ = vibeEnum;
        this.nK = i;
        this.nL = list;
        ByteBuffer allocate = ByteBuffer.allocate((list.size() * 2) + 10);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(cb());
        allocate.put(bZ());
        allocate.put(cc());
        allocate.put(ce());
        allocate.put((byte) ((hb.m15166e(lEDColor.getId()) << 4) | (b & 15)));
        allocate.put(vibeEnum.getId());
        allocate.put((byte) 5);
        allocate.put((byte) ((list.size() * 2) + 2));
        allocate.putShort(hb.m15170k(i));
        for (HandControl handControl : list) {
            allocate.putShort((short) (((handControl.getDegrees() & 511) & 65535) | (handControl.getHandID().getId() << 12)));
        }
        this.mRequestData = allocate.array();
    }

    public JSONObject getRequestDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(BaseFeatureModel.COLUMN_COLOR, this.mS);
            jSONObject.put("blinkNum", this.nI);
            jSONObject.put("vibeNum", this.nJ);
            jSONObject.put(Constants.DURATION, this.nK);
            JSONArray jSONArray = new JSONArray();
            for (HandControl toJSON : this.nL) {
                jSONArray.put(toJSON.toJSON());
            }
            jSONObject.put("handControls", jSONArray);
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public void onRequestSent(int i) {
        this.mIsCompleted = true;
    }

    public Event getEventID() {
        return Event.PLAY_NOTIFICATION_WITH_ANIMATION;
    }
}
