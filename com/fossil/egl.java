package com.fossil;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.j256.ormlite.field.FieldType;
import com.misfit.frameworks.common.constants.Constants;
import com.ua.sdk.cache.DiskCache;
import com.ua.sdk.cache.DiskCache.State;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class egl<T extends ecm> extends SQLiteOpenHelper implements DiskCache<T> {
    private static final Integer dGO = Integer.valueOf(0);
    private static final Integer dGP = Integer.valueOf(1);
    private static final Integer dGQ = Integer.valueOf(2);
    private static final Integer dGR = Integer.valueOf(4);
    private final String dGS;
    private final String dGT;
    private final String[] dGU;

    static /* synthetic */ class C33871 {
        static final /* synthetic */ int[] dGV = new int[State.values().length];

        static {
            try {
                dGV[State.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                dGV[State.CREATED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                dGV[State.MODIFIED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                dGV[State.SYNCED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                dGV[State.DELETED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public abstract void mo2908a(SQLiteDatabase sQLiteDatabase, int i, int i2);

    protected abstract void mo2909d(SQLiteDatabase sQLiteDatabase);

    protected abstract ContentValues mo2910e(T t);

    protected abstract T mo2911g(Cursor cursor);

    protected egl(Context context, String str, String str2, String[] strArr, String str3, int i) {
        super(context, str, null, co(0, i));
        this.dGS = str2;
        this.dGT = str3;
        this.dGU = strArr;
        if (Arrays.binarySearch(strArr, FieldType.FOREIGN_ID_FIELD_SUFFIX) < 0) {
            throw new IllegalArgumentException("entityCols do not contain _id");
        }
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        m10686e(sQLiteDatabase);
        mo2909d(sQLiteDatabase);
    }

    private void m10686e(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE links(foreign_key INTEGER NOT NULL,relation TEXT,href TEXT,id TEXT,name TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE meta(id INTEGER PRIMARY KEY UNIQUE NOT NULL,pending_operation NUMERIC,last_update_time_ms NUMERIC)");
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (nQ(i2) > nQ(i)) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS links");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS meta");
            m10686e(sQLiteDatabase);
        }
        int nR = nR(i2);
        int nR2 = nR(i);
        if (nR > nR2) {
            mo2908a(sQLiteDatabase, nR2, nR);
        }
    }

    private static int co(int i, int i2) {
        return (i2 << 15) | i;
    }

    private static int nQ(int i) {
        return i & 8191;
    }

    private static int nR(int i) {
        return (536805376 & i) >> 15;
    }

    public static String m10668a(String str, egn[] com_fossil_egnArr) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CREATE TABLE ");
        stringBuilder.append(str);
        stringBuilder.append(" (");
        for (int i = 0; i < com_fossil_egnArr.length; i++) {
            egn com_fossil_egn = com_fossil_egnArr[i];
            stringBuilder.append(com_fossil_egn.getColumnName());
            stringBuilder.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            stringBuilder.append(com_fossil_egn.aDe());
            if (i + 1 < com_fossil_egnArr.length) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public static String[] m10681a(egn[] com_fossil_egnArr) {
        String[] strArr = new String[com_fossil_egnArr.length];
        for (int i = 0; i < com_fossil_egnArr.length; i++) {
            strArr[i] = com_fossil_egnArr[i].getColumnName();
        }
        return strArr;
    }

    private void m10676a(SQLiteDatabase sQLiteDatabase, long j) {
        m10677a(sQLiteDatabase, j, System.currentTimeMillis(), State.SYNCED);
    }

    private void m10679a(SQLiteDatabase sQLiteDatabase, long j, State state) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("pending_operation", m10666a(state));
        if (sQLiteDatabase.update(Constants.META, contentValues, "id=?", new String[]{String.valueOf(j)}) == 0) {
            contentValues.put("id", Long.valueOf(j));
            sQLiteDatabase.insert(Constants.META, null, contentValues);
        }
    }

    private void m10677a(SQLiteDatabase sQLiteDatabase, long j, long j2, State state) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Long.valueOf(j));
        contentValues.put("pending_operation", m10666a(state));
        contentValues.put("last_update_time_ms", Long.valueOf(j2));
        sQLiteDatabase.insertWithOnConflict(Constants.META, null, contentValues, 5);
    }

    private Integer m10666a(State state) {
        if (state == null) {
            return null;
        }
        switch (C33871.dGV[state.ordinal()]) {
            case 1:
                return null;
            case 2:
                return dGP;
            case 3:
                return dGQ;
            case 4:
                return dGO;
            case 5:
                return dGR;
            default:
                return null;
        }
    }

    private void m10678a(SQLiteDatabase sQLiteDatabase, long j, eil com_fossil_eil) {
        SQLiteStatement compileStatement = sQLiteDatabase.compileStatement("INSERT INTO links VALUES (?,?,?,?,?);");
        try {
            Map aDq = com_fossil_eil.aDq();
            if (aDq != null) {
                for (String str : aDq.keySet()) {
                    for (eiu com_fossil_eiu : (List) aDq.get(str)) {
                        compileStatement.clearBindings();
                        compileStatement.bindLong(1, j);
                        compileStatement.bindString(2, str);
                        m10680a(compileStatement, 3, com_fossil_eiu.getHref());
                        m10680a(compileStatement, 4, com_fossil_eiu.getId());
                        m10680a(compileStatement, 5, com_fossil_eiu.getName());
                        compileStatement.execute();
                    }
                }
            }
            compileStatement.close();
        } catch (Throwable th) {
            compileStatement.close();
        }
    }

    private void m10680a(SQLiteStatement sQLiteStatement, int i, String str) {
        if (str != null) {
            sQLiteStatement.bindString(i, str);
        } else {
            sQLiteStatement.bindNull(i);
        }
    }

    protected Map<String, ArrayList<eiu>> m10696b(SQLiteDatabase sQLiteDatabase, long j) {
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        Cursor query = sQLiteDatabase2.query("links", null, "foreign_key=?", new String[]{String.valueOf(j)}, null, null, null, null);
        Map<String, ArrayList<eiu>> hashMap = new HashMap();
        while (query.moveToNext()) {
            try {
                String string = query.getString(query.getColumnIndex("relation"));
                eiu com_fossil_eiu = new eiu(query.getString(query.getColumnIndex("href")), query.getString(query.getColumnIndex("id")), query.getString(query.getColumnIndex("name")));
                ArrayList arrayList = (ArrayList) hashMap.get(string);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    hashMap.put(string, arrayList);
                }
                arrayList.add(com_fossil_eiu);
            } finally {
                query.close();
            }
        }
        return hashMap;
    }

    protected void m10698c(SQLiteDatabase sQLiteDatabase, long j) {
        if (j >= 0) {
            sQLiteDatabase.delete("links", "foreign_key=?", new String[]{Long.toString(j)});
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected long m10689a(android.database.sqlite.SQLiteDatabase r11, com.fossil.ecj r12) {
        /*
        r10 = this;
        r2 = -1;
        r5 = 0;
        r4 = 0;
        r0 = r12 instanceof com.fossil.eiv;
        if (r0 == 0) goto L_0x006f;
    L_0x0008:
        r0 = r12;
        r0 = (com.fossil.eiv) r0;
        r0 = r0.checkCache();
        if (r0 == 0) goto L_0x006f;
    L_0x0011:
        r0 = r12;
        r0 = (com.fossil.eiv) r0;
        r8 = r0.aDp();
        r0 = 0;
        r0 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1));
        if (r0 < 0) goto L_0x006f;
    L_0x001e:
        r0 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1));
        if (r0 != 0) goto L_0x0067;
    L_0x0022:
        r0 = r12.getId();
        if (r0 == 0) goto L_0x0067;
    L_0x0028:
        r1 = r10.dGS;
        r2 = 1;
        r2 = new java.lang.String[r2];
        r3 = "_id";
        r2[r5] = r3;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r5 = r10.dGT;
        r3 = r3.append(r5);
        r5 = "= '";
        r3 = r3.append(r5);
        r0 = r3.append(r0);
        r3 = "'";
        r0 = r0.append(r3);
        r3 = r0.toString();
        r0 = r11;
        r5 = r4;
        r6 = r4;
        r7 = r4;
        r2 = r0.query(r1, r2, r3, r4, r5, r6, r7);
        r0 = r2.moveToFirst();	 Catch:{ all -> 0x0068 }
        if (r0 == 0) goto L_0x006d;
    L_0x005e:
        r0 = 0;
        r0 = r2.getLong(r0);	 Catch:{ all -> 0x0068 }
    L_0x0063:
        r2.close();
        r8 = r0;
    L_0x0067:
        return r8;
    L_0x0068:
        r0 = move-exception;
        r2.close();
        throw r0;
    L_0x006d:
        r0 = r8;
        goto L_0x0063;
    L_0x006f:
        r8 = r2;
        goto L_0x001e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.egl.a(android.database.sqlite.SQLiteDatabase, com.fossil.ecj):long");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized T m10695b(com.fossil.ecj r13) {
        /*
        r12 = this;
        r5 = 1;
        r4 = 0;
        r11 = 0;
        monitor-enter(r12);
        r2 = "ref";
        com.fossil.eiy.m10771e(r13, r2);	 Catch:{ all -> 0x00ab }
        r2 = r13 instanceof com.fossil.eiv;	 Catch:{ Throwable -> 0x0099, all -> 0x00ae }
        if (r2 == 0) goto L_0x00d2;
    L_0x000d:
        r0 = r13;
        r0 = (com.fossil.eiv) r0;	 Catch:{ Throwable -> 0x0099, all -> 0x00ae }
        r2 = r0;
        r2 = r2.checkCache();	 Catch:{ Throwable -> 0x0099, all -> 0x00ae }
        if (r2 != 0) goto L_0x0084;
    L_0x0017:
        r2 = r11;
        r3 = r11;
        r5 = r4;
    L_0x001a:
        if (r5 == 0) goto L_0x00cd;
    L_0x001c:
        if (r3 != 0) goto L_0x0024;
    L_0x001e:
        r3 = r12.dGT;	 Catch:{ Throwable -> 0x0099, all -> 0x00ae }
        r2 = r13.getId();	 Catch:{ Throwable -> 0x0099, all -> 0x00ae }
    L_0x0024:
        if (r2 != 0) goto L_0x00cd;
    L_0x0026:
        r7 = r2;
        r5 = r3;
        r2 = r4;
    L_0x0029:
        if (r2 == 0) goto L_0x00ca;
    L_0x002b:
        r2 = r12.getReadableDatabase();	 Catch:{ Throwable -> 0x0099, all -> 0x00ae }
        r3 = r12.dGS;	 Catch:{ Throwable -> 0x0099, all -> 0x00ae }
        r4 = r12.dGU;	 Catch:{ Throwable -> 0x0099, all -> 0x00ae }
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0099, all -> 0x00ae }
        r6.<init>();	 Catch:{ Throwable -> 0x0099, all -> 0x00ae }
        r5 = r6.append(r5);	 Catch:{ Throwable -> 0x0099, all -> 0x00ae }
        r6 = "=?";
        r5 = r5.append(r6);	 Catch:{ Throwable -> 0x0099, all -> 0x00ae }
        r5 = r5.toString();	 Catch:{ Throwable -> 0x0099, all -> 0x00ae }
        r6 = 1;
        r6 = new java.lang.String[r6];	 Catch:{ Throwable -> 0x0099, all -> 0x00ae }
        r8 = 0;
        r6[r8] = r7;	 Catch:{ Throwable -> 0x0099, all -> 0x00ae }
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r10 = 0;
        r5 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ Throwable -> 0x0099, all -> 0x00ae }
        if (r5 == 0) goto L_0x00c8;
    L_0x0056:
        r3 = r5.moveToFirst();	 Catch:{ Throwable -> 0x00be, all -> 0x00b8 }
        if (r3 == 0) goto L_0x00c8;
    L_0x005c:
        r4 = r12.mo2911g(r5);	 Catch:{ Throwable -> 0x00be, all -> 0x00b8 }
        r3 = r4 instanceof com.fossil.eil;	 Catch:{ Throwable -> 0x00c3, all -> 0x00b8 }
        if (r3 == 0) goto L_0x0079;
    L_0x0064:
        r3 = "_id";
        r3 = r5.getColumnIndex(r3);	 Catch:{ Throwable -> 0x00c3, all -> 0x00b8 }
        r6 = r5.getLong(r3);	 Catch:{ Throwable -> 0x00c3, all -> 0x00b8 }
        r0 = r4;
        r0 = (com.fossil.eil) r0;	 Catch:{ Throwable -> 0x00c3, all -> 0x00b8 }
        r3 = r0;
        r2 = r12.m10696b(r2, r6);	 Catch:{ Throwable -> 0x00c3, all -> 0x00b8 }
        r3.m10510A(r2);	 Catch:{ Throwable -> 0x00c3, all -> 0x00b8 }
    L_0x0079:
        r2 = r4;
    L_0x007a:
        if (r5 == 0) goto L_0x007f;
    L_0x007c:
        r5.close();	 Catch:{ all -> 0x00ab }
    L_0x007f:
        r12.close();	 Catch:{ all -> 0x00ab }
    L_0x0082:
        monitor-exit(r12);
        return r2;
    L_0x0084:
        r0 = r13;
        r0 = (com.fossil.eiv) r0;	 Catch:{ Throwable -> 0x0099, all -> 0x00ae }
        r2 = r0;
        r6 = r2.aDp();	 Catch:{ Throwable -> 0x0099, all -> 0x00ae }
        r2 = 0;
        r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1));
        if (r2 < 0) goto L_0x00d2;
    L_0x0092:
        r3 = "_id";
        r2 = java.lang.String.valueOf(r6);	 Catch:{ Throwable -> 0x0099, all -> 0x00ae }
        goto L_0x001a;
    L_0x0099:
        r2 = move-exception;
        r3 = r2;
        r4 = r11;
        r2 = r11;
    L_0x009d:
        r5 = "Unable to get entity.";
        com.fossil.ecq.m10489d(r5, r3);	 Catch:{ all -> 0x00bb }
        if (r4 == 0) goto L_0x00a7;
    L_0x00a4:
        r4.close();	 Catch:{ all -> 0x00ab }
    L_0x00a7:
        r12.close();	 Catch:{ all -> 0x00ab }
        goto L_0x0082;
    L_0x00ab:
        r2 = move-exception;
        monitor-exit(r12);
        throw r2;
    L_0x00ae:
        r2 = move-exception;
    L_0x00af:
        if (r11 == 0) goto L_0x00b4;
    L_0x00b1:
        r11.close();	 Catch:{ all -> 0x00ab }
    L_0x00b4:
        r12.close();	 Catch:{ all -> 0x00ab }
        throw r2;	 Catch:{ all -> 0x00ab }
    L_0x00b8:
        r2 = move-exception;
        r11 = r5;
        goto L_0x00af;
    L_0x00bb:
        r2 = move-exception;
        r11 = r4;
        goto L_0x00af;
    L_0x00be:
        r2 = move-exception;
        r3 = r2;
        r4 = r5;
        r2 = r11;
        goto L_0x009d;
    L_0x00c3:
        r2 = move-exception;
        r3 = r2;
        r2 = r4;
        r4 = r5;
        goto L_0x009d;
    L_0x00c8:
        r2 = r11;
        goto L_0x007a;
    L_0x00ca:
        r5 = r11;
        r2 = r11;
        goto L_0x007a;
    L_0x00cd:
        r7 = r2;
        r2 = r5;
        r5 = r3;
        goto L_0x0029;
    L_0x00d2:
        r2 = r11;
        r3 = r11;
        goto L_0x001a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.egl.b(com.fossil.ecj):T");
    }

    protected ContentValues m10694b(long j, T t) {
        ContentValues e = mo2910e((ecm) t);
        if (j >= 0) {
            e.put(FieldType.FOREIGN_ID_FIELD_SUFFIX, Long.valueOf(j));
        } else if (e.containsKey(FieldType.FOREIGN_ID_FIELD_SUFFIX)) {
            e.remove(FieldType.FOREIGN_ID_FIELD_SUFFIX);
        }
        return e;
    }

    protected void m10693a(SQLiteDatabase sQLiteDatabase, long j, T t) {
        if (sQLiteDatabase.update(this.dGS, m10694b(j, (ecm) t), "_id=" + j, null) >= 1) {
            m10698c(sQLiteDatabase, j);
            if (t instanceof eil) {
                ((eil) t).aV(j);
                m10678a(sQLiteDatabase, j, (eil) t);
                return;
            }
            return;
        }
        ecq.error("Failed to update entity. type=%s id=%s rowsChanged=%s", t.getClass().getSimpleName(), Long.valueOf(j), Integer.valueOf(sQLiteDatabase.update(this.dGS, m10694b(j, (ecm) t), "_id=" + j, null)));
    }

    protected long m10690a(SQLiteDatabase sQLiteDatabase, T t) {
        long insertWithOnConflict = sQLiteDatabase.insertWithOnConflict(this.dGS, FieldType.FOREIGN_ID_FIELD_SUFFIX, m10694b(m10689a(sQLiteDatabase, t.aCy()), (ecm) t), 5);
        m10698c(sQLiteDatabase, insertWithOnConflict);
        if (t instanceof eil) {
            ((eil) t).aV(insertWithOnConflict);
            m10678a(sQLiteDatabase, insertWithOnConflict, (eil) t);
        }
        return insertWithOnConflict;
    }

    public synchronized void m10699c(T t) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = getWritableDatabase();
            sQLiteDatabase.beginTransaction();
            m10676a(sQLiteDatabase, m10690a(sQLiteDatabase, (ecm) t));
            sQLiteDatabase.setTransactionSuccessful();
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
            close();
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
            close();
        }
    }

    private static void m10688f(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.endTransaction();
        } catch (Throwable th) {
            ecq.m10489d("Failed to end transaction.", th);
        }
    }

    public synchronized void m10691a(long j, T t) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = getWritableDatabase();
            sQLiteDatabase.beginTransaction();
            m10693a(sQLiteDatabase, j, (ecm) t);
            m10676a(sQLiteDatabase, j);
            sQLiteDatabase.setTransactionSuccessful();
            if (sQLiteDatabase != null) {
                m10688f(sQLiteDatabase);
            }
            close();
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                m10688f(sQLiteDatabase);
            }
            close();
        }
    }

    public synchronized long m10701d(T t) {
        long a;
        Throwable th;
        Throwable th2;
        SQLiteDatabase writableDatabase;
        try {
            writableDatabase = getWritableDatabase();
            try {
                writableDatabase.beginTransaction();
                a = m10690a(writableDatabase, (ecm) t);
                try {
                    m10679a(writableDatabase, a, State.CREATED);
                    writableDatabase.setTransactionSuccessful();
                    if (writableDatabase != null) {
                        m10688f(writableDatabase);
                    }
                    close();
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        ecq.m10489d("Failed to put in cache for create.", th);
                        if (writableDatabase != null) {
                            m10688f(writableDatabase);
                        }
                        close();
                        return a;
                    } catch (Throwable th4) {
                        th2 = th4;
                        if (writableDatabase != null) {
                            m10688f(writableDatabase);
                        }
                        close();
                        throw th2;
                    }
                }
            } catch (Throwable th22) {
                th = th22;
                a = -1;
                ecq.m10489d("Failed to put in cache for create.", th);
                if (writableDatabase != null) {
                    m10688f(writableDatabase);
                }
                close();
                return a;
            }
        } catch (Throwable th5) {
            th22 = th5;
            writableDatabase = null;
            if (writableDatabase != null) {
                m10688f(writableDatabase);
            }
            close();
            throw th22;
        }
        return a;
    }

    public synchronized long m10700d(ecj com_fossil_ecj) {
        Cursor query;
        long j;
        Throwable th;
        Cursor cursor = null;
        synchronized (this) {
            if (com_fossil_ecj != null) {
                try {
                    SQLiteDatabase readableDatabase = getReadableDatabase();
                    if (m10689a(readableDatabase, com_fossil_ecj) >= 0) {
                        query = readableDatabase.query(Constants.META, new String[]{"last_update_time_ms"}, "id=?", new String[]{Long.toString(r6)}, null, null, null);
                        try {
                            if (!query.moveToFirst() || query.isNull(0)) {
                                cursor = query;
                                j = -1;
                            } else {
                                cursor = query;
                                j = query.getLong(0);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                ecq.m10489d("Unable to get last synced time.", th);
                                if (query != null) {
                                    query.close();
                                }
                                close();
                                j = -1;
                                return j;
                            } catch (Throwable th3) {
                                th = th3;
                                cursor = query;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                close();
                                throw th;
                            }
                        }
                    }
                    j = -1;
                    if (cursor != null) {
                        cursor.close();
                    }
                    close();
                } catch (Throwable th4) {
                    th = th4;
                    if (cursor != null) {
                        cursor.close();
                    }
                    close();
                    throw th;
                }
            }
            j = -1;
        }
        return j;
    }

    public long m10697c(ecj com_fossil_ecj) {
        if (com_fossil_ecj == null) {
            return -1;
        }
        long d = m10700d(com_fossil_ecj);
        if (d >= 0) {
            return System.currentTimeMillis() - d;
        }
        return -1;
    }

    public static String m10667a(int i, Cursor cursor) {
        if (cursor.isNull(i)) {
            return null;
        }
        return cursor.getString(i);
    }

    public static Boolean m10682b(int i, Cursor cursor) {
        boolean z = true;
        if (cursor.isNull(i)) {
            return null;
        }
        if (cursor.getInt(i) != 1) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    public static Long m10683c(int i, Cursor cursor) {
        if (cursor.isNull(i)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i));
    }

    public static Double m10684d(int i, Cursor cursor) {
        if (cursor.isNull(i)) {
            return null;
        }
        return Double.valueOf(cursor.getDouble(i));
    }

    public static Date m10685e(int i, Cursor cursor) {
        if (cursor.isNull(i)) {
            return null;
        }
        return new Date(cursor.getLong(i));
    }

    public static ech m10687f(int i, Cursor cursor) {
        if (cursor.isNull(i)) {
            return null;
        }
        return ech.lm(cursor.getString(i));
    }

    public static <T extends Enum<T>> T m10665a(int i, Cursor cursor, Class<T> cls) {
        if (cursor.isNull(i)) {
            return null;
        }
        return Enum.valueOf(cls, cursor.getString(i));
    }

    public static void m10674a(ContentValues contentValues, String str, String str2) {
        if (str2 == null) {
            contentValues.putNull(str);
        } else {
            contentValues.put(str, str2);
        }
    }

    public static void m10670a(ContentValues contentValues, String str, Boolean bool) {
        if (bool == null) {
            contentValues.putNull(str);
        } else {
            contentValues.put(str, bool);
        }
    }

    public static void m10673a(ContentValues contentValues, String str, Long l) {
        if (l == null) {
            contentValues.putNull(str);
        } else {
            contentValues.put(str, l);
        }
    }

    public static void m10671a(ContentValues contentValues, String str, Double d) {
        if (d == null) {
            contentValues.putNull(str);
        } else {
            contentValues.put(str, d);
        }
    }

    public static void m10675a(ContentValues contentValues, String str, Date date) {
        if (date == null) {
            contentValues.putNull(str);
        } else {
            contentValues.put(str, Long.valueOf(date.getTime()));
        }
    }

    public static void m10669a(ContentValues contentValues, String str, ech com_fossil_ech) {
        if (com_fossil_ech == null) {
            contentValues.putNull(str);
        } else {
            contentValues.put(str, com_fossil_ech.toString());
        }
    }

    public static void m10672a(ContentValues contentValues, String str, Enum<?> enumR) {
        if (enumR == null) {
            contentValues.putNull(str);
        } else {
            contentValues.put(str, enumR.toString());
        }
    }
}
