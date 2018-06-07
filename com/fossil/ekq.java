package com.fossil;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.j256.ormlite.field.FieldType;
import com.misfit.frameworks.common.constants.Constants;
import com.ua.sdk.MeasurementSystem;
import com.ua.sdk.user.Gender;
import com.ua.sdk.user.UserObjectState;
import java.util.Date;

public class ekq extends egl<ekn> {
    public static final egn<Double> dKA = new egp(14, Constants.PROFILE_KEY_UNITS_HEIGHT);
    public static final egn<Double> dKB = new egp(15, Constants.PROFILE_KEY_UNITS_WEIGHT);
    public static final egn<String> dKC = new egt(16, "timezone");
    public static final egn<Date> dKD = new ego(17, "date_joined");
    public static final egn<Date> dKE = new ego(18, "last_login");
    public static final egn<MeasurementSystem> dKF = new egq(19, "display_measurement_system", MeasurementSystem.class);
    public static final egn<Boolean> dKG = new egm(20, "communication_promotions");
    public static final egn<Boolean> dKH = new egm(22, "communication_newsletter");
    public static final egn<Boolean> dKI = new egm(22, "communication_system_messages");
    public static final egn<Boolean> dKJ = new egm(23, "sharing_twitter");
    public static final egn<Boolean> dKK = new egm(24, "sharing_facebook");
    public static final egn<String> dKL = new egt(25, "location_country");
    public static final egn<String> dKM = new egt(26, "location_region");
    public static final egn<String> dKN = new egt(27, "location_locality");
    public static final egn<String> dKO = new egt(28, "location_address");
    public static final egn<String> dKP = new egt(29, "profile_image_small");
    public static final egn<String> dKQ = new egt(30, "profile_image_medium");
    public static final egn<String> dKR = new egt(31, "profile_image_large");
    private static final egn[] dKS = new egn[]{dKm, dKn, dKo, dKp, dKq, dKr, dKs, dKt, dKu, dKv, dKw, dKx, dKy, dKz, dKA, dKB, dKC, dKD, dKE, dKF, dKG, dKH, dKI, dKJ, dKK, dKL, dKM, dKN, dKO, dKP, dKQ, dKR};
    private static ekq dKl = null;
    public static final egn<Long> dKm = new egs(0, FieldType.FOREIGN_ID_FIELD_SUFFIX);
    public static final egn<String> dKn = new egt(1, "id");
    public static final egn<String> dKo = new egt(2, "username");
    public static final egn<String> dKp = new egt(3, Constants.EMAIL);
    public static final egn<String> dKq = new egt(4, Constants.FACEBOOK_KEY_FIRST_NAME);
    public static final egn<String> dKr = new egt(5, Constants.FACEBOOK_KEY_LAST_NAME);
    public static final egn<String> dKs = new egt(6, "last_initial");
    public static final egn<String> dKt = new egt(7, "display_name");
    public static final egn<String> dKu = new egt(8, "introduction");
    public static final egn<String> dKv = new egt(9, "hobbies");
    public static final egn<String> dKw = new egt(10, "goal_statement");
    public static final egn<String> dKx = new egt(11, "profile_statement");
    public static final egn<ech> dKy = new egr(12, "birthdate");
    public static final egn<Gender> dKz = new egq(13, "gender", Gender.class);

