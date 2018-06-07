package com.portfolio.platform.util;

import android.text.TextUtils;
import com.fossil.dqp;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.helper.DeviceHelper;
import java.util.Locale;

public class URLHelper {

    public enum Feature {
        USING_YOUR_WATCH,
        LOW_BATTERY,
        SHOP_BATTERY,
        HOUR_TIME_24,
        ACTIVITY,
        ALARM,
        DATE,
        NOTIFICATIONS,
        Q_LINK,
        SECOND_TIME_ZONE,
        GOAL_TRACKING,
        CUSTOMIZE_DEVICE,
        STOP_WATCH
    }

    public enum StaticPage {
        PRIVACY,
        SUPPORT,
        STORE,
        TERMS,
        CALL,
        FEATURES,
        REPAIR_CENTER,
        DEVICE_FEATURE,
        CHAT
    }

    public static String m15812a(StaticPage staticPage, Feature feature) {
        return m15813a(staticPage, feature, null);
    }

    public static String m15813a(StaticPage staticPage, Feature feature, String str) {
        StringBuilder stringBuilder = new StringBuilder(dqp.lx(1));
        if (TextUtils.isEmpty(str)) {
            str = PortfolioApp.ZQ().aaa();
        }
        switch (staticPage) {
            case CHAT:
                return "http://chat.fossil.com/chat/";
            case PRIVACY:
                stringBuilder.append("/privacy");
                break;
            case SUPPORT:
                stringBuilder.append("/support");
                break;
            case STORE:
                stringBuilder.append("/store");
                break;
            case TERMS:
                stringBuilder.append("/terms");
                break;
            case REPAIR_CENTER:
                stringBuilder.append("/service_centers");
                break;
            case CALL:
                stringBuilder.append("/call");
                break;
            case DEVICE_FEATURE:
                stringBuilder.append("/device_features/customize_device");
                break;
            case FEATURES:
                stringBuilder.append(DeviceHelper.ge(str) ? "/tracker" : "/hybrid");
                switch (feature) {
                    case USING_YOUR_WATCH:
                        stringBuilder.append("/using_your_watch");
                        break;
                    case LOW_BATTERY:
                        stringBuilder.append("/low_battery");
                        break;
                    case SHOP_BATTERY:
                        stringBuilder.append("/shop_battery");
                        break;
                    case HOUR_TIME_24:
                        stringBuilder.append("/24_hour_time");
                        break;
                    case ACTIVITY:
                        stringBuilder.append("/activity");
                        break;
                    case ALARM:
                        stringBuilder.append("/alarm");
                        break;
                    case DATE:
                        stringBuilder.append("/date");
                        break;
                    case NOTIFICATIONS:
                        stringBuilder.append("/notifications");
                        break;
                    case Q_LINK:
                        stringBuilder.append("/link");
                        break;
                    case SECOND_TIME_ZONE:
                        stringBuilder.append("/second_time_zone");
                        break;
                    case GOAL_TRACKING:
                        stringBuilder.append("/service_centers");
                        break;
                    case CUSTOMIZE_DEVICE:
                        stringBuilder.append("/customize_device");
                        break;
                    case STOP_WATCH:
                        stringBuilder.append("/stopwatch");
                        break;
                    default:
                        break;
                }
        }
        String str2 = "2";
        String str3 = "?locale=%s&platform=android&serialNumber=%s&version=%s";
        Object[] objArr = new Object[3];
        objArr[0] = getLocale();
        if (str == null) {
            str = "";
        }
        objArr[1] = str;
        objArr[2] = str2;
        stringBuilder.append(String.format(str3, objArr));
        return stringBuilder.toString();
    }

    private static String getLocale() {
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        CharSequence country = locale.getCountry();
        if (TextUtils.isEmpty(language)) {
            return "";
        }
        if (TextUtils.isEmpty(country)) {
            return language;
        }
        return String.format(Locale.US, "%s_%s", new Object[]{language, country});
    }
}
