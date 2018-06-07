package com.fossil;

import android.support.constraint.solver.SolverVariable;
import android.support.constraint.solver.SolverVariable.Type;
import java.util.Arrays;

public class C3810l {
    int qo = 0;
    private final C3857m qp;
    private final C3899n qq;
    private int qr = 8;
    private SolverVariable qs = null;
    private int[] qt = new int[this.qr];
    private int[] qu = new int[this.qr];
    private float[] qv = new float[this.qr];
    private int qw = -1;
    private int qx = -1;
    private boolean qy = false;

    C3810l(C3857m c3857m, C3899n c3899n) {
        this.qp = c3857m;
        this.qq = c3899n;
    }

    public final void m12054a(SolverVariable solverVariable, float f) {
        if (f == 0.0f) {
            m12053a(solverVariable);
        } else if (this.qw == -1) {
            this.qw = 0;
            this.qv[this.qw] = f;
            this.qt[this.qw] = solverVariable.id;
            this.qu[this.qw] = -1;
            this.qo++;
            if (!this.qy) {
                this.qx++;
            }
        } else {
            int i = this.qw;
            int i2 = 0;
            int i3 = -1;
            while (i != -1 && i2 < this.qo) {
                if (this.qt[i] == solverVariable.id) {
                    this.qv[i] = f;
                    return;
                }
                if (this.qt[i] < solverVariable.id) {
                    i3 = i;
                }
                i2++;
                i = this.qu[i];
            }
            i = this.qx + 1;
            if (this.qy) {
                if (this.qt[this.qx] == -1) {
                    i = this.qx;
                } else {
                    i = this.qt.length;
                }
            }
            if (i >= this.qt.length && this.qo < this.qt.length) {
                for (i2 = 0; i2 < this.qt.length; i2++) {
                    if (this.qt[i2] == -1) {
                        i = i2;
                        break;
                    }
                }
            }
            if (i >= this.qt.length) {
                i = this.qt.length;
                this.qr *= 2;
                this.qy = false;
                this.qx = i - 1;
                this.qv = Arrays.copyOf(this.qv, this.qr);
                this.qt = Arrays.copyOf(this.qt, this.qr);
                this.qu = Arrays.copyOf(this.qu, this.qr);
            }
            this.qt[i] = solverVariable.id;
            this.qv[i] = f;
            if (i3 != -1) {
                this.qu[i] = this.qu[i3];
                this.qu[i3] = i;
            } else {
                this.qu[i] = this.qw;
                this.qw = i;
            }
            this.qo++;
            if (!this.qy) {
                this.qx++;
            }
            if (this.qo >= this.qt.length) {
                this.qy = true;
            }
        }
    }

    public final void m12059b(SolverVariable solverVariable, float f) {
        if (f != 0.0f) {
            if (this.qw == -1) {
                this.qw = 0;
                this.qv[this.qw] = f;
                this.qt[this.qw] = solverVariable.id;
                this.qu[this.qw] = -1;
                this.qo++;
                if (!this.qy) {
                    this.qx++;
                    return;
                }
                return;
            }
            int i = this.qw;
            int i2 = 0;
            int i3 = -1;
            while (i != -1 && i2 < this.qo) {
                int i4 = this.qt[i];
                if (i4 == solverVariable.id) {
                    float[] fArr = this.qv;
                    fArr[i] = fArr[i] + f;
                    if (this.qv[i] == 0.0f) {
                        if (i == this.qw) {
                            this.qw = this.qu[i];
                        } else {
                            this.qu[i3] = this.qu[i];
                        }
                        this.qq.qG[i4].m1644g(this.qp);
                        if (this.qy) {
                            this.qx = i;
                        }
                        this.qo--;
                        return;
                    }
                    return;
                }
                if (this.qt[i] < solverVariable.id) {
                    i3 = i;
                }
                i2++;
                i = this.qu[i];
            }
            i = this.qx + 1;
            if (this.qy) {
                if (this.qt[this.qx] == -1) {
                    i = this.qx;
                } else {
                    i = this.qt.length;
                }
            }
            if (i >= this.qt.length && this.qo < this.qt.length) {
                for (i2 = 0; i2 < this.qt.length; i2++) {
                    if (this.qt[i2] == -1) {
                        i = i2;
                        break;
                    }
                }
            }
            if (i >= this.qt.length) {
                i = this.qt.length;
                this.qr *= 2;
                this.qy = false;
                this.qx = i - 1;
                this.qv = Arrays.copyOf(this.qv, this.qr);
                this.qt = Arrays.copyOf(this.qt, this.qr);
                this.qu = Arrays.copyOf(this.qu, this.qr);
            }
            this.qt[i] = solverVariable.id;
            this.qv[i] = f;
            if (i3 != -1) {
                this.qu[i] = this.qu[i3];
                this.qu[i3] = i;
            } else {
                this.qu[i] = this.qw;
                this.qw = i;
            }
            this.qo++;
            if (!this.qy) {
                this.qx++;
            }
            if (this.qx >= this.qt.length) {
                this.qy = true;
                this.qx = this.qt.length - 1;
            }
        }
    }

