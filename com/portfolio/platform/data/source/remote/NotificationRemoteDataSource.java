package com.portfolio.platform.data.source.remote;

import android.util.SparseArray;
import com.fossil.wearables.fsl.appfilter.AppFilter;
import com.fossil.wearables.fsl.contact.Contact;
import com.fossil.wearables.fsl.contact.ContactGroup;
import com.fossil.wearables.fsl.contact.EmailAddress;
import com.fossil.wearables.fsl.contact.PhoneNumber;
import com.fossil.wearables.fsl.shared.BaseFeatureModel;
import com.portfolio.platform.data.source.NotificationsDataSource;
import com.portfolio.platform.model.PhoneFavoritesContact;
import java.util.List;

public class NotificationRemoteDataSource implements NotificationsDataSource {
    public List<ContactGroup> getAllContactGroups(int i) {
        return null;
    }

    public void saveContactGroup(ContactGroup contactGroup) {
    }

    public void removeContactGroup(ContactGroup contactGroup) {
    }

    public void saveContactGroupList(List<ContactGroup> list) {
    }

    public void removeContactGroupList(List<ContactGroup> list) {
    }

    public void saveContact(Contact contact) {
    }

    public void removeContact(Contact contact) {
    }

    public void saveListContact(List<Contact> list) {
    }

    public void removeListContact(List<Contact> list) {
    }

    public void savePhoneNumber(PhoneNumber phoneNumber) {
    }

    public void saveListPhoneNumber(List<PhoneNumber> list) {
    }

    public void saveEmailAddress(EmailAddress emailAddress) {
    }

    public List<ContactGroup> getContactGroupsMatchingSms(String str, int i) {
        return null;
    }

    public List<ContactGroup> getContactGroupsMatchingIncomingCall(String str, int i) {
        return null;
    }

    public List<ContactGroup> getContactGroupsMatchingEmail(String str, int i) {
        return null;
    }

    public void saveAppFilter(AppFilter appFilter) {
    }

    public void removeAllAppFilters() {
    }

    public void removeAppFilter(AppFilter appFilter) {
    }

    public void removeListAppFilter(List<AppFilter> list) {
    }

    public void saveListAppFilters(List<AppFilter> list) {
    }

    public List<AppFilter> getAllAppFilters(int i) {
        return null;
    }

    public AppFilter getAppFilterByType(String str, int i) {
        return null;
    }

    public List<AppFilter> getAllAppFilterByHour(int i, int i2) {
        return null;
    }

    public List<AppFilter> getAllAppFilterByVibration(int i) {
        return null;
    }

    public SparseArray<List<BaseFeatureModel>> getAllNotificationsByHour(String str) {
        return null;
    }

    public void clearAllNotificationSetting() {
    }

    public void removeRedundantContact() {
    }

    public List<Integer> getLocalContactId() {
        return null;
    }

    public List<Integer> getContactGroupId(List<Integer> list) {
        return null;
    }

    public void removeLocalRedundantContact(List<Integer> list) {
    }

    public void removeLocalRedundantContactGroup(List<Integer> list) {
    }

    public void removePhoneNumber(List<Integer> list) {
    }

    public Contact getContactById(int i) {
        return null;
    }

    public void removePhoneNumberByContactGroupId(int i) {
    }

    public void clearAllPhoneFavoritesContacts() {
    }

    public void removePhoneFavoritesContact(PhoneFavoritesContact phoneFavoritesContact) {
    }

    public void removePhoneFavoritesContact(String str) {
    }

    public void savePhoneFavoritesContact(PhoneFavoritesContact phoneFavoritesContact) {
    }
}
