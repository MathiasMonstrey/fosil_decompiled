package com.fossil;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.Log;

public final class yc {
    public static Bitmap m14067a(Bitmap bitmap, Bitmap bitmap2, int i, int i2) {
        float f = 0.0f;
        if (bitmap2 == null) {
            return null;
        }
        if (bitmap2.getWidth() == i && bitmap2.getHeight() == i2) {
            return bitmap2;
        }
        float height;
        float width;
        Matrix matrix = new Matrix();
        if (bitmap2.getWidth() * i2 > bitmap2.getHeight() * i) {
            height = ((float) i2) / ((float) bitmap2.getHeight());
            width = (((float) i) - (((float) bitmap2.getWidth()) * height)) * 0.5f;
        } else {
            height = ((float) i) / ((float) bitmap2.getWidth());
            width = 0.0f;
            f = (((float) i2) - (((float) bitmap2.getHeight()) * height)) * 0.5f;
        }
        matrix.setScale(height, height);
        matrix.postTranslate((float) ((int) (width + 0.5f)), (float) ((int) (f + 0.5f)));
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(i, i2, m14072n(bitmap2));
        }
        m14071a(bitmap2, bitmap);
        new Canvas(bitmap).drawBitmap(bitmap2, matrix, new Paint(6));
        return bitmap;
    }

    public static Bitmap m14069a(Bitmap bitmap, vl vlVar, int i, int i2) {
        if (bitmap.getWidth() != i || bitmap.getHeight() != i2) {
            float min = Math.min(((float) i) / ((float) bitmap.getWidth()), ((float) i2) / ((float) bitmap.getHeight()));
            int width = (int) (((float) bitmap.getWidth()) * min);
            int height = (int) (((float) bitmap.getHeight()) * min);
            if (bitmap.getWidth() != width || bitmap.getHeight() != height) {
                Config n = m14072n(bitmap);
                Bitmap b = vlVar.mo4214b(width, height, n);
                if (b == null) {
                    b = Bitmap.createBitmap(width, height, n);
                }
                m14071a(bitmap, b);
                if (Log.isLoggable("TransformationUtils", 2)) {
                    Log.v("TransformationUtils", "request: " + i + "x" + i2);
                    Log.v("TransformationUtils", "toFit:   " + bitmap.getWidth() + "x" + bitmap.getHeight());
                    Log.v("TransformationUtils", "toReuse: " + b.getWidth() + "x" + b.getHeight());
                    Log.v("TransformationUtils", "minPct:   " + min);
                }
                Canvas canvas = new Canvas(b);
                Matrix matrix = new Matrix();
                matrix.setScale(min, min);
                canvas.drawBitmap(bitmap, matrix, new Paint(6));
                return b;
            } else if (!Log.isLoggable("TransformationUtils", 2)) {
                return bitmap;
            } else {
                Log.v("TransformationUtils", "adjusted target size matches input, returning input");
                return bitmap;
            }
        } else if (!Log.isLoggable("TransformationUtils", 2)) {
            return bitmap;
        } else {
            Log.v("TransformationUtils", "requested target size matches input, returning input");
            return bitmap;
        }
    }

    @TargetApi(12)
    public static void m14071a(Bitmap bitmap, Bitmap bitmap2) {
        if (VERSION.SDK_INT >= 12 && bitmap2 != null) {
            bitmap2.setHasAlpha(bitmap.hasAlpha());
        }
    }

    public static int eM(int i) {
        switch (i) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    public static Bitmap m14068a(Bitmap bitmap, vl vlVar, int i) {
        Matrix matrix = new Matrix();
        m14070a(i, matrix);
        if (matrix.isIdentity()) {
            return bitmap;
        }
        RectF rectF = new RectF(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight());
        matrix.mapRect(rectF);
        int round = Math.round(rectF.width());
        int round2 = Math.round(rectF.height());
        Config n = m14072n(bitmap);
        Bitmap b = vlVar.mo4214b(round, round2, n);
        if (b == null) {
            b = Bitmap.createBitmap(round, round2, n);
        }
        matrix.postTranslate(-rectF.left, -rectF.top);
        new Canvas(b).drawBitmap(bitmap, matrix, new Paint(6));
        return b;
    }

    private static Config m14072n(Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : Config.ARGB_8888;
    }

    static void m14070a(int i, Matrix matrix) {
        switch (i) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                return;
            case 3:
                matrix.setRotate(180.0f);
                return;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 6:
                matrix.setRotate(90.0f);
                return;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 8:
                matrix.setRotate(-90.0f);
                return;
            default:
                return;
        }
    }
}
