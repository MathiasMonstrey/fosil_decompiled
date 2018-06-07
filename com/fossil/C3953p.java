package com.fossil;

import android.support.constraint.solver.SolverVariable;
import android.support.constraint.solver.SolverVariable.Type;
import android.support.constraint.solver.widgets.ConstraintAnchor;
import java.util.Arrays;
import java.util.HashMap;

public class C3953p {
    private static int qI = 1000;
    int qJ;
    private HashMap<String, SolverVariable> qK;
    private C3933o qL;
    private int qM;
    private int qN;
    private m[] qO;
    private boolean[] qP;
    int qQ;
    private int qR;
    private int qS;
    private SolverVariable[] qT;
    private int qU;
    private m[] qV;
    final n qq;

    public C3953p() {
        this.qJ = 0;
        this.qK = null;
        this.qL = new C3933o();
        this.qM = 32;
        this.qN = this.qM;
        this.qO = null;
        this.qP = new boolean[this.qM];
        this.qQ = 1;
        this.qR = 0;
        this.qS = this.qM;
        this.qT = new SolverVariable[qI];
        this.qU = 0;
        this.qV = new m[this.qM];
        this.qO = new m[this.qM];
        dT();
        this.qq = new n();
    }

    private void dS() {
        this.qM *= 2;
        this.qO = (m[]) Arrays.copyOf(this.qO, this.qM);
        this.qq.qG = (SolverVariable[]) Arrays.copyOf(this.qq.qG, this.qM);
        this.qP = new boolean[this.qM];
        this.qN = this.qM;
        this.qS = this.qM;
        this.qL.qH.clear();
    }

    private void dT() {
        for (int i = 0; i < this.qO.length; i++) {
            Object obj = this.qO[i];
            if (obj != null) {
                this.qq.qE.mo4016e(obj);
            }
            this.qO[i] = null;
        }
    }

    public void reset() {
        int i;
        for (SolverVariable solverVariable : this.qq.qG) {
            if (solverVariable != null) {
                solverVariable.reset();
            }
        }
        this.qq.qF.mo4015a(this.qT, this.qU);
        this.qU = 0;
        Arrays.fill(this.qq.qG, null);
        if (this.qK != null) {
            this.qK.clear();
        }
        this.qJ = 0;
        this.qL.qH.clear();
        this.qQ = 1;
        for (i = 0; i < this.qR; i++) {
            this.qO[i].qB = false;
        }
        dT();
        this.qR = 0;
    }

    public SolverVariable m13003c(Object obj) {
        SolverVariable solverVariable = null;
        if (obj != null) {
            if (this.qQ + 1 >= this.qN) {
                dS();
            }
            if (obj instanceof ConstraintAnchor) {
                solverVariable = ((ConstraintAnchor) obj).ed();
                if (solverVariable == null) {
                    ((ConstraintAnchor) obj).a(this.qq);
                    solverVariable = ((ConstraintAnchor) obj).ed();
                }
                if (solverVariable.id == -1 || solverVariable.id > this.qJ || this.qq.qG[solverVariable.id] == null) {
                    if (solverVariable.id != -1) {
                        solverVariable.reset();
                    }
                    this.qJ++;
                    this.qQ++;
                    solverVariable.id = this.qJ;
                    solverVariable.rd = Type.UNRESTRICTED;
                    this.qq.qG[this.qJ] = solverVariable;
                }
            }
        }
        return solverVariable;
    }

    public m dU() {
        m mVar = (m) this.qq.qE.ea();
        if (mVar == null) {
            return new m(this.qq);
        }
        mVar.reset();
        return mVar;
    }

    public SolverVariable dV() {
        if (this.qQ + 1 >= this.qN) {
            dS();
        }
        SolverVariable a = m12988a(Type.SLACK);
        this.qJ++;
        this.qQ++;
        a.id = this.qJ;
        this.qq.qG[this.qJ] = a;
        return a;
    }

    private void m12997c(m mVar) {
        mVar.a(dW(), dW());
    }

    private void m12992a(m mVar, int i) {
        mVar.c(dW(), i);
    }

