package com.fossil;

import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.FailedDownloadRequest;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class cmv {
    private static final String TAG = cmv.class.getSimpleName();
    private static SparseArray<Float> cyv = new SparseArray();
    private static SparseIntArray cyw = new SparseIntArray();
    private static String uriSchemePrefix = "urn:fsl:fitness";

    public static int jA(int i) {
        return (int) Math.round(((double) i) / 28.349523125d);
    }

    public static int jB(int i) {
        return (int) Math.round(((double) i) * 28.349523125d);
    }

    public static List<FailedDownloadRequest> m7154Q(List<FailedDownloadRequest> list) {
        List<FailedDownloadRequest> arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        List arrayList3 = new ArrayList();
        for (FailedDownloadRequest failedDownloadRequest : list) {
            try {
                Date fY = cmq.fY(failedDownloadRequest.getFrom());
                Date fY2 = cmq.fY(failedDownloadRequest.getTo());
                arrayList2.add(Long.valueOf(fY.getTime()));
                arrayList3.add(Long.valueOf(fY2.getTime()));
            } catch (ParseException e) {
                MFLogger.m12670d(TAG, " ---- INSIDE " + TAG + ", startDate or endDate of missing request is wrong, ignore it.");
            }
        }
        Collections.sort(arrayList2);
        Collections.sort(arrayList3);
        int size = arrayList2.size();
        if (size > 0) {
            int requestCode = ((FailedDownloadRequest) list.get(0)).getRequestCode();
            long longValue = ((Long) arrayList2.get(0)).longValue();
            long longValue2 = ((Long) arrayList3.get(0)).longValue();
            int i = 0;
            while (i < size) {
                long longValue3 = ((Long) arrayList2.get(i)).longValue();
                long longValue4 = ((Long) arrayList3.get(i)).longValue();
                if (longValue3 < longValue || longValue3 > longValue2) {
                    arrayList.addAll(m7155d(requestCode, longValue, longValue2));
                    longValue2 = longValue3;
                } else {
                    if (longValue4 <= longValue2) {
                        longValue4 = longValue2;
                    }
                    longValue2 = longValue;
                }
                i++;
                longValue = longValue2;
                longValue2 = longValue4;
            }
            arrayList.addAll(m7155d(requestCode, longValue, longValue2));
        }
        return arrayList;
    }

    private static List<FailedDownloadRequest> m7155d(int i, long j, long j2) {
        List<FailedDownloadRequest> arrayList = new ArrayList();
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(j2);
        if (cmq.m7112c(0, j, j2) > 14) {
            while (!instance.after(instance2)) {
                String a = cmq.m7105a(instance.getTime());
                instance.add(5, 14);
                arrayList.add(new FailedDownloadRequest(i, a, !instance.after(instance2) ? cmq.m7105a(instance.getTime()) : cmq.m7105a(instance2.getTime()), FailedDownloadRequest.NO_OFFSET, FailedDownloadRequest.NO_LIMIT));
            }
        } else {
            arrayList.add(new FailedDownloadRequest(i, cmq.m7105a(instance.getTime()), cmq.m7105a(instance2.getTime()), FailedDownloadRequest.NO_OFFSET, FailedDownloadRequest.NO_LIMIT));
        }
        return arrayList;
    }

    public static int ar(String str, String str2) {
        MFLogger.m12670d(TAG, "compareVersionNames oldVersionName=" + str + "newVersionName=" + str2);
        if (TextUtils.isEmpty(str)) {
            return 1;
        }
        if (TextUtils.isEmpty(str2)) {
            return -1;
        }
        return new euw(str).m11251a(new euw(str2));
    }

    public static String as(String str, String str2) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        Key secretKeySpec = new SecretKeySpec(str2.getBytes("UTF-8"), "HmacSHA1");
        Mac instance = Mac.getInstance("HmacSHA1");
        instance.init(secretKeySpec);
        String encodeToString = Base64.encodeToString(instance.doFinal(str.getBytes("UTF-8")), 0);
        if (TextUtils.isEmpty(encodeToString)) {
            return encodeToString;
        }
        return encodeToString.replace(System.getProperty("line.separator"), "");
    }

    public static int aE(long j) {
        return (int) (j % 255);
    }
}
