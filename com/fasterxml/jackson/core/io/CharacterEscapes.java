package com.fasterxml.jackson.core.io;

import com.fossil.afc;
import com.fossil.afn;
import java.io.Serializable;
import java.util.Arrays;

public abstract class CharacterEscapes implements Serializable {
    public static final int ESCAPE_CUSTOM = -2;
    public static final int ESCAPE_NONE = 0;
    public static final int ESCAPE_STANDARD = -1;

    public abstract int[] getEscapeCodesForAscii();

    public abstract afc getEscapeSequence(int i);

    public static int[] standardAsciiEscapesForJSON() {
        int[] Bu = afn.Bu();
        return Arrays.copyOf(Bu, Bu.length);
    }
}
