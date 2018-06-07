package com.misfit.ble.setting.uapp;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.misfit.ble.obfuscated.C4462b;
import com.misfit.ble.obfuscated.C4594u;
import com.misfit.ble.obfuscated.C4597w;
import com.misfit.ble.obfuscated.hb;
import com.misfit.ble.setting.uapp.UAppEnum.UAppID;
import com.misfit.ble.setting.uapp.UAppEnum.UAppVariant;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class UAppNotification implements Parcelable {
    public static final Creator<UAppNotification> CREATOR = new C46021();
    private UAppEnum$UAppSystemLevelEvent bA;
    private byte bB;
    private C4604a bC;
    private short bv;
    private byte bw;
    private byte bx;
    private byte by;
    private byte bz;

    static class C46021 implements Creator<UAppNotification> {
        C46021() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m15239a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m15240b(i);
        }

        public UAppNotification m15239a(Parcel parcel) {
            return new UAppNotification(parcel);
        }

        public UAppNotification[] m15240b(int i) {
            return new UAppNotification[i];
        }
    }

    enum C4604a {
        SUCCESS((byte) 0),
        TIMEOUT((byte) 1);
        
        private static final Map<Byte, C4604a> aD = null;
        private final byte ax;

        static {
            aD = new HashMap();
            Iterator it = EnumSet.allOf(C4604a.class).iterator();
            while (it.hasNext()) {
                C4604a c4604a = (C4604a) it.next();
                aD.put(Byte.valueOf(c4604a.getId()), c4604a);
            }
        }

        private C4604a(byte b) {
            this.ax = b;
        }

        public static C4604a m15241a(byte b) {
            return (C4604a) aD.get(Byte.valueOf(b));
        }

        public byte getId() {
            return this.ax;
        }
    }

    public UAppNotification(byte[] bArr) throws IllegalArgumentException {
        if (bArr == null) {
            throw new IllegalArgumentException("data must not be null.");
        } else if (bArr.length != 9) {
            throw new IllegalArgumentException("data has invalid length.");
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            this.bw = bArr[0];
            this.bv = wrap.getShort(1);
            this.bx = bArr[3];
            this.by = bArr[4];
            this.bz = bArr[5];
            this.bA = UAppEnum$UAppSystemLevelEvent.get(bArr[6]);
            this.bB = bArr[7];
            this.bC = C4604a.m15241a(bArr[8]);
        }
    }

    public byte[] m15243D() {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(m15242E().getData());
        allocate.put(this.by);
        allocate.put(this.bz);
        allocate.put(this.bA.getId());
        allocate.put(this.bB);
        return allocate.array();
    }

    public UAppID getUAppId() {
        return C4597w.m15232a(this.bv);
    }

    public UAppVariant getUAppVariant() {
        return C4597w.m15233b(this.bv);
    }

    public byte getUAppVersion() {
        return this.bw;
    }

    public byte getUAppVariation() {
        return this.bx;
    }

    private C4594u m15242E() {
        return new C4594u(this.bv, this.bw, this.bx);
    }

    public UAppEnum$UAppSystemLevelEvent getUAppSystemEvent() {
        return this.bA;
    }

    public UAppEnum$UAppError getUAppError() {
        switch (this.bC) {
            case TIMEOUT:
                return UAppEnum$UAppError.TIMEOUT;
            default:
                return null;
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof UAppNotification) {
            UAppNotification uAppNotification = (UAppNotification) obj;
            if (this.bv == uAppNotification.bv && this.bw == uAppNotification.bw && this.bx == uAppNotification.bx && this.by == uAppNotification.by && this.bz == uAppNotification.bz && this.bA == uAppNotification.bA && this.bB == uAppNotification.bB && this.bC == uAppNotification.bC) {
                return true;
            }
        }
        return false;
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uAppDeclarationId", this.bv);
            jSONObject.put("uAppId", getUAppId());
            jSONObject.put("uAppVariant", getUAppVariant());
            jSONObject.put("uAppVersion", this.bw);
            jSONObject.put("uAppVariation", this.bx);
            jSONObject.put("contextTransitionNumber", hb.m15163c(this.by));
            jSONObject.put("activityId", hb.m15163c(this.bz));
            jSONObject.put("systemEventId", this.bA);
            jSONObject.put("eventOccurrenceNumber", hb.m15163c(this.bB));
            jSONObject.put("uAppEventType", this.bC);
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public String toString() {
        return toJSONObject().toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        bundle.putShort("uapp_declaration_id", this.bv);
        bundle.putByte("uapp_version", this.bw);
        bundle.putByte("uapp_variation", this.bx);
        bundle.putByte("context_transition_number", this.by);
        bundle.putByte("activity_id", this.bz);
        bundle.putByte("uapp_system_level_event", this.bA.getId());
        bundle.putByte("event_occurrence_number", this.bB);
        bundle.putByte("uapp_event_type", this.bC.getId());
        parcel.writeBundle(bundle);
    }

    private UAppNotification(Parcel parcel) {
        Bundle readBundle = parcel.readBundle();
        if (readBundle != null) {
            this.bv = readBundle.getShort("uapp_declaration_id", (short) -1);
            this.bw = readBundle.getByte("uapp_version", (byte) -1).byteValue();
            this.bx = readBundle.getByte("uapp_variation", (byte) -1).byteValue();
            this.by = readBundle.getByte("context_transition_number");
            this.bz = readBundle.getByte("activity_id");
            this.bA = UAppEnum$UAppSystemLevelEvent.get(readBundle.getByte("uapp_system_level_event"));
            this.bB = readBundle.getByte("event_occurrence_number");
            this.bC = C4604a.m15241a(readBundle.getByte("uapp_event_type"));
        }
    }
}
