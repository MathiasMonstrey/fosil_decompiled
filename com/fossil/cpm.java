package com.fossil;

import android.content.Context;
import com.fossil.wearables.fsl.shared.BaseDbProvider;
import com.fossil.wearables.fsl.shared.UpgradeCommand;
import com.j256.ormlite.dao.Dao;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.Widget;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class cpm extends BaseDbProvider implements cpl {
    private static final String TAG = cpm.class.getSimpleName();

    public cpm(Context context, String str) {
        super(context, str);
    }

    protected int getDbVersion() {
        return 1;
    }

    protected Class<?>[] getDbEntities() {
        return new Class[]{Widget.class};
    }

    private Dao<Widget, Integer> aeR() throws SQLException {
        return this.databaseHelper.getDao(Widget.class);
    }

    protected Map<Integer, UpgradeCommand> getDbUpgrades() {
        return null;
    }

    public void mo2014b(Widget widget) {
        if (widget != null) {
            try {
                aeR().createOrUpdate(widget);
            } catch (SQLException e) {
                MFLogger.m12671e(TAG, "Error inside " + TAG + ".addOrUpdateWidget - e=" + e);
            }
        }
    }

    public List<Widget> aeP() {
        try {
            MFLogger.m12670d(TAG, "---Inside .getAllWidget");
            return aeR().queryBuilder().query();
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "Error inside " + TAG + ".getAllWidget - e=" + e);
            return null;
        }
    }

    public void aeQ() {
        MFLogger.m12670d(TAG, "Inside .deleteAllWidget");
        try {
            aeR().deleteBuilder().delete();
        } catch (Exception e) {
            MFLogger.m12671e(TAG, ".deleteAllWidget - e=" + e.toString());
        }
    }

    public String getDbPath() {
        return this.databaseHelper.getDbPath();
    }
}
