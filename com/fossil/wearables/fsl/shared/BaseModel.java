package com.fossil.wearables.fsl.shared;

import com.j256.ormlite.field.DatabaseField;
import java.io.Serializable;

public abstract class BaseModel implements Serializable {
    protected final String TAG = getClass().getCanonicalName();
    @DatabaseField(columnName = "id", generatedId = true)
    private int dbRowId = 0;

    public int getDbRowId() {
        return this.dbRowId;
    }

    public void setDbRowId(int i) {
        this.dbRowId = i;
    }
}
