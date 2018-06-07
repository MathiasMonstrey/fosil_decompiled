package com.fossil;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import android.view.View;
import com.fossil.kj.C3796a;
import java.lang.reflect.Field;

@TargetApi(11)
class kk {
    private static Field Ry;
    private static boolean Rz;

    static class C3797a extends C3796a implements Factory2 {
        C3797a(km kmVar) {
            super(kmVar);
        }

        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            return this.Rx.onCreateView(view, str, context, attributeSet);
        }
    }

    static void m11977a(LayoutInflater layoutInflater, km kmVar) {
        Factory2 c3797a;
        if (kmVar != null) {
            c3797a = new C3797a(kmVar);
        } else {
            c3797a = null;
        }
        layoutInflater.setFactory2(c3797a);
        Factory factory = layoutInflater.getFactory();
        if (factory instanceof Factory2) {
            m11976a(layoutInflater, (Factory2) factory);
        } else {
            m11976a(layoutInflater, c3797a);
        }
    }

    static void m11976a(LayoutInflater layoutInflater, Factory2 factory2) {
        if (!Rz) {
            try {
                Ry = LayoutInflater.class.getDeclaredField("mFactory2");
                Ry.setAccessible(true);
            } catch (Throwable e) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e);
            }
            Rz = true;
        }
        if (Ry != null) {
            try {
                Ry.set(layoutInflater, factory2);
            } catch (Throwable e2) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e2);
            }
        }
    }
}
