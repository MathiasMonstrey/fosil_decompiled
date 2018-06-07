package com.portfolio.platform.data.source;

import android.database.Cursor;
import android.provider.ContactsContract.Data;
import android.util.Log;
import android.util.SparseArray;
import com.fossil.emj;
import com.fossil.wearables.fsl.appfilter.AppFilter;
import com.fossil.wearables.fsl.contact.Contact;
import com.fossil.wearables.fsl.contact.ContactGroup;
import com.fossil.wearables.fsl.contact.EmailAddress;
import com.fossil.wearables.fsl.contact.PhoneNumber;
import com.fossil.wearables.fsl.shared.BaseFeatureModel;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.source.scope.Local;
import com.portfolio.platform.data.source.scope.Remote;
import com.portfolio.platform.model.PhoneFavoritesContact;
import java.util.ArrayList;
import java.util.List;

public class NotificationsRepository implements NotificationsDataSource {
    private static final String TAG = NotificationsRepository.class.getSimpleName();
    private SparseArray<List<BaseFeatureModel>> mCachedNotificationsData;
    private boolean mCachedNotificationsDirty;
    private final NotificationsDataSource mNotificationLocalDataSource;
    private final NotificationsDataSource mNotificationRemoteDataSource;
    private List<NotificationRepositoryObserver> mObservers = new ArrayList();

    public interface NotificationRepositoryObserver {
        void onNotificationsDataChanged();
    }

    public NotificationsRepository(@Remote NotificationsDataSource notificationsDataSource, @Local NotificationsDataSource notificationsDataSource2) {
        this.mNotificationLocalDataSource = (NotificationsDataSource) emj.f(notificationsDataSource2, "mNotificationLocalDataSource cannot be null!");
        this.mNotificationRemoteDataSource = (NotificationsDataSource) emj.f(notificationsDataSource, "mNotificationRemoteDataSource cannot be null!");
    }

    public void addContentObserver(NotificationRepositoryObserver notificationRepositoryObserver) {
        if (!this.mObservers.contains(notificationRepositoryObserver)) {
            this.mObservers.add(notificationRepositoryObserver);
        }
    }

    public void removeContentObserver(NotificationRepositoryObserver notificationRepositoryObserver) {
        if (this.mObservers.contains(notificationRepositoryObserver)) {
            this.mObservers.remove(notificationRepositoryObserver);
        }
    }

    private void notifyNotificationsChanged() {
        MFLogger.d(TAG, "Inside .notifyNotificationsChanged observerList=" + this.mObservers);
        for (NotificationRepositoryObserver onNotificationsDataChanged : this.mObservers) {
            onNotificationsDataChanged.onNotificationsDataChanged();
        }
    }

    public boolean isCacheNotificationsAvailable() {
        return (this.mCachedNotificationsData == null || this.mCachedNotificationsDirty) ? false : true;
    }

    public SparseArray<List<BaseFeatureModel>> getCachedNotifications() {
        return this.mCachedNotificationsData;
    }

    private void processNotificationsList(SparseArray<List<BaseFeatureModel>> sparseArray) {
        MFLogger.d(TAG, "Inside .processNotificationsList notificationsList = " + sparseArray);
        if (sparseArray != null) {
            if (this.mCachedNotificationsData == null) {
                this.mCachedNotificationsData = new SparseArray();
            }
            this.mCachedNotificationsData.clear();
            int i = 1;
            while (i <= 12) {
                if (!(sparseArray.get(i) == null || ((List) sparseArray.get(i)).isEmpty())) {
                    this.mCachedNotificationsData.put(i, sparseArray.get(i));
                }
                i++;
            }
            MFLogger.d(TAG, "Inside .processNotificationsList add list notification to cache = " + sparseArray);
            this.mCachedNotificationsDirty = false;
        }
    }

    public List<ContactGroup> getAllContactGroups(int i) {
        return this.mNotificationLocalDataSource.getAllContactGroups(i);
    }

    public void saveContactGroup(ContactGroup contactGroup) {
        MFLogger.d(TAG, "Inside .saveContactGroup contactGroup=" + contactGroup);
        this.mNotificationLocalDataSource.saveContactGroup(contactGroup);
        this.mCachedNotificationsDirty = true;
        notifyNotificationsChanged();
    }

    public void removeContactGroup(ContactGroup contactGroup) {
        MFLogger.d(TAG, "Inside .saveContactGroup removeContactGroup=" + contactGroup);
        this.mNotificationLocalDataSource.removeContactGroup(contactGroup);
        this.mCachedNotificationsDirty = true;
        notifyNotificationsChanged();
    }

    public void saveContactGroupList(List<ContactGroup> list) {
        this.mNotificationLocalDataSource.saveContactGroupList(list);
        this.mCachedNotificationsDirty = true;
        notifyNotificationsChanged();
    }