    public final float m12053a(SolverVariable solverVariable) {
        if (this.qs == solverVariable) {
            this.qs = null;
        }
        if (this.qw == -1) {
            return 0.0f;
        }
        int i = this.qw;
        int i2 = 0;
        int i3 = -1;
        while (i != -1 && i2 < this.qo) {
            int i4 = this.qt[i];
            if (i4 == solverVariable.id) {
                if (i == this.qw) {
                    this.qw = this.qu[i];
                } else {
                    this.qu[i3] = this.qu[i];
                }
                this.qq.qG[i4].m1644g(this.qp);
                this.qo--;
                this.qt[i] = -1;
                if (this.qy) {
                    this.qx = i;
                }
                return this.qv[i];
            }
            i2++;
            int i5 = i;
            i = this.qu[i];
            i3 = i5;
        }
        return 0.0f;
    }

    public final void clear() {
        this.qw = -1;
        this.qx = -1;
        this.qy = false;
        this.qo = 0;
    }

    final boolean m12060b(SolverVariable solverVariable) {
        if (this.qw == -1) {
            return false;
        }
        int i = this.qw;
        int i2 = 0;
        while (i != -1 && i2 < this.qo) {
            if (this.qt[i] == solverVariable.id) {
                return true;
            }
            i = this.qu[i];
            i2++;
        }
        return false;
    }

    void dK() {
        int i = this.qw;
        int i2 = 0;
        while (i != -1 && i2 < this.qo) {
            float[] fArr = this.qv;
            fArr[i] = fArr[i] * -1.0f;
            i = this.qu[i];
            i2++;
        }
    }

    void m12058b(float f) {
        int i = this.qw;
        int i2 = 0;
        while (i != -1 && i2 < this.qo) {
            float[] fArr = this.qv;
            fArr[i] = fArr[i] / f;
            i = this.qu[i];
            i2++;
        }
    }

    void m12055a(C3857m c3857m) {
        int i = this.qw;
        int i2 = 0;
        while (i != -1 && i2 < this.qo) {
            this.qq.qG[this.qt[i]].m1643f(c3857m);
            i = this.qu[i];
            i2++;
        }
    }

