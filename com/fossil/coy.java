package com.fossil;

import android.content.Context;
import com.fossil.wearables.fsl.shared.BaseDbProvider;
import com.fossil.wearables.fsl.shared.UpgradeCommand;
import com.j256.ormlite.dao.Dao;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.LandingPage;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class coy extends BaseDbProvider implements cox {
    private static final String TAG = coy.class.getSimpleName();

    public coy(Context context, String str) {
        super(context, str);
    }

    protected int getDbVersion() {
        return 1;
    }

    protected Class<?>[] getDbEntities() {
        return new Class[]{LandingPage.class};
    }

    private Dao<LandingPage, Integer> aeE() throws SQLException {
        return this.databaseHelper.getDao(LandingPage.class);
    }

    protected Map<Integer, UpgradeCommand> getDbUpgrades() {
        return null;
    }

    public void mo1986a(LandingPage landingPage) {
        if (landingPage != null) {
            try {
                aeE().createOrUpdate(landingPage);
            } catch (Exception e) {
                MFLogger.m12671e(TAG, "Error inside " + TAG + ".addOrUpdateLandingPage - e=" + e);
            }
        }
    }

    public List<LandingPage> aeC() {
        try {
            MFLogger.m12670d(TAG, "---Inside .getAllLandingPage");
            return aeE().queryBuilder().query();
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "Error inside " + TAG + ".getAllLandingPage - e=" + e);
            return null;
        }
    }

    public void aeD() {
        MFLogger.m12670d(TAG, "Inside .deleteAllLandingPage");
        try {
            aeE().deleteBuilder().delete();
        } catch (Exception e) {
            MFLogger.m12671e(TAG, ".deleteAllLandingPage - e=" + e.toString());
        }
    }

    public String getDbPath() {
        return this.databaseHelper.getDbPath();
    }
}
