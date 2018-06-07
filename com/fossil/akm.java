package com.fossil;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;

public abstract class akm<T extends akm<T>> extends aki {
    protected final JsonNodeFactory _nodeFactory;

    public abstract int size();

    protected akm(JsonNodeFactory jsonNodeFactory) {
        this._nodeFactory = jsonNodeFactory;
    }

    public String DP() {
        return "";
    }

    public final akh arrayNode() {
        return this._nodeFactory.arrayNode();
    }

    public final akv objectNode() {
        return this._nodeFactory.objectNode();
    }

    public final akt nullNode() {
        return this._nodeFactory.nullNode();
    }

    public final akl booleanNode(boolean z) {
        return this._nodeFactory.booleanNode(z);
    }

    public final aky textNode(String str) {
        return this._nodeFactory.textNode(str);
    }
}
