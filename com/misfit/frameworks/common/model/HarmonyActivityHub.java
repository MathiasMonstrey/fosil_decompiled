package com.misfit.frameworks.common.model;

public class HarmonyActivityHub {
    private String hubID;
    private String id;
    private boolean isCheck;
    private String name;

    public HarmonyActivityHub() {
        this.hubID = "";
        this.id = "";
        this.name = "";
        this.isCheck = false;
    }

    public HarmonyActivityHub(String str, String str2, String str3) {
        this.hubID = str;
        this.id = str2;
        this.name = str3;
        this.isCheck = false;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setID(String str) {
        this.id = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public boolean isCheck() {
        return this.isCheck;
    }

    public void setCheck(boolean z) {
        this.isCheck = z;
    }

    public String getHubID() {
        return this.hubID;
    }

    public void setHubID(String str) {
        this.hubID = str;
    }
}
