package com.fossil.wearables.fsl.keyvalue;

import java.util.List;

public interface KeyValueProvider {
    List<KeyValue> getAllKeyValues();

    KeyValue getKeyValueById(int i);

    String getValueByKey(String str);

    void removeAllKeyValues();

    void removeKeyValue(KeyValue keyValue);

    void saveKeyValue(KeyValue keyValue);
}
