package com.fossil;

public abstract class euq implements eur {
    private final String dVM;
    private final String dvJ;
    private final String mimeType;

    public euq(String str) {
        if (str == null) {
            throw new IllegalArgumentException("MIME type may not be null");
        }
        this.mimeType = str;
        int indexOf = str.indexOf(47);
        if (indexOf != -1) {
            this.dvJ = str.substring(0, indexOf);
            this.dVM = str.substring(indexOf + 1);
            return;
        }
        this.dvJ = str;
        this.dVM = null;
    }

    public String getMimeType() {
        return this.mimeType;
    }
}
