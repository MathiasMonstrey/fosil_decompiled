package android.support.design.widget;

import android.support.design.widget.CoordinatorLayout.Behavior;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.fossil.ks;
import com.fossil.li;
import com.fossil.oq;
import com.fossil.oq.a;

public class SwipeDismissBehavior<V extends View> extends Behavior<V> {
    private boolean AA;
    private float AB = 0.0f;
    private boolean AC;
    int AE = 2;
    float AF = 0.5f;
    float AG = 0.0f;
    float AI = 0.5f;
    C1106a Az;
    oq vY;
    private final a wj = new C00321(this);

    class C00321 extends a {
        private int AJ;
        final /* synthetic */ SwipeDismissBehavior AK;
        private int mActivePointerId = -1;

        C00321(SwipeDismissBehavior swipeDismissBehavior) {
            this.AK = swipeDismissBehavior;
        }

        public boolean m1886b(View view, int i) {
            return this.mActivePointerId == -1 && this.AK.mo1129g(view);
        }

        public void m1888j(View view, int i) {
            this.mActivePointerId = i;
            this.AJ = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        public void m1882Q(int i) {
            if (this.AK.Az != null) {
                this.AK.Az.mo1124L(i);
            }
        }

        public void m1883a(View view, float f, float f2) {
            this.mActivePointerId = -1;
            int width = view.getWidth();
            boolean z = false;
            if (m1881c(view, f)) {
                width = view.getLeft() < this.AJ ? this.AJ - width : this.AJ + width;
                z = true;
            } else {
                width = this.AJ;
            }
            if (this.AK.vY.J(width, view.getTop())) {
                li.m12254b(view, new C1107b(this.AK, view, z));
            } else if (z && this.AK.Az != null) {
                this.AK.Az.mo1125d(view);
            }
        }

        private boolean m1881c(View view, float f) {
            if (f != 0.0f) {
                boolean z = li.m12235S(view) == 1;
                if (this.AK.AE == 2) {
                    return true;
                }
                if (this.AK.AE == 0) {
                    if (z) {
                        if (f >= 0.0f) {
                            return false;
                        }
                        return true;
                    } else if (f <= 0.0f) {
                        return false;
                    } else {
                        return true;
                    }
                } else if (this.AK.AE != 1) {
                    return false;
                } else {
                    if (z) {
                        if (f <= 0.0f) {
                            return false;
                        }
                        return true;
                    } else if (f >= 0.0f) {
                        return false;
                    } else {
                        return true;
                    }
                }
            }
            if (Math.abs(view.getLeft() - this.AJ) < Math.round(((float) view.getWidth()) * this.AK.AF)) {
                return false;
            }
            return true;
        }

        public int m1889v(View view) {
            return view.getWidth();
        }

        public int m1887c(View view, int i, int i2) {
            int width;
            int i3;
            Object obj = li.m12235S(view) == 1 ? 1 : null;
            if (this.AK.AE == 0) {
                if (obj != null) {
                    width = this.AJ - view.getWidth();
                    i3 = this.AJ;
                } else {
                    width = this.AJ;
                    i3 = this.AJ + view.getWidth();
                }
            } else if (this.AK.AE != 1) {
                width = this.AJ - view.getWidth();
                i3 = this.AJ + view.getWidth();
            } else if (obj != null) {
                width = this.AJ;
                i3 = this.AJ + view.getWidth();
            } else {
                width = this.AJ - view.getWidth();
                i3 = this.AJ;
            }
            return SwipeDismissBehavior.m1895f(width, i, i3);
        }

        public int m1884b(View view, int i, int i2) {
            return view.getTop();
        }

        public void m1885b(View view, int i, int i2, int i3, int i4) {
            float width = ((float) this.AJ) + (((float) view.getWidth()) * this.AK.AG);
            float width2 = ((float) this.AJ) + (((float) view.getWidth()) * this.AK.AI);
            if (((float) i) <= width) {
                li.m12264g(view, 1.0f);
            } else if (((float) i) >= width2) {
                li.m12264g(view, 0.0f);
            } else {
                li.m12264g(view, SwipeDismissBehavior.m1893c(0.0f, 1.0f - SwipeDismissBehavior.m1894d(width, width2, (float) i), 1.0f));
            }
        }
    }

    public interface C1106a {
        void mo1124L(int i);

        void mo1125d(View view);
    }

    class C1107b implements Runnable {
        final /* synthetic */ SwipeDismissBehavior AK;
        private final boolean AL;
        private final View mView;

        C1107b(SwipeDismissBehavior swipeDismissBehavior, View view, boolean z) {
            this.AK = swipeDismissBehavior;
            this.mView = view;
            this.AL = z;
        }

        public void run() {
            if (this.AK.vY != null && this.AK.vY.N(true)) {
                li.m12254b(this.mView, (Runnable) this);
            } else if (this.AL && this.AK.Az != null) {
                this.AK.Az.mo1125d(this.mView);
            }
        }
    }

    public void m1896a(C1106a c1106a) {
        this.Az = c1106a;
    }

    public void ah(int i) {
        this.AE = i;
    }

    public void m1898s(float f) {
        this.AG = m1893c(0.0f, f, 1.0f);
    }

    public void m1899t(float f) {
        this.AI = m1893c(0.0f, f, 1.0f);
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = this.AA;
        switch (ks.m12043a(motionEvent)) {
            case 0:
                this.AA = coordinatorLayout.m1845e(v, (int) motionEvent.getX(), (int) motionEvent.getY());
                z = this.AA;
                break;
            case 1:
            case 3:
                this.AA = false;
                break;
        }
        if (!z) {
            return false;
        }
        m1892b(coordinatorLayout);
        return this.vY.f(motionEvent);
    }

    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.vY == null) {
            return false;
        }
        this.vY.g(motionEvent);
        return true;
    }

    public boolean mo1129g(View view) {
        return true;
    }

    private void m1892b(ViewGroup viewGroup) {
        if (this.vY == null) {
            oq a;
            if (this.AC) {
                a = oq.a(viewGroup, this.AB, this.wj);
            } else {
                a = oq.a(viewGroup, this.wj);
            }
            this.vY = a;
        }
    }

    static float m1893c(float f, float f2, float f3) {
        return Math.min(Math.max(f, f2), f3);
    }

    static int m1895f(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    static float m1894d(float f, float f2, float f3) {
        return (f3 - f) / (f2 - f);
    }
}
