package com.fossil;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v8.renderscript.Allocation;
import android.util.Log;
import java.io.IOException;
import java.io.OutputStream;

public class uh {
    private Integer aAk = null;
    private Bitmap aAl;
    private byte[] aAm;
    private byte[] aAn;
    private int aAo;
    private byte[] aAp;
    private boolean[] aAq = new boolean[256];
    private int aAr = 7;
    private boolean aAs = false;
    private boolean aAt = true;
    private boolean aAu = false;
    private int aAv = 10;
    private boolean aAw;
    private int azW = -1;
    private int azX;
    private int delay = 0;
    private int height;
    private OutputStream out;
    private int repeat = -1;
    private boolean started = false;
    private int width;

    public void eD(int i) {
        this.delay = Math.round(((float) i) / 10.0f);
    }

    public boolean m13819e(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.aAu) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.aAl = bitmap;
            uz();
            uy();
            if (this.aAt) {
                uC();
                uE();
                if (this.repeat >= 0) {
                    uD();
                }
            }
            uA();
            uB();
            if (!this.aAt) {
                uE();
            }
            uF();
            this.aAt = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean ux() {
        if (!this.started) {
            return false;
        }
        boolean z;
        this.started = false;
        try {
            this.out.write(59);
            this.out.flush();
            if (this.aAs) {
                this.out.close();
            }
            z = true;
        } catch (IOException e) {
            z = false;
        }
        this.azX = 0;
        this.out = null;
        this.aAl = null;
        this.aAm = null;
        this.aAn = null;
        this.aAp = null;
        this.aAs = false;
        this.aAt = true;
        return z;
    }

    public void setSize(int i, int i2) {
        if (!this.started || this.aAt) {
            this.width = i;
            this.height = i2;
            if (this.width < 1) {
                this.width = 320;
            }
            if (this.height < 1) {
                this.height = 240;
            }
            this.aAu = true;
        }
    }

    public boolean m13818a(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.aAs = false;
        this.out = outputStream;
        try {
            writeString("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.started = z;
        return z;
    }

    private void uy() {
        int length = this.aAm.length;
        int i = length / 3;
        this.aAn = new byte[i];
        uj ujVar = new uj(this.aAm, length, this.aAv);
        this.aAp = ujVar.uK();
        for (length = 0; length < this.aAp.length; length += 3) {
            byte b = this.aAp[length];
            this.aAp[length] = this.aAp[length + 2];
            this.aAp[length + 2] = b;
            this.aAq[length / 3] = false;
        }
        int i2 = 0;
        for (length = 0; length < i; length++) {
            int i3 = i2 + 1;
            int i4 = i3 + 1;
            i2 = i4 + 1;
            int r = ujVar.m13827r(this.aAm[i2] & 255, this.aAm[i3] & 255, this.aAm[i4] & 255);
            this.aAq[r] = true;
            this.aAn[length] = (byte) r;
        }
        this.aAm = null;
        this.aAo = 8;
        this.aAr = 7;
        if (this.aAk != null) {
            this.azX = eE(this.aAk.intValue());
        } else if (this.aAw) {
            this.azX = eE(0);
        }
    }

    private int eE(int i) {
        int i2 = 0;
        if (this.aAp == null) {
            return -1;
        }
        int red = Color.red(i);
        int green = Color.green(i);
        int blue = Color.blue(i);
        int i3 = 16777216;
        int length = this.aAp.length;
        int i4 = 0;
        while (i2 < length) {
            int i5 = i2 + 1;
            i2 = red - (this.aAp[i2] & 255);
            int i6 = i5 + 1;
            int i7 = green - (this.aAp[i5] & 255);
            i5 = blue - (this.aAp[i6] & 255);
            i2 = ((i2 * i2) + (i7 * i7)) + (i5 * i5);
            i7 = i6 / 3;
            if (!this.aAq[i7] || i2 >= i3) {
                i2 = i3;
                i3 = i4;
            } else {
                i3 = i7;
            }
            i4 = i3;
            i3 = i2;
            i2 = i6 + 1;
        }
        return i4;
    }

    private void uz() {
        boolean z = false;
        int width = this.aAl.getWidth();
        int height = this.aAl.getHeight();
        if (!(width == this.width && height == this.height)) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Config.ARGB_8888);
            new Canvas(createBitmap).drawBitmap(createBitmap, 0.0f, 0.0f, null);
            this.aAl = createBitmap;
        }
        int[] iArr = new int[(width * height)];
        this.aAl.getPixels(iArr, 0, width, 0, 0, width, height);
        this.aAm = new byte[(iArr.length * 3)];
        this.aAw = false;
        int i = 0;
        int i2 = 0;
        for (int i3 : iArr) {
            if (i3 == 0) {
                i++;
            }
            int i4 = i2 + 1;
            this.aAm[i2] = (byte) (i3 & 255);
            height = i4 + 1;
            this.aAm[i4] = (byte) ((i3 >> 8) & 255);
            i2 = height + 1;
            this.aAm[height] = (byte) ((i3 >> 16) & 255);
        }
        double length = ((double) (i * 100)) / ((double) iArr.length);
        if (length > 4.0d) {
            z = true;
        }
        this.aAw = z;
        if (Log.isLoggable("AnimatedGifEncoder", 3)) {
            Log.d("AnimatedGifEncoder", "got pixels for frame with " + length + "% transparent pixels");
        }
    }

    private void uA() throws IOException {
        int i;
        int i2;
        this.out.write(33);
        this.out.write(249);
        this.out.write(4);
        if (this.aAk != null || this.aAw) {
            i = 1;
            i2 = 2;
        } else {
            i2 = 0;
            i = 0;
        }
        if (this.azW >= 0) {
            i2 = this.azW & 7;
        }
        this.out.write((((i2 << 2) | 0) | 0) | i);
        writeShort(this.delay);
        this.out.write(this.azX);
        this.out.write(0);
    }

    private void uB() throws IOException {
        this.out.write(44);
        writeShort(0);
        writeShort(0);
        writeShort(this.width);
        writeShort(this.height);
        if (this.aAt) {
            this.out.write(0);
        } else {
            this.out.write(this.aAr | Allocation.USAGE_SHARED);
        }
    }

    private void uC() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.out.write(this.aAr | 240);
        this.out.write(0);
        this.out.write(0);
    }

    private void uD() throws IOException {
        this.out.write(33);
        this.out.write(255);
        this.out.write(11);
        writeString("NETSCAPE2.0");
        this.out.write(3);
        this.out.write(1);
        writeShort(this.repeat);
        this.out.write(0);
    }

    private void uE() throws IOException {
        this.out.write(this.aAp, 0, this.aAp.length);
        int length = 768 - this.aAp.length;
        for (int i = 0; i < length; i++) {
            this.out.write(0);
        }
    }

    private void uF() throws IOException {
        new ui(this.width, this.height, this.aAn, this.aAo).encode(this.out);
    }

    private void writeShort(int i) throws IOException {
        this.out.write(i & 255);
        this.out.write((i >> 8) & 255);
    }

    private void writeString(String str) throws IOException {
        for (int i = 0; i < str.length(); i++) {
            this.out.write((byte) str.charAt(i));
        }
    }
}
