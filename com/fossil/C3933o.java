package com.fossil;

import android.support.constraint.solver.SolverVariable;
import android.support.constraint.solver.SolverVariable.Type;
import java.util.ArrayList;

public class C3933o {
    ArrayList<SolverVariable> qH = new ArrayList();

    SolverVariable dR() {
        int size = this.qH.size();
        int i = 0;
        int i2 = 0;
        SolverVariable solverVariable = null;
        while (i < size) {
            SolverVariable solverVariable2 = (SolverVariable) this.qH.get(i);
            SolverVariable solverVariable3 = solverVariable;
            int i3 = 5;
            while (i3 >= 0) {
                float f = solverVariable2.rc[i3];
                if (solverVariable3 == null && f < 0.0f && i3 >= r1) {
                    i2 = i3;
                    solverVariable3 = solverVariable2;
                }
                if (f > 0.0f && i3 > r1) {
                    i2 = i3;
                    solverVariable3 = null;
                }
                i3--;
            }
            i++;
            solverVariable = solverVariable3;
        }
        return solverVariable;
    }

    private void m12861a(C3953p c3953p) {
        this.qH.clear();
        for (int i = 1; i < c3953p.qQ; i++) {
            SolverVariable solverVariable = c3953p.qq.qG[i];
            for (int i2 = 0; i2 < 6; i2++) {
                solverVariable.rc[i2] = 0.0f;
            }
            solverVariable.rc[solverVariable.ra] = 1.0f;
            if (solverVariable.rd == Type.ERROR) {
                this.qH.add(solverVariable);
            }
        }
    }

    void m12862b(C3953p c3953p) {
        m12861a(c3953p);
        int size = this.qH.size();
        for (int i = 0; i < size; i++) {
            SolverVariable solverVariable = (SolverVariable) this.qH.get(i);
            if (solverVariable.qZ != -1) {
                l lVar = c3953p.m13008t(solverVariable.qZ).qC;
                int i2 = lVar.qo;
                for (int i3 = 0; i3 < i2; i3++) {
                    SolverVariable r = lVar.r(i3);
                    if (r != null) {
                        float s = lVar.s(i3);
                        for (int i4 = 0; i4 < 6; i4++) {
                            float[] fArr = r.rc;
                            fArr[i4] = fArr[i4] + (solverVariable.rc[i4] * s);
                        }
                        if (!this.qH.contains(r)) {
                            this.qH.add(r);
                        }
                    }
                }
                solverVariable.eb();
            }
        }
    }

    public String toString() {
        int size = this.qH.size();
        String str = "Goal: ";
        for (int i = 0; i < size; i++) {
            str = str + ((SolverVariable) this.qH.get(i)).ec();
        }
        return str;
    }
}
