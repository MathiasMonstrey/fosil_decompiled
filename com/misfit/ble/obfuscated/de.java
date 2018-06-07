package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.ble.util.LogUtils;
import com.misfit.frameworks.common.constants.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.apache.http.util.ByteArrayBuffer;
import org.json.JSONObject;

public class de extends ew {
    private byte gF = (byte) -1;
    private ByteArrayBuffer lb = new ByteArrayBuffer(20);
    private boolean lc = false;
    private boolean ld = false;
    private C4525a ll;

    public static class C4525a extends ey {
        public byte kT;
        public short lm;
        public long ln;
    }

    public /* synthetic */ ey getResponse() {
        return cp();
    }

    public String getRequestName() {
        return "fileList";
    }

    public C4525a cp() {
        return this.ll;
    }

    public String getCharacteristicUUID() {
        return "3dda0003-957f-7d4a-34a6-74696673696d";
    }

    public void ca() {
        ByteBuffer allocate = ByteBuffer.allocate(1);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, (byte) 5);
        this.mRequestData = allocate.array();
    }

    public void handleResponse(String str, byte[] bArr) {
        boolean z = true;
        if (this.mIsCompleted) {
            LogUtils.m15479l("ListFileRequest", "Skip response: " + bArr);
            return;
        }
        if (this.ll == null) {
            this.ll = m15047p(bArr);
            if (this.ll.result != (byte) 0) {
                this.mIsCompleted = true;
            }
        } else if (str.equals("3dda0004-957f-7d4a-34a6-74696673696d")) {
            byte b = (byte) (bArr[0] & 63);
            if (b != this.gF + 1) {
                LogUtils.m15479l("ListFileRequest", "WRONG sequence number: " + b + " - expected: " + (this.gF + 1));
                return;
            }
            this.gF = (byte) (this.gF + 1);
            this.lb.append(bArr, 1, bArr.length - 1);
            if ((bArr[0] & -128) != 0) {
                ByteBuffer wrap = ByteBuffer.wrap(this.lb.buffer());
                wrap.order(ByteOrder.LITTLE_ENDIAN);
                this.ll.lm = hb.m15163c(wrap.get(0));
                this.ll.ln = hb.m15169j(wrap.getInt(1));
                this.lc = true;
            }
        } else if (str.equals("3dda0003-957f-7d4a-34a6-74696673696d")) {
            if (bArr[0] == (byte) 8) {
                this.ld = true;
            } else {
                this.ll.result = (byte) 1;
                this.mIsCompleted = true;
            }
        }
        if (this.ll.result == (byte) 0) {
            if (!(this.ld && this.lc)) {
                z = false;
            }
            this.mIsCompleted = z;
        }
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.ll != null) {
                jSONObject.put(Constants.RESULT, this.ll.result);
                jSONObject.put("status", this.ll.kT);
                jSONObject.put("numberOfFiles", this.ll.lm);
                jSONObject.put("totalFileSize", this.ll.ln);
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public byte validateResponse(String str, byte[] bArr) {
        if (this.ll != null) {
            return (byte) 0;
        }
        return ew.validateResponse(bArr, (byte) 6);
    }

    private C4525a m15047p(byte[] bArr) {
        C4525a c4525a = new C4525a();
        c4525a.result = (byte) 0;
        c4525a.kT = (byte) 0;
        if (bArr.length <= 1) {
            c4525a.result = (byte) 1;
        } else {
            c4525a.kT = bArr[1];
            if (c4525a.kT != (byte) 0) {
                c4525a.result = (byte) 1;
            }
        }
        return c4525a;
    }

    public Event getEventID() {
        return Event.FILE_LIST;
    }
}
