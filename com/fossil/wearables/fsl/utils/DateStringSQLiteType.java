package com.fossil.wearables.fsl.utils;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.field.types.BaseDateType.DateStringFormatConfig;
import com.j256.ormlite.field.types.DateStringType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateStringSQLiteType extends DateStringType {
    protected static final ExtendDateStringFormatConfig dateFormatConfig = new ExtendDateStringFormatConfig("yyyy-MM-dd HH:mm:ss.SSSSS");
    private static final DateStringSQLiteType singleTon = new DateStringSQLiteType();

    public static class ExtendDateStringFormatConfig extends DateStringFormatConfig {
        final String exDateFormatStr;
        private final ThreadLocal<DateFormat> exThreadLocal = new C41961();

        class C41961 extends ThreadLocal<DateFormat> {
            C41961() {
            }

            protected DateFormat initialValue() {
                return new SimpleDateFormat(ExtendDateStringFormatConfig.this.exDateFormatStr, Locale.US);
            }
        }

        public ExtendDateStringFormatConfig(String str) {
            super(str);
            this.exDateFormatStr = str;
        }

        public DateFormat getDateFormat() {
            return (DateFormat) this.exThreadLocal.get();
        }

        public String toString() {
            return this.exDateFormatStr;
        }
    }

    public static DateStringSQLiteType getSingleton() {
        return singleTon;
    }

    private DateStringSQLiteType() {
        super(SqlType.STRING, new Class[0]);
    }

    public Object parseDefaultString(FieldType fieldType, String str) throws SQLException {
        DateStringFormatConfig convertDateStringConfig = convertDateStringConfig(fieldType, dateFormatConfig);
        try {
            convertDateStringConfig.getDateFormat().setTimeZone(TimeZone.getDefault());
            return normalizeDateString(convertDateStringConfig, str);
        } catch (Throwable e) {
            throw SqlExceptionUtil.create("Problems with field " + fieldType + " parsing default date-string '" + str + "' using '" + convertDateStringConfig + "'", e);
        }
    }

    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i) throws SQLException {
        return databaseResults.getString(i);
    }

    public Object sqlArgToJava(FieldType fieldType, Object obj, int i) throws SQLException {
        String str = (String) obj;
        DateStringFormatConfig convertDateStringConfig = convertDateStringConfig(fieldType, dateFormatConfig);
        try {
            convertDateStringConfig.getDateFormat().setTimeZone(TimeZone.getDefault());
            return parseDateString(convertDateStringConfig, str);
        } catch (Throwable e) {
            throw SqlExceptionUtil.create("Problems with column " + i + " parsing date-string '" + str + "' using '" + convertDateStringConfig + "'", e);
        }
    }

    public Object javaToSqlArg(FieldType fieldType, Object obj) {
        DateFormat dateFormat = convertDateStringConfig(fieldType, dateFormatConfig).getDateFormat();
        dateFormat.setTimeZone(TimeZone.getDefault());
        return dateFormat.format((Date) obj);
    }

    public Object makeConfigObject(FieldType fieldType) {
        String format = fieldType.getFormat();
        if (format != null) {
            return new ExtendDateStringFormatConfig(format);
        }
        dateFormatConfig.getDateFormat().setTimeZone(TimeZone.getDefault());
        return dateFormatConfig;
    }
}
