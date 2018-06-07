package com.fossil;

import android.util.Log;
import android.util.SparseArray;
import com.fossil.ckb.C2126d;
import com.fossil.ckb.C2131a;
import com.fossil.dcg.C2646a;
import com.fossil.dcg.C2647b;
import com.fossil.dcv.C2675a;
import com.fossil.dcv.C2677c;
import com.fossil.dcx.C2678a;
import com.fossil.dcz.C2679a;
import com.fossil.ddd.C2682a;
import com.fossil.ddd.C2683b;
import com.fossil.wearables.fossil.R;
import com.fossil.wearables.fsl.contact.Contact;
import com.fossil.wearables.fsl.contact.ContactGroup;
import com.fossil.wearables.fsl.contact.PhoneNumber;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.ui.notifications.domain.model.AppWrapper;
import com.portfolio.platform.ui.notifications.domain.model.ContactWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class dcn implements C2646a {
    private static final String TAG = dcn.class.getSimpleName();
    private int Bz;
    protected cmj cEE;
    private List<ContactWrapper> cPA;
    private List<AppWrapper> cPB;
    private List<Object> cPC = new CopyOnWriteArrayList();
    private List<Object> cPD = new ArrayList();
    private final C2647b cPr;
    private int cPs;
    private boolean cPt;
    private final dcz cPv;
    private final ddd cPw;
    private final dcx cPx;
    private final ddf cPy;
    private final dcv cPz;
    private final cnr mSharedPreferencesManager;
    private final ckc mUseCaseHandler;

    class C26601 implements C2126d<C2677c, C2675a> {
        final /* synthetic */ dcn cPE;

        C26601(dcn com_fossil_dcn) {
            this.cPE = com_fossil_dcn;
        }

        public /* synthetic */ void onError(Object obj) {
            m8263a((C2675a) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m8264a((C2677c) obj);
        }

        public void m8264a(C2677c c2677c) {
            this.cPE.cPA = new ArrayList();
            List<ContactGroup> amu = c2677c.amu();
            for (ContactGroup contactGroup : amu) {
                for (Contact contact : contactGroup.getContacts()) {
                    if (contactGroup.getHour() == this.cPE.cPs) {
                        ContactWrapper contactWrapper = new ContactWrapper(contact, null);
                        contactWrapper.setAdded(true);
                        contactWrapper.setCurrentHandGroup(contact.getContactGroup().getHour());
                        contactWrapper.getContact().setDbRowId(contact.getDbRowId());
                        contactWrapper.getContact().setUseSms(contact.isUseSms());
                        contactWrapper.getContact().setUseCall(contact.isUseCall());
                        if (!contact.getPhoneNumbers().isEmpty() && ((PhoneNumber) contact.getPhoneNumbers().get(0)).getNumber().length() > 0) {
                            contactWrapper.setHasPhoneNumber(true);
                            contactWrapper.setPhoneNumber(((PhoneNumber) contact.getPhoneNumbers().get(0)).getNumber());
                            MFLogger.m12670d(dcn.TAG, ".Inside loadContactData filter selected contact, phoneNumber=" + ((PhoneNumber) contact.getPhoneNumbers().get(0)).getNumber());
                        }
                        MFLogger.m12670d(dcn.TAG, ".Inside loadContactData filter selected contact, hand=" + contact.getContactGroup().getHour() + " ,rowId=" + contact.getDbRowId() + " ,isUseText=" + contact.isUseSms() + " ,isUseCall=" + contact.isUseCall());
                        this.cPE.cPA.add(contactWrapper);
                        this.cPE.cPC.add(contactWrapper);
                    }
                }
            }
            if (this.cPE.cPr.isActive()) {
                this.cPE.cPr.mo2258a(amu, this.cPE.cPs, this.cPE.cPA);
            }
            this.cPE.ame();
            MFLogger.m12670d(dcn.TAG, ".Inside mGetAllContactGroup onSuccess");
        }

        public void m8263a(C2675a c2675a) {
            this.cPE.cPr.alG();
            MFLogger.m12670d(dcn.TAG, ".Inside mGetAllContactGroup onError");
        }
    }

    class C26612 implements C2126d<C2679a, C2131a> {
        final /* synthetic */ dcn cPE;

        C26612(dcn com_fossil_dcn) {
            this.cPE = com_fossil_dcn;
        }

        public /* synthetic */ void onError(Object obj) {
            m8265a((C2131a) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m8266a((C2679a) obj);
        }

        public void m8266a(C2679a c2679a) {
            MFLogger.m12670d(dcn.TAG, ".Inside GetApps usecase onSuccess");
            this.cPE.cPB = new ArrayList();
            this.cPE.cPB.addAll(c2679a.amy());
            this.cPE.cPr.mo2281g(this.cPE.cPB, this.cPE.cPs);
            for (AppWrapper appWrapper : this.cPE.cPB) {
                if (appWrapper.installedApp.isSelected().booleanValue() && appWrapper.getCurrentHandGroup() == this.cPE.cPs) {
                    this.cPE.cPC.add(appWrapper);
                }
            }
            this.cPE.cPr.ac(this.cPE.cPC);
            this.cPE.cPD.addAll(this.cPE.cPC);
            if (this.cPE.cPt) {
                this.cPE.cPr.alD();
            } else if (this.cPE.cPC.size() > 0) {
                this.cPE.cPr.mo2273b(0, this.cPE.cPC.get(0));
                this.cPE.cPr.cF(true);
            } else {
                this.cPE.cPr.alD();
            }
            this.cPE.cPr.alG();
            this.cPE.ami();
            this.cPE.amj();
        }

        public void m8265a(C2131a c2131a) {
            MFLogger.m12670d(dcn.TAG, ".Inside GetApps usecase onError");
            this.cPE.cPr.alG();
        }
    }

    class C26623 implements C2126d<C2683b, C2131a> {
        final /* synthetic */ dcn cPE;

        C26623(dcn com_fossil_dcn) {
            this.cPE = com_fossil_dcn;
        }

        public /* synthetic */ void onError(Object obj) {
            m8267a((C2131a) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m8268a((C2683b) obj);
        }

        public void m8268a(C2683b c2683b) {
            MFLogger.m12670d(dcn.TAG, ".Inside mSaveAllNotification onSuccess");
            this.cPE.cPr.alG();
            this.cPE.cPr.kG(this.cPE.cPs);
        }

        public void m8267a(C2131a c2131a) {
            MFLogger.m12670d(dcn.TAG, ".Inside mSaveAllNotification onError");
        }
    }

    dcn(C2647b c2647b, ckc com_fossil_ckc, int i, boolean z, dcz com_fossil_dcz, ddd com_fossil_ddd, dcx com_fossil_dcx, ddf com_fossil_ddf, cnr com_fossil_cnr, dcv com_fossil_dcv) {
        this.cPr = (C2647b) cco.m5996s(c2647b, "view cannot be nulL!");
        this.cPv = (dcz) cco.m5996s(com_fossil_dcz, "getApps cannot be null!");
        this.cPs = i;
        this.cPt = z;
        this.mUseCaseHandler = (ckc) cco.m5996s(com_fossil_ckc, "useCaseHandler cannot be nulL!");
        this.cPw = (ddd) cco.m5996s(com_fossil_ddd, "saveAllNotification cannot be nulL!");
        this.cPx = (dcx) cco.m5996s(com_fossil_dcx, "getAllNotification cannot be nulL!");
        this.cPy = (ddf) cco.m5996s(com_fossil_ddf, "updateAllPhoneFavoritesContacts cannot be nulL!");
        this.mSharedPreferencesManager = com_fossil_cnr;
        this.cEE = cmj.bs(PortfolioApp.ZQ());
        this.cPz = (dcv) cco.m5996s(com_fossil_dcv, "mGetAllContactGroup cannot be nulL!");
    }

    public void ahu() {
        this.cPr.cK(this);
    }

    public void start() {
        Log.d(TAG, "Presenter starts, isAddFlow =" + this.cPt + " ,mHandNumber=" + this.cPs);
        amd();
        this.cPr.kH(this.cPs);
    }

    public void stop() {
        Log.d(TAG, "Presenter stopped");
    }

    private void amd() {
        if (this.cPA == null) {
            this.cPr.alF();
            MFLogger.m12670d(TAG, ".Inside start get all contact group for cursor adapter");
            this.mUseCaseHandler.m6886a(this.cPz, null, new C26601(this));
        }
    }

    private void ame() {
        MFLogger.m12670d(TAG, ".Inside start GetApps usecase");
        if (this.cPB == null) {
            this.mUseCaseHandler.m6886a(this.cPv, null, new C26612(this));
        }
    }

    public void save() {
        MFLogger.m12670d(TAG, ".Inside start SaveAllNotification usecase");
        this.cPr.alF();
        this.mUseCaseHandler.m6886a(this.cPw, new C2682a(this.cPA, this.cPB), new C26623(this));
    }

    public void alA() {
        MFLogger.m12670d(TAG, "Inside. finishAddTooltip");
        this.mSharedPreferencesManager.bY(true);
        cmj.bs(PortfolioApp.ZQ()).m7086l("tooltip_dismiss", "Subject", "2nd_Notifications_Tooltip");
    }

    public void alB() {
        MFLogger.m12670d(TAG, "Inside. finishCallTooltip");
        this.mSharedPreferencesManager.bX(true);
        cmj.bs(PortfolioApp.ZQ()).m7086l("tooltip_dismiss", "Subject", "3rd_Notifications_Tooltip");
        this.cPr.alI();
    }

    public void cH(boolean z) {
        this.cPt = z;
    }

    public boolean amf() {
        return this.cPt;
    }

    public void kt(int i) {
        MFLogger.m12670d(TAG, ".Inside selectedPosition position = " + i);
        this.Bz = i;
        this.cPr.mo2273b(i, this.cPC.get(i));
    }

    public int amg() {
        return this.Bz;
    }

    public void kN(int i) {
        this.Bz = i;
    }

    public int amh() {
        MFLogger.m12670d(TAG, ".Inside getHandNumber");
        return this.cPs;
    }

    public void kO(int i) {
        MFLogger.m12670d(TAG, ".Inside setHandNumber");
        this.cPs = i;
    }

    public void mo2300a(ContactWrapper contactWrapper, boolean z, int i) {
        MFLogger.m12670d(TAG, ".Inside addContact at position " + contactWrapper);
        if (this.cPC.size() >= 12) {
            this.cPr.alE();
            return;
        }
        if (m8275a(contactWrapper)) {
            for (ContactWrapper contactWrapper2 : this.cPA) {
                if (contactWrapper2.getContact().getContactId() == contactWrapper.getContact().getContactId()) {
                    contactWrapper2.setAdded(true);
                }
            }
        } else {
            this.cPA.add(contactWrapper);
        }
        cQ(contactWrapper);
        this.cPr.kA(i);
        amj();
        MFLogger.m12670d(TAG, ".Inside addContact: contact id = " + contactWrapper.getContact().getContactId() + " ,name=" + contactWrapper.getContact().getDisplayName() + " ,hand=" + contactWrapper.getCurrentHandGroup() + " ,rowId=" + contactWrapper.getContact().getDbRowId());
        Object obj = z ? "Search" : "List";
        Map hashMap = new HashMap();
        hashMap.put("Dest", String.valueOf(this.cPs));
        hashMap.put("Assigned", String.valueOf(this.cPs));
        hashMap.put("Screen", obj);
        if (contactWrapper.getContact().getContactId() == -100) {
            hashMap.put("Item", "All_Calls");
            m8282f("notifications_contacts_set", hashMap);
        } else if (contactWrapper.getContact().getContactId() == -200) {
            hashMap.put("Item", "All_Texts");
            m8282f("notifications_contacts_set", hashMap);
        } else {
            hashMap.put("Item", "Contact");
            m8282f("notifications_contacts_set", hashMap);
            m8287n("notifications_contacts", "Screen", "Preview");
        }
    }

    public void ku(int i) {
        if (this.cPC.isEmpty()) {
            MFLogger.m12670d(TAG, "mHorizontalData is empty");
            return;
        }
        MFLogger.m12670d(TAG, ".Inside removeContact at position " + i);
        ContactWrapper contactWrapper = (ContactWrapper) this.cPC.get(i);
        for (ContactWrapper contactWrapper2 : this.cPA) {
            if (contactWrapper.getContact().getContactId() == contactWrapper2.getContact().getContactId()) {
                contactWrapper2.setAdded(false);
                break;
            }
        }
        cP(contactWrapper);
        this.cPr.kB(i);
        if (this.cPC.size() == 0) {
            this.cPr.alL();
        } else {
            this.cPr.mo2273b(0, this.cPC.get(0));
        }
        MFLogger.m12670d(TAG, ".Inside removeContact: contact id = " + contactWrapper.getContact().getContactId() + " ,name=" + contactWrapper.getContact().getDisplayName() + " ,hand=" + contactWrapper.getCurrentHandGroup() + " ,rowId=" + contactWrapper.getContact().getDbRowId());
    }

    public void bY(int i, int i2) {
        MFLogger.m12670d(TAG, ".Inside removeContactInAddFlow at position=" + i + " contactId=" + i2);
        for (ContactWrapper contactWrapper : this.cPA) {
            if (contactWrapper.getContact().getContactId() == i2) {
                contactWrapper.setAdded(false);
                break;
            }
        }
        ContactWrapper contactWrapper2 = null;
        if (contactWrapper2 != null) {
            cP(contactWrapper2);
            this.cPr.kB(i);
            amj();
            MFLogger.m12670d(TAG, ".Inside removeContactInAddFlow: contact id = " + contactWrapper2.getContact().getContactId() + " ,name=" + contactWrapper2.getContact().getDisplayName() + " ,hand=" + contactWrapper2.getCurrentHandGroup() + " ,rowId=" + contactWrapper2.getContact().getDbRowId());
            if (contactWrapper2.getContact().getContactId() != -100 && contactWrapper2.getContact().getContactId() != -200) {
                m8287n("notifications_remove", "Item", "Contacts");
            }
        }
    }

    public void mo2295A(int i, boolean z) {
        if (this.cPC.size() >= 12) {
            this.cPr.alE();
            return;
        }
        AppWrapper appWrapper = (AppWrapper) this.cPB.get(i);
        appWrapper.installedApp.setSelected(true);
        appWrapper.setCurrentHandGroup(this.cPs);
        this.cPC.add(appWrapper);
        this.cPr.kC(i);
        amj();
        MFLogger.m12670d(TAG, ".Inside addApp: app name = " + appWrapper.installedApp.getTitle() + " ,hand=" + appWrapper.getCurrentHandGroup() + " ,rowId=" + appWrapper.installedApp.getDbRowId());
        Object obj = z ? "Search" : "List";
        Map hashMap = new HashMap();
        hashMap.put("Item", appWrapper.installedApp.getTitle());
        hashMap.put("Dest", String.valueOf(this.cPs));
        hashMap.put("Assigned", String.valueOf(this.cPs));
        hashMap.put("Screen", obj);
        m8282f("notifications_apps_set", hashMap);
        m8287n("notifications_apps", "Screen", "Preview");
    }

    public void kv(int i) {
        AppWrapper appWrapper = (AppWrapper) this.cPB.get(i);
        appWrapper.installedApp.setSelected(false);
        this.cPC.remove(appWrapper);
        this.cPr.kD(i);
        amj();
        MFLogger.m12670d(TAG, ".Inside removeAppInAddFlow: app name=" + appWrapper.installedApp.getTitle() + " ,hand=" + appWrapper.getCurrentHandGroup() + " ,item.getCurrentHandGroup() ,rowId=" + appWrapper.installedApp.getDbRowId());
        m8287n("notifications_remove", "Item", "Apps");
    }

    public void kw(int i) {
        AppWrapper appWrapper = (AppWrapper) this.cPC.get(i);
        for (AppWrapper appWrapper2 : this.cPB) {
            if (appWrapper.installedApp.getIdentifier().equalsIgnoreCase(appWrapper2.installedApp.getIdentifier())) {
                appWrapper2.installedApp.setSelected(false);
            }
        }
        this.cPC.remove(appWrapper);
        this.cPr.kD(i);
        if (this.cPC.size() == 0) {
            this.cPr.alL();
        } else {
            this.cPr.mo2273b(0, this.cPC.get(0));
        }
        MFLogger.m12670d(TAG, ".Inside removeApp: app name=" + appWrapper.installedApp.getTitle() + " ,hand=" + appWrapper.getCurrentHandGroup() + " ,rowId=" + appWrapper.installedApp.getDbRowId());
    }

    public void mo2299a(ContactWrapper contactWrapper, int i) {
        MFLogger.m12670d(TAG, ".Inside reassignContact in add flow, at position = " + i);
        this.cPr.mo2256a(contactWrapper, contactWrapper.getCurrentHandGroup(), this.cPs, i);
        MFLogger.m12670d(TAG, ".Inside reassignContact: contact id=" + contactWrapper.getContact().getContactId() + " ,name=" + contactWrapper.getContact().getDisplayName() + " ,hand=" + contactWrapper.getCurrentHandGroup() + " ,rowId=" + contactWrapper.getContact().getDbRowId());
    }

    public void kx(int i) {
        MFLogger.m12670d(TAG, ".Inside reassignContact in edit flow, at position = " + i);
        this.cPr.cb(this.cPs, i);
    }

    public void mo2298a(int i, ContactWrapper contactWrapper) {
        MFLogger.m12670d(TAG, ".Inside confirmedReassignContact at position=" + i);
        if (this.cPC.size() >= 12) {
            this.cPr.alE();
            return;
        }
        contactWrapper.setCurrentHandGroup(this.cPs);
        contactWrapper.setAdded(true);
        this.cPA.add(contactWrapper);
        cQ(contactWrapper);
        this.cPr.kE(i);
        this.cPr.iq(String.format(PortfolioApp.ZQ().getResources().getString(R.string.Notifications_Preview_Toast_Text_contact_was_assigned_to), new Object[]{contactWrapper.getContact().getDisplayName(), String.valueOf(this.cPs)}));
        amj();
        MFLogger.m12670d(TAG, ".Inside confirmedReassignContact: contact id=" + contactWrapper.getContact().getContactId() + " ,name=," + contactWrapper.getContact().getDisplayName() + " ,hand=" + contactWrapper.getCurrentHandGroup() + " ,rowId=" + contactWrapper.getContact().getDbRowId());
    }

    public void bZ(final int i, final int i2) {
        MFLogger.m12670d(TAG, ".Inside confirmedReassignContact at position = " + i + " ,toHand=" + i2);
        this.mUseCaseHandler.m6886a(this.cPx, null, new C2126d<C2678a, C2131a>(this) {
            final /* synthetic */ dcn cPE;

            public /* synthetic */ void onError(Object obj) {
                m8269a((C2131a) obj);
            }

            public /* synthetic */ void onSuccess(Object obj) {
                m8270a((C2678a) obj);
            }

            public void m8270a(C2678a c2678a) {
                MFLogger.m12670d(dcn.TAG, ".Inside mGetAllNotification onSuccess ");
                SparseArray amw = c2678a.amw();
                int i = (amw.get(i2) == null || ((List) amw.get(i2)).isEmpty() || ((List) amw.get(i2)).size() < 12) ? true : 0;
                if (i == 0) {
                    this.cPE.cPr.alE();
                    return;
                }
                ContactWrapper contactWrapper = (ContactWrapper) this.cPE.cPC.get(i);
                for (ContactWrapper contactWrapper2 : this.cPE.cPA) {
                    if (contactWrapper.getContact().getContactId() == contactWrapper2.getContact().getContactId()) {
                        contactWrapper2.setCurrentHandGroup(i2);
                        contactWrapper2.setAdded(true);
                        break;
                    }
                }
                this.cPE.cPC.remove(contactWrapper);
                this.cPE.cPr.kE(i);
                this.cPE.cPr.iq(String.format(PortfolioApp.ZQ().getResources().getString(R.string.Notifications_Preview_Toast_Text_contact_was_assigned_to), new Object[]{contactWrapper.getContact().getDisplayName(), String.valueOf(i2)}));
                if (this.cPE.cPC.size() == 0) {
                    this.cPE.cPr.alL();
                } else {
                    this.cPE.cPr.mo2273b(0, this.cPE.cPC.get(0));
                }
                MFLogger.m12670d(dcn.TAG, ".Inside confirmedReassignContact: contact id=" + contactWrapper.getContact().getContactId() + " ,name=" + contactWrapper.getContact().getDisplayName() + " ,hand=" + contactWrapper.getCurrentHandGroup() + " ,rowId=" + contactWrapper.getContact().getDbRowId());
            }

            public void m8269a(C2131a c2131a) {
                MFLogger.m12670d(dcn.TAG, ".Inside mGetAllNotification onError ");
            }
        });
    }

    public void ky(int i) {
        MFLogger.m12670d(TAG, ".Inside reassignApp at position = " + i);
        AppWrapper appWrapper = (AppWrapper) this.cPB.get(i);
        if (this.cPt) {
            this.cPr.mo2257a(appWrapper.installedApp.getTitle(), appWrapper.getCurrentHandGroup(), this.cPs, i);
        } else {
            this.cPr.cc(this.cPs, i);
        }
        MFLogger.m12670d(TAG, ".Inside reassignApp: app name = " + appWrapper.installedApp.getTitle() + " ,hand=" + appWrapper.getCurrentHandGroup() + " ,rowId=" + appWrapper.installedApp.getDbRowId());
    }

    public void kz(int i) {
        MFLogger.m12670d(TAG, ".Inside confirmedReassignApp at position = " + i);
        if (this.cPC.size() >= 12) {
            this.cPr.alE();
            return;
        }
        AppWrapper appWrapper = (AppWrapper) this.cPB.get(i);
        appWrapper.setCurrentHandGroup(this.cPs);
        appWrapper.installedApp.setSelected(true);
        this.cPC.add(appWrapper);
        this.cPr.kF(i);
        this.cPr.iq(String.format(PortfolioApp.ZQ().getResources().getString(R.string.Notifications_Preview_Toast_Text_contact_was_assigned_to), new Object[]{appWrapper.installedApp.getTitle(), String.valueOf(this.cPs)}));
        amj();
        MFLogger.m12670d(TAG, ".Inside confirmedReassignApp: app name = " + appWrapper.installedApp.getTitle() + " ,hand=" + appWrapper.getCurrentHandGroup() + " ,rowId=" + appWrapper.installedApp.getDbRowId());
    }

    public void ca(final int i, final int i2) {
        MFLogger.m12670d(TAG, ".Inside confirmedReassignApp at position = " + i + " toHand = " + i2);
        this.mUseCaseHandler.m6886a(this.cPx, null, new C2126d<C2678a, C2131a>(this) {
            final /* synthetic */ dcn cPE;

            public /* synthetic */ void onError(Object obj) {
                m8271a((C2131a) obj);
            }

            public /* synthetic */ void onSuccess(Object obj) {
                m8272a((C2678a) obj);
            }

            public void m8272a(C2678a c2678a) {
                MFLogger.m12670d(dcn.TAG, ".Inside mGetAllNotification onSuccess ");
                SparseArray amw = c2678a.amw();
                int i = (amw.get(i2) == null || ((List) amw.get(i2)).isEmpty() || ((List) amw.get(i2)).size() < 12) ? true : 0;
                if (i == 0) {
                    this.cPE.cPr.alE();
                    return;
                }
                AppWrapper appWrapper = (AppWrapper) this.cPE.cPC.get(i);
                for (AppWrapper appWrapper2 : this.cPE.cPB) {
                    if (appWrapper.installedApp.getIdentifier().equalsIgnoreCase(appWrapper2.installedApp.getIdentifier())) {
                        appWrapper2.setCurrentHandGroup(i2);
                        appWrapper2.installedApp.setSelected(true);
                        break;
                    }
                }
                this.cPE.cPC.remove(appWrapper);
                this.cPE.cPr.kF(i);
                this.cPE.cPr.iq(String.format(PortfolioApp.ZQ().getResources().getString(R.string.Notifications_Preview_Toast_Text_contact_was_assigned_to), new Object[]{appWrapper.installedApp.getTitle(), String.valueOf(i2)}));
                if (this.cPE.cPC.size() == 0) {
                    this.cPE.cPr.alL();
                } else {
                    this.cPE.cPr.mo2273b(0, this.cPE.cPC.get(0));
                }
                MFLogger.m12670d(dcn.TAG, ".Inside confirmedReassignApp: app name=" + appWrapper.installedApp.getTitle() + " ,hand=" + appWrapper.getCurrentHandGroup() + " ,rowId=" + appWrapper.installedApp.getDbRowId());
            }

            public void m8271a(C2131a c2131a) {
                MFLogger.m12670d(dcn.TAG, ".Inside mGetAllNotification onError ");
            }
        });
    }

    private void ami() {
        if (this.cPC.size() > 0) {
            if (!this.cPt) {
                this.cPr.alJ();
            }
            if (this.cPC.size() >= 12) {
                this.cPr.alK();
                return;
            }
            return;
        }
        this.cPr.alK();
    }

    public void alz() {
        MFLogger.m12670d(TAG, ".Inside handleTooltips");
        if (this.cPC.size() > 0 && this.cPC.size() <= 12 && !this.cPt) {
            Object obj = this.cPC.get(0);
            if (obj instanceof ContactWrapper) {
                if (((ContactWrapper) obj).getContact().getContactId() == -100 || ((ContactWrapper) obj).getContact().getContactId() == -200) {
                    if (!this.mSharedPreferencesManager.acU()) {
                        this.cPr.alI();
                    }
                } else if (!this.mSharedPreferencesManager.acT()) {
                    this.cPr.alH();
                }
            } else if (!this.mSharedPreferencesManager.acU()) {
                this.cPr.alI();
            }
        }
    }

    public void mo2296B(int i, boolean z) {
        MFLogger.m12670d(TAG, ".Inside handleCallToggle");
        ContactWrapper contactWrapper = (ContactWrapper) this.cPC.get(i);
        for (ContactWrapper contactWrapper2 : this.cPA) {
            if (contactWrapper2.getContact().getContactId() == contactWrapper.getContact().getContactId()) {
                contactWrapper2.getContact().setUseCall(z);
            }
        }
    }

    public void mo2297C(int i, boolean z) {
        MFLogger.m12670d(TAG, ".Inside handleTextToggle");
        ContactWrapper contactWrapper = (ContactWrapper) this.cPC.get(i);
        for (ContactWrapper contactWrapper2 : this.cPA) {
            if (contactWrapper2.getContact().getContactId() == contactWrapper.getContact().getContactId()) {
                contactWrapper2.getContact().setUseSms(z);
            }
        }
    }

    public void alC() {
        MFLogger.m12670d(TAG, ".Inside onPlusClick");
        this.cPt = true;
        this.cPr.alM();
        this.cPr.cF(false);
        amj();
    }

    public void onCancel() {
        MFLogger.m12670d(TAG, ".Inside onCancel");
        if (amk()) {
            this.cPr.alP();
        } else {
            this.cPr.cancel();
        }
    }

    private void amj() {
        if (this.cPC.size() > 0) {
            this.cPr.alO();
        } else {
            this.cPr.alN();
        }
    }

    private boolean amk() {
        if (this.cPD.size() != this.cPC.size()) {
            return true;
        }
        for (Object contains : this.cPC) {
            if (!this.cPD.contains(contains)) {
                return true;
            }
        }
        return false;
    }

    private void m8287n(String str, String str2, String str3) {
        this.cEE.m7086l(str, str2, str3);
    }

    private void m8282f(String str, Map<String, String> map) {
        this.cEE.m7085e(str, map);
    }

    private boolean m8275a(ContactWrapper contactWrapper) {
        for (ContactWrapper contact : this.cPA) {
            if (contact.getContact().getContactId() == contactWrapper.getContact().getContactId()) {
                return true;
            }
        }
        return false;
    }

    private synchronized void cP(Object obj) {
        for (Object next : this.cPC) {
            if ((obj instanceof ContactWrapper) && (next instanceof ContactWrapper) && ((ContactWrapper) obj).getContact().getContactId() == ((ContactWrapper) next).getContact().getContactId()) {
                this.cPC.remove(next);
            }
        }
    }

    private synchronized void cQ(Object obj) {
        this.cPC.add(obj);
    }
}
