package com.portfolio.platform.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Telephony.Sms.Intents;
import android.telephony.SmsMessage;
import android.text.TextUtils;
import com.fossil.cnj;
import com.fossil.dri;
import com.j256.ormlite.field.FieldType;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.NotificationSource;
import com.portfolio.platform.data.model.NotificationInfo;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.MessageFormat;

public class SmsMmsReceiver extends BroadcastReceiver {
    private static final String TAG = SmsMmsReceiver.class.getSimpleName();

    public void onReceive(Context context, Intent intent) {
        NotificationInfo notificationInfo = null;
        MFLogger.i(TAG, "SmsMmsReceiver : " + intent.getAction());
        if (TextUtils.isEmpty(intent.getAction()) || !intent.getAction().equals("android.provider.Telephony.WAP_PUSH_RECEIVED")) {
            try {
                SmsMessage[] messagesFromIntent = Intents.getMessagesFromIntent(intent);
                if (messagesFromIntent != null && messagesFromIntent.length > 0) {
                    int length = messagesFromIntent.length;
                    int i = 0;
                    while (i < length) {
                        SmsMessage smsMessage = messagesFromIntent[i];
                        String messageBody = smsMessage.getMessageBody();
                        i++;
                        notificationInfo = new NotificationInfo(NotificationSource.TEXT, smsMessage.getOriginatingAddress(), messageBody, "");
                    }
                }
            } catch (Exception e) {
                System.err.println("Exception was thrown: " + e.toString());
            }
        } else {
            Cursor query = context.getContentResolver().query(Uri.parse("content://mms"), new String[]{FieldType.FOREIGN_ID_FIELD_SUFFIX}, null, null, "_id desc limit 1");
            if (query != null) {
                if (query.getCount() == 0) {
                    query.close();
                    return;
                }
                query.moveToFirst();
                String string = query.getString(query.getColumnIndex(FieldType.FOREIGN_ID_FIELD_SUFFIX));
                query.close();
                String B = m15643B(context, string);
                MFLogger.i(TAG, "Entourage MMS address : " + B + " : " + string);
                notificationInfo = new NotificationInfo(NotificationSource.TEXT, B, m15644C(context, string), "");
            } else {
                return;
            }
        }
        if (notificationInfo != null) {
            if (!dri.a(TAG, dri.ju(notificationInfo.getSenderInfo()), false, false)) {
                cnj.abR().a(notificationInfo);
            }
        }
    }

    private String m15643B(Context context, String str) {
        Uri parse = Uri.parse(MessageFormat.format("content://mms/{0}/addr", new Object[]{str}));
        String[] strArr = new String[]{"address"};
        String[] strArr2 = new String[]{str};
        Cursor query = context.getContentResolver().query(parse, strArr, "msg_id = ? and type = 137", strArr2, "_id asc limit 1");
        if (query == null) {
            return null;
        }
        if (query.getCount() == 0) {
            query.close();
            return null;
        }
        query.moveToFirst();
        String string = query.getString(query.getColumnIndex("address"));
        query.close();
        return string;
    }

    private String m15644C(Context context, String str) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://mms/part"), new String[]{"mid", FieldType.FOREIGN_ID_FIELD_SUFFIX, "ct", "_data", "text"}, null, null, null);
        if (query == null) {
            return null;
        }
        if (query.getCount() == 0) {
            query.close();
            return null;
        }
        query.moveToFirst();
        String str2 = null;
        while (!query.isAfterLast()) {
            String string;
            if (str.equals(query.getString(query.getColumnIndex("mid")))) {
                string = query.getString(query.getColumnIndex(FieldType.FOREIGN_ID_FIELD_SUFFIX));
                if ("text/plain".equals(query.getString(query.getColumnIndex("ct")))) {
                    if (TextUtils.isEmpty(query.getString(query.getColumnIndex("_data")))) {
                        string = query.getString(query.getColumnIndex("text"));
                    } else {
                        try {
                            string = m15645D(context, string);
                        } catch (Exception e) {
                            Exception e2 = e;
                        }
                    }
                    query.moveToNext();
                    str2 = string;
                }
            }
            string = str2;
            try {
                query.moveToNext();
                str2 = string;
            } catch (Exception e3) {
                Exception exception = e3;
                str2 = string;
                e2 = exception;
            }
        }
        query.close();
        MFLogger.i(TAG, "MMS MESSAGE : " + str2);
        return str2;
        try {
            MFLogger.e(TAG, ".parseMessage - ex=" + e2.toString());
            MFLogger.i(TAG, "MMS MESSAGE : " + str2);
            return str2;
        } finally {
            query.close();
        }
    }

    private String m15645D(Context context, String str) {
        Uri parse = Uri.parse("content://mms/part/" + str);
        InputStream inputStream = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            inputStream = context.getContentResolver().openInputStream(parse);
            if (inputStream != null) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                for (Object readLine = bufferedReader.readLine(); !TextUtils.isEmpty(readLine); readLine = bufferedReader.readLine()) {
                    stringBuilder.append(readLine);
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e22) {
                    e22.printStackTrace();
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
        return stringBuilder.toString();
    }
}
