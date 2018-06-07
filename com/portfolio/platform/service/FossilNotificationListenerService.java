package com.portfolio.platform.service;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Telephony.Sms;
import android.service.notification.NotificationListenerService;
import android.service.notification.NotificationListenerService.Ranking;
import android.service.notification.NotificationListenerService.RankingMap;
import android.service.notification.StatusBarNotification;
import android.support.v8.renderscript.Allocation;
import android.text.TextUtils;
import android.util.SparseArray;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.fossil.cnj;
import com.fossil.cnq;
import com.fossil.dre;
import com.fossil.euj;
import com.fossil.wearables.fsl.contact.Contact;
import com.fossil.wearables.fsl.contact.ContactGroup;
import com.misfit.frameworks.buttonservice.enums.MFDeviceFamily;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.NotificationSource;
import com.portfolio.platform.data.model.NotificationInfo;
import com.portfolio.platform.helper.DeviceHelper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

@SuppressLint({"OverrideAbstract"})
public class FossilNotificationListenerService extends NotificationListenerService {
    private static final String TAG = FossilNotificationListenerService.class.getSimpleName();
    private static final String[] cCF = new String[]{"android.title", "android.title.big", "android.text", "android.subText", "android.infoText", "android.summaryText", "android.bigText"};
    private Runnable Dc = new C49151(this);
    private final StringBuilder cCD = new StringBuilder();
    private final SparseArray<C4916a> cCE = new SparseArray();
    private HashSet<String> cCG = new HashSet();
    private ConcurrentLinkedQueue<StatusBarNotification> cCH = new ConcurrentLinkedQueue();
    private Handler mHandler = new Handler();

    class C49151 implements Runnable {
        final /* synthetic */ FossilNotificationListenerService cCI;

        C49151(FossilNotificationListenerService fossilNotificationListenerService) {
            this.cCI = fossilNotificationListenerService;
        }

        public void run() {
            MFLogger.d(FossilNotificationListenerService.TAG, "Running runnable");
            this.cCI.aeY();
        }
    }

    static class C4916a {
        private int hashCode;
        private final int id;
        private final String packageName;
        private final String text;
        private final long timestamp;

        private C4916a(String str, String str2, int i, long j) {
            this.hashCode = -1;
            this.packageName = str;
            this.text = str2;
            this.id = i;
            this.timestamp = j;
        }

        public long getTimestamp() {
            return this.timestamp;
        }

        public int hashCode() {
            if (this.hashCode == -1) {
                this.hashCode = (this.packageName + this.id).hashCode();
            }
            return this.hashCode;
        }

        public boolean equals(Object obj) {
            return (obj instanceof C4916a) && this.packageName.equals(((C4916a) obj).packageName) && this.text.equals(((C4916a) obj).text) && this.id == ((C4916a) obj).id;
        }

        public String toString() {
            return this.id + " | " + this.packageName + " | " + this.text;
        }
    }

    public void onCreate() {
        super.onCreate();
        MFLogger.d(TAG, "Notification Listener Service Created");
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        MFLogger.d(TAG, "Notification Listener Service Started");
        return super.onStartCommand(intent, i, i2);
    }

    public void onDestroy() {
        super.onDestroy();
        MFLogger.d(TAG, "Notification Listener Service Destroyed");
    }

