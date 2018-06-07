package com.fossil;

import java.net.URL;

public class wv<T> implements wp<URL, T> {
    private final wp<wh, T> aDL;

    public /* synthetic */ us mo4419c(Object obj, int i, int i2) {
        return m14016a((URL) obj, i, i2);
    }

    public wv(wp<wh, T> wpVar) {
        this.aDL = wpVar;
    }

    public us<T> m14016a(URL url, int i, int i2) {
        return this.aDL.mo4419c(new wh(url), i, i2);
    }
}
