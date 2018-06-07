package com.j256.ormlite.misc;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.DataPersisterManager;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseFieldConfig;
import java.lang.reflect.Field;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

public class JavaxPersistenceImpl implements JavaxPersistenceConfigurer {
    public DatabaseFieldConfig createFieldConfig(DatabaseType databaseType, Field field) {
        Column column = (Column) field.getAnnotation(Column.class);
        Basic basic = (Basic) field.getAnnotation(Basic.class);
        Id id = (Id) field.getAnnotation(Id.class);
        GeneratedValue generatedValue = (GeneratedValue) field.getAnnotation(GeneratedValue.class);
        OneToOne oneToOne = (OneToOne) field.getAnnotation(OneToOne.class);
        ManyToOne manyToOne = (ManyToOne) field.getAnnotation(ManyToOne.class);
        JoinColumn joinColumn = (JoinColumn) field.getAnnotation(JoinColumn.class);
        Enumerated enumerated = (Enumerated) field.getAnnotation(Enumerated.class);
        Version version = (Version) field.getAnnotation(Version.class);
        if (column == null && basic == null && id == null && oneToOne == null && manyToOne == null && enumerated == null && version == null) {
            return null;
        }
        DatabaseFieldConfig databaseFieldConfig = new DatabaseFieldConfig();
        String name = field.getName();
        if (databaseType.isEntityNamesMustBeUpCase()) {
            name = databaseType.upCaseEntityName(name);
        }
        databaseFieldConfig.setFieldName(name);
        if (column != null) {
            if (stringNotEmpty(column.name())) {
                databaseFieldConfig.setColumnName(column.name());
            }
            if (stringNotEmpty(column.columnDefinition())) {
                databaseFieldConfig.setColumnDefinition(column.columnDefinition());
            }
            databaseFieldConfig.setWidth(column.length());
            databaseFieldConfig.setCanBeNull(column.nullable());
            databaseFieldConfig.setUnique(column.unique());
        }
        if (basic != null) {
            databaseFieldConfig.setCanBeNull(basic.optional());
        }
        if (id != null) {
            if (generatedValue == null) {
                databaseFieldConfig.setId(true);
            } else {
                databaseFieldConfig.setGeneratedId(true);
            }
        }
        if (!(oneToOne == null && manyToOne == null)) {
            if (Collection.class.isAssignableFrom(field.getType()) || ForeignCollection.class.isAssignableFrom(field.getType())) {
                databaseFieldConfig.setForeignCollection(true);
                if (joinColumn != null && stringNotEmpty(joinColumn.name())) {
                    databaseFieldConfig.setForeignCollectionColumnName(joinColumn.name());
                }
                if (manyToOne != null) {
                    FetchType fetch = manyToOne.fetch();
                    if (fetch != null && fetch == FetchType.EAGER) {
                        databaseFieldConfig.setForeignCollectionEager(true);
                    }
                }
            } else {
                databaseFieldConfig.setForeign(true);
                if (joinColumn != null) {
                    if (stringNotEmpty(joinColumn.name())) {
                        databaseFieldConfig.setColumnName(joinColumn.name());
                    }
                    databaseFieldConfig.setCanBeNull(joinColumn.nullable());
                    databaseFieldConfig.setUnique(joinColumn.unique());
                }
            }
        }
        if (enumerated != null) {
            EnumType value = enumerated.value();
            if (value == null || value != EnumType.STRING) {
                databaseFieldConfig.setDataType(DataType.ENUM_INTEGER);
            } else {
                databaseFieldConfig.setDataType(DataType.ENUM_STRING);
            }
        }
        if (version != null) {
            databaseFieldConfig.setVersion(true);
        }
        if (databaseFieldConfig.getDataPersister() == null) {
            databaseFieldConfig.setDataPersister(DataPersisterManager.lookupForField(field));
        }
        boolean z = (DatabaseFieldConfig.findGetMethod(field, false) == null || DatabaseFieldConfig.findSetMethod(field, false) == null) ? false : true;
        databaseFieldConfig.setUseGetSet(z);
        return databaseFieldConfig;
    }

    public String getEntityName(Class<?> cls) {
        Entity entity = (Entity) cls.getAnnotation(Entity.class);
        Table table = (Table) cls.getAnnotation(Table.class);
        if (entity != null && stringNotEmpty(entity.name())) {
            return entity.name();
        }
        if (table == null || !stringNotEmpty(table.name())) {
            return null;
        }
        return table.name();
    }

    private boolean stringNotEmpty(String str) {
        return str != null && str.length() > 0;
    }
}
