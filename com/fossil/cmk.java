package com.fossil;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.MediaStore.Audio.Media;
import android.text.TextUtils;
import android.util.Log;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.fossil.wearables.fossil.R;
import com.j256.ormlite.field.FieldType;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.DeviceModel;
import com.portfolio.platform.data.model.MFUser;
import com.portfolio.platform.data.model.Ringtone;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class cmk {
    private static cmk cxC;
    private static List<Ringtone> cxD = new ArrayList();

    public static class C2196a implements Comparable {
        public String cxE = "";
        public String cxF = "";
        public Uri uri;
        public int versionCode = 0;
        public String versionName = "";

        public int compareTo(Object obj) {
            return this.cxE.compareTo((String) obj);
        }
    }

    private cmk() {
    }

    public static synchronized cmk abE() {
        cmk com_fossil_cmk;
        synchronized (cmk.class) {
            if (cxC == null) {
                cxC = new cmk();
            }
            com_fossil_cmk = cxC;
        }
        return com_fossil_cmk;
    }

    public static ArrayList<C2196a> bt(Context context) {
        return m7089h(context, false);
    }

    private static ArrayList<C2196a> m7089h(Context context, boolean z) {
        ArrayList<C2196a> arrayList = new ArrayList();
        Intent intent = new Intent("android.intent.action.MAIN", null);
        intent.addCategory("android.intent.category.LAUNCHER");
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        PackageManager packageManager = context.getPackageManager();
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            if (!(resolveInfo.loadLabel(packageManager).toString().equalsIgnoreCase("Contacts") || resolveInfo.loadLabel(packageManager).toString().equalsIgnoreCase("Phone"))) {
                C2196a c2196a = new C2196a();
                c2196a.cxE = resolveInfo.loadLabel(context.getPackageManager()).toString();
                c2196a.cxF = resolveInfo.activityInfo.packageName;
                try {
                    ApplicationInfo applicationInfo = packageManager.getApplicationInfo(c2196a.cxF, 0);
                    if (applicationInfo.icon != 0) {
                        c2196a.uri = Uri.parse("android.resource://" + c2196a.cxF + "/" + applicationInfo.icon);
                    }
                } catch (NameNotFoundException e) {
                    e.printStackTrace();
                }
                arrayList.add(c2196a);
            }
        }
        return arrayList;
    }

    public static synchronized List<Ringtone> abF() {
        List<Ringtone> list;
        synchronized (cmk.class) {
            MFLogger.m12670d("AppHelper", "getListRingtoneFromRingtonePhone");
            if (cxD.isEmpty()) {
                try {
                    String[] strArr = new String[]{FieldType.FOREIGN_ID_FIELD_SUFFIX, "title", "\"" + Media.INTERNAL_CONTENT_URI + "\"", "title_key"};
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("(");
                    stringBuilder.append(Collections.singletonList("is_ringtone")).append("=1 or ");
                    stringBuilder.setLength(stringBuilder.length() - 4);
                    stringBuilder.append(")");
                    m7088e(PortfolioApp.ZQ().getContentResolver().query(Media.INTERNAL_CONTENT_URI, strArr, stringBuilder.toString(), null, "title_key"));
                } catch (Exception e) {
                    MFLogger.m12671e("AppHelper", "getListRingtoneFromRingtonePhone - Exception=" + e);
                }
                list = cxD;
            } else {
                list = cxD;
            }
        }
        return list;
    }

    private static void m7088e(Cursor cursor) {
        MFLogger.m12670d("AppHelper", "readCursorRingtone - cursor=" + cursor);
        if (cursor != null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            MFLogger.m12670d("AppHelper", "readCursorRingtone - step1");
            while (cursor.moveToNext()) {
                try {
                    mediaPlayer.reset();
                    mediaPlayer.setDataSource(PortfolioApp.ZQ(), Uri.parse(cursor.getString(2).concat("/").concat(cursor.getString(0))));
                    mediaPlayer.prepare();
                    if (mediaPlayer.getDuration() < 30000) {
                        cxD.add(new Ringtone(cursor.getString(0), cursor.getString(1)));
                    }
                } catch (IllegalArgumentException e) {
                    MFLogger.m12671e("AppHelper", "readCursorRingtone - IllegalArgumentException=" + e);
                } catch (Exception e2) {
                    MFLogger.m12671e("AppHelper", "readCursorRingtone - Exception=" + e2);
                    cxD.add(new Ringtone(cursor.getString(0), cursor.getString(1)));
                }
            }
            MFLogger.m12670d("AppHelper", "readCursorRingtone - step2");
            mediaPlayer.release();
            cursor.close();
        }
    }

    public static String fV(String str) {
        return Build.SERIAL + ":" + str;
    }

    public String m7092d(Context context, int i, int i2) {
        String str;
        MFUser currentUser = cnq.acd().ace().getCurrentUser();
        DeviceModel hd = cnq.acd().acp().hd(PortfolioApp.ZQ().aaa());
        TimeZone timeZone = TimeZone.getDefault();
        String str2 = "";
        if (hd != null) {
            CharSequence sku = hd.getSku();
            CharSequence firmwareRevision = hd.getFirmwareRevision();
            int batteryLevel = hd.getBatteryLevel();
            DeviceModel hd2 = cnq.acd().acp().hd(hd.getDeviceId());
            CharSequence charSequence;
            if (hd2 != null) {
                if (TextUtils.isEmpty(sku)) {
                    sku = hd2.getSku();
                }
                if (TextUtils.isEmpty(firmwareRevision)) {
                    firmwareRevision = hd2.getFirmwareRevision();
                }
                if (batteryLevel <= 0) {
                    batteryLevel = hd2.getBatteryLevel();
                }
                charSequence = firmwareRevision;
                str = sku;
                str2 = charSequence;
            } else {
                charSequence = firmwareRevision;
                firmwareRevision = sku;
                sku = charSequence;
            }
            str2 = "Serial: " + hd.getDeviceId() + "\nModel: " + str + "\nFW: " + str2 + "\nLatest Firmware: " + hd.getFirmwareRevision() + "\nBatteryLevel: " + batteryLevel;
        }
        str = "";
        String str3 = "";
        String str4 = "";
        if (currentUser != null) {
            str = currentUser.getEmail();
            str3 = currentUser.getUserId();
        }
        String str5 = "Tags: ";
        if (i2 != -1) {
            switch (i2) {
                case 0:
                    str4 = str4 + "Hardware/FW\nDid the device have any form of feedback such as hands-movement, vibe, led-flashing when you press/tap on it?\n*Note: if there's none, pls replace the battery. If the issue persist, report it as FW/HW issue.\nWhat's the connection status in phone's Bluetooth settings?\n\nDisconnected → Was you able to find the device with another phone, using either nRF or ShineSample?\n\nNo → move away from everyone and try sync again.\nIt works → it's probably someone else was connected to your watch.\nNo → feedback as HW/FW issue.\nYes → go on.\nConnected → Go on.\nSW and OS\nPlease provide the followings info:\nWhen was the last successful sync (? mins/hours/days ago) and what was the battery level?\n\nHow many apps which use bluetooth in background installed on your phone?\n\n*Note:\nShineSample, nRF and TestShine are NOT counted as these apps don't automatically do any Bluetooth thing in background.\nMisfit, Whitelabel, Fossil Q and portfolio apps each have a background service, which continuously manage bluetooth connection.\nFor QA, it is recommended to have only one of these on your phone during the test.\nHow many bluetooth devices are currently connected to your phone? Please provide a screenshot of Settings > Bluetooth.\n*Note:\nThere're unconfirmed reports that things would go wrong if people have multiple Bluetooth-enabled device connected to the phone at the same time.\nWas ShineSample, nRF or TestShine on your phone able to connect?\nWas you able to connect with another device using ShineSample or nRF?\nLet's try the following tricks. If the connection recover in any of the following steps, you may stop there and report the result.\nDid killing the app then relaunch help?\n\nDid turn off/on Bluetooth help?\n\nDid turn on/off Airplane mode help?\n\nDid remove/forget device in Settings > Bluetooth then kill app and relaunch help?\n\nDid reboot phone help?\n\nDid clearBluetoothCache help?\n\nHardware\nTurn off Bluetooth on your phone → Try with another phone and see if it works.\"\nHID connection issue: https://misfit.jira.com/wiki/display/SDS/Troubleshoot%3A+HID+Connection\n\n\n";
                    break;
                case 1:
                    str4 = str4 + "Hardware/FW\nDid the device have any form of feedback such as hands-movement, vibe, led-flashing when you press/tap on it?\n*Note: if there's none, pls replace the battery. If the issue persist, report it as FW/HW issue.\n\nWhat's the connection status in phone's Bluetooth settings?\nDisconnected → Was you able to find the device with another phone, using either nRF or ShineSample?\nNo → move away from everyone and try sync again.\nIt works → it's probably someone else was connected to your watch.\nNo → feedback as HW/FW issue.\nYes → go on.\nConnected → Go on.\nSW and OS\nPlease provide the followings info:\nWhen was the last successful sync (?mins/hours/days) and what was the battery level?\n\nHow many apps which use bluetooth in background installed on your phone?\n\n*Note:\nShineSample, nRF and TestShine are NOT counted as these apps don't automatically do any Bluetooth thing in background.\nMisfit, Whitelabel, Fossil Q and portfolio apps each have a background service, which continuously manage bluetooth connection.\nFor QA, it is recommended to have only one of these on your phone during the test.\nHow many bluetooth devices are currently connected to your phone? Please provide a screenshot of Settings > Bluetooth.\n*Note:\nThere're unconfirmed reports that things would go wrong if people have multiple Bluetooth-enabled device connected to the phone at the same time.\nWas ShineSample, nRF or TestShine on your phone able to connect?\n\nWas you able to connect with another device using ShineSample or nRF?\n\nLet's try the following tricks. If the connection recover in any of the following steps, you may stop there and report the result.\nDid killing the app then relaunch help?\n\nDid turn off/on Bluetooth help?\n\nDid turn on/off Airplane mode help?\n\nDid remove/forget device in Settings > Bluetooth then kill app and relaunch help?\n\nDid reboot phone help?\n\nDid clearBluetoothCache help?\n\nHardware\nTurn off Bluetooth on your phone → Try with another phone and see if it works.\n\n\n";
                    break;
                default:
                    break;
            }
        } else if (i == 0) {
            str5 = str5 + "uat";
            str4 = str4 + "\nPlease give a detailed Description of the issue you are experiencing.\n\n\nHow often is the issue happening?\n\n\nIf you are able, provide the steps you took that caused the bug. (example: opened app > synced > tapped new preset > exited app > watch did not adapt to new functions assigned)\n\nPlease attach any additional pictures, screenshots, or video that may help describe the issue.\n\n\n";
        } else {
            str4 = str4 + "\n1. What did you do?\n\n2. What did you actually get?\n\n3. What did you expect?\n\n\n";
        }
        String str6 = "Brand: " + PortfolioApp.ZQ().aag().getName();
        if (TextUtils.isEmpty(str)) {
            StringBuilder append = new StringBuilder().append(str4).append("\n\n\n__________\nAppName: ").append(context.getResources().getString(R.string.app_name)).append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).append("Production").append("\nEmail: ").append(str).append("\nUserID:");
            if (TextUtils.isEmpty(str3)) {
                str3 = "NULL";
            }
            return append.append(str3).append("\nDevice name: ").append(Build.DEVICE).append("\nSystem name: Android OS\nSystem version: ").append(VERSION.RELEASE).append("\nModel: ").append(Build.MODEL).append("\nApp code: android_").append(cjy.cnN.aaQ()).append("\nLanguage code: ").append(Locale.getDefault().getLanguage()).append("_t\nServer type: ").append("release").append("\nLocal timezone: Local Time Zone (").append(timeZone.getID()).append(" (").append(timeZone.getDisplayName(false, 0)).append(")offset ").append(timeZone.getOffset(Calendar.getInstance().getTimeInMillis())).append("\nDate time: ").append(String.format(" %s (%s)", new Object[]{Long.valueOf(System.currentTimeMillis() / 1000), cmq.m7138p(new Date())})).append("\nVer. ").append(fW("2.3.1")).append("\nBuild number: ").append("12638-2018-03-27").append("\n").append(str2).append("\n").append(str5).append("\n").append(str6).append("\n\nData Log:").toString();
        }
        append = new StringBuilder().append(str4).append("\n\n\n__________\nAppName: ").append(context.getResources().getString(R.string.app_name)).append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).append("Production").append("\nEmail: ").append(str).append("\nUserID:");
        if (TextUtils.isEmpty(str3)) {
            str3 = "NULL";
        }
        return append.append(str3).append("\nDevice name: ").append(Build.DEVICE).append("\nSystem name: Android OS\nSystem version: ").append(VERSION.RELEASE).append("\nModel: ").append(Build.MODEL).append("\nApp code: android_").append(cjy.cnN.aaQ()).append("\nLanguage code: ").append(Locale.getDefault().getLanguage()).append("_t\nServer type: ").append("release").append("\nLocal timezone: Local Time Zone (").append(timeZone.getID()).append(" (").append(timeZone.getDisplayName(false, 0)).append(")offset ").append(timeZone.getOffset(Calendar.getInstance().getTimeInMillis())).append("\nDate time: ").append(String.format(" %s (%s)", new Object[]{Long.valueOf(System.currentTimeMillis() / 1000), cmq.m7138p(new Date())})).append("\nVer. ").append(fW("2.3.1")).append("\nBuild number: ").append("12638-2018-03-27").append("\n\n__________\n").append(str2).append("\n").append(str5).append("\n").append(str6).append("\n\nData Log:").toString();
    }

    private static String fW(String str) {
        return str.indexOf("-");
    }

    public static void m7090x(Context context, String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=" + str));
        try {
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Log.e("AppHelper", "openMarketApp - ex=" + e);
        }
    }

    public static boolean m7091y(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }
}
