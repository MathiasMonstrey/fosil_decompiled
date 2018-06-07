package android.support.constraint.solver;

import com.fossil.C3857m;
import java.util.Arrays;

public class SolverVariable {
    private static int qY = 1;
    public int id = -1;
    private String mName;
    public int qZ = -1;
    public int ra = 0;
    public float rb;
    public float[] rc = new float[6];
    public Type rd;
    public C3857m[] re = new C3857m[8];
    public int rf = 0;

    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public SolverVariable(Type type) {
        this.rd = type;
    }

    public void eb() {
        for (int i = 0; i < 6; i++) {
            this.rc[i] = 0.0f;
        }
    }

    public String ec() {
        String str = this + "[";
        for (int i = 0; i < this.rc.length; i++) {
            str = str + this.rc[i];
            if (i < this.rc.length - 1) {
                str = str + ", ";
            } else {
                str = str + "] ";
            }
        }
        return str;
    }

    public void m1643f(C3857m c3857m) {
        int i = 0;
        while (i < this.rf) {
            if (this.re[i] != c3857m) {
                i++;
            } else {
                return;
            }
        }
        if (this.rf >= this.re.length) {
            this.re = (C3857m[]) Arrays.copyOf(this.re, this.re.length * 2);
        }
        this.re[this.rf] = c3857m;
        this.rf++;
    }

    public void m1644g(C3857m c3857m) {
        int i = 0;
        for (int i2 = 0; i2 < this.rf; i2++) {
            if (this.re[i2] == c3857m) {
                while (i < (this.rf - i2) - 1) {
                    this.re[i2 + i] = this.re[(i2 + i) + 1];
                    i++;
                }
                this.rf--;
                return;
            }
        }
    }

    public void reset() {
        this.mName = null;
        this.rd = Type.UNKNOWN;
        this.ra = 0;
        this.id = -1;
        this.qZ = -1;
        this.rb = 0.0f;
        this.rf = 0;
    }

    public void m1642b(Type type) {
        this.rd = type;
    }

    public String toString() {
        return "" + this.mName;
    }
}
