package com.misfit.frameworks.common.model;

import java.util.ArrayList;
import java.util.List;

public class HarmonyHub {
    private String id;
    private List<HarmonyActivityHub> listHarmonyActivity;
    private String name;

    public HarmonyHub() {
        this.id = "";
        this.name = "";
        this.listHarmonyActivity = new ArrayList();
    }

    public HarmonyHub(String str, String str2) {
        this.id = str;
        this.name = str2;
        this.listHarmonyActivity = new ArrayList();
    }

    public String getID() {
        return this.id;
    }

    public void setID(String str) {
        this.id = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public List<HarmonyActivityHub> getListHarmonyActivity() {
        return this.listHarmonyActivity;
    }

    public void setListHarmonyActivity(List<HarmonyActivityHub> list) {
        this.listHarmonyActivity = list;
    }
}
