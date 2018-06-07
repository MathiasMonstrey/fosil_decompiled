package com.fossil;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.appevents.AppEventsConstants;
import com.misfit.frameworks.common.constants.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class ead {
    private static eaq dCu = ebb.aCr();
    private static Context dCv = null;
    private static ead dCw = null;
    volatile int f1488a = 0;
    private String aXl = "";
    private boolean aYq = false;
    private String aYv = "";
    private eav dBV = null;
    private eam dCr = null;
    private eam dCs = null;
    ear dCt = null;
    private ConcurrentHashMap<dzm, String> dCx = null;
    private HashMap<String, String> dCy = new HashMap();
    private int f1489k = 0;

    private ead(Context context) {
        try {
            this.dBV = new eav();
            dCv = context.getApplicationContext();
            this.dCx = new ConcurrentHashMap();
            this.aXl = ebb.dQ(context);
            this.aYv = "pri_" + ebb.dQ(context);
            this.dCr = new eam(dCv, this.aXl);
            this.dCs = new eam(dCv, this.aYv);
            m10405a(true);
            m10405a(false);
            HW();
            dz(dCv);
            m10415d();
            HQ();
        } catch (Throwable th) {
            dCu.m10419g(th);
        }
    }

    private synchronized void m10394F(int i, boolean z) {
        try {
            if (this.f1488a > 0 && i > 0 && !dzg.Ja()) {
                if (dze.aBG()) {
                    dCu.cY("Load " + this.f1488a + " unsent events");
                }
                List arrayList = new ArrayList(i);
                m10408c(arrayList, i, z);
                if (arrayList.size() > 0) {
                    if (dze.aBG()) {
                        dCu.cY("Peek " + arrayList.size() + " unsent events.");
                    }
                    m10406b(arrayList, 2, z);
                    ebo.ei(dCv).m10461b(arrayList, new eak(this, arrayList, z));
                }
            }
        } catch (Throwable th) {
            dCu.m10419g(th);
        }
    }

    private void m10395G(int i, boolean z) {
        int IS = i == -1 ? !z ? IS() : HX() : i;
        if (IS > 0) {
            int aBO = (dze.aBO() * 60) * dze.aBM();
            if (IS > aBO && aBO > 0) {
                IS = aBO;
            }
            int a = dze.m10337a();
            int i2 = IS / a;
            int i3 = IS % a;
            if (dze.aBG()) {
                dCu.cY("sentStoreEventsByDb sendNumbers=" + IS + ",important=" + z + ",maxSendNumPerFor1Period=" + aBO + ",maxCount=" + i2 + ",restNumbers=" + i3);
            }
            for (IS = 0; IS < i2; IS++) {
                m10394F(a, z);
            }
            if (i3 > 0) {
                m10394F(i3, z);
            }
        }
    }

    private void HP() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.fossil.ead.HP():void. bs: [B:42:0x011b, B:53:0x0133]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r9 = this;
        r1 = 0;
        r0 = r9.aYq;
        if (r0 == 0) goto L_0x0006;
    L_0x0005:
        return;
    L_0x0006:
        r2 = r9.dCx;
        monitor-enter(r2);
        r0 = r9.dCx;	 Catch:{ all -> 0x0013 }
        r0 = r0.size();	 Catch:{ all -> 0x0013 }
        if (r0 != 0) goto L_0x0016;	 Catch:{ all -> 0x0013 }
    L_0x0011:
        monitor-exit(r2);	 Catch:{ all -> 0x0013 }
        goto L_0x0005;	 Catch:{ all -> 0x0013 }
    L_0x0013:
        r0 = move-exception;	 Catch:{ all -> 0x0013 }
        monitor-exit(r2);	 Catch:{ all -> 0x0013 }
        throw r0;
    L_0x0016:
        r0 = 1;
        r9.aYq = r0;	 Catch:{ all -> 0x0013 }
        r0 = com.fossil.dze.aBG();	 Catch:{ all -> 0x0013 }
        if (r0 == 0) goto L_0x0051;	 Catch:{ all -> 0x0013 }
    L_0x001f:
        r0 = dCu;	 Catch:{ all -> 0x0013 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0013 }
        r4 = "insert ";	 Catch:{ all -> 0x0013 }
        r3.<init>(r4);	 Catch:{ all -> 0x0013 }
        r4 = r9.dCx;	 Catch:{ all -> 0x0013 }
        r4 = r4.size();	 Catch:{ all -> 0x0013 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0013 }
        r4 = " events ,numEventsCachedInMemory:";	 Catch:{ all -> 0x0013 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0013 }
        r4 = com.fossil.dze.bai;	 Catch:{ all -> 0x0013 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0013 }
        r4 = ",numStoredEvents:";	 Catch:{ all -> 0x0013 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0013 }
        r4 = r9.f1488a;	 Catch:{ all -> 0x0013 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0013 }
        r3 = r3.toString();	 Catch:{ all -> 0x0013 }
        r0.cY(r3);	 Catch:{ all -> 0x0013 }
    L_0x0051:
        r0 = r9.dCr;	 Catch:{ Throwable -> 0x00ca }
        r1 = r0.getWritableDatabase();	 Catch:{ Throwable -> 0x00ca }
        r1.beginTransaction();	 Catch:{ Throwable -> 0x00ca }
        r0 = r9.dCx;	 Catch:{ Throwable -> 0x00ca }
        r0 = r0.entrySet();	 Catch:{ Throwable -> 0x00ca }
        r3 = r0.iterator();	 Catch:{ Throwable -> 0x00ca }
    L_0x0064:
        r0 = r3.hasNext();	 Catch:{ Throwable -> 0x00ca }
        if (r0 == 0) goto L_0x0116;	 Catch:{ Throwable -> 0x00ca }
    L_0x006a:
        r0 = r3.next();	 Catch:{ Throwable -> 0x00ca }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ Throwable -> 0x00ca }
        r0 = r0.getKey();	 Catch:{ Throwable -> 0x00ca }
        r0 = (com.fossil.dzm) r0;	 Catch:{ Throwable -> 0x00ca }
        r4 = new android.content.ContentValues;	 Catch:{ Throwable -> 0x00ca }
        r4.<init>();	 Catch:{ Throwable -> 0x00ca }
        r5 = r0.Iw();	 Catch:{ Throwable -> 0x00ca }
        r6 = com.fossil.dze.aBG();	 Catch:{ Throwable -> 0x00ca }
        if (r6 == 0) goto L_0x0099;	 Catch:{ Throwable -> 0x00ca }
    L_0x0085:
        r6 = dCu;	 Catch:{ Throwable -> 0x00ca }
        r7 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00ca }
        r8 = "insert content:";	 Catch:{ Throwable -> 0x00ca }
        r7.<init>(r8);	 Catch:{ Throwable -> 0x00ca }
        r7 = r7.append(r5);	 Catch:{ Throwable -> 0x00ca }
        r7 = r7.toString();	 Catch:{ Throwable -> 0x00ca }
        r6.cY(r7);	 Catch:{ Throwable -> 0x00ca }
    L_0x0099:
        r5 = com.fossil.ebh.cx(r5);	 Catch:{ Throwable -> 0x00ca }
        r6 = "content";	 Catch:{ Throwable -> 0x00ca }
        r4.put(r6, r5);	 Catch:{ Throwable -> 0x00ca }
        r5 = "send_count";	 Catch:{ Throwable -> 0x00ca }
        r6 = "0";	 Catch:{ Throwable -> 0x00ca }
        r4.put(r5, r6);	 Catch:{ Throwable -> 0x00ca }
        r5 = "status";	 Catch:{ Throwable -> 0x00ca }
        r6 = 1;	 Catch:{ Throwable -> 0x00ca }
        r6 = java.lang.Integer.toString(r6);	 Catch:{ Throwable -> 0x00ca }
        r4.put(r5, r6);	 Catch:{ Throwable -> 0x00ca }
        r5 = "timestamp";	 Catch:{ Throwable -> 0x00ca }
        r6 = r0.IL();	 Catch:{ Throwable -> 0x00ca }
        r0 = java.lang.Long.valueOf(r6);	 Catch:{ Throwable -> 0x00ca }
        r4.put(r5, r0);	 Catch:{ Throwable -> 0x00ca }
        r0 = "events";	 Catch:{ Throwable -> 0x00ca }
        r5 = 0;	 Catch:{ Throwable -> 0x00ca }
        r1.insert(r0, r5, r4);	 Catch:{ Throwable -> 0x00ca }
        r3.remove();	 Catch:{ Throwable -> 0x00ca }
        goto L_0x0064;
    L_0x00ca:
        r0 = move-exception;
        r3 = dCu;	 Catch:{ all -> 0x0130 }
        r3.m10419g(r0);	 Catch:{ all -> 0x0130 }
        if (r1 == 0) goto L_0x00d8;
    L_0x00d2:
        r1.endTransaction();	 Catch:{ Throwable -> 0x0129 }
        r9.HW();	 Catch:{ Throwable -> 0x0129 }
    L_0x00d8:
        r0 = 0;
        r9.aYq = r0;	 Catch:{ all -> 0x0013 }
        r0 = com.fossil.dze.aBG();	 Catch:{ all -> 0x0013 }
        if (r0 == 0) goto L_0x0113;	 Catch:{ all -> 0x0013 }
    L_0x00e1:
        r0 = dCu;	 Catch:{ all -> 0x0013 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0013 }
        r3 = "after insert, cacheEventsInMemory.size():";	 Catch:{ all -> 0x0013 }
        r1.<init>(r3);	 Catch:{ all -> 0x0013 }
        r3 = r9.dCx;	 Catch:{ all -> 0x0013 }
        r3 = r3.size();	 Catch:{ all -> 0x0013 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x0013 }
        r3 = ",numEventsCachedInMemory:";	 Catch:{ all -> 0x0013 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x0013 }
        r3 = com.fossil.dze.bai;	 Catch:{ all -> 0x0013 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x0013 }
        r3 = ",numStoredEvents:";	 Catch:{ all -> 0x0013 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x0013 }
        r3 = r9.f1488a;	 Catch:{ all -> 0x0013 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x0013 }
        r1 = r1.toString();	 Catch:{ all -> 0x0013 }
        r0.cY(r1);	 Catch:{ all -> 0x0013 }
    L_0x0113:
        monitor-exit(r2);	 Catch:{ all -> 0x0013 }
        goto L_0x0005;
    L_0x0116:
        r1.setTransactionSuccessful();	 Catch:{ Throwable -> 0x00ca }
        if (r1 == 0) goto L_0x00d8;
    L_0x011b:
        r1.endTransaction();	 Catch:{ Throwable -> 0x0122 }
        r9.HW();	 Catch:{ Throwable -> 0x0122 }
        goto L_0x00d8;
    L_0x0122:
        r0 = move-exception;
        r1 = dCu;	 Catch:{ all -> 0x0013 }
        r1.m10419g(r0);	 Catch:{ all -> 0x0013 }
        goto L_0x00d8;	 Catch:{ all -> 0x0013 }
    L_0x0129:
        r0 = move-exception;	 Catch:{ all -> 0x0013 }
        r1 = dCu;	 Catch:{ all -> 0x0013 }
        r1.m10419g(r0);	 Catch:{ all -> 0x0013 }
        goto L_0x00d8;
    L_0x0130:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0139;
    L_0x0133:
        r1.endTransaction();	 Catch:{ Throwable -> 0x013a }
        r9.HW();	 Catch:{ Throwable -> 0x013a }
    L_0x0139:
        throw r0;	 Catch:{ all -> 0x0013 }
    L_0x013a:
        r1 = move-exception;	 Catch:{ all -> 0x0013 }
        r3 = dCu;	 Catch:{ all -> 0x0013 }
        r3.m10419g(r1);	 Catch:{ all -> 0x0013 }
        goto L_0x0139;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.ead.HP():void");
    }

    private void HQ() {
        Throwable th;
        Cursor query;
        try {
            query = this.dCr.getReadableDatabase().query("keyvalues", null, null, null, null, null, null);
            while (query.moveToNext()) {
                try {
                    this.dCy.put(query.getString(0), query.getString(1));
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (query != null) {
                query.close();
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

    private void HW() {
        this.f1488a = IS() + HX();
    }

    private int HX() {
        return (int) DatabaseUtils.queryNumEntries(this.dCs.getReadableDatabase(), "events");
    }

    private int IS() {
        return (int) DatabaseUtils.queryNumEntries(this.dCr.getReadableDatabase(), "events");
    }

    private void m10396a(dzm com_fossil_dzm, ebn com_fossil_ebn, boolean z) {
        long insert;
        long j;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = dE(z);
            sQLiteDatabase.beginTransaction();
            if (!z && this.f1488a > dze.aBN()) {
                dCu.warn("Too many events stored in db.");
                this.f1488a -= this.dCr.getWritableDatabase().delete("events", "event_id in (select event_id from events where timestamp in (select min(timestamp) from events) limit 1)", null);
            }
            ContentValues contentValues = new ContentValues();
            String Iw = com_fossil_dzm.Iw();
            if (dze.aBG()) {
                dCu.cY("insert 1 event, content:" + Iw);
            }
            contentValues.put("content", ebh.cx(Iw));
            contentValues.put("send_count", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            contentValues.put("status", Integer.toString(1));
            contentValues.put("timestamp", Long.valueOf(com_fossil_dzm.IL()));
            insert = sQLiteDatabase.insert("events", null, contentValues);
            sQLiteDatabase.setTransactionSuccessful();
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                    j = insert;
                } catch (Throwable th) {
                    dCu.m10419g(th);
                    j = insert;
                }
                if (j <= 0) {
                    this.f1488a++;
                    if (dze.aBG()) {
                        dCu.db("directStoreEvent insert event to db, event:" + com_fossil_dzm.Iw());
                    }
                    if (com_fossil_ebn != null) {
                        com_fossil_ebn.HJ();
                    }
                }
                dCu.error("Failed to store event:" + com_fossil_dzm.Iw());
                return;
            }
        } catch (Throwable th2) {
            dCu.m10419g(th2);
            j = -1;
        }
        j = insert;
        if (j <= 0) {
            dCu.error("Failed to store event:" + com_fossil_dzm.Iw());
            return;
        }
        this.f1488a++;
        if (dze.aBG()) {
            dCu.db("directStoreEvent insert event to db, event:" + com_fossil_dzm.Iw());
        }
        if (com_fossil_ebn != null) {
            com_fossil_ebn.HJ();
        }
    }

    private synchronized void m10397a(dzm com_fossil_dzm, ebn com_fossil_ebn, boolean z, boolean z2) {
        if (dze.aBN() > 0) {
            if (dze.bai <= 0 || z || z2) {
                m10396a(com_fossil_dzm, com_fossil_ebn, z);
            } else if (dze.bai > 0) {
                if (dze.aBG()) {
                    dCu.cY("cacheEventsInMemory.size():" + this.dCx.size() + ",numEventsCachedInMemory:" + dze.bai + ",numStoredEvents:" + this.f1488a);
                    dCu.cY("cache event:" + com_fossil_dzm.Iw());
                }
                this.dCx.put(com_fossil_dzm, "");
                if (this.dCx.size() >= dze.bai) {
                    HP();
                }
                if (com_fossil_ebn != null) {
                    if (this.dCx.size() > 0) {
                        HP();
                    }
                    com_fossil_ebn.HJ();
                }
            }
        }
    }

    private synchronized void m10404a(ebl com_fossil_ebl) {
        Cursor query;
        Throwable th;
        try {
            Object obj;
            long update;
            String Ik = com_fossil_ebl.Ik();
            String a = ebb.m10438a(Ik);
            ContentValues contentValues = new ContentValues();
            contentValues.put("content", com_fossil_ebl.dDh.toString());
            contentValues.put("md5sum", a);
            com_fossil_ebl.aWS = a;
            contentValues.put("version", Integer.valueOf(com_fossil_ebl.f1511d));
            query = this.dCr.getReadableDatabase().query("config", null, null, null, null, null, null);
            do {
                try {
                    if (!query.moveToNext()) {
                        obj = null;
                        break;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } while (query.getInt(0) != com_fossil_ebl.f1510a);
            obj = 1;
            this.dCr.getWritableDatabase().beginTransaction();
            if (1 == obj) {
                update = (long) this.dCr.getWritableDatabase().update("config", contentValues, "type=?", new String[]{Integer.toString(com_fossil_ebl.f1510a)});
            } else {
                contentValues.put("type", Integer.valueOf(com_fossil_ebl.f1510a));
                update = this.dCr.getWritableDatabase().insert("config", null, contentValues);
            }
            if (update == -1) {
                dCu.da("Failed to store cfg:" + Ik);
            } else {
                dCu.db("Sucessed to store cfg:" + Ik);
            }
            this.dCr.getWritableDatabase().setTransactionSuccessful();
            if (query != null) {
                query.close();
            }
            try {
                this.dCr.getWritableDatabase().endTransaction();
            } catch (Exception e) {
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            this.dCr.getWritableDatabase().endTransaction();
            throw th;
        }
        return;
    }

    private void m10405a(boolean z) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = dE(z);
            sQLiteDatabase.beginTransaction();
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", Integer.valueOf(1));
            int update = sQLiteDatabase.update("events", contentValues, "status=?", new String[]{Long.toString(2)});
            if (dze.aBG()) {
                dCu.cY("update " + update + " unsent events.");
            }
            sQLiteDatabase.setTransactionSuccessful();
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable th) {
                    dCu.m10419g(th);
                }
            }
        } catch (Throwable th2) {
            dCu.m10419g(th2);
        }
    }

    public static ead aCn() {
        return dCw;
    }

    private String aD(List<ean> list) {
        StringBuilder stringBuilder = new StringBuilder(list.size() * 3);
        stringBuilder.append("event_id in (");
        int size = list.size();
        int i = 0;
        for (ean com_fossil_ean : list) {
            stringBuilder.append(com_fossil_ean.aXm);
            if (i != size - 1) {
                stringBuilder.append(",");
            }
            i++;
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private synchronized void m10406b(List<ean> list, int i, boolean z) {
        SQLiteDatabase dE;
        Throwable th;
        String str = null;
        synchronized (this) {
            if (list.size() != 0) {
                int dD = dD(z);
                try {
                    String str2;
                    dE = dE(z);
                    if (i == 2) {
                        try {
                            str2 = "update events set status=" + i + ", send_count=send_count+1  where " + aD(list);
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                dCu.m10419g(th);
                                if (dE != null) {
                                    try {
                                        dE.endTransaction();
                                    } catch (Throwable th3) {
                                        dCu.m10419g(th3);
                                    }
                                }
                            } catch (Throwable th4) {
                                th3 = th4;
                                if (dE != null) {
                                    try {
                                        dE.endTransaction();
                                    } catch (Throwable th5) {
                                        dCu.m10419g(th5);
                                    }
                                }
                                throw th3;
                            }
                        }
                    }
                    str2 = "update events set status=" + i + " where " + aD(list);
                    if (this.f1489k % 3 == 0) {
                        str = "delete from events where send_count>" + dD;
                    }
                    this.f1489k++;
                    if (dze.aBG()) {
                        dCu.cY("update sql:" + str2);
                    }
                    dE.beginTransaction();
                    dE.execSQL(str2);
                    if (str != null) {
                        dCu.cY("update for delete sql:" + str);
                        dE.execSQL(str);
                        HW();
                    }
                    dE.setTransactionSuccessful();
                    if (dE != null) {
                        try {
                            dE.endTransaction();
                        } catch (Throwable th32) {
                            dCu.m10419g(th32);
                        }
                    }
                } catch (Throwable th6) {
                    th32 = th6;
                    dE = null;
                    if (dE != null) {
                        dE.endTransaction();
                    }
                    throw th32;
                }
            }
        }
    }

    private synchronized void m10407b(java.util.List<com.fossil.ean> r9, boolean r10) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.fossil.ead.b(java.util.List, boolean):void. bs: [B:26:0x00c1, B:49:0x00e9]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r8 = this;
        r1 = 0;
        monitor-enter(r8);
        r0 = r9.size();	 Catch:{ all -> 0x00ce }
        if (r0 != 0) goto L_0x000a;
    L_0x0008:
        monitor-exit(r8);
        return;
    L_0x000a:
        r0 = com.fossil.dze.aBG();	 Catch:{ all -> 0x00ce }
        if (r0 == 0) goto L_0x0032;	 Catch:{ all -> 0x00ce }
    L_0x0010:
        r0 = dCu;	 Catch:{ all -> 0x00ce }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ce }
        r3 = "Delete ";	 Catch:{ all -> 0x00ce }
        r2.<init>(r3);	 Catch:{ all -> 0x00ce }
        r3 = r9.size();	 Catch:{ all -> 0x00ce }
        r2 = r2.append(r3);	 Catch:{ all -> 0x00ce }
        r3 = " events, important:";	 Catch:{ all -> 0x00ce }
        r2 = r2.append(r3);	 Catch:{ all -> 0x00ce }
        r2 = r2.append(r10);	 Catch:{ all -> 0x00ce }
        r2 = r2.toString();	 Catch:{ all -> 0x00ce }
        r0.cY(r2);	 Catch:{ all -> 0x00ce }
    L_0x0032:
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ce }
        r0 = r9.size();	 Catch:{ all -> 0x00ce }
        r0 = r0 * 3;	 Catch:{ all -> 0x00ce }
        r3.<init>(r0);	 Catch:{ all -> 0x00ce }
        r0 = "event_id in (";	 Catch:{ all -> 0x00ce }
        r3.append(r0);	 Catch:{ all -> 0x00ce }
        r0 = 0;	 Catch:{ all -> 0x00ce }
        r4 = r9.size();	 Catch:{ all -> 0x00ce }
        r5 = r9.iterator();	 Catch:{ all -> 0x00ce }
        r2 = r0;	 Catch:{ all -> 0x00ce }
    L_0x004c:
        r0 = r5.hasNext();	 Catch:{ all -> 0x00ce }
        if (r0 == 0) goto L_0x006a;	 Catch:{ all -> 0x00ce }
    L_0x0052:
        r0 = r5.next();	 Catch:{ all -> 0x00ce }
        r0 = (com.fossil.ean) r0;	 Catch:{ all -> 0x00ce }
        r6 = r0.aXm;	 Catch:{ all -> 0x00ce }
        r3.append(r6);	 Catch:{ all -> 0x00ce }
        r0 = r4 + -1;	 Catch:{ all -> 0x00ce }
        if (r2 == r0) goto L_0x0066;	 Catch:{ all -> 0x00ce }
    L_0x0061:
        r0 = ",";	 Catch:{ all -> 0x00ce }
        r3.append(r0);	 Catch:{ all -> 0x00ce }
    L_0x0066:
        r0 = r2 + 1;	 Catch:{ all -> 0x00ce }
        r2 = r0;	 Catch:{ all -> 0x00ce }
        goto L_0x004c;	 Catch:{ all -> 0x00ce }
    L_0x006a:
        r0 = ")";	 Catch:{ all -> 0x00ce }
        r3.append(r0);	 Catch:{ all -> 0x00ce }
        r1 = r8.dE(r10);	 Catch:{ Throwable -> 0x00d1 }
        r1.beginTransaction();	 Catch:{ Throwable -> 0x00d1 }
        r0 = "events";	 Catch:{ Throwable -> 0x00d1 }
        r2 = r3.toString();	 Catch:{ Throwable -> 0x00d1 }
        r5 = 0;	 Catch:{ Throwable -> 0x00d1 }
        r0 = r1.delete(r0, r2, r5);	 Catch:{ Throwable -> 0x00d1 }
        r2 = com.fossil.dze.aBG();	 Catch:{ Throwable -> 0x00d1 }
        if (r2 == 0) goto L_0x00b3;	 Catch:{ Throwable -> 0x00d1 }
    L_0x0087:
        r2 = dCu;	 Catch:{ Throwable -> 0x00d1 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00d1 }
        r6 = "delete ";	 Catch:{ Throwable -> 0x00d1 }
        r5.<init>(r6);	 Catch:{ Throwable -> 0x00d1 }
        r4 = r5.append(r4);	 Catch:{ Throwable -> 0x00d1 }
        r5 = " event ";	 Catch:{ Throwable -> 0x00d1 }
        r4 = r4.append(r5);	 Catch:{ Throwable -> 0x00d1 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x00d1 }
        r3 = r4.append(r3);	 Catch:{ Throwable -> 0x00d1 }
        r4 = ", success delete:";	 Catch:{ Throwable -> 0x00d1 }
        r3 = r3.append(r4);	 Catch:{ Throwable -> 0x00d1 }
        r3 = r3.append(r0);	 Catch:{ Throwable -> 0x00d1 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x00d1 }
        r2.cY(r3);	 Catch:{ Throwable -> 0x00d1 }
    L_0x00b3:
        r2 = r8.f1488a;	 Catch:{ Throwable -> 0x00d1 }
        r0 = r2 - r0;	 Catch:{ Throwable -> 0x00d1 }
        r8.f1488a = r0;	 Catch:{ Throwable -> 0x00d1 }
        r1.setTransactionSuccessful();	 Catch:{ Throwable -> 0x00d1 }
        r8.HW();	 Catch:{ Throwable -> 0x00d1 }
        if (r1 == 0) goto L_0x0008;
    L_0x00c1:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00c6 }
        goto L_0x0008;
    L_0x00c6:
        r0 = move-exception;
        r1 = dCu;	 Catch:{ all -> 0x00ce }
        r1.m10419g(r0);	 Catch:{ all -> 0x00ce }
        goto L_0x0008;
    L_0x00ce:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
    L_0x00d1:
        r0 = move-exception;
        r2 = dCu;	 Catch:{ all -> 0x00e6 }
        r2.m10419g(r0);	 Catch:{ all -> 0x00e6 }
        if (r1 == 0) goto L_0x0008;
    L_0x00d9:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00de }
        goto L_0x0008;
    L_0x00de:
        r0 = move-exception;
        r1 = dCu;	 Catch:{ all -> 0x00ce }
        r1.m10419g(r0);	 Catch:{ all -> 0x00ce }
        goto L_0x0008;
    L_0x00e6:
        r0 = move-exception;
        if (r1 == 0) goto L_0x00ec;
    L_0x00e9:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00ed }
    L_0x00ec:
        throw r0;	 Catch:{ all -> 0x00ce }
    L_0x00ed:
        r1 = move-exception;	 Catch:{ all -> 0x00ce }
        r2 = dCu;	 Catch:{ all -> 0x00ce }
        r2.m10419g(r1);	 Catch:{ all -> 0x00ce }
        goto L_0x00ec;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.ead.b(java.util.List, boolean):void");
    }

    private void m10408c(List<ean> list, int i, boolean z) {
        Throwable th;
        Cursor cursor;
        Cursor query;
        try {
            query = dF(z).query("events", null, "status=?", new String[]{Integer.toString(1)}, null, null, null, Integer.toString(i));
            while (query.moveToNext()) {
                try {
                    long j = query.getLong(0);
                    String string = query.getString(1);
                    if (!dze.aWF) {
                        string = ebh.m10451a(string);
                    }
                    int i2 = query.getInt(2);
                    int i3 = query.getInt(3);
                    ean com_fossil_ean = new ean(j, string, i2, i3);
                    if (dze.aBG()) {
                        dCu.cY("peek event, id=" + j + ",send_count=" + i3 + ",timestamp=" + query.getLong(4));
                    }
                    list.add(com_fossil_ean);
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (query != null) {
                query.close();
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

    private int dD(boolean z) {
        return !z ? dze.aBL() : dze.aBJ();
    }

    private SQLiteDatabase dE(boolean z) {
        return !z ? this.dCr.getWritableDatabase() : this.dCs.getWritableDatabase();
    }

    private SQLiteDatabase dF(boolean z) {
        return !z ? this.dCr.getReadableDatabase() : this.dCs.getReadableDatabase();
    }

    public static ead dy(Context context) {
        if (dCw == null) {
            synchronized (ead.class) {
                if (dCw == null) {
                    dCw = new ead(context);
                }
            }
        }
        return dCw;
    }

    void HH() {
        if (dze.aBH()) {
            try {
                this.dBV.m10423a(new eag(this));
            } catch (Throwable th) {
                dCu.m10419g(th);
            }
        }
    }

    public int m10409a() {
        return this.f1488a;
    }

    void m10410a(int i) {
        this.dBV.m10423a(new eal(this, i));
    }

    void m10411a(List<ean> list, int i, boolean z, boolean z2) {
        if (this.dBV != null) {
            this.dBV.m10423a(new eae(this, list, i, z, z2));
        }
    }

    void m10412b(dzm com_fossil_dzm, ebn com_fossil_ebn, boolean z, boolean z2) {
        if (this.dBV != null) {
            this.dBV.m10423a(new eah(this, com_fossil_dzm, com_fossil_ebn, z, z2));
        }
    }

    void m10413b(ebl com_fossil_ebl) {
        if (com_fossil_ebl != null) {
            this.dBV.m10423a(new eai(this, com_fossil_ebl));
        }
    }

    void m10414c(List<ean> list, boolean z, boolean z2) {
        if (this.dBV != null) {
            this.dBV.m10423a(new eaf(this, list, z, z2));
        }
    }

    void m10415d() {
        Throwable th;
        Cursor query;
        try {
            query = this.dCr.getReadableDatabase().query("config", null, null, null, null, null, null);
            while (query.moveToNext()) {
                try {
                    int i = query.getInt(0);
                    String string = query.getString(1);
                    String string2 = query.getString(2);
                    int i2 = query.getInt(3);
                    ebl com_fossil_ebl = new ebl(i);
                    com_fossil_ebl.f1510a = i;
                    com_fossil_ebl.dDh = new JSONObject(string);
                    com_fossil_ebl.aWS = string2;
                    com_fossil_ebl.f1511d = i2;
                    dze.m10340a(dCv, com_fossil_ebl);
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (query != null) {
                query.close();
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

    public synchronized ear dz(Context context) {
        ear com_fossil_ear;
        Cursor query;
        Throwable th;
        Cursor cursor;
        if (this.dCt != null) {
            com_fossil_ear = this.dCt;
        } else {
            try {
                this.dCr.getWritableDatabase().beginTransaction();
                if (dze.aBG()) {
                    dCu.cY("try to load user info from db.");
                }
                query = this.dCr.getReadableDatabase().query("user", null, null, null, null, null, null, null);
                Object obj = null;
                try {
                    String string;
                    String aa;
                    if (query.moveToNext()) {
                        String a = ebh.m10451a(query.getString(0));
                        int i = query.getInt(1);
                        string = query.getString(2);
                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                        int i2 = (i == 1 || ebb.aR(query.getLong(3) * 1000).equals(ebb.aR(1000 * currentTimeMillis))) ? i : 1;
                        int i3 = !string.equals(ebb.dM(context)) ? i2 | 2 : i2;
                        String[] split = a.split(",");
                        obj = null;
                        if (split == null || split.length <= 0) {
                            aa = ebb.aa(context);
                            obj = 1;
                            a = aa;
                        } else {
                            aa = split[0];
                            if (aa == null || aa.length() < 11) {
                                string = ebh.m10450Y(context);
                                if (string == null || string.length() <= 10) {
                                    string = aa;
                                } else {
                                    obj = 1;
                                }
                                aa = a;
                                a = string;
                            } else {
                                String str = aa;
                                aa = a;
                                a = str;
                            }
                        }
                        if (split == null || split.length < 2) {
                            string = ebb.dC(context);
                            if (string != null && string.length() > 0) {
                                aa = a + "," + string;
                                obj = 1;
                            }
                        } else {
                            string = split[1];
                            aa = a + "," + string;
                        }
                        this.dCt = new ear(a, string, i3);
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(Constants.PROFILE_KEY_UID, ebh.cx(aa));
                        contentValues.put("user_type", Integer.valueOf(i3));
                        contentValues.put("app_ver", ebb.dM(context));
                        contentValues.put("ts", Long.valueOf(currentTimeMillis));
                        if (obj != null) {
                            this.dCr.getWritableDatabase().update("user", contentValues, "uid=?", new String[]{r10});
                        }
                        if (i3 != i) {
                            this.dCr.getWritableDatabase().replace("user", null, contentValues);
                        }
                        obj = 1;
                    }
                    if (obj == null) {
                        string = ebb.aa(context);
                        aa = ebb.dC(context);
                        String str2 = (aa == null || aa.length() <= 0) ? string : string + "," + aa;
                        long currentTimeMillis2 = System.currentTimeMillis() / 1000;
                        String dM = ebb.dM(context);
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put(Constants.PROFILE_KEY_UID, ebh.cx(str2));
                        contentValues2.put("user_type", Integer.valueOf(0));
                        contentValues2.put("app_ver", dM);
                        contentValues2.put("ts", Long.valueOf(currentTimeMillis2));
                        this.dCr.getWritableDatabase().insert("user", null, contentValues2);
                        this.dCt = new ear(string, aa, 0);
                    }
                    this.dCr.getWritableDatabase().setTransactionSuccessful();
                    if (query != null) {
                        try {
                            query.close();
                        } catch (Throwable th2) {
                            dCu.m10419g(th2);
                        }
                    }
                    this.dCr.getWritableDatabase().endTransaction();
                } catch (Throwable th3) {
                    th2 = th3;
                    if (query != null) {
                        query.close();
                    }
                    this.dCr.getWritableDatabase().endTransaction();
                    throw th2;
                }
            } catch (Throwable th4) {
                th2 = th4;
                query = null;
                if (query != null) {
                    query.close();
                }
                this.dCr.getWritableDatabase().endTransaction();
                throw th2;
            }
            com_fossil_ear = this.dCt;
        }
        return com_fossil_ear;
    }
}
