package com.fossil;

import android.support.constraint.solver.widgets.ConstraintAnchor;
import android.support.constraint.solver.widgets.ConstraintAnchor.Type;
import android.support.constraint.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

public class C4070s extends ConstraintWidget {
    private int mOrientation = 0;
    protected float sY = -1.0f;
    protected int sZ = -1;
    protected int ta = -1;
    private ConstraintAnchor tb = this.rE;
    private boolean tc = false;
    private int td = 0;
    private C4130u te = new C4130u();
    private int tf = 8;

    static /* synthetic */ class C40691 {
        static final /* synthetic */ int[] rr = new int[Type.values().length];

        static {
            try {
                rr[Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                rr[Type.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                rr[Type.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                rr[Type.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public C4070s() {
        this.rL.clear();
        this.rL.add(this.tb);
    }

    public void setOrientation(int i) {
        if (this.mOrientation != i) {
            this.mOrientation = i;
            this.rL.clear();
            if (this.mOrientation == 1) {
                this.tb = this.rD;
            } else {
                this.tb = this.rE;
            }
            this.rL.add(this.tb);
        }
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public ConstraintAnchor m13489a(Type type) {
        switch (C40691.rr[type.ordinal()]) {
            case 1:
            case 2:
                if (this.mOrientation == 1) {
                    return this.tb;
                }
                break;
            case 3:
            case 4:
                if (this.mOrientation == 0) {
                    return this.tb;
                }
                break;
        }
        return null;
    }

    public ArrayList<ConstraintAnchor> eC() {
        return this.rL;
    }

    public void m13492g(float f) {
        if (f > -1.0f) {
            this.sY = f;
            this.sZ = -1;
            this.ta = -1;
        }
    }

    public void m13493z(int i) {
        if (i > -1) {
            this.sY = -1.0f;
            this.sZ = i;
            this.ta = -1;
        }
    }

    public void m13488A(int i) {
        if (i > -1) {
            this.sY = -1.0f;
            this.sZ = -1;
            this.ta = i;
        }
    }

    public float eM() {
        return this.sY;
    }

    public int eN() {
        return this.sZ;
    }

    public int eO() {
        return this.ta;
    }

    public void m13490a(C3953p c3953p, int i) {
        C4023r c4023r = (C4023r) en();
        if (c4023r != null) {
            Object a;
            Object a2 = c4023r.a(Type.LEFT);
            ConstraintAnchor a3 = c4023r.a(Type.RIGHT);
            if (this.mOrientation == 0) {
                a3 = c4023r.a(Type.TOP);
                a = c4023r.a(Type.BOTTOM);
                a2 = a3;
            } else {
                ConstraintAnchor constraintAnchor = a3;
            }
            if (this.sZ != -1) {
                c3953p.m13007e(C3953p.m12990a(c3953p, c3953p.m13003c(this.tb), c3953p.m13003c(a2), this.sZ, false));
            } else if (this.ta != -1) {
                c3953p.m13007e(C3953p.m12990a(c3953p, c3953p.m13003c(this.tb), c3953p.m13003c(a), -this.ta, false));
            } else if (this.sY != -1.0f) {
                c3953p.m13007e(C3953p.m12991a(c3953p, c3953p.m13003c(this.tb), c3953p.m13003c(a2), c3953p.m13003c(a), this.sY, this.tc));
            }
        }
    }

    public void m13491b(C3953p c3953p, int i) {
        if (en() != null) {
            int d = c3953p.m13005d(this.tb);
            if (this.mOrientation == 1) {
                setX(d);
                setY(0);
                setHeight(en().getHeight());
                setWidth(0);
                return;
            }
            setX(0);
            setY(d);
            setWidth(en().getWidth());
            setHeight(0);
        }
    }
}
