package com.portfolio.platform.ui.notifications.domain.model;

import android.text.TextUtils;
import com.fossil.wearables.fsl.contact.Contact;
import java.io.Serializable;

public class ContactWrapper implements Serializable {
    private Contact contact;
    private boolean isAdded;
    private int mCurrentHandGroup;
    private boolean mHasPhoneNumber;
    private boolean mIsFavorites;
    private String mPhoneNumber;
    private final String sortKey;

    public ContactWrapper(Contact contact, String str) {
        this.contact = contact;
        this.sortKey = str;
    }

    public String getSortKey() {
        return this.sortKey;
    }

    public Contact getContact() {
        return this.contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    private char gn(String str) {
        if (TextUtils.isEmpty(str)) {
            return '#';
        }
        char toUpperCase = Character.toUpperCase(str.charAt(0));
        if (Character.isAlphabetic(toUpperCase)) {
            return toUpperCase;
        }
        return '#';
    }

    public char getSortKeyInRightFormat() {
        return gn(this.sortKey);
    }

    public String getPhoneNumber() {
        return this.mPhoneNumber;
    }

    public void setPhoneNumber(String str) {
        this.mPhoneNumber = str;
    }

    public boolean hasPhoneNumber() {
        return this.mHasPhoneNumber;
    }

    public void setHasPhoneNumber(boolean z) {
        this.mHasPhoneNumber = z;
    }

    public boolean isFavorites() {
        return this.mIsFavorites;
    }

    public void setFavorites(boolean z) {
        this.mIsFavorites = z;
    }

    public boolean isAdded() {
        return this.isAdded;
    }

    public void setAdded(boolean z) {
        this.isAdded = z;
    }

    public int getCurrentHandGroup() {
        return this.mCurrentHandGroup;
    }

    public void setCurrentHandGroup(int i) {
        this.mCurrentHandGroup = i;
    }
}
