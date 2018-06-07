package com.fossil;

import android.os.Bundle;
import android.support.v8.renderscript.Allocation;
import android.util.Log;
import com.fossil.fj.C2426a;
import com.fossil.gx.C3577b;
import com.fossil.gx.C3578c;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

public class fk extends fj {
    static boolean DEBUG = false;
    final jw<C3579a> KF = new jw();
    final jw<C3579a> KG = new jw();
    boolean KH;
    ez mHost;
    boolean mRetaining;
    boolean mStarted;
    final String mWho;

    final class C3579a implements C3577b<Object>, C3578c<Object> {
        final Bundle KI;
        C2426a<Object> KJ;
        gx<Object> KK;
        boolean KL;
        boolean KM;
        Object KN;
        boolean KO;
        boolean KP;
        boolean KQ;
        C3579a KR;
        final /* synthetic */ fk KS;
        boolean mDestroyed;
        final int mId;
        boolean mRetaining;
        boolean mStarted;

        public C3579a(fk fkVar, int i, Bundle bundle, C2426a<Object> c2426a) {
            this.KS = fkVar;
            this.mId = i;
            this.KI = bundle;
            this.KJ = c2426a;
        }

        void start() {
            if (this.mRetaining && this.KO) {
                this.mStarted = true;
            } else if (!this.mStarted) {
                this.mStarted = true;
                if (fk.DEBUG) {
                    Log.v("LoaderManager", "  Starting: " + this);
                }
                if (this.KK == null && this.KJ != null) {
                    this.KK = this.KJ.mo2137b(this.mId, this.KI);
                }
                if (this.KK == null) {
                    return;
                }
                if (!this.KK.getClass().isMemberClass() || Modifier.isStatic(this.KK.getClass().getModifiers())) {
                    if (!this.KQ) {
                        this.KK.registerListener(this.mId, this);
                        this.KK.registerOnLoadCanceledListener(this);
                        this.KQ = true;
                    }
                    this.KK.startLoading();
                    return;
                }
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.KK);
            }
        }

        void iy() {
            if (fk.DEBUG) {
                Log.v("LoaderManager", "  Retaining: " + this);
            }
            this.mRetaining = true;
            this.KO = this.mStarted;
            this.mStarted = false;
            this.KJ = null;
        }

        void iu() {
            if (this.mRetaining) {
                if (fk.DEBUG) {
                    Log.v("LoaderManager", "  Finished Retaining: " + this);
                }
                this.mRetaining = false;
                if (!(this.mStarted == this.KO || this.mStarted)) {
                    stop();
                }
            }
            if (this.mStarted && this.KL && !this.KP) {
                m11415c(this.KK, this.KN);
            }
        }

        void iz() {
            if (this.mStarted && this.KP) {
                this.KP = false;
                if (this.KL && !this.mRetaining) {
                    m11415c(this.KK, this.KN);
                }
            }
        }

        void stop() {
            if (fk.DEBUG) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.mStarted = false;
            if (!this.mRetaining && this.KK != null && this.KQ) {
                this.KQ = false;
                this.KK.unregisterListener(this);
                this.KK.unregisterOnLoadCanceledListener(this);
                this.KK.stopLoading();
            }
        }

        void destroy() {
            String str;
            C2426a c2426a = null;
            if (fk.DEBUG) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.mDestroyed = true;
            boolean z = this.KM;
            this.KM = false;
            if (this.KJ != null && this.KK != null && this.KL && z) {
                if (fk.DEBUG) {
                    Log.v("LoaderManager", "  Resetting: " + this);
                }
                if (this.KS.mHost != null) {
                    String str2 = this.KS.mHost.mFragmentManager.Jt;
                    this.KS.mHost.mFragmentManager.Jt = "onLoaderReset";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    this.KJ.mo2129a(this.KK);
                } finally {
                    c2426a = this.KS.mHost;
                    if (c2426a != null) {
                        c2426a = this.KS.mHost.mFragmentManager;
                        c2426a.Jt = str;
                    }
                }
            }
            this.KJ = c2426a;
            this.KN = c2426a;
            this.KL = false;
            if (this.KK != null) {
                if (this.KQ) {
                    this.KQ = false;
                    this.KK.unregisterListener(this);
                    this.KK.unregisterOnLoadCanceledListener(this);
                }
                this.KK.reset();
            }
            if (this.KR != null) {
                this.KR.destroy();
            }
        }

        public void mo3098b(gx<Object> gxVar) {
            if (fk.DEBUG) {
                Log.v("LoaderManager", "onLoadCanceled: " + this);
            }
            if (this.mDestroyed) {
                if (fk.DEBUG) {
                    Log.v("LoaderManager", "  Ignoring load canceled -- destroyed");
                }
            } else if (this.KS.KF.get(this.mId) == this) {
                C3579a c3579a = this.KR;
                if (c3579a != null) {
                    if (fk.DEBUG) {
                        Log.v("LoaderManager", "  Switching to pending loader: " + c3579a);
                    }
                    this.KR = null;
                    this.KS.KF.put(this.mId, null);
                    destroy();
                    this.KS.m11419a(c3579a);
                }
            } else if (fk.DEBUG) {
                Log.v("LoaderManager", "  Ignoring load canceled -- not active");
            }
        }

