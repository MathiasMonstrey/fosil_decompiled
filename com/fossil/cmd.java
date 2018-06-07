package com.fossil;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;

public class cmd implements up<Bitmap> {
    private final int cpv;
    private final int cpw;
    private final vl cxl;

    public cmd(Context context, int i, int i2) {
        this(tx.E(context).tE(), i, i2);
    }

    private cmd(vl vlVar, int i, int i2) {
        this.cxl = vlVar;
        this.cpv = i;
        this.cpw = i2;
    }

    public vh<Bitmap> m7062a(vh<Bitmap> vhVar, int i, int i2) {
        Bitmap createBitmap;
        Bitmap bitmap = (Bitmap) vhVar.get();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap b = this.cxl.b(width, height, Config.ARGB_8888);
        if (b == null) {
            createBitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
        } else {
            createBitmap = b;
        }
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        if (!(this.cpv == 0 || this.cpw == 0)) {
            paint.setColor(this.cpw);
            canvas.drawRect(0.0f, 0.0f, (float) width, (float) height, paint);
        }
        paint.setShader(new BitmapShader(bitmap, TileMode.CLAMP, TileMode.CLAMP));
        canvas.drawRect((float) this.cpv, (float) this.cpv, (float) (width - this.cpv), (float) (height - this.cpv), paint);
        return xp.a(createBitmap, this.cxl);
    }

    public String getId() {
        return "CropBorderRectTransformation()";
    }
}
