package com.fossil;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;

public class cmn extends xq {
    public cmn(Context context) {
        super(context);
    }

    protected Bitmap m7101a(vl vlVar, Bitmap bitmap, int i, int i2) {
        return m7100a(vlVar, bitmap);
    }

    private static Bitmap m7100a(vl vlVar, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, (bitmap.getWidth() - min) / 2, (bitmap.getHeight() - min) / 2, min, min);
        Bitmap b = vlVar.b(min, min, Config.ARGB_8888);
        if (b == null) {
            b = Bitmap.createBitmap(min, min, Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(b);
        Paint paint = new Paint();
        paint.setShader(new BitmapShader(createBitmap, TileMode.CLAMP, TileMode.CLAMP));
        paint.setAntiAlias(true);
        float f = ((float) min) / 2.0f;
        canvas.drawCircle(f, f, f, paint);
        return b;
    }

    public String getId() {
        return getClass().getName();
    }
}
