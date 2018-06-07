package com.fossil;

import android.content.Context;
import com.fossil.wearables.fsl.shared.BaseDbProvider;
import com.fossil.wearables.fsl.shared.UpgradeCommand;
import com.j256.ormlite.dao.Dao;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.Integration;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class cow extends BaseDbProvider implements cov {
    private static final String TAG = cow.class.getSimpleName();

    public cow(Context context, String str) {
        super(context, str);
    }

    protected int getDbVersion() {
        return 1;
    }

    protected Class<?>[] getDbEntities() {
        return new Class[]{Integration.class};
    }

    protected Map<Integer, UpgradeCommand> getDbUpgrades() {
        return null;
    }

    private Dao<Integration, Integer> aeB() throws SQLException {
        return this.databaseHelper.getDao(Integration.class);
    }

    public void mo1983a(Integration integration) {
        if (integration != null) {
            try {
                aeB().createOrUpdate(integration);
            } catch (SQLException e) {
                MFLogger.m12671e(TAG, "Error inside " + TAG + ".addOrUpdateIntegration - e=" + e);
            }
        }
    }

    public List<Integration> aez() {
        try {
            MFLogger.m12670d(TAG, "---Inside .getAllIntegration");
            return aeB().queryBuilder().query();
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "Error inside " + TAG + ".getAllIntegration - e=" + e);
            return null;
        }
    }

    public void aeA() {
        MFLogger.m12670d(TAG, "Inside .deleteAllIntegration");
        try {
            aeB().deleteBuilder().delete();
        } catch (Exception e) {
            MFLogger.m12671e(TAG, ".deleteAllIntegration - e=" + e.toString());
        }
    }

    public String getDbPath() {
        return this.databaseHelper.getDbPath();
    }
}
