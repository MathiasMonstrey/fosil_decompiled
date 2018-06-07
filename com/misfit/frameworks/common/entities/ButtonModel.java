package com.misfit.frameworks.common.entities;

public class ButtonModel {
    private long id;
    private String name;

    public ButtonModel(long j, String str) {
        this.id = j;
        this.name = str;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return "[ButtonModel: id=" + this.id + ", name=" + this.name + "]";
    }
}