    static /* synthetic */ class C34401 {
        static final /* synthetic */ int[] dKT = new int[UserObjectState.values().length];

        static {
            try {
                dKT[UserObjectState.FULL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                dKT[UserObjectState.FRIENDS_WITH.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    protected /* synthetic */ ContentValues mo2910e(ecm com_fossil_ecm) {
        return m10812a((ekn) com_fossil_ecm);
    }

    protected /* synthetic */ ecm mo2911g(Cursor cursor) {
        return m10817p(cursor);
    }

    public static ekq el(Context context) {
        if (dKl == null) {
            dKl = new ekq(context.getApplicationContext());
        }
        return dKl;
    }

    protected ekq(Context context) {
        Context context2 = context;
        super(context2, "mmdk_user", "user", egl.m10681a(dKS), dKn.getColumnName(), 4);
    }

    public void mo2909d(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(egl.m10668a("user", dKS));
    }

    public void mo2908a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS user");
        mo2909d(sQLiteDatabase);
    }

    protected ContentValues m10812a(ekn com_fossil_ekn) {
        if (!(com_fossil_ekn instanceof ekr)) {
            return m10810b(com_fossil_ekn);
        }
        switch (C34401.dKT[((ekr) com_fossil_ekn).aEC().ordinal()]) {
            case 1:
                return m10810b(com_fossil_ekn);
            case 2:
                return m10811c(com_fossil_ekn);
            default:
                return m10810b(com_fossil_ekn);
        }
    }

    private ContentValues m10810b(ekn com_fossil_ekn) {
        Object aEw;
        Object obj = null;
        ContentValues contentValues = new ContentValues();
        dKn.mo2863a(com_fossil_ekn.getId(), contentValues);
        dKo.mo2863a(com_fossil_ekn.getUsername(), contentValues);
        dKp.mo2863a(com_fossil_ekn.getEmail(), contentValues);
        dKq.mo2863a(com_fossil_ekn.getFirstName(), contentValues);
        dKr.mo2863a(com_fossil_ekn.getLastName(), contentValues);
        dKs.mo2863a(com_fossil_ekn.aEf(), contentValues);
        dKt.mo2863a(com_fossil_ekn.getDisplayName(), contentValues);
        dKu.mo2863a(com_fossil_ekn.aEq(), contentValues);
        dKv.mo2863a(com_fossil_ekn.aEr(), contentValues);
        dKw.mo2863a(com_fossil_ekn.aEs(), contentValues);
        dKx.mo2863a(com_fossil_ekn.aEt(), contentValues);
        dKy.mo2863a(com_fossil_ekn.aEg(), contentValues);
        dKz.mo2863a(com_fossil_ekn.aEh(), contentValues);
        dKA.mo2863a(com_fossil_ekn.aEi(), contentValues);
        dKB.mo2863a(com_fossil_ekn.aEj(), contentValues);
        dKC.mo2863a(com_fossil_ekn.getTimeZone(), contentValues);
        dKD.mo2863a(com_fossil_ekn.aEk(), contentValues);
        dKE.mo2863a(com_fossil_ekn.aEl(), contentValues);
        dKF.mo2863a(com_fossil_ekn.aEm(), contentValues);
        dKG.mo2863a(com_fossil_ekn.aEn() != null ? com_fossil_ekn.aEn().aEv() : null, contentValues);
        egn com_fossil_egn = dKH;
        if (com_fossil_ekn.aEn() != null) {
            aEw = com_fossil_ekn.aEn().aEw();
        } else {
            aEw = null;
        }
        com_fossil_egn.mo2863a(aEw, contentValues);
        com_fossil_egn = dKI;
        if (com_fossil_ekn.aEn() != null) {
            aEw = com_fossil_ekn.aEn().aEx();
        } else {
            aEw = null;
        }
        com_fossil_egn.mo2863a(aEw, contentValues);
        com_fossil_egn = dKJ;
        if (com_fossil_ekn.aEo() != null) {
            aEw = com_fossil_ekn.aEo().aEF();
        } else {
            aEw = null;
        }
        com_fossil_egn.mo2863a(aEw, contentValues);
        com_fossil_egn = dKK;
        if (com_fossil_ekn.aEo() != null) {
            aEw = com_fossil_ekn.aEo().aEG();
        } else {
            aEw = null;
        }
        com_fossil_egn.mo2863a(aEw, contentValues);
        com_fossil_egn = dKL;
        if (com_fossil_ekn.aEp() != null) {
            aEw = com_fossil_ekn.aEp().getCountry();
        } else {
            aEw = null;
        }
        com_fossil_egn.mo2863a(aEw, contentValues);
        com_fossil_egn = dKM;
        if (com_fossil_ekn.aEp() != null) {
            aEw = com_fossil_ekn.aEp().aDW();
        } else {
            aEw = null;
        }
        com_fossil_egn.mo2863a(aEw, contentValues);
        com_fossil_egn = dKN;
        if (com_fossil_ekn.aEp() != null) {
            aEw = com_fossil_ekn.aEp().getLocality();
        } else {
            aEw = null;
        }
        com_fossil_egn.mo2863a(aEw, contentValues);
        com_fossil_egn = dKO;
        if (com_fossil_ekn.aEp() != null) {
            aEw = com_fossil_ekn.aEp().getAddress();
        } else {
            aEw = null;
        }
        com_fossil_egn.mo2863a(aEw, contentValues);
        com_fossil_egn = dKP;
        if (com_fossil_ekn.aEu() != null) {
            aEw = com_fossil_ekn.aEu().aCu();
        } else {
            aEw = null;
        }
        com_fossil_egn.mo2863a(aEw, contentValues);
        com_fossil_egn = dKQ;
        if (com_fossil_ekn.aEu() != null) {
            aEw = com_fossil_ekn.aEu().aCv();
        } else {
            aEw = null;
        }
        com_fossil_egn.mo2863a(aEw, contentValues);
        egn com_fossil_egn2 = dKR;
        if (com_fossil_ekn.aEu() != null) {
            obj = com_fossil_ekn.aEu().aCw();
        }
        com_fossil_egn2.mo2863a(obj, contentValues);
        return contentValues;
    }

    private ContentValues m10811c(ekn com_fossil_ekn) {
        ContentValues contentValues = new ContentValues();
        dKn.mo2863a(com_fossil_ekn.getId(), contentValues);
        dKo.mo2863a(com_fossil_ekn.getUsername(), contentValues);
        dKq.mo2863a(com_fossil_ekn.getFirstName(), contentValues);
        dKs.mo2863a(com_fossil_ekn.aEf(), contentValues);
        return contentValues;
    }

    protected ekr m10817p(Cursor cursor) {
        ekr com_fossil_ekr = new ekr();
        com_fossil_ekr.aV(((Long) dKm.mo2865i(cursor)).longValue());
        com_fossil_ekr.setId((String) dKn.mo2865i(cursor));
        com_fossil_ekr.setUsername((String) dKo.mo2865i(cursor));
        com_fossil_ekr.setEmail((String) dKp.mo2865i(cursor));
        com_fossil_ekr.setFirstName((String) dKq.mo2865i(cursor));
        com_fossil_ekr.setLastName((String) dKr.mo2865i(cursor));
        com_fossil_ekr.lX((String) dKs.mo2865i(cursor));
        com_fossil_ekr.setDisplayName((String) dKt.mo2865i(cursor));
        com_fossil_ekr.lY((String) dKu.mo2865i(cursor));
        com_fossil_ekr.lZ((String) dKv.mo2865i(cursor));
        com_fossil_ekr.ma((String) dKw.mo2865i(cursor));
        com_fossil_ekr.mb((String) dKx.mo2865i(cursor));
        com_fossil_ekr.m10821a((ech) dKy.mo2865i(cursor));
        com_fossil_ekr.m10825a((Gender) dKz.mo2865i(cursor));
        com_fossil_ekr.m10826c((Double) dKA.mo2865i(cursor));
        com_fossil_ekr.m10827d((Double) dKB.mo2865i(cursor));
        com_fossil_ekr.setTimeZone((String) dKC.mo2865i(cursor));
        com_fossil_ekr.m10818B((Date) dKD.mo2865i(cursor));
        com_fossil_ekr.m10819C((Date) dKE.mo2865i(cursor));
        com_fossil_ekr.m10828f((MeasurementSystem) dKF.mo2865i(cursor));
        com_fossil_ekr.m10823a(ekp.aEy().m10804g((Boolean) dKG.mo2865i(cursor)).m10805h((Boolean) dKH.mo2865i(cursor)).m10806i((Boolean) dKI.mo2865i(cursor)).aEz());
        com_fossil_ekr.m10824a(elb.aEH().m10849l((Boolean) dKJ.mo2865i(cursor)).m10850m((Boolean) dKK.mo2865i(cursor)).aEI());
        ejd com_fossil_eje = new eje();
        com_fossil_eje.lJ((String) dKL.mo2865i(cursor));
        com_fossil_eje.lK((String) dKM.mo2865i(cursor));
        com_fossil_eje.setLocality((String) dKN.mo2865i(cursor));
        com_fossil_eje.setAddress((String) dKO.mo2865i(cursor));
        com_fossil_ekr.m10822a(com_fossil_eje);
        com_fossil_ekr.m10820a(eir.aDu().lE((String) dKP.mo2865i(cursor)).lF((String) dKQ.mo2865i(cursor)).lG((String) dKR.mo2865i(cursor)).aDv());
        return com_fossil_ekr;
    }
}
