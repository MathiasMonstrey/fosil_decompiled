package com.j256.ormlite.misc;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class TransactionManager {
    private static final String SAVE_POINT_PREFIX = "ORMLITE";
    private static final Logger logger = LoggerFactory.getLogger(TransactionManager.class);
    private static AtomicInteger savePointCounter = new AtomicInteger();
    private ConnectionSource connectionSource;

    public TransactionManager(ConnectionSource connectionSource) {
        this.connectionSource = connectionSource;
        initialize();
    }

    public void initialize() {
        if (this.connectionSource == null) {
            throw new IllegalStateException("dataSource was not set on " + getClass().getSimpleName());
        }
    }

    public <T> T callInTransaction(Callable<T> callable) throws SQLException {
        return callInTransaction(this.connectionSource, (Callable) callable);
    }

    public <T> T callInTransaction(String str, Callable<T> callable) throws SQLException {
        return callInTransaction(str, this.connectionSource, (Callable) callable);
    }

    public static <T> T callInTransaction(ConnectionSource connectionSource, Callable<T> callable) throws SQLException {
        return callInTransaction(null, connectionSource, (Callable) callable);
    }

    public static <T> T callInTransaction(String str, ConnectionSource connectionSource, Callable<T> callable) throws SQLException {
        DatabaseConnection readWriteConnection = connectionSource.getReadWriteConnection(str);
        try {
            T callInTransaction = callInTransaction(readWriteConnection, connectionSource.saveSpecialConnection(readWriteConnection), connectionSource.getDatabaseType(), callable);
            return callInTransaction;
        } finally {
            connectionSource.clearSpecialConnection(readWriteConnection);
            connectionSource.releaseConnection(readWriteConnection);
        }
    }

    public static <T> T callInTransaction(DatabaseConnection databaseConnection, DatabaseType databaseType, Callable<T> callable) throws SQLException {
        return callInTransaction(databaseConnection, false, databaseType, callable);
    }

    public static <T> T callInTransaction(DatabaseConnection databaseConnection, boolean z, DatabaseType databaseType, Callable<T> callable) throws SQLException {
        Savepoint savepoint;
        boolean z2;
        Throwable th;
        boolean z3 = false;
        if (!z) {
            if (!databaseType.isNestedSavePointsSupported()) {
                savepoint = null;
                z2 = false;
                T call = callable.call();
                if (z2) {
                    commit(databaseConnection, savepoint);
                }
                if (z3) {
                    databaseConnection.setAutoCommit(true);
                    logger.debug("restored auto-commit to true");
                }
                return call;
            }
        }
        if (databaseConnection.isAutoCommitSupported() && databaseConnection.isAutoCommit()) {
            databaseConnection.setAutoCommit(false);
            try {
                logger.debug("had to set auto-commit to false");
                z3 = true;
            } catch (Throwable th2) {
                th = th2;
                z3 = true;
                if (z3) {
                    databaseConnection.setAutoCommit(true);
                    logger.debug("restored auto-commit to true");
                }
                throw th;
            }
        }
        try {
            Savepoint savePoint = databaseConnection.setSavePoint(SAVE_POINT_PREFIX + savePointCounter.incrementAndGet());
            if (savePoint == null) {
                logger.debug("started savePoint transaction");
            } else {
                logger.debug("started savePoint transaction {}", savePoint.getSavepointName());
            }
            savepoint = savePoint;
            z2 = true;
            T call2 = callable.call();
            if (z2) {
                commit(databaseConnection, savepoint);
            }
            if (z3) {
                databaseConnection.setAutoCommit(true);
                logger.debug("restored auto-commit to true");
            }
            return call2;
        } catch (Throwable th3) {
            if (z2) {
                try {
                    rollBack(databaseConnection, savepoint);
                } catch (SQLException e) {
                    logger.error(th3, "after commit exception, rolling back to save-point also threw exception");
                }
            }
            throw th3;
        } catch (Throwable th32) {
            if (z2) {
                try {
                    rollBack(databaseConnection, savepoint);
                } catch (SQLException e2) {
                    logger.error(th32, "after commit exception, rolling back to save-point also threw exception");
                }
            }
            throw SqlExceptionUtil.create("Transaction callable threw non-SQL exception", th32);
        } catch (Throwable th4) {
            th32 = th4;
            if (z3) {
                databaseConnection.setAutoCommit(true);
                logger.debug("restored auto-commit to true");
            }
            throw th32;
        }
    }

    public void setConnectionSource(ConnectionSource connectionSource) {
        this.connectionSource = connectionSource;
    }

    private static void commit(DatabaseConnection databaseConnection, Savepoint savepoint) throws SQLException {
        Object savepointName = savepoint == null ? null : savepoint.getSavepointName();
        databaseConnection.commit(savepoint);
        if (savepointName == null) {
            logger.debug("committed savePoint transaction");
        } else {
            logger.debug("committed savePoint transaction {}", savepointName);
        }
    }

    private static void rollBack(DatabaseConnection databaseConnection, Savepoint savepoint) throws SQLException {
        Object savepointName = savepoint == null ? null : savepoint.getSavepointName();
        databaseConnection.rollback(savepoint);
        if (savepointName == null) {
            logger.debug("rolled back savePoint transaction");
        } else {
            logger.debug("rolled back savePoint transaction {}", savepointName);
        }
    }
}
