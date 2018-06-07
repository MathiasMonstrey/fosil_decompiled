package com.fossil;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.fossil.pq.C3998b;

class te {

    static class C4103a implements td {
        C4103a() {
        }

        private void m13667a(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2) {
            canvas.save();
            canvas.translate(f, f2);
            recyclerView.drawChild(canvas, view, 0);
            canvas.restore();
        }

        public void cK(View view) {
            view.setVisibility(0);
        }

        public void cL(View view) {
            view.setVisibility(4);
        }

        public void mo4157a(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
            if (i != 2) {
                m13667a(canvas, recyclerView, view, f, f2);
            }
        }

        public void mo4158b(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
            if (i == 2) {
                m13667a(canvas, recyclerView, view, f, f2);
            }
        }
    }

    static class C4104b implements td {
        C4104b() {
        }

        public void cK(View view) {
            li.e(view, 0.0f);
            li.f(view, 0.0f);
        }

        public void cL(View view) {
        }

        public void mo4157a(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
            li.e(view, f);
            li.f(view, f2);
        }

        public void mo4158b(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
        }
    }

    static class C4105c extends C4104b {
        C4105c() {
        }

        public void mo4157a(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
            if (z && view.getTag(C3998b.item_touch_helper_previous_elevation) == null) {
                Float valueOf = Float.valueOf(li.ag(view));
                li.l(view, 1.0f + m13672a(recyclerView, view));
                view.setTag(C3998b.item_touch_helper_previous_elevation, valueOf);
            }
            super.mo4157a(canvas, recyclerView, view, f, f2, i, z);
        }

        private float m13672a(RecyclerView recyclerView, View view) {
            int childCount = recyclerView.getChildCount();
            float f = 0.0f;
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView.getChildAt(i);
                if (childAt != view) {
                    float ag = li.ag(childAt);
                    if (ag > f) {
                        f = ag;
                    }
                }
            }
            return f;
        }

        public void cK(View view) {
            Object tag = view.getTag(C3998b.item_touch_helper_previous_elevation);
            if (tag != null && (tag instanceof Float)) {
                li.l(view, ((Float) tag).floatValue());
            }
            view.setTag(C3998b.item_touch_helper_previous_elevation, null);
            super.cK(view);
        }
    }
}
