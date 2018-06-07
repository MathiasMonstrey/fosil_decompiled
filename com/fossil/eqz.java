package com.fossil;

import com.misfit.frameworks.buttonservice.ButtonService;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import java.util.Comparator;
import java.util.concurrent.Callable;

public final class eqz {
    static final equ<Object, Object> dRg = new C3507g();
    public static final Runnable dRh = new C3504d();
    public static final eqq dRi = new C3501a();
    static final eqt<Object> dRj = new C3502b();
    public static final eqt<Throwable> dRk = new C3505e();
    public static final eqt<Throwable> dRl = new C3511k();
    public static final eqv dRm = new C3503c();
    static final eqw<Object> dRn = new C3512l();
    static final eqw<Object> dRo = new C3506f();
    static final Callable<Object> dRp = new C3510j();
    static final Comparator<Object> dRq = new C3509i();
    public static final eqt<euy> dRr = new C3508h();

    static final class C3501a implements eqq {
        C3501a() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    static final class C3502b implements eqt<Object> {
        C3502b() {
        }

        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    static final class C3503c implements eqv {
        C3503c() {
        }
    }

    static final class C3504d implements Runnable {
        C3504d() {
        }

        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    static final class C3505e implements eqt<Throwable> {
        C3505e() {
        }

        public /* synthetic */ void accept(Object obj) throws Exception {
            m11071l((Throwable) obj);
        }

        public void m11071l(Throwable th) {
            ers.onError(th);
        }
    }

    static final class C3506f implements eqw<Object> {
        C3506f() {
        }

        public boolean test(Object obj) {
            return false;
        }
    }

    static final class C3507g implements equ<Object, Object> {
        C3507g() {
        }

        public Object apply(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    static final class C3508h implements eqt<euy> {
        C3508h() {
        }

        public /* synthetic */ void accept(Object obj) throws Exception {
            m11072a((euy) obj);
        }

        public void m11072a(euy com_fossil_euy) throws Exception {
            com_fossil_euy.bn(ButtonService.TIME_STAMP_FOR_NON_EXECUTABLE_METHOD);
        }
    }

    static final class C3509i implements Comparator<Object> {
        C3509i() {
        }

        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    static final class C3510j implements Callable<Object> {
        C3510j() {
        }

        public Object call() {
            return null;
        }
    }

    static final class C3511k implements eqt<Throwable> {
        C3511k() {
        }

        public /* synthetic */ void accept(Object obj) throws Exception {
            m11073l((Throwable) obj);
        }

        public void m11073l(Throwable th) {
            ers.onError(new OnErrorNotImplementedException(th));
        }
    }

    static final class C3512l implements eqw<Object> {
        C3512l() {
        }

        public boolean test(Object obj) {
            return true;
        }
    }
}
