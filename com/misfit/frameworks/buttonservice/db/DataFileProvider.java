package com.misfit.frameworks.buttonservice.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.misfit.frameworks.common.log.MFLogger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataFileProvider extends BaseDbProvider {
    private static final int BUFFER_SIZE = 1000000;
    public static final String DB_NAME = "data_file.db";
    private static DataFileProvider sInstance;

    class C47071 extends HashMap<Integer, UpgradeCommand> {

        class C47061 implements UpgradeCommand {
            C47061() {
            }

            public void execute(SQLiteDatabase sQLiteDatabase) {
                sQLiteDatabase.execSQL("ALTER TABLE datafile ADD COLUMN syncTime BIGINT");
            }
        }

        C47071() {
            put(Integer.valueOf(2), new C47061());
        }
    }

    public static synchronized DataFileProvider getInstance(Context context) {
        DataFileProvider dataFileProvider;
        synchronized (DataFileProvider.class) {
            if (sInstance == null) {
                sInstance = new DataFileProvider(context, DB_NAME);
            }
            dataFileProvider = sInstance;
        }
        return dataFileProvider;
    }

    protected DataFileProvider(Context context, String str) {
        super(context, str);
    }

    protected int getDbVersion() {
        return 2;
    }

    protected Class<?>[] getDbEntities() {
        return new Class[]{DataFile.class};
    }

    protected Map<Integer, UpgradeCommand> getDbUpgrades() {
        return new C47071();
    }

    private Dao<DataFile, String> getDataFileDao() throws SQLException {
        return this.databaseHelper.getDao(DataFile.class);
    }

    protected void saveDataFile(DataFile dataFile) {
        MFLogger.d(this.TAG, "Inside " + this.TAG + ".saveDataFile - dataFile=" + dataFile);
        try {
            if (getDataFile(dataFile.key, dataFile.serial) == null) {
                MFLogger.d(this.TAG, "Inside " + this.TAG + ".saveDataFile - Saving dataFile=" + dataFile);
                getDataFileDao().create((Object) dataFile);
            } else {
                MFLogger.e(this.TAG, "Error inside " + this.TAG + ".saveDataFile -e=Data file existed");
            }
        } catch (Exception e) {
            MFLogger.e(this.TAG, "Error inside " + this.TAG + ".saveDataFile - e=" + e);
        }
        MFLogger.d(this.TAG, "Inside " + this.TAG + ".saveDataFile - dataFile=" + dataFile + " - DONE");
    }

    public DataFile getDataFile(String str, String str2) {
        Exception exception;
        DataFile dataFile;
        Object obj;
        Throwable th;
        SQLiteDatabase readableDatabase = this.databaseHelper.getReadableDatabase();
        Cursor rawQuery = readableDatabase.rawQuery("SELECT length(dataFile), serial, syncTime FROM dataFile WHERE `key` = ?" + (str2 == null ? "" : " AND serial = ?"), str2 == null ? new String[]{str} : new String[]{str, str2});
        Cursor rawQuery2;
        try {
            QueryBuilder queryBuilder = getDataFileDao().queryBuilder();
            queryBuilder.where().eq(DataFile.COLUMN_KEY, str);
            int i = 0;
            String str3 = "";
            long j = 0;
            if (rawQuery != null && rawQuery.getCount() > 0) {
                rawQuery.moveToFirst();
                i = rawQuery.getInt(0);
                str3 = rawQuery.getString(1);
                j = rawQuery.getLong(2);
                rawQuery.close();
            }
            int i2 = i;
            MFLogger.d(this.TAG, "Inside .getDataFile - fileData len=" + i2);
            if (i2 > BUFFER_SIZE) {
                StringBuffer stringBuffer = new StringBuffer();
                Cursor cursor = rawQuery;
                long j2 = 0;
                while (j2 < ((long) i2)) {
                    long j3 = 1 + j2;
                    try {
                        rawQuery2 = readableDatabase.rawQuery("SELECT substr(dataFile, ?, ? ) FROM dataFile WHERE `key` = ?" + (str2 == null ? "" : " AND serial = ?"), str2 == null ? new String[]{Long.toString(j3), Long.toString(1000000), str} : new String[]{Long.toString(j3), Long.toString(1000000), str, str2});
                        if (rawQuery2 != null) {
                            try {
                                if (rawQuery2.getCount() > 0) {
                                    rawQuery2.moveToFirst();
                                    String string = rawQuery2.getString(0);
                                    stringBuffer.append(string);
                                    j2 += (long) string.length();
                                }
                            } catch (Exception e) {
                                exception = e;
                                dataFile = null;
                            }
                        }
                        cursor = rawQuery2;
                    } catch (Exception e2) {
                        obj = e2;
                        rawQuery2 = cursor;
                        dataFile = null;
                    } catch (Throwable th2) {
                        th = th2;
                        rawQuery = cursor;
                    }
                }
                dataFile = new DataFile(str, stringBuffer.toString(), str3, j);
                rawQuery2 = cursor;
            } else {
                dataFile = (DataFile) getDataFileDao().queryForFirst(queryBuilder.prepare());
                rawQuery2 = rawQuery;
            }
            if (rawQuery2 != null) {
                try {
                    rawQuery2.close();
                } catch (Exception e3) {
                    obj = e3;
                    try {
                        MFLogger.e(this.TAG, "Error inside " + this.TAG + ".getDataFile - e=" + obj);
                        if (rawQuery2 != null) {
                            rawQuery2.close();
                        }
                        return dataFile;
                    } catch (Throwable th3) {
                        th = th3;
                        rawQuery = rawQuery2;
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        throw th;
                    }
                }
            }
            if (rawQuery2 != null) {
                rawQuery2.close();
            }
        } catch (Exception e22) {
            rawQuery2 = rawQuery;
            exception = e22;
            dataFile = null;
            MFLogger.e(this.TAG, "Error inside " + this.TAG + ".getDataFile - e=" + obj);
            if (rawQuery2 != null) {
                rawQuery2.close();
            }
            return dataFile;
        } catch (Throwable th4) {
            th = th4;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
        return dataFile;
    }

    public DataFile getDataFile(String str) {
        return getDataFile(str, null);
    }

    public void deleteDataFile(DataFile dataFile) {
        try {
            getDataFileDao().delete((Object) dataFile);
        } catch (Exception e) {
            MFLogger.e(this.TAG, "Error inside " + this.TAG + ".deleteDataFile - e=" + e);
        }
    }

    public List<DataFile> getAllDataFiles(long j) {
        List<DataFile> arrayList = new ArrayList();
        try {
            QueryBuilder queryBuilder = getDataFileDao().queryBuilder();
            queryBuilder.where().lt("syncTime", Long.valueOf(j));
            Collection query = getDataFileDao().query(queryBuilder.prepare());
            if (query != null) {
                arrayList.addAll(query);
            }
        } catch (Exception e) {
            MFLogger.e(this.TAG, "Error inside " + this.TAG + ".getAllDataFiles - e=" + e);
        }
        return arrayList;
    }

    public void clearFiles() {
        try {
            MFLogger.i(this.TAG, "Inside " + this.TAG + ".clearHwLog");
            getDataFileDao().deleteBuilder().delete();
        } catch (Exception e) {
            MFLogger.e(this.TAG, "Error inside " + this.TAG + ".clearHwLog - e=" + e);
        }
    }
}
