package com.portfolio.platform.helper;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Parcelable;
import android.view.View;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.log.MFLogger;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ImageHelper {
    private static final String TAG = ImageHelper.class.getSimpleName();

    public enum FLIP {
        VERTICAL,
        HORIZONTAL
    }

    private static Uri bw(Context context) {
        return m15629A(context, "pickerImage.jpg");
    }

    public static Uri m15629A(Context context, String str) {
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir != null) {
            return Uri.fromFile(new File(externalCacheDir.getPath(), str));
        }
        return null;
    }

    public static Bitmap cM(View view) {
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        return view.getDrawingCache();
    }

    public static Intent bx(Context context) {
        Parcelable bw = bw(context);
        List<Intent> arrayList = new ArrayList();
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, 0)) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name));
            intent2.setPackage(resolveInfo.activityInfo.packageName);
            if (bw != null) {
                intent2.putExtra("output", bw);
            }
            arrayList.add(intent2);
        }
        Intent intent3 = new Intent("android.intent.action.GET_CONTENT");
        intent3.setType("image/*");
        for (ResolveInfo resolveInfo2 : packageManager.queryIntentActivities(intent3, 0)) {
            intent = new Intent(intent3);
            intent.setComponent(new ComponentName(resolveInfo2.activityInfo.packageName, resolveInfo2.activityInfo.name));
            intent.setPackage(resolveInfo2.activityInfo.packageName);
            arrayList.add(intent);
        }
        Intent intent4 = (Intent) arrayList.get(arrayList.size() - 1);
        for (Intent intent32 : arrayList) {
            if ("com.android.documentsui.DocumentsActivity".equalsIgnoreCase(intent32.getComponent().getClassName())) {
                break;
            }
        }
        intent32 = intent4;
        arrayList.remove(intent32);
        intent32 = Intent.createChooser(intent32, context.getResources().getString(R.string.choose));
        intent32.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[arrayList.size()]));
        return intent32;
    }

    public static Uri m15631a(Intent intent, Context context) {
        Object obj = null;
        Object obj2 = 1;
        if (intent != null) {
            if (intent.getData() != null) {
                obj2 = null;
            } else {
                String action = intent.getAction();
                if (action != null) {
                    MFLogger.d(TAG, "Action is " + action);
                    if (action.equals("android.media.action.IMAGE_CAPTURE") || action.equalsIgnoreCase("inline-data")) {
                        obj = 1;
                    }
                    obj2 = obj;
                }
            }
        }
        if (obj2 != null) {
            return bw(context);
        }
        return intent.getData();
    }

    public static Bitmap m15630a(Bitmap bitmap, FLIP flip) {
        Matrix matrix = new Matrix();
        if (flip == FLIP.VERTICAL) {
            matrix.preScale(1.0f, -1.0f);
        } else if (flip != FLIP.HORIZONTAL) {
            return null;
        } else {
            matrix.preScale(-1.0f, 1.0f);
        }
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap gl(String str) {
        Options options = new Options();
        options.inPreferredConfig = Config.ARGB_8888;
        return BitmapFactory.decodeFile(str, options);
    }
}
