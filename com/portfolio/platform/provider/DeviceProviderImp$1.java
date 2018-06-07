package com.portfolio.platform.provider;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.fossil.col;
import com.fossil.wearables.fsl.shared.UpgradeCommand;
import com.misfit.frameworks.buttonservice.db.DataLogService;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.DeviceModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DeviceProviderImp$1 extends HashMap<Integer, UpgradeCommand> {
    final /* synthetic */ col this$0;

    class C48981 implements UpgradeCommand {
        final /* synthetic */ DeviceProviderImp$1 cBe;

        C48981(DeviceProviderImp$1 deviceProviderImp$1) {
            this.cBe = deviceProviderImp$1;
        }

        public void execute(SQLiteDatabase sQLiteDatabase) {
            MFLogger.d(col.access$000(), "Inside upgrade ver 11 of dbPath=" + this.cBe.this$0.getDbPath());
            try {
                MFLogger.d(col.access$000(), "Inside .doInBackground upgrade device task on thread=" + Thread.currentThread().getName());
                Cursor query = sQLiteDatabase.query(true, Constants.DEVICE, new String[]{"deviceId", "sku", DeviceModel.COLUMN_FIRMWARE_VERSION, DeviceModel.COLUMN_BATTERY_LEVEL, "createdAt", DataLogService.COLUMN_UPDATE_AT, "macAddress"}, null, null, null, null, null, null);
                List<DeviceModel> arrayList = new ArrayList();
                if (query != null) {
                    query.moveToFirst();
                    while (!query.isAfterLast()) {
                        String string = query.getString(query.getColumnIndex("deviceId"));
                        String string2 = query.getString(query.getColumnIndex("sku"));
                        String string3 = query.getString(query.getColumnIndex(DeviceModel.COLUMN_FIRMWARE_VERSION));
                        int i = query.getInt(query.getColumnIndex(DeviceModel.COLUMN_BATTERY_LEVEL));
                        String string4 = query.getString(query.getColumnIndex("createdAt"));
                        String string5 = query.getString(query.getColumnIndex(DataLogService.COLUMN_UPDATE_AT));
                        String string6 = query.getString(query.getColumnIndex("macAddress"));
                        DeviceModel deviceModel = new DeviceModel();
                        deviceModel.setDeviceId(string);
                        deviceModel.setSku(string2);
                        deviceModel.setFirmwareRevision(string3);
                        deviceModel.setBatteryLevel(i);
                        deviceModel.setCreatedAt(string4);
                        deviceModel.setUpdateAt(string5);
                        deviceModel.setMacAddress(string6);
                        MFLogger.d(col.access$000(), "Add device=" + deviceModel);
                        arrayList.add(deviceModel);
                        query.moveToNext();
                    }
                    query.close();
                }
                sQLiteDatabase.execSQL("CREATE TABLE device_copy (deviceId VARCHAR PRIMARY KEY, sku VARCHAR, firmwareRevision VARCHAR, deviceBattery INTEGER, createdAt VARCHAR, updateAt VARCHAR, macAddress VARCHAR, minor INTEGER, major INTEGER, vibrationStrength INTEGER);");
                for (DeviceModel deviceModel2 : arrayList) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("deviceId", deviceModel2.getDeviceId());
                    contentValues.put("sku", deviceModel2.getSku());
                    contentValues.put(DeviceModel.COLUMN_FIRMWARE_VERSION, deviceModel2.getFirmwareRevision());
                    contentValues.put(DeviceModel.COLUMN_BATTERY_LEVEL, Integer.valueOf(deviceModel2.getBatteryLevel()));
                    contentValues.put("macAddress", deviceModel2.getMacAddress());
                    contentValues.put("createdAt", deviceModel2.getCreatedAt());
                    contentValues.put(DataLogService.COLUMN_UPDATE_AT, deviceModel2.getUpdateAt());
                    contentValues.put(DeviceModel.COLUMN_MAJOR, Integer.valueOf(deviceModel2.getMajor()));
                    contentValues.put(DeviceModel.COLUMN_MINOR, Integer.valueOf(deviceModel2.getMinor()));
                    contentValues.put(DeviceModel.COLUMN_VIBRATION_STRENGTH, Integer.valueOf(deviceModel2.getVibrationStrength()));
                    sQLiteDatabase.insert("device_copy", null, contentValues);
                }
                sQLiteDatabase.execSQL("DROP TABLE device;");
                sQLiteDatabase.execSQL("ALTER TABLE device_copy RENAME TO device;");
                MFLogger.d(col.access$000(), "Migration complete");
            } catch (Exception e) {
                MFLogger.e(col.access$000(), "Error inside " + col.access$000() + ".upgrade - e=" + e);
            }
            sQLiteDatabase.execSQL("CREATE TABLE uappsystemversion (deviceId VARCHAR PRIMARY KEY, majorVersion INTEGER, minorVersion INTEGER, pinType INTEGER);");
            sQLiteDatabase.execSQL("CREATE TABLE microApp (id VARCHAR PRIMARY KEY, appId VARCHAR, name VARCHAR, platform VARCHAR, like INTEGER, appSetting VARCHAR, icon VARCHAR, releaseDate BIGINT, updatedAt BIGINT, createdAt BIGINT, description VARCHAR);");
            sQLiteDatabase.execSQL("CREATE TABLE recommendedPreset (id VARCHAR PRIMARY KEY, objectId VARCHAR, buttons VARCHAR, name VARCHAR, description VARCHAR, createAt BIGINT, updatedAt BIGINT, serialNumber VARCHAR, type VARCHAR);");
            sQLiteDatabase.execSQL("CREATE TABLE savedPreset (id VARCHAR PRIMARY KEY, buttons VARCHAR, name VARCHAR, createAt BIGINT, pinType INTEGER DEFAULT 0, updatedAt BIGINT );");
            sQLiteDatabase.execSQL("CREATE TABLE activePreset (serialNumber VARCHAR PRIMARY KEY, buttons VARCHAR, originalId VARCHAR, createAt BIGINT, pinType INTEGER DEFAULT 0, updatedAt BIGINT);");
            sQLiteDatabase.execSQL("CREATE TABLE microAppVariant (id VARCHAR PRIMARY KEY, appId VARCHAR, description VARCHAR, name VARCHAR, createdAt BIGINT, updatedAt BIGINT, majorNumber INTEGER, minorNumber INTEGER, serialNumber VARCHAR);");
            String str = "CREATE TABLE declarationFile (id VARCHAR PRIMARY KEY, fileId VARCHAR, content VARCHAR, variant VARCHAR, description VARCHAR, FOREIGN KEY(variant) REFERENCES microAppVariant (id));";
            MFLogger.d(col.access$000(), "statements=" + str);
            sQLiteDatabase.execSQL(str);
            MFLogger.d(col.access$000(), "Migration device complete");
        }
    }

    public DeviceProviderImp$1(col com_fossil_col) {
        this.this$0 = com_fossil_col;
        put(Integer.valueOf(11), new C48981(this));
    }
}
