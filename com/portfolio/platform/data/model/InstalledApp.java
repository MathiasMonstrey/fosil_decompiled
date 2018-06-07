package com.portfolio.platform.data.model;

import java.util.Comparator;

public class InstalledApp {
    private int currentHandGroup;
    private int dbRowId;
    private String identifier;
    private Boolean isSelected;
    private String title;

    public static class TitleComparator implements Comparator<InstalledApp> {
        public int compare(InstalledApp installedApp, InstalledApp installedApp2) {
            return installedApp.getTitle().toLowerCase().compareTo(installedApp2.getTitle().toLowerCase());
        }
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setIdentifier(String str) {
        this.identifier = str;
    }

    public int getDbRowId() {
        return this.dbRowId;
    }

    public void setDbRowId(int i) {
        this.dbRowId = i;
    }

    public InstalledApp(String str, String str2, Boolean bool) {
        this.identifier = str;
        this.title = str2;
        this.isSelected = bool;
    }

    public String getTitle() {
        return this.title;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public Boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean z) {
        this.isSelected = Boolean.valueOf(z);
    }

    public int getCurrentHandGroup() {
        return this.currentHandGroup;
    }

    public void setCurrentHandGroup(int i) {
        this.currentHandGroup = i;
    }
}
