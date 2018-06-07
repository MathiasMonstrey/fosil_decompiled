package com.fossil.wearables.fsl.dial;

import android.content.Context;
import android.util.Log;
import com.fossil.wearables.fsl.shared.BaseDbProvider;
import com.fossil.wearables.fsl.shared.UpgradeCommand;
import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DialProviderImpl extends BaseDbProvider {
    public static final String DB_NAME = "dial.db";
    static DialProviderImpl sDialProvider = null;
    protected final String TAG = getClass().getSimpleName();

    public static DialProviderImpl getInstance(Context context) {
        if (sDialProvider == null) {
            sDialProvider = new DialProviderImpl(context, DB_NAME);
        }
        return sDialProvider;
    }

    public DialProviderImpl(Context context, String str) {
        super(context, str);
    }

    protected int getDbVersion() {
        return 3;
    }

    protected Class<?>[] getDbEntities() {
        return new Class[]{SavedDial.class, ConfigItem.class};
    }

    protected Map<Integer, UpgradeCommand> getDbUpgrades() {
        return null;
    }

    public List<SavedDial> getAllSavedDials() {
        List<SavedDial> queryForAll;
        SQLException e;
        try {
            queryForAll = this.databaseHelper.getDao(SavedDial.class).queryForAll();
            try {
                Log.d(this.TAG, "getAllSavedDials() = " + queryForAll.size());
            } catch (SQLException e2) {
                e = e2;
                Log.e(this.TAG, "getAllSavedDials failed.\n" + e.getLocalizedMessage());
                return queryForAll;
            }
        } catch (SQLException e3) {
            SQLException sQLException = e3;
            queryForAll = null;
            e = sQLException;
            Log.e(this.TAG, "getAllSavedDials failed.\n" + e.getLocalizedMessage());
            return queryForAll;
        }
        return queryForAll;
    }

    public SavedDial getSavedDial(int i) {
        SavedDial savedDial;
        SQLException e;
        try {
            savedDial = (SavedDial) this.databaseHelper.getDao(SavedDial.class).queryForId(Integer.valueOf(i));
            try {
                Log.d(this.TAG, "getSavedDial(" + i + ") = " + savedDial.getDisplayName());
            } catch (SQLException e2) {
                e = e2;
                Log.e(this.TAG, "getSavedDial '" + i + "' failed.\n" + e.getLocalizedMessage());
                return savedDial;
            }
        } catch (SQLException e3) {
            SQLException sQLException = e3;
            savedDial = null;
            e = sQLException;
            Log.e(this.TAG, "getSavedDial '" + i + "' failed.\n" + e.getLocalizedMessage());
            return savedDial;
        }
        return savedDial;
    }

    public void update(SavedDial savedDial) {
        if (savedDial != null) {
            try {
                Dao dao = this.databaseHelper.getDao(SavedDial.class);
                SavedDial savedDial2 = (SavedDial) dao.queryForSameId(savedDial);
                if (savedDial2 != null) {
                    savedDial.setDbRowId(savedDial2.getDbRowId());
                }
                dao.update((Object) savedDial);
                Dao dao2 = this.databaseHelper.getDao(ConfigItem.class);
                for (Object obj : savedDial.getConfigItems()) {
                    ConfigItem configItem = (ConfigItem) dao2.queryForSameId(obj);
                    if (configItem != null) {
                        obj.setDbRowId(configItem.getDbRowId());
                    }
                    dao2.update(obj);
                }
                Log.d(this.TAG, "updated " + savedDial.getDisplayName());
            } catch (SQLException e) {
                Log.e(this.TAG, "update '" + savedDial.getDisplayName() + "' failed.\n" + e.getLocalizedMessage());
            }
        }
    }

    public void updateNoConfig(SavedDial savedDial) {
        if (savedDial != null) {
            try {
                Dao dao = this.databaseHelper.getDao(SavedDial.class);
                SavedDial savedDial2 = (SavedDial) dao.queryForSameId(savedDial);
                if (savedDial2 != null) {
                    savedDial.setDbRowId(savedDial2.getDbRowId());
                }
                dao.update((Object) savedDial);
                Log.d(this.TAG, "updated (no config) " + savedDial.getDisplayName());
            } catch (SQLException e) {
                Log.e(this.TAG, "update '" + savedDial.getDisplayName() + "' failed.\n" + e.getLocalizedMessage());
            }
        }
    }

    public void create(SavedDial savedDial) {
        if (savedDial != null) {
            try {
                this.databaseHelper.getDao(SavedDial.class).create((Object) savedDial);
                Dao dao = this.databaseHelper.getDao(ConfigItem.class);
                Iterator it;
                if (savedDial.getConfigItems() != null) {
                    for (Object create : savedDial.getConfigItems()) {
                        dao.create(create);
                    }
                } else if (savedDial.initialConfigItems != null) {
                    it = savedDial.initialConfigItems.iterator();
                    while (it.hasNext()) {
                        dao.create((ConfigItem) it.next());
                    }
                }
                Log.d(this.TAG, "create " + savedDial.getDisplayName());
            } catch (SQLException e) {
                Log.e(this.TAG, "create '" + savedDial.getDisplayName() + "' failed.\n" + e.getLocalizedMessage());
            }
        }
    }

    public void delete(int i) {
        try {
            Dao dao = this.databaseHelper.getDao(SavedDial.class);
            Object obj = (SavedDial) dao.queryForId(Integer.valueOf(i));
            dao.delete(obj);
            Log.d(this.TAG, "delete " + obj.getDisplayName());
        } catch (SQLException e) {
            Log.e(this.TAG, "delete '" + i + "' failed.\n" + e.getLocalizedMessage());
        }
    }
}
