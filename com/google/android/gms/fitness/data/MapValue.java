package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.fossil.auq;
import com.fossil.aus;
import com.fossil.awa;
import com.fossil.bat;
import com.google.android.gms.common.internal.ReflectedParcelable;

public class MapValue extends auq implements ReflectedParcelable {
    public static final Creator<MapValue> CREATOR = new bat();
    private final int ber;
    private final int boo;
    private final float bop;

    public MapValue(int i, int i2, float f) {
        this.ber = i;
        this.boo = i2;
        this.bop = f;
    }

    public final float Mm() {
        awa.a(this.boo == 2, "Value is not in float format");
        return this.bop;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof MapValue)) {
                return false;
            }
            boolean z;
            MapValue mapValue = (MapValue) obj;
            if (this.boo == mapValue.boo) {
                switch (this.boo) {
                    case 2:
                        if (Mm() != mapValue.Mm()) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    default:
                        if (this.bop != mapValue.bop) {
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

    public int hashCode() {
        return (int) this.bop;
    }

    public String toString() {
        switch (this.boo) {
            case 2:
                return Float.toString(Mm());
            default:
                return "unknown";
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        int A = aus.A(parcel);
        aus.c(parcel, 1, this.boo);
        aus.a(parcel, 2, this.bop);
        aus.c(parcel, 1000, this.ber);
        aus.G(parcel, A);
    }
}
