package com.misfit.frameworks.buttonservice.db;

import android.content.Context;
import java.util.concurrent.Executors;

public class DataCollectorHelper {
    public static void saveDataFile(Context context, DataFile dataFile) {
        if (dataFile != null) {
            DataFileProvider.getInstance(context).saveDataFile(dataFile);
        }
    }

    public static void saveHwLog(final Context context, final HardwareLog hardwareLog) {
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            public void run() {
                if (hardwareLog != null) {
                    HwLogProvider.getInstance(context).saveHwLog(hardwareLog);
                }
            }
        });
    }
}