    public SolverVariable dW() {
        if (this.qQ + 1 >= this.qN) {
            dS();
        }
        SolverVariable a = m12988a(Type.ERROR);
        this.qJ++;
        this.qQ++;
        a.id = this.qJ;
        this.qq.qG[this.qJ] = a;
        return a;
    }

    private SolverVariable m12988a(Type type) {
        SolverVariable solverVariable;
        SolverVariable solverVariable2 = (SolverVariable) this.qq.qF.ea();
        if (solverVariable2 == null) {
            solverVariable = new SolverVariable(type);
        } else {
            solverVariable2.reset();
            solverVariable2.b(type);
            solverVariable = solverVariable2;
        }
        if (this.qU >= qI) {
            qI *= 2;
            this.qT = (SolverVariable[]) Arrays.copyOf(this.qT, qI);
        }
        SolverVariable[] solverVariableArr = this.qT;
        int i = this.qU;
        this.qU = i + 1;
        solverVariableArr[i] = solverVariable;
        return solverVariable;
    }

    m m13008t(int i) {
        return this.qO[i];
    }

    public int m13005d(Object obj) {
        SolverVariable ed = ((ConstraintAnchor) obj).ed();
        if (ed != null) {
            return (int) (ed.rb + 0.5f);
        }
        return 0;
    }

    public void dX() throws Exception {
        m13001a(this.qL);
    }

    void m13001a(C3933o c3933o) throws Exception {
        c3933o.m12862b(this);
        m12995c(c3933o);
        m12993b(c3933o);
        dY();
    }

    private void m12998d(m mVar) {
        if (this.qR > 0) {
            mVar.qC.a(mVar, this.qO);
            if (mVar.qC.qo == 0) {
                mVar.qD = true;
            }
        }
    }

    public void m13007e(m mVar) {
        int i = 0;
        if (mVar != null) {
            if (this.qR + 1 >= this.qS || this.qQ + 1 >= this.qN) {
                dS();
            }
            if (!mVar.qD) {
                m12998d(mVar);
                mVar.dP();
                mVar.dQ();
                if (!mVar.dN()) {
                    return;
                }
            }
            if (this.qO[this.qR] != null) {
                this.qq.qE.mo4016e(this.qO[this.qR]);
            }
            if (!mVar.qD) {
                mVar.dM();
            }
            this.qO[this.qR] = mVar;
            mVar.qz.qZ = this.qR;
            this.qR++;
            int i2 = mVar.qz.rf;
            if (i2 > 0) {
                while (this.qV.length < i2) {
                    this.qV = new m[(this.qV.length * 2)];
                }
                m[] mVarArr = this.qV;
                for (int i3 = 0; i3 < i2; i3++) {
                    mVarArr[i3] = mVar.qz.re[i3];
                }
                while (i < i2) {
                    m mVar2 = mVarArr[i];
                    if (mVar2 != mVar) {
                        mVar2.qC.a(mVar2, mVar);
                        mVar2.dM();
                    }
                    i++;
                }
            }
        }
    }

