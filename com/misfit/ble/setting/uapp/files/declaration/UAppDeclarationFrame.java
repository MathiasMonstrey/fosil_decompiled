package com.misfit.ble.setting.uapp.files.declaration;

import com.misfit.ble.obfuscated.C4462b;
import com.misfit.ble.obfuscated.C4594u;
import com.misfit.ble.obfuscated.C4597w;
import com.misfit.ble.obfuscated.hd;
import com.misfit.ble.setting.uapp.UAppEnum.UAppID;
import com.misfit.ble.setting.uapp.UAppEnum.UAppVariant;
import com.misfit.ble.setting.uapp.files.customization.UAppCustomizationFrame;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import org.json.JSONObject;

public class UAppDeclarationFrame {
    private UAppCustomizationFrame cb;
    private byte[] cc;
    private byte cd;

    public UAppDeclarationFrame(byte[] bArr) throws IllegalArgumentException {
        if (bArr == null) {
            throw new IllegalArgumentException("data must not be null.");
        }
        this.cc = bArr;
        this.cd = (byte) 0;
    }

    public UAppDeclarationFrame(byte[] bArr, byte b) throws IllegalArgumentException {
        if (bArr == null) {
            throw new IllegalArgumentException("data must not be null.");
        }
        this.cc = bArr;
        this.cd = b;
    }

    public UAppDeclarationFrame setCustomization(UAppCustomizationFrame uAppCustomizationFrame) throws IllegalArgumentException {
        if (uAppCustomizationFrame == null) {
            throw new IllegalArgumentException("uAppCustomizationFrame must not be null.");
        }
        this.cb = uAppCustomizationFrame;
        this.cb.m15247a(m15252E());
        return this;
    }

    public byte[] getData() {
        return this.cc;
    }

    private short m15250L() {
        if (this.cc == null || this.cc.length < 15) {
            return (short) -1;
        }
        ByteBuffer wrap = ByteBuffer.wrap(this.cc);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        return wrap.getShort(3);
    }

    public C4594u m15252E() {
        return new C4594u(m15250L(), getUAppVersion(), this.cd);
    }

    public UAppID getUAppId() {
        return C4597w.m15232a(m15250L());
    }

    public UAppVariant getUAppVariant() {
        return C4597w.m15233b(m15250L());
    }

    public byte getUAppVersion() {
        if (this.cc == null || this.cc.length < 15) {
            return (byte) -1;
        }
        return this.cc[2];
    }

    public byte getUAppVariation() {
        return this.cd;
    }

    public boolean isCustomizationRequired() {
        if (this.cc == null || this.cc.length < 15) {
            return false;
        }
        ByteBuffer wrap = ByteBuffer.wrap(Arrays.copyOfRange(this.cc, 7, 9));
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        if (wrap.getShort(0) > (short) 0) {
            return true;
        }
        return false;
    }

    public UAppCustomizationFrame getCustomizationFrame() {
        return this.cb;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof UAppDeclarationFrame) && ((UAppDeclarationFrame) obj).m15250L() == m15250L()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return m15250L();
    }

    public JSONObject m15251C() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uAppId", getUAppId());
            jSONObject.put("uAppVariant", getUAppVariant());
            jSONObject.put("uAppDeclarationId", m15250L());
            jSONObject.put("CRC", hd.m15176a(this.cc.length, this.cc));
            jSONObject.put("variation", this.cd);
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public String toString() {
        return m15251C().toString();
    }
}
