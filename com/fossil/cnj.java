package com.fossil;

import android.os.Handler;
import android.os.Looper;
import android.provider.Telephony.Sms;
import android.text.TextUtils;
import android.util.Log;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.fossil.wearables.fsl.appfilter.AppFilter;
import com.fossil.wearables.fsl.contact.Contact;
import com.fossil.wearables.fsl.contact.ContactGroup;
import com.fossil.wearables.fsl.fitness.FitnessProviderImpl;
import com.misfit.frameworks.buttonservice.enums.MFDeviceFamily;
import com.misfit.frameworks.buttonservice.model.CalibrationEnums.HandId;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.AppFilterHistory;
import com.portfolio.platform.data.AppType;
import com.portfolio.platform.data.ContactHistory;
import com.portfolio.platform.data.NotificationSource;
import com.portfolio.platform.data.NotificationType;
import com.portfolio.platform.data.model.LightAndHaptics;
import com.portfolio.platform.data.model.MessageComparator;
import com.portfolio.platform.data.model.NotificationInfo;
import com.portfolio.platform.data.model.NotificationPriority;
import java.util.List;
import java.util.PriorityQueue;

public class cnj {
    private static final String TAG = cnj.class.getSimpleName();
    public static int[] cyX = new int[]{HandId.MINUTE.getValue(), HandId.HOUR.getValue()};
    private static cnj cyY;
    private PriorityQueue<LightAndHaptics> cyZ = new PriorityQueue(5, new MessageComparator());
    private Boolean cza = Boolean.valueOf(false);
    private final Runnable czb = new C22181(this);
    private final Handler handler = new Handler(Looper.getMainLooper());

    class C22181 implements Runnable {
        final /* synthetic */ cnj czc;

        C22181(cnj com_fossil_cnj) {
            this.czc = com_fossil_cnj;
        }

        public void run() {
            this.czc.abT();
        }
    }

