package com.fossil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import okio.ByteString;

class dwh {
    private final eto dyM;
    private int dyN;
    private final etj dyk = etp.m11180c(this.dyM);

    class C32642 extends Inflater {
        final /* synthetic */ dwh dyO;

        C32642(dwh com_fossil_dwh) {
            this.dyO = com_fossil_dwh;
        }

        public int inflate(byte[] bArr, int i, int i2) throws DataFormatException {
            int inflate = super.inflate(bArr, i, i2);
            if (inflate != 0 || !needsDictionary()) {
                return inflate;
            }
            setDictionary(dwl.dyV);
            return super.inflate(bArr, i, i2);
        }
    }

    public dwh(etj com_fossil_etj) {
        this.dyM = new eto(new etl(this, com_fossil_etj) {
            final /* synthetic */ dwh dyO;

            public long mo2733b(eth com_fossil_eth, long j) throws IOException {
                if (this.dyO.dyN == 0) {
                    return -1;
                }
                long b = super.mo2733b(com_fossil_eth, Math.min(j, (long) this.dyO.dyN));
                if (b == -1) {
                    return -1;
                }
                this.dyO.dyN = (int) (((long) this.dyO.dyN) - b);
                return b;
            }
        }, new C32642(this));
    }

    public List<dwc> mO(int i) throws IOException {
        this.dyN += i;
        int readInt = this.dyk.readInt();
        if (readInt < 0) {
            throw new IOException("numberOfPairs < 0: " + readInt);
        } else if (readInt > 1024) {
            throw new IOException("numberOfPairs > 1024: " + readInt);
        } else {
            List<dwc> arrayList = new ArrayList(readInt);
            for (int i2 = 0; i2 < readInt; i2++) {
                ByteString toAsciiLowercase = aAt().toAsciiLowercase();
                ByteString aAt = aAt();
                if (toAsciiLowercase.size() == 0) {
                    throw new IOException("name.size == 0");
                }
                arrayList.add(new dwc(toAsciiLowercase, aAt));
            }
            aAz();
            return arrayList;
        }
    }

    private ByteString aAt() throws IOException {
        return this.dyk.bd((long) this.dyk.readInt());
    }

    private void aAz() throws IOException {
        if (this.dyN > 0) {
            this.dyM.aHD();
            if (this.dyN != 0) {
                throw new IOException("compressedLimit > 0: " + this.dyN);
            }
        }
    }

    public void close() throws IOException {
        this.dyk.close();
    }
}
