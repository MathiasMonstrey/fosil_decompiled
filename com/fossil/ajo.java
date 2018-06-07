package com.fossil;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;

@Deprecated
public class ajo {
    private final akv aTk;

    @JsonCreator
    public ajo(akv com_fossil_akv) {
        this.aTk = com_fossil_akv;
    }

    public String toString() {
        return this.aTk.toString();
    }

    public int hashCode() {
        return this.aTk.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ajo)) {
            return false;
        }
        ajo com_fossil_ajo = (ajo) obj;
        if (this.aTk != null) {
            return this.aTk.equals(com_fossil_ajo.aTk);
        }
        if (com_fossil_ajo.aTk != null) {
            return false;
        }
        return true;
    }

    public static agz Ge() {
        agz objectNode = JsonNodeFactory.instance.objectNode();
        objectNode.m3675t("type", "any");
        return objectNode;
    }
}
