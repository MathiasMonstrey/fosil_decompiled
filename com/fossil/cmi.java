package com.fossil;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.fossil.clx.C2164b;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.buttonservice.model.Alarm;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.MFUser;
import com.portfolio.platform.data.source.AlarmsDataSource.LoadAlarmsCallback;
import com.portfolio.platform.data.source.AlarmsRepository;
import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.enums.FossilBrand;
import com.portfolio.platform.receiver.AlarmReceiver;
import com.portfolio.platform.ui.device.alarm.main.AlarmMainActivity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class cmi {
    private final AlarmManager cxv;
    private final AlarmsRepository cxw;
    private final Context mContext;
    private final cnr mSharedPreferencesManager;
    private final UserRepository mUserRepository;

    public cmi(Context context, cnr com_fossil_cnr, UserRepository userRepository, AlarmsRepository alarmsRepository) {
        this.mContext = (Context) cco.m5996s(context, "context cannot be null!");
        this.mSharedPreferencesManager = com_fossil_cnr;
        this.mUserRepository = userRepository;
        this.cxw = alarmsRepository;
        this.cxv = (AlarmManager) context.getSystemService(Alarm.TABLE_NAME);
    }

    public void abz() {
        CharSequence acW = this.mSharedPreferencesManager.acW();
        Object aaa = PortfolioApp.ZQ().aaa();
        MFLogger.m12670d("AlarmHelper", "startReplaceBatteryAlarm: lowBatteryDevice = " + acW + ", activeDeviceId = " + aaa);
        if (!TextUtils.equals(acW, aaa)) {
            this.mSharedPreferencesManager.gL(aaa);
            Intent intent = new Intent(this.mContext, AlarmReceiver.class);
            Intent intent2 = new Intent(this.mContext, AlarmReceiver.class);
            intent.putExtra("REQUEST_CODE", 0);
            intent2.putExtra("REQUEST_CODE", 1);
            PendingIntent broadcast = PendingIntent.getBroadcast(this.mContext, 0, intent, 134217728);
            PendingIntent broadcast2 = PendingIntent.getBroadcast(this.mContext, 1, intent2, 134217728);
            this.cxv.cancel(broadcast);
            this.cxv.cancel(broadcast2);
            Calendar instance = Calendar.getInstance();
            instance.add(5, 1);
            instance.set(11, 9);
            instance.set(12, 0);
            instance.set(13, 0);
            long timeInMillis = instance.getTimeInMillis();
            MFLogger.m12670d("AlarmHelper", "startReplaceBatteryAlarm setInexactRepeating: triggerAtMillis = " + timeInMillis);
            this.cxv.setInexactRepeating(0, timeInMillis - 3600000, 604800000, broadcast);
        }
    }

    public void abA() {
        MFLogger.m12670d("AlarmHelper", "stopReplaceBatteryAlarm");
        this.mSharedPreferencesManager.gL("");
        Intent intent = new Intent(this.mContext, AlarmReceiver.class);
        Intent intent2 = new Intent(this.mContext, AlarmReceiver.class);
        intent.putExtra("REQUEST_CODE", 0);
        intent2.putExtra("REQUEST_CODE", 1);
        PendingIntent broadcast = PendingIntent.getBroadcast(this.mContext, 0, intent, 134217728);
        PendingIntent broadcast2 = PendingIntent.getBroadcast(this.mContext, 1, intent2, 134217728);
        this.cxv.cancel(broadcast);
        this.cxv.cancel(broadcast2);
    }

    public void abB() {
        Calendar instance = Calendar.getInstance();
        instance.set(11, 9);
        instance.set(12, 0);
        instance.set(13, 0);
        long timeInMillis = instance.getTimeInMillis();
        Intent intent = new Intent(this.mContext, AlarmReceiver.class);
        intent.putExtra("REQUEST_CODE", 1);
        PendingIntent broadcast = PendingIntent.getBroadcast(this.mContext, 1, intent, 134217728);
        MFLogger.m12670d("AlarmHelper", "startExactReplaceBatteryAlarm: triggerAtMillis = " + timeInMillis);
        if (VERSION.SDK_INT >= 23) {
            this.cxv.setExactAndAllowWhileIdle(0, timeInMillis, broadcast);
        } else {
            this.cxv.setExact(0, timeInMillis, broadcast);
        }
    }

    public void abC() {
        Intent intent = new Intent(this.mContext, AlarmReceiver.class);
        intent.putExtra("REQUEST_CODE", 10);
        PendingIntent broadcast = PendingIntent.getBroadcast(this.mContext, 10, intent, 134217728);
        this.cxv.cancel(broadcast);
        Calendar instance = Calendar.getInstance();
        instance.set(11, 10);
        instance.set(12, 0);
        instance.set(13, 0);
        long timeInMillis = instance.getTimeInMillis();
        MFLogger.m12670d("AlarmHelper", "startHWLogScheduler setInexactRepeating: triggerAtMillis = " + timeInMillis + " interval = " + 86400000);
        this.cxv.setInexactRepeating(0, timeInMillis, 86400000, broadcast);
    }

    public void bp(Context context) {
        MFLogger.m12670d("AlarmHelper", "startJobScheduler");
        br(context);
        coe acu = cnq.acd().acu();
        if (acu != null) {
            List<Alarm> adG = acu.adG();
            if (adG != null) {
                for (Alarm alarm : adG) {
                    if (m7083b(alarm)) {
                        alarm.setActive(false);
                        this.cxw.setAlarm(alarm, null);
                    }
                }
            }
            Alarm alarm2 = acu.adF();
            if (alarm2 != null) {
                int i;
                long alarmMillis = alarm2.getAlarmMillis();
                Calendar instance = Calendar.getInstance();
                if (instance.get(9) == 1) {
                    i = instance.get(10);
                    i = i == 12 ? 12 : i + 12;
                } else {
                    i = instance.get(10);
                }
                long j = (((long) ((((i * 60) + instance.get(12)) * 60) + instance.get(13))) * 1000) + ((long) instance.get(14));
                if (j <= alarmMillis) {
                    alarmMillis -= j;
                } else {
                    alarmMillis = 86400000 - (j - alarmMillis);
                }
                long currentTimeMillis = System.currentTimeMillis() + alarmMillis;
                MFLogger.m12670d("AlarmHelper", "startJobScheduler - duration: " + alarmMillis);
                MFLogger.m12670d("AlarmHelper", "startJobScheduler - alarmEnd: " + new Date(currentTimeMillis));
                MFUser currentUser = this.mUserRepository.getCurrentUser();
                if (currentUser != null && !TextUtils.isEmpty(currentUser.getUserId())) {
                    Bundle bundle = new Bundle();
                    bundle.putString("DEF_ALARM_RECEIVER_USER_ID", currentUser.getUserId());
                    bundle.putInt("DEF_ALARM_RECEIVER_ACTION", 0);
                    Intent intent = new Intent(context, AlarmReceiver.class);
                    intent.setAction("com.portfolio.platform.ALARM_RECEIVER");
                    intent.putExtras(bundle);
                    PendingIntent broadcast = PendingIntent.getBroadcast(context, 102, intent, 134217728);
                    AlarmManager alarmManager = (AlarmManager) context.getSystemService(Alarm.TABLE_NAME);
                    MFLogger.m12670d("AlarmHelper", "Inside .startJobScheduler inexactAlarm=" + alarmManager);
                    if (alarmMillis <= 3600000 || alarmManager == null) {
                        bundle = new Bundle();
                        bundle.putString("DEF_ALARM_RECEIVER_USER_ID", currentUser.getUserId());
                        bundle.putInt("DEF_ALARM_RECEIVER_ACTION", 3);
                        Intent intent2 = new Intent(context, AlarmReceiver.class);
                        intent2.setAction("com.portfolio.platform.ALARM_RECEIVER");
                        intent2.putExtras(bundle);
                        alarmManager = (AlarmManager) context.getSystemService(Alarm.TABLE_NAME);
                        if (alarmManager != null) {
                            alarmManager.setExact(0, currentTimeMillis, PendingIntent.getBroadcast(context, 101, intent2, 134217728));
                            return;
                        }
                        return;
                    }
                    alarmManager.set(0, currentTimeMillis - 3600000, broadcast);
                }
            }
        }
    }

    public void bq(final Context context) {
        Calendar instance = Calendar.getInstance();
        final int i = instance.get(12) + (instance.get(11) * 60);
        MFLogger.m12670d("AlarmHelper", "endJobScheduler - currentMinute: " + i);
        this.cxw.getActiveAlarms(new LoadAlarmsCallback(this) {
            final /* synthetic */ cmi cxy;

            class C21941 implements LoadAlarmsCallback {
                final /* synthetic */ C21951 cxz;

                C21941(C21951 c21951) {
                    this.cxz = c21951;
                }

                public void onAlarmsLoaded(List<Alarm> list) {
                    MFLogger.m12670d("AlarmHelper", "getActiveAlarms again onAlarmsLoaded");
                    this.cxz.cxy.bp(context);
                    PortfolioApp.ZQ().m12684H(list);
                }

                public void onDataNotAvailable() {
                    MFLogger.m12670d("AlarmHelper", "getActiveAlarms again onDataNotAvailable");
                    this.cxz.cxy.br(context);
                    PortfolioApp.ZQ().m12684H(new ArrayList());
                }
            }

            public void onAlarmsLoaded(List<Alarm> list) {
                MFLogger.m12670d("AlarmHelper", "getActiveAlarms onAlarmsLoaded");
                for (Alarm alarm : list) {
                    if (alarm.getAlarmMinute() == i) {
                        int i = Calendar.getInstance().get(7);
                        int[] days = alarm.getDays();
                        int length = days != null ? days.length : 0;
                        MFLogger.m12670d("AlarmHelper", "sendNotificationAlarm - alarm: " + alarm.getAlarmTitle() + ", curDay=" + i + ", daysRepeat=" + Arrays.toString(days));
                        if (length > 0) {
                            for (int i2 : days) {
                                if (i == i2) {
                                    this.cxy.m7081a(PortfolioApp.ZQ(), alarm);
                                    break;
                                }
                            }
                        } else if (i == cmi.m7079a(alarm)) {
                            this.cxy.m7081a(PortfolioApp.ZQ(), alarm);
                        }
                        if (!alarm.isRepeat()) {
                            alarm.setActive(false);
                            this.cxy.cxw.setAlarm(alarm, null);
                            PortfolioApp.cL(new C2164b(true, alarm.getUri()));
                        }
                    }
                }
                this.cxy.cxw.getActiveAlarms(new C21941(this));
            }

            public void onDataNotAvailable() {
                MFLogger.m12670d("AlarmHelper", "getActiveAlarms onDataNotAvailable");
                this.cxy.br(context);
            }
        });
    }

    public void br(Context context) {
        MFLogger.m12670d("AlarmHelper", "cancelJobScheduler");
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Alarm.TABLE_NAME);
        Intent intent = new Intent(context, AlarmReceiver.class);
        intent.setAction("com.portfolio.platform.ALARM_RECEIVER");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 101, intent, 134217728);
        if (!(broadcast == null || alarmManager == null)) {
            alarmManager.cancel(broadcast);
        }
        alarmManager = (AlarmManager) context.getSystemService(Alarm.TABLE_NAME);
        intent = new Intent(context, AlarmReceiver.class);
        intent.setAction("com.portfolio.platform.ALARM_RECEIVER");
        broadcast = PendingIntent.getBroadcast(context, 102, intent, 134217728);
        if (alarmManager != null) {
            alarmManager.cancel(broadcast);
        }
    }

    private void m7081a(Context context, Alarm alarm) {
        MFLogger.m12670d("AlarmHelper", "sendNotificationAlarm");
        Intent intent = new Intent(context, AlarmMainActivity.class);
        intent.putExtra("EXTRA_DEVICE_ID", PortfolioApp.ZQ().aaa());
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 134217728);
        String a = cnf.m7189a(alarm.getAlarmMinute(), PortfolioApp.ZQ());
        String string = PortfolioApp.ZQ().getString(R.string.brand_name);
        String str = String.valueOf(alarm.getAlarmTitle()) + " - " + String.valueOf(a);
        if (this.mSharedPreferencesManager.ada() && PortfolioApp.ZQ().aag() != FossilBrand.FOSSIL) {
            cna.m7182a(context, 5, string, str, activity, null);
        }
    }

    public static long aB(long j) {
        int i;
        MFLogger.m12670d("AlarmHelper", "getEndTimeFromAlarmMinute - duration=" + String.valueOf(j));
        Calendar instance = Calendar.getInstance();
        if (instance.get(9) == 1) {
            i = instance.get(10);
            i = i == 12 ? 12 : i + 12;
        } else {
            i = instance.get(10);
        }
        long j2 = ((long) ((((i * 60) + instance.get(12)) * 60) + instance.get(13))) * 1000;
        if (j2 <= j) {
            j2 = j - j2;
        } else {
            j2 = 86400000 - (j2 - j);
        }
        long currentTimeMillis = System.currentTimeMillis() + j2;
        MFLogger.m12670d("AlarmHelper", "getEndTimeFromAlarmMinute - duration=" + j2);
        MFLogger.m12670d("AlarmHelper", "getEndTimeFromAlarmMinute - currentSecond=" + instance.get(13));
        MFLogger.m12670d("AlarmHelper", "getEndTimeFromAlarmMinute - alarmEnd=" + new Date(currentTimeMillis));
        return currentTimeMillis;
    }

    private static int m7079a(Alarm alarm) {
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Alarm.FORMAT_DATE_ISO, Locale.US);
        simpleDateFormat.setTimeZone(timeZone);
        try {
            Date parse;
            if (!TextUtils.isEmpty(alarm.getUpdatedAt())) {
                parse = simpleDateFormat.parse(alarm.getUpdatedAt());
            } else if (TextUtils.isEmpty(alarm.getCreatedAt())) {
                MFLogger.m12671e("AlarmHelper", ".convertAlarmStringDayToDayOfWeek - updatedAt and createdAt is EMPTY");
                return -1;
            } else {
                parse = simpleDateFormat.parse(alarm.getCreatedAt());
            }
            MFLogger.m12670d("AlarmHelper", ".convertAlarmStringDayToDayOfWeek - date=" + parse.toString());
            Calendar instance = Calendar.getInstance();
            instance.setTime(parse);
            return instance.get(7);
        } catch (Exception e) {
            e.printStackTrace();
            MFLogger.m12671e("AlarmHelper", ".convertAlarmStringDayToDayOfWeek - exception parse date ex=" + e.toString());
            return -1;
        }
    }

    private boolean m7083b(Alarm alarm) {
        if (alarm.isRepeat() || !alarm.isActive()) {
            return false;
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(cmq.fZ(alarm.getUpdatedAt()));
        int i = instance.get(9);
        int i2 = instance.get(10);
        if (i == 1 && i2 < 12) {
            i2 += 12;
        }
        Calendar instance2 = Calendar.getInstance();
        long j = ((long) ((((i2 * 60) + instance.get(12)) * 60) + instance.get(13))) * 1000;
        long timeInMillis = instance2.getTimeInMillis() - cmq.m7110b(instance2).getTimeInMillis();
        long alarmMillis = alarm.getAlarmMillis();
        return j < alarmMillis && alarmMillis < timeInMillis;
    }
}
