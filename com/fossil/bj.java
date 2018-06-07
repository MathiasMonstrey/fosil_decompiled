package com.fossil;

import android.view.animation.Interpolator;

public class bj {
    private final C1930e CR;

    public interface C1073c {
        void mo14a(bj bjVar);
    }

    public interface C1114a {
        void mo71b(bj bjVar);

        void mo72c(bj bjVar);

        void mo73d(bj bjVar);
    }

    public static class C1115b implements C1114a {
        protected C1115b() {
        }

        public void mo72c(bj bjVar) {
        }

        public void mo71b(bj bjVar) {
        }

        public void mo73d(bj bjVar) {
        }
    }

    public interface C1929d {
        bj ha();
    }

    static abstract class C1930e {

        interface C1925b {
            void gY();
        }

        interface C1927a {
            void gZ();

            void onAnimationEnd();

            void onAnimationStart();
        }

        abstract void mo1364a(C1927a c1927a);

        abstract void mo1365a(C1925b c1925b);

        abstract void cancel();

        abstract void mo1367d(float f, float f2);

        abstract void end();

        abstract int gW();

        abstract float gX();

        abstract float getAnimatedFraction();

        abstract long getDuration();

        abstract boolean isRunning();

        abstract void mo1374q(int i, int i2);

        abstract void setDuration(long j);

        abstract void setInterpolator(Interpolator interpolator);

        abstract void start();

        C1930e() {
        }
    }

    bj(C1930e c1930e) {
        this.CR = c1930e;
    }

    public void start() {
        this.CR.start();
    }

    public boolean isRunning() {
        return this.CR.isRunning();
    }

    public void setInterpolator(Interpolator interpolator) {
        this.CR.setInterpolator(interpolator);
    }

    public void m5222a(final C1073c c1073c) {
        if (c1073c != null) {
            this.CR.mo1365a(new C1925b(this) {
                final /* synthetic */ bj CT;

                public void gY() {
                    c1073c.mo14a(this.CT);
                }
            });
        } else {
            this.CR.mo1365a(null);
        }
    }

    public void m5221a(final C1114a c1114a) {
        if (c1114a != null) {
            this.CR.mo1364a(new C1927a(this) {
                final /* synthetic */ bj CT;

                public void onAnimationStart() {
                    c1114a.mo72c(this.CT);
                }

                public void onAnimationEnd() {
                    c1114a.mo71b(this.CT);
                }

                public void gZ() {
                    c1114a.mo73d(this.CT);
                }
            });
        } else {
            this.CR.mo1364a(null);
        }
    }

    public void m5224q(int i, int i2) {
        this.CR.mo1374q(i, i2);
    }

    public int gW() {
        return this.CR.gW();
    }

    public void m5223d(float f, float f2) {
        this.CR.mo1367d(f, f2);
    }

    public float gX() {
        return this.CR.gX();
    }

    public void setDuration(long j) {
        this.CR.setDuration(j);
    }

    public void cancel() {
        this.CR.cancel();
    }

    public float getAnimatedFraction() {
        return this.CR.getAnimatedFraction();
    }

    public void end() {
        this.CR.end();
    }

    public long getDuration() {
        return this.CR.getDuration();
    }
}
