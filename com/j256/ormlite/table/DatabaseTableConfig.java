package com.j256.ormlite.table;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.DatabaseFieldConfig;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.misc.JavaxPersistenceConfigurer;
import com.j256.ormlite.support.ConnectionSource;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseTableConfig<T> {
    private static JavaxPersistenceConfigurer javaxPersistenceConfigurer;
    private Constructor<T> constructor;
    private Class<T> dataClass;
    private List<DatabaseFieldConfig> fieldConfigs;
    private FieldType[] fieldTypes;
    private String tableName;

    static {
        try {
            Class.forName("javax.persistence.Entity");
            javaxPersistenceConfigurer = (JavaxPersistenceConfigurer) Class.forName("com.j256.ormlite.misc.JavaxPersistenceImpl").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            javaxPersistenceConfigurer = null;
        }
    }

    public DatabaseTableConfig(Class<T> cls, List<DatabaseFieldConfig> list) {
        this((Class) cls, extractTableName(cls), (List) list);
    }

    public DatabaseTableConfig(Class<T> cls, String str, List<DatabaseFieldConfig> list) {
        this.dataClass = cls;
        this.tableName = str;
        this.fieldConfigs = list;
    }

    private DatabaseTableConfig(Class<T> cls, String str, FieldType[] fieldTypeArr) {
        this.dataClass = cls;
        this.tableName = str;
        this.fieldTypes = fieldTypeArr;
    }

    public void initialize() {
        if (this.dataClass == null) {
            throw new IllegalStateException("dataClass was never set on " + getClass().getSimpleName());
        } else if (this.tableName == null) {
            this.tableName = extractTableName(this.dataClass);
        }
    }

    public Class<T> getDataClass() {
        return this.dataClass;
    }

    public void setDataClass(Class<T> cls) {
        this.dataClass = cls;
    }

    public String getTableName() {
        return this.tableName;
    }

    public void setTableName(String str) {
        this.tableName = str;
    }

    public void setFieldConfigs(List<DatabaseFieldConfig> list) {
        this.fieldConfigs = list;
    }

    public void extractFieldTypes(ConnectionSource connectionSource) throws SQLException {
        if (this.fieldTypes != null) {
            return;
        }
        if (this.fieldConfigs == null) {
            this.fieldTypes = extractFieldTypes(connectionSource, this.dataClass, this.tableName);
        } else {
            this.fieldTypes = convertFieldConfigs(connectionSource, this.tableName, this.fieldConfigs);
        }
    }

    public FieldType[] getFieldTypes(DatabaseType databaseType) throws SQLException {
        if (this.fieldTypes != null) {
            return this.fieldTypes;
        }
        throw new SQLException("Field types have not been extracted in table config");
    }

    public List<DatabaseFieldConfig> getFieldConfigs() {
        return this.fieldConfigs;
    }

    public Constructor<T> getConstructor() {
        if (this.constructor == null) {
            this.constructor = findNoArgConstructor(this.dataClass);
        }
        return this.constructor;
    }

    public void setConstructor(Constructor<T> constructor) {
        this.constructor = constructor;
    }

    public static <T> DatabaseTableConfig<T> fromClass(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        String extractTableName = extractTableName(cls);
        DatabaseType databaseType = connectionSource.getDatabaseType();
        if (databaseType.isEntityNamesMustBeUpCase()) {
            extractTableName = databaseType.upCaseEntityName(extractTableName);
        }
        return new DatabaseTableConfig((Class) cls, extractTableName, extractFieldTypes(connectionSource, cls, extractTableName));
    }

    public static <T> String extractTableName(Class<T> cls) {
        String str;
        DatabaseTable databaseTable = (DatabaseTable) cls.getAnnotation(DatabaseTable.class);
        if (databaseTable == null || databaseTable.tableName() == null || databaseTable.tableName().length() <= 0) {
            str = null;
        } else {
            str = databaseTable.tableName();
        }
        if (str == null && javaxPersistenceConfigurer != null) {
            str = javaxPersistenceConfigurer.getEntityName(cls);
        }
        if (str == null) {
            return cls.getSimpleName().toLowerCase();
        }
        return str;
    }

    public static <T> Constructor<T> findNoArgConstructor(Class<T> cls) {
        try {
            for (Constructor<T> constructor : cls.getDeclaredConstructors()) {
                if (constructor.getParameterTypes().length == 0) {
                    if (!constructor.isAccessible()) {
                        try {
                            constructor.setAccessible(true);
                        } catch (SecurityException e) {
                            throw new IllegalArgumentException("Could not open access to constructor for " + cls);
                        }
                    }
                    return constructor;
                }
            }
            if (cls.getEnclosingClass() == null) {
                throw new IllegalArgumentException("Can't find a no-arg constructor for " + cls);
            }
            throw new IllegalArgumentException("Can't find a no-arg constructor for " + cls + ".  Missing static on inner class?");
        } catch (Throwable e2) {
            throw new IllegalArgumentException("Can't lookup declared constructors for " + cls, e2);
        }
    }

    private static <T> FieldType[] extractFieldTypes(ConnectionSource connectionSource, Class<T> cls, String str) throws SQLException {
        List arrayList = new ArrayList();
        for (Class cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            for (Field createFieldType : cls2.getDeclaredFields()) {
                FieldType createFieldType2 = FieldType.createFieldType(connectionSource, str, createFieldType, cls);
                if (createFieldType2 != null) {
                    arrayList.add(createFieldType2);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            return (FieldType[]) arrayList.toArray(new FieldType[arrayList.size()]);
        }
        throw new IllegalArgumentException("No fields have a " + DatabaseField.class.getSimpleName() + " annotation in " + cls);
    }

    private FieldType[] convertFieldConfigs(ConnectionSource connectionSource, String str, List<DatabaseFieldConfig> list) throws SQLException {
        List arrayList = new ArrayList();
        for (DatabaseFieldConfig databaseFieldConfig : list) {
            Object obj = null;
            Class cls = this.dataClass;
            while (cls != null) {
                try {
                    Field declaredField = cls.getDeclaredField(databaseFieldConfig.getFieldName());
                    if (declaredField != null) {
                        obj = new FieldType(connectionSource, str, declaredField, databaseFieldConfig, this.dataClass);
                        break;
                    }
                    cls = cls.getSuperclass();
                } catch (NoSuchFieldException e) {
                }
            }
            if (obj == null) {
                throw new SQLException("Could not find declared field with name '" + databaseFieldConfig.getFieldName() + "' for " + this.dataClass);
            }
            arrayList.add(obj);
        }
        if (!arrayList.isEmpty()) {
            return (FieldType[]) arrayList.toArray(new FieldType[arrayList.size()]);
        }
        throw new SQLException("No fields were configured for class " + this.dataClass);
    }
}
