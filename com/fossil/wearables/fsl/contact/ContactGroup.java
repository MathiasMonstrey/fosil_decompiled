package com.fossil.wearables.fsl.contact;

import com.fossil.wearables.fsl.shared.BaseFeatureModel;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import java.util.ArrayList;
import java.util.List;

public class ContactGroup extends BaseFeatureModel {
    public static final String COLUMN_DEVICE_FAMILY = "deviceFamily";
    @ForeignCollectionField(eager = true)
    ForeignCollection<Contact> contacts;
    @DatabaseField
    private int deviceFamily;

    public int getDeviceFamily() {
        return this.deviceFamily;
    }

    public void setDeviceFamily(int i) {
        this.deviceFamily = i;
    }

    public List<Contact> getContacts() {
        List<Contact> arrayList = new ArrayList();
        if (this.contacts == null || this.contacts.size() <= 0) {
            return arrayList;
        }
        return new ArrayList(this.contacts);
    }

    public Contact getContactWithPhoneNumber(String str) {
        if (getContacts() != null && getContacts().size() > 0) {
            for (Contact contact : getContacts()) {
                if (contact != null && contact.containsPhoneNumber(str)) {
                    return contact;
                }
            }
        }
        return null;
    }

    public Contact getContactWithEmail(String str) {
        if (getContacts() != null && getContacts().size() > 0) {
            for (Contact contact : getContacts()) {
                if (contact != null && contact.containsEmail(str)) {
                    return contact;
                }
            }
        }
        return null;
    }
}
