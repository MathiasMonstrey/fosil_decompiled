package com.fossil;

import android.content.Context;
import com.fossil.wearables.fsl.shared.BaseDbProvider;
import com.fossil.wearables.fsl.shared.UpgradeCommand;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.PinObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class cpg extends BaseDbProvider implements cpf {
    public cpg(Context context, String str) {
        super(context, str);
    }

    protected int getDbVersion() {
        return 1;
    }

    protected Class<?>[] getDbEntities() {
        return new Class[]{PinObject.class};
    }

    protected Map<Integer, UpgradeCommand> getDbUpgrades() {
        return null;
    }

    private Dao<PinObject, Integer> aeL() throws SQLException {
        return this.databaseHelper.getDao(PinObject.class);
    }

    public void mo2004a(PinObject pinObject) {
        if (pinObject != null) {
            try {
                MFLogger.m12670d(this.TAG, "Pin new object - uuid=" + pinObject.getUuid() + ", className=" + pinObject.getClassName() + ", json=" + pinObject.getJsonData());
                aeL().createOrUpdate(pinObject);
            } catch (Exception e) {
                MFLogger.m12671e(this.TAG, "Error inside " + this.TAG + ".pin - e=" + e);
            }
        }
    }

    public void mo2005b(PinObject pinObject) {
        if (pinObject != null) {
            try {
                MFLogger.m12670d(this.TAG, "Unpin new object - uuid=" + pinObject.getUuid() + ", className=" + pinObject.getClassName());
                aeL().delete(pinObject);
            } catch (Exception e) {
                MFLogger.m12671e(this.TAG, "Error inside " + this.TAG + ".unpin - e=" + e);
            }
        }
    }

    public List<PinObject> hu(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            QueryBuilder queryBuilder = aeL().queryBuilder();
            Where where = queryBuilder.where();
            where.eq(PinObject.COLUMN_CLASS_NAME, str);
            queryBuilder.setWhere(where);
            List<PinObject> query = aeL().query(queryBuilder.prepare());
            if (query != null && query.size() > 0) {
                return query;
            }
        } catch (Exception e) {
            MFLogger.m12671e(this.TAG, "Error inside " + this.TAG + ".find - e=" + e);
        }
        return arrayList;
    }

    public String getDbPath() {
        return this.databaseHelper.getDbPath();
    }
}
