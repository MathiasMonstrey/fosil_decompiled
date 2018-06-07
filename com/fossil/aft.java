package com.fossil;

import java.io.Writer;

public final class aft extends Writer {
    protected final agr aNJ;

    public aft(agm com_fossil_agm) {
        this.aNJ = new agr(com_fossil_agm);
    }

    public Writer append(char c) {
        write((int) c);
        return this;
    }

    public Writer append(CharSequence charSequence) {
        String charSequence2 = charSequence.toString();
        this.aNJ.m3321i(charSequence2, 0, charSequence2.length());
        return this;
    }

    public Writer append(CharSequence charSequence, int i, int i2) {
        String charSequence2 = charSequence.subSequence(i, i2).toString();
        this.aNJ.m3321i(charSequence2, 0, charSequence2.length());
        return this;
    }

    public void close() {
    }

    public void flush() {
    }

    public void write(char[] cArr) {
        this.aNJ.append(cArr, 0, cArr.length);
    }

    public void write(char[] cArr, int i, int i2) {
        this.aNJ.append(cArr, i, i2);
    }

    public void write(int i) {
        this.aNJ.append((char) i);
    }

    public void write(String str) {
        this.aNJ.m3321i(str, 0, str.length());
    }

    public void write(String str, int i, int i2) {
        this.aNJ.m3321i(str, i, i2);
    }

    public String BJ() {
        String Da = this.aNJ.Da();
        this.aNJ.CW();
        return Da;
    }
}
