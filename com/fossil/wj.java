package com.fossil;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.Priority;
import java.io.InputStream;

public class wj<A> implements wp<A, wk> {
    private final wp<A, InputStream> aDr;
    private final wp<A, ParcelFileDescriptor> aDs;

    static class C4198a implements us<wk> {
        private final us<InputStream> aDt;
        private final us<ParcelFileDescriptor> aDu;

        public /* synthetic */ Object mo4186d(Priority priority) throws Exception {
            return m13995f(priority);
        }

        public C4198a(us<InputStream> usVar, us<ParcelFileDescriptor> usVar2) {
            this.aDt = usVar;
            this.aDu = usVar2;
        }

        public wk m13995f(Priority priority) throws Exception {
            InputStream inputStream;
            ParcelFileDescriptor parcelFileDescriptor = null;
            if (this.aDt != null) {
                try {
                    inputStream = (InputStream) this.aDt.mo4186d(priority);
                } catch (Throwable e) {
                    if (Log.isLoggable("IVML", 2)) {
                        Log.v("IVML", "Exception fetching input stream, trying ParcelFileDescriptor", e);
                    }
                    if (this.aDu == null) {
                        throw e;
                    }
                }
                if (this.aDu != null) {
                    try {
                        parcelFileDescriptor = (ParcelFileDescriptor) this.aDu.mo4186d(priority);
                    } catch (Throwable e2) {
                        if (Log.isLoggable("IVML", 2)) {
                            Log.v("IVML", "Exception fetching ParcelFileDescriptor", e2);
                        }
                        if (inputStream == null) {
                            throw e2;
                        }
                    }
                }
                return new wk(inputStream, parcelFileDescriptor);
            }
            inputStream = null;
            if (this.aDu != null) {
                parcelFileDescriptor = (ParcelFileDescriptor) this.aDu.mo4186d(priority);
            }
            return new wk(inputStream, parcelFileDescriptor);
        }

        public void lG() {
            if (this.aDt != null) {
                this.aDt.lG();
            }
            if (this.aDu != null) {
                this.aDu.lG();
            }
        }

        public String getId() {
            if (this.aDt != null) {
                return this.aDt.getId();
            }
            return this.aDu.getId();
        }

        public void cancel() {
            if (this.aDt != null) {
                this.aDt.cancel();
            }
            if (this.aDu != null) {
                this.aDu.cancel();
            }
        }
    }

    public wj(wp<A, InputStream> wpVar, wp<A, ParcelFileDescriptor> wpVar2) {
        if (wpVar == null && wpVar2 == null) {
            throw new NullPointerException("At least one of streamLoader and fileDescriptorLoader must be non null");
        }
        this.aDr = wpVar;
        this.aDs = wpVar2;
    }

    public us<wk> mo4419c(A a, int i, int i2) {
        us c;
        us c2;
        if (this.aDr != null) {
            c = this.aDr.mo4419c(a, i, i2);
        } else {
            c = null;
        }
        if (this.aDs != null) {
            c2 = this.aDs.mo4419c(a, i, i2);
        } else {
            c2 = null;
        }
        if (c == null && c2 == null) {
            return null;
        }
        return new C4198a(c, c2);
    }
}
