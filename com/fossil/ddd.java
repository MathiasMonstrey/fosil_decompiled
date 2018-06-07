package com.fossil;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.util.Log;
import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.fossil.wearables.fsl.appfilter.AppFilter;
import com.fossil.wearables.fsl.contact.Contact;
import com.fossil.wearables.fsl.contact.ContactGroup;
import com.fossil.wearables.fsl.contact.ContactProvider;
import com.fossil.wearables.fsl.contact.PhoneNumber;
import com.misfit.frameworks.buttonservice.enums.MFDeviceFamily;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.source.NotificationsRepository;
import com.portfolio.platform.model.PhoneFavoritesContact;
import com.portfolio.platform.ui.notifications.domain.model.AppWrapper;
import com.portfolio.platform.ui.notifications.domain.model.ContactWrapper;
import java.util.ArrayList;
import java.util.List;

public class ddd extends ckb<C2682a, C2683b, C2131a> {
    private static final String TAG = ddd.class.getSimpleName();
    private final NotificationsRepository cFK;

    public static final class C2682a implements C2132b {
        List<ContactWrapper> cQI;
        List<AppWrapper> cQJ;

        List<ContactWrapper> amB() {
            return this.cQI;
        }

        List<AppWrapper> amC() {
            return this.cQJ;
        }

        public C2682a(List<ContactWrapper> list, List<AppWrapper> list2) {
            this.cQI = list;
            this.cQJ = list2;
        }
    }

    public static final class C2683b implements C2133c {
        boolean cQK;

        public C2683b(boolean z) {
            this.cQK = z;
        }
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m8358a((C2682a) c2132b);
    }

    ddd(NotificationsRepository notificationsRepository) {
        this.cFK = (NotificationsRepository) cco.m5996s(notificationsRepository, "notificationsRepository cannot be null!");
    }