    static /* synthetic */ class C22192 {
        static final /* synthetic */ int[] czd = new int[NotificationSource.values().length];

        static {
            try {
                czd[NotificationSource.TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                czd[NotificationSource.CALL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    private cnj() {
    }

    public static cnj abR() {
        if (cyY == null) {
            cyY = new cnj();
        }
        return cyY;
    }

    public void m7205a(NotificationInfo notificationInfo) {
        Log.i(TAG, "notification info : " + notificationInfo.getSource());
        Log.i(TAG, "notification body : " + notificationInfo.getBody());
        Log.i(TAG, "notification type : " + notificationInfo.getSource().toString());
        Log.e(TAG, "notification - info=" + notificationInfo.toString());
        if (notificationInfo.getSource() == NotificationSource.CALL || notificationInfo.getSource() == NotificationSource.TEXT || notificationInfo.getSource() == NotificationSource.MAIL) {
            if (!m7200b(notificationInfo)) {
                if (notificationInfo.getSource() == NotificationSource.CALL) {
                    m7202d(notificationInfo);
                } else if (notificationInfo.getSource() == NotificationSource.TEXT) {
                    m7203e(notificationInfo);
                } else if (notificationInfo.getSource() == NotificationSource.MAIL) {
                    m7201c(notificationInfo);
                }
            }
        } else if (notificationInfo.getSource() == NotificationSource.OS) {
            m7204f(notificationInfo);
        }
    }

    private boolean m7200b(NotificationInfo notificationInfo) {
        List b;
        List b2;
        LightAndHaptics lightAndHaptics = null;
        if (notificationInfo.getSource() == NotificationSource.TEXT) {
            b = drd.auo().m9457b("-5678", MFDeviceFamily.DEVICE_FAMILY_SAM);
            if (!TextUtils.isEmpty(notificationInfo.getSenderInfo())) {
                b2 = drd.auo().m9457b(notificationInfo.getSenderInfo(), MFDeviceFamily.DEVICE_FAMILY_SAM);
            }
            b2 = null;
        } else if (notificationInfo.getSource() == NotificationSource.CALL) {
            b = drd.auo().m9458c("-1234", MFDeviceFamily.DEVICE_FAMILY_SAM);
            if (!TextUtils.isEmpty(notificationInfo.getSenderInfo())) {
                b2 = drd.auo().m9458c(notificationInfo.getSenderInfo(), MFDeviceFamily.DEVICE_FAMILY_SAM);
            }
            b2 = null;
        } else {
            b = null;
            b2 = null;
        }
        if (b != null && b2 != null && b2.isEmpty() && b.isEmpty()) {
            if (abU()) {
                m7204f(notificationInfo);
                MFLogger.m12670d(TAG, ".Inside checkAgainstContacts, NO assigned contact with this phone number, NO ALL-TEXT, let Message fire");
            }
            return false;
        } else if (b2 == null && b == null) {
            return false;
        } else {
            if (b2 == null || b2.size() <= 0) {
                switch (C22192.czd[notificationInfo.getSource().ordinal()]) {
                    case 1:
                        lightAndHaptics = m7196a("-5678", b, notificationInfo.getSource());
                        MFLogger.m12670d(TAG, "ALL TEXT with " + notificationInfo.getSenderInfo() + " body " + notificationInfo.getBody() + " matchcontact is " + lightAndHaptics);
                        break;
                    case 2:
                        lightAndHaptics = m7196a("-1234", b, notificationInfo.getSource());
                        MFLogger.m12670d(TAG, "ALL CALL with " + notificationInfo.getSenderInfo() + " body " + notificationInfo.getBody() + " matchcontact is " + lightAndHaptics);
                        break;
                    default:
                        break;
                }
            }
            lightAndHaptics = m7196a(notificationInfo.getSenderInfo(), b2, notificationInfo.getSource());
            MFLogger.m12670d(TAG, "checkAgainstContacts with " + notificationInfo.getSenderInfo() + " body " + notificationInfo.getBody() + " matchcontact is " + lightAndHaptics);
            if (lightAndHaptics == null) {
                return false;
            }
            m7198a(lightAndHaptics);
            return true;
        }
    }

    private void m7201c(NotificationInfo notificationInfo) {
        MFLogger.m12671e(TAG, "Check again email with senderInfo " + notificationInfo.getSenderInfo() + " and body " + notificationInfo.getBody());
        LightAndHaptics at = at(AppType.ALL_EMAIL.name(), notificationInfo.getBody());
        if (at != null) {
            m7198a(at);
        }
    }

    private void m7202d(NotificationInfo notificationInfo) {
        Log.e(TAG, "Check again phone with senderInfo " + notificationInfo.getSenderInfo() + " and body " + notificationInfo.getBody());
        LightAndHaptics at = at(AppType.ALL_CALLS.name(), notificationInfo.getSenderInfo());
        if (at != null) {
            at.setNotificationType(NotificationType.CALL);
            m7198a(at);
        }
    }

    private void m7203e(NotificationInfo notificationInfo) {
        Log.e(TAG, "Check again sms with senderInfo " + notificationInfo.getSenderInfo() + " and body " + notificationInfo.getBody());
        LightAndHaptics at = at(AppType.ALL_SMS.name(), notificationInfo.getBody());
        if (at != null) {
            at.setNotificationType(NotificationType.SMS);
            m7198a(at);
        }
    }

    private void m7204f(NotificationInfo notificationInfo) {
        Log.i(TAG, "PACKAGE CHECK : " + notificationInfo.getPackageName());
        if (!TextUtils.isEmpty(notificationInfo.getPackageName())) {
            LightAndHaptics at = at(notificationInfo.getPackageName(), notificationInfo.getBody());
            if (at != null) {
                at.setNotificationType(NotificationType.APP_FILTER);
                m7198a(at);
            }
        }
    }

    private void m7198a(LightAndHaptics lightAndHaptics) {
        if (this.cyZ.size() < 5) {
            this.cyZ.add(lightAndHaptics);
            Log.i(TAG, "addEventToQueue : " + lightAndHaptics.getType());
            if (!this.cza.booleanValue()) {
                this.cza = Boolean.valueOf(true);
                abS();
            }
        }
    }

    private void abS() {
        if (this.cyZ.isEmpty()) {
            this.cza = Boolean.valueOf(false);
            return;
        }
        m7199b((LightAndHaptics) this.cyZ.remove());
        Log.d(TAG, "Total duration: " + 500);
        this.handler.postDelayed(this.czb, 500);
    }

    private void abT() {
        Log.i(TAG, "Check the  : " + this.cyZ.size());
        if (this.cyZ.size() > 0) {
            this.cza = Boolean.valueOf(true);
            abS();
            return;
        }
        this.cza = Boolean.valueOf(false);
    }

    private LightAndHaptics m7196a(String str, List<ContactGroup> list, NotificationSource notificationSource) {
        if (list != null && list.size() > 0) {
            ContactGroup contactGroup = (ContactGroup) list.get(0);
            Contact contactWithPhoneNumber = contactGroup.getContactWithPhoneNumber(str);
            String firstName = contactWithPhoneNumber.getFirstName();
            if (!(TextUtils.isEmpty(contactWithPhoneNumber.getLastName()) || contactWithPhoneNumber.getLastName().equalsIgnoreCase("null"))) {
                firstName = firstName + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + contactWithPhoneNumber.getLastName();
            }
            ContactHistory contactHistory = new ContactHistory();
            contactHistory.setName(firstName);
            contactHistory.setColor(contactGroup.getColor());
            contactHistory.setHaptic(contactGroup.getHaptic());
            contactHistory.setTitle(contactGroup.getName());
            contactHistory.setPhotoThumbUri(contactWithPhoneNumber.getPhotoThumbUri());
            contactHistory.setSource(notificationSource.name());
            switch (C22192.czd[notificationSource.ordinal()]) {
                case 1:
                    return new LightAndHaptics("", NotificationType.SMS, firstName, contactGroup.getHour(), NotificationPriority.ENTOURAGE_SMS);
                case 2:
                    return new LightAndHaptics("", NotificationType.CALL, firstName, contactGroup.getHour(), NotificationPriority.ENTOURAGE_CALL);
            }
        }
        return null;
    }

    private LightAndHaptics at(String str, String str2) {
        Log.d(TAG, "Attepting to match app " + str);
        AppFilter a = drc.aun().m9455a(str, MFDeviceFamily.DEVICE_FAMILY_SAM);
        if (a == null) {
            return null;
        }
        String str3 = "";
        AppFilterHistory appFilterHistory = new AppFilterHistory(str3);
        appFilterHistory.setColor(a.getColor());
        appFilterHistory.setHaptic(a.getHaptic());
        appFilterHistory.setTitle(a.getName());
        appFilterHistory.setSubTitle(str2);
        appFilterHistory.setType(a.getType());
        NotificationType notificationType = NotificationType.APP_FILTER;
        if (str.equals(AppType.ALL_CALLS.name())) {
            notificationType = NotificationType.CALL;
        } else if (str.equals(AppType.ALL_SMS.name())) {
            notificationType = NotificationType.SMS;
        } else if (str.equals(AppType.ALL_EMAIL.name())) {
            notificationType = NotificationType.EMAIL;
        }
        return new LightAndHaptics(str, notificationType, str3, a.getHour(), NotificationPriority.APP_FILTER);
    }

    private void m7199b(LightAndHaptics lightAndHaptics) {
        PortfolioApp.ZQ().m12687a(lightAndHaptics.getType(), PortfolioApp.ZQ().aaa(), (int) FitnessProviderImpl.DEFAULT_DAILY_STEP_GOAL, cyX, new int[]{cnf.jE(lightAndHaptics.getHour()), cnf.jE(lightAndHaptics.getHour())}, false);
    }

    private boolean abU() {
        for (AppFilter type : cnq.acd().acm().getAllAppFilters()) {
            if (type.getType().equalsIgnoreCase(Sms.getDefaultSmsPackage(PortfolioApp.ZQ()))) {
                MFLogger.m12670d(TAG, ".Inside hasMessageApp, return true");
                return true;
            }
        }
        MFLogger.m12670d(TAG, ".Inside hasMessageApp, return false");
        return false;
    }
}
