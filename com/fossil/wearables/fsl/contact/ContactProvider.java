package com.fossil.wearables.fsl.contact;

import com.fossil.wearables.fsl.BaseProvider;
import java.util.List;

public interface ContactProvider extends BaseProvider {
    void clearAllTables();

    List<ContactGroup> getAllContactGroups();

    List<ContactGroup> getAllContactGroups(int i);

    Contact getContact(int i);

    ContactGroup getContactGroup(int i);

    List<ContactGroup> getContactGroupsMatchingEmail(String str);

    List<ContactGroup> getContactGroupsMatchingEmail(String str, int i);

    List<ContactGroup> getContactGroupsMatchingIncomingCall(String str);

    List<ContactGroup> getContactGroupsMatchingIncomingCall(String str, int i);

    List<ContactGroup> getContactGroupsMatchingSms(String str);

    List<ContactGroup> getContactGroupsMatchingSms(String str, int i);

    void removeAllContactGroups();

    void removeContact(Contact contact);

    void removeContactGroup(ContactGroup contactGroup);

    void removeEmailAddress(EmailAddress emailAddress);

    void removePhoneNumber(PhoneNumber phoneNumber);

    void saveContact(Contact contact);

    void saveContactGroup(ContactGroup contactGroup);

    void saveEmailAddress(EmailAddress emailAddress);

    void savePhoneNumber(PhoneNumber phoneNumber);

    void syncContacts();
}
