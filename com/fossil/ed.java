package com.fossil;

import android.annotation.TargetApi;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

@TargetApi(9)
class ed implements eb {

    static class C3321a implements ef {
        private long CZ = 200;
        private boolean GG = false;
        List<ec> HA = new ArrayList();
        View HB;
        private float HC = 0.0f;
        private Runnable HD = new C33201(this);
        private long mStartTime;
        private boolean mStarted = false;
        List<ea> vm = new ArrayList();

        class C33201 implements Runnable {
            final /* synthetic */ C3321a HE;

            C33201(C3321a c3321a) {
                this.HE = c3321a;
            }

            public void run() {
                float a = (((float) (this.HE.getTime() - this.HE.mStartTime)) * 1.0f) / ((float) this.HE.CZ);
                if (a > 1.0f || this.HE.HB.getParent() == null) {
                    a = 1.0f;
                }
                this.HE.HC = a;
                this.HE.hI();
                if (this.HE.HC >= 1.0f) {
                    this.HE.hJ();
                } else {
                    this.HE.HB.postDelayed(this.HE.HD, 16);
                }
            }
        }

        private void hI() {
            for (int size = this.HA.size() - 1; size >= 0; size--) {
                ((ec) this.HA.get(size)).m10469e(this);
            }
        }

        public void mo2808G(View view) {
            this.HB = view;
        }

        public void mo2809a(ea eaVar) {
            this.vm.add(eaVar);
        }

        public void setDuration(long j) {
            if (!this.mStarted) {
                this.CZ = j;
            }
        }

        public void start() {
            if (!this.mStarted) {
                this.mStarted = true;
                dispatchStart();
                this.HC = 0.0f;
                this.mStartTime = getTime();
                this.HB.postDelayed(this.HD, 16);
            }
        }

        private long getTime() {
            return this.HB.getDrawingTime();
        }

        private void dispatchStart() {
            for (int size = this.vm.size() - 1; size >= 0; size--) {
                ((ea) this.vm.get(size)).m10390a(this);
            }
        }

        private void hJ() {
            for (int size = this.vm.size() - 1; size >= 0; size--) {
                ((ea) this.vm.get(size)).m10391b(this);
            }
        }

        private void hK() {
            for (int size = this.vm.size() - 1; size >= 0; size--) {
                ((ea) this.vm.get(size)).m10392c(this);
            }
        }

        public void cancel() {
            if (!this.GG) {
                this.GG = true;
                if (this.mStarted) {
                    hK();
                }
                hJ();
            }
        }

        public void mo2810a(ec ecVar) {
            this.HA.add(ecVar);
        }

        public float getAnimatedFraction() {
            return this.HC;
        }
    }

    ed() {
    }

    public ef hH() {
        return new C3321a();
    }

    public void mo2815F(View view) {
    }
}
