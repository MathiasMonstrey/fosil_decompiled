package com.fossil;

import com.portfolio.platform.data.model.microapp.DeclarationFile;
import com.portfolio.platform.data.model.microapp.MicroAppVariant;
import java.util.ArrayList;
import java.util.List;

public class cst {
    private String appId;
    private List<DeclarationFile> cCv;
    private long createAt;
    private String description;
    private String id;
    private int majorNumber;
    private int minorNumber;
    private String name;
    private String serialNumbers;
    private long updateAt;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public List<DeclarationFile> getDeclarationFiles() {
        if (this.cCv == null) {
            this.cCv = new ArrayList();
        }
        return this.cCv;
    }

    public void setDeclarationFiles(List<DeclarationFile> list) {
        if (this.cCv == null) {
            this.cCv = new ArrayList();
        }
        this.cCv.addAll(list);
    }

    public void setCreateAt(long j) {
        this.createAt = j;
    }

    public void setUpdateAt(long j) {
        this.updateAt = j;
    }

    public String getAppId() {
        return this.appId;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setSerialNumbers(String str) {
        this.serialNumbers = str;
    }

    public void setMajorNumber(int i) {
        this.majorNumber = i;
    }

    public int getMinorNumber() {
        return this.minorNumber;
    }

    public void setMinorNumber(int i) {
        this.minorNumber = i;
    }

    public MicroAppVariant aeV() {
        MicroAppVariant microAppVariant = new MicroAppVariant();
        microAppVariant.setSerialNumbers(this.serialNumbers);
        microAppVariant.setId(this.id);
        microAppVariant.setAppId(this.appId);
        microAppVariant.setName(this.name);
        microAppVariant.setDescription(this.description);
        microAppVariant.setCreateAt(this.createAt);
        microAppVariant.setUpdateAt(this.updateAt);
        microAppVariant.setMajorNumber(this.majorNumber);
        microAppVariant.setMinorNumber(this.minorNumber);
        return microAppVariant;
    }

    public void setId(String str) {
        this.id = str;
    }
}
