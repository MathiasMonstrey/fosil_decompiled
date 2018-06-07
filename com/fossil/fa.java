package com.fossil;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class fa {

    public static abstract class C3106a {
        public void m9378a(fa faVar, Fragment fragment, Context context) {
        }

        public void m9382b(fa faVar, Fragment fragment, Context context) {
        }

        public void m9379a(fa faVar, Fragment fragment, Bundle bundle) {
        }

        public void m9383b(fa faVar, Fragment fragment, Bundle bundle) {
        }

        public void m9380a(fa faVar, Fragment fragment, View view, Bundle bundle) {
        }

        public void m9377a(fa faVar, Fragment fragment) {
        }

        public void m9381b(fa faVar, Fragment fragment) {
        }

        public void m9384c(fa faVar, Fragment fragment) {
        }

        public void m9386d(fa faVar, Fragment fragment) {
        }

        public void m9385c(fa faVar, Fragment fragment, Bundle bundle) {
        }

        public void mo2664e(fa faVar, Fragment fragment) {
        }

        public void m9388f(fa faVar, Fragment fragment) {
        }

        public void m9389g(fa faVar, Fragment fragment) {
        }
    }

    public interface C3555b {
        void onBackStackChanged();
    }

    public abstract Fragment mo3086W(String str);

    public abstract void mo3087a(C3106a c3106a);

    public abstract void mo3088a(C3106a c3106a, boolean z);

    public abstract Fragment aF(int i);

    public abstract void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract boolean executePendingTransactions();

    public abstract int getBackStackEntryCount();

    public abstract fg hW();

    public abstract void popBackStack();

    public abstract void popBackStack(int i, int i2);

    public abstract boolean popBackStackImmediate();
}
