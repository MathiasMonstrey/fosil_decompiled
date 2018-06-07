package com.fossil.wearables.fsl.contact;

import com.fossil.wearables.fsl.shared.BaseModel;
import com.j256.ormlite.field.DatabaseField;

public class EmailAddress extends BaseModel {
    @DatabaseField
    private String address;
    @DatabaseField(columnName = "email_address_id", foreign = true, foreignAutoRefresh = true)
    private Contact contact;

    public void setAddress(String str) {
        this.address = str;
    }

    public String getAddress() {
        return this.address;
    }

    public Contact getContact() {
        return this.contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
