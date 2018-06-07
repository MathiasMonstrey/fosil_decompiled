package com.fossil;

import android.content.Context;
import com.fossil.wearables.fsl.shared.BaseDbProvider;
import com.fossil.wearables.fsl.shared.UpgradeCommand;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.Where;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.Firmware;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class cpa extends BaseDbProvider implements coz {
    private static final String TAG = cpa.class.getSimpleName();

    public cpa(Context context, String str) {
        super(context, str);
    }

    protected int getDbVersion() {
        return 1;
    }

    protected Class<?>[] getDbEntities() {
        return new Class[]{Firmware.class};
    }

    private Dao<Firmware, Integer> aeF() throws SQLException {
        return this.databaseHelper.getDao(Firmware.class);
    }

    protected Map<Integer, UpgradeCommand> getDbUpgrades() {
        return null;
    }

    public Firmware hr(String str) {
        try {
            Where where = aeF().queryBuilder().where();
            where.eq("deviceModel", str);
            List query = where.query();
            if (query != null && query.size() > 0) {
                return (Firmware) query.get(0);
            }
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "Error inside " + TAG + ".getLatestFirmware with model " + str + ") - e=" + e);
        }
        return null;
    }

    public void mo1992a(Firmware firmware) {
        try {
            aeF().createOrUpdate(firmware);
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "Error inside " + TAG + ".addOrUpdatePhoto - e=" + e);
        }
    }

    public String getDbPath() {
        return this.databaseHelper.getDbPath();
    }
}
