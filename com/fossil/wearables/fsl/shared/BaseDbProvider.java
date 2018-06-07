package com.fossil.wearables.fsl.shared;

import android.content.Context;
import android.util.Log;
import java.util.Map;

public abstract class BaseDbProvider {
    protected final String TAG = getClass().getCanonicalName();
    protected Context context;
    protected DatabaseHelper databaseHelper;
    protected boolean isCacheDirty = true;

    public abstract Class<?>[] getDbEntities();

    public abstract Map<Integer, UpgradeCommand> getDbUpgrades();

    public abstract int getDbVersion();

    public BaseDbProvider(Context context, String str) {
        this.context = context;
        this.databaseHelper = new DatabaseHelper(context, str, getDbVersion(), getDbEntities(), getDbUpgrades());
    }

    public BaseDbProvider(Context context, String str, String str2) {
        this.databaseHelper = new DatabaseHelper(context, str + "_" + str2, getDbVersion(), getDbEntities(), getDbUpgrades());
    }

    public void setCacheToDirty() {
        Log.d(this.TAG, "Setting cache to dirty");
        this.isCacheDirty = true;
    }
}
