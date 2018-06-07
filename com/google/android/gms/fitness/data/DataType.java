package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.fossil.auq;
import com.fossil.aus;
import com.fossil.axi;
import com.fossil.bac;
import com.fossil.bac.C1913a;
import com.fossil.bap;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class DataType extends auq implements ReflectedParcelable {
    public static final Creator<DataType> CREATOR = new bap();
    @KeepName
    public static final DataType TYPE_DISTANCE_CUMULATIVE = new DataType("com.google.distance.cumulative", bac.bmv);
    @KeepName
    public static final DataType TYPE_STEP_COUNT_CUMULATIVE = new DataType("com.google.step_count.cumulative", bac.bmj);
    public static final DataType bkZ = new DataType("com.google.step_count.delta", bac.bmj);
    public static final DataType blA = new DataType("com.google.body.waist.circumference", bac.bmy);
    public static final DataType blB = new DataType("com.google.body.hip.circumference", bac.bmy);
    public static final DataType blC = new DataType("com.google.nutrition", bac.bmJ, bac.bmH, bac.bmI);
    public static final DataType blD = new DataType("com.google.hydration", bac.bmG);
    public static final DataType blE = new DataType("com.google.activity.exercise", bac.bmQ, bac.bmR, bac.bml, bac.bmT, bac.bmS);
    public static final DataType blF = new DataType("com.google.activity.summary", bac.bmf, bac.bml, bac.bmU);
    public static final DataType blG = new DataType("com.google.floor_change.summary", bac.bmo, bac.bmp, bac.bmL, bac.bmM, bac.bmO, bac.bmP);
    public static final DataType blH = new DataType("com.google.calories.bmr.summary", bac.bmV, bac.bmW, bac.bmX);
    public static final DataType blI = bkZ;
    public static final DataType blJ = blr;
    @Deprecated
    public static final DataType blK = blf;
    public static final DataType blL = blg;
    public static final DataType blM = new DataType("com.google.heart_rate.summary", bac.bmV, bac.bmW, bac.bmX);
    public static final DataType blN = new DataType("com.google.location.bounding_box", bac.bmY, bac.bmZ, bac.bna, bac.bnb);
    public static final DataType blO = new DataType("com.google.power.summary", bac.bmV, bac.bmW, bac.bmX);
    public static final DataType blP = new DataType("com.google.speed.summary", bac.bmV, bac.bmW, bac.bmX);
    public static final DataType blQ = new DataType("com.google.body.fat.percentage.summary", bac.bmV, bac.bmW, bac.bmX);
    public static final DataType blR = new DataType("com.google.body.hip.circumference.summary", bac.bmV, bac.bmW, bac.bmX);
    public static final DataType blS = new DataType("com.google.body.waist.circumference.summary", bac.bmV, bac.bmW, bac.bmX);
    public static final DataType blT = new DataType("com.google.weight.summary", bac.bmV, bac.bmW, bac.bmX);
    public static final DataType blU = new DataType("com.google.height.summary", bac.bmV, bac.bmW, bac.bmX);
    public static final DataType blV = new DataType("com.google.nutrition.summary", bac.bmJ, bac.bmH);
    public static final DataType blW = blD;
    @Deprecated
    public static final Set<DataType> blX;
    public static final DataType bla = new DataType("com.google.step_length", bac.bmk);
    public static final DataType blb = new DataType("com.google.step_count.cadence", bac.bmB);
    public static final DataType blc = new DataType("com.google.stride_model", bac.bmC);
    public static final DataType bld = new DataType("com.google.activity.segment", bac.bmf);
    public static final DataType ble = new DataType("com.google.floor_change", bac.bmf, bac.bmg, bac.bmK, bac.bmN);
    @Deprecated
    public static final DataType blf = new DataType("com.google.calories.consumed", bac.bmE);
    public static final DataType blg = new DataType("com.google.calories.expended", bac.bmE);
    public static final DataType blh = new DataType("com.google.calories.bmr", bac.bmE);
    public static final DataType bli = new DataType("com.google.power.sample", bac.bmF);
    @Deprecated
    public static final DataType blj = new DataType("com.google.activity.sample", bac.bmf, bac.bmg);
    public static final DataType blk = new DataType("com.google.activity.samples", bac.bmh);
    public static final DataType bll = new DataType("com.google.accelerometer", C1913a.bnl, C1913a.bnm, C1913a.bnn);
    public static final DataType blm = new DataType("com.google.sensor.events", bac.bnd, bac.bnf, bac.bnj);
    public static final DataType bln = new DataType("com.google.sensor.const_rate_events", bac.bne, bac.bng, bac.bnh, bac.bni, bac.bnj);
    public static final DataType blo = new DataType("com.google.heart_rate.bpm", bac.bmq);
    public static final DataType blp = new DataType("com.google.location.sample", bac.bmr, bac.bms, bac.bmt, bac.bmu);
    public static final DataType blq = new DataType("com.google.location.track", bac.bmr, bac.bms, bac.bmt, bac.bmu);
    public static final DataType blr = new DataType("com.google.distance.delta", bac.bmv);
    public static final DataType bls = new DataType("com.google.speed", bac.bmA);
    public static final DataType blt = new DataType("com.google.cycling.wheel_revolution.cumulative", bac.bmD);
    public static final DataType blu = new DataType("com.google.cycling.wheel_revolution.rpm", bac.bmB);
    public static final DataType blv = new DataType("com.google.cycling.pedaling.cumulative", bac.bmD);
    public static final DataType blw = new DataType("com.google.cycling.pedaling.cadence", bac.bmB);
    public static final DataType blx = new DataType("com.google.height", bac.bmw);
    public static final DataType bly = new DataType("com.google.weight", bac.bmx);
    public static final DataType blz = new DataType("com.google.body.fat.percentage", bac.bmz);
    private final List<bac> blY;
    private final String name;
    private final int versionCode;

    static {
        Set com_fossil_axi = new axi();
        blX = com_fossil_axi;
        com_fossil_axi.add(bld);
        blX.add(blh);
        blX.add(blz);
        blX.add(blB);
        blX.add(blA);
        blX.add(blf);
        blX.add(blg);
        blX.add(blr);
        blX.add(ble);
        blX.add(blp);
        blX.add(blC);
        blX.add(blD);
        blX.add(blo);
        blX.add(bli);
        blX.add(bls);
        blX.add(bkZ);
        blX.add(bly);
    }

    public DataType(int i, String str, List<bac> list) {
        this.versionCode = i;
        this.name = str;
        this.blY = Collections.unmodifiableList(list);
    }

    public DataType(String str, bac... com_fossil_bacArr) {
        this(1, str, Arrays.asList(com_fossil_bacArr));
    }

    public final List<bac> Mj() {
        return this.blY;
    }

    public final String Mk() {
        return this.name.startsWith("com.google.") ? this.name.substring(11) : this.name;
    }

    public final int m12655b(bac com_fossil_bac) {
        int indexOf = this.blY.indexOf(com_fossil_bac);
        if (indexOf >= 0) {
            return indexOf;
        }
        throw new IllegalArgumentException(String.format("%s not a field of %s", new Object[]{com_fossil_bac, this}));
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof DataType)) {
                return false;
            }
            DataType dataType = (DataType) obj;
            boolean z = this.name.equals(dataType.name) && this.blY.equals(dataType.blY);
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public final String getName() {
        return this.name;
    }

    public final int hashCode() {
        return this.name.hashCode();
    }

    public final String toString() {
        return String.format("DataType{%s%s}", new Object[]{this.name, this.blY});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4554a(parcel, 1, getName(), false);
        aus.m4566c(parcel, 2, Mj(), false);
        aus.m4565c(parcel, 1000, this.versionCode);
        aus.m4540G(parcel, A);
    }
}
