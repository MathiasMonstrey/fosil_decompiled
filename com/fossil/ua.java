package com.fossil;

import com.facebook.appevents.AppEventsConstants;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class ua implements Closeable {
    private long Fs = 0;
    private final File azd;
    private final File aze;
    private final File azf;
    private final int azg;
    private long azh;
    private final int azi;
    private Writer azj;
    private final LinkedHashMap<String, C4133b> azk = new LinkedHashMap(0, 0.75f, true);
    private int azl;
    private long azm = 0;
    final ThreadPoolExecutor azn = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Callable<Void> azo = new C41311(this);
    private final File directory;

    class C41311 implements Callable<Void> {
        final /* synthetic */ ua azp;

        C41311(ua uaVar) {
            this.azp = uaVar;
        }

        public Void call() throws Exception {
            synchronized (this.azp) {
                if (this.azp.azj == null) {
                } else {
                    this.azp.trimToSize();
                    if (this.azp.tZ()) {
                        this.azp.tY();
                        this.azp.azl = 0;
                    }
                }
            }
            return null;
        }
    }

    public final class C4132a {
        final /* synthetic */ ua azp;
        private final C4133b azq;
        private final boolean[] azr;
        private boolean azs;

        private C4132a(ua uaVar, C4133b c4133b) {
            this.azp = uaVar;
            this.azq = c4133b;
            this.azr = c4133b.azw ? null : new boolean[uaVar.azi];
        }

        public File ey(int i) throws IOException {
            File eA;
            synchronized (this.azp) {
                if (this.azq.azx != this) {
                    throw new IllegalStateException();
                }
                if (!this.azq.azw) {
                    this.azr[i] = true;
                }
                eA = this.azq.eA(i);
                if (!this.azp.directory.exists()) {
                    this.azp.directory.mkdirs();
                }
            }
            return eA;
        }

        public void commit() throws IOException {
            this.azp.m13800a(this, true);
            this.azs = true;
        }

        public void abort() throws IOException {
            this.azp.m13800a(this, false);
        }

        public void ub() {
            if (!this.azs) {
                try {
                    abort();
                } catch (IOException e) {
                }
            }
        }
    }

    final class C4133b {
        final /* synthetic */ ua azp;
        private final long[] azt;
        File[] azu;
        File[] azv;
        private boolean azw;
        private C4132a azx;
        private long azy;
        private final String key;

        private C4133b(ua uaVar, String str) {
            this.azp = uaVar;
            this.key = str;
            this.azt = new long[uaVar.azi];
            this.azu = new File[uaVar.azi];
            this.azv = new File[uaVar.azi];
            StringBuilder append = new StringBuilder(str).append('.');
            int length = append.length();
            for (int i = 0; i < uaVar.azi; i++) {
                append.append(i);
                this.azu[i] = new File(uaVar.directory, append.toString());
                append.append(".tmp");
                this.azv[i] = new File(uaVar.directory, append.toString());
                append.setLength(length);
            }
        }

        public String uc() throws IOException {
            StringBuilder stringBuilder = new StringBuilder();
            for (long append : this.azt) {
                stringBuilder.append(' ').append(append);
            }
            return stringBuilder.toString();
        }

        private void m13789a(String[] strArr) throws IOException {
            if (strArr.length != this.azp.azi) {
                throw m13791b(strArr);
            }
            int i = 0;
            while (i < strArr.length) {
                try {
                    this.azt[i] = Long.parseLong(strArr[i]);
                    i++;
                } catch (NumberFormatException e) {
                    throw m13791b(strArr);
                }
            }
        }

        private IOException m13791b(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File ez(int i) {
            return this.azu[i];
        }

        public File eA(int i) {
            return this.azv[i];
        }
    }

    public final class C4134c {
        final /* synthetic */ ua azp;
        private final long[] azt;
        private final long azy;
        private final File[] azz;
        private final String key;

        private C4134c(ua uaVar, String str, long j, File[] fileArr, long[] jArr) {
            this.azp = uaVar;
            this.key = str;
            this.azy = j;
            this.azz = fileArr;
            this.azt = jArr;
        }

        public File ey(int i) {
            return this.azz[i];
        }
    }

    private ua(File file, int i, int i2, long j) {
        this.directory = file;
        this.azg = i;
        this.azd = new File(file, "journal");
        this.aze = new File(file, "journal.tmp");
        this.azf = new File(file, "journal.bkp");
        this.azi = i2;
        this.azh = j;
    }

    public static ua m13798a(File file, int i, int i2, long j) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        } else {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    m13802a(file2, file3, false);
                }
            }
            ua uaVar = new ua(file, i, i2, j);
            if (uaVar.azd.exists()) {
                try {
                    uaVar.tW();
                    uaVar.tX();
                    return uaVar;
                } catch (IOException e) {
                    System.out.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                    uaVar.delete();
                }
            }
            file.mkdirs();
            uaVar = new ua(file, i, i2, j);
            uaVar.tY();
            return uaVar;
        }
    }

    private void tW() throws IOException {
        Closeable ubVar = new ub(new FileInputStream(this.azd), uc.US_ASCII);
        int i;
        try {
            String readLine = ubVar.readLine();
            String readLine2 = ubVar.readLine();
            String readLine3 = ubVar.readLine();
            String readLine4 = ubVar.readLine();
            String readLine5 = ubVar.readLine();
            if ("libcore.io.DiskLruCache".equals(readLine) && AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(readLine2) && Integer.toString(this.azg).equals(readLine3) && Integer.toString(this.azi).equals(readLine4) && "".equals(readLine5)) {
                i = 0;
                while (true) {
                    ai(ubVar.readLine());
                    i++;
                }
            } else {
                throw new IOException("unexpected journal header: [" + readLine + ", " + readLine2 + ", " + readLine4 + ", " + readLine5 + "]");
            }
        } catch (EOFException e) {
            this.azl = i - this.azk.size();
            if (ubVar.ud()) {
                tY();
            } else {
                this.azj = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.azd, true), uc.US_ASCII));
            }
            uc.closeQuietly(ubVar);
        } catch (Throwable th) {
            uc.closeQuietly(ubVar);
        }
    }

    private void ai(String str) throws IOException {
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        String str2;
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(32, i);
        if (indexOf2 == -1) {
            String substring = str.substring(i);
            if (indexOf == "REMOVE".length() && str.startsWith("REMOVE")) {
                this.azk.remove(substring);
                return;
            }
            str2 = substring;
        } else {
            str2 = str.substring(i, indexOf2);
        }
        C4133b c4133b = (C4133b) this.azk.get(str2);
        if (c4133b == null) {
            c4133b = new C4133b(str2);
            this.azk.put(str2, c4133b);
        }
        if (indexOf2 != -1 && indexOf == "CLEAN".length() && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            c4133b.azw = true;
            c4133b.azx = null;
            c4133b.m13789a(split);
        } else if (indexOf2 == -1 && indexOf == "DIRTY".length() && str.startsWith("DIRTY")) {
            c4133b.azx = new C4132a(c4133b);
        } else if (indexOf2 != -1 || indexOf != "READ".length() || !str.startsWith("READ")) {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    private void tX() throws IOException {
        m13808m(this.aze);
        Iterator it = this.azk.values().iterator();
        while (it.hasNext()) {
            C4133b c4133b = (C4133b) it.next();
            int i;
            if (c4133b.azx == null) {
                for (i = 0; i < this.azi; i++) {
                    this.Fs += c4133b.azt[i];
                }
            } else {
                c4133b.azx = null;
                for (i = 0; i < this.azi; i++) {
                    m13808m(c4133b.ez(i));
                    m13808m(c4133b.eA(i));
                }
                it.remove();
            }
        }
    }

    private synchronized void tY() throws IOException {
        if (this.azj != null) {
            this.azj.close();
        }
        Writer bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.aze), uc.US_ASCII));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write(AppEventsConstants.EVENT_PARAM_VALUE_YES);
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.azg));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.azi));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (C4133b c4133b : this.azk.values()) {
                if (c4133b.azx != null) {
                    bufferedWriter.write("DIRTY " + c4133b.key + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + c4133b.key + c4133b.uc() + '\n');
                }
            }
            bufferedWriter.close();
            if (this.azd.exists()) {
                m13802a(this.azd, this.azf, true);
            }
            m13802a(this.aze, this.azd, false);
            this.azf.delete();
            this.azj = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.azd, true), uc.US_ASCII));
        } catch (Throwable th) {
            bufferedWriter.close();
        }
    }

    private static void m13808m(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void m13802a(File file, File file2, boolean z) throws IOException {
        if (z) {
            m13808m(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public synchronized C4134c aj(String str) throws IOException {
        C4134c c4134c = null;
        synchronized (this) {
            ua();
            C4133b c4133b = (C4133b) this.azk.get(str);
            if (c4133b != null) {
                if (c4133b.azw) {
                    for (File exists : c4133b.azu) {
                        if (!exists.exists()) {
                            break;
                        }
                    }
                    this.azl++;
                    this.azj.append("READ");
                    this.azj.append(' ');
                    this.azj.append(str);
                    this.azj.append('\n');
                    if (tZ()) {
                        this.azn.submit(this.azo);
                    }
                    c4134c = new C4134c(str, c4133b.azy, c4133b.azu, c4133b.azt);
                }
            }
        }
        return c4134c;
    }

    public C4132a ak(String str) throws IOException {
        return m13797a(str, -1);
    }

    private synchronized C4132a m13797a(String str, long j) throws IOException {
        C4132a c4132a;
        ua();
        C4133b c4133b = (C4133b) this.azk.get(str);
        if (j == -1 || (c4133b != null && c4133b.azy == j)) {
            C4133b c4133b2;
            if (c4133b == null) {
                c4133b = new C4133b(str);
                this.azk.put(str, c4133b);
                c4133b2 = c4133b;
            } else if (c4133b.azx != null) {
                c4132a = null;
            } else {
                c4133b2 = c4133b;
            }
            c4132a = new C4132a(c4133b2);
            c4133b2.azx = c4132a;
            this.azj.append("DIRTY");
            this.azj.append(' ');
            this.azj.append(str);
            this.azj.append('\n');
            this.azj.flush();
        } else {
            c4132a = null;
        }
        return c4132a;
    }

    private synchronized void m13800a(C4132a c4132a, boolean z) throws IOException {
        int i = 0;
        synchronized (this) {
            C4133b a = c4132a.azq;
            if (a.azx != c4132a) {
                throw new IllegalStateException();
            }
            if (z) {
                if (!a.azw) {
                    int i2 = 0;
                    while (i2 < this.azi) {
                        if (!c4132a.azr[i2]) {
                            c4132a.abort();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                        } else if (!a.eA(i2).exists()) {
                            c4132a.abort();
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            }
            while (i < this.azi) {
                File eA = a.eA(i);
                if (!z) {
                    m13808m(eA);
                } else if (eA.exists()) {
                    File ez = a.ez(i);
                    eA.renameTo(ez);
                    long j = a.azt[i];
                    long length = ez.length();
                    a.azt[i] = length;
                    this.Fs = (this.Fs - j) + length;
                }
                i++;
            }
            this.azl++;
            a.azx = null;
            if ((a.azw | z) != 0) {
                a.azw = true;
                this.azj.append("CLEAN");
                this.azj.append(' ');
                this.azj.append(a.key);
                this.azj.append(a.uc());
                this.azj.append('\n');
                if (z) {
                    long j2 = this.azm;
                    this.azm = 1 + j2;
                    a.azy = j2;
                }
            } else {
                this.azk.remove(a.key);
                this.azj.append("REMOVE");
                this.azj.append(' ');
                this.azj.append(a.key);
                this.azj.append('\n');
            }
            this.azj.flush();
            if (this.Fs > this.azh || tZ()) {
                this.azn.submit(this.azo);
            }
        }
    }

    private boolean tZ() {
        return this.azl >= 2000 && this.azl >= this.azk.size();
    }

    public synchronized boolean al(String str) throws IOException {
        boolean z;
        int i = 0;
        synchronized (this) {
            ua();
            C4133b c4133b = (C4133b) this.azk.get(str);
            if (c4133b == null || c4133b.azx != null) {
                z = false;
            } else {
                while (i < this.azi) {
                    File ez = c4133b.ez(i);
                    if (!ez.exists() || ez.delete()) {
                        this.Fs -= c4133b.azt[i];
                        c4133b.azt[i] = 0;
                        i++;
                    } else {
                        throw new IOException("failed to delete " + ez);
                    }
                }
                this.azl++;
                this.azj.append("REMOVE");
                this.azj.append(' ');
                this.azj.append(str);
                this.azj.append('\n');
                this.azk.remove(str);
                if (tZ()) {
                    this.azn.submit(this.azo);
                }
                z = true;
            }
        }
        return z;
    }

    private void ua() {
        if (this.azj == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized void close() throws IOException {
        if (this.azj != null) {
            Iterator it = new ArrayList(this.azk.values()).iterator();
            while (it.hasNext()) {
                C4133b c4133b = (C4133b) it.next();
                if (c4133b.azx != null) {
                    c4133b.azx.abort();
                }
            }
            trimToSize();
            this.azj.close();
            this.azj = null;
        }
    }

    private void trimToSize() throws IOException {
        while (this.Fs > this.azh) {
            al((String) ((Entry) this.azk.entrySet().iterator().next()).getKey());
        }
    }

    public void delete() throws IOException {
        close();
        uc.m13810n(this.directory);
    }
}
