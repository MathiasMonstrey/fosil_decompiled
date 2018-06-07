package com.fossil.wearables.fsl.dial;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import com.fossil.wearables.fsl.shared.BaseModel;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import java.util.ArrayList;

public class SavedDial extends BaseModel implements DialListItem {
    @DatabaseField(dataType = DataType.BYTE_ARRAY)
    public byte[] imageBytes;
    public ArrayList<ConfigItem> initialConfigItems;
    @ForeignCollectionField(eager = true)
    private ForeignCollection<ConfigItem> mConfigItems;
    @DatabaseField(canBeNull = false)
    private String mDisplayName;
    @DatabaseField(canBeNull = false)
    private String templateDialId;

    public ForeignCollection<ConfigItem> getConfigItems() {
        return this.mConfigItems;
    }

    SavedDial() {
    }

    public SavedDial(String str, String str2) {
        this.mDisplayName = str;
        this.templateDialId = str2;
    }

    public void setDisplayName(String str) {
        this.mDisplayName = str;
    }

    public String getTemplateDialId() {
        return this.templateDialId;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id=").append(getDbRowId());
        stringBuilder.append(", ").append("mDisplayName=").append(this.mDisplayName);
        stringBuilder.append(", ").append("size=").append(this.mConfigItems.size());
        for (ConfigItem append : this.mConfigItems) {
            stringBuilder.append("\n- ").append(append);
        }
        return stringBuilder.toString();
    }

    public Drawable getThumbnailDrawable(Context context) {
        return null;
    }

    public Bitmap getThumbnailBitmap() {
        return BitmapFactory.decodeByteArray(this.imageBytes, 0, this.imageBytes.length);
    }

    public String getDisplayName() {
        return this.mDisplayName;
    }
}