        public void mo3099b(gx<Object> gxVar, Object obj) {
            if (fk.DEBUG) {
                Log.v("LoaderManager", "onLoadComplete: " + this);
            }
            if (this.mDestroyed) {
                if (fk.DEBUG) {
                    Log.v("LoaderManager", "  Ignoring load complete -- destroyed");
                }
            } else if (this.KS.KF.get(this.mId) == this) {
                C3579a c3579a = this.KR;
                if (c3579a != null) {
                    if (fk.DEBUG) {
                        Log.v("LoaderManager", "  Switching to pending loader: " + c3579a);
                    }
                    this.KR = null;
                    this.KS.KF.put(this.mId, null);
                    destroy();
                    this.KS.m11419a(c3579a);
                    return;
                }
                if (!(this.KN == obj && this.KL)) {
                    this.KN = obj;
                    this.KL = true;
                    if (this.mStarted) {
                        m11415c(gxVar, obj);
                    }
                }
                c3579a = (C3579a) this.KS.KG.get(this.mId);
                if (!(c3579a == null || c3579a == this)) {
                    c3579a.KM = false;
                    c3579a.destroy();
                    this.KS.KG.remove(this.mId);
                }
                if (this.KS.mHost != null && !this.KS.iq()) {
                    this.KS.mHost.mFragmentManager.hX();
                }
            } else if (fk.DEBUG) {
                Log.v("LoaderManager", "  Ignoring load complete -- not active");
            }
        }

