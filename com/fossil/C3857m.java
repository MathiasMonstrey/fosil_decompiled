package com.fossil;

import android.support.constraint.solver.SolverVariable;
import android.support.constraint.solver.SolverVariable.Type;
import com.facebook.appevents.AppEventsConstants;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;

public class C3857m {
    float qA = 0.0f;
    boolean qB = false;
    final C3810l qC;
    boolean qD = false;
    SolverVariable qz = null;

    public C3857m(C3899n c3899n) {
        this.qC = new C3810l(this, c3899n);
    }

    void dM() {
        this.qC.m12055a(this);
    }

    boolean dN() {
        return this.qz != null && (this.qz.rd == Type.UNRESTRICTED || this.qA >= 0.0f);
    }

    public String toString() {
        return dO();
    }

    String dO() {
        String str;
        Object obj;
        String str2 = "";
        if (this.qz == null) {
            str2 = str2 + AppEventsConstants.EVENT_PARAM_VALUE_NO;
        } else {
            str2 = str2 + this.qz;
        }
        str2 = str2 + " = ";
        if (this.qA != 0.0f) {
            str = str2 + this.qA;
            obj = 1;
        } else {
            str = str2;
            obj = null;
        }
        int i = this.qC.qo;
        String str3 = str;
        for (int i2 = 0; i2 < i; i2++) {
            SolverVariable r = this.qC.m12062r(i2);
            if (r != null) {
                float f;
                float s = this.qC.m12063s(i2);
                String solverVariable = r.toString();
                if (obj == null) {
                    if (s < 0.0f) {
                        str3 = str3 + "- ";
                        f = s * -1.0f;
                    } else {
                        f = s;
                    }
                } else if (s > 0.0f) {
                    str3 = str3 + " + ";
                    f = s;
                } else {
                    str3 = str3 + " - ";
                    f = s * -1.0f;
                }
                if (f == 1.0f) {
                    str2 = str3 + solverVariable;
                } else {
                    str2 = str3 + f + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + solverVariable;
                }
                str3 = str2;
                int i3 = 1;
            }
        }
        if (obj == null) {
            return str3 + "0.0";
        }
        return str3;
    }

    public void reset() {
        this.qz = null;
        this.qC.clear();
        this.qA = 0.0f;
        this.qD = false;
    }

    boolean m12434d(SolverVariable solverVariable) {
        return this.qC.m12060b(solverVariable);
    }

    C3857m m12423a(SolverVariable solverVariable, int i) {
        this.qz = solverVariable;
        solverVariable.rb = (float) i;
        this.qA = (float) i;
        this.qD = true;
        return this;
    }

    public C3857m m12430b(SolverVariable solverVariable, int i) {
        if (i < 0) {
            this.qA = (float) (i * -1);
            this.qC.m12054a(solverVariable, 1.0f);
        } else {
            this.qA = (float) i;
            this.qC.m12054a(solverVariable, -1.0f);
        }
        return this;
    }

