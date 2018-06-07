package com.fossil;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.fitness.data.MapValue;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public final class baf extends auq {
    public static final Creator<baf> CREATOR = new bag();
    private int[] boA;
    private float[] boB;
    private byte[] boC;
    private boolean box;
    private String boy;
    private Map<String, MapValue> boz;
    private final int format;
    private float value;
    private final int versionCode;

    public baf(int i) {
        this(3, i, false, 0.0f, null, null, null, null, null);
    }

    baf(int i, int i2, boolean z, float f, String str, Bundle bundle, int[] iArr, float[] fArr, byte[] bArr) {
        Map map;
        this.versionCode = i;
        this.format = i2;
        this.box = z;
        this.value = f;
        this.boy = str;
        if (bundle == null) {
            map = null;
        } else {
            bundle.setClassLoader(MapValue.class.getClassLoader());
            Map jlVar = new jl(bundle.size());
            for (String str2 : bundle.keySet()) {
                jlVar.put(str2, (MapValue) bundle.getParcelable(str2));
            }
            map = jlVar;
        }
        this.boz = map;
        this.boA = iArr;
        this.boB = fArr;
        this.boC = bArr;
    }

    public final float Mm() {
        awa.m4634a(this.format == 2, "Value is not in float format");
        return this.value;
    }

    public final boolean Mn() {
        return this.box;
    }

    public final int Mo() {
        boolean z = true;
        if (this.format != 1) {
            z = false;
        }
        awa.m4634a(z, "Value is not in int format");
        return Float.floatToRawIntBits(this.value);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof baf)) {
                return false;
            }
            boolean z;
            baf com_fossil_baf = (baf) obj;
            if (this.format == com_fossil_baf.format && this.box == com_fossil_baf.box) {
                switch (this.format) {
                    case 1:
                        if (Mo() != com_fossil_baf.Mo()) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    case 2:
                        if (this.value != com_fossil_baf.value) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    case 3:
                        z = avx.equal(this.boy, com_fossil_baf.boy);
                        break;
                    case 4:
                        z = avx.equal(this.boz, com_fossil_baf.boz);
                        break;
                    case 5:
                        z = Arrays.equals(this.boA, com_fossil_baf.boA);
                        break;
                    case 6:
                        z = Arrays.equals(this.boB, com_fossil_baf.boB);
                        break;
                    case 7:
                        z = Arrays.equals(this.boC, com_fossil_baf.boC);
                        break;
                    default:
                        if (this.value != com_fossil_baf.value) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                }
            }
            z = false;
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public final int getFormat() {
        return this.format;
    }

    public final void hG(int i) {
        awa.m4634a(this.format == 1, "Attempting to set an int value to a field that is not in INT32 format.  Please check the data type definition and use the right format.");
        this.box = true;
        this.value = Float.intBitsToFloat(i);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.value), this.boy, this.boz, this.boA, this.boB, this.boC});
    }

    public final String toString() {
        if (!this.box) {
            return "unset";
        }
        switch (this.format) {
            case 1:
                return Integer.toString(Mo());
            case 2:
                return Float.toString(this.value);
            case 3:
                return this.boy;
            case 4:
                return new TreeMap(this.boz).toString();
            case 5:
                return Arrays.toString(this.boA);
            case 6:
                return Arrays.toString(this.boB);
            case 7:
                return axp.m4685a(this.boC, 0, this.boC.length, false);
            default:
                return "unknown";
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Bundle bundle;
        int A = aus.m4537A(parcel);
        aus.m4565c(parcel, 1, getFormat());
        aus.m4556a(parcel, 2, Mn());
        aus.m4543a(parcel, 3, this.value);
        aus.m4554a(parcel, 4, this.boy, false);
        if (this.boz == null) {
            bundle = null;
        } else {
            Bundle bundle2 = new Bundle(this.boz.size());
            for (Entry entry : this.boz.entrySet()) {
                bundle2.putParcelable((String) entry.getKey(), (Parcelable) entry.getValue());
            }
            bundle = bundle2;
        }
        aus.m4545a(parcel, 5, bundle, false);
        aus.m4559a(parcel, 6, this.boA, false);
        aus.m4558a(parcel, 7, this.boB, false);
        aus.m4565c(parcel, 1000, this.versionCode);
        aus.m4557a(parcel, 8, this.boC, false);
        aus.m4540G(parcel, A);
    }
}
