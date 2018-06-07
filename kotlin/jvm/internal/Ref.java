package kotlin.jvm.internal;

import java.io.Serializable;

public class Ref {

    public static final class IntRef implements Serializable {
        public int element;

        public String toString() {
            return String.valueOf(this.element);
        }
    }
}
