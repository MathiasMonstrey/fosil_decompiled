package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.support.DatabaseResults;
import java.lang.reflect.Field;

public class VoidType extends BaseDataType {
    VoidType() {
        super(null, new Class[0]);
    }

    public Object parseDefaultString(FieldType fieldType, String str) {
        return null;
    }

    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i) {
        return null;
    }

    public boolean isValidForField(Field field) {
        return false;
    }
}
