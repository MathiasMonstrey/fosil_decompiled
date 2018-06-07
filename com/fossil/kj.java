package com.fossil;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.View;

@TargetApi(9)
class kj {

    static class C3796a implements Factory {
        final km Rx;

        C3796a(km kmVar) {
            this.Rx = kmVar;
        }

        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return this.Rx.onCreateView(null, str, context, attributeSet);
        }

        public String toString() {
            return getClass().getName() + "{" + this.Rx + "}";
        }
    }

    static void m11975a(LayoutInflater layoutInflater, km kmVar) {
        layoutInflater.setFactory(kmVar != null ? new C3796a(kmVar) : null);
    }

    static km m11974a(LayoutInflater layoutInflater) {
        Factory factory = layoutInflater.getFactory();
        if (factory instanceof C3796a) {
            return ((C3796a) factory).Rx;
        }
        return null;
    }
}
