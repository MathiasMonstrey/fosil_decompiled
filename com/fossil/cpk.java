package com.fossil;

import android.content.Context;
import com.fossil.wearables.fsl.shared.BaseDbProvider;
import com.fossil.wearables.fsl.shared.UpgradeCommand;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.table.TableUtils;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.MFUser;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class cpk extends BaseDbProvider implements cpj {
    public cpk(Context context, String str) {
        super(context, str);
    }

    protected int getDbVersion() {
        return 1;
    }

    protected Class<?>[] getDbEntities() {
        return new Class[]{MFUser.class};
    }

    protected Map<Integer, UpgradeCommand> getDbUpgrades() {
        return null;
    }

    protected Dao<MFUser, Integer> aeO() throws SQLException {
        return this.databaseHelper.getDao(MFUser.class);
    }

    public void mo2008a(MFUser mFUser) {
        if (mFUser != null) {
            MFLogger.m12671e(this.TAG, "Inside .addOrUpdateUser updateAvatar=" + mFUser);
            try {
                aeO().createOrUpdate(mFUser);
                return;
            } catch (Exception e) {
                MFLogger.m12671e(this.TAG, "Inside .addOrUpdateUser exception=" + e);
                return;
            }
        }
        MFLogger.m12671e(this.TAG, "Inside .addOrUpdateUser error user is null");
    }

    public void mo2009b(MFUser mFUser) {
        if (mFUser != null) {
            MFLogger.m12671e(this.TAG, "Inside .deleteUser user=" + mFUser);
            try {
                aeO().delete(mFUser);
                return;
            } catch (Exception e) {
                MFLogger.m12671e(this.TAG, "Inside .deleteUser exception=" + e);
                return;
            }
        }
        MFLogger.m12671e(this.TAG, "Inside .deleteUser error user is null");
    }

    public MFUser getCurrentUser() {
        try {
            List queryForAll = aeO().queryForAll();
            return (queryForAll == null || queryForAll.isEmpty()) ? null : (MFUser) queryForAll.get(0);
        } catch (Exception e) {
            MFLogger.m12671e(this.TAG, "Inside .getUser exception=" + e);
            return null;
        }
    }

    public void clearAllUser() {
        try {
            TableUtils.clearTable(aeO().getConnectionSource(), MFUser.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getDbPath() {
        return this.databaseHelper.getDbPath();
    }
}
