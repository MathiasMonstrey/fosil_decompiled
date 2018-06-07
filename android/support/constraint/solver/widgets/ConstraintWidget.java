package android.support.constraint.solver.widgets;

import android.support.constraint.solver.SolverVariable;
import android.support.constraint.solver.widgets.ConstraintAnchor.ConnectionType;
import android.support.constraint.solver.widgets.ConstraintAnchor.Strength;
import android.support.constraint.solver.widgets.ConstraintAnchor.Type;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.fossil.C3857m;
import com.fossil.C3899n;
import com.fossil.p;
import com.fossil.r;
import java.util.ArrayList;

public class ConstraintWidget {
    public static float se = 0.5f;
    protected int oL;
    protected int oM;
    protected int pS = 0;
    protected int pT = 0;
    protected int rA = 0;
    protected int rB = 0;
    protected int rC = 0;
    public ConstraintAnchor rD = new ConstraintAnchor(this, Type.LEFT);
    public ConstraintAnchor rE = new ConstraintAnchor(this, Type.TOP);
    public ConstraintAnchor rF = new ConstraintAnchor(this, Type.RIGHT);
    public ConstraintAnchor rG = new ConstraintAnchor(this, Type.BOTTOM);
    public ConstraintAnchor rH = new ConstraintAnchor(this, Type.BASELINE);
    ConstraintAnchor rI = new ConstraintAnchor(this, Type.CENTER_X);
    ConstraintAnchor rJ = new ConstraintAnchor(this, Type.CENTER_Y);
    ConstraintAnchor rK = new ConstraintAnchor(this, Type.CENTER);
    protected ArrayList<ConstraintAnchor> rL = new ArrayList();
    protected ConstraintWidget rM = null;
    protected float rN = 0.0f;
    protected int rO = -1;
    private int rP = 0;
    private int rQ = 0;
    private int rR = 0;
    private int rS = 0;
    protected int rT = 0;
    protected int rU = 0;
    private int rV = 0;
    private int rW = 0;
    private int rX = 0;
    private int rY = 0;
    protected int rZ = 0;
    public int rv = -1;
    public int rw = -1;
    protected int rx = 0;
    protected int ry = 0;
    protected int rz = 0;
    protected boolean sA;
    protected boolean sB;
    public float sC = 0.0f;
    public float sD = 0.0f;
    protected ConstraintWidget sE = null;
    protected ConstraintWidget sF = null;
    protected int sa = 0;
    public int sb = 0;
    private int sc;
    private int sd;
    public float sf = se;
    public float sg = se;
    public DimensionBehaviour sh = DimensionBehaviour.FIXED;
    public DimensionBehaviour si = DimensionBehaviour.FIXED;
    private Object sj;
    private int sk = 0;
    private int sl = 0;
    private String sm = null;
    private String sn = null;
    protected int so;
    protected int sp;
    protected int sq;
    protected int sr;
    protected boolean ss;
    protected boolean st;
    protected boolean su;
    protected boolean sv;
    protected boolean sw;
    protected boolean sx;
    protected int sy = 0;
    protected int sz = 0;

    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public void reset() {
        this.rD.reset();
        this.rE.reset();
        this.rF.reset();
        this.rG.reset();
        this.rH.reset();
        this.rI.reset();
        this.rJ.reset();
        this.rK.reset();
        this.rM = null;
        this.pS = 0;
        this.pT = 0;
        this.rN = 0.0f;
        this.rO = -1;
        this.rT = 0;
        this.rU = 0;
        this.rV = 0;
        this.rW = 0;
        this.rX = 0;
        this.rY = 0;
        this.rZ = 0;
        this.sa = 0;
        this.sb = 0;
        this.oL = 0;
        this.oM = 0;
        this.sc = 0;
        this.sd = 0;
        this.sf = se;
        this.sg = se;
        this.sh = DimensionBehaviour.FIXED;
        this.si = DimensionBehaviour.FIXED;
        this.sj = null;
        this.sk = 0;
        this.sl = 0;
        this.sm = null;
        this.sn = null;
        this.sw = false;
        this.sx = false;
        this.sy = 0;
        this.sz = 0;
        this.sA = false;
        this.sB = false;
        this.sC = 0.0f;
        this.sD = 0.0f;
        this.rv = -1;
        this.rw = -1;
    }

    public ConstraintWidget() {
        el();
    }

    public void m1661b(C3899n c3899n) {
        this.rD.m1647a(c3899n);
        this.rE.m1647a(c3899n);
        this.rF.m1647a(c3899n);
        this.rG.m1647a(c3899n);
        this.rH.m1647a(c3899n);
        this.rK.m1647a(c3899n);
        this.rI.m1647a(c3899n);
        this.rJ.m1647a(c3899n);
    }

