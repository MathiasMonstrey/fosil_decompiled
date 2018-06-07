package com.misfit.ble.obfuscated;

import android.os.Handler;
import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.ble.util.LogUtils;
import com.misfit.frameworks.common.constants.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.apache.http.util.ByteArrayBuffer;
import org.json.JSONObject;

public class dd extends ew {
    private static final String TAG = LogUtils.m15475b(dd.class);
    private byte gF = (byte) -1;
    private short kQ;
    private ByteArrayBuffer lb = new ByteArrayBuffer(20);
    private boolean lc = false;
    private boolean ld = false;
    private C4520b lf;
    private int lg;
    private ba lh;
    private C4524a li;
    private Handler mHandler;
    private int mLength;

    public static class C4520b extends ey {
        public byte kT;
        public short kU;
    }

    class C4524a implements Runnable {
        private boolean iH = true;
        private ba lj;
        final /* synthetic */ dd lk;

        public C4524a(dd ddVar, ba baVar) {
            this.lk = ddVar;
            this.lj = baVar;
        }

        public void invalidate() {
            this.iH = false;
        }

        public void run() {
            if (this.iH && !this.lk.mIsCompleted) {
                this.lk.m15034j(this.lj);
            }
        }
    }

    public /* synthetic */ ey getResponse() {
        return cl();
    }

    public dd(ba baVar) {
        this.lh = baVar;
        if (this.mHandler == null) {
            this.mHandler = hd.m15181do();
        } else {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public String getRequestName() {
        return "fileGet";
    }

    public String getCharacteristicUUID() {
        return "3dda0003-957f-7d4a-34a6-74696673696d";
    }

    public int getTimeOut() {
        return 0;
    }

    public C4520b cl() {
        return this.lf;
    }

    public void mo4864k(byte[] bArr) {
    }

    public void m15035a(short s, int i, int i2) {
        this.kQ = s;
        this.lg = i;
        this.mLength = i2;
        ByteBuffer allocate = ByteBuffer.allocate(11);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, (byte) 1);
        allocate.putShort(1, s);
        allocate.putInt(3, i);
        allocate.putInt(7, i2);
        this.mRequestData = allocate.array();
    }

    public void handleResponse(String str, byte[] bArr) {
        boolean z = true;
        if (this.mIsCompleted) {
            LogUtils.m15479l(TAG, "Skip response: " + bArr);
            return;
        }
        if (this.lf == null) {
            this.lf = mo4865m(bArr);
            if (this.lf.result != (byte) 0) {
                co();
                this.mIsCompleted = true;
            }
        } else if (str.equals("3dda0004-957f-7d4a-34a6-74696673696d")) {
            byte b = (byte) (bArr[0] & 63);
            byte b2 = (byte) ((this.gF + 1) & 63);
            if (b != b2) {
                LogUtils.m15479l(TAG, "WRONG sequence number: " + b + " - expected: " + b2);
                return;
            }
            boolean z2;
            co();
            m15033i(this.lh);
            this.gF = b2;
            this.lb.append(bArr, 1, bArr.length - 1);
            if ((bArr[0] & -128) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                mo4864k(this.lb.toByteArray());
                this.lc = true;
            }
        } else if (str.equals("3dda0003-957f-7d4a-34a6-74696673696d")) {
            if (bArr.length <= 0 || bArr[0] != (byte) 8) {
                co();
                this.lf.result = (byte) 1;
                this.mIsCompleted = true;
            } else {
                co();
                if (this.lf.result != (byte) 0) {
                    this.mIsCompleted = true;
                } else {
                    this.ld = true;
                }
            }
        }
        if (this.lf.result == (byte) 0) {
            if (!(this.ld && this.lc)) {
                z = false;
            }
            this.mIsCompleted = z;
        }
    }

    public byte validateResponse(String str, byte[] bArr) {
        if (this.lf != null) {
            return (byte) 0;
        }
        return ew.validateResponse(bArr, (byte) 2);
    }

    protected C4520b mo4865m(byte[] bArr) {
        C4520b c4520b = new C4520b();
        c4520b.result = (byte) 0;
        c4520b.kT = (byte) 0;
        if (bArr.length < 4) {
            c4520b.result = (byte) 1;
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            c4520b.kU = wrap.getShort(1);
            c4520b.kT = wrap.get(3);
            if (!(c4520b.kU == this.kQ && c4520b.kT == (byte) 0)) {
                c4520b.result = (byte) 1;
            }
        }
        return c4520b;
    }

    public JSONObject getRequestDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("handle", hb.m15164d(this.kQ));
            jSONObject.put(Constants.JSON_KEY_OFFSET, this.lg);
            jSONObject.put("length", this.mLength);
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.lf != null) {
                jSONObject.put(Constants.RESULT, this.lf.result);
                jSONObject.put("status", this.lf.kT);
                jSONObject.put("handle", this.lf.kU);
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    private void m15033i(ba baVar) {
        this.li = new C4524a(this, baVar);
        this.mHandler.postDelayed(this.li, 5000);
    }

    private void co() {
        if (this.li != null) {
            this.mHandler.removeCallbacks(this.li);
            this.li.invalidate();
            this.li = null;
        }
    }

    private void m15034j(ba baVar) {
        baVar.aW();
    }

    public Event getEventID() {
        return Event.FILE_GET;
    }
}
