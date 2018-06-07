package com.fossil.wearables.fsl.dial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigItemOptionTable {
    Map<String, List<ValueItem>> optionsTable;

    public void putOptions(String str, List<ValueItem> list) {
        if (this.optionsTable == null) {
            this.optionsTable = new HashMap();
        }
        this.optionsTable.put(str, list);
    }

    public List<ValueItem> getOptions(String str) {
        if (this.optionsTable == null || this.optionsTable.size() == 0) {
            return null;
        }
        return (List) this.optionsTable.get(str);
    }

    public void putBooleanOptions(String str, int i, int i2) {
        List arrayList = new ArrayList();
        arrayList.add(new ValueItem(ConfigItem.VALUE_ON, i));
        arrayList.add(new ValueItem(ConfigItem.VALUE_OFF, i2));
        putOptions(str, arrayList);
    }
}
