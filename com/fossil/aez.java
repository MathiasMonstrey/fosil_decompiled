package com.fossil;

public abstract class aez {
    protected int _index;
    protected int _type;

    public abstract aez Az();

    public abstract String zW();

    protected aez() {
    }

    public final boolean AA() {
        return this._type == 1;
    }

    public final boolean AB() {
        return this._type == 0;
    }

    public final boolean AC() {
        return this._type == 2;
    }

    public final String AD() {
        switch (this._type) {
            case 0:
                return "ROOT";
            case 1:
                return "ARRAY";
            case 2:
                return "OBJECT";
            default:
                return "?";
        }
    }

    public final int getEntryCount() {
        return this._index + 1;
    }

    public final int getCurrentIndex() {
        return this._index < 0 ? 0 : this._index;
    }

    public void bm(Object obj) {
    }
}
