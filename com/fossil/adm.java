package com.fossil;

public class adm {
    public static final adm aKy = new adm();
    public final String email;
    public final String id;
    public final String name;

    public adm() {
        this(null, null, null);
    }

    public adm(String str, String str2, String str3) {
        this.id = str;
        this.name = str2;
        this.email = str3;
    }

    public boolean isEmpty() {
        return this.id == null && this.name == null && this.email == null;
    }
}
