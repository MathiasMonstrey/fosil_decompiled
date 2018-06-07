package com.fossil;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.fossil.wearables.fsl.shared.BaseDbProvider;
import com.fossil.wearables.fsl.shared.UpgradeCommand;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.model.PhoneFavoritesContact;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class cpe extends BaseDbProvider implements cpd {
    private static final String TAG = cpe.class.getSimpleName();

    class C22761 implements UpgradeCommand {
        final /* synthetic */ cpe cBx;

        C22761(cpe com_fossil_cpe) {
            this.cBx = com_fossil_cpe;
        }

        public void execute(SQLiteDatabase sQLiteDatabase) {
            MFLogger.m12670d(cpe.TAG, " ---- UPGRADE DB phone_favorites_contact, rename table uappsystemversion to PhoneFavoritesContact");
            sQLiteDatabase.execSQL("ALTER TABLE uappsystemversion RENAME TO PhoneFavoritesContact");
            MFLogger.m12670d(cpe.TAG, " ---- UPGRADE DB phone_favorites_contact, rename table uappsystemversion to PhoneFavoritesContact SUCCESS");
        }
    }

    public cpe(Context context, String str) {
        super(context, str);
    }

    protected int getDbVersion() {
        return 2;
    }

    protected Class<?>[] getDbEntities() {
        return new Class[]{PhoneFavoritesContact.class};
    }

    protected Map<Integer, UpgradeCommand> getDbUpgrades() {
        Map<Integer, UpgradeCommand> hashMap = new HashMap();
        hashMap.put(Integer.valueOf(2), new C22761(this));
        return hashMap;
    }

    private Dao<PhoneFavoritesContact, Integer> aeK() throws SQLException {
        return this.databaseHelper.getDao(PhoneFavoritesContact.class);
    }

    public String getDbPath() {
        return this.databaseHelper.getDbPath();
    }

    public void mo2000a(PhoneFavoritesContact phoneFavoritesContact) {
        if (phoneFavoritesContact != null) {
            try {
                aeK().createOrUpdate(phoneFavoritesContact);
                MFLogger.m12670d(TAG, "addOrUpdatePhoneFavoritesContact - number= " + phoneFavoritesContact.getPhoneNumber());
                return;
            } catch (Exception e) {
                e.printStackTrace();
                MFLogger.m12671e(TAG, "addOrUpdatePhoneFavoritesContact - e= " + e);
                return;
            }
        }
        MFLogger.m12671e(TAG, "addOrUpdatePhoneFavoritesContact - contact=NULL!!!");
    }

    public void removePhoneFavoritesContact(String str) {
        MFLogger.m12670d(TAG, "removePhoneFavoritesContact - number=" + str);
        try {
            DeleteBuilder deleteBuilder = aeK().deleteBuilder();
            deleteBuilder.where().eq(PhoneFavoritesContact.COLUMN_PHONE_NUMBER, str);
            deleteBuilder.delete();
        } catch (Exception e) {
            e.printStackTrace();
            MFLogger.m12671e(TAG, "removePhoneFavoritesContact - e=" + e);
        }
    }

    public boolean ht(String str) {
        MFLogger.m12670d(TAG, "checkPhoneFavoritesContact - number=" + str);
        try {
            QueryBuilder queryBuilder = aeK().queryBuilder();
            queryBuilder.where().eq(PhoneFavoritesContact.COLUMN_PHONE_NUMBER, str);
            if (queryBuilder.query().size() > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            MFLogger.m12671e(TAG, "checkPhoneFavoritesContact - e=" + e);
            return false;
        }
    }

    public void aeJ() {
        MFLogger.m12670d(TAG, "removeAllPhoneFavoritesContacts");
        try {
            aeK().deleteBuilder().delete();
        } catch (SQLException e) {
            e.printStackTrace();
            MFLogger.m12671e(TAG, "removeAllPhoneFavoritesContacts - e=" + e);
        }
    }
}
