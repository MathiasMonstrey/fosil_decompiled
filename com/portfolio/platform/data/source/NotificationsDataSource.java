package com.portfolio.platform.data.source;

import android.util.SparseArray;
import com.fossil.wearables.fsl.appfilter.AppFilter;
import com.fossil.wearables.fsl.contact.Contact;
import com.fossil.wearables.fsl.contact.ContactGroup;
import com.fossil.wearables.fsl.contact.EmailAddress;
import com.fossil.wearables.fsl.contact.PhoneNumber;
import com.fossil.wearables.fsl.shared.BaseFeatureModel;
import com.portfolio.platform.model.PhoneFavoritesContact;
import java.util.List;

public interface NotificationsDataSource {
    void clearAllNotificationSetting();

    void clearAllPhoneFavoritesContacts();

    List<AppFilter> getAllAppFilterByHour(int i, int i2);

    List<AppFilter> getAllAppFilterByVibration(int i);

    List<AppFilter> getAllAppFilters(int i);

    List<ContactGroup> getAllContactGroups(int i);

    SparseArray<List<BaseFeatureModel>> getAllNotificationsByHour(String str);

    AppFilter getAppFilterByType(String str, int i);

    Contact getContactById(int i);

    List<Integer> getContactGroupId(List<Integer> list);

    List<ContactGroup> getContactGroupsMatchingEmail(String str, int i);

    List<ContactGroup> getContactGroupsMatchingIncomingCall(String str, int i);

    List<ContactGroup> getContactGroupsMatchingSms(String str, int i);

    List<Integer> getLocalContactId();

    void removeAllAppFilters();

    void removeAppFilter(AppFilter appFilter);

    void removeContact(Contact contact);

    void removeContactGroup(ContactGroup contactGroup);

    void removeContactGroupList(List<ContactGroup> list);

    void removeListAppFilter(List<AppFilter> list);

    void removeListContact(List<Contact> list);

    void removeLocalRedundantContact(List<Integer> list);

    void removeLocalRedundantContactGroup(List<Integer> list);

    void removePhoneFavoritesContact(PhoneFavoritesContact phoneFavoritesContact);

    void removePhoneFavoritesContact(String str);

    void removePhoneNumber(List<Integer> list);

    void removePhoneNumberByContactGroupId(int i);

    void removeRedundantContact();

    void saveAppFilter(AppFilter appFilter);

    void saveContact(Contact contact);

    void saveContactGroup(ContactGroup contactGroup);

    void saveContactGroupList(List<ContactGroup> list);

    void saveEmailAddress(EmailAddress emailAddress);

    void saveListAppFilters(List<AppFilter> list);

    void saveListContact(List<Contact> list);

    void saveListPhoneNumber(List<PhoneNumber> list);

    void savePhoneFavoritesContact(PhoneFavoritesContact phoneFavoritesContact);

    void savePhoneNumber(PhoneNumber phoneNumber);
}
