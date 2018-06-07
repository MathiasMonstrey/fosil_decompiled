package com.fossil.wearables.fsl.shared;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.sql.SQLException;
import java.util.Map;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    private final Logger LOG = LoggerFactory.getLogger(DatabaseHelper.class);
    private final String TAG = DatabaseHelper.class.getCanonicalName();
    private Map<Integer, UpgradeCommand> availableUpgrades;
    private String dbName;
    private Class<?>[] entities;

    public DatabaseHelper(Context context, String str, int i, Class<?>[] clsArr, Map<Integer, UpgradeCommand> map) {
        super(context, str, null, i);
        this.dbName = str;
        this.entities = clsArr;
        this.availableUpgrades = map;
    }

    public String getDbPath() {
        return this.dbName;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase, ConnectionSource connectionSource) {
        try {
            createAllTables();
        } catch (Object e) {
            this.LOG.error("Can't create database", e);
            throw new RuntimeException(e);
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, ConnectionSource connectionSource, int i, int i2) {
        this.LOG.info("onUpgrade, oldVersion=" + i + " newVersion=" + i2);
        try {
            upgrade(sQLiteDatabase, i, i2);
            this.LOG.info("successful upgrade!");
        } catch (Object e) {
            this.LOG.error("Can't migrate databases, bootstrap database, data will be lost", e);
            try {
                dropAllTables();
                onCreate(sQLiteDatabase, connectionSource);
            } catch (Object e2) {
                this.LOG.error("Can't drop databases", e2);
                throw new RuntimeException(e);
            }
        }
    }

    private void createAllTables() throws SQLException {
        createTables(this.entities);
    }

    private void dropAllTables() throws SQLException {
        dropTables(this.entities);
    }

    public void createTables(Class<?>[] clsArr) throws SQLException {
        for (Class createTable : clsArr) {
            TableUtils.createTable(getConnectionSource(), createTable);
        }
    }

    public void createTable(Class<?> cls) throws SQLException {
        TableUtils.createTable(getConnectionSource(), (Class) cls);
    }

    public void dropTables(Class<?>[] clsArr) throws SQLException {
        for (Class dropTable : clsArr) {
            dropTable(getConnectionSource(), dropTable);
        }
    }

    public void dropTable(Class<?> cls) throws SQLException {
        dropTable(getConnectionSource(), cls);
    }

    private void dropTable(ConnectionSource connectionSource, Class<?> cls) {
        try {
            TableUtils.dropTable(connectionSource, (Class) cls, true);
        } catch (SQLException e) {
            this.LOG.error("Could not drop table: " + cls.getSimpleName());
        }
    }

    public void close() {
        super.close();
    }

    public void upgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (this.availableUpgrades == null) {
            throw new RuntimeException("No upgrade commands provided");
        }
        while (true) {
            i++;
            if (i <= i2) {
                UpgradeCommand upgradeCommand = (UpgradeCommand) this.availableUpgrades.get(Integer.valueOf(i));
                if (upgradeCommand != null) {
                    sQLiteDatabase.beginTransaction();
                    try {
                        Log.d(this.TAG, "Upgrading database to: " + i);
                        upgradeCommand.execute(sQLiteDatabase);
                        sQLiteDatabase.setTransactionSuccessful();
                    } finally {
                        sQLiteDatabase.endTransaction();
                    }
                }
            } else {
                return;
            }
        }
    }

    public void exportDB(Context context) {
        this.LOG.debug("exporting DB to file");
        File databasePath = context.getDatabasePath(getDatabaseName());
        File file = new File(Environment.getExternalStorageDirectory(), "nrml");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, databasePath.getName());
        try {
            file2.createNewFile();
            copyFile(databasePath, file2);
        } catch (IOException e) {
            this.LOG.debug("Unable to Export DB: " + e.getMessage());
        }
    }

    private void copyFile(File file, File file2) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel channel = fileInputStream.getChannel();
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        Object channel2 = fileOutputStream.getChannel();
        try {
            channel.transferTo(0, channel.size(), channel2);
        } finally {
            if (channel != null) {
                channel.close();
            }
            fileInputStream.close();
            if (channel2 != null) {
                channel2.close();
            }
            fileOutputStream.close();
        }
    }
}