    SolverVariable dL() {
        SolverVariable solverVariable = null;
        int i = 0;
        int i2 = this.qw;
        SolverVariable solverVariable2 = null;
        while (i2 != -1 && i < this.qo) {
            float f;
            SolverVariable solverVariable3;
            float f2 = this.qv[i2];
            if (f2 < 0.0f) {
                if (f2 > (-981668463)) {
                    this.qv[i2] = 0.0f;
                    f = 0.0f;
                }
                f = f2;
            } else {
                if (f2 < 0.001f) {
                    this.qv[i2] = 0.0f;
                    f = 0.0f;
                }
                f = f2;
            }
            if (f != 0.0f) {
                solverVariable3 = this.qq.qG[this.qt[i2]];
                if (solverVariable3.rd == Type.UNRESTRICTED) {
                    if (f < 0.0f) {
                        return solverVariable3;
                    }
                    if (solverVariable2 == null) {
                        solverVariable2 = solverVariable;
                        i++;
                        i2 = this.qu[i2];
                        solverVariable = solverVariable2;
                        solverVariable2 = solverVariable3;
                    }
                } else if (f < 0.0f && (solverVariable == null || solverVariable3.ra < solverVariable.ra)) {
                    SolverVariable solverVariable4 = solverVariable2;
                    solverVariable2 = solverVariable3;
                    solverVariable3 = solverVariable4;
                    i++;
                    i2 = this.qu[i2];
                    solverVariable = solverVariable2;
                    solverVariable2 = solverVariable3;
                }
            }
            solverVariable3 = solverVariable2;
            solverVariable2 = solverVariable;
            i++;
            i2 = this.qu[i2];
            solverVariable = solverVariable2;
            solverVariable2 = solverVariable3;
        }
        if (solverVariable2 != null) {
            return solverVariable2;
        }
        return solverVariable;
    }

    void m12056a(C3857m c3857m, C3857m c3857m2) {
        int i = this.qw;
        int i2 = 0;
        while (i != -1 && i2 < this.qo) {
            if (this.qt[i] == c3857m2.qz.id) {
                float f = this.qv[i];
                m12053a(c3857m2.qz);
                C3810l c3810l = c3857m2.qC;
                i = c3810l.qw;
                i2 = 0;
                while (i != -1 && i2 < c3810l.qo) {
                    m12059b(this.qq.qG[c3810l.qt[i]], c3810l.qv[i] * f);
                    i = c3810l.qu[i];
                    i2++;
                }
                c3857m.qA += c3857m2.qA * f;
                c3857m2.qz.m1644g(c3857m);
                i = this.qw;
                i2 = 0;
            } else {
                i = this.qu[i];
                i2++;
            }
        }
    }

    void m12057a(C3857m c3857m, C3857m[] c3857mArr) {
        int i = this.qw;
        int i2 = 0;
        while (i != -1 && i2 < this.qo) {
            SolverVariable solverVariable = this.qq.qG[this.qt[i]];
            if (solverVariable.qZ != -1) {
                float f = this.qv[i];
                m12053a(solverVariable);
                C3857m c3857m2 = c3857mArr[solverVariable.qZ];
                if (!c3857m2.qD) {
                    C3810l c3810l = c3857m2.qC;
                    i = c3810l.qw;
                    i2 = 0;
                    while (i != -1 && i2 < c3810l.qo) {
                        m12059b(this.qq.qG[c3810l.qt[i]], c3810l.qv[i] * f);
                        i = c3810l.qu[i];
                        i2++;
                    }
                }
                c3857m.qA += c3857m2.qA * f;
                c3857m2.qz.m1644g(c3857m);
                i = this.qw;
                i2 = 0;
            } else {
                i = this.qu[i];
                i2++;
            }
        }
    }

    final SolverVariable m12062r(int i) {
        int i2 = this.qw;
        int i3 = 0;
        while (i2 != -1 && i3 < this.qo) {
            if (i3 == i) {
                return this.qq.qG[this.qt[i2]];
            }
            i2 = this.qu[i2];
            i3++;
        }
        return null;
    }

    final float m12063s(int i) {
        int i2 = this.qw;
        int i3 = 0;
        while (i2 != -1 && i3 < this.qo) {
            if (i3 == i) {
                return this.qv[i2];
            }
            i2 = this.qu[i2];
            i3++;
        }
        return 0.0f;
    }

    public final float m12061c(SolverVariable solverVariable) {
        int i = this.qw;
        int i2 = 0;
        while (i != -1 && i2 < this.qo) {
            if (this.qt[i] == solverVariable.id) {
                return this.qv[i];
            }
            i = this.qu[i];
            i2++;
        }
        return 0.0f;
    }

    public String toString() {
        String str = "";
        int i = this.qw;
        int i2 = 0;
        while (i != -1 && i2 < this.qo) {
            str = ((str + " -> ") + this.qv[i] + " : ") + this.qq.qG[this.qt[i]];
            i = this.qu[i];
            i2++;
        }
        return str;
    }
}
