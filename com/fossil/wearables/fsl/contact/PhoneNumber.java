package com.fossil.wearables.fsl.contact;

import com.fossil.wearables.fsl.shared.BaseModel;
import com.j256.ormlite.field.DatabaseField;

public class PhoneNumber extends BaseModel {
    @DatabaseField(columnName = "phone_number_id", foreign = true, foreignAutoRefresh = true)
    private Contact contact;
    @DatabaseField
    private String number;

    public void setNumber(String str) {
        this.number = str;
    }

    public String getNumber() {
        return this.number;
    }

    public Contact getContact() {
        return this.contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
