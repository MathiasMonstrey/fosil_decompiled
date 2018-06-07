package com.fossil;

import android.content.Context;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class eoi<T> {
    protected final enj aIg;
    protected final Context context;
    protected final eoh<T> dOX;
    protected final eol dOY;
    private final int dOZ;
    protected volatile long dPa;
    protected final List<eom> dPb = new CopyOnWriteArrayList();

    class C34851 implements Comparator<C3486a> {
        final /* synthetic */ eoi dPc;

        C34851(eoi com_fossil_eoi) {
            this.dPc = com_fossil_eoi;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m10984a((C3486a) obj, (C3486a) obj2);
        }

        public int m10984a(C3486a c3486a, C3486a c3486a2) {
            return (int) (c3486a.timestamp - c3486a2.timestamp);
        }
    }

    static class C3486a {
        final File file;
        final long timestamp;

        public C3486a(File file, long j) {
            this.file = file;
            this.timestamp = j;
        }
    }

    protected abstract String xo();

    public eoi(Context context, eoh<T> com_fossil_eoh_T, enj com_fossil_enj, eol com_fossil_eol, int i) throws IOException {
        this.context = context.getApplicationContext();
        this.dOX = com_fossil_eoh_T;
        this.dOY = com_fossil_eol;
        this.aIg = com_fossil_enj;
        this.dPa = this.aIg.aFr();
        this.dOZ = i;
    }

    public void di(T t) throws IOException {
        byte[] bk = this.dOX.bk(t);
        pi(bk.length);
        this.dOY.av(bk);
    }

    public void m2902a(eom com_fossil_eom) {
        if (com_fossil_eom != null) {
            this.dPb.add(com_fossil_eom);
        }
    }

    public boolean aFS() throws IOException {
        boolean z = true;
        String str = null;
        if (this.dOY.aFZ()) {
            z = false;
        } else {
            str = xo();
            this.dOY.mt(str);
            CommonUtils.a(this.context, 4, "Fabric", String.format(Locale.US, "generated new file %s", new Object[]{str}));
            this.dPa = this.aIg.aFr();
        }
        mq(str);
        return z;
    }

    private void pi(int i) throws IOException {
        if (!this.dOY.cs(i, xq())) {
            CommonUtils.a(this.context, 4, "Fabric", String.format(Locale.US, "session analytics events file is %d bytes, new event is %d bytes, this is over flush limit of %d, rolling it over", new Object[]{Integer.valueOf(this.dOY.aFY()), Integer.valueOf(i), Integer.valueOf(xq())}));
            aFS();
        }
    }

    protected int xp() {
        return this.dOZ;
    }

    protected int xq() {
        return MFNetworkReturnCode.REQUEST_NOT_FOUND;
    }

    private void mq(String str) {
        for (eom ms : this.dPb) {
            try {
                ms.ms(str);
            } catch (Throwable e) {
                CommonUtils.a(this.context, "One of the roll over listeners threw an exception", e);
            }
        }
    }

    public List<File> aFV() {
        return this.dOY.pj(1);
    }

    public void aG(List<File> list) {
        this.dOY.aH(list);
    }

    public void aFW() {
        this.dOY.aH(this.dOY.aGa());
        this.dOY.aGb();
    }

    public void aFX() {
        List<File> aGa = this.dOY.aGa();
        int xp = xp();
        if (aGa.size() > xp) {
            int size = aGa.size() - xp;
            CommonUtils.Z(this.context, String.format(Locale.US, "Found %d files in  roll over directory, this is greater than %d, deleting %d oldest files", new Object[]{Integer.valueOf(aGa.size()), Integer.valueOf(xp), Integer.valueOf(size)}));
            TreeSet treeSet = new TreeSet(new C34851(this));
            for (File file : aGa) {
                treeSet.add(new C3486a(file, mr(file.getName())));
            }
            List arrayList = new ArrayList();
            Iterator it = treeSet.iterator();
            while (it.hasNext()) {
                arrayList.add(((C3486a) it.next()).file);
                if (arrayList.size() == size) {
                    break;
                }
            }
            this.dOY.aH(arrayList);
        }
    }

    public long mr(String str) {
        long j = 0;
        String[] split = str.split("_");
        if (split.length == 3) {
            try {
                j = Long.valueOf(split[2]).longValue();
            } catch (NumberFormatException e) {
            }
        }
        return j;
    }
}
