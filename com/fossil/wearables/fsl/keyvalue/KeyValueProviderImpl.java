package com.fossil.wearables.fsl.keyvalue;

import android.content.Context;
import com.fossil.wearables.fsl.shared.BaseDbProvider;
import com.fossil.wearables.fsl.shared.UpgradeCommand;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.misfit.frameworks.buttonservice.db.DataFile;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class KeyValueProviderImpl extends BaseDbProvider implements KeyValueProvider {
    public static final String DB_NAME = "keyvalue.db";

    public KeyValueProviderImpl(Context context, String str) {
        super(context, str);
    }

    protected int getDbVersion() {
        return 1;
    }

    protected Class<?>[] getDbEntities() {
        return new Class[]{KeyValue.class};
    }

    protected Map<Integer, UpgradeCommand> getDbUpgrades() {
        return null;
    }

    private Dao<KeyValue, Integer> getKeyValueDao() throws SQLException {
        return this.databaseHelper.getDao(KeyValue.class);
    }

    public void saveKeyValue(KeyValue keyValue) {
        if (keyValue != null) {
            try {
                QueryBuilder queryBuilder = getKeyValueDao().queryBuilder();
                queryBuilder.where().eq(DataFile.COLUMN_KEY, keyValue.getKey());
                List query = getKeyValueDao().query(queryBuilder.prepare());
                if (query != null && query.size() > 0) {
                    KeyValue keyValue2 = (KeyValue) query.get(0);
                    if (keyValue2 != null) {
                        keyValue.setDbRowId(keyValue2.getDbRowId());
                    }
                }
                getKeyValueDao().createOrUpdate(keyValue);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void removeAllKeyValues() {
        for (KeyValue removeKeyValue : getAllKeyValues()) {
            removeKeyValue(removeKeyValue);
        }
    }

    public List<KeyValue> getAllKeyValues() {
        List<KeyValue> arrayList = new ArrayList();
        try {
            arrayList = getKeyValueDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public KeyValue getKeyValueById(int i) {
        try {
            return (KeyValue) getKeyValueDao().queryForId(Integer.valueOf(i));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getValueByKey(String str) {
        try {
            QueryBuilder queryBuilder = getKeyValueDao().queryBuilder();
            queryBuilder.where().eq(DataFile.COLUMN_KEY, str);
            List query = getKeyValueDao().query(queryBuilder.prepare());
            if (query != null && query.size() > 0) {
                KeyValue keyValue = (KeyValue) query.get(0);
                if (keyValue != null) {
                    return keyValue.getValue();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void removeKeyValue(KeyValue keyValue) {
        if (keyValue != null) {
            try {
                getKeyValueDao().delete((Object) keyValue);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
