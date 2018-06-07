package com.fossil;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.Log;

public class ciq {
    private static final String TAG = ciq.class.getSimpleName();

    public static Bitmap m6513a(Drawable drawable, int i, int i2) {
        Bitmap createBitmap;
        Exception e;
        if (i <= 0) {
            i = 1;
        }
        if (i2 <= 0) {
            i2 = 1;
        }
        try {
            createBitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
            try {
                Canvas canvas = new Canvas(createBitmap);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
            } catch (Exception e2) {
                e = e2;
                Log.d(TAG, e.toString());
                return createBitmap;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            createBitmap = null;
            e = exception;
            Log.d(TAG, e.toString());
            return createBitmap;
        }
        return createBitmap;
    }

    public static Bitmap m6514s(Bitmap bitmap) {
        Bitmap createBitmap;
        if (bitmap.getWidth() >= bitmap.getHeight()) {
            createBitmap = Bitmap.createBitmap(bitmap, (bitmap.getWidth() / 2) - (bitmap.getHeight() / 2), 0, bitmap.getHeight(), bitmap.getHeight());
        } else {
            createBitmap = Bitmap.createBitmap(bitmap, 0, (bitmap.getHeight() / 2) - (bitmap.getWidth() / 2), bitmap.getWidth(), bitmap.getWidth());
        }
        Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap.getWidth(), createBitmap.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap2);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, createBitmap.getWidth(), createBitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-65536);
        canvas.drawOval(rectF, paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(createBitmap, rect, rect, paint);
        createBitmap.recycle();
        return createBitmap2;
    }
}
