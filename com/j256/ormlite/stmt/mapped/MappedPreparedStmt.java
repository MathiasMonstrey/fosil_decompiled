package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.logger.Log.Level;
import com.j256.ormlite.misc.IOUtils;
import com.j256.ormlite.stmt.ArgumentHolder;
import com.j256.ormlite.stmt.PreparedDelete;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.PreparedUpdate;
import com.j256.ormlite.stmt.StatementBuilder.StatementType;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;

public class MappedPreparedStmt<T, ID> extends BaseMappedQuery<T, ID> implements PreparedDelete<T>, PreparedQuery<T>, PreparedUpdate<T> {
    private final ArgumentHolder[] argHolders;
    private final boolean cacheStore;
    private final Long limit;
    private final StatementType type;

    public MappedPreparedStmt(TableInfo<T, ID> tableInfo, String str, FieldType[] fieldTypeArr, FieldType[] fieldTypeArr2, ArgumentHolder[] argumentHolderArr, Long l, StatementType statementType, boolean z) {
        super(tableInfo, str, fieldTypeArr, fieldTypeArr2);
        this.argHolders = argumentHolderArr;
        this.limit = l;
        this.type = statementType;
        this.cacheStore = z;
    }

    public CompiledStatement compile(DatabaseConnection databaseConnection, StatementType statementType) throws SQLException {
        return compile(databaseConnection, statementType, -1);
    }

    public CompiledStatement compile(DatabaseConnection databaseConnection, StatementType statementType, int i) throws SQLException {
        if (this.type != statementType) {
            throw new SQLException("Could not compile this " + this.type + " statement since the caller is expecting a " + statementType + " statement.  Check your QueryBuilder methods.");
        }
        return assignStatementArguments(databaseConnection.compileStatement(this.statement, statementType, this.argFieldTypes, i, this.cacheStore));
    }

    public String getStatement() {
        return this.statement;
    }

    public StatementType getType() {
        return this.type;
    }

    public void setArgumentHolderValue(int i, Object obj) throws SQLException {
        if (i < 0) {
            throw new SQLException("argument holder index " + i + " must be >= 0");
        } else if (this.argHolders.length <= i) {
            throw new SQLException("argument holder index " + i + " is not valid, only " + this.argHolders.length + " in statement (index starts at 0)");
        } else {
            this.argHolders[i].setValue(obj);
        }
    }

    private CompiledStatement assignStatementArguments(CompiledStatement compiledStatement) throws SQLException {
        try {
            if (this.limit != null) {
                compiledStatement.setMaxRows(this.limit.intValue());
            }
            Object obj = null;
            if (logger.isLevelEnabled(Level.TRACE) && this.argHolders.length > 0) {
                obj = new Object[this.argHolders.length];
            }
            for (int i = 0; i < this.argHolders.length; i++) {
                SqlType sqlType;
                Object sqlArgValue = this.argHolders[i].getSqlArgValue();
                FieldType fieldType = this.argFieldTypes[i];
                if (fieldType == null) {
                    sqlType = this.argHolders[i].getSqlType();
                } else {
                    sqlType = fieldType.getSqlType();
                }
                compiledStatement.setObject(i, sqlArgValue, sqlType);
                if (obj != null) {
                    obj[i] = sqlArgValue;
                }
            }
            logger.debug("prepared statement '{}' with {} args", this.statement, Integer.valueOf(this.argHolders.length));
            if (obj != null) {
                logger.trace("prepared statement arguments: {}", obj);
            }
            return compiledStatement;
        } catch (Throwable th) {
            IOUtils.closeThrowSqlException(compiledStatement, "statement");
        }
    }
}
