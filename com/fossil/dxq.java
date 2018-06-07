package com.fossil;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

final class dxq extends dxu {
    dxq(Context context) {
        super(context);
    }

    protected final String HI() {
        String str;
        synchronized (this) {
            Log.i("MID", "read mid from InternalStorage");
            try {
                for (String str2 : dxp.m10266z(new File(Environment.getExternalStorageDirectory(), dxw.lb("6X8Y4XdM2Vhvn0KfzcEatGnWaNU=")))) {
                    String[] split = str2.split(",");
                    if (split.length == 2 && split[0].equals(dxw.lb("4kU71lN96TJUomD1vOU9lgj9Tw=="))) {
                        Log.i("MID", "read mid from InternalStorage:" + split[1]);
                        str2 = split[1];
                        break;
                    }
                }
                str2 = null;
            } catch (Throwable e) {
                Log.w("MID", e);
                str2 = null;
            }
        }
        return str2;
    }

    protected final boolean Ja() {
        return dxw.m10271l(this.baD, "android.permission.WRITE_EXTERNAL_STORAGE") && Environment.getExternalStorageState().equals("mounted");
    }

    protected final void cg(String str) {
        synchronized (this) {
            Log.i("MID", "write mid to InternalStorage");
            dxp.kY(Environment.getExternalStorageDirectory() + "/" + dxw.lb("6X8Y4XdM2Vhvn0I="));
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(Environment.getExternalStorageDirectory(), dxw.lb("6X8Y4XdM2Vhvn0KfzcEatGnWaNU="))));
                bufferedWriter.write(dxw.lb("4kU71lN96TJUomD1vOU9lgj9Tw==") + "," + str);
                bufferedWriter.write("\n");
                bufferedWriter.close();
            } catch (Throwable e) {
                Log.w("MID", e);
            }
        }
    }
}