        void m11415c(gx<Object> gxVar, Object obj) {
            String str;
            if (this.KJ != null) {
                if (this.KS.mHost != null) {
                    String str2 = this.KS.mHost.mFragmentManager.Jt;
                    this.KS.mHost.mFragmentManager.Jt = "onLoadFinished";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    if (fk.DEBUG) {
                        Log.v("LoaderManager", "  onLoadFinished in " + gxVar + ": " + gxVar.dataToString(obj));
                    }
                    this.KJ.mo2130a(gxVar, obj);
                    this.KM = true;
                } finally {
                    if (this.KS.mHost != null) {
                        this.KS.mHost.mFragmentManager.Jt = str;
                    }
                }
            }
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(64);
            stringBuilder.append("LoaderInfo{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" #");
            stringBuilder.append(this.mId);
            stringBuilder.append(" : ");
            jo.m11895a(this.KK, stringBuilder);
            stringBuilder.append("}}");
            return stringBuilder.toString();
        }

        public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.mId);
            printWriter.print(" mArgs=");
            printWriter.println(this.KI);
            printWriter.print(str);
            printWriter.print("mCallbacks=");
            printWriter.println(this.KJ);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.KK);
            if (this.KK != null) {
                this.KK.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
            if (this.KL || this.KM) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.KL);
                printWriter.print("  mDeliveredData=");
                printWriter.println(this.KM);
                printWriter.print(str);
                printWriter.print("mData=");
                printWriter.println(this.KN);
            }
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.mStarted);
            printWriter.print(" mReportNextStart=");
            printWriter.print(this.KP);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.mDestroyed);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.mRetaining);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.KO);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.KQ);
            if (this.KR != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.KR);
                printWriter.println(":");
                this.KR.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
        }
    }

    fk(String str, ez ezVar, boolean z) {
        this.mWho = str;
        this.mHost = ezVar;
        this.mStarted = z;
    }

    void m11420b(ez ezVar) {
        this.mHost = ezVar;
    }

    private C3579a m11416b(int i, Bundle bundle, C2426a<Object> c2426a) {
        C3579a c3579a = new C3579a(this, i, bundle, c2426a);
        c3579a.KK = c2426a.mo2137b(i, bundle);
        return c3579a;
    }

    private C3579a m11417c(int i, Bundle bundle, C2426a<Object> c2426a) {
        try {
            this.KH = true;
            C3579a b = m11416b(i, bundle, c2426a);
            m11419a(b);
            return b;
        } finally {
            this.KH = false;
        }
    }

    void m11419a(C3579a c3579a) {
        this.KF.put(c3579a.mId, c3579a);
        if (this.mStarted) {
            c3579a.start();
        }
    }

    public <D> gx<D> mo3100a(int i, Bundle bundle, C2426a<D> c2426a) {
        if (this.KH) {
            throw new IllegalStateException("Called while creating a loader");
        }
        C3579a c3579a = (C3579a) this.KF.get(i);
        if (DEBUG) {
            Log.v("LoaderManager", "initLoader in " + this + ": args=" + bundle);
        }
        if (c3579a == null) {
            c3579a = m11417c(i, bundle, c2426a);
            if (DEBUG) {
                Log.v("LoaderManager", "  Created new loader " + c3579a);
            }
        } else {
            if (DEBUG) {
                Log.v("LoaderManager", "  Re-using existing loader " + c3579a);
            }
            c3579a.KJ = c2426a;
        }
        if (c3579a.KL && this.mStarted) {
            c3579a.m11415c(c3579a.KK, c3579a.KN);
        }
        return c3579a.KK;
    }

    public void destroyLoader(int i) {
        if (this.KH) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (DEBUG) {
            Log.v("LoaderManager", "destroyLoader in " + this + " of " + i);
        }
        int indexOfKey = this.KF.indexOfKey(i);
        if (indexOfKey >= 0) {
            C3579a c3579a = (C3579a) this.KF.valueAt(indexOfKey);
            this.KF.removeAt(indexOfKey);
            c3579a.destroy();
        }
        indexOfKey = this.KG.indexOfKey(i);
        if (indexOfKey >= 0) {
            c3579a = (C3579a) this.KG.valueAt(indexOfKey);
            this.KG.removeAt(indexOfKey);
            c3579a.destroy();
        }
        if (this.mHost != null && !iq()) {
            this.mHost.mFragmentManager.hX();
        }
    }

    public <D> gx<D> aN(int i) {
        if (this.KH) {
            throw new IllegalStateException("Called while creating a loader");
        }
        C3579a c3579a = (C3579a) this.KF.get(i);
        if (c3579a == null) {
            return null;
        }
        if (c3579a.KR != null) {
            return c3579a.KR.KK;
        }
        return c3579a.KK;
    }

    public void ir() {
        if (DEBUG) {
            Log.v("LoaderManager", "Starting in " + this);
        }
        if (this.mStarted) {
            Throwable runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStart when already started: " + this, runtimeException);
            return;
        }
        this.mStarted = true;
        for (int size = this.KF.size() - 1; size >= 0; size--) {
            ((C3579a) this.KF.valueAt(size)).start();
        }
    }

    public void is() {
        if (DEBUG) {
            Log.v("LoaderManager", "Stopping in " + this);
        }
        if (this.mStarted) {
            for (int size = this.KF.size() - 1; size >= 0; size--) {
                ((C3579a) this.KF.valueAt(size)).stop();
            }
            this.mStarted = false;
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doStop when not started: " + this, runtimeException);
    }

    public void it() {
        if (DEBUG) {
            Log.v("LoaderManager", "Retaining in " + this);
        }
        if (this.mStarted) {
            this.mRetaining = true;
            this.mStarted = false;
            for (int size = this.KF.size() - 1; size >= 0; size--) {
                ((C3579a) this.KF.valueAt(size)).iy();
            }
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doRetain when not started: " + this, runtimeException);
    }

    void iu() {
        if (this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.mRetaining = false;
            for (int size = this.KF.size() - 1; size >= 0; size--) {
                ((C3579a) this.KF.valueAt(size)).iu();
            }
        }
    }

    public void iv() {
        for (int size = this.KF.size() - 1; size >= 0; size--) {
            ((C3579a) this.KF.valueAt(size)).KP = true;
        }
    }

    public void iw() {
        for (int size = this.KF.size() - 1; size >= 0; size--) {
            ((C3579a) this.KF.valueAt(size)).iz();
        }
    }

    public void ix() {
        int size;
        if (!this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (size = this.KF.size() - 1; size >= 0; size--) {
                ((C3579a) this.KF.valueAt(size)).destroy();
            }
            this.KF.clear();
        }
        if (DEBUG) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (size = this.KG.size() - 1; size >= 0; size--) {
            ((C3579a) this.KG.valueAt(size)).destroy();
        }
        this.KG.clear();
        this.mHost = null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(Allocation.USAGE_SHARED);
        stringBuilder.append("LoaderManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        jo.m11895a(this.mHost, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i = 0;
        if (this.KF.size() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i2 = 0; i2 < this.KF.size(); i2++) {
                C3579a c3579a = (C3579a) this.KF.valueAt(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.KF.keyAt(i2));
                printWriter.print(": ");
                printWriter.println(c3579a.toString());
                c3579a.dump(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.KG.size() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            while (i < this.KG.size()) {
                c3579a = (C3579a) this.KG.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.KG.keyAt(i));
                printWriter.print(": ");
                printWriter.println(c3579a.toString());
                c3579a.dump(str3, fileDescriptor, printWriter, strArr);
                i++;
            }
        }
    }

    public boolean iq() {
        int size = this.KF.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            int i2;
            C3579a c3579a = (C3579a) this.KF.valueAt(i);
            if (!c3579a.mStarted || c3579a.KM) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            z |= i2;
        }
        return z;
    }
}
