package com.fossil;

import android.support.constraint.solver.SolverVariable;
import android.support.constraint.solver.widgets.ConstraintAnchor;
import android.support.constraint.solver.widgets.ConstraintAnchor.Type;
import android.support.constraint.solver.widgets.ConstraintWidget;
import android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour;
import java.util.ArrayList;
import java.util.Arrays;

public class C4023r extends C4022w {
    static boolean sK = true;
    private int oP = 2;
    protected C3953p sH = new C3953p();
    protected C3953p sI = null;
    private C4145v sJ;
    int sL;
    int sM;
    int sN;
    int sO;
    private int sP = 0;
    private int sQ = 0;
    private ConstraintWidget[] sR = new ConstraintWidget[4];
    private ConstraintWidget[] sS = new ConstraintWidget[4];
    private ConstraintWidget[] sT = new ConstraintWidget[4];
    private boolean[] sU = new boolean[3];
    private ConstraintWidget[] sV = new ConstraintWidget[4];
    private boolean sW = false;
    private boolean sX = false;
    int sc;
    int sd;

    public void setOptimizationLevel(int i) {
        this.oP = i;
    }

    public void reset() {
        this.sH.reset();
        this.sL = 0;
        this.sN = 0;
        this.sM = 0;
        this.sO = 0;
        super.reset();
    }

    public boolean eH() {
        return this.sW;
    }

    public boolean eI() {
        return this.sX;
    }

