package com.fossil;

import android.support.constraint.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

public class C4022w extends ConstraintWidget {
    protected ArrayList<ConstraintWidget> tj = new ArrayList();

    public void reset() {
        this.tj.clear();
        super.reset();
    }

    public void m13231f(ConstraintWidget constraintWidget) {
        this.tj.add(constraintWidget);
        if (constraintWidget.en() != null) {
            ((C4022w) constraintWidget.en()).m13233g(constraintWidget);
        }
        constraintWidget.a(this);
    }

    public void m13233g(ConstraintWidget constraintWidget) {
        this.tj.remove(constraintWidget);
        constraintWidget.a(null);
    }

    public C4023r eP() {
        C4023r c4023r;
        ConstraintWidget constraintWidget;
        ConstraintWidget en = en();
        if (this instanceof C4023r) {
            c4023r = (C4023r) this;
            constraintWidget = en;
        } else {
            c4023r = null;
            constraintWidget = en;
        }
        while (constraintWidget != null) {
            en = constraintWidget.en();
            if (constraintWidget instanceof C4023r) {
                c4023r = (C4023r) constraintWidget;
                constraintWidget = en;
            } else {
                constraintWidget = en;
            }
        }
        return c4023r;
    }

    public void m13232g(int i, int i2) {
        super.g(i, i2);
        int size = this.tj.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((ConstraintWidget) this.tj.get(i3)).g(ex(), ey());
        }
    }

    public void eD() {
        super.eD();
        if (this.tj != null) {
            int size = this.tj.size();
            for (int i = 0; i < size; i++) {
                ConstraintWidget constraintWidget = (ConstraintWidget) this.tj.get(i);
                constraintWidget.g(et(), eu());
                if (!(constraintWidget instanceof C4023r)) {
                    constraintWidget.eD();
                }
            }
        }
    }

    public void eJ() {
        eD();
        if (this.tj != null) {
            int size = this.tj.size();
            for (int i = 0; i < size; i++) {
                ConstraintWidget constraintWidget = (ConstraintWidget) this.tj.get(i);
                if (constraintWidget instanceof C4022w) {
                    ((C4022w) constraintWidget).eJ();
                }
            }
        }
    }

    public void m13230b(n nVar) {
        super.b(nVar);
        int size = this.tj.size();
        for (int i = 0; i < size; i++) {
            ((ConstraintWidget) this.tj.get(i)).b(nVar);
        }
    }

    public void eQ() {
        this.tj.clear();
    }
}
