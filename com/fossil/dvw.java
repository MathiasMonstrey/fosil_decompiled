package com.fossil;

import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.Socket;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import okio.ByteString;

public final class dvw {
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final String[] bqJ = new String[0];
    public static final byte[] dwU = new byte[0];

    public static boolean m9974b(com.fossil.etv r12, int r13, java.util.concurrent.TimeUnit r14) throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x006a in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r2 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        r6 = java.lang.System.nanoTime();
        r0 = r12.aAf();
        r0 = r0.aHw();
        if (r0 == 0) goto L_0x0051;
    L_0x0013:
        r0 = r12.aAf();
        r0 = r0.aHx();
        r0 = r0 - r6;
    L_0x001c:
        r4 = r12.aAf();
        r8 = (long) r13;
        r8 = r14.toNanos(r8);
        r8 = java.lang.Math.min(r0, r8);
        r8 = r8 + r6;
        r4.bk(r8);
        r4 = new com.fossil.eth;	 Catch:{ InterruptedIOException -> 0x0042, all -> 0x0073 }
        r4.<init>();	 Catch:{ InterruptedIOException -> 0x0042, all -> 0x0073 }
    L_0x0032:
        r8 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;	 Catch:{ InterruptedIOException -> 0x0042, all -> 0x0073 }
        r8 = r12.mo2733b(r4, r8);	 Catch:{ InterruptedIOException -> 0x0042, all -> 0x0073 }
        r10 = -1;	 Catch:{ InterruptedIOException -> 0x0042, all -> 0x0073 }
        r5 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));	 Catch:{ InterruptedIOException -> 0x0042, all -> 0x0073 }
        if (r5 == 0) goto L_0x0053;	 Catch:{ InterruptedIOException -> 0x0042, all -> 0x0073 }
    L_0x003e:
        r4.clear();	 Catch:{ InterruptedIOException -> 0x0042, all -> 0x0073 }
        goto L_0x0032;
    L_0x0042:
        r4 = move-exception;
        r4 = 0;
        r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r2 != 0) goto L_0x006a;
    L_0x0048:
        r0 = r12.aAf();
        r0.aHz();
    L_0x004f:
        r0 = r4;
    L_0x0050:
        return r0;
    L_0x0051:
        r0 = r2;
        goto L_0x001c;
    L_0x0053:
        r4 = 1;
        r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r2 != 0) goto L_0x0061;
    L_0x0058:
        r0 = r12.aAf();
        r0.aHz();
    L_0x005f:
        r0 = r4;
        goto L_0x0050;
    L_0x0061:
        r2 = r12.aAf();
        r0 = r0 + r6;
        r2.bk(r0);
        goto L_0x005f;
    L_0x006a:
        r2 = r12.aAf();
        r0 = r0 + r6;
        r2.bk(r0);
        goto L_0x004f;
    L_0x0073:
        r4 = move-exception;
        r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r2 != 0) goto L_0x0080;
    L_0x0078:
        r0 = r12.aAf();
        r0.aHz();
    L_0x007f:
        throw r4;
    L_0x0080:
        r2 = r12.aAf();
        r0 = r0 + r6;
        r2.bk(r0);
        goto L_0x007f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.dvw.b(com.fossil.etv, int, java.util.concurrent.TimeUnit):boolean");
    }

    public static void m9973b(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    public static void m9969a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e) {
                if (!m9971a(e)) {
                    throw e;
                }
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception e3) {
            }
        }
    }

    public static void m9968a(Closeable closeable, Closeable closeable2) throws IOException {
        Object obj = null;
        try {
            closeable.close();
        } catch (Throwable th) {
            obj = th;
        }
        try {
            closeable2.close();
        } catch (Throwable th2) {
            if (obj == null) {
                Throwable th3 = th2;
            }
        }
        if (obj != null) {
            if (obj instanceof IOException) {
                throw ((IOException) obj);
            } else if (obj instanceof RuntimeException) {
                throw ((RuntimeException) obj);
            } else if (obj instanceof Error) {
                throw ((Error) obj);
            } else {
                throw new AssertionError(obj);
            }
        }
    }

    public static boolean m9970a(etv com_fossil_etv, int i, TimeUnit timeUnit) {
        try {
            return m9974b(com_fossil_etv, i, timeUnit);
        } catch (IOException e) {
            return false;
        }
    }

    public static ByteString m9967a(ByteString byteString) {
        try {
            return ByteString.of(MessageDigest.getInstance("SHA-1").digest(byteString.toByteArray()));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public static <T> List<T> ay(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <T> List<T> m9976m(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static <K, V> Map<K, V> m9978z(Map<K, V> map) {
        return Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    public static ThreadFactory m9977t(final String str, final boolean z) {
        return new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str);
                thread.setDaemon(z);
                return thread;
            }
        };
    }

    public static <T> T[] m9972a(Class<T> cls, T[] tArr, T[] tArr2) {
        List a = m9966a((Object[]) tArr, (Object[]) tArr2);
        return a.toArray((Object[]) Array.newInstance(cls, a.size()));
    }

    private static <T> List<T> m9966a(T[] tArr, T[] tArr2) {
        List<T> arrayList = new ArrayList();
        for (Object obj : tArr) {
            for (Object obj2 : tArr2) {
                if (obj.equals(obj2)) {
                    arrayList.add(obj2);
                    break;
                }
            }
        }
        return arrayList;
    }

    public static String m9975e(dvf com_fossil_dvf) {
        if (com_fossil_dvf.ayW() != dvf.ky(com_fossil_dvf.ayR())) {
            return com_fossil_dvf.ayV() + ":" + com_fossil_dvf.ayW();
        }
        return com_fossil_dvf.ayV();
    }

    public static boolean m9971a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
