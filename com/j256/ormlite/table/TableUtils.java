package com.j256.ormlite.table;

import android.support.v8.renderscript.Allocation;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.IOUtils;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.stmt.StatementBuilder.StatementType;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import java.io.Closeable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TableUtils {
    private static Logger logger = LoggerFactory.getLogger(TableUtils.class);
    private static final FieldType[] noFieldTypes = new FieldType[0];

    private TableUtils() {
    }

    public static <T> int createTable(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        return doCreateTable(DaoManager.createDao(connectionSource, (Class) cls), false);
    }

    public static int createTable(Dao<?, ?> dao) throws SQLException {
        return doCreateTable(dao, false);
    }

    public static <T> int createTableIfNotExists(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        return doCreateTable(DaoManager.createDao(connectionSource, (Class) cls), true);
    }

    public static <T> int createTable(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        return doCreateTable(DaoManager.createDao(connectionSource, (DatabaseTableConfig) databaseTableConfig), false);
    }

    public static <T> int createTableIfNotExists(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        return doCreateTable(DaoManager.createDao(connectionSource, (DatabaseTableConfig) databaseTableConfig), true);
    }

    public static <T, ID> List<String> getCreateTableStatements(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        Dao createDao = DaoManager.createDao(connectionSource, (Class) cls);
        if (createDao instanceof BaseDaoImpl) {
            return addCreateTableStatements(connectionSource, ((BaseDaoImpl) createDao).getTableInfo(), false);
        }
        return addCreateTableStatements(connectionSource, new TableInfo(connectionSource, null, (Class) cls), false);
    }

    public static <T, ID> List<String> getCreateTableStatements(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        Dao createDao = DaoManager.createDao(connectionSource, (DatabaseTableConfig) databaseTableConfig);
        if (createDao instanceof BaseDaoImpl) {
            return addCreateTableStatements(connectionSource, ((BaseDaoImpl) createDao).getTableInfo(), false);
        }
        databaseTableConfig.extractFieldTypes(connectionSource);
        return addCreateTableStatements(connectionSource, new TableInfo(connectionSource.getDatabaseType(), null, (DatabaseTableConfig) databaseTableConfig), false);
    }

    public static <T, ID> int dropTable(ConnectionSource connectionSource, Class<T> cls, boolean z) throws SQLException {
        return dropTable(DaoManager.createDao(connectionSource, (Class) cls), z);
    }

    public static <T, ID> int dropTable(Dao<T, ID> dao, boolean z) throws SQLException {
        ConnectionSource connectionSource = dao.getConnectionSource();
        Class dataClass = dao.getDataClass();
        DatabaseType databaseType = connectionSource.getDatabaseType();
        if (dao instanceof BaseDaoImpl) {
            return doDropTable(databaseType, connectionSource, ((BaseDaoImpl) dao).getTableInfo(), z);
        }
        return doDropTable(databaseType, connectionSource, new TableInfo(connectionSource, null, dataClass), z);
    }

    public static <T, ID> int dropTable(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig, boolean z) throws SQLException {
        DatabaseType databaseType = connectionSource.getDatabaseType();
        Dao createDao = DaoManager.createDao(connectionSource, (DatabaseTableConfig) databaseTableConfig);
        if (createDao instanceof BaseDaoImpl) {
            return doDropTable(databaseType, connectionSource, ((BaseDaoImpl) createDao).getTableInfo(), z);
        }
        databaseTableConfig.extractFieldTypes(connectionSource);
        return doDropTable(databaseType, connectionSource, new TableInfo(databaseType, null, (DatabaseTableConfig) databaseTableConfig), z);
    }

    public static <T> int clearTable(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        String extractTableName = DatabaseTableConfig.extractTableName(cls);
        DatabaseType databaseType = connectionSource.getDatabaseType();
        if (databaseType.isEntityNamesMustBeUpCase()) {
            extractTableName = databaseType.upCaseEntityName(extractTableName);
        }
        return clearTable(connectionSource, extractTableName);
    }

    public static <T> int clearTable(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        return clearTable(connectionSource, databaseTableConfig.getTableName());
    }

    private static <T> int clearTable(ConnectionSource connectionSource, String str) throws SQLException {
        Closeable compileStatement;
        Throwable th;
        DatabaseType databaseType = connectionSource.getDatabaseType();
        StringBuilder stringBuilder = new StringBuilder(48);
        if (databaseType.isTruncateSupported()) {
            stringBuilder.append("TRUNCATE TABLE ");
        } else {
            stringBuilder.append("DELETE FROM ");
        }
        databaseType.appendEscapedEntityName(stringBuilder, str);
        Object stringBuilder2 = stringBuilder.toString();
        logger.info("clearing table '{}' with '{}", (Object) str, stringBuilder2);
        DatabaseConnection readWriteConnection = connectionSource.getReadWriteConnection(str);
        try {
            compileStatement = readWriteConnection.compileStatement(stringBuilder2, StatementType.EXECUTE, noFieldTypes, -1, false);
            try {
                int runExecute = compileStatement.runExecute();
                IOUtils.closeThrowSqlException(compileStatement, "compiled statement");
                connectionSource.releaseConnection(readWriteConnection);
                return runExecute;
            } catch (Throwable th2) {
                th = th2;
                IOUtils.closeThrowSqlException(compileStatement, "compiled statement");
                connectionSource.releaseConnection(readWriteConnection);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            compileStatement = null;
            IOUtils.closeThrowSqlException(compileStatement, "compiled statement");
            connectionSource.releaseConnection(readWriteConnection);
            throw th;
        }
    }

    private static <T, ID> int doDropTable(DatabaseType databaseType, ConnectionSource connectionSource, TableInfo<T, ID> tableInfo, boolean z) throws SQLException {
        logger.info("dropping table '{}'", tableInfo.getTableName());
        Collection arrayList = new ArrayList();
        addDropIndexStatements(databaseType, tableInfo, arrayList);
        addDropTableStatements(databaseType, tableInfo, arrayList);
        DatabaseConnection readWriteConnection = connectionSource.getReadWriteConnection(tableInfo.getTableName());
        try {
            int doStatements = doStatements(readWriteConnection, "drop", arrayList, z, databaseType.isCreateTableReturnsNegative(), false);
            return doStatements;
        } finally {
            connectionSource.releaseConnection(readWriteConnection);
        }
    }

    private static <T, ID> void addDropIndexStatements(DatabaseType databaseType, TableInfo<T, ID> tableInfo, List<String> list) {
        Set<Object> hashSet = new HashSet();
        for (FieldType fieldType : tableInfo.getFieldTypes()) {
            String indexName = fieldType.getIndexName();
            if (indexName != null) {
                hashSet.add(indexName);
            }
            String uniqueIndexName = fieldType.getUniqueIndexName();
            if (uniqueIndexName != null) {
                hashSet.add(uniqueIndexName);
            }
        }
        StringBuilder stringBuilder = new StringBuilder(48);
        for (Object obj : hashSet) {
            logger.info("dropping index '{}' for table '{}", obj, tableInfo.getTableName());
            stringBuilder.append("DROP INDEX ");
            databaseType.appendEscapedEntityName(stringBuilder, obj);
            list.add(stringBuilder.toString());
            stringBuilder.setLength(0);
        }
    }

    private static <T, ID> void addCreateIndexStatements(DatabaseType databaseType, TableInfo<T, ID> tableInfo, List<String> list, boolean z, boolean z2) {
        Map hashMap = new HashMap();
        for (FieldType fieldType : tableInfo.getFieldTypes()) {
            if (z2) {
                Object uniqueIndexName = fieldType.getUniqueIndexName();
            } else {
                String indexName = fieldType.getIndexName();
            }
            if (uniqueIndexName != null) {
                List list2 = (List) hashMap.get(uniqueIndexName);
                if (list2 == null) {
                    list2 = new ArrayList();
                    hashMap.put(uniqueIndexName, list2);
                }
                list2.add(fieldType.getColumnName());
            }
        }
        StringBuilder stringBuilder = new StringBuilder(Allocation.USAGE_SHARED);
        for (Entry entry : hashMap.entrySet()) {
            logger.info("creating index '{}' for table '{}", entry.getKey(), tableInfo.getTableName());
            stringBuilder.append("CREATE ");
            if (z2) {
                stringBuilder.append("UNIQUE ");
            }
            stringBuilder.append("INDEX ");
            if (z && databaseType.isCreateIndexIfNotExistsSupported()) {
                stringBuilder.append("IF NOT EXISTS ");
            }
            databaseType.appendEscapedEntityName(stringBuilder, (String) entry.getKey());
            stringBuilder.append(" ON ");
            databaseType.appendEscapedEntityName(stringBuilder, tableInfo.getTableName());
            stringBuilder.append(" ( ");
            int i = 1;
            for (String str : (List) entry.getValue()) {
                if (i != 0) {
                    i = 0;
                } else {
                    stringBuilder.append(", ");
                }
                databaseType.appendEscapedEntityName(stringBuilder, str);
            }
            stringBuilder.append(" )");
            list.add(stringBuilder.toString());
            stringBuilder.setLength(0);
        }
    }

    private static <T, ID> void addDropTableStatements(DatabaseType databaseType, TableInfo<T, ID> tableInfo, List<String> list) {
        Collection arrayList = new ArrayList();
        Collection arrayList2 = new ArrayList();
        for (FieldType dropColumnArg : tableInfo.getFieldTypes()) {
            databaseType.dropColumnArg(dropColumnArg, arrayList, arrayList2);
        }
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append("DROP TABLE ");
        databaseType.appendEscapedEntityName(stringBuilder, tableInfo.getTableName());
        stringBuilder.append(' ');
        list.addAll(arrayList);
        list.add(stringBuilder.toString());
        list.addAll(arrayList2);
    }

    private static <T, ID> int doCreateTable(Dao<T, ID> dao, boolean z) throws SQLException {
        if (dao instanceof BaseDaoImpl) {
            return doCreateTable(dao.getConnectionSource(), ((BaseDaoImpl) dao).getTableInfo(), z);
        }
        return doCreateTable(dao.getConnectionSource(), new TableInfo(dao.getConnectionSource(), null, dao.getDataClass()), z);
    }

    private static <T, ID> int doCreateTable(ConnectionSource connectionSource, TableInfo<T, ID> tableInfo, boolean z) throws SQLException {
        DatabaseType databaseType = connectionSource.getDatabaseType();
        logger.info("creating table '{}'", tableInfo.getTableName());
        Collection arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        addCreateTableStatements(databaseType, tableInfo, arrayList, arrayList2, z);
        DatabaseConnection readWriteConnection = connectionSource.getReadWriteConnection(tableInfo.getTableName());
        try {
            int doStatements = doStatements(readWriteConnection, "create", arrayList, false, databaseType.isCreateTableReturnsNegative(), databaseType.isCreateTableReturnsZero()) + doCreateTestQueries(readWriteConnection, databaseType, arrayList2);
            return doStatements;
        } finally {
            connectionSource.releaseConnection(readWriteConnection);
        }
    }

    private static int doStatements(DatabaseConnection databaseConnection, String str, Collection<String> collection, boolean z, boolean z2, boolean z3) throws SQLException {
        Closeable compileStatement;
        Object e;
        Throwable th;
        int i = 0;
        for (Object obj : collection) {
            int runExecute;
            try {
                compileStatement = databaseConnection.compileStatement(obj, StatementType.EXECUTE, noFieldTypes, -1, false);
                try {
                    runExecute = compileStatement.runExecute();
                } catch (SQLException e2) {
                    e = e2;
                    runExecute = 0;
                    if (z) {
                        try {
                            logger.info("ignoring {} error '{}' for statement: {}", (Object) str, e, obj);
                            IOUtils.closeThrowSqlException(compileStatement, "compiled statement");
                            if (runExecute < 0) {
                                throw new SQLException("SQL statement updated " + runExecute + " rows, we were expecting == 0: " + obj);
                            } else if (z2) {
                                throw new SQLException("SQL statement " + obj + " updated " + runExecute + " rows, we were expecting >= 0");
                            }
                            i++;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } else {
                        throw SqlExceptionUtil.create("SQL statement failed: " + obj, e);
                    }
                }
                try {
                    logger.info("executed {} table statement changed {} rows: {}", (Object) str, Integer.valueOf(runExecute), obj);
                    IOUtils.closeThrowSqlException(compileStatement, "compiled statement");
                } catch (SQLException e3) {
                    e = e3;
                    if (z) {
                        throw SqlExceptionUtil.create("SQL statement failed: " + obj, e);
                    }
                    logger.info("ignoring {} error '{}' for statement: {}", (Object) str, e, obj);
                    IOUtils.closeThrowSqlException(compileStatement, "compiled statement");
                    if (runExecute < 0) {
                        throw new SQLException("SQL statement updated " + runExecute + " rows, we were expecting == 0: " + obj);
                    } else if (z2) {
                        throw new SQLException("SQL statement " + obj + " updated " + runExecute + " rows, we were expecting >= 0");
                    }
                    i++;
                }
            } catch (SQLException e4) {
                e = e4;
                compileStatement = null;
                runExecute = 0;
                if (z) {
                    logger.info("ignoring {} error '{}' for statement: {}", (Object) str, e, obj);
                    IOUtils.closeThrowSqlException(compileStatement, "compiled statement");
                    if (runExecute < 0) {
                        throw new SQLException("SQL statement updated " + runExecute + " rows, we were expecting == 0: " + obj);
                    } else if (z2) {
                        throw new SQLException("SQL statement " + obj + " updated " + runExecute + " rows, we were expecting >= 0");
                    }
                    i++;
                } else {
                    throw SqlExceptionUtil.create("SQL statement failed: " + obj, e);
                }
            } catch (Throwable th3) {
                th = th3;
                compileStatement = null;
            }
            if (runExecute < 0) {
                if (z2) {
                    throw new SQLException("SQL statement " + obj + " updated " + runExecute + " rows, we were expecting >= 0");
                }
            } else if (runExecute > 0 && z3) {
                throw new SQLException("SQL statement updated " + runExecute + " rows, we were expecting == 0: " + obj);
            }
            i++;
        }
        return i;
        IOUtils.closeThrowSqlException(compileStatement, "compiled statement");
        throw th;
    }

    private static int doCreateTestQueries(DatabaseConnection databaseConnection, DatabaseType databaseType, List<String> list) throws SQLException {
        Closeable compileStatement;
        Throwable e;
        int i = 0;
        for (Object obj : list) {
            try {
                compileStatement = databaseConnection.compileStatement(obj, StatementType.SELECT, noFieldTypes, -1, false);
                try {
                    DatabaseResults runQuery = compileStatement.runQuery(null);
                    int i2 = 0;
                    for (boolean first = runQuery.first(); first; first = runQuery.next()) {
                        i2++;
                    }
                    logger.info("executing create table after-query got {} results: {}", Integer.valueOf(i2), obj);
                    IOUtils.closeThrowSqlException(compileStatement, "compiled statement");
                    i++;
                } catch (SQLException e2) {
                    e = e2;
                }
            } catch (SQLException e3) {
                e = e3;
                compileStatement = null;
            } catch (Throwable th) {
                e = th;
                compileStatement = null;
            }
        }
        return i;
        try {
            throw SqlExceptionUtil.create("executing create table after-query failed: " + obj, e);
        } catch (Throwable th2) {
            e = th2;
            IOUtils.closeThrowSqlException(compileStatement, "compiled statement");
            throw e;
        }
    }

    private static <T, ID> List<String> addCreateTableStatements(ConnectionSource connectionSource, TableInfo<T, ID> tableInfo, boolean z) throws SQLException {
        List<String> arrayList = new ArrayList();
        addCreateTableStatements(connectionSource.getDatabaseType(), tableInfo, arrayList, new ArrayList(), z);
        return arrayList;
    }

    private static <T, ID> void addCreateTableStatements(DatabaseType databaseType, TableInfo<T, ID> tableInfo, List<String> list, List<String> list2, boolean z) throws SQLException {
        StringBuilder stringBuilder = new StringBuilder(256);
        stringBuilder.append("CREATE TABLE ");
        if (z && databaseType.isCreateIfNotExistsSupported()) {
            stringBuilder.append("IF NOT EXISTS ");
        }
        databaseType.appendEscapedEntityName(stringBuilder, tableInfo.getTableName());
        stringBuilder.append(" (");
        List<String> arrayList = new ArrayList();
        Collection arrayList2 = new ArrayList();
        Collection arrayList3 = new ArrayList();
        FieldType[] fieldTypes = tableInfo.getFieldTypes();
        int length = fieldTypes.length;
        int i = 0;
        Object obj = 1;
        while (i < length) {
            Object obj2;
            String columnDefinition;
            FieldType fieldType = fieldTypes[i];
            if (fieldType.isForeignCollection()) {
                obj2 = obj;
            } else {
                if (obj != null) {
                    obj2 = null;
                } else {
                    stringBuilder.append(", ");
                    obj2 = obj;
                }
                columnDefinition = fieldType.getColumnDefinition();
                if (columnDefinition == null) {
                    databaseType.appendColumnArg(tableInfo.getTableName(), stringBuilder, fieldType, arrayList, arrayList2, arrayList3, list2);
                } else {
                    databaseType.appendEscapedEntityName(stringBuilder, fieldType.getColumnName());
                    stringBuilder.append(' ').append(columnDefinition).append(' ');
                }
            }
            i++;
            obj = obj2;
        }
        databaseType.addPrimaryKeySql(tableInfo.getFieldTypes(), arrayList, arrayList2, arrayList3, list2);
        databaseType.addUniqueComboSql(tableInfo.getFieldTypes(), arrayList, arrayList2, arrayList3, list2);
        for (String columnDefinition2 : arrayList) {
            stringBuilder.append(", ").append(columnDefinition2);
        }
        stringBuilder.append(") ");
        databaseType.appendCreateTableSuffix(stringBuilder);
        list.addAll(arrayList2);
        list.add(stringBuilder.toString());
        list.addAll(arrayList3);
        addCreateIndexStatements(databaseType, tableInfo, list, z, false);
        addCreateIndexStatements(databaseType, tableInfo, list, z, true);
    }
}
