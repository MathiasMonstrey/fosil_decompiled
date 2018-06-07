package com.fossil;

import android.support.v8.renderscript.Allocation;
import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class ug {
    private int aAj = 0;
    private ByteBuffer azF;
    private final byte[] azG = new byte[256];
    private uf azN;

    public ug m13817I(byte[] bArr) {
        reset();
        if (bArr != null) {
            this.azF = ByteBuffer.wrap(bArr);
            this.azF.rewind();
            this.azF.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.azF = null;
            this.azN.status = 2;
        }
        return this;
    }

    public void clear() {
        this.azF = null;
        this.azN = null;
    }

    private void reset() {
        this.azF = null;
        Arrays.fill(this.azG, (byte) 0);
        this.azN = new uf();
        this.aAj = 0;
    }

    public uf um() {
        if (this.azF == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        } else if (uw()) {
            return this.azN;
        } else {
            ur();
            if (!uw()) {
                un();
                if (this.azN.aAb < 0) {
                    this.azN.status = 1;
                }
            }
            return this.azN;
        }
    }

    private void un() {
        int i = 0;
        while (i == 0 && !uw()) {
            switch (read()) {
                case 33:
                    switch (read()) {
                        case 1:
                            uu();
                            break;
                        case 249:
                            this.azN.aAc = new ue();
                            uo();
                            break;
                        case 254:
                            uu();
                            break;
                        case 255:
                            uj();
                            String str = "";
                            for (int i2 = 0; i2 < 11; i2++) {
                                str = str + ((char) this.azG[i2]);
                            }
                            if (!str.equals("NETSCAPE2.0")) {
                                uu();
                                break;
                            } else {
                                uq();
                                break;
                            }
                        default:
                            uu();
                            break;
                    }
                case 44:
                    if (this.azN.aAc == null) {
                        this.azN.aAc = new ue();
                    }
                    up();
                    break;
                case 59:
                    i = 1;
                    break;
                default:
                    this.azN.status = 1;
                    break;
            }
        }
    }

    private void uo() {
        boolean z = true;
        read();
        int read = read();
        this.azN.aAc.azW = (read & 28) >> 2;
        if (this.azN.aAc.azW == 0) {
            this.azN.aAc.azW = 1;
        }
        ue ueVar = this.azN.aAc;
        if ((read & 1) == 0) {
            z = false;
        }
        ueVar.azV = z;
        int uv = uv();
        if (uv < 3) {
            uv = 10;
        }
        this.azN.aAc.delay = uv * 10;
        this.azN.aAc.azX = read();
        read();
    }

    private void up() {
        boolean z = true;
        this.azN.aAc.azR = uv();
        this.azN.aAc.iy = uv();
        this.azN.aAc.azS = uv();
        this.azN.aAc.azT = uv();
        int read = read();
        boolean z2 = (read & Allocation.USAGE_SHARED) != 0;
        int pow = (int) Math.pow(2.0d, (double) ((read & 7) + 1));
        ue ueVar = this.azN.aAc;
        if ((read & 64) == 0) {
            z = false;
        }
        ueVar.azU = z;
        if (z2) {
            this.azN.aAc.azZ = eC(pow);
        } else {
            this.azN.aAc.azZ = null;
        }
        this.azN.aAc.azY = this.azF.position();
        ut();
        if (!uw()) {
            uf ufVar = this.azN;
            ufVar.aAb++;
            this.azN.aAd.add(this.azN.aAc);
        }
    }

    private void uq() {
        do {
            uj();
            if (this.azG[0] == (byte) 1) {
                this.azN.aAi = (this.azG[1] & 255) | ((this.azG[2] & 255) << 8);
            }
            if (this.aAj <= 0) {
                return;
            }
        } while (!uw());
    }

    private void ur() {
        String str = "";
        for (int i = 0; i < 6; i++) {
            str = str + ((char) read());
        }
        if (str.startsWith("GIF")) {
            us();
            if (this.azN.aAe && !uw()) {
                this.azN.aAa = eC(this.azN.aAf);
                this.azN.bgColor = this.azN.aAa[this.azN.aAg];
                return;
            }
            return;
        }
        this.azN.status = 1;
    }

    private void us() {
        this.azN.width = uv();
        this.azN.height = uv();
        int read = read();
        this.azN.aAe = (read & Allocation.USAGE_SHARED) != 0;
        this.azN.aAf = 2 << (read & 7);
        this.azN.aAg = read();
        this.azN.aAh = read();
    }

    private int[] eC(int i) {
        int[] iArr;
        Throwable e;
        int i2 = 0;
        byte[] bArr = new byte[(i * 3)];
        try {
            this.azF.get(bArr);
            iArr = new int[256];
            int i3 = 0;
            while (i2 < i) {
                int i4 = i3 + 1;
                try {
                    int i5 = bArr[i3] & 255;
                    int i6 = i4 + 1;
                    int i7 = bArr[i4] & 255;
                    i3 = i6 + 1;
                    i4 = i2 + 1;
                    iArr[i2] = (((i5 << 16) | -16777216) | (i7 << 8)) | (bArr[i6] & 255);
                    i2 = i4;
                } catch (BufferUnderflowException e2) {
                    e = e2;
                }
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            iArr = null;
            e = th;
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e);
            }
            this.azN.status = 1;
            return iArr;
        }
        return iArr;
    }

    private void ut() {
        read();
        uu();
    }

    private void uu() {
        int read;
        do {
            read = read();
            this.azF.position(this.azF.position() + read);
        } while (read > 0);
    }

    private int uj() {
        int i = 0;
        this.aAj = read();
        if (this.aAj > 0) {
            int i2 = 0;
            while (i < this.aAj) {
                try {
                    i2 = this.aAj - i;
                    this.azF.get(this.azG, i, i2);
                    i += i2;
                } catch (Throwable e) {
                    if (Log.isLoggable("GifHeaderParser", 3)) {
                        Log.d("GifHeaderParser", "Error Reading Block n: " + i + " count: " + i2 + " blockSize: " + this.aAj, e);
                    }
                    this.azN.status = 1;
                }
            }
        }
        return i;
    }

    private int read() {
        int i = 0;
        try {
            return this.azF.get() & 255;
        } catch (Exception e) {
            this.azN.status = 1;
            return i;
        }
    }

    private int uv() {
        return this.azF.getShort();
    }

    private boolean uw() {
        return this.azN.status != 0;
    }
}
