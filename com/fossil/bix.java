package com.fossil;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import com.google.android.gms.common.internal.safeparcel.zzc;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class bix extends bip {
    public static final Creator<bix> CREATOR = new biy();
    private final String JY;
    private final int ber;
    private final bis bvB;
    private final Parcel bvI;
    private final int bvJ = 2;
    private int bvK;
    private int bvL;

    bix(int i, Parcel parcel, bis com_fossil_bis) {
        this.ber = i;
        this.bvI = (Parcel) awa.bO(parcel);
        this.bvB = com_fossil_bis;
        if (this.bvB == null) {
            this.JY = null;
        } else {
            this.JY = this.bvB.OD();
        }
        this.bvK = 2;
    }

    private Parcel OF() {
        switch (this.bvK) {
            case 0:
                this.bvL = aus.m4537A(this.bvI);
                break;
            case 1:
                break;
        }
        aus.m4540G(this.bvI, this.bvL);
        this.bvK = 2;
        return this.bvI;
    }

    private static void m5212a(StringBuilder stringBuilder, int i, Object obj) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                stringBuilder.append(obj);
                return;
            case 7:
                stringBuilder.append("\"").append(axr.di(obj.toString())).append("\"");
                return;
            case 8:
                stringBuilder.append("\"").append(axk.encode((byte[]) obj)).append("\"");
                return;
            case 9:
                stringBuilder.append("\"").append(axk.ac((byte[]) obj));
                stringBuilder.append("\"");
                return;
            case 10:
                axs.m4686a(stringBuilder, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown type = " + i);
        }
    }

    private final void m5213a(StringBuilder stringBuilder, bin<?, ?> com_fossil_bin___, Parcel parcel, int i) {
        double[] dArr = null;
        int i2 = 0;
        int length;
        if (com_fossil_bin___.bvw) {
            stringBuilder.append("[");
            int dataPosition;
            switch (com_fossil_bin___.bvv) {
                case 0:
                    int[] u = aur.m4530u(parcel, i);
                    length = u.length;
                    while (i2 < length) {
                        if (i2 != 0) {
                            stringBuilder.append(",");
                        }
                        stringBuilder.append(Integer.toString(u[i2]));
                        i2++;
                    }
                    break;
                case 1:
                    Object[] objArr;
                    length = aur.m4504a(parcel, i);
                    dataPosition = parcel.dataPosition();
                    if (length != 0) {
                        int readInt = parcel.readInt();
                        objArr = new BigInteger[readInt];
                        while (i2 < readInt) {
                            objArr[i2] = new BigInteger(parcel.createByteArray());
                            i2++;
                        }
                        parcel.setDataPosition(length + dataPosition);
                    }
                    axj.m4681a(stringBuilder, objArr);
                    break;
                case 2:
                    axj.m4680a(stringBuilder, aur.m4531v(parcel, i));
                    break;
                case 3:
                    axj.m4679a(stringBuilder, aur.m4532w(parcel, i));
                    break;
                case 4:
                    length = aur.m4504a(parcel, i);
                    i2 = parcel.dataPosition();
                    if (length != 0) {
                        dArr = parcel.createDoubleArray();
                        parcel.setDataPosition(length + i2);
                    }
                    axj.m4678a(stringBuilder, dArr);
                    break;
                case 5:
                    axj.m4681a(stringBuilder, aur.m4533x(parcel, i));
                    break;
                case 6:
                    axj.m4683a(stringBuilder, aur.m4529t(parcel, i));
                    break;
                case 7:
                    axj.m4682a(stringBuilder, aur.m4534y(parcel, i));
                    break;
                case 8:
                case 9:
                case 10:
                    throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                case 11:
                    Parcel[] C = aur.m4502C(parcel, i);
                    dataPosition = C.length;
                    for (int i3 = 0; i3 < dataPosition; i3++) {
                        if (i3 > 0) {
                            stringBuilder.append(",");
                        }
                        C[i3].setDataPosition(0);
                        m5214a(stringBuilder, com_fossil_bin___.OB(), C[i3]);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unknown field type out.");
            }
            stringBuilder.append("]");
            return;
        }
        switch (com_fossil_bin___.bvv) {
            case 0:
                stringBuilder.append(aur.m4515f(parcel, i));
                return;
            case 1:
                stringBuilder.append(aur.m4519j(parcel, i));
                return;
            case 2:
                stringBuilder.append(aur.m4517h(parcel, i));
                return;
            case 3:
                stringBuilder.append(aur.m4520k(parcel, i));
                return;
            case 4:
                stringBuilder.append(aur.m4522m(parcel, i));
                return;
            case 5:
                stringBuilder.append(aur.m4524o(parcel, i));
                return;
            case 6:
                stringBuilder.append(aur.m4512c(parcel, i));
                return;
            case 7:
                stringBuilder.append("\"").append(axr.di(aur.m4525p(parcel, i))).append("\"");
                return;
            case 8:
                stringBuilder.append("\"").append(axk.encode(aur.m4528s(parcel, i))).append("\"");
                return;
            case 9:
                stringBuilder.append("\"").append(axk.ac(aur.m4528s(parcel, i)));
                stringBuilder.append("\"");
                return;
            case 10:
                Bundle r = aur.m4527r(parcel, i);
                Set<String> keySet = r.keySet();
                keySet.size();
                stringBuilder.append("{");
                length = 1;
                for (String str : keySet) {
                    if (length == 0) {
                        stringBuilder.append(",");
                    }
                    stringBuilder.append("\"").append(str).append("\"");
                    stringBuilder.append(":");
                    stringBuilder.append("\"").append(axr.di(r.getString(str))).append("\"");
                    length = 0;
                }
                stringBuilder.append("}");
                return;
            case 11:
                Parcel B = aur.m4501B(parcel, i);
                B.setDataPosition(0);
                m5214a(stringBuilder, com_fossil_bin___.OB(), B);
                return;
            default:
                throw new IllegalStateException("Unknown field type out");
        }
    }

    private final void m5214a(StringBuilder stringBuilder, Map<String, bin<?, ?>> map, Parcel parcel) {
        Entry entry;
        SparseArray sparseArray = new SparseArray();
        for (Entry entry2 : map.entrySet()) {
            sparseArray.put(((bin) entry2.getValue()).bvy, entry2);
        }
        stringBuilder.append('{');
        int z = aur.m4535z(parcel);
        Object obj = null;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            entry2 = (Entry) sparseArray.get(65535 & readInt);
            if (entry2 != null) {
                if (obj != null) {
                    stringBuilder.append(",");
                }
                String str = (String) entry2.getKey();
                bin com_fossil_bin = (bin) entry2.getValue();
                stringBuilder.append("\"").append(str).append("\":");
                if (com_fossil_bin.OA()) {
                    switch (com_fossil_bin.bvv) {
                        case 0:
                            m5215b(stringBuilder, com_fossil_bin, bim.m5199a(com_fossil_bin, Integer.valueOf(aur.m4515f(parcel, readInt))));
                            break;
                        case 1:
                            m5215b(stringBuilder, com_fossil_bin, bim.m5199a(com_fossil_bin, aur.m4519j(parcel, readInt)));
                            break;
                        case 2:
                            m5215b(stringBuilder, com_fossil_bin, bim.m5199a(com_fossil_bin, Long.valueOf(aur.m4517h(parcel, readInt))));
                            break;
                        case 3:
                            m5215b(stringBuilder, com_fossil_bin, bim.m5199a(com_fossil_bin, Float.valueOf(aur.m4520k(parcel, readInt))));
                            break;
                        case 4:
                            m5215b(stringBuilder, com_fossil_bin, bim.m5199a(com_fossil_bin, Double.valueOf(aur.m4522m(parcel, readInt))));
                            break;
                        case 5:
                            m5215b(stringBuilder, com_fossil_bin, bim.m5199a(com_fossil_bin, aur.m4524o(parcel, readInt)));
                            break;
                        case 6:
                            m5215b(stringBuilder, com_fossil_bin, bim.m5199a(com_fossil_bin, Boolean.valueOf(aur.m4512c(parcel, readInt))));
                            break;
                        case 7:
                            m5215b(stringBuilder, com_fossil_bin, bim.m5199a(com_fossil_bin, aur.m4525p(parcel, readInt)));
                            break;
                        case 8:
                        case 9:
                            m5215b(stringBuilder, com_fossil_bin, bim.m5199a(com_fossil_bin, aur.m4528s(parcel, readInt)));
                            break;
                        case 10:
                            m5215b(stringBuilder, com_fossil_bin, bim.m5199a(com_fossil_bin, m5216x(aur.m4527r(parcel, readInt))));
                            break;
                        case 11:
                            throw new IllegalArgumentException("Method does not accept concrete type.");
                        default:
                            throw new IllegalArgumentException("Unknown field out type = " + com_fossil_bin.bvv);
                    }
                }
                m5213a(stringBuilder, com_fossil_bin, parcel, readInt);
                obj = 1;
            }
        }
        if (parcel.dataPosition() != z) {
            throw new zzc("Overread allowed size end=" + z, parcel);
        }
        stringBuilder.append('}');
    }

    private final void m5215b(StringBuilder stringBuilder, bin<?, ?> com_fossil_bin___, Object obj) {
        if (com_fossil_bin___.bvu) {
            ArrayList arrayList = (ArrayList) obj;
            stringBuilder.append("[");
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (i != 0) {
                    stringBuilder.append(",");
                }
                m5212a(stringBuilder, com_fossil_bin___.bvt, arrayList.get(i));
            }
            stringBuilder.append("]");
            return;
        }
        m5212a(stringBuilder, com_fossil_bin___.bvt, obj);
    }

    private static HashMap<String, String> m5216x(Bundle bundle) {
        HashMap<String, String> hashMap = new HashMap();
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.getString(str));
        }
        return hashMap;
    }

    public final Map<String, bin<?, ?>> Ox() {
        return this.bvB == null ? null : this.bvB.dK(this.JY);
    }

    public final Object dI(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public final boolean dJ(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public String toString() {
        awa.m4640p(this.bvB, "Cannot convert to JSON on client side.");
        Parcel OF = OF();
        OF.setDataPosition(0);
        StringBuilder stringBuilder = new StringBuilder(100);
        m5214a(stringBuilder, this.bvB.dK(this.JY), OF);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        Parcelable parcelable;
        int A = aus.m4537A(parcel);
        aus.m4565c(parcel, 1, this.ber);
        aus.m4547a(parcel, 2, OF(), false);
        switch (this.bvJ) {
            case 0:
                parcelable = null;
                break;
            case 1:
                parcelable = this.bvB;
                break;
            case 2:
                parcelable = this.bvB;
                break;
            default:
                throw new IllegalStateException("Invalid creation type: " + this.bvJ);
        }
        aus.m4548a(parcel, 3, parcelable, i, false);
        aus.m4540G(parcel, A);
    }
}
