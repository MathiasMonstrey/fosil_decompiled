package com.fossil;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;

public class cmc implements up<Bitmap> {
    private final int cpv;
    private final int cpw;
    private final vl cxl;

    public cmc(Context context) {
        this(tx.E(context).tE(), 0, 0);
    }

    public cmc(Context context, int i, int i2) {
        this(tx.E(context).tE(), i, i2);
    }

    private cmc(vl vlVar, int i, int i2) {
        this.cxl = vlVar;
        this.cpv = i;
        this.cpw = i2;
    }

    public vh<Bitmap> m7061a(vh<Bitmap> vhVar, int i, int i2) {
        Bitmap bitmap = (Bitmap) vhVar.get();
        int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
        int width = (bitmap.getWidth() - min) / 2;
        int height = (bitmap.getHeight() - min) / 2;
        Bitmap b = this.cxl.b(min, min, Config.ARGB_8888);
        if (b == null) {
            b = Bitmap.createBitmap(min, min, Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(b);
        Paint paint = new Paint(1);
        float f = ((float) min) / 2.0f;
        if (!(this.cpv == 0 || this.cpw == 0)) {
            paint.setColor(this.cpw);
            canvas.drawCircle(f, f, f, paint);
        }
        Shader bitmapShader = new BitmapShader(bitmap, TileMode.CLAMP, TileMode.CLAMP);
        if (!(width == 0 && height == 0)) {
            Matrix matrix = new Matrix();
            matrix.setTranslate((float) (-width), (float) (-height));
            bitmapShader.setLocalMatrix(matrix);
        }
        paint.setShader(bitmapShader);
        canvas.drawCircle(f, f, f - ((float) this.cpv), paint);
        return xp.a(b, this.cxl);
    }

    public String getId() {
        return "CropBorderCircleTransformation()";
    }
}
