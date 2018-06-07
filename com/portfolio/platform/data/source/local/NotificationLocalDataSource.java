package com.portfolio.platform.data.source.local;

import android.util.SparseArray;
import com.fossil.cnq;
import com.fossil.cop;
import com.fossil.wearables.fsl.appfilter.AppFilter;
import com.fossil.wearables.fsl.appfilter.AppFilterProvider;
import com.fossil.wearables.fsl.contact.Contact;
import com.fossil.wearables.fsl.contact.ContactGroup;
import com.fossil.wearables.fsl.contact.ContactProvider;
import com.fossil.wearables.fsl.contact.EmailAddress;
import com.fossil.wearables.fsl.contact.PhoneNumber;
import com.fossil.wearables.fsl.shared.BaseFeatureModel;
import com.misfit.frameworks.buttonservice.enums.MFDeviceFamily;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.source.NotificationsDataSource;
import com.portfolio.platform.model.PhoneFavoritesContact;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class NotificationLocalDataSource implements NotificationsDataSource {
    private static final String TAG = NotificationLocalDataSource.class.getSimpleName();

    public List<ContactGroup> getAllContactGroups(int i) {
        return cnq.acd().ack().getAllContactGroups(MFDeviceFamily.DEVICE_FAMILY_SAM.getValue());
    }

    public void saveContactGroup(ContactGroup contactGroup) {
        cnq.acd().ack().saveContactGroup(contactGroup);
    }

    public void removeContactGroup(ContactGroup contactGroup) {
        cnq.acd().ack().removeContactGroup(contactGroup);
    }

    public void saveContactGroupList(List<ContactGroup> list) {
        ContactProvider ack = cnq.acd().ack();
        for (ContactGroup saveContactGroup : list) {
            ack.saveContactGroup(saveContactGroup);
        }
    }

    public void removeContactGroupList(List<ContactGroup> list) {
        ContactProvider ack = cnq.acd().ack();
        for (ContactGroup removeContactGroup : list) {
            ack.removeContactGroup(removeContactGroup);
        }
    }

    public void saveContact(Contact contact) {
        cnq.acd().ack().saveContact(contact);
    }

    public void removeContact(Contact contact) {
        cnq.acd().ack().removeContact(contact);
    }

    public void saveListContact(List<Contact> list) {
        ContactProvider ack = cnq.acd().ack();
        for (Contact saveContact : list) {
            ack.saveContact(saveContact);
        }
    }

    public void removeListContact(List<Contact> list) {
        ContactProvider ack = cnq.acd().ack();
        for (Contact removeContact : list) {
            ack.removeContact(removeContact);
        }
    }

    public void savePhoneNumber(PhoneNumber phoneNumber) {
        cnq.acd().ack().savePhoneNumber(phoneNumber);
    }

    public void saveListPhoneNumber(List<PhoneNumber> list) {
        ContactProvider ack = cnq.acd().ack();
        for (PhoneNumber savePhoneNumber : list) {
            ack.savePhoneNumber(savePhoneNumber);
        }
    }

    public void saveEmailAddress(EmailAddress emailAddress) {
        cnq.acd().ack().saveEmailAddress(emailAddress);
    }

    public List<ContactGroup> getContactGroupsMatchingSms(String str, int i) {
        return cnq.acd().ack().getContactGroupsMatchingSms(str, MFDeviceFamily.DEVICE_FAMILY_SAM.getValue());
    }

    public List<ContactGroup> getContactGroupsMatchingIncomingCall(String str, int i) {
        return cnq.acd().ack().getContactGroupsMatchingIncomingCall(str, MFDeviceFamily.DEVICE_FAMILY_SAM.getValue());
    }

    public List<ContactGroup> getContactGroupsMatchingEmail(String str, int i) {
        return cnq.acd().ack().getContactGroupsMatchingEmail(str, MFDeviceFamily.DEVICE_FAMILY_SAM.getValue());
    }

    public void saveAppFilter(AppFilter appFilter) {
        cnq.acd().acm().saveAppFilter(appFilter);
    }

    public void removeAllAppFilters() {
        cnq.acd().acm().removeAllAppFilters();
    }

    public void removeAppFilter(AppFilter appFilter) {
        cnq.acd().acm().removeAppFilter(appFilter);
    }

    public void removeListAppFilter(List<AppFilter> list) {
        AppFilterProvider acm = cnq.acd().acm();
        for (AppFilter removeAppFilter : list) {
            acm.removeAppFilter(removeAppFilter);
        }
    }

    public void saveListAppFilters(List<AppFilter> list) {
        AppFilterProvider acm = cnq.acd().acm();
        for (AppFilter saveAppFilter : list) {
            acm.saveAppFilter(saveAppFilter);
        }
    }

    public List<AppFilter> getAllAppFilters(int i) {
        return cnq.acd().acm().getAllAppFilters(MFDeviceFamily.DEVICE_FAMILY_SAM.getValue());
    }

    public AppFilter getAppFilterByType(String str, int i) {
        return cnq.acd().acm().getAppFilterMatchingType(str, MFDeviceFamily.DEVICE_FAMILY_SAM.getValue());
    }

    public List<AppFilter> getAllAppFilterByHour(int i, int i2) {
        return cnq.acd().acm().getAllAppFiltersWithHour(i, MFDeviceFamily.DEVICE_FAMILY_SAM.getValue());
    }

    public List<AppFilter> getAllAppFilterByVibration(int i) {
        return cnq.acd().acm().getAllAppFilterVibration(MFDeviceFamily.DEVICE_FAMILY_SAM.getValue());
    }

    public SparseArray<List<BaseFeatureModel>> getAllNotificationsByHour(String str) {
        SparseArray<List<BaseFeatureModel>> sparseArray = new SparseArray();
        List<BaseFeatureModel> arrayList = new ArrayList();
        int value = MFDeviceFamily.DEVICE_FAMILY_SAM.getValue();
        Collection allContactGroups = cnq.acd().ack().getAllContactGroups(value);
        Collection allAppFilters = cnq.acd().acm().getAllAppFilters(value);
        if (!(allContactGroups == null || allContactGroups.isEmpty())) {
            arrayList.addAll(allContactGroups);
        }
        if (!(allAppFilters == null || allAppFilters.isEmpty())) {
            arrayList.addAll(allAppFilters);
        }
        for (BaseFeatureModel baseFeatureModel : arrayList) {
            List list = (List) sparseArray.get(baseFeatureModel.getHour());
            if (list == null || list.isEmpty()) {
                list = new ArrayList();
            }
            list.add(baseFeatureModel);
            sparseArray.put(baseFeatureModel.getHour(), list);
        }
        MFLogger.d(TAG, "Inside .getAllNotificationsByHour inLocal, result=" + sparseArray);
        return sparseArray;
    }

    public void clearAllNotificationSetting() {
        cnq.acd().ack().removeAllContactGroups();
        cnq.acd().acm().removeAllAppFilters();
    }

    public void clearAllPhoneFavoritesContacts() {
        cnq.acd().acB().aeJ();
    }

    public void removePhoneFavoritesContact(PhoneFavoritesContact phoneFavoritesContact) {
        cnq.acd().acB().removePhoneFavoritesContact(phoneFavoritesContact.getPhoneNumber());
    }

    public void removePhoneFavoritesContact(String str) {
        cnq.acd().acB().removePhoneFavoritesContact(str);
    }

    public void savePhoneFavoritesContact(PhoneFavoritesContact phoneFavoritesContact) {
        cnq.acd().acB().a(phoneFavoritesContact);
    }

    public void removeRedundantContact() {
    }

    public List<Integer> getLocalContactId() {
        return ((cop) cnq.acd().ack()).getLocalContactId();
    }

    public List<Integer> getContactGroupId(List<Integer> list) {
        return ((cop) cnq.acd().ack()).getContactGroupId(list);
    }

    public void removeLocalRedundantContact(List<Integer> list) {
        ((cop) cnq.acd().ack()).removeLocalRedundantContact(list);
    }

    public void removeLocalRedundantContactGroup(List<Integer> list) {
        ((cop) cnq.acd().ack()).T(list);
    }

    public void removePhoneNumber(List<Integer> list) {
        ((cop) cnq.acd().ack()).removePhoneNumber(list);
    }

    public Contact getContactById(int i) {
        return ((cop) cnq.acd().ack()).getContactById(i);
    }

    public void removePhoneNumberByContactGroupId(int i) {
        ((cop) cnq.acd().ack()).removePhoneNumberByContactGroupId(i);
    }
}