    private int m12993b(C3933o c3933o) {
        int i;
        for (i = 0; i < this.qQ; i++) {
            this.qP[i] = false;
        }
        int i2 = 0;
        i = 0;
        boolean z = false;
        while (!z) {
            SolverVariable solverVariable;
            int i3;
            float f;
            m mVar;
            float c;
            float f2;
            m mVar2;
            boolean z2;
            int i4 = i + 1;
            SolverVariable dR = c3933o.dR();
            if (dR != null) {
                if (this.qP[dR.id]) {
                    solverVariable = null;
                    i3 = i2;
                } else {
                    this.qP[dR.id] = true;
                    i2++;
                    if (i2 >= this.qQ) {
                        solverVariable = dR;
                        i3 = i2;
                        z = true;
                    }
                }
                if (solverVariable == null) {
                    i2 = -1;
                    f = Float.MAX_VALUE;
                    for (i = 0; i < this.qR; i++) {
                        mVar = this.qO[i];
                        if (mVar.qz.rd != Type.UNRESTRICTED && mVar.d(solverVariable)) {
                            c = mVar.qC.c(solverVariable);
                            if (c < 0.0f) {
                                f2 = (-mVar.qA) / c;
                                if (f2 < f) {
                                    i2 = i;
                                    f = f2;
                                }
                            }
                        }
                    }
                    if (i2 <= -1) {
                        mVar2 = this.qO[i2];
                        mVar2.qz.qZ = -1;
                        mVar2.e(solverVariable);
                        mVar2.qz.qZ = i2;
                        for (i = 0; i < this.qR; i++) {
                            this.qO[i].b(mVar2);
                        }
                        c3933o.m12862b(this);
                        try {
                            m12995c(c3933o);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        z2 = z;
                    } else {
                        z2 = true;
                    }
                } else {
                    z2 = true;
                }
                i2 = i3;
                z = z2;
                i = i4;
            }
            solverVariable = dR;
            i3 = i2;
            if (solverVariable == null) {
                z2 = true;
            } else {
                i2 = -1;
                f = Float.MAX_VALUE;
                for (i = 0; i < this.qR; i++) {
                    mVar = this.qO[i];
                    c = mVar.qC.c(solverVariable);
                    if (c < 0.0f) {
                        f2 = (-mVar.qA) / c;
                        if (f2 < f) {
                            i2 = i;
                            f = f2;
                        }
                    }
                }
                if (i2 <= -1) {
                    z2 = true;
                } else {
                    mVar2 = this.qO[i2];
                    mVar2.qz.qZ = -1;
                    mVar2.e(solverVariable);
                    mVar2.qz.qZ = i2;
                    for (i = 0; i < this.qR; i++) {
                        this.qO[i].b(mVar2);
                    }
                    c3933o.m12862b(this);
                    m12995c(c3933o);
                    z2 = z;
                }
            }
            i2 = i3;
            z = z2;
            i = i4;
        }
        return i;
    }

    private int m12995c(C3933o c3933o) throws Exception {
        Object obj;
        int i;
        int i2 = 0;
        while (i2 < this.qR) {
            if (this.qO[i2].qz.rd != Type.UNRESTRICTED && this.qO[i2].qA < 0.0f) {
                obj = 1;
                break;
            }
            i2++;
        }
        obj = null;
        if (obj != null) {
            Object obj2 = null;
            i2 = 0;
            while (obj2 == null) {
                int i3 = i2 + 1;
                float f = Float.MAX_VALUE;
                int i4 = 0;
                int i5 = -1;
                i = -1;
                for (i2 = 0; i2 < this.qR; i2++) {
                    m mVar = this.qO[i2];
                    if (mVar.qz.rd != Type.UNRESTRICTED && mVar.qA < 0.0f) {
                        float f2 = f;
                        int i6 = i4;
                        i4 = i5;
                        i5 = i;
                        for (i = 1; i < this.qQ; i++) {
                            SolverVariable solverVariable = this.qq.qG[i];
                            float c = mVar.qC.c(solverVariable);
                            if (c > 0.0f) {
                                float f3 = f2;
                                int i7 = 0;
                                while (i7 < 6) {
                                    float f4 = solverVariable.rc[i7] / c;
                                    if ((f4 >= f3 || i7 != r6) && i7 <= r6) {
                                        f4 = f3;
                                    } else {
                                        i5 = i;
                                        i4 = i2;
                                        i6 = i7;
                                    }
                                    i7++;
                                    f3 = f4;
                                }
                                f2 = f3;
                            }
                        }
                        i = i5;
                        i5 = i4;
                        i4 = i6;
                        f = f2;
                    }
                }
                if (i5 != -1) {
                    m mVar2 = this.qO[i5];
                    mVar2.qz.qZ = -1;
                    mVar2.e(this.qq.qG[i]);
                    mVar2.qz.qZ = i5;
                    for (i2 = 0; i2 < this.qR; i2++) {
                        this.qO[i2].b(mVar2);
                    }
                    c3933o.m12862b(this);
                    obj = obj2;
                } else {
                    obj = 1;
                }
                obj2 = obj;
                i2 = i3;
            }
        } else {
            i2 = 0;
        }
        i = 0;
        while (i < this.qR && (this.qO[i].qz.rd == Type.UNRESTRICTED || this.qO[i].qA >= 0.0f)) {
            i++;
        }
        return i2;
    }

    private void dY() {
        for (int i = 0; i < this.qR; i++) {
            m mVar = this.qO[i];
            mVar.qz.rb = mVar.qA;
        }
    }

    public n dZ() {
        return this.qq;
    }

    public void m13000a(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        m dU = dU();
        SolverVariable dV = dV();
        dV.ra = i2;
        dU.a(solverVariable, solverVariable2, dV, i);
        m13007e(dU);
    }

    public void m13002b(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        m dU = dU();
        SolverVariable dV = dV();
        dV.ra = i2;
        dU.b(solverVariable, solverVariable2, dV, i);
        m13007e(dU);
    }

    public void m12999a(SolverVariable solverVariable, SolverVariable solverVariable2, int i, float f, SolverVariable solverVariable3, SolverVariable solverVariable4, int i2, int i3) {
        m dU = dU();
        dU.a(solverVariable, solverVariable2, i, f, solverVariable3, solverVariable4, i2);
        SolverVariable dW = dW();
        SolverVariable dW2 = dW();
        dW.ra = i3;
        dW2.ra = i3;
        dU.a(dW, dW2);
        m13007e(dU);
    }

    public m m13004c(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        m dU = dU();
        dU.a(solverVariable, solverVariable2, i);
        SolverVariable dW = dW();
        SolverVariable dW2 = dW();
        dW.ra = i2;
        dW2.ra = i2;
        dU.a(dW, dW2);
        m13007e(dU);
        return dU;
    }

    public void m13006d(SolverVariable solverVariable, int i) {
        int i2 = solverVariable.qZ;
        m mVar;
        if (solverVariable.qZ != -1) {
            mVar = this.qO[i2];
            if (mVar.qD) {
                mVar.qA = (float) i;
                return;
            }
            mVar = dU();
            mVar.b(solverVariable, i);
            m13007e(mVar);
            return;
        }
        mVar = dU();
        mVar.a(solverVariable, i);
        m13007e(mVar);
    }

    public static m m12990a(C3953p c3953p, SolverVariable solverVariable, SolverVariable solverVariable2, int i, boolean z) {
        m dU = c3953p.dU();
        dU.a(solverVariable, solverVariable2, i);
        if (z) {
            c3953p.m12992a(dU, 1);
        }
        return dU;
    }

    public static m m12991a(C3953p c3953p, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, float f, boolean z) {
        m dU = c3953p.dU();
        if (z) {
            c3953p.m12997c(dU);
        }
        return dU.a(solverVariable, solverVariable2, solverVariable3, f);
    }

    public static m m12994b(C3953p c3953p, SolverVariable solverVariable, SolverVariable solverVariable2, int i, boolean z) {
        SolverVariable dV = c3953p.dV();
        m dU = c3953p.dU();
        dU.a(solverVariable, solverVariable2, dV, i);
        if (z) {
            c3953p.m12992a(dU, (int) (dU.qC.c(dV) * -1.0f));
        }
        return dU;
    }

    public static m m12996c(C3953p c3953p, SolverVariable solverVariable, SolverVariable solverVariable2, int i, boolean z) {
        SolverVariable dV = c3953p.dV();
        m dU = c3953p.dU();
        dU.b(solverVariable, solverVariable2, dV, i);
        if (z) {
            c3953p.m12992a(dU, (int) (dU.qC.c(dV) * -1.0f));
        }
        return dU;
    }

    public static m m12989a(C3953p c3953p, SolverVariable solverVariable, SolverVariable solverVariable2, int i, float f, SolverVariable solverVariable3, SolverVariable solverVariable4, int i2, boolean z) {
        m dU = c3953p.dU();
        dU.a(solverVariable, solverVariable2, i, f, solverVariable3, solverVariable4, i2);
        if (z) {
            SolverVariable dW = c3953p.dW();
            SolverVariable dW2 = c3953p.dW();
            dW.ra = 4;
            dW2.ra = 4;
            dU.a(dW, dW2);
        }
        return dU;
    }
}
