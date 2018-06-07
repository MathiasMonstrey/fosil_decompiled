package com.misfit.frameworks.buttonservice.db;

import android.content.Context;
import com.misfit.frameworks.common.log.MFLogger;
import java.util.Map;

public abstract class BaseDbProvider {
    protected final String TAG = getClass().getCanonicalName();
    protected Context context;
    protected DatabaseHelper databaseHelper;
    protected boolean isCacheDirty = true;

    protected abstract Class<?>[] getDbEntities();

    protected abstract Map<Integer, UpgradeCommand> getDbUpgrades();

    protected abstract int getDbVersion();

    public BaseDbProvider(Context context, String str) {
        this.context = context;
        this.databaseHelper = new DatabaseHelper(context, str, getDbVersion(), getDbEntities(), getDbUpgrades());
    }

    public BaseDbProvider(Context context, String str, String str2) {
        this.databaseHelper = new DatabaseHelper(context, str + "_" + str2, getDbVersion(), getDbEntities(), getDbUpgrades());
    }

    public void setCacheToDirty() {
        MFLogger.d(this.TAG, "Setting cache to dirty");
        this.isCacheDirty = true;
    }
}