    protected void m8358a(C2682a c2682a) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        List arrayList3 = new ArrayList();
        List arrayList4 = new ArrayList();
        for (ContactWrapper contactWrapper : c2682a.amB()) {
            if (contactWrapper.isAdded()) {
                arrayList.add(contactWrapper);
            } else {
                arrayList2.add(contactWrapper);
            }
        }
        removeListContact(arrayList2);
        ad(arrayList);
        for (AppWrapper appWrapper : c2682a.amC()) {
            if (appWrapper.installedApp.isSelected().booleanValue()) {
                arrayList3.add(appWrapper);
            } else {
                arrayList4.add(appWrapper);
            }
        }
        removeListAppFilter(arrayList4);
        ag(arrayList3);
        MFLogger.m12670d(TAG, "Inside .SaveAllNotification done");
        abr().onSuccess(new C2683b(true));
    }

    private void removeListContact(List<ContactWrapper> list) {
        if (!list.isEmpty()) {
            ContactProvider ack = cnq.acd().ack();
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            List arrayList3 = new ArrayList();
            for (ContactWrapper contact : list) {
                Contact contact2 = contact.getContact();
                arrayList2.add(contact2);
                Log.d(TAG, "Removed contact = " + contact2.getFirstName() + " row id = " + contact2.getDbRowId());
                for (ContactGroup contactGroup : ack.getAllContactGroups(MFDeviceFamily.DEVICE_FAMILY_SAM.getValue())) {
                    for (Contact contact3 : contactGroup.getContacts()) {
                        if (contact2.getContactId() == contact3.getContactId()) {
                            contact2.setDbRowId(contact3.getDbRowId());
                            arrayList.add(contactGroup);
                            break;
                        }
                    }
                }
                for (PhoneNumber number : contact2.getPhoneNumbers()) {
                    arrayList3.add(new PhoneFavoritesContact(number.getNumber()));
                }
            }
            this.cFK.removeListContact(arrayList2);
            this.cFK.removeContactGroupList(arrayList);
            af(arrayList3);
        }
    }

    private void ad(List<ContactWrapper> list) {
        if (!list.isEmpty()) {
            List<ContactGroup> allContactGroups = this.cFK.getAllContactGroups(MFDeviceFamily.DEVICE_FAMILY_SAM.getValue());
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            List arrayList3 = new ArrayList();
            List arrayList4 = new ArrayList();
            ContactProvider ack = cnq.acd().ack();
            for (ContactWrapper contactWrapper : list) {
                if (allContactGroups != null) {
                    Object obj = null;
                    for (ContactGroup contactGroup : allContactGroups) {
                        Object obj2;
                        for (Contact contact : contactGroup.getContacts()) {
                            if (contactWrapper != null && contactWrapper.getContact() != null && contact != null && contact.getContactId() == contactWrapper.getContact().getContactId()) {
                                contact.setUseCall(contactWrapper.getContact().isUseCall());
                                contact.setUseSms(contactWrapper.getContact().isUseSms());
                                contact.setFirstName(contactWrapper.getContact().getFirstName());
                                MFLogger.m12670d(TAG, "Contact Id = " + contactWrapper.getContact().getContactId());
                                MFLogger.m12670d(TAG, "Contact name = " + contactWrapper.getContact().getFirstName());
                                MFLogger.m12670d(TAG, "Contact db row = " + contactWrapper.getContact().getDbRowId());
                                MFLogger.m12670d(TAG, "Contact phone = " + contactWrapper.getPhoneNumber());
                                contactWrapper.setContact(contact);
                                ack.removeContactGroup(contactGroup);
                                allContactGroups.remove(contactGroup);
                                obj2 = 1;
                                break;
                            }
                        }
                        obj2 = obj;
                        if (obj2 != null) {
                            break;
                        }
                        obj = obj2;
                    }
                }
                ContactGroup contactGroup2 = new ContactGroup();
                contactGroup2.setDeviceFamily(MFDeviceFamily.DEVICE_FAMILY_SAM.getValue());
                contactGroup2.setHour(contactWrapper.getCurrentHandGroup());
                arrayList2.add(contactGroup2);
                Contact contact2 = contactWrapper.getContact();
                contact2.setContactGroup(contactGroup2);
                contact2.setUseCall(contactWrapper.getContact().isUseCall());
                contact2.setUseSms(contactWrapper.getContact().isUseSms());
                contact2.setUseEmail(false);
                arrayList.add(contact2);
                ContentResolver contentResolver = PortfolioApp.ZQ().getContentResolver();
                if (contactWrapper.hasPhoneNumber()) {
                    PhoneNumber phoneNumber;
                    Cursor query = contentResolver.query(Phone.CONTENT_URI, new String[]{"data1"}, "contact_id=" + contact2.getContactId(), null, null);
                    if (query != null) {
                        while (query.moveToNext()) {
                            try {
                                phoneNumber = new PhoneNumber();
                                phoneNumber.setNumber(query.getString(query.getColumnIndex("data1")));
                                phoneNumber.setContact(contact2);
                                arrayList3.add(phoneNumber);
                                if (contactWrapper.isFavorites()) {
                                    arrayList4.add(new PhoneFavoritesContact(phoneNumber.getNumber()));
                                }
                            } catch (Exception e) {
                                MFLogger.m12671e(TAG, "Error Inside " + TAG + ".saveContactToFSL - ex=" + e.toString());
                            } finally {
                                query.close();
                            }
                        }
                    }
                    if (contact2.getContactId() == -100) {
                        phoneNumber = new PhoneNumber();
                        phoneNumber.setNumber("-1234");
                        phoneNumber.setContact(contact2);
                        arrayList3.add(phoneNumber);
                    }
                    if (contact2.getContactId() == -200) {
                        phoneNumber = new PhoneNumber();
                        phoneNumber.setNumber("-5678");
                        phoneNumber.setContact(contact2);
                        arrayList3.add(phoneNumber);
                    }
                }
            }
            this.cFK.saveContactGroupList(arrayList2);
            this.cFK.saveListContact(arrayList);
            this.cFK.saveListPhoneNumber(arrayList3);
            ae(arrayList4);
        }
    }

    private void ae(List<PhoneFavoritesContact> list) {
        for (PhoneFavoritesContact savePhoneFavoritesContact : list) {
            this.cFK.savePhoneFavoritesContact(savePhoneFavoritesContact);
        }
    }

    private void af(List<PhoneFavoritesContact> list) {
        for (PhoneFavoritesContact removePhoneFavoritesContact : list) {
            this.cFK.removePhoneFavoritesContact(removePhoneFavoritesContact);
        }
    }

    private void removeListAppFilter(List<AppWrapper> list) {
        if (!list.isEmpty()) {
            List arrayList = new ArrayList();
            for (AppWrapper appWrapper : list) {
                AppFilter appFilter = new AppFilter();
                appFilter.setDbRowId(appWrapper.installedApp.getDbRowId());
                appFilter.setHour(appWrapper.getCurrentHandGroup());
                appFilter.setType(appWrapper.installedApp.getIdentifier());
                Log.d(TAG, "Removed App name:" + appWrapper.installedApp.getIdentifier() + "row id = " + appWrapper.installedApp.getDbRowId() + "hour =" + appWrapper.getCurrentHandGroup());
                arrayList.add(appFilter);
            }
            this.cFK.removeListAppFilter(arrayList);
        }
    }

    private void ag(List<AppWrapper> list) {
        if (!list.isEmpty()) {
            List arrayList = new ArrayList();
            for (AppWrapper appWrapper : list) {
                AppFilter appFilter = new AppFilter();
                appFilter.setHour(appWrapper.getCurrentHandGroup());
                appFilter.setType(appWrapper.installedApp.getIdentifier());
                appFilter.setDeviceFamily(MFDeviceFamily.DEVICE_FAMILY_SAM.getValue());
                Log.d(TAG, "Saved App name:" + appWrapper.installedApp.getIdentifier() + "hour =" + appWrapper.getCurrentHandGroup());
                arrayList.add(appFilter);
            }
            this.cFK.saveListAppFilters(arrayList);
        }
    }
}
