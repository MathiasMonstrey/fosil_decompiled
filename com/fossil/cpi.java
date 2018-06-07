package com.fossil;

import android.content.Context;
import com.fossil.wearables.fsl.shared.BaseDbProvider;
import com.fossil.wearables.fsl.shared.UpgradeCommand;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.microapp.SecondTimezone;
import java.sql.SQLException;
import java.util.Map;

public class cpi extends BaseDbProvider implements cph {
    public cpi(Context context, String str) {
        super(context, str);
    }

    protected int getDbVersion() {
        return 1;
    }

    protected Class<?>[] getDbEntities() {
        return new Class[]{SecondTimezone.class};
    }

    protected Map<Integer, UpgradeCommand> getDbUpgrades() {
        return null;
    }

    private Dao<SecondTimezone, Integer> aeN() throws SQLException {
        return this.databaseHelper.getDao(SecondTimezone.class);
    }

    public SecondTimezone aeM() {
        try {
            QueryBuilder queryBuilder = aeN().queryBuilder();
            queryBuilder.where().eq("isActiveAlarm", Boolean.valueOf(true));
            return (SecondTimezone) queryBuilder.queryForFirst();
        } catch (Exception e) {
            MFLogger.m12671e("SecondTimezoneProviderImp", "getActiveSecondTimezone - e=" + e);
            return null;
        }
    }

    public String getDbPath() {
        return this.databaseHelper.getDbPath();
    }
}
