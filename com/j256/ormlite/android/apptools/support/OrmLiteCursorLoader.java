package com.j256.ormlite.android.apptools.support;

import android.content.Context;
import android.database.Cursor;
import com.fossil.gk;
import com.j256.ormlite.android.AndroidCompiledStatement;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.Dao.DaoObserver;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.StatementBuilder.StatementType;

public class OrmLiteCursorLoader<T> extends gk<Cursor> implements DaoObserver {
    protected Cursor cursor;
    protected Dao<T, ?> dao;
    protected PreparedQuery<T> query;

    public OrmLiteCursorLoader(Context context, Dao<T, ?> dao, PreparedQuery<T> preparedQuery) {
        super(context);
        this.dao = dao;
        this.query = preparedQuery;
    }

    public Cursor loadInBackground() {
        try {
            Cursor cursor = ((AndroidCompiledStatement) this.query.compile(this.dao.getConnectionSource().getReadOnlyConnection(this.dao.getTableName()), StatementType.SELECT)).getCursor();
            cursor.getCount();
            return cursor;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void deliverResult(Cursor cursor) {
        if (!isReset()) {
            Cursor cursor2 = this.cursor;
            this.cursor = cursor;
            if (isStarted()) {
                super.deliverResult(cursor);
            }
            if (cursor2 != null && cursor2 != cursor && !cursor2.isClosed()) {
                cursor2.close();
            }
        } else if (cursor != null) {
            cursor.close();
        }
    }

    protected void onStartLoading() {
        this.dao.registerObserver(this);
        if (this.cursor == null) {
            forceLoad();
            return;
        }
        deliverResult(this.cursor);
        if (takeContentChanged()) {
            forceLoad();
        }
    }

    protected void onStopLoading() {
        cancelLoad();
    }

    public void onCanceled(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }

    protected void onReset() {
        super.onReset();
        onStopLoading();
        if (this.cursor != null) {
            if (!this.cursor.isClosed()) {
                this.cursor.close();
            }
            this.cursor = null;
        }
        this.dao.unregisterObserver(this);
    }

    public void onChange() {
        onContentChanged();
    }

    public PreparedQuery<T> getQuery() {
        return this.query;
    }

    public void setQuery(PreparedQuery<T> preparedQuery) {
        this.query = preparedQuery;
    }
}