    public void removeContactGroupList(List<ContactGroup> list) {
        this.mNotificationLocalDataSource.removeContactGroupList(list);
        this.mCachedNotificationsDirty = true;
        notifyNotificationsChanged();
    }

    public void saveContact(Contact contact) {
        MFLogger.d(TAG, "Inside .saveContactGroup saveContact=" + contact);
        Log.d(TAG, "Contact Id = " + contact.getContactId());
        Log.d(TAG, "Contact name = " + contact.getFirstName());
        Log.d(TAG, "Contact db row = " + contact.getDbRowId());
        Log.d(TAG, "-----------------------------------------");
        this.mNotificationLocalDataSource.saveContact(contact);
        this.mCachedNotificationsDirty = true;
        notifyNotificationsChanged();
    }

    public void removeContact(Contact contact) {
        MFLogger.d(TAG, "Inside .removeContact contact=" + contact);
        this.mNotificationLocalDataSource.removeContact(contact);
        this.mCachedNotificationsDirty = true;
        notifyNotificationsChanged();
    }

    public void saveListContact(List<Contact> list) {
        this.mNotificationLocalDataSource.saveListContact(list);
        this.mCachedNotificationsDirty = true;
        notifyNotificationsChanged();
    }

    public void removeListContact(List<Contact> list) {
        this.mNotificationLocalDataSource.removeListContact(list);
        this.mCachedNotificationsDirty = true;
        notifyNotificationsChanged();
    }

    public void savePhoneNumber(PhoneNumber phoneNumber) {
        MFLogger.d(TAG, "Inside .savePhoneNumber phoneNumber=" + phoneNumber);
        this.mNotificationLocalDataSource.savePhoneNumber(phoneNumber);
    }

    public void saveListPhoneNumber(List<PhoneNumber> list) {
        this.mNotificationLocalDataSource.saveListPhoneNumber(list);
    }

    public void saveEmailAddress(EmailAddress emailAddress) {
        MFLogger.d(TAG, "Inside .saveEmailAddress emailAddress=" + emailAddress);
        this.mNotificationLocalDataSource.saveEmailAddress(emailAddress);
    }

    public List<ContactGroup> getContactGroupsMatchingSms(String str, int i) {
        return this.mNotificationLocalDataSource.getContactGroupsMatchingSms(str, i);
    }

    public List<ContactGroup> getContactGroupsMatchingIncomingCall(String str, int i) {
        return this.mNotificationLocalDataSource.getContactGroupsMatchingIncomingCall(str, i);
    }

    public List<ContactGroup> getContactGroupsMatchingEmail(String str, int i) {
        return this.mNotificationLocalDataSource.getContactGroupsMatchingEmail(str, i);
    }

    public void saveAppFilter(AppFilter appFilter) {
        MFLogger.d(TAG, "Inside .saveAppFilter appFilter=" + appFilter);
        this.mNotificationLocalDataSource.saveAppFilter(appFilter);
        this.mCachedNotificationsDirty = true;
        notifyNotificationsChanged();
    }

    public void removeAllAppFilters() {
        MFLogger.d(TAG, "Inside .removeAllAppFilters");
        this.mNotificationLocalDataSource.removeAllAppFilters();
        this.mCachedNotificationsDirty = true;
        notifyNotificationsChanged();
    }

    public void removeAppFilter(AppFilter appFilter) {
        MFLogger.d(TAG, "Inside .removeListAppFilter appFilter=" + appFilter);
        this.mNotificationLocalDataSource.removeAppFilter(appFilter);
        this.mCachedNotificationsDirty = true;
        notifyNotificationsChanged();
    }

    public void removeListAppFilter(List<AppFilter> list) {
        this.mNotificationLocalDataSource.removeListAppFilter(list);
        this.mCachedNotificationsDirty = true;
        notifyNotificationsChanged();
    }

    public void saveListAppFilters(List<AppFilter> list) {
        this.mNotificationLocalDataSource.saveListAppFilters(list);
        this.mCachedNotificationsDirty = true;
        notifyNotificationsChanged();
    }

    public List<AppFilter> getAllAppFilters(int i) {
        return this.mNotificationLocalDataSource.getAllAppFilters(i);
    }

    public AppFilter getAppFilterByType(String str, int i) {
        return this.mNotificationLocalDataSource.getAppFilterByType(str, i);
    }

    public List<AppFilter> getAllAppFilterByHour(int i, int i2) {
        return this.mNotificationLocalDataSource.getAllAppFilterByHour(i, i2);
    }

    public List<AppFilter> getAllAppFilterByVibration(int i) {
        return this.mNotificationLocalDataSource.getAllAppFilterByVibration(i);
    }

