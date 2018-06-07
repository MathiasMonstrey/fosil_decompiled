package com.fossil;

import android.content.Context;
import android.util.Log;
import com.fossil.wearables.fsl.appfilter.AppFilter;
import com.fossil.wearables.fsl.contact.Contact;
import com.fossil.wearables.fsl.contact.ContactGroup;
import com.fossil.wearables.fsl.shared.BaseDbProvider;
import com.fossil.wearables.fsl.shared.UpgradeCommand;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.misfit.frameworks.buttonservice.enums.MFDeviceFamily;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.helper.DeviceHelper;
import com.portfolio.platform.provider.HourNotificationProviderImp.1;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class cou extends BaseDbProvider implements cot {
    private static final String TAG = cou.class.getSimpleName();

    public cou(Context context, String str) {
        super(context, str);
    }

    protected int getDbVersion() {
        return 2;
    }

    protected Class<?>[] getDbEntities() {
        return new Class[]{cos.class};
    }

    protected Map<Integer, UpgradeCommand> getDbUpgrades() {
        return new 1(this);
    }

    private List<cos> m7405U(List<cos> list) {
        List<cos> arrayList = new ArrayList();
        if (!(list == null || list.isEmpty())) {
            for (MFDeviceFamily mFDeviceFamily : DeviceHelper.cyg) {
                if (mFDeviceFamily != MFDeviceFamily.DEVICE_FAMILY_Q_MOTION) {
                    cos g;
                    List<AppFilter> b = drc.aun().m9456b(mFDeviceFamily);
                    List<ContactGroup> allContactGroups = cnq.acd().ack().getAllContactGroups(mFDeviceFamily.ordinal());
                    if (!(b == null || b.isEmpty())) {
                        for (AppFilter appFilter : b) {
                            g = m7407g(appFilter.getType(), list);
                            if (g != null) {
                                cos com_fossil_cos = new cos(g.getHour(), g.isVibrationOnly(), g.aex(), g.getDeviceFamily());
                                MFLogger.m12670d(TAG, "Migrating 1.10.3 ... Checking deviceFamily=" + mFDeviceFamily.name() + " Found hands setting of app filter=" + appFilter.getType());
                                com_fossil_cos.setDeviceFamily(mFDeviceFamily.name());
                                com_fossil_cos.setId(appFilter.getType() + mFDeviceFamily);
                                arrayList.add(com_fossil_cos);
                            }
                        }
                    }
                    if (!(allContactGroups == null || allContactGroups.isEmpty())) {
                        for (ContactGroup contactGroup : allContactGroups) {
                            if (!(contactGroup.getContacts() == null || contactGroup.getContacts().isEmpty())) {
                                g = m7407g(String.valueOf(((Contact) contactGroup.getContacts().get(0)).getContactId()), list);
                                if (g != null) {
                                    MFLogger.m12670d(TAG, "Migrating 1.10.3 ... Checking deviceFamily=" + mFDeviceFamily.name() + "Found hands setting of contactId=" + ((Contact) contactGroup.getContacts().get(0)).getContactId());
                                    cos com_fossil_cos2 = new cos(g.getHour(), g.isVibrationOnly(), g.aex(), g.getDeviceFamily());
                                    com_fossil_cos2.setDeviceFamily(mFDeviceFamily.name());
                                    com_fossil_cos2.setId(((Contact) contactGroup.getContacts().get(0)).getContactId() + mFDeviceFamily.name());
                                    arrayList.add(com_fossil_cos2);
                                }
                            }
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private cos m7407g(String str, List<cos> list) {
        for (cos com_fossil_cos : list) {
            if (com_fossil_cos.aex().equalsIgnoreCase(str)) {
                return com_fossil_cos;
            }
        }
        return null;
    }

    private Dao<cos, Integer> aey() throws SQLException {
        return this.databaseHelper.getDao(cos.class);
    }

    public cos aA(String str, String str2) {
        try {
            QueryBuilder queryBuilder = aey().queryBuilder();
            queryBuilder.where().eq("extraId", str).and().eq("deviceFamily", str2);
            cos com_fossil_cos = (cos) queryBuilder.queryForFirst();
            if (com_fossil_cos == null) {
                return new cos(1, false, str, DeviceHelper.getDeviceFamily(PortfolioApp.ZQ().aaa()).name());
            }
            return com_fossil_cos;
        } catch (Exception e) {
            Log.e(TAG, "Error inside " + TAG + ".getHourNotificationByExtraId - e=" + e);
            return hq(str);
        }
    }

    public cos hq(String str) {
        MFLogger.m12670d(TAG, "getHourNotificationByExtraIdOnly() id = " + str);
        try {
            QueryBuilder queryBuilder = aey().queryBuilder();
            queryBuilder.where().eq("extraId", str);
            cos com_fossil_cos = (cos) queryBuilder.queryForFirst();
            if (com_fossil_cos != null) {
                return com_fossil_cos;
            }
            MFLogger.m12670d(TAG, "getHourNotificationByExtraIdOnly() - notification is null - return default notification for this action");
            return new cos(1, false, str, DeviceHelper.getDeviceFamily(PortfolioApp.ZQ().aaa()).name());
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "Error inside " + TAG + ".getHourNotificationByExtraIdOnly - e=" + e);
            return new cos(1, false, str, DeviceHelper.getDeviceFamily(PortfolioApp.ZQ().aaa()).name());
        }
    }
}
