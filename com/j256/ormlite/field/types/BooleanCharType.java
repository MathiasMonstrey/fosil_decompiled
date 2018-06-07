package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

public class BooleanCharType extends BooleanType {
    private static final String DEFAULT_TRUE_FALSE_FORMAT = "10";
    private static final BooleanCharType singleTon = new BooleanCharType();

    public static BooleanCharType getSingleton() {
        return singleTon;
    }

    public BooleanCharType() {
        super(SqlType.STRING);
    }

    public Object parseDefaultString(FieldType fieldType, String str) {
        return javaToSqlArg(fieldType, Boolean.valueOf(Boolean.parseBoolean(str)));
    }

    public Object javaToSqlArg(FieldType fieldType, Object obj) {
        String str = (String) fieldType.getDataTypeConfigObj();
        return Character.valueOf(((Boolean) obj).booleanValue() ? str.charAt(0) : str.charAt(1));
    }

    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i) throws SQLException {
        return Character.valueOf(databaseResults.getChar(i));
    }

    public Object sqlArgToJava(FieldType fieldType, Object obj, int i) {
        return ((Character) obj).charValue() == ((String) fieldType.getDataTypeConfigObj()).charAt(0) ? Boolean.TRUE : Boolean.FALSE;
    }

    public Object resultStringToJava(FieldType fieldType, String str, int i) {
        if (str.length() == 0) {
            return Boolean.FALSE;
        }
        return sqlArgToJava(fieldType, Character.valueOf(str.charAt(0)), i);
    }

    public Object makeConfigObject(FieldType fieldType) throws SQLException {
        Object format = fieldType.getFormat();
        if (format == null) {
            return DEFAULT_TRUE_FALSE_FORMAT;
        }
        if (format.length() == 2 && format.charAt(0) != format.charAt(1)) {
            return format;
        }
        throw new SQLException("Invalid boolean format must have 2 different characters that represent true/false like \"10\" or \"tf\": " + format);
    }
}
