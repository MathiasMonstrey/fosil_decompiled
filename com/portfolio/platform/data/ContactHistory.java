package com.portfolio.platform.data;

import java.io.Serializable;

public class ContactHistory implements Serializable {
    private String color;
    private String haptic;
    private String name;
    private String photoThumbUri;
    private String source;
    private String title;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPhotoThumbUri(String str) {
        this.photoThumbUri = str;
    }

    public String getPhotoThumbUri() {
        return this.photoThumbUri;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String str) {
        this.color = str;
    }

    public String getHaptic() {
        return this.haptic;
    }

    public void setHaptic(String str) {
        this.haptic = str;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String str) {
        this.source = str;
    }
}
