package com.portfolio.platform.pushnotification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.os.Parcelable;
import android.text.TextUtils;
import com.fossil.cez;
import com.fossil.clw;
import com.fossil.cnq;
import com.fossil.fq.d;
import com.fossil.wearables.fossil.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.MFUser;
import com.portfolio.platform.data.model.buddychallenge.BCNotifications;
import com.portfolio.platform.ui.MainActivity;
import java.util.Random;
import org.json.JSONObject;

public class PushNotificationService extends FirebaseMessagingService {
    private static final String TAG = PushNotificationService.class.getSimpleName();

    public void mo5414a(cez com_fossil_cez) {
        boolean z;
        int i;
        int i2;
        Exception exception;
        Intent intent;
        super.mo5414a(com_fossil_cez);
        MFUser currentUser = cnq.acd().ace().getCurrentUser();
        if (currentUser == null || TextUtils.isEmpty(currentUser.getUserAccessToken())) {
            z = true;
        } else {
            z = false;
        }
        if (!z && clw.cwB.booleanValue()) {
            MFLogger.d(TAG, "onMessageReceived From: " + com_fossil_cez.getFrom());
            if (com_fossil_cez.Wm().size() > 0) {
                int i3;
                String str;
                Parcelable bCNotifications;
                MFLogger.d(TAG, "onMessageReceived Message data payload: " + com_fossil_cez.Wm());
                String str2 = (String) com_fossil_cez.Wm().get("message");
                String str3 = "";
                String str4 = "";
                String str5 = "";
                String str6 = "";
                try {
                    JSONObject jSONObject = new JSONObject((String) com_fossil_cez.Wm().get("data"));
                    if (jSONObject.has("sender")) {
                        str3 = jSONObject.getString("sender");
                    }
                    if (jSONObject.has("receiver")) {
                        str4 = jSONObject.getString("receiver");
                    }
                    if (jSONObject.has("id")) {
                        str5 = jSONObject.getString("id");
                    }
                    if (jSONObject.has("challengeType")) {
                        i = jSONObject.getInt("challengeType");
                    } else {
                        i = -1;
                    }
                    try {
                        String string;
                        if (jSONObject.has("challengeId")) {
                            string = jSONObject.getString("challengeId");
                        } else {
                            string = str6;
                        }
                        i3 = i;
                        str = string;
                    } catch (Exception e) {
                        Exception exception2 = e;
                        i2 = i;
                        str = str5;
                        str5 = str4;
                        str4 = str3;
                        exception = exception2;
                        exception.printStackTrace();
                        str3 = str4;
                        str4 = str5;
                        str5 = str;
                        str = str6;
                        i3 = i2;
                        i2 = Integer.valueOf((String) com_fossil_cez.Wm().get("type")).intValue();
                        bCNotifications = new BCNotifications();
                        bCNotifications.setSender(str3);
                        bCNotifications.setReceiver(str4);
                        bCNotifications.setId(str5);
                        bCNotifications.setType(i2);
                        bCNotifications.setChallengeType(i3);
                        bCNotifications.setChallengeId(str);
                        bCNotifications.setMessage(str2);
                        if (PortfolioApp.ZQ().aaj()) {
                        }
                        bCNotifications.setNeedToShowPopup(false);
                        intent = new Intent(this, MainActivity.class);
                        if (jN(i2)) {
                            intent.putExtra("NOTIFICATION", bCNotifications);
                        }
                        intent.setFlags(603979776);
                        i2 = new Random().nextInt();
                        ((NotificationManager) getSystemService("notification")).notify(i2, new d(this).aO(R.drawable.icon_q).a(BitmapFactory.decodeResource(Resources.getSystem(), R.mipmap.ic_launcher)).e(getString(R.string.app_name)).f(str2).g(str2).a(RingtoneManager.getDefaultUri(2)).a(PendingIntent.getActivity(this, i2, intent, 0)).aP(1).aQ(1).z(true).build());
                        return;
                    }
                } catch (Exception e2) {
                    str = str5;
                    str5 = str4;
                    str4 = str3;
                    exception = e2;
                    i2 = -1;
                    exception.printStackTrace();
                    str3 = str4;
                    str4 = str5;
                    str5 = str;
                    str = str6;
                    i3 = i2;
                    i2 = Integer.valueOf((String) com_fossil_cez.Wm().get("type")).intValue();
                    bCNotifications = new BCNotifications();
                    bCNotifications.setSender(str3);
                    bCNotifications.setReceiver(str4);
                    bCNotifications.setId(str5);
                    bCNotifications.setType(i2);
                    bCNotifications.setChallengeType(i3);
                    bCNotifications.setChallengeId(str);
                    bCNotifications.setMessage(str2);
                    if (PortfolioApp.ZQ().aaj()) {
                    }
                    bCNotifications.setNeedToShowPopup(false);
                    intent = new Intent(this, MainActivity.class);
                    if (jN(i2)) {
                        intent.putExtra("NOTIFICATION", bCNotifications);
                    }
                    intent.setFlags(603979776);
                    i2 = new Random().nextInt();
                    ((NotificationManager) getSystemService("notification")).notify(i2, new d(this).aO(R.drawable.icon_q).a(BitmapFactory.decodeResource(Resources.getSystem(), R.mipmap.ic_launcher)).e(getString(R.string.app_name)).f(str2).g(str2).a(RingtoneManager.getDefaultUri(2)).a(PendingIntent.getActivity(this, i2, intent, 0)).aP(1).aQ(1).z(true).build());
                    return;
                }
                try {
                    i2 = Integer.valueOf((String) com_fossil_cez.Wm().get("type")).intValue();
                } catch (Exception e3) {
                    MFLogger.d(TAG, "onMessageReceived Message invalid type: " + ((String) com_fossil_cez.Wm().get("type")));
                    i2 = -1;
                }
                bCNotifications = new BCNotifications();
                bCNotifications.setSender(str3);
                bCNotifications.setReceiver(str4);
                bCNotifications.setId(str5);
                bCNotifications.setType(i2);
                bCNotifications.setChallengeType(i3);
                bCNotifications.setChallengeId(str);
                bCNotifications.setMessage(str2);
                if (PortfolioApp.ZQ().aaj() || !jN(i2)) {
                    bCNotifications.setNeedToShowPopup(false);
                    intent = new Intent(this, MainActivity.class);
                    if (jN(i2)) {
                        intent.putExtra("NOTIFICATION", bCNotifications);
                    }
                    intent.setFlags(603979776);
                    i2 = new Random().nextInt();
                    ((NotificationManager) getSystemService("notification")).notify(i2, new d(this).aO(R.drawable.icon_q).a(BitmapFactory.decodeResource(Resources.getSystem(), R.mipmap.ic_launcher)).e(getString(R.string.app_name)).f(str2).g(str2).a(RingtoneManager.getDefaultUri(2)).a(PendingIntent.getActivity(this, i2, intent, 0)).aP(1).aQ(1).z(true).build());
                    return;
                }
                bCNotifications.setNeedToShowPopup(true);
                Intent intent2 = new Intent();
                intent2.putExtra("BC_SHOW_NOTIFICATION_NOTIFICATIONS", bCNotifications);
                intent2.setAction("BC_SHOW_NOTIFICATION_ACTION");
                PortfolioApp.ZQ().sendBroadcast(intent2);
            }
        }
    }

    private boolean jN(int i) {
        if (i < 0 || i > 11) {
            return false;
        }
        return true;
    }

    public void dy(String str) {
        super.dy(str);
    }

    public void Mq() {
        super.Mq();
        MFLogger.d(TAG, "onDeletedMessages");
    }

    public void mo5415a(String str, Exception exception) {
        super.mo5415a(str, exception);
    }
}
