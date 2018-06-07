package com.fossil;

import android.support.constraint.solver.widgets.ConstraintAnchor;
import android.support.constraint.solver.widgets.ConstraintAnchor.Strength;
import android.support.constraint.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

public class C4145v {
    private int pS;
    private int pT;
    private int rT;
    private int rU;
    private ArrayList<C4144a> tg = new ArrayList();

    static class C4144a {
        private ConstraintAnchor rj;
        private int rk;
        private ConstraintAnchor tb;
        private Strength th;
        private int ti;

        public C4144a(ConstraintAnchor constraintAnchor) {
            this.tb = constraintAnchor;
            this.rj = constraintAnchor.ei();
            this.rk = constraintAnchor.eg();
            this.th = constraintAnchor.eh();
            this.ti = constraintAnchor.ek();
        }

        public void m13869d(ConstraintWidget constraintWidget) {
            this.tb = constraintWidget.a(this.tb.ef());
            if (this.tb != null) {
                this.rj = this.tb.ei();
                this.rk = this.tb.eg();
                this.th = this.tb.eh();
                this.ti = this.tb.ek();
                return;
            }
            this.rj = null;
            this.rk = 0;
            this.th = Strength.STRONG;
            this.ti = 0;
        }

        public void m13870e(ConstraintWidget constraintWidget) {
            constraintWidget.a(this.tb.ef()).a(this.rj, this.rk, this.th, this.ti);
        }
    }

    public C4145v(ConstraintWidget constraintWidget) {
        this.rT = constraintWidget.getX();
        this.rU = constraintWidget.getY();
        this.pS = constraintWidget.getWidth();
        this.pT = constraintWidget.getHeight();
        ArrayList eC = constraintWidget.eC();
        int size = eC.size();
        for (int i = 0; i < size; i++) {
            this.tg.add(new C4144a((ConstraintAnchor) eC.get(i)));
        }
    }

    public void m13871d(ConstraintWidget constraintWidget) {
        this.rT = constraintWidget.getX();
        this.rU = constraintWidget.getY();
        this.pS = constraintWidget.getWidth();
        this.pT = constraintWidget.getHeight();
        int size = this.tg.size();
        for (int i = 0; i < size; i++) {
            ((C4144a) this.tg.get(i)).m13869d(constraintWidget);
        }
    }

    public void m13872e(ConstraintWidget constraintWidget) {
        constraintWidget.setX(this.rT);
        constraintWidget.setY(this.rU);
        constraintWidget.setWidth(this.pS);
        constraintWidget.setHeight(this.pT);
        int size = this.tg.size();
        for (int i = 0; i < size; i++) {
            ((C4144a) this.tg.get(i)).m13870e(constraintWidget);
        }
    }
}
