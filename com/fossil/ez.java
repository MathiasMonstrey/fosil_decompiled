package com.fossil;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class ez<E> extends ex {
    private final Activity IX;
    final int IY;
    private jv<String, fj> IZ;
    private boolean Ja;
    private boolean mCheckedForLoaderManager;
    final Context mContext;
    final fb mFragmentManager;
    private final Handler mHandler;
    private fk mLoaderManager;
    private boolean mLoadersStarted;

    public abstract E onGetHost();

    ez(ew ewVar) {
        this(ewVar, ewVar, ewVar.mHandler, 0);
    }

    ez(Activity activity, Context context, Handler handler, int i) {
        this.mFragmentManager = new fb();
        this.IX = activity;
        this.mContext = context;
        this.mHandler = handler;
        this.IY = i;
    }

    public void onDump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public boolean mo3075d(Fragment fragment) {
        return true;
    }

    public LayoutInflater onGetLayoutInflater() {
        return (LayoutInflater) this.mContext.getSystemService("layout_inflater");
    }

    public void hP() {
    }

    public void mo3072a(Fragment fragment, Intent intent, int i, Bundle bundle) {
        if (i != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        this.mContext.startActivity(intent);
    }

    public void mo3073a(Fragment fragment, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws SendIntentException {
        if (i != -1) {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
        eg.m10640a(this.IX, intentSender, i, intent, i2, i3, i4, bundle);
    }

    public void mo3074a(Fragment fragment, String[] strArr, int i) {
    }

    public boolean mo3071U(String str) {
        return false;
    }

    public boolean onHasWindowAnimations() {
        return true;
    }

    public int onGetWindowAnimations() {
        return this.IY;
    }

    public View onFindViewById(int i) {
        return null;
    }

    public boolean onHasView() {
        return true;
    }

    public Activity getActivity() {
        return this.IX;
    }

    public Context getContext() {
        return this.mContext;
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    fb hT() {
        return this.mFragmentManager;
    }

    fk hU() {
        if (this.mLoaderManager != null) {
            return this.mLoaderManager;
        }
        this.mCheckedForLoaderManager = true;
        this.mLoaderManager = m11261a("(root)", this.mLoadersStarted, true);
        return this.mLoaderManager;
    }

    void m11260V(String str) {
        if (this.IZ != null) {
            fk fkVar = (fk) this.IZ.get(str);
            if (fkVar != null && !fkVar.mRetaining) {
                fkVar.ix();
                this.IZ.remove(str);
            }
        }
    }

    void onAttachFragment(Fragment fragment) {
    }

    public boolean hV() {
        return this.Ja;
    }

    void doLoaderStart() {
        if (!this.mLoadersStarted) {
            this.mLoadersStarted = true;
            if (this.mLoaderManager != null) {
                this.mLoaderManager.ir();
            } else if (!this.mCheckedForLoaderManager) {
                this.mLoaderManager = m11261a("(root)", this.mLoadersStarted, false);
                if (!(this.mLoaderManager == null || this.mLoaderManager.mStarted)) {
                    this.mLoaderManager.ir();
                }
            }
            this.mCheckedForLoaderManager = true;
        }
    }

    void doLoaderStop(boolean z) {
        this.Ja = z;
        if (this.mLoaderManager != null && this.mLoadersStarted) {
            this.mLoadersStarted = false;
            if (z) {
                this.mLoaderManager.it();
            } else {
                this.mLoaderManager.is();
            }
        }
    }

    void doLoaderDestroy() {
        if (this.mLoaderManager != null) {
            this.mLoaderManager.ix();
        }
    }

    void reportLoaderStart() {
        if (this.IZ != null) {
            int size = this.IZ.size();
            fk[] fkVarArr = new fk[size];
            for (int i = size - 1; i >= 0; i--) {
                fkVarArr[i] = (fk) this.IZ.valueAt(i);
            }
            for (int i2 = 0; i2 < size; i2++) {
                fk fkVar = fkVarArr[i2];
                fkVar.iu();
                fkVar.iw();
            }
        }
    }

    public fk m11261a(String str, boolean z, boolean z2) {
        if (this.IZ == null) {
            this.IZ = new jv();
        }
        fk fkVar = (fk) this.IZ.get(str);
        if (fkVar == null && z2) {
            fkVar = new fk(str, this, z);
            this.IZ.put(str, fkVar);
            return fkVar;
        } else if (!z || fkVar == null || fkVar.mStarted) {
            return fkVar;
        } else {
            fkVar.ir();
            return fkVar;
        }
    }

    jv<String, fj> hS() {
        int i;
        int i2 = 0;
        if (this.IZ != null) {
            int size = this.IZ.size();
            fk[] fkVarArr = new fk[size];
            for (int i3 = size - 1; i3 >= 0; i3--) {
                fkVarArr[i3] = (fk) this.IZ.valueAt(i3);
            }
            boolean hV = hV();
            i = 0;
            while (i2 < size) {
                fk fkVar = fkVarArr[i2];
                if (!fkVar.mRetaining && hV) {
                    if (!fkVar.mStarted) {
                        fkVar.ir();
                    }
                    fkVar.it();
                }
                if (fkVar.mRetaining) {
                    i = 1;
                } else {
                    fkVar.ix();
                    this.IZ.remove(fkVar.mWho);
                }
                i2++;
            }
        } else {
            i = 0;
        }
        if (i != 0) {
            return this.IZ;
        }
        return null;
    }

    void m11265a(jv<String, fj> jvVar) {
        if (jvVar != null) {
            int size = jvVar.size();
            for (int i = 0; i < size; i++) {
                ((fk) jvVar.valueAt(i)).m11420b(this);
            }
        }
        this.IZ = jvVar;
    }

    void dumpLoaders(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mLoadersStarted=");
        printWriter.println(this.mLoadersStarted);
        if (this.mLoaderManager != null) {
            printWriter.print(str);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this.mLoaderManager)));
            printWriter.println(":");
            this.mLoaderManager.dump(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }
}
