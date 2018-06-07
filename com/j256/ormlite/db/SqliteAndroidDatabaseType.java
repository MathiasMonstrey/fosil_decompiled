package com.j256.ormlite.db;

import com.j256.ormlite.android.DatabaseTableConfigUtil;
import com.j256.ormlite.field.DataPersister;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.field.types.DateStringType;
import com.j256.ormlite.field.types.SqlDateStringType;
import com.j256.ormlite.field.types.SqlDateType;
import com.j256.ormlite.field.types.TimeStampStringType;
import com.j256.ormlite.field.types.TimeStampType;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.sql.SQLException;

public class SqliteAndroidDatabaseType extends BaseSqliteDatabaseType {

    static /* synthetic */ class C44231 {
        static final /* synthetic */ int[] $SwitchMap$com$j256$ormlite$field$SqlType = new int[SqlType.values().length];

        static {
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.DATE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    public void loadDriver() {
    }

    public boolean isDatabaseUrlThisType(String str, String str2) {
        return true;
    }

    protected String getDriverClassName() {
        return null;
    }

    public String getDatabaseName() {
        return "Android SQLite";
    }

    protected void appendDateType(StringBuilder stringBuilder, FieldType fieldType, int i) {
        appendStringType(stringBuilder, fieldType, i);
    }

    public void appendEscapedEntityName(StringBuilder stringBuilder, String str) {
        stringBuilder.append('`').append(str).append('`');
    }

    protected void appendBooleanType(StringBuilder stringBuilder, FieldType fieldType, int i) {
        appendShortType(stringBuilder, fieldType, i);
    }

    public DataPersister getDataPersister(DataPersister dataPersister, FieldType fieldType) {
        if (dataPersister == null) {
            return super.getDataPersister(dataPersister, fieldType);
        }
        switch (C44231.$SwitchMap$com$j256$ormlite$field$SqlType[dataPersister.getSqlType().ordinal()]) {
            case 1:
                if (dataPersister instanceof TimeStampType) {
                    return TimeStampStringType.getSingleton();
                }
                if (dataPersister instanceof SqlDateType) {
                    return SqlDateStringType.getSingleton();
                }
                return DateStringType.getSingleton();
            default:
                return super.getDataPersister(dataPersister, fieldType);
        }
    }

    public boolean isNestedSavePointsSupported() {
        return false;
    }

    public boolean isBatchUseTransaction() {
        return true;
    }

    public <T> DatabaseTableConfig<T> extractDatabaseTableConfig(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        return DatabaseTableConfigUtil.fromClass(connectionSource, cls);
    }
}
