package com.fossil;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.fossil.wearables.fsl.contact.Contact;
import com.fossil.wearables.fsl.contact.PhoneNumber;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.source.NotificationsRepository;
import java.util.List;

public class ddh extends ckb<C2685a, C2133c, C2131a> {
    private static final String TAG = ddh.class.getSimpleName();
    private final NotificationsRepository mRepository;

    public static final class C2685a implements C2132b {
        private final String cQO;
        private final String cQP;
        private final List<String> cQQ;

        String amG() {
            return this.cQO;
        }

        public String amH() {
            return this.cQP;
        }

        public List<String> amI() {
            return this.cQQ;
        }
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m8369a((C2685a) c2132b);
    }

    ddh(NotificationsRepository notificationsRepository) {
        this.mRepository = (NotificationsRepository) cco.ce(notificationsRepository);
    }

    protected void m8369a(C2685a c2685a) {
        MFLogger.m12670d(TAG, "executeUseCase");
        Contact contactById = this.mRepository.getContactById(Integer.parseInt(c2685a.amG()));
        if (contactById != null && (!contactById.getFirstName().equals(c2685a.amH()) || m8368c(contactById.getPhoneNumbers(), c2685a.amI()))) {
            contactById.setFirstName(c2685a.amH());
            m8367a(this.mRepository, contactById);
        }
        abr().onSuccess(null);
    }

    private boolean m8368c(List<PhoneNumber> list, List<String> list2) {
        if (!(list == null || list2 == null)) {
            for (PhoneNumber number : list) {
                list2.remove(number.getNumber());
            }
            if (list2.size() > 0) {
                return true;
            }
        }
        return false;
    }

    private void m8367a(NotificationsRepository notificationsRepository, Contact contact) {
        notificationsRepository.saveContact(contact);
        m8366a(contact, notificationsRepository);
    }

    private void m8366a(Contact contact, NotificationsRepository notificationsRepository) {
        notificationsRepository.removePhoneNumberByContactGroupId(contact.getContactGroup().getDbRowId());
        ContentResolver contentResolver = PortfolioApp.ZQ().getContentResolver();
        if (contact.getPhoneNumbers().size() > 0) {
            Cursor query = contentResolver.query(Phone.CONTENT_URI, new String[]{"data1"}, "contact_id=" + contact.getContactId(), null, null);
            if (query != null) {
                while (query.moveToNext()) {
                    try {
                        PhoneNumber phoneNumber = new PhoneNumber();
                        phoneNumber.setNumber(query.getString(query.getColumnIndex("data1")));
                        phoneNumber.setContact(contact);
                        notificationsRepository.savePhoneNumber(phoneNumber);
                    } catch (Exception e) {
                        MFLogger.m12671e(TAG, "Error Inside " + TAG + ".saveContactToFSL - ex=" + e.toString());
                    } finally {
                        query.close();
                    }
                }
            }
        }
    }
}
