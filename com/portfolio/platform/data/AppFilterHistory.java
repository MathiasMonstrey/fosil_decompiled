package com.portfolio.platform.data;

import java.io.Serializable;

public class AppFilterHistory implements Serializable {
    private static final long serialVersionUID = -2158356172743946820L;
    private String color;
    private String haptic;
    private int id;
    private String senderName;
    private String subtitle;
    private String title;
    private String type;

    public AppFilterHistory(String str) {
        this.senderName = str;
    }

    public String getSenderName() {
        return this.senderName;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getSubTitle() {
        return this.subtitle;
    }

    public void setSubTitle(String str) {
        this.subtitle = str;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String str) {
        this.color = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getType() {
        return this.type;
    }

    public String getHaptic() {
        return this.haptic;
    }

    public void setHaptic(String str) {
        this.haptic = str;
    }
}
