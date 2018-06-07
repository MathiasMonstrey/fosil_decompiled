package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.StatementBuilder.StatementType;
import com.j256.ormlite.stmt.StatementBuilder.WhereOperation;
import com.j256.ormlite.stmt.query.ColumnNameOrRawSql;
import com.j256.ormlite.stmt.query.OrderBy;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryBuilder<T, ID> extends StatementBuilder<T, ID> {
    private String alias;
    private String countOfQuery;
    private boolean distinct;
    private List<ColumnNameOrRawSql> groupByList;
    private String having;
    private final FieldType idField;
    private boolean isInnerQuery;
    private List<JoinInfo> joinList;
    private Long limit;
    private Long offset;
    private List<OrderBy> orderByList;
    private FieldType[] resultFieldTypes;
    private boolean selectIdColumn;
    private List<ColumnNameOrRawSql> selectList;

    public static class InternalQueryBuilderWrapper {
        private final QueryBuilder<?, ?> queryBuilder;

        InternalQueryBuilderWrapper(QueryBuilder<?, ?> queryBuilder) {
            this.queryBuilder = queryBuilder;
        }

        public void appendStatementString(StringBuilder stringBuilder, List<ArgumentHolder> list) throws SQLException {
            this.queryBuilder.appendStatementString(stringBuilder, list);
        }

        public FieldType[] getResultFieldTypes() {
            return this.queryBuilder.getResultFieldTypes();
        }
    }

    class JoinInfo {
        FieldType localField;
        JoinWhereOperation operation;
        final QueryBuilder<?, ?> queryBuilder;
        FieldType remoteField;
        final JoinType type;

        public JoinInfo(JoinType joinType, QueryBuilder<?, ?> queryBuilder, JoinWhereOperation joinWhereOperation) {
            this.type = joinType;
            this.queryBuilder = queryBuilder;
            this.operation = joinWhereOperation;
        }
    }

    public enum JoinType {
        INNER("INNER"),
        LEFT("LEFT");
        
        private String sql;

        private JoinType(String str) {
            this.sql = str;
        }
    }

    public enum JoinWhereOperation {
        AND(WhereOperation.AND),
        OR(WhereOperation.OR);
        
        private WhereOperation whereOperation;

        private JoinWhereOperation(WhereOperation whereOperation) {
            this.whereOperation = whereOperation;
        }
    }

    public QueryBuilder(DatabaseType databaseType, TableInfo<T, ID> tableInfo, Dao<T, ID> dao) {
        super(databaseType, tableInfo, dao, StatementType.SELECT);
        this.idField = tableInfo.getIdField();
        this.selectIdColumn = this.idField != null;
    }

    void enableInnerQuery() {
        this.isInnerQuery = true;
    }

    int getSelectColumnCount() {
        if (this.countOfQuery != null) {
            return 1;
        }
        if (this.selectList == null) {
            return 0;
        }
        return this.selectList.size();
    }

    String getSelectColumnsAsString() {
        if (this.countOfQuery != null) {
            return "COUNT(" + this.countOfQuery + ")";
        }
        if (this.selectList == null) {
            return "";
        }
        return this.selectList.toString();
    }

    public PreparedQuery<T> prepare() throws SQLException {
        return super.prepareStatement(this.limit, this.selectList == null);
    }

    public QueryBuilder<T, ID> selectColumns(String... strArr) {
        for (String addSelectColumnToList : strArr) {
            addSelectColumnToList(addSelectColumnToList);
        }
        return this;
    }

    public QueryBuilder<T, ID> selectColumns(Iterable<String> iterable) {
        for (String addSelectColumnToList : iterable) {
            addSelectColumnToList(addSelectColumnToList);
        }
        return this;
    }

    public QueryBuilder<T, ID> selectRaw(String... strArr) {
        for (String withRawSql : strArr) {
            addSelectToList(ColumnNameOrRawSql.withRawSql(withRawSql));
        }
        return this;
    }

    public QueryBuilder<T, ID> groupBy(String str) {
        if (verifyColumnName(str).isForeignCollection()) {
            throw new IllegalArgumentException("Can't groupBy foreign colletion field: " + str);
        }
        addGroupBy(ColumnNameOrRawSql.withColumnName(str));
        return this;
    }

    public QueryBuilder<T, ID> groupByRaw(String str) {
        addGroupBy(ColumnNameOrRawSql.withRawSql(str));
        return this;
    }

    public QueryBuilder<T, ID> orderBy(String str, boolean z) {
        if (verifyColumnName(str).isForeignCollection()) {
            throw new IllegalArgumentException("Can't orderBy foreign colletion field: " + str);
        }
        addOrderBy(new OrderBy(str, z));
        return this;
    }

    public QueryBuilder<T, ID> orderByRaw(String str) {
        addOrderBy(new OrderBy(str, (ArgumentHolder[]) null));
        return this;
    }

    public QueryBuilder<T, ID> orderByRaw(String str, ArgumentHolder... argumentHolderArr) {
        addOrderBy(new OrderBy(str, argumentHolderArr));
        return this;
    }

    public QueryBuilder<T, ID> distinct() {
        this.distinct = true;
        this.selectIdColumn = false;
        return this;
    }

    public QueryBuilder<T, ID> limit(Long l) {
        this.limit = l;
        return this;
    }

    public QueryBuilder<T, ID> offset(Long l) throws SQLException {
        if (this.databaseType.isOffsetSqlSupported()) {
            this.offset = l;
            return this;
        }
        throw new SQLException("Offset is not supported by this database");
    }

    public QueryBuilder<T, ID> setCountOf(boolean z) {
        return setCountOf("*");
    }

    public QueryBuilder<T, ID> setCountOf(String str) {
        this.countOfQuery = str;
        return this;
    }

    public QueryBuilder<T, ID> having(String str) {
        this.having = str;
        return this;
    }

    public QueryBuilder<T, ID> join(QueryBuilder<?, ?> queryBuilder) throws SQLException {
        addJoinInfo(JoinType.INNER, null, null, queryBuilder, JoinWhereOperation.AND);
        return this;
    }

    public QueryBuilder<T, ID> join(QueryBuilder<?, ?> queryBuilder, JoinType joinType, JoinWhereOperation joinWhereOperation) throws SQLException {
        addJoinInfo(joinType, null, null, queryBuilder, joinWhereOperation);
        return this;
    }

    public QueryBuilder<T, ID> joinOr(QueryBuilder<?, ?> queryBuilder) throws SQLException {
        addJoinInfo(JoinType.INNER, null, null, queryBuilder, JoinWhereOperation.OR);
        return this;
    }

    public QueryBuilder<T, ID> leftJoin(QueryBuilder<?, ?> queryBuilder) throws SQLException {
        addJoinInfo(JoinType.LEFT, null, null, queryBuilder, JoinWhereOperation.AND);
        return this;
    }

    public QueryBuilder<T, ID> leftJoinOr(QueryBuilder<?, ?> queryBuilder) throws SQLException {
        addJoinInfo(JoinType.LEFT, null, null, queryBuilder, JoinWhereOperation.OR);
        return this;
    }

    public QueryBuilder<T, ID> join(String str, String str2, QueryBuilder<?, ?> queryBuilder) throws SQLException {
        addJoinInfo(JoinType.INNER, str, str2, queryBuilder, JoinWhereOperation.AND);
        return this;
    }

    public QueryBuilder<T, ID> join(String str, String str2, QueryBuilder<?, ?> queryBuilder, JoinType joinType, JoinWhereOperation joinWhereOperation) throws SQLException {
        addJoinInfo(joinType, str, str2, queryBuilder, joinWhereOperation);
        return this;
    }

    public List<T> query() throws SQLException {
        return this.dao.query(prepare());
    }

    public GenericRawResults<String[]> queryRaw() throws SQLException {
        return this.dao.queryRaw(prepareStatementString(), new String[0]);
    }

    public T queryForFirst() throws SQLException {
        return this.dao.queryForFirst(prepare());
    }

    public String[] queryRawFirst() throws SQLException {
        return (String[]) this.dao.queryRaw(prepareStatementString(), new String[0]).getFirstResult();
    }

    public CloseableIterator<T> iterator() throws SQLException {
        return this.dao.iterator(prepare());
    }

    public long countOf() throws SQLException {
        String str = this.countOfQuery;
        try {
            setCountOf(true);
            long countOf = this.dao.countOf(prepare());
            return countOf;
        } finally {
            setCountOf(str);
        }
    }

    public long countOf(String str) throws SQLException {
        String str2 = this.countOfQuery;
        try {
            setCountOf(str);
            long countOf = this.dao.countOf(prepare());
            return countOf;
        } finally {
            setCountOf(str2);
        }
    }

    public QueryBuilder<T, ID> setAlias(String str) {
        this.alias = str;
        return this;
    }

    public void reset() {
        super.reset();
        this.distinct = false;
        this.selectIdColumn = this.idField != null;
        if (this.selectList != null) {
            this.selectList.clear();
            this.selectList = null;
        }
        if (this.orderByList != null) {
            this.orderByList.clear();
            this.orderByList = null;
        }
        if (this.groupByList != null) {
            this.groupByList.clear();
            this.groupByList = null;
        }
        this.isInnerQuery = false;
        this.countOfQuery = null;
        this.having = null;
        this.limit = null;
        this.offset = null;
        if (this.joinList != null) {
            this.joinList.clear();
            this.joinList = null;
        }
        this.addTableName = false;
        this.alias = null;
    }

    protected void appendStatementStart(StringBuilder stringBuilder, List<ArgumentHolder> list) {
        if (this.joinList == null) {
            setAddTableName(false);
        } else {
            setAddTableName(true);
        }
        stringBuilder.append("SELECT ");
        if (this.databaseType.isLimitAfterSelect()) {
            appendLimit(stringBuilder);
        }
        if (this.distinct) {
            stringBuilder.append("DISTINCT ");
        }
        if (this.countOfQuery == null) {
            appendSelects(stringBuilder);
        } else {
            this.type = StatementType.SELECT_LONG;
            stringBuilder.append("COUNT(").append(this.countOfQuery).append(") ");
        }
        stringBuilder.append("FROM ");
        this.databaseType.appendEscapedEntityName(stringBuilder, this.tableName);
        if (this.alias != null) {
            appendAlias(stringBuilder);
        }
        stringBuilder.append(' ');
        if (this.joinList != null) {
            appendJoinSql(stringBuilder);
        }
    }

    protected FieldType[] getResultFieldTypes() {
        return this.resultFieldTypes;
    }

    protected boolean appendWhereStatement(StringBuilder stringBuilder, List<ArgumentHolder> list, WhereOperation whereOperation) throws SQLException {
        boolean z = whereOperation == WhereOperation.FIRST;
        if (this.where != null) {
            z = super.appendWhereStatement(stringBuilder, list, whereOperation);
        }
        if (this.joinList == null) {
            return z;
        }
        boolean z2 = z;
        for (JoinInfo joinInfo : this.joinList) {
            WhereOperation whereOperation2;
            if (z2) {
                whereOperation2 = WhereOperation.FIRST;
            } else {
                whereOperation2 = joinInfo.operation.whereOperation;
            }
            z2 = joinInfo.queryBuilder.appendWhereStatement(stringBuilder, list, whereOperation2);
        }
        return z2;
    }

    protected void appendStatementEnd(StringBuilder stringBuilder, List<ArgumentHolder> list) throws SQLException {
        appendGroupBys(stringBuilder);
        appendHaving(stringBuilder);
        appendOrderBys(stringBuilder, list);
        if (!this.databaseType.isLimitAfterSelect()) {
            appendLimit(stringBuilder);
        }
        appendOffset(stringBuilder);
        setAddTableName(false);
    }

    protected boolean shouldPrependTableNameToColumns() {
        return this.joinList != null;
    }

    protected void appendTableQualifier(StringBuilder stringBuilder) {
        this.databaseType.appendEscapedEntityName(stringBuilder, getTableName());
    }

    protected String getTableName() {
        return this.alias == null ? this.tableName : this.alias;
    }

    private void addOrderBy(OrderBy orderBy) {
        if (this.orderByList == null) {
            this.orderByList = new ArrayList();
        }
        this.orderByList.add(orderBy);
    }

    private void addGroupBy(ColumnNameOrRawSql columnNameOrRawSql) {
        if (this.groupByList == null) {
            this.groupByList = new ArrayList();
        }
        this.groupByList.add(columnNameOrRawSql);
        this.selectIdColumn = false;
    }

    private void setAddTableName(boolean z) {
        this.addTableName = z;
        if (this.joinList != null) {
            for (JoinInfo joinInfo : this.joinList) {
                joinInfo.queryBuilder.setAddTableName(z);
            }
        }
    }

    private void addJoinInfo(JoinType joinType, String str, String str2, QueryBuilder<?, ?> queryBuilder, JoinWhereOperation joinWhereOperation) throws SQLException {
        JoinInfo joinInfo = new JoinInfo(joinType, queryBuilder, joinWhereOperation);
        if (str == null) {
            matchJoinedFields(joinInfo, queryBuilder);
        } else {
            matchJoinedFieldsByName(joinInfo, str, str2, queryBuilder);
        }
        if (this.joinList == null) {
            this.joinList = new ArrayList();
        }
        this.joinList.add(joinInfo);
    }

    private void matchJoinedFieldsByName(JoinInfo joinInfo, String str, String str2, QueryBuilder<?, ?> queryBuilder) throws SQLException {
        joinInfo.localField = this.tableInfo.getFieldTypeByColumnName(str);
        if (joinInfo.localField == null) {
            throw new SQLException("Could not find field in " + this.tableInfo.getDataClass() + " that has column-name '" + str + "'");
        }
        joinInfo.remoteField = queryBuilder.tableInfo.getFieldTypeByColumnName(str2);
        if (joinInfo.remoteField == null) {
            throw new SQLException("Could not find field in " + queryBuilder.tableInfo.getDataClass() + " that has column-name '" + str2 + "'");
        }
    }

    private void matchJoinedFields(JoinInfo joinInfo, QueryBuilder<?, ?> queryBuilder) throws SQLException {
        int i = 0;
        for (FieldType fieldType : this.tableInfo.getFieldTypes()) {
            FieldType foreignRefField = fieldType.getForeignRefField();
            if (fieldType.isForeign() && foreignRefField.equals(queryBuilder.tableInfo.getIdField())) {
                joinInfo.localField = fieldType;
                joinInfo.remoteField = foreignRefField;
                return;
            }
        }
        FieldType[] fieldTypes = queryBuilder.tableInfo.getFieldTypes();
        int length = fieldTypes.length;
        while (i < length) {
            FieldType fieldType2 = fieldTypes[i];
            if (fieldType2.isForeign() && fieldType2.getForeignIdField().equals(this.idField)) {
                joinInfo.localField = this.idField;
                joinInfo.remoteField = fieldType2;
                return;
            }
            i++;
        }
        throw new SQLException("Could not find a foreign " + this.tableInfo.getDataClass() + " field in " + queryBuilder.tableInfo.getDataClass() + " or vice versa");
    }

    private void addSelectColumnToList(String str) {
        verifyColumnName(str);
        addSelectToList(ColumnNameOrRawSql.withColumnName(str));
    }

    private void addSelectToList(ColumnNameOrRawSql columnNameOrRawSql) {
        if (this.selectList == null) {
            this.selectList = new ArrayList();
        }
        this.selectList.add(columnNameOrRawSql);
    }

    private void appendJoinSql(StringBuilder stringBuilder) {
        for (JoinInfo joinInfo : this.joinList) {
            stringBuilder.append(joinInfo.type.sql).append(" JOIN ");
            this.databaseType.appendEscapedEntityName(stringBuilder, joinInfo.queryBuilder.tableName);
            if (joinInfo.queryBuilder.alias != null) {
                joinInfo.queryBuilder.appendAlias(stringBuilder);
            }
            stringBuilder.append(" ON ");
            appendTableQualifier(stringBuilder);
            stringBuilder.append('.');
            this.databaseType.appendEscapedEntityName(stringBuilder, joinInfo.localField.getColumnName());
            stringBuilder.append(" = ");
            joinInfo.queryBuilder.appendTableQualifier(stringBuilder);
            stringBuilder.append('.');
            this.databaseType.appendEscapedEntityName(stringBuilder, joinInfo.remoteField.getColumnName());
            stringBuilder.append(' ');
            if (joinInfo.queryBuilder.joinList != null) {
                joinInfo.queryBuilder.appendJoinSql(stringBuilder);
            }
        }
    }

    private void appendSelects(StringBuilder stringBuilder) {
        this.type = StatementType.SELECT;
        if (this.selectList == null) {
            if (this.addTableName) {
                appendTableQualifier(stringBuilder);
                stringBuilder.append('.');
            }
            stringBuilder.append("* ");
            this.resultFieldTypes = this.tableInfo.getFieldTypes();
            return;
        }
        Object obj;
        if (this.isInnerQuery) {
            obj = 1;
        } else {
            obj = null;
        }
        List arrayList = new ArrayList(this.selectList.size() + 1);
        Object obj2 = obj;
        Object obj3 = 1;
        for (ColumnNameOrRawSql columnNameOrRawSql : this.selectList) {
            if (columnNameOrRawSql.getRawSql() != null) {
                this.type = StatementType.SELECT_RAW;
                if (obj3 != null) {
                    obj3 = null;
                } else {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(columnNameOrRawSql.getRawSql());
            } else {
                FieldType fieldTypeByColumnName = this.tableInfo.getFieldTypeByColumnName(columnNameOrRawSql.getColumnName());
                if (fieldTypeByColumnName.isForeignCollection()) {
                    arrayList.add(fieldTypeByColumnName);
                } else {
                    if (obj3 != null) {
                        obj3 = null;
                    } else {
                        stringBuilder.append(", ");
                    }
                    appendFieldColumnName(stringBuilder, fieldTypeByColumnName, arrayList);
                    if (fieldTypeByColumnName == this.idField) {
                        obj = 1;
                    } else {
                        obj = obj2;
                    }
                    obj2 = obj;
                }
            }
        }
        if (this.type != StatementType.SELECT_RAW) {
            if (obj2 == null && this.selectIdColumn) {
                if (obj3 == null) {
                    stringBuilder.append(',');
                }
                appendFieldColumnName(stringBuilder, this.idField, arrayList);
            }
            this.resultFieldTypes = (FieldType[]) arrayList.toArray(new FieldType[arrayList.size()]);
        }
        stringBuilder.append(' ');
    }

    private void appendFieldColumnName(StringBuilder stringBuilder, FieldType fieldType, List<FieldType> list) {
        appendColumnName(stringBuilder, fieldType.getColumnName());
        if (list != null) {
            list.add(fieldType);
        }
    }

    private void appendLimit(StringBuilder stringBuilder) {
        if (this.limit != null && this.databaseType.isLimitSqlSupported()) {
            this.databaseType.appendLimitValue(stringBuilder, this.limit.longValue(), this.offset);
        }
    }

    private void appendOffset(StringBuilder stringBuilder) throws SQLException {
        if (this.offset != null) {
            if (!this.databaseType.isOffsetLimitArgument()) {
                this.databaseType.appendOffsetValue(stringBuilder, this.offset.longValue());
            } else if (this.limit == null) {
                throw new SQLException("If the offset is specified, limit must also be specified with this database");
            }
        }
    }

    private void appendGroupBys(StringBuilder stringBuilder) {
        boolean z = true;
        if (hasGroupStuff()) {
            appendGroupBys(stringBuilder, true);
            z = false;
        }
        if (this.joinList != null) {
            boolean z2 = z;
            for (JoinInfo joinInfo : this.joinList) {
                if (joinInfo.queryBuilder == null || !joinInfo.queryBuilder.hasGroupStuff()) {
                    z = z2;
                } else {
                    joinInfo.queryBuilder.appendGroupBys(stringBuilder, z2);
                    z = false;
                }
                z2 = z;
            }
        }
    }

    private boolean hasGroupStuff() {
        return (this.groupByList == null || this.groupByList.isEmpty()) ? false : true;
    }

    private void appendGroupBys(StringBuilder stringBuilder, boolean z) {
        if (z) {
            stringBuilder.append("GROUP BY ");
        }
        for (ColumnNameOrRawSql columnNameOrRawSql : this.groupByList) {
            if (z) {
                z = false;
            } else {
                stringBuilder.append(',');
            }
            if (columnNameOrRawSql.getRawSql() == null) {
                appendColumnName(stringBuilder, columnNameOrRawSql.getColumnName());
            } else {
                stringBuilder.append(columnNameOrRawSql.getRawSql());
            }
        }
        stringBuilder.append(' ');
    }

    private void appendOrderBys(StringBuilder stringBuilder, List<ArgumentHolder> list) {
        boolean z = true;
        if (hasOrderStuff()) {
            appendOrderBys(stringBuilder, true, list);
            z = false;
        }
        if (this.joinList != null) {
            boolean z2 = z;
            for (JoinInfo joinInfo : this.joinList) {
                if (joinInfo.queryBuilder == null || !joinInfo.queryBuilder.hasOrderStuff()) {
                    z = z2;
                } else {
                    joinInfo.queryBuilder.appendOrderBys(stringBuilder, z2, list);
                    z = false;
                }
                z2 = z;
            }
        }
    }

    private boolean hasOrderStuff() {
        return (this.orderByList == null || this.orderByList.isEmpty()) ? false : true;
    }

    private void appendOrderBys(StringBuilder stringBuilder, boolean z, List<ArgumentHolder> list) {
        if (z) {
            stringBuilder.append("ORDER BY ");
        }
        for (OrderBy orderBy : this.orderByList) {
            if (z) {
                z = false;
            } else {
                stringBuilder.append(',');
            }
            if (orderBy.getRawSql() == null) {
                appendColumnName(stringBuilder, orderBy.getColumnName());
                if (!orderBy.isAscending()) {
                    stringBuilder.append(" DESC");
                }
            } else {
                stringBuilder.append(orderBy.getRawSql());
                if (orderBy.getOrderByArgs() != null) {
                    for (Object add : orderBy.getOrderByArgs()) {
                        list.add(add);
                    }
                }
            }
        }
        stringBuilder.append(' ');
    }

    private void appendColumnName(StringBuilder stringBuilder, String str) {
        if (this.addTableName) {
            appendTableQualifier(stringBuilder);
            stringBuilder.append('.');
        }
        this.databaseType.appendEscapedEntityName(stringBuilder, str);
    }

    private void appendHaving(StringBuilder stringBuilder) {
        if (this.having != null) {
            stringBuilder.append("HAVING ").append(this.having).append(' ');
        }
    }

    private void appendAlias(StringBuilder stringBuilder) {
        stringBuilder.append(" AS ");
        this.databaseType.appendEscapedEntityName(stringBuilder, this.alias);
    }
}
