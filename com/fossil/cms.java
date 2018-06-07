package com.fossil;

import android.content.Context;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.TimezoneRawData;
import com.portfolio.platform.helper.FileHelper.1;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.util.List;

public class cms {
    private static final String TAG = cms.class.getSimpleName();

    public static boolean m7141B(String str, String str2) {
        boolean z = false;
        if (!euh.isEmpty(str2)) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                InputStream fileInputStream = new FileInputStream(str);
                byte[] bArr = new byte[2014];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    } else if (read > 0) {
                        instance.update(bArr, 0, read);
                    }
                }
                z = str2.toLowerCase().equals(bytesToString(instance.digest()));
            } catch (Exception e) {
                MFLogger.m12671e(TAG, "Error inside " + TAG + ".verifyDownloadFile - e=" + e);
            }
        }
        return z;
    }

    private static String bytesToString(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bArr) {
            stringBuilder.append(Integer.toString((b & 255) + 256, 16).substring(1));
        }
        return stringBuilder.toString().toLowerCase();
    }

    public static List<TimezoneRawData> bv(Context context) {
        return (List) new cfj().m6195a(new cgv(new BufferedReader(new InputStreamReader(context.getResources().openRawResource(R.raw.timezone_cities)))), new 1().getType());
    }
}
