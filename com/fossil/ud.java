package com.fossil;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class ud {
    private static final String TAG = ud.class.getSimpleName();
    private static final Config azC = Config.ARGB_8888;
    private int[] azD;
    private final int[] azE = new int[256];
    private ByteBuffer azF;
    private final byte[] azG = new byte[256];
    private short[] azH;
    private byte[] azI;
    private byte[] azJ;
    private byte[] azK;
    private int[] azL;
    private int azM;
    private uf azN;
    private C4136a azO;
    private Bitmap azP;
    private boolean azQ;
    private byte[] data;
    private int status;

    public interface C4136a {
        Bitmap mo4440a(int i, int i2, Config config);

        void mo4441d(Bitmap bitmap);
    }

    public ud(C4136a c4136a) {
        this.azO = c4136a;
        this.azN = new uf();
    }

    public void advance() {
        this.azM = (this.azM + 1) % this.azN.aAb;
    }

    public int eB(int i) {
        if (i < 0 || i >= this.azN.aAb) {
            return -1;
        }
        return ((ue) this.azN.aAd.get(i)).delay;
    }

    public int uf() {
        if (this.azN.aAb <= 0 || this.azM < 0) {
            return -1;
        }
        return eB(this.azM);
    }

    public int getFrameCount() {
        return this.azN.aAb;
    }

    public int ug() {
        return this.azM;
    }

    public int uh() {
        if (this.azN.aAi == -1) {
            return 1;
        }
        if (this.azN.aAi == 0) {
            return 0;
        }
        return this.azN.aAi + 1;
    }

    public synchronized Bitmap ui() {
        Bitmap bitmap;
        if (this.azN.aAb <= 0 || this.azM < 0) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "unable to decode frame, frameCount=" + this.azN.aAb + " framePointer=" + this.azM);
            }
            this.status = 1;
        }
        if (this.status == 1 || this.status == 2) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Unable to decode frame, status=" + this.status);
            }
            bitmap = null;
        } else {
            ue ueVar;
            this.status = 0;
            ue ueVar2 = (ue) this.azN.aAd.get(this.azM);
            int i = this.azM - 1;
            if (i >= 0) {
                ueVar = (ue) this.azN.aAd.get(i);
            } else {
                ueVar = null;
            }
            this.azD = ueVar2.azZ != null ? ueVar2.azZ : this.azN.aAa;
            if (this.azD == null) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "No Valid Color Table");
                }
                this.status = 1;
                bitmap = null;
            } else {
                if (ueVar2.azV) {
                    System.arraycopy(this.azD, 0, this.azE, 0, this.azD.length);
                    this.azD = this.azE;
                    this.azD[ueVar2.azX] = 0;
                }
                bitmap = m13813a(ueVar2, ueVar);
            }
        }
        return bitmap;
    }

    public void clear() {
        this.azN = null;
        this.data = null;
        this.azK = null;
        this.azL = null;
        if (this.azP != null) {
            this.azO.mo4441d(this.azP);
        }
        this.azP = null;
        this.azF = null;
    }

    public void m13816a(uf ufVar, byte[] bArr) {
        this.azN = ufVar;
        this.data = bArr;
        this.status = 0;
        this.azM = -1;
        this.azF = ByteBuffer.wrap(bArr);
        this.azF.rewind();
        this.azF.order(ByteOrder.LITTLE_ENDIAN);
        this.azQ = false;
        for (ue ueVar : ufVar.aAd) {
            if (ueVar.azW == 3) {
                this.azQ = true;
                break;
            }
        }
        this.azK = new byte[(ufVar.width * ufVar.height)];
        this.azL = new int[(ufVar.width * ufVar.height)];
    }

    private Bitmap m13813a(ue ueVar, ue ueVar2) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6 = this.azN.width;
        int i7 = this.azN.height;
        int[] iArr = this.azL;
        if (ueVar2 == null) {
            Arrays.fill(iArr, 0);
        }
        if (ueVar2 != null && ueVar2.azW > 0) {
            if (ueVar2.azW == 2) {
                i = 0;
                if (!ueVar.azV) {
                    i = this.azN.bgColor;
                    if (ueVar.azZ != null && this.azN.aAg == ueVar.azX) {
                        i = 0;
                    }
                }
                i2 = ueVar2.azR + (ueVar2.iy * i6);
                i3 = i2 + (ueVar2.azT * i6);
                while (i2 < i3) {
                    i4 = i2 + ueVar2.azS;
                    for (i5 = i2; i5 < i4; i5++) {
                        iArr[i5] = i;
                    }
                    i2 += i6;
                }
            } else if (ueVar2.azW == 3 && this.azP != null) {
                this.azP.getPixels(iArr, 0, i6, 0, 0, i6, i7);
            }
        }
        m13814a(ueVar);
        i3 = 1;
        i2 = 8;
        i5 = 0;
        for (i = 0; i < ueVar.azT; i++) {
            if (ueVar.azU) {
                if (i5 >= ueVar.azT) {
                    i3++;
                    switch (i3) {
                        case 2:
                            i5 = 4;
                            break;
                        case 3:
                            i5 = 2;
                            i2 = 4;
                            break;
                        case 4:
                            i5 = 1;
                            i2 = 2;
                            break;
                    }
                }
                int i8 = i5;
                i5 += i2;
                i4 = i8;
            } else {
                i4 = i;
            }
            i4 += ueVar.iy;
            if (i4 < this.azN.height) {
                int i9 = this.azN.width * i4;
                int i10 = i9 + ueVar.azR;
                i4 = ueVar.azS + i10;
                if (this.azN.width + i9 < i4) {
                    i4 = this.azN.width + i9;
                }
                i9 = ueVar.azS * i;
                int i11 = i10;
                while (i11 < i4) {
                    i10 = i9 + 1;
                    i9 = this.azD[this.azK[i9] & 255];
                    if (i9 != 0) {
                        iArr[i11] = i9;
                    }
                    i11++;
                    i9 = i10;
                }
            }
        }
        if (this.azQ && (ueVar.azW == 0 || ueVar.azW == 1)) {
            if (this.azP == null) {
                this.azP = uk();
            }
            this.azP.setPixels(iArr, 0, i6, 0, 0, i6, i7);
        }
        Bitmap uk = uk();
        uk.setPixels(iArr, 0, i6, 0, 0, i6, i7);
        return uk;
    }

    private void m13814a(ue ueVar) {
        int i;
        int i2;
        if (ueVar != null) {
            this.azF.position(ueVar.azY);
        }
        if (ueVar == null) {
            i = this.azN.width * this.azN.height;
        } else {
            i = ueVar.azS * ueVar.azT;
        }
        if (this.azK == null || this.azK.length < i) {
            this.azK = new byte[i];
        }
        if (this.azH == null) {
            this.azH = new short[4096];
        }
        if (this.azI == null) {
            this.azI = new byte[4096];
        }
        if (this.azJ == null) {
            this.azJ = new byte[4097];
        }
        int read = read();
        int i3 = 1 << read;
        int i4 = i3 + 1;
        int i5 = i3 + 2;
        int i6 = -1;
        int i7 = read + 1;
        int i8 = (1 << i7) - 1;
        for (i2 = 0; i2 < i3; i2++) {
            this.azH[i2] = (short) 0;
            this.azI[i2] = (byte) i2;
        }
        i2 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = i7;
        int i14 = i8;
        int i15 = i5;
        i7 = 0;
        i8 = 0;
        i5 = 0;
        while (i9 < i) {
            if (i8 == 0) {
                i8 = uj();
                if (i8 <= 0) {
                    this.status = 3;
                    break;
                }
                i7 = 0;
            }
            i2 += (this.azG[i7] & 255) << i12;
            int i16 = i7 + 1;
            int i17 = i8 - 1;
            i7 = i13;
            i8 = i14;
            i13 = i11;
            int i18 = i12 + 8;
            i12 = i2;
            i2 = i5;
            i5 = i15;
            i15 = i18;
            while (i15 >= i7) {
                i11 = i12 & i8;
                i14 = i12 >> i7;
                i15 -= i7;
                if (i11 == i3) {
                    i7 = read + 1;
                    i8 = (1 << i7) - 1;
                    i5 = i3 + 2;
                    i12 = i14;
                    i6 = -1;
                } else if (i11 > i5) {
                    this.status = 3;
                    i11 = i13;
                    i12 = i15;
                    i13 = i7;
                    i15 = i5;
                    i7 = i16;
                    i5 = i2;
                    i2 = i14;
                    i14 = i8;
                    i8 = i17;
                    break;
                } else if (i11 == i4) {
                    i11 = i13;
                    i12 = i15;
                    i13 = i7;
                    i15 = i5;
                    i7 = i16;
                    i5 = i2;
                    i2 = i14;
                    i14 = i8;
                    i8 = i17;
                    break;
                } else if (i6 == -1) {
                    i12 = i10 + 1;
                    this.azJ[i10] = this.azI[i11];
                    i10 = i12;
                    i13 = i11;
                    i6 = i11;
                    i12 = i14;
                } else {
                    if (i11 >= i5) {
                        i12 = i10 + 1;
                        this.azJ[i10] = (byte) i13;
                        i10 = i12;
                        i13 = i6;
                    } else {
                        i13 = i11;
                    }
                    while (i13 >= i3) {
                        i12 = i10 + 1;
                        this.azJ[i10] = this.azI[i13];
                        short s = this.azH[i13];
                        i10 = i12;
                    }
                    i13 = this.azI[i13] & 255;
                    i12 = i10 + 1;
                    this.azJ[i10] = (byte) i13;
                    if (i5 < 4096) {
                        this.azH[i5] = (short) i6;
                        this.azI[i5] = (byte) i13;
                        i5++;
                        if ((i5 & i8) == 0 && i5 < 4096) {
                            i7++;
                            i8 += i5;
                        }
                    }
                    i10 = i9;
                    while (i12 > 0) {
                        i9 = i12 - 1;
                        i12 = i2 + 1;
                        this.azK[i2] = this.azJ[i9];
                        i10++;
                        i2 = i12;
                        i12 = i9;
                    }
                    i9 = i10;
                    i6 = i11;
                    i10 = i12;
                    i12 = i14;
                }
            }
            i11 = i13;
            i14 = i8;
            i8 = i17;
            i13 = i7;
            i7 = i16;
            i18 = i15;
            i15 = i5;
            i5 = i2;
            i2 = i12;
            i12 = i18;
        }
        for (i7 = i5; i7 < i; i7++) {
            this.azK[i7] = (byte) 0;
        }
    }

    private int read() {
        int i = 0;
        try {
            return this.azF.get() & 255;
        } catch (Exception e) {
            this.status = 1;
            return i;
        }
    }

    private int uj() {
        int read = read();
        int i = 0;
        if (read > 0) {
            while (i < read) {
                int i2 = read - i;
                try {
                    this.azF.get(this.azG, i, i2);
                    i += i2;
                } catch (Throwable e) {
                    Log.w(TAG, "Error Reading Block", e);
                    this.status = 1;
                }
            }
        }
        return i;
    }

    private Bitmap uk() {
        Bitmap a = this.azO.mo4440a(this.azN.width, this.azN.height, azC);
        if (a == null) {
            a = Bitmap.createBitmap(this.azN.width, this.azN.height, azC);
        }
        m13815c(a);
        return a;
    }

    @TargetApi(12)
    private static void m13815c(Bitmap bitmap) {
        if (VERSION.SDK_INT >= 12) {
            bitmap.setHasAlpha(true);
        }
    }
}
