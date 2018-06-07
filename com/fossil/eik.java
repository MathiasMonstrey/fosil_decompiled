package com.fossil;

import android.os.Build.VERSION;
import android.os.NetworkOnMainThreadException;
import android.os.SystemClock;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.ua.sdk.UaException;
import com.ua.sdk.UaException.Code;
import com.ua.sdk.authentication.AuthenticationManager;
import com.ua.sdk.authentication.AuthenticationManager.AuthenticationType;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.Callable;

public abstract class eik<T extends ecm> implements eiq<T> {
    protected final ein dGr;
    protected final ejb dGs;
    protected final eis<T> dId;
    protected final eit<T> dIe;
    protected final eis<? extends ecc<T>> dIf;
    protected final AuthenticationManager dIg;

    protected abstract URL mo2819a(ecj com_fossil_ecj);

    protected abstract URL aCG();

    public eik(ein com_fossil_ein, AuthenticationManager authenticationManager, ejb com_fossil_ejb, eis<T> com_fossil_eis_T, eit<T> com_fossil_eit_T, eis<? extends ecc<T>> com_fossil_eis__extends_com_fossil_ecc_T) {
        this.dGr = (ein) eiy.dd(com_fossil_ein);
        this.dGs = (ejb) eiy.dd(com_fossil_ejb);
        this.dId = com_fossil_eis_T;
        this.dIe = com_fossil_eit_T;
        this.dIg = authenticationManager;
        this.dIf = com_fossil_eis__extends_com_fossil_ecc_T;
    }

    protected final <R> R m10541f(Callable<R> callable) throws UaException {
        return m10536a(callable, true);
    }

    private <R> R m10536a(Callable<R> callable, boolean z) throws UaException {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            return callable.call();
        } catch (Throwable e) {
            if (e.getResponseCode() != 401) {
                throw e;
            } else if (z) {
                this.dIg.aU(elapsedRealtime);
                return m10536a(callable, false);
            } else {
                throw new UaException(Code.NOT_AUTHENTICATED, e);
            }
        } catch (UaException e2) {
            throw e2;
        } catch (Throwable e3) {
            throw new UaException(Code.CANCELED, e3);
        } catch (Throwable e32) {
            throw new UaException(Code.UNKNOWN, e32);
        } catch (Throwable e322) {
            if (VERSION.SDK_INT < 11 || !(e322 instanceof NetworkOnMainThreadException)) {
                throw new UaException(Code.UNKNOWN, e322);
            }
            throw new UaException(Code.NETWORK_ON_MAIN_THREAD, e322);
        }
    }

    protected final void m10539a(AuthenticationType authenticationType) throws UaException {
        if (authenticationType == AuthenticationType.USER) {
            eiy.m10768a(this.dIg);
        }
    }

    public T mo2818g(T t) throws UaException {
        try {
            m10539a(aDm());
            return (ecm) m10541f(mo2837a((ecm) t));
        } catch (UaException e) {
            throw e;
        } catch (Throwable e2) {
            throw new UaException(e2);
        }
    }

    protected Callable<T> mo2837a(final T t) throws UaException {
        eiy.m10771e(this.dIe, "jsonWriter");
        eiy.m10771e(this.dId, "jsonParser");
        return new Callable<T>(this) {
            final /* synthetic */ eik dIi;

            public /* synthetic */ Object call() throws Exception {
                return aDo();
            }

            public T aDo() throws Exception {
                eiy.m10771e(t, "resource");
                URLConnection b = this.dIi.dGr.m10760b(this.dIi.aCG());
                this.dIi.dIg.a(b, this.dIi.aDm());
                b.setRequestMethod("POST");
                b.setDoOutput(true);
                b.setUseCaches(false);
                this.dIi.dIe.mo2806b(t, b.getOutputStream());
                eiy.m10769a(b, 201);
                return (ecm) this.dIi.dId.mo2803p(b.getInputStream());
            }
        };
    }

    protected AuthenticationType aDm() {
        return AuthenticationType.USER;
    }

    public T mo2817e(ecj com_fossil_ecj) throws UaException {
        try {
            m10539a(aDn());
            return (ecm) m10541f(m10542f(com_fossil_ecj));
        } catch (UaException e) {
            throw e;
        } catch (Throwable e2) {
            throw new UaException(e2);
        }
    }

    protected Callable<T> m10542f(final ecj com_fossil_ecj) throws UaException {
        eiy.m10771e(this.dId, "jsonParser");
        return new Callable<T>(this) {
            final /* synthetic */ eik dIi;

            public /* synthetic */ Object call() throws Exception {
                return aDo();
            }

            public T aDo() throws Exception {
                eiy.m10771e(com_fossil_ecj, "ref");
                URLConnection b = this.dIi.dGr.m10760b(this.dIi.mo2819a(com_fossil_ecj));
                try {
                    this.dIi.dIg.a(b, this.dIi.aDn());
                    b.setRequestMethod("GET");
                    b.setDoOutput(false);
                    b.setUseCaches(false);
                    eiy.m10769a(b, MFNetworkReturnCode.RESPONSE_OK);
                    ecm com_fossil_ecm = (ecm) this.dIi.dId.mo2803p(b.getInputStream());
                    return com_fossil_ecm;
                } finally {
                    b.disconnect();
                }
            }
        };
    }

    protected AuthenticationType aDn() {
        return AuthenticationType.USER;
    }
}
