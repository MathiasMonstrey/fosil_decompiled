package com.fossil.wearables.fsl.contact;

import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.fossil.wearables.fsl.shared.BaseModel;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import java.util.ArrayList;
import java.util.List;

public class Contact extends BaseModel {
    @DatabaseField
    private String companyName;
    @DatabaseField(columnName = "contact_group_id", foreign = true, foreignAutoRefresh = true)
    private ContactGroup contactGroup;
    @DatabaseField
    private int contactId;
    private String displayName;
    @ForeignCollectionField(eager = true)
    private ForeignCollection<EmailAddress> emailAddresses;
    @DatabaseField
    private String firstName;
    @DatabaseField
    private String lastName;
    @ForeignCollectionField(eager = true)
    private ForeignCollection<PhoneNumber> phoneNumbers;
    @DatabaseField
    private String photoThumbUri;
    @DatabaseField
    private boolean useCall;
    @DatabaseField
    private boolean useEmail;
    @DatabaseField
    private boolean useSms;

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String str) {
        this.firstName = str;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String str) {
        this.lastName = str;
    }

    public String getDisplayName() {
        if (!TextUtils.isEmpty(this.displayName)) {
            return this.displayName;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(this.firstName)) {
            stringBuilder.append(this.firstName);
        }
        if (!TextUtils.isEmpty(this.lastName)) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            }
            stringBuilder.append(this.lastName);
        }
        this.displayName = stringBuilder.toString();
        return this.displayName;
    }

    public int getContactId() {
        return this.contactId;
    }

    public void setContactId(int i) {
        this.contactId = i;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String str) {
        this.companyName = str;
    }

    public boolean isUseCall() {
        return this.useCall;
    }

    public void setUseCall(boolean z) {
        this.useCall = z;
    }

    public boolean isUseEmail() {
        return this.useEmail;
    }

    public void setUseEmail(boolean z) {
        this.useEmail = z;
    }

    public boolean isUseSms() {
        return this.useSms;
    }

    public void setUseSms(boolean z) {
        this.useSms = z;
    }

    public void setContactGroup(ContactGroup contactGroup) {
        this.contactGroup = contactGroup;
    }

    public ContactGroup getContactGroup() {
        return this.contactGroup;
    }

    public String getPhotoThumbUri() {
        return this.photoThumbUri;
    }

    public void setPhotoThumbUri(String str) {
        this.photoThumbUri = str;
    }

    public List<EmailAddress> getEmailAddresses() {
        List<EmailAddress> arrayList = new ArrayList();
        if (this.emailAddresses == null || this.emailAddresses.size() <= 0) {
            return arrayList;
        }
        return new ArrayList(this.emailAddresses);
    }

    public List<PhoneNumber> getPhoneNumbers() {
        List<PhoneNumber> arrayList = new ArrayList();
        if (this.phoneNumbers == null || this.phoneNumbers.size() <= 0) {
            return arrayList;
        }
        return new ArrayList(this.phoneNumbers);
    }

    public boolean containsPhoneNumber(String str) {
        if (!(TextUtils.isEmpty(str) || getPhoneNumbers() == null || getPhoneNumbers().size() <= 0)) {
            for (PhoneNumber phoneNumber : getPhoneNumbers()) {
                if (phoneNumber != null && !TextUtils.isEmpty(phoneNumber.getNumber()) && arePhoneNumbersEqual(phoneNumber.getNumber(), str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsEmail(String str) {
        if (!(TextUtils.isEmpty(str) || getEmailAddresses() == null || getEmailAddresses().size() <= 0)) {
            for (EmailAddress emailAddress : getEmailAddresses()) {
                if (emailAddress != null && !TextUtils.isEmpty(emailAddress.getAddress()) && emailAddress.getAddress().equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean arePhoneNumbersEqual(String str, String str2) {
        return PhoneNumberUtils.compare(str, str2);
    }
}
