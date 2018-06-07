package com.fossil;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.fitness.data.DataType;

public class baa extends auq {
    public static final Creator<baa> CREATOR = new bao();
    private static final int[] bkT = new int[0];
    private final DataType bkP;
    private final bab bkU;
    private final bah bkV;
    private final String bkW;
    private final int[] bkX;
    private final String bkY;
    private final String name;
    private final int type;
    private final int versionCode;

    public static final class C1912a {
        private DataType bkP;
        private bab bkU;
        private bah bkV;
        private String bkW = "";
        private int[] bkX;
        private String name;
        private int type = -1;

        public final baa Mi() {
            boolean z = true;
            awa.m4634a(this.bkP != null, "Must set data type");
            if (this.type < 0) {
                z = false;
            }
            awa.m4634a(z, "Must set data source type");
            return new baa();
        }

        public final C1912a m4775a(bab com_fossil_bab) {
            this.bkU = com_fossil_bab;
            return this;
        }

        public final C1912a m4776a(DataType dataType) {
            this.bkP = dataType;
            return this;
        }

        public final C1912a aD(Context context) {
            return m4777do(context.getPackageName());
        }

        public final C1912a dn(String str) {
            this.name = str;
            return this;
        }

        public final C1912a m4777do(String str) {
            this.bkV = bah.dv(str);
            return this;
        }

        public final C1912a hF(int i) {
            this.type = i;
            return this;
        }
    }

    baa(int i, DataType dataType, String str, int i2, bab com_fossil_bab, bah com_fossil_bah, String str2, int[] iArr) {
        this.versionCode = i;
        this.bkP = dataType;
        this.type = i2;
        this.name = str;
        this.bkU = com_fossil_bab;
        this.bkV = com_fossil_bah;
        this.bkW = str2;
        this.bkY = Mh();
        if (iArr == null) {
            iArr = bkT;
        }
        this.bkX = iArr;
    }

    private baa(C1912a c1912a) {
        this.versionCode = 3;
        this.bkP = c1912a.bkP;
        this.type = c1912a.type;
        this.name = c1912a.name;
        this.bkU = c1912a.bkU;
        this.bkV = c1912a.bkV;
        this.bkW = c1912a.bkW;
        this.bkY = Mh();
        this.bkX = c1912a.bkX;
    }

    private final String Mh() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getTypeString());
        stringBuilder.append(":").append(this.bkP.getName());
        if (this.bkV != null) {
            stringBuilder.append(":").append(this.bkV.getPackageName());
        }
        if (this.bkU != null) {
            stringBuilder.append(":").append(this.bkU.Mg());
        }
        if (this.bkW != null) {
            stringBuilder.append(":").append(this.bkW);
        }
        return stringBuilder.toString();
    }

    private final String getTypeString() {
        switch (this.type) {
            case 0:
                return "raw";
            case 1:
                return "derived";
            case 2:
                return "cleaned";
            case 3:
                return "converted";
            default:
                return "derived";
        }
    }

    public DataType LS() {
        return this.bkP;
    }

    public final bah Mc() {
        return this.bkV;
    }

    public bab Md() {
        return this.bkU;
    }

    public String Me() {
        return this.bkW;
    }

    public int[] Mf() {
        return this.bkX;
    }

    public String Mg() {
        return this.bkY;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x0012;
    L_0x0002:
        r0 = r3 instanceof com.fossil.baa;
        if (r0 == 0) goto L_0x0014;
    L_0x0006:
        r3 = (com.fossil.baa) r3;
        r0 = r2.bkY;
        r1 = r3.bkY;
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0014;
    L_0x0012:
        r0 = 1;
    L_0x0013:
        return r0;
    L_0x0014:
        r0 = 0;
        goto L_0x0013;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.baa.equals(java.lang.Object):boolean");
    }

    public String getName() {
        return this.name;
    }

    public int getType() {
        return this.type;
    }

    public int hashCode() {
        return this.bkY.hashCode();
    }

    public final String toDebugString() {
        Object obj;
        String str;
        String str2;
        String valueOf;
        switch (this.type) {
            case 0:
                obj = "r";
                break;
            case 1:
                obj = "d";
                break;
            case 2:
                obj = "c";
                break;
            case 3:
                obj = "v";
                break;
            default:
                obj = "?";
                break;
        }
        String valueOf2 = String.valueOf(obj);
        String valueOf3 = String.valueOf(this.bkP.Mk());
        if (this.bkV == null) {
            str = "";
        } else if (this.bkV.equals(bah.boD)) {
            str = ":gms";
        } else {
            str2 = ":";
            str = String.valueOf(this.bkV.getPackageName());
            str = str.length() != 0 ? str2.concat(str) : new String(str2);
        }
        if (this.bkU != null) {
            str2 = String.valueOf(this.bkU.getModel());
            valueOf = String.valueOf(this.bkU.getUid());
            str2 = new StringBuilder((String.valueOf(str2).length() + 2) + String.valueOf(valueOf).length()).append(":").append(str2).append(":").append(valueOf).toString();
        } else {
            str2 = "";
        }
        if (this.bkW != null) {
            String str3 = ":";
            valueOf = String.valueOf(this.bkW);
            valueOf = valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3);
        } else {
            valueOf = "";
        }
        return new StringBuilder(((((String.valueOf(valueOf2).length() + 1) + String.valueOf(valueOf3).length()) + String.valueOf(str).length()) + String.valueOf(str2).length()) + String.valueOf(valueOf).length()).append(valueOf2).append(":").append(valueOf3).append(str).append(str2).append(valueOf).toString();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("DataSource{");
        stringBuilder.append(getTypeString());
        if (this.name != null) {
            stringBuilder.append(":").append(this.name);
        }
        if (this.bkV != null) {
            stringBuilder.append(":").append(this.bkV);
        }
        if (this.bkU != null) {
            stringBuilder.append(":").append(this.bkU);
        }
        if (this.bkW != null) {
            stringBuilder.append(":").append(this.bkW);
        }
        stringBuilder.append(":").append(this.bkP);
        return stringBuilder.append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4548a(parcel, 1, LS(), i, false);
        aus.m4554a(parcel, 2, getName(), false);
        aus.m4565c(parcel, 3, getType());
        aus.m4548a(parcel, 4, Md(), i, false);
        aus.m4548a(parcel, 5, this.bkV, i, false);
        aus.m4554a(parcel, 6, Me(), false);
        aus.m4565c(parcel, 1000, this.versionCode);
        aus.m4559a(parcel, 8, Mf(), false);
        aus.m4540G(parcel, A);
    }
}
