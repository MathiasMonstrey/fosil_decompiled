package com.fossil;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;

public class bm {
    private static final C1935a Di;

    interface C1935a {
        void mo1393a(ViewGroup viewGroup, View view, Rect rect);
    }

    static class C1936b implements C1935a {
        C1936b() {
        }

        public void mo1393a(ViewGroup viewGroup, View view, Rect rect) {
            viewGroup.offsetDescendantRectToMyCoords(view, rect);
            rect.offset(view.getScrollX(), view.getScrollY());
        }
    }

    static class C1937c implements C1935a {
        C1937c() {
        }

        public void mo1393a(ViewGroup viewGroup, View view, Rect rect) {
            bn.m5307a(viewGroup, view, rect);
        }
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            Di = new C1937c();
        } else {
            Di = new C1936b();
        }
    }

    static void m5286a(ViewGroup viewGroup, View view, Rect rect) {
        Di.mo1393a(viewGroup, view, rect);
    }

    public static void m5287b(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        m5286a(viewGroup, view, rect);
    }
}
