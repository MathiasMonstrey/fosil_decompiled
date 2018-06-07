package com.fossil;

import android.content.Context;
import com.fossil.wearables.fsl.shared.BaseDbProvider;
import com.fossil.wearables.fsl.shared.UpgradeCommand;
import com.j256.ormlite.dao.Dao;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.Explore;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class con extends BaseDbProvider implements com {
    private static final String TAG = con.class.getSimpleName();

    public con(Context context, String str) {
        super(context, str);
    }

    protected int getDbVersion() {
        return 1;
    }

    protected Class<?>[] getDbEntities() {
        return new Class[]{Explore.class};
    }

    private Dao<Explore, Integer> aer() throws SQLException {
        return this.databaseHelper.getDao(Explore.class);
    }

    protected Map<Integer, UpgradeCommand> getDbUpgrades() {
        return null;
    }

    public void mo1981b(Explore explore) {
        if (explore != null) {
            try {
                aer().createOrUpdate(explore);
            } catch (SQLException e) {
                MFLogger.m12671e(TAG, "Error inside " + TAG + ".addOrUpdateWidget - e=" + e);
            }
        }
    }

    public List<Explore> aep() {
        try {
            MFLogger.m12670d(TAG, "---Inside .getAllExplore");
            return aer().queryBuilder().query();
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "Error inside " + TAG + ".getAllExplore - e=" + e);
            return null;
        }
    }

    public void aeq() {
        MFLogger.m12670d(TAG, "Inside .deleteAllExplore");
        try {
            aer().deleteBuilder().delete();
        } catch (Exception e) {
            MFLogger.m12671e(TAG, ".deleteAllExplore - e=" + e.toString());
        }
    }

    public String getDbPath() {
        return this.databaseHelper.getDbPath();
    }
}
