package com.misfit.frameworks.buttonservice.db;

import android.database.sqlite.SQLiteDatabase;

public interface UpgradeCommand {
    void execute(SQLiteDatabase sQLiteDatabase);
}
