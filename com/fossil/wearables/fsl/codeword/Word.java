package com.fossil.wearables.fsl.codeword;

import com.fossil.wearables.fsl.shared.BaseModel;
import com.j256.ormlite.field.DatabaseField;

public class Word extends BaseModel {
    @DatabaseField(columnName = "word_group_id", foreign = true, foreignAutoRefresh = true)
    private WordGroup group;
    @DatabaseField
    private String value;

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public WordGroup getGroup() {
        return this.group;
    }

    public void setGroup(WordGroup wordGroup) {
        this.group = wordGroup;
    }
}