    private void el() {
        this.rL.add(this.rD);
        this.rL.add(this.rE);
        this.rL.add(this.rF);
        this.rL.add(this.rG);
        this.rL.add(this.rI);
        this.rL.add(this.rJ);
        this.rL.add(this.rH);
    }

    public boolean em() {
        return this.rM == null;
    }

    public ConstraintWidget en() {
        return this.rM;
    }

    public void m1657a(ConstraintWidget constraintWidget) {
        this.rM = constraintWidget;
    }

    public void setVisibility(int i) {
        this.sl = i;
    }

    public int getVisibility() {
        return this.sl;
    }

    public String eo() {
        return this.sm;
    }

    public String toString() {
        return (this.sn != null ? "type: " + this.sn + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR : "") + (this.sm != null ? "id: " + this.sm + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR : "") + "(" + this.rT + ", " + this.rU + ") - (" + this.pS + " x " + this.pT + ")" + " wrap: (" + this.sc + " x " + this.sd + ")";
    }

    public int getX() {
        return this.rT;
    }

    public int getY() {
        return this.rU;
    }

    public int getWidth() {
        if (this.sl == 8) {
            return 0;
        }
        return this.pS;
    }

    public int ep() {
        int i = this.pS;
        if (this.sh != DimensionBehaviour.MATCH_CONSTRAINT) {
            return i;
        }
        if (this.rx == 1) {
            i = Math.max(this.rz, i);
        } else if (this.rz > 0) {
            i = this.rz;
            this.pS = i;
        } else {
            i = 0;
        }
        if (this.rA <= 0 || this.rA >= i) {
            return i;
        }
        return this.rA;
    }

    public int eq() {
        int i = this.pT;
        if (this.si != DimensionBehaviour.MATCH_CONSTRAINT) {
            return i;
        }
        if (this.ry == 1) {
            i = Math.max(this.rB, i);
        } else if (this.rB > 0) {
            i = this.rB;
            this.pT = i;
        } else {
            i = 0;
        }
        if (this.rC <= 0 || this.rC >= i) {
            return i;
        }
        return this.rC;
    }

    public int er() {
        return this.sc;
    }

    public int getHeight() {
        if (this.sl == 8) {
            return 0;
        }
        return this.pT;
    }

    public int es() {
        return this.sd;
    }

    public int et() {
        return this.rV + this.rZ;
    }

    public int eu() {
        return this.rW + this.sa;
    }

    public int ev() {
        return eu() + this.rY;
    }

    public int ew() {
        return et() + this.rX;
    }

    protected int ex() {
        return this.rT + this.rZ;
    }

    protected int ey() {
        return this.rU + this.sa;
    }

    public int getRight() {
        return getX() + this.pS;
    }

    public int getBottom() {
        return getY() + this.pT;
    }

    public boolean ez() {
        return this.sb > 0;
    }

    public int eA() {
        return this.sb;
    }

    public Object eB() {
        return this.sj;
    }

    public ArrayList<ConstraintAnchor> eC() {
        return this.rL;
    }

    public void setX(int i) {
        this.rT = i;
    }

    public void setY(int i) {
        this.rU = i;
    }

    public void m1668f(int i, int i2) {
        this.rT = i;
        this.rU = i2;
    }

    public void m1670g(int i, int i2) {
        this.rZ = i;
        this.sa = i2;
    }

    public void eD() {
        int i = this.rT;
        int i2 = this.rU;
        int i3 = this.rT + this.pS;
        int i4 = this.rU + this.pT;
        this.rV = i;
        this.rW = i2;
        this.rX = i3 - i;
        this.rY = i4 - i2;
    }

    public void setWidth(int i) {
        this.pS = i;
        if (this.pS < this.oL) {
            this.pS = this.oL;
        }
    }

    public void setHeight(int i) {
        this.pT = i;
        if (this.pT < this.oM) {
            this.pT = this.oM;
        }
    }

    public void m1659b(int i, int i2, int i3) {
        this.rx = i;
        this.rz = i2;
        this.rA = i3;
    }

    public void m1664c(int i, int i2, int i3) {
        this.ry = i;
        this.rB = i2;
        this.rC = i3;
    }

