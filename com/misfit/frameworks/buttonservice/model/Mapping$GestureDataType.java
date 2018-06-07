package com.misfit.frameworks.buttonservice.model;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.field.types.BaseEnumType;
import com.j256.ormlite.support.DatabaseResults;
import com.misfit.frameworks.common.enums.Gesture;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

class Mapping$GestureDataType extends BaseEnumType {
    private static final Mapping$GestureDataType singleTon = new Mapping$GestureDataType();

    public static Mapping$GestureDataType getSingleton() {
        return singleTon;
    }

    private Mapping$GestureDataType() {
        super(SqlType.INTEGER);
    }

    public Object parseDefaultString(FieldType fieldType, String str) {
        return Integer.valueOf(Integer.parseInt(str));
    }

    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i) throws SQLException {
        return Integer.valueOf(databaseResults.getInt(i));
    }

    public Object sqlArgToJava(FieldType fieldType, Object obj, int i) throws SQLException {
        if (fieldType == null) {
            return obj;
        }
        Integer num = (Integer) obj;
        Map map = (Map) fieldType.getDataTypeConfigObj();
        return map == null ? enumVal(fieldType, num, (Enum) null, fieldType.getUnknownEnumVal()) : enumVal(fieldType, num, (Enum) map.get(num), fieldType.getUnknownEnumVal());
    }

    public Object javaToSqlArg(FieldType fieldType, Object obj) {
        return Integer.valueOf(((Gesture) obj).getValue());
    }

    public Object makeConfigObject(FieldType fieldType) throws SQLException {
        HashMap hashMap = new HashMap();
        Gesture[] gestureArr = (Gesture[]) fieldType.getType().getEnumConstants();
        if (gestureArr == null) {
            throw new SQLException("Field " + fieldType + " improperly configured as type " + this);
        }
        for (Gesture gesture : gestureArr) {
            hashMap.put(Integer.valueOf(gesture.getValue()), gesture);
        }
        return hashMap;
    }

    public Class<?> getPrimaryClass() {
        return Integer.TYPE;
    }
}
