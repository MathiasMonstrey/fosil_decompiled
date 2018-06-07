package com.fossil.wearables.fsl.shared;

import android.database.sqlite.SQLiteDatabase;

public interface UpgradeCommand {
    void execute(SQLiteDatabase sQLiteDatabase);
}
