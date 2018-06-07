package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.BaseForeignCollection;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.GenericRowMapper;
import com.j256.ormlite.support.DatabaseResults;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseMappedQuery<T, ID> extends BaseMappedStatement<T, ID> implements GenericRowMapper<T> {
    private Map<String, Integer> columnPositions = null;
    private Object parent = null;
    private Object parentId = null;
    protected final FieldType[] resultsFieldTypes;

    protected BaseMappedQuery(TableInfo<T, ID> tableInfo, String str, FieldType[] fieldTypeArr, FieldType[] fieldTypeArr2) {
        super(tableInfo, str, fieldTypeArr);
        this.resultsFieldTypes = fieldTypeArr2;
    }

    public T mapRow(DatabaseResults databaseResults) throws SQLException {
        Map hashMap;
        if (this.columnPositions == null) {
            hashMap = new HashMap();
        } else {
            hashMap = this.columnPositions;
        }
        ObjectCache objectCacheForRetrieve = databaseResults.getObjectCacheForRetrieve();
        if (objectCacheForRetrieve != null) {
            T t = objectCacheForRetrieve.get(this.clazz, this.idField.resultToJava(databaseResults, hashMap));
            if (t != null) {
                return t;
            }
        }
        T createObject = this.tableInfo.createObject();
        Object obj = null;
        boolean z = false;
        for (FieldType fieldType : this.resultsFieldTypes) {
            if (fieldType.isForeignCollection()) {
                z = true;
            } else {
                Object resultToJava = fieldType.resultToJava(databaseResults, hashMap);
                if (resultToJava == null || this.parent == null || fieldType.getField().getType() != this.parent.getClass() || !resultToJava.equals(this.parentId)) {
                    fieldType.assignField(createObject, resultToJava, false, objectCacheForRetrieve);
                } else {
                    fieldType.assignField(createObject, this.parent, true, objectCacheForRetrieve);
                }
                if (fieldType.isId()) {
                    obj = resultToJava;
                }
            }
        }
        if (z) {
            for (FieldType fieldType2 : this.resultsFieldTypes) {
                if (fieldType2.isForeignCollection()) {
                    BaseForeignCollection buildForeignCollection = fieldType2.buildForeignCollection(createObject, obj);
                    if (buildForeignCollection != null) {
                        fieldType2.assignField(createObject, buildForeignCollection, false, objectCacheForRetrieve);
                    }
                }
            }
        }
        ObjectCache objectCacheForStore = databaseResults.getObjectCacheForStore();
        if (!(objectCacheForStore == null || obj == null)) {
            objectCacheForStore.put(this.clazz, obj, createObject);
        }
        if (this.columnPositions == null) {
            this.columnPositions = hashMap;
        }
        return createObject;
    }

    public void setParentInformation(Object obj, Object obj2) {
        this.parent = obj;
        this.parentId = obj2;
    }
}