    public void m1652N(String str) {
        int i = 0;
        if (str == null || str.length() == 0) {
            this.rN = 0.0f;
            return;
        }
        float parseFloat;
        int i2 = -1;
        int length = str.length();
        int indexOf = str.indexOf(44);
        if (indexOf > 0 && indexOf < length - 1) {
            String substring = str.substring(0, indexOf);
            if (!substring.equalsIgnoreCase("W")) {
                if (substring.equalsIgnoreCase("H")) {
                    i = 1;
                } else {
                    i = -1;
                }
            }
            i2 = i;
            i = indexOf + 1;
        }
        indexOf = str.indexOf(58);
        String substring2;
        if (indexOf < 0 || indexOf >= length - 1) {
            substring2 = str.substring(i);
            if (substring2.length() > 0) {
                try {
                    parseFloat = Float.parseFloat(substring2);
                } catch (NumberFormatException e) {
                    parseFloat = 0.0f;
                }
            }
            parseFloat = 0.0f;
        } else {
            substring2 = str.substring(i, indexOf);
            String substring3 = str.substring(indexOf + 1);
            if (substring2.length() > 0 && substring3.length() > 0) {
                try {
                    parseFloat = Float.parseFloat(substring2);
                    float parseFloat2 = Float.parseFloat(substring3);
                    if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                        parseFloat = i2 == 1 ? Math.abs(parseFloat2 / parseFloat) : Math.abs(parseFloat / parseFloat2);
                    }
                } catch (NumberFormatException e2) {
                    parseFloat = 0.0f;
                }
            }
            parseFloat = 0.0f;
        }
        if (parseFloat > 0.0f) {
            this.rN = parseFloat;
            this.rO = i2;
        }
    }

    public void m1663c(float f) {
        this.sf = f;
    }

    public void m1665d(float f) {
        this.sg = f;
    }

    public void setMinWidth(int i) {
        if (i < 0) {
            this.oL = 0;
        } else {
            this.oL = i;
        }
    }

    public void setMinHeight(int i) {
        if (i < 0) {
            this.oM = 0;
        } else {
            this.oM = i;
        }
    }

    public void m1673u(int i) {
        this.sc = i;
    }

    public void m1674v(int i) {
        this.sd = i;
    }

    public void m1654a(int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        this.rT = i;
        this.rU = i2;
        if (this.sl == 8) {
            this.pS = 0;
            this.pT = 0;
            return;
        }
        if (this.sh == DimensionBehaviour.FIXED && i5 < this.pS) {
            i5 = this.pS;
        }
        if (this.si == DimensionBehaviour.FIXED && i6 < this.pT) {
            i6 = this.pT;
        }
        this.pS = i5;
        this.pT = i6;
        if (this.pT < this.oM) {
            this.pT = this.oM;
        }
        if (this.pS < this.oL) {
            this.pS = this.oL;
        }
    }

    public void m1671h(int i, int i2) {
        this.rT = i;
        this.pS = i2 - i;
        if (this.pS < this.oL) {
            this.pS = this.oL;
        }
    }

    public void m1672i(int i, int i2) {
        this.rU = i;
        this.pT = i2 - i;
        if (this.pT < this.oM) {
            this.pT = this.oM;
        }
    }

    public void m1675w(int i) {
        this.sb = i;
    }

    public void m1669f(Object obj) {
        this.sj = obj;
    }

    public void m1666e(float f) {
        this.sC = f;
    }

    public void m1667f(float f) {
        this.sD = f;
    }

    public void m1676x(int i) {
        this.sy = i;
    }

    public void m1677y(int i) {
        this.sz = i;
    }

    public void m1655a(Type type, ConstraintWidget constraintWidget, Type type2, int i, int i2) {
        m1653a(type).m1649a(constraintWidget.m1653a(type2), i, i2, Strength.STRONG, 0, true);
    }

    public void eE() {
        ConstraintWidget en = en();
        if (en == null || !(en instanceof r) || !((r) en()).eK()) {
            int size = this.rL.size();
            for (int i = 0; i < size; i++) {
                ((ConstraintAnchor) this.rL.get(i)).reset();
            }
        }
    }

    public ConstraintAnchor m1653a(Type type) {
        switch (type) {
            case LEFT:
                return this.rD;
            case TOP:
                return this.rE;
            case RIGHT:
                return this.rF;
            case BOTTOM:
                return this.rG;
            case BASELINE:
                return this.rH;
            case CENTER_X:
                return this.rI;
            case CENTER_Y:
                return this.rJ;
            case CENTER:
                return this.rK;
            default:
                return null;
        }
    }

    public DimensionBehaviour eF() {
        return this.sh;
    }

    public DimensionBehaviour eG() {
        return this.si;
    }

    public void m1656a(DimensionBehaviour dimensionBehaviour) {
        this.sh = dimensionBehaviour;
        if (this.sh == DimensionBehaviour.WRAP_CONTENT) {
            setWidth(this.sc);
        }
    }

    public void m1660b(DimensionBehaviour dimensionBehaviour) {
        this.si = dimensionBehaviour;
        if (this.si == DimensionBehaviour.WRAP_CONTENT) {
            setHeight(this.sd);
        }
    }

    public void m1658a(p pVar, int i) {
        SolverVariable c;
        SolverVariable c2;
        SolverVariable c3;
        SolverVariable c4;
        SolverVariable c5;
        SolverVariable c6;
        boolean z;
        boolean z2;
        boolean z3;
        float f;
        int i2;
        Object obj;
        boolean z4;
        int i3;
        int i4;
        boolean z5;
        ConstraintAnchor constraintAnchor;
        C3857m dU;
        SolverVariable dW;
        if (i == Integer.MAX_VALUE || this.rD.rq == i) {
            c = pVar.c(this.rD);
        } else {
            c = null;
        }
        if (i == Integer.MAX_VALUE || this.rF.rq == i) {
            c2 = pVar.c(this.rF);
        } else {
            c2 = null;
        }
        if (i == Integer.MAX_VALUE || this.rE.rq == i) {
            c3 = pVar.c(this.rE);
        } else {
            c3 = null;
        }
        if (i == Integer.MAX_VALUE || this.rG.rq == i) {
            c4 = pVar.c(this.rG);
        } else {
            c4 = null;
        }
        if (i == Integer.MAX_VALUE || this.rH.rq == i) {
            c5 = pVar.c(this.rH);
        } else {
            c5 = null;
        }
        if (this.rM != null) {
            boolean z6;
            boolean z7;
            C3857m dU2;
            if ((this.rD.rj == null || this.rD.rj.rj != this.rD) && (this.rF.rj == null || this.rF.rj.rj != this.rF)) {
                z6 = false;
            } else {
                ((r) this.rM).a(this, 0);
                z6 = true;
            }
            if ((this.rE.rj == null || this.rE.rj.rj != this.rE) && (this.rG.rj == null || this.rG.rj.rj != this.rG)) {
                z7 = false;
            } else {
                ((r) this.rM).a(this, 1);
                z7 = true;
            }
            if (this.rM.eF() == DimensionBehaviour.WRAP_CONTENT && !z6) {
                if (this.rD.rj == null || this.rD.rj.rh != this.rM) {
                    c6 = pVar.c(this.rM.rD);
                    dU2 = pVar.dU();
                    dU2.m12428a(c, c6, pVar.dV(), 0);
                    pVar.e(dU2);
                } else if (this.rD.rj != null && this.rD.rj.rh == this.rM) {
                    this.rD.m1646a(ConnectionType.STRICT);
                }
                if (this.rF.rj == null || this.rF.rj.rh != this.rM) {
                    c6 = pVar.c(this.rM.rF);
                    dU2 = pVar.dU();
                    dU2.m12428a(c6, c2, pVar.dV(), 0);
                    pVar.e(dU2);
                } else if (this.rF.rj != null && this.rF.rj.rh == this.rM) {
                    this.rF.m1646a(ConnectionType.STRICT);
                }
            }
            if (this.rM.eG() == DimensionBehaviour.WRAP_CONTENT && !z7) {
                if (this.rE.rj == null || this.rE.rj.rh != this.rM) {
                    c6 = pVar.c(this.rM.rE);
                    dU2 = pVar.dU();
                    dU2.m12428a(c3, c6, pVar.dV(), 0);
                    pVar.e(dU2);
                } else if (this.rE.rj != null && this.rE.rj.rh == this.rM) {
                    this.rE.m1646a(ConnectionType.STRICT);
                }
                if (this.rG.rj == null || this.rG.rj.rh != this.rM) {
                    c6 = pVar.c(this.rM.rG);
                    dU2 = pVar.dU();
                    dU2.m12428a(c6, c4, pVar.dV(), 0);
                    pVar.e(dU2);
                    z = z7;
                    z2 = z6;
                } else if (this.rG.rj != null && this.rG.rj.rh == this.rM) {
                    this.rG.m1646a(ConnectionType.STRICT);
                }
            }
            z = z7;
            z2 = z6;
        } else {
            z = false;
            z2 = false;
        }
        int i5 = this.pS;
        if (i5 < this.oL) {
            i5 = this.oL;
        }
        int i6 = this.pT;
        if (i6 < this.oM) {
            i6 = this.oM;
        }
        boolean z8 = this.sh != DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z9 = this.si != DimensionBehaviour.MATCH_CONSTRAINT;
        if (z8 || this.rD == null || this.rF == null || !(this.rD.rj == null || this.rF.rj == null)) {
            z3 = z8;
        } else {
            z3 = true;
        }
        if (z9 || this.rE == null || this.rG == null || (!(this.rE.rj == null || this.rG.rj == null) || (this.sb != 0 && (this.rH == null || !(this.rE.rj == null || this.rH.rj == null))))) {
            z8 = z9;
        } else {
            z8 = true;
        }
        Object obj2 = null;
        int i7 = this.rO;
        float f2 = this.rN;
        if (this.rN > 0.0f && this.sl != 8) {
            if (this.sh == DimensionBehaviour.MATCH_CONSTRAINT && this.si == DimensionBehaviour.MATCH_CONSTRAINT) {
                obj2 = 1;
                if (z3 && !z8) {
                    f = f2;
                    i2 = 0;
                    obj = 1;
                    z4 = z8;
                    i3 = i6;
                    i4 = i5;
                    z9 = z3;
                    if (obj == null) {
                    }
                    if (this.sh != DimensionBehaviour.WRAP_CONTENT) {
                    }
                    if (z5) {
                    }
                    m1651a(pVar, z8, z9, this.rD, this.rF, this.rT, this.rT + i4, i4, this.oL, this.sf, z5, z2, this.rx, this.rz, this.rA);
                    if (this.rw != 2) {
                        if (this.si != DimensionBehaviour.WRAP_CONTENT) {
                        }
                        if (obj == null) {
                        }
                        if (this.sb <= 0) {
                            constraintAnchor = this.rG;
                            pVar.c(c5, c3, eA(), 5);
                            if (this.rH.rj == null) {
                                i4 = this.sb;
                                constraintAnchor = this.rH;
                            } else {
                                i4 = i3;
                            }
                            if (z5) {
                            }
                            m1651a(pVar, z8, z4, this.rE, constraintAnchor, this.rU, this.rU + i4, i4, this.oM, this.sg, z5, z, this.ry, this.rB, this.rC);
                            pVar.c(c4, c3, i3, 5);
                        } else {
                            if (z5) {
                            }
                            m1651a(pVar, z8, z4, this.rE, this.rG, this.rU, this.rU + i3, i3, this.oM, this.sg, z5, z, this.ry, this.rB, this.rC);
                        }
                        if (obj == null) {
                            dU = pVar.dU();
                            if (i == Integer.MAX_VALUE) {
                            }
                            if (i2 != 0) {
                                pVar.e(dU.m12429a(c2, c, c4, c3, f));
                            } else if (i2 != 1) {
                                pVar.e(dU.m12429a(c4, c3, c2, c, f));
                            } else {
                                if (this.rz > 0) {
                                    pVar.a(c2, c, this.rz, 3);
                                }
                                if (this.rB > 0) {
                                    pVar.a(c4, c3, this.rB, 3);
                                }
                                dU.m12429a(c2, c, c4, c3, f);
                                dW = pVar.dW();
                                c6 = pVar.dW();
                                dW.ra = 4;
                                c6.ra = 4;
                                dU.m12424a(dW, c6);
                                pVar.e(dU);
                            }
                        }
                    }
                } else if (!z3 && z8) {
                    i7 = 1;
                    if (this.rO == -1) {
                        f = 1.0f / f2;
                        i2 = 1;
                        int i8 = 1;
                        z4 = z8;
                        i3 = i6;
                        i4 = i5;
                        z9 = z3;
                        if (obj == null) {
                        }
                        if (this.sh != DimensionBehaviour.WRAP_CONTENT) {
                        }
                        if (z5) {
                        }
                        m1651a(pVar, z8, z9, this.rD, this.rF, this.rT, this.rT + i4, i4, this.oL, this.sf, z5, z2, this.rx, this.rz, this.rA);
                        if (this.rw != 2) {
                            if (this.si != DimensionBehaviour.WRAP_CONTENT) {
                            }
                            if (obj == null) {
                            }
                            if (this.sb <= 0) {
                                if (z5) {
                                }
                                m1651a(pVar, z8, z4, this.rE, this.rG, this.rU, this.rU + i3, i3, this.oM, this.sg, z5, z, this.ry, this.rB, this.rC);
                            } else {
                                constraintAnchor = this.rG;
                                pVar.c(c5, c3, eA(), 5);
                                if (this.rH.rj == null) {
                                    i4 = i3;
                                } else {
                                    i4 = this.sb;
                                    constraintAnchor = this.rH;
                                }
                                if (z5) {
                                }
                                m1651a(pVar, z8, z4, this.rE, constraintAnchor, this.rU, this.rU + i4, i4, this.oM, this.sg, z5, z, this.ry, this.rB, this.rC);
                                pVar.c(c4, c3, i3, 5);
                            }
                            if (obj == null) {
                                dU = pVar.dU();
                                if (i == Integer.MAX_VALUE) {
                                }
                                if (i2 != 0) {
                                    pVar.e(dU.m12429a(c2, c, c4, c3, f));
                                } else if (i2 != 1) {
                                    if (this.rz > 0) {
                                        pVar.a(c2, c, this.rz, 3);
                                    }
                                    if (this.rB > 0) {
                                        pVar.a(c4, c3, this.rB, 3);
                                    }
                                    dU.m12429a(c2, c, c4, c3, f);
                                    dW = pVar.dW();
                                    c6 = pVar.dW();
                                    dW.ra = 4;
                                    c6.ra = 4;
                                    dU.m12424a(dW, c6);
                                    pVar.e(dU);
                                } else {
                                    pVar.e(dU.m12429a(c4, c3, c2, c, f));
                                }
                            }
                        }
                    }
                }
            }
            SolverVariable c7;
            SolverVariable c8;
            if (this.sh == DimensionBehaviour.MATCH_CONSTRAINT) {
                i4 = (int) (((float) this.pT) * f2);
                f = f2;
                i2 = 0;
                obj = null;
                z4 = z8;
                i3 = i6;
                z9 = true;
            } else if (this.si == DimensionBehaviour.MATCH_CONSTRAINT) {
                float f3;
                if (this.rO == -1) {
                    f3 = 1.0f / f2;
                } else {
                    f3 = f2;
                }
                i3 = (int) (((float) this.pS) * f3);
                f = f3;
                i2 = 1;
                obj = null;
                z4 = true;
                i4 = i5;
                z9 = z3;
            }
            z5 = obj == null && (i2 == 0 || i2 == -1);
            z8 = this.sh != DimensionBehaviour.WRAP_CONTENT && (this instanceof r);
            if (this.rv != 2 && (i == Integer.MAX_VALUE || (this.rD.rq == i && this.rF.rq == i))) {
                if (z5 || this.rD.rj == null || this.rF.rj == null) {
                    m1651a(pVar, z8, z9, this.rD, this.rF, this.rT, this.rT + i4, i4, this.oL, this.sf, z5, z2, this.rx, this.rz, this.rA);
                } else {
                    dW = pVar.c(this.rD);
                    c7 = pVar.c(this.rF);
                    c6 = pVar.c(this.rD.ei());
                    c8 = pVar.c(this.rF.ei());
                    pVar.a(dW, c6, this.rD.eg(), 3);
                    pVar.b(c7, c8, this.rF.eg() * -1, 3);
                    if (!z2) {
                        pVar.a(dW, c6, this.rD.eg(), this.sf, c8, c7, this.rF.eg(), 4);
                    }
                }
            }
            if (this.rw != 2) {
                z8 = this.si != DimensionBehaviour.WRAP_CONTENT && (this instanceof r);
                z5 = obj == null && (i2 == 1 || i2 == -1);
                if (this.sb <= 0) {
                    constraintAnchor = this.rG;
                    if (i == Integer.MAX_VALUE || (this.rG.rq == i && this.rH.rq == i)) {
                        pVar.c(c5, c3, eA(), 5);
                    }
                    if (this.rH.rj == null) {
                        i4 = this.sb;
                        constraintAnchor = this.rH;
                    } else {
                        i4 = i3;
                    }
                    if (i == Integer.MAX_VALUE || (this.rE.rq == i && constraintAnchor.rq == i)) {
                        if (z5 || this.rE.rj == null || this.rG.rj == null) {
                            m1651a(pVar, z8, z4, this.rE, constraintAnchor, this.rU, this.rU + i4, i4, this.oM, this.sg, z5, z, this.ry, this.rB, this.rC);
                            pVar.c(c4, c3, i3, 5);
                        } else {
                            dW = pVar.c(this.rE);
                            c7 = pVar.c(this.rG);
                            c6 = pVar.c(this.rE.ei());
                            c8 = pVar.c(this.rG.ei());
                            pVar.a(dW, c6, this.rE.eg(), 3);
                            pVar.b(c7, c8, this.rG.eg() * -1, 3);
                            if (!z) {
                                pVar.a(dW, c6, this.rE.eg(), this.sg, c8, c7, this.rG.eg(), 4);
                            }
                        }
                    }
                } else if (i == Integer.MAX_VALUE || (this.rE.rq == i && this.rG.rq == i)) {
                    if (z5 || this.rE.rj == null || this.rG.rj == null) {
                        m1651a(pVar, z8, z4, this.rE, this.rG, this.rU, this.rU + i3, i3, this.oM, this.sg, z5, z, this.ry, this.rB, this.rC);
                    } else {
                        dW = pVar.c(this.rE);
                        c7 = pVar.c(this.rG);
                        c6 = pVar.c(this.rE.ei());
                        c8 = pVar.c(this.rG.ei());
                        pVar.a(dW, c6, this.rE.eg(), 3);
                        pVar.b(c7, c8, this.rG.eg() * -1, 3);
                        if (!z) {
                            pVar.a(dW, c6, this.rE.eg(), this.sg, c8, c7, this.rG.eg(), 4);
                        }
                    }
                }
                if (obj == null) {
                    dU = pVar.dU();
                    if (i == Integer.MAX_VALUE && (this.rD.rq != i || this.rF.rq != i)) {
                        return;
                    }
                    if (i2 != 0) {
                        pVar.e(dU.m12429a(c2, c, c4, c3, f));
                    } else if (i2 != 1) {
                        pVar.e(dU.m12429a(c4, c3, c2, c, f));
                    } else {
                        if (this.rz > 0) {
                            pVar.a(c2, c, this.rz, 3);
                        }
                        if (this.rB > 0) {
                            pVar.a(c4, c3, this.rB, 3);
                        }
                        dU.m12429a(c2, c, c4, c3, f);
                        dW = pVar.dW();
                        c6 = pVar.dW();
                        dW.ra = 4;
                        c6.ra = 4;
                        dU.m12424a(dW, c6);
                        pVar.e(dU);
                    }
                }
            }
        }
        f = f2;
        i2 = i7;
        obj = obj2;
        z4 = z8;
        i3 = i6;
        i4 = i5;
        z9 = z3;
        if (obj == null) {
        }
        if (this.sh != DimensionBehaviour.WRAP_CONTENT) {
        }
        if (z5) {
        }
        m1651a(pVar, z8, z9, this.rD, this.rF, this.rT, this.rT + i4, i4, this.oL, this.sf, z5, z2, this.rx, this.rz, this.rA);
        if (this.rw != 2) {
            if (this.si != DimensionBehaviour.WRAP_CONTENT) {
            }
            if (obj == null) {
            }
            if (this.sb <= 0) {
                if (z5) {
                }
                m1651a(pVar, z8, z4, this.rE, this.rG, this.rU, this.rU + i3, i3, this.oM, this.sg, z5, z, this.ry, this.rB, this.rC);
            } else {
                constraintAnchor = this.rG;
                pVar.c(c5, c3, eA(), 5);
                if (this.rH.rj == null) {
                    i4 = i3;
                } else {
                    i4 = this.sb;
                    constraintAnchor = this.rH;
                }
                if (z5) {
                }
                m1651a(pVar, z8, z4, this.rE, constraintAnchor, this.rU, this.rU + i4, i4, this.oM, this.sg, z5, z, this.ry, this.rB, this.rC);
                pVar.c(c4, c3, i3, 5);
            }
            if (obj == null) {
                dU = pVar.dU();
                if (i == Integer.MAX_VALUE) {
                }
                if (i2 != 0) {
                    pVar.e(dU.m12429a(c2, c, c4, c3, f));
                } else if (i2 != 1) {
                    if (this.rz > 0) {
                        pVar.a(c2, c, this.rz, 3);
                    }
                    if (this.rB > 0) {
                        pVar.a(c4, c3, this.rB, 3);
                    }
                    dU.m12429a(c2, c, c4, c3, f);
                    dW = pVar.dW();
                    c6 = pVar.dW();
                    dW.ra = 4;
                    c6.ra = 4;
                    dU.m12424a(dW, c6);
                    pVar.e(dU);
                } else {
                    pVar.e(dU.m12429a(c4, c3, c2, c, f));
                }
            }
        }
    }

    private void m1651a(p pVar, boolean z, boolean z2, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i, int i2, int i3, int i4, float f, boolean z3, boolean z4, int i5, int i6, int i7) {
        int i8;
        SolverVariable c = pVar.c(constraintAnchor);
        SolverVariable c2 = pVar.c(constraintAnchor2);
        SolverVariable c3 = pVar.c(constraintAnchor.ei());
        SolverVariable c4 = pVar.c(constraintAnchor2.ei());
        int eg = constraintAnchor.eg();
        int eg2 = constraintAnchor2.eg();
        if (this.sl == 8) {
            i8 = 0;
            z2 = true;
        } else {
            i8 = i3;
        }
        if (c3 == null && c4 == null) {
            pVar.e(pVar.dU().m12430b(c, i));
            if (!z3) {
                if (z) {
                    pVar.e(p.a(pVar, c2, c, i4, true));
                } else if (z2) {
                    pVar.e(p.a(pVar, c2, c, i8, false));
                } else {
                    pVar.e(pVar.dU().m12430b(c2, i2));
                }
            }
        } else if (c3 != null && c4 == null) {
            pVar.e(pVar.dU().m12425a(c, c3, eg));
            if (z) {
                pVar.e(p.a(pVar, c2, c, i4, true));
            } else if (!z3) {
                if (z2) {
                    pVar.e(pVar.dU().m12425a(c2, c, i8));
                } else {
                    pVar.e(pVar.dU().m12430b(c2, i2));
                }
            }
        } else if (c3 == null && c4 != null) {
            pVar.e(pVar.dU().m12425a(c2, c4, eg2 * -1));
            if (z) {
                pVar.e(p.a(pVar, c2, c, i4, true));
            } else if (!z3) {
                if (z2) {
                    pVar.e(pVar.dU().m12425a(c2, c, i8));
                } else {
                    pVar.e(pVar.dU().m12430b(c, i));
                }
            }
        } else if (z2) {
            if (z) {
                pVar.e(p.a(pVar, c2, c, i4, true));
            } else {
                pVar.e(pVar.dU().m12425a(c2, c, i8));
            }
            if (constraintAnchor.eh() != constraintAnchor2.eh()) {
                SolverVariable dV;
                if (constraintAnchor.eh() == Strength.STRONG) {
                    pVar.e(pVar.dU().m12425a(c, c3, eg));
                    dV = pVar.dV();
                    C3857m dU = pVar.dU();
                    dU.m12431b(c2, c4, dV, eg2 * -1);
                    pVar.e(dU);
                    return;
                }
                dV = pVar.dV();
                C3857m dU2 = pVar.dU();
                dU2.m12428a(c, c3, dV, eg);
                pVar.e(dU2);
                pVar.e(pVar.dU().m12425a(c2, c4, eg2 * -1));
            } else if (c3 == c4) {
                pVar.e(p.a(pVar, c, c3, 0, 0.5f, c4, c2, 0, true));
            } else if (!z4) {
                pVar.e(p.b(pVar, c, c3, eg, constraintAnchor.ej() != ConnectionType.STRICT));
                pVar.e(p.c(pVar, c2, c4, eg2 * -1, constraintAnchor2.ej() != ConnectionType.STRICT));
                pVar.e(p.a(pVar, c, c3, eg, f, c4, c2, eg2, false));
            }
        } else if (z3) {
            pVar.a(c, c3, eg, 3);
            pVar.b(c2, c4, eg2 * -1, 3);
            pVar.e(p.a(pVar, c, c3, eg, f, c4, c2, eg2, true));
        } else if (!z4) {
            if (i5 == 1) {
                if (i6 > i8) {
                    i8 = i6;
                }
                if (i7 > 0) {
                    if (i7 >= i8) {
                        pVar.b(c2, c, i7, 3);
                    }
                    pVar.c(c2, c, i7, 3);
                    pVar.a(c, c3, eg, 2);
                    pVar.b(c2, c4, -eg2, 2);
                    pVar.a(c, c3, eg, f, c4, c2, eg2, 4);
                }
                i7 = i8;
                pVar.c(c2, c, i7, 3);
                pVar.a(c, c3, eg, 2);
                pVar.b(c2, c4, -eg2, 2);
                pVar.a(c, c3, eg, f, c4, c2, eg2, 4);
            } else if (i6 == 0 && i7 == 0) {
                pVar.e(pVar.dU().m12425a(c, c3, eg));
                pVar.e(pVar.dU().m12425a(c2, c4, eg2 * -1));
            } else {
                if (i7 > 0) {
                    pVar.b(c2, c, i7, 3);
                }
                pVar.a(c, c3, eg, 2);
                pVar.b(c2, c4, -eg2, 2);
                pVar.a(c, c3, eg, f, c4, c2, eg2, 4);
            }
        }
    }

    public void m1662b(p pVar, int i) {
        if (i == Integer.MAX_VALUE) {
            m1654a(pVar.d(this.rD), pVar.d(this.rE), pVar.d(this.rF), pVar.d(this.rG));
        } else if (i == -2) {
            m1654a(this.rP, this.rQ, this.rR, this.rS);
        } else {
            if (this.rD.rq == i) {
                this.rP = pVar.d(this.rD);
            }
            if (this.rE.rq == i) {
                this.rQ = pVar.d(this.rE);
            }
            if (this.rF.rq == i) {
                this.rR = pVar.d(this.rF);
            }
            if (this.rG.rq == i) {
                this.rS = pVar.d(this.rG);
            }
        }
    }
}