    public SparseArray<List<BaseFeatureModel>> getAllNotificationsByHour(String str) {
        SparseArray sparseArray = new SparseArray();
        MFLogger.d(TAG, "Inside .getAllNotificationsByHour isCachedAvailable=" + isCacheNotificationsAvailable());
        if (isCacheNotificationsAvailable()) {
            if (this.mCachedNotificationsData != null) {
                MFLogger.d(TAG, "Inside .getAllNotificationsByHour cachedNotifications=" + getCachedNotifications());
                return getCachedNotifications();
            }
            sparseArray = this.mNotificationLocalDataSource.getAllNotificationsByHour(str);
            MFLogger.d(TAG, "Inside .getAllNotificationsByHour getFromLocalDataSource=" + sparseArray);
        }
        if (sparseArray != null && sparseArray.size() == 0) {
            sparseArray = this.mNotificationLocalDataSource.getAllNotificationsByHour(str);
        }
        processNotificationsList(sparseArray);
        return getCachedNotifications();
    }

    public void clearAllNotificationSetting() {
        this.mNotificationLocalDataSource.clearAllNotificationSetting();
        if (this.mCachedNotificationsData != null) {
            this.mCachedNotificationsData.clear();
        }
        this.mCachedNotificationsDirty = true;
    }

    public void clearAllPhoneFavoritesContacts() {
        this.mNotificationLocalDataSource.clearAllPhoneFavoritesContacts();
    }

    public void removePhoneFavoritesContact(String str) {
        this.mNotificationLocalDataSource.removePhoneFavoritesContact(str);
    }

    public void removePhoneFavoritesContact(PhoneFavoritesContact phoneFavoritesContact) {
        this.mNotificationLocalDataSource.removePhoneFavoritesContact(phoneFavoritesContact);
    }

    public void savePhoneFavoritesContact(PhoneFavoritesContact phoneFavoritesContact) {
        this.mNotificationLocalDataSource.savePhoneFavoritesContact(phoneFavoritesContact);
    }

    public void removeRedundantContact() {
        MFLogger.d(TAG, ".Inside removeRedundantContact");
        List queryContactOnPhone = queryContactOnPhone(getLocalContactId());
        List contactGroupId = getContactGroupId(queryContactOnPhone);
        removeLocalRedundantContact(queryContactOnPhone);
        removeLocalRedundantContactGroup(contactGroupId);
        removePhoneNumber(contactGroupId);
        this.mCachedNotificationsDirty = true;
        notifyNotificationsChanged();
    }

    public List<Integer> getLocalContactId() {
        return this.mNotificationLocalDataSource.getLocalContactId();
    }

    private List<Integer> queryContactOnPhone(List<Integer> list) {
        String str = "contact_id IN " + transformInCondition(list);
        MFLogger.d(TAG, ".Inside step 2 - query contact on phone IN condition, selection = " + str);
        Cursor query = PortfolioApp.ZQ().getContentResolver().query(Data.CONTENT_URI, new String[]{"contact_id"}, str, null, null);
        List<Integer> arrayList = new ArrayList();
        if (query != null) {
            query.moveToFirst();
            while (!query.isAfterLast()) {
                int i = query.getInt(0);
                MFLogger.d(TAG, ".Inside step 2 - query contact on phone IN condition, contactId=" + i);
                arrayList.add(Integer.valueOf(i));
                query.moveToNext();
            }
            query.close();
        }
        for (Integer intValue : list) {
            switch (intValue.intValue()) {
                case -200:
                    arrayList.add(Integer.valueOf(-200));
                    MFLogger.d(TAG, ".Inside step 2 - manually added ALL_TEXT_ID=-200");
                    break;
                case -100:
                    arrayList.add(Integer.valueOf(-100));
                    MFLogger.d(TAG, ".Inside step 2 - manually added ALL_CALL_ID=-100");
                    break;
                default:
                    break;
            }
        }
        return arrayList;
    }

    public List<Integer> getContactGroupId(List<Integer> list) {
        return this.mNotificationLocalDataSource.getContactGroupId(list);
    }

    public void removeLocalRedundantContact(List<Integer> list) {
        this.mNotificationLocalDataSource.removeLocalRedundantContact(list);
    }

    public void removeLocalRedundantContactGroup(List<Integer> list) {
        this.mNotificationLocalDataSource.removeLocalRedundantContactGroup(list);
    }

    public void removePhoneNumber(List<Integer> list) {
        this.mNotificationLocalDataSource.removePhoneNumber(list);
    }

    public Contact getContactById(int i) {
        return this.mNotificationLocalDataSource.getContactById(i);
    }

    public void removePhoneNumberByContactGroupId(int i) {
        this.mNotificationLocalDataSource.removePhoneNumberByContactGroupId(i);
    }

    private StringBuilder transformInCondition(List<Integer> list) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        for (Integer intValue : list) {
            int intValue2 = intValue.intValue();
            if (stringBuilder.length() > 1) {
                stringBuilder.append(",");
            }
            stringBuilder.append(intValue2);
        }
        stringBuilder.append(")");
        return stringBuilder;
    }
}
