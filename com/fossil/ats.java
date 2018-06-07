package com.fossil;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.fossil.atv.C1898b;
import com.fossil.atv.C1899c;
import com.google.android.gms.common.api.Scope;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class ats<O extends C1879a> {
    private final C1890b<?, O> bfR;
    private final C1895i<?, O> bfS = null;
    private final C1893g<?> bfT;
    private final C1896j<?> bfU;
    private final String mName;

    public interface C1879a {

        public interface C1880a extends C1879a {
        }

        public interface C1881b extends C1879a {
        }

        public interface C1882c extends C1880a, C1881b {
        }
    }

    public interface C1887c {
    }

    public interface C1888f extends C1887c {
        boolean Kj();

        Intent Kk();

        boolean Ky();

        boolean Kz();

        void m4387a(avg com_fossil_avg, Set<Scope> set);

        void m4388a(aws com_fossil_aws);

        void disconnect();

        void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

        boolean isConnected();

        boolean isConnecting();
    }

    public static abstract class C1889e<T extends C1887c, O> {
        public List<Scope> bM(O o) {
            return Collections.emptyList();
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    }

    public static abstract class C1890b<T extends C1888f, O> extends C1889e<T, O> {
        public abstract T mo1176a(Context context, Looper looper, awy com_fossil_awy, O o, C1898b c1898b, C1899c c1899c);
    }

    public static class C1892d<C extends C1887c> {
    }

    public static final class C1893g<C extends C1888f> extends C1892d<C> {
    }

    public interface C1894h<T extends IInterface> extends C1887c {
        String Kh();

        String Ki();

        T m4457f(IBinder iBinder);
    }

    public static abstract class C1895i<T extends C1894h, O> extends C1889e<T, O> {
    }

    public static final class C1896j<C extends C1894h> extends C1892d<C> {
    }

    public <C extends C1888f> ats(String str, C1890b<C, O> c1890b, C1893g<C> c1893g) {
        awa.m4640p(c1890b, "Cannot construct an Api with a null ClientBuilder");
        awa.m4640p(c1893g, "Cannot construct an Api with a null ClientKey");
        this.mName = str;
        this.bfR = c1890b;
        this.bfT = c1893g;
        this.bfU = null;
    }

    public final C1889e<?, O> Kv() {
        return this.bfR;
    }

    public final C1890b<?, O> Kw() {
        awa.m4634a(this.bfR != null, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.bfR;
    }

    public final C1892d<?> Kx() {
        if (this.bfT != null) {
            return this.bfT;
        }
        throw new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
    }

    public final String getName() {
        return this.mName;
    }
}
