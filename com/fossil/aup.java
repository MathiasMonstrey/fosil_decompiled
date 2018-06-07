package com.fossil;

import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;

public abstract class aup<T> extends aug<T> {
    private boolean bgX = false;
    private ArrayList<Integer> bgY;

    protected aup(DataHolder dataHolder) {
        super(dataHolder);
    }

    private final void KP() {
        synchronized (this) {
            if (!this.bgX) {
                int i = this.bgD.bgJ;
                this.bgY = new ArrayList();
                if (i > 0) {
                    this.bgY.add(Integer.valueOf(0));
                    String KO = KO();
                    String k = this.bgD.k(KO, 0, this.bgD.hs(0));
                    int i2 = 1;
                    while (i2 < i) {
                        int hs = this.bgD.hs(i2);
                        String k2 = this.bgD.k(KO, i2, hs);
                        if (k2 == null) {
                            throw new NullPointerException(new StringBuilder(String.valueOf(KO).length() + 78).append("Missing value for markerColumn: ").append(KO).append(", at row: ").append(i2).append(", for window: ").append(hs).toString());
                        }
                        if (k2.equals(k)) {
                            k2 = k;
                        } else {
                            this.bgY.add(Integer.valueOf(i2));
                        }
                        i2++;
                        k = k2;
                    }
                }
                this.bgX = true;
            }
        }
    }

    private final int hw(int i) {
        if (i >= 0 && i < this.bgY.size()) {
            return ((Integer) this.bgY.get(i)).intValue();
        }
        throw new IllegalArgumentException("Position " + i + " is out of bounds for this buffer");
    }

    protected abstract String KO();

    protected abstract T bI(int i, int i2);

    public final T get(int i) {
        int i2;
        KP();
        int hw = hw(i);
        if (i < 0 || i == this.bgY.size()) {
            i2 = 0;
        } else {
            i2 = i == this.bgY.size() + -1 ? this.bgD.bgJ - ((Integer) this.bgY.get(i)).intValue() : ((Integer) this.bgY.get(i + 1)).intValue() - ((Integer) this.bgY.get(i)).intValue();
            if (i2 == 1) {
                this.bgD.hs(hw(i));
            }
        }
        return bI(hw, i2);
    }

    public int getCount() {
        KP();
        return this.bgY.size();
    }
}
