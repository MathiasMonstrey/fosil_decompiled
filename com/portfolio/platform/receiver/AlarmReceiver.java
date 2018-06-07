package com.portfolio.platform.receiver;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.fossil.arp;
import com.fossil.cmi;
import com.fossil.cna;
import com.fossil.cnq;
import com.fossil.cnr;
import com.fossil.gi;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.buttonservice.model.Alarm;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.DeviceModel;
import com.portfolio.platform.data.model.MFUser;
import com.portfolio.platform.data.source.DeviceRepository;
import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.helper.DeviceHelper;
import com.portfolio.platform.ui.MainActivity;
import com.portfolio.platform.ui.device.battery.DeviceBatteryActivity;

public class AlarmReceiver extends BroadcastReceiver {
    public cmi cmS;
    public DeviceRepository mDeviceRepository;
    public cnr mSharedPreferencesManager;
    public UserRepository mUserRepository;

    public void onReceive(Context context, Intent intent) {
        PortfolioApp.ZQ().aam().a(this);
        MFLogger.d("AlarmReceiver", "ALARM 0----------------------------- onReceive");
        if (intent != null) {
            Intent intent2;
            int intExtra = intent.getIntExtra("DEF_ALARM_RECEIVER_ACTION", -1);
            MFLogger.d("AlarmReceiver", "Inside AlarmReceiver.onReceiver - action=" + intExtra);
            MFUser currentUser = this.mUserRepository.getCurrentUser();
            CharSequence stringExtra;
            switch (intExtra) {
                case 0:
                    Alarm adF = cnq.acd().acu().adF();
                    stringExtra = intent.getStringExtra("DEF_ALARM_RECEIVER_USER_ID");
                    if (currentUser != null && !TextUtils.isEmpty(stringExtra) && currentUser.getUserId().equals(stringExtra) && adF != null) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("DEF_ALARM_RECEIVER_ACTION", 3);
                        bundle.putString("DEF_ALARM_RECEIVER_USER_ID", currentUser.getUserId());
                        intent2 = new Intent(context, AlarmReceiver.class);
                        intent2.setAction("com.portfolio.platform.ALARM_RECEIVER");
                        intent2.putExtras(bundle);
                        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Alarm.TABLE_NAME);
                        if (alarmManager != null) {
                            alarmManager.setExact(0, cmi.aB(adF.getAlarmMillis()), PendingIntent.getBroadcast(context, 101, intent2, 134217728));
                            break;
                        }
                    }
                    MFLogger.e("AlarmReceiver", "Inside AlarmReceiver.onReceiver - user=null||empty||equals=false");
                    this.cmS.br(context);
                    break;
                    break;
                case 2:
                    MFLogger.d("startRepeatAlarmReceiver", "push notification");
                    break;
                case 3:
                    stringExtra = intent.getStringExtra("DEF_ALARM_RECEIVER_USER_ID");
                    if (currentUser != null && !TextUtils.isEmpty(stringExtra) && currentUser.getUserId().equals(stringExtra)) {
                        this.cmS.bq(context);
                        break;
                    }
                    MFLogger.e("AlarmReceiver", "Inside AlarmReceiver.onReceiver - user=null||empty||equals=false");
                    this.cmS.br(context);
                    break;
                    break;
            }
            if (!TextUtils.isEmpty(PortfolioApp.ZQ().aaa())) {
                DeviceModel deviceBySerial = this.mDeviceRepository.getDeviceBySerial(PortfolioApp.ZQ().aaa(), null);
                int acY = this.mSharedPreferencesManager.acY();
                int intExtra2 = intent.getIntExtra("REQUEST_CODE", -1);
                MFLogger.d("AlarmReceiver", "Inside AlarmReceiver.onReceiver - extraCode=" + intExtra2);
                switch (intExtra2) {
                    case 0:
                        if (deviceBySerial == null || deviceBySerial.getBatteryLevel() >= acY) {
                            MFLogger.d("AlarmReceiver", "onReceive REQUEST_INEXACT_REPLACE_BATTERY stopReplaceBatteryAlarm: activeDevice = " + deviceBySerial + ", lowBatteryLevel = " + acY);
                            this.cmS.abA();
                            return;
                        }
                        MFLogger.d("AlarmReceiver", "onReceive REQUEST_INEXACT_REPLACE_BATTERY");
                        this.cmS.abB();
                        return;
                    case 1:
                        if (deviceBySerial == null || deviceBySerial.getBatteryLevel() >= acY) {
                            MFLogger.d("AlarmReceiver", "onReceive REQUEST_EXACT_REPLACE_BATTERY stopReplaceBatteryAlarm: activeDevice = " + deviceBySerial + ", lowBatteryLevel = " + acY);
                            this.cmS.abA();
                            return;
                        }
                        MFLogger.d("AlarmReceiver", "onReceive REQUEST_EXACT_REPLACE_BATTERY: isWasInBackground = " + PortfolioApp.cmB);
                        if (PortfolioApp.cmB) {
                            String format = String.format(arp.u(context, R.string.Onboarding_General_Error_Low_Push_Header_Critical_Warning), new Object[]{DeviceHelper.gg(deviceBySerial.getDeviceId())});
                            String u = arp.u(context, R.string.Onboarding_General_Error_Low_Push_Text_Your_Devices_Battery);
                            intent2 = new Intent(context, MainActivity.class);
                            Intent intent3 = new Intent(context, DeviceBatteryActivity.class);
                            intent3.putExtra("DEVICE_SERIAL", deviceBySerial.getDeviceId());
                            gi m = gi.m(context);
                            m.a(intent2);
                            m.a(intent3);
                            cna.b(context, 7, format, u, m.getPendingIntent(0, 134217728), null);
                            return;
                        }
                        return;
                    case 10:
                        if (PortfolioApp.ZQ().ZW() || this.mSharedPreferencesManager.acG()) {
                            MFLogger.d("AlarmReceiver", "onReceive REQUEST_INEXACT_HW_LOG_SYNC: start HWLog Sync.");
                            PortfolioApp.ZQ().ZX();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
