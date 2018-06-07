package com.portfolio.platform.data;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.v8.renderscript.Allocation;
import android.util.Log;
import com.facebook.messenger.MessengerUtils;
import com.fossil.arp;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.InstalledApp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public enum AppType {
    BADOO(-1, "com.badoo.mobile"),
    CLOCK(R.string.app_clock, ""),
    ESPN(-1, "com.espn.score_center"),
    FACEBOOK(-1, "com.facebook.katana"),
    FACEBOOK_MESSENGER(-1, MessengerUtils.PACKAGE_NAME),
    FLICKR(-1, "com.yahoo.mobile.client.android.flickr"),
    FOURSQUARE(-1, "com.joelapenna.foursquared"),
    GMAIL(-1, "com.google.android.gm"),
    GOOGLE_PLUS(-1, "com.google.android.apps.plus"),
    GOOGLE_INBOX(-1, "com.google.android.apps.inbox"),
    HANGOUTS(-1, "com.google.android.talk"),
    HIPCHAT(-1, "com.hipchat"),
    INSTAGRAM(-1, "com.instagram.android"),
    KAKAO(-1, "com.kakao.talk"),
    LINE(-1, "jp.naver.line.android"),
    LYNC(-1, "com.microsoft.office.lync15"),
    MESSAGING(-1, "com.android.mms"),
    PANDORA(-1, "com.pandora.android"),
    PINTEREST(-1, "com.pinterest"),
    SHAZAM(-1, "com.shazam.android"),
    SINA_WEIBO(-1, "com.sina.weibo"),
    SKYPE(-1, "com.skype.raider"),
    SLACK(-1, "com.Slack"),
    SNAPCHAT(-1, "com.snapchat.android"),
    SPOTIFY(-1, "com.spotify.music"),
    SWARM(-1, "com.foursquare.robin"),
    TUMBLR(-1, "com.tumblr"),
    TWITTER(-1, "com.twitter.android"),
    UBER(-1, "com.ubercab"),
    VIADEO(-1, "com.viadeo.android"),
    WECHAT(-1, "com.tencent.mm"),
    WHATSAPP(-1, "com.whatsapp"),
    ALL_SMS(R.string.app_all_sms, ""),
    ALL_EMAIL(R.string.Onboarding_Account_Signup_Email_Input_Email, ""),
    ALL_CALLS(R.string.app_all_calls, "");
    
    private final String packageName;
    private final int titleResId;

    private AppType(int i, String str) {
        this.titleResId = i;
        this.packageName = str;
    }

    public int getAppResId() {
        return this.titleResId;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public boolean isInstalled(Context context) {
        return isInstalled(context, this.packageName);
    }

    public static boolean isInstalled(Context context, String str) {
        if (context.getPackageManager().getLaunchIntentForPackage(str) != null) {
            return true;
        }
        return false;
    }

    public static List<InstalledApp> getInstalledWhiteListedApps(Context context) {
        PackageManager packageManager = context.getPackageManager();
        List<ApplicationInfo> installedApplications = packageManager.getInstalledApplications(Allocation.USAGE_SHARED);
        List<InstalledApp> arrayList = new ArrayList();
        InstalledApp installedApp = new InstalledApp(ALL_CALLS.name(), arp.u(PortfolioApp.ZQ(), ALL_CALLS.getAppResId()), Boolean.valueOf(false));
        arrayList.add(new InstalledApp(ALL_SMS.name(), arp.u(PortfolioApp.ZQ(), ALL_SMS.getAppResId()), Boolean.valueOf(false)));
        arrayList.add(installedApp);
        Set hashSet = new HashSet();
        Set hashSet2 = new HashSet();
        for (AppType appType : values()) {
            if (appType.getAppResId() > -1) {
                hashSet2.add(arp.u(PortfolioApp.ZQ(), appType.getAppResId()));
            } else {
                hashSet.add(appType.getPackageName());
            }
        }
        for (ApplicationInfo applicationInfo : installedApplications) {
            if (packageManager.getLaunchIntentForPackage(applicationInfo.packageName) != null) {
                Log.d("", "Installed package :" + packageManager.getApplicationLabel(applicationInfo) + " - " + applicationInfo.packageName);
                String charSequence = packageManager.getApplicationLabel(applicationInfo).toString();
                String str = applicationInfo.packageName;
                if (hashSet.contains(str) || hashSet2.contains(charSequence)) {
                    arrayList.add(new InstalledApp(str, charSequence, Boolean.valueOf(false)));
                }
            }
        }
        return arrayList;
    }
}
