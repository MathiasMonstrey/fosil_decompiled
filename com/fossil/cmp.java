package com.fossil;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;
import com.fossil.wearables.fsl.appfilter.AppFilterProviderImpl;
import com.fossil.wearables.fsl.codeword.CodeWordProviderImpl;
import com.fossil.wearables.fsl.contact.ContactProviderImpl;
import com.fossil.wearables.fsl.fitness.FitnessProviderFactory;
import com.fossil.wearables.fsl.goal.GoalProviderImpl;
import com.fossil.wearables.fsl.goaltracking.GoalTrackingProviderImpl;
import com.fossil.wearables.fsl.history.HistoryProviderImpl;
import com.fossil.wearables.fsl.keyvalue.KeyValueProviderImpl;
import com.fossil.wearables.fsl.location.LocationProviderImpl;
import com.fossil.wearables.fsl.sleep.MFSleepSessionProviderImp;
import com.misfit.frameworks.buttonservice.db.DataFileProvider;
import com.misfit.frameworks.buttonservice.db.DataLogServiceProvider;
import com.misfit.frameworks.buttonservice.db.HwLogProvider;
import com.misfit.frameworks.common.log.MFLogger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

public class cmp {
    private static final String TAG = cmp.class.getSimpleName();

    public static List<String> bu(final Context context) {
        int i = 0;
        String acz = cnq.acd().acz();
        MFLogger.m12670d("TAG", "------------ userId=" + acz + ", pkg=" + context.getPackageName());
        MFLogger.m12670d("TAG", "------------ userId=" + acz + ", path=" + context.getDatabasePath(acz + "_" + FitnessProviderFactory.DB_NAME));
        File file = new File("/data/data/" + context.getPackageName() + "/databases/");
        List<String> arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File name : listFiles) {
                MFLogger.m12670d("Files", "FileName: " + name.getName());
            }
        }
        String[] strArr = new String[]{"user.db", DataLogServiceProvider.DB_NAME, DataFileProvider.DB_NAME, HwLogProvider.DB_NAME, "ParseOfflineStore"};
        for (String str : new String[]{"widgets.db", "alarm.db", "secondTimezone.db", "explore.db", ContactProviderImpl.DB_NAME, AppFilterProviderImpl.DB_NAME, "user.db", FitnessProviderFactory.DB_NAME, GoalProviderImpl.DB_NAME, HistoryProviderImpl.DB_NAME, LocationProviderImpl.DB_NAME, CodeWordProviderImpl.DB_NAME, KeyValueProviderImpl.DB_NAME, MFSleepSessionProviderImp.DB_NAME, "pin.db", "firmwares.db", "deviceModel.db", GoalTrackingProviderImpl.DB_NAME, "landingPage.db", "microAppSetting.db", "challenge.db"}) {
            if (!arrayList.contains(str)) {
                arrayList.add(m7103z(context, acz + "_" + str));
            }
        }
        arrayList.add(m7103z(context, "dataVersion.db"));
        arrayList.add(m7103z(context, "Guest_landingPage.db"));
        arrayList.add(m7103z(context, "Guest_explore.db"));
        arrayList.add(m7103z(context, "Guest_widgets.db"));
        int length = strArr.length;
        while (i < length) {
            arrayList.add(m7103z(context, strArr[i]));
            i++;
        }
        ((Activity) context).runOnUiThread(new Runnable() {
            public void run() {
                Toast.makeText(context, "DB Exported!", 1).show();
            }
        });
        return arrayList;
    }

    private static String m7103z(Context context, String str) {
        String afl = csw.afk().afl();
        File file = new File(context.getDatabasePath(str).getAbsolutePath());
        File file2 = new File(afl, str);
        try {
            Object channel = new FileInputStream(file).getChannel();
            FileChannel channel2 = new FileOutputStream(file2).getChannel();
            channel2.transferFrom(channel, 0, channel.size());
            channel.close();
            channel2.close();
            return file2.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