    public void onNotificationPosted(StatusBarNotification statusBarNotification, RankingMap rankingMap) {
        MFLogger.d(TAG, "Receive notification with notification permission enable is " + dre.dff.auE());
        if (VERSION.SDK_INT >= 21) {
            try {
                Ranking ranking = new Ranking();
                if (rankingMap.getRanking(statusBarNotification.getKey(), ranking) && !ranking.matchesInterruptionFilter()) {
                    MFLogger.d(TAG, "Block due to do not disturb");
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (DeviceHelper.gc(PortfolioApp.ZQ().aaa())) {
            m15662a(statusBarNotification);
        }
    }

    private void m15662a(StatusBarNotification statusBarNotification) {
        MFLogger.d(TAG, "Adding to queue");
        this.cCH.add(statusBarNotification);
        this.mHandler.removeCallbacks(this.Dc);
        this.mHandler.postDelayed(this.Dc, (long) MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
    }

    private boolean m15664a(StatusBarNotification statusBarNotification, List<StatusBarNotification> list) {
        boolean z = true;
        if (m15666b(statusBarNotification) && VERSION.SDK_INT >= 21) {
            boolean z2 = true;
            for (int i = 0; i < list.size(); i++) {
                String groupKey = statusBarNotification.getGroupKey();
                String groupKey2 = ((StatusBarNotification) list.get(i)).getGroupKey();
                String group = statusBarNotification.getNotification().getGroup();
                String group2 = ((StatusBarNotification) list.get(i)).getNotification().getGroup();
                if (!(groupKey == null || groupKey2 == null || !groupKey.equalsIgnoreCase(groupKey2))) {
                    z2 = false;
                }
                if (!(group == null || group2 == null || !group.equalsIgnoreCase(group2))) {
                    z2 = false;
                }
            }
            z = z2;
        }
        MFLogger.d(TAG, "Notification summary is alone = " + z);
        return z;
    }

    private void aeY() {
        MFLogger.d(TAG, "Filtering queue with " + this.cCH.size() + " items");
        List arrayList = new ArrayList(this.cCH.size());
        arrayList.addAll(this.cCH);
        List arrayList2 = new ArrayList();
        this.cCH.clear();
        Set hashSet = new HashSet();
        for (int i = 0; i < arrayList.size(); i++) {
            StatusBarNotification statusBarNotification = (StatusBarNotification) arrayList.get(i);
            MFLogger.d(TAG, "Looking at:");
            boolean a = m15664a(statusBarNotification, arrayList2);
            if (hashSet.contains(statusBarNotification.getPackageName())) {
                MFLogger.d(TAG, "This notification is processing");
                a = false;
            }
            if (a) {
                MFLogger.d(TAG, "Allowing notification to process...");
                arrayList2.add(statusBarNotification);
                if (m15667c(statusBarNotification)) {
                    hashSet.add(statusBarNotification.getPackageName());
                }
            } else {
                MFLogger.d(TAG, "Blocking notification from processing");
            }
        }
    }

    private boolean m15666b(StatusBarNotification statusBarNotification) {
        return (statusBarNotification.getNotification().flags & 512) == 512;
    }

    private boolean m15667c(StatusBarNotification statusBarNotification) {
        if (statusBarNotification == null) {
            return false;
        }
        Notification notification = statusBarNotification.getNotification();
        if (notification == null) {
            return false;
        }
        if (notification.priority < -1) {
            MFLogger.d(TAG, "Ignoring Min priority notification");
            return false;
        } else if (statusBarNotification.getNotification().extras == null || statusBarNotification.getNotification().extras.getInt("android.progressMax", 0) != 0) {
            MFLogger.d(TAG, "Ignoring Progress notification");
            return false;
        } else {
            String str;
            m15668d(statusBarNotification);
            Bundle bundle = notification.extras;
            this.cCD.setLength(0);
            this.cCG.clear();
            for (String str2 : cCF) {
                Object obj = bundle.get(str2);
                MFLogger.d(TAG, "Looking at " + str2 + " : " + obj + " : class " + (obj != null ? obj.getClass().getSimpleName() : "null"));
                if ((obj instanceof CharSequence) && !TextUtils.isEmpty((CharSequence) obj)) {
                    MFLogger.d(TAG, "Adding " + str2 + " with value of " + obj);
                    hx(obj.toString());
                }
            }
            MFLogger.d(TAG, "Ticker Text = " + notification.tickerText);
            if (!TextUtils.isEmpty(notification.tickerText)) {
                hx(notification.tickerText.toString());
            }
            String charSequence = bundle.getCharSequence("android.title", "").toString();
            String trim = this.cCD.toString().trim();
            C4916a c4916a = new C4916a(statusBarNotification.getPackageName(), trim, statusBarNotification.getId(), System.currentTimeMillis());
            if (m15665a(c4916a)) {
                return false;
            }
            this.cCE.put(c4916a.hashCode(), c4916a);
            PackageManager packageManager = getPackageManager();
            try {
                str2 = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(statusBarNotification.getPackageName(), Allocation.USAGE_SHARED));
            } catch (Exception e) {
                MFLogger.e(TAG, "Could not find app name?");
                str2 = "";
            }
            MFLogger.d(TAG, "We are going to analyze this notification string: " + trim);
            MFLogger.d(TAG, "From " + str2);
            NotificationInfo notificationInfo = new NotificationInfo(NotificationSource.OS, charSequence, trim, statusBarNotification.getPackageName(), str2);
            if (!notificationInfo.getPackageName().equalsIgnoreCase(Sms.getDefaultSmsPackage(PortfolioApp.ZQ()))) {
                cnj.abR().a(notificationInfo);
                MFLogger.d(TAG, ".Inside processNotification, not SMS app, add to Queue");
            } else if (aeZ()) {
                MFLogger.d(TAG, ".Inside processNotification, ignore SMS app");
            } else {
                cnj.abR().a(notificationInfo);
                MFLogger.d(TAG, ".Inside processNotification, is SMS app, ALL TEXT not exist OR not has at least 1 contact use SMS, add to Queue");
            }
            afa();
            return true;
        }
    }

    private boolean aeZ() {
        for (ContactGroup contacts : cnq.acd().ack().getAllContactGroups(MFDeviceFamily.DEVICE_FAMILY_SAM.getValue())) {
            for (Contact contact : contacts.getContacts()) {
                if (contact.getContactId() != -200) {
                    if (contact.isUseSms()) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    private boolean m15665a(C4916a c4916a) {
        MFLogger.d(TAG, "isBlockedNotification() - thisNotification.hashCode() = " + c4916a.hashCode());
        C4916a c4916a2 = (C4916a) this.cCE.get(c4916a.hashCode());
        if (c4916a2 != null) {
            MFLogger.d(TAG, "We have an old notification with the same hash");
            if (c4916a.timestamp - c4916a2.timestamp > 10000) {
                MFLogger.d(TAG, "We are older than 10000 milliseconds. Allow update to this notification");
            } else {
                MFLogger.d(TAG, "Block duplicate notification in " + euj.bm(Math.abs(10000 - (c4916a.timestamp - c4916a2.timestamp))) + ", notification: " + c4916a.toString());
                return true;
            }
        }
        return false;
    }

    private void afa() {
        long currentTimeMillis = System.currentTimeMillis();
        int size = this.cCE.size();
        MFLogger.d(TAG, "Clean past notifications. Size = " + size);
        List<Integer> linkedList = new LinkedList();
        for (int i = 0; i < size; i++) {
            int keyAt = this.cCE.keyAt(i);
            if (this.cCE.get(keyAt) != null && currentTimeMillis - ((C4916a) this.cCE.get(keyAt)).getTimestamp() > 10000) {
                MFLogger.d(TAG, "Adding key to remove - key = " + keyAt);
                linkedList.add(Integer.valueOf(keyAt));
            }
        }
        for (Integer num : linkedList) {
            MFLogger.d(TAG, "Dumping old notification");
            this.cCE.remove(num.intValue());
        }
    }

    private void hx(String str) {
        if (!this.cCG.contains(str)) {
            Iterator it = this.cCG.iterator();
            while (it.hasNext()) {
                if (((String) it.next()).contains(str)) {
                    return;
                }
            }
            this.cCD.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            this.cCD.append(str);
            this.cCG.add(str);
        }
    }

    private void m15668d(StatusBarNotification statusBarNotification) {
        String packageName = statusBarNotification.getPackageName();
        Notification notification = statusBarNotification.getNotification();
        Bundle bundle = notification.extras;
        String str = "";
        if (!TextUtils.isEmpty(notification.tickerText)) {
            str = notification.tickerText.toString();
        }
        CharSequence charSequence = bundle.getCharSequence("android.title");
        MFLogger.d(TAG, "Notification \n package name: " + packageName + "\n ticker: " + str + "\n title: " + charSequence + "\n subtext: " + bundle.getCharSequence("android.subText") + "\n text: " + bundle.getCharSequence("android.text"));
    }
}
