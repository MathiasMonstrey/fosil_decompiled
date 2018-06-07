package com.fossil;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.misfit.frameworks.common.constants.Constants;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class bnn extends bqi {
    private static final Map<String, String> bxO;
    private static final Map<String, String> bxP;
    private static final Map<String, String> bxQ;
    private static final Map<String, String> bxR;
    private static final Map<String, String> bxS;
    private final bnq bxT = new bnq(this, getContext(), bnm.Qf());
    private final bse bxU = new bse(OX());

    static {
        Map jlVar = new jl(1);
        bxO = jlVar;
        jlVar.put("origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;");
        jlVar = new jl(18);
        bxP = jlVar;
        jlVar.put(Constants.APP_VERSION, "ALTER TABLE apps ADD COLUMN app_version TEXT;");
        bxP.put("app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;");
        bxP.put("gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;");
        bxP.put("dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;");
        bxP.put("measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;");
        bxP.put("last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;");
        bxP.put("day", "ALTER TABLE apps ADD COLUMN day INTEGER;");
        bxP.put("daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;");
        bxP.put("daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;");
        bxP.put("daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;");
        bxP.put("remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;");
        bxP.put("config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;");
        bxP.put("failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;");
        bxP.put("app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;");
        bxP.put("firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;");
        bxP.put("daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;");
        bxP.put("daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;");
        bxP.put("health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;");
        bxP.put("android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;");
        jlVar = new jl(1);
        bxQ = jlVar;
        jlVar.put("realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;");
        jlVar = new jl(1);
        bxR = jlVar;
        jlVar.put("has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;");
        jlVar = new jl(1);
        bxS = jlVar;
        jlVar.put("previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;");
    }

    bnn(bpk com_fossil_bpk) {
        super(com_fossil_bpk);
    }

    private final boolean QO() {
        return getContext().getDatabasePath(bnm.Qf()).exists();
    }

    private final long m5335a(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            cursor = getWritableDatabase().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
            } else if (cursor != null) {
                cursor.close();
            }
            return j;
        } catch (SQLiteException e) {
            Pf().Rc().m5437a("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private static Set<String> m5337a(SQLiteDatabase sQLiteDatabase, String str) {
        Set<String> hashSet = new HashSet();
        Cursor rawQuery = sQLiteDatabase.rawQuery(new StringBuilder(String.valueOf(str).length() + 22).append("SELECT * FROM ").append(str).append(" LIMIT 0").toString(), null);
        try {
            Collections.addAll(hashSet, rawQuery.getColumnNames());
            return hashSet;
        } finally {
            rawQuery.close();
        }
    }

    private static void m5338a(ContentValues contentValues, String str, Object obj) {
        awa.df(str);
        awa.bO(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    static void m5339a(bol com_fossil_bol, SQLiteDatabase sQLiteDatabase) {
        if (com_fossil_bol == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        File file = new File(sQLiteDatabase.getPath());
        if (!file.setReadable(false, false)) {
            com_fossil_bol.Re().log("Failed to turn off database read permission");
        }
        if (!file.setWritable(false, false)) {
            com_fossil_bol.Re().log("Failed to turn off database write permission");
        }
        if (!file.setReadable(true, true)) {
            com_fossil_bol.Re().log("Failed to turn on database read permission for owner");
        }
        if (!file.setWritable(true, true)) {
            com_fossil_bol.Re().log("Failed to turn on database write permission for owner");
        }
    }

    static void m5340a(bol com_fossil_bol, SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, Map<String, String> map) throws SQLiteException {
        if (com_fossil_bol == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        if (!m5342a(com_fossil_bol, sQLiteDatabase, str)) {
            sQLiteDatabase.execSQL(str2);
        }
        try {
            m5341a(com_fossil_bol, sQLiteDatabase, str, str3, map);
        } catch (SQLiteException e) {
            com_fossil_bol.Rc().m5439d("Failed to verify columns on table that was just created", str);
            throw e;
        }
    }

    private static void m5341a(bol com_fossil_bol, SQLiteDatabase sQLiteDatabase, String str, String str2, Map<String, String> map) throws SQLiteException {
        if (com_fossil_bol == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        Iterable a = m5337a(sQLiteDatabase, str);
        String[] split = str2.split(",");
        int length = split.length;
        int i = 0;
        while (i < length) {
            String str3 = split[i];
            if (a.remove(str3)) {
                i++;
            } else {
                throw new SQLiteException(new StringBuilder((String.valueOf(str).length() + 35) + String.valueOf(str3).length()).append("Table ").append(str).append(" is missing required column: ").append(str3).toString());
            }
        }
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                if (!a.remove(entry.getKey())) {
                    sQLiteDatabase.execSQL((String) entry.getValue());
                }
            }
        }
        if (!a.isEmpty()) {
            com_fossil_bol.Re().m5437a("Table has extra columns. table, columns", str, TextUtils.join(", ", a));
        }
    }

    private static boolean m5342a(bol com_fossil_bol, SQLiteDatabase sQLiteDatabase, String str) {
        Cursor query;
        Object e;
        Throwable th;
        Cursor cursor = null;
        if (com_fossil_bol == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        try {
            SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
            query = sQLiteDatabase2.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
            try {
                boolean moveToFirst = query.moveToFirst();
                if (query == null) {
                    return moveToFirst;
                }
                query.close();
                return moveToFirst;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    com_fossil_bol.Re().m5437a("Error querying for table", str, e);
                    if (query != null) {
                        query.close();
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            com_fossil_bol.Re().m5437a("Error querying for table", str, e);
            if (query != null) {
                query.close();
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private final boolean m5343a(String str, int i, bsm com_fossil_bsm) {
        RA();
        OP();
        awa.df(str);
        awa.bO(com_fossil_bsm);
        if (TextUtils.isEmpty(com_fossil_bsm.bDJ)) {
            Pf().Re().m5438a("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", bol.ei(str), Integer.valueOf(i), String.valueOf(com_fossil_bsm.bDI));
            return false;
        }
        try {
            byte[] bArr = new byte[com_fossil_bsm.MW()];
            bci h = bci.m4843h(bArr, 0, bArr.length);
            com_fossil_bsm.mo1264a(h);
            h.MQ();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", com_fossil_bsm.bDI);
            contentValues.put("event_name", com_fossil_bsm.bDJ);
            contentValues.put("data", bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("event_filters", null, contentValues, 5) == -1) {
                    Pf().Rc().m5439d("Failed to insert event filter (got -1). appId", bol.ei(str));
                }
                return true;
            } catch (SQLiteException e) {
                Pf().Rc().m5437a("Error storing event filter. appId", bol.ei(str), e);
                return false;
            }
        } catch (IOException e2) {
            Pf().Rc().m5437a("Configuration loss. Failed to serialize event filter. appId", bol.ei(str), e2);
            return false;
        }
    }

    private final boolean m5344a(String str, int i, bsp com_fossil_bsp) {
        RA();
        OP();
        awa.df(str);
        awa.bO(com_fossil_bsp);
        if (TextUtils.isEmpty(com_fossil_bsp.bDY)) {
            Pf().Re().m5438a("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", bol.ei(str), Integer.valueOf(i), String.valueOf(com_fossil_bsp.bDI));
            return false;
        }
        try {
            byte[] bArr = new byte[com_fossil_bsp.MW()];
            bci h = bci.m4843h(bArr, 0, bArr.length);
            com_fossil_bsp.mo1264a(h);
            h.MQ();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", com_fossil_bsp.bDI);
            contentValues.put("property_name", com_fossil_bsp.bDY);
            contentValues.put("data", bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                    return true;
                }
                Pf().Rc().m5439d("Failed to insert property filter (got -1). appId", bol.ei(str));
                return false;
            } catch (SQLiteException e) {
                Pf().Rc().m5437a("Error storing property filter. appId", bol.ei(str), e);
                return false;
            }
        } catch (IOException e2) {
            Pf().Rc().m5437a("Configuration loss. Failed to serialize property filter. appId", bol.ei(str), e2);
            return false;
        }
    }

    private final boolean m5345a(String str, List<Integer> list) {
        awa.df(str);
        RA();
        OP();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        try {
            if (m5346b("select count(1) from audience_filter_values where app_id=?", new String[]{str}) <= ((long) Math.max(0, Math.min(2000, Ph().m5334b(str, bob.bze))))) {
                return false;
            }
            Iterable arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                Integer num = (Integer) list.get(i);
                if (num == null || !(num instanceof Integer)) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String valueOf = String.valueOf(TextUtils.join(",", arrayList));
            valueOf = new StringBuilder(String.valueOf(valueOf).length() + 2).append("(").append(valueOf).append(")").toString();
            return writableDatabase.delete("audience_filter_values", new StringBuilder(String.valueOf(valueOf).length() + 140).append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ").append(valueOf).append(" order by rowid desc limit -1 offset ?)").toString(), new String[]{str, Integer.toString(r5)}) > 0;
        } catch (SQLiteException e) {
            Pf().Rc().m5437a("Database error querying filters. appId", bol.ei(str), e);
            return false;
        }
    }

    private final long m5346b(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = getWritableDatabase().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                long j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e) {
            Pf().Rc().m5437a("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private final Object m5347b(Cursor cursor, int i) {
        int type = cursor.getType(i);
        switch (type) {
            case 0:
                Pf().Rc().log("Loaded invalid null value from database");
                return null;
            case 1:
                return Long.valueOf(cursor.getLong(i));
            case 2:
                return Double.valueOf(cursor.getDouble(i));
            case 3:
                return cursor.getString(i);
            case 4:
                Pf().Rc().log("Loaded invalid blob type value, ignoring it");
                return null;
            default:
                Pf().Rc().m5439d("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                return null;
        }
    }

    public final void m5348B(List<Long> list) {
        awa.bO(list);
        OP();
        RA();
        StringBuilder stringBuilder = new StringBuilder("rowid in (");
        for (int i = 0; i < list.size(); i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(((Long) list.get(i)).longValue());
        }
        stringBuilder.append(")");
        int delete = getWritableDatabase().delete("raw_events", stringBuilder.toString(), null);
        if (delete != list.size()) {
            Pf().Rc().m5437a("Deleted fewer rows from raw events table than expected", Integer.valueOf(delete), Integer.valueOf(list.size()));
        }
    }

    protected final void PH() {
    }

    public final String QG() {
        Cursor rawQuery;
        Object e;
        Throwable th;
        String str = null;
        try {
            rawQuery = getWritableDatabase().rawQuery("select app_id from queue order by has_realtime desc, rowid asc limit 1;", null);
            try {
                if (rawQuery.moveToFirst()) {
                    str = rawQuery.getString(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                } else if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    Pf().Rc().m5439d("Database error getting next bundle app id", e);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            rawQuery = null;
            Pf().Rc().m5439d("Database error getting next bundle app id", e);
            if (rawQuery != null) {
                rawQuery.close();
            }
            return str;
        } catch (Throwable th3) {
            rawQuery = null;
            th = th3;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
        return str;
    }

    public final boolean QH() {
        return m5346b("select count(1) > 0 from queue where has_realtime = 1", null) != 0;
    }

    final void QI() {
        OP();
        RA();
        if (QO()) {
            long j = Pg().bAa.get();
            long elapsedRealtime = OX().elapsedRealtime();
            if (Math.abs(elapsedRealtime - j) > bnm.Ql()) {
                Pg().bAa.set(elapsedRealtime);
                OP();
                RA();
                if (QO()) {
                    int delete = getWritableDatabase().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(OX().currentTimeMillis()), String.valueOf(bnm.Qk())});
                    if (delete > 0) {
                        Pf().Ri().m5439d("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                    }
                }
            }
        }
    }

    public final long QJ() {
        return m5335a("select max(bundle_end_timestamp) from queue", null, 0);
    }

    public final long QK() {
        return m5335a("select max(timestamp) from raw_events", null, 0);
    }

    public final boolean QL() {
        return m5346b("select count(1) > 0 from raw_events", null) != 0;
    }

    public final boolean QM() {
        return m5346b("select count(1) > 0 from raw_events where realtime = 1", null) != 0;
    }

    public final long QN() {
        long j = -1;
        Cursor cursor = null;
        try {
            cursor = getWritableDatabase().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
            if (cursor.moveToFirst()) {
                j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
            } else if (cursor != null) {
                cursor.close();
            }
        } catch (SQLiteException e) {
            Pf().Rc().m5439d("Error querying raw events", e);
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return j;
    }

    public final bnv m5349R(String str, String str2) {
        Object e;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        awa.df(str);
        awa.df(str2);
        OP();
        RA();
        try {
            Cursor query = getWritableDatabase().query("events", new String[]{"lifetime_count", "current_bundle_count", "last_fire_timestamp"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    bnv com_fossil_bnv = new bnv(str, str2, query.getLong(0), query.getLong(1), query.getLong(2));
                    if (query.moveToNext()) {
                        Pf().Rc().m5439d("Got multiple records for event aggregates, expected one. appId", bol.ei(str));
                    }
                    if (query == null) {
                        return com_fossil_bnv;
                    }
                    query.close();
                    return com_fossil_bnv;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
                try {
                    Pf().Rc().m5438a("Error querying events. appId", bol.ei(str), Pa().ef(str2), e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor2 = query;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            Pf().Rc().m5438a("Error querying events. appId", bol.ei(str), Pa().ef(str2), e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public final void m5350S(String str, String str2) {
        awa.df(str);
        awa.df(str2);
        OP();
        RA();
        try {
            Pf().Ri().m5439d("Deleted user attribute rows", Integer.valueOf(getWritableDatabase().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2})));
        } catch (SQLiteException e) {
            Pf().Rc().m5438a("Error deleting user attribute. appId", bol.ei(str), Pa().eh(str2), e);
        }
    }

    public final bsj m5351T(String str, String str2) {
        Object e;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        awa.df(str);
        awa.df(str2);
        OP();
        RA();
        try {
            Cursor query = getWritableDatabase().query("user_attributes", new String[]{"set_timestamp", "value", "origin"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    String str3 = str;
                    bsj com_fossil_bsj = new bsj(str3, query.getString(2), str2, query.getLong(0), m5347b(query, 1));
                    if (query.moveToNext()) {
                        Pf().Rc().m5439d("Got multiple records for user property, expected one. appId", bol.ei(str));
                    }
                    if (query == null) {
                        return com_fossil_bsj;
                    }
                    query.close();
                    return com_fossil_bsj;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
                try {
                    Pf().Rc().m5438a("Error querying user property. appId", bol.ei(str), Pa().eh(str2), e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor2 = query;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            Pf().Rc().m5438a("Error querying user property. appId", bol.ei(str), Pa().eh(str2), e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public final bnk m5352U(String str, String str2) {
        Cursor query;
        Object e;
        Cursor cursor;
        Throwable th;
        awa.df(str);
        awa.df(str2);
        OP();
        RA();
        try {
            query = getWritableDatabase().query("conditional_properties", new String[]{"origin", "value", "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    String string = query.getString(0);
                    Object b = m5347b(query, 1);
                    boolean z = query.getInt(2) != 0;
                    String string2 = query.getString(3);
                    long j = query.getLong(4);
                    bnz com_fossil_bnz = (bnz) Pb().m5603b(query.getBlob(5), bnz.CREATOR);
                    long j2 = query.getLong(6);
                    bnz com_fossil_bnz2 = (bnz) Pb().m5603b(query.getBlob(7), bnz.CREATOR);
                    long j3 = query.getLong(8);
                    bnk com_fossil_bnk = new bnk(str, string, new bsh(str2, j3, b, string), j2, z, string2, com_fossil_bnz, j, com_fossil_bnz2, query.getLong(9), (bnz) Pb().m5603b(query.getBlob(10), bnz.CREATOR));
                    if (query.moveToNext()) {
                        Pf().Rc().m5437a("Got multiple records for conditional property, expected one", bol.ei(str), Pa().eh(str2));
                    }
                    if (query == null) {
                        return com_fossil_bnk;
                    }
                    query.close();
                    return com_fossil_bnk;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
                try {
                    Pf().Rc().m5438a("Error querying conditional property", bol.ei(str), Pa().eh(str2), e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    query = cursor;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            Pf().Rc().m5438a("Error querying conditional property", bol.ei(str), Pa().eh(str2), e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public final int m5353V(String str, String str2) {
        int i = 0;
        awa.df(str);
        awa.df(str2);
        OP();
        RA();
        try {
            i = getWritableDatabase().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            Pf().Rc().m5438a("Error deleting conditional property", bol.ei(str), Pa().eh(str2), e);
        }
        return i;
    }

    final Map<Integer, List<bsm>> m5354W(String str, String str2) {
        Object e;
        Throwable th;
        RA();
        OP();
        awa.df(str);
        awa.df(str2);
        Map<Integer, List<bsm>> jlVar = new jl();
        Cursor query;
        try {
            query = getWritableDatabase().query("event_filters", new String[]{"audience_id", "data"}, "app_id=? AND event_name=?", new String[]{str, str2}, null, null, null);
            if (query.moveToFirst()) {
                do {
                    try {
                        byte[] blob = query.getBlob(1);
                        bch g = bch.m4834g(blob, 0, blob.length);
                        bsm com_fossil_bsm = new bsm();
                        try {
                            com_fossil_bsm.mo1266a(g);
                            int i = query.getInt(0);
                            List list = (List) jlVar.get(Integer.valueOf(i));
                            if (list == null) {
                                list = new ArrayList();
                                jlVar.put(Integer.valueOf(i), list);
                            }
                            list.add(com_fossil_bsm);
                        } catch (IOException e2) {
                            Pf().Rc().m5437a("Failed to merge filter. appId", bol.ei(str), e2);
                        }
                    } catch (SQLiteException e3) {
                        e = e3;
                    }
                } while (query.moveToNext());
                if (query != null) {
                    query.close();
                }
                return jlVar;
            }
            Map<Integer, List<bsm>> emptyMap = Collections.emptyMap();
            if (query == null) {
                return emptyMap;
            }
            query.close();
            return emptyMap;
        } catch (SQLiteException e4) {
            e = e4;
            query = null;
            try {
                Pf().Rc().m5437a("Database error querying filters. appId", bol.ei(str), e);
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    final Map<Integer, List<bsp>> m5355X(String str, String str2) {
        Object e;
        Throwable th;
        RA();
        OP();
        awa.df(str);
        awa.df(str2);
        Map<Integer, List<bsp>> jlVar = new jl();
        Cursor query;
        try {
            query = getWritableDatabase().query("property_filters", new String[]{"audience_id", "data"}, "app_id=? AND property_name=?", new String[]{str, str2}, null, null, null);
            if (query.moveToFirst()) {
                do {
                    try {
                        byte[] blob = query.getBlob(1);
                        bch g = bch.m4834g(blob, 0, blob.length);
                        bsp com_fossil_bsp = new bsp();
                        try {
                            com_fossil_bsp.mo1266a(g);
                            int i = query.getInt(0);
                            List list = (List) jlVar.get(Integer.valueOf(i));
                            if (list == null) {
                                list = new ArrayList();
                                jlVar.put(Integer.valueOf(i), list);
                            }
                            list.add(com_fossil_bsp);
                        } catch (IOException e2) {
                            Pf().Rc().m5437a("Failed to merge filter", bol.ei(str), e2);
                        }
                    } catch (SQLiteException e3) {
                        e = e3;
                    }
                } while (query.moveToNext());
                if (query != null) {
                    query.close();
                }
                return jlVar;
            }
            Map<Integer, List<bsp>> emptyMap = Collections.emptyMap();
            if (query == null) {
                return emptyMap;
            }
            query.close();
            return emptyMap;
        } catch (SQLiteException e4) {
            e = e4;
            query = null;
            try {
                Pf().Rc().m5437a("Database error querying filters. appId", bol.ei(str), e);
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    protected final long m5356Y(String str, String str2) {
        long a;
        Object e;
        awa.df(str);
        awa.df(str2);
        OP();
        RA();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            a = m5335a(new StringBuilder(String.valueOf(str2).length() + 32).append("select ").append(str2).append(" from app2 where app_id=?").toString(), new String[]{str}, -1);
            if (a == -1) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", str);
                contentValues.put("first_open_count", Integer.valueOf(0));
                contentValues.put("previous_install_count", Integer.valueOf(0));
                if (writableDatabase.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                    Pf().Rc().m5437a("Failed to insert column (got -1). appId", bol.ei(str), str2);
                    writableDatabase.endTransaction();
                    return -1;
                }
                a = 0;
            }
            try {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("app_id", str);
                contentValues2.put(str2, Long.valueOf(1 + a));
                if (((long) writableDatabase.update("app2", contentValues2, "app_id = ?", new String[]{str})) == 0) {
                    Pf().Rc().m5437a("Failed to update column (got 0). appId", bol.ei(str), str2);
                    writableDatabase.endTransaction();
                    return -1;
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                return a;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    Pf().Rc().m5438a("Error inserting column. appId", bol.ei(str), str2, e);
                    return a;
                } finally {
                    writableDatabase.endTransaction();
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            a = 0;
            Pf().Rc().m5438a("Error inserting column. appId", bol.ei(str), str2, e);
            return a;
        }
    }

    public final long m5357a(bsy com_fossil_bsy) throws IOException {
        OP();
        RA();
        awa.bO(com_fossil_bsy);
        awa.df(com_fossil_bsy.bEM);
        try {
            long j;
            Object obj = new byte[com_fossil_bsy.MW()];
            bci h = bci.m4843h(obj, 0, obj.length);
            com_fossil_bsy.mo1264a(h);
            h.MQ();
            bsk Pb = Pb();
            awa.bO(obj);
            Pb.OP();
            MessageDigest eG = bsk.eG("MD5");
            if (eG == null) {
                Pb.Pf().Rc().log("Failed to get MD5");
                j = 0;
            } else {
                j = bsk.ak(eG.digest(obj));
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", com_fossil_bsy.bEM);
            contentValues.put("metadata_fingerprint", Long.valueOf(j));
            contentValues.put("metadata", obj);
            try {
                getWritableDatabase().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
                return j;
            } catch (SQLiteException e) {
                Pf().Rc().m5437a("Error storing raw event metadata. appId", bol.ei(com_fossil_bsy.bEM), e);
                throw e;
            }
        } catch (IOException e2) {
            Pf().Rc().m5437a("Data loss. Failed to serialize event metadata. appId", bol.ei(com_fossil_bsy.bEM), e2);
            throw e2;
        }
    }

    public final bno m5358a(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        Cursor query;
        Object e;
        Throwable th;
        awa.df(str);
        OP();
        RA();
        String[] strArr = new String[]{str};
        bno com_fossil_bno = new bno();
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            query = writableDatabase.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    if (query.getLong(0) == j) {
                        com_fossil_bno.bxW = query.getLong(1);
                        com_fossil_bno.bxV = query.getLong(2);
                        com_fossil_bno.bxX = query.getLong(3);
                        com_fossil_bno.bxY = query.getLong(4);
                        com_fossil_bno.bxZ = query.getLong(5);
                    }
                    if (z) {
                        com_fossil_bno.bxW++;
                    }
                    if (z2) {
                        com_fossil_bno.bxV++;
                    }
                    if (z3) {
                        com_fossil_bno.bxX++;
                    }
                    if (z4) {
                        com_fossil_bno.bxY++;
                    }
                    if (z5) {
                        com_fossil_bno.bxZ++;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("day", Long.valueOf(j));
                    contentValues.put("daily_public_events_count", Long.valueOf(com_fossil_bno.bxV));
                    contentValues.put("daily_events_count", Long.valueOf(com_fossil_bno.bxW));
                    contentValues.put("daily_conversions_count", Long.valueOf(com_fossil_bno.bxX));
                    contentValues.put("daily_error_events_count", Long.valueOf(com_fossil_bno.bxY));
                    contentValues.put("daily_realtime_events_count", Long.valueOf(com_fossil_bno.bxZ));
                    writableDatabase.update("apps", contentValues, "app_id=?", strArr);
                    if (query != null) {
                        query.close();
                    }
                    return com_fossil_bno;
                }
                Pf().Re().m5439d("Not updating daily counts, app is not known. appId", bol.ei(str));
                if (query != null) {
                    query.close();
                }
                return com_fossil_bno;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    Pf().Rc().m5437a("Error updating daily counts. appId", bol.ei(str), e);
                    if (query != null) {
                        query.close();
                    }
                    return com_fossil_bno;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            Pf().Rc().m5437a("Error updating daily counts. appId", bol.ei(str), e);
            if (query != null) {
                query.close();
            }
            return com_fossil_bno;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public final void m5359a(bng com_fossil_bng) {
        awa.bO(com_fossil_bng);
        OP();
        RA();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", com_fossil_bng.Pj());
        contentValues.put("app_instance_id", com_fossil_bng.getAppInstanceId());
        contentValues.put("gmp_app_id", com_fossil_bng.getGmpAppId());
        contentValues.put("resettable_device_id_hash", com_fossil_bng.Pk());
        contentValues.put("last_bundle_index", Long.valueOf(com_fossil_bng.Pu()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(com_fossil_bng.Pm()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(com_fossil_bng.Pn()));
        contentValues.put(Constants.APP_VERSION, com_fossil_bng.Po());
        contentValues.put("app_store", com_fossil_bng.Pq());
        contentValues.put("gmp_version", Long.valueOf(com_fossil_bng.Pr()));
        contentValues.put("dev_cert_hash", Long.valueOf(com_fossil_bng.Ps()));
        contentValues.put("measurement_enabled", Boolean.valueOf(com_fossil_bng.Pt()));
        contentValues.put("day", Long.valueOf(com_fossil_bng.Py()));
        contentValues.put("daily_public_events_count", Long.valueOf(com_fossil_bng.Pz()));
        contentValues.put("daily_events_count", Long.valueOf(com_fossil_bng.PA()));
        contentValues.put("daily_conversions_count", Long.valueOf(com_fossil_bng.PB()));
        contentValues.put("config_fetched_time", Long.valueOf(com_fossil_bng.Pv()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(com_fossil_bng.Pw()));
        contentValues.put("app_version_int", Long.valueOf(com_fossil_bng.Pp()));
        contentValues.put("firebase_instance_id", com_fossil_bng.Pl());
        contentValues.put("daily_error_events_count", Long.valueOf(com_fossil_bng.PD()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(com_fossil_bng.PC()));
        contentValues.put("health_monitor_sample", com_fossil_bng.PE());
        contentValues.put("android_id", Long.valueOf(com_fossil_bng.PG()));
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (((long) writableDatabase.update("apps", contentValues, "app_id = ?", new String[]{com_fossil_bng.Pj()})) == 0 && writableDatabase.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                Pf().Rc().m5439d("Failed to insert/update app (got -1). appId", bol.ei(com_fossil_bng.Pj()));
            }
        } catch (SQLiteException e) {
            Pf().Rc().m5437a("Error storing app. appId", bol.ei(com_fossil_bng.Pj()), e);
        }
    }

    public final void m5360a(bnv com_fossil_bnv) {
        awa.bO(com_fossil_bnv);
        OP();
        RA();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", com_fossil_bnv.mAppId);
        contentValues.put("name", com_fossil_bnv.mName);
        contentValues.put("lifetime_count", Long.valueOf(com_fossil_bnv.byk));
        contentValues.put("current_bundle_count", Long.valueOf(com_fossil_bnv.byl));
        contentValues.put("last_fire_timestamp", Long.valueOf(com_fossil_bnv.bym));
        try {
            if (getWritableDatabase().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                Pf().Rc().m5439d("Failed to insert/update event aggregates (got -1). appId", bol.ei(com_fossil_bnv.mAppId));
            }
        } catch (SQLiteException e) {
            Pf().Rc().m5437a("Error storing event aggregates. appId", bol.ei(com_fossil_bnv.mAppId), e);
        }
    }

    final void m5361a(String str, bsl[] com_fossil_bslArr) {
        int i = 0;
        RA();
        OP();
        awa.df(str);
        awa.bO(com_fossil_bslArr);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            int i2;
            RA();
            OP();
            awa.df(str);
            SQLiteDatabase writableDatabase2 = getWritableDatabase();
            writableDatabase2.delete("property_filters", "app_id=?", new String[]{str});
            writableDatabase2.delete("event_filters", "app_id=?", new String[]{str});
            for (bsl com_fossil_bsl : com_fossil_bslArr) {
                RA();
                OP();
                awa.df(str);
                awa.bO(com_fossil_bsl);
                awa.bO(com_fossil_bsl.bDG);
                awa.bO(com_fossil_bsl.bDF);
                if (com_fossil_bsl.bDE == null) {
                    Pf().Re().m5439d("Audience with no ID. appId", bol.ei(str));
                } else {
                    int intValue = com_fossil_bsl.bDE.intValue();
                    for (bsm com_fossil_bsm : com_fossil_bsl.bDG) {
                        if (com_fossil_bsm.bDI == null) {
                            Pf().Re().m5437a("Event filter with no ID. Audience definition ignored. appId, audienceId", bol.ei(str), com_fossil_bsl.bDE);
                            break;
                        }
                    }
                    for (bsp com_fossil_bsp : com_fossil_bsl.bDF) {
                        if (com_fossil_bsp.bDI == null) {
                            Pf().Re().m5437a("Property filter with no ID. Audience definition ignored. appId, audienceId", bol.ei(str), com_fossil_bsl.bDE);
                            break;
                        }
                    }
                    for (bsm com_fossil_bsm2 : com_fossil_bsl.bDG) {
                        if (!m5343a(str, intValue, com_fossil_bsm2)) {
                            i2 = 0;
                            break;
                        }
                    }
                    i2 = 1;
                    if (i2 != 0) {
                        for (bsp com_fossil_bsp2 : com_fossil_bsl.bDF) {
                            if (!m5344a(str, intValue, com_fossil_bsp2)) {
                                i2 = 0;
                                break;
                            }
                        }
                    }
                    if (i2 == 0) {
                        RA();
                        OP();
                        awa.df(str);
                        SQLiteDatabase writableDatabase3 = getWritableDatabase();
                        writableDatabase3.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(intValue)});
                        writableDatabase3.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(intValue)});
                    }
                }
            }
            List arrayList = new ArrayList();
            i2 = com_fossil_bslArr.length;
            while (i < i2) {
                arrayList.add(com_fossil_bslArr[i].bDE);
                i++;
            }
            m5345a(str, arrayList);
            writableDatabase.setTransactionSuccessful();
        } finally {
            writableDatabase.endTransaction();
        }
    }

    public final boolean m5362a(bnk com_fossil_bnk) {
        awa.bO(com_fossil_bnk);
        OP();
        RA();
        if (m5351T(com_fossil_bnk.packageName, com_fossil_bnk.bxD.name) == null) {
            long b = m5346b("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{com_fossil_bnk.packageName});
            bnm.PY();
            if (b >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", com_fossil_bnk.packageName);
        contentValues.put("origin", com_fossil_bnk.bxC);
        contentValues.put("name", com_fossil_bnk.bxD.name);
        m5338a(contentValues, "value", com_fossil_bnk.bxD.getValue());
        contentValues.put("active", Boolean.valueOf(com_fossil_bnk.bxF));
        contentValues.put("trigger_event_name", com_fossil_bnk.bxG);
        contentValues.put("trigger_timeout", Long.valueOf(com_fossil_bnk.bxI));
        Pb();
        contentValues.put("timed_out_event", bsk.m5589a(com_fossil_bnk.bxH));
        contentValues.put("creation_timestamp", Long.valueOf(com_fossil_bnk.bxE));
        Pb();
        contentValues.put("triggered_event", bsk.m5589a(com_fossil_bnk.bxJ));
        contentValues.put("triggered_timestamp", Long.valueOf(com_fossil_bnk.bxD.bDu));
        contentValues.put("time_to_live", Long.valueOf(com_fossil_bnk.bxK));
        Pb();
        contentValues.put("expired_event", bsk.m5589a(com_fossil_bnk.bxL));
        try {
            if (getWritableDatabase().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                Pf().Rc().m5439d("Failed to insert/update conditional user property (got -1)", bol.ei(com_fossil_bnk.packageName));
            }
        } catch (SQLiteException e) {
            Pf().Rc().m5437a("Error storing conditional user property", bol.ei(com_fossil_bnk.packageName), e);
        }
        return true;
    }

    public final boolean m5363a(bnu com_fossil_bnu, long j, boolean z) {
        OP();
        RA();
        awa.bO(com_fossil_bnu);
        awa.df(com_fossil_bnu.mAppId);
        bsv com_fossil_bsv = new bsv();
        com_fossil_bsv.bEu = Long.valueOf(com_fossil_bnu.byi);
        com_fossil_bsv.bEs = new bsw[com_fossil_bnu.byj.size()];
        Iterator it = com_fossil_bnu.byj.iterator();
        int i = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            bsw com_fossil_bsw = new bsw();
            int i2 = i + 1;
            com_fossil_bsv.bEs[i] = com_fossil_bsw;
            com_fossil_bsw.name = str;
            Pb().m5600a(com_fossil_bsw, com_fossil_bnu.byj.get(str));
            i = i2;
        }
        try {
            byte[] bArr = new byte[com_fossil_bsv.MW()];
            bci h = bci.m4843h(bArr, 0, bArr.length);
            com_fossil_bsv.mo1264a(h);
            h.MQ();
            Pf().Ri().m5437a("Saving event, name, data size", Pa().ef(com_fossil_bnu.mName), Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", com_fossil_bnu.mAppId);
            contentValues.put("name", com_fossil_bnu.mName);
            contentValues.put("timestamp", Long.valueOf(com_fossil_bnu.byh));
            contentValues.put("metadata_fingerprint", Long.valueOf(j));
            contentValues.put("data", bArr);
            contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
            try {
                if (getWritableDatabase().insert("raw_events", null, contentValues) != -1) {
                    return true;
                }
                Pf().Rc().m5439d("Failed to insert raw event (got -1). appId", bol.ei(com_fossil_bnu.mAppId));
                return false;
            } catch (SQLiteException e) {
                Pf().Rc().m5437a("Error storing raw event. appId", bol.ei(com_fossil_bnu.mAppId), e);
                return false;
            }
        } catch (IOException e2) {
            Pf().Rc().m5437a("Data loss. Failed to serialize event params/data. appId", bol.ei(com_fossil_bnu.mAppId), e2);
            return false;
        }
    }

    public final boolean m5364a(bsj com_fossil_bsj) {
        awa.bO(com_fossil_bsj);
        OP();
        RA();
        if (m5351T(com_fossil_bsj.mAppId, com_fossil_bsj.mName) == null) {
            long b;
            if (bsk.ex(com_fossil_bsj.mName)) {
                b = m5346b("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{com_fossil_bsj.mAppId});
                bnm.PV();
                if (b >= 25) {
                    return false;
                }
            }
            b = m5346b("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{com_fossil_bsj.mAppId, com_fossil_bsj.mOrigin});
            bnm.PX();
            if (b >= 25) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", com_fossil_bsj.mAppId);
        contentValues.put("origin", com_fossil_bsj.mOrigin);
        contentValues.put("name", com_fossil_bsj.mName);
        contentValues.put("set_timestamp", Long.valueOf(com_fossil_bsj.bDy));
        m5338a(contentValues, "value", com_fossil_bsj.mValue);
        try {
            if (getWritableDatabase().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                Pf().Rc().m5439d("Failed to insert/update user property (got -1). appId", bol.ei(com_fossil_bsj.mAppId));
            }
        } catch (SQLiteException e) {
            Pf().Rc().m5437a("Error storing user property. appId", bol.ei(com_fossil_bsj.mAppId), e);
        }
        return true;
    }

    public final boolean m5365a(bsy com_fossil_bsy, boolean z) {
        OP();
        RA();
        awa.bO(com_fossil_bsy);
        awa.df(com_fossil_bsy.bEM);
        awa.bO(com_fossil_bsy.bEE);
        QI();
        long currentTimeMillis = OX().currentTimeMillis();
        if (com_fossil_bsy.bEE.longValue() < currentTimeMillis - bnm.Qk() || com_fossil_bsy.bEE.longValue() > bnm.Qk() + currentTimeMillis) {
            Pf().Re().m5438a("Storing bundle outside of the max uploading time span. appId, now, timestamp", bol.ei(com_fossil_bsy.bEM), Long.valueOf(currentTimeMillis), com_fossil_bsy.bEE);
        }
        try {
            byte[] bArr = new byte[com_fossil_bsy.MW()];
            bci h = bci.m4843h(bArr, 0, bArr.length);
            com_fossil_bsy.mo1264a(h);
            h.MQ();
            bArr = Pb().ai(bArr);
            Pf().Ri().m5439d("Saving bundle, size", Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", com_fossil_bsy.bEM);
            contentValues.put("bundle_end_timestamp", com_fossil_bsy.bEE);
            contentValues.put("data", bArr);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            try {
                if (getWritableDatabase().insert("queue", null, contentValues) != -1) {
                    return true;
                }
                Pf().Rc().m5439d("Failed to insert bundle (got -1). appId", bol.ei(com_fossil_bsy.bEM));
                return false;
            } catch (SQLiteException e) {
                Pf().Rc().m5437a("Error storing bundle. appId", bol.ei(com_fossil_bsy.bEM), e);
                return false;
            }
        } catch (IOException e2) {
            Pf().Rc().m5437a("Data loss. Failed to serialize bundle. appId", bol.ei(com_fossil_bsy.bEM), e2);
            return false;
        }
    }

    public final String aj(long j) {
        Cursor rawQuery;
        Object e;
        Throwable th;
        String str = null;
        OP();
        RA();
        try {
            rawQuery = getWritableDatabase().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf(j)});
            try {
                if (rawQuery.moveToFirst()) {
                    str = rawQuery.getString(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                } else {
                    Pf().Ri().log("No expired configs for apps with pending events");
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    Pf().Rc().m5439d("Error selecting expired configs", e);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            rawQuery = str;
            Pf().Rc().m5439d("Error selecting expired configs", e);
            if (rawQuery != null) {
                rawQuery.close();
            }
            return str;
        } catch (Throwable th3) {
            rawQuery = str;
            th = th3;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
        return str;
    }

    public final void beginTransaction() {
        RA();
        getWritableDatabase().beginTransaction();
    }

    public final List<bnk> m5366c(String str, String[] strArr) {
        Object e;
        Cursor cursor;
        Throwable th;
        OP();
        RA();
        List<bnk> arrayList = new ArrayList();
        Cursor query;
        try {
            String[] strArr2 = new String[]{"app_id", "origin", "name", "value", "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"};
            bnm.PY();
            query = getWritableDatabase().query("conditional_properties", strArr2, str, strArr, null, null, "rowid", "1001");
            try {
                if (query.moveToFirst()) {
                    do {
                        if (arrayList.size() >= bnm.PY()) {
                            Pf().Rc().m5439d("Read more than the max allowed conditional properties, ignoring extra", Integer.valueOf(bnm.PY()));
                            break;
                        }
                        String string = query.getString(0);
                        String string2 = query.getString(1);
                        String string3 = query.getString(2);
                        Object b = m5347b(query, 3);
                        boolean z = query.getInt(4) != 0;
                        String string4 = query.getString(5);
                        long j = query.getLong(6);
                        bnz com_fossil_bnz = (bnz) Pb().m5603b(query.getBlob(7), bnz.CREATOR);
                        long j2 = query.getLong(8);
                        bnz com_fossil_bnz2 = (bnz) Pb().m5603b(query.getBlob(9), bnz.CREATOR);
                        long j3 = query.getLong(10);
                        List<bnk> list = arrayList;
                        list.add(new bnk(string, string2, new bsh(string3, j3, b, string2), j2, z, string4, com_fossil_bnz, j, com_fossil_bnz2, query.getLong(11), (bnz) Pb().m5603b(query.getBlob(12), bnz.CREATOR)));
                    } while (query.moveToNext());
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                }
                if (query != null) {
                    query.close();
                }
                return arrayList;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            try {
                Pf().Rc().m5439d("Error querying conditional user property value", e);
                List<bnk> emptyList = Collections.emptyList();
                if (cursor == null) {
                    return emptyList;
                }
                cursor.close();
                return emptyList;
            } catch (Throwable th3) {
                th = th3;
                query = cursor;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public final List<bsj> m5367d(String str, String str2, String str3) {
        Object obj;
        Object e;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        awa.df(str);
        OP();
        RA();
        List<bsj> arrayList = new ArrayList();
        try {
            List arrayList2 = new ArrayList(3);
            arrayList2.add(str);
            StringBuilder stringBuilder = new StringBuilder("app_id=?");
            if (!TextUtils.isEmpty(str2)) {
                arrayList2.add(str2);
                stringBuilder.append(" and origin=?");
            }
            if (!TextUtils.isEmpty(str3)) {
                arrayList2.add(String.valueOf(str3).concat("*"));
                stringBuilder.append(" and name glob ?");
            }
            String[] strArr = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
            String[] strArr2 = new String[]{"name", "set_timestamp", "value", "origin"};
            bnm.PW();
            Cursor query = getWritableDatabase().query("user_attributes", strArr2, stringBuilder.toString(), strArr, null, null, "rowid", "1001");
            try {
                if (query.moveToFirst()) {
                    while (arrayList.size() < bnm.PW()) {
                        String string;
                        try {
                            String string2 = query.getString(0);
                            long j = query.getLong(1);
                            Object b = m5347b(query, 2);
                            string = query.getString(3);
                            if (b == null) {
                                Pf().Rc().m5438a("(2)Read invalid user property value, ignoring it", bol.ei(str), string, str3);
                            } else {
                                arrayList.add(new bsj(str, string, string2, j, b));
                            }
                            if (!query.moveToNext()) {
                                break;
                            }
                            obj = string;
                        } catch (SQLiteException e2) {
                            e = e2;
                            cursor = query;
                            obj = string;
                        } catch (Throwable th2) {
                            th = th2;
                            cursor2 = query;
                        }
                    }
                    Pf().Rc().m5439d("Read more than the max allowed user properties, ignoring excess", Integer.valueOf(bnm.PW()));
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                }
                if (query != null) {
                    query.close();
                }
                return arrayList;
            } catch (SQLiteException e3) {
                e = e3;
                cursor = query;
            } catch (Throwable th22) {
                th = th22;
                cursor2 = query;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            try {
                Pf().Rc().m5438a("(2)Error querying user properties", bol.ei(str), obj, e);
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public final List<bsj> dY(String str) {
        Object e;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        awa.df(str);
        OP();
        RA();
        List<bsj> arrayList = new ArrayList();
        try {
            Cursor query = getWritableDatabase().query("user_attributes", new String[]{"name", "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(bnm.PW()));
            try {
                if (query.moveToFirst()) {
                    do {
                        String string = query.getString(0);
                        String string2 = query.getString(1);
                        if (string2 == null) {
                            string2 = "";
                        }
                        long j = query.getLong(2);
                        Object b = m5347b(query, 3);
                        if (b == null) {
                            Pf().Rc().m5439d("Read invalid user property value, ignoring it. appId", bol.ei(str));
                        } else {
                            arrayList.add(new bsj(str, string2, string, j, b));
                        }
                    } while (query.moveToNext());
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                }
                if (query != null) {
                    query.close();
                }
                return arrayList;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
            } catch (Throwable th2) {
                th = th2;
                cursor2 = query;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            try {
                Pf().Rc().m5437a("Error querying user properties. appId", bol.ei(str), e);
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public final bng dZ(String str) {
        Object e;
        Throwable th;
        awa.df(str);
        OP();
        RA();
        Cursor query;
        try {
            query = getWritableDatabase().query("apps", new String[]{"app_instance_id", "gmp_app_id", "resettable_device_id_hash", "last_bundle_index", "last_bundle_start_timestamp", "last_bundle_end_timestamp", Constants.APP_VERSION, "app_store", "gmp_version", "dev_cert_hash", "measurement_enabled", "day", "daily_public_events_count", "daily_events_count", "daily_conversions_count", "config_fetched_time", "failed_config_fetch_time", "app_version_int", "firebase_instance_id", "daily_error_events_count", "daily_realtime_events_count", "health_monitor_sample", "android_id"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    bng com_fossil_bng = new bng(this.zzboe, str);
                    com_fossil_bng.dP(query.getString(0));
                    com_fossil_bng.dQ(query.getString(1));
                    com_fossil_bng.dR(query.getString(2));
                    com_fossil_bng.m5323Z(query.getLong(3));
                    com_fossil_bng.m5318U(query.getLong(4));
                    com_fossil_bng.m5319V(query.getLong(5));
                    com_fossil_bng.setAppVersion(query.getString(6));
                    com_fossil_bng.dT(query.getString(7));
                    com_fossil_bng.m5321X(query.getLong(8));
                    com_fossil_bng.m5322Y(query.getLong(9));
                    com_fossil_bng.setMeasurementEnabled((query.isNull(10) ? 1 : query.getInt(10)) != 0);
                    com_fossil_bng.ac(query.getLong(11));
                    com_fossil_bng.ad(query.getLong(12));
                    com_fossil_bng.ae(query.getLong(13));
                    com_fossil_bng.af(query.getLong(14));
                    com_fossil_bng.aa(query.getLong(15));
                    com_fossil_bng.ab(query.getLong(16));
                    com_fossil_bng.m5320W(query.isNull(17) ? -2147483648L : (long) query.getInt(17));
                    com_fossil_bng.dS(query.getString(18));
                    com_fossil_bng.ah(query.getLong(19));
                    com_fossil_bng.ag(query.getLong(20));
                    com_fossil_bng.dU(query.getString(21));
                    com_fossil_bng.ai(query.isNull(22) ? 0 : query.getLong(22));
                    com_fossil_bng.Pi();
                    if (query.moveToNext()) {
                        Pf().Rc().m5439d("Got multiple records for app, expected one. appId", bol.ei(str));
                    }
                    if (query == null) {
                        return com_fossil_bng;
                    }
                    query.close();
                    return com_fossil_bng;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    Pf().Rc().m5437a("Error querying app. appId", bol.ei(str), e);
                    if (query != null) {
                        query.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            Pf().Rc().m5437a("Error querying app. appId", bol.ei(str), e);
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public final List<bnk> m5368e(String str, String str2, String str3) {
        awa.df(str);
        OP();
        RA();
        List arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder stringBuilder = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            stringBuilder.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            stringBuilder.append(" and name glob ?");
        }
        return m5366c(stringBuilder.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    public final long ea(String str) {
        awa.df(str);
        OP();
        RA();
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            String valueOf = String.valueOf(Math.max(0, Math.min(1000000, Ph().m5334b(str, bob.byO))));
            return (long) writableDatabase.delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, valueOf});
        } catch (SQLiteException e) {
            Pf().Rc().m5437a("Error deleting over the limit events. appId", bol.ei(str), e);
            return 0;
        }
    }

    public final byte[] eb(String str) {
        Cursor query;
        Object e;
        Throwable th;
        awa.df(str);
        OP();
        RA();
        try {
            query = getWritableDatabase().query("apps", new String[]{"remote_config"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    byte[] blob = query.getBlob(0);
                    if (query.moveToNext()) {
                        Pf().Rc().m5439d("Got multiple records for app config, expected one. appId", bol.ei(str));
                    }
                    if (query == null) {
                        return blob;
                    }
                    query.close();
                    return blob;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    Pf().Rc().m5437a("Error querying remote config. appId", bol.ei(str), e);
                    if (query != null) {
                        query.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            Pf().Rc().m5437a("Error querying remote config. appId", bol.ei(str), e);
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    final Map<Integer, bsz> ec(String str) {
        Object e;
        Throwable th;
        RA();
        OP();
        awa.df(str);
        Cursor query;
        try {
            query = getWritableDatabase().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str}, null, null, null);
            if (query.moveToFirst()) {
                Map<Integer, bsz> jlVar = new jl();
                do {
                    int i = query.getInt(0);
                    byte[] blob = query.getBlob(1);
                    bch g = bch.m4834g(blob, 0, blob.length);
                    bsz com_fossil_bsz = new bsz();
                    try {
                        com_fossil_bsz.mo1266a(g);
                        try {
                            jlVar.put(Integer.valueOf(i), com_fossil_bsz);
                        } catch (SQLiteException e2) {
                            e = e2;
                        }
                    } catch (IOException e3) {
                        Pf().Rc().m5438a("Failed to merge filter results. appId, audienceId, error", bol.ei(str), Integer.valueOf(i), e3);
                    }
                } while (query.moveToNext());
                if (query == null) {
                    return jlVar;
                }
                query.close();
                return jlVar;
            }
            if (query != null) {
                query.close();
            }
            return null;
        } catch (SQLiteException e4) {
            e = e4;
            query = null;
            try {
                Pf().Rc().m5437a("Database error querying filter results. appId", bol.ei(str), e);
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public final long ed(String str) {
        awa.df(str);
        return m5335a("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    public final void endTransaction() {
        RA();
        getWritableDatabase().endTransaction();
    }

    final SQLiteDatabase getWritableDatabase() {
        OP();
        try {
            return this.bxT.getWritableDatabase();
        } catch (SQLiteException e) {
            Pf().Re().m5439d("Error opening database", e);
            throw e;
        }
    }

    public final List<Pair<bsy, Long>> m5369p(String str, int i, int i2) {
        List<Pair<bsy, Long>> arrayList;
        Object e;
        Cursor cursor;
        Throwable th;
        boolean z = true;
        OP();
        RA();
        awa.aY(i > 0);
        if (i2 <= 0) {
            z = false;
        }
        awa.aY(z);
        awa.df(str);
        Cursor query;
        try {
            query = getWritableDatabase().query("queue", new String[]{"rowid", "data"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i));
            try {
                if (query.moveToFirst()) {
                    arrayList = new ArrayList();
                    int i3 = 0;
                    while (true) {
                        long j = query.getLong(0);
                        int length;
                        try {
                            byte[] aj = Pb().aj(query.getBlob(1));
                            if (!arrayList.isEmpty() && aj.length + i3 > i2) {
                                break;
                            }
                            bch g = bch.m4834g(aj, 0, aj.length);
                            bsy com_fossil_bsy = new bsy();
                            try {
                                com_fossil_bsy.mo1266a(g);
                                length = aj.length + i3;
                                arrayList.add(Pair.create(com_fossil_bsy, Long.valueOf(j)));
                            } catch (IOException e2) {
                                Pf().Rc().m5437a("Failed to merge queued bundle. appId", bol.ei(str), e2);
                                length = i3;
                            }
                            if (!query.moveToNext() || length > i2) {
                                break;
                            }
                            i3 = length;
                        } catch (IOException e22) {
                            Pf().Rc().m5437a("Failed to unzip queued bundle. appId", bol.ei(str), e22);
                            length = i3;
                        }
                    }
                    if (query != null) {
                        query.close();
                    }
                } else {
                    arrayList = Collections.emptyList();
                    if (query != null) {
                        query.close();
                    }
                }
            } catch (SQLiteException e3) {
                e = e3;
                cursor = query;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            try {
                Pf().Rc().m5437a("Error querying bundles. appId", bol.ei(str), e);
                arrayList = Collections.emptyList();
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (Throwable th3) {
                th = th3;
                query = cursor;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return arrayList;
    }

    public final void setTransactionSuccessful() {
        RA();
        getWritableDatabase().setTransactionSuccessful();
    }
}