    public C3857m m12425a(SolverVariable solverVariable, SolverVariable solverVariable2, int i) {
        Object obj = null;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                obj = 1;
            }
            this.qA = (float) i;
        }
        if (obj == null) {
            this.qC.m12054a(solverVariable, -1.0f);
            this.qC.m12054a(solverVariable2, 1.0f);
        } else {
            this.qC.m12054a(solverVariable, 1.0f);
            this.qC.m12054a(solverVariable2, -1.0f);
        }
        return this;
    }

    C3857m m12433c(SolverVariable solverVariable, int i) {
        this.qC.m12054a(solverVariable, (float) i);
        return this;
    }

    public C3857m m12428a(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i) {
        Object obj = null;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                obj = 1;
            }
            this.qA = (float) i;
        }
        if (obj == null) {
            this.qC.m12054a(solverVariable, -1.0f);
            this.qC.m12054a(solverVariable2, 1.0f);
            this.qC.m12054a(solverVariable3, 1.0f);
        } else {
            this.qC.m12054a(solverVariable, 1.0f);
            this.qC.m12054a(solverVariable2, -1.0f);
            this.qC.m12054a(solverVariable3, -1.0f);
        }
        return this;
    }

    public C3857m m12431b(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i) {
        Object obj = null;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                obj = 1;
            }
            this.qA = (float) i;
        }
        if (obj == null) {
            this.qC.m12054a(solverVariable, -1.0f);
            this.qC.m12054a(solverVariable2, 1.0f);
            this.qC.m12054a(solverVariable3, -1.0f);
        } else {
            this.qC.m12054a(solverVariable, 1.0f);
            this.qC.m12054a(solverVariable2, -1.0f);
            this.qC.m12054a(solverVariable3, 1.0f);
        }
        return this;
    }

    public C3857m m12422a(float f, float f2, float f3, SolverVariable solverVariable, int i, SolverVariable solverVariable2, int i2, SolverVariable solverVariable3, int i3, SolverVariable solverVariable4, int i4) {
        if (f2 == 0.0f || f == f3) {
            this.qA = (float) ((((-i) - i2) + i3) + i4);
            this.qC.m12054a(solverVariable, 1.0f);
            this.qC.m12054a(solverVariable2, -1.0f);
            this.qC.m12054a(solverVariable4, 1.0f);
            this.qC.m12054a(solverVariable3, -1.0f);
        } else {
            float f4 = (f / f2) / (f3 / f2);
            this.qA = (((float) ((-i) - i2)) + (((float) i3) * f4)) + (((float) i4) * f4);
            this.qC.m12054a(solverVariable, 1.0f);
            this.qC.m12054a(solverVariable2, -1.0f);
            this.qC.m12054a(solverVariable4, f4);
            this.qC.m12054a(solverVariable3, -f4);
        }
        return this;
    }

    C3857m m12426a(SolverVariable solverVariable, SolverVariable solverVariable2, int i, float f, SolverVariable solverVariable3, SolverVariable solverVariable4, int i2) {
        if (solverVariable2 == solverVariable3) {
            this.qC.m12054a(solverVariable, 1.0f);
            this.qC.m12054a(solverVariable4, 1.0f);
            this.qC.m12054a(solverVariable2, -2.0f);
        } else if (f == 0.5f) {
            this.qC.m12054a(solverVariable, 1.0f);
            this.qC.m12054a(solverVariable2, -1.0f);
            this.qC.m12054a(solverVariable3, -1.0f);
            this.qC.m12054a(solverVariable4, 1.0f);
            if (i > 0 || i2 > 0) {
                this.qA = (float) ((-i) + i2);
            }
        } else if (f <= 0.0f) {
            this.qC.m12054a(solverVariable, -1.0f);
            this.qC.m12054a(solverVariable2, 1.0f);
            this.qA = (float) i;
        } else if (f >= 1.0f) {
            this.qC.m12054a(solverVariable3, -1.0f);
            this.qC.m12054a(solverVariable4, 1.0f);
            this.qA = (float) i2;
        } else {
            this.qC.m12054a(solverVariable, (1.0f - f) * 1.0f);
            this.qC.m12054a(solverVariable2, (1.0f - f) * -1.0f);
            this.qC.m12054a(solverVariable3, -1.0f * f);
            this.qC.m12054a(solverVariable4, 1.0f * f);
            if (i > 0 || i2 > 0) {
                this.qA = (((float) (-i)) * (1.0f - f)) + (((float) i2) * f);
            }
        }
        return this;
    }

    public C3857m m12424a(SolverVariable solverVariable, SolverVariable solverVariable2) {
        this.qC.m12054a(solverVariable, 1.0f);
        this.qC.m12054a(solverVariable2, -1.0f);
        return this;
    }

    C3857m m12427a(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, float f) {
        this.qC.m12054a(solverVariable, -1.0f);
        this.qC.m12054a(solverVariable2, 1.0f - f);
        this.qC.m12054a(solverVariable3, f);
        return this;
    }

    public C3857m m12429a(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f) {
        this.qC.m12054a(solverVariable, -1.0f);
        this.qC.m12054a(solverVariable2, 1.0f);
        this.qC.m12054a(solverVariable3, f);
        this.qC.m12054a(solverVariable4, -f);
        return this;
    }

    boolean m12432b(C3857m c3857m) {
        this.qC.m12056a(this, c3857m);
        return true;
    }

    void dP() {
        if (this.qA < 0.0f) {
            this.qA *= -1.0f;
            this.qC.dK();
        }
    }

    void dQ() {
        SolverVariable dL = this.qC.dL();
        if (dL != null) {
            m12435e(dL);
        }
        if (this.qC.qo == 0) {
            this.qD = true;
        }
    }

    void m12435e(SolverVariable solverVariable) {
        if (this.qz != null) {
            this.qC.m12054a(this.qz, -1.0f);
            this.qz = null;
        }
        float a = this.qC.m12053a(solverVariable) * -1.0f;
        this.qz = solverVariable;
        if (a != 1.0f) {
            this.qA /= a;
            this.qC.m12058b(a);
        }
    }
}