    public boolean m13245c(C3953p c3953p, int i) {
        boolean z;
        a(c3953p, i);
        int size = this.tj.size();
        if (this.oP != 2 && this.oP != 4) {
            z = true;
        } else if (m13237c(c3953p)) {
            return false;
        } else {
            z = false;
        }
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.tj.get(i2);
            if (constraintWidget instanceof C4023r) {
                DimensionBehaviour dimensionBehaviour = constraintWidget.sh;
                DimensionBehaviour dimensionBehaviour2 = constraintWidget.si;
                if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.a(DimensionBehaviour.FIXED);
                }
                if (dimensionBehaviour2 == DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.b(DimensionBehaviour.FIXED);
                }
                constraintWidget.a(c3953p, i);
                if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.a(dimensionBehaviour);
                }
                if (dimensionBehaviour2 == DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.b(dimensionBehaviour2);
                }
            } else {
                if (z) {
                    C4088t.m13594a(this, c3953p, constraintWidget);
                }
                constraintWidget.a(c3953p, i);
            }
        }
        if (this.sP > 0) {
            m13238d(c3953p);
        }
        if (this.sQ > 0) {
            m13239e(c3953p);
        }
        return true;
    }

    private boolean m13237c(C3953p c3953p) {
        int i;
        int i2;
        int size = this.tj.size();
        for (i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.tj.get(i);
            constraintWidget.rv = -1;
            constraintWidget.rw = -1;
            if (constraintWidget.sh == DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.si == DimensionBehaviour.MATCH_CONSTRAINT) {
                constraintWidget.rv = 1;
                constraintWidget.rw = 1;
            }
        }
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        while (!z) {
            boolean z2;
            int i6 = i3 + 1;
            int i7 = 0;
            i2 = 0;
            i = 0;
            while (i7 < size) {
                constraintWidget = (ConstraintWidget) this.tj.get(i7);
                if (constraintWidget.rv == -1) {
                    if (this.sh == DimensionBehaviour.WRAP_CONTENT) {
                        constraintWidget.rv = 1;
                    } else {
                        C4088t.m13596b(this, c3953p, constraintWidget);
                    }
                }
                if (constraintWidget.rw == -1) {
                    if (this.si == DimensionBehaviour.WRAP_CONTENT) {
                        constraintWidget.rw = 1;
                    } else {
                        C4088t.m13597c(this, c3953p, constraintWidget);
                    }
                }
                if (constraintWidget.rw == -1) {
                    i++;
                }
                if (constraintWidget.rv == -1) {
                    i3 = i2 + 1;
                } else {
                    i3 = i2;
                }
                i7++;
                i2 = i3;
            }
            if (i == 0 && i2 == 0) {
                z2 = true;
            } else if (i5 == i && r8 == i2) {
                z2 = true;
            } else {
                z2 = z;
            }
            i4 = i2;
            i5 = i;
            z = z2;
            i3 = i6;
        }
        int i8 = 0;
        i2 = 0;
        i = 0;
        while (i8 < size) {
            constraintWidget = (ConstraintWidget) this.tj.get(i8);
            if (constraintWidget.rv == 1 || constraintWidget.rv == -1) {
                i++;
            }
            if (constraintWidget.rw == 1 || constraintWidget.rw == -1) {
                i3 = i2 + 1;
            } else {
                i3 = i2;
            }
            i8++;
            i2 = i3;
        }
        if (i == 0 && i2 == 0) {
            return true;
        }
        return false;
    }

    private void m13238d(C3953p c3953p) {
        for (int i = 0; i < this.sP; i++) {
            ConstraintWidget constraintWidget = this.sT[i];
            int a = m13234a(c3953p, this.sV, this.sT[i], 0, this.sU);
            ConstraintWidget constraintWidget2 = this.sV[2];
            if (constraintWidget2 != null) {
                int et;
                if (this.sU[1]) {
                    et = constraintWidget.et();
                    while (constraintWidget2 != null) {
                        c3953p.m13006d(constraintWidget2.rD.rp, et);
                        et += (constraintWidget2.rD.eg() + constraintWidget2.getWidth()) + constraintWidget2.rF.eg();
                        constraintWidget2 = constraintWidget2.sE;
                    }
                } else {
                    Object obj = constraintWidget.sy == 0 ? 1 : null;
                    Object obj2 = constraintWidget.sy == 2 ? 1 : null;
                    Object obj3 = this.sh == DimensionBehaviour.WRAP_CONTENT ? 1 : null;
                    if ((this.oP == 2 || this.oP == 8) && this.sU[0] && constraintWidget.sA && obj2 == null && obj3 == null && constraintWidget.sy == 0) {
                        C4088t.m13593a(this, c3953p, a, constraintWidget);
                    } else if (a == 0 || obj2 != null) {
                        ConstraintAnchor constraintAnchor;
                        int eg;
                        int eg2;
                        SolverVariable solverVariable;
                        ConstraintWidget constraintWidget3 = null;
                        obj3 = null;
                        ConstraintWidget constraintWidget4 = null;
                        ConstraintWidget constraintWidget5 = constraintWidget2;
                        while (constraintWidget5 != null) {
                            Object obj4;
                            ConstraintWidget constraintWidget6;
                            ConstraintWidget constraintWidget7;
                            r5 = constraintWidget5.sE;
                            if (r5 == null) {
                                obj4 = 1;
                                constraintWidget6 = this.sV[1];
                            } else {
                                obj4 = obj3;
                                constraintWidget6 = constraintWidget3;
                            }
                            if (obj2 != null) {
                                int eg3;
                                ConstraintAnchor constraintAnchor2 = constraintWidget5.rD;
                                et = constraintAnchor2.eg();
                                if (constraintWidget4 != null) {
                                    eg3 = et + constraintWidget4.rF.eg();
                                } else {
                                    eg3 = et;
                                }
                                et = 1;
                                if (constraintWidget2 != constraintWidget5) {
                                    et = 3;
                                }
                                c3953p.m13000a(constraintAnchor2.rp, constraintAnchor2.rj.rp, eg3, et);
                                if (constraintWidget5.sh == DimensionBehaviour.MATCH_CONSTRAINT) {
                                    r4 = constraintWidget5.rF;
                                    if (constraintWidget5.rx == 1) {
                                        c3953p.m13004c(r4.rp, constraintAnchor2.rp, Math.max(constraintWidget5.rz, constraintWidget5.getWidth()), 3);
                                    } else {
                                        c3953p.m13000a(constraintAnchor2.rp, constraintAnchor2.rj.rp, constraintAnchor2.rk, 3);
                                        c3953p.m13002b(r4.rp, constraintAnchor2.rp, constraintWidget5.rz, 3);
                                    }
                                }
                                constraintWidget7 = r5;
                            } else if (obj != null || obj4 == null || constraintWidget4 == null) {
                                if (obj != null || obj4 != null || constraintWidget4 != null) {
                                    ConstraintWidget constraintWidget8;
                                    ConstraintAnchor constraintAnchor3 = constraintWidget5.rD;
                                    constraintAnchor = constraintWidget5.rF;
                                    eg = constraintAnchor3.eg();
                                    eg2 = constraintAnchor.eg();
                                    c3953p.m13000a(constraintAnchor3.rp, constraintAnchor3.rj.rp, eg, 1);
                                    c3953p.m13002b(constraintAnchor.rp, constraintAnchor.rj.rp, -eg2, 1);
                                    r6 = constraintAnchor3.rj != null ? constraintAnchor3.rj.rp : null;
                                    if (constraintWidget4 == null) {
                                        r6 = constraintWidget.rD.rj != null ? constraintWidget.rD.rj.rp : null;
                                    }
                                    if (r5 == null) {
                                        constraintWidget8 = constraintWidget6.rF.rj != null ? constraintWidget6.rF.rj.rh : null;
                                    } else {
                                        constraintWidget8 = r5;
                                    }
                                    if (constraintWidget8 != null) {
                                        solverVariable = constraintWidget8.rD.rp;
                                        if (obj4 != null) {
                                            solverVariable = constraintWidget6.rF.rj != null ? constraintWidget6.rF.rj.rp : null;
                                        }
                                        if (!(r6 == null || solverVariable == null)) {
                                            c3953p.m12999a(constraintAnchor3.rp, r6, eg, 0.5f, solverVariable, constraintAnchor.rp, eg2, 4);
                                        }
                                    }
                                    constraintWidget7 = constraintWidget8;
                                } else if (constraintWidget5.rD.rj == null) {
                                    c3953p.m13006d(constraintWidget5.rD.rp, constraintWidget5.et());
                                    constraintWidget7 = r5;
                                } else {
                                    c3953p.m13004c(constraintWidget5.rD.rp, constraintWidget.rD.rj.rp, constraintWidget5.rD.eg(), 5);
                                    constraintWidget7 = r5;
                                }
                            } else if (constraintWidget5.rF.rj == null) {
                                c3953p.m13006d(constraintWidget5.rF.rp, constraintWidget5.ew());
                                constraintWidget7 = r5;
                            } else {
                                c3953p.m13004c(constraintWidget5.rF.rp, constraintWidget6.rF.rj.rp, -constraintWidget5.rF.eg(), 5);
                                constraintWidget7 = r5;
                            }
                            if (obj4 != null) {
                                constraintWidget7 = null;
                            }
                            constraintWidget3 = constraintWidget6;
                            constraintWidget4 = constraintWidget5;
                            constraintWidget5 = constraintWidget7;
                            obj3 = obj4;
                        }
                        if (obj2 != null) {
                            r4 = constraintWidget2.rD;
                            constraintAnchor = constraintWidget3.rF;
                            eg = r4.eg();
                            eg2 = constraintAnchor.eg();
                            r6 = constraintWidget.rD.rj != null ? constraintWidget.rD.rj.rp : null;
                            solverVariable = constraintWidget3.rF.rj != null ? constraintWidget3.rF.rj.rp : null;
                            if (!(r6 == null || solverVariable == null)) {
                                c3953p.m13002b(constraintAnchor.rp, solverVariable, -eg2, 1);
                                c3953p.m12999a(r4.rp, r6, eg, constraintWidget.sf, solverVariable, constraintAnchor.rp, eg2, 4);
                            }
                        }
                    } else {
                        int i2;
                        float f = 0.0f;
                        r5 = null;
                        ConstraintWidget constraintWidget9 = constraintWidget2;
                        while (constraintWidget9 != null) {
                            if (constraintWidget9.sh != DimensionBehaviour.MATCH_CONSTRAINT) {
                                et = constraintWidget9.rD.eg();
                                if (r5 != null) {
                                    et += r5.rF.eg();
                                }
                                i2 = 3;
                                if (constraintWidget9.rD.rj.rh.sh == DimensionBehaviour.MATCH_CONSTRAINT) {
                                    i2 = 2;
                                }
                                c3953p.m13000a(constraintWidget9.rD.rp, constraintWidget9.rD.rj.rp, et, i2);
                                et = constraintWidget9.rF.eg();
                                if (constraintWidget9.rF.rj.rh.rD.rj != null && constraintWidget9.rF.rj.rh.rD.rj.rh == constraintWidget9) {
                                    et += constraintWidget9.rF.rj.rh.rD.eg();
                                }
                                i2 = 3;
                                if (constraintWidget9.rF.rj.rh.sh == DimensionBehaviour.MATCH_CONSTRAINT) {
                                    i2 = 2;
                                }
                                c3953p.m13002b(constraintWidget9.rF.rp, constraintWidget9.rF.rj.rp, -et, i2);
                            } else {
                                f += constraintWidget9.sC;
                                et = 0;
                                if (constraintWidget9.rF.rj != null) {
                                    et = constraintWidget9.rF.eg();
                                    if (constraintWidget9 != this.sV[3]) {
                                        et += constraintWidget9.rF.rj.rh.rD.eg();
                                    }
                                }
                                c3953p.m13000a(constraintWidget9.rF.rp, constraintWidget9.rD.rp, 0, 1);
                                c3953p.m13002b(constraintWidget9.rF.rp, constraintWidget9.rF.rj.rp, -et, 1);
                            }
                            r5 = constraintWidget9;
                            constraintWidget9 = constraintWidget9.sE;
                        }
                        if (a == 1) {
                            constraintWidget9 = this.sR[0];
                            et = constraintWidget9.rD.eg();
                            if (constraintWidget9.rD.rj != null) {
                                et += constraintWidget9.rD.rj.eg();
                            }
                            i2 = constraintWidget9.rF.eg();
                            if (constraintWidget9.rF.rj != null) {
                                i2 += constraintWidget9.rF.rj.eg();
                            }
                            r6 = constraintWidget.rF.rj.rp;
                            if (constraintWidget9 == this.sV[3]) {
                                r6 = this.sV[1].rF.rj.rp;
                            }
                            if (constraintWidget9.rx == 1) {
                                c3953p.m13000a(constraintWidget.rD.rp, constraintWidget.rD.rj.rp, et, 1);
                                c3953p.m13002b(constraintWidget.rF.rp, r6, -i2, 1);
                                c3953p.m13004c(constraintWidget.rF.rp, constraintWidget.rD.rp, constraintWidget.getWidth(), 2);
                            } else {
                                c3953p.m13004c(constraintWidget9.rD.rp, constraintWidget9.rD.rj.rp, et, 1);
                                c3953p.m13004c(constraintWidget9.rF.rp, r6, -i2, 1);
                            }
                        } else {
                            for (int i3 = 0; i3 < a - 1; i3++) {
                                ConstraintWidget constraintWidget10 = this.sR[i3];
                                constraintWidget2 = this.sR[i3 + 1];
                                SolverVariable solverVariable2 = constraintWidget10.rD.rp;
                                SolverVariable solverVariable3 = constraintWidget10.rF.rp;
                                SolverVariable solverVariable4 = constraintWidget2.rD.rp;
                                SolverVariable solverVariable5 = constraintWidget2.rF.rp;
                                if (constraintWidget2 == this.sV[3]) {
                                    solverVariable5 = this.sV[1].rF.rp;
                                }
                                et = constraintWidget10.rD.eg();
                                if (!(constraintWidget10.rD.rj == null || constraintWidget10.rD.rj.rh.rF.rj == null || constraintWidget10.rD.rj.rh.rF.rj.rh != constraintWidget10)) {
                                    et += constraintWidget10.rD.rj.rh.rF.eg();
                                }
                                c3953p.m13000a(solverVariable2, constraintWidget10.rD.rj.rp, et, 2);
                                i2 = constraintWidget10.rF.eg();
                                if (constraintWidget10.rF.rj == null || constraintWidget10.sE == null) {
                                    et = i2;
                                } else {
                                    et = (constraintWidget10.sE.rD.rj != null ? constraintWidget10.sE.rD.eg() : 0) + i2;
                                }
                                c3953p.m13002b(solverVariable3, constraintWidget10.rF.rj.rp, -et, 2);
                                if (i3 + 1 == a - 1) {
                                    et = constraintWidget2.rD.eg();
                                    if (!(constraintWidget2.rD.rj == null || constraintWidget2.rD.rj.rh.rF.rj == null || constraintWidget2.rD.rj.rh.rF.rj.rh != constraintWidget2)) {
                                        et += constraintWidget2.rD.rj.rh.rF.eg();
                                    }
                                    c3953p.m13000a(solverVariable4, constraintWidget2.rD.rj.rp, et, 2);
                                    r4 = constraintWidget2.rF;
                                    if (constraintWidget2 == this.sV[3]) {
                                        r4 = this.sV[1].rF;
                                    }
                                    i2 = r4.eg();
                                    if (!(r4.rj == null || r4.rj.rh.rD.rj == null || r4.rj.rh.rD.rj.rh != constraintWidget2)) {
                                        i2 += r4.rj.rh.rD.eg();
                                    }
                                    c3953p.m13002b(solverVariable5, r4.rj.rp, -i2, 2);
                                }
                                if (constraintWidget.rA > 0) {
                                    c3953p.m13002b(solverVariable3, solverVariable2, constraintWidget.rA, 2);
                                }
                                m dU = c3953p.dU();
                                dU.a(constraintWidget10.sC, f, constraintWidget2.sC, solverVariable2, constraintWidget10.rD.eg(), solverVariable3, constraintWidget10.rF.eg(), solverVariable4, constraintWidget2.rD.eg(), solverVariable5, constraintWidget2.rF.eg());
                                c3953p.m13007e(dU);
                            }
                        }
                    }
                }
            }
        }
    }

    private void m13239e(C3953p c3953p) {
        for (int i = 0; i < this.sQ; i++) {
            ConstraintWidget constraintWidget = this.sS[i];
            int a = m13234a(c3953p, this.sV, this.sS[i], 1, this.sU);
            ConstraintWidget constraintWidget2 = this.sV[2];
            if (constraintWidget2 != null) {
                int eu;
                if (this.sU[1]) {
                    eu = constraintWidget.eu();
                    while (constraintWidget2 != null) {
                        c3953p.m13006d(constraintWidget2.rE.rp, eu);
                        eu += (constraintWidget2.rE.eg() + constraintWidget2.getHeight()) + constraintWidget2.rG.eg();
                        constraintWidget2 = constraintWidget2.sF;
                    }
                } else {
                    Object obj = constraintWidget.sz == 0 ? 1 : null;
                    Object obj2 = constraintWidget.sz == 2 ? 1 : null;
                    Object obj3 = this.si == DimensionBehaviour.WRAP_CONTENT ? 1 : null;
                    if ((this.oP == 2 || this.oP == 8) && this.sU[0] && constraintWidget.sB && obj2 == null && obj3 == null && constraintWidget.sz == 0) {
                        C4088t.m13595b(this, c3953p, a, constraintWidget);
                    } else if (a == 0 || obj2 != null) {
                        ConstraintAnchor constraintAnchor;
                        int eg;
                        int eg2;
                        SolverVariable solverVariable;
                        ConstraintWidget constraintWidget3 = null;
                        obj3 = null;
                        ConstraintWidget constraintWidget4 = null;
                        ConstraintWidget constraintWidget5 = constraintWidget2;
                        while (constraintWidget5 != null) {
                            Object obj4;
                            ConstraintWidget constraintWidget6;
                            ConstraintWidget constraintWidget7;
                            r5 = constraintWidget5.sF;
                            if (r5 == null) {
                                obj4 = 1;
                                constraintWidget6 = this.sV[1];
                            } else {
                                obj4 = obj3;
                                constraintWidget6 = constraintWidget3;
                            }
                            if (obj2 != null) {
                                constraintAnchor = constraintWidget5.rE;
                                int eg3 = constraintAnchor.eg();
                                if (constraintWidget4 != null) {
                                    eg3 += constraintWidget4.rG.eg();
                                }
                                eu = 1;
                                if (constraintWidget2 != constraintWidget5) {
                                    eu = 3;
                                }
                                SolverVariable solverVariable2 = null;
                                r6 = null;
                                if (constraintAnchor.rj != null) {
                                    solverVariable2 = constraintAnchor.rp;
                                    r6 = constraintAnchor.rj.rp;
                                } else if (constraintWidget5.rH.rj != null) {
                                    solverVariable2 = constraintWidget5.rH.rp;
                                    r6 = constraintWidget5.rH.rj.rp;
                                    eg3 -= constraintAnchor.eg();
                                }
                                if (!(solverVariable2 == null || r6 == null)) {
                                    c3953p.m13000a(solverVariable2, r6, eg3, eu);
                                }
                                if (constraintWidget5.si == DimensionBehaviour.MATCH_CONSTRAINT) {
                                    r4 = constraintWidget5.rG;
                                    if (constraintWidget5.ry == 1) {
                                        c3953p.m13004c(r4.rp, constraintAnchor.rp, Math.max(constraintWidget5.rB, constraintWidget5.getHeight()), 3);
                                    } else {
                                        c3953p.m13000a(constraintAnchor.rp, constraintAnchor.rj.rp, constraintAnchor.rk, 3);
                                        c3953p.m13002b(r4.rp, constraintAnchor.rp, constraintWidget5.rB, 3);
                                    }
                                }
                                constraintWidget7 = r5;
                            } else if (obj != null || obj4 == null || constraintWidget4 == null) {
                                if (obj != null || obj4 != null || constraintWidget4 != null) {
                                    ConstraintWidget constraintWidget8;
                                    ConstraintAnchor constraintAnchor2 = constraintWidget5.rE;
                                    constraintAnchor = constraintWidget5.rG;
                                    eg = constraintAnchor2.eg();
                                    eg2 = constraintAnchor.eg();
                                    c3953p.m13000a(constraintAnchor2.rp, constraintAnchor2.rj.rp, eg, 1);
                                    c3953p.m13002b(constraintAnchor.rp, constraintAnchor.rj.rp, -eg2, 1);
                                    r6 = constraintAnchor2.rj != null ? constraintAnchor2.rj.rp : null;
                                    if (constraintWidget4 == null) {
                                        r6 = constraintWidget.rE.rj != null ? constraintWidget.rE.rj.rp : null;
                                    }
                                    if (r5 == null) {
                                        constraintWidget8 = constraintWidget6.rG.rj != null ? constraintWidget6.rG.rj.rh : null;
                                    } else {
                                        constraintWidget8 = r5;
                                    }
                                    if (constraintWidget8 != null) {
                                        solverVariable = constraintWidget8.rE.rp;
                                        if (obj4 != null) {
                                            solverVariable = constraintWidget6.rG.rj != null ? constraintWidget6.rG.rj.rp : null;
                                        }
                                        if (!(r6 == null || solverVariable == null)) {
                                            c3953p.m12999a(constraintAnchor2.rp, r6, eg, 0.5f, solverVariable, constraintAnchor.rp, eg2, 4);
                                        }
                                    }
                                    constraintWidget7 = constraintWidget8;
                                } else if (constraintWidget5.rE.rj == null) {
                                    c3953p.m13006d(constraintWidget5.rE.rp, constraintWidget5.eu());
                                    constraintWidget7 = r5;
                                } else {
                                    c3953p.m13004c(constraintWidget5.rE.rp, constraintWidget.rE.rj.rp, constraintWidget5.rE.eg(), 5);
                                    constraintWidget7 = r5;
                                }
                            } else if (constraintWidget5.rG.rj == null) {
                                c3953p.m13006d(constraintWidget5.rG.rp, constraintWidget5.ev());
                                constraintWidget7 = r5;
                            } else {
                                c3953p.m13004c(constraintWidget5.rG.rp, constraintWidget6.rG.rj.rp, -constraintWidget5.rG.eg(), 5);
                                constraintWidget7 = r5;
                            }
                            if (obj4 != null) {
                                constraintWidget7 = null;
                            }
                            constraintWidget3 = constraintWidget6;
                            constraintWidget4 = constraintWidget5;
                            constraintWidget5 = constraintWidget7;
                            obj3 = obj4;
                        }
                        if (obj2 != null) {
                            r4 = constraintWidget2.rE;
                            constraintAnchor = constraintWidget3.rG;
                            eg = r4.eg();
                            eg2 = constraintAnchor.eg();
                            r6 = constraintWidget.rE.rj != null ? constraintWidget.rE.rj.rp : null;
                            solverVariable = constraintWidget3.rG.rj != null ? constraintWidget3.rG.rj.rp : null;
                            if (!(r6 == null || solverVariable == null)) {
                                c3953p.m13002b(constraintAnchor.rp, solverVariable, -eg2, 1);
                                c3953p.m12999a(r4.rp, r6, eg, constraintWidget.sg, solverVariable, constraintAnchor.rp, eg2, 4);
                            }
                        }
                    } else {
                        int i2;
                        float f = 0.0f;
                        r5 = null;
                        ConstraintWidget constraintWidget9 = constraintWidget2;
                        while (constraintWidget9 != null) {
                            if (constraintWidget9.si != DimensionBehaviour.MATCH_CONSTRAINT) {
                                eu = constraintWidget9.rE.eg();
                                if (r5 != null) {
                                    eu += r5.rG.eg();
                                }
                                i2 = 3;
                                if (constraintWidget9.rE.rj.rh.si == DimensionBehaviour.MATCH_CONSTRAINT) {
                                    i2 = 2;
                                }
                                c3953p.m13000a(constraintWidget9.rE.rp, constraintWidget9.rE.rj.rp, eu, i2);
                                eu = constraintWidget9.rG.eg();
                                if (constraintWidget9.rG.rj.rh.rE.rj != null && constraintWidget9.rG.rj.rh.rE.rj.rh == constraintWidget9) {
                                    eu += constraintWidget9.rG.rj.rh.rE.eg();
                                }
                                i2 = 3;
                                if (constraintWidget9.rG.rj.rh.si == DimensionBehaviour.MATCH_CONSTRAINT) {
                                    i2 = 2;
                                }
                                c3953p.m13002b(constraintWidget9.rG.rp, constraintWidget9.rG.rj.rp, -eu, i2);
                            } else {
                                f += constraintWidget9.sD;
                                eu = 0;
                                if (constraintWidget9.rG.rj != null) {
                                    eu = constraintWidget9.rG.eg();
                                    if (constraintWidget9 != this.sV[3]) {
                                        eu += constraintWidget9.rG.rj.rh.rE.eg();
                                    }
                                }
                                c3953p.m13000a(constraintWidget9.rG.rp, constraintWidget9.rE.rp, 0, 1);
                                c3953p.m13002b(constraintWidget9.rG.rp, constraintWidget9.rG.rj.rp, -eu, 1);
                            }
                            r5 = constraintWidget9;
                            constraintWidget9 = constraintWidget9.sF;
                        }
                        if (a == 1) {
                            constraintWidget9 = this.sR[0];
                            eu = constraintWidget9.rE.eg();
                            if (constraintWidget9.rE.rj != null) {
                                eu += constraintWidget9.rE.rj.eg();
                            }
                            i2 = constraintWidget9.rG.eg();
                            if (constraintWidget9.rG.rj != null) {
                                i2 += constraintWidget9.rG.rj.eg();
                            }
                            r6 = constraintWidget.rG.rj.rp;
                            if (constraintWidget9 == this.sV[3]) {
                                r6 = this.sV[1].rG.rj.rp;
                            }
                            if (constraintWidget9.ry == 1) {
                                c3953p.m13000a(constraintWidget.rE.rp, constraintWidget.rE.rj.rp, eu, 1);
                                c3953p.m13002b(constraintWidget.rG.rp, r6, -i2, 1);
                                c3953p.m13004c(constraintWidget.rG.rp, constraintWidget.rE.rp, constraintWidget.getHeight(), 2);
                            } else {
                                c3953p.m13004c(constraintWidget9.rE.rp, constraintWidget9.rE.rj.rp, eu, 1);
                                c3953p.m13004c(constraintWidget9.rG.rp, r6, -i2, 1);
                            }
                        } else {
                            for (int i3 = 0; i3 < a - 1; i3++) {
                                ConstraintWidget constraintWidget10 = this.sR[i3];
                                constraintWidget2 = this.sR[i3 + 1];
                                SolverVariable solverVariable3 = constraintWidget10.rE.rp;
                                SolverVariable solverVariable4 = constraintWidget10.rG.rp;
                                SolverVariable solverVariable5 = constraintWidget2.rE.rp;
                                SolverVariable solverVariable6 = constraintWidget2.rG.rp;
                                if (constraintWidget2 == this.sV[3]) {
                                    solverVariable6 = this.sV[1].rG.rp;
                                }
                                eu = constraintWidget10.rE.eg();
                                if (!(constraintWidget10.rE.rj == null || constraintWidget10.rE.rj.rh.rG.rj == null || constraintWidget10.rE.rj.rh.rG.rj.rh != constraintWidget10)) {
                                    eu += constraintWidget10.rE.rj.rh.rG.eg();
                                }
                                c3953p.m13000a(solverVariable3, constraintWidget10.rE.rj.rp, eu, 2);
                                i2 = constraintWidget10.rG.eg();
                                if (constraintWidget10.rG.rj == null || constraintWidget10.sF == null) {
                                    eu = i2;
                                } else {
                                    eu = (constraintWidget10.sF.rE.rj != null ? constraintWidget10.sF.rE.eg() : 0) + i2;
                                }
                                c3953p.m13002b(solverVariable4, constraintWidget10.rG.rj.rp, -eu, 2);
                                if (i3 + 1 == a - 1) {
                                    eu = constraintWidget2.rE.eg();
                                    if (!(constraintWidget2.rE.rj == null || constraintWidget2.rE.rj.rh.rG.rj == null || constraintWidget2.rE.rj.rh.rG.rj.rh != constraintWidget2)) {
                                        eu += constraintWidget2.rE.rj.rh.rG.eg();
                                    }
                                    c3953p.m13000a(solverVariable5, constraintWidget2.rE.rj.rp, eu, 2);
                                    r4 = constraintWidget2.rG;
                                    if (constraintWidget2 == this.sV[3]) {
                                        r4 = this.sV[1].rG;
                                    }
                                    i2 = r4.eg();
                                    if (!(r4.rj == null || r4.rj.rh.rE.rj == null || r4.rj.rh.rE.rj.rh != constraintWidget2)) {
                                        i2 += r4.rj.rh.rE.eg();
                                    }
                                    c3953p.m13002b(solverVariable6, r4.rj.rp, -i2, 2);
                                }
                                if (constraintWidget.rC > 0) {
                                    c3953p.m13002b(solverVariable4, solverVariable3, constraintWidget.rC, 2);
                                }
                                m dU = c3953p.dU();
                                dU.a(constraintWidget10.sD, f, constraintWidget2.sD, solverVariable3, constraintWidget10.rE.eg(), solverVariable4, constraintWidget10.rG.eg(), solverVariable5, constraintWidget2.rE.eg(), solverVariable6, constraintWidget2.rG.eg());
                                c3953p.m13007e(dU);
                            }
                        }
                    }
                }
            }
        }
    }

    public void m13242a(C3953p c3953p, int i, boolean[] zArr) {
        zArr[2] = false;
        b(c3953p, i);
        int size = this.tj.size();
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.tj.get(i2);
            constraintWidget.b(c3953p, i);
            if (constraintWidget.sh == DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.getWidth() < constraintWidget.er()) {
                zArr[2] = true;
            }
            if (constraintWidget.si == DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.getHeight() < constraintWidget.es()) {
                zArr[2] = true;
            }
        }
    }

    public void eJ() {
        boolean z;
        int size;
        int i;
        ConstraintWidget constraintWidget;
        int i2;
        boolean z2;
        int i3;
        int max;
        int i4 = this.rT;
        int i5 = this.rU;
        int max2 = Math.max(0, getWidth());
        int max3 = Math.max(0, getHeight());
        this.sW = false;
        this.sX = false;
        if (this.rM != null) {
            if (this.sJ == null) {
                this.sJ = new C4145v(this);
            }
            this.sJ.m13871d(this);
            setX(this.sL);
            setY(this.sM);
            eE();
            m13230b(this.sH.dZ());
        } else {
            this.rT = 0;
            this.rU = 0;
        }
        boolean z3 = false;
        DimensionBehaviour dimensionBehaviour = this.si;
        DimensionBehaviour dimensionBehaviour2 = this.sh;
        if (this.oP == 2 && (this.si == DimensionBehaviour.WRAP_CONTENT || this.sh == DimensionBehaviour.WRAP_CONTENT)) {
            m13243a(this.tj, this.sU);
            z3 = this.sU[0];
            if (max2 > 0 && max3 > 0 && (this.sc > max2 || this.sd > max3)) {
                z3 = false;
            }
            if (z3) {
                if (this.sh == DimensionBehaviour.WRAP_CONTENT) {
                    this.sh = DimensionBehaviour.FIXED;
                    if (max2 <= 0 || max2 >= this.sc) {
                        setWidth(Math.max(this.oL, this.sc));
                    } else {
                        this.sW = true;
                        setWidth(max2);
                    }
                }
                if (this.si == DimensionBehaviour.WRAP_CONTENT) {
                    this.si = DimensionBehaviour.FIXED;
                    if (max3 <= 0 || max3 >= this.sd) {
                        setHeight(Math.max(this.oM, this.sd));
                    } else {
                        this.sX = true;
                        setHeight(max3);
                        z = z3;
                        eL();
                        size = this.tj.size();
                        for (i = 0; i < size; i++) {
                            constraintWidget = (ConstraintWidget) this.tj.get(i);
                            if (constraintWidget instanceof C4022w) {
                                ((C4022w) constraintWidget).eJ();
                            }
                        }
                        i2 = 0;
                        z2 = z;
                        z = true;
                        while (z) {
                            i3 = i2 + 1;
                            try {
                                this.sH.reset();
                                z = m13245c(this.sH, Integer.MAX_VALUE);
                                if (z) {
                                    this.sH.dX();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            if (z) {
                                b(this.sH, Integer.MAX_VALUE);
                                while (max < size) {
                                    constraintWidget = (ConstraintWidget) this.tj.get(max);
                                    if (constraintWidget.sh == DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.getWidth() >= constraintWidget.er()) {
                                        if (constraintWidget.si != DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.getHeight() < constraintWidget.es()) {
                                            this.sU[2] = true;
                                            break;
                                        }
                                    } else {
                                        this.sU[2] = true;
                                        break;
                                    }
                                }
                            }
                            m13242a(this.sH, Integer.MAX_VALUE, this.sU);
                            if (i3 < 8 || !this.sU[2]) {
                                z3 = false;
                                z = z2;
                            } else {
                                int i6;
                                int i7 = 0;
                                int i8 = 0;
                                for (i6 = 0; i6 < size; i6++) {
                                    constraintWidget = (ConstraintWidget) this.tj.get(i6);
                                    i7 = Math.max(i7, constraintWidget.rT + constraintWidget.getWidth());
                                    i8 = Math.max(i8, constraintWidget.getHeight() + constraintWidget.rU);
                                }
                                i2 = Math.max(this.oL, i7);
                                i6 = Math.max(this.oM, i8);
                                if (dimensionBehaviour2 != DimensionBehaviour.WRAP_CONTENT || getWidth() >= i2) {
                                    z3 = false;
                                    z = z2;
                                } else {
                                    setWidth(i2);
                                    this.sh = DimensionBehaviour.WRAP_CONTENT;
                                    z = true;
                                    z3 = true;
                                }
                                if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT && getHeight() < i6) {
                                    setHeight(i6);
                                    this.si = DimensionBehaviour.WRAP_CONTENT;
                                    z = true;
                                    z3 = true;
                                }
                            }
                            i = Math.max(this.oL, getWidth());
                            if (i > getWidth()) {
                                setWidth(i);
                                this.sh = DimensionBehaviour.FIXED;
                                z = true;
                                z3 = true;
                            }
                            i = Math.max(this.oM, getHeight());
                            if (i > getHeight()) {
                                setHeight(i);
                                this.si = DimensionBehaviour.FIXED;
                                z = true;
                                z3 = true;
                            }
                            if (z) {
                                if (this.sh == DimensionBehaviour.WRAP_CONTENT && max2 > 0 && getWidth() > max2) {
                                    this.sW = true;
                                    z = true;
                                    this.sh = DimensionBehaviour.FIXED;
                                    setWidth(max2);
                                    z3 = true;
                                }
                                if (this.si == DimensionBehaviour.WRAP_CONTENT && max3 > 0 && getHeight() > max3) {
                                    this.sX = true;
                                    z = true;
                                    this.si = DimensionBehaviour.FIXED;
                                    setHeight(max3);
                                    z3 = true;
                                }
                            }
                            z2 = z;
                            z = z3;
                            i2 = i3;
                        }
                        if (this.rM == null) {
                            i2 = Math.max(this.oL, getWidth());
                            max = Math.max(this.oM, getHeight());
                            this.sJ.m13872e(this);
                            setWidth((i2 + this.sL) + this.sN);
                            setHeight((this.sM + max) + this.sO);
                        } else {
                            this.rT = i4;
                            this.rU = i5;
                        }
                        if (z2) {
                            this.sh = dimensionBehaviour2;
                            this.si = dimensionBehaviour;
                        }
                        m13230b(this.sH.dZ());
                        if (this == eP()) {
                            eD();
                        }
                    }
                }
            }
        }
        z = z3;
        eL();
        size = this.tj.size();
        for (i = 0; i < size; i++) {
            constraintWidget = (ConstraintWidget) this.tj.get(i);
            if (constraintWidget instanceof C4022w) {
                ((C4022w) constraintWidget).eJ();
            }
        }
        i2 = 0;
        z2 = z;
        z = true;
        while (z) {
            i3 = i2 + 1;
            this.sH.reset();
            z = m13245c(this.sH, Integer.MAX_VALUE);
            if (z) {
                this.sH.dX();
            }
            if (z) {
                b(this.sH, Integer.MAX_VALUE);
                for (max = 0; max < size; max++) {
                    constraintWidget = (ConstraintWidget) this.tj.get(max);
                    if (constraintWidget.sh == DimensionBehaviour.MATCH_CONSTRAINT) {
                    }
                    if (constraintWidget.si != DimensionBehaviour.MATCH_CONSTRAINT) {
                    }
                }
            } else {
                m13242a(this.sH, Integer.MAX_VALUE, this.sU);
            }
            if (i3 < 8) {
            }
            z3 = false;
            z = z2;
            i = Math.max(this.oL, getWidth());
            if (i > getWidth()) {
                setWidth(i);
                this.sh = DimensionBehaviour.FIXED;
                z = true;
                z3 = true;
            }
            i = Math.max(this.oM, getHeight());
            if (i > getHeight()) {
                setHeight(i);
                this.si = DimensionBehaviour.FIXED;
                z = true;
                z3 = true;
            }
            if (z) {
                this.sW = true;
                z = true;
                this.sh = DimensionBehaviour.FIXED;
                setWidth(max2);
                z3 = true;
                this.sX = true;
                z = true;
                this.si = DimensionBehaviour.FIXED;
                setHeight(max3);
                z3 = true;
            }
            z2 = z;
            z = z3;
            i2 = i3;
        }
        if (this.rM == null) {
            this.rT = i4;
            this.rU = i5;
        } else {
            i2 = Math.max(this.oL, getWidth());
            max = Math.max(this.oM, getHeight());
            this.sJ.m13872e(this);
            setWidth((i2 + this.sL) + this.sN);
            setHeight((this.sM + max) + this.sO);
        }
        if (z2) {
            this.sh = dimensionBehaviour2;
            this.si = dimensionBehaviour;
        }
        m13230b(this.sH.dZ());
        if (this == eP()) {
            eD();
        }
    }

    public void m13241a(ConstraintWidget constraintWidget, boolean[] zArr) {
        ConstraintWidget constraintWidget2 = null;
        boolean z = false;
        if (constraintWidget.sh == DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.si == DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.rN > 0.0f) {
            zArr[0] = false;
            return;
        }
        boolean ep = constraintWidget.ep();
        if (constraintWidget.sh != DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.si == DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.rN <= 0.0f) {
            int i;
            int i2;
            constraintWidget.sw = true;
            if (constraintWidget instanceof C4070s) {
                int i3;
                C4070s c4070s = (C4070s) constraintWidget;
                if (c4070s.getOrientation() != 1) {
                    i3 = ep;
                    z = ep;
                } else if (c4070s.eN() != -1) {
                    i3 = c4070s.eN();
                } else if (c4070s.eO() != -1) {
                    ep = c4070s.eO();
                    i3 = 0;
                    z = ep;
                } else {
                    i3 = 0;
                }
                i = i3;
                i2 = z;
            } else if (!constraintWidget.rF.isConnected() && !constraintWidget.rD.isConnected()) {
                boolean z2 = ep;
                i = constraintWidget.getX() + ep;
            } else if (constraintWidget.rF.rj == null || constraintWidget.rD.rj == null || (constraintWidget.rF.rj != constraintWidget.rD.rj && (constraintWidget.rF.rj.rh != constraintWidget.rD.rj.rh || constraintWidget.rF.rj.rh == constraintWidget.rM))) {
                ConstraintWidget constraintWidget3;
                if (constraintWidget.rF.rj != null) {
                    constraintWidget3 = constraintWidget.rF.rj.rh;
                    i2 = constraintWidget.rF.eg() + ep;
                    if (!(constraintWidget3.em() || constraintWidget3.sw)) {
                        m13241a(constraintWidget3, zArr);
                    }
                } else {
                    constraintWidget3 = null;
                    i2 = ep;
                }
                if (constraintWidget.rD.rj != null) {
                    constraintWidget2 = constraintWidget.rD.rj.rh;
                    i = ep + constraintWidget.rD.eg();
                    if (!(constraintWidget2.em() || constraintWidget2.sw)) {
                        m13241a(constraintWidget2, zArr);
                    }
                }
                if (!(constraintWidget.rF.rj == null || constraintWidget3.em())) {
                    boolean z3;
                    if (constraintWidget.rF.rj.ri == Type.RIGHT) {
                        i2 += constraintWidget3.sq - constraintWidget3.ep();
                    } else if (constraintWidget.rF.rj.ef() == Type.LEFT) {
                        i2 += constraintWidget3.sq;
                    }
                    if (constraintWidget3.st || !(constraintWidget3.rD.rj == null || constraintWidget3.rF.rj == null || constraintWidget3.sh == DimensionBehaviour.MATCH_CONSTRAINT)) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    constraintWidget.st = z3;
                    if (constraintWidget.st) {
                        if (constraintWidget3.rD.rj != null) {
                            if (constraintWidget3.rD.rj.rh != constraintWidget) {
                            }
                        }
                        i2 += i2 - constraintWidget3.sq;
                    }
                }
                if (!(constraintWidget.rD.rj == null || constraintWidget2.em())) {
                    if (constraintWidget.rD.rj.ef() == Type.LEFT) {
                        i += constraintWidget2.sp - constraintWidget2.ep();
                    } else if (constraintWidget.rD.rj.ef() == Type.RIGHT) {
                        i += constraintWidget2.sp;
                    }
                    if (constraintWidget2.ss || !(constraintWidget2.rD.rj == null || constraintWidget2.rF.rj == null || constraintWidget2.sh == DimensionBehaviour.MATCH_CONSTRAINT)) {
                        z = true;
                    }
                    constraintWidget.ss = z;
                    if (constraintWidget.ss) {
                        if (constraintWidget2.rF.rj != null) {
                            if (constraintWidget2.rF.rj.rh != constraintWidget) {
                            }
                        }
                        i += i - constraintWidget2.sp;
                    }
                }
            } else {
                zArr[0] = false;
                return;
            }
            if (constraintWidget.getVisibility() == 8) {
                i -= constraintWidget.pS;
                i2 -= constraintWidget.pS;
            }
            constraintWidget.sp = i;
            constraintWidget.sq = i2;
            return;
        }
        zArr[0] = false;
    }

    public void m13244b(ConstraintWidget constraintWidget, boolean[] zArr) {
        ConstraintWidget constraintWidget2 = null;
        boolean z = false;
        if (constraintWidget.si != DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.sh == DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.rN <= 0.0f) {
            int i;
            int i2;
            boolean eq = constraintWidget.eq();
            constraintWidget.sx = true;
            int i3;
            if (constraintWidget instanceof C4070s) {
                C4070s c4070s = (C4070s) constraintWidget;
                if (c4070s.getOrientation() != 0) {
                    i3 = eq;
                    z = eq;
                } else if (c4070s.eN() != -1) {
                    eq = c4070s.eN();
                    i3 = 0;
                    z = eq;
                } else {
                    i3 = c4070s.eO() != -1 ? c4070s.eO() : 0;
                }
                i = i3;
                i2 = z;
            } else if (constraintWidget.rH.rj == null && constraintWidget.rE.rj == null && constraintWidget.rG.rj == null) {
                i2 = eq + constraintWidget.getY();
            } else if (constraintWidget.rG.rj != null && constraintWidget.rE.rj != null && (constraintWidget.rG.rj == constraintWidget.rE.rj || (constraintWidget.rG.rj.rh == constraintWidget.rE.rj.rh && constraintWidget.rG.rj.rh != constraintWidget.rM))) {
                zArr[0] = false;
                return;
            } else if (constraintWidget.rH.isConnected()) {
                r0 = constraintWidget.rH.rj.ee();
                if (!r0.sx) {
                    m13244b(r0, zArr);
                }
                int max = Math.max((r0.so - r0.pT) + eq, eq);
                i3 = Math.max((r0.sr - r0.pT) + eq, eq);
                if (constraintWidget.getVisibility() == 8) {
                    max -= constraintWidget.pT;
                    i3 -= constraintWidget.pT;
                }
                constraintWidget.so = max;
                constraintWidget.sr = i3;
                return;
            } else {
                if (constraintWidget.rE.isConnected()) {
                    r0 = constraintWidget.rE.rj.ee();
                    i2 = constraintWidget.rE.eg() + eq;
                    if (!(r0.em() || r0.sx)) {
                        m13244b(r0, zArr);
                    }
                } else {
                    r0 = null;
                    i2 = eq;
                }
                if (constraintWidget.rG.isConnected()) {
                    constraintWidget2 = constraintWidget.rG.rj.ee();
                    i = eq + constraintWidget.rG.eg();
                    if (!(constraintWidget2.em() || constraintWidget2.sx)) {
                        m13244b(constraintWidget2, zArr);
                    }
                }
                if (!(constraintWidget.rE.rj == null || r0.em())) {
                    boolean z2;
                    if (constraintWidget.rE.rj.ef() == Type.TOP) {
                        i2 += r0.so - r0.eq();
                    } else if (constraintWidget.rE.rj.ef() == Type.BOTTOM) {
                        i2 += r0.so;
                    }
                    if (r0.su || !(r0.rE.rj == null || r0.rE.rj.rh == constraintWidget || r0.rG.rj == null || r0.rG.rj.rh == constraintWidget || r0.si == DimensionBehaviour.MATCH_CONSTRAINT)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    constraintWidget.su = z2;
                    if (constraintWidget.su) {
                        if (r0.rG.rj != null) {
                            if (r0.rG.rj.rh != constraintWidget) {
                            }
                        }
                        i2 += i2 - r0.so;
                    }
                }
                if (!(constraintWidget.rG.rj == null || constraintWidget2.em())) {
                    if (constraintWidget.rG.rj.ef() == Type.BOTTOM) {
                        i += constraintWidget2.sr - constraintWidget2.eq();
                    } else if (constraintWidget.rG.rj.ef() == Type.TOP) {
                        i += constraintWidget2.sr;
                    }
                    if (constraintWidget2.sv || !(constraintWidget2.rE.rj == null || constraintWidget2.rE.rj.rh == constraintWidget || constraintWidget2.rG.rj == null || constraintWidget2.rG.rj.rh == constraintWidget || constraintWidget2.si == DimensionBehaviour.MATCH_CONSTRAINT)) {
                        z = true;
                    }
                    constraintWidget.sv = z;
                    if (constraintWidget.sv) {
                        if (constraintWidget2.rE.rj != null) {
                            if (constraintWidget2.rE.rj.rh != constraintWidget) {
                            }
                        }
                        i += i - constraintWidget2.sr;
                    }
                }
            }
            if (constraintWidget.getVisibility() == 8) {
                i2 -= constraintWidget.pT;
                i -= constraintWidget.pT;
            }
            constraintWidget.so = i2;
            constraintWidget.sr = i;
            return;
        }
        zArr[0] = false;
    }

    public void m13243a(ArrayList<ConstraintWidget> arrayList, boolean[] zArr) {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int size = arrayList.size();
        zArr[0] = true;
        int i7 = 0;
        while (i7 < size) {
            int i8;
            int i9;
            int i10;
            ConstraintWidget constraintWidget = (ConstraintWidget) arrayList.get(i7);
            if (constraintWidget.em()) {
                i8 = i6;
                i9 = i5;
                i10 = i4;
                i6 = i3;
                i5 = i2;
                i4 = i;
            } else {
                if (!constraintWidget.sw) {
                    m13241a(constraintWidget, zArr);
                }
                if (!constraintWidget.sx) {
                    m13244b(constraintWidget, zArr);
                }
                if (zArr[0]) {
                    i9 = (constraintWidget.sp + constraintWidget.sq) - constraintWidget.getWidth();
                    i10 = (constraintWidget.so + constraintWidget.sr) - constraintWidget.getHeight();
                    if (constraintWidget.sh == DimensionBehaviour.MATCH_PARENT) {
                        i9 = (constraintWidget.getWidth() + constraintWidget.rD.rk) + constraintWidget.rF.rk;
                    }
                    if (constraintWidget.si == DimensionBehaviour.MATCH_PARENT) {
                        i10 = (constraintWidget.getHeight() + constraintWidget.rE.rk) + constraintWidget.rG.rk;
                    }
                    if (constraintWidget.getVisibility() == 8) {
                        i9 = 0;
                        i10 = 0;
                    }
                    i2 = Math.max(i2, constraintWidget.sp);
                    i3 = Math.max(i3, constraintWidget.sq);
                    i4 = Math.max(i4, constraintWidget.sr);
                    i = Math.max(i, constraintWidget.so);
                    i9 = Math.max(i5, i9);
                    i8 = Math.max(i6, i10);
                    i10 = i4;
                    i6 = i3;
                    i5 = i2;
                    i4 = i;
                } else {
                    return;
                }
            }
            i7++;
            i2 = i5;
            i = i4;
            i4 = i10;
            i3 = i6;
            i5 = i9;
            i6 = i8;
        }
        this.sc = Math.max(this.oL, Math.max(Math.max(i2, i3), i5));
        this.sd = Math.max(this.oM, Math.max(Math.max(i, i4), i6));
        for (i9 = 0; i9 < size; i9++) {
            constraintWidget = (ConstraintWidget) arrayList.get(i9);
            constraintWidget.sw = false;
            constraintWidget.sx = false;
            constraintWidget.ss = false;
            constraintWidget.st = false;
            constraintWidget.su = false;
            constraintWidget.sv = false;
        }
    }

    public boolean eK() {
        return false;
    }

    private void eL() {
        this.sP = 0;
        this.sQ = 0;
    }

    public void m13240a(ConstraintWidget constraintWidget, int i) {
        if (i == 0) {
            while (constraintWidget.rD.rj != null && constraintWidget.rD.rj.rh.rF.rj != null && constraintWidget.rD.rj.rh.rF.rj == constraintWidget.rD && constraintWidget.rD.rj.rh != constraintWidget) {
                constraintWidget = constraintWidget.rD.rj.rh;
            }
            m13235b(constraintWidget);
        } else if (i == 1) {
            while (constraintWidget.rE.rj != null && constraintWidget.rE.rj.rh.rG.rj != null && constraintWidget.rE.rj.rh.rG.rj == constraintWidget.rE && constraintWidget.rE.rj.rh != constraintWidget) {
                constraintWidget = constraintWidget.rE.rj.rh;
            }
            m13236c(constraintWidget);
        }
    }

    private void m13235b(ConstraintWidget constraintWidget) {
        int i = 0;
        while (i < this.sP) {
            if (this.sT[i] != constraintWidget) {
                i++;
            } else {
                return;
            }
        }
        if (this.sP + 1 >= this.sT.length) {
            this.sT = (ConstraintWidget[]) Arrays.copyOf(this.sT, this.sT.length * 2);
        }
        this.sT[this.sP] = constraintWidget;
        this.sP++;
    }

    private void m13236c(ConstraintWidget constraintWidget) {
        int i = 0;
        while (i < this.sQ) {
            if (this.sS[i] != constraintWidget) {
                i++;
            } else {
                return;
            }
        }
        if (this.sQ + 1 >= this.sS.length) {
            this.sS = (ConstraintWidget[]) Arrays.copyOf(this.sS, this.sS.length * 2);
        }
        this.sS[this.sQ] = constraintWidget;
        this.sQ++;
    }

    private int m13234a(C3953p c3953p, ConstraintWidget[] constraintWidgetArr, ConstraintWidget constraintWidget, int i, boolean[] zArr) {
        int i2;
        zArr[0] = true;
        zArr[1] = false;
        constraintWidgetArr[0] = null;
        constraintWidgetArr[2] = null;
        constraintWidgetArr[1] = null;
        constraintWidgetArr[3] = null;
        boolean z;
        ConstraintWidget constraintWidget2;
        ConstraintWidget constraintWidget3;
        ConstraintWidget constraintWidget4;
        ConstraintWidget constraintWidget5;
        ConstraintWidget constraintWidget6;
        int i3;
        if (i == 0) {
            if (constraintWidget.rD.rj == null || constraintWidget.rD.rj.rh == this) {
                z = true;
            } else {
                z = false;
            }
            constraintWidget.sE = null;
            constraintWidget2 = null;
            if (constraintWidget.getVisibility() != 8) {
                constraintWidget2 = constraintWidget;
            }
            constraintWidget3 = null;
            i2 = 0;
            constraintWidget4 = constraintWidget;
            constraintWidget5 = constraintWidget2;
            while (constraintWidget4.rF.rj != null) {
                constraintWidget4.sE = null;
                if (constraintWidget4.getVisibility() != 8) {
                    if (constraintWidget5 == null) {
                        constraintWidget6 = constraintWidget4;
                    } else {
                        constraintWidget6 = constraintWidget5;
                    }
                    if (!(constraintWidget2 == null || constraintWidget2 == constraintWidget4)) {
                        constraintWidget2.sE = constraintWidget4;
                    }
                    constraintWidget5 = constraintWidget4;
                } else {
                    c3953p.m13004c(constraintWidget4.rD.rp, constraintWidget4.rD.rj.rp, 0, 5);
                    c3953p.m13004c(constraintWidget4.rF.rp, constraintWidget4.rD.rp, 0, 5);
                    constraintWidget6 = constraintWidget5;
                    constraintWidget5 = constraintWidget2;
                }
                if (constraintWidget4.getVisibility() != 8 && constraintWidget4.sh == DimensionBehaviour.MATCH_CONSTRAINT) {
                    if (constraintWidget4.si == DimensionBehaviour.MATCH_CONSTRAINT) {
                        zArr[0] = false;
                    }
                    if (constraintWidget4.rN <= 0.0f) {
                        zArr[0] = false;
                        if (i2 + 1 >= this.sR.length) {
                            this.sR = (ConstraintWidget[]) Arrays.copyOf(this.sR, this.sR.length * 2);
                        }
                        i3 = i2 + 1;
                        this.sR[i2] = constraintWidget4;
                        i2 = i3;
                    }
                }
                if (constraintWidget4.rF.rj.rh.rD.rj == null || constraintWidget4.rF.rj.rh.rD.rj.rh != constraintWidget4 || constraintWidget4.rF.rj.rh == constraintWidget4) {
                    break;
                }
                constraintWidget2 = constraintWidget4.rF.rj.rh;
                constraintWidget3 = constraintWidget2;
                constraintWidget4 = constraintWidget2;
                constraintWidget2 = constraintWidget5;
                constraintWidget5 = constraintWidget6;
            }
            constraintWidget6 = constraintWidget5;
            constraintWidget5 = constraintWidget2;
            if (!(constraintWidget4.rF.rj == null || constraintWidget4.rF.rj.rh == this)) {
                z = false;
            }
            if (constraintWidget.rD.rj == null || constraintWidget3.rF.rj == null) {
                zArr[1] = true;
            }
            constraintWidget.sA = z;
            constraintWidget3.sE = null;
            constraintWidgetArr[0] = constraintWidget;
            constraintWidgetArr[2] = constraintWidget6;
            constraintWidgetArr[1] = constraintWidget3;
            constraintWidgetArr[3] = constraintWidget5;
        } else {
            if (constraintWidget.rE.rj == null || constraintWidget.rE.rj.rh == this) {
                z = true;
            } else {
                z = false;
            }
            constraintWidget.sF = null;
            constraintWidget2 = null;
            if (constraintWidget.getVisibility() != 8) {
                constraintWidget2 = constraintWidget;
            }
            constraintWidget3 = null;
            i2 = 0;
            constraintWidget4 = constraintWidget;
            constraintWidget5 = constraintWidget2;
            while (constraintWidget4.rG.rj != null) {
                constraintWidget4.sF = null;
                if (constraintWidget4.getVisibility() != 8) {
                    if (constraintWidget5 == null) {
                        constraintWidget6 = constraintWidget4;
                    } else {
                        constraintWidget6 = constraintWidget5;
                    }
                    if (!(constraintWidget2 == null || constraintWidget2 == constraintWidget4)) {
                        constraintWidget2.sF = constraintWidget4;
                    }
                    constraintWidget5 = constraintWidget4;
                } else {
                    c3953p.m13004c(constraintWidget4.rE.rp, constraintWidget4.rE.rj.rp, 0, 5);
                    c3953p.m13004c(constraintWidget4.rG.rp, constraintWidget4.rE.rp, 0, 5);
                    constraintWidget6 = constraintWidget5;
                    constraintWidget5 = constraintWidget2;
                }
                if (constraintWidget4.getVisibility() != 8 && constraintWidget4.si == DimensionBehaviour.MATCH_CONSTRAINT) {
                    if (constraintWidget4.sh == DimensionBehaviour.MATCH_CONSTRAINT) {
                        zArr[0] = false;
                    }
                    if (constraintWidget4.rN <= 0.0f) {
                        zArr[0] = false;
                        if (i2 + 1 >= this.sR.length) {
                            this.sR = (ConstraintWidget[]) Arrays.copyOf(this.sR, this.sR.length * 2);
                        }
                        i3 = i2 + 1;
                        this.sR[i2] = constraintWidget4;
                        i2 = i3;
                    }
                }
                if (constraintWidget4.rG.rj.rh.rE.rj == null || constraintWidget4.rG.rj.rh.rE.rj.rh != constraintWidget4 || constraintWidget4.rG.rj.rh == constraintWidget4) {
                    break;
                }
                constraintWidget2 = constraintWidget4.rG.rj.rh;
                constraintWidget3 = constraintWidget2;
                constraintWidget4 = constraintWidget2;
                constraintWidget2 = constraintWidget5;
                constraintWidget5 = constraintWidget6;
            }
            constraintWidget6 = constraintWidget5;
            constraintWidget5 = constraintWidget2;
            if (!(constraintWidget4.rG.rj == null || constraintWidget4.rG.rj.rh == this)) {
                z = false;
            }
            if (constraintWidget.rE.rj == null || constraintWidget3.rG.rj == null) {
                zArr[1] = true;
            }
            constraintWidget.sB = z;
            constraintWidget3.sF = null;
            constraintWidgetArr[0] = constraintWidget;
            constraintWidgetArr[2] = constraintWidget6;
            constraintWidgetArr[1] = constraintWidget3;
            constraintWidgetArr[3] = constraintWidget5;
        }
        return i2;
    }
}
