package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.ble.util.LogUtils;
import com.misfit.frameworks.common.constants.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class gf extends ew {
    private static final String TAG = LogUtils.m15475b(gf.class);
    private short f1553if;
    private C4571a nq;

    public static class C4571a extends ey {
        public byte kT;
        public short le;
        public long mA;
        public long nr;
    }

    public /* synthetic */ ey getResponse() {
        return de();
    }

    public C4571a de() {
        return this.nq;
    }

    public String getRequestName() {
        return "fileSettingGetSizeWritten";
    }

    public String getCharacteristicUUID() {
        return "3dda0007-957f-7d4a-34a6-74696673696d";
    }

    public void m15132c(short s) {
        this.f1553if = s;
        ByteBuffer allocate = ByteBuffer.allocate(3);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, (byte) 23);
        allocate.putShort(1, this.f1553if);
        this.mRequestData = allocate.array();
    }

    public byte validateResponse(String str, byte[] bArr) {
        if (ew.validateResponse(bArr, (byte) 23) != (byte) 0 || bArr.length < 4) {
            return (byte) 2;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        if (wrap.getShort(2) == this.f1553if) {
            return (byte) 0;
        }
        return (byte) 2;
    }

    public void handleResponse(String str, byte[] bArr) {
        this.nq = m15131A(bArr);
        if (this.nq != null) {
            this.mIsCompleted = true;
        }
    }

    protected C4571a m15131A(byte[] bArr) {
        if (bArr.length == 12) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            if (wrap.getShort(2) == this.f1553if) {
                C4571a c4571a = new C4571a();
                c4571a.kT = wrap.get(1);
                c4571a.mA = hb.m15169j(wrap.getInt(4));
                c4571a.nr = hb.m15169j(wrap.getInt(8));
                if (c4571a.kT == (byte) 0) {
                    c4571a.result = (byte) 0;
                    return c4571a;
                }
                c4571a.result = (byte) 1;
                return c4571a;
            }
        }
        return null;
    }

    public JSONObject getRequestDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.nq != null) {
                jSONObject.put("fileHandle", hb.m15164d(this.f1553if));
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.nq != null) {
                jSONObject.put(Constants.RESULT, this.nq.result);
                jSONObject.put("status", this.nq.kT);
                jSONObject.put("sizeWritten", this.nq.mA);
                jSONObject.put("previousOffset", this.nq.nr);
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public Event getEventID() {
        return Event.FILE_SETTING_GET_SIZE_WRITTEN;
    }
}
