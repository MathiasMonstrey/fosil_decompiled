package com.fossil;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.os.Build.VERSION;
import android.renderscript.Allocation;
import android.renderscript.Allocation.MipmapControl;
import android.renderscript.Element;
import android.renderscript.RSRuntimeException;
import android.renderscript.RenderScript;
import android.renderscript.RenderScript.RSMessageHandler;
import android.renderscript.ScriptIntrinsicBlur;
import java.lang.reflect.Array;

public class dru {
    public static Bitmap m9555a(Context context, Bitmap bitmap, drx com_fossil_drx) {
        if (drw.m9563k(com_fossil_drx.width / com_fossil_drx.dob, com_fossil_drx.height / com_fossil_drx.dob)) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(com_fossil_drx.width / com_fossil_drx.dob, com_fossil_drx.height / com_fossil_drx.dob, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.scale(1.0f / ((float) com_fossil_drx.dob), 1.0f / ((float) com_fossil_drx.dob));
        Paint paint = new Paint();
        paint.setFlags(3);
        paint.setColorFilter(new PorterDuffColorFilter(com_fossil_drx.color, Mode.SRC_ATOP));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        if (VERSION.SDK_INT >= 18) {
            try {
                createBitmap = m9554a(context, createBitmap, com_fossil_drx.radius);
            } catch (Exception e) {
                createBitmap = m9556a(createBitmap, com_fossil_drx.radius, true);
            }
        } else {
            createBitmap = m9556a(createBitmap, com_fossil_drx.radius, true);
        }
        if (com_fossil_drx.dob == 1) {
            return createBitmap;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(createBitmap, com_fossil_drx.width, com_fossil_drx.height, true);
        createBitmap.recycle();
        return createScaledBitmap;
    }

    @TargetApi(18)
    public static Bitmap m9554a(Context context, Bitmap bitmap, int i) throws RSRuntimeException {
        RenderScript renderScript = null;
        try {
            renderScript = RenderScript.create(context);
            renderScript.setMessageHandler(new RSMessageHandler());
            Allocation createFromBitmap = Allocation.createFromBitmap(renderScript, bitmap, MipmapControl.MIPMAP_NONE, 1);
            Allocation createTyped = Allocation.createTyped(renderScript, createFromBitmap.getType());
            ScriptIntrinsicBlur create = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
            create.setInput(createFromBitmap);
            create.setRadius((float) i);
            create.forEach(createTyped);
            createTyped.copyTo(bitmap);
            return bitmap;
        } finally {
            if (renderScript != null) {
                renderScript.destroy();
            }
        }
    }

    public static Bitmap m9556a(Bitmap bitmap, int i, boolean z) {
        Bitmap bitmap2;
        if (z) {
            bitmap2 = bitmap;
        } else {
            bitmap2 = bitmap.copy(bitmap.getConfig(), true);
        }
        if (i < 1) {
            return null;
        }
        int i2;
        int width = bitmap2.getWidth();
        int height = bitmap2.getHeight();
        int[] iArr = new int[(width * height)];
        bitmap2.getPixels(iArr, 0, width, 0, 0, width, height);
        int i3 = width - 1;
        int i4 = height - 1;
        int i5 = width * height;
        int i6 = (i + i) + 1;
        int[] iArr2 = new int[i5];
        int[] iArr3 = new int[i5];
        int[] iArr4 = new int[i5];
        int[] iArr5 = new int[Math.max(width, height)];
        i5 = (i6 + 1) >> 1;
        int i7 = i5 * i5;
        int[] iArr6 = new int[(i7 * 256)];
        for (i5 = 0; i5 < i7 * 256; i5++) {
            iArr6[i5] = i5 / i7;
        }
        int[][] iArr7 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{i6, 3});
        int i8 = i + 1;
        int i9 = 0;
        int i10 = 0;
        for (i2 = 0; i2 < height; i2++) {
            int i11;
            int i12;
            i7 = 0;
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            for (i11 = -i; i11 <= i; i11++) {
                i12 = iArr[Math.min(i3, Math.max(i11, 0)) + i10];
                int[] iArr8 = iArr7[i11 + i];
                iArr8[0] = (16711680 & i12) >> 16;
                iArr8[1] = (65280 & i12) >> 8;
                iArr8[2] = i12 & 255;
                i12 = i8 - Math.abs(i11);
                i19 += iArr8[0] * i12;
                i18 += iArr8[1] * i12;
                i17 += i12 * iArr8[2];
                if (i11 > 0) {
                    i13 += iArr8[0];
                    i20 += iArr8[1];
                    i7 += iArr8[2];
                } else {
                    i16 += iArr8[0];
                    i15 += iArr8[1];
                    i14 += iArr8[2];
                }
            }
            i12 = i19;
            i19 = i18;
            i18 = i17;
            i11 = i10;
            i10 = i;
            for (i17 = 0; i17 < width; i17++) {
                iArr2[i11] = iArr6[i12];
                iArr3[i11] = iArr6[i19];
                iArr4[i11] = iArr6[i18];
                i12 -= i16;
                i19 -= i15;
                i18 -= i14;
                iArr8 = iArr7[((i10 - i) + i6) % i6];
                i16 -= iArr8[0];
                i15 -= iArr8[1];
                i14 -= iArr8[2];
                if (i2 == 0) {
                    iArr5[i17] = Math.min((i17 + i) + 1, i3);
                }
                int i21 = iArr[iArr5[i17] + i9];
                iArr8[0] = (16711680 & i21) >> 16;
                iArr8[1] = (65280 & i21) >> 8;
                iArr8[2] = i21 & 255;
                i13 += iArr8[0];
                i20 += iArr8[1];
                i7 += iArr8[2];
                i12 += i13;
                i19 += i20;
                i18 += i7;
                i10 = (i10 + 1) % i6;
                iArr8 = iArr7[i10 % i6];
                i16 += iArr8[0];
                i15 += iArr8[1];
                i14 += iArr8[2];
                i13 -= iArr8[0];
                i20 -= iArr8[1];
                i7 -= iArr8[2];
                i11++;
            }
            i9 += width;
            i10 = i11;
        }
        for (i17 = 0; i17 < width; i17++) {
            i20 = 0;
            i7 = (-i) * width;
            i14 = 0;
            i15 = 0;
            i16 = 0;
            i10 = 0;
            i12 = -i;
            i11 = 0;
            i18 = 0;
            i19 = 0;
            i13 = 0;
            while (i12 <= i) {
                i2 = Math.max(0, i7) + i17;
                int[] iArr9 = iArr7[i12 + i];
                iArr9[0] = iArr2[i2];
                iArr9[1] = iArr3[i2];
                iArr9[2] = iArr4[i2];
                int abs = i8 - Math.abs(i12);
                i9 = (iArr2[i2] * abs) + i19;
                i19 = (iArr3[i2] * abs) + i18;
                i18 = (iArr4[i2] * abs) + i11;
                if (i12 > 0) {
                    i14 += iArr9[0];
                    i13 += iArr9[1];
                    i20 += iArr9[2];
                } else {
                    i10 += iArr9[0];
                    i16 += iArr9[1];
                    i15 += iArr9[2];
                }
                if (i12 < i4) {
                    i7 += width;
                }
                i12++;
                i11 = i18;
                i18 = i19;
                i19 = i9;
            }
            i12 = i18;
            i9 = i19;
            i19 = i11;
            i11 = i17;
            i7 = i20;
            i20 = i13;
            i13 = i14;
            i14 = i15;
            i15 = i16;
            i16 = i10;
            i10 = i;
            for (i18 = 0; i18 < height; i18++) {
                iArr[i11] = (((-16777216 & iArr[i11]) | (iArr6[i9] << 16)) | (iArr6[i12] << 8)) | iArr6[i19];
                i9 -= i16;
                i12 -= i15;
                i19 -= i14;
                int[] iArr10 = iArr7[((i10 - i) + i6) % i6];
                i16 -= iArr10[0];
                i15 -= iArr10[1];
                i14 -= iArr10[2];
                if (i17 == 0) {
                    iArr5[i18] = Math.min(i18 + i8, i4) * width;
                }
                i3 = iArr5[i18] + i17;
                iArr10[0] = iArr2[i3];
                iArr10[1] = iArr3[i3];
                iArr10[2] = iArr4[i3];
                i13 += iArr10[0];
                i20 += iArr10[1];
                i7 += iArr10[2];
                i9 += i13;
                i12 += i20;
                i19 += i7;
                i10 = (i10 + 1) % i6;
                iArr10 = iArr7[i10];
                i16 += iArr10[0];
                i15 += iArr10[1];
                i14 += iArr10[2];
                i13 -= iArr10[0];
                i20 -= iArr10[1];
                i7 -= iArr10[2];
                i11 += width;
            }
        }
        bitmap2.setPixels(iArr, 0, width, 0, 0, width, height);
        return bitmap2;
    }
}
