package com.fossil;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.RawContacts;
import android.text.TextUtils;
import com.fossil.ckb.C2126d;
import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2133c;
import com.fossil.ddj.C2686a;
import com.j256.ormlite.field.FieldType;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class dqs extends ContentObserver {
    private static final String TAG = dqs.class.getSimpleName();
    private final HashMap<String, Integer> deP = new HashMap();
    private final HashMap<String, Boolean> deQ = new HashMap();
    private final ddh deR;
    private final ddj deS;
    private final PortfolioApp deT;
    private final ContentResolver mContentResolver;
    private final cnr mSharedPreferencesManager;
    private final ckc mUseCaseHandler;

    class C31081 implements C2126d<C2133c, C2131a> {
        final /* synthetic */ dqs deU;

        C31081(dqs com_fossil_dqs) {
            this.deU = com_fossil_dqs;
        }

        public /* synthetic */ void onError(Object obj) {
            m9402a((C2131a) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m9403a((C2133c) obj);
        }

        public void m9403a(C2133c c2133c) {
            MFLogger.m12670d(dqs.TAG, "UpdatePhoneFavoritesContacts onSuccess");
        }

        public void m9402a(C2131a c2131a) {
            MFLogger.m12670d(dqs.TAG, "UpdatePhoneFavoritesContacts onError");
        }
    }

    dqs(PortfolioApp portfolioApp, ckc com_fossil_ckc, ddh com_fossil_ddh, cnr com_fossil_cnr, ddj com_fossil_ddj, ContentResolver contentResolver) {
        super(null);
        this.deT = portfolioApp;
        this.mUseCaseHandler = (ckc) cco.m5996s(com_fossil_ckc, "useCaseHandler cannot be nulL!");
        this.deR = (ddh) cco.m5996s(com_fossil_ddh, "mUpdateContact cannot be nulL!");
        this.deS = (ddj) cco.m5996s(com_fossil_ddj, "updatePhoneFavoritesContacts cannot be nulL!");
        this.mContentResolver = (ContentResolver) cco.m5996s(contentResolver, "mContentResolver cannot be null!");
        this.mSharedPreferencesManager = com_fossil_cnr;
    }

    public boolean deliverSelfNotifications() {
        return true;
    }

    public void onChange(boolean z, Uri uri) {
        if (dre.dff.m9462a(this.deT, "android.permission.READ_PHONE_STATE", "android.permission.READ_CONTACTS", "android.permission.READ_SMS")) {
            Object string;
            MFLogger.m12670d(TAG, ".Inside onChange, enable flag isNeedRemoveRedundantContact = true");
            MFLogger.m12670d(TAG, "Contact on phone made something change, let's check!");
            String str = "";
            Cursor query = this.mContentResolver.query(Contacts.CONTENT_URI, new String[]{FieldType.FOREIGN_ID_FIELD_SUFFIX}, null, null, "contact_last_updated_timestamp Desc");
            String str2;
            if (query != null) {
                if (query.moveToFirst()) {
                    string = query.getString(query.getColumnIndex(FieldType.FOREIGN_ID_FIELD_SUFFIX));
                } else {
                    str2 = str;
                }
                query.close();
            } else {
                str2 = str;
            }
            String jp = jp(string);
            String jm = jm(string);
            boolean jn = jn(string);
            List jo = jo(string);
            if (jq(string)) {
                MFLogger.m12670d(TAG, "Update Contact: " + string + " - contactName: " + jm + " - contactPhone: " + jo + " - contactEmail: " + jp + " - isFavorites:" + jn);
                if (!TextUtils.isEmpty(string)) {
                    m9405a(string, jo, jn);
                }
            } else if (!m9406s(string, jn)) {
                m9405a(string, jo, jn);
            }
        }
    }

    private String jm(String str) {
        Exception e;
        String str2 = "";
        String str3;
        try {
            Cursor query = this.mContentResolver.query(Phone.CONTENT_URI, null, "contact_id = ?", new String[]{str}, null);
            if (query == null) {
                return str2;
            }
            str3 = str2;
            while (query.moveToNext()) {
                try {
                    str3 = query.getString(query.getColumnIndex("display_name"));
                } catch (Exception e2) {
                    e = e2;
                }
            }
            query.close();
            return str3;
        } catch (Exception e3) {
            e = e3;
            str3 = str2;
            e.printStackTrace();
            return str3;
        }
    }

    private boolean jn(String str) {
        Exception exception;
        boolean z = false;
        try {
            Cursor query = this.mContentResolver.query(Phone.CONTENT_URI, null, "contact_id = ?", new String[]{str}, null);
            if (query == null) {
                return false;
            }
            boolean z2 = false;
            while (query.moveToNext()) {
                try {
                    z2 = query.getInt(query.getColumnIndex("starred")) == 1;
                } catch (Exception e) {
                    z = z2;
                    exception = e;
                }
            }
            query.close();
            return z2;
        } catch (Exception e2) {
            exception = e2;
            exception.printStackTrace();
            return z;
        }
    }

    private List<String> jo(String str) {
        List<String> arrayList = new ArrayList();
        try {
            Cursor query = this.mContentResolver.query(Phone.CONTENT_URI, null, "contact_id = ?", new String[]{str}, null);
            if (query != null) {
                while (query.moveToNext()) {
                    CharSequence string = query.getString(query.getColumnIndex("data1"));
                    if (!TextUtils.isEmpty(string)) {
                        arrayList.add(string);
                    }
                }
                query.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    private String jp(String str) {
        Exception e;
        String str2 = "";
        String str3;
        try {
            Cursor query = this.mContentResolver.query(Email.CONTENT_URI, null, "contact_id = ?", new String[]{str}, null);
            if (query == null) {
                return str2;
            }
            str3 = str2;
            while (query.moveToNext()) {
                try {
                    str3 = query.getString(query.getColumnIndex("data1"));
                } catch (Exception e2) {
                    e = e2;
                }
            }
            query.close();
            return str3;
        } catch (Exception e3) {
            e = e3;
            str3 = str2;
            e.printStackTrace();
            return str3;
        }
    }

    private boolean jq(String str) {
        int i;
        Cursor query = this.mContentResolver.query(RawContacts.CONTENT_URI, new String[]{"contact_id", "version"}, "contact_id = ?", new String[]{str}, null);
        if (query != null) {
            i = 0;
            while (query.moveToNext()) {
                i += query.getInt(query.getColumnIndex("version"));
            }
            query.close();
        } else {
            i = 0;
        }
        if (m9404H(str, i)) {
            return false;
        }
        return true;
    }

    private boolean m9406s(String str, boolean z) {
        synchronized (this.deQ) {
            Boolean bool = (Boolean) this.deQ.get(str);
            MFLogger.m12670d(TAG, " Enter isFavoritesSettingLasted contactId= " + str + " saved Favorites Setting=" + bool + " new Favorites Setting:" + z);
            if (bool == null) {
                MFLogger.m12670d(TAG, "Contact not found, let's update");
                this.deQ.put(str, Boolean.valueOf(z));
                return false;
            }
            MFLogger.m12670d(TAG, "Found contact " + str);
            if (z != bool.booleanValue()) {
                MFLogger.m12670d(TAG, "Saved favorites setting of this contact is old, let's update");
                this.deQ.put(str, Boolean.valueOf(z));
                return false;
            }
            MFLogger.m12670d(TAG, "Saved favorites setting of this contact is lasted, skip!");
            jr(str);
            return true;
        }
    }

    private boolean m9404H(String str, int i) {
        synchronized (this.deP) {
            Integer num = (Integer) this.deP.get(str);
            MFLogger.m12670d(TAG, " Enter isVersionLasted contactId= " + str + " savedVersion=" + num + " newVersion:" + i);
            if (num == null) {
                MFLogger.m12670d(TAG, "Contact not found, let's update");
                this.deP.put(str, Integer.valueOf(i));
                return false;
            }
            MFLogger.m12670d(TAG, "Found contact " + str);
            if (i > num.intValue()) {
                MFLogger.m12670d(TAG, "Saved version of this contact is old, let's update");
                this.deP.put(str, Integer.valueOf(i));
                return false;
            }
            MFLogger.m12670d(TAG, "Saved version of this contact is lasted, skip!");
            js(str);
            return true;
        }
    }

    private void jr(String str) {
        synchronized (this.deQ) {
            MFLogger.m12670d(TAG, "removeOldContactFavoritesSettingHashMap. Size = " + this.deQ.size());
            List<String> linkedList = new LinkedList();
            for (String str2 : this.deQ.keySet()) {
                if (!str2.equals(str)) {
                    linkedList.add(str2);
                }
            }
            for (String str22 : linkedList) {
                MFLogger.m12670d(TAG, "remove from favorites contact, contactId= " + str22);
                this.deQ.remove(str22);
            }
        }
    }

    private void js(String str) {
        synchronized (this.deP) {
            MFLogger.m12670d(TAG, "removeOtherContactVersionHashMap. Size = " + this.deP.size());
            List<String> linkedList = new LinkedList();
            for (String str2 : this.deP.keySet()) {
                if (!str2.equals(str)) {
                    linkedList.add(str2);
                }
            }
            for (String str22 : linkedList) {
                MFLogger.m12670d(TAG, "remove from contact versions, contactId= " + str22);
                this.deP.remove(str22);
            }
        }
    }

    private synchronized void m9405a(String str, List<String> list, boolean z) {
        List arrayList = new ArrayList(list);
        synchronized (this.deQ) {
            this.deQ.put(str, Boolean.valueOf(z));
        }
        MFLogger.m12670d(TAG, "Save favorites contact to db");
        this.mUseCaseHandler.m6886a(this.deS, new C2686a(arrayList, z), new C31081(this));
    }
}
