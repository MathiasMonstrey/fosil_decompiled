package com.fossil.wearables.fsl.contact;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract.Contacts;
import android.util.Log;
import com.fossil.wearables.fsl.shared.BaseDbProvider;
import com.fossil.wearables.fsl.shared.UpgradeCommand;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.table.TableUtils;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ContactProviderImpl extends BaseDbProvider implements ContactProvider {
    public static final String DB_NAME = "entourage.db";

    protected int getDbVersion() {
        return 5;
    }

    protected Class<?>[] getDbEntities() {
        return new Class[]{Contact.class, ContactGroup.class, EmailAddress.class, PhoneNumber.class};
    }

    public Map<Integer, UpgradeCommand> getDbUpgrades() {
        return null;
    }

    public ContactProviderImpl(Context context, String str) {
        super(context, str);
    }

    protected Dao<ContactGroup, Integer> getContactGroupDao() throws SQLException {
        return this.databaseHelper.getDao(ContactGroup.class);
    }

    protected Dao<Contact, Integer> getContactDao() throws SQLException {
        return this.databaseHelper.getDao(Contact.class);
    }

    protected Dao<PhoneNumber, Integer> getPhoneNumberDao() throws SQLException {
        return this.databaseHelper.getDao(PhoneNumber.class);
    }

    protected Dao<EmailAddress, Integer> getEmailAddressDao() throws SQLException {
        return this.databaseHelper.getDao(EmailAddress.class);
    }

    public String getDbPath() {
        return this.databaseHelper.getDbPath();
    }

    public void saveContactGroup(ContactGroup contactGroup) {
        if (contactGroup != null) {
            try {
                getContactGroupDao().createOrUpdate(contactGroup);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void removeAllContactGroups() {
        for (ContactGroup removeContactGroup : getAllContactGroups()) {
            removeContactGroup(removeContactGroup);
        }
    }

    public ContactGroup getContactGroup(int i) {
        try {
            return (ContactGroup) getContactGroupDao().queryForId(Integer.valueOf(i));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void removeContactGroup(ContactGroup contactGroup) {
        try {
            for (Contact removeContact : contactGroup.getContacts()) {
                removeContact(removeContact);
            }
            getContactGroupDao().delete((Object) contactGroup);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ContactGroup> getAllContactGroups() {
        List<ContactGroup> arrayList = new ArrayList();
        try {
            arrayList = getContactGroupDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public List<ContactGroup> getAllContactGroups(int i) {
        List<ContactGroup> arrayList = new ArrayList();
        try {
            arrayList = getContactGroupDao().queryForEq("deviceFamily", Integer.valueOf(i));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public List<ContactGroup> getContactGroupsMatchingEmail(String str) {
        List<ContactGroup> arrayList = new ArrayList();
        List<ContactGroup> allContactGroups = getAllContactGroups();
        if (allContactGroups != null && allContactGroups.size() > 0) {
            for (ContactGroup contactGroup : allContactGroups) {
                if (contactGroup != null && contactGroup.isEnabled()) {
                    Contact contactWithEmail = contactGroup.getContactWithEmail(str);
                    if (contactWithEmail != null && contactWithEmail.isUseEmail()) {
                        arrayList.add(contactGroup);
                    }
                }
            }
        }
        return arrayList;
    }

    public List<ContactGroup> getContactGroupsMatchingSms(String str) {
        List<ContactGroup> arrayList = new ArrayList();
        List<ContactGroup> allContactGroups = getAllContactGroups();
        if (allContactGroups != null && allContactGroups.size() > 0) {
            for (ContactGroup contactGroup : allContactGroups) {
                if (contactGroup != null && contactGroup.isEnabled()) {
                    Contact contactWithPhoneNumber = contactGroup.getContactWithPhoneNumber(str);
                    if (contactWithPhoneNumber != null && contactWithPhoneNumber.isUseSms()) {
                        arrayList.add(contactGroup);
                    }
                }
            }
        }
        return arrayList;
    }

    public List<ContactGroup> getContactGroupsMatchingIncomingCall(String str) {
        List<ContactGroup> arrayList = new ArrayList();
        List<ContactGroup> allContactGroups = getAllContactGroups();
        if (allContactGroups != null && allContactGroups.size() > 0) {
            for (ContactGroup contactGroup : allContactGroups) {
                if (contactGroup != null && contactGroup.isEnabled()) {
                    Contact contactWithPhoneNumber = contactGroup.getContactWithPhoneNumber(str);
                    if (contactWithPhoneNumber != null && contactWithPhoneNumber.isUseCall()) {
                        arrayList.add(contactGroup);
                    }
                }
            }
        }
        return arrayList;
    }

    public List<ContactGroup> getContactGroupsMatchingEmail(String str, int i) {
        List<ContactGroup> arrayList = new ArrayList();
        List<ContactGroup> allContactGroups = getAllContactGroups(i);
        if (allContactGroups != null && allContactGroups.size() > 0) {
            for (ContactGroup contactGroup : allContactGroups) {
                if (contactGroup != null && contactGroup.isEnabled()) {
                    Contact contactWithEmail = contactGroup.getContactWithEmail(str);
                    if (contactWithEmail != null && contactWithEmail.isUseEmail()) {
                        arrayList.add(contactGroup);
                    }
                }
            }
        }
        return arrayList;
    }

    public List<ContactGroup> getContactGroupsMatchingSms(String str, int i) {
        List<ContactGroup> arrayList = new ArrayList();
        List<ContactGroup> allContactGroups = getAllContactGroups(i);
        if (allContactGroups != null && allContactGroups.size() > 0) {
            for (ContactGroup contactGroup : allContactGroups) {
                if (contactGroup != null && contactGroup.isEnabled()) {
                    Contact contactWithPhoneNumber = contactGroup.getContactWithPhoneNumber(str);
                    if (contactWithPhoneNumber != null && contactWithPhoneNumber.isUseSms()) {
                        arrayList.add(contactGroup);
                    }
                }
            }
        }
        return arrayList;
    }

    public List<ContactGroup> getContactGroupsMatchingIncomingCall(String str, int i) {
        List<ContactGroup> arrayList = new ArrayList();
        List<ContactGroup> allContactGroups = getAllContactGroups(i);
        if (allContactGroups != null && allContactGroups.size() > 0) {
            for (ContactGroup contactGroup : allContactGroups) {
                if (contactGroup != null && contactGroup.isEnabled()) {
                    Contact contactWithPhoneNumber = contactGroup.getContactWithPhoneNumber(str);
                    if (contactWithPhoneNumber != null && contactWithPhoneNumber.isUseCall()) {
                        arrayList.add(contactGroup);
                    }
                }
            }
        }
        return arrayList;
    }

    public void saveContact(Contact contact) {
        if (contact != null) {
            try {
                Contact contact2 = (Contact) getContactDao().queryForSameId(contact);
                if (contact2 != null) {
                    contact.setDbRowId(contact2.getDbRowId());
                }
                getContactDao().createOrUpdate(contact);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Contact getContact(int i) {
        try {
            return (Contact) getContactDao().queryForId(Integer.valueOf(i));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<Contact> getAllContacts() {
        List<Contact> list = null;
        try {
            list = getContactDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void removeContact(Contact contact) {
        if (contact != null) {
            try {
                for (PhoneNumber removePhoneNumber : contact.getPhoneNumbers()) {
                    removePhoneNumber(removePhoneNumber);
                }
                for (EmailAddress removeEmailAddress : contact.getEmailAddresses()) {
                    removeEmailAddress(removeEmailAddress);
                }
                getContactDao().delete((Object) contact);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void savePhoneNumber(PhoneNumber phoneNumber) {
        if (phoneNumber != null && phoneNumber.getContact() != null) {
            try {
                QueryBuilder queryBuilder = getPhoneNumberDao().queryBuilder();
                queryBuilder.where().idEq(Integer.valueOf(phoneNumber.getContact().getContactId()));
                List query = getPhoneNumberDao().query(queryBuilder.prepare());
                if (query != null && query.size() > 0) {
                    PhoneNumber phoneNumber2 = (PhoneNumber) query.get(0);
                    if (phoneNumber2 != null) {
                        phoneNumber.setDbRowId(phoneNumber2.getDbRowId());
                    }
                }
                getPhoneNumberDao().createOrUpdate(phoneNumber);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void removePhoneNumber(PhoneNumber phoneNumber) {
        try {
            getPhoneNumberDao().delete((Object) phoneNumber);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeEmailAddress(EmailAddress emailAddress) {
        try {
            getEmailAddressDao().delete((Object) emailAddress);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveEmailAddress(EmailAddress emailAddress) {
        if (emailAddress != null && emailAddress.getContact() != null) {
            try {
                QueryBuilder queryBuilder = getEmailAddressDao().queryBuilder();
                queryBuilder.where().idEq(Integer.valueOf(emailAddress.getContact().getContactId()));
                List query = getEmailAddressDao().query(queryBuilder.prepare());
                if (query != null && query.size() > 0) {
                    EmailAddress emailAddress2 = (EmailAddress) query.get(0);
                    if (emailAddress2 != null) {
                        emailAddress.setDbRowId(emailAddress2.getDbRowId());
                    }
                }
                getEmailAddressDao().createOrUpdate(emailAddress);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void syncContacts() {
        List<ContactGroup> allContactGroups = getAllContactGroups();
        if (allContactGroups != null && allContactGroups.size() > 0) {
            for (ContactGroup contacts : allContactGroups) {
                List<Contact> contacts2 = contacts.getContacts();
                if (contacts2 != null && contacts2.size() > 0) {
                    for (Contact contact : contacts2) {
                        if (isContactExisted(contact)) {
                            updateContactToDatabase(contact);
                        } else {
                            removeContact(contact);
                        }
                    }
                }
            }
        }
        for (ContactGroup contacts3 : getAllContactGroups()) {
            if (contacts3.getContacts().size() == 0) {
                removeContactGroup(contacts3);
            }
        }
    }

    public void clearAllTables() {
        try {
            TableUtils.clearTable(getContactGroupDao().getConnectionSource(), ContactGroup.class);
            TableUtils.clearTable(getContactDao().getConnectionSource(), Contact.class);
            TableUtils.clearTable(getPhoneNumberDao().getConnectionSource(), PhoneNumber.class);
            TableUtils.clearTable(getEmailAddressDao().getConnectionSource(), EmailAddress.class);
        } catch (Exception e) {
            Log.e(this.TAG, "clearAllTables Exception=" + e);
        }
    }

    private boolean isContactExisted(Contact contact) {
        String[] strArr = new String[]{String.valueOf(contact.getContactId())};
        Cursor query = this.context.getContentResolver().query(Contacts.CONTENT_URI, null, "name_raw_contact_id=?", strArr, null);
        if (query == null) {
            return false;
        }
        boolean moveToFirst = query.moveToFirst();
        query.close();
        return moveToFirst;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void updateContactToDatabase(com.fossil.wearables.fsl.contact.Contact r9) {
        /*
        r8 = this;
        r6 = 0;
        r0 = r8.context;	 Catch:{ Exception -> 0x014e, all -> 0x00c7 }
        r0 = r0.getContentResolver();	 Catch:{ Exception -> 0x014e, all -> 0x00c7 }
        r3 = "name_raw_contact_id=?";
        r1 = 1;
        r4 = new java.lang.String[r1];	 Catch:{ Exception -> 0x014e, all -> 0x00c7 }
        r1 = 0;
        r2 = r9.getContactId();	 Catch:{ Exception -> 0x014e, all -> 0x00c7 }
        r2 = java.lang.String.valueOf(r2);	 Catch:{ Exception -> 0x014e, all -> 0x00c7 }
        r4[r1] = r2;	 Catch:{ Exception -> 0x014e, all -> 0x00c7 }
        r1 = android.provider.ContactsContract.Contacts.CONTENT_URI;	 Catch:{ Exception -> 0x014e, all -> 0x00c7 }
        r2 = 0;
        r5 = 0;
        r6 = r0.query(r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x014e, all -> 0x00c7 }
        r6.moveToFirst();	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r1 = "has_phone_number";
        r1 = r6.getColumnIndex(r1);	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r7 = r6.getInt(r1);	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r1 = "photo_thumb_uri";
        r1 = r6.getColumnIndex(r1);	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r1 = r6.getString(r1);	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r9.setPhotoThumbUri(r1);	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r3 = "mimetype = ? AND raw_contact_id = ?";
        r1 = 2;
        r4 = new java.lang.String[r1];	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r1 = 0;
        r2 = "vnd.android.cursor.item/name";
        r4[r1] = r2;	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r1 = 1;
        r2 = r9.getContactId();	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r2 = java.lang.String.valueOf(r2);	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r4[r1] = r2;	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r1 = android.provider.ContactsContract.Data.CONTENT_URI;	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r2 = 0;
        r5 = "data2";
        r1 = r0.query(r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
    L_0x0057:
        r2 = r1.moveToNext();	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        if (r2 == 0) goto L_0x0083;
    L_0x005d:
        r2 = "data2";
        r2 = r1.getColumnIndex(r2);	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r2 = r1.getString(r2);	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r9.setFirstName(r2);	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r2 = "data3";
        r2 = r1.getColumnIndex(r2);	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r2 = r1.getString(r2);	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r9.setLastName(r2);	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        goto L_0x0057;
    L_0x0078:
        r0 = move-exception;
        r1 = r6;
    L_0x007a:
        r0.printStackTrace();	 Catch:{ all -> 0x014a }
        if (r1 == 0) goto L_0x0082;
    L_0x007f:
        r1.close();
    L_0x0082:
        return;
    L_0x0083:
        r1.close();	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        if (r7 == 0) goto L_0x0135;
    L_0x0088:
        r1 = r8.TAG;	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r2 = "Contact has phone numbers";
        android.util.Log.i(r1, r2);	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r1 = android.provider.ContactsContract.CommonDataKinds.Phone.CONTENT_URI;	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r2 = 0;
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r3.<init>();	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r4 = "name_raw_contact_id = ";
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r4 = r9.getContactId();	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r4 = 0;
        r5 = 0;
        r2 = r0.query(r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r1 = r9.getPhoneNumbers();	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r3 = r1.iterator();	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
    L_0x00b7:
        r1 = r3.hasNext();	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        if (r1 == 0) goto L_0x00ce;
    L_0x00bd:
        r1 = r3.next();	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r1 = (com.fossil.wearables.fsl.contact.PhoneNumber) r1;	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r8.removePhoneNumber(r1);	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        goto L_0x00b7;
    L_0x00c7:
        r0 = move-exception;
    L_0x00c8:
        if (r6 == 0) goto L_0x00cd;
    L_0x00ca:
        r6.close();
    L_0x00cd:
        throw r0;
    L_0x00ce:
        r1 = r2.moveToNext();	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        if (r1 == 0) goto L_0x00ed;
    L_0x00d4:
        r1 = "data1";
        r1 = r2.getColumnIndex(r1);	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r1 = r2.getString(r1);	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r3 = new com.fossil.wearables.fsl.contact.PhoneNumber;	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r3.<init>();	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r3.setNumber(r1);	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r3.setContact(r9);	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r8.savePhoneNumber(r3);	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        goto L_0x00ce;
    L_0x00ed:
        r2.close();	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
    L_0x00f0:
        r1 = android.provider.ContactsContract.CommonDataKinds.Email.CONTENT_URI;	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r2 = 0;
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r3.<init>();	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r4 = "raw_contact_id=";
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r4 = r9.getContactId();	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r4 = 0;
        r5 = 0;
        r0 = r0.query(r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
    L_0x0110:
        r1 = r0.moveToNext();	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        if (r1 == 0) goto L_0x013d;
    L_0x0116:
        r1 = "data1";
        r1 = r0.getColumnIndex(r1);	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r1 = r0.getString(r1);	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        if (r2 != 0) goto L_0x0110;
    L_0x0126:
        r2 = new com.fossil.wearables.fsl.contact.EmailAddress;	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r2.<init>();	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r2.setAddress(r1);	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r2.setContact(r9);	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r8.saveEmailAddress(r2);	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        goto L_0x0110;
    L_0x0135:
        r1 = r8.TAG;	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r2 = "Contact has no phone numbers";
        android.util.Log.i(r1, r2);	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        goto L_0x00f0;
    L_0x013d:
        r0.close();	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        r8.saveContact(r9);	 Catch:{ Exception -> 0x0078, all -> 0x00c7 }
        if (r6 == 0) goto L_0x0082;
    L_0x0145:
        r6.close();
        goto L_0x0082;
    L_0x014a:
        r0 = move-exception;
        r6 = r1;
        goto L_0x00c8;
    L_0x014e:
        r0 = move-exception;
        r1 = r6;
        goto L_0x007a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.wearables.fsl.contact.ContactProviderImpl.updateContactToDatabase(com.fossil.wearables.fsl.contact.Contact):void");
    }
}
