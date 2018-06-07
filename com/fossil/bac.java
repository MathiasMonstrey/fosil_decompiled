package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.fossil.wearables.fsl.goaltracking.GoalTrackingSummary;
import com.fossil.wearables.fsl.location.DeviceLocation;
import com.misfit.frameworks.common.constants.Constants;

public final class bac extends auq {
    public static final Creator<bac> CREATOR = new bas();
    public static final bac bmA = dr("speed");
    public static final bac bmB = dr("rpm");
    public static final bac bmC = new bac("google.android.fitness.StrideModel", 7);
    public static final bac bmD = dp("revolutions");
    public static final bac bmE = dr("calories");
    public static final bac bmF = dr("watts");
    public static final bac bmG = dr("volume");
    public static final bac bmH = dp("meal_type");
    public static final bac bmI = ds("food_item");
    public static final bac bmJ = dt("nutrients");
    public static final bac bmK = dr("elevation.change");
    public static final bac bmL = dt("elevation.gain");
    public static final bac bmM = dt("elevation.loss");
    public static final bac bmN = dr("floors");
    public static final bac bmO = dt("floor.gain");
    public static final bac bmP = dt("floor.loss");
    public static final bac bmQ = ds("exercise");
    public static final bac bmR = dp("repetitions");
    public static final bac bmS = dr("resistance");
    public static final bac bmT = dp("resistance_type");
    public static final bac bmU = dp("num_segments");
    public static final bac bmV = dr(GoalTrackingSummary.COLUMN_AVERAGE);
    public static final bac bmW = dr("max");
    public static final bac bmX = dr("min");
    public static final bac bmY = dr("low_latitude");
    public static final bac bmZ = dr("low_longitude");
    public static final bac bmf = dp(Constants.ACTIVITY);
    public static final bac bmg = dr("confidence");
    public static final bac bmh = dt("activity_confidence");
    public static final bac bmj = dp("steps");
    public static final bac bmk = dr("step_length");
    public static final bac bml = dp(Constants.DURATION);
    private static bac bmm = dq(Constants.DURATION);
    private static bac bmn = dt("activity_duration");
    public static final bac bmo = dt("activity_duration.ascending");
    public static final bac bmp = dt("activity_duration.descending");
    public static final bac bmq = dr("bpm");
    public static final bac bmr = dr(DeviceLocation.COLUMN_LATITUDE);
    public static final bac bms = dr(DeviceLocation.COLUMN_LONGITUDE);
    public static final bac bmt = dr("accuracy");
    public static final bac bmu = new bac("altitude", 2, Boolean.valueOf(true));
    public static final bac bmv = dr("distance");
    public static final bac bmw = dr(Constants.PROFILE_KEY_UNITS_HEIGHT);
    public static final bac bmx = dr(Constants.PROFILE_KEY_UNITS_WEIGHT);
    public static final bac bmy = dr("circumference");
    public static final bac bmz = dr("percentage");
    public static final bac bna = dr("high_latitude");
    public static final bac bnb = dr("high_longitude");
    public static final bac bnc = dp("occurrences");
    public static final bac bnd = dp("sensor_type");
    public static final bac bne = dp("sensor_types");
    public static final bac bnf = new bac("timestamps", 5);
    public static final bac bng = dp("sample_period");
    public static final bac bnh = dp("num_samples");
    public static final bac bni = dp("num_dimensions");
    public static final bac bnj = new bac("sensor_values", 6);
    private final Boolean bnk;
    private final int format;
    private final String name;
    private final int versionCode;

    public static class C1913a {
        public static final bac bnl = bac.dr("x");
        public static final bac bnm = bac.dr("y");
        public static final bac bnn = bac.dr("z");
        public static final bac bno = bac.du("debug_session");
        public static final bac bnp = bac.du("google.android.fitness.SessionV2");
    }

    bac(int i, String str, int i2, Boolean bool) {
        this.versionCode = i;
        this.name = (String) awa.bO(str);
        this.format = i2;
        this.bnk = bool;
    }

    private bac(String str, int i) {
        this(2, str, i, null);
    }

    private bac(String str, int i, Boolean bool) {
        this(2, str, i, bool);
    }

    private static bac dp(String str) {
        return new bac(str, 1);
    }

    static bac dq(String str) {
        return new bac(str, 1, Boolean.valueOf(true));
    }

    static bac dr(String str) {
        return new bac(str, 2);
    }

    private static bac ds(String str) {
        return new bac(str, 3);
    }

    private static bac dt(String str) {
        return new bac(str, 4);
    }

    static bac du(String str) {
        return new bac(str, 7, Boolean.valueOf(true));
    }

    public final Boolean Ml() {
        return this.bnk;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof bac) {
            bac com_fossil_bac = (bac) obj;
            boolean z = this.name.equals(com_fossil_bac.name) && this.format == com_fossil_bac.format;
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final int getFormat() {
        return this.format;
    }

    public final String getName() {
        return this.name;
    }

    public final int hashCode() {
        return this.name.hashCode();
    }

    public final String toString() {
        String str = "%s(%s)";
        Object[] objArr = new Object[2];
        objArr[0] = this.name;
        objArr[1] = this.format == 1 ? "i" : "f";
        return String.format(str, objArr);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4554a(parcel, 1, getName(), false);
        aus.m4565c(parcel, 2, getFormat());
        aus.m4549a(parcel, 3, Ml(), false);
        aus.m4565c(parcel, 1000, this.versionCode);
        aus.m4540G(parcel, A);
    }
}
