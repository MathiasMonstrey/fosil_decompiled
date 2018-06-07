package com.fossil;

import android.content.Context;
import android.text.TextUtils;
import com.fossil.wearables.fsl.shared.BaseDbProvider;
import com.fossil.wearables.fsl.shared.UpgradeCommand;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.buddychallenge.BCChallenge;
import com.portfolio.platform.data.model.buddychallenge.BCHeartbeatStep;
import com.portfolio.platform.data.model.buddychallenge.BCInvitation;
import com.portfolio.platform.data.model.buddychallenge.BCOpponent;
import com.portfolio.platform.data.model.buddychallenge.BCPlayer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class coh extends BaseDbProvider implements cog {
    public coh(Context context, String str) {
        super(context, str);
    }

    protected int getDbVersion() {
        return 1;
    }

    protected Class<?>[] getDbEntities() {
        return new Class[]{BCChallenge.class, BCInvitation.class, BCOpponent.class, BCHeartbeatStep.class, BCPlayer.class};
    }

    protected Map<Integer, UpgradeCommand> getDbUpgrades() {
        return null;
    }

    private Dao<BCPlayer, Integer> adL() throws SQLException {
        return this.databaseHelper.getDao(BCPlayer.class);
    }

    private Dao<BCChallenge, Integer> adM() throws SQLException {
        return this.databaseHelper.getDao(BCChallenge.class);
    }

    private Dao<BCInvitation, Integer> adN() throws SQLException {
        return this.databaseHelper.getDao(BCInvitation.class);
    }

    private Dao<BCOpponent, Integer> adO() throws SQLException {
        return this.databaseHelper.getDao(BCOpponent.class);
    }

    private Dao<BCHeartbeatStep, Integer> adP() throws SQLException {
        return this.databaseHelper.getDao(BCHeartbeatStep.class);
    }

    public BCPlayer adI() {
        try {
            return (BCPlayer) adL().queryBuilder().queryForFirst();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void mo1931b(BCPlayer bCPlayer) {
        if (bCPlayer != null) {
            try {
                adL().createOrUpdate(bCPlayer);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void adJ() {
        try {
            adL().delete((BCPlayer) adL().queryBuilder().queryForFirst());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mo1921a(BCChallenge bCChallenge) {
        if (bCChallenge != null) {
            try {
                adM().createOrUpdate(bCChallenge);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void mo1923a(BCInvitation bCInvitation) {
        if (bCInvitation != null) {
            try {
                adN().createOrUpdate(bCInvitation);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<BCChallenge> adK() {
        List<BCChallenge> arrayList = new ArrayList();
        try {
            arrayList = adM().query(adM().queryBuilder().prepare());
        } catch (Exception e) {
            e.printStackTrace();
            MFLogger.m12671e(this.TAG, "Error when get all challenge " + e);
        }
        return arrayList;
    }

    public BCChallenge ha(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            QueryBuilder queryBuilder = adM().queryBuilder();
            queryBuilder.where().eq("id", str);
            return (BCChallenge) queryBuilder.queryForFirst();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void mo1929b(BCChallenge bCChallenge) {
        if (bCChallenge != null) {
            try {
                adM().delete(bCChallenge);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void mo1930b(BCInvitation bCInvitation) {
        if (bCInvitation != null) {
            try {
                adN().delete(bCInvitation);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void mo1924a(BCOpponent bCOpponent) {
        if (bCOpponent != null) {
            try {
                adO().createOrUpdate(bCOpponent);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public BCOpponent hb(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            QueryBuilder queryBuilder = adO().queryBuilder();
            queryBuilder.where().eq("id", str);
            return (BCOpponent) queryBuilder.queryForFirst();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void mo1922a(BCHeartbeatStep bCHeartbeatStep) {
        if (bCHeartbeatStep != null) {
            try {
                adP().createOrUpdate(bCHeartbeatStep);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public BCHeartbeatStep aH(long j) {
        try {
            List query = adP().queryBuilder().where().between("lastHeartbeatStamp", Long.valueOf(cmq.getStartOfDay(new Date(j)).getTime()), Long.valueOf(j)).query();
            if (!(query == null || query.isEmpty())) {
                return (BCHeartbeatStep) query.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            MFLogger.m12671e(this.TAG, "Error when get all challenge " + e);
        }
        return null;
    }

    public String getDbPath() {
        return this.databaseHelper.getDbPath();
    }
}
