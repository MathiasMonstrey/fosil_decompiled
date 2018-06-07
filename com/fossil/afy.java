package com.fossil;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import java.io.IOException;

public abstract class afy extends aff {
    protected static final int[] aOe = afn.Bu();
    protected CharacterEscapes _characterEscapes;
    protected afc _rootValueSeparator = DefaultPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
    protected final afo aLS;
    protected int[] aOf = aOe;
    protected int aOg;

    public afy(afo com_fossil_afo, int i, afa com_fossil_afa) {
        super(i, com_fossil_afa);
        this.aLS = com_fossil_afo;
        if (isEnabled(Feature.ESCAPE_NON_ASCII)) {
            fj(127);
        }
    }

    public JsonGenerator fj(int i) {
        if (i < 0) {
            i = 0;
        }
        this.aOg = i;
        return this;
    }

    public JsonGenerator mo921a(CharacterEscapes characterEscapes) {
        this._characterEscapes = characterEscapes;
        if (characterEscapes == null) {
            this.aOf = aOe;
        } else {
            this.aOf = characterEscapes.getEscapeCodesForAscii();
        }
        return this;
    }

    public JsonGenerator mo922a(afc com_fossil_afc) {
        this._rootValueSeparator = com_fossil_afc;
        return this;
    }

    public final void mo924r(String str, String str2) throws IOException {
        aQ(str);
        writeString(str2);
    }
}
