package android.support.constraint.solver.widgets;

import android.support.constraint.solver.SolverVariable;
import com.fossil.C3899n;
import com.fossil.s;
import java.util.HashSet;

public class ConstraintAnchor {
    public final ConstraintWidget rh;
    public final Type ri;
    public ConstraintAnchor rj;
    public int rk = 0;
    int rl = -1;
    private Strength rm = Strength.NONE;
    private ConnectionType rn = ConnectionType.RELAXED;
    private int ro = 0;
    public SolverVariable rp;
    int rq = Integer.MAX_VALUE;

    public enum ConnectionType {
        RELAXED,
        STRICT
    }

    public enum Strength {
        NONE,
        STRONG,
        WEAK
    }

    public enum Type {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public ConstraintAnchor(ConstraintWidget constraintWidget, Type type) {
        this.rh = constraintWidget;
        this.ri = type;
    }

    public SolverVariable ed() {
        return this.rp;
    }

    public void m1647a(C3899n c3899n) {
        if (this.rp == null) {
            this.rp = new SolverVariable(android.support.constraint.solver.SolverVariable.Type.UNRESTRICTED);
        } else {
            this.rp.reset();
        }
    }

    public ConstraintWidget ee() {
        return this.rh;
    }

    public Type ef() {
        return this.ri;
    }

    public int eg() {
        if (this.rh.getVisibility() == 8) {
            return 0;
        }
        if (this.rl <= -1 || this.rj == null || this.rj.rh.getVisibility() != 8) {
            return this.rk;
        }
        return this.rl;
    }

    public Strength eh() {
        return this.rm;
    }

    public ConstraintAnchor ei() {
        return this.rj;
    }

    public ConnectionType ej() {
        return this.rn;
    }

    public void m1646a(ConnectionType connectionType) {
        this.rn = connectionType;
    }

    public int ek() {
        return this.ro;
    }

    public void reset() {
        this.rj = null;
        this.rk = 0;
        this.rl = -1;
        this.rm = Strength.STRONG;
        this.ro = 0;
        this.rn = ConnectionType.RELAXED;
    }

    public boolean m1650a(ConstraintAnchor constraintAnchor, int i, Strength strength, int i2) {
        return m1649a(constraintAnchor, i, -1, strength, i2, false);
    }

    public boolean m1649a(ConstraintAnchor constraintAnchor, int i, int i2, Strength strength, int i3, boolean z) {
        if (constraintAnchor == null) {
            this.rj = null;
            this.rk = 0;
            this.rl = -1;
            this.rm = Strength.NONE;
            this.ro = 2;
            return true;
        } else if (!z && !m1648a(constraintAnchor)) {
            return false;
        } else {
            this.rj = constraintAnchor;
            if (i > 0) {
                this.rk = i;
            } else {
                this.rk = 0;
            }
            this.rl = i2;
            this.rm = strength;
            this.ro = i3;
            return true;
        }
    }

    public boolean isConnected() {
        return this.rj != null;
    }

    public boolean m1648a(ConstraintAnchor constraintAnchor) {
        boolean z = true;
        if (constraintAnchor == null) {
            return false;
        }
        Type ef = constraintAnchor.ef();
        if (ef != this.ri) {
            boolean z2;
            switch (this.ri) {
                case CENTER:
                    if (ef == Type.BASELINE || ef == Type.CENTER_X || ef == Type.CENTER_Y) {
                        z = false;
                    }
                    return z;
                case LEFT:
                case RIGHT:
                    if (ef == Type.LEFT || ef == Type.RIGHT) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (constraintAnchor.ee() instanceof s) {
                        if (z2 || ef == Type.CENTER_X) {
                            return true;
                        }
                        return false;
                    }
                    break;
                case TOP:
                case BOTTOM:
                    if (ef == Type.TOP || ef == Type.BOTTOM) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (constraintAnchor.ee() instanceof s) {
                        if (z2 || ef == Type.CENTER_Y) {
                            return true;
                        }
                        return false;
                    }
                    break;
                default:
                    return false;
            }
            return z2;
        } else if (this.ri == Type.CENTER) {
            return false;
        } else {
            if (this.ri != Type.BASELINE || (constraintAnchor.ee().ez() && ee().ez())) {
                return true;
            }
            return false;
        }
    }

    public String toString() {
        return this.rh.eo() + ":" + this.ri.toString() + (this.rj != null ? " connected to " + this.rj.m1645a(new HashSet()) : "");
    }

    private String m1645a(HashSet<ConstraintAnchor> hashSet) {
        if (!hashSet.add(this)) {
            return "<-";
        }
        return this.rh.eo() + ":" + this.ri.toString() + (this.rj != null ? " connected to " + this.rj.m1645a((HashSet) hashSet) : "");
    }
}
