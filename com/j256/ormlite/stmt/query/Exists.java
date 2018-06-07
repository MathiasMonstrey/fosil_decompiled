package com.j256.ormlite.stmt.query;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.stmt.ArgumentHolder;
import com.j256.ormlite.stmt.QueryBuilder.InternalQueryBuilderWrapper;
import java.sql.SQLException;
import java.util.List;

public class Exists implements Clause {
    private final InternalQueryBuilderWrapper subQueryBuilder;

    public Exists(InternalQueryBuilderWrapper internalQueryBuilderWrapper) {
        this.subQueryBuilder = internalQueryBuilderWrapper;
    }

    public void appendSql(DatabaseType databaseType, String str, StringBuilder stringBuilder, List<ArgumentHolder> list) throws SQLException {
        stringBuilder.append("EXISTS (");
        this.subQueryBuilder.appendStatementString(stringBuilder, list);
        stringBuilder.append(") ");
    }
}
