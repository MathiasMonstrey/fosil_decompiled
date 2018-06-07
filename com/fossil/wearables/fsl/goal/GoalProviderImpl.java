package com.fossil.wearables.fsl.goal;

import android.content.Context;
import com.fossil.wearables.fsl.goaltracking.GoalPhase;
import com.fossil.wearables.fsl.shared.BaseDbProvider;
import com.fossil.wearables.fsl.shared.UpgradeCommand;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoalProviderImpl extends BaseDbProvider implements GoalProvider {
    public static final String DB_NAME = "goal.db";

    class C41821 extends HashMap<Integer, UpgradeCommand> {
        C41821() {
        }
    }

    protected int getDbVersion() {
        return 1;
    }

    protected Class<?>[] getDbEntities() {
        return new Class[]{Goal.class, GoalInterval.class};
    }

    protected Map<Integer, UpgradeCommand> getDbUpgrades() {
        return new C41821();
    }

    private Dao<Goal, Integer> getGoalDao() throws SQLException {
        return this.databaseHelper.getDao(Goal.class);
    }

    private Dao<GoalInterval, Integer> getGoalIntervalDao() throws SQLException {
        return this.databaseHelper.getDao(GoalInterval.class);
    }

    public GoalProviderImpl(Context context, String str) {
        super(context, str);
    }

    public void saveGoal(Goal goal) {
        if (goal != null) {
            try {
                Goal goal2 = (Goal) getGoalDao().queryForSameId(goal);
                if (goal2 != null) {
                    goal.setDbRowId(goal2.getDbRowId());
                }
                getGoalDao().createOrUpdate(goal);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public String getDbPath() {
        return this.databaseHelper.getDbPath();
    }

    public void removeGoal(Goal goal) {
        if (goal != null) {
            try {
                for (GoalInterval removeGoalInterval : goal.getIntervals()) {
                    removeGoalInterval(removeGoalInterval);
                }
                getGoalDao().delete((Object) goal);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Goal getGoal(int i) {
        try {
            return (Goal) getGoalDao().queryForId(Integer.valueOf(i));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Goal> getAllGoals() {
        List<Goal> arrayList = new ArrayList();
        try {
            arrayList = getGoalDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public List<Goal> getAllGoals(long j) {
        List<Goal> arrayList = new ArrayList();
        try {
            QueryBuilder queryBuilder = getGoalDao().queryBuilder();
            queryBuilder.where().le(GoalPhase.COLUMN_START_DATE, Long.valueOf(j)).and().ge(GoalPhase.COLUMN_END_DATE, Long.valueOf(j));
            arrayList = getGoalDao().query(queryBuilder.prepare());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public void saveGoalInterval(GoalInterval goalInterval) {
        if (goalInterval != null) {
            try {
                GoalInterval goalInterval2 = (GoalInterval) getGoalIntervalDao().queryForSameId(goalInterval);
                if (goalInterval2 != null) {
                    goalInterval.setDbRowId(goalInterval2.getDbRowId());
                }
                getGoalIntervalDao().createOrUpdate(goalInterval);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void removeGoalInterval(GoalInterval goalInterval) {
        try {
            getGoalIntervalDao().delete((Object) goalInterval);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
